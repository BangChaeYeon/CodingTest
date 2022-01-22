package programmers.coding.test;

public class ID_Recommend {
	
	// 1�ܰ�: �ҹ��ڷ� ��ȯ
	public static String step01(String id) {
		return id.toLowerCase();
	}
	
	// 2�ܰ�: ���� �ҹ���, ����, -, _, . �̿��� ���� ���� ����
	public static String step02(String id) {
		return id.replaceAll("[^a-z0-9\\-_.]*", "");
	}
	
	// 3�ܰ�: .�� 2�� �̻� ���� ��� .�ϳ��� ġȯ
	public static String step03(String id) {
		return id.replaceAll("\\.{2,}", ".");
	}
	
	// 4�ܰ�: .�� ó���̳� ���� ���� ��� ����
	public static String step04(String id) {
		// .�� ó���� ���� ��
		if(id.charAt(0) == '.'){
			id = id.substring(1);
		}
		
		// .�� ���� ���� ��
		if(id.length() > 1 && id.charAt(id.length() - 1) == '.'){
			id = id.substring(0, id.length() - 1);
		}
		
		return id;
	}
	
	// 5�ܰ�: id�� �� ���ڿ��� ��� a �ֱ�
	public static String step05(String id) {
		if(id == null || id.equals("")) {
			id = "aaa";
		}
		
		return id;
	}
	
	// 6�ܰ�: id ���̰� 16�� �̻��� ��, ù 15���� ������ ������ ���� ����
	public static String step06(String id) {
		if(id.length() >= 16){
			id = id.substring(0, 15);
		}
		
		return step04(id);
	}
	
	// 7�ܰ�: id ���̰� 2�� ���϶�� ������ ���ڸ� id ���̰� 3�̻��� �� �� ���� ����
	public static String step07(String id) {
		while(id.length() <= 2) {
			if(id.length() == 1) {
				id += id;
			}else {
				id += id.substring(1);
			}
		}
		
		return id;
	}
	
	public static String solution(String id) {
		// ����
		/*String exID = id;
		
		id = step01(id);
		System.out.println(String.format("1�ܰ� %s -> %s", exID, id));
		exID = id;
		
		id = step02(id);
		System.out.println(String.format("2�ܰ� %s -> %s", exID, id));
		exID = id;
		
		id = step03(id);
		System.out.println(String.format("3�ܰ� %s -> %s", exID, id));
		exID = id;
		
		id = step04(id);
		System.out.println(String.format("4�ܰ� %s -> %s", exID, id));
		exID = id;
		
		id = step05(id);
		System.out.println(String.format("5�ܰ� %s -> %s", exID, id));
		exID = id;
		
		id = step06(id);
		System.out.println(String.format("6�ܰ� %s -> %s", exID, id));
		exID = id;
		
		id = step07(id);
		System.out.println(String.format("7�ܰ� %s -> %s", exID, id));
		exID = id;
		
		
		return id;*/
		return step07(step06(step05(step04(step03(step02(step01(id)))))));
	}
	
	public static void main(String[] args) {
		String id01 = "...!@BaT#*..y.abcdefghijklm";
		System.out.println(solution(id01));
		
		String id02 = "z-+.^.";
		System.out.println(solution(id02));
		
		String id03 = "=.=";
		System.out.println(solution(id03));
		
		String id04 = "123_.def";
		System.out.println(solution(id04));
		
		String id05 = "abcdefghijklmn.p";
		System.out.println(solution(id05));
	}

}
