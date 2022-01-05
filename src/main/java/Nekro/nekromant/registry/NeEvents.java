package Nekro.nekromant.registry;

import Nekro.nekromant.Nekromant;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = Nekromant.MODID)
public class NeEvents {
    /*@SubscribeEvent
    public static void zombiesDropBloodWhenHitUsingExtractor(LivingDamageEvent event){
        if(!event.getEntity().level.isClientSide()){
            if(event.getSource().getDirectEntity() instanceof Player){
                Player player = ((Player) event.getSource().getDirectEntity());
                EntityType entity = event.getEntity().getType();
                if(player.getMainHandItem().getItem() == NeItems.EXTRACTER.get() && entity == EntityType.ZOMBIE){
                    event.getEntityLiving().spawnAtLocation(NeItems.BLOOD_DROP.get());
                }
            }
        }
    }*/
}
