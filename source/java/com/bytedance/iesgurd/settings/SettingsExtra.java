package com.bytedance.iesgurd.settings;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsExtra.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/iesgurd/settings/SettingsExtra;", "", "()V", "noLocalAk", "", "", "getNoLocalAk", "()Ljava/util/List;", "setNoLocalAk", "(Ljava/util/List;)V", "pcdnInfo", "Lcom/bytedance/iesgurd/settings/SettingsExtra$PCDNInfo;", "getPcdnInfo", "()Lcom/bytedance/iesgurd/settings/SettingsExtra$PCDNInfo;", "setPcdnInfo", "(Lcom/bytedance/iesgurd/settings/SettingsExtra$PCDNInfo;)V", "probeInfo", "Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;", "getProbeInfo", "()Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;", "setProbeInfo", "(Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;)V", "PCDNInfo", "ProbeInfo", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final class SettingsExtra {

    @SerializedName("no_local_ak")
    private List<String> noLocalAk;

    @SerializedName("p2p")
    private PCDNInfo pcdnInfo;

    @SerializedName("probe")
    private ProbeInfo probeInfo;

    public final List<String> getNoLocalAk() {
        return this.noLocalAk;
    }

    public final void setNoLocalAk(List<String> list) {
        this.noLocalAk = list;
    }

    public final PCDNInfo getPcdnInfo() {
        return this.pcdnInfo;
    }

    public final void setPcdnInfo(PCDNInfo pCDNInfo) {
        this.pcdnInfo = pCDNInfo;
    }

    public final ProbeInfo getProbeInfo() {
        return this.probeInfo;
    }

    public final void setProbeInfo(ProbeInfo probeInfo) {
        this.probeInfo = probeInfo;
    }

    /* compiled from: SettingsExtra.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/iesgurd/settings/SettingsExtra$PCDNInfo;", "", "()V", "businessId", "", "getBusinessId", "()Ljava/lang/Integer;", "setBusinessId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "groupId", "", "getGroupId", "()Ljava/lang/String;", "setGroupId", "(Ljava/lang/String;)V", "testId", "getTestId", "setTestId", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes4.dex */
    public static final class PCDNInfo {

        @SerializedName("sid")
        private Integer businessId;

        @SerializedName("pcdn_groupid")
        private String groupId = "";

        @SerializedName("pcdn_testid")
        private String testId = "";

        public final Integer getBusinessId() {
            return this.businessId;
        }

        public final void setBusinessId(Integer num) {
            this.businessId = num;
        }

        public final String getGroupId() {
            return this.groupId;
        }

        public final void setGroupId(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.groupId = str;
        }

        public final String getTestId() {
            return this.testId;
        }

        public final void setTestId(String str) {
            Intrinsics.checkParameterIsNotNull(str, "<set-?>");
            this.testId = str;
        }
    }

    /* compiled from: SettingsExtra.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/iesgurd/settings/SettingsExtra$ProbeInfo;", "", "()V", "probeThreshold", "", "getProbeThreshold", "()I", "setProbeThreshold", "(I)V", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes4.dex */
    public static final class ProbeInfo {

        @SerializedName("probe_threshold")
        private int probeThreshold;

        public final int getProbeThreshold() {
            return this.probeThreshold;
        }

        public final void setProbeThreshold(int i) {
            this.probeThreshold = i;
        }
    }
}
