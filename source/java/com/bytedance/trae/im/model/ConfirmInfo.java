package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b1\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 <2\u00020\u0001:\u0001<B»\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0011\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u0011\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÂ\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u001e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0011\u0010%\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b'\u0010&¨\u0006="}, d2 = {"Lcom/bytedance/trae/im/model/ConfirmInfo;", "", "confirmStatus", "", "autoConfirm", "", "blockLevel", "blockCommandList", "", "hitRedList", "hitBlackList", "runningCommandList", "nowRunMode", "runMode", "runModeVersion", "sandboxStatus", "sandboxRecoveryType", "sandboxConfigCommand", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getConfirmStatus", "()Ljava/lang/String;", "getAutoConfirm", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getBlockLevel", "getBlockCommandList", "()Ljava/util/List;", "getHitRedList", "getHitBlackList", "getRunningCommandList", "getNowRunMode", "getRunMode", "getRunModeVersion", "getSandboxStatus", "getSandboxRecoveryType", "getSandboxConfigCommand", "isEnterpriseCommandBlacklist", "()Z", "isWaitingConfirm", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/trae/im/model/ConfirmInfo;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "Companion", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConfirmInfo {
    public static final String BLOCK_LEVEL_ENTERPRISE_COMMAND_BLACKLIST = "enterprise_command_blacklist";
    public static final String STATUS_CANCELED = "canceled";
    public static final String STATUS_CONFIRMED = "confirmed";
    public static final String STATUS_SKIPPED = "skipped";
    public static final String STATUS_SKIPPED_RUN = "skippedRun";
    public static final String STATUS_UNCONFIRMED = "unconfirmed";

    @SerializedName("auto_confirm")
    private final Boolean autoConfirm;

    @SerializedName("block_command_list")
    private final List<String> blockCommandList;

    @SerializedName("block_level")
    private final String blockLevel;

    @SerializedName("confirm_status")
    private final String confirmStatus;

    @SerializedName("hit_black_list")
    private final List<String> hitBlackList;

    @SerializedName("hit_red_list")
    private final List<String> hitRedList;

    @SerializedName("now_run_mode")
    private final String nowRunMode;

    @SerializedName("run_mode")
    private final String runMode;

    @SerializedName("run_mode_version")
    private final String runModeVersion;

    @SerializedName("running_command_list")
    private final List<String> runningCommandList;

    @SerializedName("sandbox_config_command")
    private final String sandboxConfigCommand;

    @SerializedName("sandbox_recovery_type")
    private final String sandboxRecoveryType;

    @SerializedName("sandbox_status")
    private final String sandboxStatus;

    public ConfirmInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getConfirmStatus() {
        return this.confirmStatus;
    }

    /* renamed from: component10, reason: from getter */
    public final String getRunModeVersion() {
        return this.runModeVersion;
    }

    /* renamed from: component11, reason: from getter */
    public final String getSandboxStatus() {
        return this.sandboxStatus;
    }

    /* renamed from: component12, reason: from getter */
    public final String getSandboxRecoveryType() {
        return this.sandboxRecoveryType;
    }

    /* renamed from: component13, reason: from getter */
    public final String getSandboxConfigCommand() {
        return this.sandboxConfigCommand;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getAutoConfirm() {
        return this.autoConfirm;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBlockLevel() {
        return this.blockLevel;
    }

    public final List<String> component4() {
        return this.blockCommandList;
    }

    public final List<String> component5() {
        return this.hitRedList;
    }

    public final List<String> component6() {
        return this.hitBlackList;
    }

    public final List<String> component7() {
        return this.runningCommandList;
    }

    /* renamed from: component8, reason: from getter */
    public final String getNowRunMode() {
        return this.nowRunMode;
    }

    /* renamed from: component9, reason: from getter */
    public final String getRunMode() {
        return this.runMode;
    }

    public final ConfirmInfo copy(String confirmStatus, Boolean autoConfirm, String blockLevel, List<String> blockCommandList, List<String> hitRedList, List<String> hitBlackList, List<String> runningCommandList, String nowRunMode, String runMode, String runModeVersion, String sandboxStatus, String sandboxRecoveryType, String sandboxConfigCommand) {
        return new ConfirmInfo(confirmStatus, autoConfirm, blockLevel, blockCommandList, hitRedList, hitBlackList, runningCommandList, nowRunMode, runMode, runModeVersion, sandboxStatus, sandboxRecoveryType, sandboxConfigCommand);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfirmInfo)) {
            return false;
        }
        ConfirmInfo confirmInfo = (ConfirmInfo) other;
        return Intrinsics.areEqual(this.confirmStatus, confirmInfo.confirmStatus) && Intrinsics.areEqual(this.autoConfirm, confirmInfo.autoConfirm) && Intrinsics.areEqual(this.blockLevel, confirmInfo.blockLevel) && Intrinsics.areEqual(this.blockCommandList, confirmInfo.blockCommandList) && Intrinsics.areEqual(this.hitRedList, confirmInfo.hitRedList) && Intrinsics.areEqual(this.hitBlackList, confirmInfo.hitBlackList) && Intrinsics.areEqual(this.runningCommandList, confirmInfo.runningCommandList) && Intrinsics.areEqual(this.nowRunMode, confirmInfo.nowRunMode) && Intrinsics.areEqual(this.runMode, confirmInfo.runMode) && Intrinsics.areEqual(this.runModeVersion, confirmInfo.runModeVersion) && Intrinsics.areEqual(this.sandboxStatus, confirmInfo.sandboxStatus) && Intrinsics.areEqual(this.sandboxRecoveryType, confirmInfo.sandboxRecoveryType) && Intrinsics.areEqual(this.sandboxConfigCommand, confirmInfo.sandboxConfigCommand);
    }

    public int hashCode() {
        String str = this.confirmStatus;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.autoConfirm;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.blockLevel;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<String> list = this.blockCommandList;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        List<String> list2 = this.hitRedList;
        int hashCode5 = (hashCode4 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<String> list3 = this.hitBlackList;
        int hashCode6 = (hashCode5 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<String> list4 = this.runningCommandList;
        int hashCode7 = (hashCode6 + (list4 == null ? 0 : list4.hashCode())) * 31;
        String str3 = this.nowRunMode;
        int hashCode8 = (hashCode7 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.runMode;
        int hashCode9 = (hashCode8 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.runModeVersion;
        int hashCode10 = (hashCode9 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.sandboxStatus;
        int hashCode11 = (hashCode10 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.sandboxRecoveryType;
        int hashCode12 = (hashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.sandboxConfigCommand;
        return hashCode12 + (str8 != null ? str8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ConfirmInfo(confirmStatus=");
        sb.append(this.confirmStatus).append(", autoConfirm=").append(this.autoConfirm).append(", blockLevel=").append(this.blockLevel).append(", blockCommandList=").append(this.blockCommandList).append(", hitRedList=").append(this.hitRedList).append(", hitBlackList=").append(this.hitBlackList).append(", runningCommandList=").append(this.runningCommandList).append(", nowRunMode=").append(this.nowRunMode).append(", runMode=").append(this.runMode).append(", runModeVersion=").append(this.runModeVersion).append(", sandboxStatus=").append(this.sandboxStatus).append(", sandboxRecoveryType=");
        sb.append(this.sandboxRecoveryType).append(", sandboxConfigCommand=").append(this.sandboxConfigCommand).append(')');
        return sb.toString();
    }

    public ConfirmInfo(String str, Boolean bool, String str2, List<String> list, List<String> list2, List<String> list3, List<String> list4, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.confirmStatus = str;
        this.autoConfirm = bool;
        this.blockLevel = str2;
        this.blockCommandList = list;
        this.hitRedList = list2;
        this.hitBlackList = list3;
        this.runningCommandList = list4;
        this.nowRunMode = str3;
        this.runMode = str4;
        this.runModeVersion = str5;
        this.sandboxStatus = str6;
        this.sandboxRecoveryType = str7;
        this.sandboxConfigCommand = str8;
    }

    public /* synthetic */ ConfirmInfo(String str, Boolean bool, String str2, List list, List list2, List list3, List list4, String str3, String str4, String str5, String str6, String str7, String str8, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : list, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : list3, (i & 64) != 0 ? null : list4, (i & 128) != 0 ? null : str3, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? null : str5, (i & 1024) != 0 ? null : str6, (i & 2048) != 0 ? null : str7, (i & 4096) == 0 ? str8 : null);
    }

    public final String getConfirmStatus() {
        return this.confirmStatus;
    }

    public final Boolean getAutoConfirm() {
        return this.autoConfirm;
    }

    public final String getBlockLevel() {
        return this.blockLevel;
    }

    public final List<String> getBlockCommandList() {
        return this.blockCommandList;
    }

    public final List<String> getHitRedList() {
        return this.hitRedList;
    }

    public final List<String> getHitBlackList() {
        return this.hitBlackList;
    }

    public final List<String> getRunningCommandList() {
        return this.runningCommandList;
    }

    public final String getNowRunMode() {
        return this.nowRunMode;
    }

    public final String getRunMode() {
        return this.runMode;
    }

    public final String getRunModeVersion() {
        return this.runModeVersion;
    }

    public final String getSandboxStatus() {
        return this.sandboxStatus;
    }

    public final String getSandboxRecoveryType() {
        return this.sandboxRecoveryType;
    }

    public final String getSandboxConfigCommand() {
        return this.sandboxConfigCommand;
    }

    public final boolean isEnterpriseCommandBlacklist() {
        return Intrinsics.areEqual(this.blockLevel, BLOCK_LEVEL_ENTERPRISE_COMMAND_BLACKLIST);
    }

    public final boolean isWaitingConfirm() {
        return (!Intrinsics.areEqual(this.confirmStatus, STATUS_UNCONFIRMED) || Intrinsics.areEqual((Object) this.autoConfirm, (Object) true) || isEnterpriseCommandBlacklist()) ? false : true;
    }
}
