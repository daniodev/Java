package ban;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class tphere implements CommandExecutor {
    private Plugin plugin = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender.hasPermission("intents.tphere.use")) {
            if (args.length == 0) {
                String messaggio = plugin.getConfig().getString("Messaggi.tphere-specify").replaceAll("&", "§");
                sender.sendMessage(messaggio);
            } else {
                if (args.length == 1) {
                    Player senderp = (Player) sender;
                    Player target = Bukkit.getServer().getPlayerExact(args[0]);
                    if(target!=null){
                        if(target!=senderp){
                            target.teleport(senderp);
                            String messaggio = plugin.getConfig().getString("Messaggi.tp-mess").replaceAll("&", "§");
                            sender.sendMessage(messaggio);
                        }
                    }else{
                        String messaggio = plugin.getConfig().getString("Messaggi.offline-player").replaceAll("&", "§");
                        sender.sendMessage(messaggio);
                    }
                }
            }
        }
        return true;
    }
}
