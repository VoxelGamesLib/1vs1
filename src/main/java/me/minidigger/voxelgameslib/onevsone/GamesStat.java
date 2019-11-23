package me.minidigger.voxelgameslib.onevsone;

import com.voxelgameslib.voxelgameslib.api.stats.Stat;
import com.voxelgameslib.voxelgameslib.api.stats.Trackable;

public class GamesStat extends Stat {

    @Override
    public Trackable getType() {
        return OneVsOneStats.GAMES;
    }
}
