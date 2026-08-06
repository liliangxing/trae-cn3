package ms.bd.c;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: classes8.dex */
public abstract class k3 {
    public static int a;
    public static int b;

    public static String a(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            a = point.x;
            b = point.y;
        } catch (Throwable unused) {
        }
        return a + "*" + b;
    }
}
