package com.bytedance.ies.xbridge.base.runtime.depend;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.sdk.xbridge.cn.calendar.reducer.ReducerConstants;
import com.heytap.mcssdk.constant.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IHostCalendarDependV2.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b,\b\u0086\b\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0015J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u0010\u0010.\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0017J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00106\u001a\u00020\u000eHÆ\u0003J²\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\u000e2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\tHÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u001aR\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b\"\u0010\u0017R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001cR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0018\u001a\u0004\b$\u0010\u0017R\u0019\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001c¨\u0006="}, d2 = {"Lcom/bytedance/ies/xbridge/base/runtime/depend/CalendarEventRecord;", "", "title", "", "description", "startTime", "", "endTime", "alarmMinutes", "", b.k, "appUrl", "location", ReducerConstants.EVENT_ALL_DAY, "", "isRepeat", "scheduledWeekDays", "", "repeatFrequency", "repeatInterval", "repeatCount", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAlarmMinutes", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAllDay", "()Z", "getAppUrl", "()Ljava/lang/String;", "getDescription", "getEndTime", "()J", "getEventId", "getLocation", "getRepeatCount", "getRepeatFrequency", "getRepeatInterval", "getScheduledWeekDays", "()Ljava/util/List;", "getStartTime", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/ies/xbridge/base/runtime/depend/CalendarEventRecord;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CalendarEventRecord {
    private final Integer alarmMinutes;
    private final boolean allDay;
    private final String appUrl;
    private final String description;
    private final long endTime;
    private final String eventId;
    private final boolean isRepeat;
    private final String location;
    private final Integer repeatCount;
    private final String repeatFrequency;
    private final Integer repeatInterval;
    private final List<Integer> scheduledWeekDays;
    private final long startTime;
    private final String title;

    /* renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getIsRepeat() {
        return this.isRepeat;
    }

    public final List<Integer> component11() {
        return this.scheduledWeekDays;
    }

    /* renamed from: component12, reason: from getter */
    public final String getRepeatFrequency() {
        return this.repeatFrequency;
    }

    /* renamed from: component13, reason: from getter */
    public final Integer getRepeatInterval() {
        return this.repeatInterval;
    }

    /* renamed from: component14, reason: from getter */
    public final Integer getRepeatCount() {
        return this.repeatCount;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final long getStartTime() {
        return this.startTime;
    }

    /* renamed from: component4, reason: from getter */
    public final long getEndTime() {
        return this.endTime;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getAlarmMinutes() {
        return this.alarmMinutes;
    }

    /* renamed from: component6, reason: from getter */
    public final String getEventId() {
        return this.eventId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getAppUrl() {
        return this.appUrl;
    }

    /* renamed from: component8, reason: from getter */
    public final String getLocation() {
        return this.location;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getAllDay() {
        return this.allDay;
    }

    public final CalendarEventRecord copy(String title, String description, long startTime, long endTime, Integer alarmMinutes, String eventId, String appUrl, String location, boolean allDay, boolean isRepeat, List<Integer> scheduledWeekDays, String repeatFrequency, Integer repeatInterval, Integer repeatCount) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        return new CalendarEventRecord(title, description, startTime, endTime, alarmMinutes, eventId, appUrl, location, allDay, isRepeat, scheduledWeekDays, repeatFrequency, repeatInterval, repeatCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CalendarEventRecord)) {
            return false;
        }
        CalendarEventRecord calendarEventRecord = (CalendarEventRecord) other;
        return Intrinsics.areEqual(this.title, calendarEventRecord.title) && Intrinsics.areEqual(this.description, calendarEventRecord.description) && this.startTime == calendarEventRecord.startTime && this.endTime == calendarEventRecord.endTime && Intrinsics.areEqual(this.alarmMinutes, calendarEventRecord.alarmMinutes) && Intrinsics.areEqual(this.eventId, calendarEventRecord.eventId) && Intrinsics.areEqual(this.appUrl, calendarEventRecord.appUrl) && Intrinsics.areEqual(this.location, calendarEventRecord.location) && this.allDay == calendarEventRecord.allDay && this.isRepeat == calendarEventRecord.isRepeat && Intrinsics.areEqual(this.scheduledWeekDays, calendarEventRecord.scheduledWeekDays) && Intrinsics.areEqual(this.repeatFrequency, calendarEventRecord.repeatFrequency) && Intrinsics.areEqual(this.repeatInterval, calendarEventRecord.repeatInterval) && Intrinsics.areEqual(this.repeatCount, calendarEventRecord.repeatCount);
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.endTime)) * 31;
        Integer num = this.alarmMinutes;
        int hashCode3 = (((hashCode2 + (num == null ? 0 : num.hashCode())) * 31) + this.eventId.hashCode()) * 31;
        String str3 = this.appUrl;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.location;
        int hashCode5 = (((((hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31) + Boolean.hashCode(this.allDay)) * 31) + Boolean.hashCode(this.isRepeat)) * 31;
        List<Integer> list = this.scheduledWeekDays;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str5 = this.repeatFrequency;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num2 = this.repeatInterval;
        int hashCode8 = (hashCode7 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.repeatCount;
        return hashCode8 + (num3 != null ? num3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CalendarEventRecord(title=");
        sb.append(this.title).append(", description=").append(this.description).append(", startTime=").append(this.startTime).append(", endTime=").append(this.endTime).append(", alarmMinutes=").append(this.alarmMinutes).append(", eventId=").append(this.eventId).append(", appUrl=").append(this.appUrl).append(", location=").append(this.location).append(", allDay=").append(this.allDay).append(", isRepeat=").append(this.isRepeat).append(", scheduledWeekDays=").append(this.scheduledWeekDays).append(", repeatFrequency=");
        sb.append(this.repeatFrequency).append(", repeatInterval=").append(this.repeatInterval).append(", repeatCount=").append(this.repeatCount).append(')');
        return sb.toString();
    }

    public CalendarEventRecord(String str, String str2, long j, long j2, Integer num, String eventId, String str3, String str4, boolean z, boolean z2, List<Integer> list, String str5, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(eventId, "eventId");
        this.title = str;
        this.description = str2;
        this.startTime = j;
        this.endTime = j2;
        this.alarmMinutes = num;
        this.eventId = eventId;
        this.appUrl = str3;
        this.location = str4;
        this.allDay = z;
        this.isRepeat = z2;
        this.scheduledWeekDays = list;
        this.repeatFrequency = str5;
        this.repeatInterval = num2;
        this.repeatCount = num3;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final Integer getAlarmMinutes() {
        return this.alarmMinutes;
    }

    public final String getEventId() {
        return this.eventId;
    }

    public final String getAppUrl() {
        return this.appUrl;
    }

    public final String getLocation() {
        return this.location;
    }

    public final boolean getAllDay() {
        return this.allDay;
    }

    public final boolean isRepeat() {
        return this.isRepeat;
    }

    public final List<Integer> getScheduledWeekDays() {
        return this.scheduledWeekDays;
    }

    public final String getRepeatFrequency() {
        return this.repeatFrequency;
    }

    public final Integer getRepeatInterval() {
        return this.repeatInterval;
    }

    public final Integer getRepeatCount() {
        return this.repeatCount;
    }
}
