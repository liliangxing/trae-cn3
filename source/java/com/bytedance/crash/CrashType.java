package com.bytedance.crash;

import com.bytedance.crash.anr.AnrManager;
import com.bytedance.reparo.core.parse.PatchFileParser;
import net.openid.appauth.RegistrationRequest;

/* loaded from: classes3.dex */
public enum CrashType {
    LAUNCH("launch"),
    JAVA(PatchFileParser.JAVA_PATCH_ROOT_DIR_NAME),
    NATIVE(RegistrationRequest.APPLICATION_TYPE_NATIVE),
    ASAN("asan"),
    TSAN("tsan"),
    ANR(AnrManager.ANR_ROOT_DIR),
    NATIVE_CUSTOMIZE("ensure_zip"),
    BLOCK("block"),
    ENSURE("ensure"),
    DART("dart"),
    GAME("game"),
    CUSTOM_JAVA("custom_java"),
    OOM("oom"),
    CJAVA("cjava"),
    COREDUMP("coredump"),
    EVENT("event"),
    ALL("all"),
    UNKNOWN("unknown");

    private final String mName;

    CrashType(String str) {
        this.mName = str;
    }

    public String getName() {
        return this.mName;
    }

    public static CrashType getType(String str) {
        try {
            return valueOf(str.toUpperCase());
        } catch (Throwable unused) {
            return UNKNOWN;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }
}
