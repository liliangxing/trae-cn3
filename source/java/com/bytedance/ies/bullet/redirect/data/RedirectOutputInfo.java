package com.bytedance.ies.bullet.redirect.data;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RedirectOutputInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/RedirectOutputInfo;", "", "schema", "", "errorCode", "", "errorMsg", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getErrorMsg", "()Ljava/lang/String;", "getSchema", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/ies/bullet/redirect/data/RedirectOutputInfo;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RedirectOutputInfo {
    private final Integer errorCode;
    private final String errorMsg;
    private final String schema;

    public static /* synthetic */ RedirectOutputInfo copy$default(RedirectOutputInfo redirectOutputInfo, String str, Integer num, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = redirectOutputInfo.schema;
        }
        if ((i & 2) != 0) {
            num = redirectOutputInfo.errorCode;
        }
        if ((i & 4) != 0) {
            str2 = redirectOutputInfo.errorMsg;
        }
        return redirectOutputInfo.copy(str, num, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getSchema() {
        return this.schema;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getErrorCode() {
        return this.errorCode;
    }

    /* renamed from: component3, reason: from getter */
    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final RedirectOutputInfo copy(String schema, Integer errorCode, String errorMsg) {
        return new RedirectOutputInfo(schema, errorCode, errorMsg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RedirectOutputInfo)) {
            return false;
        }
        RedirectOutputInfo redirectOutputInfo = (RedirectOutputInfo) other;
        return Intrinsics.areEqual(this.schema, redirectOutputInfo.schema) && Intrinsics.areEqual(this.errorCode, redirectOutputInfo.errorCode) && Intrinsics.areEqual(this.errorMsg, redirectOutputInfo.errorMsg);
    }

    public int hashCode() {
        String str = this.schema;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.errorCode;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.errorMsg;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "RedirectOutputInfo(schema=" + this.schema + ", errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ')';
    }

    public RedirectOutputInfo(String str, Integer num, String str2) {
        this.schema = str;
        this.errorCode = num;
        this.errorMsg = str2;
    }

    public final String getSchema() {
        return this.schema;
    }

    public /* synthetic */ RedirectOutputInfo(String str, Integer num, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? 0 : num, (i & 4) != 0 ? "" : str2);
    }

    public final Integer getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }
}
