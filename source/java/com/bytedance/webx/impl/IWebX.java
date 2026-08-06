package com.bytedance.webx.impl;

import com.bytedance.webx.IManager;

/* loaded from: classes6.dex */
public interface IWebX {
    <T extends IManager> T getContainerManager(Class<T> cls);
}
