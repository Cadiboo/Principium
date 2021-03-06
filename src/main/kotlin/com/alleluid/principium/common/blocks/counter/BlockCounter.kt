package com.alleluid.principium.common.blocks.counter

import com.alleluid.principium.Utils
import com.alleluid.principium.common.blocks.BaseTileEntity
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.EnumHand
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

object BlockCounter : BaseTileEntity<TileEntityCounter>(Material.ROCK, "counter") {

    override fun onBlockActivated(worldIn: World, pos: BlockPos, state: IBlockState, playerIn: EntityPlayer, hand: EnumHand, facing: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean {
        if (!worldIn.isRemote) {
            val tile: TileEntityCounter = this.getTileEntity(worldIn, pos)
            if (facing == EnumFacing.DOWN) {
                tile.count--
            } else if (facing == EnumFacing.UP) {
                tile.count++
            }
            Utils.statusMessage("Count: ${tile.count}")
        }
        return true
    }

    override val tileEntityClass: Class<TileEntityCounter>
        get() = TileEntityCounter::class.java

    override fun createTileEntity(world: World, state: IBlockState): TileEntityCounter? = TileEntityCounter()
}