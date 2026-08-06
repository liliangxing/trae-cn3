package com.bytedance.ies.xbridge.base.runtime.network;

import java.util.LinkedHashMap;
import kotlin.Metadata;

/* compiled from: AbsStringConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\u0005J$\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\fj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007`\rH\u0016J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/network/AbsStringConnection;", "", "()V", "getClientCode", "", "()Ljava/lang/Integer;", "getErrorMsg", "", "getException", "", "getResponseCode", "getResponseHeader", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "getStringResponseBody", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AbsStringConnection {
    public Integer getClientCode() {
        return null;
    }

    public String getErrorMsg() {
        return "";
    }

    public Throwable getException() {
        return null;
    }

    public Integer getResponseCode() {
        return null;
    }

    public String getStringResponseBody() {
        return null;
    }

    public LinkedHashMap<String, String> getResponseHeader() {
        return new LinkedHashMap<>();
    }
}
