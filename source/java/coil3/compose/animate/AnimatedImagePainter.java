package coil3.compose.animate;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Animatable2;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Trace;
import androidx.compose.p001ui.unit.LayoutDirection;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil3.DrawableImage;
import coil3.compose.ImagePainter_androidKt;
import coil3.size.ScaleDrawable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: AnimatedImagePainter.android.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000*\u0002\u001f%\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u000201H\u0016J\b\u00103\u001a\u000201H\u0016J\u0010\u00104\u001a\u0002012\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u00105\u001a\u00020\u001d2\u0006\u00106\u001a\u000207H\u0014J\u0012\u00108\u001a\u00020\u001d2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020=H\u0014J\f\u0010>\u001a\u000201*\u00020?H\u0014J\b\u0010@\u001a\u000201H\u0016J\b\u0010A\u001a\u000201H\u0016J\b\u0010B\u001a\u00020\u001dH\u0016J\u0010\u0010C\u001a\u0002012\u0006\u0010D\u001a\u00020\rH\u0016J\u0018\u0010C\u001a\u0002012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\rH\u0002J\u0010\u0010E\u001a\u0002012\u0006\u0010F\u001a\u00020GH\u0016J\u0018\u0010E\u001a\u0002012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020GH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R+\u0010\u0016\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\u00158B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b \u0010!R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b(\u0010#\u001a\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u0018R\u001b\u0010+\u001a\u00020,8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010#\u001a\u0004\b-\u0010.¨\u0006H"}, d2 = {"Lcoil3/compose/animate/AnimatedImagePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "Landroidx/compose/runtime/RememberObserver;", "Lcoil3/compose/animate/AnimationController;", "image", "Lcoil3/DrawableImage;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lcoil3/DrawableImage;Lkotlin/coroutines/CoroutineContext;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "<set-?>", "", "drawInvalidateTick", "getDrawInvalidateTick", "()I", "setDrawInvalidateTick", "(I)V", "drawInvalidateTick$delegate", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/geometry/Size;", "drawableIntrinsicSize", "getDrawableIntrinsicSize-NH-jbRc", "()J", "setDrawableIntrinsicSize-uvyYCjk", "(J)V", "drawableIntrinsicSize$delegate", "hasDrawn", "", "animation2Callback", "coil3/compose/animate/AnimatedImagePainter$animation2Callback$2$1", "getAnimation2Callback", "()Lcoil3/compose/animate/AnimatedImagePainter$animation2Callback$2$1;", "animation2Callback$delegate", "Lkotlin/Lazy;", "animation2CompatCallback", "coil3/compose/animate/AnimatedImagePainter$animation2CompatCallback$2$1", "getAnimation2CompatCallback", "()Lcoil3/compose/animate/AnimatedImagePainter$animation2CompatCallback$2$1;", "animation2CompatCallback$delegate", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "callback", "Landroid/graphics/drawable/Drawable$Callback;", "getCallback", "()Landroid/graphics/drawable/Drawable$Callback;", "callback$delegate", "onRemembered", "", "onAbandoned", "onForgotten", "unregisterAnimationCallback", "applyAlpha", "alpha", "", "applyColorFilter", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "applyLayoutDirection", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "onDraw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "start", "stop", "isRunning", "setRepeatCount", "count", "setAnimateListener", "listener", "Lcoil3/compose/animate/AnimatedImageListener;", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnimatedImagePainter extends Painter implements RememberObserver, AnimationController {
    public static final int $stable = 0;

    /* renamed from: animation2Callback$delegate, reason: from kotlin metadata */
    private final Lazy animation2Callback;

    /* renamed from: animation2CompatCallback$delegate, reason: from kotlin metadata */
    private final Lazy animation2CompatCallback;

    /* renamed from: callback$delegate, reason: from kotlin metadata */
    private final Lazy callback;

    /* renamed from: drawInvalidateTick$delegate, reason: from kotlin metadata */
    private final MutableState drawInvalidateTick;
    private final Drawable drawable;

    /* renamed from: drawableIntrinsicSize$delegate, reason: from kotlin metadata */
    private final MutableState drawableIntrinsicSize;
    private boolean hasDrawn;
    private final DrawableImage image;

    /* compiled from: AnimatedImagePainter.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AnimatedImagePainter(DrawableImage drawableImage, CoroutineContext coroutineContext) {
        long intrinsicSize;
        this.image = drawableImage;
        Drawable drawable = drawableImage.getDrawable();
        this.drawable = drawable;
        this.drawInvalidateTick = SnapshotStateKt.mutableStateOf$default(0, (SnapshotMutationPolicy) null, 2, (Object) null);
        intrinsicSize = AnimatedImagePainter_androidKt.getIntrinsicSize(drawable);
        this.drawableIntrinsicSize = SnapshotStateKt.mutableStateOf$default(Size.box-impl(intrinsicSize), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.animation2Callback = LazyKt.lazy(new Function0() { // from class: coil3.compose.animate.AnimatedImagePainter$$ExternalSyntheticLambda0
            public final Object invoke() {
                AnimatedImagePainter$animation2Callback$2$1 animation2Callback_delegate$lambda$0;
                animation2Callback_delegate$lambda$0 = AnimatedImagePainter.animation2Callback_delegate$lambda$0();
                return animation2Callback_delegate$lambda$0;
            }
        });
        this.animation2CompatCallback = LazyKt.lazy(new Function0() { // from class: coil3.compose.animate.AnimatedImagePainter$$ExternalSyntheticLambda1
            public final Object invoke() {
                AnimatedImagePainter$animation2CompatCallback$2$1 animation2CompatCallback_delegate$lambda$1;
                animation2CompatCallback_delegate$lambda$1 = AnimatedImagePainter.animation2CompatCallback_delegate$lambda$1();
                return animation2CompatCallback_delegate$lambda$1;
            }
        });
        this.callback = LazyKt.lazy(new Function0() { // from class: coil3.compose.animate.AnimatedImagePainter$$ExternalSyntheticLambda2
            public final Object invoke() {
                AnimatedImagePainter$callback$2$1 callback_delegate$lambda$2;
                callback_delegate$lambda$2 = AnimatedImagePainter.callback_delegate$lambda$2(AnimatedImagePainter.this);
                return callback_delegate$lambda$2;
            }
        });
        if (drawable.getIntrinsicWidth() < 0 || drawable.getIntrinsicHeight() < 0) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getDrawInvalidateTick() {
        return ((Number) this.drawInvalidateTick.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDrawInvalidateTick(int i) {
        this.drawInvalidateTick.setValue(Integer.valueOf(i));
    }

    /* renamed from: getDrawableIntrinsicSize-NH-jbRc, reason: not valid java name */
    private final long m3207getDrawableIntrinsicSizeNHjbRc() {
        return ((Size) this.drawableIntrinsicSize.getValue()).unbox-impl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDrawableIntrinsicSize-uvyYCjk, reason: not valid java name */
    public final void m3208setDrawableIntrinsicSizeuvyYCjk(long j) {
        this.drawableIntrinsicSize.setValue(Size.box-impl(j));
    }

    private final AnimatedImagePainter$animation2Callback$2$1 getAnimation2Callback() {
        return (AnimatedImagePainter$animation2Callback$2$1) this.animation2Callback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimatedImagePainter$animation2Callback$2$1 animation2Callback_delegate$lambda$0() {
        return new AnimatedImagePainter$animation2Callback$2$1();
    }

    private final AnimatedImagePainter$animation2CompatCallback$2$1 getAnimation2CompatCallback() {
        return (AnimatedImagePainter$animation2CompatCallback$2$1) this.animation2CompatCallback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimatedImagePainter$animation2CompatCallback$2$1 animation2CompatCallback_delegate$lambda$1() {
        return new AnimatedImagePainter$animation2CompatCallback$2$1();
    }

    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long m3209getIntrinsicSizeNHjbRc() {
        return m3207getDrawableIntrinsicSizeNHjbRc();
    }

    private final Drawable.Callback getCallback() {
        return (Drawable.Callback) this.callback.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [coil3.compose.animate.AnimatedImagePainter$callback$2$1] */
    public static final AnimatedImagePainter$callback$2$1 callback_delegate$lambda$2(final AnimatedImagePainter animatedImagePainter) {
        return new Drawable.Callback() { // from class: coil3.compose.animate.AnimatedImagePainter$callback$2$1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable d) {
                int drawInvalidateTick;
                Drawable drawable;
                long intrinsicSize;
                drawInvalidateTick = AnimatedImagePainter.this.getDrawInvalidateTick();
                AnimatedImagePainter.this.setDrawInvalidateTick(drawInvalidateTick + 1);
                AnimatedImagePainter animatedImagePainter2 = AnimatedImagePainter.this;
                drawable = animatedImagePainter2.drawable;
                intrinsicSize = AnimatedImagePainter_androidKt.getIntrinsicSize(drawable);
                animatedImagePainter2.m3208setDrawableIntrinsicSizeuvyYCjk(intrinsicSize);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable d, Runnable what, long time) {
                Handler main_handler;
                main_handler = AnimatedImagePainter_androidKt.getMAIN_HANDLER();
                main_handler.postAtTime(what, time);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable d, Runnable what) {
                Handler main_handler;
                main_handler = AnimatedImagePainter_androidKt.getMAIN_HANDLER();
                main_handler.removeCallbacks(what);
            }
        };
    }

    public void onRemembered() {
        this.drawable.setCallback(getCallback());
        this.drawable.setVisible(true, true);
        Object obj = this.drawable;
        if (obj instanceof Animatable) {
            ((Animatable) obj).start();
        }
    }

    public void onAbandoned() {
        onForgotten();
    }

    public void onForgotten() {
        Handler main_handler;
        Object obj = this.drawable;
        if (obj instanceof Animatable) {
            ((Animatable) obj).stop();
        }
        main_handler = AnimatedImagePainter_androidKt.getMAIN_HANDLER();
        main_handler.post(new Runnable() { // from class: coil3.compose.animate.AnimatedImagePainter$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                AnimatedImagePainter.onForgotten$lambda$3(AnimatedImagePainter.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onForgotten$lambda$3(AnimatedImagePainter animatedImagePainter) {
        animatedImagePainter.unregisterAnimationCallback(animatedImagePainter.drawable);
        animatedImagePainter.drawable.setVisible(false, false);
        animatedImagePainter.drawable.setCallback(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void unregisterAnimationCallback(Drawable drawable) {
        if (drawable instanceof Animatable2Compat) {
            getAnimation2CompatCallback().setListener(null);
            ((Animatable2Compat) drawable).unregisterAnimationCallback(getAnimation2CompatCallback());
        } else if (drawable instanceof Animatable2) {
            getAnimation2Callback().setListener(null);
            ((Animatable2) drawable).unregisterAnimationCallback(getAnimation2Callback());
        } else if (drawable instanceof ScaleDrawable) {
            unregisterAnimationCallback(((ScaleDrawable) drawable).getChild());
        } else {
            CoilImageLog.INSTANCE.info("unregisterAnimationCallback fail : type " + Reflection.getOrCreateKotlinClass(drawable.getClass().getClass()).getSimpleName() + " mismatch");
        }
    }

    protected boolean applyAlpha(float alpha) {
        this.drawable.setAlpha(RangesKt.coerceIn(MathKt.roundToInt(alpha * 255), 0, 255));
        return true;
    }

    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.drawable.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.asAndroidColorFilter(colorFilter) : null);
        return true;
    }

    protected boolean applyLayoutDirection(LayoutDirection layoutDirection) {
        Drawable drawable = this.drawable;
        int i = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i2 = 1;
        if (i == 1) {
            i2 = 0;
        } else if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return drawable.setLayoutDirection(i2);
    }

    @Override // coil3.compose.animate.AnimationController
    public void start() {
        Object obj = this.drawable;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // coil3.compose.animate.AnimationController
    public void stop() {
        Object obj = this.drawable;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // coil3.compose.animate.AnimationController
    public boolean isRunning() {
        Object obj = this.drawable;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            return animatable.isRunning();
        }
        return false;
    }

    @Override // coil3.compose.animate.RepeatableAnimation
    public void setRepeatCount(int count) {
        Drawable drawable = this.drawable;
        if (drawable instanceof ScaleDrawable) {
            setRepeatCount(((ScaleDrawable) drawable).getChild(), count);
        } else {
            setRepeatCount(drawable, count);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setRepeatCount(Drawable drawable, int count) {
        boolean z;
        if (drawable instanceof AnimationController) {
            ((AnimationController) drawable).setRepeatCount(count);
            return;
        }
        if (drawable instanceof RepeatableAnimation) {
            ((RepeatableAnimation) drawable).setRepeatCount(count);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28 && ((z = drawable instanceof AnimatedImageDrawable))) {
            AnimatedImageDrawable animatedImageDrawable = z ? (AnimatedImageDrawable) drawable : null;
            if (animatedImageDrawable != null) {
                animatedImageDrawable.setRepeatCount(count);
                return;
            }
            return;
        }
        CoilImageLog.INSTANCE.info("setRepeatCount fail : type " + Reflection.getOrCreateKotlinClass(drawable.getClass().getClass()).getSimpleName() + " mismatch");
    }

    @Override // coil3.compose.animate.AnimationController
    public void setAnimateListener(AnimatedImageListener listener) {
        Drawable drawable = this.drawable;
        if (drawable instanceof ScaleDrawable) {
            setAnimateListener(((ScaleDrawable) drawable).getChild(), listener);
        } else {
            setAnimateListener(drawable, listener);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setAnimateListener(Drawable drawable, AnimatedImageListener listener) {
        if (drawable instanceof Animatable2Compat) {
            getAnimation2CompatCallback().setListener(listener);
            ((Animatable2Compat) drawable).registerAnimationCallback(getAnimation2CompatCallback());
        } else if (drawable instanceof Animatable2) {
            getAnimation2Callback().setListener(listener);
            ((Animatable2) drawable).registerAnimationCallback(getAnimation2Callback());
        } else {
            CoilImageLog.INSTANCE.info("setAnimateListener fail : type " + Reflection.getOrCreateKotlinClass(drawable.getClass().getClass()).getSimpleName() + " mismatch");
        }
    }

    protected void onDraw(DrawScope drawScope) {
        Trace.beginSection("AnimatedImagePainter.onDraw");
        try {
            Canvas canvas = drawScope.getDrawContext().getCanvas();
            getDrawInvalidateTick();
            this.drawable.setBounds(0, 0, MathKt.roundToInt(Size.getWidth-impl(drawScope.getSize-NH-jbRc())), MathKt.roundToInt(Size.getHeight-impl(drawScope.getSize-NH-jbRc())));
            try {
                canvas.save();
                this.drawable.draw(ImagePainter_androidKt.getNativeCanvas(canvas));
                canvas.restore();
                if (!this.hasDrawn) {
                    this.hasDrawn = true;
                    if (getAnimation2Callback().getListener() != null) {
                        getAnimation2Callback().onAnimateImageFirstDraw();
                    }
                    if (getAnimation2CompatCallback().getListener() != null) {
                        getAnimation2CompatCallback().onAnimateImageFirstDraw();
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                canvas.restore();
                throw th;
            }
        } finally {
            Trace.endSection();
        }
    }
}
