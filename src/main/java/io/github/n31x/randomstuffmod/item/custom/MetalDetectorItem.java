package io.github.n31x.randomstuffmod.item.custom;

import io.github.n31x.randomstuffmod.data.ModDataComponents;
import io.github.n31x.randomstuffmod.item.ModItems;
import io.github.n31x.randomstuffmod.tags.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.Tags;

import java.util.function.Consumer;

public class MetalDetectorItem extends Item {
    public MetalDetectorItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        BlockPos blockPos = context.getClickedPos();
        Player player = context.getPlayer();

        if(!level.isClientSide()) {
            boolean foundBlock = false;

            for(int i = 0; i <= blockPos.getY() + 64; i++) {
                BlockState blockState = level.getBlockState(blockPos.below(i));

                if(isValuableBlock(blockState)) {
                    outputValuableCoordinates(blockPos.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    level.playSound(null, blockPos, SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.BLOCKS, 1.5f, 1f);

                    spawnFoundParticles(level, blockPos, blockState);

                    addDataToDataTablet(player, blockPos.below(i), blockState);

                    break;
                }
            }
            context.getItemInHand().hurtAndBreak(1, player, context.getHand());

            if(!foundBlock) {
                outputValuableCoordinates(player);
            }
        }

        return InteractionResult.SUCCESS;
    }

    private void addDataToDataTablet(Player player, BlockPos pos, BlockState blockState) {
        int slotIndex = player.getInventory().findSlotMatchingItem(new ItemStack(ModItems.DATA_TABLET.get()));
        if(slotIndex == -1) {
            return;
        }
        ItemStack dataTablet = player.getInventory().getItem(slotIndex);
        dataTablet.set(ModDataComponents.COORDINATES, pos);
        dataTablet.set(ModDataComponents.BLOCK, blockState);
    }

    private void spawnFoundParticles(Level level, BlockPos blockPos, BlockState blockState) {
        for(int i = 0; i < 20; i++) {
            ServerLevel serverLevel = (ServerLevel) level;

            serverLevel.sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, blockState),
                    blockPos.getX() + 0.5d, blockPos.getY() + 1, blockPos.getZ() + 0.5d, 3,
                    Math.cos(i * 18) * 0.15d, 0.15d, Math.sin(i * 18) * 0.15d, 0.1);
        }
    }

    private void outputValuableCoordinates(Player player) {
        player.sendSystemMessage(Component.translatable("item.randomstuffmod.metal_detector.no_valuables"));
    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Valuables found at: ").append(block.getName()
                .append(Component.literal(" at (" + below.getX() + " , " + below.getY() + " , " + below.getZ() + ")"))));
    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.is(ModTags.Blocks.METAL_DETECTABLES);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if(Minecraft.getInstance().hasShiftDown()) {
            builder.accept(Component.translatable("tooltip.randomstuffmod.metal_detector.shift_down"));
        } else {
            builder.accept(Component.translatable("tooltip.randomstuffmod.metal_detector"));
        }
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
    }
}
