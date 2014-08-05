/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null)
    		return null;
    	HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    	UndirectedGraphNode cloneHead = new UndirectedGraphNode(node.label);
    	map.put(node, cloneHead);

    	Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
    	queue.add(node);

    	while(!queue.isEmpty()) {
    		UndirectedGraphNode cur = queue.remove();
    		UndirectedGraphNode cloneCur = map.get(cur);
    		List<UndirectedGraphNode> nbs = cur.neighbors;
    		for(UndirectedGraphNode nbNode : nbs) {
    			if(map.containsKey(nbNode)) {
    				cloneCur.neighbors.add(map.get(nbNode));
    			}
    			else {//non visited nbNode
    				UndirectedGraphNode newNode = new UndirectedGraphNode(nbNode.label);
    				map.put(nbNode, newNode);
    				cloneCur.neighbors.add(newNode);
    				queue.add(nbNode); // cause undirected double direction only new node add to Q
    			}
    		}
    	}

    	return cloneHead;
    }
}