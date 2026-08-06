package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.event.AutoTrackEventType;
import com.bytedance.tobshadow.bdtracker.C0453k;

/* renamed from: com.bytedance.tobshadow.bdtracker.d0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0405d0 implements C0453k.e {

    /* renamed from: a */
    public final /* synthetic */ C0549x4 f492a;

    public C0405d0(C0549x4 c0549x4) {
        this.f492a = c0549x4;
    }

    @Override // com.bytedance.tobshadow.bdtracker.C0453k.e
    /* renamed from: a */
    public boolean mo248a(C0467m c0467m) {
        if (!c0467m.isBavEnabled()) {
            return false;
        }
        if ((c0467m.getInitConfig() == null || AutoTrackEventType.m227a(c0467m.getInitConfig().getAutoTrackEventType(), 2)) && !c0467m.isAutoTrackPageIgnored(this.f492a.f1240E)) {
            return !this.f492a.f1239D || c0467m.getInitConfig() == null || c0467m.getInitConfig().isAutoTrackFragmentEnabled();
        }
        return false;
    }
}
