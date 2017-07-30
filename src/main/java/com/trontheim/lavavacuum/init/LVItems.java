package com.trontheim.lavavacuum.init;

import com.trontheim.lavavacuum.LavaVacuum;
import com.trontheim.lavavacuum.item.ItemLavaVacuum;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class LVItems {

  public static Item lavaVacuum;

  public static void registerItems() {
    lavaVacuum = GameRegistry.registerItem(new ItemLavaVacuum(), "lavaVacuum", LavaVacuum.MODID);
  }

  public static void registerRecipes() {
    GameRegistry.addRecipe(new ItemStack(LVItems.lavaVacuum), " b ", "i i", "iii", 'b', Items.bucket, 'i', Items.iron_ingot);
  }

}
