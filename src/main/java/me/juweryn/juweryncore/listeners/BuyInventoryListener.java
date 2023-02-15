package me.juweryn.juweryncore.listeners;

import me.juweryn.juweryncore.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;


public class BuyInventoryListener implements Listener {

    Utils utils;

    public BuyInventoryListener(Utils utils) {
        this.utils = utils;
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        if(event.getCurrentItem()==null) return;
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equalsIgnoreCase(Utils.cc("&cCoins | Main Menu"))) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName()));
            switch(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())) {
                case "Tags" -> utils.tagsGui(player);
                case "Keys" -> utils.keysGui(player);
                case "Ranks" -> utils.ranksGui(player);
            }
        } else if(event.getView().getTitle().equalsIgnoreCase(Utils.cc("&cCoins | Tags"))) {
            event.setCancelled(true);

            switch(event.getCurrentItem().getType()) {
                case BARRIER -> player.closeInventory();
                case NAME_TAG -> utils.buyTag(event.getCurrentItem(), player);
                case ARROW -> utils.coinGui(player);
            }
        } else if (event.getView().getTitle().equalsIgnoreCase(Utils.cc("&cCoins | Keys"))) {
            event.setCancelled(true);

            switch(event.getCurrentItem().getType()) {
                case BARRIER -> player.closeInventory();
                case TRIPWIRE_HOOK -> utils.buyKey(event.getCurrentItem(), player);
                case ARROW -> utils.coinGui(player);
            }
        } else if (event.getView().getTitle().equalsIgnoreCase(Utils.cc("&cCoins | Ranks"))) {
            event.setCancelled(true);

            switch(event.getCurrentItem().getType()) {
                case BARRIER -> player.closeInventory();
                case DIAMOND -> utils.buyRank(event.getCurrentItem(), player);
                case ARROW -> utils.coinGui(player);
            }
        }
    }


}
