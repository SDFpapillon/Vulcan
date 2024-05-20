package papillon.vulcan.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import papillon.vulcan.Vulcan;

public class ModBlocks {


    public static final Block VULCAN_ORE = registerBlock("vulcan_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).strength(200.0f, 1200.0f)));

    public static final Block VULCAN_BLOCK = registerBlock("vulcan_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE).strength(50.0f, 1200.0f)));

    public static final Block VULCAN_RENFORCED_BLOCK = registerBlock("vulcan_reinforced_block",
            new Block(FabricBlockSettings.copyOf(Blocks.REINFORCED_DEEPSLATE).strength(500.0f, 1200.0f)));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Vulcan.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Vulcan.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Vulcan.LOGGER.info("Création des blocks pour " + Vulcan.MOD_ID);
    }
}
