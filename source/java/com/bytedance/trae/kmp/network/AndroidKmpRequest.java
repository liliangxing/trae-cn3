package com.bytedance.trae.kmp.network;

import com.bytedance.android.monitorV2.constant.ReportConst;
import com.bytedance.forest.model.PreloadConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

/* compiled from: AndroidKmpRawHttpClient.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003Ja\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÇ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u001e\u001a\u00020\u001fH×\u0001J\t\u0010 \u001a\u00020\u0003H×\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006!"}, d2 = {"Lcom/bytedance/trae/kmp/network/AndroidKmpRequest;", "", "url", "", "method", "headers", "", "queries", ReportConst.ValidationReport.BODY, CMSAttributeTableGenerator.CONTENT_TYPE, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getMethod", "getHeaders", "()Ljava/util/Map;", "getQueries", "getBody", "getContentType", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class AndroidKmpRequest {
    public static final int $stable = 8;
    private final String body;
    private final String contentType;
    private final Map<String, String> headers;
    private final String method;
    private final Map<String, String> queries;
    private final String url;

    public static /* synthetic */ AndroidKmpRequest copy$default(AndroidKmpRequest androidKmpRequest, String str, String str2, Map map, Map map2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = androidKmpRequest.url;
        }
        if ((i & 2) != 0) {
            str2 = androidKmpRequest.method;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            map = androidKmpRequest.headers;
        }
        Map map3 = map;
        if ((i & 8) != 0) {
            map2 = androidKmpRequest.queries;
        }
        Map map4 = map2;
        if ((i & 16) != 0) {
            str3 = androidKmpRequest.body;
        }
        String str6 = str3;
        if ((i & 32) != 0) {
            str4 = androidKmpRequest.contentType;
        }
        return androidKmpRequest.copy(str, str5, map3, map4, str6, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    public final Map<String, String> component3() {
        return this.headers;
    }

    public final Map<String, String> component4() {
        return this.queries;
    }

    /* renamed from: component5, reason: from getter */
    public final String getBody() {
        return this.body;
    }

    /* renamed from: component6, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    public final AndroidKmpRequest copy(String url, String method, Map<String, String> headers, Map<String, String> queries, String body, String contentType) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(queries, "queries");
        return new AndroidKmpRequest(url, method, headers, queries, body, contentType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AndroidKmpRequest)) {
            return false;
        }
        AndroidKmpRequest androidKmpRequest = (AndroidKmpRequest) other;
        return Intrinsics.areEqual(this.url, androidKmpRequest.url) && Intrinsics.areEqual(this.method, androidKmpRequest.method) && Intrinsics.areEqual(this.headers, androidKmpRequest.headers) && Intrinsics.areEqual(this.queries, androidKmpRequest.queries) && Intrinsics.areEqual(this.body, androidKmpRequest.body) && Intrinsics.areEqual(this.contentType, androidKmpRequest.contentType);
    }

    public int hashCode() {
        int hashCode = ((((((this.url.hashCode() * 31) + this.method.hashCode()) * 31) + this.headers.hashCode()) * 31) + this.queries.hashCode()) * 31;
        String str = this.body;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.contentType;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AndroidKmpRequest(url=" + this.url + ", method=" + this.method + ", headers=" + this.headers + ", queries=" + this.queries + ", body=" + this.body + ", contentType=" + this.contentType + ')';
    }

    public AndroidKmpRequest(String url, String method, Map<String, String> headers, Map<String, String> queries, String str, String str2) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(queries, "queries");
        this.url = url;
        this.method = method;
        this.headers = headers;
        this.queries = queries;
        this.body = str;
        this.contentType = str2;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getMethod() {
        return this.method;
    }

    public final Map<String, String> getHeaders() {
        return this.headers;
    }

    public /* synthetic */ AndroidKmpRequest(String str, String str2, Map map, Map map2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, map, (i & 8) != 0 ? MapsKt.emptyMap() : map2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4);
    }

    public final Map<String, String> getQueries() {
        return this.queries;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getContentType() {
        return this.contentType;
    }
}
