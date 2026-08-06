package com.bytedance.android.anniex.container.holder;

import androidx.fragment.app.Fragment;
import com.bytedance.android.anniex.base.builder.PageBuilder;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.IPageContainer;
import com.bytedance.android.anniex.base.container.holder.IFragmentHolder;
import com.bytedance.android.anniex.base.container.listener.AnnieXFragmentListener;
import com.bytedance.android.anniex.container.AnnieXPageContainer;
import com.bytedance.android.anniex.container.p025ui.AnnieXFragment;
import com.bytedance.android.anniex.container.p025ui.AnnieXPageService;
import com.bytedance.android.anniex.lite.container.AnnieXFlowPageContainer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXFragmentHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/anniex/container/holder/AnnieXFragmentHolder;", "Lcom/bytedance/android/anniex/container/holder/UIComponentHolder;", "Lcom/bytedance/android/anniex/base/container/holder/IFragmentHolder;", "builder", "Lcom/bytedance/android/anniex/base/builder/PageBuilder;", "(Lcom/bytedance/android/anniex/base/builder/PageBuilder;)V", "annieXFragment", "Lcom/bytedance/android/anniex/container/ui/AnnieXFragment;", "container", "Lcom/bytedance/android/anniex/base/container/IPageContainer;", "listener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXFragmentListener;", "getContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "getFragment", "Landroidx/fragment/app/Fragment;", "getPageContainer", "release", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXFragmentHolder extends UIComponentHolder implements IFragmentHolder {
    private AnnieXFragment annieXFragment;
    private final PageBuilder builder;
    private final IPageContainer container;
    private AnnieXFragmentListener listener;

    public AnnieXFragmentHolder(PageBuilder pageBuilder) {
        Intrinsics.checkNotNullParameter(pageBuilder, "builder");
        this.builder = pageBuilder;
        this.container = getPageContainer(pageBuilder);
        this.listener = pageBuilder.getListener();
    }

    private final IPageContainer getPageContainer(PageBuilder builder) {
        if (builder.getBundle().getBoolean(AnnieXPageService.BUNDLE_ANNIE_X_FLOW, false)) {
            return new AnnieXFlowPageContainer(builder);
        }
        return new AnnieXPageContainer(builder);
    }

    @Override // com.bytedance.android.anniex.base.container.holder.IFragmentHolder
    public Fragment getFragment() {
        AnnieXFragment annieXFragment;
        if (this.annieXFragment == null) {
            AnnieXFragment annieXFragment2 = new AnnieXFragment(this.builder);
            this.annieXFragment = annieXFragment2;
            annieXFragment2.setPageContainer$anniex_release(this.container);
            AnnieXFragmentListener annieXFragmentListener = this.listener;
            if (annieXFragmentListener != null && (annieXFragment = this.annieXFragment) != null) {
                annieXFragment.setListener$anniex_release(annieXFragmentListener);
            }
        }
        AnnieXFragment annieXFragment3 = this.annieXFragment;
        Intrinsics.checkNotNull(annieXFragment3, "null cannot be cast to non-null type com.bytedance.android.anniex.container.ui.AnnieXFragment");
        return annieXFragment3;
    }

    @Override // com.bytedance.android.anniex.container.holder.UIComponentHolder
    public IContainer getContainer() {
        return this.container;
    }

    public final void release() {
        this.container.release();
        this.listener = null;
    }
}
