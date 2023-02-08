package me.juweryn.juweryncore;

import me.juweryn.juweryncore.currency.CurrencyManager;
import me.juweryn.juweryncore.listeners.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class JuwerynCore extends JavaPlugin {
    private CurrencyManager currencyManager;
    private static JuwerynCore plugin;
    private File configurationFile = new File(getDataFolder(), "config.yml");

    @Override
    public void onEnable() {

        plugin = this;
        if (!configurationFile.exists()) {
            saveDefaultConfig();
        }

        currencyManager = new CurrencyManager(new File(getDataFolder(), "currency"));
        getLogger().info("JuwerynCore has been enabled!");
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        getCommand("coin").setExecutor(new me.juweryn.juweryncore.commands.CoinCommand());
        getCommand("coins").setExecutor(new me.juweryn.juweryncore.commands.CoinsCommand());
    }

    public static JuwerynCore getPlugin() {
        return plugin;
    }

    public CurrencyManager getCurrencyManager() {
        return currencyManager;
    }
}
