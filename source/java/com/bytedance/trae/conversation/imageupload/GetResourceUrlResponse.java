package com.bytedance.trae.conversation.imageupload;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ImageUploadModels.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/imageupload/GetResourceUrlResponse;", "", "urlMap", "", "", "<init>", "(Ljava/util/Map;)V", "getUrlMap", "()Ljava/util/Map;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class GetResourceUrlResponse {

    @SerializedName("url_map")
    private final Map<String, String> urlMap;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GetResourceUrlResponse() {
        this(r0, 1, r0);
        Map map = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetResourceUrlResponse copy$default(GetResourceUrlResponse getResourceUrlResponse, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = getResourceUrlResponse.urlMap;
        }
        return getResourceUrlResponse.copy(map);
    }

    public final Map<String, String> component1() {
        return this.urlMap;
    }

    public final GetResourceUrlResponse copy(Map<String, String> urlMap) {
        Intrinsics.checkNotNullParameter(urlMap, "urlMap");
        return new GetResourceUrlResponse(urlMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof GetResourceUrlResponse) && Intrinsics.areEqual(this.urlMap, ((GetResourceUrlResponse) other).urlMap);
    }

    public int hashCode() {
        return this.urlMap.hashCode();
    }

    public String toString() {
        return "GetResourceUrlResponse(urlMap=" + this.urlMap + ')';
    }

    public GetResourceUrlResponse(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "urlMap");
        this.urlMap = map;
    }

    public /* synthetic */ GetResourceUrlResponse(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map);
    }

    public final Map<String, String> getUrlMap() {
        return this.urlMap;
    }
}
