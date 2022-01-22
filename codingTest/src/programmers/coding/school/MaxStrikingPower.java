package programmers.coding.school;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxStrikingPower {
	
	/*public static int[] solution(int[] healths, int[][] items) {
		List<Integer> itemList = new ArrayList<>();
		List<Integer> selectList = new ArrayList<>();
		
		for (int i = 0; i < items.length; i++) {
			itemList.add(i, items[i][0]);
		}
		
		Integer[] healthArr = Arrays.stream(healths).boxed().toArray(Integer[]::new);
		Arrays.sort(items, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
			return o2[1] > o1[1] ? 1 :  o2[1] < o1[1] ? -1 : 0;
			}
		});
		
	//	System.out.println(Arrays.toString(healthArr));
		
		for (int[] item : items) {
			System.out.println(Arrays.toString(item));
		}
		
		int itemIdx = 0;
		int hIdx = 0;
		while (hIdx < healthArr.length && itemIdx < items.length) {
			if (healthArr[hIdx] - items[itemIdx][1] >= 100) {
				healthArr[hIdx] -= items[itemIdx][1];
				selectList.add(items[itemIdx][0]);
				itemIdx += 1;
			} else {
				hIdx += 1;
			}
		
			if (hIdx == healths.length && itemIdx < items.length) {
				itemIdx += 1;
				hIdx = 0;
			}
		}
		
	//	System.out.println(selectList.toString());
	//	System.out.println(itemList.toString());
		
		int ai = 0;
		int[] answer = new int[selectList.size()];
		for (int i = 0; i < selectList.size(); i++) {
			for (int j = 0; j < itemList.size(); j++) {
				if (selectList.get(i).intValue() == itemList.get(j).intValue()) {
					answer[ai++] = j + 1;
					break;
				}
			}
		}
		
		return answer;
	}*/
	
	public static int[] solution(int[] healths, int[][] items) {
        List<Integer> itemList = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < healths.length;) {
                if (healths[j] - items[i][1] >= 100) {
                    healths[j] -= items[i][1];
                    itemList.add(i + 1);
                    break;
                } else {
                    j++;
                }
            }
        }

        return itemList.stream().mapToInt(i->i).toArray();
    }
	
	public static void main(String[] args) {
	int[] healths = {200,120,150};
	int[][] items = {{30,100},{500,30},{100,400}};
	
	/*int[] healths = {300,200,500};
	int[][] items = {{1000, 600},{400, 500},{300, 100}};*/
	
	int[] result = solution(healths, items);
	System.out.println(Arrays.toString(result));
	}

}
