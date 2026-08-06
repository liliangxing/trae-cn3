package com.bytedance.ies.xbridge.base.runtime.network;

import java.io.InputStream;
import java.util.LinkedHashMap;
import kotlin.Metadata;

/* compiled from: AbsStreamConnection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J$\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0010j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t`\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/network/AbsStreamConnection;", "", "()V", "cancel", "", "getClientCode", "", "()Ljava/lang/Integer;", "getErrorMsg", "", "getException", "", "getInputStreamResponseBody", "Ljava/io/InputStream;", "getResponseCode", "getResponseHeader", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public abstract class AbsStreamConnection {
    public void cancel() {
    }

    public Integer getClientCode() {
        return null;
    }

    public String getErrorMsg() {
        return "";
    }

    public Throwable getException() {
        return null;
    }

    public InputStream getInputStreamResponseBody() {
        return null;
    }

    public int getResponseCode() {
        return 0;
    }

    public LinkedHashMap<String, String> getResponseHeader() {
        return new LinkedHashMap<>();
    }
}
