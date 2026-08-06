package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.upc.cache.ApiHookRecord;

/* loaded from: classes7.dex */
class ap implements ah {
    private static String a = "content://com.vivo.vms.IdProvider/IdentifierId/";
    private static String b = a + ApiHookRecord.KEY_OAID;
    private static String c = a + "VAID_";
    private static String d = a + "AAID_";
    private static String e = a + "OAIDSTATUS";
    private static String f = "persist.sys.identifierid.supported";

    /* renamed from: a, reason: collision with other field name */
    private Context f183a;

    public ap(Context context) {
        this.f183a = context;
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public boolean mo9615a() {
        return "1".equals(p.a(f, "0"));
    }

    @Override // com.xiaomi.push.ah
    /* renamed from: a */
    public String mo9614a() {
        return a(b);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        if (r10 == null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0029, code lost:
    
        if (r10 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x002b, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x003d, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String a(String str) {
        Throwable th;
        Cursor cursor;
        String str2 = null;
        try {
            cursor = this.f183a.getContentResolver().query(Uri.parse(str), null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToNext()) {
                        str2 = cursor.getString(cursor.getColumnIndex("value"));
                    }
                } catch (Exception unused) {
                } catch (Throwable th2) {
                    th = th2;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public static boolean a(Context context) {
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(a).getAuthority(), 128);
            if (resolveContentProvider != null) {
                if ((resolveContentProvider.applicationInfo.flags & 1) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
