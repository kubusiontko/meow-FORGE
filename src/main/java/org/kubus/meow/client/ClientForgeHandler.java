package org.kubus.meow.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.kubus.meow.Meowing;
import org.kubus.meow.network.MeowPacket;
import org.kubus.meow.network.ModNetwork;

@Mod.EventBusSubscriber(
        modid = Meowing.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.FORGE, // Correct bus for gameplay/tick events
        value = Dist.CLIENT
)
public class ClientForgeHandler {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;

        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        // Referencing the key from MeowingClient
        while (MeowingClient.PLAY_SOUND_KEY_MEOW.consumeClick()) {
            ModNetwork.CHANNEL.sendToServer(new MeowPacket());
        }
    }
}