package org.kapydev.spacerp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Help implements CommandExecutor {
    private final JavaPlugin plugin;

    public Help(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Проверяем подкоманду
        if (args.length == 0 || !args[0].equalsIgnoreCase("help")) {
            sender.sendMessage(ChatColor.RED + "Использование: /spacerp help");
            return true;
        }

        String version = plugin.getDescription().getVersion();
        sender.sendMessage(ChatColor.BLUE.toString() + ChatColor.BOLD + "=== SpaceRP v" + version + " by karbyrator ===");
        sender.sendMessage("/spacerp help" + ChatColor.WHITE + " - список доступных команд");
        sender.sendMessage("/do <действие> - действие от 3 лица");
        sender.sendMessage("/me <текст> - действие от 1 лица");
        sender.sendMessage("/try <действие> - попытаться выполнить действие (шанс 50/50)");
        sender.sendMessage("/roll - прокрутить рулетку (выпадает случайное число от 1 до 100)");
        sender.sendMessage("/dice - бросить кости (выпадает число от 1 до 6)");
        sender.sendMessage(ChatColor.BLUE.toString() + ChatColor.BOLD + "====================================");
        return true;
    }
}