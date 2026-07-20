package io.github.n31x.randomstuffmod.datagen;

import io.github.n31x.randomstuffmod.RandomStuffMod;
import io.github.n31x.randomstuffmod.RandomStuffModDataGen;
import io.github.n31x.randomstuffmod.block.ModBlocks;
import io.github.n31x.randomstuffmod.block.custom.LeadLampBlock;
import io.github.n31x.randomstuffmod.data.ModDataComponents;
import io.github.n31x.randomstuffmod.item.ModArmorMaterials;
import io.github.n31x.randomstuffmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.renderer.item.ConditionalItemModel;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.renderer.item.properties.conditional.HasComponent;
import net.minecraft.data.PackOutput;

import java.util.Optional;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, RandomStuffMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.LEAD_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RAW_LEAD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.LEAD_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.RED_PAPER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.METAL_DETECTOR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.CORN.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.NETHER_COAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.WRAPPING_PAPER.get(), ModelTemplates.FLAT_ITEM);

        itemModels.generateFlatItem(ModItems.LEAD_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.LEAD_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.LEAD_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.LEAD_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.LEAD_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateSpear(ModItems.LEAD_SPEAR.get());

        itemModels.generateTrimmableItem(ModItems.LEAD_HELMET.get(), ModArmorMaterials.LEAD_KEY, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModels.generateTrimmableItem(ModItems.LEAD_CHESTPLATE.get(), ModArmorMaterials.LEAD_KEY, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModels.generateTrimmableItem(ModItems.LEAD_LEGGINGS.get(), ModArmorMaterials.LEAD_KEY, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModels.generateTrimmableItem(ModItems.LEAD_BOOTS.get(), ModArmorMaterials.LEAD_KEY, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        itemModels.generateFlatItem(ModItems.LEAD_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);

        ItemModel.Unbaked unbakedDataTablet = ItemModelUtils.plainModel(itemModels.createFlatItemModel(ModItems.DATA_TABLET.get(), ModelTemplates.FLAT_ITEM));
        ItemModel.Unbaked unbakedDataTabletOn = ItemModelUtils.plainModel(itemModels.createFlatItemModel(ModItems.DATA_TABLET.get(), "_on", ModelTemplates.FLAT_ITEM));
        itemModels.itemModelOutput.register(ModItems.DATA_TABLET.get(),
                new ClientItem(new ConditionalItemModel.Unbaked(Optional.empty(), new HasComponent(ModDataComponents.COORDINATES.get(), false),
                        unbakedDataTabletOn, unbakedDataTablet), new ClientItem.Properties(false, false, 1f)));

        itemModels.createFlatItemModel(ModItems.LEAD_BOW.get(), ModelTemplates.BOW);
        itemModels.generateBow(ModItems.LEAD_BOW.get());


        /* BLOCKS */
        blockModels.createTrivialCube(ModBlocks.RAW_LEAD_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.LEAD_ORE.get());
        blockModels.createTrivialCube(ModBlocks.DEEPSLATE_LEAD_ORE.get());
        blockModels.createTrivialCube(ModBlocks.MAGIC_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.NETHER_COAL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.NETHER_COAL_ORE.get());

        blockModels.family(ModBlocks.LEAD_BLOCK.get())
                .stairs(ModBlocks.LEAD_STAIRS.get())
                .slab(ModBlocks.LEAD_SLAB.get())
                .pressurePlate(ModBlocks.LEAD_PRESSURE_PLATE.get())
                .button(ModBlocks.LEAD_BUTTON.get())
                .fence(ModBlocks.LEAD_FENCE.get())
                .fenceGate(ModBlocks.LEAD_FENCE_GATE.get())
                .wall(ModBlocks.LEAD_WALL.get())
                .door(ModBlocks.LEAD_DOOR.get())
                .trapdoor(ModBlocks.LEAD_TRAPDOOR.get());

        blockModels.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(ModBlocks.LEAD_LAMP.get()).with(BlockModelGenerators.createBooleanModelDispatch(LeadLampBlock.CLICKED,
                        BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(ModBlocks.LEAD_LAMP.get(), "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube)),
                        BlockModelGenerators.plainVariant(TexturedModel.CUBE.create(ModBlocks.LEAD_LAMP.get(), blockModels.modelOutput))
                        ))
        );
    }
}
