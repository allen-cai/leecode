package issuelist.last_stone_weight_1046;

import java.util.LinkedList;

/**
 * @Description
 * @Author allen
 * @Date 2020/12/30 16:13
 * @ClassName Solution
 **/
public class Solution {

    public static void main(String[] args) {
        int[] stones = new int[]{2,7,4,1,8,1};
        Solution solution = new Solution();
        int i = solution.lastStoneWeight(stones);
        System.out.println(i);
    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < stones.length; i++) {
            linkedList.add(stones[i]);
        }
        //至少剩余两个石头
        while (linkedList.size() > 1) {
            int max1 = getMax(linkedList);
            int max2 = getMax(linkedList);

            if (max1 > max2) {
                linkedList.add(max1 - max2);
            }
        }

        if (linkedList.isEmpty()) {
            return 0;
        } else {
            return (int) linkedList.getFirst();
        }
    }

    public int getMax(LinkedList<Integer> linkedList) {
        if (linkedList.isEmpty()) {
            return 0;
        }
        int max = 0;
        int index = -1;
        for (int i = 0; i < linkedList.size(); i++) {
            if (linkedList.get(i) > max) {
                max = linkedList.get(i);
                index = i;
            }
        }

        linkedList.remove(index);
        return max;
    }
}
