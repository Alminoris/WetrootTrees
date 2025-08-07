package net.alminoris.wetroottrees;

import net.alminoris.wetroottrees.block.ModBlocks;
import net.alminoris.wetroottrees.entity.ModBoats;
import net.alminoris.wetroottrees.item.ModItemGroups;
import net.alminoris.wetroottrees.item.ModItems;
import net.alminoris.wetroottrees.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.alminoris.wetroottrees.util.helper.ModBlockSetsHelper.*;

public class WetrootTrees implements ModInitializer
{
	public static final String MOD_ID = "wetroottrees";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize()
	{
		LOGGER.info("Wetroot Trees Mod Initialization");

		ModItems.registerModItems();

		ModBlocks.registerModBlocks();

		for (String name : WOOD_NAMES)
		{
			StrippableBlockRegistry.register(LOGS.get(name), STRIPPED_LOGS.get(name));
			StrippableBlockRegistry.register(WOODS.get(name), STRIPPED_WOODS.get(name));

			FlammableBlockRegistry.getDefaultInstance().add(LOGS.get(name), 5, 5);
			FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_LOGS.get(name), 5, 5);
			FlammableBlockRegistry.getDefaultInstance().add(WOODS.get(name), 5, 5);
			FlammableBlockRegistry.getDefaultInstance().add(STRIPPED_WOODS.get(name), 5, 5);

			FlammableBlockRegistry.getDefaultInstance().add(WOODEN_PLANKS.get(name), 5, 20);
			FlammableBlockRegistry.getDefaultInstance().add(LEAVES.get(name), 30, 60);
		}

		ModBoats.registerBoats();

		ModItemGroups.registerItemGroups();

		ModWorldGeneration.generateModWorldGen();
	}
}