package com.ss.ttm.player;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes7.dex */
public class TTWindowClientMessage {
    public static final int CHANGE_BIND = 7;
    public static final int DISPLAY_SIZE = 0;
    public static final int DISPLAY_SIZE_EXT = 5;
    public static final int FIRST_DREW = 1;
    public static final int LOCK_CPU_BUFFER = 3;
    public static final int RE_CREATE_SURFACE = 4;
    public static final int SURFACE_FIXED_SIZE = 6;
    public static final int SWITCH_RENDER_TYPE = 8;
    public static final int WINDOW_LOAD = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes7.dex */
    public @interface MessageType {
    }
}
