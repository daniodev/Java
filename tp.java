package ban;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class tp implements CommandExecutor {
    private Plugin plugin = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args) {
        if (sender.hasPermission("intents.teleport.use")) {
            if (args.length == 0) {
                String messaggio = plugin.getConfig().getString("Messaggi.tp-specify").replaceAll("&", "§");
                sender.sendMessage(messaggio);
            } else {
                if (args.length == 1) {
                    Player senderp = (Player) sender;
                    Player target = Bukkit.getServer().getPlayerExact(args[0]);
                    senderp.teleport(target);
                    String messaggio = plugin.getConfig().getString("Messaggi.tp-mess").replaceAll("&", "§");
                    sender.sendMessage(messaggio);
                } else {
                    if (args.length == 2) {
                        Player target = Bukkit.getServer().getPlayerExact(args[0]);
                        Player targer2 = Bukkit.getServer().getPlayerExact(args[1]);
                        target.teleport(targer2);
                        if (target != null || targer2 != null) {
                                String messaggio = plugin.getConfig().getString("Messaggi.tp-mess").replaceAll("&", "§");
                                targer2.sendMessage(messaggio);
                                target.sendMessage(messaggio);
                            } else {
                                String messaggio = plugin.getConfig().getString("Messaggi.tp-mess").replaceAll("&", "§");
                                sender.sendMessage(messaggio);
                            }
                    }
                }
            }
        }else{
            String messaggio = plugin.getConfig().getString("Messaggi.no-perms").replaceAll("&", "§");
            sender.sendMessage(messaggio);
        }
        return true;
    }
}