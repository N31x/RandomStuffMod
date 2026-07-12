package io.github.n31x.randomstuffmod.datagen;

import io.github.n31x.randomstuffmod.block.ModBlocks;
import io.github.n31x.randomstuffmod.item.ModItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.RAW_LEAD_BLOCK.get());
        dropSelf(ModBlocks.MAGIC_BLOCK.get());
        dropSelf(ModBlocks.NETHER_COAL_BLOCK.get());
        dropSelf(ModBlocks.LEAD_STAIRS.get());
        dropSelf(ModBlocks.LEAD_BLOCK.get());

        add(ModBlocks.LEAD_ORE.get(),
                createOreDrop(ModBlocks.LEAD_ORE.get(), ModItems.RAW_LEAD.get()));
        add(ModBlocks.DEEPSLATE_LEAD_ORE.get(),
                createOreDrop(ModBlocks.DEEPSLATE_LEAD_ORE.get(), ModItems.RAW_LEAD.get()));
        add(ModBlocks.NETHER_COAL_ORE.get(),
                createOreDrop(ModBlocks.NETHER_COAL_ORE.get(), ModItems.NETHER_COAL.get()));

        add(ModBlocks.LEAD_SLAB.get(), this::createSlabItemTable);

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
