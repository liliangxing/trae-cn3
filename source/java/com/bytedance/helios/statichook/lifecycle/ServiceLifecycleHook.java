package com.bytedance.helios.statichook.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ServiceLifecycleHook {
    private static final List<ServiceLifecycleInvoker> invokers = new ArrayList();

    private static void initInvokers() {
    }

    static {
        initInvokers();
    }

    public static void onStartCommand(Service service, Intent intent, int i, int i2) {
        Iterator<ServiceLifecycleInvoker> it = invokers.iterator();
        while (it.hasNext()) {
            try {
                it.next().onStartCommand(service, intent, i, i2);
            } catch (Exception e) {
                Log.e("ServiceLifecycleHook", null, e);
            }
        }
    }
}
