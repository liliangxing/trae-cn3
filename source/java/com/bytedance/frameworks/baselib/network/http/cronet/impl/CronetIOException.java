package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class CronetIOException extends TTNetExceptionStorage {
    private final int cronetInternalErrorCode;
    private CronetRequestExtraInfo cronetInternalExtraInfo;
    private int statusCode;

    /* JADX WARN: Multi-variable type inference failed */
    public CronetIOException(Exception exc, BaseHttpRequestInfo baseHttpRequestInfo, int i) {
        super(exc.getMessage(), exc.getCause() == null ? exc : exc.getCause());
        super.setInfo(false, true, baseHttpRequestInfo.url != null ? baseHttpRequestInfo.url.toString() : "", baseHttpRequestInfo.traceCode, baseHttpRequestInfo);
        this.cronetInternalErrorCode = i;
        if (exc instanceof HttpResponseException) {
            this.statusCode = ((HttpResponseException) exc).getStatusCode();
        }
        if (baseHttpRequestInfo.metrics.networklib.misc.requestExtraInfo instanceof CronetRequestExtraInfo) {
            this.cronetInternalExtraInfo = (CronetRequestExtraInfo) baseHttpRequestInfo.metrics.networklib.misc.requestExtraInfo;
        }
    }

    public BaseHttpRequestInfo getRequestInfo() {
        return (BaseHttpRequestInfo) ((TTNetExceptionStorage) this).infoObj;
    }

    public String getRequestLog() {
        return getRequestInfo().requestLog;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int getCronetInternalErrorCode() {
        return this.cronetInternalErrorCode;
    }

    public CronetRequestExtraInfo getCronetRequestExtraInfo() {
        return this.cronetInternalExtraInfo;
    }
}
