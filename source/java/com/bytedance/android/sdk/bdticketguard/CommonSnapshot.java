package com.bytedance.android.sdk.bdticketguard;

import android.util.Pair;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Snapshot.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0016\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0016\u0010\u0011\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0016\u0010\u0015\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/CommonSnapshot;", "Lcom/bytedance/android/sdk/bdticketguard/LocalSnapshot;", "responseContent", "Lcom/bytedance/android/sdk/bdticketguard/ResponseContent;", "(Lcom/bytedance/android/sdk/bdticketguard/ResponseContent;)V", "host", "", "getHost", "()Ljava/lang/String;", "logid", "getLogid", "path", "getPath", "request_client_cert", "getRequest_client_cert", "request_csr", "getRequest_csr", "request_iteration_version", "getRequest_iteration_version", "request_ree_public_key", "getRequest_ree_public_key", "request_version", "getRequest_version", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CommonSnapshot extends LocalSnapshot {

    @SerializedName("host")
    private final String host;

    @SerializedName("logid")
    private final String logid;

    @SerializedName("path")
    private final String path;

    @SerializedName("request_client_cert")
    private final String request_client_cert;

    @SerializedName("request_csr")
    private final String request_csr;

    @SerializedName("request_iteration_version")
    private final String request_iteration_version;

    @SerializedName("request_ree_public_key")
    private final String request_ree_public_key;

    @SerializedName("request_version")
    private final String request_version;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.bytedance.android.sdk.bdticketguard.ResponseParam] */
    public CommonSnapshot(ResponseContent<?> responseContent) {
        String mask;
        String mask2;
        String mask3;
        List<Pair<String, String>> headers;
        String path;
        String host;
        Intrinsics.checkParameterIsNotNull(responseContent, "responseContent");
        ?? responseParam = responseContent.getResponseParam();
        RequestContent requestContent = responseParam != 0 ? responseParam.getRequestContent() : null;
        RequestParam requestParam = requestContent != null ? requestContent.getRequestParam() : null;
        this.logid = responseContent.getLogid();
        this.host = (requestParam == null || (host = requestParam.getHost()) == null) ? "" : host;
        this.path = (requestParam == null || (path = requestParam.getPath()) == null) ? "" : path;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (requestContent != null && (headers = requestContent.getHeaders()) != null) {
            Iterator<T> it = headers.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                Object obj = pair.first;
                Intrinsics.checkExpressionValueIsNotNull(obj, "it.first");
                Object obj2 = pair.second;
                Intrinsics.checkExpressionValueIsNotNull(obj2, "it.second");
                linkedHashMap.put(obj, obj2);
            }
        }
        String str = (String) linkedHashMap.get(TicketGuardApiKt.HEADER_CLIENT_CSR);
        this.request_csr = (str == null || (mask3 = SnapshotKt.mask(str)) == null) ? "" : mask3;
        String str2 = (String) linkedHashMap.get(TicketGuardApiKt.HEADER_CLIENT_CERT);
        this.request_client_cert = (str2 == null || (mask2 = SnapshotKt.mask(str2)) == null) ? "" : mask2;
        String str3 = (String) linkedHashMap.get(TicketGuardApiKt.HEADER_REE_PUBLIC_KEY);
        this.request_ree_public_key = (str3 == null || (mask = SnapshotKt.mask(str3)) == null) ? "" : mask;
        String str4 = (String) linkedHashMap.get(TicketGuardApiKt.HEADER_ITERATION_VERSION);
        this.request_iteration_version = str4 == null ? "" : str4;
        String str5 = (String) linkedHashMap.get(TicketGuardApiKt.HEADER_VERSION);
        this.request_version = str5 != null ? str5 : "";
    }

    public final String getHost() {
        return this.host;
    }

    public final String getPath() {
        return this.path;
    }

    public final String getLogid() {
        return this.logid;
    }

    public final String getRequest_csr() {
        return this.request_csr;
    }

    public final String getRequest_client_cert() {
        return this.request_client_cert;
    }

    public final String getRequest_ree_public_key() {
        return this.request_ree_public_key;
    }

    public final String getRequest_iteration_version() {
        return this.request_iteration_version;
    }

    public final String getRequest_version() {
        return this.request_version;
    }
}
