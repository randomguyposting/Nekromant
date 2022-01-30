package Nekro.nekromant.registry;

import Nekro.nekromant.Nekromant;
import Nekro.nekromant.world.placement.MercuryOreFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NeFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, Nekromant.MODID);

    public static final RegistryObject<Feature<NoneFeatureConfiguration>> MERCURY_ORE = FEATURES.register(
            "mercury_ore", () -> new MercuryOreFeature(NoneFeatureConfiguration.CODEC));

}
