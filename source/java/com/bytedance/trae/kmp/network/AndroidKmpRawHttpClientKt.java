package com.bytedance.trae.kmp.network;

import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import kotlin.Metadata;

/* compiled from: AndroidKmpRawHttpClient.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"httpStatusCodeOrNull", "", "", "(Ljava/lang/Throwable;)Ljava/lang/Integer;", "base_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class AndroidKmpRawHttpClientKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer httpStatusCodeOrNull(Throwable th) {
        int statusCode;
        while (th != null) {
            if (th instanceof CronetIOException) {
                statusCode = ((CronetIOException) th).getStatusCode();
            } else {
                statusCode = th instanceof HttpResponseException ? ((HttpResponseException) th).getStatusCode() : -1;
            }
            if (statusCode > 0) {
                return Integer.valueOf(statusCode);
            }
            Throwable cause = th.getCause();
            if (cause == th) {
                return null;
            }
            th = cause;
        }
        return null;
    }
}
