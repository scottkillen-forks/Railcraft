/* 
 * Copyright (c) CovertJaguar, 2014 http://railcraft.info
 * 
 * This code is the property of CovertJaguar
 * and may only be used with explicit written
 * permission unless otherwise specified on the
 * license page at http://railcraft.info/wiki/info:license.
 */
package mods.railcraft.common.plugins.ic2;

import ic2.api.energy.tile.IMetaDelegate;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CovertJaguar <http://www.railcraft.info/>
 */
public class TileIC2MultiEmitterDelegate extends TileIC2SourceDelegate implements IMetaDelegate {

    private final IMultiEmitterDelegate delegate;
    private final List<TileEntity> subTiles = new ArrayList<TileEntity>(30);

    public TileIC2MultiEmitterDelegate(IMultiEmitterDelegate delegate) {
        super(delegate.getTile());
        this.delegate = delegate;
        subTiles.addAll(delegate.getSubTiles());
    }

    @Override
    public boolean emitsEnergyTo(TileEntity receiver, ForgeDirection direction) {
        return true;
    }

    @Override
    public double getOfferedEnergy() {
        return delegate.getOfferedEnergy();
    }

    @Override
    public void drawEnergy(double amount) {
        delegate.drawEnergy(amount);
    }

    @Override
    public List<TileEntity> getSubTiles() {
        return subTiles;
    }

    @Override
    public int getSourceTier() {
        return delegate.getSourceTier();
    }

}
