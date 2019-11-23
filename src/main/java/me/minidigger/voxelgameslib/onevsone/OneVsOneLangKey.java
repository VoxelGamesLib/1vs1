package me.minidigger.voxelgameslib.onevsone;

import java.util.UUID;
import javax.annotation.Nonnull;

import com.voxelgameslib.voxelgameslib.internal.lang.ExternalTranslatable;
import com.voxelgameslib.voxelgameslib.internal.lang.Translatable;

public enum OneVsOneLangKey implements ExternalTranslatable {

    DUMMY("dummy"),

    // STATS
    STAT_KILLS_NAME("Kills"),
    STAT_KILLS_TEXT("killed {val} enemies.", "val"),
    STAT_GAMES_NAME("Games"),
    STAT_GAMES_TEXT("played {val} times.", "val"),

    ;

    @Nonnull
    private final String defaultValue;

    @Nonnull
    private final String[] args;

    private static UUID uuid = UUID.randomUUID();

    OneVsOneLangKey(@Nonnull String defaultValue, @Nonnull String... args) {
        this.defaultValue = defaultValue;
        this.args = args;
    }

    /**
     * @return the default value for this lang key, in english
     */
    @Override
    @Nonnull
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * @return the arguments that this key requires
     */
    @Override
    @Nonnull
    public String[] getArgs() {
        return args;
    }

    @Override
    @Nonnull
    public UUID getUuid() {
        return uuid;
    }

    @Override
    @Nonnull
    public Translatable[] getValues() {
        return values();
    }
}
