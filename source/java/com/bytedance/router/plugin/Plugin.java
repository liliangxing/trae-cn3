package com.bytedance.router.plugin;

import android.net.Uri;
import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class Plugin {
    private String mName;
    private String mPackageName;
    private String mSchemaRegExp;

    public Plugin(String str, String str2, String str3) {
        this.mName = str;
        this.mPackageName = str2;
        this.mSchemaRegExp = str3;
    }

    public String getName() {
        return this.mName;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public String getSchemaRegExp() {
        return this.mSchemaRegExp;
    }

    public boolean containsUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String schemeSpecificPart = Uri.parse(str).getSchemeSpecificPart();
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return false;
        }
        return Pattern.matches(this.mSchemaRegExp, schemeSpecificPart);
    }
}
