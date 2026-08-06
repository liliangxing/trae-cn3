package com.bytedance.android.anniex.base.builder;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.base.container.listener.AnnieXDialogListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/base/builder/PopupBuilder;", "Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "()V", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "getFragmentActivity$anniex_release", "()Landroidx/fragment/app/FragmentActivity;", "setFragmentActivity$anniex_release", "(Landroidx/fragment/app/FragmentActivity;)V", "listener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXDialogListener;", "getListener$anniex_release", "()Lcom/bytedance/android/anniex/base/container/listener/AnnieXDialogListener;", "setListener$anniex_release", "(Lcom/bytedance/android/anniex/base/container/listener/AnnieXDialogListener;)V", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PopupBuilder extends UIComponentBuilder {
    public FragmentActivity fragmentActivity;
    private AnnieXDialogListener listener;

    public final FragmentActivity getFragmentActivity$anniex_release() {
        FragmentActivity fragmentActivity = this.fragmentActivity;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fragmentActivity");
        return null;
    }

    public final void setFragmentActivity$anniex_release(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<set-?>");
        this.fragmentActivity = fragmentActivity;
    }

    /* renamed from: getListener$anniex_release, reason: from getter */
    public final AnnieXDialogListener getListener() {
        return this.listener;
    }

    public final void setListener$anniex_release(AnnieXDialogListener annieXDialogListener) {
        this.listener = annieXDialogListener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void fragmentActivity(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        setFragmentActivity$anniex_release(fragmentActivity);
        setSystemContext$anniex_release((Context) fragmentActivity);
    }

    public final void listener(AnnieXDialogListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }
}
