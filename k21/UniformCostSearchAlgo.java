package k21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		boolean check = false;
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new Comparator<? super Node>());
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
				explored.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					Node end = child.getEnd();
					double newPathCost = current.getPathCost();
					child.getWeight();
					if (!frontier.contains(end) && !explored.contains(end)) {
						frontier.add(end);
					} else if (end.getPathCost() > newPathCost) {
						
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute_TreeS(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute_TreeS(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
