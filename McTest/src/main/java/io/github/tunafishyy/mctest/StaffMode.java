package io.github.tunafishyy.mctest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class StaffMode implements Listener {

    /**
     * NOTICE: Staff members will receive other staff's messages no matter if their mode is toggled on or off.
     */

    @EventHandler
    public void onSendMessage(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        Player p = e.getPlayer();

        //Handling staff messages.
        if (p.hasPermission("staff") || p.isOp()) {
            if (StaffChatToggle.staff.contains(p.getUniqueId())) {
                e.setCancelled(true);

                for (Player staff : Bukkit.getOnlinePlayers()) {
                    if (staff.hasPermission("staff") || staff.isOp()) {
                        staff.sendMessage(ChatColor.RED + p.getName() + ": " + ChatColor.AQUA + message);
                    }
                }
            }
        }
    }


}