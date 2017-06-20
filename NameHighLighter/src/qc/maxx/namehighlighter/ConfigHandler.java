package qc.maxx.namehighlighter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigHandler {
	private static String langage = "en";
	private static String replaceString = "&6@%PLAYERNAME%&r";
	private static Boolean mentionSelf = false;
	private static Boolean usePermission = false;
	private static String permissionNode = "nameshower.mention";
	private static Boolean mentionSound = true;
	private static String sound = "NOTE_PIANO";
	private static int soundVolume = 10;
	private static int soundPitch = 10;

	public static String getLangage() {
		return langage;
	}

	public static void setLangage(String langage) {
		ConfigHandler.langage = langage;
	}
	
	public static String getReplaceString() {
		return replaceString;
	}

	public static void setReplaceString(String replaceString) {
		ConfigHandler.replaceString = replaceString;
	}

	public static Boolean getMentionSelf() {
		return mentionSelf;
	}

	public static void setMentionSelf(Boolean mentionSelf) {
		ConfigHandler.mentionSelf = mentionSelf;
	}
	
	public static Boolean getUsePermission() {
		return usePermission;
	}

	public static void setUsePermission(Boolean usePermission) {
		ConfigHandler.usePermission = usePermission;
	}

	public static String getPermissionNode() {
		return permissionNode;
	}

	public static void setPermissionNode(String permissionNode) {
		ConfigHandler.permissionNode = permissionNode;
	}

	public static Boolean getMentionSound() {
		return mentionSound;
	}

	public static void setMentionSound(Boolean mentionSound) {
		ConfigHandler.mentionSound = mentionSound;
	}

	public static String getSound() {
		return sound;
	}

	public static void setSound(String sound) {
		ConfigHandler.sound = sound;
	}

	public static int getSoundVolume() {
		return soundVolume;
	}

	public static void setSoundVolume(int soundVolume) {
		ConfigHandler.soundVolume = soundVolume;
	}

	public static int getSoundPitch() {
		return soundPitch;
	}

	public static void setSoundPitch(int soundPitch) {
		ConfigHandler.soundPitch = soundPitch;
	}

	public static void writeLangage(BufferedWriter out) throws IOException {
		out.write("#######");
		out.newLine();
		out.write("# Quel est le language utilisé pour les messages? (Défaut: en)");
		out.newLine();
		out.write("# Choix: fr, en");
		out.newLine();
		out.write("#");
		out.newLine();
		out.write("# What langage should be used for the messages? (Default: en)");
		out.newLine();
		out.write("# Choices: fr, en");
		out.newLine();
		out.write("#######");
		out.newLine();
		out.write("Langage: en");
		out.newLine();
		out.newLine();
	}
	
	public static void writeReplaceString(BufferedWriter out) throws IOException {
		out.write("#######");
		out.newLine();
		out.write("# Ceci est le remplacement lorsqu'un pseudo est cité dans le chat (Défaut: &6@%PLAYERNAME%&r)");
		out.newLine();
		out.write("# %PLAYERNAME% est remplacé par le pseudo du joueur cité");
		out.newLine();
		out.write("#");
		out.newLine();
		out.write("# This is the replacement when a nickname is quoted in the chat (Default: &6@%PLAYERNAME%&r)");
		out.newLine();
		out.write("# %PLAYERNAME% is replaced with the quoted player's name");
		out.newLine();
		out.write("#######");
		out.newLine();
		out.write("ReplaceString: '&6@%PLAYERNAME%&r'");
		out.newLine();
		out.newLine();
	}
	
	public static void writeMentionSelf(BufferedWriter out) throws IOException {
		out.write("#######");
		out.newLine();
		out.write("# Est-ce que les joueurs peuvent se citer eux-même? (Défaut: false)");
		out.newLine();
		out.write("#");
		out.newLine();
		out.write("# Can the players quote themself? (Default: false)");
		out.newLine();
		out.write("#######");
		out.newLine();
		out.write("MentionSelf: false");
		out.newLine();
		out.newLine();
	}
	
	public static void writeUsePermission(BufferedWriter out) throws IOException {
		out.write("#######");
		out.newLine();
		out.write("# Voulez-vous utiliser une permission pour pouvoir mentionner un nom? (Défaut: false)");
		out.newLine();
		out.write("# Si sur FALSE, tout le monde pourra mentionner le nom d'un autre joueur");
		out.newLine();
		out.write("#");
		out.newLine();
		out.write("# Do you want to use the permission node to be able to mention players' name? (Default: false)");
		out.newLine();
		out.write("# If on FALSE, everyone would be able to mention the name of any other player");
		out.newLine();
		out.write("#######");
		out.newLine();
		out.write("UsePermission: false");
		out.newLine();
		out.newLine();
	}
	
	public static void writePermissionNode(BufferedWriter out) throws IOException {
		out.write("#######");
		out.newLine();
		out.write("# Seulement si UsePermission est sur TRUE!");
		out.newLine();
		out.write("# La permission utilisée pour permettre aux joueurs de mentionner un nom (Défaut: namehighlighter.mention)");
		out.newLine();
		out.write("#");
		out.newLine();
		out.write("# Only if UsePermission is on TRUE!");
		out.newLine();
		out.write("# The permission node used to give players the ability to mention players' name (Default: namehighlighter.mention)");
		out.newLine();
		out.write("#######");
		out.newLine();
		out.write("PermissionNode: 'namehighlighter.mention'");
		out.newLine();
		out.newLine();
	}

	public static void writeMentionSound(BufferedWriter out) throws IOException {
		out.write("#######");
		out.newLine();
		out.write("# Voulez-vous activer le son lorsqu'un pseudo est cité? (Défaut: true)");
		out.newLine();
		out.write("# Seul le joueur cité entendra ce son");
		out.newLine();
		out.write("#");
		out.newLine();
		out.write("# Do you want to enable the sound when any nickname is mentioned? (Default: true)");
		out.newLine();
		out.write("# Only the mentioned player will hear this sound");
		out.newLine();
		out.write("#######");
		out.newLine();
		out.write("MentionSound: true");
		out.newLine();
		out.newLine();
	}

	public static void writeSound(BufferedWriter out) throws IOException {
		out.write("#######");
		out.newLine();
		out.write("# Seulement si MentionSound est sur TRUE!");
		out.newLine();
		out.write("# Quel son voulez-vous? (Défaut: ENTITY_PLAYER_LEVELUP)");
		out.newLine();
		out.write("# Répertoire des sons disponible ici: https://www.spigotmc.org/wiki/cc-sounds-list/");
		out.newLine();
		out.write("#");
		out.newLine();
		out.write("# Only if MentionSound is on TRUE!");
		out.newLine();
		out.write("# What sound do you want? (Default: ENTITY_PLAYER_LEVELUP)");
		out.newLine();
		out.write("# Directory of sounds available here: https://www.spigotmc.org/wiki/cc-sounds-list/");
		out.newLine();
		out.write("#######");
		out.newLine();
		out.write("Sound: 'ENTITY_PLAYER_LEVELUP'");
		out.newLine();
		out.newLine();
	}
	
	public static void writeSoundVolume(BufferedWriter out) throws IOException {
		out.write("#######");
		out.newLine();
		out.write("# Seulement si MentionSound est sur TRUE!");
		out.newLine();
		out.write("# Quel volume voulez-vous pour le son? (Défaut: 10)");
		out.newLine();
		out.write("#");
		out.newLine();
		out.write("# Only if MentionSound is on TRUE!");
		out.newLine();
		out.write("# What volume do you want for the sound? (Default: 10)");
		out.newLine();
		out.write("#######");
		out.newLine();
		out.write("SoundVolume: 10");
		out.newLine();
		out.newLine();
	}
	
	public static void writeSoundPitch(BufferedWriter out) throws IOException {
		out.write("#######");
		out.newLine();
		out.write("# Seulement si MentionSound est sur TRUE!");
		out.newLine();
		out.write("# Quel ton voulez-vous pour le son? (Défaut: 10)");
		out.newLine();
		out.write("#");
		out.newLine();
		out.write("# Only if MentionSound is on TRUE!");
		out.newLine();
		out.write("# What pitch do you want for the sound? (Default: 10)");
		out.newLine();
		out.write("#######");
		out.newLine();
		out.write("SoundPitch: 10");
		out.newLine();
		out.newLine();
	}

	public static void initConfig(File dataFolder) throws IOException {
		if (!dataFolder.exists())
			dataFolder.mkdir();
		
		File configFile = new File(dataFolder, "config.yml");
		
		if (!configFile.exists()) {
			configFile.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(configFile));
			
			out.write("####  #  #####  ###    ###  #####  #   #  #  #####  #   #  #      #  #####    #   #  #####  #####  #####");
			out.newLine();
			out.write("#  #  #  #   #  # #   #  #  #      #   #  #  #      #   #  #      #  #        #   #    #    #      #   #");
			out.newLine();
			out.write("#  #  #  #   #  #  # #   #  #      #   #  #  #      #   #  #      #  #        #   #    #    #      #   #");
			out.newLine();
			out.write("#  #  #  #####  #   #    #  #####  #####  #  #  ##  #####  #      #  #  ##    #####    #    #####  #####");
			out.newLine();
			out.write("#  #  #  #   #  #        #  #      #   #  #  #   #  #   #  #      #  #   #    #   #    #    #      # #");
			out.newLine();
			out.write("#  #  #  #   #  #        #  #      #   #  #  #   #  #   #  #      #  #   #    #   #    #    #      #  #");
			out.newLine();
			out.write("#  ####  #   #  #        #  #####  #   #  #  #####  #   #  #####  #  #####    #   #    #    #####  #   #");
			out.newLine();
			out.newLine();

			writeLangage(out);
			writeReplaceString(out);
			writeMentionSelf(out);
			writeUsePermission(out);
			writePermissionNode(out);
			writeMentionSound(out);
			writeSound(out);
			writeSoundVolume(out);
			writeSoundPitch(out);
			
			out.close();
		}
		
		YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
		BufferedWriter out = new BufferedWriter(new FileWriter(configFile, true));
		
		if (config.contains("Langage")) {
			if (!config.getString("Langage").equalsIgnoreCase("fr") && !config.getString("Langage").equalsIgnoreCase("en")) {
				System.out.println("Langue non valide! Utilisation de: en | Invalid language! Now using: en");
				setLangage("en");
			} else
				setLangage(config.getString("Langage"));
		} else
			writeLangage(out);
		
		if (config.contains("ReplaceString"))
			setReplaceString(config.getString("ReplaceString"));
		else
			writeReplaceString(out);
		
		if (config.contains("MentionSelf"))
			setMentionSelf(config.getBoolean("MentionSelf"));
		else
			writeMentionSelf(out);
		
		if (config.contains("UsePermission"))
			setUsePermission(config.getBoolean("UsePermission"));
		else
			writeUsePermission(out);
		
		if (config.contains("PermissionNode"))
			setPermissionNode(config.getString("PermissionNode"));
		else
			writePermissionNode(out);
		
		if (config.contains("MentionSound"))
			setMentionSound(config.getBoolean("MentionSound"));
		else
			writeMentionSound(out);
		
		if (config.contains("Sound"))
			setSound(config.getString("Sound"));
		else
			writeSound(out);
		
		if (config.contains("SoundVolume"))
			setSoundVolume(config.getInt("SoundVolume"));
		else
			writeSoundVolume(out);
		
		if (config.contains("SoundPitch"))
			setSoundPitch(config.getInt("SoundPitch"));
		else
			writeSoundPitch(out);
		
		out.close();
	}
}
