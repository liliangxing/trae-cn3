package com.bytedance.ug.sdk.share.impl.p009ui.sysopt;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.DialogEventType;
import com.bytedance.ug.sdk.share.api.entity.DialogType;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.TokenShareInfo;
import com.bytedance.ug.sdk.share.api.p008ui.ISystemOptShareTokenDialog;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.model.ShareTokenType;
import com.bytedance.ug.sdk.share.impl.share.action.SystemShareAction;
import com.bytedance.ug.sdk.share.impl.utils.ClipboardCompat;
import com.bytedance.ug.sdk.share.impl.utils.SharePrefHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SystemOptShareTokenDialogProxy {
    private WeakReference<Activity> mContextRef;
    private ISystemOptShareTokenDialog.ITokenDialogCallback mDialogCallback;
    private boolean mIsDialogClicked;
    private ShareContent mShareModel;
    private ISystemOptShareTokenDialog mTokenDialog;
    private TokenShareInfo mTokenShareInfo;

    public SystemOptShareTokenDialogProxy(Activity activity, ShareContent shareContent, ArrayList<Uri> arrayList, ISystemOptShareTokenDialog iSystemOptShareTokenDialog) {
        this.mTokenDialog = iSystemOptShareTokenDialog;
        this.mShareModel = shareContent;
        this.mTokenShareInfo = shareContent.getTokenShareInfo();
        this.mContextRef = new WeakReference<>(activity);
        ISystemOptShareTokenDialog.ITokenDialogCallback iTokenDialogCallback = new ISystemOptShareTokenDialog.ITokenDialogCallback() { // from class: com.bytedance.ug.sdk.share.impl.ui.sysopt.SystemOptShareTokenDialogProxy.1
            @Override // com.bytedance.ug.sdk.share.api.ui.ISystemOptShareTokenDialog.ITokenDialogCallback
            public void onClick(boolean z, ArrayList<Uri> arrayList2) {
                SystemOptShareTokenDialogProxy.this.mIsDialogClicked = true;
                String description = SystemOptShareTokenDialogProxy.this.mTokenShareInfo.getDescription();
                if (!TextUtils.isEmpty(description)) {
                    Activity activity2 = (Activity) SystemOptShareTokenDialogProxy.this.mContextRef.get();
                    if (activity2 == null) {
                        return;
                    }
                    ClipboardCompat.setText(activity2, "", description);
                    SharePrefHelper.getInstance().setPref(SharePrefHelper.SP_USER_COPY_CONTENT, description);
                    SystemShareAction.shareTo(activity2, SystemOptShareTokenDialogProxy.this.mShareModel.getShareChanelType(), SystemOptShareTokenDialogProxy.this.mShareModel, arrayList2);
                }
                if (SystemOptShareTokenDialogProxy.this.mShareModel.getEventCallBack() != null) {
                    SystemOptShareTokenDialogProxy.this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_NORMAL, DialogEventType.CLICK, ShareTokenType.TEXT_SYS_OPT, SystemOptShareTokenDialogProxy.this.mShareModel);
                }
                ShareEvent.sendShareDialogClickEvent(SystemOptShareTokenDialogProxy.this.mShareModel, "go_share", "submit");
                if (z) {
                    SystemOptShareTokenDialogProxy.this.dismiss();
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.ui.ISystemOptShareTokenDialog.ITokenDialogCallback
            public void onDismiss() {
                if (SystemOptShareTokenDialogProxy.this.mIsDialogClicked) {
                    return;
                }
                ShareEvent.sendShareDialogClickEvent(SystemOptShareTokenDialogProxy.this.mShareModel, "go_share", "cancel");
                if (SystemOptShareTokenDialogProxy.this.mShareModel != null && SystemOptShareTokenDialogProxy.this.mShareModel.getEventCallBack() != null) {
                    SystemOptShareTokenDialogProxy.this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_NORMAL, DialogEventType.DISMISS, ShareTokenType.TEXT_SYS_OPT, SystemOptShareTokenDialogProxy.this.mShareModel);
                }
                MonitorEvent.monitorPanelClick(2, System.currentTimeMillis() - MonitorEvent.mPanelClickTime);
            }
        };
        this.mDialogCallback = iTokenDialogCallback;
        ISystemOptShareTokenDialog iSystemOptShareTokenDialog2 = this.mTokenDialog;
        if (iSystemOptShareTokenDialog2 != null) {
            iSystemOptShareTokenDialog2.initTokenDialog(this.mShareModel, arrayList, iTokenDialogCallback);
        }
    }

    public void dismiss() {
        ISystemOptShareTokenDialog iSystemOptShareTokenDialog;
        Activity activity = this.mContextRef.get();
        if (activity == null || activity.isFinishing() || (iSystemOptShareTokenDialog = this.mTokenDialog) == null || !iSystemOptShareTokenDialog.isShowing()) {
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
        ISystemOptShareTokenDialog iSystemOptShareTokenDialog = this.mTokenDialog;
        if (iSystemOptShareTokenDialog != null) {
            iSystemOptShareTokenDialog.show();
        }
        ShareEvent.sendShareDialogShowEvent(this.mShareModel, "go_share");
        if (this.mShareModel.getEventCallBack() != null) {
            this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_NORMAL, DialogEventType.SHOW, ShareTokenType.TEXT_SYS_OPT, this.mShareModel);
        }
    }
}
