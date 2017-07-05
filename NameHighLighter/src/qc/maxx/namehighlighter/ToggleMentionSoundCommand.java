package qc.maxx.namehighlighter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ToggleMentionSoundCommand implements CommandExecutor {
	private NameHighLighter plugin;
	
	public ToggleMentionSoundCommand(NameHighLighter plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (plugin.getDesactivedSoundPlayers().contains(p.getUniqueId().toString())) {
				plugin.getDesactivedSoundPlayers().remove(p.getUniqueId().toString());
				
				if (ConfigHandler.getLangage().equals("fr"))
					p.sendMessage(plugin.colorize("&bLe son de mention est désormais activé!"));
				else
					p.sendMessage(plugin.colorize("&bThe mention sound is now activated!"));
			} else {
				plugin.getDesactivedSoundPlayers().add(p.getUniqueId().toString());
				
				if (ConfigHandler.getLangage().equals("fr"))
					p.sendMessage(plugin.colorize("&bLe son de mention est désormais désactivé!"));
				else
					p.sendMessage(plugin.colorize("&bThe mention sound is now desactivated!"));
			}
		}
		
		return true;
	}
}
