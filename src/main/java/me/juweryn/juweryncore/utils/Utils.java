package me.juweryn.juweryncore.utils;

import me.juweryn.juweryncore.JuwerynCore;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Utils {





    public static String cc(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public void coinGui(Player player) {
        Inventory shop = Bukkit.createInventory(player, 27, Utils.cc("&cCoins | Main Menu"));
        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(Utils.cc("&7"));
        glass.setItemMeta(glassMeta);

        for(int i = 0; i < shop.getSize(); i++) {
            if(i != 10 && i != 12 && i != 14 && i != 16) {
                shop.setItem(i, glass);
            }
        }

        ItemStack tags = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta tagsMeta = tags.getItemMeta();
        tagsMeta.setDisplayName(Utils.cc("&aTags"));
        List<String> tagsLore = new ArrayList<>();
        tagsLore.add(Utils.cc("&7Buy a tag for your name!"));
        tagsLore.add("");
        tagsLore.add(Utils.cc("&e&l➜ CLICK TO BROWSE"));
        tagsMeta.setLore(tagsLore);
        tags.setItemMeta(tagsMeta);
        shop.setItem(10, tags);

        ItemStack keys = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta keysMeta = keys.getItemMeta();
        keysMeta.setDisplayName(Utils.cc("&aKeys"));
        List<String> keysLore = new ArrayList<>();
        keysLore.add(Utils.cc("&7Buy a key to open crates!"));
        keysLore.add("");
        keysLore.add(Utils.cc("&e&l➜ CLICK TO BROWSE"));
        keysMeta.setLore(keysLore);
        keys.setItemMeta(keysMeta);
        shop.setItem(12, keys);

        ItemStack chatColor = new ItemStack(Material.LIME_DYE, 1);
        ItemMeta chatColorMeta = chatColor.getItemMeta();
        chatColorMeta.setDisplayName(Utils.cc("&aChat Color"));
        List<String> chatColorLore = new ArrayList<>();
        chatColorLore.add(Utils.cc("&7Buy a chat color to change"));
        chatColorLore.add(Utils.cc("&7the color of your messages!"));
        chatColorLore.add("");
        chatColorLore.add(Utils.cc("&e&l➜ CLICK TO BROWSE"));
        chatColorMeta.setLore(chatColorLore);
        chatColor.setItemMeta(chatColorMeta);
        shop.setItem(14, chatColor);

        ItemStack ranks = new ItemStack(Material.DIAMOND, 1);
        ItemMeta ranksMeta = ranks.getItemMeta();
        ranksMeta.setDisplayName(Utils.cc("&aRanks"));
        List<String> ranksLore = new ArrayList<>();
        ranksLore.add(Utils.cc("&7Buy a rank to get many"));
        ranksLore.add(Utils.cc("&7unique perks and goodies!"));
        ranksLore.add("");
        ranksLore.add(Utils.cc("&e&l➜ CLICK TO BROWSE"));
        ranksMeta.setLore(ranksLore);
        ranks.setItemMeta(ranksMeta);
        shop.setItem(16, ranks);




        player.openInventory(shop);
    }

    public void tagsGui(Player player) {
        Inventory tags = Bukkit.createInventory(player, 45, Utils.cc("&cCoins | Tags"));
        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(Utils.cc("&7"));
        glass.setItemMeta(glassMeta);
        for(int i = 0; i < tags.getSize(); i++) {
            if(i != 10 && i != 11 && i != 12 && i != 13 && i != 14 && i != 15 && i != 16 && i != 19 && i != 20 && i != 21 && i != 22 && i != 23 && i != 24 && i != 25 && i != 28) {
                tags.setItem(i, glass);
            }
        }

        ItemStack back = new ItemStack(Material.ARROW, 1);
        ItemMeta backMeta = back.getItemMeta();
        backMeta.setDisplayName(Utils.cc("&cBack"));
        List<String> backLore = new ArrayList<>();
        backLore.add(Utils.cc("&7Click to go back to the"));
        backLore.add(Utils.cc("&7main menu!"));
        backMeta.setLore(backLore);
        back.setItemMeta(backMeta);
        tags.setItem(36, back);

        ItemStack close = new ItemStack(Material.BARRIER, 1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(Utils.cc("&cClose"));
        List<String> closeLore = new ArrayList<>();
        closeLore.add(Utils.cc("&7Click to close the menu!"));
        closeMeta.setLore(closeLore);
        close.setItemMeta(closeMeta);
        tags.setItem(40, close);

        generateTags("&7[&eCold&7]", 10, tags, 1000);
        generateTags("[E-Boy]", 11, tags, 1000);
        generateTags("[E-Girl]", 12, tags, 1000);
        generateTags("[Farmer]", 13, tags, 1000);
        generateTags("[GUCCI]", 14, tags, 1000);
        generateTags("[Hot]", 15, tags, 1000);
        generateTags("[King]", 16, tags, 1000);
        generateTags("[Omega]", 19, tags, 1000);
        generateTags("[Queen]", 20, tags, 1000);
        generateTags("[Reaper]", 21, tags, 1000);
        generateTags("[Rich]", 22, tags, 1000);
        generateTags("[Scythe]", 23, tags, 1000);
        generateTags("[Sussy]", 24, tags, 1000);
        generateTags("[TopG]", 25, tags, 1000);
        generateTags("[L]", 28, tags, 1000);

        player.openInventory(tags);
    }

    public void buyTag(ItemStack item, Player player) {
//        JuwerynCore.getPlugin().getCurrencyManager().removeCoins(player, 1000);

        ItemMeta meta = item.getItemMeta();
        String name = meta.getDisplayName();
        name = ChatColor.stripColor(name);
        name = name.replaceAll("[\\[\\]]", "");
        name = name.replaceAll("-", "");
        name = name.toLowerCase();

        if(!player.hasPermission("eternaltags.tag." + name)) {
            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + player.getName() + " permission set eternaltags.tag." + name + " true");
            player.sendMessage(Utils.cc("&aYou have successfully bought the tag &e" + meta.getDisplayName() + "&a!"));
            return;
        }

        player.sendMessage(Utils.cc("&cYou already own this tag!"));

    }

    private void generateTags(String name, int slot, Inventory inventory, int price) {
        ItemStack tag = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta tagMeta = tag.getItemMeta();
        tagMeta.setDisplayName(Utils.cc(name));
        List<String> lore = new ArrayList<>();
        lore.add(Utils.cc("&7Price: &e" + price + " Coins"));
        lore.add("");
        lore.add(Utils.cc("&e&l➜ LEFT CLICK TO BUY"));
        tagMeta.setLore(lore);
        tag.setItemMeta(tagMeta);

        inventory.setItem(slot, tag);
    }



}
