package org.kubus.meow.network;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.kubus.meow.Meowing;

public class ModNetwork {

    private static final String PROTOCOL = "1";
    public static final SimpleChannel CHANNEL = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(Meowing.MOD_ID, "main"),
            () -> PROTOCOL,
            PROTOCOL::equals,
            PROTOCOL::equals
    );

    private static int id = 0;

    public static void register() {
        CHANNEL.registerMessage(
                id++,
                MeowPacket.class,
                MeowPacket::encode,
                MeowPacket::decode,
                MeowPacket::handle
        );
    }
}