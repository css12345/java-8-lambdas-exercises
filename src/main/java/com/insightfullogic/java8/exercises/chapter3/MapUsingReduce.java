package com.insightfullogic.java8.exercises.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 1
 */
public class MapUsingReduce {

	public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
		List<O> initializeList = new ArrayList<>();
		return stream.reduce(initializeList, (acc, element) -> {
			List<O> result = new ArrayList<>(acc);
			result.add(mapper.apply(element));
			return result;
		}, (left, right) -> {
			List<O> result = new ArrayList<>(left);
			result.addAll(right);
			return result;
		});
	}

}
