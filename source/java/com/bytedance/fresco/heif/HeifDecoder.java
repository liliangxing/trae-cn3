package com.bytedance.fresco.heif;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.common.heif.HeifBitmapFactory;
import com.facebook.common.heif.HeifDecodeData;
import com.facebook.common.internal.Closeables;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatCheckerUtils;
import com.facebook.imagepipeline.bitmaps.SimpleBitmapReleaser;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.facebook.imagepipeline.core.FrescoCacheMonitorUtil;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class HeifDecoder {
    public static final int MAX_BITMAP_SIZE = 104857600;
    public static final String TAG = "XGFrescoLog";
    public static final int TARGET_BITMAP_SIZE = 4194304;
    public static final ImageFormat HEIF_FORMAT = new ImageFormat("HEIF_FORMAT", "heic");
    public static final ImageFormat VVIC_FORMAT = new ImageFormat("VVIC_FORMAT", "vvic");
    public static final ImageFormat HEIF_FORMAT_ANIMATED = new ImageFormat("HEIF_FORMAT_ANIMATED", "heic");
    public static boolean DEBUG = false;
    public static HeifBitmapFactory sBitmapFactory = new HeifBitmapFactoryImpl();
    public static boolean sHeifWppEnable = true;
    public static boolean mHeifDecodeLog = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static BitmapFactory.Options getDecodeOptionsNoDecodeBound(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BitmapFactory.Options getDecodeOptionsHasDecodeBound(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException(DefaultImageDecoder.parseEncodedImageInfo(encodedImage));
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Rect getRegionToDecode(EncodedImage encodedImage, ImageDecodeOptions imageDecodeOptions) {
        Rect regionToDecode = encodedImage.getRegionToDecode();
        if (regionToDecode != null) {
            return imageDecodeOptions.useSmartCrop ? regionToDecode : imageDecodeOptions.regionToDecode;
        }
        return imageDecodeOptions.regionToDecode;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class HeifFormatChecker implements ImageFormat.FormatChecker {
        private static final int HEIF_HEADER_LENGTH;
        private static final String HEIF_HEADER_PREFIX = "ftyp";
        private static final String[] HEIF_HEADER_SUFFIXES;

        static {
            String[] strArr = {"heic", "heix", "hevc", "hevx", "mif1", "msf1", "vvic"};
            HEIF_HEADER_SUFFIXES = strArr;
            HEIF_HEADER_LENGTH = ImageFormatCheckerUtils.asciiBytes(HEIF_HEADER_PREFIX + strArr[0]).length;
        }

        private static String getHeifHeader(byte[] bArr, int i) {
            if (i < HEIF_HEADER_LENGTH || bArr[3] < 8) {
                return null;
            }
            for (String str : HEIF_HEADER_SUFFIXES) {
                if (ImageFormatCheckerUtils.indexOfPattern(bArr, bArr.length, ImageFormatCheckerUtils.asciiBytes(HEIF_HEADER_PREFIX + str), HEIF_HEADER_LENGTH) > -1) {
                    return "vvic".equalsIgnoreCase(str) ? "vvic" : "heic";
                }
            }
            return null;
        }

        public int getHeaderSize() {
            return HEIF_HEADER_LENGTH;
        }

        public ImageFormat determineFormat(byte[] bArr, int i) {
            String heifHeader = getHeifHeader(bArr, i);
            if (TextUtils.isEmpty(heifHeader)) {
                return null;
            }
            if ("vvic".equalsIgnoreCase(heifHeader)) {
                return HeifDecoder.VVIC_FORMAT;
            }
            return HeifDecoder.HEIF_FORMAT;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class HeifFormatDecoder implements ImageDecoder {
        private boolean mDecodeHeicUseSystemApiFirst;
        private PlatformDecoder mPlatformDecoder;
        private PooledByteBufferFactory mPooledByteBufferFactory;

        public HeifFormatDecoder(PooledByteBufferFactory pooledByteBufferFactory) {
            this.mPooledByteBufferFactory = pooledByteBufferFactory;
        }

        public HeifFormatDecoder(boolean z) {
            this.mDecodeHeicUseSystemApiFirst = z;
        }

        public void setDecodeHeicUseSystemApiFirst(boolean z) {
            this.mDecodeHeicUseSystemApiFirst = z;
        }

        public boolean isDecodeHeicUseSystemApiFirst() {
            return this.mDecodeHeicUseSystemApiFirst;
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00f2 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0111  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0125 A[ADDED_TO_REGION] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public CloseableImage decode(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            boolean z;
            int i2;
            boolean z2;
            int i3;
            JSONObject result;
            Log.d(HeifDecoder.TAG, "decode: encodedImage getHdrType = " + encodedImage.getHdrType());
            if (encodedImage.getHdrType() > 0) {
                return decodeHdrHeic(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
            if (imageDecodeOptions != null && imageDecodeOptions.optSrWhenHeicDecode && imageDecodeOptions.heicSROptions != null && !encodedImage.hasAlpha()) {
                return decodeAndBmfSr(encodedImage, i, qualityInfo, imageDecodeOptions);
            }
            SimplayerImageStrategy strategy = SimplayerImageStrategy.getStrategy();
            if (strategy != null && encodedImage.getViewWidth() > 0 && encodedImage.getViewHeight() > 0 && encodedImage.getUri() != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("viewWidth", encodedImage.getViewWidth());
                    jSONObject.put("viewHeight", encodedImage.getViewHeight());
                    jSONObject.put("imageFormat", encodedImage.getImageFormat());
                    if (SimplayerImageStrategy.isOpenLog()) {
                        Log.d("SimplayerImageStrategy", "HeifDecoder.decode, params:" + jSONObject + ", uri:" + encodedImage.getUri());
                    }
                    result = strategy.getResult(2, encodedImage.getUri(), jSONObject);
                    if (SimplayerImageStrategy.isOpenLog()) {
                        Log.d("SimplayerImageStrategy", "HeifDecoder.decode, results:" + result);
                    }
                } catch (JSONException e) {
                    e = e;
                    i3 = 1;
                }
                if (result != null) {
                    i2 = result.optInt("priority", 1);
                    try {
                        z = result.optBoolean("useSystemApiFirst");
                    } catch (JSONException e2) {
                        i3 = i2;
                        e = e2;
                        e.printStackTrace();
                        i2 = i3;
                        z = false;
                        if (this.mDecodeHeicUseSystemApiFirst) {
                        }
                        if (i2 != 3) {
                        }
                        Log.d(HeifDecoder.TAG, "decode: -------useSystemApiFirst = " + z + ", isHeif = " + (encodedImage.getImageFormat() == HeifDecoder.HEIF_FORMAT));
                        if (encodedImage.getImageFormat() != HeifDecoder.HEIF_FORMAT) {
                        }
                        return decodeUseLibHeifFirst(encodedImage, i, qualityInfo, imageDecodeOptions);
                    }
                    z2 = !this.mDecodeHeicUseSystemApiFirst || ImagePipelineConfig.getDefaultImageRequestConfig().isDecodeHeicUseSystemApiFirst();
                    if (i2 != 3 && (i2 != 2 || z2)) {
                        z = z2;
                    }
                    Log.d(HeifDecoder.TAG, "decode: -------useSystemApiFirst = " + z + ", isHeif = " + (encodedImage.getImageFormat() == HeifDecoder.HEIF_FORMAT));
                    if (encodedImage.getImageFormat() != HeifDecoder.HEIF_FORMAT && z) {
                        return decodeUseSystemApiFirst(encodedImage, i, qualityInfo, imageDecodeOptions, FrescoCacheMonitorUtil.isUseImageDecoder());
                    }
                    return decodeUseLibHeifFirst(encodedImage, i, qualityInfo, imageDecodeOptions);
                }
            }
            z = false;
            i2 = 1;
            if (this.mDecodeHeicUseSystemApiFirst) {
            }
            if (i2 != 3) {
                z = z2;
            }
            Log.d(HeifDecoder.TAG, "decode: -------useSystemApiFirst = " + z + ", isHeif = " + (encodedImage.getImageFormat() == HeifDecoder.HEIF_FORMAT));
            if (encodedImage.getImageFormat() != HeifDecoder.HEIF_FORMAT) {
            }
            return decodeUseLibHeifFirst(encodedImage, i, qualityInfo, imageDecodeOptions);
        }

        private CloseableImage decodeHdrHeic(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            if (encodedImage == null) {
                return null;
            }
            HeifDecodeData heifDecodeData = new HeifDecodeData();
            heifDecodeData.setHasAlpha(encodedImage.hasAlpha());
            heifDecodeData.setWidth(encodedImage.getWidth());
            heifDecodeData.setHeight(encodedImage.getHeight());
            heifDecodeData.setHdrType(encodedImage.getHdrType());
            encodedImage.setHeicSysFirst(false);
            encodedImage.setHeicCustomDecoder(1);
            HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions);
            encodedImage.getNativeSize();
            if (HeifDecoder.mHeifDecodeLog) {
                Log.d(HeifDecoder.TAG, "decodeHdrHeic: isUseUltimateOptHeifBitmap = " + FrescoCacheMonitorUtil.isUseUltimateOptHeifBitmap());
            }
            InputStream inputStream = encodedImage.getInputStream();
            try {
                Bitmap decodeStream = HeifDecoder.sBitmapFactory.decodeStream(inputStream, (Rect) null, HeifDecoder.getDecodeOptionsNoDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig), heifDecodeData);
                encodedImage.setHeifDecError(heifDecodeData.getHeifDecError());
                if (HeifDecoder.mHeifDecodeLog) {
                    Log.d(HeifDecoder.TAG, "decodeHdrHeic: -----1111----- bitmap = " + decodeStream);
                }
                if (decodeStream == null && Build.VERSION.SDK_INT >= 27) {
                    inputStream.reset();
                    BitmapFactory.Options decodeOptionsHasDecodeBound = HeifDecoder.getDecodeOptionsHasDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig);
                    inputStream.reset();
                    decodeStream = BitmapFactory.decodeStream(inputStream, null, decodeOptionsHasDecodeBound);
                    encodedImage.setHeicCustomDecoder(0);
                    if (HeifDecoder.mHeifDecodeLog) {
                        Log.d(HeifDecoder.TAG, "decodeHdrHeic: system decode bitmap = " + decodeStream);
                    }
                }
                if (decodeStream != null) {
                    Bitmap trimBitmap = HeifDecoder.trimBitmap(decodeStream, encodedImage);
                    if (trimBitmap != decodeStream) {
                        decodeStream.recycle();
                    }
                    return new HeifBitmap(trimBitmap, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), 0, HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions), encodedImage.getRegionToDecode(), encodedImage.getSampleSize(), encodedImage.getImageFormat());
                }
            } finally {
                try {
                    return null;
                } finally {
                }
            }
            return null;
        }

        private CloseableImage decodeAndBmfSr(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            String str;
            Bitmap bitmap;
            HashMap hashMap;
            if (encodedImage == null) {
                return null;
            }
            HeifDecodeData heifDecodeData = new HeifDecodeData();
            heifDecodeData.setHasAlpha(encodedImage.hasAlpha());
            heifDecodeData.setWidth(encodedImage.getWidth());
            heifDecodeData.setHeight(encodedImage.getHeight());
            encodedImage.setHeicSysFirst(false);
            encodedImage.setHeicCustomDecoder(1);
            Rect regionToDecode = HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions);
            int nativeSize = encodedImage.getNativeSize();
            if (HeifDecoder.mHeifDecodeLog) {
                Log.d(HeifDecoder.TAG, "decodeAndBmfSr: optSrWhenHeicDecode = " + imageDecodeOptions.optSrWhenHeicDecode);
            }
            try {
                long nativePtr = encodedImage.getNativePtr();
                int thumbWidth = encodedImage.getThumbWidth();
                int thumbHeight = encodedImage.getThumbHeight();
                encodedImage.getSize();
                if (encodedImage.isDecodeThumb()) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    Bitmap decodeThumbByNativePtr = HeifDecoder.sBitmapFactory.decodeThumbByNativePtr(nativePtr, nativeSize, thumbWidth, thumbHeight, (Rect) null, (BitmapFactory.Options) null, (HeifDecodeData) null);
                    encodedImage.setThumbDecodeDuration(SystemClock.uptimeMillis() - uptimeMillis);
                    if (decodeThumbByNativePtr != null) {
                        FLog.d(HeifDecoder.TAG, "decode thumb successfully");
                        HeifBitmap heifBitmap = new HeifBitmap(decodeThumbByNativePtr, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), 0, HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions), encodedImage.getRegionToDecode(), encodedImage.getSampleSize(), encodedImage.getImageFormat());
                        heifBitmap.setThumbCache(true);
                        return heifBitmap;
                    }
                }
                if (regionToDecode != null) {
                    HeifBitmapFactory heifBitmapFactory = HeifDecoder.sBitmapFactory;
                    BitmapFactory.Options decodeOptionsNoDecodeBound = HeifDecoder.getDecodeOptionsNoDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig);
                    str = HeifDecoder.TAG;
                    try {
                        bitmap = heifBitmapFactory.decodeByNativePtr(nativePtr, nativeSize, regionToDecode, decodeOptionsNoDecodeBound, heifDecodeData);
                        encodedImage.setHeifDecError(heifDecodeData.getHeifDecError());
                    } catch (Throwable th) {
                        th = th;
                        FLog.d(str, "decodeAndBmfSr isUseUltimateOptHeifBitmap t = " + th);
                        return null;
                    }
                } else {
                    str = HeifDecoder.TAG;
                    bitmap = null;
                }
                if (bitmap == null) {
                    HashMap hashMap2 = new HashMap();
                    if (HeifDecoder.mHeifDecodeLog) {
                        Log.d(str, "decodeAndBmfSr: decodeByNativePtrCombineSr heicSROptions = " + imageDecodeOptions.heicSROptions);
                    }
                    bitmap = HeifDecoder.sBitmapFactory.decodeByNativePtrCombineSr(nativePtr, nativeSize, regionToDecode, HeifDecoder.getDecodeOptionsNoDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig), heifDecodeData, imageDecodeOptions.heicSROptions, hashMap2);
                    encodedImage.setHeifDecError(heifDecodeData.getHeifDecError());
                    hashMap = hashMap2;
                } else {
                    hashMap = null;
                }
                if (bitmap != null) {
                    Bitmap trimBitmap = HeifDecoder.trimBitmap(bitmap, encodedImage);
                    if (trimBitmap != bitmap) {
                        bitmap.recycle();
                    }
                    if (HeifDecoder.mHeifDecodeLog) {
                        Log.d(str, "decodeAndBmfSr:  dstBitmap = " + trimBitmap + ", extraMap = " + hashMap);
                    }
                    return new HeifBitmap(trimBitmap, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), 0, HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions), encodedImage.getRegionToDecode(), encodedImage.getSampleSize(), encodedImage.getImageFormat(), hashMap);
                }
            } catch (Throwable th2) {
                th = th2;
                str = HeifDecoder.TAG;
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:36:0x0252, code lost:
        
            if (r9 == null) goto L85;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:15:0x01c1 A[Catch: all -> 0x0304, TryCatch #4 {all -> 0x0304, blocks: (B:13:0x01bb, B:15:0x01c1, B:17:0x01d9, B:22:0x020a, B:27:0x025f, B:37:0x0244, B:46:0x0258, B:47:0x025b, B:49:0x0264, B:51:0x027f, B:53:0x0292, B:55:0x0298, B:58:0x02d6, B:60:0x02dc, B:61:0x02df, B:67:0x02a4, B:69:0x02aa, B:71:0x02c2, B:39:0x0239, B:35:0x024b), top: B:12:0x01bb, inners: #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x020a A[Catch: all -> 0x0304, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x0304, blocks: (B:13:0x01bb, B:15:0x01c1, B:17:0x01d9, B:22:0x020a, B:27:0x025f, B:37:0x0244, B:46:0x0258, B:47:0x025b, B:49:0x0264, B:51:0x027f, B:53:0x0292, B:55:0x0298, B:58:0x02d6, B:60:0x02dc, B:61:0x02df, B:67:0x02a4, B:69:0x02aa, B:71:0x02c2, B:39:0x0239, B:35:0x024b), top: B:12:0x01bb, inners: #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0264 A[Catch: all -> 0x0304, TryCatch #4 {all -> 0x0304, blocks: (B:13:0x01bb, B:15:0x01c1, B:17:0x01d9, B:22:0x020a, B:27:0x025f, B:37:0x0244, B:46:0x0258, B:47:0x025b, B:49:0x0264, B:51:0x027f, B:53:0x0292, B:55:0x0298, B:58:0x02d6, B:60:0x02dc, B:61:0x02df, B:67:0x02a4, B:69:0x02aa, B:71:0x02c2, B:39:0x0239, B:35:0x024b), top: B:12:0x01bb, inners: #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0298 A[Catch: all -> 0x0304, TryCatch #4 {all -> 0x0304, blocks: (B:13:0x01bb, B:15:0x01c1, B:17:0x01d9, B:22:0x020a, B:27:0x025f, B:37:0x0244, B:46:0x0258, B:47:0x025b, B:49:0x0264, B:51:0x027f, B:53:0x0292, B:55:0x0298, B:58:0x02d6, B:60:0x02dc, B:61:0x02df, B:67:0x02a4, B:69:0x02aa, B:71:0x02c2, B:39:0x0239, B:35:0x024b), top: B:12:0x01bb, inners: #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:58:0x02d6 A[Catch: all -> 0x0304, TryCatch #4 {all -> 0x0304, blocks: (B:13:0x01bb, B:15:0x01c1, B:17:0x01d9, B:22:0x020a, B:27:0x025f, B:37:0x0244, B:46:0x0258, B:47:0x025b, B:49:0x0264, B:51:0x027f, B:53:0x0292, B:55:0x0298, B:58:0x02d6, B:60:0x02dc, B:61:0x02df, B:67:0x02a4, B:69:0x02aa, B:71:0x02c2, B:39:0x0239, B:35:0x024b), top: B:12:0x01bb, inners: #5 }] */
        /* JADX WARN: Removed duplicated region for block: B:71:0x02c2 A[Catch: all -> 0x0304, TryCatch #4 {all -> 0x0304, blocks: (B:13:0x01bb, B:15:0x01c1, B:17:0x01d9, B:22:0x020a, B:27:0x025f, B:37:0x0244, B:46:0x0258, B:47:0x025b, B:49:0x0264, B:51:0x027f, B:53:0x0292, B:55:0x0298, B:58:0x02d6, B:60:0x02dc, B:61:0x02df, B:67:0x02a4, B:69:0x02aa, B:71:0x02c2, B:39:0x0239, B:35:0x024b), top: B:12:0x01bb, inners: #5 }] */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2 */
        /* JADX WARN: Type inference failed for: r3v23 */
        /* JADX WARN: Type inference failed for: r3v24 */
        /* JADX WARN: Type inference failed for: r3v3 */
        /* JADX WARN: Type inference failed for: r3v4 */
        /* JADX WARN: Type inference failed for: r3v5 */
        /* JADX WARN: Type inference failed for: r3v6 */
        /* JADX WARN: Type inference failed for: r3v7, types: [int, boolean] */
        /* JADX WARN: Type inference failed for: r9v10, types: [android.graphics.BitmapRegionDecoder] */
        /* JADX WARN: Type inference failed for: r9v22 */
        /* JADX WARN: Type inference failed for: r9v23 */
        /* JADX WARN: Type inference failed for: r9v3, types: [long] */
        /* JADX WARN: Type inference failed for: r9v8, types: [int] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private CloseableImage decodeUseLibHeifFirst(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            Rect rect;
            int i2;
            int i3;
            Bitmap bitmap;
            String str7;
            Bitmap bitmap2;
            String str8;
            InputStream inputStream;
            Rect rect2;
            BitmapRegionDecoder bitmapRegionDecoder;
            String str9;
            BitmapRegionDecoder newInstance;
            if (encodedImage == null) {
                return null;
            }
            HeifDecodeData heifDecodeData = new HeifDecodeData();
            heifDecodeData.setHasAlpha(encodedImage.hasAlpha());
            heifDecodeData.setWidth(encodedImage.getWidth());
            heifDecodeData.setHeight(encodedImage.getHeight());
            encodedImage.setHeicSysFirst(false);
            encodedImage.setHeicCustomDecoder(1);
            Rect regionToDecode = HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions);
            int nativeSize = encodedImage.getNativeSize();
            String str10 = "decodeUseLibHeifFirst: isUseUltimateOptHeifBitmap = ";
            if (HeifDecoder.mHeifDecodeLog) {
                Log.d(HeifDecoder.TAG, "decodeUseLibHeifFirst: isUseUltimateOptHeifBitmap = " + FrescoCacheMonitorUtil.isUseUltimateOptHeifBitmap());
            }
            if (FrescoCacheMonitorUtil.isUseUltimateOptHeifBitmap()) {
                try {
                    long nativePtr = encodedImage.getNativePtr();
                    int thumbWidth = encodedImage.getThumbWidth();
                    int thumbHeight = encodedImage.getThumbHeight();
                    encodedImage.getSize();
                    if (encodedImage.isDecodeThumb()) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        Bitmap decodeThumbByNativePtr = HeifDecoder.sBitmapFactory.decodeThumbByNativePtr(nativePtr, nativeSize, thumbWidth, thumbHeight, (Rect) null, (BitmapFactory.Options) null, (HeifDecodeData) null);
                        encodedImage.setThumbDecodeDuration(SystemClock.uptimeMillis() - uptimeMillis);
                        if (decodeThumbByNativePtr != null) {
                            FLog.d(HeifDecoder.TAG, "decode thumb successfully");
                            HeifBitmap heifBitmap = new HeifBitmap(decodeThumbByNativePtr, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), 0, HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions), encodedImage.getRegionToDecode(), encodedImage.getSampleSize(), encodedImage.getImageFormat());
                            heifBitmap.setThumbCache(true);
                            return heifBitmap;
                        }
                    }
                    if (regionToDecode != null) {
                        HeifBitmapFactory heifBitmapFactory = HeifDecoder.sBitmapFactory;
                        BitmapFactory.Options decodeOptionsNoDecodeBound = HeifDecoder.getDecodeOptionsNoDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig);
                        str2 = "decodeUseLibHeifFirst: system decode bitmap = ";
                        str4 = "HeifFormatDecoder.decode exception:";
                        str7 = "decodeUseLibHeifFirst: isUseUltimateOptHeifBitmap = ";
                        str5 = "decode thumb successfully";
                        str3 = "decodeUseLibHeifFirst: isUseUltimateOptHeifBitmap after bitmap = ";
                        str6 = HeifDecoder.TAG;
                        rect = regionToDecode;
                        str = "Could not decode region %s, decoding full bitmap instead.";
                        i2 = 1;
                        i3 = 0;
                        try {
                            Bitmap decodeByNativePtr = heifBitmapFactory.decodeByNativePtr(nativePtr, nativeSize, regionToDecode, decodeOptionsNoDecodeBound, heifDecodeData);
                            try {
                                ?? heifDecError = heifDecodeData.getHeifDecError();
                                encodedImage.setHeifDecError((int) heifDecError);
                                bitmap2 = decodeByNativePtr;
                                i2 = i2;
                                str8 = heifDecError;
                            } catch (Throwable th) {
                                th = th;
                                bitmap = decodeByNativePtr;
                                str10 = "decodeUseLibHeifFirst isUseUltimateOptHeifBitmap t = ";
                                FLog.d(str6, "decodeUseLibHeifFirst isUseUltimateOptHeifBitmap t = " + th);
                                inputStream = encodedImage.getInputStream();
                                ?? r9 = str10;
                                if (encodedImage.isDecodeThumb()) {
                                }
                                rect2 = rect;
                                if (rect2 != null) {
                                }
                                if (bitmap == null) {
                                }
                                if (FrescoCacheMonitorUtil.isRemoveVvicUseSystemApi()) {
                                }
                                inputStream.reset();
                                BitmapFactory.Options decodeOptionsHasDecodeBound = HeifDecoder.getDecodeOptionsHasDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig);
                                inputStream.reset();
                                bitmap = BitmapFactory.decodeStream(inputStream, null, decodeOptionsHasDecodeBound);
                                encodedImage.setHeicCustomDecoder(i3);
                                if (HeifDecoder.mHeifDecodeLog) {
                                }
                                if (bitmap != null) {
                                }
                                Closeables.closeQuietly(inputStream);
                                return null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            bitmap = null;
                            str10 = "decodeUseLibHeifFirst isUseUltimateOptHeifBitmap t = ";
                            FLog.d(str6, "decodeUseLibHeifFirst isUseUltimateOptHeifBitmap t = " + th);
                            inputStream = encodedImage.getInputStream();
                            ?? r92 = str10;
                            if (encodedImage.isDecodeThumb()) {
                            }
                            rect2 = rect;
                            if (rect2 != null) {
                            }
                            if (bitmap == null) {
                            }
                            if (FrescoCacheMonitorUtil.isRemoveVvicUseSystemApi()) {
                            }
                            inputStream.reset();
                            BitmapFactory.Options decodeOptionsHasDecodeBound2 = HeifDecoder.getDecodeOptionsHasDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig);
                            inputStream.reset();
                            bitmap = BitmapFactory.decodeStream(inputStream, null, decodeOptionsHasDecodeBound2);
                            encodedImage.setHeicCustomDecoder(i3);
                            if (HeifDecoder.mHeifDecodeLog) {
                            }
                            if (bitmap != null) {
                            }
                            Closeables.closeQuietly(inputStream);
                            return null;
                        }
                    } else {
                        str = "Could not decode region %s, decoding full bitmap instead.";
                        str2 = "decodeUseLibHeifFirst: system decode bitmap = ";
                        str3 = "decodeUseLibHeifFirst: isUseUltimateOptHeifBitmap after bitmap = ";
                        str4 = "HeifFormatDecoder.decode exception:";
                        str7 = "decodeUseLibHeifFirst: isUseUltimateOptHeifBitmap = ";
                        str5 = "decode thumb successfully";
                        str6 = HeifDecoder.TAG;
                        rect = regionToDecode;
                        i2 = 1;
                        i3 = 0;
                        bitmap2 = null;
                        str8 = str10;
                    }
                    if (bitmap2 == null) {
                        try {
                            if (HeifDecoder.mHeifDecodeLog) {
                                Log.d(str6, str7 + FrescoCacheMonitorUtil.isUseUltimateOptHeifBitmap());
                            }
                            ?? r93 = nativePtr;
                            bitmap = HeifDecoder.sBitmapFactory.decodeByNativePtr((long) r93, nativeSize, rect, HeifDecoder.getDecodeOptionsNoDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig), heifDecodeData);
                            try {
                                encodedImage.setHeifDecError(heifDecodeData.getHeifDecError());
                                str10 = r93;
                            } catch (Throwable th3) {
                                th = th3;
                                str10 = "decodeUseLibHeifFirst isUseUltimateOptHeifBitmap t = ";
                                FLog.d(str6, "decodeUseLibHeifFirst isUseUltimateOptHeifBitmap t = " + th);
                                inputStream = encodedImage.getInputStream();
                                ?? r922 = str10;
                                if (encodedImage.isDecodeThumb()) {
                                }
                                rect2 = rect;
                                if (rect2 != null) {
                                }
                                if (bitmap == null) {
                                }
                                if (FrescoCacheMonitorUtil.isRemoveVvicUseSystemApi()) {
                                }
                                inputStream.reset();
                                BitmapFactory.Options decodeOptionsHasDecodeBound22 = HeifDecoder.getDecodeOptionsHasDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig);
                                inputStream.reset();
                                bitmap = BitmapFactory.decodeStream(inputStream, null, decodeOptionsHasDecodeBound22);
                                encodedImage.setHeicCustomDecoder(i3);
                                if (HeifDecoder.mHeifDecodeLog) {
                                }
                                if (bitmap != null) {
                                }
                                Closeables.closeQuietly(inputStream);
                                return null;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            bitmap = bitmap2;
                            str10 = "decodeUseLibHeifFirst isUseUltimateOptHeifBitmap t = ";
                            FLog.d(str6, "decodeUseLibHeifFirst isUseUltimateOptHeifBitmap t = " + th);
                            inputStream = encodedImage.getInputStream();
                            ?? r9222 = str10;
                            if (encodedImage.isDecodeThumb()) {
                            }
                            rect2 = rect;
                            if (rect2 != null) {
                            }
                            if (bitmap == null) {
                            }
                            if (FrescoCacheMonitorUtil.isRemoveVvicUseSystemApi()) {
                            }
                            inputStream.reset();
                            BitmapFactory.Options decodeOptionsHasDecodeBound222 = HeifDecoder.getDecodeOptionsHasDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig);
                            inputStream.reset();
                            bitmap = BitmapFactory.decodeStream(inputStream, null, decodeOptionsHasDecodeBound222);
                            encodedImage.setHeicCustomDecoder(i3);
                            if (HeifDecoder.mHeifDecodeLog) {
                            }
                            if (bitmap != null) {
                            }
                            Closeables.closeQuietly(inputStream);
                            return null;
                        }
                    } else {
                        bitmap = bitmap2;
                        str10 = str8;
                    }
                    if (bitmap != null) {
                        Bitmap trimBitmap = HeifDecoder.trimBitmap(bitmap, encodedImage);
                        if (trimBitmap != bitmap) {
                            bitmap.recycle();
                        }
                        if (HeifDecoder.mHeifDecodeLog) {
                            Log.d(str6, "decodeUseLibHeifFirst: isUseUltimateOptHeifBitmap dstBitmap = " + trimBitmap);
                        }
                        return new HeifBitmap(trimBitmap, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), 0, HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions), encodedImage.getRegionToDecode(), encodedImage.getSampleSize(), encodedImage.getImageFormat());
                    }
                } catch (Throwable th5) {
                    th = th5;
                    str = "Could not decode region %s, decoding full bitmap instead.";
                    str2 = "decodeUseLibHeifFirst: system decode bitmap = ";
                    str3 = "decodeUseLibHeifFirst: isUseUltimateOptHeifBitmap after bitmap = ";
                    str4 = "HeifFormatDecoder.decode exception:";
                    str5 = "decode thumb successfully";
                    str6 = HeifDecoder.TAG;
                    rect = regionToDecode;
                    i2 = 1;
                    i3 = 0;
                }
            } else {
                str = "Could not decode region %s, decoding full bitmap instead.";
                str2 = "decodeUseLibHeifFirst: system decode bitmap = ";
                str3 = "decodeUseLibHeifFirst: isUseUltimateOptHeifBitmap after bitmap = ";
                str4 = "HeifFormatDecoder.decode exception:";
                str5 = "decode thumb successfully";
                str6 = HeifDecoder.TAG;
                rect = regionToDecode;
                i2 = 1;
                i3 = 0;
                bitmap = null;
            }
            inputStream = encodedImage.getInputStream();
            try {
                ?? r92222 = str10;
                if (encodedImage.isDecodeThumb()) {
                    long uptimeMillis2 = SystemClock.uptimeMillis();
                    Bitmap decodeThumb = HeifDecoder.sBitmapFactory.decodeThumb(inputStream, (Rect) null, (BitmapFactory.Options) null);
                    encodedImage.setThumbDecodeDuration(SystemClock.uptimeMillis() - uptimeMillis2);
                    inputStream.reset();
                    r92222 = uptimeMillis2;
                    if (decodeThumb != null) {
                        FLog.d(str6, str5);
                        HeifBitmap heifBitmap2 = new HeifBitmap(decodeThumb, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), 0, HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions), encodedImage.getRegionToDecode(), encodedImage.getSampleSize(), encodedImage.getImageFormat());
                        heifBitmap2.setThumbCache(i2);
                        return heifBitmap2;
                    }
                }
                rect2 = rect;
                if (rect2 != null) {
                    bitmap = HeifDecoder.sBitmapFactory.decodeStream(inputStream, rect2, HeifDecoder.getDecodeOptionsNoDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig), heifDecodeData);
                    encodedImage.setHeifDecError(heifDecodeData.getHeifDecError());
                    try {
                        if (bitmap == null) {
                            try {
                                inputStream.reset();
                                newInstance = BitmapRegionDecoder.newInstance(inputStream, (boolean) i2);
                                try {
                                    bitmap = newInstance.decodeRegion(rect2, HeifDecoder.getDecodeOptionsForStream(encodedImage, imageDecodeOptions.bitmapConfig));
                                } catch (IOException unused) {
                                    bitmapRegionDecoder = newInstance;
                                    str9 = str;
                                    Object[] objArr = new Object[i2];
                                    objArr[i3] = rect2;
                                    FLog.e(str6, str9, objArr);
                                } catch (Throwable unused2) {
                                    bitmapRegionDecoder = newInstance;
                                    Object[] objArr2 = new Object[i2];
                                    objArr2[i3] = rect2;
                                    FLog.e(str6, str, objArr2);
                                }
                            } catch (IOException unused3) {
                                str9 = str;
                                bitmapRegionDecoder = null;
                            } catch (Throwable unused4) {
                                bitmapRegionDecoder = null;
                            }
                        } else {
                            newInstance = null;
                        }
                        if (newInstance != null) {
                            newInstance.recycle();
                        }
                    } finally {
                        if (r92222 != 0) {
                            r92222.recycle();
                        }
                    }
                }
                if (bitmap == null) {
                    inputStream.reset();
                    Bitmap decodeStream = HeifDecoder.sBitmapFactory.decodeStream(inputStream, (Rect) null, HeifDecoder.getDecodeOptionsNoDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig), heifDecodeData);
                    encodedImage.setHeifDecError(heifDecodeData.getHeifDecError());
                    if (HeifDecoder.mHeifDecodeLog) {
                        Log.d(str6, str3 + decodeStream);
                    }
                    bitmap = decodeStream;
                }
                if ((FrescoCacheMonitorUtil.isRemoveVvicUseSystemApi() || DefaultImageFormats.isHeifFormat(encodedImage.getImageFormat())) && bitmap == null && Build.VERSION.SDK_INT >= 27) {
                    inputStream.reset();
                    BitmapFactory.Options decodeOptionsHasDecodeBound2222 = HeifDecoder.getDecodeOptionsHasDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig);
                    inputStream.reset();
                    bitmap = BitmapFactory.decodeStream(inputStream, null, decodeOptionsHasDecodeBound2222);
                    encodedImage.setHeicCustomDecoder(i3);
                    if (HeifDecoder.mHeifDecodeLog) {
                        Log.d(str6, str2 + bitmap);
                    }
                }
                if (bitmap != null) {
                    Bitmap trimBitmap2 = HeifDecoder.trimBitmap(bitmap, encodedImage);
                    if (trimBitmap2 != bitmap) {
                        bitmap.recycle();
                    }
                    return new HeifBitmap(trimBitmap2, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), 0, HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions), encodedImage.getRegionToDecode(), encodedImage.getSampleSize(), encodedImage.getImageFormat());
                }
            } finally {
                try {
                    Closeables.closeQuietly(inputStream);
                    return null;
                } finally {
                }
            }
            Closeables.closeQuietly(inputStream);
            return null;
        }

        public Bitmap decodeByImageDecoder(InputStream inputStream, int i, final Rect rect, final BitmapFactory.Options options) {
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
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
                    final int i2 = options != null ? options.inSampleSize : 1;
                    if (Build.VERSION.SDK_INT >= 28) {
                        Log.d(HeifDecoder.TAG, "decodeByImageDecoder: byteBuffer.position() = " + allocateDirect.position());
                        if (allocateDirect.position() != 0) {
                            allocateDirect.rewind();
                        }
                        Bitmap decodeBitmap = android.graphics.ImageDecoder.decodeBitmap(android.graphics.ImageDecoder.createSource(allocateDirect), new ImageDecoder.OnHeaderDecodedListener() { // from class: com.bytedance.fresco.heif.HeifDecoder.HeifFormatDecoder.1
                            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                            public void onHeaderDecoded(android.graphics.ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                                if (HeifDecoder.mHeifDecodeLog) {
                                    Log.d(HeifDecoder.TAG, "decodeByImageDecoder: region = " + rect + ", inSampleSize = " + i2 + ", opts = " + options + ", opts.inPreferredConfig = " + options.inPreferredConfig);
                                }
                                Rect rect2 = rect;
                                if (rect2 != null) {
                                    imageDecoder.setCrop(rect2);
                                }
                                imageDecoder.setMutableRequired(false);
                                imageDecoder.setTargetSampleSize(i2);
                                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                                BitmapFactory.Options options2 = options;
                                if (options2 != null && options2.inPreferredConfig == Bitmap.Config.RGB_565) {
                                    Log.d(HeifDecoder.TAG, "decodeByImageDecoder: ----------ALLOCATOR_SHARED_MEMORY---------- = ");
                                    imageDecoder.setUnpremultipliedRequired(false);
                                    imageDecoder.setAllocator(2);
                                    return;
                                }
                                imageDecoder.setAllocator(1);
                            }
                        });
                        Log.d(HeifDecoder.TAG, "decodeByImageDecoder: getConfig = " + decodeBitmap.getConfig() + ", getWidth = " + decodeBitmap.getWidth() + ", getHeight = " + decodeBitmap.getHeight() + ", getColorSpace = " + decodeBitmap.getColorSpace() + ", getByteCount = " + decodeBitmap.getByteCount());
                        return decodeBitmap;
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

        /* JADX WARN: Code restructure failed: missing block: B:77:0x00bb, code lost:
        
            if (r14 == null) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x00be, code lost:
        
            r0 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:81:0x00ae, code lost:
        
            r14.recycle();
            r14 = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:84:0x00ac, code lost:
        
            if (r14 == null) goto L34;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0138 A[Catch: all -> 0x0166, TryCatch #1 {all -> 0x0166, blocks: (B:33:0x0138, B:35:0x0155, B:37:0x016a, B:39:0x0170, B:40:0x0173, B:60:0x012c), top: B:59:0x012c }] */
        /* JADX WARN: Removed duplicated region for block: B:37:0x016a A[Catch: all -> 0x0166, TryCatch #1 {all -> 0x0166, blocks: (B:33:0x0138, B:35:0x0155, B:37:0x016a, B:39:0x0170, B:40:0x0173, B:60:0x012c), top: B:59:0x012c }] */
        /* JADX WARN: Type inference failed for: r14v15, types: [long] */
        /* JADX WARN: Type inference failed for: r14v16 */
        /* JADX WARN: Type inference failed for: r14v17 */
        /* JADX WARN: Type inference failed for: r14v18 */
        /* JADX WARN: Type inference failed for: r14v7 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private CloseableImage decodeUseSystemApiFirst(EncodedImage encodedImage, int i, QualityInfo qualityInfo, ImageDecodeOptions imageDecodeOptions, boolean z) {
            BitmapRegionDecoder bitmapRegionDecoder;
            BitmapRegionDecoder bitmapRegionDecoder2;
            BitmapRegionDecoder bitmapRegionDecoder3;
            Bitmap bitmap;
            Bitmap bitmap2;
            if (encodedImage == null) {
                return null;
            }
            HeifDecodeData heifDecodeData = new HeifDecodeData();
            heifDecodeData.setHasAlpha(encodedImage.hasAlpha());
            heifDecodeData.setWidth(encodedImage.getWidth());
            heifDecodeData.setHeight(encodedImage.getHeight());
            encodedImage.setHeicSysFirst(true);
            encodedImage.setHeicCustomDecoder(0);
            InputStream inputStream = encodedImage.getInputStream();
            Rect regionToDecode = HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions);
            try {
                if (encodedImage.isDecodeThumb()) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    Bitmap decodeThumb = HeifDecoder.sBitmapFactory.decodeThumb(inputStream, (Rect) null, (BitmapFactory.Options) null);
                    bitmapRegionDecoder = SystemClock.uptimeMillis() - uptimeMillis;
                    encodedImage.setThumbDecodeDuration((long) bitmapRegionDecoder);
                    inputStream.reset();
                    if (decodeThumb != null) {
                        FLog.d(HeifDecoder.TAG, "decode thumb successfully");
                        HeifBitmap heifBitmap = new HeifBitmap(decodeThumb, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), 0, HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions), encodedImage.getRegionToDecode(), encodedImage.getSampleSize(), encodedImage.getImageFormat());
                        heifBitmap.setThumbCache(true);
                        return heifBitmap;
                    }
                }
                try {
                    if (regionToDecode != null) {
                        try {
                            bitmapRegionDecoder2 = BitmapRegionDecoder.newInstance(inputStream, true);
                        } catch (IOException e) {
                            e = e;
                            bitmapRegionDecoder2 = null;
                        } catch (Throwable th) {
                            th = th;
                            bitmapRegionDecoder2 = null;
                        }
                        try {
                            bitmap = bitmapRegionDecoder2.decodeRegion(regionToDecode, HeifDecoder.getDecodeOptionsForStream(encodedImage, imageDecodeOptions.bitmapConfig));
                        } catch (IOException e2) {
                            e = e2;
                            FLog.e(HeifDecoder.TAG, e, "Could not decode region %s use system api.", new Object[]{regionToDecode});
                            bitmapRegionDecoder = bitmapRegionDecoder2;
                            bitmapRegionDecoder3 = bitmapRegionDecoder2;
                        } catch (Throwable th2) {
                            th = th2;
                            FLog.e(HeifDecoder.TAG, th, "Could not decode region %s use system api.", new Object[]{regionToDecode});
                            bitmapRegionDecoder = bitmapRegionDecoder2;
                            bitmapRegionDecoder3 = bitmapRegionDecoder2;
                        }
                        if (bitmap == null) {
                            inputStream.reset();
                            bitmap = HeifDecoder.sBitmapFactory.decodeStream(inputStream, regionToDecode, HeifDecoder.getDecodeOptionsNoDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig), heifDecodeData);
                            encodedImage.setHeicCustomDecoder(1);
                            encodedImage.setHeifDecError(heifDecodeData.getHeifDecError());
                        }
                        bitmap2 = bitmap;
                    } else {
                        bitmap2 = null;
                    }
                    if (bitmap2 == null && Build.VERSION.SDK_INT >= 28) {
                        try {
                            inputStream.reset();
                            BitmapFactory.Options decodeOptionsHasDecodeBound = HeifDecoder.getDecodeOptionsHasDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig);
                            inputStream.reset();
                            try {
                                if (z) {
                                    bitmap2 = decodeByImageDecoder(inputStream, inputStream.available(), null, decodeOptionsHasDecodeBound);
                                    encodedImage.setHeicCustomDecoder(-1);
                                } else {
                                    bitmap2 = BitmapFactory.decodeStream(inputStream, null, decodeOptionsHasDecodeBound);
                                    encodedImage.setHeicCustomDecoder(0);
                                }
                                if (HeifDecoder.mHeifDecodeLog) {
                                    Log.d(HeifDecoder.TAG, "decodeUseSystemApiFirst: bitmap = " + bitmap2);
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    FLog.e(HeifDecoder.TAG, th, "Could not decode full image use system api.", new Object[0]);
                                    if (bitmap2 == null) {
                                    }
                                    if (bitmap2 != null) {
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    try {
                                        if (HeifDecoder.DEBUG) {
                                            FLog.d(HeifDecoder.TAG, "HeifFormatDecoder.decode exception:" + Log.getStackTraceString(th));
                                        }
                                        return null;
                                    } finally {
                                        Closeables.closeQuietly(inputStream);
                                    }
                                }
                                return null;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                        }
                    }
                    if (bitmap2 == null) {
                        inputStream.reset();
                        bitmap2 = HeifDecoder.sBitmapFactory.decodeStream(inputStream, (Rect) null, HeifDecoder.getDecodeOptionsNoDecodeBound(encodedImage, imageDecodeOptions.bitmapConfig), heifDecodeData);
                        encodedImage.setHeicCustomDecoder(1);
                        encodedImage.setHeifDecError(heifDecodeData.getHeifDecError());
                        if (HeifDecoder.mHeifDecodeLog) {
                            Log.d(HeifDecoder.TAG, "decodeUseSystemApiFirst: system decode fail, soft decode bitmap = " + bitmap2);
                        }
                    }
                    if (bitmap2 != null) {
                        Bitmap trimBitmap = HeifDecoder.trimBitmap(bitmap2, encodedImage);
                        if (trimBitmap != bitmap2) {
                            bitmap2.recycle();
                        }
                        return new HeifBitmap(trimBitmap, SimpleBitmapReleaser.getInstance(), ImmutableQualityInfo.FULL_QUALITY, encodedImage.getRotationAngle(), 0, HeifDecoder.getRegionToDecode(encodedImage, imageDecodeOptions), encodedImage.getRegionToDecode(), encodedImage.getSampleSize(), encodedImage.getImageFormat());
                    }
                } finally {
                    if (bitmapRegionDecoder != 0) {
                        bitmapRegionDecoder.recycle();
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bitmap trimBitmap(Bitmap bitmap, EncodedImage encodedImage) {
        int width = encodedImage.getWidth();
        int height = encodedImage.getHeight();
        int byteCount = bitmap.getByteCount();
        if (byteCount <= 104857600) {
            return bitmap;
        }
        FLog.w(TAG, "Too large(" + byteCount + ")bytes bitmap.  dimension: " + (width + "x" + height) + " sampleSize: " + encodedImage.getSampleSize() + " Config: " + bitmap.getConfig());
        Pair<Integer, Integer> calcDstWidthHeight = calcDstWidthHeight(width, height, byteCount);
        return Bitmap.createScaledBitmap(bitmap, ((Integer) calcDstWidthHeight.first).intValue(), ((Integer) calcDstWidthHeight.second).intValue(), false);
    }

    private static Pair<Integer, Integer> calcDstWidthHeight(int i, int i2, int i3) {
        float f = i * i2 * (4194304.0f / i3);
        float f2 = i / i2;
        return new Pair<>(Integer.valueOf((int) Math.sqrt(f * f2)), Integer.valueOf((int) Math.sqrt(f / f2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BitmapFactory.Options getDecodeOptionsForStream(EncodedImage encodedImage, Bitmap.Config config) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = encodedImage.getSampleSize();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(encodedImage.getInputStream(), null, options);
        if (options.outWidth == -1 || options.outHeight == -1) {
            throw new IllegalArgumentException(DefaultImageDecoder.parseEncodedImageInfo(encodedImage));
        }
        options.inJustDecodeBounds = false;
        options.inDither = true;
        options.inPreferredConfig = config;
        options.inMutable = true;
        return options;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class HeifBitmap extends CloseableStaticBitmap {
        public HeifBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i, int i2, Rect rect, Rect rect2, int i3, ImageFormat imageFormat) {
            super(bitmap, resourceReleaser, qualityInfo, i, i2, rect, rect2, i3, imageFormat);
        }

        public HeifBitmap(Bitmap bitmap, ResourceReleaser<Bitmap> resourceReleaser, QualityInfo qualityInfo, int i, int i2, Rect rect, Rect rect2, int i3, ImageFormat imageFormat, Map<String, String> map) {
            super(bitmap, resourceReleaser, qualityInfo, i, i2, rect, rect2, i3, imageFormat, map);
        }

        public HeifBitmap(CloseableReference<Bitmap> closeableReference, QualityInfo qualityInfo, int i) {
            super(closeableReference, qualityInfo, i);
        }
    }
}
