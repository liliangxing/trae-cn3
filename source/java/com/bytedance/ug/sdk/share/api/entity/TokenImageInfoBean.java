package com.bytedance.ug.sdk.share.api.entity;

import com.bytedance.ug.sdk.share.impl.model.ImageUrl;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
public class TokenImageInfoBean implements Serializable {

    @SerializedName("height")
    private int mHeight;

    @SerializedName("uri")
    private String mUri;

    @SerializedName("url")
    private String mUrl;

    @SerializedName("url_list")
    private List<ImageUrl> mUrlList;

    @SerializedName("width")
    private int mWidth;

    public int getWidth() {
        return this.mWidth;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public void setHeight(int i) {
        this.mHeight = i;
    }

    public String getUri() {
        return this.mUri;
    }

    public void setUri(String str) {
        this.mUri = str;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public List<ImageUrl> getUrlList() {
        return this.mUrlList;
    }

    public void setUrlList(List<ImageUrl> list) {
        this.mUrlList = list;
    }
}
