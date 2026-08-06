package com.bytedance.trae.im.service;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IGetDownloadUrlApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/im/service/GetDownloadUrlData;", "", "urlMap", "", "", "<init>", "(Ljava/util/Map;)V", "getUrlMap", "()Ljava/util/Map;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GetDownloadUrlData {

    @SerializedName("url_map")
    private final Map<String, String> urlMap;

    /* JADX WARN: Multi-variable type inference failed */
    public GetDownloadUrlData() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetDownloadUrlData copy$default(GetDownloadUrlData getDownloadUrlData, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = getDownloadUrlData.urlMap;
        }
        return getDownloadUrlData.copy(map);
    }

    public final Map<String, String> component1() {
        return this.urlMap;
    }

    public final GetDownloadUrlData copy(Map<String, String> urlMap) {
        return new GetDownloadUrlData(urlMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetDownloadUrlData) && Intrinsics.areEqual(this.urlMap, ((GetDownloadUrlData) other).urlMap);
    }

    public int hashCode() {
        Map<String, String> map = this.urlMap;
        if (map == null) {
            return 0;
        }
        return map.hashCode();
    }

    public String toString() {
        return "GetDownloadUrlData(urlMap=" + this.urlMap + ')';
    }

    public GetDownloadUrlData(Map<String, String> map) {
        this.urlMap = map;
    }

    public /* synthetic */ GetDownloadUrlData(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map);
    }

    public final Map<String, String> getUrlMap() {
        return this.urlMap;
    }
}
