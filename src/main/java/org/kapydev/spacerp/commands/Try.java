package org.kapydev.spacerp.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.kapydev.spacerp.SpaceRP;

import java.util.Random;

public class Try implements CommandExecutor {

    private final SpaceRP plugin;
    private final Random random = new Random();

    public Try(SpaceRP plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getConfig().getString("not-player-message", "Команду может использовать только игрок!")));
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    plugin.getPrefix() + "&cПожалуйста, укажите сообщение."));
            return true;
        }

        String message = String.join(" ", args);
        String outcome = random.nextBoolean() ? "успешно" : "неудачно";

        String formatted = plugin.getPrefix() + plugin.getTryMessage()
                .replace("{player}", player.getName())
                .replace("{message}", message + " (" + outcome + ")");

        double radius = plugin.getConfig().getDouble("messages-radius", 100.0);

        player.getWorld().getPlayers().forEach(p -> {
            if (p.getLocation().distance(player.getLocation()) <= radius) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', formatted));
            }
        });

        return true;
    }
}
