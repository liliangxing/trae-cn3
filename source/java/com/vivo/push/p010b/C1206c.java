package com.vivo.push.p010b;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.deviceregister.base.RegistrationHeaderHelper;
import com.vivo.push.AbstractC1400v;
import com.vivo.push.C1232d;
import com.vivo.push.util.C1366aa;
import com.vivo.push.util.C1393t;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: BaseAppCommand.java */
/* renamed from: com.vivo.push.b.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1206c extends AbstractC1400v {

    /* renamed from: a */
    private String f338a;

    /* renamed from: b */
    private String f339b;

    /* renamed from: c */
    private long f340c;

    /* renamed from: d */
    private int f341d;

    /* renamed from: e */
    private int f342e;

    /* renamed from: f */
    private String f343f;

    /* renamed from: g */
    private String f344g;

    /* renamed from: h */
    private String f345h;

    @Override // com.vivo.push.AbstractC1400v
    public String toString() {
        return "BaseAppCommand";
    }

    public C1206c(int i, String str) {
        super(i);
        this.f340c = -1L;
        this.f341d = -1;
        this.f338a = null;
        this.f339b = str;
    }

    /* renamed from: e */
    public final int m590e() {
        return this.f342e;
    }

    /* renamed from: b */
    public final void m586b(int i) {
        this.f342e = i;
    }

    /* renamed from: f */
    public final void m591f() {
        this.f343f = null;
    }

    /* renamed from: a */
    public final int m585a(Context context) {
        if (this.f341d == -1) {
            String str = this.f339b;
            if (TextUtils.isEmpty(str)) {
                C1393t.m1034a("BaseAppCommand", "pkg name is null");
                str = m1063a();
                if (TextUtils.isEmpty(str)) {
                    C1393t.m1034a("BaseAppCommand", "src is null");
                    return -1;
                }
            }
            this.f341d = C1366aa.m928b(context, str);
            if (!TextUtils.isEmpty(this.f343f)) {
                this.f341d = 2;
            }
        }
        return this.f341d;
    }

    /* renamed from: g */
    public final String m592g() {
        return this.f338a;
    }

    /* renamed from: b */
    public final void m587b(String str) {
        this.f338a = str;
    }

    /* renamed from: c */
    public final void m588c(String str) {
        this.f345h = str;
    }

    /* renamed from: d */
    public final void m589d(String str) {
        this.f344g = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: c */
    public void mo582c(C1232d c1232d) {
        c1232d.m654a("req_id", this.f338a);
        c1232d.m654a(Constants.PACKAGE_NAME, this.f339b);
        c1232d.m652a(RegistrationHeaderHelper.KEY_SDK_VERSION, 356L);
        c1232d.m651a("PUSH_APP_STATUS", this.f341d);
        if (!TextUtils.isEmpty(this.f343f)) {
            c1232d.m654a("BaseAppCommand.EXTRA__HYBRIDVERSION", this.f343f);
        }
        c1232d.m654a("BaseAppCommand.EXTRA_APPID", this.f345h);
        c1232d.m654a("BaseAppCommand.EXTRA_APPKEY", this.f344g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.vivo.push.AbstractC1400v
    /* renamed from: d */
    public void mo583d(C1232d c1232d) {
        this.f338a = c1232d.m650a("req_id");
        this.f339b = c1232d.m650a(Constants.PACKAGE_NAME);
        this.f340c = c1232d.m659b(RegistrationHeaderHelper.KEY_SDK_VERSION, 0L);
        this.f341d = c1232d.m658b("PUSH_APP_STATUS", 0);
        this.f343f = c1232d.m650a("BaseAppCommand.EXTRA__HYBRIDVERSION");
        this.f345h = c1232d.m650a("BaseAppCommand.EXTRA_APPID");
        this.f344g = c1232d.m650a("BaseAppCommand.EXTRA_APPKEY");
    }
}
