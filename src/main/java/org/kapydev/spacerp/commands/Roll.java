package org.kapydev.spacerp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.kapydev.spacerp.SpaceRP;

import java.util.Random;

public class Roll implements CommandExecutor {

    private final SpaceRP plugin;
    private final Random random = new Random();

    public Roll(SpaceRP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("not-player-message")));
            return true;
        }

        int result = random.nextInt(100) + 1; // от 1 до 100

        String message = plugin.getConfig().getString("messages.roll")
                .replace("{player}", player.getName())
                .replace("{result}", String.valueOf(result));

        player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));

        return true;
    }
}
