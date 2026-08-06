package com.bytedance.ug.sdk.share.api.p008ui;

import android.net.Uri;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public interface ISystemOptShareTokenDialog {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface ITokenDialogCallback {
        void onClick(boolean z, ArrayList<Uri> arrayList);

        void onDismiss();
    }

    void dismiss();

    void initTokenDialog(ShareContent shareContent, ArrayList<Uri> arrayList, ITokenDialogCallback iTokenDialogCallback);

    boolean isShowing();

    void show();
}
