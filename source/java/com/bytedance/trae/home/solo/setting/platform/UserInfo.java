package com.bytedance.trae.home.solo.setting.platform;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserInfoProvider.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÇ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0018\u001a\u00020\u0007H×\u0001J\t\u0010\u0019\u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/platform/UserInfo;", "", "displayName", "", "accountText", "avatarUrl", "productType", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getDisplayName", "()Ljava/lang/String;", "getAccountText", "getAvatarUrl", "getProductType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class UserInfo {
    public static final int $stable = 0;
    private final String accountText;
    private final String avatarUrl;
    private final String displayName;
    private final int productType;

    public static /* synthetic */ UserInfo copy$default(UserInfo userInfo, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = userInfo.displayName;
        }
        if ((i2 & 2) != 0) {
            str2 = userInfo.accountText;
        }
        if ((i2 & 4) != 0) {
            str3 = userInfo.avatarUrl;
        }
        if ((i2 & 8) != 0) {
            i = userInfo.productType;
        }
        return userInfo.copy(str, str2, str3, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
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
    public final int getProductType() {
        return this.productType;
    }

    public final UserInfo copy(String displayName, String accountText, String avatarUrl, int productType) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(accountText, "accountText");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        return new UserInfo(displayName, accountText, avatarUrl, productType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserInfo)) {
            return false;
        }
        UserInfo userInfo = (UserInfo) other;
        return Intrinsics.areEqual(this.displayName, userInfo.displayName) && Intrinsics.areEqual(this.accountText, userInfo.accountText) && Intrinsics.areEqual(this.avatarUrl, userInfo.avatarUrl) && this.productType == userInfo.productType;
    }

    public int hashCode() {
        return (((((this.displayName.hashCode() * 31) + this.accountText.hashCode()) * 31) + this.avatarUrl.hashCode()) * 31) + Integer.hashCode(this.productType);
    }

    public String toString() {
        return "UserInfo(displayName=" + this.displayName + ", accountText=" + this.accountText + ", avatarUrl=" + this.avatarUrl + ", productType=" + this.productType + ')';
    }

    public UserInfo(String displayName, String accountText, String avatarUrl, int i) {
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        Intrinsics.checkNotNullParameter(accountText, "accountText");
        Intrinsics.checkNotNullParameter(avatarUrl, "avatarUrl");
        this.displayName = displayName;
        this.accountText = accountText;
        this.avatarUrl = avatarUrl;
        this.productType = i;
    }

    public /* synthetic */ UserInfo(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i2 & 8) != 0 ? 0 : i);
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

    public final int getProductType() {
        return this.productType;
    }
}
