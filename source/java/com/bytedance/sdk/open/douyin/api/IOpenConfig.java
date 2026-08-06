package com.bytedance.sdk.open.douyin.api;

import com.bytedance.sdk.open.aweme.core.OpenEventService;
import com.bytedance.sdk.open.aweme.core.OpenHostInfoService;
import com.bytedance.sdk.open.aweme.core.OpenImageService;
import com.bytedance.sdk.open.aweme.core.OpenNetworkService;

/* loaded from: classes5.dex */
public interface IOpenConfig {
    OpenEventService getEventService();

    OpenHostInfoService getHostInfo();

    OpenImageService getImageService();

    OpenNetworkService getNetWork();
}
