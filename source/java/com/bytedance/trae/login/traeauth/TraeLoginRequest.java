package com.bytedance.trae.login.traeauth;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthModels.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b1\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J½\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00104\u001a\u0002052\b\u00106\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0015¨\u0006:"}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeLoginRequest;", "", "loginChannel", "", "platform", "sso", "sig", "utmSource", "utmMedium", "utmCampaign", "utmTerm", "utmContent", "bdvid", "activityName", "activityId", "promotionChannel", "riskActivityName", "extraUtmInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLoginChannel", "()Ljava/lang/String;", "getPlatform", "getSso", "getSig", "getUtmSource", "getUtmMedium", "getUtmCampaign", "getUtmTerm", "getUtmContent", "getBdvid", "getActivityName", "getActivityId", "getPromotionChannel", "getRiskActivityName", "getExtraUtmInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class TraeLoginRequest {

    @SerializedName("ActivityID")
    private final String activityId;

    @SerializedName("ActivityName")
    private final String activityName;

    @SerializedName("BDVID")
    private final String bdvid;

    @SerializedName("ExtraUtmInfo")
    private final String extraUtmInfo;

    @SerializedName("LoginChannel")
    private final String loginChannel;

    @SerializedName("Platform")
    private final String platform;

    @SerializedName("PromotionChannel")
    private final String promotionChannel;

    @SerializedName("RiskActivityName")
    private final String riskActivityName;

    @SerializedName("Sig")
    private final String sig;

    @SerializedName("SSO")
    private final String sso;

    @SerializedName("UtmCampaign")
    private final String utmCampaign;

    @SerializedName("UtmContent")
    private final String utmContent;

    @SerializedName("UtmMedium")
    private final String utmMedium;

    @SerializedName("UtmSource")
    private final String utmSource;

    @SerializedName("UtmTerm")
    private final String utmTerm;

    public TraeLoginRequest() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLoginChannel() {
        return this.loginChannel;
    }

    /* renamed from: component10, reason: from getter */
    public final String getBdvid() {
        return this.bdvid;
    }

    /* renamed from: component11, reason: from getter */
    public final String getActivityName() {
        return this.activityName;
    }

    /* renamed from: component12, reason: from getter */
    public final String getActivityId() {
        return this.activityId;
    }

    /* renamed from: component13, reason: from getter */
    public final String getPromotionChannel() {
        return this.promotionChannel;
    }

    /* renamed from: component14, reason: from getter */
    public final String getRiskActivityName() {
        return this.riskActivityName;
    }

    /* renamed from: component15, reason: from getter */
    public final String getExtraUtmInfo() {
        return this.extraUtmInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPlatform() {
        return this.platform;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSso() {
        return this.sso;
    }

    /* renamed from: component4, reason: from getter */
    public final String getSig() {
        return this.sig;
    }

    /* renamed from: component5, reason: from getter */
    public final String getUtmSource() {
        return this.utmSource;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUtmMedium() {
        return this.utmMedium;
    }

    /* renamed from: component7, reason: from getter */
    public final String getUtmCampaign() {
        return this.utmCampaign;
    }

    /* renamed from: component8, reason: from getter */
    public final String getUtmTerm() {
        return this.utmTerm;
    }

    /* renamed from: component9, reason: from getter */
    public final String getUtmContent() {
        return this.utmContent;
    }

    public final TraeLoginRequest copy(String loginChannel, String platform, String sso, String sig, String utmSource, String utmMedium, String utmCampaign, String utmTerm, String utmContent, String bdvid, String activityName, String activityId, String promotionChannel, String riskActivityName, String extraUtmInfo) {
        return new TraeLoginRequest(loginChannel, platform, sso, sig, utmSource, utmMedium, utmCampaign, utmTerm, utmContent, bdvid, activityName, activityId, promotionChannel, riskActivityName, extraUtmInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TraeLoginRequest)) {
            return false;
        }
        TraeLoginRequest traeLoginRequest = (TraeLoginRequest) other;
        return Intrinsics.areEqual(this.loginChannel, traeLoginRequest.loginChannel) && Intrinsics.areEqual(this.platform, traeLoginRequest.platform) && Intrinsics.areEqual(this.sso, traeLoginRequest.sso) && Intrinsics.areEqual(this.sig, traeLoginRequest.sig) && Intrinsics.areEqual(this.utmSource, traeLoginRequest.utmSource) && Intrinsics.areEqual(this.utmMedium, traeLoginRequest.utmMedium) && Intrinsics.areEqual(this.utmCampaign, traeLoginRequest.utmCampaign) && Intrinsics.areEqual(this.utmTerm, traeLoginRequest.utmTerm) && Intrinsics.areEqual(this.utmContent, traeLoginRequest.utmContent) && Intrinsics.areEqual(this.bdvid, traeLoginRequest.bdvid) && Intrinsics.areEqual(this.activityName, traeLoginRequest.activityName) && Intrinsics.areEqual(this.activityId, traeLoginRequest.activityId) && Intrinsics.areEqual(this.promotionChannel, traeLoginRequest.promotionChannel) && Intrinsics.areEqual(this.riskActivityName, traeLoginRequest.riskActivityName) && Intrinsics.areEqual(this.extraUtmInfo, traeLoginRequest.extraUtmInfo);
    }

    public int hashCode() {
        String str = this.loginChannel;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.platform;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.sso;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sig;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.utmSource;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.utmMedium;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.utmCampaign;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.utmTerm;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.utmContent;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.bdvid;
        int hashCode10 = (hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.activityName;
        int hashCode11 = (hashCode10 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.activityId;
        int hashCode12 = (hashCode11 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.promotionChannel;
        int hashCode13 = (hashCode12 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.riskActivityName;
        int hashCode14 = (hashCode13 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.extraUtmInfo;
        return hashCode14 + (str15 != null ? str15.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TraeLoginRequest(loginChannel=");
        sb.append(this.loginChannel).append(", platform=").append(this.platform).append(", sso=").append(this.sso).append(", sig=").append(this.sig).append(", utmSource=").append(this.utmSource).append(", utmMedium=").append(this.utmMedium).append(", utmCampaign=").append(this.utmCampaign).append(", utmTerm=").append(this.utmTerm).append(", utmContent=").append(this.utmContent).append(", bdvid=").append(this.bdvid).append(", activityName=").append(this.activityName).append(", activityId=");
        sb.append(this.activityId).append(", promotionChannel=").append(this.promotionChannel).append(", riskActivityName=").append(this.riskActivityName).append(", extraUtmInfo=").append(this.extraUtmInfo).append(')');
        return sb.toString();
    }

    public TraeLoginRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        this.loginChannel = str;
        this.platform = str2;
        this.sso = str3;
        this.sig = str4;
        this.utmSource = str5;
        this.utmMedium = str6;
        this.utmCampaign = str7;
        this.utmTerm = str8;
        this.utmContent = str9;
        this.bdvid = str10;
        this.activityName = str11;
        this.activityId = str12;
        this.promotionChannel = str13;
        this.riskActivityName = str14;
        this.extraUtmInfo = str15;
    }

    public /* synthetic */ TraeLoginRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10, (i & 1024) != 0 ? null : str11, (i & 2048) != 0 ? null : str12, (i & 4096) != 0 ? null : str13, (i & 8192) != 0 ? null : str14, (i & 16384) == 0 ? str15 : null);
    }

    public final String getLoginChannel() {
        return this.loginChannel;
    }

    public final String getPlatform() {
        return this.platform;
    }

    public final String getSso() {
        return this.sso;
    }

    public final String getSig() {
        return this.sig;
    }

    public final String getUtmSource() {
        return this.utmSource;
    }

    public final String getUtmMedium() {
        return this.utmMedium;
    }

    public final String getUtmCampaign() {
        return this.utmCampaign;
    }

    public final String getUtmTerm() {
        return this.utmTerm;
    }

    public final String getUtmContent() {
        return this.utmContent;
    }

    public final String getBdvid() {
        return this.bdvid;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final String getPromotionChannel() {
        return this.promotionChannel;
    }

    public final String getRiskActivityName() {
        return this.riskActivityName;
    }

    public final String getExtraUtmInfo() {
        return this.extraUtmInfo;
    }
}
