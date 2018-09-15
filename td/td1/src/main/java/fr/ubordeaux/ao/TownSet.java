package fr.ubordeaux.ao;

import java.util.HashSet;
import java.util.Set;

public class TownSet {
    private Set<Town> townSet;

    public TownSet() {
	townSet = new HashSet<Town>();
    }

    public void addTown(Town newTown) {
	townSet.add(newTown);
    }

    public void removeTown(Town oldTown) {
	townSet.remove(oldTown);
    }

    public int size() {
	return townSet.size();
    }

    public Set<Town> getTown(int from, int to) {
	Set<Town> result = new HashSet<Town>();
        int i = 0;
        for (Town t : townSet) {
            if (i >= from) {
                result.add(t);
            }
            if (i >= to) {
                return result;
            }
            i++;
        }
        return result;
    }
}
