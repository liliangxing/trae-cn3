package com.ss.android.agilelogger;

import com.ss.android.agilelogger.utils.FormatUtils;

/* loaded from: classes7.dex */
public class LogItem {
    public String className;
    public String lineNum;
    public FormatUtils.TYPE mFormatType;
    public int mLevel;
    public boolean mMainThread;
    public String mMsg;
    public Object mObj;
    public Object mObj2;
    public String mStackTraceInfo;
    public String mTag;
    public long mThreadId;
    public String mThreadInfo;
    public String methodName;
    public int oprationType = -1;

    @Deprecated
    public void recycle() {
    }

    public static LogItem obtain() {
        return new LogItem();
    }

    public static LogItem obtain(int i, String str, String str2, long j, boolean z) {
        LogItem obtain = obtain();
        obtain.mLevel = i;
        obtain.mTag = str;
        obtain.mMsg = str2;
        obtain.mThreadId = j;
        obtain.mMainThread = z;
        return obtain;
    }

    public static LogItem obtain(int i, String str, String str2, String str3, String str4) {
        LogItem obtain = obtain();
        obtain.mLevel = i;
        obtain.mTag = str;
        obtain.mMsg = str2;
        obtain.mThreadInfo = str3;
        obtain.mStackTraceInfo = str4;
        return obtain;
    }
}
