package com.lynx.tasm.service.security;

/* loaded from: classes7.dex */
public class SecurityResult {
    private String errorMsg;
    private boolean verified = false;

    private SecurityResult() {
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public boolean isVerified() {
        return this.verified;
    }

    public static SecurityResult onSuccess() {
        SecurityResult securityResult = new SecurityResult();
        securityResult.verified = true;
        return securityResult;
    }

    public static SecurityResult onReject(String str) {
        SecurityResult securityResult = new SecurityResult();
        securityResult.verified = false;
        securityResult.errorMsg = str;
        return securityResult;
    }
}
