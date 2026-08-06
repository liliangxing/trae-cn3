package com.bytedance.webx;

import com.bytedance.webx.IExtension;

/* loaded from: classes6.dex */
public interface IContainer {
    <T extends IExtension.IContainerExtension> T castContainer(Class<T> cls);
}
