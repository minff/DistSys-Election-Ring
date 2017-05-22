import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;

public class Main {

	private static final int MAX_ID = 20;
	private static Random gen = new Random(System.currentTimeMillis());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Node> nodes = new ArrayList<Node>(3);
		for (int i = 0; i < 3; i++) {
			nodes.add(new Node());
		}
		Iterator it1 = nodes.iterator();
		Iterator it2 = nodes.iterator(); 
		it2.next();
		for (; it2.hasNext();) {
			Node node1 = (Node) it1.next();
			Node node2 = (Node) it2.next();
			node1.init(randomId(), node2);
		}
		((Node)it1.next()).init(randomId(),nodes.get(0));
		
		
		for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			System.out.println(node);
		}
		nodes.get(0).beginElection();
	}
	
	public static int randomId(){
		return gen .nextInt(MAX_ID);
	}

}
