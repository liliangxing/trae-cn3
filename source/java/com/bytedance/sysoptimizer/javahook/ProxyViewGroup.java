package com.bytedance.sysoptimizer.javahook;

import android.util.Log;
import android.view.View;
import com.bytedance.crash.AttachUserData;
import com.bytedance.crash.CrashType;
import com.bytedance.crash.ICrashCallback;
import com.bytedance.crash.Npth;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class ProxyViewGroup {
    private static final int MAX_COUNT = 4;
    private static final String TAG = "ProxyViewGroup";
    private static final ArrayDeque<RemoveInfo> infos = new ArrayDeque<>(4);
    private static final AtomicBoolean needRegisterHook = new AtomicBoolean(true);

    static /* synthetic */ String access$000() {
        return getInfo();
    }

    public void removeAllViews() throws Throwable {
        addHookInfoIfEnabled(this);
        AHook.callOrigin(OriginMethodKey.KEY_VIEWGROUP_REMOVEALLVIEWS, this, new Object[0]);
    }

    public void removeAllViewsInLayout() throws Throwable {
        addHookInfoIfEnabled(this);
        AHook.callOrigin(OriginMethodKey.KEY_VIEWGROUP_REMOVEALLVIEWSINLAYOUT, this, new Object[0]);
    }

    public void removeView(View view) throws Throwable {
        addHookInfoIfEnabled(this, view);
        AHook.callOrigin(OriginMethodKey.KEY_VIEWGROUP_REMOVEVIEW, this, view);
    }

    public void removeViewAt(int i) throws Throwable {
        addHookInfoIfEnabled(this);
        AHook.callOrigin(OriginMethodKey.KEY_VIEWGROUP_REMOVEVIEWAT, this, Integer.valueOf(i));
    }

    public void removeViewInLayout(View view) throws Throwable {
        addHookInfoIfEnabled(this, view);
        AHook.callOrigin(OriginMethodKey.KEY_VIEWGROUP_REMOVEVIEWINLAYOUT, this, view);
    }

    public void removeViews(int i, int i2) throws Throwable {
        addHookInfoIfEnabled(this);
        AHook.callOrigin(OriginMethodKey.KEY_VIEWGROUP_REMOVEVIEWS, this, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public void removeViewsInLayout(int i, int i2) throws Throwable {
        addHookInfoIfEnabled(this);
        AHook.callOrigin(OriginMethodKey.KEY_VIEWGROUP_REMOVEVIEWSINLAYOUT, this, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public static void addHookInfoIfEnabled(Object obj) {
        addHookInfoIfEnabled(obj, null);
    }

    public static void addHookInfoIfEnabled(Object obj, View view) {
        traceInfo(new RemoveInfo(formDesc(obj, view)));
    }

    private static void traceInfo(RemoveInfo removeInfo) {
        ArrayDeque<RemoveInfo> arrayDeque = infos;
        synchronized (arrayDeque) {
            if (arrayDeque.size() >= 4) {
                arrayDeque.pollFirst();
            }
            arrayDeque.addLast(removeInfo);
        }
        initHook();
    }

    private static void initHook() {
        if (needRegisterHook.getAndSet(false)) {
            ICrashCallback iCrashCallback = new ICrashCallback() { // from class: com.bytedance.sysoptimizer.javahook.ProxyViewGroup.1
                public void onCrash(CrashType crashType, String str, Thread thread) {
                    if (str == null || !str.contains("Attempt to invoke virtual method 'int android.view.View.getVisibility()' on a null object reference")) {
                        return;
                    }
                    AttachUserData attachUserData = new AttachUserData() { // from class: com.bytedance.sysoptimizer.javahook.ProxyViewGroup.1.1
                        public Map<? extends String, ? extends String> getUserData(CrashType crashType2) {
                            HashMap hashMap = new HashMap();
                            String access$000 = ProxyViewGroup.access$000();
                            AHook.getCallback().mo207e(ProxyViewGroup.TAG, access$000);
                            hashMap.put("ProxyViewGroupRemoveView", access$000);
                            return hashMap;
                        }
                    };
                    Npth.addAttachLongUserData(attachUserData, CrashType.JAVA);
                    Npth.addAttachLongUserData(attachUserData, CrashType.LAUNCH);
                }
            };
            Npth.registerCrashCallback(iCrashCallback, CrashType.JAVA);
            Npth.registerCrashCallback(iCrashCallback, CrashType.LAUNCH);
            HashMap hashMap = new HashMap();
            hashMap.put("ProxyViewGroupRemoveView", "1");
            Npth.addTags(hashMap);
            AHook.getCallback().mo207e(TAG, "initHook");
        }
    }

    private static String getInfo() {
        StringBuilder sb = new StringBuilder();
        synchronized (infos) {
            while (true) {
                RemoveInfo pollLast = infos.pollLast();
                if (pollLast != null) {
                    sb.append(pollLast).append("\n\n");
                }
            }
        }
        return sb.toString();
    }

    private static String formDesc(Object obj, View view) {
        if (obj == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("container: ");
        sb.append(obj);
        if (view != null) {
            sb.append(", child: ").append(view);
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class RemoveInfo {
        private final String desc;
        private final long time = System.currentTimeMillis();
        private final String threadName = Thread.currentThread().getName();
        private final Throwable stack = new Throwable();

        RemoveInfo(String str) {
            this.desc = str;
        }

        public String toString() {
            return "time: " + this.time + ", thread: " + this.threadName + "\ndesc: " + this.desc + "\nstack: " + Log.getStackTraceString(this.stack);
        }
    }
}
