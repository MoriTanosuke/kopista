package com.example.examplemod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class AsphaltOre extends GenericBlock {

    public static final String NAME = "asphaltOre";

    public AsphaltOre() {
        super(Material.rock);
        setHardness(0.5F);
        setStepSound(Block.soundTypeStone);
        setUnlocalizedName(NAME);
        setCreativeTab(CreativeTabs.tabBlock);
    }
    

}
