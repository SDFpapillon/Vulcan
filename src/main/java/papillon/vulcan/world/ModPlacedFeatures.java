package papillon.vulcan.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import papillon.vulcan.Vulcan;

import java.util.List;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> VULCAN_ORE_PLACED_KEY = registerKey("vulcan_ore");
    public static final RegistryKey<PlacedFeature> VULCAN_ORE_EXTRA_KEY = registerKey("vulcan_ore_extra");
    public static final RegistryKey<PlacedFeature> VULCAN_ORE_LOWER_KEY = registerKey("vulcan_ore_lower");

    public static void boostrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, VULCAN_ORE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VULCAN_ORE_KEY),
                ModOrePlacement.modifiersWithCount(54, // Veins per Chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(32))));
        register(context, VULCAN_ORE_EXTRA_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VULCAN_ORE_KEY),
                ModOrePlacement.modifiersWithCount(50, // Veins per Chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(32), YOffset.fixed(-256))));
        register(context, VULCAN_ORE_LOWER_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VULCAN_ORE_KEY),
                ModOrePlacement.modifiersWithCount(1, // Veins per Chunk
                        HeightRangePlacementModifier.trapezoid(YOffset.fixed(-64), YOffset.fixed(32))));

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Vulcan.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
