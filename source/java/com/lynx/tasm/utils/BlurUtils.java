package com.lynx.tasm.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RenderNode;
import android.graphics.Shader;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RSRuntimeException;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public class BlurUtils {
    private static final int BLUR_DEFAULT_SAMPLING = 1;
    private static final int DEFAULT_ITERATIONS = 3;
    private static final String TAG = "BlurUtils";
    private static Method sCreateBlurEffect = null;
    private static Class sRenderEffectClass = null;
    private static Method sSetNodeRenderEffect = null;
    private static Method sSetRenderEffect = null;
    private static boolean sSupportRenderEffect = true;

    private static native void nativeIterativeBoxBlur(Bitmap bitmap, int i, int i2);

    public static boolean createEffect(View view, float f) {
        if (!isSupportRenderEffect() || f <= 0.0f) {
            return false;
        }
        if (!prepareViewSetMethod()) {
            sSupportRenderEffect = false;
            return false;
        }
        try {
            sSetRenderEffect.invoke(view, sCreateBlurEffect.invoke(null, Float.valueOf(f), Float.valueOf(f), Shader.TileMode.CLAMP));
            return true;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            LLog.e(TAG, "createViewEffect failed " + e.getMessage());
            sSupportRenderEffect = false;
            return false;
        }
    }

    public static boolean createEffect(RenderNode renderNode, float f) {
        if (!isSupportRenderEffect() || f <= 0.0f) {
            return false;
        }
        if (!prepareRenderNodeSetMethod()) {
            sSupportRenderEffect = false;
            return false;
        }
        try {
            sSetNodeRenderEffect.invoke(renderNode, sCreateBlurEffect.invoke(null, Float.valueOf(f), Float.valueOf(f), Shader.TileMode.CLAMP));
            return true;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            LLog.e(TAG, "createNodeEffect failed " + e.getMessage());
            sSupportRenderEffect = false;
            return false;
        }
    }

    private static boolean isSupportRenderEffect() {
        return Build.VERSION.SDK_INT >= 31 && sSupportRenderEffect;
    }

    public static boolean removeEffect(View view) {
        if (!isSupportRenderEffect()) {
            return false;
        }
        if (!prepareViewSetMethod()) {
            sSupportRenderEffect = false;
            return false;
        }
        try {
            sSetRenderEffect.invoke(view, null);
            return true;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            sSupportRenderEffect = false;
            return false;
        }
    }

    private static boolean prepareRenderEffect() {
        if (sRenderEffectClass == null) {
            try {
                sRenderEffectClass = Class.forName("android.graphics.RenderEffect");
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }
        Class cls = sRenderEffectClass;
        if (cls != null && sCreateBlurEffect == null) {
            try {
                sCreateBlurEffect = cls.getMethod("createBlurEffect", Float.TYPE, Float.TYPE, Shader.TileMode.class);
            } catch (NoSuchMethodException unused2) {
                LLog.e(TAG, "prepareRenderEffectClass failed");
                return false;
            }
        }
        return (sRenderEffectClass == null || sCreateBlurEffect == null) ? false : true;
    }

    private static boolean prepareViewSetMethod() {
        if (!prepareRenderEffect()) {
            return false;
        }
        if (sSetRenderEffect == null) {
            try {
                sSetRenderEffect = View.class.getMethod("setRenderEffect", sRenderEffectClass);
            } catch (NoSuchMethodException unused) {
                LLog.e(TAG, "prepareRenderEffectMethods failed");
                return false;
            }
        }
        return true;
    }

    private static boolean prepareRenderNodeSetMethod() {
        if (!prepareRenderEffect()) {
            return false;
        }
        if (sSetNodeRenderEffect == null) {
            try {
                sSetNodeRenderEffect = RenderNode.class.getMethod("setRenderEffect", sRenderEffectClass);
            } catch (NoSuchMethodException unused) {
                LLog.e(TAG, "prepareRenderNodeRenderEffectMethods failed");
                sSupportRenderEffect = false;
                return false;
            }
        }
        return true;
    }

    public static Bitmap blur(Context context, Bitmap bitmap, int i, int i2, float f, int i3) {
        if (i == 0 || i2 == 0) {
            return null;
        }
        Boolean valueOf = Boolean.valueOf(i3 > 1);
        Bitmap createScaledBitmap = valueOf.booleanValue() ? Bitmap.createScaledBitmap(bitmap, i / i3, i2 / i3, true) : bitmap;
        try {
            createScaledBitmap = rs(context, createScaledBitmap, f);
        } catch (RSRuntimeException unused) {
            iterativeBoxBlur(createScaledBitmap, (int) f);
        }
        if (valueOf.booleanValue()) {
            int[] iArr = new int[i * i2];
            Bitmap.createScaledBitmap(createScaledBitmap, i, i2, true).getPixels(iArr, 0, i, 0, 0, i, i2);
            bitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        }
        return bitmap;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap rs(Context context, Bitmap bitmap, float f) throws RSRuntimeException {
        ScriptIntrinsicBlur scriptIntrinsicBlur;
        Allocation allocation;
        Allocation allocation2;
        RenderScript renderScript = null;
        ScriptIntrinsicBlur scriptIntrinsicBlur2 = null;
        try {
            RenderScript create = RenderScript.create(context);
            try {
                create.setMessageHandler(new RenderScript.RSMessageHandler());
                allocation = Allocation.createFromBitmap(create, bitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
                try {
                    allocation2 = Allocation.createTyped(create, allocation.getType());
                    try {
                        scriptIntrinsicBlur2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                        scriptIntrinsicBlur2.setInput(allocation);
                        scriptIntrinsicBlur2.setRadius(f);
                        scriptIntrinsicBlur2.forEach(allocation2);
                        allocation2.copyTo(bitmap);
                        if (create != null) {
                            create.destroy();
                        }
                        if (allocation != null) {
                            allocation.destroy();
                        }
                        if (allocation2 != null) {
                            allocation2.destroy();
                        }
                        if (scriptIntrinsicBlur2 != null) {
                            scriptIntrinsicBlur2.destroy();
                        }
                        return bitmap;
                    } catch (Throwable th) {
                        th = th;
                        ScriptIntrinsicBlur scriptIntrinsicBlur3 = scriptIntrinsicBlur2;
                        renderScript = create;
                        scriptIntrinsicBlur = scriptIntrinsicBlur3;
                        if (renderScript != null) {
                            renderScript.destroy();
                        }
                        if (allocation != null) {
                            allocation.destroy();
                        }
                        if (allocation2 != null) {
                            allocation2.destroy();
                        }
                        if (scriptIntrinsicBlur != null) {
                            scriptIntrinsicBlur.destroy();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    allocation2 = null;
                    renderScript = create;
                    scriptIntrinsicBlur = allocation2;
                    if (renderScript != null) {
                    }
                    if (allocation != null) {
                    }
                    if (allocation2 != null) {
                    }
                    if (scriptIntrinsicBlur != null) {
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                allocation = null;
                allocation2 = null;
            }
        } catch (Throwable th4) {
            th = th4;
            scriptIntrinsicBlur = null;
            allocation = null;
            allocation2 = null;
        }
    }

    public static void iterativeBoxBlur(Bitmap bitmap, int i) {
        if (bitmap == null) {
            LLog.w("Blur", "bitmap is null");
            return;
        }
        if (i <= 0) {
            LLog.w("Blur", "radius <= 0");
            return;
        }
        try {
            TraceEvent.beginSection("image.BlurUtils.nativeIterativeBoxBlur");
            nativeIterativeBoxBlur(bitmap, 3, i);
            TraceEvent.endSection("image.BlurUtils.nativeIterativeBoxBlur");
        } catch (RuntimeException e) {
            LLog.w("Blur", e.getMessage());
        }
    }
}
