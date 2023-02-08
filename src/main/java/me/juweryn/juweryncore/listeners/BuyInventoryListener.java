package me.juweryn.juweryncore.listeners;

import me.juweryn.juweryncore.utils.Utils;
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
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equalsIgnoreCase(Utils.cc("&cCoins | Main Menu"))) {
            event.setCancelled(true);
            if(event.getCurrentItem().getType() == Material.NAME_TAG) {
                utils.tagsGui(player);
            }
        } else if(event.getView().getTitle().equalsIgnoreCase(Utils.cc("&cCoins | Tags"))) {
            event.setCancelled(true);

            switch(event.getCurrentItem().getType()) {
                case BARRIER -> player.closeInventory();
                case NAME_TAG -> utils.buyTag(event.getCurrentItem(), player);
                case ARROW -> utils.coinGui(player);
            }

            if(event.getCurrentItem().getType() == Material.NAME_TAG) {
//                utils.buyTag(player);
            }
        }
    }


}
