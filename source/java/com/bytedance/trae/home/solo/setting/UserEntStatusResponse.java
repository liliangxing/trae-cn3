package com.bytedance.trae.home.solo.setting;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserEntStatusApi.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0012J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003J\\\u0010!\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÇ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010%\u001a\u00020\u000bH×\u0001J\t\u0010&\u001a\u00020\rH×\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0005\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0007\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;", "", "userEntitlementPackList", "", "Lcom/bytedance/trae/home/solo/setting/UserEntitlementPack;", "isPayFreshman", "", "isDollarUsageBilling", "trialStatus", "Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;", "code", "", "message", "", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;Ljava/lang/Integer;Ljava/lang/String;)V", "getUserEntitlementPackList", "()Ljava/util/List;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getTrialStatus", "()Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;", "getCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Lcom/bytedance/trae/home/solo/setting/EntTrialStatus;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/trae/home/solo/setting/UserEntStatusResponse;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class UserEntStatusResponse {
    public static final int $stable = 8;

    @SerializedName("code")
    private final Integer code;

    @SerializedName("is_dollar_usage_billing")
    private final Boolean isDollarUsageBilling;

    @SerializedName("is_pay_freshman")
    private final Boolean isPayFreshman;

    @SerializedName("message")
    private final String message;

    @SerializedName("trial_status")
    private final EntTrialStatus trialStatus;

    @SerializedName("user_entitlement_pack_list")
    private final List<UserEntitlementPack> userEntitlementPackList;

    public UserEntStatusResponse() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ UserEntStatusResponse copy$default(UserEntStatusResponse userEntStatusResponse, List list, Boolean bool, Boolean bool2, EntTrialStatus entTrialStatus, Integer num, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = userEntStatusResponse.userEntitlementPackList;
        }
        if ((i & 2) != 0) {
            bool = userEntStatusResponse.isPayFreshman;
        }
        Boolean bool3 = bool;
        if ((i & 4) != 0) {
            bool2 = userEntStatusResponse.isDollarUsageBilling;
        }
        Boolean bool4 = bool2;
        if ((i & 8) != 0) {
            entTrialStatus = userEntStatusResponse.trialStatus;
        }
        EntTrialStatus entTrialStatus2 = entTrialStatus;
        if ((i & 16) != 0) {
            num = userEntStatusResponse.code;
        }
        Integer num2 = num;
        if ((i & 32) != 0) {
            str = userEntStatusResponse.message;
        }
        return userEntStatusResponse.copy(list, bool3, bool4, entTrialStatus2, num2, str);
    }

    public final List<UserEntitlementPack> component1() {
        return this.userEntitlementPackList;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getIsPayFreshman() {
        return this.isPayFreshman;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getIsDollarUsageBilling() {
        return this.isDollarUsageBilling;
    }

    /* renamed from: component4, reason: from getter */
    public final EntTrialStatus getTrialStatus() {
        return this.trialStatus;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getCode() {
        return this.code;
    }

    /* renamed from: component6, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final UserEntStatusResponse copy(List<UserEntitlementPack> userEntitlementPackList, Boolean isPayFreshman, Boolean isDollarUsageBilling, EntTrialStatus trialStatus, Integer code, String message) {
        return new UserEntStatusResponse(userEntitlementPackList, isPayFreshman, isDollarUsageBilling, trialStatus, code, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserEntStatusResponse)) {
            return false;
        }
        UserEntStatusResponse userEntStatusResponse = (UserEntStatusResponse) other;
        return Intrinsics.areEqual(this.userEntitlementPackList, userEntStatusResponse.userEntitlementPackList) && Intrinsics.areEqual(this.isPayFreshman, userEntStatusResponse.isPayFreshman) && Intrinsics.areEqual(this.isDollarUsageBilling, userEntStatusResponse.isDollarUsageBilling) && Intrinsics.areEqual(this.trialStatus, userEntStatusResponse.trialStatus) && Intrinsics.areEqual(this.code, userEntStatusResponse.code) && Intrinsics.areEqual(this.message, userEntStatusResponse.message);
    }

    public int hashCode() {
        List<UserEntitlementPack> list = this.userEntitlementPackList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Boolean bool = this.isPayFreshman;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isDollarUsageBilling;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        EntTrialStatus entTrialStatus = this.trialStatus;
        int hashCode4 = (hashCode3 + (entTrialStatus == null ? 0 : entTrialStatus.hashCode())) * 31;
        Integer num = this.code;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.message;
        return hashCode5 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "UserEntStatusResponse(userEntitlementPackList=" + this.userEntitlementPackList + ", isPayFreshman=" + this.isPayFreshman + ", isDollarUsageBilling=" + this.isDollarUsageBilling + ", trialStatus=" + this.trialStatus + ", code=" + this.code + ", message=" + this.message + ')';
    }

    public UserEntStatusResponse(List<UserEntitlementPack> list, Boolean bool, Boolean bool2, EntTrialStatus entTrialStatus, Integer num, String str) {
        this.userEntitlementPackList = list;
        this.isPayFreshman = bool;
        this.isDollarUsageBilling = bool2;
        this.trialStatus = entTrialStatus;
        this.code = num;
        this.message = str;
    }

    public /* synthetic */ UserEntStatusResponse(List list, Boolean bool, Boolean bool2, EntTrialStatus entTrialStatus, Integer num, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : list, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : entTrialStatus, (i & 16) != 0 ? null : num, (i & 32) != 0 ? null : str);
    }

    public final List<UserEntitlementPack> getUserEntitlementPackList() {
        return this.userEntitlementPackList;
    }

    public final Boolean isPayFreshman() {
        return this.isPayFreshman;
    }

    public final Boolean isDollarUsageBilling() {
        return this.isDollarUsageBilling;
    }

    public final EntTrialStatus getTrialStatus() {
        return this.trialStatus;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }
}
