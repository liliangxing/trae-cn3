package com.ss.android.agilelogger.printer;

import com.ss.android.agilelogger.LogItem;

/* loaded from: classes7.dex */
public interface Printer {
    void flush();

    void println(LogItem logItem);

    void release();
}
