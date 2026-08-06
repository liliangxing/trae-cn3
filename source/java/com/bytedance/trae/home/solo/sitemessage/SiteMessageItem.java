package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SiteMessageApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010.\u001a\u00020\u000bHÆ\u0003JR\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÇ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u00103\u001a\u00020\u0003H×\u0001J\t\u00104\u001a\u00020\u0006H×\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\b\u0010\u0016R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u001c\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0014R\u0013\u0010 \u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b!\u0010\u0014R\u0011\u0010\"\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0013\u0010%\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b&\u0010\u0014R\u0013\u0010'\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b(\u0010\u0014¨\u00065"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;", "", "id", "", "draftId", "notificationType", "", "effectiveTime", "isRead", "", "data", "Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;", "<init>", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;)V", "getId", "()I", "getDraftId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNotificationType", "()Ljava/lang/String;", "getEffectiveTime", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getData", "()Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;", "title", "getTitle", ReportConst.ValidationReport.BODY, "getBody", "actionTitle", "getActionTitle", "actionUrl", "getActionUrl", "openInBrowser", "getOpenInBrowser", "()Z", "commandId", "getCommandId", "commandArgs", "getCommandArgs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;)Lcom/bytedance/trae/home/solo/sitemessage/SiteMessageItem;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class SiteMessageItem {
    public static final int $stable = 0;

    @SerializedName("data")
    private final NotificationData data;

    @SerializedName("draftId")
    private final Integer draftId;

    @SerializedName("effectiveTime")
    private final String effectiveTime;

    @SerializedName("id")
    private final int id;

    @SerializedName("isRead")
    private final Boolean isRead;

    @SerializedName("notificationType")
    private final String notificationType;

    public static /* synthetic */ SiteMessageItem copy$default(SiteMessageItem siteMessageItem, int i, Integer num, String str, String str2, Boolean bool, NotificationData notificationData, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = siteMessageItem.id;
        }
        if ((i2 & 2) != 0) {
            num = siteMessageItem.draftId;
        }
        Integer num2 = num;
        if ((i2 & 4) != 0) {
            str = siteMessageItem.notificationType;
        }
        String str3 = str;
        if ((i2 & 8) != 0) {
            str2 = siteMessageItem.effectiveTime;
        }
        String str4 = str2;
        if ((i2 & 16) != 0) {
            bool = siteMessageItem.isRead;
        }
        Boolean bool2 = bool;
        if ((i2 & 32) != 0) {
            notificationData = siteMessageItem.data;
        }
        return siteMessageItem.copy(i, num2, str3, str4, bool2, notificationData);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getDraftId() {
        return this.draftId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getNotificationType() {
        return this.notificationType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getEffectiveTime() {
        return this.effectiveTime;
    }

    /* renamed from: component5, reason: from getter */
    public final Boolean getIsRead() {
        return this.isRead;
    }

    /* renamed from: component6, reason: from getter */
    public final NotificationData getData() {
        return this.data;
    }

    public final SiteMessageItem copy(int id, Integer draftId, String notificationType, String effectiveTime, Boolean isRead, NotificationData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        return new SiteMessageItem(id, draftId, notificationType, effectiveTime, isRead, data);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SiteMessageItem)) {
            return false;
        }
        SiteMessageItem siteMessageItem = (SiteMessageItem) other;
        return this.id == siteMessageItem.id && Intrinsics.areEqual(this.draftId, siteMessageItem.draftId) && Intrinsics.areEqual(this.notificationType, siteMessageItem.notificationType) && Intrinsics.areEqual(this.effectiveTime, siteMessageItem.effectiveTime) && Intrinsics.areEqual(this.isRead, siteMessageItem.isRead) && Intrinsics.areEqual(this.data, siteMessageItem.data);
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        Integer num = this.draftId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.notificationType;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.effectiveTime;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isRead;
        return ((hashCode4 + (bool != null ? bool.hashCode() : 0)) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "SiteMessageItem(id=" + this.id + ", draftId=" + this.draftId + ", notificationType=" + this.notificationType + ", effectiveTime=" + this.effectiveTime + ", isRead=" + this.isRead + ", data=" + this.data + ')';
    }

    public SiteMessageItem(int i, Integer num, String str, String str2, Boolean bool, NotificationData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.id = i;
        this.draftId = num;
        this.notificationType = str;
        this.effectiveTime = str2;
        this.isRead = bool;
        this.data = data;
    }

    public /* synthetic */ SiteMessageItem(int i, Integer num, String str, String str2, Boolean bool, NotificationData notificationData, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : str2, (i2 & 16) != 0 ? null : bool, notificationData);
    }

    public final int getId() {
        return this.id;
    }

    public final Integer getDraftId() {
        return this.draftId;
    }

    public final String getNotificationType() {
        return this.notificationType;
    }

    public final String getEffectiveTime() {
        return this.effectiveTime;
    }

    public final Boolean isRead() {
        return this.isRead;
    }

    public final NotificationData getData() {
        return this.data;
    }

    public final String getTitle() {
        String localized;
        LocalizedText title = this.data.getTitle();
        return (title == null || (localized = title.getLocalized()) == null) ? "" : localized;
    }

    public final String getBody() {
        String localized;
        LocalizedText content = this.data.getContent();
        return (content == null || (localized = content.getLocalized()) == null) ? "" : localized;
    }

    public final String getActionTitle() {
        LocalizedText label;
        NotificationButton button = this.data.getButton();
        if (button == null || (label = button.getLabel()) == null) {
            return null;
        }
        return label.getLocalized();
    }

    public final String getActionUrl() {
        NotificationButton button = this.data.getButton();
        if (button != null) {
            return button.getUrl();
        }
        return null;
    }

    public final boolean getOpenInBrowser() {
        NotificationButton button = this.data.getButton();
        if (button != null) {
            return Intrinsics.areEqual((Object) button.getOpenInBrowser(), (Object) true);
        }
        return false;
    }

    public final String getCommandId() {
        NotificationButton button = this.data.getButton();
        if (button != null) {
            return button.getCommandId();
        }
        return null;
    }

    public final String getCommandArgs() {
        NotificationButton button = this.data.getButton();
        if (button != null) {
            return button.getCommandArgs();
        }
        return null;
    }
}
