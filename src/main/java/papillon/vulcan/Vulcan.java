package papillon.vulcan;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import papillon.vulcan.block.ModBlocks;
import papillon.vulcan.event.AttackEntityHandler;
import papillon.vulcan.item.ModItemGroups;
import papillon.vulcan.item.ModItems;
import papillon.vulcan.world.gen.ModWorldGeneration;

public class Vulcan implements ModInitializer {
    public static final String MOD_ID = "vulcan";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModWorldGeneration.generateModWorldGen();

        ModBlocks.registerModBlocks();
        ModItems.registerModItems();
        ModItemGroups.registerItemGroup();

        AttackEntityCallback.EVENT.register(new AttackEntityHandler());
    }
}
