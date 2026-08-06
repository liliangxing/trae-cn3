package com.bytedance.ug.sdk.share.impl.share;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ies.bullet.web.scc.SccDelegate;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareContentType;
import com.bytedance.ug.sdk.share.api.entity.ShareResult;
import com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback;
import com.bytedance.ug.sdk.share.impl.callback.VideoShareCallback;
import com.bytedance.ug.sdk.share.impl.config.ShareConfigManager;
import com.bytedance.ug.sdk.share.impl.event.ShareEvent;
import com.bytedance.ug.sdk.share.impl.helper.ImageShareHelper;
import com.bytedance.ug.sdk.share.impl.helper.VideoShareHelper;
import com.bytedance.ug.sdk.share.impl.manager.ShareSdkManager;
import com.bytedance.ug.sdk.share.impl.utils.FileUtils;
import com.bytedance.ug.sdk.share.impl.utils.HttpUtils;
import com.bytedance.ug.sdk.share.impl.utils.ToolUtils;
import java.util.ArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public abstract class BaseSdkShare extends AbstractShare {
    protected int mErrorCode;

    protected String getClassName() {
        return null;
    }

    public BaseSdkShare(Context context) {
        super(context);
        this.mErrorCode = ShareResult.ERROR_SDK_UNKNOWN;
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.api.IShare
    public boolean doShare(ShareContent shareContent) {
        this.mShareContent = shareContent;
        if (!isInstalled()) {
            String channelZlink = ShareSdkManager.getInstance().getChannelZlink(shareContent.getShareChanelType());
            if (!TextUtils.isEmpty(channelZlink)) {
                ShareConfigManager.getInstance().openPage(this.mContext, channelZlink);
            }
            ShareEvent.sendDiversionEvent(shareContent, channelZlink);
        }
        if (!canShare(shareContent)) {
            return false;
        }
        boolean share = share(shareContent);
        if (!share) {
            ShareResult.sendShareStatus(this.mErrorCode, shareContent);
        }
        return share;
    }

    protected boolean share(ShareContent shareContent) {
        if (this.mContext == null) {
            this.mErrorCode = ShareResult.ERROR_SDK_CONTEXT_NULL;
            return false;
        }
        if (shareContent == null) {
            this.mErrorCode = ShareResult.ERROR_SDK_DATA_NULL;
            return false;
        }
        switch (C10904.f160x723cd226[shareContent.getShareContentType().ordinal()]) {
            case 1:
                return shareH5(shareContent);
            case 2:
                return shareText(shareContent);
            case 3:
                return shareImage(shareContent);
            case 4:
                return shareImageAndText(shareContent);
            case 5:
                return shareVideo(shareContent);
            case 6:
                return shareFile(shareContent);
            case 7:
                return shareMiniApp(shareContent);
            case 8:
                return shareAudio(shareContent);
            case 9:
                return shareSuperGroup(shareContent);
            default:
                return shareContentByDefaultOrder(shareContent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.ug.sdk.share.impl.share.BaseSdkShare$4 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static /* synthetic */ class C10904 {

        /* renamed from: $SwitchMap$com$bytedance$ug$sdk$share$api$entity$ShareContentType */
        static final /* synthetic */ int[] f160x723cd226;

        static {
            int[] iArr = new int[ShareContentType.values().length];
            f160x723cd226 = iArr;
            try {
                iArr[ShareContentType.H5.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f160x723cd226[ShareContentType.TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f160x723cd226[ShareContentType.IMAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f160x723cd226[ShareContentType.TEXT_IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f160x723cd226[ShareContentType.VIDEO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f160x723cd226[ShareContentType.FILE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f160x723cd226[ShareContentType.MINI_APP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f160x723cd226[ShareContentType.AUDIO.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f160x723cd226[ShareContentType.SUPER_GROUP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f160x723cd226[ShareContentType.ALL.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    protected boolean shareContentByDefaultOrder(ShareContent shareContent) {
        return shareH5(shareContent) || shareImageAndText(shareContent) || shareText(shareContent) || shareImage(shareContent) || shareVideo(shareContent) || shareFile(shareContent) || shareMiniApp(shareContent) || shareAudio(shareContent) || shareSuperGroup(shareContent) || shareError();
    }

    protected boolean shareH5(ShareContent shareContent) {
        String targetUrl = shareContent.getTargetUrl();
        if (TextUtils.isEmpty(targetUrl)) {
            this.mErrorCode = ShareResult.ERROR_SDK_H5_TITLE_EMPTY;
            return false;
        }
        String title = shareContent.getTitle();
        if (TextUtils.isEmpty(title)) {
            this.mErrorCode = ShareResult.ERROR_SDK_H5_URL_EMPTY;
            return false;
        }
        if (!shareText(title + " " + targetUrl)) {
            return false;
        }
        ShareResult.sendShareStatus(10000, shareContent);
        return true;
    }

    protected boolean shareImageAndText(final ShareContent shareContent) {
        if (isImageNotExist(shareContent)) {
            this.mErrorCode = ShareResult.ERROR_SDK_IMAGE_AND_TEXT_URL_EMPTY;
            return false;
        }
        if (TextUtils.isEmpty(shareContent.getTitle())) {
            this.mErrorCode = ShareResult.ERROR_SDK_IMAGE_AND_TEXT_TITLE_EMPTY;
            return false;
        }
        ImageShareHelper imageShareHelper = new ImageShareHelper();
        ArrayList<Bitmap> imageBitmapList = shareContent.getImageBitmapList();
        if (imageBitmapList != null && !imageBitmapList.isEmpty()) {
            ArrayList<Uri> arrayList = new ArrayList<>();
            for (int i = 0; i < imageBitmapList.size(); i++) {
                String saveImagePathWithUUID = imageShareHelper.getSaveImagePathWithUUID(imageBitmapList.get(i));
                if (!TextUtils.isEmpty(saveImagePathWithUUID)) {
                    arrayList.add(FileUtils.getUriFromPath(this.mContext, saveImagePathWithUUID, false));
                }
            }
            if (!shareTextAndImage(shareContent.getTitle(), arrayList)) {
                return false;
            }
            ShareResult.sendShareStatus(10000, shareContent);
            return true;
        }
        if (!TextUtils.isEmpty(shareContent.getImageUrl())) {
            if (imageShareHelper.isLocalUrl(shareContent.getImageUrl())) {
                if (!shareTextAndImage(shareContent.getTitle(), FileUtils.getUriFromPath(this.mContext, shareContent.getImageUrl(), false))) {
                    return false;
                }
                ShareResult.sendShareStatus(10000, shareContent);
                return true;
            }
            imageShareHelper.shareImage(shareContent, new ImageShareCallback() { // from class: com.bytedance.ug.sdk.share.impl.share.BaseSdkShare.1
                @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
                public void onShareSuccess(String str) {
                    if (BaseSdkShare.this.shareTextAndImage(shareContent.getTitle(), FileUtils.getUriFromPath(BaseSdkShare.this.mContext, str, false))) {
                        ShareResult.sendShareStatus(10000, shareContent);
                    }
                }

                @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
                public void onShareFailed() {
                    ShareResult.sendShareStatus(ShareResult.ERROR_SDK_IMAGE_AND_TEXT_FETCH_FAILED, shareContent);
                }
            }, false);
            return true;
        }
        if (shareContent.getImage() != null) {
            String saveImagePath = imageShareHelper.getSaveImagePath(shareContent.getImage());
            if (!TextUtils.isEmpty(saveImagePath) && shareTextAndImage(shareContent.getTitle(), FileUtils.getUriFromPath(this.mContext, saveImagePath, false))) {
                ShareResult.sendShareStatus(10000, shareContent);
                return true;
            }
        }
        return false;
    }

    private boolean isImageNotExist(ShareContent shareContent) {
        return TextUtils.isEmpty(shareContent.getImageUrl()) && shareContent.getImage() == null && shareContent.getImageBitmapList() == null;
    }

    protected boolean shareText(ShareContent shareContent) {
        String title = shareContent.getTitle();
        if (TextUtils.isEmpty(title)) {
            this.mErrorCode = ShareResult.ERROR_SDK_TEXT_TITLE_EMPTY;
            return false;
        }
        if (!shareText(title)) {
            return false;
        }
        ShareResult.sendShareStatus(10000, shareContent);
        return true;
    }

    protected boolean shareImage(final ShareContent shareContent) {
        if (isImageNotExist(shareContent)) {
            this.mErrorCode = ShareResult.ERROR_SDK_IMAGE_URL_EMPTY;
            return false;
        }
        ImageShareHelper imageShareHelper = new ImageShareHelper();
        ArrayList<Bitmap> imageBitmapList = shareContent.getImageBitmapList();
        if (imageBitmapList != null && !imageBitmapList.isEmpty()) {
            ArrayList<Uri> arrayList = new ArrayList<>();
            for (int i = 0; i < imageBitmapList.size(); i++) {
                String saveImagePathWithUUID = imageShareHelper.getSaveImagePathWithUUID(imageBitmapList.get(i));
                if (!TextUtils.isEmpty(saveImagePathWithUUID)) {
                    arrayList.add(FileUtils.getUriFromPath(this.mContext, saveImagePathWithUUID, false));
                }
            }
            if (!shareImage(arrayList)) {
                return false;
            }
            ShareResult.sendShareStatus(10000, shareContent);
            return true;
        }
        if (!TextUtils.isEmpty(shareContent.getImageUrl())) {
            if (imageShareHelper.isLocalUrl(shareContent.getImageUrl())) {
                if (!shareImage(FileUtils.getUriFromPath(this.mContext, shareContent.getImageUrl(), false))) {
                    return false;
                }
                ShareResult.sendShareStatus(10000, shareContent);
                return true;
            }
            imageShareHelper.shareImage(shareContent, new ImageShareCallback() { // from class: com.bytedance.ug.sdk.share.impl.share.BaseSdkShare.2
                @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
                public void onShareSuccess(String str) {
                    BaseSdkShare baseSdkShare = BaseSdkShare.this;
                    if (baseSdkShare.shareImage(FileUtils.getUriFromPath(baseSdkShare.mContext, str, false))) {
                        ShareResult.sendShareStatus(10000, shareContent);
                    }
                }

                @Override // com.bytedance.ug.sdk.share.impl.callback.ImageShareCallback
                public void onShareFailed() {
                    ShareResult.sendShareStatus(ShareResult.ERROR_SDK_IMAGE_FETCH_FAILED, shareContent);
                }
            }, false);
            return true;
        }
        if (shareContent.getImage() != null) {
            String saveImagePath = imageShareHelper.getSaveImagePath(shareContent.getImage());
            if (!TextUtils.isEmpty(saveImagePath) && shareImage(FileUtils.getUriFromPath(this.mContext, saveImagePath, false))) {
                ShareResult.sendShareStatus(10000, shareContent);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean shareVideo(final ShareContent shareContent) {
        if (TextUtils.isEmpty(shareContent.getVideoUrl())) {
            this.mErrorCode = ShareResult.ERROR_SDK_VIDEO_URL_EMPTY;
            return false;
        }
        if (!HttpUtils.isUrl(shareContent.getVideoUrl())) {
            if (!shareVideo(FileUtils.getUriFromPath(this.mContext, shareContent.getVideoUrl(), true))) {
                return false;
            }
            ShareResult.sendShareStatus(10000, shareContent);
            return true;
        }
        new VideoShareHelper().shareVideo(shareContent, new VideoShareCallback() { // from class: com.bytedance.ug.sdk.share.impl.share.BaseSdkShare.3
            @Override // com.bytedance.ug.sdk.share.impl.callback.VideoShareCallback
            public void onShareSuccess(String str) {
                BaseSdkShare baseSdkShare = BaseSdkShare.this;
                if (baseSdkShare.shareVideo(FileUtils.getUriFromPath(baseSdkShare.mContext, str, true))) {
                    ShareResult.sendShareStatus(10000, shareContent);
                }
            }

            @Override // com.bytedance.ug.sdk.share.impl.callback.VideoShareCallback
            public void onShareFailed() {
                ShareResult.sendShareStatus(ShareResult.ERROR_SDK_VIDEO_FETCH_FAILED, shareContent);
            }
        });
        return true;
    }

    protected boolean shareFile(ShareContent shareContent) {
        this.mErrorCode = ShareResult.ERROR_SDK_FILE_NOT_SUPPORT;
        return false;
    }

    protected boolean shareAudio(ShareContent shareContent) {
        this.mErrorCode = ShareResult.ERROR_SDK_AUDIO_NOT_SUPPORT;
        return false;
    }

    protected boolean shareMiniApp(ShareContent shareContent) {
        this.mErrorCode = ShareResult.ERROR_SDK_MINIAPP_NOT_SUPPORT;
        return false;
    }

    protected boolean shareSuperGroup(ShareContent shareContent) {
        this.mErrorCode = ShareResult.ERROR_SDK_SUPER_GROUP_NOT_SUPPORT;
        return false;
    }

    protected boolean shareText(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(SccDelegate.MIMETYPE_TEXT_PLAIN);
        if (TextUtils.isEmpty(getClassName())) {
            intent.setPackage(getPackageName());
        } else {
            intent.setClassName(getPackageName(), getClassName());
        }
        intent.putExtra("android.intent.extra.TEXT", str);
        return ToolUtils.tryStartIntent(this.mContext, intent);
    }

    protected boolean shareTextAndImage(String str, ArrayList<Uri> arrayList) {
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setType("image/*");
        if (TextUtils.isEmpty(getClassName())) {
            intent.setPackage(getPackageName());
        } else {
            intent.setClassName(getPackageName(), getClassName());
        }
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        intent.putExtra("android.intent.extra.TEXT", str);
        return ToolUtils.tryStartIntent(this.mContext, intent);
    }

    protected boolean shareImage(ArrayList<Uri> arrayList) {
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setType("image/*");
        if (TextUtils.isEmpty(getClassName())) {
            intent.setPackage(getPackageName());
        } else {
            intent.setClassName(getPackageName(), getClassName());
        }
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        return ToolUtils.tryStartIntent(this.mContext, intent);
    }

    protected boolean shareTextAndImage(String str, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        if (TextUtils.isEmpty(getClassName())) {
            intent.setPackage(getPackageName());
        } else {
            intent.setClassName(getPackageName(), getClassName());
        }
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.putExtra("android.intent.extra.TEXT", str);
        return ToolUtils.tryStartIntent(this.mContext, intent);
    }

    protected boolean shareImage(Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        if (TextUtils.isEmpty(getClassName())) {
            intent.setPackage(getPackageName());
        } else {
            intent.setClassName(getPackageName(), getClassName());
        }
        intent.putExtra("android.intent.extra.STREAM", uri);
        return ToolUtils.tryStartIntent(this.mContext, intent);
    }

    protected boolean shareVideo(Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/*");
        if (TextUtils.isEmpty(getClassName())) {
            intent.setPackage(getPackageName());
        } else {
            intent.setClassName(getPackageName(), getClassName());
        }
        intent.putExtra("android.intent.extra.STREAM", uri);
        return ToolUtils.tryStartIntent(this.mContext, intent);
    }

    protected boolean shareFile(Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("*/*");
        if (TextUtils.isEmpty(getClassName())) {
            intent.setPackage(getPackageName());
        } else {
            intent.setClassName(getPackageName(), getClassName());
        }
        intent.putExtra("android.intent.extra.STREAM", uri);
        return ToolUtils.tryStartIntent(this.mContext, intent);
    }

    @Override // com.bytedance.ug.sdk.share.impl.share.AbstractShare, com.bytedance.ug.sdk.share.impl.share.api.IShare
    public boolean isInstalled() {
        return ToolUtils.isInstalledApp(getPackageName());
    }

    protected boolean shareError() {
        this.mErrorCode = ShareResult.ERROR_SDK_UNKNOWN;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void willLaunchThirdApp() {
        if (this.mShareContent == null || this.mShareContent.getEventCallBack() == null) {
            return;
        }
        this.mShareContent.getEventCallBack().onWillLaunchThirdAppEvent(this.mShareContent.getShareChanelType());
    }
}
