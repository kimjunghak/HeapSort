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

            System.out.print("**** 현재 우선 순위 큐에 저장되어 있는 작업 대기 목록은 다음과 같습니다. ****\n\n");

            heap.print();

            System.out.println("---------------------------------------------");
            System.out.println("1. 작업추가   2. 최대값  3. 최대우선순위 작업 처리");
            System.out.println("4. 원소 키값 증가       5. 작업 제거     6. 종료");
            System.out.println("---------------------------------------------");

            try {

                int number = scan.nextInt();
                scan.nextLine();

                switch (number) {
                    case 1:
                        System.out.println("추가할 과목번호를 입력하시오.");
                        int num = scan.nextInt();
                        System.out.println("추가할 과목이름을 입력하시오.");
                        String name = input.readLine();

                        mPQ.insert(heap, new Node(num, name));
                        break;

                    case 2:
                        System.out.print("과목번호가 가장 큰 과묵은 ");
                        System.out.printf("%3s, %s", mPQ.max(heap).num, mPQ.max(heap).name);
                        System.out.println(" 입니다.\n");
                        break;

                    case 3:
                        Node max = mPQ.extract_max(heap);
                        System.out.print("최대우선순의가 가장 큰 처리 과목은 ");
                        System.out.printf("%3s, %s", max.num, max.name);
                        System.out.println(" 입니다.\n");
                        break;

                    case 4:
                        System.out.println("찾을 과목번호를 입력하시오.");
                        int find = scan.nextInt();
                        System.out.println("증가시킬 과목번호를 입력하시오.");
                        int change = scan.nextInt();
                        mPQ.increase_key(heap, find, change);
                        break;

                    case 5:
                        System.out.println("지우고자 하는 노드번호를 입력하시오.");
                        int delete = scan.nextInt();
                        mPQ.h_delete(heap, delete);
                        break;

                    case 6:
                        isTrue = false;
                        System.out.println("프로그램을 종료합니다.");
                        break;

                    default:
                        System.out.println("잘못 입력하셨습니다.\n");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("잘못 입력하셨습니다.\n");
                scan.nextLine();
            }
        }

    }
}
