package com.bytedance.sysoptimizer;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;

/* loaded from: classes5.dex */
public class BitmapFinalizeOpt {
    private static native int nStart();

    public static int start(Context context, boolean z) {
        if (!SysOptimizer.loadOptimizerLibrary(context)) {
            return -1;
        }
        if (z) {
            new Thread(new Runnable() { // from class: com.bytedance.sysoptimizer.BitmapFinalizeOpt.1
                @Override // java.lang.Runnable
                public void run() {
                    while (true) {
                        Bitmap.createBitmap(1024, 1024, Bitmap.Config.ARGB_8888).setPixel(0, 0, 16777215);
                        SystemClock.sleep(1L);
                    }
                }
            }).start();
        }
        return nStart();
    }
}
