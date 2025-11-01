package io.taiga.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.UUID;

public final class TestUtils {

    public static String randomString(int len) {
        return RandomStringUtils.secure().nextAlphanumeric(len);
    }

    public static String randomLetters(int len) {
        return RandomStringUtils.secure().nextAlphabetic(len);
    }

    public static String randomLowcaseString(int len) {
        return RandomStringUtils.secure().nextAlphabetic(len).toLowerCase();
    }


    public static String randomUppercaseString(int len) {
        return RandomStringUtils.secure().nextAlphabetic(len).toUpperCase();
    }

    public static String randomNumber(int len) {
        return RandomStringUtils.secure().nextNumeric(len);
    }

    public static String randomPassword(int len) {
        return RandomStringUtils.secure().nextGraph(len);
    }


    public static String randomUsername(int len) {
        return randomString(8);
    }

    public static String randomEmail() {
        return randomLowcaseString(8) + "@" + randomLowcaseString(4) + ".test";
    }


    public static String randomRealEmail() {
        return randomLowcaseString(8) + "@grr.la";
    }

    public static String currentTimeMillis() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static int randomInt(int len) {
        return Integer.parseInt(randomNumber(len));
    }

    public static long randomInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

}
