# 🌐 SpaceRP

**Выберите язык / Select language:**
 [🇷🇺 Русский](#russian) | [🇬🇧 English](#english)

---
<a name="russian"></a>
# 🇷🇺 SpaceRP
> Плагин на RP-команды (/do /me /try /roll /dice) для Minecraft-серверов 1.21+. Разрабатывался специально для проекта [MineSpace](https://minespace.su)

## Команды
* `/spacerp help` — список доступных команд. Право не требуется
* `/do` — действие от 3 лица. Право `spacerp.do`
* `/me` — действие от 1 лица. Право `spacerp.me`
* `/try` — попытаться выполнить действие. Право `spacerp.try`
* `/roll` — прокрутить рулетку. Право `spacerp.roll`
* `/dice` — бросить кости. Право `spacerp.dice`

## Пример конфигурации
Плагин поддерживает кастомизацию сообщений (config.yml):
```
check-updates:
  enabled: true
  repository: "https://github.com/zooont/spacerp" # НЕ ТРОГАТЬ!!!! | DONT TOUCH!!!!!

prefix: "" 
permission-message: "&cУ вас нет прав для использования этой команды!"
not-player-message: "&cКоманду может использовать только игрок!"
messages-radius: 100.0

messages:
  do: "&7**Игрок {player} {message}**"
  me: "&7*{player} {message}*"
  try: "&7Игрок {player} попытался {message}"
  roll: "&7Игрок {player} прокрутил рулетку и выбил {result} (1-100)"
  dice: "&7Игрок {player} бросил кости и выпало {result}"
```

## Статистика
![image](https://bstats.org/signatures/bukkit/SpaceRP.svg)

---

<a name="english"></a>
# 🇬🇧 SpaceRP
> A plugin with RP commands (/do /me /try /roll /dice) for Minecraft servers 1.21+. Originally developed for the [MineSpace](https://minespace.su) project.
> 
## Commands
* `/spacerp help` — list of available commands. No permission required
* `/do` — perform a third-person action. Permission: `spacerp.do`
* `/me` — perform a first-person action. Permission: `spacerp.me`
* `/try` — attempt to do something. Permission: `spacerp.try`
* `/roll` — roll a roulette. Permission: `spacerp.roll`
* `/dice` — throw dice. Permission: `spacerp.dice`

## Example configuration
The plugin supports message customization (config.yml):
```
check-updates:
  enabled: true
  repository: "https://github.com/zooont/spacerp" # DO NOT TOUCH!

prefix: "" 
permission-message: "&cYou don't have permission to use this command!"
not-player-message: "&cOnly players can use this command!"
messages-radius: 100.0

messages:
  do: "&7**Player {player} {message}**"
  me: "&7*{player} {message}*"
  try: "&7Player {player} tried to {message}"
  roll: "&7Player {player} rolled and got {result} (1-100)"
  dice: "&7Player {player} threw the dice and got {result}"
```

## Statistics
![image](https://bstats.org/signatures/bukkit/SpaceRP.svg)
