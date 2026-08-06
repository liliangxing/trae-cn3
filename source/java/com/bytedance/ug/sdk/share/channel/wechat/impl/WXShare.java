package com.bytedance.ug.sdk.share.channel.wechat.impl;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.share_wechat.R;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareExtra;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.api.entity.ToastCode;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.channel.wechat.model.WXExtra;
import com.bytedance.ug.sdk.share.channel.wechat.utils.OnImageLoadListener;
import com.bytedance.ug.sdk.share.channel.wechat.utils.WXImageUtils;
import com.bytedance.ug.sdk.share.channel.wechat.wxshare.WXShareFacory;
import com.bytedance.ug.sdk.share.channel.wechat.wxshare.WXShareSignHelper;
import com.bytedance.ug.sdk.share.impl.callback.FileShareCallback;
import com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.helper.FileShareHelper;
import com.bytedance.ug.sdk.share.impl.helper.ImageShareHelper;
import com.bytedance.ug.sdk.share.impl.network.request.GetSignInfoThread;
import com.bytedance.ug.sdk.share.impl.share.BaseSdkShare;
import com.bytedance.ug.sdk.share.impl.utils.ShareUtils;
import com.bytedance.ug.sdk.share.impl.utils.ToastUtils;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class WXShare extends BaseSdkShare {
    private static int MAX_DESCRIPTION_LENGTH = 1000;
    private static int MAX_TITLE_LENGTH = 500;
    private IWXAPI mWxApi;

    @Override // com.bytedance.ug.sdk.share.impl.share.BaseSdkShare
    protected String getClassName() {
        return "com.tencent.mm.ui.tools.ShareImgUI";
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.AbstractShare, com.bytedance.ug.sdk.share.impl.share.api.IShare
    public String getPackageName() {
        return "com.tencent.mm";
    }

    public WXShare(Context context) {
        super(context);
        String weChatKey = ShareConfigManager.getInstance().getWeChatKey();
        if (TextUtils.isEmpty(weChatKey)) {
            return;
        }
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(this.mContext, weChatKey, true);
        this.mWxApi = createWXAPI;
        if (createWXAPI.registerApp(weChatKey)) {
            return;
        }
        this.mWxApi = null;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.AbstractShare, com.bytedance.ug.sdk.share.impl.share.api.IShare
    public boolean canShare(ShareContent shareContent) {
        IWXAPI iwxapi = this.mWxApi;
        if (iwxapi == null) {
            ShareResult.sendShareStatus(ShareResult.ERROR_SDK_APP_INIT_FAILED, shareContent);
            return false;
        }
        if (iwxapi.isWXAppInstalled()) {
            return true;
        }
        ShareResult.sendShareStatus(ShareResult.ERROR_SDK_APP_NOT_INSTALL, shareContent);
        ToastUtils.showToastWithIcon(this.mContext, shareContent, 104, R.drawable.share_sdk_close_popup_textpage, R.string.share_sdk_toast_weixin_not_install);
        return false;
    }

    private int getScene(ShareContent shareContent) {
        return shareContent.getShareChanelType() == ShareChannelType.WX ? 0 : 1;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.BaseSdkShare
    protected boolean shareImageAndText(ShareContent shareContent) {
        this.mErrorCode = ShareResult.ERROR_SDK_IMAGE_AND_TEXT_NOT_SUPPORT;
        return false;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.BaseSdkShare
    protected boolean shareText(ShareContent shareContent) {
        if (TextUtils.isEmpty(shareContent.getTitle())) {
            this.mErrorCode = ShareResult.ERROR_SDK_TEXT_TITLE_EMPTY;
            return false;
        }
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = shareContent.getTitle();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = shareContent.getTitle();
        WXShareSignHelper.signText(shareContent, wXTextObject, generateSignCallback(shareContent, wXMediaMessage));
        return true;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.BaseSdkShare
    protected boolean shareMiniApp(final ShareContent shareContent) {
        ShareExtra extraParams = shareContent.getExtraParams();
        if (extraParams == null || extraParams.getWXExtra() == null || !(extraParams.getWXExtra() instanceof WXExtra)) {
            this.mErrorCode = ShareResult.ERROR_SDK_MINIAPP_DATA_ERROR;
            return false;
        }
        WXExtra wXExtra = (WXExtra) extraParams.getWXExtra();
        String miniAppId = wXExtra.getMiniAppId();
        if (TextUtils.isEmpty(miniAppId)) {
            this.mErrorCode = ShareResult.ERROR_SDK_MINIAPP_ID_EMPTY;
            return false;
        }
        if (TextUtils.isEmpty(shareContent.getTargetUrl())) {
            this.mErrorCode = ShareResult.ERROR_SDK_MINIAPP_WEB_URL_EMPTY;
            return false;
        }
        if (TextUtils.isEmpty(shareContent.getTitle())) {
            this.mErrorCode = ShareResult.ERROR_SDK_MINIAPP_TITLE_EMPTY;
            return false;
        }
        if (TextUtils.isEmpty(shareContent.getImageUrl()) && shareContent.getImage() == null) {
            this.mErrorCode = ShareResult.ERROR_SDK_MINIAPP_IMAGE_EMPTY;
            return false;
        }
        final WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = shareContent.getTargetUrl();
        int miniprogramType = wXExtra.getMiniprogramType();
        if (miniprogramType >= 0 && miniprogramType <= 2) {
            wXMiniProgramObject.miniprogramType = miniprogramType;
        } else {
            wXMiniProgramObject.miniprogramType = 0;
        }
        wXMiniProgramObject.userName = miniAppId;
        String miniAppPath = wXExtra.getMiniAppPath();
        if (!TextUtils.isEmpty(miniAppPath)) {
            wXMiniProgramObject.path = miniAppPath;
        }
        final WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
        wXMediaMessage.title = shareContent.getTitle();
        if (!TextUtils.isEmpty(shareContent.getText())) {
            wXMediaMessage.description = shareContent.getText();
        }
        if (shareContent.getImage() == null && TextUtils.isEmpty(shareContent.getImageUrl())) {
            return false;
        }
        WXImageUtils.getImageBytes(shareContent, new OnImageLoadListener() { // from class: com.bytedance.ug.sdk.share.channel.wechat.impl.WXShare.1
            @Override // com.bytedance.ug.sdk.share.channel.wechat.utils.OnImageLoadListener
            public void onLoaded(byte[] bArr) {
                if (bArr == null) {
                    ShareResult.sendShareStatus(ShareResult.ERROR_SDK_MINIAPP_IMAGE_EMPTY, shareContent);
                    return;
                }
                wXMediaMessage.thumbData = bArr;
                ShareContent shareContent2 = shareContent;
                WXMiniProgramObject wXMiniProgramObject2 = wXMiniProgramObject;
                WXMediaMessage wXMediaMessage2 = wXMediaMessage;
                WXShareSignHelper.signMiniApp(shareContent2, wXMiniProgramObject2, wXMediaMessage2, WXShare.this.generateSignCallback(shareContent2, 0, wXMediaMessage2));
            }
        }, true, true);
        return true;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.BaseSdkShare
    protected boolean shareH5(final ShareContent shareContent) {
        if (TextUtils.isEmpty(shareContent.getTargetUrl())) {
            this.mErrorCode = ShareResult.ERROR_SDK_H5_URL_EMPTY;
            return false;
        }
        if (TextUtils.isEmpty(shareContent.getTitle())) {
            this.mErrorCode = ShareResult.ERROR_SDK_H5_TITLE_EMPTY;
            return false;
        }
        final WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = shareContent.getTargetUrl();
        final WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = ShareUtils.getMaxLengthStr(shareContent.getTitle(), MAX_TITLE_LENGTH);
        String maxLengthStr = ShareUtils.getMaxLengthStr(shareContent.getText(), MAX_DESCRIPTION_LENGTH);
        if (!TextUtils.isEmpty(maxLengthStr)) {
            wXMediaMessage.description = maxLengthStr;
        }
        if (shareContent.getImage() != null || !TextUtils.isEmpty(shareContent.getImageUrl())) {
            WXImageUtils.getImageBytes(shareContent, new OnImageLoadListener() { // from class: com.bytedance.ug.sdk.share.channel.wechat.impl.WXShare.2
                @Override // com.bytedance.ug.sdk.share.channel.wechat.utils.OnImageLoadListener
                public void onLoaded(byte[] bArr) {
                    wXMediaMessage.thumbData = bArr;
                    ShareContent shareContent2 = shareContent;
                    WXWebpageObject wXWebpageObject2 = wXWebpageObject;
                    WXMediaMessage wXMediaMessage2 = wXMediaMessage;
                    WXShareSignHelper.signH5(shareContent2, wXWebpageObject2, wXMediaMessage2, WXShare.this.generateSignCallback(shareContent2, wXMediaMessage2));
                }
            });
            return true;
        }
        WXShareSignHelper.signH5(shareContent, wXWebpageObject, wXMediaMessage, generateSignCallback(shareContent, wXMediaMessage));
        return true;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.BaseSdkShare
    protected boolean shareAudio(final ShareContent shareContent) {
        if (TextUtils.isEmpty(shareContent.getTargetUrl())) {
            this.mErrorCode = ShareResult.ERROR_SDK_AUDIO_TARGET_URL_EMPTY;
            return false;
        }
        if (TextUtils.isEmpty(shareContent.getAudioUrl())) {
            this.mErrorCode = ShareResult.ERROR_SDK_AUDIO_URL_EMPTY;
            return false;
        }
        if (TextUtils.isEmpty(shareContent.getTitle())) {
            this.mErrorCode = ShareResult.ERROR_SDK_AUDIO_TITLE_EMPTY;
            return false;
        }
        if (shareContent.getImage() != null || !TextUtils.isEmpty(shareContent.getImageUrl())) {
            WXImageUtils.getImageBytes(shareContent, new OnImageLoadListener() { // from class: com.bytedance.ug.sdk.share.channel.wechat.impl.WXShare.3
                @Override // com.bytedance.ug.sdk.share.channel.wechat.utils.OnImageLoadListener
                public void onLoaded(byte[] bArr) {
                    WXShare.this.shareAudio(shareContent, bArr);
                }
            });
            return true;
        }
        shareAudio(shareContent, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareAudio(ShareContent shareContent, byte[] bArr) {
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = shareContent.getTargetUrl() + "#wechat_music_url=" + shareContent.getAudioUrl();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.title = ShareUtils.getMaxLengthStr(shareContent.getTitle(), MAX_TITLE_LENGTH);
        if (!TextUtils.isEmpty(shareContent.getText())) {
            wXMediaMessage.description = ShareUtils.getMaxLengthStr(shareContent.getText(), MAX_DESCRIPTION_LENGTH);
        }
        if (bArr != null) {
            wXMediaMessage.thumbData = bArr;
        }
        WXShareSignHelper.signAudio(shareContent, wXMusicObject, wXMediaMessage, generateSignCallback(shareContent, wXMediaMessage));
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.BaseSdkShare
    protected boolean shareImage(final ShareContent shareContent) {
        String imageUrl = shareContent.getImageUrl();
        if (shareContent.getImage() == null && TextUtils.isEmpty(imageUrl)) {
            this.mErrorCode = ShareResult.ERROR_SDK_IMAGE_URL_EMPTY;
            return false;
        }
        ImageShareHelper imageShareHelper = new ImageShareHelper();
        if (!TextUtils.isEmpty(imageUrl)) {
            if (imageShareHelper.isLocalUrl(imageUrl)) {
                shareImage(shareContent, imageUrl);
                return true;
            }
            imageShareHelper.shareImage(shareContent, new ImageShareCallback() { // from class: com.bytedance.ug.sdk.share.channel.wechat.impl.WXShare.4
                @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
                public void onShareSuccess(String str) {
                    WXShare.this.shareImage(shareContent, str);
                }

                @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
                public void onShareFailed() {
                    ShareResult.sendShareStatus(ShareResult.ERROR_SDK_IMAGE_FETCH_FAILED, shareContent);
                }
            }, false);
            return true;
        }
        String saveImagePath = imageShareHelper.getSaveImagePath(shareContent.getImage());
        if (TextUtils.isEmpty(saveImagePath)) {
            return true;
        }
        shareImage(shareContent, saveImagePath);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareImage(ShareContent shareContent, String str) {
        WXImageObject wXImageObject = new WXImageObject();
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXImageObject);
        if (checkVersionValid() && ShareUtils.checkAndroidNotBelowN()) {
            wXImageObject.imagePath = ShareUtils.getFileProviderUri(this.mContext, "com.tencent.mm", str);
        } else {
            wXImageObject.imagePath = str;
        }
        realShare(wXMediaMessage, getScene(shareContent), shareContent);
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.BaseSdkShare
    protected boolean shareFile(final ShareContent shareContent) {
        if (TextUtils.isEmpty(shareContent.getFileUrl())) {
            this.mErrorCode = ShareResult.ERROR_SDK_FILE_URL_EMPTY;
            return false;
        }
        if (TextUtils.isEmpty(shareContent.getFileName())) {
            this.mErrorCode = ShareResult.ERROR_SDK_FILE_NAME_EMPTY;
            return false;
        }
        FileShareHelper.getInstance().shareFile(shareContent, new FileShareCallback() { // from class: com.bytedance.ug.sdk.share.channel.wechat.impl.WXShare.5
            @Override // com.bytedance.ug.sdk.share.impl.callback.FileShareCallback
            public void onShareSuccess(String str) {
                WXShare.this.shareFile(shareContent, str);
            }

            @Override // com.bytedance.ug.sdk.share.impl.callback.FileShareCallback
            public void onShareFailed() {
                ShareResult.sendShareStatus(ShareResult.ERROR_SDK_FILE_FETCH_FAILED, shareContent);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shareFile(ShareContent shareContent, String str) {
        WXFileObject wXFileObject;
        if (checkVersionValid() && ShareUtils.checkAndroidNotBelowN()) {
            wXFileObject = new WXFileObject(ShareUtils.getFileProviderUri(this.mContext, "com.tencent.mm", str));
        } else {
            wXFileObject = new WXFileObject(str);
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXFileObject);
        wXMediaMessage.title = shareContent.getFileName();
        realShare(wXMediaMessage, 0, shareContent);
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.BaseSdkShare
    protected boolean shareVideo(ShareContent shareContent) {
        if (shareContent.getShareChanelType() == ShareChannelType.WX) {
            return super.shareVideo(shareContent);
        }
        return shareVideoBySDK(shareContent);
    }

    private boolean shareVideoBySDK(final ShareContent shareContent) {
        if (TextUtils.isEmpty(shareContent.getTargetUrl())) {
            this.mErrorCode = ShareResult.ERROR_SDK_VIDEO_TARGET_URL_EMPTY;
            return false;
        }
        if (TextUtils.isEmpty(shareContent.getTitle())) {
            this.mErrorCode = ShareResult.ERROR_SDK_VIDEO_TITLE_EMPTY;
            return false;
        }
        final WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = shareContent.getTargetUrl();
        final WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
        wXMediaMessage.title = ShareUtils.getMaxLengthStr(shareContent.getTitle(), MAX_TITLE_LENGTH);
        String maxLengthStr = ShareUtils.getMaxLengthStr(shareContent.getText(), MAX_DESCRIPTION_LENGTH);
        if (!TextUtils.isEmpty(maxLengthStr)) {
            wXMediaMessage.description = maxLengthStr;
        }
        if (shareContent.getImage() != null || !TextUtils.isEmpty(shareContent.getImageUrl())) {
            WXImageUtils.getImageBytes(shareContent, new OnImageLoadListener() { // from class: com.bytedance.ug.sdk.share.channel.wechat.impl.WXShare.6
                @Override // com.bytedance.ug.sdk.share.channel.wechat.utils.OnImageLoadListener
                public void onLoaded(byte[] bArr) {
                    wXMediaMessage.thumbData = bArr;
                    ShareContent shareContent2 = shareContent;
                    WXVideoObject wXVideoObject2 = wXVideoObject;
                    WXMediaMessage wXMediaMessage2 = wXMediaMessage;
                    WXShareSignHelper.signVideo(shareContent2, wXVideoObject2, wXMediaMessage2, WXShare.this.generateSignCallback(shareContent2, wXMediaMessage2));
                }
            });
            return true;
        }
        WXShareSignHelper.signVideo(shareContent, wXVideoObject, wXMediaMessage, generateSignCallback(shareContent, wXMediaMessage));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GetSignInfoThread.GetSignInfoCallback generateSignCallback(ShareContent shareContent, WXMediaMessage wXMediaMessage) {
        return generateSignCallback(shareContent, getScene(shareContent), wXMediaMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public GetSignInfoThread.GetSignInfoCallback generateSignCallback(final ShareContent shareContent, final int i, final WXMediaMessage wXMediaMessage) {
        return new GetSignInfoThread.GetSignInfoCallback() { // from class: com.bytedance.ug.sdk.share.channel.wechat.impl.WXShare.7
            @Override // com.bytedance.ug.sdk.share.impl.network.request.GetSignInfoThread.GetSignInfoCallback
            public void onSignResult(boolean z, String str) {
                if (!z) {
                    ToastUtils.showToast(WXShare.this.mContext, shareContent, ToastCode.SHARE_ILLEGAL_CONTENT, R.string.share_sdk_share_illegal_content_tips);
                    ShareResult.sendShareStatus(ShareResult.ERROR_SDK_SHARE_ILLEGAL_CONTENT, shareContent);
                } else {
                    wXMediaMessage.msgSignature = str;
                    WXShare.this.realShare(wXMediaMessage, i, shareContent);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realShare(WXMediaMessage wXMediaMessage, int i, ShareContent shareContent) {
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = wXMediaMessage;
        req.scene = i;
        if (WXShareFacory.getWXShareImpl(shareContent.getShareStrategy()).doShare(this.mContext, this.mWxApi, shareContent, req)) {
            willLaunchThirdApp();
        }
    }

    public boolean checkVersionValid() {
        IWXAPI iwxapi = this.mWxApi;
        return iwxapi != null && iwxapi.getWXAppSupportAPI() >= 654314752;
    }
}
