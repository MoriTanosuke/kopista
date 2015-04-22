package de.kopis.kopista.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import de.kopis.kopista.KopistaMod;

public class GenericBlock extends Block {

    private String name;

    public GenericBlock(Material material, String name, float hardness, float resistance) {
        super(material);
        this.name = name;
        setHardness(hardness);
        setResistance(resistance);
        setStepSound(Block.soundTypeStone);
        setUnlocalizedName(this.name);
        setCreativeTab(CreativeTabs.tabBlock);
        setHarvestLevel(HarvestTool.Pickaxe.value(), HarvestLevel.Stone.value());
    }

    public String getName() {
        return name;
    }

    public String getTexture() {
        return KopistaMod.MODID + ":" + name;
    }

    protected enum HarvestTool {
        Axe("axe"), Shovel("shovel"), Pickaxe("pickaxe");

        private final String level;

        private HarvestTool(String level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return level;
        }

        public String value() {
            return level;
        }
    }

    protected enum HarvestLevel {
        Wood(0), Stone(1), Iron(2), Diamond(3), Gold(0);

        private final int level;

        private HarvestLevel(int level) {
            this.level = level;
        }

        @Override
        public String toString() {
            return Integer.toString(level);
        }

        public int value() {
            return level;
        }

    }
}
