import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Greedy implements IInformedSearchAlgo {
    @Override
    public Node execute(Node root, String goal) {
        PriorityQueue<Node> frontier = new PriorityQueue<Node>((n1, n2) -> Double.compare(n1.getH(), n2.getH()));
        ArrayList<Node> explored = new ArrayList<>();
        frontier.add(root);
        //
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if (current.getLabel().equals(goal)) {
                return current;
            }
            explored.add(current);
            List<Edge> children = current.getChildren();
            for (Edge child : children) {
                Node end = child.getEnd();
                if (!frontier.contains(end) && !explored.contains(end)) {
                    frontier.add(end);
                    end.setParent(current);
                    end.setPathCost(current.getPathCost() + child.getWeight());
                } else if (frontier.contains(end) && (end.getPathCost() > current.getPathCost() + child.getWeight())) {
                    end.setParent(current);
                    end.setPathCost(current.getPathCost() + child.getWeight());
                }
            }
        }

        return null;
    }


    @Override
    public Node execute(Node root, String start, String goal) {
        return null;
    }


}
