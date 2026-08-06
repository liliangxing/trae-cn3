package com.heytap.mcssdk.p014e;

import android.content.Context;
import android.content.Intent;
import com.heytap.mcssdk.constant.C0879b;
import com.heytap.mcssdk.p012c.C0877b;
import com.heytap.mcssdk.utils.C0893b;
import com.heytap.mcssdk.utils.C0895d;
import com.heytap.msp.push.mode.BaseMode;

/* renamed from: com.heytap.mcssdk.e.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0884a extends AbstractC0886c {

    /* renamed from: a */
    private static final String f608a = "a";

    @Override // com.heytap.mcssdk.p014e.InterfaceC0887d
    /* renamed from: a */
    public BaseMode mo632a(Context context, int i, Intent intent) {
        if (4105 == i) {
            return mo633a(intent, i);
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0100: MOVE (r5 I:??[OBJECT, ARRAY]) = (r6 I:??[OBJECT, ARRAY]), block:B:26:0x0100 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.heytap.mcssdk.p014e.AbstractC0886c
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected BaseMode mo633a(Intent intent, int i) {
        C0877b c0877b;
        Exception e;
        C0877b c0877b2;
        C0877b c0877b3 = null;
        try {
            try {
                c0877b = new C0877b();
                try {
                    c0877b.m589a(Integer.parseInt(C0893b.m652d(intent.getStringExtra(C0879b.f581y))));
                    c0877b.m592b(Integer.parseInt(C0893b.m652d(intent.getStringExtra("code"))));
                    c0877b.m599e(C0893b.m652d(intent.getStringExtra("content")));
                    c0877b.m590a(C0893b.m652d(intent.getStringExtra(C0879b.f582z)));
                    c0877b.m593b(C0893b.m652d(intent.getStringExtra(C0879b.f552A)));
                    c0877b.m603g(C0893b.m652d(intent.getStringExtra(C0879b.f561e)));
                    String str = f608a;
                    C0895d.m662b(str, "parseMessageByIntent() finally will get miniProgramPkg");
                    try {
                        C0895d.m662b(str, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                        c0877b.m601f(intent.getStringExtra("miniProgramPkg"));
                        C0895d.m661b("OnHandleIntent-message:" + c0877b.toString());
                    } catch (Exception e2) {
                        C0895d.m661b("OnHandleIntent--" + e2.getMessage() + " ");
                    }
                    return c0877b;
                } catch (Exception e3) {
                    e = e3;
                    C0895d.m661b("OnHandleIntent--" + e.getMessage());
                    String str2 = f608a;
                    C0895d.m662b(str2, "parseMessageByIntent() finally will get miniProgramPkg");
                    if (c0877b != null) {
                        try {
                            C0895d.m662b(str2, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                            c0877b.m601f(intent.getStringExtra("miniProgramPkg"));
                            C0895d.m661b("OnHandleIntent-message:" + c0877b.toString());
                        } catch (Exception e4) {
                            C0895d.m661b("OnHandleIntent--" + e4.getMessage() + " ");
                        }
                    }
                    return c0877b;
                }
            } catch (Throwable unused) {
                c0877b3 = c0877b2;
                String str3 = f608a;
                C0895d.m662b(str3, "parseMessageByIntent() finally will get miniProgramPkg");
                if (c0877b3 != null) {
                    try {
                        C0895d.m662b(str3, "parseMessageByIntent() miniProgramPkg : message is not null and will get miniProgramPkg from intent .");
                        c0877b3.m601f(intent.getStringExtra("miniProgramPkg"));
                        C0895d.m661b("OnHandleIntent-message:" + c0877b3.toString());
                    } catch (Exception e5) {
                        C0895d.m661b("OnHandleIntent--" + e5.getMessage() + " ");
                    }
                }
                return c0877b3;
            }
        } catch (Exception e6) {
            c0877b = null;
            e = e6;
        } catch (Throwable unused2) {
            String str32 = f608a;
            C0895d.m662b(str32, "parseMessageByIntent() finally will get miniProgramPkg");
            if (c0877b3 != null) {
            }
            return c0877b3;
        }
    }
}
