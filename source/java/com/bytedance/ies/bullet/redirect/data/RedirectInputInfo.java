package com.bytedance.ies.bullet.redirect.data;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RedirectInputInfo.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÆ\u0003JW\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006&"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/RedirectInputInfo;", "", AccountMonitorConstants.CommonParameter.RAW, "", "key", "schemaQuery", "urlQuery", "defaultSchema", "reportInfo", "Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo;", "decodeQueryValue", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo;Z)V", "getDecodeQueryValue", "()Z", "setDecodeQueryValue", "(Z)V", "getDefaultSchema", "()Ljava/lang/String;", "getKey", "getRaw", "getReportInfo", "()Lcom/bytedance/ies/bullet/redirect/data/RedirectReportInfo;", "getSchemaQuery", "getUrlQuery", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RedirectInputInfo {
    private boolean decodeQueryValue;
    private final String defaultSchema;
    private final String key;
    private final String raw;
    private final RedirectReportInfo reportInfo;
    private final String schemaQuery;
    private final String urlQuery;

    public static /* synthetic */ RedirectInputInfo copy$default(RedirectInputInfo redirectInputInfo, String str, String str2, String str3, String str4, String str5, RedirectReportInfo redirectReportInfo, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = redirectInputInfo.raw;
        }
        if ((i & 2) != 0) {
            str2 = redirectInputInfo.key;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = redirectInputInfo.schemaQuery;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = redirectInputInfo.urlQuery;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = redirectInputInfo.defaultSchema;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            redirectReportInfo = redirectInputInfo.reportInfo;
        }
        RedirectReportInfo redirectReportInfo2 = redirectReportInfo;
        if ((i & 64) != 0) {
            z = redirectInputInfo.decodeQueryValue;
        }
        return redirectInputInfo.copy(str, str6, str7, str8, str9, redirectReportInfo2, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRaw() {
        return this.raw;
    }

    /* renamed from: component2, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: component3, reason: from getter */
    public final String getSchemaQuery() {
        return this.schemaQuery;
    }

    /* renamed from: component4, reason: from getter */
    public final String getUrlQuery() {
        return this.urlQuery;
    }

    /* renamed from: component5, reason: from getter */
    public final String getDefaultSchema() {
        return this.defaultSchema;
    }

    /* renamed from: component6, reason: from getter */
    public final RedirectReportInfo getReportInfo() {
        return this.reportInfo;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getDecodeQueryValue() {
        return this.decodeQueryValue;
    }

    public final RedirectInputInfo copy(String raw, String key, String schemaQuery, String urlQuery, String defaultSchema, RedirectReportInfo reportInfo, boolean decodeQueryValue) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        Intrinsics.checkNotNullParameter(key, "key");
        return new RedirectInputInfo(raw, key, schemaQuery, urlQuery, defaultSchema, reportInfo, decodeQueryValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RedirectInputInfo)) {
            return false;
        }
        RedirectInputInfo redirectInputInfo = (RedirectInputInfo) other;
        return Intrinsics.areEqual(this.raw, redirectInputInfo.raw) && Intrinsics.areEqual(this.key, redirectInputInfo.key) && Intrinsics.areEqual(this.schemaQuery, redirectInputInfo.schemaQuery) && Intrinsics.areEqual(this.urlQuery, redirectInputInfo.urlQuery) && Intrinsics.areEqual(this.defaultSchema, redirectInputInfo.defaultSchema) && Intrinsics.areEqual(this.reportInfo, redirectInputInfo.reportInfo) && this.decodeQueryValue == redirectInputInfo.decodeQueryValue;
    }

    public int hashCode() {
        int hashCode = ((this.raw.hashCode() * 31) + this.key.hashCode()) * 31;
        String str = this.schemaQuery;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.urlQuery;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.defaultSchema;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        RedirectReportInfo redirectReportInfo = this.reportInfo;
        return ((hashCode4 + (redirectReportInfo != null ? redirectReportInfo.hashCode() : 0)) * 31) + Boolean.hashCode(this.decodeQueryValue);
    }

    public String toString() {
        return "RedirectInputInfo(raw=" + this.raw + ", key=" + this.key + ", schemaQuery=" + this.schemaQuery + ", urlQuery=" + this.urlQuery + ", defaultSchema=" + this.defaultSchema + ", reportInfo=" + this.reportInfo + ", decodeQueryValue=" + this.decodeQueryValue + ')';
    }

    public RedirectInputInfo(String raw, String key, String str, String str2, String str3, RedirectReportInfo redirectReportInfo, boolean z) {
        Intrinsics.checkNotNullParameter(raw, "raw");
        Intrinsics.checkNotNullParameter(key, "key");
        this.raw = raw;
        this.key = key;
        this.schemaQuery = str;
        this.urlQuery = str2;
        this.defaultSchema = str3;
        this.reportInfo = redirectReportInfo;
        this.decodeQueryValue = z;
    }

    public /* synthetic */ RedirectInputInfo(String str, String str2, String str3, String str4, String str5, RedirectReportInfo redirectReportInfo, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, redirectReportInfo, (i & 64) != 0 ? false : z);
    }

    public final String getRaw() {
        return this.raw;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getSchemaQuery() {
        return this.schemaQuery;
    }

    public final String getUrlQuery() {
        return this.urlQuery;
    }

    public final String getDefaultSchema() {
        return this.defaultSchema;
    }

    public final RedirectReportInfo getReportInfo() {
        return this.reportInfo;
    }

    public final boolean getDecodeQueryValue() {
        return this.decodeQueryValue;
    }

    public final void setDecodeQueryValue(boolean z) {
        this.decodeQueryValue = z;
    }
}
