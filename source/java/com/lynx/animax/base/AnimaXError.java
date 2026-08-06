package com.lynx.animax.base;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public enum AnimaXError {
    NO_ERROR(0),
    RESOURCE_NOT_FOUND(1),
    THREAD_INIT_ERROR(11),
    VIDEO_PLAYER_ERROR(100),
    VIDEO_PLAYER_ERROR_HAS_OCCURRED(101),
    BLOCK_DEVICE(200);

    private final int errorCode;

    AnimaXError(int i) {
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public static Map<String, Object> createBlockErrorParam() {
        HashMap hashMap = new HashMap();
        hashMap.put("code", Integer.valueOf(BLOCK_DEVICE.ordinal()));
        hashMap.put("msg", "The device is not support.");
        return hashMap;
    }

    public static Map<String, Object> createThreadInitErrorParam() {
        HashMap hashMap = new HashMap();
        hashMap.put("code", Integer.valueOf(THREAD_INIT_ERROR.ordinal()));
        hashMap.put("msg", "Thread init error.");
        return hashMap;
    }
}
