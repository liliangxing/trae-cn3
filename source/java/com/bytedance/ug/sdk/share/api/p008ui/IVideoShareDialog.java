package com.bytedance.ug.sdk.share.api.p008ui;

import com.bytedance.ug.sdk.share.api.entity.ShareContent;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface IVideoShareDialog {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ITokenDialogCallback {
        void onClick(boolean z);

        void onDismiss();
    }

    void dismiss();

    void initTokenDialog(ShareContent shareContent, ITokenDialogCallback iTokenDialogCallback);

    boolean isShowing();

    void show();
}
