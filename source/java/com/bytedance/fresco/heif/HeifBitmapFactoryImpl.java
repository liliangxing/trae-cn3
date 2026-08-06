package com.bytedance.fresco.heif;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import coil3.disk.DiskLruCache;
import com.bytedance.fresco.nativeheif.Heif;
import com.bytedance.fresco.nativeheif.HeifData;
import com.bytedance.fresco.sr.SREventTrackingConst;
import com.facebook.common.heif.HeicSROptions;
import com.facebook.common.heif.HeifBitmapFactory;
import com.facebook.common.heif.HeifDecodeData;
import com.facebook.common.heif.SRMonitorUtil;
import com.facebook.common.internal.Closeables;
import com.facebook.common.logging.FLog;
import com.facebook.common.webp.BitmapCreator;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imageutils.HeifFormatUtil;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class HeifBitmapFactoryImpl implements HeifBitmapFactory {
    private static final String TAG = "HeifBitmapFactoryImpl";
    private static BitmapCreator mBitmapCreator;

    public String getScaleType(int i) {
        return i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? DiskLruCache.VERSION : "1.4" : "1.3" : "1.2" : "1.1" : ExifInterface.GPS_MEASUREMENT_2D : "1.5";
    }

    public void setBitmapCreator(BitmapCreator bitmapCreator) {
        mBitmapCreator = bitmapCreator;
    }

    public Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return decodeStream(inputStream, rect, options, null);
    }

    public Bitmap decodeStream(InputStream inputStream, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData) {
        InputStream inputStream2;
        int[] readHeifFormatImageSizeForSimple;
        try {
            int available = inputStream.available();
            if (inputStream.markSupported()) {
                inputStream2 = inputStream;
            } else {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                bufferedInputStream.mark(available);
                inputStream2 = bufferedInputStream;
            }
            if (!FrescoCacheMonitorUtil.isUseUltimateOptHeifBitmap() && !FrescoCacheMonitorUtil.isUseNewOptHeifBitmap() && !FrescoCacheMonitorUtil.isOptHeifParse()) {
                if (FrescoCacheMonitorUtil.isOptHeifParse()) {
                    readHeifFormatImageSizeForSimple = HeifFormatUtil.readHeifFormatImageSizeForSimple(inputStream2);
                } else {
                    readHeifFormatImageSizeForSimple = HeifFormatUtil.readHeifFormatImageSizeForSimple(inputStream2);
                }
                if (options != null && options.inJustDecodeBounds) {
                    if (readHeifFormatImageSizeForSimple != null) {
                        options.outWidth = readHeifFormatImageSizeForSimple[0];
                        options.outHeight = readHeifFormatImageSizeForSimple[1];
                    }
                    return null;
                }
                inputStream2.reset();
            }
            if (available <= 0) {
                return null;
            }
            if (heifDecodeData != null && heifDecodeData.getHdrType() > 0 && FrescoCacheMonitorUtil.isUseHeicHdr() && Build.VERSION.SDK_INT >= 34) {
                if (HeifDecoder.mHeifDecodeLog) {
                    Log.d(TAG, "decodeStream: decodeStreamHdrHeic");
                }
                return decodeStreamHdrHeic(inputStream2, available, rect, options, heifDecodeData);
            }
            if (FrescoCacheMonitorUtil.isUseNewOptHeifBitmap()) {
                if (HeifDecoder.mHeifDecodeLog) {
                    Log.d(TAG, "decodeStream: decodeStreamNewOpt");
                }
                return decodeStreamNewOpt(inputStream2, available, rect, options, heifDecodeData);
            }
            if (FrescoCacheMonitorUtil.isUseOptHeifBitmap() || ImagePipelineConfig.getInstance().isUseOptHeifBitmap()) {
                if (HeifDecoder.mHeifDecodeLog) {
                    Log.d(TAG, "decodeStream: decodeStreamOpt");
                }
                return decodeStreamOpt(inputStream2, available, rect, options, heifDecodeData);
            }
            if (HeifDecoder.mHeifDecodeLog) {
                Log.d(TAG, "decodeStream: decodeStreamBefore");
            }
            return decodeStreamBefore(inputStream2, rect, options, heifDecodeData);
        } catch (IOException unused) {
            return null;
        }
    }

    public Bitmap decodeStreamHdrHeic(InputStream inputStream, int i, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        Rect rect2 = rect == null ? new Rect() : rect;
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                allocateDirect.put(bArr, 0, read);
            }
            allocateDirect.flip();
            allocateDirect.compact();
            if (allocateDirect.limit() > 0) {
                int i2 = options != null ? options.inSampleSize : 1;
                int i3 = FrescoCacheMonitorUtil.isUseHeicHdrRgba102() ? 1 : 0;
                if (HeifDecoder.mHeifDecodeLog) {
                    Log.d(TAG, "decodeStreamHdrHeic: toRgbaWithGainMap use ttheif::heif_decode_to_rgba_hdr, tonemap = " + i3);
                }
                HeifData rgbaWithGainMap = Heif.toRgbaWithGainMap(allocateDirect, i, i3, FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), i2, rect2.left, rect2.top, rect2.height(), rect2.width());
                if (rgbaWithGainMap != null) {
                    if (heifDecodeData != null) {
                        heifDecodeData.setHeifDecError(rgbaWithGainMap.error);
                    }
                    if (i3 == 0) {
                        if (HeifDecoder.mHeifDecodeLog) {
                            Log.d(TAG, "decodeStreamHdrHeic: gainMapData = " + rgbaWithGainMap.gainMapData);
                        }
                        if (rgbaWithGainMap.gainMapData != null && HeifDecoder.mHeifDecodeLog) {
                            Log.d(TAG, "decodeStreamHdrHeic: gainMapData length = " + rgbaWithGainMap.gainMapData.length);
                        }
                        if (rgbaWithGainMap.gainMapData != null && rgbaWithGainMap.gainMapData.length > 0 && rgbaWithGainMap.gainMapWidth > 0 && rgbaWithGainMap.gainMapHeight > 0) {
                            return rgbaWithGainMap.newBitmapWithGainMap(Bitmap.Config.ARGB_8888, FrescoCacheMonitorUtil.isUseHeicHdrRgba102());
                        }
                    } else if (Build.VERSION.SDK_INT >= 33) {
                        Log.d(TAG, "decodeStreamHdrHeic: ***********RGBA_1010102*********");
                        return rgbaWithGainMap.newBitmapWithGainMap(null, FrescoCacheMonitorUtil.isUseHeicHdrRgba102());
                    }
                    return rgbaWithGainMap.newBitmap(options == null ? Bitmap.Config.ARGB_8888 : options.inPreferredConfig);
                }
            }
        } finally {
            try {
                return null;
            } finally {
            }
        }
        return null;
    }

    public Bitmap decodeByNativePtr(long j, int i, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData) {
        int i2;
        Rect rect2 = rect == null ? new Rect() : rect;
        if (options != null) {
            try {
                i2 = options.inSampleSize;
            } catch (Throwable th) {
                FLog.e(TAG, "HeifFormatDecoder.decodeByNativePtr exception:" + Log.getStackTraceString(th));
                return null;
            }
        } else {
            i2 = 1;
        }
        if (options != null && options.inPreferredConfig == Bitmap.Config.RGB_565) {
            if (HeifDecoder.mHeifDecodeLog) {
                Log.d(TAG, "decodeByNativePtr: toRgb565BitmapByNativePtr use ttheif::".concat(FrescoCacheMonitorUtil.getTTHeifDecOpt() ? "heif_decode_to_rgb565_ext_opt|vvif_decode_to_rgb565_ext_opt" : "heif_decode_to_rgb565_extern_buffer|vvif_decode_to_rgb565_extern_buffer"));
            }
            int[] iArr = new int[1];
            Bitmap rgb565BitmapByNativePtr = Heif.toRgb565BitmapByNativePtr(j, FrescoCacheMonitorUtil.getTTHeifDecOpt(), i, heifDecodeData.hasAlpha(), heifDecodeData.getWidth(), heifDecodeData.getHeight(), FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), FrescoCacheMonitorUtil.isVvicUseWpp(), FrescoCacheMonitorUtil.getVvicDecodeThreads(), i2, rect2.left, rect2.top, rect2.height(), rect2.width(), iArr);
            heifDecodeData.setHeifDecError(iArr[0]);
            return rgb565BitmapByNativePtr;
        }
        if (HeifDecoder.mHeifDecodeLog) {
            Log.d(TAG, "decodeByNativePtr: toRgbaBitmapByNativePtr use ttheif::".concat(FrescoCacheMonitorUtil.getTTHeifDecOpt() ? "heif_decode_to_rgba_ext_opt|vvif_decode_to_rgba_ext_opt" : "heif_decode_to_rgba_extern_buffer|vvif_decode_to_rgba_extern_buffer"));
        }
        int[] iArr2 = new int[1];
        Bitmap rgbaBitmapByNativePtr = Heif.toRgbaBitmapByNativePtr(j, FrescoCacheMonitorUtil.getTTHeifDecOpt(), i, heifDecodeData.hasAlpha(), heifDecodeData.getWidth(), heifDecodeData.getHeight(), FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), FrescoCacheMonitorUtil.isVvicUseWpp(), FrescoCacheMonitorUtil.getVvicDecodeThreads(), i2, rect2.left, rect2.top, rect2.height(), rect2.width(), iArr2);
        heifDecodeData.setHeifDecError(iArr2[0]);
        return rgbaBitmapByNativePtr;
    }

    public Bitmap decodeByNativePtrCombineSr(long j, int i, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData, HeicSROptions heicSROptions, Map<String, String> map) {
        int i2;
        Rect rect2 = rect == null ? new Rect() : rect;
        if (options != null) {
            try {
                i2 = options.inSampleSize;
            } catch (Throwable th) {
                FLog.e(TAG, "HeifFormatDecoder.decodeByNativePtrCombineSr exception:" + Log.getStackTraceString(th));
                return null;
            }
        } else {
            i2 = 1;
        }
        if (options != null && options.inPreferredConfig == Bitmap.Config.RGB_565) {
            if (HeifDecoder.mHeifDecodeLog) {
                Log.d(TAG, "decodeByNativePtrCombineSr: toRgb565BitmapByNativePtr use ttheif::".concat(FrescoCacheMonitorUtil.getTTHeifDecOpt() ? "heif_decode_to_rgb565_ext_opt|vvif_decode_to_rgb565_ext_opt" : "heif_decode_to_rgb565_extern_buffer|vvif_decode_to_rgb565_extern_buffer"));
            }
            int[] iArr = new int[6];
            Bitmap rgbaBitmapByNativePtrWithBmfSr = Heif.toRgbaBitmapByNativePtrWithBmfSr(j, FrescoCacheMonitorUtil.getTTHeifDecOpt(), i, heifDecodeData.hasAlpha(), heifDecodeData.getWidth(), heifDecodeData.getHeight(), FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), FrescoCacheMonitorUtil.isVvicUseWpp(), FrescoCacheMonitorUtil.getVvicDecodeThreads(), i2, rect2.left, rect2.top, rect2.height(), rect2.width(), SRMonitorUtil.getMaxWidth(), SRMonitorUtil.getMaxHeight(), SRMonitorUtil.getConcurrencyLimit(), getScaleTypeFromHeicSROption(heifDecodeData.getWidth(), heifDecodeData.getHeight(), i2, heicSROptions), SRMonitorUtil.getCacheDir(), iArr);
            heifDecodeData.setHeifDecError(iArr[0]);
            return rgbaBitmapByNativePtrWithBmfSr;
        }
        if (HeifDecoder.mHeifDecodeLog) {
            Log.d(TAG, "decodeByNativePtrCombineSr: toRgbaBitmapByNativePtr use ttheif::".concat(FrescoCacheMonitorUtil.getTTHeifDecOpt() ? "heif_decode_to_rgba_ext_opt|vvif_decode_to_rgba_ext_opt" : "heif_decode_to_rgba_extern_buffer|vvif_decode_to_rgba_extern_buffer"));
        }
        int[] iArr2 = new int[6];
        int scaleTypeFromHeicSROption = getScaleTypeFromHeicSROption(heifDecodeData.getWidth(), heifDecodeData.getHeight(), i2, heicSROptions);
        Bitmap rgbaBitmapByNativePtrWithBmfSr2 = Heif.toRgbaBitmapByNativePtrWithBmfSr(j, FrescoCacheMonitorUtil.getTTHeifDecOpt(), i, heifDecodeData.hasAlpha(), heifDecodeData.getWidth(), heifDecodeData.getHeight(), FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), FrescoCacheMonitorUtil.isVvicUseWpp(), FrescoCacheMonitorUtil.getVvicDecodeThreads(), i2, rect2.left, rect2.top, rect2.height(), rect2.width(), SRMonitorUtil.getMaxWidth(), SRMonitorUtil.getMaxHeight(), SRMonitorUtil.getConcurrencyLimit(), scaleTypeFromHeicSROption, SRMonitorUtil.getCacheDir(), iArr2);
        heifDecodeData.setHeifDecError(iArr2[0]);
        if (map != null) {
            map.put(SREventTrackingConst.SR_MODE, "BMFSR," + SRMonitorUtil.getStageType());
            map.put(SREventTrackingConst.SR_MAX_WIDTH, SRMonitorUtil.getMaxWidth() + "");
            map.put(SREventTrackingConst.SR_MAX_HEIGHT, SRMonitorUtil.getMaxHeight() + "");
            map.put(SREventTrackingConst.SR_STRETCH, getScaleType(scaleTypeFromHeicSROption));
            map.put(SREventTrackingConst.SR_SCALE_TYPE, String.valueOf(scaleTypeFromHeicSROption));
            map.put(SREventTrackingConst.SR_IS_ENABLE_ALL, heicSROptions.isAdaptiveSr + "");
            if (scaleTypeFromHeicSROption < 0) {
                map.put(SREventTrackingConst.SR_STATUS, DiskLruCache.VERSION);
                map.put(SREventTrackingConst.SR_ERROR, "The scale is abnormal, scale = " + scaleTypeFromHeicSROption);
            } else {
                int i3 = iArr2[1];
                int i4 = iArr2[2];
                map.put("sr_heic_opt", i4 + "");
                if (i3 == 1) {
                    map.put(SREventTrackingConst.SR_STATUS, "0");
                    map.put(SREventTrackingConst.SR_DURATION, String.valueOf(iArr2[5]));
                    if (rgbaBitmapByNativePtrWithBmfSr2 != null) {
                        map.put(SREventTrackingConst.SR_WIDTH, rgbaBitmapByNativePtrWithBmfSr2.getWidth() + "");
                        map.put(SREventTrackingConst.SR_HEIGHT, rgbaBitmapByNativePtrWithBmfSr2.getHeight() + "");
                    }
                } else {
                    map.put(SREventTrackingConst.SR_STATUS, DiskLruCache.VERSION);
                    if (i4 == 1) {
                        map.put(SREventTrackingConst.SR_ERROR, "bmf init result is: " + iArr2[3] + ", process result is: " + iArr2[4]);
                    }
                }
            }
        }
        return rgbaBitmapByNativePtrWithBmfSr2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        if (r11 < 2.0f) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008e, code lost:
    
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0089, code lost:
    
        if (r11 <= 1.5f) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int getScaleTypeFromHeicSROption(int i, int i2, int i3, HeicSROptions heicSROptions) {
        if (heicSROptions == null) {
            return -1;
        }
        if (!heicSROptions.isAdaptiveSr) {
            return heicSROptions.scaleType;
        }
        if (i3 > 1) {
            i /= i3;
            i2 /= i3;
        }
        if (heicSROptions.targetWidth <= 0 || heicSROptions.targetHeight <= 0 || i <= 0 || i2 <= 0) {
            return -1;
        }
        float max = Math.max((heicSROptions.targetWidth * 1.0f) / i, (heicSROptions.targetHeight * 1.0f) / i2);
        if (FrescoCacheMonitorUtil.isSRAutoScaleLowerFirst()) {
            if (max <= 1.0f) {
                return -1;
            }
            if (max >= 1.2f) {
                if (max >= 1.3f) {
                    if (max >= 1.4f) {
                        if (max >= 1.5f) {
                        }
                        return 32;
                    }
                    return 16;
                }
                return 8;
            }
            return 4;
        }
        if (max <= 1.0f) {
            return -1;
        }
        if (max > 1.1f) {
            if (max > 1.2f) {
                if (max > 1.3f) {
                    if (max > 1.4f) {
                    }
                    return 32;
                }
                return 16;
            }
            return 8;
        }
        return 4;
    }

    public Bitmap decodeStreamBefore(InputStream inputStream, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData) {
        HeifData rgba;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Rect rect2 = rect == null ? new Rect() : rect;
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray.length > 0) {
                int i = options != null ? options.inSampleSize : 1;
                if (options != null && options.inPreferredConfig == Bitmap.Config.RGB_565) {
                    rgba = Heif.toRgb565(byteArray, FrescoCacheMonitorUtil.getTTHeifDecOpt(), byteArray.length, FrescoCacheMonitorUtil.getVvicDecOpt(), FrescoCacheMonitorUtil.getVvicOptMode(), FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), FrescoCacheMonitorUtil.isVvicUseWpp(), FrescoCacheMonitorUtil.getVvicDecodeThreads(), i, rect2.left, rect2.top, rect2.height(), rect2.width(), FrescoCacheMonitorUtil.isFixVvicDecode());
                    if (HeifDecoder.mHeifDecodeLog) {
                        Log.d(TAG, "decodeStreamBefore: toRgb565 use ttheif::" + (FrescoCacheMonitorUtil.getTTHeifDecOpt() ? "heif_decode_to_rgb565_opt|vvif_decode_to_rgb565_opt" : "heif_decode_to_rgb565|vvif_decode_to_rgb565"));
                    }
                } else {
                    rgba = Heif.toRgba(byteArray, FrescoCacheMonitorUtil.getTTHeifDecOpt(), byteArray.length, FrescoCacheMonitorUtil.getVvicDecOpt(), FrescoCacheMonitorUtil.getVvicOptMode(), FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), FrescoCacheMonitorUtil.isVvicUseWpp(), FrescoCacheMonitorUtil.getVvicDecodeThreads(), i, rect2.left, rect2.top, rect2.height(), rect2.width(), FrescoCacheMonitorUtil.isFixVvicDecode());
                    if (HeifDecoder.mHeifDecodeLog) {
                        Log.d(TAG, "decodeStreamBefore: toRgba use ttheif::" + (FrescoCacheMonitorUtil.getTTHeifDecOpt() ? "heif_decode_to_rgba_opt|vvif_decode_to_rgba_opt" : "heif_decode_to_rgba|vvif_decode_to_rgba"));
                    }
                }
                if (rgba != null) {
                    if (heifDecodeData != null) {
                        heifDecodeData.setHeifDecError(rgba.error);
                    }
                    return rgba.newBitmap(options == null ? Bitmap.Config.ARGB_8888 : options.inPreferredConfig);
                }
            }
        } finally {
            try {
                Closeables.close(byteArrayOutputStream, true);
            } finally {
                try {
                    Closeables.close(byteArrayOutputStream, true);
                } catch (IOException unused) {
                }
            }
        }
        try {
            Closeables.close(byteArrayOutputStream, true);
        } catch (IOException unused2) {
            return null;
        }
    }

    public Bitmap decodeStreamOpt(InputStream inputStream, int i, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData) {
        ByteBuffer byteBuffer;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        Rect rect2 = rect == null ? new Rect() : rect;
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                allocateDirect.put(bArr, 0, read);
            }
            allocateDirect.flip();
            allocateDirect.compact();
        } catch (Throwable th) {
            th = th;
            byteBuffer = allocateDirect;
        }
        if (allocateDirect.limit() <= 0) {
            byteBuffer = allocateDirect;
            return null;
        }
        int i2 = options != null ? options.inSampleSize : 1;
        try {
            if (options != null && options.inPreferredConfig == Bitmap.Config.RGB_565) {
                if (HeifDecoder.mHeifDecodeLog) {
                    Log.d(TAG, "decodeStreamOpt: toRgb565Bitmap use ttheif::" + (FrescoCacheMonitorUtil.getTTHeifDecOpt() ? "heif_decode_to_rgb565_opt|vvif_decode_to_rgb565_opt" : "heif_decode_to_rgb565|vvif_decode_to_rgb565"));
                }
                Bitmap rgb565Bitmap = Heif.toRgb565Bitmap(allocateDirect, FrescoCacheMonitorUtil.getTTHeifDecOpt(), i, FrescoCacheMonitorUtil.getVvicDecOpt(), FrescoCacheMonitorUtil.getVvicOptMode(), FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), FrescoCacheMonitorUtil.isVvicUseWpp(), FrescoCacheMonitorUtil.getVvicDecodeThreads(), i2, rect2.left, rect2.top, rect2.height(), rect2.width());
                allocateDirect.clear();
                return rgb565Bitmap;
            }
            if (HeifDecoder.mHeifDecodeLog) {
                Log.d(TAG, "decodeStreamOpt: toRgbaBitmap use ttheif::" + (FrescoCacheMonitorUtil.getTTHeifDecOpt() ? "heif_decode_to_rgba_opt|vvif_decode_to_rgba_opt" : "heif_decode_to_rgba|vvif_decode_to_rgba"));
            }
            Bitmap rgbaBitmap = Heif.toRgbaBitmap(allocateDirect, FrescoCacheMonitorUtil.getTTHeifDecOpt(), i, FrescoCacheMonitorUtil.getVvicDecOpt(), FrescoCacheMonitorUtil.getVvicOptMode(), FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), FrescoCacheMonitorUtil.isVvicUseWpp(), FrescoCacheMonitorUtil.getVvicDecodeThreads(), i2, rect2.left, rect2.top, rect2.height(), rect2.width());
            allocateDirect.clear();
            return rgbaBitmap;
        } catch (Throwable th2) {
            th = th2;
            try {
                FLog.e(TAG, "HeifFormatDecoder.decodeStreamOpt exception:" + Log.getStackTraceString(th));
                return null;
            } finally {
                byteBuffer.clear();
            }
        }
    }

    public Bitmap decodeStreamNewOpt(InputStream inputStream, int i, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData) {
        ByteBuffer byteBuffer;
        String str = TAG;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        Rect rect2 = rect == null ? new Rect() : rect;
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                allocateDirect.put(bArr, 0, read);
            }
            allocateDirect.flip();
            allocateDirect.compact();
        } catch (Throwable th) {
            th = th;
            byteBuffer = allocateDirect;
        }
        if (allocateDirect.limit() <= 0) {
            byteBuffer = allocateDirect;
            return null;
        }
        int i2 = options != null ? options.inSampleSize : 1;
        try {
            if (options != null && options.inPreferredConfig == Bitmap.Config.RGB_565) {
                if (HeifDecoder.mHeifDecodeLog) {
                    Log.d(TAG, "decodeStreamNewOpt: toRgb565BitmapOpt use ttheif::" + (FrescoCacheMonitorUtil.getTTHeifDecOpt() ? "heif_decode_to_rgb565_ext_opt|vvif_decode_to_rgb565_ext_opt" : "heif_decode_to_rgb565_extern_buffer|vvif_decode_to_rgb565_extern_buffer"));
                }
                int[] iArr = new int[1];
                try {
                    Bitmap rgb565BitmapOpt = Heif.toRgb565BitmapOpt(allocateDirect, FrescoCacheMonitorUtil.getTTHeifDecOpt(), i, heifDecodeData.hasAlpha(), heifDecodeData.getWidth(), heifDecodeData.getHeight(), FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), FrescoCacheMonitorUtil.isVvicUseWpp(), FrescoCacheMonitorUtil.getVvicDecodeThreads(), i2, rect2.left, rect2.top, rect2.height(), rect2.width(), iArr);
                    heifDecodeData.setHeifDecError(iArr[0]);
                    allocateDirect.clear();
                    return rgb565BitmapOpt;
                } catch (Throwable th2) {
                    th = th2;
                    byteBuffer = allocateDirect;
                    str = TAG;
                    FLog.e(str, "HeifFormatDecoder.decodeStreamNewOpt exception:" + Log.getStackTraceString(th));
                    return null;
                }
            }
            byteBuffer = allocateDirect;
            if (HeifDecoder.mHeifDecodeLog) {
                String str2 = "decodeStreamNewOpt: toRgbaBitmapOpt use ttheif::" + (FrescoCacheMonitorUtil.getTTHeifDecOpt() ? "heif_decode_to_rgba_ext_opt|vvif_decode_to_rgba_ext_opt" : "heif_decode_to_rgba_extern_buffer|vvif_decode_to_rgba_extern_buffer");
                str = TAG;
                try {
                    Log.d(str, str2);
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        FLog.e(str, "HeifFormatDecoder.decodeStreamNewOpt exception:" + Log.getStackTraceString(th));
                        return null;
                    } finally {
                        byteBuffer.clear();
                    }
                }
            } else {
                str = TAG;
            }
            int[] iArr2 = new int[1];
            Bitmap rgbaBitmapOpt = Heif.toRgbaBitmapOpt(byteBuffer, FrescoCacheMonitorUtil.getTTHeifDecOpt(), i, heifDecodeData.hasAlpha(), heifDecodeData.getWidth(), heifDecodeData.getHeight(), FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), FrescoCacheMonitorUtil.isVvicUseWpp(), FrescoCacheMonitorUtil.getVvicDecodeThreads(), i2, rect2.left, rect2.top, rect2.height(), rect2.width(), iArr2);
            heifDecodeData.setHeifDecError(iArr2[0]);
            return rgbaBitmapOpt;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public Bitmap decodeByteArray(byte[] bArr, int i, int i2, BitmapFactory.Options options) {
        int i3;
        BitmapFactory.Options options2;
        HeifData rgba;
        if (bArr.length > 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            if (options != null) {
                try {
                    if (options.inJustDecodeBounds) {
                        int[] readHeifFormatImageSizeForSimple = HeifFormatUtil.readHeifFormatImageSizeForSimple(byteArrayInputStream);
                        if (readHeifFormatImageSizeForSimple != null) {
                            options.outWidth = readHeifFormatImageSizeForSimple[0];
                            options.outHeight = readHeifFormatImageSizeForSimple[1];
                        }
                        return null;
                    }
                } catch (IOException unused) {
                } finally {
                    Closeables.closeQuietly(byteArrayInputStream);
                }
            }
            byteArrayInputStream.reset();
            if (options != null) {
                try {
                    i3 = options.inSampleSize;
                } catch (Throwable th) {
                    FLog.e(TAG, "HeifFormatDecoder.decode exception:" + Log.getStackTraceString(th));
                }
            } else {
                i3 = 1;
            }
            if (options != null && options.inPreferredConfig == Bitmap.Config.RGB_565) {
                options2 = options;
                rgba = Heif.toRgb565(bArr, FrescoCacheMonitorUtil.getTTHeifDecOpt(), bArr.length, FrescoCacheMonitorUtil.getVvicDecOpt(), FrescoCacheMonitorUtil.getVvicOptMode(), FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), FrescoCacheMonitorUtil.isVvicUseWpp(), FrescoCacheMonitorUtil.getVvicDecodeThreads(), i3, -1, -1, -1, -1, FrescoCacheMonitorUtil.isFixVvicDecode());
            } else {
                options2 = options;
                rgba = Heif.toRgba(bArr, FrescoCacheMonitorUtil.getTTHeifDecOpt(), bArr.length, FrescoCacheMonitorUtil.getVvicDecOpt(), FrescoCacheMonitorUtil.getVvicOptMode(), FrescoCacheMonitorUtil.isHeicUseWpp(), FrescoCacheMonitorUtil.getHeicDecodeThreads(), FrescoCacheMonitorUtil.isVvicUseWpp(), FrescoCacheMonitorUtil.getVvicDecodeThreads(), i3, -1, -1, -1, -1, FrescoCacheMonitorUtil.isFixVvicDecode());
            }
            if (rgba != null) {
                return rgba.newBitmap(options2 == null ? Bitmap.Config.ARGB_8888 : options2.inPreferredConfig);
            }
        }
        return null;
    }

    public Bitmap decodeThumbByNativePtr(long j, int i, int i2, int i3, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData) {
        try {
            return Heif.toThumbRgbaBitmapByNativePtr(j, i, i2, i3);
        } catch (Throwable th) {
            FLog.e(TAG, "HeifFormatDecoder.decodeThumbByNativePtr exception:" + Log.getStackTraceString(th));
            return null;
        }
    }

    public Bitmap decodeThumb(InputStream inputStream, Rect rect, BitmapFactory.Options options) {
        return decodeThumb(inputStream, rect, options, null);
    }

    public Bitmap decodeThumb(InputStream inputStream, Rect rect, BitmapFactory.Options options, HeifDecodeData heifDecodeData) {
        HeifData thumbRgba;
        if (options != null && options.inJustDecodeBounds) {
            try {
                int[] readHeifFormatImageSizeForSimple = HeifFormatUtil.readHeifFormatImageSizeForSimple(inputStream);
                if (readHeifFormatImageSizeForSimple != null) {
                    options.outWidth = readHeifFormatImageSizeForSimple[0];
                    options.outHeight = readHeifFormatImageSizeForSimple[1];
                }
            } catch (IOException unused) {
            }
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray.length > 0 && (thumbRgba = Heif.toThumbRgba(byteArray, byteArray.length)) != null) {
                if (heifDecodeData != null) {
                    heifDecodeData.setHeifDecError(thumbRgba.error);
                }
                return thumbRgba.newBitmap(null);
            }
        } finally {
            try {
                Closeables.close(byteArrayOutputStream, true);
            } finally {
                try {
                    Closeables.close(byteArrayOutputStream, true);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            Closeables.close(byteArrayOutputStream, true);
        } catch (IOException unused3) {
            return null;
        }
    }
}
