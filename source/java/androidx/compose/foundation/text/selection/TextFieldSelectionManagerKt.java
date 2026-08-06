package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.Handle;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.LongPressTextDragObserverKt;
import androidx.compose.foundation.text.TextDelegate;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.p002ui.Modifier;
import androidx.compose.p002ui.geometry.Offset;
import androidx.compose.p002ui.geometry.Rect;
import androidx.compose.p002ui.graphics.Fields;
import androidx.compose.p002ui.input.pointer.PointerInputEventHandler;
import androidx.compose.p002ui.input.pointer.PointerInputScope;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p002ui.layout.LayoutCoordinates;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* compiled from: TextFieldSelectionManager.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0003*\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u001f\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"TextFieldSelectionHandle", "", "isStartHandle", "", "direction", "Landroidx/compose/ui/text/style/ResolvedTextDirection;", "manager", "Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;", "(ZLandroidx/compose/ui/text/style/ResolvedTextDirection;Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;Landroidx/compose/runtime/Composer;I)V", "isSelectionHandleInVisibleBound", "calculateSelectionMagnifierCenterAndroid", "Landroidx/compose/ui/geometry/Offset;", "magnifierSize", "Landroidx/compose/ui/unit/IntSize;", "calculateSelectionMagnifierCenterAndroid-O0kMr_c", "(Landroidx/compose/foundation/text/selection/TextFieldSelectionManager;J)J", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class TextFieldSelectionManagerKt {

    /* compiled from: TextFieldSelectionManager.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Handle.values().length];
            try {
                iArr[Handle.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Handle.SelectionStart.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Handle.SelectionEnd.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TextFieldSelectionHandle$lambda$3(boolean z, ResolvedTextDirection resolvedTextDirection, TextFieldSelectionManager textFieldSelectionManager, int i, Composer composer, int i2) {
        TextFieldSelectionHandle(z, resolvedTextDirection, textFieldSelectionManager, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void TextFieldSelectionHandle(final boolean z, final ResolvedTextDirection resolvedTextDirection, final TextFieldSelectionManager textFieldSelectionManager, Composer composer, final int i) {
        int i2;
        Composer startRestartGroup = composer.startRestartGroup(-1344558920);
        ComposerKt.sourceInformation(startRestartGroup, "C(TextFieldSelectionHandle)N(isStartHandle,direction,manager)1250@52762L78,1253@52888L44,1259@53191L51,1252@52846L403:TextFieldSelectionManager.kt#eksfi3");
        if ((i & 6) == 0) {
            i2 = (startRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= startRestartGroup.changed(((Enum) resolvedTextDirection).ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= startRestartGroup.changedInstance(textFieldSelectionManager) ? Fields.RotationX : Fields.SpotShadowColor;
        }
        if (!startRestartGroup.shouldExecute((i2 & 147) != 146, i2 & 1)) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1344558920, i2, -1, "androidx.compose.foundation.text.selection.TextFieldSelectionHandle (TextFieldSelectionManager.kt:1249)");
            }
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 664039814, "CC(remember):TextFieldSelectionManager.kt#9igjgp");
            int i3 = i2 & 14;
            boolean changed = (i3 == 4) | startRestartGroup.changed(textFieldSelectionManager);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = textFieldSelectionManager.handleDragObserver$foundation_release(z);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final TextDragObserver textDragObserver = (TextDragObserver) rememberedValue;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 664043812, "CC(remember):TextFieldSelectionManager.kt#9igjgp");
            boolean changedInstance = startRestartGroup.changedInstance(textFieldSelectionManager) | (i3 == 4);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = (OffsetProvider) new OffsetProvider() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$1$1
                    @Override // androidx.compose.foundation.text.selection.OffsetProvider
                    /* renamed from: provide-F1C5BW0 */
                    public final long mo1503provideF1C5BW0() {
                        return TextFieldSelectionManager.this.m2150getHandlePositiontuRUvjQ$foundation_release(z);
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            OffsetProvider offsetProvider = (OffsetProvider) rememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            boolean z2 = TextRange.getReversed-impl(textFieldSelectionManager.getValue$foundation_release().getSelection-d9O1mEE());
            float handleLineHeight$foundation_release = textFieldSelectionManager.getHandleLineHeight$foundation_release(z);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(startRestartGroup, 664053515, "CC(remember):TextFieldSelectionManager.kt#9igjgp");
            boolean changedInstance2 = startRestartGroup.changedInstance(textDragObserver);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                rememberedValue3 = (PointerInputEventHandler) new PointerInputEventHandler() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$TextFieldSelectionHandle$2$1
                    @Override // androidx.compose.p002ui.input.pointer.PointerInputEventHandler
                    public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                        Object detectDownAndDragGesturesWithObserver = LongPressTextDragObserverKt.detectDownAndDragGesturesWithObserver(pointerInputScope, TextDragObserver.this, continuation);
                        return detectDownAndDragGesturesWithObserver == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? detectDownAndDragGesturesWithObserver : Unit.INSTANCE;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(startRestartGroup);
            int i4 = i2 << 3;
            AndroidSelectionHandles_androidKt.m2045SelectionHandlewLIcFTc(offsetProvider, z, resolvedTextDirection, z2, 0L, handleLineHeight$foundation_release, SuspendingPointerInputFilterKt.pointerInput(companion, textDragObserver, (PointerInputEventHandler) rememberedValue3), startRestartGroup, (i4 & 112) | (i4 & 896), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.text.selection.TextFieldSelectionManagerKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit TextFieldSelectionHandle$lambda$3;
                    TextFieldSelectionHandle$lambda$3 = TextFieldSelectionManagerKt.TextFieldSelectionHandle$lambda$3(z, resolvedTextDirection, textFieldSelectionManager, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TextFieldSelectionHandle$lambda$3;
                }
            });
        }
    }

    public static final boolean isSelectionHandleInVisibleBound(TextFieldSelectionManager textFieldSelectionManager, boolean z) {
        LayoutCoordinates layoutCoordinates;
        Rect visibleBounds;
        LegacyTextFieldState state = textFieldSelectionManager.getState();
        if (state == null || (layoutCoordinates = state.getLayoutCoordinates()) == null || (visibleBounds = SelectionManagerKt.visibleBounds(layoutCoordinates)) == null) {
            return false;
        }
        return SelectionManagerKt.m2117containsInclusiveUv8p0NA(visibleBounds, textFieldSelectionManager.m2150getHandlePositiontuRUvjQ$foundation_release(z));
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /* renamed from: calculateSelectionMagnifierCenterAndroid-O0kMr_c, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final long m2157calculateSelectionMagnifierCenterAndroidO0kMr_c(TextFieldSelectionManager textFieldSelectionManager, long j) {
        boolean z;
        int i;
        TextLayoutResultProxy layoutResult;
        TextDelegate textDelegate;
        AnnotatedString text;
        Offset m2148getCurrentDragPosition_m7T9E = textFieldSelectionManager.m2148getCurrentDragPosition_m7T9E();
        if (m2148getCurrentDragPosition_m7T9E == null) {
            return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
        }
        long m4603unboximpl = m2148getCurrentDragPosition_m7T9E.m4603unboximpl();
        CharSequence transformedText$foundation_release = textFieldSelectionManager.getTransformedText$foundation_release();
        if (transformedText$foundation_release != null) {
            if (!(transformedText$foundation_release.length() == 0)) {
                z = true;
                if (z) {
                    return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
                }
                Handle draggingHandle = textFieldSelectionManager.getDraggingHandle();
                int i2 = draggingHandle == null ? -1 : WhenMappings.$EnumSwitchMapping$0[draggingHandle.ordinal()];
                if (i2 == -1) {
                    return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
                }
                if (i2 == 1 || i2 == 2) {
                    i = TextRange.getStart-impl(textFieldSelectionManager.getValue$foundation_release().getSelection-d9O1mEE());
                } else {
                    if (i2 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i = TextRange.getEnd-impl(textFieldSelectionManager.getValue$foundation_release().getSelection-d9O1mEE());
                }
                LegacyTextFieldState state = textFieldSelectionManager.getState();
                if (state == null || (layoutResult = state.getLayoutResult()) == null) {
                    return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
                }
                LegacyTextFieldState state2 = textFieldSelectionManager.getState();
                if (state2 == null || (textDelegate = state2.getTextDelegate()) == null || (text = textDelegate.getText()) == null) {
                    return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
                }
                int coerceIn = RangesKt.coerceIn(textFieldSelectionManager.getOffsetMapping().originalToTransformed(i), 0, text.length());
                float intBitsToFloat = Float.intBitsToFloat((int) (layoutResult.m1666translateDecorationToInnerCoordinatesMKHz9U$foundation_release(m4603unboximpl) >> 32));
                TextLayoutResult value = layoutResult.getValue();
                int lineForOffset = value.getLineForOffset(coerceIn);
                float lineLeft = value.getLineLeft(lineForOffset);
                float lineRight = value.getLineRight(lineForOffset);
                float coerceIn2 = RangesKt.coerceIn(intBitsToFloat, Math.min(lineLeft, lineRight), Math.max(lineLeft, lineRight));
                if (!IntSize.equals-impl0(j, IntSize.Companion.getZero-YbymL2g()) && Math.abs(intBitsToFloat - coerceIn2) > ((int) (j >> 32)) / 2) {
                    return Offset.INSTANCE.m4608getUnspecifiedF1C5BW0();
                }
                float lineTop = value.getLineTop(lineForOffset);
                return Offset.m4585constructorimpl((Float.floatToRawIntBits(coerceIn2) << 32) | (Float.floatToRawIntBits(((value.getLineBottom(lineForOffset) - lineTop) / 2) + lineTop) & 4294967295L));
            }
        }
        z = false;
        if (z) {
        }
    }
}
