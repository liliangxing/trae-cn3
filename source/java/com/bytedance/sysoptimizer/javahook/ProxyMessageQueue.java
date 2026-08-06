package com.bytedance.sysoptimizer.javahook;

import android.os.Process;
import android.util.Log;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.Npth;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ProxyMessageQueue {
    private static final String TAG = "ProxyMessageQueue";
    private static int MAX_COUNT = 8;
    private static final ArrayDeque<Record> records = new ArrayDeque<>(MAX_COUNT);
    private static final AtomicBoolean sRegisterCrashCallback = new AtomicBoolean(false);

    public int postSyncBarrier() throws Throwable {
        Object callOrigin = AHook.callOrigin(OriginMethodKey.KEY_POST_SYNC_BARRIER, this, new Object[0]);
        int intValue = callOrigin != null ? ((Integer) callOrigin).intValue() : 0;
        AHook.getCallback().mo206d(TAG, "postSyncBarrier ret=[" + intValue + "]");
        return intValue;
    }

    private int postSyncBarrier(long j) throws Throwable {
        registerCrashCallback();
        Record addLast = addLast();
        Object callOrigin = AHook.callOrigin(OriginMethodKey.KEY_POST_SYNC_BARRIER_2, this, Long.valueOf(j));
        int intValue = callOrigin != null ? ((Integer) callOrigin).intValue() : 0;
        addLast.others = "android.os.MessageQueue.postSyncBarrier(J)I, this=[" + this + "], when=[" + j + "], token=[" + intValue + "]";
        return intValue;
    }

    public void removeSyncBarrier(int i) throws Throwable {
        registerCrashCallback();
        addLast().others = "android.os.MessageQueue.removeSyncBarrier(I)V, this=[" + this + "], token=[" + i + "]";
        AHook.callOrigin(OriginMethodKey.KEY_REMOVE_SYNC_BARRIER, this, Integer.valueOf(i));
    }

    private Record addLast() {
        long currentTimeMillis = System.currentTimeMillis();
        Throwable th = new Throwable();
        Record record = new Record();
        record.timestamp = currentTimeMillis;
        record.thread = Thread.currentThread();
        record.tid = Process.myTid();
        record.f259t = th;
        ArrayDeque<Record> arrayDeque = records;
        synchronized (arrayDeque) {
            if (arrayDeque.size() >= MAX_COUNT) {
                arrayDeque.pollFirst();
            }
            arrayDeque.addLast(record);
        }
        return record;
    }

    public static void dump(PrintWriter printWriter) {
        synchronized (records) {
            while (true) {
                Record pollLast = records.pollLast();
                if (pollLast != null) {
                    printWriter.println(pollLast.toString());
                } else {
                    printWriter.flush();
                }
            }
        }
    }

    private static void registerCrashCallback() {
        if (sRegisterCrashCallback.getAndSet(true)) {
            return;
        }
        Npth.registerCrashCallback(new ICrashCallback() { // from class: com.bytedance.sysoptimizer.javahook.ProxyMessageQueue.1
            public void onCrash(CrashType crashType, String str, Thread thread) {
                AHook.getCallback().mo206d(ProxyMessageQueue.TAG, "onCrash() called with: type = [" + crashType + "], crash = [" + str + "], thread = [" + thread + "]");
                if (str == null || !str.contains("The specified message queue synchronization  barrier token has not been posted or has already been removed.")) {
                    return;
                }
                Npth.addAttachLongUserData(new AttachUserData() { // from class: com.bytedance.sysoptimizer.javahook.ProxyMessageQueue.1.1
                    public Map<? extends String, ? extends String> getUserData(CrashType crashType2) {
                        HashMap hashMap = new HashMap();
                        StringWriter stringWriter = new StringWriter();
                        PrintWriter printWriter = new PrintWriter((Writer) stringWriter, true);
                        ProxyMessageQueue.dump(printWriter);
                        printWriter.flush();
                        printWriter.close();
                        String stringWriter2 = stringWriter.toString();
                        AHook.getCallback().mo207e(ProxyMessageQueue.TAG, stringWriter2);
                        hashMap.put("removeSyncBarrier_Data", stringWriter2);
                        return hashMap;
                    }
                }, CrashType.JAVA);
            }
        }, CrashType.JAVA);
        HashMap hashMap = new HashMap();
        hashMap.put("removeSyncBarrier", "1");
        Npth.addTags(hashMap);
        AHook.getCallback().mo206d(TAG, "registerCrashCallback() called");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class Record {
        String others;

        /* renamed from: t */
        Throwable f259t;
        Thread thread;
        int tid;
        long timestamp;

        Record() {
        }

        public String toString() {
            return "Record{time=" + format(this.timestamp) + ", tid=" + this.tid + ", thread=" + this.thread.getName() + ", t=\n" + Log.getStackTraceString(this.f259t) + ", others='" + this.others + "'}";
        }

        private static String format(long j) {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Long.valueOf(j));
        }
    }
}
