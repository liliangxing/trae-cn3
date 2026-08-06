package com.bytedance.pia.core.api.resource;

import com.bytedance.pia.core.api.utils.IConsumer;
import com.bytedance.pia.core.api.utils.IReleasable;

/* loaded from: classes4.dex */
public interface IResourceLoader {
    IResourceResponse load(LoadFrom loadFrom, IResourceRequest iResourceRequest) throws Throwable;

    IReleasable loadAsync(LoadFrom loadFrom, IResourceRequest iResourceRequest, IConsumer<IResourceResponse> iConsumer, IConsumer<Throwable> iConsumer2);
}
