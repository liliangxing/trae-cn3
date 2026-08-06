package org.jetbrains.compose.resources;

import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.unit.Dp;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ImageResources.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\u001a\b\u0010\u0016\u001a\u00020\u0017H\u0000\u001a2\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00130\u001dH\u0080@¢\u0006\u0002\u0010\u001f\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00078@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\b\u0010\t\"\u001b\u0010\u000b\u001a\u00020\f8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\r\u0010\u000e\" \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"emptyImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "getEmptyImageBitmap", "()Landroidx/compose/ui/graphics/ImageBitmap;", "emptyImageBitmap$delegate", "Lkotlin/Lazy;", "emptyImageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "getEmptyImageVector", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "emptyImageVector$delegate", "emptySvgPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "getEmptySvgPainter", "()Landroidx/compose/ui/graphics/painter/Painter;", "emptySvgPainter$delegate", "imageCache", "Lorg/jetbrains/compose/resources/AsyncCache;", "", "Lorg/jetbrains/compose/resources/ImageCache;", "getImageCache", "()Lorg/jetbrains/compose/resources/AsyncCache;", "dropImageCache", "", "loadImage", "path", "resourceReader", "Lorg/jetbrains/compose/resources/ResourceReader;", "decode", "Lkotlin/Function1;", "", "(Ljava/lang/String;Lorg/jetbrains/compose/resources/ResourceReader;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "library_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes9.dex */
public final class ImageResourcesKt {
    private static final Lazy emptyImageBitmap$delegate = LazyKt.lazy(new Function0() { // from class: org.jetbrains.compose.resources.ImageResourcesKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            ImageBitmap emptyImageBitmap_delegate$lambda$0;
            emptyImageBitmap_delegate$lambda$0 = ImageResourcesKt.emptyImageBitmap_delegate$lambda$0();
            return emptyImageBitmap_delegate$lambda$0;
        }
    });
    private static final Lazy emptyImageVector$delegate = LazyKt.lazy(new Function0() { // from class: org.jetbrains.compose.resources.ImageResourcesKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            ImageVector emptyImageVector_delegate$lambda$1;
            emptyImageVector_delegate$lambda$1 = ImageResourcesKt.emptyImageVector_delegate$lambda$1();
            return emptyImageVector_delegate$lambda$1;
        }
    });
    private static final Lazy emptySvgPainter$delegate = LazyKt.lazy(new Function0() { // from class: org.jetbrains.compose.resources.ImageResourcesKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            BitmapPainter emptySvgPainter_delegate$lambda$2;
            emptySvgPainter_delegate$lambda$2 = ImageResourcesKt.emptySvgPainter_delegate$lambda$2();
            return emptySvgPainter_delegate$lambda$2;
        }
    });
    private static final AsyncCache<String, ImageCache> imageCache = new AsyncCache<>();

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageBitmap emptyImageBitmap_delegate$lambda$0() {
        return ImageBitmapKt.ImageBitmap-x__-hDU$default(1, 1, 0, false, (ColorSpace) null, 28, (Object) null);
    }

    public static final ImageBitmap getEmptyImageBitmap() {
        return (ImageBitmap) emptyImageBitmap$delegate.getValue();
    }

    public static final ImageVector getEmptyImageVector() {
        return (ImageVector) emptyImageVector$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageVector emptyImageVector_delegate$lambda$1() {
        float f = 1;
        return new ImageVector.Builder("emptyImageVector", Dp.constructor-impl(f), Dp.constructor-impl(f), 1.0f, 1.0f, 0L, 0, false, 224, (DefaultConstructorMarker) null).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BitmapPainter emptySvgPainter_delegate$lambda$2() {
        return new BitmapPainter(getEmptyImageBitmap(), 0L, 0L, 6, (DefaultConstructorMarker) null);
    }

    public static final Painter getEmptySvgPainter() {
        return (Painter) emptySvgPainter$delegate.getValue();
    }

    public static final AsyncCache<String, ImageCache> getImageCache() {
        return imageCache;
    }

    public static final void dropImageCache() {
        imageCache.clear();
    }

    public static final Object loadImage(String str, ResourceReader resourceReader, Function1<? super byte[], ? extends ImageCache> function1, Continuation<? super ImageCache> continuation) {
        return imageCache.getOrLoad(str, new ImageResourcesKt$loadImage$2(function1, resourceReader, str, null), continuation);
    }
}
