package com.bytedance.pia.core.api.plugin;

import android.net.Uri;
import android.view.View;
import com.bytedance.pia.core.api.bridge.IWorkerBridgeHandle;
import com.bytedance.pia.core.api.resource.IResourceRequest;
import com.bytedance.pia.core.api.resource.IResourceResponse;

/* loaded from: classes4.dex */
public interface IPiaLifeCycle {
    Object getCustomContext();

    void loadUrl(String str);

    IResourceResponse onAfterLoadResource(IResourceRequest iResourceRequest, IResourceResponse iResourceResponse);

    IResourceResponse onBeforeLoadResource(IResourceRequest iResourceRequest);

    @Deprecated
    void onBindBridge(IWorkerBridgeHandle iWorkerBridgeHandle);

    void onBindView(View view);

    void onDestroy();

    void onLoadError(int i, String str);

    void onLoadFinish(String str);

    void onLoadStart(String str);

    void onRedirect(String str);

    boolean shouldHandleResource(Uri uri);
}
