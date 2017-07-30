package com.trontheim.lavavacuum.item;

import com.trontheim.lavavacuum.LavaVacuum;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ItemLavaVacuum extends Item {

  public static final String NAME = "lavavacuum";

  private static final Logger logger = LogManager.getLogger(LavaVacuum.MODID);

  public ItemLavaVacuum() {
    super();
    setCreativeTab(CreativeTabs.tabTools);
    setUnlocalizedName(LavaVacuum.MODID + "." + NAME);
    setTextureName(LavaVacuum.MODID + ":" + NAME);
  }

  @Override
  public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

    MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);

    if(movingobjectposition == null) {
      return itemStack;
    } else {
      if(movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
        int i = movingobjectposition.blockX;
        int j = movingobjectposition.blockY;
        int k = movingobjectposition.blockZ;

        if(!world.canMineBlock(player, i, j, k)) {
          return itemStack;
        }

        if(!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, itemStack)) {
          return itemStack;
        }

        Material material = world.getBlock(i, j, k).getMaterial();
        int l = world.getBlockMetadata(i, j, k);

        if(material == Material.lava && l == 0) {
          world.setBlockToAir(i, j, k);
          return itemStack;
        }
      }
    }

    return itemStack;
  }

}
