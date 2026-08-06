package com.ss.android.agilelogger.formatter.thread;

/* loaded from: classes7.dex */
public class DefaultThreadFormatter implements ThreadFormatter {
    private final String THREAD_PREFIX = "Thread: ";

    @Override // com.ss.android.agilelogger.formatter.Formatter
    public String format(Thread thread) {
        StringBuffer stringBuffer = new StringBuffer("Thread: ");
        stringBuffer.append(thread.getName());
        return stringBuffer.toString();
    }
}
