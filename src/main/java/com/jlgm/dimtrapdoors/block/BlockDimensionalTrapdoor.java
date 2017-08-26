package com.jlgm.dimtrapdoors.block;

import java.util.List;

import javax.annotation.Nullable;

import com.jlgm.dimtrapdoors.util.DimTrapdoorsTeleporter;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

public class BlockDimensionalTrapdoor extends Block{
	
	protected static final AxisAlignedBB END_PORTAL_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.75D, 1.0D);
	
	public BlockDimensionalTrapdoor(Material materialIn) {
		super(materialIn);
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
		return END_PORTAL_AABB;
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn, boolean p_185477_7_){
	}
	
	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks for render
	 */
	@Override
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state){
		return false;
	}
	
	/**
	 * Called When an Entity Collided with the Block
	 */
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (!entityIn.isRiding() && !entityIn.isBeingRidden() && entityIn.isNonBoss() && !worldIn.isRemote && entityIn.getEntityBoundingBox().intersects(state.getBoundingBox(worldIn, pos).offset(pos))){
			if(entityIn instanceof EntityPlayer) {
				DimTrapdoorsTeleporter.teleportToDimension((EntityPlayer) entityIn, 15, entityIn.posX, entityIn.posY, entityIn.posZ);
			}
		}
	}
}
