package com.insightfullogic.java8.exercises.chapter3;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Stream;

import com.insightfullogic.java8.examples.chapter1.Album;
import com.insightfullogic.java8.examples.chapter1.Artist;

public class Question1 {
	public static int addUp(Stream<Integer> numbers) {
		return numbers.reduce(0, (sum, element) -> sum + element);
	}

	public static List<String> getNamesAndOrigins(List<Artist> artists) {
//		List<String> namesAndOrigins = new ArrayList<>();
//		artists.stream().forEach(artist -> {
//        	namesAndOrigins.add(artist.getName());
//			namesAndOrigins.add(artist.getNationality());
//        });
//        return namesAndOrigins;
		
		return artists.stream().flatMap(artist -> Stream.of(artist.getName(),artist.getNationality())).collect(toList());
    }

	public static List<Album> getAlbumsWithAtMostThreeTracks(List<Album> input) {
		return input.stream().filter(album -> album.getTrackList().size() <= 3).collect(toList());
	}
}
