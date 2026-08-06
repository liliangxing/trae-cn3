package com.huawei.agconnect.core.p017a;

import com.huawei.agconnect.AGCInitFinishManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.huawei.agconnect.core.a.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0990a extends AGCInitFinishManager {

    /* renamed from: a */
    private static final List<AGCInitFinishManager.AGCInitFinishCallback> f866a = new CopyOnWriteArrayList();

    /* renamed from: a */
    public static void m829a() {
        Iterator<AGCInitFinishManager.AGCInitFinishCallback> it = f866a.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
    }

    @Override // com.huawei.agconnect.AGCInitFinishManager
    public void addAGCInitFinishCallback(AGCInitFinishManager.AGCInitFinishCallback aGCInitFinishCallback) {
        if (aGCInitFinishCallback != null) {
            f866a.add(aGCInitFinishCallback);
        }
    }
}
