package androidx.compose.p001ui.platform;

import android.graphics.Outline;
import android.os.Build;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.android.live.core.setting.p027v2.tools.SettingV2Monitor;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OutlineResolver.android.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J7\u0010'\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020#¢\u0006\u0004\b,\u0010-J\u0015\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020 ¢\u0006\u0004\b0\u00101J\u000e\u0010)\u001a\u0002022\u0006\u00103\u001a\u000204J\b\u00105\u001a\u000202H\u0002J\u0010\u00106\u001a\u0002022\u0006\u00107\u001a\u000208H\u0002J\u0010\u00109\u001a\u0002022\u0006\u0010:\u001a\u00020\u0014H\u0002J\u0010\u0010;\u001a\u0002022\u0006\u0010<\u001a\u00020\u000bH\u0002J-\u0010=\u001a\u00020\u0005*\u0004\u0018\u00010\u00142\u0006\u0010>\u001a\u00020 2\u0006\u0010+\u001a\u00020#2\u0006\u0010?\u001a\u00020\u0016H\u0002¢\u0006\u0004\b@\u0010AR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0004\n\u0002\u0010!R\u000e\u0010$\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Landroidx/compose/ui/platform/OutlineResolver;", "", "<init>", "()V", "isSupportedOutline", "", "cachedOutline", "Landroid/graphics/Outline;", "outline", "Landroidx/compose/ui/graphics/Outline;", "cachedRrectPath", "Landroidx/compose/ui/graphics/Path;", "outlinePath", StrategyConstants.VALUE, "cacheIsDirty", "getCacheIsDirty$ui_release", "()Z", "usePathForClip", "tmpPath", "tmpRoundRect", "Landroidx/compose/ui/geometry/RoundRect;", "roundedCornerRadius", "", "androidOutline", "getAndroidOutline", "()Landroid/graphics/Outline;", "outlineClipSupported", "getOutlineClipSupported", "clipPath", "getClipPath", "()Landroidx/compose/ui/graphics/Path;", "rectTopLeft", "Landroidx/compose/ui/geometry/Offset;", "J", "rectSize", "Landroidx/compose/ui/geometry/Size;", "outlineNeeded", "tmpTouchPointPath", "tmpOpPath", SettingV2Monitor.REPORT_TYPE_UPDATE, "alpha", "clipToOutline", "elevation", "size", "update-S_szKao", "(Landroidx/compose/ui/graphics/Outline;FZFJ)Z", "isInOutline", "position", "isInOutline-k-4lQ0M", "(J)Z", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "updateCache", "updateCacheWithRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateCacheWithRoundRect", "roundRect", "updateCacheWithPath", "composePath", "isSameBounds", "offset", "radius", "isSameBounds-4L21HEs", "(Landroidx/compose/ui/geometry/RoundRect;JJF)Z", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class OutlineResolver {
    public static final int $stable = 8;
    private boolean cacheIsDirty;
    private final Outline cachedOutline;
    private Path cachedRrectPath;
    private boolean isSupportedOutline = true;
    private androidx.compose.ui.graphics.Outline outline;
    private boolean outlineNeeded;
    private Path outlinePath;
    private long rectSize;
    private long rectTopLeft;
    private float roundedCornerRadius;
    private Path tmpOpPath;
    private Path tmpPath;
    private RoundRect tmpRoundRect;
    private Path tmpTouchPointPath;
    private boolean usePathForClip;

    public OutlineResolver() {
        Outline outline = new Outline();
        outline.setAlpha(1.0f);
        this.cachedOutline = outline;
        this.rectTopLeft = Offset.Companion.getZero-F1C5BW0();
        this.rectSize = Size.Companion.getZero-NH-jbRc();
    }

    /* renamed from: getCacheIsDirty$ui_release, reason: from getter */
    public final boolean getCacheIsDirty() {
        return this.cacheIsDirty;
    }

    public final Outline getAndroidOutline() {
        updateCache();
        if (this.outlineNeeded && this.isSupportedOutline) {
            return this.cachedOutline;
        }
        return null;
    }

    public final boolean getOutlineClipSupported() {
        return !this.usePathForClip;
    }

    public final Path getClipPath() {
        updateCache();
        return this.outlinePath;
    }

    /* renamed from: update-S_szKao, reason: not valid java name */
    public final boolean m1812updateS_szKao(androidx.compose.ui.graphics.Outline outline, float alpha, boolean clipToOutline, float elevation, long size) {
        this.cachedOutline.setAlpha(alpha);
        boolean z = !Intrinsics.areEqual(this.outline, outline);
        if (z) {
            this.outline = outline;
            this.cacheIsDirty = true;
        }
        this.rectSize = size;
        boolean z2 = outline != null && (clipToOutline || elevation > 0.0f);
        if (this.outlineNeeded != z2) {
            this.outlineNeeded = z2;
            this.cacheIsDirty = true;
        }
        return z;
    }

    /* renamed from: isInOutline-k-4lQ0M, reason: not valid java name */
    public final boolean m1811isInOutlinek4lQ0M(long position) {
        androidx.compose.ui.graphics.Outline outline;
        if (this.outlineNeeded && (outline = this.outline) != null) {
            return ShapeContainingUtilKt.isInOutline(outline, Float.intBitsToFloat((int) (position >> 32)), Float.intBitsToFloat((int) (position & 4294967295L)), this.tmpTouchPointPath, this.tmpOpPath);
        }
        return true;
    }

    public final void clipToOutline(Canvas canvas) {
        int i;
        int i2;
        Path clipPath = getClipPath();
        if (clipPath != null) {
            Canvas.clipPath-mtrdD-E$default(canvas, clipPath, 0, 2, (Object) null);
            return;
        }
        float f = this.roundedCornerRadius;
        if (f > 0.0f) {
            Path path = this.tmpPath;
            RoundRect roundRect = this.tmpRoundRect;
            if (path == null || !m1810isSameBounds4L21HEs(roundRect, this.rectTopLeft, this.rectSize, f)) {
                float intBitsToFloat = Float.intBitsToFloat((int) (this.rectTopLeft >> 32));
                float intBitsToFloat2 = Float.intBitsToFloat((int) (this.rectTopLeft & 4294967295L));
                float intBitsToFloat3 = Float.intBitsToFloat((int) (this.rectSize >> 32)) + Float.intBitsToFloat((int) (this.rectTopLeft >> 32));
                float intBitsToFloat4 = Float.intBitsToFloat((int) (this.rectSize & 4294967295L)) + Float.intBitsToFloat((int) (this.rectTopLeft & 4294967295L));
                float f2 = this.roundedCornerRadius;
                RoundRect roundRect2 = RoundRectKt.RoundRect-gG7oq9Y(intBitsToFloat, intBitsToFloat2, intBitsToFloat3, intBitsToFloat4, CornerRadius.constructor-impl((Float.floatToRawIntBits(f2) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L)));
                if (path == null) {
                    path = AndroidPath_androidKt.Path();
                } else {
                    path.reset();
                }
                i = 2;
                Path.addRoundRect$default(path, roundRect2, (Path.Direction) null, 2, (Object) null);
                this.tmpRoundRect = roundRect2;
                this.tmpPath = path;
                i2 = 0;
            } else {
                i2 = 0;
                i = 2;
            }
            Canvas.clipPath-mtrdD-E$default(canvas, path, i2, i, (Object) null);
            return;
        }
        Canvas.clipRect-N_I0leg$default(canvas, Float.intBitsToFloat((int) (this.rectTopLeft >> 32)), Float.intBitsToFloat((int) (this.rectTopLeft & 4294967295L)), Float.intBitsToFloat((int) (this.rectTopLeft >> 32)) + Float.intBitsToFloat((int) (this.rectSize >> 32)), Float.intBitsToFloat((int) (this.rectTopLeft & 4294967295L)) + Float.intBitsToFloat((int) (this.rectSize & 4294967295L)), 0, 16, (Object) null);
    }

    private final void updateCache() {
        if (this.cacheIsDirty) {
            this.rectTopLeft = Offset.Companion.getZero-F1C5BW0();
            this.roundedCornerRadius = 0.0f;
            this.outlinePath = null;
            this.cacheIsDirty = false;
            this.usePathForClip = false;
            Outline.Rectangle rectangle = this.outline;
            if (rectangle != null && this.outlineNeeded && Float.intBitsToFloat((int) (this.rectSize >> 32)) > 0.0f && Float.intBitsToFloat((int) (this.rectSize & 4294967295L)) > 0.0f) {
                this.isSupportedOutline = true;
                if (rectangle instanceof Outline.Rectangle) {
                    updateCacheWithRect(rectangle.getRect());
                    return;
                } else if (rectangle instanceof Outline.Rounded) {
                    updateCacheWithRoundRect(((Outline.Rounded) rectangle).getRoundRect());
                    return;
                } else {
                    if (!(rectangle instanceof Outline.Generic)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    updateCacheWithPath(((Outline.Generic) rectangle).getPath());
                    return;
                }
            }
            this.cachedOutline.setEmpty();
        }
    }

    private final void updateCacheWithRect(Rect rect) {
        float left = rect.getLeft();
        float top = rect.getTop();
        this.rectTopLeft = Offset.constructor-impl((Float.floatToRawIntBits(top) & 4294967295L) | (Float.floatToRawIntBits(left) << 32));
        float right = rect.getRight() - rect.getLeft();
        float bottom = rect.getBottom() - rect.getTop();
        this.rectSize = Size.constructor-impl((Float.floatToRawIntBits(bottom) & 4294967295L) | (Float.floatToRawIntBits(right) << 32));
        this.cachedOutline.setRect(Math.round(rect.getLeft()), Math.round(rect.getTop()), Math.round(rect.getRight()), Math.round(rect.getBottom()));
    }

    private final void updateCacheWithRoundRect(RoundRect roundRect) {
        float intBitsToFloat = Float.intBitsToFloat((int) (roundRect.getTopLeftCornerRadius-kKHJgLs() >> 32));
        float left = roundRect.getLeft();
        float top = roundRect.getTop();
        this.rectTopLeft = Offset.constructor-impl((Float.floatToRawIntBits(left) << 32) | (Float.floatToRawIntBits(top) & 4294967295L));
        float width = roundRect.getWidth();
        float height = roundRect.getHeight();
        this.rectSize = Size.constructor-impl((Float.floatToRawIntBits(width) << 32) | (Float.floatToRawIntBits(height) & 4294967295L));
        if (RoundRectKt.isSimple(roundRect)) {
            this.cachedOutline.setRoundRect(Math.round(roundRect.getLeft()), Math.round(roundRect.getTop()), Math.round(roundRect.getRight()), Math.round(roundRect.getBottom()), intBitsToFloat);
            this.roundedCornerRadius = intBitsToFloat;
            return;
        }
        Path path = this.cachedRrectPath;
        if (path == null) {
            path = AndroidPath_androidKt.Path();
            this.cachedRrectPath = path;
        }
        path.reset();
        Path.addRoundRect$default(path, roundRect, (Path.Direction) null, 2, (Object) null);
        updateCacheWithPath(path);
    }

    private final void updateCacheWithPath(Path composePath) {
        if (Build.VERSION.SDK_INT > 28 || composePath.isConvex()) {
            if (Build.VERSION.SDK_INT >= 30) {
                OutlineVerificationHelper.INSTANCE.setPath(this.cachedOutline, composePath);
            } else {
                android.graphics.Outline outline = this.cachedOutline;
                if (composePath instanceof AndroidPath) {
                    outline.setConvexPath(((AndroidPath) composePath).getInternalPath());
                } else {
                    throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
                }
            }
            this.usePathForClip = !this.cachedOutline.canClip();
        } else {
            this.isSupportedOutline = false;
            this.cachedOutline.setEmpty();
            this.usePathForClip = true;
        }
        this.outlinePath = composePath;
    }

    /* renamed from: isSameBounds-4L21HEs, reason: not valid java name */
    private final boolean m1810isSameBounds4L21HEs(RoundRect roundRect, long j, long j2, float f) {
        if (roundRect == null || !RoundRectKt.isSimple(roundRect)) {
            return false;
        }
        int i = (int) (j >> 32);
        if (!(roundRect.getLeft() == Float.intBitsToFloat(i))) {
            return false;
        }
        int i2 = (int) (j & 4294967295L);
        if (!(roundRect.getTop() == Float.intBitsToFloat(i2))) {
            return false;
        }
        if (!(roundRect.getRight() == Float.intBitsToFloat(i) + Float.intBitsToFloat((int) (j2 >> 32)))) {
            return false;
        }
        if (roundRect.getBottom() == Float.intBitsToFloat(i2) + Float.intBitsToFloat((int) (j2 & 4294967295L))) {
            return (Float.intBitsToFloat((int) (roundRect.getTopLeftCornerRadius-kKHJgLs() >> 32)) > f ? 1 : (Float.intBitsToFloat((int) (roundRect.getTopLeftCornerRadius-kKHJgLs() >> 32)) == f ? 0 : -1)) == 0;
        }
        return false;
    }
}
