package androidx.compose.p002ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.graphics.ColorFilter;
import androidx.compose.p002ui.graphics.drawscope.DrawContext;
import androidx.compose.p002ui.graphics.drawscope.DrawScope;
import androidx.compose.p002ui.graphics.painter.Painter;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: VectorPainter.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\f\u0010A\u001a\u00020B*\u00020CH\u0014J\u0010\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020<H\u0014J\u0012\u0010F\u001a\u00020\u000f2\b\u0010G\u001a\u0004\u0018\u00010\u0017H\u0014R+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f8@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u00178@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00078@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\n\"\u0004\b\u001f\u0010\fR$\u0010!\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020 8@@@X\u0080\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R+\u00105\u001a\u0002042\u0006\u0010\u0006\u001a\u0002048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b6\u0010-\"\u0004\b7\u00108R\u000e\u0010;\u001a\u00020<X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\nR\u000e\u0010@\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006H"}, d2 = {"Landroidx/compose/ui/graphics/vector/VectorPainter;", "Landroidx/compose/ui/graphics/painter/Painter;", "root", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "<init>", "(Landroidx/compose/ui/graphics/vector/GroupComponent;)V", "<set-?>", "Landroidx/compose/ui/geometry/Size;", "size", "getSize-NH-jbRc$ui_release", "()J", "setSize-uvyYCjk$ui_release", "(J)V", "size$delegate", "Landroidx/compose/runtime/MutableState;", "", "autoMirror", "getAutoMirror$ui_release", "()Z", "setAutoMirror$ui_release", "(Z)V", "autoMirror$delegate", "value", "Landroidx/compose/ui/graphics/ColorFilter;", "intrinsicColorFilter", "getIntrinsicColorFilter$ui_release", "()Landroidx/compose/ui/graphics/ColorFilter;", "setIntrinsicColorFilter$ui_release", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "viewportSize", "getViewportSize-NH-jbRc$ui_release", "setViewportSize-uvyYCjk$ui_release", "", HintConstants.AUTOFILL_HINT_NAME, "getName$ui_release", "()Ljava/lang/String;", "setName$ui_release", "(Ljava/lang/String;)V", "vector", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "getVector$ui_release", "()Landroidx/compose/ui/graphics/vector/VectorComponent;", "bitmapConfig", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getBitmapConfig-_sVssgQ$ui_release", "()I", "composition", "Landroidx/compose/runtime/Composition;", "getComposition$ui_release", "()Landroidx/compose/runtime/Composition;", "setComposition$ui_release", "(Landroidx/compose/runtime/Composition;)V", "", "invalidateCount", "getInvalidateCount", "setInvalidateCount", "(I)V", "invalidateCount$delegate", "Landroidx/compose/runtime/MutableIntState;", "currentAlpha", "", "currentColorFilter", "intrinsicSize", "getIntrinsicSize-NH-jbRc", "drawCount", "onDraw", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "applyAlpha", "alpha", "applyColorFilter", "colorFilter", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class VectorPainter extends Painter {
    public static final int $stable = 8;

    /* renamed from: autoMirror$delegate, reason: from kotlin metadata */
    private final MutableState autoMirror;
    private Composition composition;
    private float currentAlpha;
    private ColorFilter currentColorFilter;
    private int drawCount;

    /* renamed from: invalidateCount$delegate, reason: from kotlin metadata */
    private final MutableIntState invalidateCount;

    /* renamed from: size$delegate, reason: from kotlin metadata */
    private final MutableState size;
    private final VectorComponent vector;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public VectorPainter() {
        this(r0, 1, r0);
        GroupComponent groupComponent = null;
    }

    public VectorPainter(GroupComponent groupComponent) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m4650boximpl(Size.INSTANCE.m4671getZeroNHjbRc()), null, 2, null);
        this.size = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
        this.autoMirror = mutableStateOf$default2;
        VectorComponent vectorComponent = new VectorComponent(groupComponent);
        vectorComponent.setInvalidateCallback$ui_release(new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$vector$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m5602invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m5602invoke() {
                int i;
                int invalidateCount;
                int invalidateCount2;
                i = VectorPainter.this.drawCount;
                invalidateCount = VectorPainter.this.getInvalidateCount();
                if (i == invalidateCount) {
                    invalidateCount2 = VectorPainter.this.getInvalidateCount();
                    VectorPainter.this.setInvalidateCount(invalidateCount2 + 1);
                }
            }
        });
        this.vector = vectorComponent;
        this.invalidateCount = SnapshotIntStateKt.mutableIntStateOf(0);
        this.currentAlpha = 1.0f;
        this.drawCount = -1;
    }

    public /* synthetic */ VectorPainter(GroupComponent groupComponent, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new GroupComponent() : groupComponent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSize-NH-jbRc$ui_release, reason: not valid java name */
    public final long m5598getSizeNHjbRc$ui_release() {
        return ((Size) this.size.getValue()).m4667unboximpl();
    }

    /* renamed from: setSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m5600setSizeuvyYCjk$ui_release(long j) {
        this.size.setValue(Size.m4650boximpl(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getAutoMirror$ui_release() {
        return ((Boolean) this.autoMirror.getValue()).booleanValue();
    }

    public final void setAutoMirror$ui_release(boolean z) {
        this.autoMirror.setValue(Boolean.valueOf(z));
    }

    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return this.vector.getIntrinsicColorFilter$ui_release();
    }

    public final void setIntrinsicColorFilter$ui_release(ColorFilter colorFilter) {
        this.vector.setIntrinsicColorFilter$ui_release(colorFilter);
    }

    /* renamed from: getViewportSize-NH-jbRc$ui_release, reason: not valid java name */
    public final long m5599getViewportSizeNHjbRc$ui_release() {
        return this.vector.m5586getViewportSizeNHjbRc$ui_release();
    }

    /* renamed from: setViewportSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m5601setViewportSizeuvyYCjk$ui_release(long j) {
        this.vector.m5587setViewportSizeuvyYCjk$ui_release(j);
    }

    public final String getName$ui_release() {
        return this.vector.getName();
    }

    public final void setName$ui_release(String str) {
        this.vector.setName(str);
    }

    /* renamed from: getVector$ui_release, reason: from getter */
    public final VectorComponent getVector() {
        return this.vector;
    }

    /* renamed from: getBitmapConfig-_sVssgQ$ui_release, reason: not valid java name */
    public final int m5597getBitmapConfig_sVssgQ$ui_release() {
        return this.vector.m5585getCacheBitmapConfig_sVssgQ$ui_release();
    }

    /* renamed from: getComposition$ui_release, reason: from getter */
    public final Composition getComposition() {
        return this.composition;
    }

    public final void setComposition$ui_release(Composition composition) {
        this.composition = composition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getInvalidateCount() {
        return this.invalidateCount.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInvalidateCount(int i) {
        this.invalidateCount.setIntValue(i);
    }

    @Override // androidx.compose.p002ui.graphics.painter.Painter
    /* renamed from: getIntrinsicSize-NH-jbRc */
    public long getIntrinsicSize() {
        return m5598getSizeNHjbRc$ui_release();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.p002ui.graphics.painter.Painter
    public void onDraw(DrawScope drawScope) {
        VectorComponent vectorComponent = this.vector;
        ColorFilter colorFilter = this.currentColorFilter;
        if (colorFilter == null) {
            colorFilter = vectorComponent.getIntrinsicColorFilter$ui_release();
        }
        if (!getAutoMirror$ui_release() || drawScope.getLayoutDirection() != LayoutDirection.Rtl) {
            vectorComponent.draw(drawScope, this.currentAlpha, colorFilter);
        } else {
            long m5416getCenterF1C5BW0 = drawScope.m5416getCenterF1C5BW0();
            DrawContext drawContext = drawScope.getDrawContext();
            long mo5338getSizeNHjbRc = drawContext.mo5338getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo5345scale0AR0LA0(-1.0f, 1.0f, m5416getCenterF1C5BW0);
                vectorComponent.draw(drawScope, this.currentAlpha, colorFilter);
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo5339setSizeuvyYCjk(mo5338getSizeNHjbRc);
            }
        }
        this.drawCount = getInvalidateCount();
    }

    @Override // androidx.compose.p002ui.graphics.painter.Painter
    protected boolean applyAlpha(float alpha) {
        this.currentAlpha = alpha;
        return true;
    }

    @Override // androidx.compose.p002ui.graphics.painter.Painter
    protected boolean applyColorFilter(ColorFilter colorFilter) {
        this.currentColorFilter = colorFilter;
        return true;
    }
}
