package com.bytedance.ug.sdk.share.impl.share.api;

import android.content.Context;

/* loaded from: classes4.dex */
public interface IShareChannelDepend {
    IShare getChannel(Context context);

    IShareHandler getChannelHandler();

    int getChannelIcon();

    String getChannelName();

    String getPackageName();

    boolean needFiltered();
}
