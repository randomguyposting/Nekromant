package Nekro.nekromant.registry;

import Nekro.nekromant.Nekromant;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;

public class NeTags {
    public static class Blocks {

        private static Tag.Named<Block> tag (String name){
            return BlockTags.bind(new ResourceLocation(Nekromant.MODID, name).toString());
        }

        public static final Tag.Named<Block> CRIPPLING_KEY = tag("crippling_key");
    }

}
