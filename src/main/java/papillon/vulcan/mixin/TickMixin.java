package papillon.vulcan.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import papillon.vulcan.event.Event;


@Mixin(MinecraftClient.class)
public abstract class TickMixin {

    @Inject(at = @At("HEAD"), method = "tick")
    public void tick(CallbackInfo ci) {
        Event.SlimeRain();
        Event.SilverFishInvade();
    }
}
