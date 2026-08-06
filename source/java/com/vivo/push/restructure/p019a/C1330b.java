package com.vivo.push.restructure.p019a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.restructure.request.p023a.C1340a;
import com.vivo.push.restructure.request.p023a.p024a.C1341a;
import com.vivo.push.util.C1393t;
import com.vivo.push.util.C1394u;
import org.json.JSONException;

/* compiled from: ReceivedMessageImpl.java */
/* renamed from: com.vivo.push.restructure.a.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1330b implements InterfaceC1314a {

    /* renamed from: a */
    private Intent f581a;

    /* renamed from: c */
    private C1340a f583c;

    /* renamed from: e */
    private InsideNotificationItem f585e;

    /* renamed from: f */
    private UnvarnishedMessage f586f;

    /* renamed from: b */
    private String f582b = "";

    /* renamed from: d */
    private String f584d = "";

    public C1330b(Intent intent) {
        this.f581a = intent;
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: a */
    public final String mo819a() {
        Bundle extras;
        Intent intent = this.f581a;
        long j = (intent == null || (extras = intent.getExtras()) == null) ? 0L : extras.getLong("notify_id", 0L);
        return j != 0 ? String.valueOf(j) : "";
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: b */
    public final Intent mo820b() {
        return this.f581a;
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: c */
    public final String mo821c() {
        if (TextUtils.isEmpty(this.f582b)) {
            this.f582b = this.f581a.getStringExtra("req_id");
        }
        return this.f582b;
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: d */
    public final long mo822d() {
        Intent intent = this.f581a;
        if (intent != null) {
            return intent.getLongExtra("ipc_start_time", 0L);
        }
        return 0L;
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: e */
    public final boolean mo823e() {
        Intent intent = this.f581a;
        if (intent != null) {
            return intent.getBooleanExtra("core_support_monitor", false);
        }
        return false;
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: f */
    public final boolean mo824f() {
        Bundle extras;
        Intent intent = this.f581a;
        if (intent == null || (extras = intent.getExtras()) == null) {
            return false;
        }
        return extras.getBoolean("client_collect_node", false);
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: g */
    public final boolean mo825g() {
        C1340a mo826h = mo826h();
        return mo826h != null && mo826h.m883a() == 2018;
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: h */
    public final C1340a mo826h() {
        String stringExtra;
        C1341a c1341a;
        if (this.f583c == null && (stringExtra = this.f581a.getStringExtra("cf_content")) != null) {
            try {
                c1341a = new C1341a(stringExtra);
            } catch (JSONException unused) {
                c1341a = null;
            }
            if (c1341a != null) {
                this.f583c = (C1340a) C1340a.f599a.mo674a(c1341a);
            }
        }
        return this.f583c;
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: i */
    public final String mo827i() {
        if (TextUtils.isEmpty(this.f584d)) {
            this.f584d = this.f581a.getStringExtra("content");
        }
        return this.f584d;
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: j */
    public final int mo828j() {
        Intent intent = this.f581a;
        if (intent == null) {
            return -1;
        }
        int intExtra = intent.getIntExtra("command", -1);
        return intExtra < 0 ? this.f581a.getIntExtra("method", -1) : intExtra;
    }

    /* renamed from: n */
    private boolean m850n() {
        return mo828j() == 4;
    }

    /* renamed from: o */
    private boolean m851o() {
        return mo828j() == 3;
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: k */
    public final boolean mo829k() {
        return mo828j() == 5;
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: l */
    public final int mo830l() {
        if (this.f581a == null) {
            return 0;
        }
        if (m850n() && m852p() != null) {
            return m852p().getTargetType();
        }
        if (!m851o() || m853q() == null) {
            return 0;
        }
        return m853q().getTargetType();
    }

    @Override // com.vivo.push.restructure.p019a.InterfaceC1314a
    /* renamed from: m */
    public final String mo831m() {
        if (this.f581a == null) {
            return "";
        }
        if (!m850n() || m852p() == null) {
            return (!m851o() || m853q() == null) ? "" : m853q().getTragetContent();
        }
        return m852p().getTargetContent();
    }

    /* renamed from: p */
    private InsideNotificationItem m852p() {
        Exception e;
        InsideNotificationItem insideNotificationItem;
        String stringExtra;
        InsideNotificationItem insideNotificationItem2 = this.f585e;
        if (insideNotificationItem2 != null) {
            return insideNotificationItem2;
        }
        Intent intent = this.f581a;
        InsideNotificationItem insideNotificationItem3 = null;
        if (intent != null) {
            try {
                stringExtra = intent.getStringExtra("notification_v1");
            } catch (Exception e2) {
                e = e2;
                insideNotificationItem = null;
            }
            if (stringExtra != null) {
                insideNotificationItem = C1394u.m1050a(stringExtra);
                if (insideNotificationItem != null) {
                    try {
                        insideNotificationItem.setMsgId(Long.parseLong(mo819a()));
                    } catch (Exception e3) {
                        e = e3;
                        C1393t.m1034a("ReceivedMessageImpl", "getNotificationMessage " + e.getMessage());
                        insideNotificationItem3 = insideNotificationItem;
                        this.f585e = insideNotificationItem3;
                        return insideNotificationItem3;
                    }
                }
                insideNotificationItem3 = insideNotificationItem;
            }
        }
        this.f585e = insideNotificationItem3;
        return insideNotificationItem3;
    }

    /* renamed from: q */
    private UnvarnishedMessage m853q() {
        UnvarnishedMessage unvarnishedMessage = this.f586f;
        if (unvarnishedMessage != null) {
            return unvarnishedMessage;
        }
        Intent intent = this.f581a;
        UnvarnishedMessage unvarnishedMessage2 = null;
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("msg_v1");
                if (!TextUtils.isEmpty(stringExtra)) {
                    UnvarnishedMessage unvarnishedMessage3 = new UnvarnishedMessage(stringExtra);
                    try {
                        unvarnishedMessage3.setMsgId(Long.parseLong(mo819a()));
                        unvarnishedMessage2 = unvarnishedMessage3;
                    } catch (Exception e) {
                        e = e;
                        unvarnishedMessage2 = unvarnishedMessage3;
                        C1393t.m1034a("ReceivedMessageImpl", "getTransmissionMessage " + e.getMessage());
                        this.f586f = unvarnishedMessage2;
                        return unvarnishedMessage2;
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
        }
        this.f586f = unvarnishedMessage2;
        return unvarnishedMessage2;
    }
}
