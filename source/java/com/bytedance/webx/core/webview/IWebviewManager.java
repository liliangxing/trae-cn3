package com.bytedance.webx.core.webview;

import android.content.Context;
import com.bytedance.webx.ContainerConfig;
import com.bytedance.webx.IContainer;
import com.bytedance.webx.IManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public interface IWebviewManager extends IManager {
    @Override // com.bytedance.webx.IManager
    <T extends IContainer> T createContainer(Context context, Class<T> cls);

    @Override // com.bytedance.webx.IManager
    WebViewContainer createContainer(Context context);

    @Override // com.bytedance.webx.IManager
    WebViewContainer createContainer(Context context, ContainerConfig containerConfig);
}
