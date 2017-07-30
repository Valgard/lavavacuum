package com.trontheim.lavavacuum.init;

import com.trontheim.lavavacuum.LavaVacuum;
import com.trontheim.lavavacuum.item.ItemLavaVacuum;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.launchwrapper.Launch;

public class LVItems {

  public static Item lavaVacuum;

  private static final boolean developmentEnvironment = (Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");

  public static void registerItems() {
    lavaVacuum = GameRegistry.registerItem(new ItemLavaVacuum(), "lavaVacuum", LavaVacuum.MODID);
  }

  public static boolean isDevelopmentEnvironment() {
    return developmentEnvironment;
  }

}
