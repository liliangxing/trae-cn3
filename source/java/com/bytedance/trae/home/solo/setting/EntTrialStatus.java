package com.bytedance.trae.home.solo.setting;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserEntStatusApi.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\fJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÇ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0015\u001a\u00020\u0016H×\u0001J\t\u0010\u0017\u001a\u00020\u0018H×\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0002\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u0004\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;", "", "isInTrial", "", "isEligibleForTrial", "trialEndTime", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTrialEndTime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class EntTrialStatus {
    public static final int $stable = 0;

    @SerializedName("is_eligible_for_trial")
    private final Boolean isEligibleForTrial;

    @SerializedName("is_in_trial")
    private final Boolean isInTrial;

    @SerializedName("trial_end_time")
    private final Long trialEndTime;

    public EntTrialStatus() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ EntTrialStatus copy$default(EntTrialStatus entTrialStatus, Boolean bool, Boolean bool2, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = entTrialStatus.isInTrial;
        }
        if ((i & 2) != 0) {
            bool2 = entTrialStatus.isEligibleForTrial;
        }
        if ((i & 4) != 0) {
            l = entTrialStatus.trialEndTime;
        }
        return entTrialStatus.copy(bool, bool2, l);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getIsInTrial() {
        return this.isInTrial;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getIsEligibleForTrial() {
        return this.isEligibleForTrial;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getTrialEndTime() {
        return this.trialEndTime;
    }

    public final EntTrialStatus copy(Boolean isInTrial, Boolean isEligibleForTrial, Long trialEndTime) {
        return new EntTrialStatus(isInTrial, isEligibleForTrial, trialEndTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntTrialStatus)) {
            return false;
        }
        EntTrialStatus entTrialStatus = (EntTrialStatus) other;
        return Intrinsics.areEqual(this.isInTrial, entTrialStatus.isInTrial) && Intrinsics.areEqual(this.isEligibleForTrial, entTrialStatus.isEligibleForTrial) && Intrinsics.areEqual(this.trialEndTime, entTrialStatus.trialEndTime);
    }

    public int hashCode() {
        Boolean bool = this.isInTrial;
        int hashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.isEligibleForTrial;
        int hashCode2 = (hashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Long l = this.trialEndTime;
        return hashCode2 + (l != null ? l.hashCode() : 0);
    }

    public String toString() {
        return "EntTrialStatus(isInTrial=" + this.isInTrial + ", isEligibleForTrial=" + this.isEligibleForTrial + ", trialEndTime=" + this.trialEndTime + ')';
    }

    public EntTrialStatus(Boolean bool, Boolean bool2, Long l) {
        this.isInTrial = bool;
        this.isEligibleForTrial = bool2;
        this.trialEndTime = l;
    }

    public /* synthetic */ EntTrialStatus(Boolean bool, Boolean bool2, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bool, (i & 2) != 0 ? null : bool2, (i & 4) != 0 ? null : l);
    }

    public final Boolean isInTrial() {
        return this.isInTrial;
    }

    public final Boolean isEligibleForTrial() {
        return this.isEligibleForTrial;
    }

    public final Long getTrialEndTime() {
        return this.trialEndTime;
    }
}
