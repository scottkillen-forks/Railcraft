package mods.railcraft.common.blocks.multi;

import mods.railcraft.client.util.textures.TextureAtlasSheet;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.Tuple;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 *
 */
public class BlockCokeOven extends BlockMultiBlockInventory {

    public static final PropertyInteger ICON = PropertyInteger.create("icon", 0, 2);

    public BlockCokeOven() {
        super(Material.ROCK);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, ICON);
    }

    @Override
    public TileMultiBlockInventory createTileEntity(World world, IBlockState state) {
        return new TileCokeOven();
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Class<TileCokeOven> getTileClass(IBlockState state) {
        return TileCokeOven.class;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerTextures(TextureMap textureMap) {
        TextureAtlasSheet.unstitchIcons(textureMap, getBlockTexture(), getTextureDimensions());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Tuple<Integer, Integer> getTextureDimensions() {
        return new Tuple<>(3, 1);
    }
}
