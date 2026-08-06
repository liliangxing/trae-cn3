package com.bytedance.platform.godzilla.common;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public class CrashPortrait {
    public String appVersion;
    public String clazzName;
    public String detailMessage;
    public String methodName;
    public int osVersion;
    public String processName;
    public String threadName;
    public String throwableClassName;
    public int updateVersion;

    public String toString() {
        return "CrashPortrait{processName='" + this.processName + "', clazzName='" + this.clazzName + "', methodName='" + this.methodName + "', threadName='" + this.threadName + "', appVersion='" + this.appVersion + "', updateVersion=" + this.updateVersion + ", detailMessage='" + this.detailMessage + "', throwableClassName='" + this.throwableClassName + "', osVersion=" + this.osVersion + AbstractJsonLexerKt.END_OBJ;
    }
}
