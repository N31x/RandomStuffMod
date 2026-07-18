package io.github.n31x.randomstuffmod.item.custom;

import io.github.n31x.randomstuffmod.data.ModDataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.Consumer;

public class DataTabletItem extends Item {
    public DataTabletItem(Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        if(player.getItemInHand(hand).has(ModDataComponents.COORDINATES) && player.isShiftKeyDown()) {
            player.getItemInHand(hand).remove(ModDataComponents.COORDINATES);
            player.getItemInHand(hand).remove(ModDataComponents.BLOCK);
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.PASS;
    }

    @Override
    public boolean isFoil(ItemStack itemStack) {
        return itemStack.has(ModDataComponents.COORDINATES);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
        if(itemStack.has(ModDataComponents.COORDINATES)) {
            BlockPos pos = itemStack.get(ModDataComponents.COORDINATES);
            BlockState block = itemStack.get(ModDataComponents.BLOCK);
            builder.accept(Component.literal("Block: ").append(block.getBlock().getName()
                    .append(Component.literal(" found at (" + pos.getX() + " , " + pos.getY() + " , " + pos.getZ() + ")"))));
        }
    }
}
