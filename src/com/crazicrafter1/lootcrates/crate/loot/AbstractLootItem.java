package com.crazicrafter1.lootcrates.crate.loot;

import com.crazicrafter1.crutils.ItemBuilder;
import com.crazicrafter1.crutils.Util;
import com.crazicrafter1.lootcrates.crate.ActiveCrate;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractLootItem implements ILoot {

    public int min;
    public int max;

    public AbstractLootItem() {
        min = 1;
        max = 1;
    }

    public AbstractLootItem(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public AbstractLootItem(Map<String, Object> args) {
        this((int)args.get("min"), (int)args.get("max"));

        if (min > max)
            throw new IndexOutOfBoundsException("failed to assert: min <= max");
    }

    protected ItemStack ofRange(Player p, ItemStack itemStack) {
        ItemBuilder builder = new ItemBuilder(itemStack).count(Util.randomRange(min, max));

        builder.placeholders(p);

        return builder.toItem();
    }

    @Override
    public final boolean execute(ActiveCrate activeCrate) {
        // Closed shouldn't matter
        // Should execute the same no matter what
        //Util.giveItemToPlayer(activeCrate.getPlayer(), getIcon());
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (min == max)
            sb.append("&7count: &f").append(min);
        else sb.append("&7range: &f[").append(min).append(", ").append(max).append("]");

        return sb.toString();
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new LinkedHashMap<>();

        result.put("min", min);
        result.put("max", max);

        return result;
    }
}
