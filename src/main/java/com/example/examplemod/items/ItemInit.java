package com.example.examplemod.items;

import com.example.examplemod.ModStrings;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModStrings.MODID);    
	   
    
    public static final RegistryObject<Item> HACK = ITEMS.register("hack", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC).fireResistant().food((new FoodProperties.Builder()).nutrition(10).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.LUCK, 10000, 255), 1.0F).build())));
    
    public static DeferredRegister<Item> getRegistry() {
    	return ITEMS;
    }
}
