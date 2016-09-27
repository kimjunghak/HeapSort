/**
 * Created by kjh on 16. 9. 26.
 */
import java.io.IOException;

/**
 * Created by kjh on 16. 9. 26.
 */
public class MaxPriorityQueue {

    public void insert(Heap heap, Node x){
        heap.subjects[getLastNodeIndex(heap)] = x;
        heap.BUILD_MAX_HEAP(heap.subjects);
    }

    public int getLastNodeIndex(Heap heap) {
        return heap.nodeSize(heap.subjects)-1;
    }

    public Node max(Heap heap){
        return heap.subjects[0];
    }

    public Node extract_max(Heap heap){
        Node maxNode = this.max(heap);
        heap.subjects[0] = heap.subjects[getLastNodeIndex(heap)];
        heap.BUILD_MAX_HEAP(heap.subjects);
        return maxNode;
    }

    public void increase_key(Heap heap, int x, int k){
        int xIndex = heap.findNodeIndex(heap.subjects, x);
        heap.subjects[xIndex].setNode(k);
        heap.BUILD_MAX_HEAP(heap.subjects);
    }

    public Node h_delete(Heap heap, int x){
        heap.subjects[x-1] = heap.subjects[getLastNodeIndex(heap)];
        heap.BUILD_MAX_HEAP(heap.subjects);
        return heap.subjects[x-1];
    }
}

