package qc.maxx.namehighlighter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class NameHighLighter extends JavaPlugin implements Listener {
	private Logger logger;
	private List<String> desactivedSoundPlayers;
	
	public void onEnable() {
		this.logger = getLogger();
		new PlayerChatEvent(this);
		
		if (!setupConfig()) {
			if (ConfigHandler.getLangage().equals("fr")) {
				this.logger.severe(" ");
				this.logger.severe("Depuis que je n'ai pas pu configurer le fichier de configuration correctement, je suppose que cela est un au revoir.");
				this.logger.severe("Chargement du plugin interrompu!");
				this.logger.severe(" ");
			} else {
				this.logger.severe(" ");
		        this.logger.severe("Since I could not configure the configuration file correctly , I guess this is goodbye.");
		        this.logger.severe("Plugin loading aborted!");
		        this.logger.severe(" ");
			}
		}
		
		if (!setupPlayersSettings()) {
			if (ConfigHandler.getLangage().equals("fr")) {
				this.logger.severe(" ");
		        this.logger.severe("Depuis que je n'ai pas pu configurer le fichier de paramètres des joueurs correctement, je suppose que cela est un au revoir.");
		        this.logger.severe("Chargement du plugin interrompu!");
		        this.logger.severe(" ");
			} else {
				this.logger.severe(" ");
		        this.logger.severe("Since I could not configure the players' settings file correctly , I guess this is goodbye.");
		        this.logger.severe("Plugin loading aborted!");
		        this.logger.severe(" ");
			}
		}
		
		if (ConfigHandler.getMentionSound())
			this.getCommand("togglementionsound").setExecutor(new ToggleMentionSoundCommand(this));
		
		this.logger.info("Langue / Langage : " + ConfigHandler.getLangage());
		
		return;
	}
	
	public void onDisable() {
		File playersSettingsFile = new File(getDataFolder(), "players-settings.yml");
        FileConfiguration playersSettings = YamlConfiguration.loadConfiguration(playersSettingsFile);

        playersSettings.set("disabled-sound-players", getDesactivedSoundPlayers());
        
        try {
			playersSettings.save(playersSettingsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean setupConfig() {
		File pluginFolder = getDataFolder();
		
		if ((!pluginFolder.exists()) && (!pluginFolder.mkdir())) {
			this.logger.severe("Impossible de créer le dossier du plugin! Ça ne va pas bien finir...");
			this.logger.severe(" ");
	        this.logger.severe(" ---");
	        this.logger.severe(" ");
			this.logger.severe("Could not create the plugin folder ! It will not end well...");
			
			return false;
		}
		
		try {
			ConfigHandler.initConfig(getDataFolder());
		} catch (IOException e) {
			this.logger.severe("Création du fichier de configuration impossible!");
			this.logger.severe(" ");
	        this.logger.severe(" ---");
	        this.logger.severe(" ");
			this.logger.severe("Could not create the configuration file!");
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	private boolean setupPlayersSettings() {
		File playersSettingsFile = new File(getDataFolder(), "players-settings.yml");
        FileConfiguration playersSettings = YamlConfiguration.loadConfiguration(playersSettingsFile);

        if (playersSettingsFile.exists()) {
        	if (ConfigHandler.getMentionSound())
        		setDesactivedSoundPlayers(playersSettings.getStringList("disabled-sound-players"));
        } else {
        	try {
                playersSettings.save(playersSettingsFile);
            } catch (IOException e) {
            	this.logger.severe("Création du fichier de paramètres des joueurs impossible!");
    			this.logger.severe(" ");
    	        this.logger.severe(" ---");
    	        this.logger.severe(" ");
    			this.logger.severe("Could not create the players' settings file!");
            	
                e.printStackTrace();
                return false;
            }
        }
        
        return true;
	}
	
	public static String colorize(String string) {
		if (string == null)
			return null;

		return string.replaceAll("&([0-9a-z])", "§$1");
	}

	public List<String> getDesactivedSoundPlayers() {
		return desactivedSoundPlayers;
	}

	public void setDesactivedSoundPlayers(List<String> desactivedSoundPlayers) {
		this.desactivedSoundPlayers = desactivedSoundPlayers;
	}
}
