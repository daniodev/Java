package ban;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class discord implements CommandExecutor {
    private Plugin plugin = Main.getPlugin(Main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(sender.hasPermission("intents.discord")) {
            if(args.length==0) {
                String messaggio = plugin.getConfig().getString("Messaggi.discord-message").replaceAll("§","&");
                sender.sendMessage(messaggio);
            }else if(args[0].equalsIgnoreCase("link")) {
                String messaggios = plugin.getConfig().getString("Messaggi.discord-message").replaceAll("§","&");
                sender.sendMessage(messaggios);
            }
        }else{
            String messaggio = plugin.getConfig().getString("Messaggi.no-perms").replaceAll("§","&");
            sender.sendMessage(messaggio);
        }
        return true;
    }
}
