package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SiteMessageApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0017B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J\t\u0010\u0015\u001a\u00020\u0016H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;", "", "data", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;", "success", "", "<init>", "(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;Ljava/lang/Boolean;)V", "getData", "()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;Ljava/lang/Boolean;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "ListData", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SiteMessageListResponse {
    public static final int $stable = 8;

    @SerializedName("data")
    private final ListData data;

    @SerializedName("success")
    private final Boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public SiteMessageListResponse() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SiteMessageListResponse copy$default(SiteMessageListResponse siteMessageListResponse, ListData listData, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            listData = siteMessageListResponse.data;
        }
        if ((i & 2) != 0) {
            bool = siteMessageListResponse.success;
        }
        return siteMessageListResponse.copy(listData, bool);
    }

    /* renamed from: component1, reason: from getter */
    public final ListData getData() {
        return this.data;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getSuccess() {
        return this.success;
    }

    public final SiteMessageListResponse copy(ListData data, Boolean success) {
        return new SiteMessageListResponse(data, success);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteMessageListResponse)) {
            return false;
        }
        SiteMessageListResponse siteMessageListResponse = (SiteMessageListResponse) other;
        return Intrinsics.areEqual(this.data, siteMessageListResponse.data) && Intrinsics.areEqual(this.success, siteMessageListResponse.success);
    }

    public int hashCode() {
        ListData listData = this.data;
        int hashCode = (listData == null ? 0 : listData.hashCode()) * 31;
        Boolean bool = this.success;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "SiteMessageListResponse(data=" + this.data + ", success=" + this.success + ')';
    }

    public SiteMessageListResponse(ListData listData, Boolean bool) {
        this.data = listData;
        this.success = bool;
    }

    public /* synthetic */ SiteMessageListResponse(ListData listData, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : listData, (i & 2) != 0 ? null : bool);
    }

    public final ListData getData() {
        return this.data;
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    /* compiled from: SiteMessageApi.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ,\u0010\u0010\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÇ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0014\u001a\u00020\u0015H×\u0001J\t\u0010\u0016\u001a\u00020\u0017H×\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;", "", "list", "", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;", "hasMore", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "getList", "()Ljava/util/List;", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "copy", "(Ljava/util/List;Ljava/lang/Boolean;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageListResponse$ListData;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class ListData {
        public static final int $stable = 8;

        @SerializedName("hasMore")
        private final Boolean hasMore;

        @SerializedName("list")
        private final List<SiteMessageItem> list;

        /* JADX WARN: Multi-variable type inference failed */
        public ListData() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ListData copy$default(ListData listData, List list, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                list = listData.list;
            }
            if ((i & 2) != 0) {
                bool = listData.hasMore;
            }
            return listData.copy(list, bool);
        }

        public final List<SiteMessageItem> component1() {
            return this.list;
        }

        /* renamed from: component2, reason: from getter */
        public final Boolean getHasMore() {
            return this.hasMore;
        }

        public final ListData copy(List<SiteMessageItem> list, Boolean hasMore) {
            return new ListData(list, hasMore);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ListData)) {
                return false;
            }
            ListData listData = (ListData) other;
            return Intrinsics.areEqual(this.list, listData.list) && Intrinsics.areEqual(this.hasMore, listData.hasMore);
        }

        public int hashCode() {
            List<SiteMessageItem> list = this.list;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            Boolean bool = this.hasMore;
            return hashCode + (bool != null ? bool.hashCode() : 0);
        }

        public String toString() {
            return "ListData(list=" + this.list + ", hasMore=" + this.hasMore + ')';
        }

        public ListData(List<SiteMessageItem> list, Boolean bool) {
            this.list = list;
            this.hasMore = bool;
        }

        public /* synthetic */ ListData(List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : bool);
        }

        public final List<SiteMessageItem> getList() {
            return this.list;
        }

        public final Boolean getHasMore() {
            return this.hasMore;
        }
    }
}
