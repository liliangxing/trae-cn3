package com.bytedance.sdk.open.aweme.core;

import com.bytedance.sdk.open.aweme.core.net.IOpenHostNetCall;
import com.bytedance.sdk.open.aweme.core.net.OpenHostRequest;

/* loaded from: classes5.dex */
public interface OpenNetworkService extends IOpenService {
    IOpenHostNetCall newCall(OpenHostRequest openHostRequest);
}
