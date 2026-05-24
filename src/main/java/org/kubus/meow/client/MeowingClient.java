package org.kubus.meow.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.kubus.meow.Meowing;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(
        modid = Meowing.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.MOD,
        value = Dist.CLIENT
)
public class MeowingClient {
    public static final KeyMapping PLAY_SOUND_KEY_MEOW = new KeyMapping(
            "key.meowing.play_sound",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_M,
            "category.meowing.controls"
    );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(PLAY_SOUND_KEY_MEOW);
    }
}