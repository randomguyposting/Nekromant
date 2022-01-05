package Nekro.nekromant.events.loot;

import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.common.util.JsonUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import javax.annotation.Nonnull;
import java.util.List;
import Nekro.nekromant.registry.*;

public class ZombieAdditionModifier extends LootModifier {
        private final Item addition;


    protected ZombieAdditionModifier(LootItemCondition[] conditions, Item addition) {
        super(conditions);
        this.addition = addition;
    }

    @Nonnull
        @Override
        protected List<ItemStack> doApply(List<ItemStack> generatedLoot, LootContext context) {
                    generatedLoot.add(new ItemStack( addition,1));
            return generatedLoot;
        }

        public static class Serializer extends GlobalLootModifierSerializer<ZombieAdditionModifier> {

            @Override
            public ZombieAdditionModifier read(ResourceLocation name, JsonObject object, LootItemCondition[] conditions) {
                Item addition = ForgeRegistries.ITEMS.getValue(new ResourceLocation(GsonHelper.getAsString(object, "addition")));
                return new ZombieAdditionModifier(conditions, addition);
            }

            @Override
            public JsonObject write(ZombieAdditionModifier instance) {
                JsonObject json = makeConditions(instance.conditions);
                json.addProperty("addition",ForgeRegistries.ITEMS.getKey(instance.addition).toString());
                return json;
            }
        }
}
