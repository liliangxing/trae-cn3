package com.bytedance.platform.horae.java_impl.async;

import android.os.Handler;
import android.os.Message;
import com.bytedance.platform.horae.common.ActivityThreadUtils;
import com.bytedance.platform.horae.common.Logger;
import com.bytedance.platform.horae.java_impl.ServiceFollowBean;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
public class AsyncMessageHandleUtils {
    private static final int BIND_SERVICE = 121;
    public static final int CONFIGURATION_CHANGED = 118;
    private static final int CREATE_SERVICE = 114;
    private static final int DUMP_SERVICE = 123;
    private static final Object LOCK;
    public static final int MESSAGE_HANDLED_ASYNC = 1000089;
    public static final int RECEIVER = 113;
    private static final int SERVICE_ARGS = 115;
    public static final int STOP_SERVICE = 116;
    public static final int TRIM_MEMORY = 140;
    private static final int UNBIND_SERVICE = 122;
    private static final Set<String> sIgnoreTokens;
    private static Set<String> sNoScheduleList;
    private static Set<Integer> ASYNC_MESSAGE_IDS = new HashSet();
    private static Set<Integer> MESSAGE_NEED_BE_LOCKED_ID = new HashSet();
    private static final Object LOCK_FOR_SERVICES_IN_ACTIVITY_THREAD = new Object();

    static {
        ASYNC_MESSAGE_IDS.add(113);
        ASYNC_MESSAGE_IDS.add(114);
        ASYNC_MESSAGE_IDS.add(115);
        ASYNC_MESSAGE_IDS.add(116);
        ASYNC_MESSAGE_IDS.add(121);
        ASYNC_MESSAGE_IDS.add(122);
        ASYNC_MESSAGE_IDS.add(123);
        MESSAGE_NEED_BE_LOCKED_ID.add(140);
        MESSAGE_NEED_BE_LOCKED_ID.add(118);
        MESSAGE_NEED_BE_LOCKED_ID.add(113);
        MESSAGE_NEED_BE_LOCKED_ID.add(114);
        MESSAGE_NEED_BE_LOCKED_ID.add(115);
        MESSAGE_NEED_BE_LOCKED_ID.add(116);
        MESSAGE_NEED_BE_LOCKED_ID.add(121);
        MESSAGE_NEED_BE_LOCKED_ID.add(122);
        MESSAGE_NEED_BE_LOCKED_ID.add(123);
        sIgnoreTokens = new HashSet();
        LOCK = new Object();
    }

    public static void handleMessage(Message message) {
        if (message == null) {
            return;
        }
        Logger.e("MessageHandleUtils", "Success handle delay message " + message.what + "!");
        Handler handler = (Handler) ActivityThreadUtils.getHInActivityThread();
        synchronized (LOCK_FOR_SERVICES_IN_ACTIVITY_THREAD) {
            message.arg2 = MESSAGE_HANDLED_ASYNC;
            handler.dispatchMessage(message);
        }
    }

    public static boolean isServiceOrReceiverMessage(Message message) {
        return message.getTarget() == ActivityThreadUtils.getHInActivityThread() && ASYNC_MESSAGE_IDS.contains(Integer.valueOf(message.what)) && !hintNoScheduleList(message);
    }

    public static boolean isMessageNeedBeLocked(Message message) {
        if (message.getTarget() != ActivityThreadUtils.getHInActivityThread()) {
            return false;
        }
        return MESSAGE_NEED_BE_LOCKED_ID.contains(Integer.valueOf(message.what));
    }

    public static void setNoOptList(Set<String> set) {
        sNoScheduleList = set;
    }

    private static boolean hintNoScheduleList(Message message) {
        boolean z;
        if (message == null) {
            throw new RuntimeException("Argument can not be null");
        }
        Set<String> set = sNoScheduleList;
        if (set == null || set.isEmpty()) {
            return false;
        }
        ServiceFollowBean fetchServiceName = ServiceFollowBean.fetchServiceName(message);
        synchronized (LOCK) {
            if (message.what == 114 && sNoScheduleList.contains(fetchServiceName.mServiceName)) {
                sIgnoreTokens.add(fetchServiceName.mToken);
            }
            z = sNoScheduleList.contains(fetchServiceName.mServiceName) || sIgnoreTokens.contains(fetchServiceName.mToken);
        }
        return z;
    }
}
