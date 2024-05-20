package papillon.vulcan.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import papillon.vulcan.Vulcan;
import papillon.vulcan.event.Event;


@Mixin(ItemStack.class)
public class ItemStackMixin {

    @Inject(at = @At("HEAD"), method = "inventoryTick")
    public void inventoryTick(World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {
        if(entity.isPlayer()) {
            Event.DifficultyCalcule((PlayerEntity) entity, world);
        }
    }

}
