package com.bytedance.kmp.image.options;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.DrawableResource;
import org.jetbrains.compose.resources.ImageResources_androidKt;

/* compiled from: ImagePlaceholder.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0012\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\r\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000bJ\u0006\u0010\f\u001a\u00020\u0006J\b\u0010\r\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/image/options/ImagePlaceholder;", "", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Landroidx/compose/ui/graphics/painter/Painter;)V", "imageSource", "Lcom/bytedance/kmp/image/options/KImageSource;", "scaleType", "Lcom/bytedance/kmp/image/options/ImageScaleType;", "(Lcom/bytedance/kmp/image/options/KImageSource;Lcom/bytedance/kmp/image/options/ImageScaleType;)V", "getCoilPlaceHolder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "getPlaceHolder", "getScaleType", "Companion", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ImagePlaceholder {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private KImageSource imageSource;
    private Painter painter;
    private ImageScaleType scaleType;

    public /* synthetic */ ImagePlaceholder(KImageSource kImageSource, ImageScaleType imageScaleType, DefaultConstructorMarker defaultConstructorMarker) {
        this(kImageSource, imageScaleType);
    }

    public ImagePlaceholder(Painter painter) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        this.painter = new ColorPainter(ColorKt.Color(ImageColor.INSTANCE.getWhite().getColor()), (DefaultConstructorMarker) null);
        this.imageSource = None.INSTANCE;
        this.painter = painter;
    }

    private ImagePlaceholder(KImageSource kImageSource, ImageScaleType imageScaleType) {
        this.painter = new ColorPainter(ColorKt.Color(ImageColor.INSTANCE.getWhite().getColor()), (DefaultConstructorMarker) null);
        None none = None.INSTANCE;
        this.imageSource = kImageSource;
        this.scaleType = imageScaleType;
    }

    /* synthetic */ ImagePlaceholder(KImageSource kImageSource, ImageScaleType imageScaleType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kImageSource, (i & 2) != 0 ? null : imageScaleType);
    }

    /* compiled from: ImagePlaceholder.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/kmp/image/options/ImagePlaceholder$Companion;", "", "()V", "ofColor", "Lcom/bytedance/kmp/image/options/ImagePlaceholder;", "color", "Lcom/bytedance/kmp/image/options/ImageColor;", "ofColorValue", "colorValue", "", "ofResource", "drawable", "Lorg/jetbrains/compose/resources/DrawableResource;", "scaleType", "Lcom/bytedance/kmp/image/options/ImageScaleType;", "kmpimage_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ImagePlaceholder ofColorValue(long colorValue) {
            ColorSource colorSource = new ColorSource(colorValue);
            ImageScaleType imageScaleType = null;
            return new ImagePlaceholder(colorSource, imageScaleType, 2, imageScaleType);
        }

        public final ImagePlaceholder ofColor(ImageColor color) {
            Intrinsics.checkNotNullParameter(color, "color");
            ColorSource colorSource = new ColorSource(color.getColor());
            ImageScaleType imageScaleType = null;
            return new ImagePlaceholder(colorSource, imageScaleType, 2, imageScaleType);
        }

        public static /* synthetic */ ImagePlaceholder ofResource$default(Companion companion, DrawableResource drawableResource, ImageScaleType imageScaleType, int i, Object obj) {
            if ((i & 2) != 0) {
                imageScaleType = null;
            }
            return companion.ofResource(drawableResource, imageScaleType);
        }

        public final ImagePlaceholder ofResource(DrawableResource drawable, ImageScaleType scaleType) {
            Intrinsics.checkNotNullParameter(drawable, "drawable");
            return new ImagePlaceholder(new LocalResourceSource(drawable), scaleType, null);
        }
    }

    public final Painter getCoilPlaceHolder(Composer composer, int i) {
        composer.startReplaceGroup(335875908);
        ComposerKt.sourceInformation(composer, "C(getCoilPlaceHolder):ImagePlaceholder.kt#8bzg8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(335875908, i, -1, "com.bytedance.kmp.image.options.ImagePlaceholder.getCoilPlaceHolder (ImagePlaceholder.kt:57)");
        }
        KImageSource kImageSource = this.imageSource;
        if (kImageSource instanceof ColorSource) {
            KImageSource kImageSource2 = this.imageSource;
            Intrinsics.checkNotNull(kImageSource2, "null cannot be cast to non-null type com.bytedance.kmp.image.options.ColorSource");
            this.painter = new ColorPainter(ColorKt.Color(((ColorSource) kImageSource2).getColor()), (DefaultConstructorMarker) null);
        } else if (kImageSource instanceof LocalResourceSource) {
            if (this.scaleType != null) {
                composer.startReplaceGroup(-1194346907);
                ComposerKt.sourceInformation(composer, "66@2178L62");
                KImageSource kImageSource3 = this.imageSource;
                Intrinsics.checkNotNull(kImageSource3, "null cannot be cast to non-null type com.bytedance.kmp.image.options.LocalResourceSource");
                Painter painterResource = ImageResources_androidKt.painterResource(((LocalResourceSource) kImageSource3).getResource(), composer, 0);
                ImageScaleType imageScaleType = this.scaleType;
                Intrinsics.checkNotNull(imageScaleType);
                this.painter = new PlaceholderScalePainter(painterResource, imageScaleType.getScaleType());
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1194128946);
                ComposerKt.sourceInformation(composer, "69@2352L62");
                KImageSource kImageSource4 = this.imageSource;
                Intrinsics.checkNotNull(kImageSource4, "null cannot be cast to non-null type com.bytedance.kmp.image.options.LocalResourceSource");
                this.painter = ImageResources_androidKt.painterResource(((LocalResourceSource) kImageSource4).getResource(), composer, 0);
                composer.endReplaceGroup();
            }
        }
        Painter painter = this.painter;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return painter;
    }

    /* renamed from: getPlaceHolder, reason: from getter */
    public final KImageSource getImageSource() {
        return this.imageSource;
    }

    public final ImageScaleType getScaleType() {
        return this.scaleType;
    }
}
