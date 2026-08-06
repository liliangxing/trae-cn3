package com.bytedance.ug.sdk.share.api.entity;

import android.graphics.Bitmap;
import com.bytedance.ug.sdk.share.api.callback.IShareTokenGenerator;
import com.bytedance.ug.sdk.share.api.callback.ShareEventCallback;
import com.bytedance.ug.sdk.share.api.p008ui.IDownloadProgressDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IImageTokenDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IShareProgressView;
import com.bytedance.ug.sdk.share.api.p008ui.IShareTokenDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IVideoGuideDialog;
import com.bytedance.ug.sdk.share.api.p008ui.IVideoShareDialog;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.callback.VideoDialogCallback;
import com.bytedance.ug.sdk.share.impl.utils.UGLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ShareContent implements Serializable {
    private UGLogger.LogContext logContext;
    private String mAudioUrl;
    private String mCopyUrl;
    private IDownloadProgressDialog mDownloadProgressDialog;
    private ShareEventCallback mEventCallBack;
    private String mExtra;
    private ShareExtra mExtraParams;
    private String mFileName;
    private String mFileUrl;
    private String mFrom;
    private ShareChannelType mFromChannel;
    private String mHiddenImageUrl;
    private Bitmap mImage;
    private ArrayList<Bitmap> mImageBitmapList;
    private IImageTokenDialog mImageTokenDialog;
    private TokenShareInfo mImageTokenShareInfo;
    private String mImageUrl;
    private JSONObject mLogEventParams;
    private String mPanelId;
    private String mQrcodeImageUrl;
    private String mResourceId;
    private ShareChannelType mShareChanelType;
    private ShareContentType mShareContentType;
    private IShareProgressView mShareProgressView;
    private ShareStrategy mShareStrategy;
    private List<ShareStrategy> mShareStrategyList;
    private String mShareToken;
    private IShareTokenDialog mShareTokenDialog;
    private IShareTokenGenerator mShareTokenGenerator;
    private ShareContentType mSystemShareType;
    private String mTargetUrl;
    private String mText;
    private String mTitle;
    private TokenShareInfo mTokenShareInfo;
    private VideoDialogCallback mVideoDialogCallback;
    private IVideoGuideDialog mVideoGuideDialog;
    private String mVideoName;
    private IVideoShareDialog mVideoShareDialog;
    private String mVideoUrl;

    private ShareContent() {
        this.mShareStrategy = ShareStrategy.NORMAL;
        this.mShareContentType = ShareContentType.ALL;
        this.mSystemShareType = ShareContentType.TEXT;
        this.logContext = new UGLogger.LogContext();
    }

    public UGLogger.LogContext getLogContext() {
        return this.logContext;
    }

    public ShareEventCallback getEventCallBack() {
        return this.mEventCallBack;
    }

    public void setEventCallBack(ShareEventCallback shareEventCallback) {
        this.mEventCallBack = shareEventCallback;
    }

    public ShareExtra getExtraParams() {
        return this.mExtraParams;
    }

    public void setExtraParams(ShareExtra shareExtra) {
        this.mExtraParams = shareExtra;
    }

    public JSONObject getLogEventParams() {
        return this.mLogEventParams;
    }

    public Bitmap getImage() {
        return this.mImage;
    }

    public void setImage(Bitmap bitmap) {
        this.mImage = bitmap;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getTargetUrl() {
        return this.mTargetUrl;
    }

    public String getCopyUrl() {
        return this.mCopyUrl;
    }

    public void setCopyUrl(String str) {
        this.mCopyUrl = str;
    }

    public void setTargetUrl(String str) {
        this.mTargetUrl = str;
    }

    public String getText() {
        return this.mText;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public ShareStrategy getShareStrategy() {
        return this.mShareStrategy;
    }

    public void setShareStrategy(ShareStrategy shareStrategy) {
        this.mShareStrategy = shareStrategy;
    }

    public List<ShareStrategy> getShareStrategyList() {
        return this.mShareStrategyList;
    }

    public void setShareStrategyList(List<ShareStrategy> list) {
        this.mShareStrategyList = list;
    }

    public TokenShareInfo getTokenShareInfo() {
        return this.mTokenShareInfo;
    }

    public void setTokenShareInfo(TokenShareInfo tokenShareInfo) {
        this.mTokenShareInfo = tokenShareInfo;
    }

    public TokenShareInfo getImageTokenShareInfo() {
        return this.mImageTokenShareInfo;
    }

    public void setImageTokenShareInfo(TokenShareInfo tokenShareInfo) {
        this.mImageTokenShareInfo = tokenShareInfo;
    }

    public ShareChannelType getShareChanelType() {
        return this.mShareChanelType;
    }

    public void setShareChannelType(ShareChannelType shareChannelType) {
        this.mShareChanelType = shareChannelType;
    }

    public ShareContentType getShareContentType() {
        return this.mShareContentType;
    }

    public void setShareContentType(ShareContentType shareContentType) {
        this.mShareContentType = shareContentType;
    }

    public ShareContentType getSystemShareType() {
        return this.mSystemShareType;
    }

    public void setSystemShareType(ShareContentType shareContentType) {
        this.mSystemShareType = shareContentType;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public void setImageBitmapList(ArrayList<Bitmap> arrayList) {
        this.mImageBitmapList = arrayList;
    }

    public ArrayList<Bitmap> getImageBitmapList() {
        return this.mImageBitmapList;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public String getVideoName() {
        return this.mVideoName;
    }

    public void setVideoName(String str) {
        this.mVideoName = str;
    }

    public String getAudioUrl() {
        return this.mAudioUrl;
    }

    public void setAudioUrl(String str) {
        this.mAudioUrl = str;
    }

    public void setFileUrl(String str) {
        this.mFileUrl = str;
    }

    public String getQrcodeImageUrl() {
        return this.mQrcodeImageUrl;
    }

    public void setQrcodeImageUrl(String str) {
        this.mQrcodeImageUrl = str;
    }

    public String getHiddenImageUrl() {
        return this.mHiddenImageUrl;
    }

    public String getFileUrl() {
        return this.mFileUrl;
    }

    public String getFileName() {
        return this.mFileName;
    }

    public void setFileName(String str) {
        this.mFileName = str;
    }

    public void setHiddenImageUrl(String str) {
        this.mHiddenImageUrl = str;
    }

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public ShareChannelType getFromChannel() {
        return this.mFromChannel;
    }

    public void setFromChannel(ShareChannelType shareChannelType) {
        this.mFromChannel = shareChannelType;
    }

    public String getPanelId() {
        return this.mPanelId;
    }

    public void setPanelId(String str) {
        this.mPanelId = str;
    }

    public String getResourceId() {
        return this.mResourceId;
    }

    public IShareTokenDialog getShareTokenDialog() {
        return this.mShareTokenDialog;
    }

    public IImageTokenDialog getImageTokenDialog() {
        return this.mImageTokenDialog;
    }

    public IVideoGuideDialog getVideoGuideDialog() {
        return this.mVideoGuideDialog;
    }

    public IVideoShareDialog getVideoShareDialog() {
        return this.mVideoShareDialog;
    }

    public IDownloadProgressDialog getDownloadProgressDialog() {
        return this.mDownloadProgressDialog;
    }

    public IShareProgressView getShareProgressView() {
        return this.mShareProgressView;
    }

    public VideoDialogCallback getVideoDialogCallback() {
        return this.mVideoDialogCallback;
    }

    public void setVideoDialogCallback(VideoDialogCallback videoDialogCallback) {
        this.mVideoDialogCallback = videoDialogCallback;
    }

    public void setResourceId(String str) {
        this.mResourceId = str;
    }

    public String getExtra() {
        return this.mExtra;
    }

    public void setExtra(String str) {
        this.mExtra = str;
    }

    public IShareTokenGenerator getShareTokenGenerator() {
        return this.mShareTokenGenerator;
    }

    public void setShareToken(String str) {
        this.mShareToken = str;
    }

    public String getShareToken() {
        return this.mShareToken;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static class Builder {
        private ShareContent shareModel = new ShareContent();

        public Builder setShareContentType(ShareContentType shareContentType) {
            if (shareContentType != null) {
                this.shareModel.mShareContentType = shareContentType;
            }
            return this;
        }

        public Builder setSystemShareType(ShareContentType shareContentType) {
            if (shareContentType != null) {
                this.shareModel.mSystemShareType = shareContentType;
            }
            return this;
        }

        public Builder setEventCallBack(ShareEventCallback shareEventCallback) {
            this.shareModel.mEventCallBack = shareEventCallback;
            return this;
        }

        public Builder setImage(Bitmap bitmap) {
            this.shareModel.mImage = bitmap;
            return this;
        }

        public Builder setTitle(String str) {
            this.shareModel.mTitle = str;
            return this;
        }

        public Builder setTargetUrl(String str) {
            this.shareModel.mTargetUrl = str;
            return this;
        }

        public Builder setText(String str) {
            this.shareModel.mText = str;
            return this;
        }

        public Builder setShareStrategy(ShareStrategy shareStrategy) {
            this.shareModel.mShareStrategy = shareStrategy;
            return this;
        }

        public Builder setShareStrategyList(List<ShareStrategy> list) {
            this.shareModel.mShareStrategyList = list;
            return this;
        }

        public Builder setTokenShareInfo(TokenShareInfo tokenShareInfo) {
            this.shareModel.mTokenShareInfo = tokenShareInfo;
            return this;
        }

        public Builder setImageTokenShareInfo(TokenShareInfo tokenShareInfo) {
            this.shareModel.mImageTokenShareInfo = tokenShareInfo;
            return this;
        }

        public Builder setShareChannelType(ShareChannelType shareChannelType) {
            this.shareModel.mShareChanelType = shareChannelType;
            return this;
        }

        public Builder setImageBitmapList(ArrayList<Bitmap> arrayList) {
            this.shareModel.mImageBitmapList = arrayList;
            return this;
        }

        public Builder setImageUrl(String str) {
            this.shareModel.mImageUrl = str;
            return this;
        }

        public Builder setVideoUrl(String str) {
            this.shareModel.mVideoUrl = str;
            return this;
        }

        public Builder setVideoName(String str) {
            this.shareModel.mVideoName = str;
            return this;
        }

        public Builder setAudioUrl(String str) {
            this.shareModel.mAudioUrl = str;
            return this;
        }

        public Builder setQrcodeImageUrl(String str) {
            this.shareModel.mQrcodeImageUrl = str;
            return this;
        }

        public Builder setHiddenImageUrl(String str) {
            this.shareModel.mHiddenImageUrl = str;
            return this;
        }

        public Builder setCopyUrl(String str) {
            this.shareModel.mCopyUrl = str;
            return this;
        }

        public Builder setFileUrl(String str) {
            this.shareModel.mFileUrl = str;
            return this;
        }

        public Builder setFileName(String str) {
            this.shareModel.mFileName = str;
            return this;
        }

        public Builder setExtraParams(ShareExtra shareExtra) {
            this.shareModel.mExtraParams = shareExtra;
            return this;
        }

        public Builder setLogEventParams(JSONObject jSONObject) {
            this.shareModel.mLogEventParams = jSONObject;
            return this;
        }

        public Builder setShareTokenDialog(IShareTokenDialog iShareTokenDialog) {
            this.shareModel.mShareTokenDialog = iShareTokenDialog;
            return this;
        }

        public Builder setImageTokenDialog(IImageTokenDialog iImageTokenDialog) {
            this.shareModel.mImageTokenDialog = iImageTokenDialog;
            return this;
        }

        public Builder setVideoGuideDialog(IVideoGuideDialog iVideoGuideDialog) {
            this.shareModel.mVideoGuideDialog = iVideoGuideDialog;
            return this;
        }

        public Builder setVideoShareDialog(IVideoShareDialog iVideoShareDialog) {
            this.shareModel.mVideoShareDialog = iVideoShareDialog;
            return this;
        }

        public Builder setDownloadProgressDialog(IDownloadProgressDialog iDownloadProgressDialog) {
            this.shareModel.mDownloadProgressDialog = iDownloadProgressDialog;
            return this;
        }

        public Builder setShareProgressView(IShareProgressView iShareProgressView) {
            this.shareModel.mShareProgressView = iShareProgressView;
            return this;
        }

        public Builder setVideoDialogCallback(VideoDialogCallback videoDialogCallback) {
            this.shareModel.mVideoDialogCallback = videoDialogCallback;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setFrom(String str) {
            this.shareModel.mFrom = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setFromChannel(ShareChannelType shareChannelType) {
            this.shareModel.mFromChannel = shareChannelType;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setPanelId(String str) {
            this.shareModel.mPanelId = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setResourceId(String str) {
            this.shareModel.mResourceId = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Builder setExtra(String str) {
            this.shareModel.mExtra = str;
            return this;
        }

        public Builder setShareTokenGenerator(IShareTokenGenerator iShareTokenGenerator) {
            this.shareModel.mShareTokenGenerator = iShareTokenGenerator;
            return this;
        }

        public ShareContent build() {
            if (this.shareModel.mShareTokenGenerator == null) {
                this.shareModel.mShareTokenGenerator = new IShareTokenGenerator.DefaultShareTokenGenerator();
            }
            return this.shareModel;
        }

        public Builder setShareToken(String str) {
            this.shareModel.mShareToken = str;
            return this;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public ShareContent m987clone() {
        TokenShareInfo tokenShareInfo;
        TokenShareInfo tokenShareInfo2;
        ShareExtra shareExtra = null;
        if (this.mTokenShareInfo != null) {
            tokenShareInfo = new TokenShareInfo();
            tokenShareInfo.setTitle(this.mTokenShareInfo.getTitle());
            tokenShareInfo.setDescription(this.mTokenShareInfo.getDescription());
            tokenShareInfo.setTips(this.mTokenShareInfo.getTips());
        } else {
            tokenShareInfo = null;
        }
        if (this.mImageTokenShareInfo != null) {
            tokenShareInfo2 = new TokenShareInfo();
            tokenShareInfo2.setTitle(this.mImageTokenShareInfo.getTitle());
            tokenShareInfo2.setDescription(this.mImageTokenShareInfo.getDescription());
            tokenShareInfo2.setTips(this.mImageTokenShareInfo.getTips());
        } else {
            tokenShareInfo2 = null;
        }
        if (this.mExtraParams != null) {
            shareExtra = new ShareExtra();
            shareExtra.setDYExtra(this.mExtraParams.getDYExtra());
            shareExtra.setTiktokExtra(this.mExtraParams.getTiktokExtra());
            shareExtra.setWXExtra(this.mExtraParams.getWXExtra());
            shareExtra.setWBExtra(this.mExtraParams.getWBExtra());
            shareExtra.setQQExtra(this.mExtraParams.getQQExtra());
            shareExtra.setAppExtra(this.mExtraParams.getAppExtra());
            shareExtra.setSystemExtra(this.mExtraParams.getSystemExtra());
            shareExtra.setImagePanelExtra(this.mExtraParams.getImagePanelExtra());
        }
        ShareContent build = new Builder().setShareContentType(this.mShareContentType).setSystemShareType(this.mSystemShareType).setShareChannelType(this.mShareChanelType).setShareStrategy(this.mShareStrategy).setShareStrategyList(this.mShareStrategyList).setTitle(this.mTitle).setText(this.mText).setTargetUrl(this.mTargetUrl).setCopyUrl(this.mCopyUrl).setImage(this.mImage).setImageBitmapList(this.mImageBitmapList).setImageUrl(this.mImageUrl).setHiddenImageUrl(this.mHiddenImageUrl).setQrcodeImageUrl(this.mQrcodeImageUrl).setVideoUrl(this.mVideoUrl).setVideoName(this.mVideoName).setAudioUrl(this.mAudioUrl).setFileName(this.mFileName).setFileUrl(this.mFileUrl).setShareTokenDialog(this.mShareTokenDialog).setImageTokenDialog(this.mImageTokenDialog).setVideoGuideDialog(this.mVideoGuideDialog).setVideoShareDialog(this.mVideoShareDialog).setDownloadProgressDialog(this.mDownloadProgressDialog).setShareProgressView(this.mShareProgressView).setVideoDialogCallback(this.mVideoDialogCallback).setEventCallBack(this.mEventCallBack).setTokenShareInfo(tokenShareInfo).setImageTokenShareInfo(tokenShareInfo2).setExtraParams(shareExtra).setLogEventParams(this.mLogEventParams).setFrom(this.mFrom).setFromChannel(this.mFromChannel).setPanelId(this.mPanelId).setResourceId(this.mResourceId).setExtra(this.mExtra).setShareTokenGenerator(this.mShareTokenGenerator).setShareToken(this.mShareToken).build();
        build.logContext = this.logContext;
        return build;
    }
}
