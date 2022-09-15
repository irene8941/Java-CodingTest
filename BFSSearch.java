import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class BFSSearch {
    public ArrayList<String> bfsFunctions(HashMap<String, ArrayList<String>> graph, String startNode) {
        // BFS 알고리즘 구현 => 자료구조 큐(선입선출 방식)를 활용 => 큐의 구현은 ArrayList 클래스를 활용
        // 두 개의 큐 생성 => needVisit 큐, visted 큐
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);
        int count = 0;

        while (!needVisit.isEmpty()) {
            count += 1;
            String node = needVisit.remove(0);

            if (!visited.contains(node)) {
                visited.add(node);
                needVisit.addAll(graph.get(node));
            }
        }

        System.out.println(count);
        return visited;
    }

    public static void main(String[] args) {
        // 그래프 표현 방법 : HashMap
        // HashMap은 '키'와 '값'을 저장하는 자료 구조로, 내부에서 해쉬 함수를 통해, '키' 에 대한 '값' 을 빠르게 검색할 수 있음
        // 기본 선언 HashMap<키타입, 값타입> 변수 = new HashMap<키타입, 값타입>();
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        // HashMap 데이터 추가
        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        BFSSearch bObject = new BFSSearch();
        System.out.println(bObject.bfsFunctions(graph, "A"));
    }
}

// 노드 수(V), 간선 수(E)
// 시간복잡도 : O(V+E)