package com.bytedance.ug.sdk.share.api.depend;

import android.app.Activity;
import com.bytedance.ug.sdk.share.api.entity.RecognizeDialogClickType;
import com.bytedance.ug.sdk.share.api.entity.TokenInfoBean;
import com.bytedance.ug.sdk.share.api.ui.IRecognizeTokenDialog;

/* loaded from: classes4.dex */
public interface IShareTokenConfig {
    boolean disableRecognizeToken(Activity activity);

    boolean filterRecognizeToken(Activity activity);

    boolean handleRecognizeToken(Activity activity, TokenInfoBean tokenInfoBean);

    void handleTokenCheckCallback(boolean z, String str, String str2);

    boolean interceptRecognizeTokenDialog(IRecognizeTokenDialog iRecognizeTokenDialog);

    void onRecognizeTokenDialogClickEvent(IRecognizeTokenDialog iRecognizeTokenDialog, RecognizeDialogClickType recognizeDialogClickType, TokenInfoBean tokenInfoBean);

    void onRecognizeTokenDialogDismissEvent(IRecognizeTokenDialog iRecognizeTokenDialog, TokenInfoBean tokenInfoBean);

    void onRecognizeTokenDialogShowEvent(IRecognizeTokenDialog iRecognizeTokenDialog, TokenInfoBean tokenInfoBean);
}
