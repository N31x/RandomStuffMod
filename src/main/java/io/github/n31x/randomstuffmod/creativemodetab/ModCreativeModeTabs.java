package io.github.n31x.randomstuffmod.creativemodetab;

import io.github.n31x.randomstuffmod.RandomStuffMod;
import io.github.n31x.randomstuffmod.block.ModBlocks;
import io.github.n31x.randomstuffmod.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RandomStuffMod.MOD_ID);

    public static final Supplier<CreativeModeTab> RANDOMSTUFFMOD_ITEMS_TAB = CREATIVE_MODE_TABS.register("randomstuffmod_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LEAD_INGOT.get()))
                    .title(Component.translatable("creativetab.randomstuffmod.items"))
                    .withTabsAfter(Identifier.fromNamespaceAndPath(RandomStuffMod.MOD_ID, "randomstuffmod_blocks_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LEAD_INGOT);
                    }).build());

    public static final Supplier<CreativeModeTab> RANDOMSTUFFMOD_BLOCKS_TAB = CREATIVE_MODE_TABS.register("randomstuffmod_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.RAW_LEAD_BLOCk.get()))
                    .title(Component.translatable("creativetab.randomstuffmod.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.RAW_LEAD_BLOCk);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
