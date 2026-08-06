package com.bytedance.platform.horae.java_impl.sync;

import android.os.Handler;
import android.os.Message;
import com.bytedance.platform.horae.common.ActivityThreadUtils;
import com.bytedance.platform.horae.common.Logger;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class SyncMessageHandleUtils {
    private static final int BIND_SERVICE = 121;
    private static final int CREATE_SERVICE = 114;
    private static final int DUMP_SERVICE = 123;
    private static final int RECEIVER = 113;
    private static final int SERVICE_ARGS = 115;
    public static final int STOP_SERVICE = 116;
    private static final int UNBIND_SERVICE = 122;
    private static Set<Integer> mMessageIds;

    static {
        HashSet hashSet = new HashSet();
        mMessageIds = hashSet;
        hashSet.add(113);
        mMessageIds.add(114);
        mMessageIds.add(115);
        mMessageIds.add(116);
        mMessageIds.add(121);
        mMessageIds.add(122);
        mMessageIds.add(123);
    }

    public static void handleMessage(Message message) {
        if (message == null) {
            return;
        }
        Logger.e("MessageHandleUtils", "Success handle delay message " + message.what + "!");
        ((Handler) ActivityThreadUtils.getHInActivityThread()).dispatchMessage(message);
    }

    public static boolean isServiceOrReceiverMessage(Message message) {
        if (message.getTarget() != ActivityThreadUtils.getHInActivityThread()) {
            return false;
        }
        return mMessageIds.contains(Integer.valueOf(message.what));
    }
}
