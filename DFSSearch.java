import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

// 깊이 우선 탐색 (Depth First Search): 정점의 자식들을 먼저 탐색하는 방식
public class DFSSearch {
    public ArrayList<String> dfsFunc(HashMap<String, ArrayList<String>> graph, String startNode) {
        // DFS 알고리즘 구현 => 자료구조 스택(후입선출)과 큐(선입선출)를 활용 => ArrayList 클래스를 활용
        // 두 개의 자료 구조 생성 => needVisit 스택, visited 큐
        ArrayList<String> visited = new ArrayList<>();
        ArrayList<String> needVisit = new ArrayList<>();

        needVisit.add(startNode);
        int count = 0;

        while (!needVisit.isEmpty()) {
            count += 1;
            String node = needVisit.remove(needVisit.size() - 1);
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

        DFSSearch dfsSearch = new DFSSearch();
        System.out.println(dfsSearch.dfsFunc(graph, "A"));
    }
}

// 노드 수(V), 간선 수(E)
// 시간복잡도 : O(V+E)