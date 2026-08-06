package com.bytedance.ug.sdk.share.impl.p009ui.recognize;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.RecognizeDialogClickType;
import com.bytedance.ug.sdk.share.api.entity.TokenInfoBean;
import com.bytedance.ug.sdk.share.api.p008ui.IRecognizeTokenDialog;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class RecognizeTokenDialogProxy {
    private WeakReference<Activity> mContextRef;
    private IRecognizeTokenDialog.ITokenDialogCallback mDialogCallback;
    private boolean mIsDialogClicked;
    private IRecognizeTokenDialog mTokenDialog;
    private TokenInfoBean mTokenInfoBean;

    public RecognizeTokenDialogProxy(Activity activity, TokenInfoBean tokenInfoBean, IRecognizeTokenDialog iRecognizeTokenDialog) {
        this.mTokenDialog = iRecognizeTokenDialog;
        this.mTokenInfoBean = tokenInfoBean;
        this.mContextRef = new WeakReference<>(activity);
        IRecognizeTokenDialog.ITokenDialogCallback iTokenDialogCallback = new IRecognizeTokenDialog.ITokenDialogCallback() { // from class: com.bytedance.ug.sdk.share.impl.ui.recognize.RecognizeTokenDialogProxy.1
            @Override // com.bytedance.ug.sdk.share.api.ui.IRecognizeTokenDialog.ITokenDialogCallback
            public void onClick(boolean z, RecognizeDialogClickType recognizeDialogClickType, TokenInfoBean tokenInfoBean2) {
                Activity activity2;
                RecognizeTokenDialogProxy.this.mIsDialogClicked = true;
                if (z) {
                    RecognizeTokenDialogProxy.this.dismiss();
                }
                ShareConfigManager.getInstance().onRecognizeTokenDialogClickEvent(RecognizeTokenDialogProxy.this.mTokenDialog, recognizeDialogClickType, RecognizeTokenDialogProxy.this.mTokenInfoBean);
                if (recognizeDialogClickType == RecognizeDialogClickType.CLICK_TYPE_DETAIL) {
                    r0 = RecognizeTokenDialogProxy.this.mTokenInfoBean != null ? RecognizeTokenDialogProxy.this.mTokenInfoBean.getOpenUrl() : null;
                    ShareEvent.sendRecognizeDialogClickEvent(RecognizeTokenDialogProxy.this.mTokenInfoBean, "submit");
                } else if (recognizeDialogClickType == RecognizeDialogClickType.CLICK_TYPE_USER_DETAIL) {
                    if (RecognizeTokenDialogProxy.this.mTokenInfoBean != null && RecognizeTokenDialogProxy.this.mTokenInfoBean.getShareUserInfo() != null) {
                        r0 = RecognizeTokenDialogProxy.this.mTokenInfoBean.getShareUserInfo().getSourceOpenUrl();
                    }
                    ShareEvent.sendRecognizeDialogClickEvent(RecognizeTokenDialogProxy.this.mTokenInfoBean, "submit");
                } else if (recognizeDialogClickType == RecognizeDialogClickType.CLICK_TYPE_CLOSE) {
                    ShareEvent.sendRecognizeDialogClickEvent(RecognizeTokenDialogProxy.this.mTokenInfoBean, "close");
                } else {
                    ShareEvent.sendRecognizeDialogClickEvent(RecognizeTokenDialogProxy.this.mTokenInfoBean, "other");
                }
                if (TextUtils.isEmpty(r0) || (activity2 = (Activity) RecognizeTokenDialogProxy.this.mContextRef.get()) == null) {
                    return;
                }
                ShareConfigManager.getInstance().openPage(activity2, r0);
            }

            @Override // com.bytedance.ug.sdk.share.api.ui.IRecognizeTokenDialog.ITokenDialogCallback
            public void onDismiss() {
                if (RecognizeTokenDialogProxy.this.mTokenInfoBean == null || RecognizeTokenDialogProxy.this.mIsDialogClicked) {
                    return;
                }
                ShareEvent.sendRecognizeDialogClickEvent(RecognizeTokenDialogProxy.this.mTokenInfoBean, "cancel");
                ShareConfigManager.getInstance().onRecognizeTokenDialogDismissEvent(RecognizeTokenDialogProxy.this.mTokenDialog, RecognizeTokenDialogProxy.this.mTokenInfoBean);
            }
        };
        this.mDialogCallback = iTokenDialogCallback;
        IRecognizeTokenDialog iRecognizeTokenDialog2 = this.mTokenDialog;
        if (iRecognizeTokenDialog2 != null) {
            iRecognizeTokenDialog2.initTokenDialog(this.mTokenInfoBean, iTokenDialogCallback);
        }
    }

    public void dismiss() {
        IRecognizeTokenDialog iRecognizeTokenDialog;
        Activity activity = this.mContextRef.get();
        if (activity == null || activity.isFinishing() || (iRecognizeTokenDialog = this.mTokenDialog) == null || !iRecognizeTokenDialog.isShowing()) {
            return;
        }
        try {
            this.mTokenDialog.dismiss();
        } catch (Throwable unused) {
        }
    }

    public void show() {
        Activity activity = this.mContextRef.get();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (this.mTokenDialog != null && !ShareConfigManager.getInstance().interceptRecognizeTokenDialog(this.mTokenDialog)) {
            this.mTokenDialog.show();
        }
        ShareEvent.sendRecognizeDialogShowEvent(this.mTokenInfoBean);
        ShareConfigManager.getInstance().onRecognizeTokenDialogShowEvent(this.mTokenDialog, this.mTokenInfoBean);
    }
}
