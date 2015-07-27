package me.merinthium.com.listeners;

import me.merinthium.com.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener 
{
	private Main plugin;
	public JoinListener(Main instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		if (plugin.getConfig().getString(e.getPlayer().getName()) == null)
		{
			plugin.getConfig().set(e.getPlayer().getName() + ".staffchat", "false");
			
		}
	}
}
