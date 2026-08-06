package com.apm.lite;

import com.bytedance.crash.anr.AnrManager;
import com.bytedance.reparo.core.parse.PatchFileParser;
import net.openid.appauth.RegistrationRequest;

/* loaded from: classes2.dex */
public enum CrashType {
    LAUNCH("launch"),
    JAVA(PatchFileParser.JAVA_PATCH_ROOT_DIR_NAME),
    NATIVE(RegistrationRequest.APPLICATION_TYPE_NATIVE),
    ANR(AnrManager.ANR_ROOT_DIR),
    ENSURE("ensure"),
    DART("dart"),
    OOM("oom"),
    ALL("all");

    private String mName;

    CrashType(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }
}
