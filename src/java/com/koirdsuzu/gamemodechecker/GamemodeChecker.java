package com.koirdsuzu.gamemodechecker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamemodeChecker extends JavaPlugin implements TabCompleter {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("GameModeCheckPlugin has been enabled!");
        getCommand("gamemodecheck").setTabCompleter(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("GameModeCheckPlugin has been disabled!");
    }

    private String colorize(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("gamemodecheck")) {
            if (!sender.hasPermission("gamemodecheck.use")) {
                sender.sendMessage(colorize(getConfig().getString("messages.no-permission", "&cYou do not have permission to use this command.")));
                return true;
            }

            if (args.length == 0) {
                sender.sendMessage(colorize(getConfig().getString("messages.usage", "&eUsage: /gamemodecheck <MCID|*>")));
                return true;
            }

            String target = args[0];
            if (target.equalsIgnoreCase("*")) {
                displayGameModes(sender);
            } else {
                displayPlayerGameMode(sender, target);
            }
            return true;
        }
        return false;
    }

    private void displayGameModes(CommandSender sender) {
        String header = colorize(getConfig().getString("messages.list-header", "&6Game Modes:"));
        sender.sendMessage(header);

        for (GameMode mode : GameMode.values()) {
            List<String> playersInMode = new ArrayList<>();
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (player.getGameMode() == mode) {
                    playersInMode.add(player.getName());
                }
            }

            if (!playersInMode.isEmpty()) {
                String modeMessage = colorize(getConfig().getString("messages.mode-format", "&e{mode}: &a{players}")
                        .replace("{mode}", mode.name())
                        .replace("{players}", String.join(", ", playersInMode)));
                sender.sendMessage(modeMessage);
            }
        }
    }


    private void displayPlayerGameMode(CommandSender sender, String playerName) {
        Player target = Bukkit.getPlayer(playerName);
        if (target == null) {
            String notFound = colorize(getConfig().getString("messages.player-not-found", "Player {player} not found.")
                    .replace("{player}", playerName));
            sender.sendMessage(notFound);
            return;
        }

        GameMode mode = target.getGameMode();
        String playerMode = colorize(getConfig().getString("messages.player-mode", "Player {player}'s game mode: {mode}")
                .replace("{player}", target.getName())
                .replace("{mode}", mode.name()));
        sender.sendMessage(playerMode);
    }

    @Nullable
    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("gamemodecheck")) {
            if (args.length == 1) {
                List<String> suggestions = new ArrayList<>();
                for (Player player : Bukkit.getOnlinePlayers()) {
                    suggestions.add(player.getName());
                }
                suggestions.add("*");
                return suggestions.stream().filter(name -> name.startsWith(args[0])).toList();
            }
        }
        return Collections.emptyList();
    }
}
