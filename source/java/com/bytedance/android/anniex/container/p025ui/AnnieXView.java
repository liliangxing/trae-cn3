package com.bytedance.android.anniex.container.p025ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.anniex.base.container.IViewContainer;
import com.bytedance.android.anniex.base.container.listener.AnnieXViewListener;
import com.bytedance.android.anniex.container.AnnieXContainer;
import com.bytedance.android.anniex.container.AnnieXViewContainer;
import com.bytedance.android.anniex.container.util.CustomViewUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u000e\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012J\b\u0010\u0013\u001a\u00020\u0011H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0014J\u0006\u0010\u0015\u001a\u00020\u0011J\u0015\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0017J\u0015\u0010\u0018\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u0019R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/anniex/container/ui/AnnieXView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "container", "Lcom/bytedance/android/anniex/container/AnnieXViewContainer;", "listener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXViewListener;", "viewComponent", "com/bytedance/android/anniex/container/ui/AnnieXView$viewComponent$1", "Lcom/bytedance/android/anniex/container/ui/AnnieXView$viewComponent$1;", "initUi", "", "initUi$anniex_release", "onAttachedToWindow", "onDetachedFromWindow", "release", "setListener", "setListener$anniex_release", "setViewContainer", "setViewContainer$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXView extends FrameLayout {
    private AnnieXViewContainer container;
    private AnnieXViewListener listener;
    private final AnnieXView$viewComponent$1 viewComponent;

    public /* synthetic */ AnnieXView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.android.anniex.container.ui.AnnieXView$viewComponent$1] */
    public AnnieXView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.viewComponent = new IViewContainer.ViewComponent() { // from class: com.bytedance.android.anniex.container.ui.AnnieXView$viewComponent$1
            @Override // com.bytedance.android.anniex.base.container.UIComponent
            public View createErrorView() {
                AnnieXViewContainer annieXViewContainer;
                annieXViewContainer = AnnieXView.this.container;
                if (annieXViewContainer != null) {
                    return CustomViewUtil.INSTANCE.createErrorView((AnnieXContainer) annieXViewContainer);
                }
                return null;
            }

            @Override // com.bytedance.android.anniex.base.container.UIComponent
            public View createLoadingView() {
                AnnieXViewContainer annieXViewContainer;
                annieXViewContainer = AnnieXView.this.container;
                if (annieXViewContainer != null) {
                    return CustomViewUtil.INSTANCE.createLoadingView((AnnieXContainer) annieXViewContainer);
                }
                return null;
            }
        };
    }

    public final void setViewContainer$anniex_release(AnnieXViewContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
    }

    public final void setListener$anniex_release(AnnieXViewListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
    }

    public final void initUi$anniex_release() {
        AnnieXViewContainer annieXViewContainer = this.container;
        if (annieXViewContainer != null) {
            annieXViewContainer.setViewComponent(this.viewComponent);
            annieXViewContainer.onCreateView(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AnnieXViewListener annieXViewListener = this.listener;
        if (annieXViewListener != null) {
            annieXViewListener.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnnieXViewListener annieXViewListener = this.listener;
        if (annieXViewListener != null) {
            annieXViewListener.onDetachedFromWindow();
        }
    }

    public final void release() {
        AnnieXViewContainer annieXViewContainer = this.container;
        if (annieXViewContainer != null) {
            annieXViewContainer.release();
        }
    }
}
