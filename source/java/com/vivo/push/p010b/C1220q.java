package com.vivo.push.p010b;

import android.text.TextUtils;
import com.vivo.push.C1232d;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.util.C1394u;

/* compiled from: OnNotifyArrivedReceiveCommand.java */
/* renamed from: com.vivo.push.b.q */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1220q extends AbstractC1226w {

    /* renamed from: a */
    protected InsideNotificationItem f372a;

    /* renamed from: b */
    private String f373b;

    @Override // com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    public final String toString() {
        return "OnNotifyArrivedCommand";
    }

    public C1220q() {
        super(4);
    }

    /* renamed from: e */
    public final InsideNotificationItem m622e() {
        return this.f372a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.AbstractC1226w, com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public final void mo582c(C1232d c1232d) {
        super.mo582c(c1232d);
        String m1052b = C1394u.m1052b(this.f372a);
        this.f373b = m1052b;
        c1232d.m654a("notification_v1", m1052b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.p010b.AbstractC1226w, com.vivo.push.p010b.C1223t, com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public final void mo583d(C1232d c1232d) {
        super.mo583d(c1232d);
        String m650a = c1232d.m650a("notification_v1");
        this.f373b = m650a;
        if (TextUtils.isEmpty(m650a)) {
            return;
        }
        InsideNotificationItem m1050a = C1394u.m1050a(this.f373b);
        this.f372a = m1050a;
        if (m1050a != null) {
            m1050a.setMsgId(m632h());
        }
    }

    /* renamed from: f */
    public final String m623f() {
        if (!TextUtils.isEmpty(this.f373b)) {
            return this.f373b;
        }
        InsideNotificationItem insideNotificationItem = this.f372a;
        if (insideNotificationItem == null) {
            return null;
        }
        return C1394u.m1052b(insideNotificationItem);
    }

    /* renamed from: g */
    public final boolean m624g() {
        InsideNotificationItem insideNotificationItem = this.f372a;
        return insideNotificationItem != null && insideNotificationItem.isNoShowOnForeground();
    }
}
