package programmers.coding.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {
	
	static class Music {
		String genre;
		int play;
		int index;
		
		public Music(String genre, int play, int index){
			this.genre = genre;
			this.play = play;
			this.index = index;
		}
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		List<Integer> answerList = new ArrayList<>();
		List<String> genreList = new ArrayList<>();
		Map<String, Integer> genreMap = new HashMap<String, Integer>();
		Music[] musicList = new Music[genres.length];
		
		for (int i = 0; i< genres.length; i++) {
			Music music = new Music(genres[i], plays[i], i);
			musicList[i] = music;
			
			genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
		}
		
		for (String genre : genreMap.keySet()) {
			genreList.add(genre);
		}
		
		Collections.sort(genreList, (o1, o2) -> genreMap.get(o2) - genreMap.get(o1));
		
		Arrays.sort(musicList, (o1, o2) -> o2.play - o1.play);
		
		int cnt = 0;
		for (int i = 0; i < genreList.size(); i++) {
			cnt = 0;
			for (int j = 0; j < musicList.length; j++) {
				if(genreList.get(i).equals(musicList[j].genre)){
					answerList.add(musicList[j].index);
					cnt++;
				}
				
				if (cnt >= 2) break;
			}
		}
		
		return answerList.stream().mapToInt(i -> i).toArray();
	}
	
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		System.out.println(Arrays.toString(solution(genres, plays))); // [4, 1, 3, 0]
	}
}
