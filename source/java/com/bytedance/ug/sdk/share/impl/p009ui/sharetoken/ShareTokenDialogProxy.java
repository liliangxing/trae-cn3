package com.bytedance.ug.sdk.share.impl.p009ui.sharetoken;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.DialogEventType;
import com.bytedance.ug.sdk.share.api.entity.DialogType;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.entity.TokenShareInfo;
import com.bytedance.ug.sdk.share.api.p008ui.IShareTokenDialog;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.model.ShareTokenType;
import com.bytedance.ug.sdk.share.impl.utils.ClipboardCompat;
import com.bytedance.ug.sdk.share.impl.utils.SharePrefHelper;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShareTokenDialogProxy {
    private WeakReference<Activity> mContextRef;
    private IShareTokenDialog.ITokenDialogCallback mDialogCallback;
    private boolean mIsDialogClicked;
    private ShareContent mShareModel;
    private IShareTokenDialog mTokenDialog;
    private TokenShareInfo mTokenShareInfo;

    public ShareTokenDialogProxy(Activity activity, ShareContent shareContent, IShareTokenDialog iShareTokenDialog) {
        this.mTokenDialog = iShareTokenDialog;
        this.mShareModel = shareContent;
        this.mTokenShareInfo = shareContent.getTokenShareInfo();
        this.mContextRef = new WeakReference<>(activity);
        IShareTokenDialog.ITokenDialogCallback iTokenDialogCallback = new IShareTokenDialog.ITokenDialogCallback() { // from class: com.bytedance.ug.sdk.share.impl.ui.sharetoken.ShareTokenDialogProxy.1
            @Override // com.bytedance.ug.sdk.share.api.ui.IShareTokenDialog.ITokenDialogCallback
            public void onClick(boolean z) {
                ShareTokenDialogProxy.this.mIsDialogClicked = true;
                String description = ShareTokenDialogProxy.this.mTokenShareInfo.getDescription();
                if (!TextUtils.isEmpty(description)) {
                    ShareTokenDialogProxy shareTokenDialogProxy = ShareTokenDialogProxy.this;
                    shareTokenDialogProxy.continueToShare((Context) shareTokenDialogProxy.mContextRef.get(), description);
                    ShareResult.sendShareStatus(10000, ShareTokenDialogProxy.this.mShareModel);
                }
                if (ShareTokenDialogProxy.this.mShareModel.getEventCallBack() != null) {
                    ShareTokenDialogProxy.this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_NORMAL, DialogEventType.CLICK, ShareTokenType.TEXT, ShareTokenDialogProxy.this.mShareModel);
                }
                ShareEvent.sendShareDialogClickEvent(ShareTokenDialogProxy.this.mShareModel, "go_share", "submit");
                if (z) {
                    ShareTokenDialogProxy.this.dismiss();
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.ui.IShareTokenDialog.ITokenDialogCallback
            public void onDismiss() {
                if (ShareTokenDialogProxy.this.mIsDialogClicked) {
                    return;
                }
                ShareEvent.sendShareDialogClickEvent(ShareTokenDialogProxy.this.mShareModel, "go_share", "cancel");
                if (ShareTokenDialogProxy.this.mShareModel != null && ShareTokenDialogProxy.this.mShareModel.getEventCallBack() != null) {
                    ShareTokenDialogProxy.this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_NORMAL, DialogEventType.DISMISS, ShareTokenType.TEXT, ShareTokenDialogProxy.this.mShareModel);
                }
                MonitorEvent.monitorPanelClick(2, System.currentTimeMillis() - MonitorEvent.mPanelClickTime);
            }
        };
        this.mDialogCallback = iTokenDialogCallback;
        IShareTokenDialog iShareTokenDialog2 = this.mTokenDialog;
        if (iShareTokenDialog2 != null) {
            iShareTokenDialog2.initTokenDialog(this.mShareModel, iTokenDialogCallback);
        }
    }

    public void dismiss() {
        IShareTokenDialog iShareTokenDialog;
        Activity activity = this.mContextRef.get();
        if (activity == null || activity.isFinishing() || (iShareTokenDialog = this.mTokenDialog) == null || !iShareTokenDialog.isShowing()) {
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
        IShareTokenDialog iShareTokenDialog = this.mTokenDialog;
        if (iShareTokenDialog != null) {
            iShareTokenDialog.show();
        }
        ShareEvent.sendShareDialogShowEvent(this.mShareModel, "go_share");
        if (this.mShareModel.getEventCallBack() != null) {
            this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_NORMAL, DialogEventType.SHOW, ShareTokenType.TEXT, this.mShareModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continueToShare(Context context, String str) {
        if (context == null) {
            return;
        }
        ClipboardCompat.setText(context, "", str);
        SharePrefHelper.getInstance().setPref(SharePrefHelper.SP_USER_COPY_CONTENT, str);
        ShareUtils.jumpToTargetApp(context, this.mShareModel.getShareChanelType());
    }
}
