package com.jlgm.dimtrapdoors.util;

import javax.annotation.Nonnull;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.DimensionManager;

public class DimTrapdoorsTeleporter extends Teleporter {

    @SuppressWarnings("all")
    public DimTrapdoorsTeleporter(WorldServer world, double x, double y, double z) {
        super(world);
        this.worldServer = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private final WorldServer worldServer;
    private double x, y, z;

    @Override
    public void placeInPortal(@Nonnull Entity entity, float rotationYaw) {
        this.worldServer.getBlockState(new BlockPos((int) this.x, (int) this.y, (int) this.z));

        entity.setPosition(this.x, this.y, this.z);
        entity.motionX = 0.0f;
        entity.motionY = 0.0f;
        entity.motionZ = 0.0f;
    }

    public static void teleportToDimension(EntityPlayer player, int dimension, BlockPos pos){
        teleportToDimension(player, dimension, pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5);
    }

    @SuppressWarnings("all")
    public static void teleportToDimension(EntityPlayer player, int dimension, double x, double y, double z) {
        int oldDimension = DimTrapdoorsTeleporter.getDimID(player.getEntityWorld());
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
        MinecraftServer server = ((EntityPlayerMP) player).getEntityWorld().getMinecraftServer();
        WorldServer worldServer = server.getWorld(dimension);
        player.addExperienceLevel(0);

        if (worldServer == null || worldServer.getMinecraftServer() == null){ //Dimension doesn't exist
            throw new IllegalArgumentException("Dimension: "+dimension+" doesn't exist!");
        }

        worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, dimension, new DimTrapdoorsTeleporter(worldServer, x, y, z));
        player.setPositionAndUpdate(x, y, z);
        if (oldDimension == 1) {
            // For some reason teleporting out of the end does weird things.
            player.setPositionAndUpdate(x, y, z);
            DimTrapdoorsTeleporter.spawnEntityInWorld(worldServer, player);
            worldServer.updateEntityWithOptionalForce(player, false);
        }
    }
    
    @SuppressWarnings("all")
    public static int getDimID(World world){
        if (world == null) {
            throw new IllegalArgumentException("Cannot fetch the Dimension-ID from a null world!");
        }
        if (world.provider == null){
            for (Integer i : DimensionManager.getIDs()){
                if (DimensionManager.getWorld(i) == world)
                    return i;
            }
            throw new RuntimeException("Unable to determine the dimension of world: "+ world);
        }
        return world.provider.getDimension();
    }
    
    public static boolean spawnEntityInWorld(World world, Entity entity){
        return world.spawnEntity(entity);
    }
}