package qc.maxx.namehighlighter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleMentionSoundCommand implements CommandExecutor {
	private NameHighLighter plugin;
	
	public ToggleMentionSoundCommand(NameHighLighter plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (plugin.getDesactivedSoundPlayers().contains(sender.getName())) {
			plugin.getDesactivedSoundPlayers().remove(sender.getName());
			
			if (ConfigHandler.getLangage().equals("fr"))
				sender.sendMessage(NameHighLighter.colorize("&bLe son de mention est désormais activé!"));
			else
				sender.sendMessage(NameHighLighter.colorize("&bThe mention sound is now activated!"));
		} else {
			plugin.getDesactivedSoundPlayers().add(sender.getName());
			
			if (ConfigHandler.getLangage().equals("fr"))
				sender.sendMessage(NameHighLighter.colorize("&bLe son de mention est désormais désactivé!"));
			else
				sender.sendMessage(NameHighLighter.colorize("&bThe mention sound is now desactivated!"));
		}
		
		return true;
	}
}
