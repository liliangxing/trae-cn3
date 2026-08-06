package com.bytedance.notification.model;

/* loaded from: classes4.dex */
public enum NotificationStyle {
    NORMAL(1, "NORMAL"),
    SMALL_PICTURE(2, "SMALL_PICTURE");

    public final int styleIndex;
    public final String styleName;

    NotificationStyle(int i, String str) {
        this.styleIndex = i;
        this.styleName = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.styleName;
    }
}
