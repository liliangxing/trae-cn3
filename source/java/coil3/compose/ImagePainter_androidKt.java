package coil3.compose;

import android.content.Context;
import android.graphics.Canvas;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.BitmapPainterKt;
import androidx.compose.ui.graphics.painter.Painter;
import coil3.BitmapImage;
import coil3.DrawableImage;
import coil3.Image;
import coil3.compose.animate.AnimatedImagePainter;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

/* compiled from: ImagePainter.android.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u00060\u0005j\u0002`\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000b\"\u0018\u0010\f\u001a\u00020\r*\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"asPainter", "Landroidx/compose/ui/graphics/painter/Painter;", "Lcoil3/Image;", "context", "Lcoil3/PlatformContext;", "Landroid/content/Context;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "asPainter-wIOrVNA", "(Lcoil3/Image;Landroid/content/Context;ILkotlin/coroutines/CoroutineContext;)Landroidx/compose/ui/graphics/painter/Painter;", "nativeCanvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/Canvas;", "getNativeCanvas", "(Landroidx/compose/ui/graphics/Canvas;)Landroid/graphics/Canvas;", "coil-compose-core_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ImagePainter_androidKt {
    /* renamed from: asPainter-wIOrVNA, reason: not valid java name */
    public static final Painter m3194asPainterwIOrVNA(Image image, Context context, int i, CoroutineContext coroutineContext) {
        if (image instanceof BitmapImage) {
            return BitmapPainterKt.BitmapPainter-QZhYCtY$default(AndroidImageBitmap_androidKt.asImageBitmap(((BitmapImage) image).getBitmap()), 0L, 0L, i, 6, (Object) null);
        }
        if (image instanceof DrawableImage) {
            return new AnimatedImagePainter((DrawableImage) image, coroutineContext);
        }
        return new ImagePainter(image);
    }

    public static final Canvas getNativeCanvas(androidx.compose.ui.graphics.Canvas canvas) {
        return AndroidCanvas_androidKt.getNativeCanvas(canvas);
    }

    /* renamed from: asPainter-wIOrVNA$default, reason: not valid java name */
    public static /* synthetic */ Painter m3195asPainterwIOrVNA$default(Image image, Context context, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = DrawScope.Companion.getDefaultFilterQuality-f-v9h1I();
        }
        return m3194asPainterwIOrVNA(image, context, i, coroutineContext);
    }
}
