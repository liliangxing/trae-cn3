package com.ss.android.agilelogger;

import java.util.Queue;

/* loaded from: classes7.dex */
public interface ILogCacheCallback {
    Queue<LogItem> getCachedLog();

    void notifyCacheLogConsumed();
}
