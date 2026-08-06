package com.bytedance.tobshadow.bdtracker;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.r2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0505r2 extends AbstractC0553y1 {

    /* renamed from: e */
    public final Context f976e;

    /* renamed from: f */
    public final C0467m f977f;

    public C0505r2(C0467m c0467m, Context context) {
        super(true, false);
        this.f977f = c0467m;
        this.f976e = context;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public String mo253a() {
        return "SigHash";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0553y1
    /* renamed from: a */
    public boolean mo255a(JSONObject jSONObject) {
        PackageInfo packageInfo;
        Signature[] signatureArr;
        Signature signature;
        String str = null;
        try {
            Context context = this.f976e;
            packageInfo = C0508r5.m641a(context, context.getPackageName(), 64);
        } catch (Throwable th) {
            this.f977f.f764D.error("Get package info failed", th, new Object[0]);
            packageInfo = null;
        }
        if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
            str = C0473m5.m534a(signature.toByteArray());
        }
        if (str == null) {
            return true;
        }
        jSONObject.put("sig_hash", str);
        return true;
    }
}
