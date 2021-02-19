package com.crazicrafter1.lootcrates.listeners;

import com.crazicrafter1.lootcrates.Main;
import com.crazicrafter1.lootcrates.crate.Crate;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;

public class ListenerOnDeath extends BaseListener {

    public ListenerOnDeath(Main plugin) {
        super(plugin);
    }

    // get the handle first
    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onDeath(PlayerDeathEvent e) {
        if (true) return;
        Player p = e.getEntity();
        if (Main.openCrates.containsKey(p.getUniqueId())) {
            //plugin.openCrates.get(p.getUniqueId()).giveAndCancel();
            Main.getInstance().debug("onDeath()");
            Crate.closeCrate(p);
        }
    }

}
