package com.huawei.hms.framework.network.grs.p023g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.p021e.C1093c;
import java.util.concurrent.Callable;

/* renamed from: com.huawei.hms.framework.network.grs.g.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1099a {

    /* renamed from: a */
    protected C1102d f1308a;

    /* renamed from: b */
    private final String f1309b;

    /* renamed from: c */
    private final C1101c f1310c;

    /* renamed from: d */
    private final int f1311d;

    /* renamed from: e */
    private final Context f1312e;

    /* renamed from: f */
    private final String f1313f;

    /* renamed from: g */
    private final GrsBaseInfo f1314g;

    /* renamed from: h */
    private final C1093c f1315h;

    public C1099a(String str, int i, C1101c c1101c, Context context, String str2, GrsBaseInfo grsBaseInfo, C1093c c1093c) {
        this.f1309b = str;
        this.f1310c = c1101c;
        this.f1311d = i;
        this.f1312e = context;
        this.f1313f = str2;
        this.f1314g = grsBaseInfo;
        this.f1315h = c1093c;
    }

    /* renamed from: a */
    public Context m1282a() {
        return this.f1312e;
    }

    /* renamed from: b */
    public C1101c m1283b() {
        return this.f1310c;
    }

    /* renamed from: c */
    public String m1284c() {
        return this.f1309b;
    }

    /* renamed from: d */
    public int m1285d() {
        return this.f1311d;
    }

    /* renamed from: e */
    public String m1286e() {
        return this.f1313f;
    }

    /* renamed from: f */
    public C1093c m1287f() {
        return this.f1315h;
    }

    /* renamed from: g */
    public Callable<C1102d> m1288g() {
        return new CallableC1104f(this.f1309b, this.f1311d, this.f1310c, this.f1312e, this.f1313f, this.f1314g, this.f1315h);
    }
}
