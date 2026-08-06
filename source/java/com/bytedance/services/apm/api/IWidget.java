package com.bytedance.services.apm.api;

import android.content.Context;

/* loaded from: classes5.dex */
public interface IWidget {
    void destroy();

    String getTag();

    void init(Context context);

    boolean isOnlyMainProcess();

    void notifyParams(WidgetParams widgetParams);

    void start();

    void stop();
}
