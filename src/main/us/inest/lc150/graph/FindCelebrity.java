package us.inest.lc150.graph;

class Relation {
    private boolean[][] grid;

    public Relation() {
        grid = new boolean[][] {
                {true, true, false}, {false, true, false}, {true, true, true}
        };
    }

    protected boolean knows(int i, int j) {
        return grid[i][j];
    }
}

public class FindCelebrity extends Relation {
    private int numberOfPeople;

    public int findCelebrity(int n) {
        numberOfPeople = n;
        int candidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(candidate, i)) {
                candidate = i;
            }
        }
        if (isCelebrity(candidate)) {
            return candidate;
        }
        return -1;
    }

    private boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (j == i) continue;
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }
}
