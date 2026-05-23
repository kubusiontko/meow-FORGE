package org.kubus.meow.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.network.NetworkEvent;
import org.kubus.meow.Meowing;

import java.util.function.Supplier;

public class MeowPacket {

    public MeowPacket() {}

    public static void encode(MeowPacket msg, FriendlyByteBuf buf) {}

    public static MeowPacket decode(FriendlyByteBuf buf) {
        return new MeowPacket();
    }

    public static void handle(MeowPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {

            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;

            player.level().playSound(
                    null,
                    player.blockPosition(),
                    Meowing.MEOW.get(),
                    SoundSource.PLAYERS,
                    1.0F,
                    1.0F
            );
        });

        ctx.get().setPacketHandled(true);
    }
}