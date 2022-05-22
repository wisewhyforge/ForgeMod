package com.example.examplemod.blocks;

import java.util.function.Function;
import java.util.function.Supplier;

import com.example.examplemod.ModStrings;
import com.example.examplemod.items.HaloBlockItem;
import com.example.examplemod.items.ItemInit;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
	
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModStrings.MODID);

	public static final RegistryObject<Block> HALO = register("halo", 
			  () -> new Block(BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.SAND).strength(3, 100).requiresCorrectToolForDrops()),
			  object -> () -> new HaloBlockItem(object.get(), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS).fireResistant())); 

	
	private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
    	return BLOCKS.register(name, block);
    }
    
    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Supplier<? extends Item>> item) {
    	RegistryObject<T> obj = registerBlock(name, block);
    	ItemInit.getRegistry().register(name, item.apply(obj));
    	return obj;
    }
    
    public static DeferredRegister<Block> getRegistry() {
    	return BLOCKS;
    }
	
}
