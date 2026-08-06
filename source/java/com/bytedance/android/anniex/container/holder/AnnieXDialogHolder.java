package com.bytedance.android.anniex.container.holder;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.anniex.base.builder.PopupBuilder;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.container.IPopupContainer;
import com.bytedance.android.anniex.base.container.holder.IDialogHolder;
import com.bytedance.android.anniex.base.container.listener.AnnieXDialogListener;
import com.bytedance.android.anniex.container.AnnieXPopupContainer;
import com.bytedance.android.anniex.container.p025ui.AnnieXDialog;
import com.bytedance.android.anniex.lite.container.AnnieXFlowPopupContainer;
import com.bytedance.ies.bullet.base.BulletSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXDialogHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0006\u0010\u0010\u001a\u00020\u0011J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/anniex/container/holder/AnnieXDialogHolder;", "Lcom/bytedance/android/anniex/container/holder/UIComponentHolder;", "Lcom/bytedance/android/anniex/base/container/holder/IDialogHolder;", "builder", "Lcom/bytedance/android/anniex/base/builder/PopupBuilder;", "(Lcom/bytedance/android/anniex/base/builder/PopupBuilder;)V", "annieXDialog", "Lcom/bytedance/android/anniex/container/ui/AnnieXDialog;", "container", "Lcom/bytedance/android/anniex/base/container/IPopupContainer;", "listener", "Lcom/bytedance/android/anniex/base/container/listener/AnnieXDialogListener;", "getContainer", "Lcom/bytedance/android/anniex/base/container/IContainer;", "getDialog", "Landroidx/fragment/app/DialogFragment;", "release", "", "show", "tag", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class AnnieXDialogHolder extends UIComponentHolder implements IDialogHolder {
    private AnnieXDialog annieXDialog;
    private final PopupBuilder builder;
    private final IPopupContainer container;
    private AnnieXDialogListener listener;

    public AnnieXDialogHolder(PopupBuilder popupBuilder) {
        AnnieXPopupContainer annieXPopupContainer;
        Intrinsics.checkNotNullParameter(popupBuilder, "builder");
        this.builder = popupBuilder;
        if (popupBuilder.getUseFlow()) {
            annieXPopupContainer = new AnnieXFlowPopupContainer(popupBuilder);
        } else {
            annieXPopupContainer = new AnnieXPopupContainer(popupBuilder);
        }
        this.container = annieXPopupContainer;
        this.listener = popupBuilder.getListener();
    }

    @Override // com.bytedance.android.anniex.base.container.holder.IDialogHolder
    public DialogFragment getDialog() {
        markOpenTime(this.builder.getBundle());
        Context systemContext = this.container.getSystemContext();
        if (systemContext != null) {
            BulletSdk.INSTANCE.ensureDefaultBidReady(systemContext);
        }
        AnnieXDialog annieXDialog = this.annieXDialog;
        if (annieXDialog == null) {
            annieXDialog = new AnnieXDialog();
            annieXDialog.setArguments(this.builder.getBundle());
            annieXDialog.setPopupContainer$anniex_release(this.container);
            AnnieXDialogListener annieXDialogListener = this.listener;
            if (annieXDialogListener != null) {
                annieXDialog.setListener$anniex_release(annieXDialogListener);
            }
            this.annieXDialog = annieXDialog;
        }
        return annieXDialog;
    }

    @Override // com.bytedance.android.anniex.base.container.holder.IDialogHolder
    public void show(String tag) {
        getDialog().show(this.builder.getFragmentActivity$anniex_release().getSupportFragmentManager(), tag);
    }

    @Override // com.bytedance.android.anniex.container.holder.UIComponentHolder
    public IContainer getContainer() {
        return this.container;
    }

    public final void release() {
        this.annieXDialog = null;
        this.listener = null;
    }
}
