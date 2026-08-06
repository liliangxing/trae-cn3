package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.frameworks.baselib.network.http.parser.MimeTypeParseException;

/* loaded from: classes2.dex */
public abstract class BaseHttpClient implements IHttpClient {
    public static String getContentBaseType(String str) {
        try {
            return !StringUtils.isEmpty(str) ? new MimeType(str).getBaseType() : "";
        } catch (MimeTypeParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
