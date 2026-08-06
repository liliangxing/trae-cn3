package com.ss.android.download.api.model;

/* loaded from: classes7.dex */
public class DeepLink {
    private long extValue;
    private long id;
    private String mLogExtra;
    private String mOpenUrl;
    private String mWebTitle;
    private String mWebUrl;

    public DeepLink(String str, String str2, String str3) {
        this.mOpenUrl = str;
        this.mWebUrl = str2;
        this.mWebTitle = str3;
    }

    public DeepLink() {
    }

    public String getWebUrl() {
        return this.mWebUrl;
    }

    public void setWebUrl(String str) {
        this.mWebUrl = str;
    }

    public String getOpenUrl() {
        return this.mOpenUrl;
    }

    public void setOpenUrl(String str) {
        this.mOpenUrl = str;
    }

    public String getWebTitle() {
        return this.mWebTitle;
    }

    public void setWebTitle(String str) {
        this.mWebTitle = str;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long j) {
        this.id = j;
    }

    public long getExtValue() {
        return this.extValue;
    }

    public void setExtValue(long j) {
        this.extValue = j;
    }

    public String getLogExtra() {
        return this.mLogExtra;
    }

    public void setLogExtra(String str) {
        this.mLogExtra = str;
    }
}
