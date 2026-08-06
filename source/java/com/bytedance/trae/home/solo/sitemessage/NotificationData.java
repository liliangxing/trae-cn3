package com.bytedance.trae.home.solo.sitemessage;

import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SiteMessageApi.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÇ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0015\u001a\u00020\u0016H×\u0001J\t\u0010\u0017\u001a\u00020\u0018H×\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/home/solo/sitemessage/NotificationData;", "", "title", "Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;", ReportConstant.COMMON_CONTENT, "button", "Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;", "<init>", "(Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;)V", "getTitle", "()Lcom/bytedance/trae/home/solo/sitemessage/LocalizedText;", "getContent", "getButton", "()Lcom/bytedance/trae/home/solo/sitemessage/NotificationButton;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class NotificationData {
    public static final int $stable = 0;

    @SerializedName("button")
    private final NotificationButton button;

    @SerializedName(ReportConstant.COMMON_CONTENT)
    private final LocalizedText content;

    @SerializedName("title")
    private final LocalizedText title;

    public NotificationData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NotificationData copy$default(NotificationData notificationData, LocalizedText localizedText, LocalizedText localizedText2, NotificationButton notificationButton, int i, Object obj) {
        if ((i & 1) != 0) {
            localizedText = notificationData.title;
        }
        if ((i & 2) != 0) {
            localizedText2 = notificationData.content;
        }
        if ((i & 4) != 0) {
            notificationButton = notificationData.button;
        }
        return notificationData.copy(localizedText, localizedText2, notificationButton);
    }

    /* renamed from: component1, reason: from getter */
    public final LocalizedText getTitle() {
        return this.title;
    }

    /* renamed from: component2, reason: from getter */
    public final LocalizedText getContent() {
        return this.content;
    }

    /* renamed from: component3, reason: from getter */
    public final NotificationButton getButton() {
        return this.button;
    }

    public final NotificationData copy(LocalizedText title, LocalizedText content, NotificationButton button) {
        return new NotificationData(title, content, button);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NotificationData)) {
            return false;
        }
        NotificationData notificationData = (NotificationData) other;
        return Intrinsics.areEqual(this.title, notificationData.title) && Intrinsics.areEqual(this.content, notificationData.content) && Intrinsics.areEqual(this.button, notificationData.button);
    }

    public int hashCode() {
        LocalizedText localizedText = this.title;
        int hashCode = (localizedText == null ? 0 : localizedText.hashCode()) * 31;
        LocalizedText localizedText2 = this.content;
        int hashCode2 = (hashCode + (localizedText2 == null ? 0 : localizedText2.hashCode())) * 31;
        NotificationButton notificationButton = this.button;
        return hashCode2 + (notificationButton != null ? notificationButton.hashCode() : 0);
    }

    public String toString() {
        return "NotificationData(title=" + this.title + ", content=" + this.content + ", button=" + this.button + ')';
    }

    public NotificationData(LocalizedText localizedText, LocalizedText localizedText2, NotificationButton notificationButton) {
        this.title = localizedText;
        this.content = localizedText2;
        this.button = notificationButton;
    }

    public /* synthetic */ NotificationData(LocalizedText localizedText, LocalizedText localizedText2, NotificationButton notificationButton, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : localizedText, (i & 2) != 0 ? null : localizedText2, (i & 4) != 0 ? null : notificationButton);
    }

    public final LocalizedText getTitle() {
        return this.title;
    }

    public final LocalizedText getContent() {
        return this.content;
    }

    public final NotificationButton getButton() {
        return this.button;
    }
}
