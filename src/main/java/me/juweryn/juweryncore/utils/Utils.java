package me.juweryn.juweryncore.utils;

import me.juweryn.juweryncore.JuwerynCore;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.bukkit.ChatColor.COLOR_CHAR;

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
        chatColorLore.add(Utils.cc("&e&l➜ WIP"));
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

        generateTags("&7[&#5dd5fdC&#46bbe6o&#2ca2cfl&#008ab8d&7]", 10, tags, 250);
        generateTags("&7[&#1058cbE&#1d61d5-&#266bdeB&#2e74e8o&#367ef2y&7]", 11, tags, 250);
        generateTags("&7[&#cb1099E&#d319a7-&#db21b6G&#e329c4i&#ea2fd3r&#f236e2l&7]", 12, tags, 250);
        generateTags("&7[&#78911dF&#84a51ca&#91ba1ar&#9dcf15m&#aae40ee&#b7fa00r&7]", 13, tags, 250);
        generateTags("&7[&#1bc845&lG&#caa41c&lU&#1bc845&lC&#caa41c&lC&#1bc845&lI&7]", 14, tags, 300);
        generateTags("&7[&#ff4d2eH&#ff722co&#ff9029t&7]", 15, tags, 250);
        generateTags("&7[&#f0c800K&#ebd816i&#e6e725n&#dff631g&7]", 16, tags, 250);
        generateTags("&7[&#0062ff&lO&#11ff00&lM&#0062ff&lE&#11ff00&lG&#0062ff&lA&#11ff00&l+&7]", 19, tags, 300);
        generateTags("&7[&#8835edQ&#8030ebu&#772be9e&#6e26e6e&#6521e4n&7]", 20, tags, 250);
        generateTags("&7[&#ff5252R&#fc4b4be&#f94543a&#f63d3cp&#f33634e&#f02d2dr&7]", 21, tags, 250);
        generateTags("&7[&#069d4fR&#08ab57i&#0aba60c&#0dc968h&7]", 22, tags, 250);
        generateTags("&7[&#c5fb60S&#cdf854c&#d4f547y&#dbf138t&#e1ee25h&#e7eb00e&7]", 23, tags, 250);
        generateTags("&7[&#da6c93S&#d86085U&#d55377S&#d24569S&#ce365cY&7]", 24, tags, 250);
        generateTags("&7[&#10cb93T&#20d8a3o&#2ce5b3p&#36f2c3G&7]", 25, tags, 250);
        generateTags("&7[&#12c2e9L&7]", 28, tags, 250);

        player.openInventory(tags);
    }

    public void buyTag(ItemStack item, Player player) {
        LuckPerms api = LuckPermsProvider.get();


        User user = api.getUserManager().getUser(player.getUniqueId());


        ItemMeta meta = item.getItemMeta();

        String price = ChatColor.stripColor(meta.getLore().get(0));
        price = price.replaceAll("(?!\\d+).", "");

        String name = meta.getDisplayName();
        name = ChatColor.stripColor(name);
        name = name.replaceAll("[\\[\\]]", "");
        name = name.replaceAll("-", "");
        name = name.replaceAll("#", "");
        name = name.replaceAll("\\+", "");
        name = name.toLowerCase();
        //debug player.sendMessage(name + " " + price);

        if(!player.hasPermission("eternaltags.tag." + name)) {
            if(JuwerynCore.getPlugin().getCurrencyManager().getCoins(player.getUniqueId()) >= Integer.parseInt(price)) {
                JuwerynCore.getPlugin().getCurrencyManager().removeCoins(player.getUniqueId(), Integer.parseInt(price));
            } else {
                player.sendMessage(Utils.cc("&cYou do not have enough coins to buy this tag!"));
                return;
            }

            addPermission(user, "eternaltags.tag." + name);
            player.sendMessage(Utils.cc("&aYou have successfully bought the tag &e" + meta.getDisplayName() + "&a!"));
            return;
        }

        player.sendMessage(Utils.cc("&cYou already own this tag!"));

    }

    private void generateTags(String name, int slot, Inventory inventory, int price) {
        ItemStack tag = new ItemStack(Material.NAME_TAG, 1);
        ItemMeta tagMeta = tag.getItemMeta();
        tagMeta.setDisplayName(hex(name));
        List<String> lore = new ArrayList<>();
        lore.add(Utils.cc("&7Price: &e" + price + " Coins"));
        lore.add("");
        lore.add(Utils.cc("&e&l➜ LEFT CLICK TO BUY"));
        tagMeta.setLore(lore);
        tag.setItemMeta(tagMeta);

        inventory.setItem(slot, tag);
    }

    public void keysGui(Player player) {
        Inventory keys = Bukkit.createInventory(player, 27, Utils.cc("&cCoins | Keys"));
        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(Utils.cc("&7"));
        glass.setItemMeta(glassMeta);
        for(int i = 0; i < keys.getSize(); i++) {
            if(i != 10 && i != 11 && i != 12) {
                keys.setItem(i, glass);
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
        keys.setItem(18, back);

        ItemStack close = new ItemStack(Material.BARRIER, 1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(Utils.cc("&cClose"));
        List<String> closeLore = new ArrayList<>();
        closeLore.add(Utils.cc("&7Click to close the menu!"));
        closeMeta.setLore(closeLore);
        close.setItemMeta(closeMeta);
        keys.setItem(22, close);

        generateKeys("&aPremium &7Crate key", 10, keys, 400);
        generateKeys("&bWinter &7Crate key", 11, keys, 600);
        generateKeys("&dEpic &7Crate key", 12, keys, 800);

        player.openInventory(keys);
    }

    public void buyKey(ItemStack item, Player player) {


        ItemMeta meta = item.getItemMeta();

        String price = ChatColor.stripColor(meta.getLore().get(0));
        price = price.replaceAll("(?!\\d+).", "");

        String name = meta.getDisplayName();
        name = ChatColor.stripColor(name);
        name = name.replaceAll("Crate key", "");
        name = name.toLowerCase();
        //debug player.sendMessage(name + " " + price);


            if(JuwerynCore.getPlugin().getCurrencyManager().getCoins(player.getUniqueId()) >= Integer.parseInt(price)) {
                JuwerynCore.getPlugin().getCurrencyManager().removeCoins(player.getUniqueId(), Integer.parseInt(price));
            } else {
                player.sendMessage(Utils.cc("&cYou do not have enough coins to buy this key!"));
                return;
            }

            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "crates key give " + player.getName() + " " + name + " 1");
            player.sendMessage(Utils.cc("&aYou have successfully bought the key &e" + meta.getDisplayName() + "&a!"));





    }

    private void generateKeys(String name, int slot, Inventory inventory, int price) {
        ItemStack tag = new ItemStack(Material.TRIPWIRE_HOOK, 1);
        ItemMeta tagMeta = tag.getItemMeta();
        tagMeta.setDisplayName(hex(name));
        List<String> lore = new ArrayList<>();
        lore.add(Utils.cc("&7Price: &e" + price + " Coins"));
        lore.add("");
        lore.add(Utils.cc("&e&l➜ LEFT CLICK TO BUY"));
        tagMeta.setLore(lore);
        tag.setItemMeta(tagMeta);

        inventory.setItem(slot, tag);
    }

    public void ranksGui(Player player) {
        Inventory keys = Bukkit.createInventory(player, 27, Utils.cc("&cCoins | Ranks"));
        ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE, 1);
        ItemMeta glassMeta = glass.getItemMeta();
        glassMeta.setDisplayName(Utils.cc("&7"));
        glass.setItemMeta(glassMeta);
        for(int i = 0; i < keys.getSize(); i++) {
            if(i != 10 && i != 11 && i != 12 && i != 13 && i != 14) {
                keys.setItem(i, glass);
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
        keys.setItem(18, back);

        ItemStack close = new ItemStack(Material.BARRIER, 1);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(Utils.cc("&cClose"));
        List<String> closeLore = new ArrayList<>();
        closeLore.add(Utils.cc("&7Click to close the menu!"));
        closeMeta.setLore(closeLore);
        close.setItemMeta(closeMeta);
        keys.setItem(22, close);

        generateRanks("&#a271fe&lM&#9a7dfe&lE&#9188fe&lR&#8892fe&lC&#7c9cfe&lH&#6fa6fd&lA&#5faffd&lN&#49b8fd&lT", 10, keys, 2000);
        generateRanks("&#71e2fe&lN&#6be9f3&lO&#62f0e7&lB&#57f6dc&lL&#49fdd0&lE", 11, keys, 3000);
        generateRanks("&#71fe94&lK&#87fe87&lN&#99fe79&lI&#a9fd6a&lG&#b7fd5b&lH&#c4fd49&lT", 12, keys, 4500);
        generateRanks("&#fe7171&lW&#fe6a69&lI&#fe6261&lZ&#fe5a59&lA&#fd5251&lR&#fd4949&lD", 13, keys, 6000);
        generateRanks("&#818ffe&lP&#7c84fe&lR&#767aff&lO&#706fff&lP&#6964ff&lH&#6159ff&lE&#584dff&lT", 14, keys, 7500);

        player.openInventory(keys);
    }

    public void buyRank(ItemStack item, Player player) {


        ItemMeta meta = item.getItemMeta();

        String price = ChatColor.stripColor(meta.getLore().get(0));
        price = price.replaceAll("(?!\\d+).", "");

        String name = meta.getDisplayName();
        name = ChatColor.stripColor(name);
        name = name.toLowerCase();
         player.sendMessage(name + " " + price);




        if(JuwerynCore.getPlugin().getCurrencyManager().getCoins(player.getUniqueId()) >= Integer.parseInt(price)) {
            JuwerynCore.getPlugin().getCurrencyManager().removeCoins(player.getUniqueId(), Integer.parseInt(price));
        } else {
            player.sendMessage(Utils.cc("&cYou do not have enough coins to buy this rank!"));
            return;
        }



        ItemStack rank = new ItemStack(Material.PAPER, 1);
        ItemMeta rankMeta = rank.getItemMeta();
        rankMeta.setDisplayName(Utils.hex(meta.getDisplayName() + " Rank"));
        List<String> rankLore = new ArrayList<>();
        rankLore.add(Utils.cc("&7Right Click this to get the rank &e" + meta.getDisplayName()));
        rankMeta.setLore(rankLore);
        rank.setItemMeta(rankMeta);

        player.getInventory().addItem(rank);

        player.closeInventory();

        player.sendMessage(Utils.cc("&aYou have successfully bought the rank " + meta.getDisplayName() + "&a!"));





    }


    private void generateRanks(String name, int slot, Inventory inventory, int price) {
        ItemStack tag = new ItemStack(Material.DIAMOND, 1);
        ItemMeta tagMeta = tag.getItemMeta();
        tagMeta.setDisplayName(hex(name));
        List<String> lore = new ArrayList<>();
        lore.add(Utils.cc("&7Price: &e" + price + " Coins"));
        lore.add("");
        lore.add(Utils.cc("&e&l➜ LEFT CLICK TO BUY"));
        tagMeta.setLore(lore);
        tag.setItemMeta(tagMeta);

        inventory.setItem(slot, tag);
    }


    public static final Pattern HEX_PATTERN = Pattern.compile("&#([a-f0-9]{6})");
    public static String hex(String message) {
        Matcher matcher = HEX_PATTERN.matcher(message);
        StringBuffer buffer = new StringBuffer(message.length() + 4 * 8);
        while (matcher.find()) {
            String group = matcher.group(1);
            matcher.appendReplacement(buffer, COLOR_CHAR + "x"
                    + COLOR_CHAR + group.charAt(0) + COLOR_CHAR + group.charAt(1)
                    + COLOR_CHAR + group.charAt(2) + COLOR_CHAR + group.charAt(3)
                    + COLOR_CHAR + group.charAt(4) + COLOR_CHAR + group.charAt(5)
            );
        }
        return ChatColor.translateAlternateColorCodes('&', matcher.appendTail(buffer).toString());
    }

    public void addPermission(User user, String permission) {
        LuckPerms api = LuckPermsProvider.get();
        // Add the permission
        user.data().add(Node.builder(permission).build());

        // Now we need to save changes.
        api.getUserManager().saveUser(user);
    }


}
