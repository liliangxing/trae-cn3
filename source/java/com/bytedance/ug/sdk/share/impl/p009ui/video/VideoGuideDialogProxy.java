package com.bytedance.ug.sdk.share.impl.p009ui.video;

import android.app.Activity;
import com.bytedance.ug.sdk.share.api.entity.DialogEventType;
import com.bytedance.ug.sdk.share.api.entity.DialogType;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.p008ui.IVideoGuideDialog;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.helper.VideoShareActionHelper;
import com.bytedance.ug.sdk.share.impl.model.ShareTokenType;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class VideoGuideDialogProxy {
    private WeakReference<Activity> mContextRef;
    private IVideoGuideDialog.ITokenDialogCallback mDialogCallback;
    private boolean mIsDialogClicked;
    private ShareContent mShareModel;
    private IVideoGuideDialog mTokenDialog;

    public VideoGuideDialogProxy(Activity activity, ShareContent shareContent, IVideoGuideDialog iVideoGuideDialog) {
        this.mTokenDialog = iVideoGuideDialog;
        this.mShareModel = shareContent;
        this.mContextRef = new WeakReference<>(activity);
        IVideoGuideDialog.ITokenDialogCallback iTokenDialogCallback = new IVideoGuideDialog.ITokenDialogCallback() { // from class: com.bytedance.ug.sdk.share.impl.ui.video.VideoGuideDialogProxy.1
            @Override // com.bytedance.ug.sdk.share.api.ui.IVideoGuideDialog.ITokenDialogCallback
            public void onClick(boolean z) {
                VideoGuideDialogProxy.this.mIsDialogClicked = true;
                if (!new VideoShareActionHelper().directShareVideo(VideoGuideDialogProxy.this.mShareModel)) {
                    ShareResult.sendShareStatus(ShareResult.ERROR_SDK_UNKNOWN, VideoGuideDialogProxy.this.mShareModel);
                }
                if (VideoGuideDialogProxy.this.mShareModel.getEventCallBack() != null) {
                    VideoGuideDialogProxy.this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_GUIDE, DialogEventType.CLICK, ShareTokenType.VIDEO, VideoGuideDialogProxy.this.mShareModel);
                }
                ShareEvent.sendShareDialogClickEvent(VideoGuideDialogProxy.this.mShareModel, "lead_share", "submit");
                if (z) {
                    VideoGuideDialogProxy.this.dismiss();
                }
            }

            @Override // com.bytedance.ug.sdk.share.api.ui.IVideoGuideDialog.ITokenDialogCallback
            public void onDismiss() {
                if (VideoGuideDialogProxy.this.mIsDialogClicked) {
                    return;
                }
                ShareEvent.sendShareDialogClickEvent(VideoGuideDialogProxy.this.mShareModel, "lead_share", "cancel");
                if (VideoGuideDialogProxy.this.mShareModel != null && VideoGuideDialogProxy.this.mShareModel.getEventCallBack() != null) {
                    VideoGuideDialogProxy.this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_GUIDE, DialogEventType.DISMISS, ShareTokenType.VIDEO, VideoGuideDialogProxy.this.mShareModel);
                }
                MonitorEvent.monitorPanelClick(2, System.currentTimeMillis() - MonitorEvent.mPanelClickTime);
            }
        };
        this.mDialogCallback = iTokenDialogCallback;
        IVideoGuideDialog iVideoGuideDialog2 = this.mTokenDialog;
        if (iVideoGuideDialog2 != null) {
            iVideoGuideDialog2.initTokenDialog(this.mShareModel, iTokenDialogCallback);
        }
    }

    public void dismiss() {
        IVideoGuideDialog iVideoGuideDialog;
        Activity activity = this.mContextRef.get();
        if (activity == null || activity.isFinishing() || (iVideoGuideDialog = this.mTokenDialog) == null || !iVideoGuideDialog.isShowing()) {
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
        IVideoGuideDialog iVideoGuideDialog = this.mTokenDialog;
        if (iVideoGuideDialog != null) {
            iVideoGuideDialog.show();
        }
        ShareEvent.sendShareDialogShowEvent(this.mShareModel, "lead_share");
        if (this.mShareModel.getEventCallBack() != null) {
            this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_GUIDE, DialogEventType.SHOW, ShareTokenType.VIDEO, this.mShareModel);
        }
    }
}
