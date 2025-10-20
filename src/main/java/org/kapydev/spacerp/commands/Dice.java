package org.kapydev.spacerp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.kapydev.spacerp.SpaceRP;

import java.util.Random;

public class Dice implements CommandExecutor {

    private final SpaceRP plugin;
    private final Random random = new Random();

    public Dice(SpaceRP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("not-player-message")));
            return true;
        }

        int result = random.nextInt(6) + 1;

        String messageTemplate = plugin.getConfig().getString("messages.dice",
                "&7Игрок {player} бросил кости и выпало {result}");

        String message = messageTemplate
                .replace("{player}", player.getName())
                .replace("{result}", String.valueOf(result));

        message = ChatColor.translateAlternateColorCodes('&', message);

        final String finalMessage = message;

        double radius = plugin.getConfig().getDouble("messages-radius", 100.0);

        player.getWorld().getPlayers().forEach(p -> {
            if (p.getLocation().distance(player.getLocation()) <= radius) {
                p.sendMessage(finalMessage);
            }
        });

        return true;
    }
}