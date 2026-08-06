package com.bytedance.sdk.xbridge.cn.calendar.model;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalendarModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\nHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003Jc\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\nHÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006'"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/model/CalendarModel;", "", "id", "", "name", "", "displayName", "accountType", "accountName", "visible", "", "ownerAccount", "accessLevel", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;I)V", "getAccessLevel", "()I", "getAccountName", "()Ljava/lang/String;", "getAccountType", "getDisplayName", "getId", "()J", "getName", "getOwnerAccount", "getVisible", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class CalendarModel {
    private final int accessLevel;
    private final String accountName;
    private final String accountType;
    private final String displayName;
    private final long id;
    private final String name;
    private final String ownerAccount;
    private final int visible;

    public CalendarModel() {
        this(0L, null, null, null, null, 0, null, 0, 255, null);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getAccountType() {
        return this.accountType;
    }

    /* renamed from: component5, reason: from getter */
    public final String getAccountName() {
        return this.accountName;
    }

    /* renamed from: component6, reason: from getter */
    public final int getVisible() {
        return this.visible;
    }

    /* renamed from: component7, reason: from getter */
    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    /* renamed from: component8, reason: from getter */
    public final int getAccessLevel() {
        return this.accessLevel;
    }

    public final CalendarModel copy(long id, String name, String displayName, String accountType, String accountName, int visible, String ownerAccount, int accessLevel) {
        return new CalendarModel(id, name, displayName, accountType, accountName, visible, ownerAccount, accessLevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarModel)) {
            return false;
        }
        CalendarModel calendarModel = (CalendarModel) other;
        return this.id == calendarModel.id && Intrinsics.areEqual(this.name, calendarModel.name) && Intrinsics.areEqual(this.displayName, calendarModel.displayName) && Intrinsics.areEqual(this.accountType, calendarModel.accountType) && Intrinsics.areEqual(this.accountName, calendarModel.accountName) && this.visible == calendarModel.visible && Intrinsics.areEqual(this.ownerAccount, calendarModel.ownerAccount) && this.accessLevel == calendarModel.accessLevel;
    }

    public int hashCode() {
        int hashCode = Long.hashCode(this.id) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.displayName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.accountType;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.accountName;
        int hashCode5 = (((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Integer.hashCode(this.visible)) * 31;
        String str5 = this.ownerAccount;
        return ((hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31) + Integer.hashCode(this.accessLevel);
    }

    public String toString() {
        return "CalendarModel(id=" + this.id + ", name=" + this.name + ", displayName=" + this.displayName + ", accountType=" + this.accountType + ", accountName=" + this.accountName + ", visible=" + this.visible + ", ownerAccount=" + this.ownerAccount + ", accessLevel=" + this.accessLevel + ')';
    }

    public CalendarModel(long j, String str, String str2, String str3, String str4, int i, String str5, int i2) {
        this.id = j;
        this.name = str;
        this.displayName = str2;
        this.accountType = str3;
        this.accountName = str4;
        this.visible = i;
        this.ownerAccount = str5;
        this.accessLevel = i2;
    }

    public /* synthetic */ CalendarModel(long j, String str, String str2, String str3, String str4, int i, String str5, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3, (i3 & 16) != 0 ? null : str4, (i3 & 32) != 0 ? 0 : i, (i3 & 64) == 0 ? str5 : null, (i3 & 128) != 0 ? -1 : i2);
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getAccountType() {
        return this.accountType;
    }

    public final String getAccountName() {
        return this.accountName;
    }

    public final int getVisible() {
        return this.visible;
    }

    public final String getOwnerAccount() {
        return this.ownerAccount;
    }

    public final int getAccessLevel() {
        return this.accessLevel;
    }
}
