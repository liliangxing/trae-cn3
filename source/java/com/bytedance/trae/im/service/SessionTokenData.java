package com.bytedance.trae.im.service;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IChatSessionAuthApi.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0011\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J8\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/bytedance/trae/im/service/SessionTokenData;", "", "token", "", "expiresAt", "", SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_HOSTS, "", "<init>", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)V", "getToken", "()Ljava/lang/String;", "getExpiresAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getHosts", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;)Lcom/bytedance/trae/im/service/SessionTokenData;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SessionTokenData {

    @SerializedName(alternate = {"expires_at"}, value = "expiresAt")
    private final Long expiresAt;

    @SerializedName(SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_HOSTS)
    private final List<String> hosts;

    @SerializedName("token")
    private final String token;

    public SessionTokenData() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SessionTokenData copy$default(SessionTokenData sessionTokenData, String str, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sessionTokenData.token;
        }
        if ((i & 2) != 0) {
            l = sessionTokenData.expiresAt;
        }
        if ((i & 4) != 0) {
            list = sessionTokenData.hosts;
        }
        return sessionTokenData.copy(str, l, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getExpiresAt() {
        return this.expiresAt;
    }

    public final List<String> component3() {
        return this.hosts;
    }

    public final SessionTokenData copy(String token, Long expiresAt, List<String> hosts) {
        return new SessionTokenData(token, expiresAt, hosts);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionTokenData)) {
            return false;
        }
        SessionTokenData sessionTokenData = (SessionTokenData) other;
        return Intrinsics.areEqual(this.token, sessionTokenData.token) && Intrinsics.areEqual(this.expiresAt, sessionTokenData.expiresAt) && Intrinsics.areEqual(this.hosts, sessionTokenData.hosts);
    }

    public int hashCode() {
        String str = this.token;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l = this.expiresAt;
        int hashCode2 = (hashCode + (l == null ? 0 : l.hashCode())) * 31;
        List<String> list = this.hosts;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        return "SessionTokenData(token=" + this.token + ", expiresAt=" + this.expiresAt + ", hosts=" + this.hosts + ')';
    }

    public SessionTokenData(String str, Long l, List<String> list) {
        this.token = str;
        this.expiresAt = l;
        this.hosts = list;
    }

    public /* synthetic */ SessionTokenData(String str, Long l, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : list);
    }

    public final String getToken() {
        return this.token;
    }

    public final Long getExpiresAt() {
        return this.expiresAt;
    }

    public final List<String> getHosts() {
        return this.hosts;
    }
}
