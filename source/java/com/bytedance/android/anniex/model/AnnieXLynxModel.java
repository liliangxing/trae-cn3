package com.bytedance.android.anniex.model;

import android.net.Uri;
import com.bytedance.forest.model.PreloadConfig;
import com.lynx.tasm.TemplateData;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnnieXLynxModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0003PQRB\u009f\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010\u0019J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0011HÆ\u0003J\t\u0010=\u001a\u00020\u0011HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0011HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\t\u0010B\u001a\u00020\u0005HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010F\u001a\u00020\u000bHÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u000fHÆ\u0003J«\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÆ\u0001J\u0013\u0010K\u001a\u00020\u00112\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020NHÖ\u0001J\t\u0010O\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\u0012\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010 R\u001a\u0010(\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010 \"\u0004\b*\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001bR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001b\"\u0004\b4\u00105R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b8\u0010'R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u001bR\u0011\u0010\u0016\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b:\u0010 ¨\u0006S"}, d2 = {"Lcom/bytedance/android/anniex/model/AnnieXLynxModel;", "", "url", "", "originalUri", "Landroid/net/Uri;", "bid", "globalProps", "Lcom/lynx/tasm/TemplateData;", "extra", "lynxViewBuilderParams", "Lcom/bytedance/android/anniex/model/LynxViewBuilderParams;", "sessionId", "templateData", "template", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel$ComparableByteArray;", "isSSR", "", "isCompactMode", "ssrHydrateConfig", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel$SSRHydrateConfig;", "enterFrom", "useXBridge3", "compactConfig", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel$CompactConfig;", "(Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;Lcom/lynx/tasm/TemplateData;Ljava/lang/Object;Lcom/bytedance/android/anniex/model/LynxViewBuilderParams;Ljava/lang/String;Lcom/lynx/tasm/TemplateData;Lcom/bytedance/android/anniex/model/AnnieXLynxModel$ComparableByteArray;ZZLcom/bytedance/android/anniex/model/AnnieXLynxModel$SSRHydrateConfig;Ljava/lang/String;ZLcom/bytedance/android/anniex/model/AnnieXLynxModel$CompactConfig;)V", "getBid", "()Ljava/lang/String;", "getCompactConfig", "()Lcom/bytedance/android/anniex/model/AnnieXLynxModel$CompactConfig;", "enableElementTreeReuse", "getEnableElementTreeReuse$anniex_release", "()Z", "setEnableElementTreeReuse$anniex_release", "(Z)V", "getEnterFrom", "getExtra", "()Ljava/lang/Object;", "getGlobalProps", "()Lcom/lynx/tasm/TemplateData;", "isLynxSSRViaSchemaConfig", "isLynxSSRViaSchemaConfig$anniex_release", "setLynxSSRViaSchemaConfig$anniex_release", "getLynxViewBuilderParams", "()Lcom/bytedance/android/anniex/model/LynxViewBuilderParams;", "getOriginalUri", "()Landroid/net/Uri;", "getSessionId", "getSsrHydrateConfig", "()Lcom/bytedance/android/anniex/model/AnnieXLynxModel$SSRHydrateConfig;", "ssrMode", "getSsrMode$anniex_release", "setSsrMode$anniex_release", "(Ljava/lang/String;)V", "getTemplate", "()Lcom/bytedance/android/anniex/model/AnnieXLynxModel$ComparableByteArray;", "getTemplateData", "getUrl", "getUseXBridge3", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "CompactConfig", "ComparableByteArray", "SSRHydrateConfig", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AnnieXLynxModel {
    private final String bid;
    private final CompactConfig compactConfig;
    private boolean enableElementTreeReuse;
    private final String enterFrom;
    private final Object extra;
    private final TemplateData globalProps;
    private final boolean isCompactMode;
    private boolean isLynxSSRViaSchemaConfig;
    private final boolean isSSR;
    private final LynxViewBuilderParams lynxViewBuilderParams;
    private final Uri originalUri;
    private final String sessionId;
    private final SSRHydrateConfig ssrHydrateConfig;
    private String ssrMode;
    private final ComparableByteArray template;
    private final TemplateData templateData;
    private final String url;
    private final boolean useXBridge3;

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsSSR() {
        return this.isSSR;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getIsCompactMode() {
        return this.isCompactMode;
    }

    /* renamed from: component12, reason: from getter */
    public final SSRHydrateConfig getSsrHydrateConfig() {
        return this.ssrHydrateConfig;
    }

    /* renamed from: component13, reason: from getter */
    public final String getEnterFrom() {
        return this.enterFrom;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getUseXBridge3() {
        return this.useXBridge3;
    }

    /* renamed from: component15, reason: from getter */
    public final CompactConfig getCompactConfig() {
        return this.compactConfig;
    }

    /* renamed from: component2, reason: from getter */
    public final Uri getOriginalUri() {
        return this.originalUri;
    }

    /* renamed from: component3, reason: from getter */
    public final String getBid() {
        return this.bid;
    }

    /* renamed from: component4, reason: from getter */
    public final TemplateData getGlobalProps() {
        return this.globalProps;
    }

    /* renamed from: component5, reason: from getter */
    public final Object getExtra() {
        return this.extra;
    }

    /* renamed from: component6, reason: from getter */
    public final LynxViewBuilderParams getLynxViewBuilderParams() {
        return this.lynxViewBuilderParams;
    }

    /* renamed from: component7, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* renamed from: component8, reason: from getter */
    public final TemplateData getTemplateData() {
        return this.templateData;
    }

    /* renamed from: component9, reason: from getter */
    public final ComparableByteArray getTemplate() {
        return this.template;
    }

    public final AnnieXLynxModel copy(String url, Uri originalUri, String bid, TemplateData globalProps, Object extra, LynxViewBuilderParams lynxViewBuilderParams, String sessionId, TemplateData templateData, ComparableByteArray template, boolean isSSR, boolean isCompactMode, SSRHydrateConfig ssrHydrateConfig, String enterFrom, boolean useXBridge3, CompactConfig compactConfig) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(originalUri, "originalUri");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(lynxViewBuilderParams, "lynxViewBuilderParams");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        return new AnnieXLynxModel(url, originalUri, bid, globalProps, extra, lynxViewBuilderParams, sessionId, templateData, template, isSSR, isCompactMode, ssrHydrateConfig, enterFrom, useXBridge3, compactConfig);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnnieXLynxModel)) {
            return false;
        }
        AnnieXLynxModel annieXLynxModel = (AnnieXLynxModel) other;
        return Intrinsics.areEqual(this.url, annieXLynxModel.url) && Intrinsics.areEqual(this.originalUri, annieXLynxModel.originalUri) && Intrinsics.areEqual(this.bid, annieXLynxModel.bid) && Intrinsics.areEqual(this.globalProps, annieXLynxModel.globalProps) && Intrinsics.areEqual(this.extra, annieXLynxModel.extra) && Intrinsics.areEqual(this.lynxViewBuilderParams, annieXLynxModel.lynxViewBuilderParams) && Intrinsics.areEqual(this.sessionId, annieXLynxModel.sessionId) && Intrinsics.areEqual(this.templateData, annieXLynxModel.templateData) && Intrinsics.areEqual(this.template, annieXLynxModel.template) && this.isSSR == annieXLynxModel.isSSR && this.isCompactMode == annieXLynxModel.isCompactMode && Intrinsics.areEqual(this.ssrHydrateConfig, annieXLynxModel.ssrHydrateConfig) && Intrinsics.areEqual(this.enterFrom, annieXLynxModel.enterFrom) && this.useXBridge3 == annieXLynxModel.useXBridge3 && Intrinsics.areEqual(this.compactConfig, annieXLynxModel.compactConfig);
    }

    public int hashCode() {
        int hashCode = ((((this.url.hashCode() * 31) + this.originalUri.hashCode()) * 31) + this.bid.hashCode()) * 31;
        TemplateData templateData = this.globalProps;
        int hashCode2 = (hashCode + (templateData == null ? 0 : templateData.hashCode())) * 31;
        Object obj = this.extra;
        int hashCode3 = (((((hashCode2 + (obj == null ? 0 : obj.hashCode())) * 31) + this.lynxViewBuilderParams.hashCode()) * 31) + this.sessionId.hashCode()) * 31;
        TemplateData templateData2 = this.templateData;
        int hashCode4 = (hashCode3 + (templateData2 == null ? 0 : templateData2.hashCode())) * 31;
        ComparableByteArray comparableByteArray = this.template;
        int hashCode5 = (((((hashCode4 + (comparableByteArray == null ? 0 : comparableByteArray.hashCode())) * 31) + Boolean.hashCode(this.isSSR)) * 31) + Boolean.hashCode(this.isCompactMode)) * 31;
        SSRHydrateConfig sSRHydrateConfig = this.ssrHydrateConfig;
        int hashCode6 = (((((hashCode5 + (sSRHydrateConfig == null ? 0 : sSRHydrateConfig.hashCode())) * 31) + this.enterFrom.hashCode()) * 31) + Boolean.hashCode(this.useXBridge3)) * 31;
        CompactConfig compactConfig = this.compactConfig;
        return hashCode6 + (compactConfig != null ? compactConfig.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AnnieXLynxModel(url=");
        sb.append(this.url).append(", originalUri=").append(this.originalUri).append(", bid=").append(this.bid).append(", globalProps=").append(this.globalProps).append(", extra=").append(this.extra).append(", lynxViewBuilderParams=").append(this.lynxViewBuilderParams).append(", sessionId=").append(this.sessionId).append(", templateData=").append(this.templateData).append(", template=").append(this.template).append(", isSSR=").append(this.isSSR).append(", isCompactMode=").append(this.isCompactMode).append(", ssrHydrateConfig=");
        sb.append(this.ssrHydrateConfig).append(", enterFrom=").append(this.enterFrom).append(", useXBridge3=").append(this.useXBridge3).append(", compactConfig=").append(this.compactConfig).append(')');
        return sb.toString();
    }

    public AnnieXLynxModel(String url, Uri originalUri, String bid, TemplateData templateData, Object obj, LynxViewBuilderParams lynxViewBuilderParams, String sessionId, TemplateData templateData2, ComparableByteArray comparableByteArray, boolean z, boolean z2, SSRHydrateConfig sSRHydrateConfig, String enterFrom, boolean z3, CompactConfig compactConfig) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(originalUri, "originalUri");
        Intrinsics.checkNotNullParameter(bid, "bid");
        Intrinsics.checkNotNullParameter(lynxViewBuilderParams, "lynxViewBuilderParams");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        this.url = url;
        this.originalUri = originalUri;
        this.bid = bid;
        this.globalProps = templateData;
        this.extra = obj;
        this.lynxViewBuilderParams = lynxViewBuilderParams;
        this.sessionId = sessionId;
        this.templateData = templateData2;
        this.template = comparableByteArray;
        this.isSSR = z;
        this.isCompactMode = z2;
        this.ssrHydrateConfig = sSRHydrateConfig;
        this.enterFrom = enterFrom;
        this.useXBridge3 = z3;
        this.compactConfig = compactConfig;
        this.ssrMode = "";
    }

    public /* synthetic */ AnnieXLynxModel(String str, Uri uri, String str2, TemplateData templateData, Object obj, LynxViewBuilderParams lynxViewBuilderParams, String str3, TemplateData templateData2, ComparableByteArray comparableByteArray, boolean z, boolean z2, SSRHydrateConfig sSRHydrateConfig, String str4, boolean z3, CompactConfig compactConfig, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, uri, (i & 4) != 0 ? "default_bid" : str2, (i & 8) != 0 ? null : templateData, (i & 16) != 0 ? null : obj, lynxViewBuilderParams, str3, (i & 128) != 0 ? null : templateData2, (i & 256) != 0 ? null : comparableByteArray, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? false : z2, (i & 2048) != 0 ? null : sSRHydrateConfig, (i & 4096) != 0 ? "annieXCard" : str4, (i & 8192) != 0 ? true : z3, (i & 16384) != 0 ? null : compactConfig);
    }

    public final String getUrl() {
        return this.url;
    }

    public final Uri getOriginalUri() {
        return this.originalUri;
    }

    public final String getBid() {
        return this.bid;
    }

    public final TemplateData getGlobalProps() {
        return this.globalProps;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public final LynxViewBuilderParams getLynxViewBuilderParams() {
        return this.lynxViewBuilderParams;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final TemplateData getTemplateData() {
        return this.templateData;
    }

    public final ComparableByteArray getTemplate() {
        return this.template;
    }

    public final boolean isSSR() {
        return this.isSSR;
    }

    public final boolean isCompactMode() {
        return this.isCompactMode;
    }

    public final SSRHydrateConfig getSsrHydrateConfig() {
        return this.ssrHydrateConfig;
    }

    public final String getEnterFrom() {
        return this.enterFrom;
    }

    public final boolean getUseXBridge3() {
        return this.useXBridge3;
    }

    public final CompactConfig getCompactConfig() {
        return this.compactConfig;
    }

    /* renamed from: isLynxSSRViaSchemaConfig$anniex_release, reason: from getter */
    public final boolean getIsLynxSSRViaSchemaConfig() {
        return this.isLynxSSRViaSchemaConfig;
    }

    public final void setLynxSSRViaSchemaConfig$anniex_release(boolean z) {
        this.isLynxSSRViaSchemaConfig = z;
    }

    /* renamed from: getSsrMode$anniex_release, reason: from getter */
    public final String getSsrMode() {
        return this.ssrMode;
    }

    public final void setSsrMode$anniex_release(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ssrMode = str;
    }

    /* renamed from: getEnableElementTreeReuse$anniex_release, reason: from getter */
    public final boolean getEnableElementTreeReuse() {
        return this.enableElementTreeReuse;
    }

    public final void setEnableElementTreeReuse$anniex_release(boolean z) {
        this.enableElementTreeReuse = z;
    }

    /* compiled from: AnnieXLynxModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/model/AnnieXLynxModel$ComparableByteArray;", "", "templateJS", "", "([B)V", "getTemplateJS", "()[B", "component1", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ComparableByteArray {
        private final byte[] templateJS;

        public static /* synthetic */ ComparableByteArray copy$default(ComparableByteArray comparableByteArray, byte[] bArr, int i, Object obj) {
            if ((i & 1) != 0) {
                bArr = comparableByteArray.templateJS;
            }
            return comparableByteArray.copy(bArr);
        }

        /* renamed from: component1, reason: from getter */
        public final byte[] getTemplateJS() {
            return this.templateJS;
        }

        public final ComparableByteArray copy(byte[] templateJS) {
            Intrinsics.checkNotNullParameter(templateJS, "templateJS");
            return new ComparableByteArray(templateJS);
        }

        public String toString() {
            return "ComparableByteArray(templateJS=" + Arrays.toString(this.templateJS) + ')';
        }

        public ComparableByteArray(byte[] templateJS) {
            Intrinsics.checkNotNullParameter(templateJS, "templateJS");
            this.templateJS = templateJS;
        }

        public final byte[] getTemplateJS() {
            return this.templateJS;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!Intrinsics.areEqual(getClass(), other != null ? other.getClass() : null)) {
                return false;
            }
            Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.bytedance.android.anniex.model.AnnieXLynxModel.ComparableByteArray");
            return Arrays.equals(this.templateJS, ((ComparableByteArray) other).templateJS);
        }

        public int hashCode() {
            return Arrays.hashCode(this.templateJS);
        }
    }

    /* compiled from: AnnieXLynxModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/anniex/model/AnnieXLynxModel$SSRHydrateConfig;", "", "template", "Lcom/bytedance/android/anniex/model/AnnieXLynxModel$ComparableByteArray;", "baseUrl", "", "templateData", "Lcom/lynx/tasm/TemplateData;", "(Lcom/bytedance/android/anniex/model/AnnieXLynxModel$ComparableByteArray;Ljava/lang/String;Lcom/lynx/tasm/TemplateData;)V", "getBaseUrl", "()Ljava/lang/String;", "getTemplate", "()Lcom/bytedance/android/anniex/model/AnnieXLynxModel$ComparableByteArray;", "getTemplateData", "()Lcom/lynx/tasm/TemplateData;", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SSRHydrateConfig {
        private final String baseUrl;
        private final ComparableByteArray template;
        private final TemplateData templateData;

        public SSRHydrateConfig() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ SSRHydrateConfig copy$default(SSRHydrateConfig sSRHydrateConfig, ComparableByteArray comparableByteArray, String str, TemplateData templateData, int i, Object obj) {
            if ((i & 1) != 0) {
                comparableByteArray = sSRHydrateConfig.template;
            }
            if ((i & 2) != 0) {
                str = sSRHydrateConfig.baseUrl;
            }
            if ((i & 4) != 0) {
                templateData = sSRHydrateConfig.templateData;
            }
            return sSRHydrateConfig.copy(comparableByteArray, str, templateData);
        }

        /* renamed from: component1, reason: from getter */
        public final ComparableByteArray getTemplate() {
            return this.template;
        }

        /* renamed from: component2, reason: from getter */
        public final String getBaseUrl() {
            return this.baseUrl;
        }

        /* renamed from: component3, reason: from getter */
        public final TemplateData getTemplateData() {
            return this.templateData;
        }

        public final SSRHydrateConfig copy(ComparableByteArray template, String baseUrl, TemplateData templateData) {
            return new SSRHydrateConfig(template, baseUrl, templateData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SSRHydrateConfig)) {
                return false;
            }
            SSRHydrateConfig sSRHydrateConfig = (SSRHydrateConfig) other;
            return Intrinsics.areEqual(this.template, sSRHydrateConfig.template) && Intrinsics.areEqual(this.baseUrl, sSRHydrateConfig.baseUrl) && Intrinsics.areEqual(this.templateData, sSRHydrateConfig.templateData);
        }

        public int hashCode() {
            ComparableByteArray comparableByteArray = this.template;
            int hashCode = (comparableByteArray == null ? 0 : comparableByteArray.hashCode()) * 31;
            String str = this.baseUrl;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            TemplateData templateData = this.templateData;
            return hashCode2 + (templateData != null ? templateData.hashCode() : 0);
        }

        public String toString() {
            return "SSRHydrateConfig(template=" + this.template + ", baseUrl=" + this.baseUrl + ", templateData=" + this.templateData + ')';
        }

        public SSRHydrateConfig(ComparableByteArray comparableByteArray, String str, TemplateData templateData) {
            this.template = comparableByteArray;
            this.baseUrl = str;
            this.templateData = templateData;
        }

        public /* synthetic */ SSRHydrateConfig(ComparableByteArray comparableByteArray, String str, TemplateData templateData, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : comparableByteArray, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : templateData);
        }

        public final ComparableByteArray getTemplate() {
            return this.template;
        }

        public final String getBaseUrl() {
            return this.baseUrl;
        }

        public final TemplateData getTemplateData() {
            return this.templateData;
        }
    }

    /* compiled from: AnnieXLynxModel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JQ\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/android/anniex/model/AnnieXLynxModel$CompactConfig;", "", "compactBridge", "", "compactCanvas", "compactMonitor", "disableSignVerify", "enableBridgeDelayInit", "monitorID", "", "trimGlobalProps", "(ZZZZZLjava/lang/String;Z)V", "getCompactBridge", "()Z", "getCompactCanvas", "getCompactMonitor", "getDisableSignVerify", "getEnableBridgeDelayInit", "getMonitorID", "()Ljava/lang/String;", "getTrimGlobalProps", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class CompactConfig {
        private final boolean compactBridge;
        private final boolean compactCanvas;
        private final boolean compactMonitor;
        private final boolean disableSignVerify;
        private final boolean enableBridgeDelayInit;
        private final String monitorID;
        private final boolean trimGlobalProps;

        public CompactConfig() {
            this(false, false, false, false, false, null, false, 127, null);
        }

        public static /* synthetic */ CompactConfig copy$default(CompactConfig compactConfig, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, boolean z6, int i, Object obj) {
            if ((i & 1) != 0) {
                z = compactConfig.compactBridge;
            }
            if ((i & 2) != 0) {
                z2 = compactConfig.compactCanvas;
            }
            boolean z7 = z2;
            if ((i & 4) != 0) {
                z3 = compactConfig.compactMonitor;
            }
            boolean z8 = z3;
            if ((i & 8) != 0) {
                z4 = compactConfig.disableSignVerify;
            }
            boolean z9 = z4;
            if ((i & 16) != 0) {
                z5 = compactConfig.enableBridgeDelayInit;
            }
            boolean z10 = z5;
            if ((i & 32) != 0) {
                str = compactConfig.monitorID;
            }
            String str2 = str;
            if ((i & 64) != 0) {
                z6 = compactConfig.trimGlobalProps;
            }
            return compactConfig.copy(z, z7, z8, z9, z10, str2, z6);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getCompactBridge() {
            return this.compactBridge;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCompactCanvas() {
            return this.compactCanvas;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCompactMonitor() {
            return this.compactMonitor;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getDisableSignVerify() {
            return this.disableSignVerify;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getEnableBridgeDelayInit() {
            return this.enableBridgeDelayInit;
        }

        /* renamed from: component6, reason: from getter */
        public final String getMonitorID() {
            return this.monitorID;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getTrimGlobalProps() {
            return this.trimGlobalProps;
        }

        public final CompactConfig copy(boolean compactBridge, boolean compactCanvas, boolean compactMonitor, boolean disableSignVerify, boolean enableBridgeDelayInit, String monitorID, boolean trimGlobalProps) {
            return new CompactConfig(compactBridge, compactCanvas, compactMonitor, disableSignVerify, enableBridgeDelayInit, monitorID, trimGlobalProps);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CompactConfig)) {
                return false;
            }
            CompactConfig compactConfig = (CompactConfig) other;
            return this.compactBridge == compactConfig.compactBridge && this.compactCanvas == compactConfig.compactCanvas && this.compactMonitor == compactConfig.compactMonitor && this.disableSignVerify == compactConfig.disableSignVerify && this.enableBridgeDelayInit == compactConfig.enableBridgeDelayInit && Intrinsics.areEqual(this.monitorID, compactConfig.monitorID) && this.trimGlobalProps == compactConfig.trimGlobalProps;
        }

        public int hashCode() {
            int hashCode = ((((((((Boolean.hashCode(this.compactBridge) * 31) + Boolean.hashCode(this.compactCanvas)) * 31) + Boolean.hashCode(this.compactMonitor)) * 31) + Boolean.hashCode(this.disableSignVerify)) * 31) + Boolean.hashCode(this.enableBridgeDelayInit)) * 31;
            String str = this.monitorID;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.trimGlobalProps);
        }

        public String toString() {
            return "CompactConfig(compactBridge=" + this.compactBridge + ", compactCanvas=" + this.compactCanvas + ", compactMonitor=" + this.compactMonitor + ", disableSignVerify=" + this.disableSignVerify + ", enableBridgeDelayInit=" + this.enableBridgeDelayInit + ", monitorID=" + this.monitorID + ", trimGlobalProps=" + this.trimGlobalProps + ')';
        }

        public CompactConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, boolean z6) {
            this.compactBridge = z;
            this.compactCanvas = z2;
            this.compactMonitor = z3;
            this.disableSignVerify = z4;
            this.enableBridgeDelayInit = z5;
            this.monitorID = str;
            this.trimGlobalProps = z6;
        }

        public /* synthetic */ CompactConfig(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str, boolean z6, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3, (i & 8) != 0 ? true : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? null : str, (i & 64) != 0 ? true : z6);
        }

        public final boolean getCompactBridge() {
            return this.compactBridge;
        }

        public final boolean getCompactCanvas() {
            return this.compactCanvas;
        }

        public final boolean getCompactMonitor() {
            return this.compactMonitor;
        }

        public final boolean getDisableSignVerify() {
            return this.disableSignVerify;
        }

        public final boolean getEnableBridgeDelayInit() {
            return this.enableBridgeDelayInit;
        }

        public final String getMonitorID() {
            return this.monitorID;
        }

        public final boolean getTrimGlobalProps() {
            return this.trimGlobalProps;
        }
    }
}
