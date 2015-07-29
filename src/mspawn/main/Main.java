package mspawn.main;

import mspawn.cmds.SetSpawn;
import mspawn.cmds.Spawn;
import mspawn.listeners.PlayerMove;
import mspawn.utils.ConfigManager;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		
		load(new PlayerMove());
		
	}
	
	private void registerCommands() {
		
		getCommand("Spawn").setExecutor(new Spawn());
		getCommand("SetSpawn").setExecutor(new SetSpawn());
		
	}
	
	private void load(Listener... listeners) {
		
		for (Listener l : listeners) {
			
			Bukkit.getServer().getPluginManager().registerEvents(l, this);
			
		}
		
		registerCommands();
		
		ConfigManager.getInstance().setup(this);
		
	}

}
