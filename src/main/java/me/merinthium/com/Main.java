package me.merinthium.com;

import me.merinthium.com.listeners.ChatListener;
import me.merinthium.com.listeners.CommandListener;
import me.merinthium.com.listeners.JoinListener;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{

	public void onEnable()
	{
		getConfig().options().copyDefaults();
		saveConfig();
		getServer().getPluginManager().registerEvents(new JoinListener(this),(this));
		getCommand("staffchat").setExecutor(new CommandListener(this));
		getServer().getPluginManager().registerEvents(new ChatListener(this), (this));
	}
}
