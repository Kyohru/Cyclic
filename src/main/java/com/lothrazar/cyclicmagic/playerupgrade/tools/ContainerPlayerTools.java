/*******************************************************************************
 * The MIT License (MIT)
 * 
 * Copyright (C) 2014-2018 Sam Bassett (aka Lothrazar)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 ******************************************************************************/
package com.lothrazar.cyclicmagic.playerupgrade.tools;

import com.lothrazar.cyclicmagic.gui.core.ContainerBase;
import com.lothrazar.cyclicmagic.playerupgrade.storage.InventoryPlayerExtended;
import com.lothrazar.cyclicmagic.util.Const;
import com.lothrazar.cyclicmagic.util.UtilPlayerInventoryFilestorage;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;

public class ContainerPlayerTools extends ContainerBase {

  private InventoryPlayerExtended inventory;
  public static final int SQ = Const.SQ;
  public static final int HOTBAR_SIZE = Const.HOTBAR_SIZE;
  final int pad = Const.PAD;
  private EntityPlayer player;

  public ContainerPlayerTools(InventoryPlayer playerInv, InventoryPlayerExtended eInvo, EntityPlayer player) {
    this.player = player;
    eInvo.setEventHandler(this);
    //        if (player.getEntityWorld().isRemote == false) {
    //if serverside  
      UtilPlayerInventoryFilestorage.putDataIntoInventory(eInvo, player);

      this.detectAndSendChanges();
      //
    //        }
    setInventory(eInvo);
    UtilPlayerInventoryFilestorage.setPlayerInventory(player, inventory);
    if (player.getEntityWorld().isRemote == false) {
    int size = InventoryPlayerExtended.ICOL * InventoryPlayerExtended.IROW + 20;//+20 somehow magically fixes bottom row
    for (int a = 0; a < size; a++) {
      System.out.println(a + " SYNC" + inventory.getStackInSlot(a));
      inventory.syncSlotToClients(a);
    }
    }
  }

  public void setInventory(InventoryPlayerExtended inv) {
    inventory = inv;
  }

  public EntityPlayer getPlayer() {
    return player;
  }

  public InventoryPlayerExtended getInv() {
    return inventory;
  }
}
