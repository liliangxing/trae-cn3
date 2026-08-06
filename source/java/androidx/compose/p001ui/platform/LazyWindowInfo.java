package androidx.compose.p001ui.platform;

import androidx.compose.p001ui.unit.IntSize;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidWindowInfo.android.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\bJ\u0016\u0010\u001b\u001a\u00020\u00192\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00128V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/platform/LazyWindowInfo;", "Landroidx/compose/ui/platform/WindowInfo;", "<init>", "()V", "onInitializeContainerSize", "Lkotlin/Function0;", "Landroidx/compose/ui/unit/IntSize;", "_containerSize", "Landroidx/compose/runtime/MutableState;", "<set-?>", "", "isWindowFocused", "()Z", "setWindowFocused", "(Z)V", "isWindowFocused$delegate", "Landroidx/compose/runtime/MutableState;", StrategyConstants.VALUE, "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "keyboardModifiers", "getKeyboardModifiers-k7X9c1A", "()I", "setKeyboardModifiers-5xRPYO0", "(I)V", "updateContainerSizeIfObserved", "", "calculateContainerSize", "setOnInitializeContainerSize", "containerSize", "getContainerSize-YbymL2g", "()J", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LazyWindowInfo implements WindowInfo {
    public static final int $stable = 0;
    private MutableState<IntSize> _containerSize;

    /* renamed from: isWindowFocused$delegate, reason: from kotlin metadata */
    private final MutableState isWindowFocused = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
    private Function0<IntSize> onInitializeContainerSize;

    public static final /* synthetic */ MutableState access$get_containerSize$p(LazyWindowInfo lazyWindowInfo) {
        return lazyWindowInfo._containerSize;
    }

    @Override // androidx.compose.p001ui.platform.WindowInfo
    public boolean isWindowFocused() {
        return ((Boolean) this.isWindowFocused.getValue()).booleanValue();
    }

    public void setWindowFocused(boolean z) {
        this.isWindowFocused.setValue(Boolean.valueOf(z));
    }

    @Override // androidx.compose.p001ui.platform.WindowInfo
    /* renamed from: getKeyboardModifiers-k7X9c1A */
    public int mo1778getKeyboardModifiersk7X9c1A() {
        return ((PointerKeyboardModifiers) WindowInfoImpl.INSTANCE.getGlobalKeyboardModifiers$ui_release().getValue()).unbox-impl();
    }

    /* renamed from: setKeyboardModifiers-5xRPYO0 */
    public void m1779setKeyboardModifiers5xRPYO0(int i) {
        WindowInfoImpl.INSTANCE.getGlobalKeyboardModifiers$ui_release().setValue(PointerKeyboardModifiers.box-impl(i));
    }

    public final void updateContainerSizeIfObserved(Function0<IntSize> calculateContainerSize) {
        MutableState mutableState = this._containerSize;
        if (mutableState != null) {
            mutableState.setValue(calculateContainerSize.invoke());
        }
    }

    public final void setOnInitializeContainerSize(Function0<IntSize> onInitializeContainerSize) {
        if (this._containerSize == null) {
            this.onInitializeContainerSize = onInitializeContainerSize;
        }
    }

    @Override // androidx.compose.p001ui.platform.WindowInfo
    /* renamed from: getContainerSize-YbymL2g */
    public long mo1777getContainerSizeYbymL2g() {
        if (this._containerSize == null) {
            Function0<IntSize> function0 = this.onInitializeContainerSize;
            this._containerSize = SnapshotStateKt.mutableStateOf$default(IntSize.m2843boximpl(function0 != null ? ((IntSize) function0.invoke()).m2855unboximpl() : IntSize.INSTANCE.m2856getZeroYbymL2g()), (SnapshotMutationPolicy) null, 2, (Object) null);
            this.onInitializeContainerSize = null;
        }
        MutableState<IntSize> mutableState = this._containerSize;
        Intrinsics.checkNotNull(mutableState);
        return ((IntSize) mutableState.getValue()).m2855unboximpl();
    }
}
