package ban;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class spectator implements CommandExecutor {
    private Plugin plugin = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("intents.gamemode.spectator")) {
                if (args.length == 0) {
                    Player pu = (Player) sender;
                    pu.setGameMode(GameMode.SPECTATOR);
                    String messaggio = plugin.getConfig().getString("Messaggi.gmsp-msg").replaceAll("&","§");
                    pu.sendMessage(messaggio);
                } else if (args.length == 1) {
                    Player pi = Bukkit.getServer().getPlayerExact(args[0]);
                    if (pi != null) {
                        if(pi==sender) {
                            pi.setGameMode(GameMode.SPECTATOR);
                            String messaggios = plugin.getConfig().getString("Messaggi.gmsp-msg").replaceAll("&","§");
                            sender.sendMessage(messaggios);
                        }if(pi!=sender) {
                            pi.setGameMode(GameMode.SPECTATOR);
                            String messaggios = plugin.getConfig().getString("Messaggi.gmsp-msg").replaceAll("&","§");
                            pi.sendMessage(messaggios);
                            String messaggiose = plugin.getConfig().getString("Messaggi.gamemode-change-msg-other").replaceAll("&","§");
                            sender.sendMessage(messaggiose);
                        }
                    } else if (pi == null) {
                        sender.sendMessage("Giocatore offline");
                    }
                }
            } else {
                String messaggiose = plugin.getConfig().getString("Messaggi.no-perms").replaceAll("&","§");
                sender.sendMessage(messaggiose);
            }
        } else if (args.length == 1) {
            Player p = Bukkit.getServer().getPlayerExact(args[0]);
            if (p != null) {
                p.setGameMode(GameMode.SPECTATOR);
                String messaggios = plugin.getConfig().getString("Messaggi.gmsp-msg").replaceAll("&","§");
                sender.sendMessage(messaggios);
            } else if (p == null) {
                sender.sendMessage("Giocatore offline");
            }
        }
        return true;
    }
}