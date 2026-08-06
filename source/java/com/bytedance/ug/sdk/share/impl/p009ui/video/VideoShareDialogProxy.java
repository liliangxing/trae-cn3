package com.bytedance.ug.sdk.share.impl.p009ui.video;

import android.app.Activity;
import com.bytedance.ug.sdk.share.api.entity.DialogEventType;
import com.bytedance.ug.sdk.share.api.entity.DialogType;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.p008ui.IVideoShareDialog;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.model.ShareTokenType;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class VideoShareDialogProxy {
    private WeakReference<Activity> mContextRef;
    private IVideoShareDialog.ITokenDialogCallback mDialogCallback;
    private boolean mIsDialogClicked;
    private ShareContent mShareModel;
    private IVideoShareDialog mTokenDialog;

    public VideoShareDialogProxy(Activity activity, final ShareContent shareContent, IVideoShareDialog iVideoShareDialog) {
        this.mTokenDialog = iVideoShareDialog;
        this.mShareModel = shareContent;
        this.mContextRef = new WeakReference<>(activity);
        IVideoShareDialog.ITokenDialogCallback iTokenDialogCallback = new IVideoShareDialog.ITokenDialogCallback() { // from class: com.bytedance.ug.sdk.share.impl.ui.video.VideoShareDialogProxy.1
            @Override // com.bytedance.ug.sdk.share.api.ui.IVideoShareDialog.ITokenDialogCallback
            public void onClick(boolean z) {
                VideoShareDialogProxy.this.mIsDialogClicked = true;
                Activity activity2 = (Activity) VideoShareDialogProxy.this.mContextRef.get();
                if (activity2 != null) {
                    ShareUtils.jumpToTargetApp(activity2, VideoShareDialogProxy.this.mShareModel.getShareChanelType());
                    ShareResult.sendShareStatus(10000, shareContent);
                }
                if (VideoShareDialogProxy.this.mShareModel.getEventCallBack() != null) {
                    VideoShareDialogProxy.this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_NORMAL, DialogEventType.CLICK, ShareTokenType.VIDEO, VideoShareDialogProxy.this.mShareModel);
                }
                ShareEvent.sendShareDialogClickEvent(VideoShareDialogProxy.this.mShareModel, "go_share", "submit");
                if (z) {
                    VideoShareDialogProxy.this.dismiss();
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.ui.IVideoShareDialog.ITokenDialogCallback
            public void onDismiss() {
                if (VideoShareDialogProxy.this.mIsDialogClicked) {
                    return;
                }
                ShareEvent.sendShareDialogClickEvent(VideoShareDialogProxy.this.mShareModel, "go_share", "cancel");
                if (VideoShareDialogProxy.this.mShareModel != null && VideoShareDialogProxy.this.mShareModel.getEventCallBack() != null) {
                    VideoShareDialogProxy.this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_NORMAL, DialogEventType.DISMISS, ShareTokenType.VIDEO, VideoShareDialogProxy.this.mShareModel);
                }
                MonitorEvent.monitorPanelClick(2, System.currentTimeMillis() - MonitorEvent.mPanelClickTime);
            }
        };
        this.mDialogCallback = iTokenDialogCallback;
        IVideoShareDialog iVideoShareDialog2 = this.mTokenDialog;
        if (iVideoShareDialog2 != null) {
            iVideoShareDialog2.initTokenDialog(this.mShareModel, iTokenDialogCallback);
        }
    }

    public void dismiss() {
        IVideoShareDialog iVideoShareDialog;
        Activity activity = this.mContextRef.get();
        if (activity == null || activity.isFinishing() || (iVideoShareDialog = this.mTokenDialog) == null || !iVideoShareDialog.isShowing()) {
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
        IVideoShareDialog iVideoShareDialog = this.mTokenDialog;
        if (iVideoShareDialog != null) {
            iVideoShareDialog.show();
        }
        ShareEvent.sendShareDialogShowEvent(this.mShareModel, "go_share");
        if (this.mShareModel.getEventCallBack() != null) {
            this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_NORMAL, DialogEventType.SHOW, ShareTokenType.VIDEO, this.mShareModel);
        }
    }
}
