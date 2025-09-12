package atheant.skylanders.init;

import atheant.skylanders.SkylandersCrafted;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ItemsInit {

    //region Helper Method & Initializing
    // Initialize
    public static void initialize() {
        SkylandersCrafted.LOGGER.info("Initializing Items for " + SkylandersCrafted.MOD_ID);

        //TODO: Remove from here & add to custom Item Group Later
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(PORTELIUM_SHARD));
    }

    // Helper Method
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create Item Key
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SkylandersCrafted.MOD_ID, name));

        // Create Item Instance
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register Item
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }
    //endregion Helper Method & Initializing

    // ----------

    // Registering
    //region Portelium Items
    public static final Item PORTELIUM_SHARD = register("portelium_shard", Item::new, new Item.Settings());
    //endregion Portelium Items
}
