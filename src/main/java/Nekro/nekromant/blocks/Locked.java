package Nekro.nekromant.blocks;

import Nekro.nekromant.registry.NeItems;
import Nekro.nekromant.registry.NeTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockState;

public class Locked {
        public static boolean isMatch(BlockState blockState, Item item) {
            if (NeTags.Blocks.CRIPPLING_KEY.contains(blockState.getBlock()) && item == NeItems.CRIPPLING_KEY.get()) {
                return true;
            }

            return false;
        }

        public static boolean isKey(Item item) {
            return NeTags.Items.KEYS.contains(item);
        }
}
