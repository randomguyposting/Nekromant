package Nekro.nekromant.registry;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import Nekro.nekromant.Nekromant;

public class NeBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Nekromant.MODID);

    public static final RegistryObject<Block> PURPLE_CHISELED_DUNGEON_BRICKS = BLOCKS.register("purple_chiseled_dungeon_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> PURPLE_DUNGEON_BRICKS = BLOCKS.register("purple_dungeon_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> PURPLE_CRACKED_DUNGEON_BRICKS = BLOCKS.register("purple_cracked_dungeon_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> PURPLE_MOSSY_DUNGEON_BRICKS = BLOCKS.register("purple_mossy_dungeon_bricks", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> PURPLE_DUNGEON_PILLAR = BLOCKS.register("purple_dungeon_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
}
