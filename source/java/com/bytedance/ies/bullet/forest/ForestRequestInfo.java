package com.bytedance.ies.bullet.forest;

import android.net.Uri;
import com.bytedance.android.anniex.ability.GlobalPropsHelper;
import com.bytedance.forest.Forest;
import com.bytedance.forest.model.RequestParams;
import com.bytedance.forest.model.Scene;
import com.bytedance.forest.utils.LoaderUtils;
import com.bytedance.ies.bullet.secure.HybridSecureUtil;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ies.bullet.service.base.utils.ExtKt;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ForestRequestInfoBuilder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÂ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÂ\u0003JS\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020#H\u0007J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006'"}, d2 = {"Lcom/bytedance/ies/bullet/forest/ForestRequestInfo;", "", "srcUri", "Landroid/net/Uri;", "srcUrl", "", "cdnUrl", "params", "Lcom/bytedance/forest/model/RequestParams;", "isMainResource", "", "bid", "containerId", "(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/forest/model/RequestParams;ZLjava/lang/String;Ljava/lang/String;)V", "getCdnUrl", "()Ljava/lang/String;", "isCDNRequest", "()Z", "getParams", "()Lcom/bytedance/forest/model/RequestParams;", "getSrcUri", "()Landroid/net/Uri;", "getSrcUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "generateForestUrl", "forest", "Lcom/bytedance/forest/Forest;", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final /* data */ class ForestRequestInfo {
    private final String bid;
    private final String cdnUrl;
    private final String containerId;
    private final boolean isCDNRequest;
    private final boolean isMainResource;
    private final RequestParams params;
    private final Uri srcUri;
    private final String srcUrl;

    /* renamed from: component6, reason: from getter */
    private final String getBid() {
        return this.bid;
    }

    /* renamed from: component7, reason: from getter */
    private final String getContainerId() {
        return this.containerId;
    }

    public static /* synthetic */ ForestRequestInfo copy$default(ForestRequestInfo forestRequestInfo, Uri uri, String str, String str2, RequestParams requestParams, boolean z, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            uri = forestRequestInfo.srcUri;
        }
        if ((i & 2) != 0) {
            str = forestRequestInfo.srcUrl;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = forestRequestInfo.cdnUrl;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            requestParams = forestRequestInfo.params;
        }
        RequestParams requestParams2 = requestParams;
        if ((i & 16) != 0) {
            z = forestRequestInfo.isMainResource;
        }
        boolean z2 = z;
        if ((i & 32) != 0) {
            str3 = forestRequestInfo.bid;
        }
        String str7 = str3;
        if ((i & 64) != 0) {
            str4 = forestRequestInfo.containerId;
        }
        return forestRequestInfo.copy(uri, str5, str6, requestParams2, z2, str7, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final Uri getSrcUri() {
        return this.srcUri;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSrcUrl() {
        return this.srcUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCdnUrl() {
        return this.cdnUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final RequestParams getParams() {
        return this.params;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsMainResource() {
        return this.isMainResource;
    }

    public final ForestRequestInfo copy(Uri srcUri, String srcUrl, String cdnUrl, RequestParams params, boolean isMainResource, String bid, String containerId) {
        Intrinsics.checkNotNullParameter(srcUri, "srcUri");
        Intrinsics.checkNotNullParameter(srcUrl, "srcUrl");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(bid, "bid");
        return new ForestRequestInfo(srcUri, srcUrl, cdnUrl, params, isMainResource, bid, containerId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ForestRequestInfo)) {
            return false;
        }
        ForestRequestInfo forestRequestInfo = (ForestRequestInfo) other;
        return Intrinsics.areEqual(this.srcUri, forestRequestInfo.srcUri) && Intrinsics.areEqual(this.srcUrl, forestRequestInfo.srcUrl) && Intrinsics.areEqual(this.cdnUrl, forestRequestInfo.cdnUrl) && Intrinsics.areEqual(this.params, forestRequestInfo.params) && this.isMainResource == forestRequestInfo.isMainResource && Intrinsics.areEqual(this.bid, forestRequestInfo.bid) && Intrinsics.areEqual(this.containerId, forestRequestInfo.containerId);
    }

    public int hashCode() {
        int hashCode = ((this.srcUri.hashCode() * 31) + this.srcUrl.hashCode()) * 31;
        String str = this.cdnUrl;
        int hashCode2 = (((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.params.hashCode()) * 31) + Boolean.hashCode(this.isMainResource)) * 31) + this.bid.hashCode()) * 31;
        String str2 = this.containerId;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "ForestRequestInfo(srcUri=" + this.srcUri + ", srcUrl=" + this.srcUrl + ", cdnUrl=" + this.cdnUrl + ", params=" + this.params + ", isMainResource=" + this.isMainResource + ", bid=" + this.bid + ", containerId=" + this.containerId + ')';
    }

    public ForestRequestInfo(Uri uri, String str, String str2, RequestParams requestParams, boolean z, String str3, String str4) {
        Intrinsics.checkNotNullParameter(uri, "srcUri");
        Intrinsics.checkNotNullParameter(str, "srcUrl");
        Intrinsics.checkNotNullParameter(requestParams, "params");
        Intrinsics.checkNotNullParameter(str3, "bid");
        this.srcUri = uri;
        this.srcUrl = str;
        this.cdnUrl = str2;
        this.params = requestParams;
        this.isMainResource = z;
        this.bid = str3;
        this.containerId = str4;
        this.isCDNRequest = LoaderUtils.INSTANCE.isNotNullOrEmpty(str2);
    }

    public final Uri getSrcUri() {
        return this.srcUri;
    }

    public final String getSrcUrl() {
        return this.srcUrl;
    }

    public final String getCdnUrl() {
        return this.cdnUrl;
    }

    public final RequestParams getParams() {
        return this.params;
    }

    public final boolean isMainResource() {
        return this.isMainResource;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x012c, code lost:
    
        if ((r1 == null || r1.length() == 0) != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x004a, code lost:
    
        if (r13 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String generateForestUrl(Forest forest) {
        String str;
        Object obj;
        String addEnvParamsForCDNMultiVersion;
        String str2;
        Intrinsics.checkNotNullParameter(forest, "forest");
        List list = null;
        if (this.isMainResource && (str2 = this.cdnUrl) != null && forest.isPreloaded(str2, this.params)) {
            str = this.cdnUrl;
        } else if (this.params.getResourceScene() == Scene.WEB_MAIN_DOCUMENT && (StringsKt.startsWith$default(this.srcUrl, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(this.srcUrl, "https://", false, 2, (Object) null))) {
            str = this.srcUrl;
        } else {
            str = this.cdnUrl;
            if (str != null) {
                if (!LoaderUtils.INSTANCE.isNotNullOrEmpty(str)) {
                    str = null;
                }
            }
            str = this.srcUrl;
        }
        boolean z = true;
        String str3 = StringsKt.startsWith$default(str, "http://", false, 2, (Object) null) || StringsKt.startsWith$default(str, "https://", false, 2, (Object) null) ? str : null;
        if (str3 != null && (addEnvParamsForCDNMultiVersion = ForestRequestInfoBuilderKt.addEnvParamsForCDNMultiVersion(str3)) != null) {
            str = addEnvParamsForCDNMultiVersion;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Uri.parse(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Uri uri = (Uri) obj;
        if (uri == null) {
            return str;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        if (ExtKt.safeGetQueryParameter(uri, SchemaConstants.APPENDED_GLOBAL_PROPS) == null) {
            String safeGetQueryParameter = ExtKt.safeGetQueryParameter(this.srcUri, SchemaConstants.APPEND_GLOBAL_PROPS);
            if (safeGetQueryParameter != null) {
                if (!(safeGetQueryParameter.length() > 0)) {
                    safeGetQueryParameter = null;
                }
                if (safeGetQueryParameter != null) {
                    list = StringsKt.split$default(safeGetQueryParameter, new String[]{","}, false, 0, 6, (Object) null);
                }
            }
            List list2 = list;
            if (!(list2 == null || list2.isEmpty()) && HybridSecureUtil.INSTANCE.inCommonParamsAllowList(uri)) {
                GlobalPropsHelper globalPropsHelper = GlobalPropsHelper.INSTANCE;
                String str4 = this.bid;
                String str5 = this.containerId;
                if (str5 == null) {
                    str5 = "";
                }
                buildUpon.appendQueryParameter(SchemaConstants.APPENDED_GLOBAL_PROPS, new JSONObject(globalPropsHelper.getStaticGlobalPropsForAppend(uri, str4, str5, list)).toString());
            }
        }
        if (!Intrinsics.areEqual(ExtKt.safeGetQueryParameter(uri, SchemaConstants.QUERY_KEY_APPEND_COMMON_PARAMS), ViewVisibleBridge.INVISIBLE) && Intrinsics.areEqual(ExtKt.safeGetQueryParameter(this.srcUri, SchemaConstants.QUERY_KEY_APPEND_COMMON_PARAMS), "1")) {
            String safeGetQueryParameter2 = ExtKt.safeGetQueryParameter(uri, "_rticket");
        }
        z = false;
        String uri2 = buildUpon.build().toString();
        if (z) {
            StringBuilder sb = new StringBuilder(buildUpon.build().toString());
            HybridSecureUtil.INSTANCE.appendCommonParams(uri, sb, false);
            uri2 = sb.toString();
        }
        Intrinsics.checkNotNullExpressionValue(uri2, "builder.build().toString…t\n            }\n        }");
        return uri2;
    }

    /* renamed from: isCDNRequest, reason: from getter */
    public final boolean getIsCDNRequest() {
        return this.isCDNRequest;
    }
}
