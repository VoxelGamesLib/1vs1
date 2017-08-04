package me.minidigger.voxelgameslib.onevsone;

import com.voxelgameslib.voxelgameslib.game.AbstractGame;
import com.voxelgameslib.voxelgameslib.game.GameDefinition;
import com.voxelgameslib.voxelgameslib.game.GameInfo;
import com.voxelgameslib.voxelgameslib.phase.phases.GracePhase;
import com.voxelgameslib.voxelgameslib.phase.phases.LobbyWithVotePhase;

import javax.annotation.Nonnull;

/**
 * Created by Martin on 28.01.2017.
 */
@GameInfo(name = "1vs1", author = "MiniDigger", version = "v1.0", description = "1vs1 Description")
public class OneVsOneGame extends AbstractGame {

    public OneVsOneGame() {
        super(OneVsOnePlugin.GAMEMODE);
    }

    @Override
    public void initGameFromModule() {
        setMinPlayers(2);
        setMaxPlayers(2);

        LobbyWithVotePhase lobbyWithVotePhase = createPhase(LobbyWithVotePhase.class);
        GracePhase gracePhase = createPhase(GracePhase.class);
        gracePhase.setTicks(10 * 20);
        OneVsOnePhase survivalGamesPhase = createPhase(OneVsOnePhase.class);

        lobbyWithVotePhase.setNextPhase(gracePhase);
        gracePhase.setNextPhase(survivalGamesPhase);

        activePhase = lobbyWithVotePhase;

        loadMap();
    }

    @Override
    public void initGameFromDefinition(@Nonnull GameDefinition gameDefinition) {
        super.initGameFromDefinition(gameDefinition);

        loadMap();
    }
}
