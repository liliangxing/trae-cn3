package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SiteMessageApi.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0016JR\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÇ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\"\u001a\u00020\u0004H×\u0001J\t\u0010#\u001a\u00020\u0006H×\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;", "", "notificationIds", "", "", "action", "", "version", "platform", SettingsTracker.TYPE_LANGUAGE, "updateAll", "", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getNotificationIds", "()Ljava/util/List;", "getAction", "()Ljava/lang/String;", "getVersion", "getPlatform", "getLanguage", "getUpdateAll", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageUpdateStatusBody;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class SiteMessageUpdateStatusBody {
    public static final int $stable = 8;

    @SerializedName("action")
    private final String action;

    @SerializedName(SettingsTracker.TYPE_LANGUAGE)
    private final String language;

    @SerializedName("notificationIds")
    private final List<Integer> notificationIds;

    @SerializedName("platform")
    private final String platform;

    @SerializedName("updateAll")
    private final Boolean updateAll;

    @SerializedName("version")
    private final String version;

    public static /* synthetic */ SiteMessageUpdateStatusBody copy$default(SiteMessageUpdateStatusBody siteMessageUpdateStatusBody, List list, String str, String str2, String str3, String str4, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            list = siteMessageUpdateStatusBody.notificationIds;
        }
        if ((i & 2) != 0) {
            str = siteMessageUpdateStatusBody.action;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = siteMessageUpdateStatusBody.version;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = siteMessageUpdateStatusBody.platform;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = siteMessageUpdateStatusBody.language;
        }
        String str8 = str4;
        if ((i & 32) != 0) {
            bool = siteMessageUpdateStatusBody.updateAll;
        }
        return siteMessageUpdateStatusBody.copy(list, str5, str6, str7, str8, bool);
    }

    public final List<Integer> component1() {
        return this.notificationIds;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAction() {
        return this.action;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component4, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: component6, reason: from getter */
    public final Boolean getUpdateAll() {
        return this.updateAll;
    }

    public final SiteMessageUpdateStatusBody copy(List<Integer> notificationIds, String action, String version, String platform, String language, Boolean updateAll) {
        Intrinsics.checkNotNullParameter(notificationIds, "notificationIds");
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(platform, "platform");
        Intrinsics.checkNotNullParameter(language, SettingsTracker.TYPE_LANGUAGE);
        return new SiteMessageUpdateStatusBody(notificationIds, action, version, platform, language, updateAll);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteMessageUpdateStatusBody)) {
            return false;
        }
        SiteMessageUpdateStatusBody siteMessageUpdateStatusBody = (SiteMessageUpdateStatusBody) other;
        return Intrinsics.areEqual(this.notificationIds, siteMessageUpdateStatusBody.notificationIds) && Intrinsics.areEqual(this.action, siteMessageUpdateStatusBody.action) && Intrinsics.areEqual(this.version, siteMessageUpdateStatusBody.version) && Intrinsics.areEqual(this.platform, siteMessageUpdateStatusBody.platform) && Intrinsics.areEqual(this.language, siteMessageUpdateStatusBody.language) && Intrinsics.areEqual(this.updateAll, siteMessageUpdateStatusBody.updateAll);
    }

    public int hashCode() {
        int hashCode = ((((((((this.notificationIds.hashCode() * 31) + this.action.hashCode()) * 31) + this.version.hashCode()) * 31) + this.platform.hashCode()) * 31) + this.language.hashCode()) * 31;
        Boolean bool = this.updateAll;
        return hashCode + (bool == null ? 0 : bool.hashCode());
    }

    public String toString() {
        return "SiteMessageUpdateStatusBody(notificationIds=" + this.notificationIds + ", action=" + this.action + ", version=" + this.version + ", platform=" + this.platform + ", language=" + this.language + ", updateAll=" + this.updateAll + ')';
    }

    public SiteMessageUpdateStatusBody(List<Integer> list, String str, String str2, String str3, String str4, Boolean bool) {
        Intrinsics.checkNotNullParameter(list, "notificationIds");
        Intrinsics.checkNotNullParameter(str, "action");
        Intrinsics.checkNotNullParameter(str2, "version");
        Intrinsics.checkNotNullParameter(str3, "platform");
        Intrinsics.checkNotNullParameter(str4, SettingsTracker.TYPE_LANGUAGE);
        this.notificationIds = list;
        this.action = str;
        this.version = str2;
        this.platform = str3;
        this.language = str4;
        this.updateAll = bool;
    }

    public final List<Integer> getNotificationIds() {
        return this.notificationIds;
    }

    public final String getAction() {
        return this.action;
    }

    public /* synthetic */ SiteMessageUpdateStatusBody(List list, String str, String str2, String str3, String str4, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i & 4) != 0 ? SiteMessageParams.INSTANCE.getVersion() : str2, (i & 8) != 0 ? SiteMessageParams.platform : str3, (i & 16) != 0 ? SiteMessageParams.INSTANCE.getLanguage() : str4, (i & 32) != 0 ? null : bool);
    }

    public final String getVersion() {
        return this.version;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final Boolean getUpdateAll() {
        return this.updateAll;
    }
}
