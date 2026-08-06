package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SiteMessageApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001\u0011B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\r\u001a\u00020\u000eH×\u0001J\t\u0010\u000f\u001a\u00020\u0010H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageCountResponse;", "", "data", "Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageCountResponse$CountData;", "<init>", "(Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageCountResponse$CountData;)V", "getData", "()Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageCountResponse$CountData;", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "CountData", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SiteMessageCountResponse {
    public static final int $stable = 0;

    @SerializedName("data")
    private final CountData data;

    /* JADX WARN: Multi-variable type inference failed */
    public SiteMessageCountResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SiteMessageCountResponse copy$default(SiteMessageCountResponse siteMessageCountResponse, CountData countData, int i, Object obj) {
        if ((i & 1) != 0) {
            countData = siteMessageCountResponse.data;
        }
        return siteMessageCountResponse.copy(countData);
    }

    /* renamed from: component1, reason: from getter */
    public final CountData getData() {
        return this.data;
    }

    public final SiteMessageCountResponse copy(CountData data) {
        return new SiteMessageCountResponse(data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SiteMessageCountResponse) && Intrinsics.areEqual(this.data, ((SiteMessageCountResponse) other).data);
    }

    public int hashCode() {
        CountData countData = this.data;
        if (countData == null) {
            return 0;
        }
        return countData.hashCode();
    }

    public String toString() {
        return "SiteMessageCountResponse(data=" + this.data + ')';
    }

    public SiteMessageCountResponse(CountData countData) {
        this.data = countData;
    }

    public /* synthetic */ SiteMessageCountResponse(CountData countData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : countData);
    }

    public final CountData getData() {
        return this.data;
    }

    /* compiled from: SiteMessageApi.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\r\u001a\u00020\u0003H×\u0001J\t\u0010\u000e\u001a\u00020\u000fH×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageCountResponse$CountData;", "", "count", "", "<init>", "(I)V", "getCount", "()I", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class CountData {
        public static final int $stable = 0;

        @SerializedName("count")
        private final int count;

        public CountData() {
            this(0, 1, null);
        }

        public static /* synthetic */ CountData copy$default(CountData countData, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = countData.count;
            }
            return countData.copy(i);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        public final CountData copy(int count) {
            return new CountData(count);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CountData) && this.count == ((CountData) other).count;
        }

        public int hashCode() {
            return Integer.hashCode(this.count);
        }

        public String toString() {
            return "CountData(count=" + this.count + ')';
        }

        public CountData(int i) {
            this.count = i;
        }

        public /* synthetic */ CountData(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 0 : i);
        }

        public final int getCount() {
            return this.count;
        }
    }
}
