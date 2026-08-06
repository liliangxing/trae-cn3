package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SiteMessageApi.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003JV\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÇ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010!\u001a\u00020\"H×\u0001J\t\u0010#\u001a\u00020\bH×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0018\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014¨\u0006$"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;", "", "label", "Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;", "openInBrowser", "", "primary", "commandId", "", "commandArgs", "url", "<init>", "(Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLabel", "()Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;", "getOpenInBrowser", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getPrimary", "getCommandId", "()Ljava/lang/String;", "getCommandArgs", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class NotificationButton {
    public static final int $stable = 0;

    @SerializedName("commandArgs")
    private final String commandArgs;

    @SerializedName("commandId")
    private final String commandId;

    @SerializedName("label")
    private final LocalizedText label;

    @SerializedName("openInBrowser")
    private final Boolean openInBrowser;

    @SerializedName("primary")
    private final Boolean primary;

    @SerializedName("url")
    private final String url;

    public NotificationButton() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ NotificationButton copy$default(NotificationButton notificationButton, LocalizedText localizedText, Boolean bool, Boolean bool2, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            localizedText = notificationButton.label;
        }
        if ((i & 2) != 0) {
            bool = notificationButton.openInBrowser;
        }
        Boolean bool3 = bool;
        if ((i & 4) != 0) {
            bool2 = notificationButton.primary;
        }
        Boolean bool4 = bool2;
        if ((i & 8) != 0) {
            str = notificationButton.commandId;
        }
        String str4 = str;
        if ((i & 16) != 0) {
            str2 = notificationButton.commandArgs;
        }
        String str5 = str2;
        if ((i & 32) != 0) {
            str3 = notificationButton.url;
        }
        return notificationButton.copy(localizedText, bool3, bool4, str4, str5, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final LocalizedText getLabel() {
        return this.label;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getOpenInBrowser() {
        return this.openInBrowser;
    }

    /* renamed from: component3, reason: from getter */
    public final Boolean getPrimary() {
        return this.primary;
    }

    /* renamed from: component4, reason: from getter */
    public final String getCommandId() {
        return this.commandId;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCommandArgs() {
        return this.commandArgs;
    }

    /* renamed from: component6, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final NotificationButton copy(LocalizedText label, Boolean openInBrowser, Boolean primary, String commandId, String commandArgs, String url) {
        return new NotificationButton(label, openInBrowser, primary, commandId, commandArgs, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationButton)) {
            return false;
        }
        NotificationButton notificationButton = (NotificationButton) other;
        return Intrinsics.areEqual(this.label, notificationButton.label) && Intrinsics.areEqual(this.openInBrowser, notificationButton.openInBrowser) && Intrinsics.areEqual(this.primary, notificationButton.primary) && Intrinsics.areEqual(this.commandId, notificationButton.commandId) && Intrinsics.areEqual(this.commandArgs, notificationButton.commandArgs) && Intrinsics.areEqual(this.url, notificationButton.url);
    }

    public int hashCode() {
        LocalizedText localizedText = this.label;
        int hashCode = (localizedText == null ? 0 : localizedText.hashCode()) * 31;
        Boolean bool = this.openInBrowser;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.primary;
        int hashCode3 = (hashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str = this.commandId;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.commandArgs;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.url;
        return hashCode5 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "NotificationButton(label=" + this.label + ", openInBrowser=" + this.openInBrowser + ", primary=" + this.primary + ", commandId=" + this.commandId + ", commandArgs=" + this.commandArgs + ", url=" + this.url + ')';
    }

    public NotificationButton(LocalizedText localizedText, Boolean bool, Boolean bool2, String str, String str2, String str3) {
        this.label = localizedText;
        this.openInBrowser = bool;
        this.primary = bool2;
        this.commandId = str;
        this.commandArgs = str2;
        this.url = str3;
    }

    public /* synthetic */ NotificationButton(LocalizedText localizedText, Boolean bool, Boolean bool2, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : localizedText, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : bool2, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : str2, (i & 32) != 0 ? null : str3);
    }

    public final LocalizedText getLabel() {
        return this.label;
    }

    public final Boolean getOpenInBrowser() {
        return this.openInBrowser;
    }

    public final Boolean getPrimary() {
        return this.primary;
    }

    public final String getCommandId() {
        return this.commandId;
    }

    public final String getCommandArgs() {
        return this.commandArgs;
    }

    public final String getUrl() {
        return this.url;
    }
}
