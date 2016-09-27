import java.io.*;

/**
 * Created by kjh on 16. 9. 26.
 */
public class Heap {

    Node[] subjects;

    public Heap() throws IOException {
        reader();
        BUILD_MAX_HEAP(subjects);
    }

    private void reader() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream("/home/kjh/Documents/git/HeapSort/data03.txt"), "euc-kr"));
        subjects = new Node[50];
        int index = 0;

        arrayInit(subjects);

        while(true){
            String[] temp;
            String line = buffer.readLine();

            if(line == null) break;

            temp = line.split(",");
            subjects[index++].setNode(Integer.parseInt(temp[0]), temp[1].substring(1, temp[1].length()));
        }

        buffer.close();
    }

    private void MAX_HEAPIFY(Node[] subjects, int index){
        int leftChildIndex = index*2+1;
        int rightChildIndex = index*2+2;
        int largest = index;

        if(leftChildIndex <= nodeSize(subjects) && subjects[leftChildIndex].num > subjects[index].num)
            largest = leftChildIndex;

        if(rightChildIndex <= nodeSize(subjects) && subjects[rightChildIndex].num > subjects[largest].num)
            largest = rightChildIndex;

        if(largest != index) {
            swapNode(subjects, index, largest);
            MAX_HEAPIFY(subjects, largest);
        }
    }

    public void BUILD_MAX_HEAP(Node[] subjects){
        for(int i = (nodeSize(subjects)-1)/2; i>=0 ; i--)
            MAX_HEAPIFY(subjects, i);
    }

    private void swapNode(Node[] subjects, int index, int largest) {
        Node temp = subjects[index];
        subjects[index] = subjects[largest];
        subjects[largest] = temp;
    }

    public int nodeSize(Node[] subjects){
        int count=0;
        for(int i=0 ; i<subjects.length ; i++){
            if(subjects[i].name != null)
                count++;
        }
        return count;
    }

    private void arrayInit(Node[] subjects){
        for(int i=0 ; i<subjects.length ; i++)
            this.subjects[i] = new Node();
    }

    public int findNodeIndex(Node[] subjects, int key){
        int keyIndex = 0;
        for(int i=0 ; i<nodeSize(subjects) ; i++){
            if(subjects[i].num == key)
                keyIndex = i;
        }

        if(keyIndex == 0)
            System.out.println("입력한 과목번호는 존재하지 않습니다.");
        return keyIndex;
    }

    public void print(){
        for(int i=0 ; i<nodeSize(subjects) ; i++)
            System.out.printf("%3s, %s\n", subjects[i].num, subjects[i].name);
    }
}
