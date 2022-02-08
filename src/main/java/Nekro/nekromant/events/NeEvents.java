package Nekro.nekromant.events;

import Nekro.nekromant.Nekromant;
import Nekro.nekromant.blocks.MercuryOre;
import Nekro.nekromant.registry.NeBlocks;
import Nekro.nekromant.registry.NePlacedfeatures;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.storage.WorldData;
import net.minecraftforge.event.entity.player.PlayerEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.ParticleArgument;
import net.minecraft.commands.arguments.coordinates.Vec3Argument;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.commands.ParticleCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.File;
import java.io.IOException;


@Mod.EventBusSubscriber(modid = Nekromant.MODID)
public class NeEvents {
    @SubscribeEvent
    public static void breakingMercuryOreRestoresDurability(BlockEvent.BreakEvent event){
        Block block = event.getState().getBlock();
        if(block == NeBlocks.MERCURY_ORE.get()){
            ServerLevel level;
            LivingEntity player = event.getPlayer();
                player.getMainHandItem().hurtAndBreak(-101, player, (p_40992_) -> {
                    p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                });
        }
    }

    @SubscribeEvent
    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.BiomeCategory.NETHER) {
        } else if (event.getCategory() == Biome.BiomeCategory.THEEND) {
        } else {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, NePlacedfeatures.MERCURY_ORE);
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinEvent(PlayerEvent.PlayerLoggedInEvent event){
        Logger logger = LogManager.getLogger();
        WorldData worldData = event.getPlayer().getServer().getWorldData();

        try {
            File playerFile = new File("saves\\"+worldData.getLevelName()+"\\playerdata\\"+event.getPlayer().getStringUUID() + ".json");
            if (playerFile.createNewFile()) {
                logger.info("File for:" + event.getPlayer() + " successfully created");
            } else {
                logger.info("File for:" + event.getPlayer() + " already exists");
            }
        } catch (IOException e){
            logger.info("An error while trying to create a file for:"+event.getPlayer()+" occurred");
            e.printStackTrace();
        }
    }
}
