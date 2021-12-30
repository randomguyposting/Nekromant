package Nekro.nekromant.registry;

import Nekro.nekromant.Nekromant;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Nekromant.MODID);

    //Block items
    public static final RegistryObject<BlockItem> PURPLE_DUNGEON_BRICKS = ITEMS.register("purple_dungeon_bricks", () -> new BlockItem(NBlocks.PURPLE_DUNGEON_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
}
