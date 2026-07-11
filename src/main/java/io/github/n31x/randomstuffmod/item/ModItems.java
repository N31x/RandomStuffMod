package io.github.n31x.randomstuffmod.item;

import io.github.n31x.randomstuffmod.RandomStuffMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(RandomStuffMod.MOD_ID);

    public static final DeferredItem<Item> LEAD_INGOT = ITEMS.registerSimpleItem("lead_ingot");
    public static final DeferredItem<Item> RAW_LEAD = ITEMS.registerSimpleItem("raw_lead");
    public static final DeferredItem<Item> LEAD_NUGGET = ITEMS.registerSimpleItem("lead_nugget");
    public static final DeferredItem<Item> RED_PAPER = ITEMS.registerSimpleItem("red_paper");



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
