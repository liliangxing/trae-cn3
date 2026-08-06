package com.bytedance.vmsdk.worker;

import com.bytedance.vmsdk.net.INetCallback;
import com.bytedance.vmsdk.net.IReleasable;
import com.bytedance.vmsdk.net.Request;
import com.bytedance.vmsdk.net.Response;

/* loaded from: classes6.dex */
public interface IWorkerDelegate {
    String fetchWithUrlSync(String str);

    IReleasable loadAsync(Request request, INetCallback<Response> iNetCallback, INetCallback<Throwable> iNetCallback2);
}
