package com.bytedance.webx.extension.webview.precreate;

import com.bytedance.webx.IExtension;
import com.bytedance.webx.core.webview.WebViewContainer;

/* loaded from: classes6.dex */
public interface IPreCreateExtension extends IExtension.IManagerExtension {
    void initPreCreate(int i, boolean z);

    void initPreCreate(int i, boolean z, Class<? extends WebViewContainer> cls);
}
