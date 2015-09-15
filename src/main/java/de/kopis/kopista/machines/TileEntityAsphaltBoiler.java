package de.kopis.kopista.machines;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;

public class TileEntityAsphaltBoiler extends TileEntity implements IInventory {
    private ItemStack[] inv;

    public TileEntityAsphaltBoiler() {
        inv = new ItemStack[1];
    }

    @Override
    public int getSizeInventory() {
        return inv.length;
    }

    @Override
    public ItemStack getStackInSlot(int i) {
        return inv[i];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amt) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            if (stack.stackSize <= amt) {
                setInventorySlotContents(slot, null);
            } else {
                stack = stack.splitStack(amt);
                if (stack.stackSize == 0) {
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inv[slot] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityPlayer) {
        BlockPos playerPosition = entityPlayer.getPosition();
        return worldObj.getTileEntity(playerPosition) == this &&
                entityPlayer.getDistanceSq(playerPosition.getX() + 0.5, playerPosition.getY() + 0.5, playerPosition.getZ() + 0.5) < 64;
    }

    @Override
    public void openInventory(EntityPlayer entityPlayer) {
        //TODO override this method?
    }

    @Override
    public void closeInventory(EntityPlayer entityPlayer) {
        //TODO override this method?
    }

    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemStack) {
        //TODO override this method?
        return false;
    }

    @Override
    public int getField(int i) {
        //TODO override this method?
        return 0;
    }

    @Override
    public void setField(int i, int i1) {
        //TODO override this method?

    }

    @Override
    public int getFieldCount() {
        //TODO override this method?
        return 0;
    }

    @Override
    public void clear() {
        //TODO override this method?

    }

    @Override
    public String getName() {
        //TODO override this method?
        return null;
    }

    @Override
    public boolean hasCustomName() {
        //TODO override this method?
        return false;
    }

    @Override
    public IChatComponent getDisplayName() {
        //TODO override this method?
        return null;
    }
}
