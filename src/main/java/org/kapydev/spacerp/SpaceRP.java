package org.kapydev.spacerp;

import org.bukkit.plugin.java.JavaPlugin;

import org.kapydev.spacerp.commands.Help;
import org.kapydev.spacerp.commands.Do;
import org.kapydev.spacerp.commands.Me;
import org.kapydev.spacerp.commands.Try;
import org.kapydev.spacerp.commands.Roll;
import org.kapydev.spacerp.commands.Dice;

public class SpaceRP extends JavaPlugin {

    private String prefix;
    private String doMessage;
    private String meMessage;
    private String tryMessage;

    @Override
    public void onEnable() {
        String version = getDescription().getVersion();
        getLogger().info("§9§lEnabling SpaceRP v" + version);

        int pluginId = 27648;
        Metrics metrics = new Metrics(this, pluginId);

        saveDefaultConfig();
        loadConfigValues();

        new CheckUpdates(this).check();

        getCommand("help").setExecutor(new Help(this));
        getCommand("do").setExecutor(new Do(this));
        getCommand("me").setExecutor(new Me(this));
        getCommand("try").setExecutor(new Try(this));
        getCommand("roll").setExecutor(new Roll(this));
        getCommand("dice").setExecutor(new Dice(this));

        getLogger().info("plugin enabled");
    }

    private void loadConfigValues() {
        prefix = getConfig().getString("prefix", "&7[SpaceRP]&r ");
        doMessage = getConfig().getString("messages.do", "{player}: {message}");
        meMessage = getConfig().getString("messages.me", "{player}: {message}");
        tryMessage = getConfig().getString("messages.try", "{player}: {message}");
    }

    public String getPrefix() {
        return prefix;
    }

    public String getDoMessage() {
        return doMessage;
    }

    public String getMeMessage() {
        return meMessage;
    }

    public String getTryMessage() {
        return tryMessage;
    }
}