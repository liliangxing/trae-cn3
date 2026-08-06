package com.bytedance.ies.web.jsbridge2;

import android.text.TextUtils;
import net.openid.appauth.RegistrationRequest;

/* loaded from: classes4.dex */
public enum PermissionGroup {
    PUBLIC,
    PROTECTED,
    PRIVATE,
    SECURE;

    public static PermissionGroup from(String str) {
        if (TextUtils.isEmpty(str)) {
            return PUBLIC;
        }
        String lowerCase = str.toLowerCase();
        if (TextUtils.equals("protected", lowerCase)) {
            return PROTECTED;
        }
        if (TextUtils.equals("private", lowerCase)) {
            return PRIVATE;
        }
        if (TextUtils.equals("secure", lowerCase)) {
            return SECURE;
        }
        return PUBLIC;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this == PRIVATE ? "private" : this == PROTECTED ? "protected" : this == SECURE ? "secure" : RegistrationRequest.SUBJECT_TYPE_PUBLIC;
    }
}
