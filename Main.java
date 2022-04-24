package ban;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
    public static Main plugin;
       public void  onEnable(){
        System.out.println("\n|------------------------------------------\n|Intents version 1.0 by danio#7394 Enabled!\n|------------------------------------------");
        getCommand("gmc").setExecutor(new gamemode());
        getCommand("gms").setExecutor(new survival());
        getCommand("fly").setExecutor(new fly());
        getCommand("gma").setExecutor(new adventure());
        getCommand("gmsp").setExecutor(new spectator());
        getCommand("intents").setExecutor(new intents());
        getCommand("discord").setExecutor(new discord());
        getCommand("tphere").setExecutor(new tphere());
        getCommand("tp").setExecutor(new tp());
        getServer().getPluginManager().registerEvents(new join(),this);
        getConfig().options().copyDefaults(true);
        saveConfig();
               }
    public void OnDisable(){
        System.out.println("\n|------------------------------------------\n|Intents version 1.0 by danio#7394 Disabled!\n|------------------------------------------");
    }
    public void OnReload(){
           reloadConfig();
    }
    public static Main getInstance() {
           return plugin;
    }
}

