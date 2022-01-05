package Nekro.nekromant.events;

import Nekro.nekromant.Nekromant;
import Nekro.nekromant.events.loot.ZombieAdditionModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Nekromant.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {


    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>>
                                                           event) {
        event.getRegistry().registerAll(
                new ZombieAdditionModifier.Serializer().setRegistryName
                        (new ResourceLocation(Nekromant.MODID,"blood_drop_from_zombie"))
        );
    }
}