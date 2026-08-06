package com.facebook.imageutils;

import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class HeifFormatUtil {
    private static final String TAG = "HeifFormatUtil";
    private static boolean mOptParseExif;
    private static volatile Class sHeifClass;
    private static Class sHeifDecodeClass;
    private static ImageFormat sHeifFormat;
    private static ImageFormat sHeifFormatAnimated;
    private static Method sParseMetaMethod;
    private static Method sParseMetaMethodByNativePtr;
    private static Method sParseThumbMetaMethod;
    private static Method sParseThumbMetaMethodByNativePtr;
    private static ImageFormat sVvifFormat;

    static {
        try {
            sHeifDecodeClass = Class.forName("com.bytedance.fresco.heif.HeifDecoder");
        } catch (ClassNotFoundException e) {
            FLog.e(TAG, "Heif init ", e);
        }
    }

    public static void setOptParseExif(boolean z) {
        mOptParseExif = z;
    }

    public static int[] parseSimpleMeta(byte[] bArr, int i) {
        Class heifClass = getHeifClass();
        if (heifClass == null) {
            return null;
        }
        try {
            if (sParseMetaMethod == null) {
                sParseMetaMethod = heifClass.getDeclaredMethod("parseSimpleMeta", byte[].class, Integer.TYPE, Boolean.TYPE);
            }
            Method method = sParseMetaMethod;
            if (method != null) {
                method.setAccessible(true);
                return (int[]) sParseMetaMethod.invoke(null, bArr, Integer.valueOf(i), Boolean.valueOf(mOptParseExif));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return null;
    }

    public static int[] parseThumbMeta(byte[] bArr, int i) {
        Class heifClass = getHeifClass();
        if (heifClass == null) {
            return null;
        }
        try {
            if (sParseThumbMetaMethod == null) {
                sParseThumbMetaMethod = heifClass.getDeclaredMethod("parseThumbMeta", byte[].class, Integer.TYPE);
            }
            Method method = sParseThumbMetaMethod;
            if (method != null) {
                method.setAccessible(true);
                return (int[]) sParseThumbMetaMethod.invoke(null, bArr, Integer.valueOf(i));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return null;
    }

    public static int[] parseSimpleMetaByNativePtr(long j, int i) {
        Class heifClass = getHeifClass();
        if (heifClass == null) {
            return null;
        }
        try {
            if (sParseMetaMethodByNativePtr == null) {
                sParseMetaMethodByNativePtr = heifClass.getDeclaredMethod("parseSimpleMetaByNativePtr", Long.TYPE, Integer.TYPE);
            }
            Method method = sParseMetaMethodByNativePtr;
            if (method != null) {
                method.setAccessible(true);
                return (int[]) sParseMetaMethodByNativePtr.invoke(null, Long.valueOf(j), Integer.valueOf(i));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return null;
    }

    public static int[] parseThumbMetaByNativePtr(long j, int i) {
        Class heifClass = getHeifClass();
        if (heifClass == null) {
            return null;
        }
        try {
            if (sParseThumbMetaMethodByNativePtr == null) {
                sParseThumbMetaMethodByNativePtr = heifClass.getDeclaredMethod("parseThumbMetaByNativePtr", Long.TYPE, Integer.TYPE);
            }
            Method method = sParseThumbMetaMethodByNativePtr;
            if (method != null) {
                method.setAccessible(true);
                return (int[]) sParseThumbMetaMethodByNativePtr.invoke(null, Long.valueOf(j), Integer.valueOf(i));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return null;
    }

    public static ImageFormat getHeifFormat() {
        ImageFormat imageFormat = sHeifFormat;
        if (imageFormat != null) {
            return imageFormat;
        }
        Class cls = sHeifDecodeClass;
        if (cls == null) {
            return null;
        }
        try {
            sHeifFormat = (ImageFormat) cls.getDeclaredField("HEIF_FORMAT").get(null);
        } catch (IllegalAccessException e) {
            FLog.e(TAG, "HeifFormat init ", e);
        } catch (NoSuchFieldException e2) {
            FLog.e(TAG, "HeifFormat init ", e2);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return sHeifFormat;
    }

    public static ImageFormat getVvifFormat() {
        ImageFormat imageFormat = sVvifFormat;
        if (imageFormat != null) {
            return imageFormat;
        }
        Class cls = sHeifDecodeClass;
        if (cls == null) {
            return null;
        }
        try {
            sVvifFormat = (ImageFormat) cls.getDeclaredField("VVIC_FORMAT").get(null);
        } catch (IllegalAccessException e) {
            FLog.e(TAG, "VvifFormat init ", e);
        } catch (NoSuchFieldException e2) {
            FLog.e(TAG, "VvifFormat init ", e2);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return sVvifFormat;
    }

    public static ImageFormat getHeifFormatAnimated() {
        ImageFormat imageFormat = sHeifFormatAnimated;
        if (imageFormat != null) {
            return imageFormat;
        }
        Class cls = sHeifDecodeClass;
        if (cls == null) {
            return null;
        }
        try {
            sHeifFormatAnimated = (ImageFormat) cls.getDeclaredField("HEIF_FORMAT_ANIMATED").get(null);
        } catch (IllegalAccessException e) {
            FLog.e(TAG, "HEIF_FORMAT_ANIMATED init ", e);
        } catch (NoSuchFieldException e2) {
            FLog.e(TAG, "HEIF_FORMAT_ANIMATED init ", e2);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return sHeifFormatAnimated;
    }

    public static boolean canParseThumbDataAndSet(EncodedImage encodedImage) {
        int[] readHeifThumbData;
        if (encodedImage != null && DefaultImageFormats.isHeifFormat(encodedImage.getImageFormat())) {
            try {
                int available = encodedImage.getInputStream().available();
                if (EncodedImage.isOptHeifParse()) {
                    readHeifThumbData = readHeifThumbData(encodedImage.getNativePtr(), encodedImage.getSize());
                } else {
                    readHeifThumbData = readHeifThumbData(encodedImage.getInputStream());
                }
                if (readHeifThumbData != null && readHeifThumbData.length >= 8 && readHeifThumbData[5] == 1) {
                    FLog.d(TAG, "fresco_parseThumbData available len:" + available + " thumb:" + (readHeifThumbData[6] + readHeifThumbData[7]));
                    if (readHeifThumbData[6] + readHeifThumbData[7] < available) {
                        encodedImage.setIsDecodeThumb(true);
                        encodedImage.setThumbWidth(readHeifThumbData[0]);
                        encodedImage.setThumbHeight(readHeifThumbData[1]);
                    }
                    return true;
                }
            } catch (IOException e) {
                FLog.e(TAG, "canParseThumbData ", e);
            }
        }
        return false;
    }

    public static int[] readHeifThumbData(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        int available = inputStream.available();
        byte[] bArr = new byte[available];
        inputStream.reset();
        if (inputStream.read(bArr, 0, available) != -1) {
            return parseThumbMeta(bArr, available);
        }
        return null;
    }

    public static int[] readHeifThumbData(long j, int i) {
        return parseThumbMetaByNativePtr(j, i);
    }

    public static int[] readHeifFormatImageSizeForSimple(InputStream inputStream) throws IOException {
        int available = inputStream.available();
        byte[] bArr = new byte[available];
        inputStream.reset();
        if (inputStream.read(bArr, 0, available) == -1) {
            return null;
        }
        int[] parseSimpleMeta = parseSimpleMeta(bArr, available);
        Log.d(TAG, "readHeifFormatImageSizeForSimple: -----1111--------result = " + parseSimpleMeta);
        if (parseSimpleMeta != null) {
            Log.d(TAG, "readHeifFormatImageSizeForSimple: -----1111--------result length = " + parseSimpleMeta.length);
        }
        return parseSimpleMeta;
    }

    public static int[] readHeifFormatImageSizeForSimple(long j, int i) {
        int[] parseSimpleMetaByNativePtr = parseSimpleMetaByNativePtr(j, i);
        Log.d(TAG, "readHeifFormatImageSizeForSimple: -----2222--------result = " + parseSimpleMetaByNativePtr);
        if (parseSimpleMetaByNativePtr != null) {
            Log.d(TAG, "readHeifFormatImageSizeForSimple: -----2222--------result length = " + parseSimpleMetaByNativePtr.length);
        }
        return parseSimpleMetaByNativePtr;
    }

    private static synchronized Class getHeifClass() {
        Class cls;
        synchronized (HeifFormatUtil.class) {
            if (sHeifClass == null) {
                try {
                    sHeifClass = Class.forName("com.bytedance.fresco.nativeheif.Heif");
                } catch (ClassNotFoundException e) {
                    FLog.e(TAG, "Heif init ", e);
                }
            }
            cls = sHeifClass;
        }
        return cls;
    }
}
