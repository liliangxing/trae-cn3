package com.vivo.push.model;

/* loaded from: classes7.dex */
public class InsideNotificationItem extends UPSNotificationMessage {
    private int mAppType;
    private int mDisplayStyle;
    private int mInnerPriority;
    private boolean mIsShowBigPicOnMobileNet;
    private int mMessageBizType;
    private int mMessageType;
    private boolean mNoShowOnForeground = false;
    private int mNotifyDisplayStatus;
    private String mReactPackage;
    private String mSuitReactVersion;
    private String mWindowPeriod;

    public int getAppType() {
        return this.mAppType;
    }

    public void setAppType(int i) {
        this.mAppType = i;
    }

    public String getReactPackage() {
        return this.mReactPackage;
    }

    public void setReactPackage(String str) {
        this.mReactPackage = str;
    }

    public boolean isShowBigPicOnMobileNet() {
        return this.mIsShowBigPicOnMobileNet;
    }

    public void setIsShowBigPicOnMobileNet(boolean z) {
        this.mIsShowBigPicOnMobileNet = z;
    }

    public String getSuitReactVersion() {
        return this.mSuitReactVersion;
    }

    public void setSuitReactVersion(String str) {
        this.mSuitReactVersion = str;
    }

    public int getMessageType() {
        return this.mMessageType;
    }

    public void setMessageType(int i) {
        this.mMessageType = i;
    }

    public void setInnerPriority(int i) {
        this.mInnerPriority = i;
    }

    public int getInnerPriority() {
        return this.mInnerPriority;
    }

    public int getDisplayStyle() {
        return this.mDisplayStyle;
    }

    public void setDisplayStyle(int i) {
        this.mDisplayStyle = i;
        this.mNotifyDisplayStatus = parsingNotifyStyle();
    }

    public int getNotifyDisplayStatus() {
        return this.mNotifyDisplayStatus;
    }

    private int parsingNotifyStyle() {
        int i = this.mDisplayStyle;
        return ((i & 32) == 0 && (i & 16) != 0) ? 1 : 0;
    }

    public void noShowOnForeground() {
        this.mNoShowOnForeground = true;
    }

    public boolean isNoShowOnForeground() {
        return this.mNoShowOnForeground;
    }

    public int getMessageBizType() {
        return this.mMessageBizType;
    }

    public boolean isOperateMsg() {
        return this.mMessageBizType == 0;
    }

    public void setMessageBizType(int i) {
        this.mMessageBizType = i;
    }

    public String getWindowPeriod() {
        return this.mWindowPeriod;
    }

    public void setWindowPeriod(String str) {
        this.mWindowPeriod = str;
    }
}
