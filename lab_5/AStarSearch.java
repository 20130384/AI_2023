package lab_5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class AStarSearch implements IPuzzleAlgo {
    private enum HeuristicType {
        H1, H2
    }

    @Override
    public Node execute(Puzzle problem) {
        Node initialState = problem.getInitialState();
        Node goalState = problem.getGoalState();
        
        Node result = aStarSearch(problem, initialState, HeuristicType.H1);
        if (result != null) {
            return result;
        }
        
        result = aStarSearch(problem, initialState, HeuristicType.H2);
        return result;
    }

    private Node aStarSearch(Puzzle problem, Node initialState, HeuristicType heuristicType) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(new AStarComparator(heuristicType));
        Map<Node, Integer> gValues = new HashMap<>();
        frontier.add(initialState);
        gValues.put(initialState, 0);

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();

            if (currentNode.equals(problem.getGoalState())) {
                // Found the goal state, return the solution
                return currentNode;
            }

            for (Node successor : problem.getSuccessors(currentNode)) {
                int newGValue = gValues.get(currentNode) + 1;

                if (!gValues.containsKey(successor) || newGValue < gValues.get(successor)) {
                    gValues.put(successor, newGValue);

                    if (heuristicType == HeuristicType.H1) {
                        successor.setH(problem.computeH1(successor));
                    } else if (heuristicType == HeuristicType.H2) {
                        successor.setH(problem.computeH2(successor));
                    }

                    frontier.add(successor);
                }
            }
        }

        // No solution found for the current heuristic
        return null;
    }

    private class AStarComparator implements Comparator<Node> {
        private HeuristicType heuristicType;

        public AStarComparator(HeuristicType heuristicType) {
            this.heuristicType = heuristicType;
        }

        @Override
        public int compare(Node a, Node b) {
            int fA, fB;
            if (heuristicType == HeuristicType.H1) {
                fA = a.getG() + problem.computeH1(a);
                fB = b.getG() + problem.computeH1(b);
            } else {
                fA = a.getG() + problem.computeH2(a);
                fB = b.getG() + problem.computeH2(b);
            }

            return Integer.compare(fA, fB);
        }
    }


}
