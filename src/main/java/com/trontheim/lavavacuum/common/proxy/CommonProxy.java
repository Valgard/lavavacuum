package com.trontheim.lavavacuum.common.proxy;

import com.trontheim.lavavacuum.init.LVItems;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

abstract public class CommonProxy {

  public void preInit(FMLPreInitializationEvent event) {
    LVItems.registerItems();
  }

  public void init(FMLInitializationEvent event) {
  }

  public void postInit(FMLPostInitializationEvent event) {
  }

}
