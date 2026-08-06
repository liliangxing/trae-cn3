package com.bytedance.crash.upload;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class UploadLimitConfig {
    private int crashLimitAll;
    private int crashLimitIssue;
    private int exceptionAllLimit;
    private int exceptionMsgLimit;
    private int exceptionStackLimit;
    private boolean isNoLimit;

    public UploadLimitConfig(int i, int i2, int i3, int i4, int i5) {
        this.crashLimitIssue = 50;
        this.crashLimitAll = 100;
        this.exceptionAllLimit = 100;
        this.exceptionMsgLimit = 5;
        this.exceptionStackLimit = 2;
        if (i > 0) {
            this.crashLimitIssue = i;
        }
        if (i2 > 0) {
            this.crashLimitAll = i2;
        }
        if (i3 > 0) {
            this.exceptionAllLimit = i3;
        }
        if (i4 > 0) {
            this.exceptionMsgLimit = i4;
        }
        if (i5 > 0) {
            this.exceptionStackLimit = i5;
        }
    }

    public UploadLimitConfig(boolean z) {
        this.crashLimitIssue = 50;
        this.crashLimitAll = 100;
        this.exceptionAllLimit = 100;
        this.exceptionMsgLimit = 5;
        this.exceptionStackLimit = 2;
        this.isNoLimit = z;
    }

    public boolean isNoLimit() {
        return this.isNoLimit;
    }

    public int getCrashLimitIssue() {
        return this.crashLimitIssue;
    }

    public int getCrashLimitAll() {
        return this.crashLimitAll;
    }

    public int getExceptionAllLimit() {
        return this.exceptionAllLimit;
    }

    public int getExceptionMsgLimit() {
        return this.exceptionMsgLimit;
    }

    public int getExceptionStackLimit() {
        return this.exceptionStackLimit;
    }

    public String toString() {
        return "UploadLimitConfig{crashLimitIssue=" + this.crashLimitIssue + ", crashLimitAll=" + this.crashLimitAll + ", exceptionAllLimit=" + this.exceptionAllLimit + ", exceptionMsgLimit=" + this.exceptionMsgLimit + ", exceptionStackLimit=" + this.exceptionStackLimit + ", isNoLimit=" + this.isNoLimit + AbstractJsonLexerKt.END_OBJ;
    }
}
