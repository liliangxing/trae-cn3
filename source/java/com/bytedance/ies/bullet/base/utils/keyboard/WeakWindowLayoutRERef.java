package com.bytedance.ies.bullet.base.utils.keyboard;

import android.view.ViewTreeObserver;
import androidx.arch.core.util.Function;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SoftInput.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u0005H\u0016R.\u0010\u0002\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/base/utils/keyboard/WeakWindowLayoutRERef;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "functionRef", "Ljava/lang/ref/WeakReference;", "Landroidx/arch/core/util/Function;", "", "(Ljava/lang/ref/WeakReference;)V", "getFunctionRef", "()Ljava/lang/ref/WeakReference;", "setFunctionRef", "onGlobalLayout", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class WeakWindowLayoutRERef implements ViewTreeObserver.OnGlobalLayoutListener {
    private WeakReference<Function<Unit, Unit>> functionRef;

    /* JADX WARN: Multi-variable type inference failed */
    public WeakWindowLayoutRERef() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public WeakWindowLayoutRERef(WeakReference<Function<Unit, Unit>> weakReference) {
        this.functionRef = weakReference;
    }

    public /* synthetic */ WeakWindowLayoutRERef(WeakReference weakReference, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : weakReference);
    }

    public final WeakReference<Function<Unit, Unit>> getFunctionRef() {
        return this.functionRef;
    }

    public final void setFunctionRef(WeakReference<Function<Unit, Unit>> weakReference) {
        this.functionRef = weakReference;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        WeakReference<Function<Unit, Unit>> weakReference = this.functionRef;
        Function<Unit, Unit> function = weakReference != null ? weakReference.get() : null;
        if (function == null) {
            return;
        }
        function.apply(Unit.INSTANCE);
    }
}
