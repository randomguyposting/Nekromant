package Nekro.nekromant.registry;


import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import Nekro.nekromant.Nekromant;
import net.minecraftforge.registries.RegistryObject;

public class NeItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Nekromant.MODID);

    public static final RegistryObject<BlockItem> PURPLE_CHISELED_DUNGEON_BRICKS = ITEMS.register("purple_chiseled_dungeon_bricks", () -> new BlockItem(NeBlocks.PURPLE_CHISELED_DUNGEON_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
}

