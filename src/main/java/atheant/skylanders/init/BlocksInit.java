package atheant.skylanders.init;

import atheant.skylanders.SkylandersCrafted;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class BlocksInit {

    //region Helper Methods & Initializing
    // Initialize
    public static void initialize() {
        SkylandersCrafted.LOGGER.info("Initializing Blocks for " + SkylandersCrafted.MOD_ID);
    }

    // Helper Methods
    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory,
                                  AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create Block Key
        RegistryKey<Block> blockKey = keyOfBlock(name);

        // Create Block Instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(SkylandersCrafted.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SkylandersCrafted.MOD_ID, name));
    }
    //endregion Helper Method & Initializing

    // ----------

    // Registering
    //region Portelium Blocks
    public static final Block PORTELIUM_SHARD_BLOCK = register(
            "portelium_shard_block",
            Block::new,
            AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(2.5f)
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
            true
    );
    //endregion Portelium Blocks
}
