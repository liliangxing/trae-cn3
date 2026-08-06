package com.bytedance.ug.sdk.share.impl.network.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.entity.ShareStrategy;
import com.bytedance.ug.sdk.share.api.entity.TokenShareInfo;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class ShareInfo implements Serializable {

    @SerializedName("channel")
    private String mChannel;

    @SerializedName("share_data")
    private ShareDetail mShareDetail;

    @SerializedName("method")
    private String mStrategy;

    public String getChannel() {
        return this.mChannel;
    }

    public void setChannel(String str) {
        this.mChannel = str;
    }

    public String getStrategy() {
        return this.mStrategy;
    }

    public void setStrategy(String str) {
        this.mStrategy = str;
    }

    public ShareDetail getShareDetail() {
        return this.mShareDetail;
    }

    public void setShareDetail(ShareDetail shareDetail) {
        this.mShareDetail = shareDetail;
    }

    public static ShareContent applyToShareModel(ShareInfo shareInfo, ShareContent shareContent) {
        String strategy = shareInfo.getStrategy();
        if (!TextUtils.isEmpty(strategy)) {
            shareContent.setShareStrategy(ShareStrategy.getStrategyByType(strategy));
        }
        ShareDetail shareDetail = shareInfo.getShareDetail();
        if (shareDetail != null) {
            String title = shareDetail.getTitle();
            if (!TextUtils.isEmpty(title)) {
                shareContent.setTitle(title);
            }
            String description = shareDetail.getDescription();
            if (!TextUtils.isEmpty(description)) {
                shareContent.setText(description);
            }
            String imageUrl = shareDetail.getImageUrl();
            if (!TextUtils.isEmpty(imageUrl)) {
                shareContent.setImageUrl(imageUrl);
            }
            String qrCodeImageUrl = shareDetail.getQrCodeImageUrl();
            if (!TextUtils.isEmpty(qrCodeImageUrl)) {
                shareContent.setQrcodeImageUrl(qrCodeImageUrl);
            }
            String hiddenImageUrl = shareDetail.getHiddenImageUrl();
            if (!TextUtils.isEmpty(hiddenImageUrl)) {
                shareContent.setHiddenImageUrl(hiddenImageUrl);
            }
            String shareUrl = shareDetail.getShareUrl();
            if (!TextUtils.isEmpty(shareUrl)) {
                try {
                    Uri parse = Uri.parse(shareUrl);
                    if (shareContent.getShareChanelType() != ShareChannelType.COPY_LINK && TextUtils.isEmpty(parse.getQueryParameter("share_token"))) {
                        shareContent.setTargetUrl(parse.buildUpon().appendQueryParameter("share_token", shareContent.getShareToken()).build().toString());
                    } else {
                        shareContent.setTargetUrl(shareUrl);
                    }
                } catch (Exception unused) {
                    shareContent.setTargetUrl(shareUrl);
                }
            }
            String videoUrl = shareDetail.getVideoUrl();
            if (!TextUtils.isEmpty(videoUrl)) {
                shareContent.setVideoUrl(videoUrl);
            }
            String audioUrl = shareDetail.getAudioUrl();
            if (!TextUtils.isEmpty(audioUrl)) {
                shareContent.setAudioUrl(audioUrl);
            }
            String extra = shareDetail.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                shareContent.setExtra(extra);
            }
            TokenInfo tokenInfo = shareDetail.getTokenInfo();
            if (tokenInfo != null) {
                TokenShareInfo tokenShareInfo = new TokenShareInfo();
                tokenShareInfo.setTitle(tokenInfo.getTitle());
                tokenShareInfo.setDescription(tokenInfo.getDescription());
                tokenShareInfo.setTips(tokenInfo.getTips());
                shareContent.setTokenShareInfo(tokenShareInfo);
            }
            TokenInfo imageTokenInfo = shareDetail.getImageTokenInfo();
            if (imageTokenInfo != null) {
                TokenShareInfo tokenShareInfo2 = new TokenShareInfo();
                tokenShareInfo2.setTitle(imageTokenInfo.getTitle());
                tokenShareInfo2.setDescription(imageTokenInfo.getDescription());
                tokenShareInfo2.setTips(imageTokenInfo.getTips());
                shareContent.setImageTokenShareInfo(tokenShareInfo2);
            }
        }
        return shareContent;
    }

    public static ShareContent applyTokenToShareModel(ShareInfo shareInfo, ShareContent shareContent) {
        ShareDetail shareDetail = shareInfo.getShareDetail();
        if (shareDetail != null) {
            TokenInfo tokenInfo = shareDetail.getTokenInfo();
            if (tokenInfo != null) {
                TokenShareInfo tokenShareInfo = new TokenShareInfo();
                tokenShareInfo.setTitle(tokenInfo.getTitle());
                tokenShareInfo.setDescription(tokenInfo.getDescription());
                tokenShareInfo.setTips(tokenInfo.getTips());
                shareContent.setTokenShareInfo(tokenShareInfo);
            }
            TokenInfo imageTokenInfo = shareDetail.getImageTokenInfo();
            if (imageTokenInfo != null) {
                TokenShareInfo tokenShareInfo2 = new TokenShareInfo();
                tokenShareInfo2.setTitle(imageTokenInfo.getTitle());
                tokenShareInfo2.setDescription(imageTokenInfo.getDescription());
                tokenShareInfo2.setTips(imageTokenInfo.getTips());
                shareContent.setImageTokenShareInfo(tokenShareInfo2);
            }
        }
        return shareContent;
    }
}
