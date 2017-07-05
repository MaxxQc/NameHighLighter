package qc.maxx.namehighlighter;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatEvent implements Listener {
	private NameHighLighter plugin;
	
	public PlayerChatEvent(NameHighLighter plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player sender = e.getPlayer();
		Collection<? extends Player> list = Bukkit.getOnlinePlayers();

		if (ConfigHandler.getUsePermission()) {
			if (sender.hasPermission(ConfigHandler.getPermissionNode())) {
				for (Player target : list) {
					if (!ConfigHandler.getMentionSelf() && target == sender)
						continue;
					
					if (e.getMessage().contains(target.getName())) {
						String message = e.getMessage().replace(target.getName(), plugin.colorize(ConfigHandler.getReplaceString().replace("%PLAYERNAME%", target.getName())));
						
						e.getRecipients().remove(target);
						e.getRecipients().remove(sender);
						
						target.sendMessage(String.format(e.getFormat(), sender.getCustomName() == null ? sender.getName() : sender.getCustomName(), message));
						
						if (sender != target)
							sender.sendMessage(String.format(e.getFormat(), sender.getCustomName() == null ? sender.getName() : sender.getCustomName(), message));
						
						if (ConfigHandler.getMentionSound())
							if (!plugin.getDesactivedSoundPlayers().contains(target.getUniqueId().toString()))
								target.playSound(target.getLocation(), Sound.valueOf(ConfigHandler.getSound()), ConfigHandler.getSoundVolume(), ConfigHandler.getSoundPitch());
					}
				}
			}
		} else {
			for (Player target : list) {
				if (!ConfigHandler.getMentionSelf() && target == sender)
					continue;
				
				if (e.getMessage().contains(target.getName())) {
					String message = e.getMessage().replace(target.getName(), plugin.colorize(ConfigHandler.getReplaceString().replace("%PLAYERNAME%", target.getName())));
					
					e.getRecipients().remove(target);
					e.getRecipients().remove(sender);
					
					target.sendMessage(String.format(e.getFormat(), sender.getCustomName() == null ? sender.getName() : sender.getCustomName(), message));
					
					if (sender != target)
						sender.sendMessage(String.format(e.getFormat(), sender.getCustomName() == null ? sender.getName() : sender.getCustomName(), message));
					
					if (ConfigHandler.getMentionSound())
						if (!plugin.getDesactivedSoundPlayers().contains(target.getUniqueId().toString()))
							target.playSound(target.getLocation(), Sound.valueOf(ConfigHandler.getSound()), ConfigHandler.getSoundVolume(), ConfigHandler.getSoundPitch());
				}
			}
		}
	}
}
