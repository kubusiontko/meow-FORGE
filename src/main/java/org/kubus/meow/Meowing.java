package org.kubus.meow;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(Meowing.MOD_ID)
public class Meowing {

    public static final String MOD_ID = "meowing";

    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MOD_ID);

    public static final RegistryObject<SoundEvent> MEOW4 = SOUND_EVENTS.register(
            "mojdzwiek",
            () -> SoundEvent.createVariableRangeEvent(
                    new ResourceLocation(MOD_ID, "mojdzwiek")
            )
    );

    public Meowing() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        SOUND_EVENTS.register(modEventBus);
    }
}