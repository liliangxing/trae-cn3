package com.bytedance.sdk.xbridge.cn.calendar.reducer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CalendarContract;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.calendar.AbsXReadCalendarEventMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: CalendarReadReducer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/reducer/CalendarReadReducer;", "", "()V", "TAG", "", "getAlarmOffset", "", "eventRowId", "", "contentResolver", "Landroid/content/ContentResolver;", "(JLandroid/content/ContentResolver;)Ljava/lang/Integer;", "getEndDate", "value1", "value2", "readCalendar", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXReadCalendarEventMethodIDL$XReadCalendarEventResultModel;", "param", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXReadCalendarEventMethodIDL$XReadCalendarEventParamModel;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CalendarReadReducer {
    public static final CalendarReadReducer INSTANCE = new CalendarReadReducer();
    private static final String TAG = "[CalendarReadReducer]";

    public final long getEndDate(long value1, long value2) {
        if (value1 != 0) {
            return value1;
        }
        if (value2 != 0) {
            return value2;
        }
        return 0L;
    }

    private CalendarReadReducer() {
    }

    public final AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel readCalendar(AbsXReadCalendarEventMethodIDL.XReadCalendarEventParamModel param, ContentResolver contentResolver) {
        AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel xReadCalendarEventResultModel;
        Intrinsics.checkNotNullParameter(param, "param");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        Cursor query = contentResolver.query(CalendarContract.Events.CONTENT_URI, new String[]{"_id", ReducerConstants.EVENT_ID_COLUMN, "dtstart", "dtend", "title", "description", ReducerConstants.EVENT_LOCATION_COLUMN, ReducerConstants.EVENT_URL_COLUMN, "lastDate"}, "sync_data1=?", new String[]{param.getIdentifier()}, null);
        if (query != null) {
            Cursor cursor = query;
            try {
                Cursor cursor2 = cursor;
                if (cursor2.getCount() <= 0) {
                    XBridge.log("read calendar but with this identifier = " + param.getIdentifier() + ", got a null.");
                    CloseableKt.closeFinally(cursor, (Throwable) null);
                    return null;
                }
                if (cursor2.moveToNext()) {
                    XBaseModel createXModel = XBridgeKTXKt.createXModel((KClass<XBaseModel>) Reflection.getOrCreateKotlinClass(AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel.class));
                    AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel xReadCalendarEventResultModel2 = (AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel) createXModel;
                    CalendarReadReducer calendarReadReducer = INSTANCE;
                    Integer alarmOffset = calendarReadReducer.getAlarmOffset(cursor2.getLong(0), contentResolver);
                    if (alarmOffset != null) {
                        xReadCalendarEventResultModel2.setAlarmOffset(Integer.valueOf(alarmOffset.intValue() * 60000));
                    }
                    xReadCalendarEventResultModel2.setStartDate(Long.valueOf(cursor2.getLong(2)));
                    xReadCalendarEventResultModel2.setEndDate(Long.valueOf(calendarReadReducer.getEndDate(cursor2.getLong(3), cursor2.getLong(8))));
                    xReadCalendarEventResultModel2.setTitle(cursor2.getString(4));
                    xReadCalendarEventResultModel2.setNotes(cursor2.getString(5));
                    xReadCalendarEventResultModel2.setLocation(cursor2.getString(6));
                    xReadCalendarEventResultModel2.setUrl(cursor2.getString(7));
                    xReadCalendarEventResultModel = (AbsXReadCalendarEventMethodIDL.XReadCalendarEventResultModel) createXModel;
                } else {
                    xReadCalendarEventResultModel = null;
                }
                CloseableKt.closeFinally(cursor, (Throwable) null);
                return xReadCalendarEventResultModel;
            } finally {
            }
        } else {
            XBridge.log("read calendar but meet an error. Please check.");
            return null;
        }
    }

    private final Integer getAlarmOffset(long eventRowId, ContentResolver contentResolver) {
        Cursor query = contentResolver.query(CalendarContract.Reminders.CONTENT_URI, new String[]{"minutes"}, "event_id=?", new String[]{String.valueOf(eventRowId)}, null);
        if (query == null) {
            return null;
        }
        Cursor cursor = query;
        try {
            Cursor cursor2 = cursor;
            Integer valueOf = cursor2.moveToNext() ? Integer.valueOf(cursor2.getInt(0)) : null;
            CloseableKt.closeFinally(cursor, (Throwable) null);
            return valueOf;
        } finally {
        }
    }
}
