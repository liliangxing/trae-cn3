package com.bytedance.iesgurd.statistic.model;

import com.bytedance.iesgurd.statistic.UploadStatistic;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: StatisticCleanData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\t\u0010\u000f\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÂ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\t\u0010\u0013\u001a\u00020\nHÂ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÂ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÂ\u0003J_\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u001eR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/bytedance/iesgurd/statistic/model/StatisticCleanData;", "", "cleanStrategy", "Lcom/bytedance/iesgurd/statistic/model/CleanStrategy;", "cleanType", "", "accessKey", "", "channel", "id", "", "statsType", "expireAge", "cleanGroup", "(Lcom/bytedance/iesgurd/statistic/model/CleanStrategy;ILjava/lang/String;Ljava/lang/String;JIILjava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "upload", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class StatisticCleanData {
    private final String accessKey;
    private final String channel;
    private final String cleanGroup;
    private final CleanStrategy cleanStrategy;
    private final int cleanType;
    private final int expireAge;
    private final long id;
    private final int statsType;

    /* renamed from: component1, reason: from getter */
    private final CleanStrategy getCleanStrategy() {
        return this.cleanStrategy;
    }

    /* renamed from: component2, reason: from getter */
    private final int getCleanType() {
        return this.cleanType;
    }

    /* renamed from: component3, reason: from getter */
    private final String getAccessKey() {
        return this.accessKey;
    }

    /* renamed from: component4, reason: from getter */
    private final String getChannel() {
        return this.channel;
    }

    /* renamed from: component5, reason: from getter */
    private final long getId() {
        return this.id;
    }

    /* renamed from: component6, reason: from getter */
    private final int getStatsType() {
        return this.statsType;
    }

    /* renamed from: component7, reason: from getter */
    private final int getExpireAge() {
        return this.expireAge;
    }

    /* renamed from: component8, reason: from getter */
    private final String getCleanGroup() {
        return this.cleanGroup;
    }

    public final StatisticCleanData copy(CleanStrategy cleanStrategy, int cleanType, String accessKey, String channel, long id, int statsType, int expireAge, String cleanGroup) {
        Intrinsics.checkParameterIsNotNull(cleanStrategy, "cleanStrategy");
        return new StatisticCleanData(cleanStrategy, cleanType, accessKey, channel, id, statsType, expireAge, cleanGroup);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StatisticCleanData)) {
            return false;
        }
        StatisticCleanData statisticCleanData = (StatisticCleanData) other;
        return Intrinsics.areEqual(this.cleanStrategy, statisticCleanData.cleanStrategy) && this.cleanType == statisticCleanData.cleanType && Intrinsics.areEqual(this.accessKey, statisticCleanData.accessKey) && Intrinsics.areEqual(this.channel, statisticCleanData.channel) && this.id == statisticCleanData.id && this.statsType == statisticCleanData.statsType && this.expireAge == statisticCleanData.expireAge && Intrinsics.areEqual(this.cleanGroup, statisticCleanData.cleanGroup);
    }

    public int hashCode() {
        CleanStrategy cleanStrategy = this.cleanStrategy;
        int hashCode = (((cleanStrategy != null ? cleanStrategy.hashCode() : 0) * 31) + this.cleanType) * 31;
        String str = this.accessKey;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.channel;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        long j = this.id;
        int i = (((((hashCode3 + ((int) (j ^ (j >>> 32)))) * 31) + this.statsType) * 31) + this.expireAge) * 31;
        String str3 = this.cleanGroup;
        return i + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "StatisticCleanData(cleanStrategy=" + this.cleanStrategy + ", cleanType=" + this.cleanType + ", accessKey=" + this.accessKey + ", channel=" + this.channel + ", id=" + this.id + ", statsType=" + this.statsType + ", expireAge=" + this.expireAge + ", cleanGroup=" + this.cleanGroup + ")";
    }

    public StatisticCleanData(CleanStrategy cleanStrategy, int i, String str, String str2, long j, int i2, int i3, String str3) {
        Intrinsics.checkParameterIsNotNull(cleanStrategy, "cleanStrategy");
        this.cleanStrategy = cleanStrategy;
        this.cleanType = i;
        this.accessKey = str;
        this.channel = str2;
        this.id = j;
        this.statsType = i2;
        this.expireAge = i3;
        this.cleanGroup = str3;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ StatisticCleanData(CleanStrategy cleanStrategy, int i, String str, String str2, long j, int i2, int i3, String str3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(cleanStrategy, i, r6, r7, r8, r10, r11, r12);
        String str4;
        String str5;
        String str6;
        if ((i4 & 4) != 0) {
            str4 = null;
        } else {
            str4 = str;
        }
        if ((i4 & 8) != 0) {
            str5 = null;
        } else {
            str5 = str2;
        }
        long j2 = (i4 & 16) != 0 ? 0L : j;
        int i5 = (i4 & 32) != 0 ? 200 : i2;
        int i6 = (i4 & 64) != 0 ? 0 : i3;
        if ((i4 & 128) != 0) {
            str6 = null;
        } else {
            str6 = str3;
        }
    }

    public final void upload() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("clean_strategy", this.cleanStrategy.ordinal());
        int i = this.cleanType;
        if (i != 0) {
            jSONObject.put("clean_type", i);
        }
        jSONObject.put("stats_type", this.statsType);
        String str = this.accessKey;
        if (str != null) {
            jSONObject.put("access_key", str);
        }
        String str2 = this.channel;
        if (str2 != null) {
            jSONObject.put("channel", str2);
        }
        long j = this.id;
        if (j != 0) {
            jSONObject.put("id", j);
        }
        String str3 = this.cleanGroup;
        if (str3 != null) {
            jSONObject.put("clean_group", str3);
        }
        int i2 = this.expireAge;
        if (i2 != 0) {
            jSONObject.put("expire_age", i2);
        }
        UploadStatistic.INSTANCE.uploadEventWithJson("geckosdk_clean_stats", jSONObject);
    }
}
