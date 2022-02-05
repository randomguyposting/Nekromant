package Nekro.nekromant.registry;

import Nekro.nekromant.Nekromant;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NeBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, Nekromant.MODID);

    public static final RegistryObject<BlockEntityType<ChestBlockEntity>> PURPLE_BASKET = BLOCK_ENTITIES.register("purple_basket", () ->
            BlockEntityType.Builder.of(ChestBlockEntity::new, NeBlocks.PURPLE_BASKET.get()).build(null));
}
