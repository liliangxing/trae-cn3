package com.bytedance.p009dr.impl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.bytedance.p009dr.OaidApi;
import com.bytedance.tobshadow.applog.log.LoggerImpl;
import com.bytedance.tobshadow.bdtracker.b;
import com.bytedance.tobshadow.bdtracker.e;

/* renamed from: com.bytedance.dr.impl.k */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class C1076k implements OaidApi {

    /* renamed from: a */
    public static final b<Boolean> f181a = new a();

    /* renamed from: com.bytedance.dr.impl.k$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class a extends b<Boolean> {
        /* renamed from: a */
        public Object m277a(Object[] objArr) {
            return Boolean.valueOf("1".equals(C1076k.m276a("persist.sys.identifierid.supported", "0")));
        }
    }

    /* renamed from: a */
    public static /* synthetic */ String m276a(String str, String str2) {
        try {
            return SystemProperties.get(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    @Override // com.bytedance.p009dr.OaidApi
    public String getName() {
        return "Vivo";
    }

    @Override // com.bytedance.p009dr.OaidApi
    public OaidApi.C1053a getOaid(Context context) {
        Cursor cursor;
        OaidApi.C1053a c1053a = new OaidApi.C1053a();
        Uri parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
        String str = null;
        str = null;
        str = null;
        str = null;
        Cursor cursor2 = null;
        if (parse != null) {
            try {
                cursor = context.getContentResolver().query(parse, null, null, null, null);
                if (cursor != null) {
                    try {
                        try {
                            if (cursor.moveToNext()) {
                                str = cursor.getString(cursor.getColumnIndex("value"));
                            }
                        } catch (Exception e) {
                            e = e;
                            LoggerImpl.global().error(1, "Query oaid failed", e, new Object[0]);
                            e.a(cursor);
                            c1053a.f153a = str;
                            return c1053a;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor2 = cursor;
                        e.a(cursor2);
                        throw th;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                cursor = null;
            } catch (Throwable th2) {
                th = th2;
                e.a(cursor2);
                throw th;
            }
            e.a(cursor);
        }
        c1053a.f153a = str;
        return c1053a;
    }

    @Override // com.bytedance.p009dr.OaidApi
    public boolean support(Context context) {
        return ((Boolean) f181a.b(new Object[0])).booleanValue();
    }
}
