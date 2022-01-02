package Nekro.nekromant.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class NeCreativeModeTab {
    public static final CreativeModeTab NEKROMANT_BLOCKS = new CreativeModeTab("NekromantBlocks") {


        @Override
        public ItemStack makeIcon() {
            return new ItemStack(NeItems.PURPLE_CHISELED_DUNGEON_BRICKS.get());
        }
    };

    public static final CreativeModeTab NEKROMANT_ITEMS = new CreativeModeTab("NekromantItems") {


        @Override
        public ItemStack makeIcon() {
            return new ItemStack(NeItems.MERCURY.get());
        }
    };

}
