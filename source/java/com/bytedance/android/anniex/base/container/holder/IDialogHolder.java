package com.bytedance.android.anniex.base.container.holder;

import androidx.fragment.app.DialogFragment;
import com.bytedance.push.interfaze.IMessageCallbackService;
import kotlin.Metadata;

/* compiled from: IDialogHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0014\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/anniex/base/container/holder/IDialogHolder;", "Lcom/bytedance/android/anniex/base/container/holder/IUIComponentHolder;", "getDialog", "Landroidx/fragment/app/DialogFragment;", IMessageCallbackService.EVENT_TYPE_SHOW, "", "tag", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public interface IDialogHolder extends IUIComponentHolder {
    DialogFragment getDialog();

    void show(String tag);

    /* compiled from: IDialogHolder.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void show$default(IDialogHolder iDialogHolder, String str, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: show");
            }
            if ((i & 1) != 0) {
                str = "annie_x_dialog";
            }
            iDialogHolder.show(str);
        }
    }
}
