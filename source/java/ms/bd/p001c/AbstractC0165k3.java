package ms.bd.p001c;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: ms.bd.c.k3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public abstract class AbstractC0165k3 {

    /* renamed from: a */
    public static int f211a;

    /* renamed from: b */
    public static int f212b;

    /* renamed from: a */
    public static String m138a(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            f211a = point.x;
            f212b = point.y;
        } catch (Throwable unused) {
        }
        return f211a + "*" + f212b;
    }
}
