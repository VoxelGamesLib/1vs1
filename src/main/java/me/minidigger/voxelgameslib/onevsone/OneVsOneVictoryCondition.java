package me.minidigger.voxelgameslib.onevsone;

import javax.annotation.Nonnull;

import com.voxelgameslib.voxelgameslib.condition.VictoryConditionInfo;
import com.voxelgameslib.voxelgameslib.condition.conditions.DuelVictoryCondition;
import com.voxelgameslib.voxelgameslib.event.GameEvent;

import org.bukkit.event.entity.PlayerDeathEvent;

@VictoryConditionInfo(name = "OneVsOneVictoryCondition", author = "MiniDigger", version = "1.0", description = "Determines the winner for 1vs1 games")
public class OneVsOneVictoryCondition extends DuelVictoryCondition {

    @Override
    @GameEvent
    public void onDeath(@Nonnull PlayerDeathEvent e) {
        super.onDeath(e);
        OneVsOneStats.KILLS.getInstance(winner).increment();
    }
}
