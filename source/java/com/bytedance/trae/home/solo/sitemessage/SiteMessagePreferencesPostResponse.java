package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SiteMessageApi.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\f\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u000e\u001a\u00020\u000fH×\u0001J\t\u0010\u0010\u001a\u00020\u0004H×\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesPostResponse;", "", "data", "", "", "", "<init>", "(Ljava/util/Map;)V", "getData", "()Ljava/util/Map;", "component1", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SiteMessagePreferencesPostResponse {
    public static final int $stable = 8;

    @SerializedName("data")
    private final Map<String, Boolean> data;

    /* JADX WARN: Multi-variable type inference failed */
    public SiteMessagePreferencesPostResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SiteMessagePreferencesPostResponse copy$default(SiteMessagePreferencesPostResponse siteMessagePreferencesPostResponse, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = siteMessagePreferencesPostResponse.data;
        }
        return siteMessagePreferencesPostResponse.copy(map);
    }

    public final Map<String, Boolean> component1() {
        return this.data;
    }

    public final SiteMessagePreferencesPostResponse copy(Map<String, Boolean> data) {
        return new SiteMessagePreferencesPostResponse(data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SiteMessagePreferencesPostResponse) && Intrinsics.areEqual(this.data, ((SiteMessagePreferencesPostResponse) other).data);
    }

    public int hashCode() {
        Map<String, Boolean> map = this.data;
        if (map == null) {
            return 0;
        }
        return map.hashCode();
    }

    public String toString() {
        return "SiteMessagePreferencesPostResponse(data=" + this.data + ')';
    }

    public SiteMessagePreferencesPostResponse(Map<String, Boolean> map) {
        this.data = map;
    }

    public /* synthetic */ SiteMessagePreferencesPostResponse(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : map);
    }

    public final Map<String, Boolean> getData() {
        return this.data;
    }
}
