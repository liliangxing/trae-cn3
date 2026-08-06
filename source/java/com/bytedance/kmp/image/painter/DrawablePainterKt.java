package com.bytedance.kmp.image.painter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import androidx.compose.ui.graphics.painter.ColorPainter;
import androidx.compose.ui.graphics.painter.Painter;
import com.bytedance.kmp.image.utils.EmptyPainter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawablePainter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0002\u0010\u000e\"\u001b\u0010\u0000\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"MAIN_HANDLER", "Landroid/os/Handler;", "getMAIN_HANDLER", "()Landroid/os/Handler;", "MAIN_HANDLER$delegate", "Lkotlin/Lazy;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "Landroid/graphics/drawable/Drawable;", "getIntrinsicSize", "(Landroid/graphics/drawable/Drawable;)J", "rememberDrawablePainter", "Landroidx/compose/ui/graphics/painter/Painter;", "drawable", "(Landroid/graphics/drawable/Drawable;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "kmpimage_release"}, k = 2, mv = {1, 7, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DrawablePainterKt {
    private static final Lazy MAIN_HANDLER$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<Handler>() { // from class: com.bytedance.kmp.image.painter.DrawablePainterKt$MAIN_HANDLER$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Handler m674invoke() {
            return new Handler(Looper.getMainLooper());
        }
    });

    public static final Painter rememberDrawablePainter(Drawable drawable, Composer composer, int i) {
        DrawablePainter drawablePainter;
        composer.startReplaceGroup(-1533141478);
        ComposerKt.sourceInformation(composer, "C(rememberDrawablePainter)121@4282L410:DrawablePainter.kt#fqqyg8");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1533141478, i, -1, "com.bytedance.kmp.image.painter.rememberDrawablePainter (DrawablePainter.kt:121)");
        }
        composer.startReplaceGroup(655565057);
        ComposerKt.sourceInformation(composer, "CC(remember):DrawablePainter.kt#9igjgp");
        boolean changed = composer.changed(drawable);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            if (drawable == null) {
                rememberedValue = EmptyPainter.INSTANCE;
            } else {
                if (drawable instanceof BitmapDrawable) {
                    Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                    Intrinsics.checkNotNullExpressionValue(bitmap, "drawable.bitmap");
                    drawablePainter = (Painter) new BitmapPainter(AndroidImageBitmap_androidKt.asImageBitmap(bitmap), 0L, 0L, 6, (DefaultConstructorMarker) null);
                } else if (drawable instanceof ColorDrawable) {
                    drawablePainter = (Painter) new ColorPainter(ColorKt.Color(((ColorDrawable) drawable).getColor()), (DefaultConstructorMarker) null);
                } else {
                    Drawable mutate = drawable.mutate();
                    Intrinsics.checkNotNullExpressionValue(mutate, "drawable.mutate()");
                    drawablePainter = new DrawablePainter(mutate);
                }
                rememberedValue = drawablePainter;
            }
            composer.updateRememberedValue(rememberedValue);
        }
        Painter painter = (Painter) rememberedValue;
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return painter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler getMAIN_HANDLER() {
        return (Handler) MAIN_HANDLER$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long getIntrinsicSize(Drawable drawable) {
        if (drawable.getIntrinsicWidth() >= 0 && drawable.getIntrinsicHeight() >= 0) {
            float intrinsicWidth = drawable.getIntrinsicWidth();
            float intrinsicHeight = drawable.getIntrinsicHeight();
            return Size.constructor-impl((Float.floatToRawIntBits(intrinsicWidth) << 32) | (Float.floatToRawIntBits(intrinsicHeight) & 4294967295L));
        }
        return Size.Companion.getUnspecified-NH-jbRc();
    }
}
