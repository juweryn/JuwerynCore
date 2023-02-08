package me.juweryn.juweryncore.commands;

import me.juweryn.juweryncore.JuwerynCore;
import me.juweryn.juweryncore.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender msgsender, Command command, String label, String[] args) {
        if(!(msgsender instanceof Player)) {
            msgsender.sendMessage("This command can only be run by a player.");
            return true;
        }
        Player sender = (Player) msgsender;
        String prefix = JuwerynCore.getPlugin().getConfig().getString("prefix");
        String noPermission = JuwerynCore.getPlugin().getConfig().getString("no-permission");

        if (command.getName().equalsIgnoreCase("coins")) {
            if(args.length == 0) {
                sender.sendMessage(ChatUtils.cc(prefix + "Balance: " + JuwerynCore.getPlugin().getCurrencyManager().getCoins(sender.getUniqueId())));
                return true;
                // gui shop here
            }
            if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if(target == null) {
                    sender.sendMessage(ChatUtils.cc(prefix + "Usage: /coins [pay] <player> [amount]"));
                    return true;
                } else {
                    if(!sender.hasPermission("juweryncore.coins.others")) {
                        sender.sendMessage(ChatUtils.cc(prefix + noPermission));
                        return true;
                    }

                    sender.sendMessage(ChatUtils.cc(prefix + "Balance of "+ target.getName() + ": " + JuwerynCore.getPlugin().getCurrencyManager().getCoins(target.getUniqueId())));
                    return true;

                }
            }
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("pay")) {
                    if(!sender.hasPermission("juweryncore.coins.pay")) {
                        sender.sendMessage(ChatUtils.cc(prefix + noPermission));
                        return true;
                    }
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target == null) {
                        sender.sendMessage(ChatUtils.cc(prefix + "Usage: /coins [pay] <player> [amount]"));
                        return true;
                    } else {
                        if (JuwerynCore.getPlugin().getCurrencyManager().getCoins(sender.getUniqueId()) < Integer.parseInt(args[2])) {
                            sender.sendMessage(ChatUtils.cc(prefix + "You don't have enough coins to do that."));
                            return true;
                        } else if (Integer.parseInt(args[2]) == 0) {
                            sender.sendMessage(ChatUtils.cc(prefix + "You can't send 0 coins."));
                            return true;
                        } else if (Integer.parseInt(args[2]) < 0) {
                            sender.sendMessage(ChatUtils.cc(prefix + "You can't send negative coins."));
                            return true;
                        } else {
                            JuwerynCore.getPlugin().getCurrencyManager().removeCoins(sender.getUniqueId(), Integer.parseInt(args[2]));
                            JuwerynCore.getPlugin().getCurrencyManager().addCoins(target.getUniqueId(), Integer.parseInt(args[2]));
                            sender.sendMessage(ChatUtils.cc(prefix + "You have sent " + args[2] + " coins to " + target.getName()));
                            target.sendMessage(ChatUtils.cc(prefix + "You have received " + args[2] + " coins from " + sender.getName()));
                            return true;
                        }
                    }
                }
            }
        }

        return true;
    }


}