package programmers.coding.test;

public class ID_Recommend {
	
	// 1단계: 소문자로 변환
	public static String step01(String id) {
		return id.toLowerCase();
	}
	
	// 2단계: 영어 소문자, 숫자, -, _, . 이외의 문자 전부 제거
	public static String step02(String id) {
		return id.replaceAll("[^a-z0-9\\-_.]*", "");
	}
	
	// 3단계: .가 2개 이상 있을 경우 .하나로 치환
	public static String step03(String id) {
		return id.replaceAll("\\.{2,}", ".");
	}
	
	// 4단계: .가 처음이나 끝에 있을 경우 제거
	public static String step04(String id) {
		// .이 처음에 있을 때
		if(id.charAt(0) == '.'){
			id = id.substring(1);
		}
		
		// .이 끝에 있을 때
		if(id.length() > 1 && id.charAt(id.length() - 1) == '.'){
			id = id.substring(0, id.length() - 1);
		}
		
		return id;
	}
	
	// 5단계: id가 빈 문자열일 경우 a 넣기
	public static String step05(String id) {
		if(id == null || id.equals("")) {
			id = "aaa";
		}
		
		return id;
	}
	
	// 6단계: id 길이가 16자 이상일 때, 첫 15개를 제외한 나머지 문자 제거
	public static String step06(String id) {
		if(id.length() >= 16){
			id = id.substring(0, 15);
		}
		
		return step04(id);
	}
	
	// 7단계: id 길이가 2자 이하라면 마지막 문자를 id 길이가 3이상이 될 때 까지 붙임
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
		// 검증
		/*String exID = id;
		
		id = step01(id);
		System.out.println(String.format("1단계 %s -> %s", exID, id));
		exID = id;
		
		id = step02(id);
		System.out.println(String.format("2단계 %s -> %s", exID, id));
		exID = id;
		
		id = step03(id);
		System.out.println(String.format("3단계 %s -> %s", exID, id));
		exID = id;
		
		id = step04(id);
		System.out.println(String.format("4단계 %s -> %s", exID, id));
		exID = id;
		
		id = step05(id);
		System.out.println(String.format("5단계 %s -> %s", exID, id));
		exID = id;
		
		id = step06(id);
		System.out.println(String.format("6단계 %s -> %s", exID, id));
		exID = id;
		
		id = step07(id);
		System.out.println(String.format("7단계 %s -> %s", exID, id));
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
