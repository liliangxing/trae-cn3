package com.bytedance.reparo.core.exception;

/* loaded from: classes4.dex */
public class PatchException extends RuntimeException {
    public static final int ERR_INSTALL_PARSE_IO = 400;
    public static final int ERR_INSTALL_PARSE_JAVA_FILE = 402;
    public static final int ERR_INSTALL_PARSE_SO = 403;
    public static final int ERR_INSTALL_PARSE_SO_INFO = 401;
    public static final int ERR_LOAD_JAVA_CRASH_PROTECT = 101;
    public static final int ERR_LOAD_JAVA_EMPTY_DEOPT_FILE = 108;
    public static final int ERR_LOAD_JAVA_EMPTY_DEX_FILE = 109;
    public static final int ERR_LOAD_JAVA_EMPTY_DIR = 106;
    public static final int ERR_LOAD_JAVA_EMPTY_PATCH_FILE = 107;
    public static final int ERR_LOAD_JAVA_EXCEPTION_CATCH = 103;
    public static final int ERR_LOAD_JAVA_INIT_PROTECT = 102;
    public static final int ERR_LOAD_JAVA_PARSE_IO = 111;
    public static final int ERR_LOAD_JAVA_RETRY_FAILED = 105;
    public static final int ERR_LOAD_JAVA_UNKNOWN_PARSE = 110;
    public static final int ERR_LOAD_SO_HOOK_ERR1 = 302;
    public static final int ERR_LOAD_SO_HOOK_ERR2 = 303;
    public static final int ERR_LOAD_SO_HOOK_ERR3 = 304;
    public static final int ERR_LOAD_SO_HOOK_ERR4 = 305;
    public static final int ERR_LOAD_SO_IS_RUNNING = 301;
    public static final int ERR_LOAD_SO_LOAD_ERR = 306;
    public static final int ERR_LOAD_SO_MD5_NOT_MATCH = 300;
    public static final int ERR_SO_MD5_VERIFY_FAILED = 299;
    public static final int ERR_UNKNOWN = 0;
    private static final int RANGE_INSTALL_START = 400;
    private static final int RANGE_LOAD_JAVA_START = 100;
    private static final int RANGE_LOAD_SO_START = 300;
    private static final int RANGE_SO_MD5_VERIFY_FAILED = 299;
    public static final int SUCCESS = 1;
    private int errorCode;

    public PatchException(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public PatchException(String str, Throwable th, int i) {
        super(str, th);
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
