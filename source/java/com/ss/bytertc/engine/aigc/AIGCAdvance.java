package com.ss.bytertc.engine.aigc;

import com.ss.bytertc.engine.NativeRTCRoomFunctions;
import com.ss.bytertc.engine.RTCRoom;
import com.ss.bytertc.engine.utils.LogUtil;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public abstract class AIGCAdvance {
    protected static final String TAG = "AIGCAdvance";
    private static Method mGetNativeMethod;
    private static Method mSetHandlerAIGCMethod;

    private static long getNativeRoomHandle(RTCRoom room) {
        if (mGetNativeMethod == null) {
            try {
                Class<?> cls = Class.forName("com.ss.bytertc.engine.RTCRoomImpl");
                if (cls != null) {
                    mGetNativeMethod = cls.getMethod("getNativeHandle", new Class[0]);
                }
            } catch (Exception unused) {
                LogUtil.m216e(TAG, "fail to find method getNativeHandle");
            }
        }
        Method method = mGetNativeMethod;
        if (method == null) {
            return 0L;
        }
        try {
            return ((Long) method.invoke(room, new Object[0])).longValue();
        } catch (Exception unused2) {
            LogUtil.m216e(TAG, "fail to invoke method getNativeHandle");
            return 0L;
        }
    }

    public static int startSession(RTCRoom room, AIGCSessionConfig sessionConfig) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, enableAutoSubscribe failed.");
            return -1;
        }
        return NativeRTCRoomFunctions.nativeStartSession(nativeRoomHandle, sessionConfig.token, sessionConfig.userInfo, sessionConfig.roomConfig, sessionConfig.type, sessionConfig.action, sessionConfig.message == null ? "" : sessionConfig.message.toString(), sessionConfig.timeout, sessionConfig.joinRoomNeedSdp, sessionConfig.fgConfig);
    }

    public static int clearAudioCache(RTCRoom room) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, enableAutoSubscribe failed.");
            return -1;
        }
        return NativeRTCRoomFunctions.nativeClearAudioCache(nativeRoomHandle);
    }

    public static int enableAudioCache(RTCRoom room, boolean enable) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, enableAutoSubscribe failed.");
            return -1;
        }
        return NativeRTCRoomFunctions.nativeEnableAudioCache(nativeRoomHandle, enable);
    }

    public static int stopSession(RTCRoom room) {
        long nativeRoomHandle = getNativeRoomHandle(room);
        if (nativeRoomHandle == 0) {
            LogUtil.m216e(TAG, "room native handle is invalid, enableAutoSubscribe failed.");
            return -1;
        }
        return NativeRTCRoomFunctions.nativeStopSession(nativeRoomHandle);
    }

    public static int setRTCRoomEventHandlerAIGC(RTCRoom room, IRTCRoomEventHandlerAIGC handlerAIGC) {
        if (mSetHandlerAIGCMethod == null) {
            try {
                Class<?> cls = Class.forName("com.ss.bytertc.engine.RTCRoomImpl");
                if (cls != null) {
                    mSetHandlerAIGCMethod = cls.getMethod("setRTCRoomEventHandlerAIGC", IRTCRoomEventHandlerAIGC.class);
                }
            } catch (Exception unused) {
                LogUtil.m216e(TAG, "fail to find method getNativeHandle");
            }
        }
        Method method = mSetHandlerAIGCMethod;
        if (method == null) {
            return 0;
        }
        try {
            return ((Integer) method.invoke(room, handlerAIGC)).intValue();
        } catch (Exception unused2) {
            LogUtil.m216e(TAG, "fail to invoke method getNativeHandle");
            return 0;
        }
    }
}
