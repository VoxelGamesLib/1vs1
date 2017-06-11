package me.minidigger.voxelgameslib.onevsone;

import me.minidigger.voxelgameslib.module.ModuleHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class OneVsOnePlugin extends JavaPlugin {

  @Override
  public void onLoad() {
    ModuleHandler.offerModule(OneVsOneModule.class);
  }
}
