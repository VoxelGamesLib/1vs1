package me.minidigger.voxelgameslib.onevsone;

import java.util.UUID;

import com.voxelgameslib.voxelgameslib.api.stats.Stat;
import com.voxelgameslib.voxelgameslib.api.stats.StatFormatter;
import com.voxelgameslib.voxelgameslib.api.stats.StatInstance;
import com.voxelgameslib.voxelgameslib.api.stats.Trackable;
import com.voxelgameslib.voxelgameslib.components.user.User;
import com.voxelgameslib.voxelgameslib.internal.lang.Lang;
import com.voxelgameslib.voxelgameslib.internal.lang.Locale;
import com.voxelgameslib.voxelgameslib.internal.lang.Translatable;

public enum OneVsOneStats implements Trackable {

    KILLS(OneVsOneLangKey.STAT_KILLS_NAME, OneVsOneLangKey.STAT_KILLS_TEXT, true, StatFormatter.INT),
    GAMES(OneVsOneLangKey.STAT_GAMES_NAME, OneVsOneLangKey.STAT_GAMES_TEXT, true, StatFormatter.INT);

    private Stat stat;
    private Translatable displayName;
    private Translatable text;
    private boolean announce;
    private StatFormatter statFormatter;

    OneVsOneStats(Translatable displayName, Translatable text, boolean announce) {
        this(displayName, text, announce, StatFormatter.DOUBLE);
    }

    OneVsOneStats(Translatable displayName, Translatable text, boolean announce, StatFormatter statFormatter) {
        this.displayName = displayName;
        this.text = text;
        this.announce = announce;
        this.statFormatter = statFormatter;
    }

    @Override
    public void setStat(Stat stat) {
        this.stat = stat;
    }

    @Override
    public Stat getStat() {
        return stat;
    }

    @Override
    public StatInstance getInstance(User user) {
        return stat.getInstance(user);
    }

    @Override
    public StatInstance getInstance(UUID id) {
        return stat.getInstance(id);
    }

    @Override
    public StatInstance getNewInstance(UUID uuid) {
        return stat.getNewInstance(uuid);
    }

    @Override
    public Translatable getDisplayName() {
        return displayName;
    }

    @Override
    public Translatable getText() {
        return text;
    }

    @Override
    public StatFormatter getStatFormatter() {
        return statFormatter;
    }

    @Override
    public String formatLong(double val, Locale locale) {
        return Lang.string(text, locale, statFormatter.format(val));
    }

    @Override
    public String formatShort(double val) {
        return statFormatter.format(val);
    }

    // workaround for not having access to the user handler
    @Override
    public User getUser(UUID id) {
        return stat.getUser(id);
    }

    @Override
    public Trackable[] getValues() {
        return values();
    }

    @Override
    public boolean shouldAnnounce() {
        return announce;
    }

    @Override
    public void setAnnounce(boolean announce) {
        this.announce = announce;
    }

    @Override
    public String getPrefix() {
        return "ONEVSONE";
    }
}
