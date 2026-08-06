package com.bytedance.sdk.xbridge.cn.auth.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'LEGACY_PUBLIC_METHOD' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: AuthResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/AuthSuccessCode;", "", "code", "", "msg", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "UN_SET", "LEGACY_PUBLIC_METHOD", "LEGACY_PRIVATE_DOMAINS", "METHOD_NOT_FOUND", "DISABLE_AUTH", "MATCH_RECOVERY_CONFIG", "REQUEST_CHECK_PASSED", "NO_AUTH_PACKAGE", "LOGIC_ERROR", "REQUEST_CHECK_WARNING", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class AuthSuccessCode {
    public static final AuthSuccessCode LEGACY_PUBLIC_METHOD;
    public static final AuthSuccessCode METHOD_NOT_FOUND;
    private final int code;
    private final String msg;
    public static final AuthSuccessCode UN_SET = new AuthSuccessCode("UN_SET", 0, 0, null, 2, null);
    public static final AuthSuccessCode LEGACY_PRIVATE_DOMAINS = new AuthSuccessCode("LEGACY_PRIVATE_DOMAINS", 2, 2, null, 2, null);
    public static final AuthSuccessCode DISABLE_AUTH = new AuthSuccessCode("DISABLE_AUTH", 4, 9, "XBridge disable auth");
    public static final AuthSuccessCode MATCH_RECOVERY_CONFIG = new AuthSuccessCode("MATCH_RECOVERY_CONFIG", 5, 10, "recovery over auth");
    public static final AuthSuccessCode REQUEST_CHECK_PASSED = new AuthSuccessCode("REQUEST_CHECK_PASSED", 6, 17, "success_request_parameters_check_passed");
    public static final AuthSuccessCode NO_AUTH_PACKAGE = new AuthSuccessCode("NO_AUTH_PACKAGE", 7, 101, "all permission config not found");
    public static final AuthSuccessCode LOGIC_ERROR = new AuthSuccessCode("LOGIC_ERROR", 8, 102, "unexpected error");
    public static final AuthSuccessCode REQUEST_CHECK_WARNING = new AuthSuccessCode("REQUEST_CHECK_WARNING", 9, 103, "success_request_parameters_warn");
    private static final /* synthetic */ AuthSuccessCode[] $VALUES = $values();

    private static final /* synthetic */ AuthSuccessCode[] $values() {
        return new AuthSuccessCode[]{UN_SET, LEGACY_PUBLIC_METHOD, LEGACY_PRIVATE_DOMAINS, METHOD_NOT_FOUND, DISABLE_AUTH, MATCH_RECOVERY_CONFIG, REQUEST_CHECK_PASSED, NO_AUTH_PACKAGE, LOGIC_ERROR, REQUEST_CHECK_WARNING};
    }

    public static AuthSuccessCode valueOf(String str) {
        return (AuthSuccessCode) Enum.valueOf(AuthSuccessCode.class, str);
    }

    public static AuthSuccessCode[] values() {
        return (AuthSuccessCode[]) $VALUES.clone();
    }

    private AuthSuccessCode(String str, int i, int i2, String str2) {
        this.code = i2;
        this.msg = str2;
    }

    /* synthetic */ AuthSuccessCode(String str, int i, int i2, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, (i3 & 2) != 0 ? null : str2);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    static {
        String str = null;
        int i = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        LEGACY_PUBLIC_METHOD = new AuthSuccessCode("LEGACY_PUBLIC_METHOD", 1, 1, str, i, defaultConstructorMarker);
        METHOD_NOT_FOUND = new AuthSuccessCode("METHOD_NOT_FOUND", 3, 3, str, i, defaultConstructorMarker);
    }
}
