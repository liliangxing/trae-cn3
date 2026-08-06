package com.bytedance.sdk.xbridge.cn.media.utils;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ResponseJsonConvert.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/media/utils/AvatarUri;", "", "()V", "uri", "", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "urlList", "", "getUrlList", "()Ljava/util/List;", "setUrlList", "(Ljava/util/List;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class AvatarUri {

    @SerializedName("uri")
    private String uri;

    @SerializedName("url_list")
    private List<String> urlList;

    public final String getUri() {
        return this.uri;
    }

    public final void setUri(String str) {
        this.uri = str;
    }

    public final List<String> getUrlList() {
        return this.urlList;
    }

    public final void setUrlList(List<String> list) {
        this.urlList = list;
    }
}
