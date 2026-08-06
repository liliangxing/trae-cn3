package com.bytedance.monitor.collector.service;

import android.os.Message;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class MessageHandleUtils {
    public static final int BIND_SERVICE = 121;
    public static final int CREATE_SERVICE = 114;
    public static final int DUMP_SERVICE = 123;
    public static final int SERVICE_ARGS = 115;
    public static final int STOP_SERVICE = 116;
    public static final int UNBIND_SERVICE = 122;
    private static Set<Integer> mMessageIds;

    static {
        HashSet hashSet = new HashSet();
        mMessageIds = hashSet;
        hashSet.add(114);
        mMessageIds.add(115);
        mMessageIds.add(116);
        mMessageIds.add(121);
        mMessageIds.add(122);
        mMessageIds.add(123);
    }

    public static boolean isServiceMessage(Message message) {
        return mMessageIds.contains(Integer.valueOf(message.what));
    }
}
