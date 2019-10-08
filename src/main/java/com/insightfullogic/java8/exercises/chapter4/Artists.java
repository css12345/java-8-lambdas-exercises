package com.insightfullogic.java8.exercises.chapter4;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.insightfullogic.java8.examples.chapter1.Artist;

public class Artists {

	private List<Artist> artists;

	public Artists(List<Artist> artists) {
		this.artists = artists;
	}

	public Optional<Artist> getArtist(int index) {
		if (index < 0 || index >= artists.size()) {
			return Optional.empty();
		}
		return Optional.of(artists.get(index));
	}

	public String getArtistName(int index) {
//        try {
//            Artist artist = getArtist(index).get();
//            return artist.getName();
//        } catch (NoSuchElementException e) {
//            return "unknown";
//        }
		return getArtist(index).map(Artist::getName).orElse("unknown");
	}

}
