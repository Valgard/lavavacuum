package com.trontheim.lavavacuum;

import com.trontheim.lavavacuum.common.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.InstanceFactory;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
  modid = LavaVacuum.MODID,
  name = LavaVacuum.NAME,
  version = LavaVacuum.VERSION,
  acceptedMinecraftVersions = LavaVacuum.MCVERSION
  // updateJSON = "http://minecraft.valgard-lp.de"
)
public class LavaVacuum {

  public static final String MODID = "lavavacuum";
  public static final String NAME = "Lava Vacuum";
  public static final String VERSION = "0.0.3-alpha";
  public static final String MCVERSION = "[1.7.10]";

  private static final Logger logger = LogManager.getLogger(MODID);

  @SidedProxy(
    clientSide = "com.trontheim.lavavacuum.client.proxy.ClientProxy",
    serverSide = "com.trontheim.lavavacuum.server.proxy.ServerProxy"
  )
  public static CommonProxy proxy;

  private static LavaVacuum instance = new LavaVacuum();

  @InstanceFactory
  public static LavaVacuum instance() {
    return instance;
  }

  @EventHandler
  public void preinit(FMLPreInitializationEvent event) {
    proxy.preInit(event);
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
    proxy.init(event);
  }

  @EventHandler
  public void postinit(FMLPostInitializationEvent event) {
    proxy.postInit(event);
  }

}
