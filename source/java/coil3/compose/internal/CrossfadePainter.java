package coil3.compose.internal;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.ScaleFactorKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;

/* compiled from: CrossfadePainter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u0001B;\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\f\u0010,\u001a\u00020-*\u00020.H\u0014J\u0010\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\u0018H\u0014J\u0012\u00101\u001a\u00020\t2\b\u0010!\u001a\u0004\u0018\u00010 H\u0014J\u000f\u00102\u001a\u00020)H\u0002¢\u0006\u0004\b3\u0010+J\u001e\u00104\u001a\u00020-*\u00020.2\b\u00105\u001a\u0004\u0018\u00010\u00012\u0006\u00100\u001a\u00020\u0018H\u0002J\u001f\u00106\u001a\u00020)2\u0006\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020)H\u0002¢\u0006\u0004\b9\u0010:R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00078B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u00188B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR/\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\r\u001a\u0004\u0018\u00010 8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u0006;"}, d2 = {"Lcoil3/compose/internal/CrossfadePainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "start", "end", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "durationMillis", "", "fadeStart", "", "preferExactIntrinsicSize", "<init>", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/layout/ContentScale;IZZ)V", "<set-?>", "invalidateTick", "getInvalidateTick", "()I", "setInvalidateTick", "(I)V", "invalidateTick$delegate", "Landroidx/compose/runtime/MutableIntState;", "startTime", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "isDone", "", "maxAlpha", "getMaxAlpha", "()F", "setMaxAlpha", "(F)V", "maxAlpha$delegate", "Landroidx/compose/runtime/MutableFloatState;", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "colorFilter$delegate", "Landroidx/compose/runtime/MutableState;", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "alpha", "applyColorFilter", "computeIntrinsicSize", "computeIntrinsicSize-NH-jbRc", "drawPainter", "painter", "computeDrawSize", "srcSize", "dstSize", "computeDrawSize-x8L_9b0", "(JJ)J", "coil-compose-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class CrossfadePainter extends Painter {
    public static final int $stable = 0;
    private final ContentScale contentScale;
    private final int durationMillis;
    private final Painter end;
    private final boolean fadeStart;
    private boolean isDone;
    private final boolean preferExactIntrinsicSize;
    private Painter start;
    private TimeSource.Monotonic.ValueTimeMark startTime;

    /* renamed from: invalidateTick$delegate, reason: from kotlin metadata */
    private final MutableIntState invalidateTick = SnapshotIntStateKt.mutableIntStateOf(0);

    /* renamed from: maxAlpha$delegate, reason: from kotlin metadata */
    private final MutableFloatState maxAlpha = PrimitiveSnapshotStateKt.mutableFloatStateOf(1.0f);

    /* renamed from: colorFilter$delegate, reason: from kotlin metadata */
    private final MutableState colorFilter = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);

    public CrossfadePainter(Painter painter, Painter painter2, ContentScale contentScale, int i, boolean z, boolean z2) {
        this.start = painter;
        this.end = painter2;
        this.contentScale = contentScale;
        this.durationMillis = i;
        this.fadeStart = z;
        this.preferExactIntrinsicSize = z2;
    }

    private final int getInvalidateTick() {
        return this.invalidateTick.getIntValue();
    }

    private final void setInvalidateTick(int i) {
        this.invalidateTick.setIntValue(i);
    }

    private final float getMaxAlpha() {
        return this.maxAlpha.getFloatValue();
    }

    private final void setMaxAlpha(float f) {
        this.maxAlpha.setFloatValue(f);
    }

    private final ColorFilter getColorFilter() {
        return (ColorFilter) this.colorFilter.getValue();
    }

    private final void setColorFilter(ColorFilter colorFilter) {
        this.colorFilter.setValue(colorFilter);
    }

    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long m3214getIntrinsicSizeNHjbRc() {
        return m3213computeIntrinsicSizeNHjbRc();
    }

    protected void onDraw(DrawScope drawScope) {
        long j;
        if (this.isDone) {
            drawPainter(drawScope, this.end, getMaxAlpha());
            return;
        }
        TimeSource.Monotonic.ValueTimeMark valueTimeMark = this.startTime;
        if (valueTimeMark != null) {
            j = valueTimeMark.unbox-impl();
        } else {
            j = TimeSource.Monotonic.INSTANCE.markNow-z9LOYto();
            this.startTime = TimeSource.Monotonic.ValueTimeMark.box-impl(j);
        }
        float f = ((float) Duration.getInWholeMilliseconds-impl(TimeSource.Monotonic.ValueTimeMark.elapsedNow-UwyO8pc(j))) / this.durationMillis;
        float coerceIn = RangesKt.coerceIn(f, 0.0f, 1.0f) * getMaxAlpha();
        float maxAlpha = this.fadeStart ? getMaxAlpha() - coerceIn : getMaxAlpha();
        this.isDone = f >= 1.0f;
        drawPainter(drawScope, this.start, maxAlpha);
        drawPainter(drawScope, this.end, coerceIn);
        if (this.isDone) {
            this.start = null;
        } else {
            setInvalidateTick(getInvalidateTick() + 1);
        }
    }

    protected boolean applyAlpha(float alpha) {
        setMaxAlpha(alpha);
        return true;
    }

    protected boolean applyColorFilter(ColorFilter colorFilter) {
        setColorFilter(colorFilter);
        return true;
    }

    /* renamed from: computeIntrinsicSize-NH-jbRc, reason: not valid java name */
    private final long m3213computeIntrinsicSizeNHjbRc() {
        Painter painter = this.start;
        long j = painter != null ? painter.getIntrinsicSize-NH-jbRc() : Size.Companion.getZero-NH-jbRc();
        Painter painter2 = this.end;
        long j2 = painter2 != null ? painter2.getIntrinsicSize-NH-jbRc() : Size.Companion.getZero-NH-jbRc();
        boolean z = j != Size.Companion.getUnspecified-NH-jbRc();
        boolean z2 = j2 != Size.Companion.getUnspecified-NH-jbRc();
        if (z && z2) {
            return SizeKt.Size(Math.max(Size.getWidth-impl(j), Size.getWidth-impl(j2)), Math.max(Size.getHeight-impl(j), Size.getHeight-impl(j2)));
        }
        if (this.preferExactIntrinsicSize) {
            if (z) {
                return j;
            }
            if (z2) {
                return j2;
            }
        }
        return Size.Companion.getUnspecified-NH-jbRc();
    }

    private final void drawPainter(DrawScope drawScope, Painter painter, float f) {
        if (painter == null || f <= 0.0f) {
            return;
        }
        long j = drawScope.getSize-NH-jbRc();
        long m3212computeDrawSizex8L_9b0 = m3212computeDrawSizex8L_9b0(painter.getIntrinsicSize-NH-jbRc(), j);
        if ((j == Size.Companion.getUnspecified-NH-jbRc()) || Size.isEmpty-impl(j)) {
            painter.draw-x_KDEd0(drawScope, m3212computeDrawSizex8L_9b0, f, getColorFilter());
            return;
        }
        float f2 = 2;
        float f3 = (Size.getWidth-impl(j) - Size.getWidth-impl(m3212computeDrawSizex8L_9b0)) / f2;
        float f4 = (Size.getHeight-impl(j) - Size.getHeight-impl(m3212computeDrawSizex8L_9b0)) / f2;
        drawScope.getDrawContext().getTransform().inset(f3, f4, f3, f4);
        painter.draw-x_KDEd0(drawScope, m3212computeDrawSizex8L_9b0, f, getColorFilter());
        float f5 = -f3;
        float f6 = -f4;
        drawScope.getDrawContext().getTransform().inset(f5, f6, f5, f6);
    }

    /* renamed from: computeDrawSize-x8L_9b0, reason: not valid java name */
    private final long m3212computeDrawSizex8L_9b0(long srcSize, long dstSize) {
        if (!(srcSize == Size.Companion.getUnspecified-NH-jbRc()) && !Size.isEmpty-impl(srcSize)) {
            if (!(dstSize == Size.Companion.getUnspecified-NH-jbRc()) && !Size.isEmpty-impl(dstSize)) {
                return ScaleFactorKt.times-UQTWf7w(srcSize, this.contentScale.computeScaleFactor-H7hwNQA(srcSize, dstSize));
            }
        }
        return dstSize;
    }
}
