package me.minidigger.voxelgameslib.onevsone;

import jskills.Rating;
import lombok.extern.java.Log;
import me.minidigger.voxelgameslib.feature.AbstractFeature;
import me.minidigger.voxelgameslib.feature.features.DuelFeature;
import me.minidigger.voxelgameslib.user.User;
import me.minidigger.voxelgameslib.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

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

    // TODO better items, lol
    for (User user : new User[]{duelFeature.getOne(), duelFeature.getTwo()}) {
      user.getPlayer().getInventory()
          .setItemInMainHand(new ItemBuilder(Material.DIAMOND_SWORD).build());
    }
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

  @EventHandler
  public void onDeath(PlayerDeathEvent e) {
    if (getPhase().getGame().isPlaying(e.getEntity().getUniqueId())) {
      DuelFeature duelFeature = getPhase().getFeature(DuelFeature.class);
      getPhase().getGame().endGame(null, duelFeature.getOther(e.getEntity().getUniqueId()));
    }
  }

  @Override
  public Class[] getDependencies() {
    return new Class[]{DuelFeature.class};
  }
}
