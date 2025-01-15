# GameModeCheck Plugin

## Overview
GameModeCheck is a lightweight Bukkit plugin that allows server administrators to check the game modes of online players with ease. The plugin supports all Minecraft versions and provides customizable messages for better user experience.

---

## Features
1. **Commands:**
   - `/gamemodecheck *`
     - Lists all players grouped by their current game mode.
     - Only displays groups with at least one player.
   - `/gamemodecheck <MCID>`
     - Displays the game mode of the specified player.

2. **Permissions:**
   - `gamemodecheck.use`
     - Required to use the plugin commands (default: OP).

3. **Customizable Messages:**
   - All messages are configurable via `config.yml`, including support for Minecraft color codes (`&`).

4. **Tab Completion:**
   - Supports tab completion for player names and `*`.

---

## Installation
1. Place the plugin's JAR file in your server's `plugins` folder.
2. Restart your server.
3. Edit the `config.yml` file to customize messages as needed.
4. Reload or restart your server to apply changes.

---

## Configuration
Example `config.yml`:

```yaml
messages:
  usage: "&eUsage: /gamemodecheck <MCID|*>"
  no-permission: "&cYou do not have permission to use this command."
  player-not-found: "&cPlayer {player} not found."
  player-mode: "&6Player {player}'s game mode: &a{mode}"
  list-header: "&6Game Modes:"
  mode-format: "&e{mode}: &a{players}"
```

---

## Permissions
- `gamemodecheck.use`
  - Default: OP
  - Allows players to execute `/gamemodecheck` commands.

---

## Support
For questions or issues, please contact the developer or visit the plugin's GitHub repository.

---

# GameModeCheck プラグイン

## 概要
GameModeCheckは、オンラインプレイヤーのゲームモードを簡単に確認できる軽量なBukkitプラグインです。このプラグインはすべてのMinecraftバージョンに対応し、カスタマイズ可能なメッセージを提供します。

---

## 主な機能
1. **コマンド：**
   - `/gamemodecheck *`
     - プレイヤーを現在のゲームモードごとに分類して一覧表示します。
     - そのモードにプレイヤーがいる場合のみ表示します。
   - `/gamemodecheck <MCID>`
     - 指定したプレイヤーの現在のゲームモードを表示します。

2. **権限：**
   - `gamemodecheck.use`
     - コマンドの使用に必要な権限（デフォルト：OP）。

3. **カスタマイズ可能なメッセージ：**
   - `config.yml` を通じて、すべてのメッセージをカスタマイズ可能。
   - Minecraftのカラーコード（`&`）に対応。

4. **TAB補完：**
   - プレイヤー名および `*` のTAB補完をサポート。

---

## インストール
1. プラグインのJARファイルをサーバーの `plugins` フォルダに配置します。
2. サーバーを再起動します。
3. 必要に応じて `config.yml` を編集してメッセージをカスタマイズします。
4. サーバーを再起動またはリロードして変更を反映します。

---

## 設定
`config.yml` の例：

```yaml
messages:
  usage: "&e使用方法: /gamemodecheck <MCID|*>"
  no-permission: "&cこのコマンドを使用する権限がありません。"
  player-not-found: "&cプレイヤー {player} が見つかりませんでした。"
  player-mode: "&6プレイヤー {player} のゲームモード: &a{mode}"
  list-header: "&6ゲームモード一覧:"
  mode-format: "&e{mode}: &a{players}"
```

---

## 権限
- `gamemodecheck.use`
  - デフォルト: OP
  - `/gamemodecheck` コマンドの実行を許可します。

---

## サポート
質問や問題がある場合は、開発者に連絡するか、プラグインのGitHubリポジトリをご確認ください。

