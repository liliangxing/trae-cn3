package com.bytedance.trae.conversation.extract;

public final class FileLogger {
    public static void log(String tag, String message) {
        log(tag, message, null);
    }

    public static void log(String tag, String message, Throwable throwable) {
        System.out.println("[" + tag + "] " + message);
        if (throwable != null) {
            throwable.printStackTrace(System.out);
        }
    }
}
