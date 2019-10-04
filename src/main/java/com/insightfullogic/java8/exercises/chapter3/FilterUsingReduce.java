package com.insightfullogic.java8.exercises.chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 2
 */
public class FilterUsingReduce {

	public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
		List<I> identity = new ArrayList<>();
		return stream.reduce(identity, (acc, element) -> {
			if (predicate.test(element)) {
				List<I> result = new ArrayList<>(acc);
				result.add(element);
				return result;
			} else
				return acc;
		}, (left, right) -> {
			List<I> result = new ArrayList<>(left);
			result.addAll(right);
			return result;
		});
	}

}
