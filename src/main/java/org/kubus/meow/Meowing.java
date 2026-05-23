package org.kubus.meow;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.kubus.meow.network.ModNetwork;

@Mod(Meowing.MOD_ID)
public class Meowing {

    public static final String MOD_ID = "meowing";

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MOD_ID);

    public static final RegistryObject<SoundEvent> MEOW = SOUND_EVENTS.register(
            "meow",
            () -> SoundEvent.createVariableRangeEvent(
                    new ResourceLocation(MOD_ID, "meow")
            )
    );

    public static final RegistryObject<SoundEvent> NYAA = SOUND_EVENTS.register(
            "nyaa",
            () -> SoundEvent.createVariableRangeEvent(
                    new ResourceLocation(MOD_ID, "nyaa")
            )
    );

    public Meowing() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        SOUND_EVENTS.register(modEventBus);

        ModNetwork.register();
    }
}