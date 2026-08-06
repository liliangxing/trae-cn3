package com.bytedance.webx;

import android.content.Context;
import com.bytedance.webx.IExtension;

/* loaded from: classes6.dex */
public interface IManager {
    <T extends IExtension.IManagerExtension> T castManager(Class<T> cls);

    IContainer createContainer(Context context);

    IContainer createContainer(Context context, ContainerConfig containerConfig);

    <T extends IContainer> T createContainer(Context context, Class<T> cls);
}
