package Nekro.nekromant.registry;

import Nekro.nekromant.Nekromant;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.*;

public class NePlacedfeatures {

    public static final PlacedFeature MERCURY_ORE = register("mercury_ore", NeConfiguredFeatures.MERCURY_ORE.placed(CountPlacement.of(200), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome()));

    private static PlacedFeature register(String name, PlacedFeature feature) {
        return Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(Nekromant.MODID, name), feature);
    }

    public static void init() {}
}
