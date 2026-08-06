package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.p002ui.geometry.Size;
import androidx.compose.p002ui.input.pointer.PointerEvent;
import androidx.compose.p002ui.input.pointer.PointerEventKt;
import androidx.compose.p002ui.input.pointer.PointerEventPass;
import androidx.compose.p002ui.input.pointer.PointerInputChange;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p002ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Clickable.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u00002\u00020\u0001BM\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0017\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001aH\u0016¢\u0006\u0004\b%\u0010&J\b\u0010'\u001a\u00020\u000fH\u0016JQ\u0010(\u001a\u00020\u000f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\b)J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,H\u0004¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00072\u0006\u0010+\u001a\u00020,H\u0004¢\u0006\u0004\b0\u0010.R\u0014\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0013\u0010\u0014R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/foundation/ClickableNode;", "Landroidx/compose/foundation/AbstractClickableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "indicationNodeFactory", "Landroidx/compose/foundation/IndicationNodeFactory;", "useLocalIndication", "", "enabled", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/IndicationNodeFactory;ZZLjava/lang/String;Landroidx/compose/ui/semantics/Role;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "isSuspendingPointerInputEnabled", "isSuspendingPointerInputEnabled$annotations", "()V", "createPointerInputNodeIfNeeded", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "getExtendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "size", "Landroidx/compose/ui/unit/IntSize;", "getExtendedTouchPadding-hWWAJMo", "(J)J", "downEvent", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onCancelPointerInput", "update", "update-O2vRcR0", "onClickKeyDownEvent", "event", "Landroidx/compose/ui/input/key/KeyEvent;", "onClickKeyDownEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "onClickKeyUpEvent", "onClickKeyUpEvent-ZmokQxo", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public class ClickableNode extends AbstractClickableNode {
    public static final int $stable = 8;
    private PointerInputChange downEvent;
    private final boolean isSuspendingPointerInputEnabled;

    public /* synthetic */ ClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(mutableInteractionSource, indicationNodeFactory, z, z2, str, role, function0);
    }

    private static /* synthetic */ void isSuspendingPointerInputEnabled$annotations() {
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* renamed from: onClickKeyDownEvent-ZmokQxo */
    protected final boolean mo360onClickKeyDownEventZmokQxo(KeyEvent event) {
        return false;
    }

    private ClickableNode(MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z, boolean z2, String str, Role role, Function0<Unit> function0) {
        super(mutableInteractionSource, indicationNodeFactory, z, z2, str, role, function0, null);
        this.isSuspendingPointerInputEnabled = (ComposeFoundationFlags.isDetectTapGesturesImmediateCoroutineDispatchEnabled && ComposeFoundationFlags.isNonSuspendingPointerInputInClickableEnabled) ? false : true;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public SuspendingPointerInputModifierNode createPointerInputNodeIfNeeded() {
        if (this.isSuspendingPointerInputEnabled) {
            return SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode(new ClickableNode$createPointerInputNodeIfNeeded$1(this));
        }
        return null;
    }

    /* renamed from: getExtendedTouchPadding-hWWAJMo, reason: not valid java name */
    private final long m456getExtendedTouchPaddinghWWAJMo(long size) {
        long j = DelegatableNodeKt.requireDensity(this).toSize-XkaWNTQ(((ViewConfiguration) CompositionLocalConsumerModifierNodeKt.currentValueOf(this, CompositionLocalsKt.getLocalViewConfiguration())).getMinimumTouchTargetSize-MYxV2XQ());
        float max = Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - ((int) (size >> 32))) / 2.0f;
        float max2 = Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - ((int) (size & 4294967295L))) / 2.0f;
        return Size.m4653constructorimpl((Float.floatToRawIntBits(max2) & 4294967295L) | (Float.floatToRawIntBits(max) << 32));
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* renamed from: onPointerEvent-H0pRuoY */
    public void mo363onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        boolean z;
        super.mo363onPointerEventH0pRuoY(pointerEvent, pass, bounds);
        if (this.isSuspendingPointerInputEnabled) {
            return;
        }
        boolean z2 = true;
        if (pass == PointerEventPass.Main) {
            PointerInputChange pointerInputChange = this.downEvent;
            if (pointerInputChange == null) {
                if (TapGestureDetectorKt.isChangedToDown$default(pointerEvent, true, false, 2, null)) {
                    PointerInputChange pointerInputChange2 = pointerEvent.getChanges().get(0);
                    pointerInputChange2.consume();
                    this.downEvent = pointerInputChange2;
                    if (getEnabled()) {
                        m359handlePressInteractionStartk4lQ0M(pointerInputChange2.getPosition());
                        return;
                    }
                    return;
                }
                return;
            }
            List<PointerInputChange> changes = pointerEvent.getChanges();
            int size = changes.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = true;
                    break;
                } else {
                    if (!PointerEventKt.changedToUp(changes.get(i))) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            if (z) {
                pointerEvent.getChanges().get(0).consume();
                if (getEnabled()) {
                    m358handlePressInteractionReleasek4lQ0M(pointerInputChange.getPosition());
                    getOnClick().invoke();
                }
                this.downEvent = null;
                return;
            }
            long m456getExtendedTouchPaddinghWWAJMo = m456getExtendedTouchPaddinghWWAJMo(bounds);
            List<PointerInputChange> changes2 = pointerEvent.getChanges();
            int size2 = changes2.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size2) {
                    z2 = false;
                    break;
                }
                PointerInputChange pointerInputChange3 = changes2.get(i2);
                if (pointerInputChange3.isConsumed() || PointerEventKt.m6087isOutOfBoundsjwHxaWs(pointerInputChange3, bounds, m456getExtendedTouchPaddinghWWAJMo)) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z2) {
                this.downEvent = null;
                handlePressInteractionCancel();
                return;
            }
            return;
        }
        if (pass != PointerEventPass.Final || this.downEvent == null) {
            return;
        }
        List<PointerInputChange> changes3 = pointerEvent.getChanges();
        int size3 = changes3.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size3) {
                z2 = false;
                break;
            }
            PointerInputChange pointerInputChange4 = changes3.get(i3);
            if (pointerInputChange4.isConsumed() && !Intrinsics.areEqual(pointerInputChange4, this.downEvent)) {
                break;
            } else {
                i3++;
            }
        }
        if (z2) {
            this.downEvent = null;
            handlePressInteractionCancel();
        }
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void onCancelPointerInput() {
        super.onCancelPointerInput();
        if (this.downEvent != null) {
            this.downEvent = null;
            handlePressInteractionCancel();
        }
    }

    /* renamed from: update-O2vRcR0, reason: not valid java name */
    public final void m457updateO2vRcR0(MutableInteractionSource interactionSource, IndicationNodeFactory indicationNodeFactory, boolean useLocalIndication, boolean enabled, String onClickLabel, Role role, Function0<Unit> onClick) {
        m365updateCommonO2vRcR0(interactionSource, indicationNodeFactory, useLocalIndication, enabled, onClickLabel, role, onClick);
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    /* renamed from: onClickKeyUpEvent-ZmokQxo */
    protected final boolean mo361onClickKeyUpEventZmokQxo(KeyEvent event) {
        getOnClick().invoke();
        return true;
    }
}
