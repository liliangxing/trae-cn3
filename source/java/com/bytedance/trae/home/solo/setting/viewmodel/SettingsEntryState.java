package com.bytedance.trae.home.solo.setting.viewmodel;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsUiState.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003J\t\u00103\u001a\u00020\fHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u00106\u001a\u00020\u0015HÆ\u0003J\u008f\u0001\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÇ\u0001J\u0013\u00108\u001a\u00020\f2\b\u00109\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010:\u001a\u00020;H×\u0001J\t\u0010<\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0010\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006="}, d2 = {"Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEntryState;", "", "displayName", "", "accountText", "avatarUrl", "themeMode", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;", "identityBadgeText", "enterpriseBadge", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;", "showByteCloudBadge", "", "groups", "", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsGroup;", "showEditProfile", "messageUnreadBadge", "footer", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;", "aboutState", "Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;Ljava/lang/String;Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;ZLjava/util/List;ZLjava/lang/String;Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;)V", "getDisplayName", "()Ljava/lang/String;", "getAccountText", "getAvatarUrl", "getThemeMode", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsThemeMode;", "getIdentityBadgeText", "getEnterpriseBadge", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsEnterpriseBadge;", "getShowByteCloudBadge", "()Z", "getGroups", "()Ljava/util/List;", "getShowEditProfile", "getMessageUnreadBadge", "getFooter", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsFooterState;", "getAboutState", "()Lcom/bytedance/trae/home/solo/setting/viewmodel/SettingsAboutState;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class SettingsEntryState {
    public static final int $stable = 8;
    private final SettingsAboutState aboutState;
    private final String accountText;
    private final String avatarUrl;
    private final String displayName;
    private final SettingsEnterpriseBadge enterpriseBadge;
    private final SettingsFooterState footer;
    private final List<SettingsGroup> groups;
    private final String identityBadgeText;
    private final String messageUnreadBadge;
    private final boolean showByteCloudBadge;
    private final boolean showEditProfile;
    private final SettingsThemeMode themeMode;

    /* renamed from: component1, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component10, reason: from getter */
    public final String getMessageUnreadBadge() {
        return this.messageUnreadBadge;
    }

    /* renamed from: component11, reason: from getter */
    public final SettingsFooterState getFooter() {
        return this.footer;
    }

    /* renamed from: component12, reason: from getter */
    public final SettingsAboutState getAboutState() {
        return this.aboutState;
    }

    /* renamed from: component2, reason: from getter */
    public final String getAccountText() {
        return this.accountText;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final SettingsThemeMode getThemeMode() {
        return this.themeMode;
    }

    /* renamed from: component5, reason: from getter */
    public final String getIdentityBadgeText() {
        return this.identityBadgeText;
    }

    /* renamed from: component6, reason: from getter */
    public final SettingsEnterpriseBadge getEnterpriseBadge() {
        return this.enterpriseBadge;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getShowByteCloudBadge() {
        return this.showByteCloudBadge;
    }

    public final List<SettingsGroup> component8() {
        return this.groups;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getShowEditProfile() {
        return this.showEditProfile;
    }

    public final SettingsEntryState copy(String displayName, String accountText, String avatarUrl, SettingsThemeMode themeMode, String identityBadgeText, SettingsEnterpriseBadge enterpriseBadge, boolean showByteCloudBadge, List<SettingsGroup> groups, boolean showEditProfile, String messageUnreadBadge, SettingsFooterState footer, SettingsAboutState aboutState) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(accountText, "accountText");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        Intrinsics.checkNotNullParameter(themeMode, "themeMode");
        Intrinsics.checkNotNullParameter(groups, "groups");
        Intrinsics.checkNotNullParameter(aboutState, "aboutState");
        return new SettingsEntryState(displayName, accountText, avatarUrl, themeMode, identityBadgeText, enterpriseBadge, showByteCloudBadge, groups, showEditProfile, messageUnreadBadge, footer, aboutState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SettingsEntryState)) {
            return false;
        }
        SettingsEntryState settingsEntryState = (SettingsEntryState) other;
        return Intrinsics.areEqual(this.displayName, settingsEntryState.displayName) && Intrinsics.areEqual(this.accountText, settingsEntryState.accountText) && Intrinsics.areEqual(this.avatarUrl, settingsEntryState.avatarUrl) && this.themeMode == settingsEntryState.themeMode && Intrinsics.areEqual(this.identityBadgeText, settingsEntryState.identityBadgeText) && this.enterpriseBadge == settingsEntryState.enterpriseBadge && this.showByteCloudBadge == settingsEntryState.showByteCloudBadge && Intrinsics.areEqual(this.groups, settingsEntryState.groups) && this.showEditProfile == settingsEntryState.showEditProfile && Intrinsics.areEqual(this.messageUnreadBadge, settingsEntryState.messageUnreadBadge) && Intrinsics.areEqual(this.footer, settingsEntryState.footer) && Intrinsics.areEqual(this.aboutState, settingsEntryState.aboutState);
    }

    public int hashCode() {
        int hashCode = ((((((this.displayName.hashCode() * 31) + this.accountText.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + this.themeMode.hashCode()) * 31;
        String str = this.identityBadgeText;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        SettingsEnterpriseBadge settingsEnterpriseBadge = this.enterpriseBadge;
        int hashCode3 = (((((((hashCode2 + (settingsEnterpriseBadge == null ? 0 : settingsEnterpriseBadge.hashCode())) * 31) + Boolean.hashCode(this.showByteCloudBadge)) * 31) + this.groups.hashCode()) * 31) + Boolean.hashCode(this.showEditProfile)) * 31;
        String str2 = this.messageUnreadBadge;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        SettingsFooterState settingsFooterState = this.footer;
        return ((hashCode4 + (settingsFooterState != null ? settingsFooterState.hashCode() : 0)) * 31) + this.aboutState.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SettingsEntryState(displayName=");
        sb.append(this.displayName).append(", accountText=").append(this.accountText).append(", avatarUrl=").append(this.avatarUrl).append(", themeMode=").append(this.themeMode).append(", identityBadgeText=").append(this.identityBadgeText).append(", enterpriseBadge=").append(this.enterpriseBadge).append(", showByteCloudBadge=").append(this.showByteCloudBadge).append(", groups=").append(this.groups).append(", showEditProfile=").append(this.showEditProfile).append(", messageUnreadBadge=").append(this.messageUnreadBadge).append(", footer=").append(this.footer).append(", aboutState=");
        sb.append(this.aboutState).append(')');
        return sb.toString();
    }

    public SettingsEntryState(String str, String str2, String str3, SettingsThemeMode settingsThemeMode, String str4, SettingsEnterpriseBadge settingsEnterpriseBadge, boolean z, List<SettingsGroup> list, boolean z2, String str5, SettingsFooterState settingsFooterState, SettingsAboutState settingsAboutState) {
        Intrinsics.checkNotNullParameter(str, "displayName");
        Intrinsics.checkNotNullParameter(str2, "accountText");
        Intrinsics.checkNotNullParameter(str3, "avatarUrl");
        Intrinsics.checkNotNullParameter(settingsThemeMode, "themeMode");
        Intrinsics.checkNotNullParameter(list, "groups");
        Intrinsics.checkNotNullParameter(settingsAboutState, "aboutState");
        this.displayName = str;
        this.accountText = str2;
        this.avatarUrl = str3;
        this.themeMode = settingsThemeMode;
        this.identityBadgeText = str4;
        this.enterpriseBadge = settingsEnterpriseBadge;
        this.showByteCloudBadge = z;
        this.groups = list;
        this.showEditProfile = z2;
        this.messageUnreadBadge = str5;
        this.footer = settingsFooterState;
        this.aboutState = settingsAboutState;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getAccountText() {
        return this.accountText;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public /* synthetic */ SettingsEntryState(String str, String str2, String str3, SettingsThemeMode settingsThemeMode, String str4, SettingsEnterpriseBadge settingsEnterpriseBadge, boolean z, List list, boolean z2, String str5, SettingsFooterState settingsFooterState, SettingsAboutState settingsAboutState, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? SettingsThemeMode.Light : settingsThemeMode, str4, settingsEnterpriseBadge, z, list, z2, (i & StatusBarUtils.FLAG_NOTCH_PORTRAIT) != 0 ? null : str5, (i & 1024) != 0 ? null : settingsFooterState, settingsAboutState);
    }

    public final SettingsThemeMode getThemeMode() {
        return this.themeMode;
    }

    public final String getIdentityBadgeText() {
        return this.identityBadgeText;
    }

    public final SettingsEnterpriseBadge getEnterpriseBadge() {
        return this.enterpriseBadge;
    }

    public final boolean getShowByteCloudBadge() {
        return this.showByteCloudBadge;
    }

    public final List<SettingsGroup> getGroups() {
        return this.groups;
    }

    public final boolean getShowEditProfile() {
        return this.showEditProfile;
    }

    public final String getMessageUnreadBadge() {
        return this.messageUnreadBadge;
    }

    public final SettingsFooterState getFooter() {
        return this.footer;
    }

    public final SettingsAboutState getAboutState() {
        return this.aboutState;
    }
}
