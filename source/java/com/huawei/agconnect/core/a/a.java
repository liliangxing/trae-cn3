package com.huawei.agconnect.core.a;

import com.huawei.agconnect.AGCInitFinishManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes6.dex */
public class a extends AGCInitFinishManager {
    private static final List<AGCInitFinishManager.AGCInitFinishCallback> a = new CopyOnWriteArrayList();

    public static void a() {
        Iterator<AGCInitFinishManager.AGCInitFinishCallback> it = a.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
    }

    @Override // com.huawei.agconnect.AGCInitFinishManager
    public void addAGCInitFinishCallback(AGCInitFinishManager.AGCInitFinishCallback aGCInitFinishCallback) {
        if (aGCInitFinishCallback != null) {
            a.add(aGCInitFinishCallback);
        }
    }
}
