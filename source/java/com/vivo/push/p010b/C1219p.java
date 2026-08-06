package com.vivo.push.p010b;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1232d;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.util.C1394u;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: OnNotificationClickReceiveCommand.java */
/* renamed from: com.vivo.push.b.p */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1219p extends AbstractC1400v {

    /* renamed from: a */
    private String f362a;

    /* renamed from: b */
    private String f363b;

    /* renamed from: c */
    private byte[] f364c;

    /* renamed from: d */
    private long f365d;

    /* renamed from: e */
    private InsideNotificationItem f366e;

    /* renamed from: f */
    private String f367f;

    /* renamed from: g */
    private String f368g;

    /* renamed from: h */
    private Uri f369h;

    /* renamed from: i */
    private String f370i;

    /* renamed from: j */
    private Bundle f371j;

    @Override // com.vivo.push.AbstractC1400v
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    public C1219p(String str, long j, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.f362a = str;
        this.f365d = j;
        this.f366e = insideNotificationItem;
    }

    public C1219p() {
        super(5);
    }

    /* renamed from: e */
    public final String m614e() {
        return this.f362a;
    }

    /* renamed from: f */
    public final long m615f() {
        return this.f365d;
    }

    /* renamed from: g */
    public final InsideNotificationItem m616g() {
        return this.f366e;
    }

    /* renamed from: h */
    public final String m617h() {
        return this.f367f;
    }

    /* renamed from: b */
    public final void m611b(String str) {
        this.f367f = str;
    }

    /* renamed from: i */
    public final String m618i() {
        return this.f368g;
    }

    /* renamed from: c */
    public final void m612c(String str) {
        this.f368g = str;
    }

    /* renamed from: j */
    public final String m619j() {
        return this.f370i;
    }

    /* renamed from: d */
    public final void m613d(String str) {
        this.f370i = str;
    }

    /* renamed from: k */
    public final Uri m620k() {
        return this.f369h;
    }

    /* renamed from: a */
    public final void m610a(Uri uri) {
        this.f369h = uri;
    }

    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: c */
    protected final void mo582c(C1232d c1232d) {
        c1232d.m654a(Constants.PACKAGE_NAME, this.f362a);
        c1232d.m652a("notify_id", this.f365d);
        c1232d.m654a("notification_v1", C1394u.m1052b(this.f366e));
        c1232d.m654a("open_pkg_name", this.f363b);
        c1232d.m657a("open_pkg_name_encode", this.f364c);
        c1232d.m654a("notify_action", this.f367f);
        c1232d.m654a("notify_componet_pkg", this.f368g);
        c1232d.m654a("notify_componet_class_name", this.f370i);
        Uri uri = this.f369h;
        if (uri != null) {
            c1232d.m654a("notify_uri_data", uri.toString());
        }
    }

    /* renamed from: e */
    private static Uri m609e(String str) {
        try {
            return Uri.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: d */
    protected final void mo583d(C1232d c1232d) {
        this.f362a = c1232d.m650a(Constants.PACKAGE_NAME);
        this.f365d = c1232d.m659b("notify_id", -1L);
        this.f363b = c1232d.m650a("open_pkg_name");
        this.f364c = c1232d.m661b("open_pkg_name_encode");
        this.f367f = c1232d.m650a("notify_action");
        this.f368g = c1232d.m650a("notify_componet_pkg");
        this.f370i = c1232d.m650a("notify_componet_class_name");
        String m650a = c1232d.m650a("notification_v1");
        if (!TextUtils.isEmpty(m650a)) {
            this.f366e = C1394u.m1050a(m650a);
        }
        InsideNotificationItem insideNotificationItem = this.f366e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f365d);
        }
        String m650a2 = c1232d.m650a("notify_uri_data");
        if (!TextUtils.isEmpty(m650a2)) {
            this.f369h = m609e(m650a2);
        }
        this.f371j = c1232d.m660b();
    }

    /* renamed from: l */
    public final Bundle m621l() {
        if (this.f371j == null) {
            return null;
        }
        Bundle bundle = new Bundle(this.f371j);
        try {
            bundle.remove("command_type");
            bundle.remove("security_avoid_pull");
            bundle.remove("security_avoid_pull_rsa");
            bundle.remove("security_avoid_rsa_public_key");
            bundle.remove("security_avoid_rsa_public_key");
            bundle.remove("notify_action");
            bundle.remove("notify_componet_pkg");
            bundle.remove("notify_componet_class_name");
            bundle.remove("notification_v1");
            bundle.remove("command");
            bundle.remove(Constants.PACKAGE_NAME);
            bundle.remove("method");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bundle;
    }
}
