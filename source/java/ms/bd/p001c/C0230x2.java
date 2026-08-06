package ms.bd.p001c;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import okio.Utf8;

/* renamed from: ms.bd.c.x2 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class C0230x2 {

    /* renamed from: a */
    public final Context f463a;

    public C0230x2(Context context) {
        this.f463a = context;
    }

    /* renamed from: a */
    public final String m208a() {
        Bundle call;
        if (Build.VERSION.SDK_INT <= 28) {
            return null;
        }
        try {
            ContentProviderClient acquireContentProviderClient = this.f463a.getContentResolver().acquireContentProviderClient(Uri.parse((String) AbstractC0190p2.m166a(16777217, 0, 0L, "a78c74", new byte[]{115, 58, 69, 3, 13, 45, 118, 76, 38, 124, 115, 59, 5, 25, 29, 33, 107, 23, 39, 58, 116, 48, 69, 3, 1, 55, 123, 89, 96, 55, 117, 59, 95, 30, 28, 58})));
            call = acquireContentProviderClient.call((String) AbstractC0190p2.m166a(16777217, 0, 0L, "6fdea0", new byte[]{32, 97, 3, 62, Byte.MAX_VALUE, 14, 17}), null, null);
            acquireContentProviderClient.close();
        } catch (Exception unused) {
        }
        if (call == null) {
            return null;
        }
        if (call.getInt((String) AbstractC0190p2.m166a(16777217, 0, 0L, "e72224", new byte[]{119, 58, 69, 67}), -1) == 0) {
            return call.getString((String) AbstractC0190p2.m166a(16777217, 0, 0L, "cda7ab", new byte[]{123, 98}));
        }
        call.getString((String) AbstractC0190p2.m166a(16777217, 0, 0L, "48a911", new byte[]{40, Utf8.REPLACEMENT_BYTE, 1, 94, 15, 33, 50}));
        return null;
    }
}
