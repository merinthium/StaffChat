package me.merinthium.com.listeners;

import me.merinthium.com.Main;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
@SuppressWarnings("deprecation")
public class ChatListener implements Listener 
{
	private Main plugin;
	
	public ChatListener(Main instance)
	{
		plugin= instance;
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e)
	{
		if (plugin.getConfig().getString(e.getPlayer().getName() + ".staffchat").equalsIgnoreCase("true"))
		{
			e.setCancelled(true);
			for(String s : plugin.getConfig().getStringList("staff"))
			{
				Player p = (Player) plugin.getServer().getPlayer(s);
				if(p.isOnline())
				{
					p.sendMessage(ChatColor.DARK_BLUE + "[StaffChat]" + p.getName() + ChatColor.GREEN + e.getMessage());
				}
			}
		}
		else return;
	}

}
