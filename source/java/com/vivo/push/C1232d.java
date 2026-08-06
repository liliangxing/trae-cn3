package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.util.C1393t;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: BundleWapper.java */
/* renamed from: com.vivo.push.d */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1232d {

    /* renamed from: a */
    private Bundle f392a;

    /* renamed from: b */
    private String f393b;

    /* renamed from: c */
    private String f394c;

    public C1232d(String str, String str2, Bundle bundle) {
        this.f393b = str;
        this.f394c = str2;
        this.f392a = bundle;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) == false) goto L12;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C1232d m648a(Intent intent) {
        String str;
        if (intent == null) {
            C1393t.m1034a("BundleWapper", "create error : intent is null");
            return null;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            str = extras.getString("client_pkgname");
        }
        str = null;
        if (TextUtils.isEmpty(str)) {
            C1393t.m1041b("BundleWapper", "create warning: pkgName is null");
        }
        String str2 = intent.getPackage();
        if (TextUtils.isEmpty(str2)) {
            String packageName = intent.getComponent() != null ? intent.getComponent().getPackageName() : null;
            if (TextUtils.isEmpty(packageName)) {
                C1393t.m1041b("BundleWapper", "create warning: targetPkgName is null");
            }
            str2 = packageName;
        }
        return new C1232d(str, str2, extras);
    }

    /* renamed from: a */
    public final void m651a(String str, int i) {
        if (this.f392a == null) {
            this.f392a = new Bundle();
        }
        this.f392a.putInt(str, i);
    }

    /* renamed from: a */
    public final void m652a(String str, long j) {
        if (this.f392a == null) {
            this.f392a = new Bundle();
        }
        this.f392a.putLong(str, j);
    }

    /* renamed from: a */
    public final void m654a(String str, String str2) {
        if (this.f392a == null) {
            this.f392a = new Bundle();
        }
        this.f392a.putString(str, str2);
    }

    /* renamed from: a */
    public final void m657a(String str, byte[] bArr) {
        if (this.f392a == null) {
            this.f392a = new Bundle();
        }
        this.f392a.putByteArray(str, bArr);
    }

    /* renamed from: a */
    public final void m653a(String str, Serializable serializable) {
        if (this.f392a == null) {
            this.f392a = new Bundle();
        }
        this.f392a.putSerializable(str, serializable);
    }

    /* renamed from: a */
    public final void m656a(String str, boolean z) {
        if (this.f392a == null) {
            this.f392a = new Bundle();
        }
        this.f392a.putBoolean(str, z);
    }

    /* renamed from: a */
    public final void m655a(String str, ArrayList<String> arrayList) {
        if (this.f392a == null) {
            this.f392a = new Bundle();
        }
        this.f392a.putStringArrayList(str, arrayList);
    }

    /* renamed from: a */
    public final String m650a(String str) {
        Bundle bundle = this.f392a;
        if (bundle == null) {
            return null;
        }
        return bundle.getString(str);
    }

    /* renamed from: b */
    public final int m658b(String str, int i) {
        Bundle bundle = this.f392a;
        return bundle == null ? i : bundle.getInt(str, i);
    }

    /* renamed from: b */
    public final byte[] m661b(String str) {
        Bundle bundle = this.f392a;
        if (bundle == null) {
            return null;
        }
        return bundle.getByteArray(str);
    }

    /* renamed from: c */
    public final ArrayList<String> m662c(String str) {
        Bundle bundle = this.f392a;
        if (bundle == null) {
            return null;
        }
        return bundle.getStringArrayList(str);
    }

    /* renamed from: b */
    public final long m659b(String str, long j) {
        Bundle bundle = this.f392a;
        return bundle == null ? j : bundle.getLong(str, j);
    }

    /* renamed from: d */
    public final Serializable m663d(String str) {
        Bundle bundle = this.f392a;
        if (bundle == null) {
            return null;
        }
        return bundle.getSerializable(str);
    }

    /* renamed from: e */
    public final boolean m664e(String str) {
        Bundle bundle = this.f392a;
        if (bundle == null) {
            return false;
        }
        return bundle.getBoolean(str, false);
    }

    /* renamed from: a */
    public final String m649a() {
        return this.f393b;
    }

    /* renamed from: b */
    public final Bundle m660b() {
        return this.f392a;
    }
}
