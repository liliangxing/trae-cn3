package com.bytedance.android.monitorV2.webview.blank;

import android.graphics.Bitmap;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import kotlin.Metadata;

/* compiled from: DetectResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010!\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\f\"\u0004\b#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000eR\u001c\u0010'\u001a\u0004\u0018\u00010(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\f\"\u0004\b/\u0010\u000e¨\u00061"}, d2 = {"Lcom/bytedance/android/monitorV2/webview/blank/DetectResult;", "", "()V", "bitmap", "Landroid/graphics/Bitmap;", "getBitmap", "()Landroid/graphics/Bitmap;", "setBitmap", "(Landroid/graphics/Bitmap;)V", "blankState", "", "getBlankState", "()I", "setBlankState", "(I)V", "calculateTime", "", "getCalculateTime", "()J", "setCalculateTime", "(J)V", "collectTime", "getCollectTime", "setCollectTime", "config", "Landroid/graphics/Bitmap$Config;", "getConfig", "()Landroid/graphics/Bitmap$Config;", "setConfig", "(Landroid/graphics/Bitmap$Config;)V", WiseOpenHianalyticsData.UNION_COSTTIME, "getCostTime", "setCostTime", "detectPixel", "getDetectPixel", "setDetectPixel", "errorCode", "getErrorCode", "setErrorCode", "errorMsg", "", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "hitCache", "getHitCache", "setHitCache", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class DetectResult {
    public static final int BLANK_SCREEN = 1;
    public static final int DETECT_FAIL = 3;
    public static final int NORMAL_SCREEN = 2;
    private Bitmap bitmap;
    private long calculateTime;
    private long collectTime;
    private Bitmap.Config config;
    private long costTime;
    private int detectPixel;
    private String errorMsg;
    private int hitCache;
    private int blankState = 3;
    private int errorCode = -1;

    public final int getBlankState() {
        return this.blankState;
    }

    public final void setBlankState(int i) {
        this.blankState = i;
    }

    public final int getDetectPixel() {
        return this.detectPixel;
    }

    public final void setDetectPixel(int i) {
        this.detectPixel = i;
    }

    public final long getCalculateTime() {
        return this.calculateTime;
    }

    public final void setCalculateTime(long j) {
        this.calculateTime = j;
    }

    public final long getCollectTime() {
        return this.collectTime;
    }

    public final void setCollectTime(long j) {
        this.collectTime = j;
    }

    public final long getCostTime() {
        return this.costTime;
    }

    public final void setCostTime(long j) {
        this.costTime = j;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    public final String getErrorMsg() {
        return this.errorMsg;
    }

    public final void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public final int getHitCache() {
        return this.hitCache;
    }

    public final void setHitCache(int i) {
        this.hitCache = i;
    }

    public final Bitmap.Config getConfig() {
        return this.config;
    }

    public final void setConfig(Bitmap.Config config) {
        this.config = config;
    }

    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    public final void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
