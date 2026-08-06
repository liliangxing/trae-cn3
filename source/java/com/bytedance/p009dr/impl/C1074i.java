package com.bytedance.p009dr.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.p009dr.OaidApi;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.b;
import com.bytedance.tobshadow.bdtracker.e;

/* renamed from: com.bytedance.dr.impl.i */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1074i implements OaidApi {

    /* renamed from: a */
    public final b<Boolean> f180a = new a(this);

    /* renamed from: com.bytedance.dr.impl.i$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class a extends b<Boolean> {
        public a(C1074i c1074i) {
        }

        /* renamed from: a */
        public Object m275a(Object[] objArr) {
            try {
                PackageManager packageManager = ((Context) objArr[0]).getPackageManager();
                if (packageManager != null) {
                    return Boolean.valueOf(packageManager.resolveContentProvider("com.meizu.flyme.openidsdk", 0) != null);
                }
            } catch (Throwable unused) {
            }
            return false;
        }
    }

    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return "Meizu";
    }

    @Override // com.bytedance.p009dr.OaidApi
    public OaidApi.C1053a getOaid(Context context) {
        Cursor cursor;
        String string;
        try {
            cursor = context.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{Oaid.KEY_OAID_ID}, null);
            if (cursor == null) {
                return null;
            }
            try {
                OaidApi.C1053a c1053a = new OaidApi.C1053a();
                if (!cursor.isClosed()) {
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex("value");
                    if (columnIndex >= 0) {
                        string = cursor.getString(columnIndex);
                        c1053a.f153a = string;
                        return c1053a;
                    }
                }
                string = null;
                c1053a.f153a = string;
                return c1053a;
            } catch (Throwable th) {
                th = th;
                try {
                    LoggerImpl.global().error(1, "getOaid failed", th, new Object[0]);
                    return null;
                } finally {
                    e.a(cursor);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    @Override // com.bytedance.p009dr.OaidApi
    public boolean support(Context context) {
        if (context == null) {
            return false;
        }
        return ((Boolean) this.f180a.b(new Object[]{context})).booleanValue();
    }
}
