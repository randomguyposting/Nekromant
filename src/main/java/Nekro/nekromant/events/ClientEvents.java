package Nekro.nekromant.events;

import Nekro.nekromant.Nekromant;
import Nekro.nekromant.registry.NeBlocks;
import Nekro.nekromant.registry.NeFluids;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Nekromant.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientEvents {

    private ClientEvents() {
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(NeFluids.BLOOD_SOURCE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(NeFluids.BLOOD_FLOWING.get(), RenderType.translucent());
    }
}