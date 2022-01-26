package Nekro.nekromant.registry;

import Nekro.nekromant.Nekromant;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NeFluids{
        public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Nekromant.MODID);

        public static final RegistryObject<FlowingFluid> BLOOD_SOURCE = FLUIDS.register("blood_source", () -> new ForgeFlowingFluid.Source(NeFluids.BLOOD_PROPERTIES));
        public static final RegistryObject<FlowingFluid> BLOOD_FLOWING = FLUIDS.register("blood_flowing", () -> new ForgeFlowingFluid.Flowing(NeFluids.BLOOD_PROPERTIES));
        public static final ForgeFlowingFluid.Properties BLOOD_PROPERTIES = new ForgeFlowingFluid.Properties(BLOOD_SOURCE, BLOOD_FLOWING, FluidAttributes.builder(new ResourceLocation(Nekromant.MODID, "fluid/blood_still"), new ResourceLocation(Nekromant.MODID, "fluid/blood_flow"))).bucket(NeItems.BLOOD_BUCKET).block(NeBlocks.BLOOD);
}
