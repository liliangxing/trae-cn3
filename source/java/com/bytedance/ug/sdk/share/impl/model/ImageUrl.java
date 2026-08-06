package com.bytedance.ug.sdk.share.impl.model;

import com.bytedance.ug.sdk.share.api.entity.UrlList;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: classes4.dex */
public class ImageUrl {

    @SerializedName("height")
    public int height;

    @SerializedName("type")
    public int imageType;

    @SerializedName("uri")
    public String uri;

    @SerializedName("url")
    public String url;

    @SerializedName("url_list")
    public List<UrlList> urlList;

    @SerializedName("width")
    public int width;
}
