package com.bytedance.android.anniex.container;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.base.builder.ViewBuilder;
import com.bytedance.android.anniex.base.container.IViewContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXViewContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/container/AnnieXViewContainer;", "Lcom/bytedance/android/anniex/container/AnnieXContainer;", "Lcom/bytedance/android/anniex/base/container/IViewContainer;", "builder", "Lcom/bytedance/android/anniex/base/builder/ViewBuilder;", "(Lcom/bytedance/android/anniex/base/builder/ViewBuilder;)V", "viewComponent", "Lcom/bytedance/android/anniex/base/container/IViewContainer$ViewComponent;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "rootView", "Landroid/view/ViewGroup;", "setViewComponent", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXViewContainer extends AnnieXContainer implements IViewContainer {
    private IViewContainer.ViewComponent viewComponent;

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void onCreate(Bundle savedInstanceState) {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnnieXViewContainer(ViewBuilder viewBuilder) {
        super(viewBuilder);
        Intrinsics.checkNotNullParameter(viewBuilder, "builder");
    }

    @Override // com.bytedance.android.anniex.base.container.IViewContainer
    public void setViewComponent(IViewContainer.ViewComponent viewComponent) {
        Intrinsics.checkNotNullParameter(viewComponent, "viewComponent");
        this.viewComponent = viewComponent;
        super.setUiComponent(viewComponent);
    }

    @Override // com.bytedance.android.anniex.base.container.IViewContainer
    public void onCreateView(ViewGroup rootView) {
        setRootView(rootView);
        if (rootView == null) {
            rootView = new FrameLayout(getContext());
        }
        setParentViewGroup(rootView);
        initUi();
    }
}
