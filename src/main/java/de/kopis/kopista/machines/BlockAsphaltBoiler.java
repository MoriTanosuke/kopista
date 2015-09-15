package de.kopis.kopista.machines;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockAsphaltBoiler extends BlockContainer {
    protected BlockAsphaltBoiler(Material material) {
        super(material);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityAsphaltBoiler();
    }
}
