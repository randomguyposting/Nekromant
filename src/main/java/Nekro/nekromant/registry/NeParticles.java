package Nekro.nekromant.registry;

import Nekro.nekromant.Nekromant;
import Nekro.nekromant.particles.BloodFlame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = Nekromant.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NeParticles{
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Nekromant.MODID);

    public static final RegistryObject<SimpleParticleType> BLOOD_FLAME = PARTICLES.register("blood_flame", ()-> new SimpleParticleType(false));

    @SubscribeEvent
    public static void registerParticleFactories(ParticleFactoryRegisterEvent event) {
        ParticleEngine particleManager = Minecraft.getInstance().particleEngine;

        particleManager.register(BLOOD_FLAME.get(), BloodFlame.Factory::new);
    }
}
