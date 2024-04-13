package net.thev123.magusarmors;

import net.fabricmc.api.ModInitializer;

import net.thev123.magusarmors.item.ModItemGroups;
import net.thev123.magusarmors.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagusArmors implements ModInitializer {
	public static final String MOD_ID = "magusarmors";
    public static final Logger LOGGER = LoggerFactory.getLogger("magusarmors");

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");

		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
	}
}