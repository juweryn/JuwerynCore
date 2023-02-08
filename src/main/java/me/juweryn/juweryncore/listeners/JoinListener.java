package me.juweryn.juweryncore.listeners;

import me.juweryn.juweryncore.JuwerynCore;
import me.juweryn.juweryncore.currency.CurrencyManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class JoinListener implements Listener {

    private CurrencyManager currencyManager = JuwerynCore.getPlugin().getCurrencyManager();
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
        File playerFile = currencyManager.getPlayerFile(playerUUID);
        if (!playerFile.exists()) {
            FileConfiguration config = currencyManager.getPlayerConfig(playerUUID);
            config.set("coins", 0);
            try {
                config.save(playerFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
