package level3.jewelry_shopping;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        int[] answer = new int[2];
        Set<String> jewelrySet = new HashSet<>();
        int minRange = 1000000;

        for(int i = 0; i < gems.length; i++) {
            if(!jewelrySet.contains(gems[i])) {
                jewelrySet.add(gems[i]);
            }
        }

        for(int i = 0; i <= gems.length - jewelrySet.size(); i++) {
            int range = getJewelryRange(gems, new HashSet<>(jewelrySet), i);
            if(range != -1 && range < minRange) {
                minRange = range;
                answer[0] = i + 1;
                answer[1] = answer[0] + range;
            }
        }
        return answer;
    }

    private int getJewelryRange(String[] gems,Set<String> jewelrySet, int start) {
        for(int i = start; i < gems.length; i++) {
            jewelrySet.remove(gems[i]);
            if(jewelrySet.isEmpty()) {
                return i - start;
            }
        }
        return -1;
    }
}

class Runner {

    public static void main(String[] args) {
        JewelryShopping jewelryShopping = new JewelryShopping();
        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        String[] gems5 = {"A","A","A","B","B"};
        String[] gems6 = {"A"};
        String[] gems7 = {"A","B","B","B","B","B","B","C","B","A"};

        int[] result1 = jewelryShopping.solution(gems1);
        int[] result2 = jewelryShopping.solution(gems2);
        int[] result3 = jewelryShopping.solution(gems3);
        int[] result4 = jewelryShopping.solution(gems4);
        int[] result5 = jewelryShopping.solution(gems5);
        int[] result6 = jewelryShopping.solution(gems6);
        int[] result7 = jewelryShopping.solution(gems7);

        Arrays.stream(result1).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        Arrays.stream(result2).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        Arrays.stream(result3).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        Arrays.stream(result4).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        Arrays.stream(result5).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        Arrays.stream(result6).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        Arrays.stream(result7).forEach(i -> System.out.print(i + "\t"));
    }

}
