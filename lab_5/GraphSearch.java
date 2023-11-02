package lab_5;

import java.util.HashSet;
import java.util.PriorityQueue;

public class GraphSearch {
	public static Node graphSearch(Puzzle problem) {
		PriorityQueue<Node> frontier = new PriorityQueue<>(PuzzleUtils.HeuristicComparatorByH);
		HashSet<Node> explored = new HashSet<>();
		Node initialState = problem.getInitialState();
		initialState.setH(problem.computeH2(initialState));
		frontier.add(initialState);
		while (!frontier.isEmpty()) {
			Node currentNode = frontier.poll();
			if (currentNode.equals(problem.getGoalState())) {
				return currentNode;
			}
			explored.add(currentNode);
			for (Node successor : problem.getSuccessors(currentNode)) {
				successor.setH(problem.computeH2(successor));
				if (!frontier.contains(successor) && !explored.contains(successor)) {
					frontier.add(successor);
				}
			}
		}
		return null;
	}
}
