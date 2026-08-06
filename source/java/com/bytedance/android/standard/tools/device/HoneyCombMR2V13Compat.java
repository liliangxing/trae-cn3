package com.bytedance.android.standard.tools.device;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: classes3.dex */
public class HoneyCombMR2V13Compat {
    static final BaseImpl IMPL = new HoneyCombMR2Impl();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class BaseImpl {
        private BaseImpl() {
        }

        public void getDisplaySize(Display display, Point point) {
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
    }

    /* loaded from: classes3.dex */
    private static class HoneyCombMR2Impl extends BaseImpl {
        private HoneyCombMR2Impl() {
            super();
        }

        @Override // com.bytedance.android.standard.tools.device.HoneyCombMR2V13Compat.BaseImpl
        public void getDisplaySize(Display display, Point point) {
            display.getSize(point);
        }
    }

    public static void getDisplaySize(Display display, Point point) {
        IMPL.getDisplaySize(display, point);
    }

    public static int getDisplayWidth(Display display) {
        Point point = new Point();
        getDisplaySize(display, point);
        return point.x;
    }

    public static void getDisplaySize(Context context, Point point) {
        getDisplaySize(((WindowManager) context.getSystemService("window")).getDefaultDisplay(), point);
    }
}
