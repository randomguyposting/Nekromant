package Nekro.nekromant.registry;


import net.minecraft.ChatFormatting;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import Nekro.nekromant.Nekromant;
import net.minecraftforge.registries.RegistryObject;

public class UGItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Nekromant.MODID);

    public static final Rarity FORGOTTEN = Rarity.create("forgotten", ChatFormatting.GREEN);

    public static final RegistryObject<BlockItem> PURPLE_CHISELED_DUNGEON_BRICKS = ITEMS.register("purple_chiseled_dungeon_bricks", () -> new BlockItem(UGBlocks.PURPLE_CHISELED_DUNGEON_BRICKS.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
}

