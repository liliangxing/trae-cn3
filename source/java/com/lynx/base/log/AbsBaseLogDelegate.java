package com.lynx.base.log;

import android.util.Log;

/* loaded from: classes6.dex */
public abstract class AbsBaseLogDelegate {
    public int mMinimumLoggingLevel = 4;

    public void setMinimumLoggingLevel(int i) {
        this.mMinimumLoggingLevel = i;
    }

    public int getMinimumLoggingLevel() {
        return this.mMinimumLoggingLevel;
    }

    public boolean isLoggable(int i) {
        return this.mMinimumLoggingLevel <= i;
    }

    public void v(String str, String str2) {
        println(2, str, str2);
    }

    public void d(String str, String str2) {
        println(3, str, str2);
    }

    public void i(String str, String str2) {
        println(4, str, str2);
    }

    public void w(String str, String str2) {
        println(5, str, str2);
    }

    public void e(String str, String str2) {
        println(6, str, str2);
    }

    public void log(int i, String str, String str2) {
        println(i, str, str2);
    }

    private void println(int i, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        Log.println(i, str, str2);
    }
}
