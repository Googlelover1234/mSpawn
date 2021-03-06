package mspawn.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigManager {
	
	private ConfigManager() {
		
	}
	
	static ConfigManager instance = new ConfigManager();
	
	public static ConfigManager getInstance() {
		return instance;
	}
	
	File file;
	FileConfiguration config;
	Plugin p;
	
	public void setup(Plugin p) {
		
		this.p = p;
		
		file = new File(p.getDataFolder(), "config.yml");
		config = YamlConfiguration.loadConfiguration(file);
		
		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();
		}
		
		if (!file.exists()) {
			
			try {
				
				file.createNewFile();
				
				config.set("spawn.world", "world");
				config.set("spawn.x", "100");
				config.set("spawn.y", "100");
				config.set("spawn.z", "100");
				config.set("spawn.yaw", "100");
				config.set("spawn.pitch", "100");
				
				config.save(file);
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
	}
	
	public FileConfiguration getConfig() {
		return config;
	}
	
	public Plugin getPlugin() {
		return p;
	}
	
	public void saveConfig() {
		
		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
