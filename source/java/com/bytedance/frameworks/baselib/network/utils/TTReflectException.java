package com.bytedance.frameworks.baselib.network.utils;

/* loaded from: classes2.dex */
public class TTReflectException extends RuntimeException {
    private final String memberType;
    private final String targetClass;
    private final String targetMember;

    public TTReflectException(String str, Throwable th, String... strArr) {
        super(buildMessage(str, strArr), th);
        this.targetClass = strArr.length > 0 ? strArr[0] : "unknown";
        this.targetMember = strArr.length > 1 ? strArr[1] : "unknown";
        this.memberType = strArr.length > 2 ? strArr[2] : "unknown";
    }

    public TTReflectException(String str) {
        this(str, null, new String[0]);
    }

    private static String buildMessage(String str, String... strArr) {
        StringBuilder sb = new StringBuilder(str);
        if (strArr != null && strArr.length > 0) {
            sb.append(" [TargetClass: ").append(strArr[0]);
            if (strArr.length > 1) {
                sb.append(", TargetMember: ").append(strArr[1]);
            }
            if (strArr.length > 2) {
                sb.append(", MemberType: ").append(strArr[2]);
            }
            sb.append("]");
        }
        return sb.toString();
    }

    public String getTargetClass() {
        return this.targetClass;
    }

    public String getTargetMember() {
        return this.targetMember;
    }

    public String getMemberType() {
        return this.memberType;
    }
}
