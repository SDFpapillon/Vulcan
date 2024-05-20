package papillon.vulcan.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.BlockBreakingInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import papillon.vulcan.Vulcan;
import papillon.vulcan.item.ModItems;

@Mixin(Block.class)
public abstract class BlockMixin {

    private void SecureBreak(World world, BlockPos pos, BlockState state) {
        if (!(world.getBlockState(pos).getBlock() == Blocks.BEDROCK || world.getBlockState(pos).getBlock() == Blocks.END_GATEWAY || world.getBlockState(pos).getBlock() == Blocks.END_PORTAL || world.getBlockState(pos).getBlock() == Blocks.END_PORTAL_FRAME)) {
            world.breakBlock(pos, true);
        }
    }

    @Inject(at = @At("HEAD"), method = "onBreak", cancellable = true)
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player, CallbackInfoReturnable<BlockState> cir) {
        //world.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 10000.0f, false, World.ExplosionSourceType.MOB);
        if(player.getInventory().getMainHandStack().getItem() == ModItems.VULCAN_PICKAXE) {
            if((state.isFullCube(world, pos))) {

                SecureBreak(world, pos.add(0, -1, -1), state);
                SecureBreak(world, pos.add(0, -1,  0), state);
                SecureBreak(world, pos.add(0, -1 , 1), state);
                SecureBreak(world, pos.add(0, 0,  -1), state);
                SecureBreak(world, pos.add(0, 0,   1), state);
                SecureBreak(world, pos.add(0, 1,  -1), state);
                SecureBreak(world, pos.add(0, 1,   0), state);
                SecureBreak(world, pos.add(0, 1,   1), state);

                SecureBreak(world, pos.add(1, -1, -1), state);
                SecureBreak(world, pos.add(1, -1,  0), state);
                SecureBreak(world, pos.add(1, -1,  1), state);
                SecureBreak(world, pos.add(1, 0,  -1), state);
                SecureBreak(world, pos.add(1, 0,   0), state);
                SecureBreak(world, pos.add(1, 0,   1), state);
                SecureBreak(world, pos.add(1, 1,  -1), state);
                SecureBreak(world, pos.add(1, 1,   0), state);
                SecureBreak(world, pos.add(1, 1,   1), state);

                SecureBreak(world, pos.add(-1, -1,-1), state);
                SecureBreak(world, pos.add(-1, -1, 0), state);
                SecureBreak(world, pos.add(-1, -1, 1), state);
                SecureBreak(world, pos.add(-1, 0, -1), state);
                SecureBreak(world, pos.add(-1, 0,  0), state);
                SecureBreak(world, pos.add(-1, 0,  1), state);
                SecureBreak(world, pos.add(-1, 1, -1), state);
                SecureBreak(world, pos.add(-1, 1,  0), state);
                SecureBreak(world, pos.add(-1, 1,  1), state);

            }
        }
    }
}