package atheant.skylanders.init;

import atheant.skylanders.SkylandersCrafted;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroupsInit {

    //region Initializing
    // Initialize
    public static void initialize() {
        SkylandersCrafted.LOGGER.info("Initializing Item Groups for " + SkylandersCrafted.MOD_ID);

        // Portelium Ingredients
        Registry.register(Registries.ITEM_GROUP, PORTELIUM_INGREDIENTS_KEY, PORTELIUM_INGREDIENTS);
        ItemGroupEvents.modifyEntriesEvent(PORTELIUM_INGREDIENTS_KEY).register(itemGroup -> {
            itemGroup.add(ItemsInit.PORTELIUM_SHARD);
            itemGroup.add(BlocksInit.PORTELIUM_SHARD_BLOCK);
        });
    }
    //endregion Helper Methods & Initializing

    // ----------

    // Registering
    public static final RegistryKey<ItemGroup> PORTELIUM_INGREDIENTS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(),
            Identifier.of(SkylandersCrafted.MOD_ID, "portelium_ingredients"));
    public static final ItemGroup PORTELIUM_INGREDIENTS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ItemsInit.PORTELIUM_SHARD))
            .displayName(Text.translatable("itemGroup.portelium_ingredients"))
            .build();
}
