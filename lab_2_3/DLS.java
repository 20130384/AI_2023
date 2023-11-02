package k21;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Stack;

public class DLS implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		List<Node> explored = new ArrayList<>();
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal)) {
				return current;

			} else {

				List<Node> children = current.getChildren();
				for (Node child : children) {
					if (!explored.contains(child) && !frontier.contains(child)) {
						frontier.add(child);
						child.setParent(current);
						child.setDepth(current.getDepth() + 1);
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
