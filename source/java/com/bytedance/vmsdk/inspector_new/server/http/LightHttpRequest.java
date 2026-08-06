package com.bytedance.vmsdk.inspector_new.server.http;

import android.net.Uri;

/* loaded from: classes6.dex */
public class LightHttpRequest extends LightHttpMessage {
    public String method;
    public String protocol;
    public Uri uri;

    @Override // com.bytedance.vmsdk.inspector_new.server.http.LightHttpMessage
    public void reset() {
        super.reset();
        this.method = null;
        this.uri = null;
        this.protocol = null;
    }
}
