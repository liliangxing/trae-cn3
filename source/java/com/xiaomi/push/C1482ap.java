package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.vivo.push.PushClient;

/* renamed from: com.xiaomi.push.ap */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
class C1482ap implements InterfaceC1474ah {

    /* renamed from: a */
    private static String f999a = "content://com.vivo.vms.IdProvider/IdentifierId/";

    /* renamed from: b */
    private static String f1000b = f999a + "OAID";

    /* renamed from: c */
    private static String f1001c = f999a + "VAID_";

    /* renamed from: d */
    private static String f1002d = f999a + "AAID_";

    /* renamed from: e */
    private static String f1003e = f999a + "OAIDSTATUS";

    /* renamed from: f */
    private static String f1004f = "persist.sys.identifierid.supported";

    /* renamed from: a */
    private Context f1005a;

    public C1482ap(Context context) {
        this.f1005a = context;
    }

    @Override // com.xiaomi.push.InterfaceC1474ah
    /* renamed from: a */
    public boolean mo1483a() {
        return PushClient.DEFAULT_REQUEST_ID.equals(C1700p.m3459a(f1004f, "0"));
    }

    @Override // com.xiaomi.push.InterfaceC1474ah
    /* renamed from: a */
    public String mo1482a() {
        return m1521a(f1000b);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String m1521a(String str) {
        Throwable th;
        Cursor cursor;
        String str2 = null;
        try {
            cursor = this.f1005a.getContentResolver().query(Uri.parse(str), null, null, null, null);
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

    /* renamed from: a */
    public static boolean m1522a(Context context) {
        try {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(Uri.parse(f999a).getAuthority(), 128);
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
