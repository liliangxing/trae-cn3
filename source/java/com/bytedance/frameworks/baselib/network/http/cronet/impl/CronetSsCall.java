package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.utils.ReflectWrap;
import com.bytedance.retrofit2.client.Request;
import java.io.IOException;
import java.net.HttpURLConnection;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
class CronetSsCall extends BaseCronetSsCall {
    private HttpURLConnection httpConnection;

    public CronetSsCall(Request request) {
        super(request);
        this.httpConnection = null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall
    HttpURLConnection connection() {
        return this.httpConnection;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall
    void setConnection(HttpURLConnection httpURLConnection) {
        this.httpConnection = httpURLConnection;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected IOException convertException(Exception exc) {
        int cronetInternalErrorCode = "com.ttnet.org.chromium.net.urlconnection.TTRequestCanceledException".equals(exc.getClass().getName()) ? SsCronetHttpClient.getCronetInternalErrorCode(this.httpConnection) : 0;
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(exc.getClass().getName()) || "com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(exc.getClass().getName())) {
            cronetInternalErrorCode = SsCronetHttpClient.getCronetInternalErrorCode(this.httpConnection);
        }
        return new CronetIOException(exc, this.requestInfo, cronetInternalErrorCode);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    protected int getStatusCodeFromException(IOException iOException) {
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(iOException.getClass().getName()) || "com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(iOException.getClass().getName())) {
            return SsCronetHttpClient.getCronetInternalErrorCode(this.httpConnection);
        }
        return -1;
    }

    public void cancel() {
        cancelInner(this.httpConnection);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall
    public boolean setThrottleNetSpeed(long j) {
        super.setThrottleNetSpeed(j);
        if (this.httpConnection != null) {
            try {
                if (NetworkParams.getOptReflection()) {
                    ReflectWrap.m1296on(this.httpConnection).call("configureConnection", new Class[]{String.class, Object[].class}, "setThrottleNetSpeed", new Object[]{Long.valueOf(j)});
                } else {
                    ReflectWrap.m1296on(this.httpConnection).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, Long.valueOf(j));
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
