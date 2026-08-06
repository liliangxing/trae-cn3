package com.bytedance.helios.statichook.window;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class WindowViewHook {
    private static final List<WindowViewInvoker> invokers = new ArrayList();

    private static void initInvokers() {
    }

    static {
        initInvokers();
    }

    public static void onWindowViewAdded(Object[] objArr) {
        Iterator<WindowViewInvoker> it = invokers.iterator();
        while (it.hasNext()) {
            try {
                it.next().onWindowViewAdded(objArr);
            } catch (Exception e) {
                Log.e("WindowViewHook", null, e);
            }
        }
    }

    public static void onWindowViewRemoved(Object[] objArr) {
        Iterator<WindowViewInvoker> it = invokers.iterator();
        while (it.hasNext()) {
            try {
                it.next().onWindowViewRemoved(objArr);
            } catch (Exception e) {
                Log.e("WindowViewHook", null, e);
            }
        }
    }
}
