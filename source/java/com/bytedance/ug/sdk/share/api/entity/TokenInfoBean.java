package com.bytedance.ug.sdk.share.api.entity;

import com.bytedance.sdk.account.platform.api.ITaptapService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.pushmanager.MessageConstants;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class TokenInfoBean implements Serializable {

    @SerializedName("activity_info")
    private ActivityInfo mActivityInfo;

    @SerializedName("author_info")
    private AuthorInfo mAuthorInfo;

    @SerializedName("button_text")
    private String mButtonText;

    @SerializedName("client_extra")
    private String mClientExtra;

    @SerializedName("desc")
    private String mDesc;
    private String mFrom;

    @SerializedName("log_info")
    private TokenLogInfoBean mLogInfo;

    @SerializedName(BaseConstants.DownloadManager.COLUMN_MEDIA_TYPE)
    private int mMediaType;

    @SerializedName(MessageConstants.BUNDLE_OPEN_URL)
    private String mOpenUrl;

    @SerializedName("pic_cnt")
    private int mPicCnt;

    @SerializedName("pics")
    private List<TokenImageInfoBean> mPics;

    @SerializedName("share_user_info")
    private TokenUserInfoBean mShareUserInfo;

    @SerializedName("title")
    private String mTitle;

    @SerializedName("token")
    private String mToken;

    @SerializedName(ITaptapService.ResponseConstants.TOKEN_TYPE)
    private int mTokenType;

    @SerializedName("video_duration")
    private int mVideoDuration;

    public String getFrom() {
        return this.mFrom;
    }

    public void setFrom(String str) {
        this.mFrom = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public String getOpenUrl() {
        return this.mOpenUrl;
    }

    public void setOpenUrl(String str) {
        this.mOpenUrl = str;
    }

    public TokenUserInfoBean getShareUserInfo() {
        return this.mShareUserInfo;
    }

    public void setShareUserInfo(TokenUserInfoBean tokenUserInfoBean) {
        this.mShareUserInfo = tokenUserInfoBean;
    }

    public List<TokenImageInfoBean> getPics() {
        return this.mPics;
    }

    public void setPics(List<TokenImageInfoBean> list) {
        this.mPics = list;
    }

    public int getPicCnt() {
        return this.mPicCnt;
    }

    public void setPicCnt(int i) {
        this.mPicCnt = i;
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public void setMediaType(int i) {
        this.mMediaType = i;
    }

    public int getTokenType() {
        return this.mTokenType;
    }

    public void setTokenType(int i) {
        this.mTokenType = i;
    }

    public int getVideoDuration() {
        return this.mVideoDuration;
    }

    public void setVideoDuration(int i) {
        this.mVideoDuration = i;
    }

    public TokenLogInfoBean getLogInfo() {
        return this.mLogInfo;
    }

    public void setLogInfo(TokenLogInfoBean tokenLogInfoBean) {
        this.mLogInfo = tokenLogInfoBean;
    }

    public String getButtonText() {
        return this.mButtonText;
    }

    public void setButtonText(String str) {
        this.mButtonText = str;
    }

    public String getClientExtra() {
        return this.mClientExtra;
    }

    public void setClientExtra(String str) {
        this.mClientExtra = str;
    }

    public String getDesc() {
        return this.mDesc;
    }

    public void setDesc(String str) {
        this.mDesc = str;
    }

    public AuthorInfo getAuthorInfo() {
        return this.mAuthorInfo;
    }

    public void setAuthorInfo(AuthorInfo authorInfo) {
        this.mAuthorInfo = authorInfo;
    }

    public ActivityInfo getActivityInfo() {
        return this.mActivityInfo;
    }

    public void setActivityInfo(ActivityInfo activityInfo) {
        this.mActivityInfo = activityInfo;
    }
}
