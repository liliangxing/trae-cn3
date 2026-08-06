package com.bytedance.p009dr.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.p009dr.OaidApi;
import com.bytedance.tobshadow.bdtracker.b;
import com.bytedance.tobshadow.bdtracker.j;
import com.bytedance.tobshadow.bdtracker.r5;

/* renamed from: com.bytedance.dr.impl.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public abstract class AbstractC1067b<SERVICE> implements OaidApi {

    /* renamed from: a */
    public final String f169a;

    /* renamed from: b */
    public final b<Boolean> f170b = new a();

    /* renamed from: com.bytedance.dr.impl.b$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class a extends b<Boolean> {
        public a() {
        }

        /* renamed from: a */
        public Object m262a(Object[] objArr) {
            return Boolean.valueOf(r5.a((Context) objArr[0], AbstractC1067b.this.f169a));
        }
    }

    public AbstractC1067b(String str) {
        this.f169a = str;
    }

    /* renamed from: a */
    public abstract Intent mo258a(Context context);

    /* renamed from: a */
    public abstract j.b<SERVICE, String> mo259a();

    @Override // com.bytedance.p009dr.OaidApi
    public OaidApi.C1053a getOaid(Context context) {
        String str = (String) new j(context, mo258a(context), mo259a()).a();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        OaidApi.C1053a c1053a = new OaidApi.C1053a();
        c1053a.f153a = str;
        return c1053a;
    }

    @Override // com.bytedance.p009dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        return ((Boolean) this.f170b.b(new Object[]{context})).booleanValue();
    }
}
