/**
 * 
 */
package com.someguyssoftware.configtest.config;

import com.someguyssoftware.configtest.ConfigTest;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @author Mark Gottschling on Sep 2, 2019
 *
 */
@Config(modid = ConfigTest.MODID)
@Config.LangKey("configtest.config.title")
public class ModConfig {
	
	@Config.Comment("This is an example boolean property.")
	public static boolean fooBar = false;
	
	public static class Client {

		@Config.Comment("This is an example int property.")
		public int baz = -100;
	}
	
	@Mod.EventBusSubscriber(modid = ConfigTest.MODID)
	private static class EventHandler {

		/**
		 * Inject the new values and save to the config file when the config has been changed from the GUI.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(ConfigTest.MODID)) {
				ConfigManager.sync(ConfigTest.MODID, Config.Type.INSTANCE);
			}
		}
	}
}
