package papillon.vulcan.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import papillon.vulcan.Vulcan;
import papillon.vulcan.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup VULCAN_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Vulcan.MOD_ID, "vulcan"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.vulcan"))//net.fabricmc.fabric.api.item.v1.FabricItemGroup
                    .icon(() -> new ItemStack(ModItems.VULCAN_INGOT)).entries((displayContext, entries) -> {
                        // ici on peut ajouter les items qu'on veut, vanilla ou pas
                        entries.add(ModBlocks.VULCAN_ORE);
                        entries.add(ModItems.VULCAN_RAW_POWDER);
                        entries.add(ModItems.VULCAN_POWDER);
                        entries.add(ModItems.VULCAN_NUGGET);
                        entries.add(ModItems.VULCAN_INGOT);

                        entries.add(ModItems.VULCAN_SWORD);
                        entries.add(ModItems.VULCAN_SHOVEL);
                        entries.add(ModItems.VULCAN_PICKAXE);
                        entries.add(ModItems.VULCAN_AXE);
                        entries.add(ModItems.VULCAN_HOE);

                        entries.add(ModItems.VULCAN_HELMET);
                        entries.add(ModItems.VULCAN_CHESTPLATE);
                        entries.add(ModItems.VULCAN_LEGGINGS);
                        entries.add(ModItems.VULCAN_BOOTS);

                        entries.add(ModItems.SIEVE_GRID);
                        entries.add(ModItems.SIEVE);

                        entries.add(ModBlocks.VULCAN_BLOCK);
                        entries.add(ModBlocks.VULCAN_RENFORCED_BLOCK);
                    }).build());

    public static void registerItemGroup () {
        Vulcan.LOGGER.info("Register item groupe for " + Vulcan.MOD_ID);
    }
}
