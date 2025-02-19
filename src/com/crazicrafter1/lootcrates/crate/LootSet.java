package com.crazicrafter1.lootcrates.crate;

import com.crazicrafter1.lootcrates.crate.loot.ILoot;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class LootSet implements ConfigurationSerializable {

    public String id;
    public ItemStack itemStack;
    public ArrayList<ILoot> loot;

    public LootSet(String id, ItemStack itemStack, ArrayList<ILoot> loot) {
        this.id = id;
        this.itemStack = itemStack;
        this.loot = loot;
    }

    public LootSet(Map<String, Object> args) {
        itemStack = (ItemStack) args.get("itemStack");
        loot = (ArrayList<ILoot>) args.get("loot");
    }

    public ILoot getRandomLoot() {
        return loot.get((int) (Math.random() * loot.size()));
    }

    /**
     * Add the specified loot, and return it
     * @param iLoot loot
     * @return the loot instance
     */
    public ILoot addLoot(ILoot iLoot) {
        loot.add(iLoot);
        return iLoot;
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> result = new LinkedHashMap<>();

        result.put("itemStack", itemStack);
        result.put("loot", loot);

        return result;
    }

    @Override
    public String toString() {
        return "LootGroup{" +
                "id='" + id + '\'' +
                ", itemStack=" + itemStack.getType() +
                ", loot=" + loot +
                '}';
    }
}
