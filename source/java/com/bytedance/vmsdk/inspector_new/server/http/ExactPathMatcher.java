package com.bytedance.vmsdk.inspector_new.server.http;

/* loaded from: classes6.dex */
public class ExactPathMatcher implements PathMatcher {
    private final String mPath;

    public ExactPathMatcher(String str) {
        this.mPath = str;
    }

    @Override // com.bytedance.vmsdk.inspector_new.server.http.PathMatcher
    public boolean match(String str) {
        return this.mPath.equals(str);
    }
}
