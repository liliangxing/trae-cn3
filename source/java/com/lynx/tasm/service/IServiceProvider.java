package com.lynx.tasm.service;

import android.content.Context;

/* loaded from: classes7.dex */
public interface IServiceProvider {
    Class<? extends IServiceProvider> getServiceClass();

    default void onInitialize(Context context) {
    }
}
