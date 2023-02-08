package me.juweryn.juweryncore.utils;

import org.bukkit.ChatColor;

public class ChatUtils {
    public static String cc(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
