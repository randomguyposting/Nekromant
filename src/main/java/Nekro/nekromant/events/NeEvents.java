package Nekro.nekromant.events;

import Nekro.nekromant.Nekromant;
import Nekro.nekromant.registry.NeBlocks;
import Nekro.nekromant.registry.NePlacedfeatures;
import com.google.common.reflect.TypeToken;
import com.google.gson.*;
import com.google.gson.JsonArray;
import net.minecraft.world.level.storage.WorldData;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.*;


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

    //code might suck
    @SubscribeEvent
    public static void onBiomeLoadingEvent(BiomeLoadingEvent event) {
        if (event.getCategory() == Biome.BiomeCategory.NETHER) {
        } else if (event.getCategory() == Biome.BiomeCategory.THEEND) {
        } else {
            event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, NePlacedfeatures.MERCURY_ORE);
        }
    }

    @SubscribeEvent
    public static boolean onPlayerMobKillEvent(LivingDeathEvent event) throws IOException {
        if(!event.getEntity().level.isClientSide) {
            //did a player kill the mob?
            if(event.getSource().getDirectEntity() instanceof Player) {

                //info for file location
                Player player = ((Player) event.getSource().getDirectEntity());
                WorldData worldData = event.getEntity().getServer().getWorldData();

                //file location
                final String fileLocation = "saves/"+worldData.getLevelName()+"/playerdata/nekromant/"+player.getStringUUID() + ".json";
                File file = new File(fileLocation);

                //create gson object and builder, setPrettyPrinting makes the json more readable
                GsonBuilder builder = new GsonBuilder().setPrettyPrinting();
                Gson gson = builder.create();

                if(file.exists()) {
                    //read file and write to array
                    com.google.gson.stream.JsonReader reader = new com.google.gson.stream.JsonReader(new FileReader(fileLocation));
                    JsonArray values = gson.fromJson(reader, new TypeToken<JsonArray>() {}.getType());

                    //check if mob is already on list
                    JsonElement jsonElement = new JsonPrimitive(event.getEntity().getEncodeId());
                    if(values.contains(jsonElement)){return true;}

                    values.add(event.getEntity().getEncodeId());

                    //write to file
                    FileWriter writer = new FileWriter(file);
                    gson.toJson(values, writer);
                    writer.close();
                } else {
                    //create dictionary if it doesn't exist already
                    new File("saves/"+worldData.getLevelName()+"/playerdata/nekromant/").mkdirs();

                    //add first killed mob to array which is later written to json
                    JsonArray values = new JsonArray();
                    values.add(event.getEntity().getEncodeId());

                    //write to file
                    FileWriter writer = new FileWriter(file);
                    gson.toJson(values, writer);
                    writer.close();
                }
            }
        }
        return true;
    }

}
