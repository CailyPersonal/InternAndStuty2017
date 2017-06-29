package io.terminus.fbw.impl;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by Intellij IDEA
 * Copyright (c) CailyPersonal
 * Version: v1.0
 * Author: Caily
 * Date: 28/06/2017
 */


public class Arguments {

    private static final Logger logger = LoggerFactory.getLogger(Arguments.class);

    public static List<Integer> parse(String... args) {

        logger.debug("");

        // Without args from input, so read from stdin.
        if (0 == args.length) {
            logger.info("No args from input, read from stdin");
            System.out.println("Input here:");
            String arg = new Scanner(System.in).nextLine();
            args = new String[]{arg};
        }

        // Legal count of the input argument is 1 or 3.
        if (1 != args.length && 3 != args.length) {
            throw new IllegalArgumentException("Invalid arguments provided!");
        }

        /**
         * There will be a lot of lambda expression follow, with JDK 8 and Stream API.
         * I found a blog to simply explain lambda and Stream, here is the link:
         *  A. lambda: {@link http://ifeve.com/lambda/}
         *  B. Stream: {@link http://ifeve.com/stream/}
         */
        List<Integer> specialNumbers;
        if (1 == args.length) {
            String arg = args[0].trim();
            if (!Pattern.compile("([0-9]\\s*,\\s*){2}[0-9]").matcher(arg).matches()) {
                throw new IllegalArgumentException("Invalid arguments provided!");
            }

            // Do split and convert operation.
            specialNumbers = Splitter.on(",").omitEmptyStrings().trimResults()
                    .splitToList(arg).stream().map(Integer::valueOf)
                    .collect(Collectors.toList());
        } else {
            Pattern singleNumberPattern = Pattern.compile("[0-9]");
            if (!Arrays.stream(args).allMatch(arg -> singleNumberPattern.matcher(arg).matches())) {
                throw new IllegalArgumentException("Invalid arguments provided!");
            }

            specialNumbers =
                    Arrays.
                            stream(args).                   // Now, T is String.
                            map(Integer::valueOf).          // A lambda expression, it equals: str -> return Integer.valueOf(str);
                            // It will return a Stream of type Integer.

                                    collect(
                                    Collectors.toList()
                            );
        }

        if (ImmutableSet.copyOf(specialNumbers).size() != specialNumbers.size()) {
            throw new IllegalArgumentException("Number duplicated!");
        }

        return specialNumbers;
    }
}
