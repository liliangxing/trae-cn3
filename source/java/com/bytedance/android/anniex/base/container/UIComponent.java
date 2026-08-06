package com.bytedance.android.anniex.base.container;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UIComponent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/base/container/UIComponent;", "", "()V", "close", "", "createDenyView", "Landroid/view/View;", "container", "Lcom/bytedance/android/anniex/base/container/IContainer;", "createErrorView", "createLoadingView", "createNoticeView", "interceptBackPress", "enable", "", "isAppBackground", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public abstract class UIComponent {
    public void close() {
    }

    public View createDenyView(IContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return null;
    }

    public View createErrorView() {
        return null;
    }

    public View createLoadingView() {
        return null;
    }

    public View createNoticeView(IContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return null;
    }

    public void interceptBackPress(boolean enable) {
    }

    public boolean isAppBackground() {
        return false;
    }
}
