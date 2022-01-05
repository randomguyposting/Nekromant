package Nekro.nekromant.registry;


import Nekro.nekromant.items.Extracter;
import net.minecraft.world.item.*;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import Nekro.nekromant.Nekromant;
import net.minecraftforge.registries.RegistryObject;

public class NeItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Nekromant.MODID);

    //purple dungeon bricks
    public static final RegistryObject<BlockItem> PURPLE_CHISELED_DUNGEON_BRICKS = ITEMS.register("purple_chiseled_dungeon_bricks", () -> new BlockItem(NeBlocks.PURPLE_CHISELED_DUNGEON_BRICKS.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));
    public static final RegistryObject<BlockItem> PURPLE_DUNGEON_BRICKS = ITEMS.register("purple_dungeon_bricks", () -> new BlockItem(NeBlocks.PURPLE_DUNGEON_BRICKS.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));
    public static final RegistryObject<BlockItem> PURPLE_CRACKED_DUNGEON_BRICKS = ITEMS.register("purple_cracked_dungeon_bricks", () -> new BlockItem(NeBlocks.PURPLE_CRACKED_DUNGEON_BRICKS.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));
    public static final RegistryObject<BlockItem> PURPLE_MOSSY_DUNGEON_BRICKS = ITEMS.register("purple_mossy_dungeon_bricks", () -> new BlockItem(NeBlocks.PURPLE_MOSSY_DUNGEON_BRICKS.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));
    public static final RegistryObject<BlockItem> PURPLE_DUNGEON_PILLAR = ITEMS.register("purple_dungeon_pillar", () -> new BlockItem(NeBlocks.PURPLE_DUNGEON_PILLAR.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));
    public static final RegistryObject<BlockItem> PURPLE_DUNGEON_BRICKS_SLAB = ITEMS.register("purple_dungeon_bricks_slab", () -> new BlockItem(NeBlocks.PURPLE_DUNGEON_BRICKS_SLAB.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));
    public static final RegistryObject<BlockItem> PURPLE_CHISELED_DUNGEON_BRICKS_SLAB = ITEMS.register("purple_chiseled_dungeon_bricks_slab", () -> new BlockItem(NeBlocks.PURPLE_CHISELED_DUNGEON_BRICKS_SLAB.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));
    public static final RegistryObject<BlockItem> PURPLE_DUNGEON_BRICKS_STAIRS = ITEMS.register("purple_dungeon_bricks_stairs", () -> new BlockItem(NeBlocks.PURPLE_DUNGEON_BRICKS_STAIRS.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));
    public static final RegistryObject<BlockItem> PURPLE_DUNGEON_BRICKS_FENCE = ITEMS.register("purple_dungeon_bricks_fence", () -> new BlockItem(NeBlocks.PURPLE_DUNGEON_BRICKS_FENCE.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));


    public static final RegistryObject<BlockItem> MERCURY_ORE = ITEMS.register("mercury_ore", () -> new BlockItem(NeBlocks.MERCURY_ORE.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));

    //items
    public static final RegistryObject<Item> MERCURY = ITEMS.register("mercury",() -> new Item(new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_ITEMS)));
    public static final RegistryObject<Item> EXTRACTER = ITEMS.register("extracter",() -> new Extracter());
    public static final RegistryObject<BlockItem> DEEPRACK = ITEMS.register("deeprack", () -> new BlockItem(NeBlocks.DEEPRACK.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));
    public static final RegistryObject<BlockItem> DEEP_GRANITE = ITEMS.register("deep_granite", () -> new BlockItem(NeBlocks.DEEP_GRANITE.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));
    public static final RegistryObject<BlockItem> BURNT_GRANITE = ITEMS.register("burnt_granite", () -> new BlockItem(NeBlocks.BURNT_GRANITE.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));


    public static final RegistryObject<Item> BLOOD_DROP = ITEMS.register("blood_drop", () -> new Item(new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_ITEMS)));

    //blood blocks
    public static final RegistryObject<BlockItem> BLOOD_LANTERN = ITEMS.register("blood_lantern", () -> new BlockItem(NeBlocks.BLOOD_LANTERN.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));
    public static final RegistryObject<BlockItem> BLOOD_CANDLE_BLACK = ITEMS.register("blood_candle_black", () -> new BlockItem(NeBlocks.BLOOD_CANDLE_BLACK.get(), new Item.Properties().tab(NeCreativeModeTab.NEKROMANT_BLOCKS)));

}

