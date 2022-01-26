package Nekro.nekromant.registry;

import Nekro.nekromant.blocks.BloodCandle;
import Nekro.nekromant.blocks.BloodLiquid;
import Nekro.nekromant.blocks.LockedDoor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.*;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import Nekro.nekromant.Nekromant;

import java.util.function.Function;
import java.util.function.Supplier;

public class NeBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Nekromant.MODID);

    //blood fluid block
    public static final RegistryObject<LiquidBlock> BLOOD = BLOCKS.register("blood", () -> new BloodLiquid(NeFluids.BLOOD_SOURCE, BlockBehaviour.Properties.of(Material.WATER)));

    //purple dungeon bricks
    public static final RegistryObject<Block> PURPLE_DUNGEON_BRICKS = BLOCKS.register("purple_dungeon_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).strength(0.5f, 6.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PURPLE_CHISELED_DUNGEON_BRICKS = BLOCKS.register("purple_chiseled_dungeon_bricks", () -> new Block(BlockBehaviour.Properties.copy(NeBlocks.PURPLE_DUNGEON_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_CRACKED_DUNGEON_BRICKS = BLOCKS.register("purple_cracked_dungeon_bricks", () -> new Block(BlockBehaviour.Properties.copy(NeBlocks.PURPLE_DUNGEON_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_MOSSY_DUNGEON_BRICKS = BLOCKS.register("purple_mossy_dungeon_bricks", () -> new Block(BlockBehaviour.Properties.copy(NeBlocks.PURPLE_DUNGEON_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_DUNGEON_PILLAR = BLOCKS.register("purple_dungeon_pillar", () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(NeBlocks.PURPLE_DUNGEON_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_DUNGEON_BRICKS_SLAB = BLOCKS.register("purple_dungeon_bricks_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(NeBlocks.PURPLE_DUNGEON_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_DUNGEON_BRICKS_STAIRS = BLOCKS.register("purple_dungeon_bricks_stairs", () -> new StairBlock(() -> PURPLE_DUNGEON_BRICKS.get().defaultBlockState() ,BlockBehaviour.Properties.copy(NeBlocks.PURPLE_DUNGEON_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_CHISELED_DUNGEON_BRICKS_SLAB = BLOCKS.register("purple_chiseled_dungeon_bricks_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(NeBlocks.PURPLE_DUNGEON_BRICKS.get())));
    public static final RegistryObject<Block> PURPLE_DUNGEON_BRICKS_FENCE = BLOCKS.register("purple_dungeon_bricks_fence", () -> new WallBlock(BlockBehaviour.Properties.copy(NeBlocks.PURPLE_DUNGEON_BRICKS.get())));
    public static final RegistryObject<Block> CRIPPLING_DOOR = BLOCKS.register("crippling_door", () -> new LockedDoor(BlockBehaviour.Properties.copy(NeBlocks.PURPLE_DUNGEON_BRICKS.get())));


    public static final RegistryObject<Block> MERCURY_ORE = BLOCKS.register("mercury_ore", () -> new OreBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_PINK).strength(0.5f, 6.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPRACK = BLOCKS.register("deeprack", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).strength(0.5f, 6.0f).sound(SoundType.AMETHYST).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEP_GRANITE = BLOCKS.register("deep_granite", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).strength(0.5f, 6.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BURNT_GRANITE = BLOCKS.register("burnt_granite", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_PINK).strength(0.5f, 6.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));


    //dungeon misc blocks
    public static final RegistryObject<Block> BLOOD_LANTERN = BLOCKS.register("blood_lantern", () -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED).strength(0.5f, 4.0f).sound(SoundType.LANTERN).lightLevel((state) -> 8)));
    public static final RegistryObject<Block> BLOOD_CANDLE_BLACK = BLOCKS.register("blood_candle_black", () -> new BloodCandle(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.SAND).noOcclusion().strength(0.1F).sound(SoundType.CANDLE).lightLevel(CandleBlock.LIGHT_EMISSION)));
    //public static final RegistryObject<Block> OPEN_BOOK = BLOCKS.register("open_book", () -> new OpenBook(BlockBehaviour.Properties.of(Material.BAMBOO, MaterialColor.COLOR_GRAY)));

}
