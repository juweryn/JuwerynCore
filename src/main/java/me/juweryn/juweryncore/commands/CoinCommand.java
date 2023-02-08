package me.juweryn.juweryncore.commands;

import me.juweryn.juweryncore.JuwerynCore;
import me.juweryn.juweryncore.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CoinCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender msgsender, Command command, String label, String[] args) {
        if (!(msgsender instanceof Player)) {
            msgsender.sendMessage("This command can only be run by a player.");
            return false;
        }
        Player sender = (Player) msgsender;
        String prefix = JuwerynCore.getPlugin().getConfig().getString("prefix");
        String noPermission = JuwerynCore.getPlugin().getConfig().getString("no-permission");

        if (command.getName().equalsIgnoreCase("coin")) {
            StringBuilder usage = new StringBuilder(prefix + "Admin Usage: /coin <");
            if (sender.hasPermission("juweryncore.coins.add")) {
                usage.append("add");
            }
            if (sender.hasPermission("juweryncore.coins.remove")) {
                if (usage.toString().endsWith("<add")) {
                    usage.append("/remove");
                } else {
                    usage.append("/remove");
                }
            }
            if (sender.hasPermission("juweryncore.coins.set")) {
                if (usage.toString().endsWith("<add") || usage.toString().endsWith("<remove")) {
                    usage.append("/set");
                } else {
                    usage.append("/set");
                }
            }
            if (sender.hasPermission("juweryncore.coins.reset")) {
                if (usage.toString().endsWith("<add") || usage.toString().endsWith("<remove") || usage.toString().endsWith("<set")) {
                    usage.append("/reset");
                } else {
                    usage.append("/reset");
                }
            }
            if (usage.toString().endsWith("<")) {
                sender.sendMessage(Utils.cc(prefix + "Balance: " + JuwerynCore.getPlugin().getCurrencyManager().getCoins(sender.getUniqueId())));
                return true;
            }
            usage.append("> <player>");
            sender.sendMessage(Utils.cc(prefix + "Balance: " + JuwerynCore.getPlugin().getCurrencyManager().getCoins(sender.getUniqueId())));
            sender.sendMessage(Utils.cc(usage.toString()));


            if (args.length == 1) {

                if (args[0].equalsIgnoreCase("add")) {

                    if (!sender.hasPermission("juweryncore.coins.add")) {
                        sender.sendMessage(Utils.cc(prefix + noPermission));
                        return true;
                    }

                    sender.sendMessage(Utils.cc(prefix + "Usage: /coin add <player> <amount>"));
                    return true;
                }
                if (args[0].equalsIgnoreCase("remove")) {
                    if (!sender.hasPermission("juweryncore.coins.remove")) {
                        sender.sendMessage(Utils.cc(prefix + noPermission));
                        return true;
                    }
                    sender.sendMessage(Utils.cc(prefix + "Usage: /coin remove <player> <amount>"));
                    return true;
                }
                if (args[0].equalsIgnoreCase("reset")) {
                    if (!sender.hasPermission("juweryncore.coins.reset")) {
                        sender.sendMessage(Utils.cc(prefix + noPermission));
                        return true;
                    }
                    sender.sendMessage(Utils.cc(prefix + "Usage: /coin reset <player>"));
                    return true;
                }
                if (args[0].equalsIgnoreCase("set")) {
                    if (!sender.hasPermission("juweryncore.coins.set")) {
                        sender.sendMessage(Utils.cc(prefix + noPermission));
                        return true;
                    }
                    sender.sendMessage(Utils.cc(prefix + "Usage: /coin set <player> <amount>"));
                    return true;
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("reset")) {
                    if (!sender.hasPermission("juweryncore.coins.reset")) {
                        sender.sendMessage(Utils.cc(prefix + noPermission));
                        return true;
                    }
                    Player target = JuwerynCore.getPlugin().getServer().getPlayer(args[1]);
                    assert target != null;
                    JuwerynCore.getPlugin().getCurrencyManager().setCoins(target.getUniqueId(), 0);
                    sender.sendMessage(Utils.cc(prefix + "You have reset" + target.getName() + "'s coins!"));
                    target.sendMessage(Utils.cc(prefix + "Your coins have been reset by " + sender.getName() + "!"));
                    return true;
                }
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("add")) {
                    if (!sender.hasPermission("juweryncore.coins.add")) {
                        sender.sendMessage(Utils.cc(prefix + noPermission));
                        return true;
                    }
                    Player target = JuwerynCore.getPlugin().getServer().getPlayer(args[1]);
                    assert target != null;
                    JuwerynCore.getPlugin().getCurrencyManager().addCoins(target.getUniqueId(), Integer.parseInt(args[2]));
                    sender.sendMessage(Utils.cc(prefix + "You have added " + args[2] + " coins to " + target.getName() + "'s balance!"));
                    target.sendMessage(Utils.cc(prefix + "You have been given " + args[2] + " coins by " + sender.getName() + "!"));
                    return true;
                }
                if (args[0].equalsIgnoreCase("remove")) {
                    if (!sender.hasPermission("juweryncore.coins.remove")) {
                        sender.sendMessage(Utils.cc(prefix + noPermission));
                        return true;
                    }
                    Player target = JuwerynCore.getPlugin().getServer().getPlayer(args[1]);
                    assert target != null;
                    JuwerynCore.getPlugin().getCurrencyManager().removeCoins(target.getUniqueId(), Integer.parseInt(args[2]));
                    if(JuwerynCore.getPlugin().getCurrencyManager().checkCoins(target.getUniqueId(), Integer.parseInt(args[2]))){
                        sender.sendMessage(Utils.cc(prefix + "You have removed " + args[2] + " coins from " + target.getName() + "'s balance!"));
                        target.sendMessage(Utils.cc(prefix +  args[2] + " coins were taken from your balance by " + sender.getName() + "!"));
                        return true;
                    } else {
                        sender.sendMessage(Utils.cc(prefix + "You cannot remove more coins than " + target.getName() + " has!"));
                        return true;
                    }

                }
                if (args[0].equalsIgnoreCase("set")) {
                    if (!sender.hasPermission("juweryncore.coins.set")) {
                        sender.sendMessage(Utils.cc(prefix + noPermission));
                        return true;
                    }
                    Player target = JuwerynCore.getPlugin().getServer().getPlayer(args[1]);
                    assert target != null;
                    JuwerynCore.getPlugin().getCurrencyManager().setCoins(target.getUniqueId(), Integer.parseInt(args[2]));
                    sender.sendMessage(Utils.cc(prefix + "You have set " + args[1] + "'s balance to " + args[2] + " coins!"));
                    target.sendMessage(Utils.cc(prefix + "Your balance has been set to " + args[2] + " coins by " + sender.getName() + "!"));
                    return true;
                }
            }


            return true;
        }
        return true;
    }
}
