package com.bytedance.fresco.nativeheif;

import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class GainmapReflectionHelper {
    private static final String GAINMAP_CLASS_NAME = "android.graphics.Gainmap";
    private static final String TAG = "GainmapReflection";
    private static Object bt2020HlgNamed;
    private static Class<?> colorSpaceClass;
    private static Class<?> configClass;
    private static Class<?> gainmapClass;
    private static Class<?> namedClass;

    public static boolean isGainmapSupported() {
        try {
            Class.forName(GAINMAP_CLASS_NAME);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void safeSetGainmap(Bitmap bitmap, Object obj) {
        if (bitmap == null || obj == null) {
            Log.d(TAG, "Bitmap or Gainmap is null");
            return;
        }
        if (Build.VERSION.SDK_INT < 34) {
            Log.d(TAG, "Gainmap requires API 34+");
            return;
        }
        try {
            Class<?> cls = obj.getClass();
            Log.d(TAG, "safeSetGainmap: ********* gainmapClass = " + cls.getName());
            if (!cls.getName().equals(GAINMAP_CLASS_NAME)) {
                Log.e(TAG, "Invalid gainmap object type: " + cls.getName());
                return;
            }
            Method declaredMethod = Bitmap.class.getDeclaredMethod("setGainmap", cls);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(bitmap, obj);
            Log.i(TAG, "Gainmap set successfully");
        } catch (NoSuchMethodException unused) {
            Log.e(TAG, "setGainmap method not found");
        } catch (Exception e) {
            Log.e(TAG, "Error setting gainmap: " + e.getMessage());
        }
    }

    public static Object createGainmapWithMeta(Bitmap bitmap, float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float f, float f2) {
        try {
            Object createGainmap = createGainmap(bitmap);
            if (createGainmap != null) {
                setGamma(createGainmap, fArr);
                setEpsilonSdr(createGainmap, fArr2);
                setEpsilonHdr(createGainmap, fArr3);
                setRatioMax(createGainmap, fArr4);
                setRatioMin(createGainmap, fArr5);
                setDisplayRatioForFullHdr(createGainmap, f);
                setMinDisplayRatioForHdrTransition(createGainmap, f2);
            }
            return createGainmap;
        } catch (Exception e) {
            Log.d(TAG, "Parameterized constructor failed, trying default constructor", e);
            return null;
        }
    }

    private static Object createGainmap(Bitmap bitmap) {
        try {
            if (gainmapClass == null) {
                gainmapClass = Class.forName(GAINMAP_CLASS_NAME);
            }
            Constructor<?> declaredConstructor = gainmapClass.getDeclaredConstructor(Bitmap.class);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(bitmap);
        } catch (Exception e) {
            Log.e(TAG, "Failed to create Gainmap instance", e);
            return null;
        }
    }

    private static boolean setGamma(Object obj, float[] fArr) {
        return invokeFloatArrayMethod(obj, "setGamma", fArr);
    }

    private static boolean setEpsilonSdr(Object obj, float[] fArr) {
        return invokeFloatArrayMethod(obj, "setEpsilonSdr", fArr);
    }

    private static boolean setEpsilonHdr(Object obj, float[] fArr) {
        return invokeFloatArrayMethod(obj, "setEpsilonHdr", fArr);
    }

    private static boolean setRatioMin(Object obj, float[] fArr) {
        return invokeFloatArrayMethod(obj, "setRatioMin", fArr);
    }

    private static boolean setRatioMax(Object obj, float[] fArr) {
        return invokeFloatArrayMethod(obj, "setRatioMax", fArr);
    }

    private static boolean setDisplayRatioForFullHdr(Object obj, float f) {
        return invokeFloatMethod(obj, "setDisplayRatioForFullHdr", f);
    }

    private static boolean setMinDisplayRatioForHdrTransition(Object obj, float f) {
        return invokeFloatMethod(obj, "setMinDisplayRatioForHdrTransition", f);
    }

    private static boolean invokeFloatMethod(Object obj, String str, float f) {
        if (obj == null) {
            return false;
        }
        try {
            gainmapClass.getMethod(str, Float.TYPE).invoke(obj, Float.valueOf(f));
            Log.d(TAG, str + " set to: " + f);
            return true;
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "Method " + str + " not found", e);
            return false;
        } catch (Exception e2) {
            Log.e(TAG, "Failed to invoke " + str, e2);
            return false;
        }
    }

    private static boolean invokeFloatArrayMethod(Object obj, String str, float[] fArr) {
        if (obj == null || TextUtils.isEmpty(str) || fArr == null || fArr.length < 3) {
            Log.e(TAG, "Gainmap instance is null, call createGainmap() first");
            return false;
        }
        try {
            gainmapClass.getMethod(str, Float.TYPE, Float.TYPE, Float.TYPE).invoke(obj, Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2]));
            Log.d(TAG, str + " set to: " + fArr);
            return true;
        } catch (NoSuchMethodException e) {
            Log.e(TAG, "Method " + str + " not found", e);
            return false;
        } catch (Exception e2) {
            Log.e(TAG, "Failed to invoke " + str, e2);
            return false;
        }
    }

    public static boolean setBT2020HLGColorSpace(Bitmap bitmap) {
        Object colorSpace;
        if (bitmap == null) {
            return false;
        }
        try {
            if (bt2020HlgNamed == null) {
                bt2020HlgNamed = getColorSpaceNamed("BT2020_HLG");
            }
            Object obj = bt2020HlgNamed;
            if (obj == null || (colorSpace = getColorSpace(obj)) == null) {
                return false;
            }
            return setColorSpaceReflectively(bitmap, colorSpace);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static Object getColorSpaceNamed(String str) {
        try {
            if (namedClass == null) {
                namedClass = Class.forName("android.graphics.ColorSpace$Named");
            }
            return namedClass.getField(str).get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Object getColorSpace(Object obj) {
        try {
            if (colorSpaceClass == null) {
                colorSpaceClass = Class.forName("android.graphics.ColorSpace");
            }
            Method declaredMethod = colorSpaceClass.getDeclaredMethod("get", obj.getClass());
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static boolean setColorSpaceReflectively(Bitmap bitmap, Object obj) {
        if (bitmap != null && obj != null) {
            try {
                Method declaredMethod = Bitmap.class.getDeclaredMethod("setColorSpace", Class.forName("android.graphics.ColorSpace"));
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(bitmap, obj);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static Bitmap createBitmapWithConfig(int i, int i2, String str) {
        if (i <= 0 || i2 <= 0) {
            Log.d(TAG, "Invalid width or height: " + i + "x" + i2);
            return null;
        }
        if (Build.VERSION.SDK_INT < 33) {
            Log.d(TAG, "Config " + str + " not supported on this API level");
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
        try {
            Object config = getConfig(str);
            if (config == null) {
                Log.e(TAG, "Failed to get config: " + str);
                return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            }
            return createBitmapReflectively(i, i2, config);
        } catch (Exception e) {
            Log.e(TAG, "Error creating bitmap: " + e.getMessage());
            return Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        }
    }

    private static Object getConfig(String str) {
        try {
            if (configClass == null) {
                configClass = Class.forName("android.graphics.Bitmap$Config");
            }
            return configClass.getField(str).get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Bitmap createBitmapReflectively(int i, int i2, Object obj) {
        if (i > 0 && i2 > 0 && obj != null) {
            try {
                Method declaredMethod = Bitmap.class.getDeclaredMethod("createBitmap", Integer.TYPE, Integer.TYPE, Class.forName("android.graphics.Bitmap$Config"));
                declaredMethod.setAccessible(true);
                return (Bitmap) declaredMethod.invoke(null, Integer.valueOf(i), Integer.valueOf(i2), obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
