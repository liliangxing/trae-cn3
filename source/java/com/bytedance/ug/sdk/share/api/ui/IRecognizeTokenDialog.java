package com.bytedance.ug.sdk.share.api.ui;

import com.bytedance.ug.sdk.share.api.entity.RecognizeDialogClickType;
import com.bytedance.ug.sdk.share.api.entity.TokenInfoBean;

/* loaded from: classes4.dex */
public interface IRecognizeTokenDialog {

    /* loaded from: classes4.dex */
    public interface ITokenDialogCallback {
        void onClick(boolean z, RecognizeDialogClickType recognizeDialogClickType, TokenInfoBean tokenInfoBean);

        void onDismiss();
    }

    void dismiss();

    void initTokenDialog(TokenInfoBean tokenInfoBean, ITokenDialogCallback iTokenDialogCallback);

    boolean isShowing();

    void show();
}
