package com.bytedance.sysoptimizer.javahook;

import android.os.Process;
import android.util.Log;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.Npth;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ProxyArrayList {
    private static final int MAX_COUNT = 8;
    private static final String TAG = "ProxyArrayList";
    private static final ArrayDeque<RemoveInfo> infos = new ArrayDeque<>(8);
    private static final AtomicBoolean needRegisterHook = new AtomicBoolean(true);

    private static String toString1(Object obj) {
        return obj instanceof ArrayList ? obj.getClass().getName() + "@" + Integer.toHexString(obj.hashCode()) : "";
    }

    public Object remove(int i) throws Throwable {
        RemoveInfo removeInfo = new RemoveInfo();
        traceInfo(removeInfo);
        removeInfo.desc = toString1(this) + " remove : index = [" + i + "]";
        return AHook.callOrigin(OriginMethodKey.KEY_ARRAYLIST_REMOVE, this, Integer.valueOf(i));
    }

    public boolean remove(Object obj) throws Throwable {
        RemoveInfo removeInfo = new RemoveInfo();
        traceInfo(removeInfo);
        removeInfo.desc = toString1(this) + " remove : o = [" + obj + "]";
        Object callOrigin = AHook.callOrigin(OriginMethodKey.KEY_ARRAYLIST_REMOVE_1, this, obj);
        return callOrigin != null && ((Boolean) callOrigin).booleanValue();
    }

    private static void traceInfo(RemoveInfo removeInfo) {
        ArrayDeque<RemoveInfo> arrayDeque = infos;
        synchronized (arrayDeque) {
            if (arrayDeque.size() >= 8) {
                arrayDeque.pollFirst();
            }
            arrayDeque.addLast(removeInfo);
        }
        initHook();
    }

    private static void initHook() {
        if (needRegisterHook.getAndSet(false)) {
            ICrashCallback iCrashCallback = new ICrashCallback() { // from class: com.bytedance.sysoptimizer.javahook.ProxyArrayList$$ExternalSyntheticLambda0
                public final void onCrash(CrashType crashType, String str, Thread thread) {
                    ProxyArrayList.lambda$initHook$1(crashType, str, thread);
                }
            };
            Npth.registerCrashCallback(iCrashCallback, CrashType.JAVA);
            Npth.registerCrashCallback(iCrashCallback, CrashType.LAUNCH);
            HashMap hashMap = new HashMap();
            hashMap.put("ProxyArrayListRemove", "1");
            Npth.addTags(hashMap);
            AHook.getCallback().mo207e(TAG, "initHook");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$initHook$1(CrashType crashType, String str, Thread thread) {
        if (str != null && str.contains("java.util.ConcurrentModificationException") && str.contains("java.util.ArrayList$Itr.next")) {
            AttachUserData attachUserData = new AttachUserData() { // from class: com.bytedance.sysoptimizer.javahook.ProxyArrayList$$ExternalSyntheticLambda1
                public final Map getUserData(CrashType crashType2) {
                    return ProxyArrayList.lambda$null$0(crashType2);
                }
            };
            Npth.addAttachLongUserData(attachUserData, CrashType.JAVA);
            Npth.addAttachLongUserData(attachUserData, CrashType.LAUNCH);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Map lambda$null$0(CrashType crashType) {
        HashMap hashMap = new HashMap();
        String info = getInfo();
        AHook.getCallback().mo207e(TAG, info);
        hashMap.put("ProxyArrayListRemove", info);
        return hashMap;
    }

    public static String getInfo() {
        StringBuilder sb = new StringBuilder();
        synchronized (infos) {
            int i = 0;
            while (true) {
                RemoveInfo pollLast = infos.pollLast();
                if (pollLast != null) {
                    sb.append("#").append(i).append(":").append(pollLast).append("\n\n");
                    i++;
                }
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class RemoveInfo {
        public String desc;
        private final long time = System.currentTimeMillis();
        private final int tid = Process.myTid();
        private final String threadName = Thread.currentThread().getName();
        private final Throwable stack = new Throwable();

        RemoveInfo() {
        }

        public String toString() {
            return "time: " + format(this.time) + ", tid: " + this.tid + ", thread: " + this.threadName + "\ndesc: " + this.desc + "\nstack: " + Log.getStackTraceString(this.stack);
        }

        private static String format(long j) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Long.valueOf(j));
        }
    }
}
