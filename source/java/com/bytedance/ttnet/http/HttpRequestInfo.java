package com.bytedance.ttnet.http;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;

/* loaded from: classes4.dex */
public class HttpRequestInfo extends BaseHttpRequestInfo<RequestContext> {
    public boolean reqTicketUnmatch = false;
    public int cdnVerifyValue = -1;

    public static void injectCreate() {
        BaseHttpRequestInfo.setCreate(new BaseHttpRequestInfo.ICreate() { // from class: com.bytedance.ttnet.http.HttpRequestInfo.1
            @Override // com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo.ICreate
            public BaseHttpRequestInfo create() {
                return new HttpRequestInfo();
            }
        });
    }
}
