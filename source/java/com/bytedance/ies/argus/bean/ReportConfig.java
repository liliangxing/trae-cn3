package com.bytedance.ies.argus.bean;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArgusSettingsConfigModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0080\b\u0018\u00002\u00020\u0001BM\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J\u001d\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\u0006HÆ\u0003JQ\u0010\u0019\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001R$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R2\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\t\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ies/argus/bean/ReportConfig;", "", "enableTeaReportCidList", "", "", "aspectMaxLimit", "", "", "teaEventMapping", "", "(Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)V", "getAspectMaxLimit", "()Ljava/util/Map;", "enableAllReportTea", "", "getEnableAllReportTea", "()Z", "getEnableTeaReportCidList", "()Ljava/util/List;", "getTeaEventMapping", "setTeaEventMapping", "(Ljava/util/Map;)V", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ReportConfig {

    @SerializedName("aspect_max_limit")
    private final Map<String, Integer> aspectMaxLimit;

    @SerializedName("enable_tea_cid")
    private final List<String> enableTeaReportCidList;

    @SerializedName("event_mapping")
    private Map<String, String[]> teaEventMapping;

    public ReportConfig() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ReportConfig copy$default(ReportConfig reportConfig, List list, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = reportConfig.enableTeaReportCidList;
        }
        if ((i & 2) != 0) {
            map = reportConfig.aspectMaxLimit;
        }
        if ((i & 4) != 0) {
            map2 = reportConfig.teaEventMapping;
        }
        return reportConfig.copy(list, map, map2);
    }

    public final List<String> component1() {
        return this.enableTeaReportCidList;
    }

    public final Map<String, Integer> component2() {
        return this.aspectMaxLimit;
    }

    public final Map<String, String[]> component3() {
        return this.teaEventMapping;
    }

    public final ReportConfig copy(List<String> enableTeaReportCidList, Map<String, Integer> aspectMaxLimit, Map<String, String[]> teaEventMapping) {
        return new ReportConfig(enableTeaReportCidList, aspectMaxLimit, teaEventMapping);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ReportConfig)) {
            return false;
        }
        ReportConfig reportConfig = (ReportConfig) other;
        return Intrinsics.areEqual(this.enableTeaReportCidList, reportConfig.enableTeaReportCidList) && Intrinsics.areEqual(this.aspectMaxLimit, reportConfig.aspectMaxLimit) && Intrinsics.areEqual(this.teaEventMapping, reportConfig.teaEventMapping);
    }

    public int hashCode() {
        List<String> list = this.enableTeaReportCidList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Map<String, Integer> map = this.aspectMaxLimit;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        Map<String, String[]> map2 = this.teaEventMapping;
        return hashCode2 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        return "ReportConfig(enableTeaReportCidList=" + this.enableTeaReportCidList + ", aspectMaxLimit=" + this.aspectMaxLimit + ", teaEventMapping=" + this.teaEventMapping + ')';
    }

    public ReportConfig(List<String> list, Map<String, Integer> map, Map<String, String[]> map2) {
        this.enableTeaReportCidList = list;
        this.aspectMaxLimit = map;
        this.teaEventMapping = map2;
    }

    public /* synthetic */ ReportConfig(List list, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : map2);
    }

    public final List<String> getEnableTeaReportCidList() {
        return this.enableTeaReportCidList;
    }

    public final Map<String, Integer> getAspectMaxLimit() {
        return this.aspectMaxLimit;
    }

    public final Map<String, String[]> getTeaEventMapping() {
        return this.teaEventMapping;
    }

    public final void setTeaEventMapping(Map<String, String[]> map) {
        this.teaEventMapping = map;
    }

    public final boolean getEnableAllReportTea() {
        List<String> list = this.enableTeaReportCidList;
        if (list != null) {
            return list.contains("*");
        }
        return false;
    }
}
