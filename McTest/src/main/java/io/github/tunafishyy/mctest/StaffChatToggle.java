package io.github.tunafishyy.mctest;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StaffChatToggle implements CommandExecutor {

    public static List<UUID> staff = new ArrayList<UUID>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) System.out.println("You are not a player.");

        Player p = (Player) sender;
        if (!(p.hasPermission("staff") || p.isOp())) p.sendMessage("You don't have permission");

        if (staff.contains(p.getUniqueId())) {
            p.sendMessage(ChatColor.RED + "Staff chat disabled");
            staff.remove(p.getUniqueId());
        } else {
            p.sendMessage(ChatColor.GREEN + "Staff chat enabled");
            staff.add(p.getUniqueId());
        }

        return false;
    }

}
