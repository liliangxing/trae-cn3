package com.bytedance.trae.image.fresco;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
import com.bytedance.trae.utils.logger.TraeLogUtil;
import com.caverock.androidsvg.SVG;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatCheckerUtils;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;
import java.io.InputStream;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: SvgFrescoDecoder.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u0013\u0014\u0015\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder;", "", "<init>", "()V", "TAG", "", "HEADER_SIZE", "", "BYTES_PER_ARGB_8888_PIXEL", "", "FALLBACK_SVG_SIZE_BYTES", "HEADER_TAG", "", "kotlin.jvm.PlatformType", "[B", "SVG_FORMAT", "Lcom/facebook/imageformat/ImageFormat;", "getSVG_FORMAT", "()Lcom/facebook/imageformat/ImageFormat;", "SvgFormatChecker", "SvgDecoder", "SvgDrawableFactory", "CloseableSvgImage", "SvgDrawable", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SvgFrescoDecoder {
    private static final long BYTES_PER_ARGB_8888_PIXEL = 4;
    private static final int FALLBACK_SVG_SIZE_BYTES = 4;
    private static final int HEADER_SIZE = 4096;
    private static final String TAG = "SvgFrescoDecoder";
    public static final SvgFrescoDecoder INSTANCE = new SvgFrescoDecoder();
    private static final byte[] HEADER_TAG = ImageFormatCheckerUtils.asciiBytes("<svg");
    private static final ImageFormat SVG_FORMAT = new ImageFormat("SVG_FORMAT", "svg");

    private SvgFrescoDecoder() {
    }

    public final ImageFormat getSVG_FORMAT() {
        return SVG_FORMAT;
    }

    /* compiled from: SvgFrescoDecoder.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgFormatChecker;", "Lcom/facebook/imageformat/ImageFormat$FormatChecker;", "<init>", "()V", "getHeaderSize", "", "determineFormat", "Lcom/facebook/imageformat/ImageFormat;", "headerBytes", "", "headerSize", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class SvgFormatChecker implements ImageFormat.FormatChecker {
        public int getHeaderSize() {
            return 4096;
        }

        public ImageFormat determineFormat(byte[] headerBytes, int headerSize) {
            Intrinsics.checkNotNullParameter(headerBytes, "headerBytes");
            if (ImageFormatCheckerUtils.indexOfPattern(headerBytes, headerSize, SvgFrescoDecoder.HEADER_TAG, SvgFrescoDecoder.HEADER_TAG.length) >= 0) {
                return SvgFrescoDecoder.INSTANCE.getSVG_FORMAT();
            }
            return null;
        }
    }

    /* compiled from: SvgFrescoDecoder.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDecoder;", "Lcom/facebook/imagepipeline/decoder/ImageDecoder;", "<init>", "()V", "decode", "Lcom/facebook/imagepipeline/image/CloseableImage;", "encodedImage", "Lcom/facebook/imagepipeline/image/EncodedImage;", "length", "", "qualityInfo", "Lcom/facebook/imagepipeline/image/QualityInfo;", "options", "Lcom/facebook/imagepipeline/common/ImageDecodeOptions;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class SvgDecoder implements ImageDecoder {
        public CloseableImage decode(EncodedImage encodedImage, int length, QualityInfo qualityInfo, ImageDecodeOptions options) {
            Object obj;
            Intrinsics.checkNotNullParameter(encodedImage, "encodedImage");
            Intrinsics.checkNotNullParameter(qualityInfo, "qualityInfo");
            Intrinsics.checkNotNullParameter(options, "options");
            try {
                Result.Companion companion = Result.Companion;
                SvgDecoder svgDecoder = this;
                InputStream inputStream = encodedImage.getInputStream();
                try {
                    SVG fromInputStream = SVG.getFromInputStream(inputStream);
                    Intrinsics.checkNotNullExpressionValue(fromInputStream, "getFromInputStream(...)");
                    CloseableSvgImage closeableSvgImage = new CloseableSvgImage(fromInputStream);
                    CloseableKt.closeFinally(inputStream, (Throwable) null);
                    obj = Result.constructor-impl(closeableSvgImage);
                } finally {
                }
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                TraeLogUtil.INSTANCE.w(SvgFrescoDecoder.TAG, "decode svg failed", th2);
            }
            return (CloseableImage) (Result.isFailure-impl(obj) ? null : obj);
        }
    }

    /* compiled from: SvgFrescoDecoder.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawableFactory;", "Lcom/facebook/imagepipeline/drawable/DrawableFactory;", "<init>", "()V", "supportsImageType", "", "image", "Lcom/facebook/imagepipeline/image/CloseableImage;", "createDrawable", "Landroid/graphics/drawable/Drawable;", "drawable", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class SvgDrawableFactory implements DrawableFactory {
        public boolean supportsImageType(CloseableImage image) {
            Intrinsics.checkNotNullParameter(image, "image");
            return image instanceof CloseableSvgImage;
        }

        public Drawable createDrawable(CloseableImage image) {
            Intrinsics.checkNotNullParameter(image, "image");
            CloseableSvgImage closeableSvgImage = image instanceof CloseableSvgImage ? (CloseableSvgImage) image : null;
            return closeableSvgImage != null ? new SvgDrawable(closeableSvgImage.getSvg()) : null;
        }

        public Drawable createDrawable(CloseableImage image, Drawable drawable) {
            Intrinsics.checkNotNullParameter(image, "image");
            return createDrawable(image);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SvgFrescoDecoder.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u000b*\u00020\u0014H\u0002¢\u0006\u0002\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$CloseableSvgImage;", "Lcom/facebook/imagepipeline/image/CloseableImage;", "svg", "Lcom/caverock/androidsvg/SVG;", "<init>", "(Lcom/caverock/androidsvg/SVG;)V", "getSvg", "()Lcom/caverock/androidsvg/SVG;", "closed", "", "getSizeInBytes", "", "close", "", "isClosed", "isStateful", "getWidth", "getHeight", "getImageCount", "toPositiveRoundedIntOrNull", "", "(F)Ljava/lang/Integer;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class CloseableSvgImage extends CloseableImage {
        private boolean closed;
        private final SVG svg;

        public int getImageCount() {
            return 1;
        }

        public boolean isStateful() {
            return false;
        }

        public CloseableSvgImage(SVG svg) {
            Intrinsics.checkNotNullParameter(svg, "svg");
            this.svg = svg;
            this.mImageFormat = SvgFrescoDecoder.INSTANCE.getSVG_FORMAT();
        }

        public final SVG getSvg() {
            return this.svg;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0078  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x003a A[Catch: all -> 0x0066, TryCatch #0 {all -> 0x0066, blocks: (B:2:0x0000, B:4:0x0019, B:5:0x002e, B:7:0x003a, B:8:0x004f, B:17:0x0041, B:19:0x004b, B:21:0x0020), top: B:1:0x0000 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSizeInBytes() {
            Object obj;
            Throwable th;
            RectF documentViewBox;
            Integer positiveRoundedIntOrNull;
            int i;
            int i2;
            Integer positiveRoundedIntOrNull2;
            try {
                Result.Companion companion = Result.Companion;
                CloseableSvgImage closeableSvgImage = this;
                documentViewBox = this.svg.getDocumentViewBox();
                positiveRoundedIntOrNull = toPositiveRoundedIntOrNull(this.svg.getDocumentWidth());
                i = 1;
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th2));
            }
            if (positiveRoundedIntOrNull == null) {
                positiveRoundedIntOrNull = documentViewBox != null ? toPositiveRoundedIntOrNull(documentViewBox.width()) : null;
                if (positiveRoundedIntOrNull == null) {
                    i2 = 1;
                    positiveRoundedIntOrNull2 = toPositiveRoundedIntOrNull(this.svg.getDocumentHeight());
                    if (positiveRoundedIntOrNull2 == null) {
                        i = positiveRoundedIntOrNull2.intValue();
                    } else {
                        Integer positiveRoundedIntOrNull3 = documentViewBox != null ? toPositiveRoundedIntOrNull(documentViewBox.height()) : null;
                        if (positiveRoundedIntOrNull3 != null) {
                            i = positiveRoundedIntOrNull3.intValue();
                        }
                    }
                    obj = Result.constructor-impl(Integer.valueOf((int) RangesKt.coerceAtMost(i2 * i * 4, 2147483647L)));
                    th = Result.exceptionOrNull-impl(obj);
                    if (th != null) {
                        TraeLogUtil.INSTANCE.w(SvgFrescoDecoder.TAG, "get svg size failed", th);
                        obj = 4;
                    }
                    return ((Number) obj).intValue();
                }
            }
            i2 = positiveRoundedIntOrNull.intValue();
            positiveRoundedIntOrNull2 = toPositiveRoundedIntOrNull(this.svg.getDocumentHeight());
            if (positiveRoundedIntOrNull2 == null) {
            }
            obj = Result.constructor-impl(Integer.valueOf((int) RangesKt.coerceAtMost(i2 * i * 4, 2147483647L)));
            th = Result.exceptionOrNull-impl(obj);
            if (th != null) {
            }
            return ((Number) obj).intValue();
        }

        public void close() {
            this.closed = true;
        }

        /* renamed from: isClosed, reason: from getter */
        public boolean getClosed() {
            return this.closed;
        }

        public int getWidth() {
            Float valueOf = Float.valueOf(this.svg.getDocumentWidth());
            if (!(valueOf.floatValue() > 0.0f)) {
                valueOf = null;
            }
            if (valueOf != null) {
                return (int) valueOf.floatValue();
            }
            return 0;
        }

        public int getHeight() {
            Float valueOf = Float.valueOf(this.svg.getDocumentHeight());
            if (!(valueOf.floatValue() > 0.0f)) {
                valueOf = null;
            }
            if (valueOf != null) {
                return (int) valueOf.floatValue();
            }
            return 0;
        }

        private final Integer toPositiveRoundedIntOrNull(float f) {
            if (!((Float.isInfinite(f) || Float.isNaN(f)) ? false : true) || f <= 0.0f) {
                return null;
            }
            Integer valueOf = Integer.valueOf(MathKt.roundToInt(RangesKt.coerceAtMost(f, 2.14748365E9f)));
            if (valueOf.intValue() > 0) {
                return valueOf;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SvgFrescoDecoder.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0012\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0017J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/image/fresco/SvgFrescoDecoder$SvgDrawable;", "Landroid/graphics/drawable/Drawable;", "svg", "Lcom/caverock/androidsvg/SVG;", "<init>", "(Lcom/caverock/androidsvg/SVG;)V", "alphaValue", "", "colorFilterValue", "Landroid/graphics/ColorFilter;", "layerPaint", "Landroid/graphics/Paint;", "intrinsicWidth", "intrinsicHeight", "draw", "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "getOpacity", "getIntrinsicWidth", "getIntrinsicHeight", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class SvgDrawable extends Drawable {
        private int alphaValue;
        private ColorFilter colorFilterValue;
        private final int intrinsicHeight;
        private final int intrinsicWidth;
        private final Paint layerPaint;
        private final SVG svg;

        @Override // android.graphics.drawable.Drawable
        @Deprecated(message = "Deprecated in Java")
        public int getOpacity() {
            return -3;
        }

        public SvgDrawable(SVG svg) {
            Intrinsics.checkNotNullParameter(svg, "svg");
            this.svg = svg;
            this.alphaValue = ReducerConstants.REQUEST_CODE;
            this.layerPaint = new Paint();
            Float valueOf = Float.valueOf(svg.getDocumentWidth());
            valueOf = (valueOf.floatValue() > 0.0f ? 1 : (valueOf.floatValue() == 0.0f ? 0 : -1)) > 0 ? valueOf : null;
            this.intrinsicWidth = valueOf != null ? MathKt.roundToInt(valueOf.floatValue()) : -1;
            Float valueOf2 = Float.valueOf(svg.getDocumentHeight());
            Float f = valueOf2.floatValue() > 0.0f ? valueOf2 : null;
            this.intrinsicHeight = f != null ? MathKt.roundToInt(f.floatValue()) : -1;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            int saveLayer;
            Object obj;
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Rect bounds = getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            if (bounds.width() <= 0 || bounds.height() <= 0) {
                return;
            }
            int i = this.alphaValue;
            if (i < 255 || this.colorFilterValue != null) {
                this.layerPaint.setAlpha(i);
                this.layerPaint.setColorFilter(this.colorFilterValue);
                saveLayer = canvas.saveLayer(bounds.left, bounds.top, bounds.right, bounds.bottom, this.layerPaint);
            } else {
                saveLayer = canvas.save();
            }
            float documentWidth = this.svg.getDocumentWidth();
            float documentHeight = this.svg.getDocumentHeight();
            try {
                Result.Companion companion = Result.Companion;
                SvgDrawable svgDrawable = this;
                canvas.translate(bounds.left, bounds.top);
                this.svg.setDocumentWidth(bounds.width());
                this.svg.setDocumentHeight(bounds.height());
                this.svg.renderToCanvas(canvas, new RectF(0.0f, 0.0f, bounds.width(), bounds.height()));
                obj = Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                TraeLogUtil.INSTANCE.w(SvgFrescoDecoder.TAG, "draw svg failed", th2);
            }
            this.svg.setDocumentWidth(documentWidth);
            this.svg.setDocumentHeight(documentHeight);
            canvas.restoreToCount(saveLayer);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
            this.alphaValue = alpha;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            if (Intrinsics.areEqual(this.colorFilterValue, colorFilter)) {
                return;
            }
            this.colorFilterValue = colorFilter;
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.intrinsicWidth;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.intrinsicHeight;
        }
    }
}
