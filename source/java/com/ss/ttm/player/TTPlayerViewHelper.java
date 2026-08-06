package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.provider.Settings;
import android.view.SurfaceView;
import android.view.View;
import androidx.core.util.Pair;
import com.ss.vcbkit.VLog;
import java.lang.reflect.Method;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes7.dex */
final class TTPlayerViewHelper {
    public static final float TT_PLAYER_VIEW_ASPECT_PRECISION = 0.001f;
    public static final String TT_PLAYER_VIEW_TAG = "ttmv";
    private static boolean sDeviceEnableSurfaceView;
    private static boolean sFetchedDeviceEnableSurfaceView;

    private TTPlayerViewHelper() {
        throw new UnsupportedOperationException("Don't instantiate");
    }

    /* loaded from: classes7.dex */
    public static class Size {
        private int height;
        private int width;

        public Size(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public String toString() {
            return "size{w=" + this.width + ", h=" + this.height + AbstractJsonLexerKt.END_OBJ;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x002c, code lost:
    
        if (r3 > r9) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x003e, code lost:
    
        r4 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0039, code lost:
    
        r4 = r10;
        r5 = r4;
        r2 = true;
        r1 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0031, code lost:
    
        if (r3 > r10) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004c, code lost:
    
        r1 = r9;
        r4 = r3;
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0047, code lost:
    
        r5 = r10;
        r2 = true;
        r4 = r3;
        r1 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0037, code lost:
    
        if (r3 > r9) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0045, code lost:
    
        if (r3 > r10) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Pair<Size, Boolean> calculatePlayerViewSize(int scaleType, float videoAspect, int viewWidth, int viewHeight, float widthLimit, float heightLimit) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        float f;
        int i7;
        boolean z = false;
        if (videoAspect == 0.0f) {
            return new Pair<>(null, false);
        }
        if (scaleType != 0) {
            if (scaleType != 1) {
                if (scaleType == 2) {
                    i = (int) (viewHeight * videoAspect);
                } else if (scaleType != 3) {
                    i5 = viewWidth;
                    i = i5;
                    i3 = viewHeight;
                    i4 = i3;
                } else {
                    float f2 = viewWidth;
                    float f3 = viewHeight;
                    if (videoAspect > f2 / f3) {
                        i = (int) (f3 * videoAspect);
                    } else {
                        i7 = (int) (f2 / videoAspect);
                    }
                }
                if (z && widthLimit > 0.0f && heightLimit > 0.0f) {
                    i6 = i3 - i4;
                    f = (i - i5) / viewWidth;
                    if (f <= widthLimit || i6 / viewHeight > heightLimit) {
                        VLog.w(TT_PLAYER_VIEW_TAG, "ttmn calculate crop w_aspect: " + f + ", h_aspect: " + (i6 / viewHeight) + ", scale: " + scaleType + " fallback to fit");
                        return calculatePlayerViewSize(0, videoAspect, viewWidth, viewHeight, widthLimit, heightLimit);
                    }
                }
                return new Pair<>(new Size(i5, i4), Boolean.valueOf(z));
            }
            i7 = (int) (viewWidth / videoAspect);
            i = i5;
            if (z) {
                i6 = i3 - i4;
                f = (i - i5) / viewWidth;
                if (f <= widthLimit) {
                }
                VLog.w(TT_PLAYER_VIEW_TAG, "ttmn calculate crop w_aspect: " + f + ", h_aspect: " + (i6 / viewHeight) + ", scale: " + scaleType + " fallback to fit");
                return calculatePlayerViewSize(0, videoAspect, viewWidth, viewHeight, widthLimit, heightLimit);
            }
            return new Pair<>(new Size(i5, i4), Boolean.valueOf(z));
        }
        float f4 = viewWidth;
        float f5 = viewHeight;
        if (videoAspect > f4 / f5) {
            i2 = (int) (f4 / videoAspect);
            i = viewWidth;
        } else {
            i = (int) (f5 * videoAspect);
            i2 = viewHeight;
        }
        i3 = i2;
        i4 = i3;
        i5 = i;
        if (z) {
        }
        return new Pair<>(new Size(i5, i4), Boolean.valueOf(z));
    }

    public static boolean isEnableSurfaceView(Context context) {
        if (!sFetchedDeviceEnableSurfaceView) {
            sDeviceEnableSurfaceView = (isDeviceOppoRealmeBrand() && isMediaTekChipset() && !isOppoPropertyEnableSurfaceView() && isOSIESwitchOffForOppoRealme(context)) ? false : true;
            sFetchedDeviceEnableSurfaceView = true;
        }
        return sDeviceEnableSurfaceView;
    }

    private static boolean isDeviceOppoRealmeBrand() {
        String lowerCase = Build.BRAND.toLowerCase();
        return lowerCase.equals("oppo") || lowerCase.equals("realme") || lowerCase.equals("oneplus");
    }

    private static boolean isMediaTekChipset() {
        String str = Build.HARDWARE;
        if (str == null) {
            return false;
        }
        return str.matches("mt[0-9]*");
    }

    private static boolean isOppoPropertyEnableSurfaceView() {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getInt", String.class, Integer.TYPE);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, "ro.oplus.display.reset_two_pq_layer", -1);
            if (invoke instanceof Integer) {
                return ((Integer) invoke).intValue() == 1;
            }
        } catch (Exception e) {
            VLog.e(TT_PLAYER_VIEW_TAG, "ttmn isSurfaceViewEnableByOppoProperty failed: " + e);
        }
        return false;
    }

    private static boolean isOSIESwitchOffForOppoRealme(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return (Settings.Secure.getInt(context.getContentResolver(), "osie_iris5_switch", -1) == 1 || Settings.Secure.getInt(context.getContentResolver(), "customize_multimedia_osie", -1) == 1 || Settings.Secure.getInt(context.getContentResolver(), "osie_video_display_switch", -1) == 1) ? false : true;
        } catch (Exception e) {
            VLog.e(TT_PLAYER_VIEW_TAG, "ttmn failed to read OSIE settings: " + e);
            return false;
        }
    }

    public static Rect getSurfaceRenderPosition(View view) {
        if (view == null) {
            return null;
        }
        if (view instanceof SurfaceView) {
            try {
                Method declaredMethod = SurfaceView.class.getDeclaredMethod("getSurfaceRenderPosition", new Class[0]);
                declaredMethod.setAccessible(true);
                Object invoke = declaredMethod.invoke(view, new Object[0]);
                if (invoke instanceof Rect) {
                    return (Rect) invoke;
                }
            } catch (Exception unused) {
            }
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    public static String objectToString(Object object) {
        int lastIndexOf;
        if (object == null) {
            return "Null";
        }
        String simpleName = object.getClass().getSimpleName();
        if ((simpleName == null || simpleName.isEmpty()) && (lastIndexOf = (simpleName = object.getClass().getName()).lastIndexOf(46)) >= 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        return simpleName + "@" + Integer.toHexString(System.identityHashCode(object));
    }
}
