package me.juweryn.juweryncore.listeners;

import me.juweryn.juweryncore.JuwerynCore;
import me.juweryn.juweryncore.utils.Utils;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.context.ContextManager;
import net.luckperms.api.model.data.DataMutateResult;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.InheritanceNode;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class onPlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {

        if(!event.getAction().isRightClick()) return;
         LuckPerms api = LuckPermsProvider.get();
         String prefix = JuwerynCore.getPlugin().getConfig().getString("prefix");

        Player player = event.getPlayer();
        ItemStack item = event.getItem();


        User user = JuwerynCore.getLuckPerms().getUserManager().getUser(player.getUniqueId());




        if(item == null || item.getType() != Material.PAPER) return;

        String rank = "";

        if (!item.hasItemMeta() || !item.getItemMeta().hasDisplayName()) return;
        ItemMeta meta = item.getItemMeta();

        String name = meta.getDisplayName();
        name = ChatColor.stripColor(name);
        name = name.toLowerCase();

        if(name.equals("merchant rank")) {
            rank = "merchant";
        } else if(name.equals("noble rank")) {
            rank = "noble";
        } else if(name.equals("knight rank")) {
            rank = "knight";
        } else if(name.equals("wizard rank")) {
            rank = "wizard";
        } else if(name.equals("prophet rank")) {
            rank = "prophet";
        } else {
            return;
        }

        if(hasRankOrHigher(player, rank)) {
            player.sendMessage(Utils.hex(prefix + "&cYou already have this rank or a higher one!"));
            return;
        }

        InheritanceNode node = InheritanceNode.builder(rank).build();

        DataMutateResult result = user.data().add(node);

        api.getUserManager().saveUser(user);
        player.sendMessage(user.getPrimaryGroup());


        player.sendMessage(Utils.hex("&eYou now possess the " + meta.getDisplayName() + " &erank!"));

        if (player.getInventory().getItemInHand().getAmount() == 1) {
            player.getInventory().setItemInHand(new ItemStack(Material.AIR));
        } else {
            player.getInventory().getItemInHand().setAmount(player.getInventory().getItemInHand().getAmount()-1);
        }
    }


    public boolean hasRankOrHigher(Player player, String rank) {
        switch (rank) {
            case "merchant":
                return player.hasPermission("group.merchant") || hasRankOrHigher(player, "noble");
            case "noble":
                return player.hasPermission("group.noble") || hasRankOrHigher(player, "knight");
            case "knight":
                return player.hasPermission("group.knight") || hasRankOrHigher(player, "wizard");
            case "wizard":
                return player.hasPermission("group.wizard") || hasRankOrHigher(player, "prophet");
            case "prophet":
                return player.hasPermission("group.prophet");
            default:
                return false; // Invalid rank name
        }
    }


}

