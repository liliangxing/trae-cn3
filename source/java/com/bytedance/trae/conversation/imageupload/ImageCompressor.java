package com.bytedance.trae.conversation.imageupload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.trae.im.model.MessagePart;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: ImageCompressor.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\"\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ,\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\"\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002J(\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageCompressor;", "", "cacheDir", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "compressIfNeeded", "Lcom/bytedance/trae/conversation/imageupload/CompressionResult;", "input", "dim", "Lcom/bytedance/trae/conversation/imageupload/ImageDimension;", "config", "Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;", "calculateOptimalDimensions", "Lkotlin/Pair;", "", "width", "height", "maxDimension", "decodeAndScale", "Landroid/graphics/Bitmap;", MessagePart.TYPE_FILE, "targetW", "targetH", "compressWithBinarySearch", "", "bitmap", "format", "Landroid/graphics/Bitmap$CompressFormat;", "targetSizeBytes", "", "minQuality", "", "Config", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ImageCompressor {
    private final File cacheDir;

    public ImageCompressor(File file) {
        Intrinsics.checkNotNullParameter(file, "cacheDir");
        this.cacheDir = file;
    }

    /* compiled from: ImageCompressor.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/ImageCompressor$Config;", "", "maxSizeBytes", "", "maxDimension", "", "minQuality", "", "preserveFormat", "", "<init>", "(JIFZ)V", "getMaxSizeBytes", "()J", "getMaxDimension", "()I", "getMinQuality", "()F", "getPreserveFormat", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class Config {
        private final int maxDimension;
        private final long maxSizeBytes;
        private final float minQuality;
        private final boolean preserveFormat;

        public Config() {
            this(0L, 0, 0.0f, false, 15, null);
        }

        public static /* synthetic */ Config copy$default(Config config, long j, int i, float f, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = config.maxSizeBytes;
            }
            long j2 = j;
            if ((i2 & 2) != 0) {
                i = config.maxDimension;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                f = config.minQuality;
            }
            float f2 = f;
            if ((i2 & 8) != 0) {
                z = config.preserveFormat;
            }
            return config.copy(j2, i3, f2, z);
        }

        /* renamed from: component1, reason: from getter */
        public final long getMaxSizeBytes() {
            return this.maxSizeBytes;
        }

        /* renamed from: component2, reason: from getter */
        public final int getMaxDimension() {
            return this.maxDimension;
        }

        /* renamed from: component3, reason: from getter */
        public final float getMinQuality() {
            return this.minQuality;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getPreserveFormat() {
            return this.preserveFormat;
        }

        public final Config copy(long maxSizeBytes, int maxDimension, float minQuality, boolean preserveFormat) {
            return new Config(maxSizeBytes, maxDimension, minQuality, preserveFormat);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return this.maxSizeBytes == config.maxSizeBytes && this.maxDimension == config.maxDimension && Float.compare(this.minQuality, config.minQuality) == 0 && this.preserveFormat == config.preserveFormat;
        }

        public int hashCode() {
            return (((((Long.hashCode(this.maxSizeBytes) * 31) + Integer.hashCode(this.maxDimension)) * 31) + Float.hashCode(this.minQuality)) * 31) + Boolean.hashCode(this.preserveFormat);
        }

        public String toString() {
            return "Config(maxSizeBytes=" + this.maxSizeBytes + ", maxDimension=" + this.maxDimension + ", minQuality=" + this.minQuality + ", preserveFormat=" + this.preserveFormat + ')';
        }

        public Config(long j, int i, float f, boolean z) {
            this.maxSizeBytes = j;
            this.maxDimension = i;
            this.minQuality = f;
            this.preserveFormat = z;
        }

        public /* synthetic */ Config(long j, int i, float f, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 1048576L : j, (i2 & 2) != 0 ? 2048 : i, (i2 & 4) != 0 ? 0.3f : f, (i2 & 8) != 0 ? false : z);
        }

        public final long getMaxSizeBytes() {
            return this.maxSizeBytes;
        }

        public final int getMaxDimension() {
            return this.maxDimension;
        }

        public final float getMinQuality() {
            return this.minQuality;
        }

        public final boolean getPreserveFormat() {
            return this.preserveFormat;
        }
    }

    public static /* synthetic */ CompressionResult compressIfNeeded$default(ImageCompressor imageCompressor, File file, ImageDimension imageDimension, Config config, int i, Object obj) {
        if ((i & 4) != 0) {
            config = new Config(0L, 0, 0.0f, false, 15, null);
        }
        return imageCompressor.compressIfNeeded(file, imageDimension, config);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00bb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CompressionResult compressIfNeeded(File input, ImageDimension dim, Config config) {
        Bitmap.CompressFormat compressFormat;
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(config, "config");
        long length = input.length();
        ImageDimension readImageDimension = dim == null ? ImageValidation.INSTANCE.readImageDimension(input) : dim;
        if (!(length > 1048576 || readImageDimension.getWidth() > 2048 || readImageDimension.getHeight() > 2048)) {
            return new CompressionResult(input, readImageDimension.getWidth(), readImageDimension.getHeight(), length, length, false);
        }
        Pair<Integer, Integer> calculateOptimalDimensions = calculateOptimalDimensions(readImageDimension.getWidth(), readImageDimension.getHeight(), config.getMaxDimension());
        int intValue = ((Number) calculateOptimalDimensions.component1()).intValue();
        int intValue2 = ((Number) calculateOptimalDimensions.component2()).intValue();
        Bitmap decodeAndScale = decodeAndScale(input, intValue, intValue2);
        if (decodeAndScale == null) {
            throw new ImageUploadException(ImageUploadErrorCode.COMPRESSION_FAILED, "Decode bitmap failed", null, 4, null);
        }
        try {
            String str = ".png";
            try {
                if (config.getPreserveFormat()) {
                    String name = input.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    String lowerCase = name.toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    if (StringsKt.endsWith$default(lowerCase, ".png", false, 2, (Object) null)) {
                        compressFormat = Bitmap.CompressFormat.PNG;
                        byte[] compressWithBinarySearch = compressWithBinarySearch(decodeAndScale, compressFormat, config.getMaxSizeBytes(), config.getMinQuality());
                        if (compressFormat == Bitmap.CompressFormat.PNG) {
                            str = ".jpg";
                        }
                        File file = new File(this.cacheDir, "conv_img_upload_" + System.currentTimeMillis() + str);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        fileOutputStream.write(compressWithBinarySearch);
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                        return new CompressionResult(file, intValue, intValue2, length, file.length(), true);
                    }
                }
                fileOutputStream.write(compressWithBinarySearch);
                Unit unit2 = Unit.INSTANCE;
                CloseableKt.closeFinally(fileOutputStream, (Throwable) null);
                return new CompressionResult(file, intValue, intValue2, length, file.length(), true);
            } finally {
            }
            compressFormat = Bitmap.CompressFormat.JPEG;
            byte[] compressWithBinarySearch2 = compressWithBinarySearch(decodeAndScale, compressFormat, config.getMaxSizeBytes(), config.getMinQuality());
            if (compressFormat == Bitmap.CompressFormat.PNG) {
            }
            File file2 = new File(this.cacheDir, "conv_img_upload_" + System.currentTimeMillis() + str);
            FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
        } finally {
            decodeAndScale.recycle();
        }
    }

    private final Pair<Integer, Integer> calculateOptimalDimensions(int width, int height, int maxDimension) {
        if (width <= maxDimension && height <= maxDimension) {
            return TuplesKt.to(Integer.valueOf(width), Integer.valueOf(height));
        }
        double d = maxDimension;
        double d2 = width;
        double d3 = height;
        double min = Math.min(d / d2, d / d3);
        int roundToInt = MathKt.roundToInt(d2 * min);
        int roundToInt2 = MathKt.roundToInt(d3 * min);
        if (roundToInt % 2 == 1) {
            roundToInt++;
        }
        if (roundToInt2 % 2 == 1) {
            roundToInt2++;
        }
        return TuplesKt.to(Integer.valueOf(roundToInt), Integer.valueOf(roundToInt2));
    }

    private final Bitmap decodeAndScale(File file, int targetW, int targetH) {
        Bitmap decodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
        if (decodeFile == null) {
            return null;
        }
        if (decodeFile.getWidth() == targetW && decodeFile.getHeight() == targetH) {
            return decodeFile;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, targetW, targetH, true);
        Intrinsics.checkNotNullExpressionValue(createScaledBitmap, "createScaledBitmap(...)");
        if (createScaledBitmap != decodeFile) {
            decodeFile.recycle();
        }
        return createScaledBitmap;
    }

    private final byte[] compressWithBinarySearch(Bitmap bitmap, Bitmap.CompressFormat format, long targetSizeBytes, float minQuality) {
        ByteArrayOutputStream byteArrayOutputStream;
        int i = 100;
        if (format == Bitmap.CompressFormat.PNG) {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = byteArrayOutputStream;
                bitmap.compress(format, 100, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                Intrinsics.checkNotNullExpressionValue(byteArray, "use(...)");
                return byteArray;
            } finally {
            }
        } else {
            int coerceIn = RangesKt.coerceIn((int) (minQuality * 100), 0, 100);
            byte[] bArr = null;
            for (int i2 = 0; i2 < 8; i2++) {
                int i3 = (coerceIn + i) / 2;
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream;
                    bitmap.compress(format, i3, byteArrayOutputStream3);
                    byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                    if (byteArray2.length <= targetSizeBytes) {
                        coerceIn = i3;
                        bArr = byteArray2;
                    } else {
                        i = i3;
                    }
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
            if (bArr == null || bArr.length > targetSizeBytes) {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream;
                    bitmap.compress(format, coerceIn, byteArrayOutputStream4);
                    bArr = byteArrayOutputStream4.toByteArray();
                    CloseableKt.closeFinally(byteArrayOutputStream, (Throwable) null);
                } finally {
                    try {
                        throw th;
                    } finally {
                    }
                }
            }
            Intrinsics.checkNotNull(bArr);
            return bArr;
        }
    }
}
