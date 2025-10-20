# SpaceRP
> Плагин на RP-команды (/do /me /try /roll /dice) для Minecraft-серверов на 1.21+. Разрабатывался специально для проекта [MineSpace](https://minespace.su)

## Команды
- `/spacerp help` - список доступных команд. Право не требуется
- `/do` - сделать действие от 3 лица. Требуется право `spacerp.do`
- `/me` - сделать действие от 1 лица. Требуется право `spacerp.me`
- `/try` - попытаться выполнить что-то. Требуется право `spacerp.try`
- `/roll` - прокрутить рулетку. Требуется право `spacerp.roll`
- `/dice` - бросить кости. Требуется право `spacerp.dice`

## Пример конфигурации
Плагин поддерживает кастомизацию сообщений в файле конфигурации (config.yml). Пример:
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
[image](https://bstats.org/signatures/bukkit/SpaceRP.svg)
