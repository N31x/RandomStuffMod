package io.github.n31x.randomstuffmod.datagen;

import io.github.n31x.randomstuffmod.RandomStuffMod;
import io.github.n31x.randomstuffmod.item.ModItems;
import io.github.n31x.randomstuffmod.tags.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.levelgen.RandomSupport;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, RandomStuffMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.IRON_INGOT)
                .add(ModItems.LEAD_INGOT.get());

        tag(ModTags.Items.LEAD_REPAIRABLE)
                .add(ModItems.LEAD_INGOT.get());

        tag(ItemTags.SWORDS)
                .add(ModItems.LEAD_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.LEAD_PICKAXE.get());
        tag(ItemTags.AXES)
                .add(ModItems.LEAD_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.LEAD_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.LEAD_HOE.get());
        tag(ItemTags.SPEARS)
                .add(ModItems.LEAD_SPEAR.get());

        tag(ItemTags.HEAD_ARMOR)
                .add(ModItems.LEAD_HELMET.get());
        tag(ItemTags.CHEST_ARMOR)
                .add(ModItems.LEAD_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR)
                .add(ModItems.LEAD_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR)
                .add(ModItems.LEAD_BOOTS.get());
    }
}
