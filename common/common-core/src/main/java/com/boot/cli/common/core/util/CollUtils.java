package com.boot.cli.common.core.util;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CollUtils {

    public static <T> List<T> filter(Predicate<? super T> predicate, List<T> coll) {
        if (Objects.isNull(coll) || coll.isEmpty()) {
            return new ArrayList<>(0);
        }
        return coll.stream().filter(predicate).collect(Collectors.toList());
    }

    public static <T> List<T> distinct(List<T> coll) {
        if (Objects.isNull(coll) || coll.isEmpty()) {
            return new ArrayList<>(0);
        }
        return coll.stream().distinct().collect(Collectors.toList());
    }

    public static <R, T> List<R> collect(Function<? super T, ? extends R> mapper, List<T> coll) {
        if (Objects.isNull(coll) || coll.isEmpty()) {
            return new ArrayList<>(0);
        }
        return coll.stream().map(mapper).collect(Collectors.toList());
    }

    public static <T, K> Map<K, T> toMap(Function<? super T, ? extends K> keyMapper, List<T> coll) {
        if (Objects.isNull(coll) || coll.isEmpty()) {
            return new HashMap<>(0);
        }
        return coll.stream().collect(Collectors.toMap(keyMapper, Function.identity(), (u1, u2) -> u1));
    }

    public static <T, K, U> Map<K, U> toMapKeyValue(Function<? super T, ? extends K> keyMapper,
                                                    Function<? super T, ? extends U> valueMapper,
                                                    List<T> coll) {
        if (Objects.isNull(coll) || coll.isEmpty()) {
            return new HashMap<>(0);
        }
        return coll.stream().collect(Collectors.toMap(keyMapper, valueMapper, (u1, u2) -> u1));
    }

    public static <T, K> Map<K, List<T>> groupingBy(Function<? super T, ? extends K> keyMapper, List<T> coll) {
        if (Objects.isNull(coll) || coll.isEmpty()) {
            return new HashMap<>(0);
        }
        return coll.stream().collect(Collectors.groupingBy(keyMapper));
    }

    public static <T, K> Map<K, List<T>> groupingByLinked(Function<? super T, ? extends K> keyMapper, List<T> coll) {
        if (Objects.isNull(coll) || coll.isEmpty()) {
            return new HashMap<>(0);
        }
        return coll.stream().collect(Collectors.groupingBy(keyMapper, LinkedHashMap::new, Collectors.toList()));
    }

    public static List<String> split(String str) {
        if (Objects.isNull(str) || str.isEmpty()) {
            return new ArrayList<>(0);
        }
        return Arrays.asList(str.split(","));
    }

    public static <T> List<T> getColl(List<T> coll) {
        return Objects.isNull(coll) || coll.isEmpty() ? new ArrayList<>(0) : coll;
    }

}
