package org.kubus.meow.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.kubus.meow.Meowing;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = Meowing.MOD_ID, value = Dist.CLIENT)
public class MeowingClient {

    public static final KeyMapping PLAY_SOUND_KEY = new KeyMapping(
            "key.meowing.play_sound",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_P,
            "category.meowing.controls"
    );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(PLAY_SOUND_KEY);
    }

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {

        if (event.phase != TickEvent.Phase.END) {
            return;
        }

        Minecraft minecraft = Minecraft.getInstance();

        if (minecraft.player == null) {
            return;
        }

        while (PLAY_SOUND_KEY.consumeClick()) {

            minecraft.player.playNotifySound(
                    Meowing.MEOW4.get(),
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F
            );
        }
    }
}