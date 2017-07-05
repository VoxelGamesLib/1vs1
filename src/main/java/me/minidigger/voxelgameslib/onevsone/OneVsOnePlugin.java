package me.minidigger.voxelgameslib.onevsone;

import com.google.inject.Singleton;

import javax.inject.Inject;

import me.minidigger.voxelgameslib.game.GameHandler;
import me.minidigger.voxelgameslib.game.GameMode;
import me.minidigger.voxelgameslib.module.Module;
import me.minidigger.voxelgameslib.module.ModuleHandler;
import me.minidigger.voxelgameslib.module.ModuleInfo;

import org.bukkit.plugin.java.JavaPlugin;

@Singleton
@ModuleInfo(name = "1vs1", authors = "MiniDigger", version = "1.0.0")
public class OneVsOnePlugin extends JavaPlugin implements Module {

    public static final GameMode GAMEMODE = new GameMode("1vs1", OneVsOneGame.class);

    @Inject
    private GameHandler gameHandler;

    @Inject
    private OneVsOnePlugin plugin;//TEST

    @Override
    public void onLoad() {
        ModuleHandler.offerModule(this); // always do this first!
    }

    @Override
    public void enable() {
        gameHandler.registerGameMode(GAMEMODE);
        System.out.println("PLUGIN WAS " + plugin);
    }

    @Override
    public void disable() {

    }
}
