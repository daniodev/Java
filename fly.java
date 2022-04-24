package ban;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class fly implements CommandExecutor {
    private Plugin plugin = Main.getPlugin(Main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("intents.fly")) {
                if (args.length == 0) {
                    Player p = (Player) sender;
                    if (p.getAllowFlight()) {
                        p.setAllowFlight(false);
                        String messaggios = plugin.getConfig().getString("Messaggi.fly-off-msg").replaceAll("&","§");
                        p.sendMessage(messaggios);
                    } else {
                        p.setAllowFlight(true);
                        String messaggios = plugin.getConfig().getString("Messaggi.fly-on-msg").replaceAll("&","§");
                        p.sendMessage(messaggios);
                    }
                } else if (args.length == 1) {
                    Player pi = Bukkit.getServer().getPlayerExact(args[0]);
                    if (pi!=null) {
                        if(pi==sender)  {
                            if (pi.getAllowFlight()) {
                                pi.setAllowFlight(false);
                                String messaggiose = plugin.getConfig().getString("Messaggi.fly-off-msg").replaceAll("&","§");
                                pi.sendMessage(messaggiose);
                        }else {
                                pi.setAllowFlight(true);
                                String messaggiose = plugin.getConfig().getString("Messaggi.fly-on-msg").replaceAll("&","§");
                                pi.sendMessage(messaggiose);
                            }
                        }if (pi!=sender) {
                            if (pi.getAllowFlight()) {
                                pi.setAllowFlight(false);
                                String messaggiose = plugin.getConfig().getString("Messaggi.fly-off-msg").replaceAll("&","§").replaceAll("%target%", pi.getName());
                                String messaggio = plugin.getConfig().getString("Messaggi.fly-on-msg-other-player").replaceAll("&","§");
                                sender.sendMessage(messaggio);
                                pi.sendMessage(messaggiose);
                            }else {
                                pi.setAllowFlight(true);
                                String messaggiose = plugin.getConfig().getString("Messaggi.fly-on-msg").replaceAll("&","§");
                                String messaggio = plugin.getConfig().getString("Messaggi.fly-off-msg-other-player").replaceAll("&","§");
                                sender.sendMessage(messaggio);
                                pi.sendMessage(messaggiose);
                            }
                        }
                    }if (pi==null) {
                        String messaggio = plugin.getConfig().getString("Messaggi.offline-player").replaceAll("&","§");
                        sender.sendMessage(messaggio);
                    }
                }
            }else {
                String messaggiose = plugin.getConfig().getString("Messaggi.no-perms").replaceAll("&","§");
                sender.sendMessage(messaggiose);
            }
        } else {
            if (args.length == 1) {
                Player pi = Bukkit.getServer().getPlayerExact(args[0]);
                if(pi!=null) {
                    if (pi.getAllowFlight()) {
                        pi.setAllowFlight(false);
                        String messaggiose = plugin.getConfig().getString("Messaggi.fly-off-msg").replaceAll("&","§");
                        String messaggio = plugin.getConfig().getString("Messaggi.fly-off-msg-other-player").replaceAll("&","§");
                        System.out.println(messaggio);
                        pi.sendMessage(messaggiose);
                    }else {
                        pi.setAllowFlight(true);
                        String messaggiose = plugin.getConfig().getString("Messaggi.fly-on-msg").replaceAll("&","§");
                        String messaggio = plugin.getConfig().getString("Messaggi.fly-on-msg-other-player").replaceAll("&","§");
                        System.out.println(messaggio);
                        pi.sendMessage(messaggiose);
                    }
                }if(pi==null) {
                    String messaggio = plugin.getConfig().getString("Messaggi.offline-player").replaceAll("&","§");
                    sender.sendMessage(messaggio);
                }
            }else if(args.length==0) {
                String messaggio = plugin.getConfig().getString("specify-command").replaceAll("&","§");
                System.out.println(messaggio);
            }
        }


        return true;
    }
}