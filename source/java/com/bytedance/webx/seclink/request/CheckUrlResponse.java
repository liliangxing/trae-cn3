package com.bytedance.webx.seclink.request;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public class CheckUrlResponse {
    private String bannerText;
    private long duration;
    private boolean needShowPage;
    private String originUrl;
    private int risk;
    private boolean showBanner;
    private boolean success;

    public CheckUrlResponse() {
    }

    public CheckUrlResponse(String str) {
        this.originUrl = str;
    }

    public boolean success() {
        return this.success;
    }

    public void success(boolean z) {
        this.success = z;
    }

    public int getRisk() {
        return this.risk;
    }

    public void setRisk(int i) {
        this.risk = i;
    }

    public boolean isNeedShowPage() {
        return this.needShowPage;
    }

    public void setNeedShowPage(boolean z) {
        this.needShowPage = z;
    }

    public long getDuration() {
        return this.duration;
    }

    public void setDuration(long j) {
        this.duration = j;
    }

    public boolean isShowBanner() {
        return this.showBanner;
    }

    public void setShowBanner(boolean z) {
        this.showBanner = z;
    }

    public String getBannerText() {
        return this.bannerText;
    }

    public void setBannerText(String str) {
        this.bannerText = str;
    }

    public String getOriginUrl() {
        return this.originUrl;
    }

    public String toString() {
        return "CheckUrlResponse{risk=" + this.risk + ", needShowPage=" + this.needShowPage + ", duration=" + this.duration + AbstractJsonLexerKt.END_OBJ;
    }
}
