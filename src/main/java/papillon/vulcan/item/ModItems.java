package papillon.vulcan.item;

import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import papillon.vulcan.Vulcan;
import papillon.vulcan.item.custom.ModArmorItem;
import papillon.vulcan.item.custom.ModArmoredElytra;

public class ModItems {

    public static final Item VULCAN_INGOT      = registerItem("vulcan_ingot", new Item(new FabricItemSettings()));
    public static final Item VULCAN_RAW_POWDER = registerItem("vulcan_raw_powder", new Item(new FabricItemSettings()));
    public static final Item VULCAN_POWDER     = registerItem("vulcan_powder", new Item(new FabricItemSettings()));
    public static final Item VULCAN_NUGGET     = registerItem("vulcan_nugget", new Item(new FabricItemSettings()));
    public static final Item SIEVE             = registerItem("sieve", new Item(new FabricItemSettings()));
    public static final Item SIEVE_GRID        = registerItem("sieve_grid", new Item(new FabricItemSettings()));

    public static final Item VULCAN_SWORD   = registerItem("vulcan_sword",   (Item)new SwordItem(ModToolMaterial.VULCAN,   4,    -2.4f, new Item.Settings().fireproof()));
    public static final Item VULCAN_SHOVEL  = registerItem("vulcan_shovel",  (Item)new ShovelItem(ModToolMaterial.VULCAN,  1f,   -3.0f, new Item.Settings().fireproof()));
    public static final Item VULCAN_PICKAXE = registerItem("vulcan_pickaxe", (Item)new PickaxeItem(ModToolMaterial.VULCAN, 7,    -3.5f, new Item.Settings().fireproof()));
    public static final Item VULCAN_AXE     = registerItem("vulcan_axe",     (Item)new AxeItem(ModToolMaterial.VULCAN,     5.0f, -3.0f, new Item.Settings().fireproof()));
    public static final Item VULCAN_HOE     = registerItem("vulcan_hoe",     (Item)new HoeItem(ModToolMaterial.VULCAN,     -4,   0.0f,  new Item.Settings().fireproof()));

    public static final Item VULCAN_HELMET = registerItem("vulcan_helmet",
            new ModArmorItem(ModArmorMaterials.VULCAN, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item VULCAN_CHESTPLATE = registerItem("vulcan_chestplate",
            new ModArmoredElytra(ModArmorMaterials.VULCAN, ArmorItem.Type.CHESTPLATE,  new FabricItemSettings().equipmentSlot(EquipmentSlotProvider -> EquipmentSlot.CHEST) ));
    public static final Item VULCAN_LEGGINGS = registerItem("vulcan_leggings",
            new ArmorItem(ModArmorMaterials.VULCAN, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item VULCAN_BOOTS = registerItem("vulcan_boots",
            new ArmorItem(ModArmorMaterials.VULCAN, ArmorItem.Type.BOOTS, new FabricItemSettings()));






    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Vulcan.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Vulcan.LOGGER.info("Création des items pour " + Vulcan.MOD_ID);
    }
}
