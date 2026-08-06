package com.bytedance.android.anniex.container.holder;

import android.content.Context;
import android.view.View;
import com.bytedance.android.anniex.base.builder.ViewBuilder;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.holder.IViewHolder;
import com.bytedance.android.anniex.base.container.listener.AnnieXViewListener;
import com.bytedance.android.anniex.container.AnnieXViewContainer;
import com.bytedance.android.anniex.container.p025ui.AnnieXView;
import com.bytedance.ies.bullet.base.BulletSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/container/holder/AnnieXViewHolder;", "Lcom/bytedance/android/anniex/container/holder/UIComponentHolder;", "Lcom/bytedance/android/anniex/base/container/holder/IViewHolder;", "builder", "Lcom/bytedance/android/anniex/base/builder/ViewBuilder;", "(Lcom/bytedance/android/anniex/base/builder/ViewBuilder;)V", "annieXView", "Lcom/bytedance/android/anniex/container/ui/AnnieXView;", "container", "Lcom/bytedance/android/anniex/container/AnnieXViewContainer;", "listener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXViewListener;", "getContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "getView", "Landroid/view/View;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXViewHolder extends UIComponentHolder implements IViewHolder {
    private AnnieXView annieXView;
    private final AnnieXViewContainer container;
    private AnnieXViewListener listener;

    public AnnieXViewHolder(ViewBuilder viewBuilder) {
        Intrinsics.checkNotNullParameter(viewBuilder, "builder");
        this.container = new AnnieXViewContainer(viewBuilder);
        this.listener = viewBuilder.getListener();
    }

    @Override // com.bytedance.android.anniex.base.container.holder.IViewHolder
    public View getView() {
        Context systemContext = this.container.getSystemContext();
        BulletSdk.INSTANCE.ensureDefaultBidReady(systemContext);
        if (this.annieXView == null) {
            AnnieXView annieXView = new AnnieXView(systemContext, null, 0, 6, null);
            annieXView.setViewContainer$anniex_release(this.container);
            AnnieXViewListener annieXViewListener = this.listener;
            if (annieXViewListener != null) {
                annieXView.setListener$anniex_release(annieXViewListener);
            }
            annieXView.initUi$anniex_release();
            this.annieXView = annieXView;
        }
        AnnieXView annieXView2 = this.annieXView;
        Intrinsics.checkNotNull(annieXView2, "null cannot be cast to non-null type com.bytedance.android.anniex.container.ui.AnnieXView");
        return annieXView2;
    }

    @Override // com.bytedance.android.anniex.container.holder.UIComponentHolder
    public IContainer getContainer() {
        return this.container;
    }
}
