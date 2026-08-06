package com.ss.android.common.util;

import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.http.legacy.message.BasicNameValuePair;
import com.ss.android.http.legacy.utils.URLEncodedUtils;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes7.dex */
public class UrlBuilder {
    private final List<BasicNameValuePair> mList;
    private String mUrl;

    public UrlBuilder(String str) {
        this.mList = new ArrayList();
        this.mUrl = str;
    }

    public UrlBuilder() {
        this.mList = new ArrayList();
        this.mUrl = null;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void addParam(String str, int i) {
        this.mList.add(new BasicNameValuePair(str, String.valueOf(i)));
    }

    public void addParam(String str, long j) {
        this.mList.add(new BasicNameValuePair(str, String.valueOf(j)));
    }

    public void addParam(String str, double d) {
        this.mList.add(new BasicNameValuePair(str, String.valueOf(d)));
    }

    public void addParam(String str, String str2) {
        this.mList.add(new BasicNameValuePair(str, str2));
    }

    public List<BasicNameValuePair> getParamList() {
        return this.mList;
    }

    public String build() {
        if (this.mList.isEmpty()) {
            return this.mUrl;
        }
        String format = URLEncodedUtils.format(this.mList, "UTF-8");
        String str = this.mUrl;
        if (str == null || str.length() == 0) {
            return format;
        }
        if (this.mUrl.indexOf(63) >= 0) {
            return this.mUrl + ContainerUtils.FIELD_DELIMITER + format;
        }
        return this.mUrl + "?" + format;
    }

    public String toString() {
        return build();
    }
}
