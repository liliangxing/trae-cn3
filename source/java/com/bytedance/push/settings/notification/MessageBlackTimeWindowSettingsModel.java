package com.bytedance.push.settings.notification;

/* loaded from: classes4.dex */
public class MessageBlackTimeWindowSettingsModel {
    public int beginHour = -1;
    public int beginMinute = -1;
    public int endDay = -1;
    public int endHour = -1;
    public int endMinute = -1;
    public boolean needIntercept;

    public boolean checkSettingsFormat() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5 = this.endDay;
        return (i5 == 0 || i5 == 1) && (i = this.beginHour) >= 0 && i <= 23 && (i2 = this.beginMinute) >= 0 && i2 <= 59 && (i3 = this.endHour) >= 0 && i3 <= 23 && (i4 = this.endMinute) >= 0 && i4 <= 60;
    }
}
