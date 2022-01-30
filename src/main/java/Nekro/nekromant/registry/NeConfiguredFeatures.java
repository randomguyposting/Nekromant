package Nekro.nekromant.registry;

import Nekro.nekromant.Nekromant;
import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class NeConfiguredFeatures {

    public static final ConfiguredFeature<?, ?> MERCURY_ORE = register("mercury_ore", NeFeatures.MERCURY_ORE.get().configured(FeatureConfiguration.NONE));

    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Nekromant.MODID, name), feature);
    }


    public static void init() {}
}
