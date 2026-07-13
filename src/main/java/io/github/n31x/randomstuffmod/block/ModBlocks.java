package io.github.n31x.randomstuffmod.block;

import io.github.n31x.randomstuffmod.RandomStuffMod;
import io.github.n31x.randomstuffmod.block.custom.MagicBlock;
import io.github.n31x.randomstuffmod.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;
import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(RandomStuffMod.MOD_ID);

    public static final DeferredBlock<Block> RAW_LEAD_BLOCK = registerBlock("raw_lead_block",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.IRON)));

    public static final DeferredBlock<Block> LEAD_ORE = registerBlock("lead_ore",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            properties -> new Block(properties.strength(4f)
                    .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final DeferredBlock<Block> MAGIC_BLOCK = registerBlock("magic_block",
            properties -> new MagicBlock(properties.strength(2f)
                    .sound(SoundType.AMETHYST)), Component.translatable("tooltip.randomstuffmod.magic_block"));

    public static final DeferredBlock<Block> NETHER_COAL_BLOCK = registerFireResistantBlock("nether_coal_block",
            properties -> new Block(properties.strength(3f)
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> NETHER_COAL_ORE = registerBlock("nether_coal_ore",
            properties -> new Block(properties.strength(3f)
                    .sound(SoundType.NETHER_ORE)));

    public static final DeferredBlock<Block> LEAD_BLOCK = registerBlock("lead_block",
            properties -> new Block(properties.strength(4f).requiresCorrectToolForDrops()
                    .sound(SoundType.IRON)));

    public static final DeferredBlock<Block> LEAD_STAIRS = registerBlock("lead_stairs",
            properties -> new StairBlock(ModBlocks.LEAD_BLOCK.get().defaultBlockState(), properties
                    .strength(3f).requiresCorrectToolForDrops()
                    .sound(SoundType.IRON)));

    public static final DeferredBlock<Block> LEAD_SLAB = registerBlock("lead_slab",
            properties -> new SlabBlock(properties
                    .strength(3f).requiresCorrectToolForDrops()
                    .sound(SoundType.IRON)));

    public static final DeferredBlock<Block> LEAD_PRESSURE_PLATE = registerBlock("lead_pressure_plate",
            properties -> new PressurePlateBlock(BlockSetType.IRON, properties
                    .strength(0.5f)
                    .noCollision().forceSolidOn().pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.IRON)));

    public static final DeferredBlock<Block> LEAD_BUTTON = registerBlock("lead_button",
            properties -> new ButtonBlock(BlockSetType.IRON, 20, properties
                    .strength(0.5f)
                    .noCollision().pushReaction(PushReaction.DESTROY)
                    .sound(SoundType.IRON)));




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, (properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix())));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function, Component... components) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn, components);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block, Component... components) {
        ModItems.ITEMS.registerItem(name, (properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()) {
            @Override
            public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                for(var component : components) {
                    builder.accept(component);
                }
                super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
            }
        }));
    }

    private static <T extends Block> DeferredBlock<T> registerFireResistantBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerFireResistantBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerFireResistantBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, (properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix().fireResistant())));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
