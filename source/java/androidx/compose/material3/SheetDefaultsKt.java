package androidx.compose.material3;

import androidx.autofill.HintConstants;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.OffsetKt;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.p002ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: SheetDefaults.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\nH\u0000\u001aA\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00120\n2\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0012H\u0001¢\u0006\u0002\u0010\u0017\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0018"}, d2 = {"DragHandleVerticalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "sheetState", "Landroidx/compose/material3/SheetState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "onFling", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "velocity", "", "rememberSheetState", "skipPartiallyExpanded", "", "confirmValueChange", "Landroidx/compose/material3/SheetValue;", "initialValue", "skipHiddenState", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/material3/SheetValue;ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/SheetState;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SheetDefaultsKt {
    private static final float DragHandleVerticalPadding = Dp.constructor-impl(22);

    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(final SheetState sheetState, final Orientation orientation, final Function1<? super Float, Unit> function1) {
        return new NestedScrollConnection() { // from class: androidx.compose.material3.SheetDefaultsKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1
            @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
            /* renamed from: onPreScroll-OzD1aCk */
            public long mo1159onPreScrollOzD1aCk(long available, int source) {
                float offsetToFloat = offsetToFloat(available);
                if (offsetToFloat < 0.0f && NestedScrollSource.m6020equalsimpl0(source, NestedScrollSource.INSTANCE.m6028getDragWNlRxjI())) {
                    return toOffset(SheetState.this.getAnchoredDraggableState$material3_release().dispatchRawDelta(offsetToFloat));
                }
                return Offset.INSTANCE.m4609getZeroF1C5BW0();
            }

            @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
            /* renamed from: onPostScroll-DzOQY0M */
            public long mo777onPostScrollDzOQY0M(long consumed, long available, int source) {
                if (NestedScrollSource.m6020equalsimpl0(source, NestedScrollSource.INSTANCE.m6028getDragWNlRxjI())) {
                    return toOffset(SheetState.this.getAnchoredDraggableState$material3_release().dispatchRawDelta(offsetToFloat(available)));
                }
                return Offset.INSTANCE.m4609getZeroF1C5BW0();
            }

            @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
            /* renamed from: onPreFling-QWom1Mo */
            public Object mo1158onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
                float velocityToFloat = velocityToFloat(j);
                float requireOffset = SheetState.this.requireOffset();
                float minAnchor = SheetState.this.getAnchoredDraggableState$material3_release().getAnchors().minAnchor();
                if (velocityToFloat < 0.0f && requireOffset > minAnchor) {
                    function1.invoke(Boxing.boxFloat(velocityToFloat));
                } else {
                    j = Velocity.Companion.getZero-9UxMQ8M();
                }
                return Velocity.box-impl(j);
            }

            @Override // androidx.compose.p002ui.input.nestedscroll.NestedScrollConnection
            /* renamed from: onPostFling-RZ2iAVY */
            public Object mo776onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
                function1.invoke(Boxing.boxFloat(velocityToFloat(j2)));
                return Velocity.box-impl(j2);
            }

            private final long toOffset(float f) {
                float f2 = orientation == Orientation.Horizontal ? f : 0.0f;
                if (orientation != Orientation.Vertical) {
                    f = 0.0f;
                }
                return OffsetKt.Offset(f2, f);
            }

            private final float velocityToFloat(long j) {
                return orientation == Orientation.Horizontal ? Velocity.getX-impl(j) : Velocity.getY-impl(j);
            }

            private final float offsetToFloat(long j) {
                return orientation == Orientation.Horizontal ? Offset.m4593getXimpl(j) : Offset.m4594getYimpl(j);
            }
        };
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dd, code lost:
    
        if (r2 == androidx.compose.runtime.Composer.INSTANCE.getEmpty()) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SheetState rememberSheetState(boolean z, Function1<? super SheetValue, Boolean> function1, SheetValue sheetValue, boolean z2, Composer composer, int i, int i2) {
        Object obj;
        composer.startReplaceableGroup(1032784200);
        ComposerKt.sourceInformation(composer, "C(rememberSheetState)P(3)482@18033L7,490@18313L179,483@18052L440:SheetDefaults.kt#uh7d8r");
        final boolean z3 = (i2 & 1) != 0 ? false : z;
        final Function1<? super SheetValue, Boolean> function12 = (i2 & 2) != 0 ? new Function1<SheetValue, Boolean>() { // from class: androidx.compose.material3.SheetDefaultsKt$rememberSheetState$1
            public final Boolean invoke(SheetValue sheetValue2) {
                return true;
            }
        } : function1;
        final SheetValue sheetValue2 = (i2 & 4) != 0 ? SheetValue.Hidden : sheetValue;
        final boolean z4 = (i2 & 8) != 0 ? false : z2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1032784200, i, -1, "androidx.compose.material3.rememberSheetState (SheetDefaults.kt:480)");
        }
        ProvidableCompositionLocal localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object consume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) consume;
        Object[] objArr = {Boolean.valueOf(z3), function12};
        Saver<SheetState, SheetValue> Saver = SheetState.INSTANCE.Saver(z3, function12, density);
        composer.startReplaceableGroup(1097108455);
        ComposerKt.sourceInformation(composer, "CC(remember):SheetDefaults.kt#9igjgp");
        boolean changed = ((((i & 14) ^ 6) > 4 && composer.changed(z3)) || (i & 6) == 4) | composer.changed(density) | ((((i & 896) ^ 384) > 256 && composer.changed(sheetValue2)) || (i & 384) == 256) | ((((i & 112) ^ 48) > 32 && composer.changed(function12)) || (i & 48) == 32) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(z4)) || (i & 3072) == 2048);
        Object rememberedValue = composer.rememberedValue();
        if (!changed) {
            obj = rememberedValue;
        }
        Object obj2 = (Function0) new Function0<SheetState>() { // from class: androidx.compose.material3.SheetDefaultsKt$rememberSheetState$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final SheetState m2907invoke() {
                return new SheetState(z3, density, sheetValue2, function12, z4);
            }
        };
        composer.updateRememberedValue(obj2);
        obj = obj2;
        composer.endReplaceableGroup();
        SheetState sheetState = (SheetState) RememberSaveableKt.m4241rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) obj, composer, 0, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return sheetState;
    }
}
