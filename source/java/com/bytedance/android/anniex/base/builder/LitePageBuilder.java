package com.bytedance.android.anniex.base.builder;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.base.container.listener.AnnieXFragmentListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LitePageBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\nR\u001a\u0010\u0003\u001a\u00020\u0004X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/anniex/base/builder/LitePageBuilder;", "Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "()V", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity$anniex_release", "()Landroidx/fragment/app/FragmentActivity;", "setActivity$anniex_release", "(Landroidx/fragment/app/FragmentActivity;)V", "isFromScan", "", "isFromScan$anniex_release", "()Z", "setFromScan$anniex_release", "(Z)V", "listener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXFragmentListener;", "getListener$anniex_release", "()Lcom/bytedance/android/anniex/base/container/listener/AnnieXFragmentListener;", "setListener$anniex_release", "(Lcom/bytedance/android/anniex/base/container/listener/AnnieXFragmentListener;)V", "", "setFromScan", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class LitePageBuilder extends UIComponentBuilder {
    public FragmentActivity activity;
    private boolean isFromScan;
    private AnnieXFragmentListener listener;

    public final FragmentActivity getActivity$anniex_release() {
        FragmentActivity fragmentActivity = this.activity;
        if (fragmentActivity != null) {
            return fragmentActivity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        return null;
    }

    public final void setActivity$anniex_release(FragmentActivity fragmentActivity) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "<set-?>");
        this.activity = fragmentActivity;
    }

    /* renamed from: getListener$anniex_release, reason: from getter */
    public final AnnieXFragmentListener getListener() {
        return this.listener;
    }

    public final void setListener$anniex_release(AnnieXFragmentListener annieXFragmentListener) {
        this.listener = annieXFragmentListener;
    }

    /* renamed from: isFromScan$anniex_release, reason: from getter */
    public final boolean getIsFromScan() {
        return this.isFromScan;
    }

    public final void setFromScan$anniex_release(boolean z) {
        this.isFromScan = z;
    }

    public final void setFromScan(boolean isFromScan) {
        this.isFromScan = isFromScan;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void activity(FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivity$anniex_release(activity);
        setSystemContext$anniex_release((Context) activity);
    }

    public final void listener(AnnieXFragmentListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }
}
