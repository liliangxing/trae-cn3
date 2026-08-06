package com.bytedance.ug.sdk.share.api.entity;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public class TokenShareInfo {
    private String mChannel;
    private String mDescription;
    private Bitmap mImage;
    private String mImageUrl;
    private String mTips;
    private String mTitle;
    private String mVideoUrl;

    public String getChannel() {
        return this.mChannel;
    }

    public void setChannel(String str) {
        this.mChannel = str;
    }

    public Bitmap getImage() {
        return this.mImage;
    }

    public void setImage(Bitmap bitmap) {
        this.mImage = bitmap;
    }

    public String getImageUrl() {
        return this.mImageUrl;
    }

    public void setImageUrl(String str) {
        this.mImageUrl = str;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String str) {
        this.mDescription = str;
    }

    public String getTips() {
        return this.mTips;
    }

    public void setTips(String str) {
        this.mTips = str;
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }
}
