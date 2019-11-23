package me.minidigger.voxelgameslib.onevsone;

import com.voxelgameslib.voxelgameslib.GameConstants;
import com.voxelgameslib.voxelgameslib.api.feature.features.AutoRespawnFeature;
import com.voxelgameslib.voxelgameslib.api.feature.features.BleedFeature;
import com.voxelgameslib.voxelgameslib.api.feature.features.DuelFeature;
import com.voxelgameslib.voxelgameslib.api.feature.features.GameModeFeature;
import com.voxelgameslib.voxelgameslib.api.feature.features.KitFeature;
import com.voxelgameslib.voxelgameslib.api.feature.features.MapFeature;
import com.voxelgameslib.voxelgameslib.api.feature.features.MobFeature;
import com.voxelgameslib.voxelgameslib.api.feature.features.SpawnFeature;
import com.voxelgameslib.voxelgameslib.api.feature.features.SpectatorFeature;
import com.voxelgameslib.voxelgameslib.api.phase.TimedPhase;

import org.bukkit.GameMode;

/**
 * Created by Martin on 28.01.2017.
 */
public class OneVsOnePhase extends TimedPhase {

    @Override
    public void init() {
        setName("OneVsOnePhase");
        setTicks(2 * 60 * GameConstants.TPS);
        super.init();
        setAllowJoin(false);
        setAllowSpectate(true);

        MapFeature mapFeature = getGame().createFeature(MapFeature.class, this);
        mapFeature.setShouldUnload(true);
        addFeature(mapFeature);

        SpawnFeature spawnFeature = getGame().createFeature(SpawnFeature.class, this);
        spawnFeature.setRespawn(false);
        spawnFeature.setInitialSpawn(false);
        addFeature(spawnFeature);

        GameModeFeature gameModeFeature = getGame().createFeature(GameModeFeature.class, this);
        gameModeFeature.setGameMode(GameMode.SURVIVAL);
        addFeature(gameModeFeature);

        OneVsOneFeature oneVsOneFeature = getGame().createFeature(OneVsOneFeature.class, this);
        addFeature(oneVsOneFeature);

        DuelFeature duelFeature = getGame().createFeature(DuelFeature.class, this);
        addFeature(duelFeature);

        KitFeature kitFeature = getGame().createFeature(KitFeature.class, this);
        addFeature(kitFeature);

        AutoRespawnFeature autoRespawnFeature = getGame().createFeature(AutoRespawnFeature.class, this);
        addFeature(autoRespawnFeature);

        MobFeature mobFeature = getGame().createFeature(MobFeature.class, this);
        addFeature(mobFeature);

        BleedFeature bleedFeature = getGame().createFeature(BleedFeature.class, this);
        addFeature(bleedFeature);

        SpectatorFeature spectatorFeature = getGame().createFeature(SpectatorFeature.class, this);
        addFeature(spectatorFeature);

        OneVsOneVictoryCondition duelVictoryCondition = getGame().createVictoryCondition(OneVsOneVictoryCondition.class, this);
        addVictoryCondition(duelVictoryCondition);
    }
}
