package ban;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;


public class intents implements CommandExecutor {
    private Plugin plugin = Main.getPlugin(Main.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender.hasPermission("intents.admin")){
            if(args.length==1) {
                if(args[0].equalsIgnoreCase("reload")) {
                    String messaggio = plugin.getConfig().getString("Messaggi.reload-msg").replaceAll("&","§");
                    sender.sendMessage(messaggio);
                    plugin.reloadConfig();
                }
            }
        }
        return true;
    }
}
