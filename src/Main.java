import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Main {

	private static final int MAX_ID = 200;
	private static Random gen = new Random(System.currentTimeMillis());
	private static Iterator<Integer> shuffledListIterator;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nNodes = 10;
		ArrayList<Node> nodes = new ArrayList<Node>(nNodes);
		
		ArrayList<Integer> shuffledList = new ArrayList<Integer>(nNodes);
		
		
		for (int i = 0; i < nNodes; i++) {
			nodes.add(new Node());
			shuffledList.add(new Integer(i));
		}
		
		
		shuffledListIterator = shuffledList.iterator();
        Collections.shuffle(shuffledList);
        
        // create ring structure
		Iterator it1 = nodes.iterator();
		Iterator it2 = nodes.iterator(); 
		it2.next();
		for (; it2.hasNext();) {
			Node node1 = (Node) it1.next();
			Node node2 = (Node) it2.next();
			node1.init(randomId(), node2);
		}
		((Node)it1.next()).init(randomId(),nodes.get(0));
		
		// print info of all nodes in ring
		for (Iterator iterator = nodes.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			System.out.println(node);
		}
		

		// begin election: 1st node
//		nodes.get(0).beginElection();
		
		// begin election: all nodes
		for (Node node : nodes)
			node.beginElection();
		
	}

	public static int randomId(){
		return shuffledListIterator.next();
	}

	public static int randomId_gen(){
		return gen .nextInt(MAX_ID);
	}

}
