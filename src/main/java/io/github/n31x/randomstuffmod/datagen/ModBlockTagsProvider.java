package io.github.n31x.randomstuffmod.datagen;

import io.github.n31x.randomstuffmod.RandomStuffMod;
import io.github.n31x.randomstuffmod.block.ModBlocks;
import io.github.n31x.randomstuffmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, RandomStuffMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.RAW_LEAD_BLOCK.get())
                .add(ModBlocks.LEAD_ORE.get())
                .add(ModBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(ModBlocks.NETHER_COAL_BLOCK.get())
                .add(ModBlocks.NETHER_COAL_ORE.get())
                .add(ModBlocks.LEAD_STAIRS.get())
                .add(ModBlocks.LEAD_SLAB.get())
                .add(ModBlocks.LEAD_BLOCK.get())
                .add(ModBlocks.LEAD_FENCE.get())
                .add(ModBlocks.LEAD_FENCE_GATE.get())
                .add(ModBlocks.LEAD_WALL.get())
                .add(ModBlocks.LEAD_DOOR.get())
                .add(ModBlocks.LEAD_TRAPDOOR.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.RAW_LEAD_BLOCK.get())
                .add(ModBlocks.NETHER_COAL_BLOCK.get())
                .add(ModBlocks.LEAD_SLAB.get())
                .add(ModBlocks.LEAD_BLOCK.get())
                .add(ModBlocks.LEAD_FENCE.get())
                .add(ModBlocks.LEAD_FENCE_GATE.get())
                .add(ModBlocks.LEAD_WALL.get())
                .add(ModBlocks.LEAD_DOOR.get())
                .add(ModBlocks.LEAD_TRAPDOOR.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LEAD_ORE.get())
                .add(ModBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(ModBlocks.NETHER_COAL_ORE.get())
                .add(ModBlocks.LEAD_BLOCK.get());

        tag(ModTags.Blocks.METAL_DETECTABLES)
                .addTag(Tags.Blocks.ORES)
                .add(ModBlocks.LEAD_ORE.get())
                .add(ModBlocks.DEEPSLATE_LEAD_ORE.get());

        tag(BlockTags.STAIRS)
                .add(ModBlocks.LEAD_STAIRS.get());
        tag(BlockTags.SLABS)
                .add(ModBlocks.LEAD_SLAB.get());
        tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.LEAD_PRESSURE_PLATE.get());
        tag(BlockTags.BUTTONS)
                .add(ModBlocks.LEAD_BUTTON.get());
        tag(BlockTags.FENCES)
                .add(ModBlocks.LEAD_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.LEAD_FENCE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.LEAD_WALL.get());
        tag(BlockTags.DOORS)
                .add(ModBlocks.LEAD_DOOR.get());
        tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.LEAD_TRAPDOOR.get());

        tag(ModTags.Blocks.NEEDS_LEAD_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        tag(ModTags.Blocks.INCORRECT_FOR_LEAD_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_LEAD_TOOL);
    }
}
