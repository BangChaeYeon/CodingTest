package programmers.coding.school;

public class BinaraySearch_After {
	
	public static int solution(int[] budgets, int M) {
		int max = 0;
		for (int b : budgets) max = Math.max(max, b);

		return reculsion(budgets, M, 1, max);
	}
	
	private static int reculsion(int[] budgets, int M, int low, int high) {
		int mid = (low + high) / 2;
		if (high < low) return mid;
		
		int total = 0;
		for (int i = 0; i < budgets.length; i++) {
			total += Math.min(budgets[i], mid);
		}
		
		if (total < M) {
			return reculsion(budgets, M, mid + 1, high);
		} else if (total > M) {
			return reculsion(budgets, M, low, mid - 1);
		}

		return mid;
	}

	public static void main(String[] args) {
		int[] budgets = {120, 110, 140, 150};
		int M = 485;
		
		int result = solution(budgets, M);
		System.out.println(result);
	}

}
