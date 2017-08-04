package me.minidigger.voxelgameslib.onevsone;

import com.voxelgameslib.voxelgameslib.event.GameEvent;
import com.voxelgameslib.voxelgameslib.feature.AbstractFeature;
import com.voxelgameslib.voxelgameslib.feature.features.DuelFeature;

import org.bukkit.event.entity.PlayerDeathEvent;

import jskills.Rating;
import lombok.extern.java.Log;

/**
 * Created by Martin on 28.01.2017.
 */
@Log
public class OneVsOneFeature extends AbstractFeature {

    @Override
    public void start() {
        DuelFeature duelFeature = getPhase().getFeature(DuelFeature.class);
        Rating r1 = duelFeature.getOne().getRating(getPhase().getGame().getGameMode());
        Rating r2 = duelFeature.getTwo().getRating(getPhase().getGame().getGameMode());

        log.info(duelFeature.getOne().getRawDisplayName() + "[" +
                r1.getMean() + "(" + r1.getStandardDeviation() + ")] duels "
                + duelFeature.getTwo().getRawDisplayName() + "[" +
                r2.getMean() + "(" + r2.getStandardDeviation() + ")]");
    }

    @Override
    public void stop() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void init() {

    }

    @GameEvent
    public void onDeath(PlayerDeathEvent e) {
        DuelFeature duelFeature = getPhase().getFeature(DuelFeature.class);
        getPhase().getGame().endGame(null, duelFeature.getOther(e.getEntity().getUniqueId()));
    }

    @Override
    public Class[] getDependencies() {
        return new Class[]{DuelFeature.class};
    }
}
