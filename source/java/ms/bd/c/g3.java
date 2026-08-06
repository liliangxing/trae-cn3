package ms.bd.c;

import android.content.Context;
import android.system.Os;

/* loaded from: classes8.dex */
public abstract class g3 {
    public static void a(Context context, String str) {
        try {
            Os.setenv("28d7fdd567361198183fa7b8e", "a7", true);
        } catch (Exception unused) {
        }
        new i3().a(context, str);
    }
}
