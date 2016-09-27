import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by kjh on 16. 9. 26.
 */
public class Test {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        MaxPriorityQueue mPQ = new MaxPriorityQueue();
        Heap heap = new Heap();
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        boolean isTrue = true;

        while(isTrue) {

            System.out.print("**** ���� �켱 ���� ť�� ����Ǿ� �ִ� �۾� ��� ����� ������ �����ϴ�. ****\n\n");

            heap.print();

            System.out.println("---------------------------------------------");
            System.out.println("1. �۾��߰�   2. �ִ밪  3. �ִ�켱���� �۾� ó��");
            System.out.println("4. ���� Ű�� ����       5. �۾� ����     6. ����");
            System.out.println("---------------------------------------------");

            try {

                int number = scan.nextInt();
                scan.nextLine();

                switch (number) {
                    case 1:
                        System.out.println("�߰��� �����ȣ�� �Է��Ͻÿ�.");
                        int num = scan.nextInt();
                        System.out.println("�߰��� �����̸��� �Է��Ͻÿ�.");
                        String name = input.readLine();

                        mPQ.insert(heap, new Node(num, name));
                        break;

                    case 2:
                        System.out.print("�����ȣ�� ���� ū ������ ");
                        System.out.printf("%3s, %s", mPQ.max(heap).num, mPQ.max(heap).name);
                        System.out.println(" �Դϴ�.\n");
                        break;

                    case 3:
                        Node max = mPQ.extract_max(heap);
                        System.out.print("�ִ�켱���ǰ� ���� ū ó�� ������ ");
                        System.out.printf("%3s, %s", max.num, max.name);
                        System.out.println(" �Դϴ�.\n");
                        break;

                    case 4:
                        System.out.println("ã�� �����ȣ�� �Է��Ͻÿ�.");
                        int find = scan.nextInt();
                        System.out.println("������ų �����ȣ�� �Է��Ͻÿ�.");
                        int change = scan.nextInt();
                        mPQ.increase_key(heap, find, change);
                        break;

                    case 5:
                        System.out.println("������� �ϴ� ����ȣ�� �Է��Ͻÿ�.");
                        int delete = scan.nextInt();
                        mPQ.h_delete(heap, delete);
                        break;

                    case 6:
                        isTrue = false;
                        System.out.println("���α׷��� �����մϴ�.");
                        break;

                    default:
                        System.out.println("�߸� �Է��ϼ̽��ϴ�.\n");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("�߸� �Է��ϼ̽��ϴ�.\n");
                scan.nextLine();
            }
        }

    }
}
