package com.bytedance.dr.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.bytedance.dr.OaidApi;
import com.bytedance.tobshadow.bdtracker.j;
import com.bytedance.tobshadow.bdtracker.r5;

/* loaded from: classes3.dex */
public abstract class b<SERVICE> implements OaidApi {
    public final String a;
    public final com.bytedance.tobshadow.bdtracker.b<Boolean> b = new a();

    /* loaded from: classes3.dex */
    public class a extends com.bytedance.tobshadow.bdtracker.b<Boolean> {
        public a() {
        }

        @Override // com.bytedance.tobshadow.bdtracker.b
        public Boolean a(Object[] objArr) {
            return Boolean.valueOf(r5.a((Context) objArr[0], b.this.a));
        }
    }

    public b(String str) {
        this.a = str;
    }

    public abstract Intent a(Context context);

    public abstract j.b<SERVICE, String> a();

    @Override // com.bytedance.dr.OaidApi
    public OaidApi.a getOaid(Context context) {
        String str = (String) new com.bytedance.tobshadow.bdtracker.j(context, a(context), a()).a();
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        OaidApi.a aVar = new OaidApi.a();
        aVar.a = str;
        return aVar;
    }

    @Override // com.bytedance.dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        return this.b.b(context).booleanValue();
    }
}
