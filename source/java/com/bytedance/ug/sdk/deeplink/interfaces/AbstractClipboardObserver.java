package com.bytedance.ug.sdk.deeplink.interfaces;

import android.content.ClipData;
import com.bytedance.ug.sdk.deeplink.utils.Logger;

/* loaded from: classes4.dex */
public abstract class AbstractClipboardObserver implements Comparable<AbstractClipboardObserver> {
    private int mPriority;
    private String mTag;

    public abstract boolean notifyClipboardContent(ClipData clipData);

    public AbstractClipboardObserver(String str, int i) {
        this.mTag = str;
        this.mPriority = i;
    }

    public void setTag(String str) {
        this.mTag = str;
    }

    public String getTag() {
        return this.mTag;
    }

    public String getClassName() {
        return getClass().getName();
    }

    public void setPriority(int i) {
        this.mPriority = i;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public final boolean process(ClipData clipData) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean notifyClipboardContent = notifyClipboardContent(clipData);
        Logger.d(this.mTag, "ClipboardObserver : " + this.mTag + " has consumed the clipData for " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        return notifyClipboardContent;
    }

    @Override // java.lang.Comparable
    public int compareTo(AbstractClipboardObserver abstractClipboardObserver) {
        int i = this.mPriority;
        int i2 = abstractClipboardObserver.mPriority;
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }
}
