package lab_5;
import java.util.PriorityQueue;

public class GreedyBestFirstSearch implements IPuzzleAlgo {

    @Override
    public Node execute(Puzzle problem) {
        PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
        Node initialState = problem.getInitialState();

        // Set the heuristic value based on h1
        initialState.setH(problem.computeH1(initialState));

        frontier.add(initialState);

        while (!frontier.isEmpty()) {
            Node currentNode = frontier.poll();

            if (currentNode.equals(problem.getGoalState())) {
                // Found the goal state, return the solution
                return currentNode;
            }

            for (Node successor : problem.getSuccessors(currentNode)) {
                // Set the heuristic value based on h1
                successor.setH(problem.computeH1(successor));
                frontier.add(successor);
            }
        }

        // No solution found
        return null;
    }
}
