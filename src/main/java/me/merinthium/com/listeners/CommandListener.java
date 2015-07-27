package me.merinthium.com.listeners;

import me.merinthium.com.Main;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandListener implements CommandExecutor 
{
	private Main plugin;
	
	public CommandListener(Main instance)
	{
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender sender,org.bukkit.command.Command command, String label, String[] args) 
	{
		if(!(sender instanceof Player))
		{
			sender.sendMessage("Only Players can toggle staff chat!");
		}
		
		Player p = (Player) sender;
		if(!p.hasPermission("staffchat.use"))
		{
			p.sendMessage(ChatColor.RED + "You do not have permission for this command");
			return true;
		}
		if(plugin.getConfig().getString(p.getName() + ".staffchat").equalsIgnoreCase("true"))
		{
			p.sendMessage(ChatColor.BLUE + "StaffChat Disabled!");
			plugin.getConfig().set(p.getName() + ".staffchat", "false");
			plugin.saveConfig();
			return true;
		}
		else if(plugin.getConfig().getString(p.getName() + ".staffchat").equalsIgnoreCase("false"))
		{
			p.sendMessage(ChatColor.BLUE + "StaffChat Enabled!");
			plugin.getConfig().set(p.getName() + ".staffchat", "true");
			plugin.saveConfig();
			return true;
		}
		return false;
	}

}
