package com.bytedance.android.anniex.container.holder;

import android.content.Context;
import android.os.Looper;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.anniex.base.builder.LitePageBuilder;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.holder.IDialogFragmentHolder;
import com.bytedance.android.anniex.base.container.listener.AnnieXFragmentListener;
import com.bytedance.android.anniex.lite.AnnieXLiteFragment;
import com.bytedance.android.anniex.lite.container.AnnieXLitePageContainer;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXDialogFragmentHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0012\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/anniex/container/holder/AnnieXDialogFragmentHolder;", "Lcom/bytedance/android/anniex/container/holder/UIComponentHolder;", "Lcom/bytedance/android/anniex/base/container/holder/IDialogFragmentHolder;", "builder", "Lcom/bytedance/android/anniex/base/builder/LitePageBuilder;", "(Lcom/bytedance/android/anniex/base/builder/LitePageBuilder;)V", "annieXFragment", "Lcom/bytedance/android/anniex/lite/AnnieXLiteFragment;", "container", "Lcom/bytedance/android/anniex/lite/container/AnnieXLitePageContainer;", "context", "Landroid/content/Context;", "listener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXFragmentListener;", "getContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "getDialog", "Landroidx/fragment/app/DialogFragment;", "loadSchema", "", StrategyConstants.SCHEMA, "", "show", "tag", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXDialogFragmentHolder extends UIComponentHolder implements IDialogFragmentHolder {
    private AnnieXLiteFragment annieXFragment;
    private final LitePageBuilder builder;
    private final AnnieXLitePageContainer container;
    private Context context;
    private AnnieXFragmentListener listener;

    public AnnieXDialogFragmentHolder(LitePageBuilder litePageBuilder) {
        Intrinsics.checkNotNullParameter(litePageBuilder, "builder");
        this.builder = litePageBuilder;
        this.container = new AnnieXLitePageContainer(litePageBuilder);
        this.listener = litePageBuilder.getListener();
        this.context = litePageBuilder.getSystemContext$anniex_release();
    }

    @Override // com.bytedance.android.anniex.container.holder.UIComponentHolder
    public IContainer getContainer() {
        return this.container;
    }

    @Override // com.bytedance.android.anniex.base.container.holder.IDialogHolder
    public DialogFragment getDialog() {
        AnnieXLiteFragment annieXLiteFragment;
        if (this.annieXFragment == null) {
            AnnieXLiteFragment annieXLiteFragment2 = new AnnieXLiteFragment(this.builder);
            this.annieXFragment = annieXLiteFragment2;
            annieXLiteFragment2.setPageContainer$anniex_release(this.container);
            AnnieXFragmentListener annieXFragmentListener = this.listener;
            if (annieXFragmentListener != null && (annieXLiteFragment = this.annieXFragment) != null) {
                annieXLiteFragment.setListener$anniex_release(annieXFragmentListener);
            }
        }
        AppCompatDialogFragment appCompatDialogFragment = this.annieXFragment;
        Intrinsics.checkNotNull(appCompatDialogFragment, "null cannot be cast to non-null type com.bytedance.android.anniex.lite.AnnieXLiteFragment");
        return (DialogFragment) appCompatDialogFragment;
    }

    @Override // com.bytedance.android.anniex.base.container.holder.IDialogHolder
    public void show(final String tag) {
        Object obj = this.context;
        if (obj instanceof FragmentActivity) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            final FragmentActivity fragmentActivity = (FragmentActivity) obj;
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                AnnieXLiteFragment annieXLiteFragment = this.annieXFragment;
                if (annieXLiteFragment != null) {
                    annieXLiteFragment.showNow(fragmentActivity.getSupportFragmentManager(), tag);
                    return;
                }
                return;
            }
            fragmentActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.android.anniex.container.holder.AnnieXDialogFragmentHolder$show$1
                @Override // java.lang.Runnable
                public final void run() {
                    AnnieXLiteFragment annieXLiteFragment2;
                    annieXLiteFragment2 = AnnieXDialogFragmentHolder.this.annieXFragment;
                    if (annieXLiteFragment2 != null) {
                        annieXLiteFragment2.showNow(fragmentActivity.getSupportFragmentManager(), tag);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.android.anniex.container.holder.UIComponentHolder, com.bytedance.android.anniex.base.container.holder.IUIComponentHolder
    public void loadSchema(String schema) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        AnnieXLiteFragment annieXLiteFragment = this.annieXFragment;
        if (annieXLiteFragment != null) {
            annieXLiteFragment.loadSchema(schema, null);
        }
    }
}
