package net.crackle.florin.sound;

import net.crackle.florin.Florin;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent JINGLE_BELLS = registerSoundEvent("jingle_bells");
    public static final RegistryKey<JukeboxSong> JINGLE_BELLS_KEY =
            RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(Florin.MOD_ID, "jingle_bells"));


    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(Florin.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        Florin.LOGGER.info("Registering Mod Sounds for " + Florin.MOD_ID);
    }
}