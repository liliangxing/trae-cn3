package com.bytedance.ies.bullet.base.utils.keyboard;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SoftInput.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ies/bullet/base/utils/keyboard/SoftInput;", "", "()V", "hideSoftInputObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "getHideSoftInputObserver$anniex_release", "()Landroidx/lifecycle/LifecycleEventObserver;", "isSoftInputCompatMode", "", "()Z", "setSoftInputCompatMode", "(Z)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class SoftInput {
    public static final SoftInput INSTANCE = new SoftInput();
    private static final LifecycleEventObserver hideSoftInputObserver = new LifecycleEventObserver() { // from class: com.bytedance.ies.bullet.base.utils.keyboard.SoftInput$hideSoftInputObserver$1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(event, "event");
            if (event == Lifecycle.Event.ON_PAUSE) {
                if (source instanceof Activity) {
                    SoftInputUtilKt.hideSoftInput((Activity) source);
                } else if (source instanceof Fragment) {
                    SoftInputUtilKt.hideSoftInput((Fragment) source);
                }
            }
        }
    };
    private static boolean isSoftInputCompatMode;

    private SoftInput() {
    }

    public final LifecycleEventObserver getHideSoftInputObserver$anniex_release() {
        return hideSoftInputObserver;
    }

    public final boolean isSoftInputCompatMode() {
        return isSoftInputCompatMode;
    }

    public final void setSoftInputCompatMode(boolean z) {
        isSoftInputCompatMode = z;
    }
}
