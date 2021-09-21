package level3.jewelry_shopping;


import java.util.*;

/**
 * @package : level3.jewelry_shopping
 * @class : JewelryShopping.java
 * @category : 2020 카카오 인턴십
 * @title : 보석 쇼핑
 * @date : 2021-09-20 오후 7:41
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/67258
*/
public class JewelryShopping {

    public int[] solution(String[] gems) {
        int[] answer = new int[]{0, 100000};
        boolean scanEnd = false;
        Set<String> gemsSet = new HashSet<>();
        List<String> subGemList = new LinkedList<>();
        int start = 0, end = -1;

        gemsSet.addAll(Arrays.asList(gems));

        while(!scanEnd) {
            while(end < gems.length && !scanEnd) {
                end++;
                subGemList.add(gems[end]);
                if(end == gems.length - 1)
                    scanEnd = true;
                if(subGemList.containsAll(gemsSet)) {
                    if(end - start < answer[1] - answer[0]) {
                        answer[0] = start + 1;
                        answer[1] = end + 1;
                    }
                    break;
                }
            }
            while(start < end) {
                if(subGemList.containsAll(gemsSet)) {
                    start++;
                    subGemList.remove(0);
                    if(subGemList.containsAll(gemsSet)
                            && end - start < answer[1] - answer[0]) {
                        answer[0] = start + 1;
                        answer[1] = end + 1;
                    }
                } else {
                    break;
                }
            }
        }
        return answer;
    }

}

class Runner {

    public static void main(String[] args) {
        JewelryShopping jewelryShopping = new JewelryShopping();


        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        int[] result1 = jewelryShopping.solution(gems1);
        Arrays.stream(result1).forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        int[] result2 = jewelryShopping.solution(gems2);
        Arrays.stream(result2).forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        int[] result3 = jewelryShopping.solution(gems3);
        Arrays.stream(result3).forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        int[] result4 = jewelryShopping.solution(gems4);
        Arrays.stream(result4).forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        String[] gems5 = {"DIA", "EM", "EM", "RUB", "DIA"};
        int[] result5 = jewelryShopping.solution(gems5);
        Arrays.stream(result5).forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        String[] gems6 = {"A", "B", "C", "B", "F", "D", "A", "F", "B", "D", "B"};
        int[] result6 = jewelryShopping.solution(gems6);
        Arrays.stream(result6).forEach(i -> System.out.print(i + "\t"));
        System.out.println();

        String[] gems7 = {"A","B","B","B","B","B","B","C","B","A"};
        int[] result7 = jewelryShopping.solution(gems7);
        Arrays.stream(result7).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
    }

}
