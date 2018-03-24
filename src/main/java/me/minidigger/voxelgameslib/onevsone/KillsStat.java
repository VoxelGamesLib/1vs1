package me.minidigger.voxelgameslib.onevsone;

import com.voxelgameslib.voxelgameslib.stats.Stat;
import com.voxelgameslib.voxelgameslib.stats.Trackable;

public class KillsStat extends Stat {

    @Override
    public Trackable getType() {
        return OneVsOneStats.KILLS;
    }
}