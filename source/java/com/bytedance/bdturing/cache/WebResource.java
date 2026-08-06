package com.bytedance.bdturing.cache;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class WebResource {
    public String md5;
    public String name;
    public String url;

    public boolean isAvailable() {
        return (TextUtils.isEmpty(this.name) || TextUtils.isEmpty(this.url) || TextUtils.isEmpty(this.md5)) ? false : true;
    }
}
