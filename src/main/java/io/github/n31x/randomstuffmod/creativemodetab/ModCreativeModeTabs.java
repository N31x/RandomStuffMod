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
                    .withTabsAfter(Identifier.fromNamespaceAndPath(RandomStuffMod.MOD_ID, "randomstuffmod_blocks_tab"),
                            Identifier.fromNamespaceAndPath(RandomStuffMod.MOD_ID, "randomstuffmod_combat_tab"),
                            Identifier.fromNamespaceAndPath(RandomStuffMod.MOD_ID, "randomstuffmod_tools_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LEAD_INGOT);
                        output.accept(ModItems.RAW_LEAD);
                        output.accept(ModItems.LEAD_NUGGET);
                        output.accept(ModItems.RED_PAPER);
                        output.accept(ModItems.METAL_DETECTOR);
                        output.accept(ModItems.CORN);
                        output.accept(ModItems.NETHER_COAL);
                        output.accept(ModItems.WRAPPING_PAPER);
                    }).build());

    public static final Supplier<CreativeModeTab> RANDOMSTUFFMOD_BLOCKS_TAB = CREATIVE_MODE_TABS.register("randomstuffmod_blocks_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.LEAD_BLOCK.get()))
                    .title(Component.translatable("creativetab.randomstuffmod.blocks"))
                    .withTabsAfter(Identifier.fromNamespaceAndPath(RandomStuffMod.MOD_ID, "randomstuffmod_combat_tab"),
                            Identifier.fromNamespaceAndPath(RandomStuffMod.MOD_ID, "randomstuffmod_tools_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.RAW_LEAD_BLOCK);
                        output.accept(ModBlocks.LEAD_ORE);
                        output.accept(ModBlocks.DEEPSLATE_LEAD_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                        output.accept(ModBlocks.NETHER_COAL_BLOCK);
                        output.accept(ModBlocks.NETHER_COAL_ORE);
                        output.accept(ModBlocks.LEAD_STAIRS);
                        output.accept(ModBlocks.LEAD_SLAB);
                        output.accept(ModBlocks.LEAD_BLOCK);
                        output.accept(ModBlocks.LEAD_PRESSURE_PLATE);
                        output.accept(ModBlocks.LEAD_BUTTON);
                        output.accept(ModBlocks.LEAD_FENCE);
                        output.accept(ModBlocks.LEAD_FENCE_GATE);
                        output.accept(ModBlocks.LEAD_WALL);
                        output.accept(ModBlocks.LEAD_DOOR);
                        output.accept(ModBlocks.LEAD_TRAPDOOR);
                    }).build());

    public static final Supplier<CreativeModeTab> RANDOMSTUFFMOD_COMBAT_TAB = CREATIVE_MODE_TABS.register("randomstuffmod_combat_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LEAD_SWORD.get()))
                    .title(Component.translatable("creativetab.randomstuffmod.combat"))
                    .withTabsAfter(Identifier.fromNamespaceAndPath(RandomStuffMod.MOD_ID, "randomstuffmod_tools_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LEAD_SWORD);
                        output.accept(ModItems.LEAD_SPEAR);
                    }).build());

    public static final Supplier<CreativeModeTab> RANDOMSTUFFMOD_TOOLS_TAB = CREATIVE_MODE_TABS.register("randomstuffmod_tools_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LEAD_PICKAXE.get()))
                    .title(Component.translatable("creativetab.randomstuffmod.tools"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.LEAD_PICKAXE);
                        output.accept(ModItems.LEAD_AXE);
                        output.accept(ModItems.LEAD_SHOVEL);
                        output.accept(ModItems.LEAD_HOE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
