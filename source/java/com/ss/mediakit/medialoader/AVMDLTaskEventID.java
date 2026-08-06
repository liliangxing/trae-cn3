package com.ss.mediakit.medialoader;

/* loaded from: classes7.dex */
public class AVMDLTaskEventID {
    public static final int TaskEventEnd = 1;
    private static final int TaskEventIdEnd = 2;
    private static final int TaskEventIdStart = -1;
    public static final int TaskEventStart = 0;
    public static final int TaskTypeCache = 3;
    private static final int TaskTypeEnd = 4;
    public static final int TaskTypePlay = 1;
    public static final int TaskTypePreload = 2;
    private static final int TaskTypeStart = 0;

    public static boolean eventTypeIsValid(int i) {
        return i > -1 && i < 2;
    }

    public static boolean taskTypeIsValid(int i) {
        return i > 0 && i < 4;
    }
}
