package com.bytedance.android.anniex.base.builder;

import android.app.Activity;
import com.bytedance.android.anniex.base.container.listener.AnnieXFragmentListener;
import com.bytedance.ies.bullet.base.core.common.Components;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PageBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/anniex/base/builder/PageBuilder;", "Lcom/bytedance/android/anniex/base/builder/UIComponentBuilder;", "()V", "activity", "Landroid/app/Activity;", "getActivity$anniex_release", "()Landroid/app/Activity;", "setActivity$anniex_release", "(Landroid/app/Activity;)V", "clientComponent", "Lcom/bytedance/ies/bullet/base/core/common/Components;", "getClientComponent$anniex_release", "()Lcom/bytedance/ies/bullet/base/core/common/Components;", "setClientComponent$anniex_release", "(Lcom/bytedance/ies/bullet/base/core/common/Components;)V", "listener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXFragmentListener;", "getListener$anniex_release", "()Lcom/bytedance/android/anniex/base/container/listener/AnnieXFragmentListener;", "setListener$anniex_release", "(Lcom/bytedance/android/anniex/base/container/listener/AnnieXFragmentListener;)V", "", "component", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PageBuilder extends UIComponentBuilder {
    public Activity activity;
    private Components clientComponent = Components.Fragment;
    private AnnieXFragmentListener listener;

    public final Activity getActivity$anniex_release() {
        Activity activity = this.activity;
        if (activity != null) {
            return activity;
        }
        Intrinsics.throwUninitializedPropertyAccessException("activity");
        return null;
    }

    public final void setActivity$anniex_release(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<set-?>");
        this.activity = activity;
    }

    /* renamed from: getListener$anniex_release, reason: from getter */
    public final AnnieXFragmentListener getListener() {
        return this.listener;
    }

    public final void setListener$anniex_release(AnnieXFragmentListener annieXFragmentListener) {
        this.listener = annieXFragmentListener;
    }

    /* renamed from: getClientComponent$anniex_release, reason: from getter */
    public final Components getClientComponent() {
        return this.clientComponent;
    }

    public final void setClientComponent$anniex_release(Components components) {
        Intrinsics.checkNotNullParameter(components, "<set-?>");
        this.clientComponent = components;
    }

    public final void activity(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivity$anniex_release(activity);
        setSystemContext$anniex_release(activity);
    }

    public final void listener(AnnieXFragmentListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void clientComponent(Components component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.clientComponent = component;
    }
}
