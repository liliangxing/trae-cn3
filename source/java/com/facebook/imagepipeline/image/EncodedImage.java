package com.facebook.imagepipeline.image;

import android.graphics.ColorSpace;
import android.graphics.Rect;
import android.util.Pair;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferInputStream;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.AlphaChecker;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.common.BytesRange;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imageutils.AvifFormatUtil;
import com.facebook.imageutils.BitmapUtil;
import com.facebook.imageutils.DngExifUtil;
import com.facebook.imageutils.HeifExifUtil;
import com.facebook.imageutils.HeifFormatUtil;
import com.facebook.imageutils.ImageMetaData;
import com.facebook.imageutils.JfifUtil;
import com.facebook.imageutils.WebpUtil;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class EncodedImage implements Closeable {
    public static final int DEFAULT_SAMPLE_SIZE = 1;
    public static final String REGION_TO_DECODE = "regionToDecode";
    public static final int UNKNOWN_HEIGHT = -1;
    public static final int UNKNOWN_ROTATION_ANGLE = -1;
    public static final int UNKNOWN_STREAM_SIZE = -1;
    public static final int UNKNOWN_WIDTH = -1;
    public static final String URL = "url";
    public static final String VIEW_HEIGHT = "viewHeight";
    public static final String VIEW_WIDTH = "viewWidth";
    private static boolean mOptHeifParse;
    private static boolean mUseUltimateOptHeifBitmap;

    @Nullable
    private int heicCustomDecoder;

    @Nullable
    private boolean heicSysFirst;
    private boolean isDecodeThumb;
    private boolean isHitBitmapMemoryCache;
    private boolean isHitDiskCache;
    private boolean isHitEncodeMemoryCache;
    private boolean isRequestNetwork;

    @Nullable
    private BytesRange mBytesRange;

    @Nullable
    private ColorSpace mColorSpace;
    private int mDecodeStatus;
    private int mExifOrientation;

    @Nullable
    private Map<String, String> mExtraInfo;
    private boolean mHasAlpha;
    private int mHdrType;
    private int mHeifDecError;
    private int mHeight;
    private ImageFormat mImageFormat;

    @Nullable
    private final Supplier<FileInputStream> mInputStreamSupplier;
    private boolean mIs10Bit;

    @Nullable
    private final CloseableReference<PooledByteBuffer> mPooledByteBufferRef;

    @Nullable
    private Rect mRegionToDecode;
    private int mRotationAngle;
    private int mSampleSize;
    private int mStreamSize;
    private int mWidth;

    @Nullable
    private long thumbDecodeDuration;
    private int thumbHeight;
    private int thumbWidth;

    @Nullable
    private String uri;
    private int viewHeight;
    private int viewWidth;

    public static void setUseUltimateOptHeifBitmap(boolean z) {
        mUseUltimateOptHeifBitmap = z;
    }

    public static void setOptHeifParse(boolean z) {
        mOptHeifParse = z;
    }

    public static boolean isOptHeifParse() {
        return mOptHeifParse;
    }

    public EncodedImage(CloseableReference<PooledByteBuffer> closeableReference) {
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        this.mHasAlpha = true;
        this.mIs10Bit = false;
        this.mHdrType = -1;
        this.mDecodeStatus = 0;
        this.isRequestNetwork = false;
        this.isHitDiskCache = false;
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = false;
        this.thumbDecodeDuration = -1L;
        Preconditions.checkArgument(CloseableReference.isValid(closeableReference));
        PooledByteBuffer pooledByteBuffer = closeableReference.get();
        if (pooledByteBuffer instanceof EncodeImagePooledByteBuffer) {
            this.mPooledByteBufferRef = closeableReference.m2638clone();
            EncodeImagePooledByteBuffer encodeImagePooledByteBuffer = (EncodeImagePooledByteBuffer) pooledByteBuffer;
            this.mExtraInfo = encodeImagePooledByteBuffer.getExtraInfo();
            if (encodeImagePooledByteBuffer.isHitEncodeMemoryCache) {
                hitEncodeMemoryCache();
                encodeImagePooledByteBuffer.setHitEncodeMemoryCache(false);
            } else if (encodeImagePooledByteBuffer.isHitBitmapMemoryCache) {
                hitBitmapMemoryCache();
                encodeImagePooledByteBuffer.setHitBitmapMemoryCache(false);
            }
        } else {
            this.mPooledByteBufferRef = CloseableReference.m496of(new EncodeImagePooledByteBuffer(closeableReference.m2638clone()));
        }
        this.mInputStreamSupplier = null;
    }

    public EncodedImage(Supplier<FileInputStream> supplier) {
        this.mImageFormat = ImageFormat.UNKNOWN;
        this.mRotationAngle = -1;
        this.mExifOrientation = 0;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSampleSize = 1;
        this.mStreamSize = -1;
        this.mHasAlpha = true;
        this.mIs10Bit = false;
        this.mHdrType = -1;
        this.mDecodeStatus = 0;
        this.isRequestNetwork = false;
        this.isHitDiskCache = false;
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = false;
        this.thumbDecodeDuration = -1L;
        Preconditions.checkNotNull(supplier);
        this.mPooledByteBufferRef = null;
        this.mInputStreamSupplier = supplier;
    }

    public EncodedImage(Supplier<FileInputStream> supplier, int i) {
        this(supplier);
        this.mStreamSize = i;
    }

    public static EncodedImage cloneOrNull(EncodedImage encodedImage) {
        if (encodedImage != null) {
            return encodedImage.cloneOrNull();
        }
        return null;
    }

    public EncodedImage cloneOrNull() {
        EncodedImage encodedImage;
        Supplier<FileInputStream> supplier = this.mInputStreamSupplier;
        if (supplier != null) {
            encodedImage = new EncodedImage(supplier, this.mStreamSize);
        } else {
            CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
            if (cloneOrNull == null) {
                encodedImage = null;
            } else {
                try {
                    encodedImage = new EncodedImage((CloseableReference<PooledByteBuffer>) cloneOrNull);
                } finally {
                    CloseableReference.closeSafely((CloseableReference<?>) cloneOrNull);
                }
            }
        }
        if (encodedImage != null) {
            encodedImage.copyMetaDataFrom(this);
        }
        return encodedImage;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference.closeSafely(this.mPooledByteBufferRef);
    }

    public synchronized boolean isValid() {
        boolean z;
        if (!CloseableReference.isValid(this.mPooledByteBufferRef)) {
            z = this.mInputStreamSupplier != null;
        }
        return z;
    }

    public CloseableReference<PooledByteBuffer> getByteBufferRef() {
        return CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
    }

    public InputStream getInputStream() {
        Supplier<FileInputStream> supplier = this.mInputStreamSupplier;
        if (supplier != null) {
            return supplier.get();
        }
        CloseableReference cloneOrNull = CloseableReference.cloneOrNull(this.mPooledByteBufferRef);
        if (cloneOrNull == null) {
            return null;
        }
        try {
            return new PooledByteBufferInputStream((PooledByteBuffer) cloneOrNull.get());
        } finally {
            CloseableReference.closeSafely((CloseableReference<?>) cloneOrNull);
        }
    }

    public long getNativePtr() {
        try {
            return this.mPooledByteBufferRef.get().getNativePtr();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    public int getNativeSize() {
        try {
            return this.mPooledByteBufferRef.get().size();
        } catch (Throwable unused) {
            return -1;
        }
    }

    public boolean isRequestNetwork() {
        return this.isRequestNetwork;
    }

    public void setRequestNetwork() {
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = false;
        this.isHitDiskCache = false;
        this.isRequestNetwork = true;
    }

    public boolean isHitDiskCache() {
        return this.isHitDiskCache;
    }

    public void hitDisCache() {
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = false;
        this.isHitDiskCache = true;
        this.isRequestNetwork = false;
    }

    public boolean isHitEncodeMemoryCache() {
        return this.isHitEncodeMemoryCache;
    }

    public void hitEncodeMemoryCache() {
        this.isHitEncodeMemoryCache = true;
        this.isHitBitmapMemoryCache = false;
        this.isHitDiskCache = false;
        this.isRequestNetwork = false;
    }

    public boolean isHitBitmapMemoryCache() {
        return this.isHitBitmapMemoryCache;
    }

    public void hitBitmapMemoryCache() {
        this.isHitEncodeMemoryCache = false;
        this.isHitBitmapMemoryCache = true;
        this.isHitDiskCache = false;
        this.isRequestNetwork = false;
    }

    public void setImageFormat(ImageFormat imageFormat) {
        this.mImageFormat = imageFormat;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void setRotationAngle(int i) {
        this.mRotationAngle = i;
    }

    public void setExifOrientation(int i) {
        this.mExifOrientation = i;
    }

    public void setSampleSize(int i) {
        this.mSampleSize = i;
    }

    public void setStreamSize(int i) {
        this.mStreamSize = i;
    }

    public void setBytesRange(@Nullable BytesRange bytesRange) {
        this.mBytesRange = bytesRange;
    }

    public void setDecodeStatus(int i) {
        this.mDecodeStatus = i;
    }

    public void setRegionToDecode(@Nullable Rect rect) {
        this.mRegionToDecode = rect;
    }

    public void setExtraInfo(@Nullable Map<String, String> map) {
        this.mExtraInfo = map;
        CloseableReference<PooledByteBuffer> closeableReference = this.mPooledByteBufferRef;
        if (closeableReference == null || !(closeableReference.get() instanceof EncodeImagePooledByteBuffer)) {
            return;
        }
        ((EncodeImagePooledByteBuffer) this.mPooledByteBufferRef.get()).setExtraInfo(map);
    }

    public ImageFormat getImageFormat() {
        parseMetaDataIfNeeded();
        return this.mImageFormat;
    }

    public int getRotationAngle() {
        parseMetaDataIfNeeded();
        return this.mRotationAngle;
    }

    public int getExifOrientation() {
        parseMetaDataIfNeeded();
        return this.mExifOrientation;
    }

    public int getWidth() {
        parseMetaDataIfNeeded();
        return this.mWidth;
    }

    public int getHeight() {
        parseMetaDataIfNeeded();
        return this.mHeight;
    }

    @Nullable
    public ColorSpace getColorSpace() {
        parseMetaDataIfNeeded();
        return this.mColorSpace;
    }

    public int getSampleSize() {
        return this.mSampleSize;
    }

    @Nullable
    public BytesRange getBytesRange() {
        return this.mBytesRange;
    }

    public boolean isCompleteAt(int i) {
        if ((this.mImageFormat != DefaultImageFormats.JPEG && this.mImageFormat != DefaultImageFormats.WEBP_ANIMATED && this.mImageFormat != DefaultImageFormats.DNG) || this.mInputStreamSupplier != null) {
            return true;
        }
        Preconditions.checkNotNull(this.mPooledByteBufferRef);
        PooledByteBuffer pooledByteBuffer = this.mPooledByteBufferRef.get();
        if (this.mImageFormat == DefaultImageFormats.JPEG) {
            return pooledByteBuffer.read(i + (-2)) == -1 && pooledByteBuffer.read(i - 1) == -39;
        }
        if (this.mImageFormat == DefaultImageFormats.WEBP_ANIMATED) {
            return isCompleteForStatus();
        }
        return true;
    }

    private boolean isCompleteForStatus() {
        int i = this.mDecodeStatus;
        return i == 0 || i == 3;
    }

    public int getSize() {
        CloseableReference<PooledByteBuffer> closeableReference = this.mPooledByteBufferRef;
        if (closeableReference != null && closeableReference.get() != null) {
            return this.mPooledByteBufferRef.get().size();
        }
        return this.mStreamSize;
    }

    @Nullable
    public Rect getRegionToDecode() {
        return this.mRegionToDecode;
    }

    @Nullable
    public Map<String, String> getExtraInfo() {
        return this.mExtraInfo;
    }

    public String getFirstBytesAsHexString(int i) {
        CloseableReference<PooledByteBuffer> byteBufferRef = getByteBufferRef();
        if (byteBufferRef == null) {
            return "";
        }
        int min = Math.min(getSize(), i);
        byte[] bArr = new byte[min];
        try {
            PooledByteBuffer pooledByteBuffer = byteBufferRef.get();
            if (pooledByteBuffer == null) {
                return "";
            }
            pooledByteBuffer.read(0, bArr, 0, min);
            byteBufferRef.close();
            StringBuilder sb = new StringBuilder(min * 2);
            for (int i2 = 0; i2 < min; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } finally {
            byteBufferRef.close();
        }
    }

    private void parseMetaDataIfNeeded() {
        if (this.mWidth < 0 || this.mHeight < 0) {
            parseMetaData();
        }
    }

    public void parseMetaData() {
        Pair<Integer, Integer> readHeifFormatImageSizeForSimple;
        ImageFormat imageFormat_WrapIOException = ImageFormatChecker.getImageFormat_WrapIOException(getInputStream());
        this.mImageFormat = imageFormat_WrapIOException;
        if (DefaultImageFormats.isWebpFormat(imageFormat_WrapIOException)) {
            readHeifFormatImageSizeForSimple = readWebPImageSize();
        } else if (DefaultImageFormats.isHeifFormat(imageFormat_WrapIOException) || DefaultImageFormats.isVvifFormat(imageFormat_WrapIOException)) {
            readHeifFormatImageSizeForSimple = readHeifFormatImageSizeForSimple();
        } else if (DefaultImageFormats.isAvifOrAvis(imageFormat_WrapIOException)) {
            readHeifFormatImageSizeForSimple = readAvifImageMetaData();
        } else {
            readHeifFormatImageSizeForSimple = readImageMetaData().getDimensions();
        }
        if (imageFormat_WrapIOException == DefaultImageFormats.JPEG && this.mRotationAngle == -1) {
            if (readHeifFormatImageSizeForSimple != null) {
                int orientation = JfifUtil.getOrientation(getInputStream());
                this.mExifOrientation = orientation;
                this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(orientation);
            }
        } else if (DefaultImageFormats.isHeifFormat(imageFormat_WrapIOException) && this.mRotationAngle == -1) {
            int orientation2 = HeifExifUtil.getOrientation(getInputStream());
            this.mExifOrientation = orientation2;
            this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(orientation2);
        } else if (imageFormat_WrapIOException == DefaultImageFormats.DNG && this.mRotationAngle == -1) {
            int orientation3 = DngExifUtil.getOrientation(getInputStream());
            this.mExifOrientation = orientation3;
            this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(orientation3);
        } else if (this.mRotationAngle == -1) {
            this.mRotationAngle = 0;
        }
        if ((!mUseUltimateOptHeifBitmap && !mOptHeifParse) || (!DefaultImageFormats.isHeifFormat(imageFormat_WrapIOException) && !DefaultImageFormats.isVvifFormat(imageFormat_WrapIOException))) {
            this.mHasAlpha = AlphaChecker.hasAlpha(imageFormat_WrapIOException, getInputStream(), true);
        }
        this.mRegionToDecode = parseRegionToDecode(this.mExtraInfo);
    }

    private Pair<Integer, Integer> readWebPImageSize() {
        Pair<Integer, Integer> size = WebpUtil.getSize(getInputStream());
        if (size != null) {
            this.mWidth = ((Integer) size.first).intValue();
            this.mHeight = ((Integer) size.second).intValue();
        }
        return size;
    }

    private Pair<Integer, Integer> readHeifFormatImageSizeForSimple() {
        int[] readHeifFormatImageSizeForSimple;
        InputStream inputStream = getInputStream();
        try {
            try {
                long nativePtr = getNativePtr();
                if (mOptHeifParse) {
                    readHeifFormatImageSizeForSimple = HeifFormatUtil.readHeifFormatImageSizeForSimple(nativePtr, getSize());
                } else {
                    readHeifFormatImageSizeForSimple = HeifFormatUtil.readHeifFormatImageSizeForSimple(inputStream);
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (inputStream == null) {
                    return null;
                }
            }
            if (readHeifFormatImageSizeForSimple != null) {
                this.mWidth = readHeifFormatImageSizeForSimple[0];
                this.mHeight = readHeifFormatImageSizeForSimple[1];
                this.mHasAlpha = readHeifFormatImageSizeForSimple[8] == 1;
                this.mIs10Bit = readHeifFormatImageSizeForSimple[9] == 10;
                this.mRotationAngle = JfifUtil.transformFromClockWiseToAntiClockWise(readHeifFormatImageSizeForSimple[2]);
                this.mExifOrientation = readHeifFormatImageSizeForSimple[10];
                if (readHeifFormatImageSizeForSimple.length >= 12) {
                    this.mHdrType = readHeifFormatImageSizeForSimple[11];
                }
                if (readHeifFormatImageSizeForSimple[3] == 0) {
                    this.mImageFormat = HeifFormatUtil.getHeifFormatAnimated();
                }
                Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(readHeifFormatImageSizeForSimple[0]), Integer.valueOf(readHeifFormatImageSizeForSimple[1]));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return pair;
            }
            if (inputStream == null) {
                return null;
            }
            try {
                inputStream.close();
            } catch (IOException unused2) {
                return null;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    private Pair<Integer, Integer> readAvifImageMetaData() {
        InputStream inputStream = getInputStream();
        try {
            try {
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.beginSection("EncodedImage#readAvifImageMetaData");
                }
                int[] readAvifImageSize = AvifFormatUtil.readAvifImageSize(inputStream);
                if (readAvifImageSize == null) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                    return null;
                }
                this.mWidth = readAvifImageSize[0];
                this.mHeight = readAvifImageSize[1];
                int transformStandarExifOrientationForAvif = JfifUtil.transformStandarExifOrientationForAvif(readAvifImageSize[2]);
                this.mExifOrientation = transformStandarExifOrientationForAvif;
                this.mRotationAngle = JfifUtil.getAutoRotateAngleFromOrientation(transformStandarExifOrientationForAvif);
                Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(readAvifImageSize[0]), Integer.valueOf(readAvifImageSize[1]));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return pair;
            } catch (Exception e) {
                e.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused3) {
                    }
                }
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
                return null;
            }
        } finally {
        }
    }

    private Rect parseRegionToDecode(Map<String, String> map) {
        String str;
        if (map == null || map.isEmpty() || (str = map.get("regionToDecode")) == null) {
            return null;
        }
        return Rect.unflattenFromString(str);
    }

    private ImageMetaData readImageMetaData() {
        InputStream inputStream;
        try {
            inputStream = getInputStream();
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            ImageMetaData decodeDimensionsAndColorSpace = BitmapUtil.decodeDimensionsAndColorSpace(inputStream);
            this.mColorSpace = decodeDimensionsAndColorSpace.getColorSpace();
            Pair<Integer, Integer> dimensions = decodeDimensionsAndColorSpace.getDimensions();
            if (dimensions != null) {
                this.mWidth = ((Integer) dimensions.first).intValue();
                this.mHeight = ((Integer) dimensions.second).intValue();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return decodeDimensionsAndColorSpace;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public void copyMetaDataFrom(EncodedImage encodedImage) {
        this.mImageFormat = encodedImage.getImageFormat();
        this.mWidth = encodedImage.getWidth();
        this.mHeight = encodedImage.getHeight();
        this.mRotationAngle = encodedImage.getRotationAngle();
        this.mExifOrientation = encodedImage.getExifOrientation();
        this.mSampleSize = encodedImage.getSampleSize();
        this.mStreamSize = encodedImage.getSize();
        this.mBytesRange = encodedImage.getBytesRange();
        this.mColorSpace = encodedImage.getColorSpace();
        this.mHasAlpha = encodedImage.hasAlpha();
        this.mDecodeStatus = encodedImage.getDecodeStatus();
        this.mRegionToDecode = encodedImage.getRegionToDecode();
        this.mExtraInfo = encodedImage.getExtraInfo();
        this.isRequestNetwork = encodedImage.isRequestNetwork;
        this.isHitDiskCache = encodedImage.isHitDiskCache;
        this.isHitEncodeMemoryCache = encodedImage.isHitEncodeMemoryCache;
        this.isHitBitmapMemoryCache = encodedImage.isHitBitmapMemoryCache;
        this.uri = encodedImage.uri;
        this.viewWidth = encodedImage.viewWidth;
        this.viewHeight = encodedImage.viewHeight;
        this.mIs10Bit = encodedImage.is10Bit();
        this.mHdrType = encodedImage.getHdrType();
    }

    public boolean hasAlpha() {
        return this.mHasAlpha;
    }

    public boolean is10Bit() {
        return this.mIs10Bit;
    }

    public int getHdrType() {
        return this.mHdrType;
    }

    public int getDecodeStatus() {
        return this.mDecodeStatus;
    }

    public static boolean isMetaDataAvailable(EncodedImage encodedImage) {
        return encodedImage.mRotationAngle >= 0 && encodedImage.mWidth >= 0 && encodedImage.mHeight >= 0;
    }

    public static void closeSafely(@Nullable EncodedImage encodedImage) {
        if (encodedImage != null) {
            encodedImage.close();
        }
    }

    public static boolean isValid(@Nullable EncodedImage encodedImage) {
        return encodedImage != null && encodedImage.isValid();
    }

    public synchronized SharedReference<PooledByteBuffer> getUnderlyingReferenceTestOnly() {
        CloseableReference<PooledByteBuffer> closeableReference;
        closeableReference = this.mPooledByteBufferRef;
        return closeableReference != null ? closeableReference.getUnderlyingReferenceTestOnly() : null;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class EncodeImagePooledByteBuffer implements PooledByteBuffer, ResourceReleaser<EncodeImagePooledByteBuffer>, MemoryCacheHitTracker {
        public final CloseableReference<PooledByteBuffer> byteBufferRef;
        private boolean isHitBitmapMemoryCache;
        private boolean isHitEncodeMemoryCache;
        private Map<String, String> mExtraInfo;

        public EncodeImagePooledByteBuffer(CloseableReference<PooledByteBuffer> closeableReference) {
            this.byteBufferRef = closeableReference;
        }

        public Map<String, String> getExtraInfo() {
            return this.mExtraInfo;
        }

        @Override // com.facebook.imagepipeline.image.MemoryCacheHitTracker
        public void hitEncodeMemoryCache() {
            setHitEncodeMemoryCache(true);
        }

        @Override // com.facebook.imagepipeline.image.MemoryCacheHitTracker
        public void hitBitmapMemoryCache() {
            setHitBitmapMemoryCache(true);
        }

        public void setExtraInfo(Map<String, String> map) {
            this.mExtraInfo = map;
        }

        public void setHitEncodeMemoryCache(boolean z) {
            this.isHitEncodeMemoryCache = z;
        }

        public boolean isHitEncodeMemoryCache() {
            return this.isHitEncodeMemoryCache;
        }

        public void setHitBitmapMemoryCache(boolean z) {
            this.isHitBitmapMemoryCache = z;
        }

        public boolean isHitBitmapMemoryCache() {
            return this.isHitBitmapMemoryCache;
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public int size() {
            return this.byteBufferRef.get().size();
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public byte read(int i) {
            return this.byteBufferRef.get().read(i);
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public int read(int i, byte[] bArr, int i2, int i3) {
            return this.byteBufferRef.get().read(i, bArr, i2, i3);
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public long getNativePtr() {
            return this.byteBufferRef.get().getNativePtr();
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        @Nullable
        public ByteBuffer getByteBuffer() {
            return this.byteBufferRef.get().getByteBuffer();
        }

        @Override // com.facebook.common.memory.PooledByteBuffer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.byteBufferRef.get().close();
        }

        @Override // com.facebook.common.memory.PooledByteBuffer
        public boolean isClosed() {
            return this.byteBufferRef.get().isClosed();
        }

        @Override // com.facebook.common.references.ResourceReleaser
        public void release(EncodeImagePooledByteBuffer encodeImagePooledByteBuffer) {
            encodeImagePooledByteBuffer.byteBufferRef.close();
        }
    }

    public void setIsDecodeThumb(boolean z) {
        this.isDecodeThumb = z;
    }

    public boolean isDecodeThumb() {
        return this.isDecodeThumb;
    }

    public int getThumbWidth() {
        return this.thumbWidth;
    }

    public void setThumbWidth(int i) {
        this.thumbWidth = i;
    }

    public int getThumbHeight() {
        return this.thumbHeight;
    }

    public void setThumbHeight(int i) {
        this.thumbHeight = i;
    }

    public boolean isHeicSysFirst() {
        return this.heicSysFirst;
    }

    public void setHeicSysFirst(boolean z) {
        this.heicSysFirst = z;
    }

    public int getHeicCustomDecoder() {
        return this.heicCustomDecoder;
    }

    public void setHeicCustomDecoder(int i) {
        this.heicCustomDecoder = i;
    }

    public long getThumbDecodeDuration() {
        return this.thumbDecodeDuration;
    }

    public void setThumbDecodeDuration(long j) {
        this.thumbDecodeDuration = j;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String str) {
        this.uri = str;
    }

    public int getViewWidth() {
        return this.viewWidth;
    }

    public void setViewWidth(int i) {
        this.viewWidth = i;
    }

    public int getViewHeight() {
        return this.viewHeight;
    }

    public void setViewHeight(int i) {
        this.viewHeight = i;
    }

    public void setHeifDecError(int i) {
        this.mHeifDecError = i;
    }

    public int getHeifDecError() {
        return this.mHeifDecError;
    }
}
