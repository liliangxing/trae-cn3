package com.ss.android.pushmanager;

import android.content.Context;

/* loaded from: classes7.dex */
public interface IMessageContext {
    int getAid();

    String getAppName();

    Context getContext();

    String getTweakedChannel();

    int getUpdateVersionCode();

    String getVersion();

    int getVersionCode();
}
