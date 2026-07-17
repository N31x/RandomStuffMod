package io.github.n31x.randomstuffmod.item;

import com.google.common.collect.Maps;
import io.github.n31x.randomstuffmod.RandomStuffMod;
import io.github.n31x.randomstuffmod.tags.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

import java.util.Map;

public class ModArmorMaterials {
    public static final ResourceKey<EquipmentAsset> LEAD_KEY = ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(RandomStuffMod.MOD_ID,"lead"));

    public static final ArmorMaterial LEAD_ARMOR_MATERIAL = new ArmorMaterial(24, makeDefense(
            2, 5,7, 2, 8), 10, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.0F,
            ModTags.Items.LEAD_REPAIRABLE, LEAD_KEY);


    private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body));
    }
}
