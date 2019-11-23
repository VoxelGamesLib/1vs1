package me.minidigger.voxelgameslib.onevsone;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.Nonnull;

import com.voxelgameslib.voxelgameslib.api.feature.AbstractFeature;
import com.voxelgameslib.voxelgameslib.api.feature.Feature;
import com.voxelgameslib.voxelgameslib.api.feature.features.DuelFeature;

import jskills.Rating;

/**
 * Created by Martin on 28.01.2017.
 */
public class OneVsOneFeature extends AbstractFeature {

    private static final Logger log = Logger.getLogger(OneVsOneFeature.class.getName());

    @Override
    public void enable() {
        DuelFeature duelFeature = getPhase().getFeature(DuelFeature.class);
        Rating r1 = duelFeature.getOne().getRating(getPhase().getGame().getGameMode());
        Rating r2 = duelFeature.getTwo().getRating(getPhase().getGame().getGameMode());

        log.info(duelFeature.getOne().getRawDisplayName() + "[" +
                r1.getMean() + "(" + r1.getStandardDeviation() + ")] duels "
                + duelFeature.getTwo().getRawDisplayName() + "[" +
                r2.getMean() + "(" + r2.getStandardDeviation() + ")]");

        OneVsOneStats.GAMES.getInstance(duelFeature.getOne()).increment();
        OneVsOneStats.GAMES.getInstance(duelFeature.getTwo()).increment();
    }

    @Override
    @Nonnull
    public List<Class<? extends Feature>> getDependencies() {
        return Collections.singletonList(DuelFeature.class);
    }
}
