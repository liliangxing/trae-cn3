package com.lynx.tasm.utils;

import android.graphics.PointF;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.react.bridge.mapbuffer.ReadableMapBufferWrapper;
import java.util.Iterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class GradientUtils {
    private static native ReadableMapBuffer nativeGetGradientArray(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8);

    private static native float[] nativeGetRadialRadius(int i, int i2, float f, float f2, float f3, float f4);

    public static PointF getRadius(int i, int i2, float f, float f2, float f3, float f4) {
        float[] nativeGetRadialRadius = nativeGetRadialRadius(i, i2, f, f2, f3, f4);
        return new PointF(nativeGetRadialRadius[0], nativeGetRadialRadius[1]);
    }

    public static ReadableArray getGradientArray(String str, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        ReadableMapBuffer nativeGetGradientArray = nativeGetGradientArray(str, f, f2, f3, f4, f5, f6, f7, f8);
        if (nativeGetGradientArray == null) {
            return null;
        }
        Iterator it = nativeGetGradientArray.iterator();
        if (it.hasNext()) {
            return new ReadableMapBufferWrapper(((MapBuffer.Entry) it.next()).getMapBuffer());
        }
        return null;
    }
}
