package level3.jewelry_shopping;

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
        Set<String> checkedJewelrySet = new HashSet<>();
        int start = 0, end = 0;

        for(int i = 0; i < gems.length; i++) {
            if(!checkedJewelrySet.contains(gems[i])) {
                checkedJewelrySet.add(gems[i]);
                end = i;
            }
        }

        for(int i = end; i >= 0; i--) {
            checkedJewelrySet.remove(gems[i]);
            if(checkedJewelrySet.isEmpty()) {
                start = i;
                break;
            }
        }
        return new int[] {start + 1, end + 1};
    }
}

class Runner {

    public static void main(String[] args) {
        JewelryShopping jewelryShopping = new JewelryShopping();
        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        int[] result1 = jewelryShopping.solution(gems1);
        int[] result2 = jewelryShopping.solution(gems2);
        int[] result3 = jewelryShopping.solution(gems3);
        int[] result4 = jewelryShopping.solution(gems4);

        Arrays.stream(result1).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        Arrays.stream(result2).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        Arrays.stream(result3).forEach(i -> System.out.print(i + "\t"));
        System.out.println();
        Arrays.stream(result4).forEach(i -> System.out.print(i + "\t"));
    }

}
