package net.thev123.awesomearmaments;

import net.fabricmc.api.ModInitializer;

import net.thev123.awesomearmaments.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AwesomeArmaments implements ModInitializer {
	public static final String MOD_ID = "awesomearmaments";
    public static final Logger LOGGER = LoggerFactory.getLogger("awesomearmaments");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModItems.registerModItems();
	}
}