package com.bytedance.ug.sdk.share.image.manager;

import android.app.Activity;
import com.bytedance.share_image_token.R;
import com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback;
import com.bytedance.ug.sdk.share.api.entity.DialogEventType;
import com.bytedance.ug.sdk.share.api.entity.DialogType;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.p008ui.IImageTokenDialog;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.image.utils.ImageConfigUtils;
import com.bytedance.ug.sdk.share.image.utils.ImageSaveUtils;
import com.bytedance.ug.sdk.share.impl.event.MonitorEvent;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.model.ShareTokenType;
import com.bytedance.ug.sdk.share.impl.share.action.SystemShareAction;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import com.bytedance.ug.sdk.share.impl.utils.ToastUtils;
import java.lang.ref.WeakReference;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ImageTokenDialogProxy {
    private WeakReference<Activity> mContextRef;
    private IImageTokenDialog.ITokenDialogCallback mDialogCallback;
    private boolean mIsDialogClicked;
    private ShareContent mShareModel;
    private IImageTokenDialog mTokenDialog;

    public ImageTokenDialogProxy(Activity activity, final ShareContent shareContent, IImageTokenDialog iImageTokenDialog) {
        this.mTokenDialog = iImageTokenDialog;
        this.mShareModel = shareContent;
        this.mContextRef = new WeakReference<>(activity);
        IImageTokenDialog.ITokenDialogCallback iTokenDialogCallback = new IImageTokenDialog.ITokenDialogCallback() { // from class: com.bytedance.ug.sdk.share.image.manager.ImageTokenDialogProxy.1
            @Override // com.bytedance.ug.sdk.share.api.ui.IImageTokenDialog.ITokenDialogCallback
            public void onClick(final boolean z) {
                ImageTokenDialogProxy.this.mIsDialogClicked = true;
                final Activity activity2 = (Activity) ImageTokenDialogProxy.this.mContextRef.get();
                ShareUtils.requestWritePermission(activity2, ImageTokenDialogProxy.this.mShareModel, new RequestPermissionsCallback() { // from class: com.bytedance.ug.sdk.share.image.manager.ImageTokenDialogProxy.1.1
                    @Override // com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback
                    public void onGranted() {
                        ImageTokenDialogProxy.this.saveAndShare();
                        if (z) {
                            ImageTokenDialogProxy.this.dismiss();
                        }
                    }

                    @Override // com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback
                    public void onDenied(String str) {
                        ToastUtils.showToast(activity2, shareContent, 10, R.string.share_sdk_pic_save_failed);
                        if (z) {
                            ImageTokenDialogProxy.this.dismiss();
                        }
                    }
                });
                if (ImageTokenDialogProxy.this.mShareModel.getEventCallBack() != null) {
                    ImageTokenDialogProxy.this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_NORMAL, DialogEventType.CLICK, ShareTokenType.IMAGE, ImageTokenDialogProxy.this.mShareModel);
                }
                ShareEvent.sendShareDialogClickEvent(ImageTokenDialogProxy.this.mShareModel, "go_share", "submit");
            }

            @Override // com.bytedance.ug.sdk.share.api.ui.IImageTokenDialog.ITokenDialogCallback
            public void onDismiss() {
                if (ImageTokenDialogProxy.this.mIsDialogClicked) {
                    return;
                }
                ShareEvent.sendShareDialogClickEvent(ImageTokenDialogProxy.this.mShareModel, "go_share", "cancel");
                if (ImageTokenDialogProxy.this.mShareModel != null && ImageTokenDialogProxy.this.mShareModel.getEventCallBack() != null) {
                    ImageTokenDialogProxy.this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_NORMAL, DialogEventType.DISMISS, ShareTokenType.IMAGE, ImageTokenDialogProxy.this.mShareModel);
                }
                MonitorEvent.monitorPanelClick(2, System.currentTimeMillis() - MonitorEvent.mPanelClickTime);
            }
        };
        this.mDialogCallback = iTokenDialogCallback;
        IImageTokenDialog iImageTokenDialog2 = this.mTokenDialog;
        if (iImageTokenDialog2 != null) {
            iImageTokenDialog2.initTokenDialog(this.mShareModel, iTokenDialogCallback);
        }
    }

    public void dismiss() {
        IImageTokenDialog iImageTokenDialog;
        Activity activity = this.mContextRef.get();
        if (activity == null || activity.isFinishing() || (iImageTokenDialog = this.mTokenDialog) == null || !iImageTokenDialog.isShowing()) {
            return;
        }
        this.mTokenDialog.dismiss();
    }

    public void show() {
        Activity activity = this.mContextRef.get();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        IImageTokenDialog iImageTokenDialog = this.mTokenDialog;
        if (iImageTokenDialog != null) {
            iImageTokenDialog.show();
        }
        ShareEvent.sendShareDialogShowEvent(this.mShareModel, "go_share");
        if (this.mShareModel.getEventCallBack() != null) {
            this.mShareModel.getEventCallBack().onTokenDialogEvent(DialogType.TOKEN_NORMAL, DialogEventType.SHOW, ShareTokenType.IMAGE, this.mShareModel);
        }
    }

    private void continueToShare(Activity activity) {
        ShareChannelType shareChanelType;
        if (activity == null || (shareChanelType = this.mShareModel.getShareChanelType()) == null) {
            return;
        }
        if (ImageConfigUtils.isEnableImageTokenShareOpt()) {
            int i = C10382.$SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType[shareChanelType.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                this.mShareModel.setSystemShareType(ShareContentType.IMAGE);
                SystemShareAction.shareTo(activity, this.mShareModel.getShareChanelType(), this.mShareModel);
                return;
            } else {
                jumpToApp(activity);
                return;
            }
        }
        jumpToApp(activity);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.ug.sdk.share.image.manager.ImageTokenDialogProxy$2 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static /* synthetic */ class C10382 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType;

        static {
            int[] iArr = new int[ShareChannelType.values().length];
            $SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType = iArr;
            try {
                iArr[ShareChannelType.QQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType[ShareChannelType.WX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$ug$sdk$share$api$panel$ShareChannelType[ShareChannelType.WX_TIMELINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void jumpToApp(Activity activity) {
        ShareUtils.jumpToTargetApp(activity, this.mShareModel.getShareChanelType());
        ShareResult.sendShareStatus(10000, this.mShareModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAndShare() {
        if (this.mShareModel.getImage() == null) {
            return;
        }
        Activity activity = this.mContextRef.get();
        if (ImageSaveUtils.saveBitmapWithHiddenStr(activity, this.mShareModel) && !ImageConfigUtils.isEnableImageTokenShareOpt()) {
            ToastUtils.showToast(activity, this.mShareModel, 11, R.string.share_sdk_pic_had_saved_to_album);
        }
        continueToShare(activity);
    }
}
