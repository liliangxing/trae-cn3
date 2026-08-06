package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SiteMessageApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\r\u001a\u00020\u000eH×\u0001J\t\u0010\u000f\u001a\u00020\u0010H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse;", "", "data", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;", "<init>", "(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;)V", "getData", "()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "PreferencesData", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SiteMessagePreferencesGetResponse {
    public static final int $stable = 8;

    @SerializedName("data")
    private final PreferencesData data;

    /* JADX WARN: Multi-variable type inference failed */
    public SiteMessagePreferencesGetResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SiteMessagePreferencesGetResponse copy$default(SiteMessagePreferencesGetResponse siteMessagePreferencesGetResponse, PreferencesData preferencesData, int i, Object obj) {
        if ((i & 1) != 0) {
            preferencesData = siteMessagePreferencesGetResponse.data;
        }
        return siteMessagePreferencesGetResponse.copy(preferencesData);
    }

    /* renamed from: component1, reason: from getter */
    public final PreferencesData getData() {
        return this.data;
    }

    public final SiteMessagePreferencesGetResponse copy(PreferencesData data) {
        return new SiteMessagePreferencesGetResponse(data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SiteMessagePreferencesGetResponse) && Intrinsics.areEqual(this.data, ((SiteMessagePreferencesGetResponse) other).data);
    }

    public int hashCode() {
        PreferencesData preferencesData = this.data;
        if (preferencesData == null) {
            return 0;
        }
        return preferencesData.hashCode();
    }

    public String toString() {
        return "SiteMessagePreferencesGetResponse(data=" + this.data + ')';
    }

    public SiteMessagePreferencesGetResponse(PreferencesData preferencesData) {
        this.data = preferencesData;
    }

    public /* synthetic */ SiteMessagePreferencesGetResponse(PreferencesData preferencesData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : preferencesData);
    }

    public final PreferencesData getData() {
        return this.data;
    }

    /* compiled from: SiteMessageApi.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0011\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÇ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0018\u001a\u00020\u0019H×\u0001J\t\u0010\u001a\u001a\u00020\u0004H×\u0001R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesGetResponse$PreferencesData;", "", "preferences", "", "", "", "lastUpdatedBy", "items", "", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessagePreferencesTypeItem;", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/util/List;)V", "getPreferences", "()Ljava/util/Map;", "getLastUpdatedBy", "()Ljava/lang/String;", "getItems", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class PreferencesData {
        public static final int $stable = 8;

        @SerializedName("items")
        private final List<SiteMessagePreferencesTypeItem> items;

        @SerializedName("lastUpdatedBy")
        private final String lastUpdatedBy;

        @SerializedName("preferences")
        private final Map<String, Boolean> preferences;

        public PreferencesData() {
            this(null, null, null, 7, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ PreferencesData copy$default(PreferencesData preferencesData, Map map, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                map = preferencesData.preferences;
            }
            if ((i & 2) != 0) {
                str = preferencesData.lastUpdatedBy;
            }
            if ((i & 4) != 0) {
                list = preferencesData.items;
            }
            return preferencesData.copy(map, str, list);
        }

        public final Map<String, Boolean> component1() {
            return this.preferences;
        }

        /* renamed from: component2, reason: from getter */
        public final String getLastUpdatedBy() {
            return this.lastUpdatedBy;
        }

        public final List<SiteMessagePreferencesTypeItem> component3() {
            return this.items;
        }

        public final PreferencesData copy(Map<String, Boolean> preferences, String lastUpdatedBy, List<SiteMessagePreferencesTypeItem> items) {
            return new PreferencesData(preferences, lastUpdatedBy, items);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PreferencesData)) {
                return false;
            }
            PreferencesData preferencesData = (PreferencesData) other;
            return Intrinsics.areEqual(this.preferences, preferencesData.preferences) && Intrinsics.areEqual(this.lastUpdatedBy, preferencesData.lastUpdatedBy) && Intrinsics.areEqual(this.items, preferencesData.items);
        }

        public int hashCode() {
            Map<String, Boolean> map = this.preferences;
            int hashCode = (map == null ? 0 : map.hashCode()) * 31;
            String str = this.lastUpdatedBy;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            List<SiteMessagePreferencesTypeItem> list = this.items;
            return hashCode2 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "PreferencesData(preferences=" + this.preferences + ", lastUpdatedBy=" + this.lastUpdatedBy + ", items=" + this.items + ')';
        }

        public PreferencesData(Map<String, Boolean> map, String str, List<SiteMessagePreferencesTypeItem> list) {
            this.preferences = map;
            this.lastUpdatedBy = str;
            this.items = list;
        }

        public /* synthetic */ PreferencesData(Map map, String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : map, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : list);
        }

        public final Map<String, Boolean> getPreferences() {
            return this.preferences;
        }

        public final String getLastUpdatedBy() {
            return this.lastUpdatedBy;
        }

        public final List<SiteMessagePreferencesTypeItem> getItems() {
            return this.items;
        }
    }
}
