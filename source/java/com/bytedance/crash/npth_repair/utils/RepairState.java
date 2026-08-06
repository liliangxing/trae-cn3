package com.bytedance.crash.npth_repair.utils;

/* loaded from: classes3.dex */
public class RepairState {
    public static final int ALL_OK = 0;
    public static final int ERR_BAD_CONTEXT = -7;
    public static final int ERR_FIXED = -2;
    public static final int ERR_FIX_DENY = -6;
    public static final int ERR_INIT_NATIVE_EXCEPTION = -3;
    public static final int ERR_LOAD_LIBRARY = -5;
    public static final int ERR_NATIVE_EXCEPTION = -4;
    public static final int ERR_UNINIT = -1;
    public static final int STATE_DUMPED = 1114;
    public static final int STATE_FAIL = 1112;
    public static final int STATE_RAW = 1110;
    public static final int STATE_STOPPED = 1113;
    public static final int STATE_SUCCESS = 1111;
}
