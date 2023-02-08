package me.juweryn.juweryncore.currency;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class CurrencyManager {
    private final File folder;

    public CurrencyManager(File folder) {
        this.folder = folder;
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public File getPlayerFile(UUID playerUUID) {
        return new File(folder, playerUUID + ".yml");
    }

    public FileConfiguration getPlayerConfig(UUID playerUUID) {
        File playerFile = getPlayerFile(playerUUID);
        return YamlConfiguration.loadConfiguration(playerFile);
    }

    public int getCoins(UUID playerUUID) {
        FileConfiguration config = getPlayerConfig(playerUUID);
        return config.getInt("coins");
    }

    public void setCoins(UUID playerUUID, int coins) {
        FileConfiguration config = getPlayerConfig(playerUUID);
        config.set("coins", coins);
        try {
            config.save(getPlayerFile(playerUUID));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkCoins(UUID uuid, int amount) {
        File playerFile = getPlayerFile(uuid);
        FileConfiguration playerData = YamlConfiguration.loadConfiguration(playerFile);
        return playerData.getInt("coins") >= amount;
    }

    public void addCoins(UUID playerUUID, int coins) {
        setCoins(playerUUID, getCoins(playerUUID) + coins);
    }

    public void removeCoins(UUID playerUUID, int coins) {
        setCoins(playerUUID, getCoins(playerUUID) - coins);
    }

}
