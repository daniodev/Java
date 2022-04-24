package ban;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class join implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (p.hasPermission("join.special.owner")) {
            for (Player online: Bukkit.getOnlinePlayers()){
                online.sendMessage(ChatColor.DARK_RED + "Owner " + ChatColor.WHITE + p.getName() + " è entrato nella lobby");
            }
        }
    }
}
