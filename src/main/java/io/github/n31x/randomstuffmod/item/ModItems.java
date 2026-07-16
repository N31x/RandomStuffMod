package io.github.n31x.randomstuffmod.item;

import io.github.n31x.randomstuffmod.RandomStuffMod;
import io.github.n31x.randomstuffmod.food.ModFoods;
import io.github.n31x.randomstuffmod.item.custom.MetalDetectorItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Consumer;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RandomStuffMod.MOD_ID);

    public static final DeferredItem<Item> LEAD_INGOT = ITEMS.registerSimpleItem("lead_ingot");
    public static final DeferredItem<Item> RAW_LEAD = ITEMS.registerSimpleItem("raw_lead");
    public static final DeferredItem<Item> LEAD_NUGGET = ITEMS.registerSimpleItem("lead_nugget");
    public static final DeferredItem<Item> RED_PAPER = ITEMS.registerSimpleItem("red_paper");
    public static final DeferredItem<Item> WRAPPING_PAPER = ITEMS.registerSimpleItem("wrapping_paper");

    public static final DeferredItem<Item> METAL_DETECTOR = ITEMS.registerItem("metal_detector",
            properties -> new MetalDetectorItem(properties.durability(64)));

    public static final DeferredItem<Item> CORN = ITEMS.registerItem("corn",
            properties -> new Item(properties.food(ModFoods.CORN, ModFoods.CORN_CONSUMABLE)) {
                @Override
                public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag) {
                    builder.accept(Component.translatable("tooltip.randomstuffmod.corn"));
                    super.appendHoverText(itemStack, context, display, builder, tooltipFlag);
                }
            });

    public static final DeferredItem<Item> NETHER_COAL = ITEMS.registerItem("nether_coal",
            properties -> new Item(properties.fireResistant()));

    public static final DeferredItem<Item> LEAD_SWORD = ITEMS.registerItem("lead_sword",
            properties -> new Item(properties.sword(ModToolTiers.LEAD, 3.0f, -2.4f)));
    public static final DeferredItem<Item> LEAD_PICKAXE = ITEMS.registerItem("lead_pickaxe",
            properties -> new Item(properties.pickaxe(ModToolTiers.LEAD, 1.0f, -2.8f)));
    public static final DeferredItem<Item> LEAD_AXE = ITEMS.registerItem("lead_axe",
            properties -> new AxeItem(ModToolTiers.LEAD, 5.5f, -3.05f, properties));
    public static final DeferredItem<Item> LEAD_SHOVEL = ITEMS.registerItem("lead_shovel",
            properties -> new ShovelItem(ModToolTiers.LEAD, 1.5f, -3.0f, properties));
    public static final DeferredItem<Item> LEAD_HOE = ITEMS.registerItem("lead_hoe",
            properties -> new HoeItem(ModToolTiers.LEAD, -2.5f, -0.5f, properties));
    public static final DeferredItem<Item> LEAD_SPEAR = ITEMS.registerItem("lead_spear",
            properties -> new Item(properties.spear(ModToolTiers.LEAD, 1.0f, 1.025f, 0.55f,
                    2.5f, 10.5f, 6.6f, 5.1f, 10.5f, 4.6f)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
