package org.kapydev.spacerp;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CheckUpdates {

    private final JavaPlugin plugin;

    public CheckUpdates(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void check() {
        if (!plugin.getConfig().getBoolean("check-updates.enabled", true)) {
            return; // отключено в конфиге
        }

        Bukkit.getScheduler().runTaskAsynchronously(plugin, () -> {
            try {
                String repoUrl = plugin.getConfig().getString("check-updates.repository");
                if (repoUrl == null || repoUrl.isEmpty()) return;

                String repoPath = repoUrl.replace("https://github.com/", "").replace("/", "/");

                URL url = new URL("https://api.github.com/repos/" + repoPath + "/releases/latest");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("Accept", "application/vnd.github.v3+json");
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);

                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                JsonObject json = JsonParser.parseReader(reader).getAsJsonObject();
                String latestVersion = json.get("tag_name").getAsString(); // тег релиза
                String currentVersion = plugin.getDescription().getVersion();

                if (!currentVersion.equalsIgnoreCase(latestVersion)) {
                    plugin.getLogger().info("§aДоступна новая версия плагина: §e" + latestVersion);
                    plugin.getLogger().info("§aСкачать: §b" + json.get("html_url").getAsString());
                } else {
                    plugin.getLogger().info("§aПлагин обновлён до последней версии!");
                }

                reader.close();
            } catch (Exception e) {
                plugin.getLogger().warning("§cНе удалось проверить обновления: " + e.getMessage());
            }
        });
    }
}
