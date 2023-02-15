package me.juweryn.juweryncore;

import me.juweryn.juweryncore.currency.CurrencyManager;
import me.juweryn.juweryncore.listeners.BuyInventoryListener;
import me.juweryn.juweryncore.listeners.JoinListener;
import me.juweryn.juweryncore.listeners.onPlayerInteract;
import me.juweryn.juweryncore.utils.Utils;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class JuwerynCore extends JavaPlugin {
    private CurrencyManager currencyManager;
    private static JuwerynCore plugin;
    private Utils utils = new Utils();
    private static LuckPerms api;
    private File configurationFile = new File(getDataFolder(), "config.yml");

    @Override
    public void onEnable() {

        plugin = this;
        if (!configurationFile.exists()) {
            saveDefaultConfig();
        }

        RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
        if (provider != null) {
            api = provider.getProvider();

        }

        currencyManager = new CurrencyManager(new File(getDataFolder(), "currency"));
        getLogger().info("JuwerynCore has been enabled!");
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new BuyInventoryListener(getUtils()), this);
        Bukkit.getPluginManager().registerEvents(new onPlayerInteract(), this);
        getCommand("coin").setExecutor(new me.juweryn.juweryncore.commands.CoinCommand());
        getCommand("coins").setExecutor(new me.juweryn.juweryncore.commands.CoinsCommand(getUtils()));



    }

    public static JuwerynCore getPlugin() {
        return plugin;
    }

    public CurrencyManager getCurrencyManager() {
        return currencyManager;
    }

    public Utils getUtils() {
        return utils;
    }

    public static LuckPerms getLuckPerms() {
        return api;
    }

    
}
