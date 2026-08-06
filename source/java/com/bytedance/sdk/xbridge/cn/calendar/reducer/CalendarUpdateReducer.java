package com.bytedance.sdk.xbridge.cn.calendar.reducer;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.bytedance.sdk.account.constants.AccountConstants;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.calendar.AbsXCreateCalendarEventMethodIDL;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarModel;
import com.bytedance.sdk.xbridge.cn.calendar.utils.KotlinUtilsKt;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* compiled from: CalendarUpdateReducer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tH\u0002J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/reducer/CalendarUpdateReducer;", "", "()V", "TAG", "", "getCalendars", "", "Lcom/bytedance/sdk/xbridge/cn/calendar/model/CalendarModel;", "contentResolver", "Landroid/content/ContentResolver;", "getLocalCalendar", "getRemindersId", "", "params", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXCreateCalendarEventMethodIDL$XCreateCalendarEventParamModel;", "updateCalendar", "Lcom/bytedance/sdk/xbridge/cn/calendar/model/CalendarErrorCode;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CalendarUpdateReducer {
    public static final CalendarUpdateReducer INSTANCE = new CalendarUpdateReducer();
    private static final String TAG = "[CalendarUpdateReducer]";

    private CalendarUpdateReducer() {
    }

    public final CalendarErrorCode updateCalendar(AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventParamModel params, ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        CalendarModel localCalendar = getLocalCalendar(contentResolver);
        if (localCalendar == null) {
            XBridge.log("updateCalendar: no available local calendar");
            return CalendarErrorCode.NoAccount;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("calendar_id", Long.valueOf(localCalendar.getId()));
        contentValues.put("eventTimezone", TimeZone.getDefault().getID());
        contentValues.put("dtstart", Long.valueOf(params.getStartDate().longValue()));
        contentValues.put("dtend", Long.valueOf(params.getEndDate().longValue()));
        contentValues.put("title", params.getTitle());
        contentValues.put("description", params.getNotes());
        contentValues.put(ReducerConstants.EVENT_ID_COLUMN, params.getIdentifier());
        contentValues.put(ReducerConstants.EVENT_ALL_DAY, params.getAllDay());
        contentValues.put(ReducerConstants.EVENT_LOCATION_COLUMN, params.getLocation());
        contentValues.put(ReducerConstants.EVENT_URL_COLUMN, params.getUrl());
        if (!Intrinsics.areEqual(params.getRepeatCount(), -1) && !Intrinsics.areEqual(params.getRepeatInterval(), -1)) {
            contentValues.put(ReportConstant.COMMON_INIT_DURATION, "P" + ((params.getEndDate().longValue() - params.getStartDate().longValue()) / 60000) + 'M');
            contentValues.put("rrule", "FREQ=" + params.getRepeatFrequency() + ";COUNT=" + params.getRepeatCount() + ";INTERVAL=" + params.getRepeatInterval());
        }
        String[] strArr = {params.getIdentifier()};
        Uri uri = CalendarContract.Events.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(uri, "CONTENT_URI");
        if (contentResolver.update(KotlinUtilsKt.asSyncAdapter(uri, ReducerConstants.SYNC_ADAPTER_ACCOUNT, "LOCAL"), contentValues, "sync_data1=?", strArr) > 0) {
            Number alarmOffset = params.getAlarmOffset();
            if (alarmOffset == null) {
                return CalendarErrorCode.Success;
            }
            if (alarmOffset.longValue() >= 0) {
                long remindersId = INSTANCE.getRemindersId(params, contentResolver);
                if (remindersId < 0) {
                    return CalendarErrorCode.Failed;
                }
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(remindersId));
                Number alarmOffset2 = params.getAlarmOffset();
                contentValues2.put("minutes", alarmOffset2 != null ? Long.valueOf(alarmOffset2.longValue() / 60000) : null);
                contentValues2.put("method", (Integer) 1);
                if (contentResolver.update(CalendarContract.Reminders.CONTENT_URI, contentValues2, "event_id=?", new String[]{String.valueOf(remindersId)}) > 0) {
                    return CalendarErrorCode.Success;
                }
                return CalendarErrorCode.Failed;
            }
            return CalendarErrorCode.InvalidParameter;
        }
        return CalendarErrorCode.Failed;
    }

    private final List<CalendarModel> getCalendars(ContentResolver contentResolver) {
        Uri uri = CalendarContract.Calendars.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(uri, "CONTENT_URI");
        Cursor query = contentResolver.query(uri, new String[]{"_id", "name", "calendar_displayName", "account_name", AccountConstants.AccountShareCols.ACCOUNT_TYPE, "visible", "ownerAccount"}, null, null, null);
        if (query != null) {
            Cursor cursor = query;
            try {
                List<CalendarModel> list = SequencesKt.toList(SequencesKt.sequence(new CalendarUpdateReducer$getCalendars$1$1(cursor, null)));
                CloseableKt.closeFinally(cursor, (Throwable) null);
                if (list != null) {
                    return list;
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(cursor, th);
                    throw th2;
                }
            }
        }
        return CollectionsKt.emptyList();
    }

    private final CalendarModel getLocalCalendar(ContentResolver contentResolver) {
        Object obj;
        Object obj2;
        boolean z;
        List<CalendarModel> calendars = getCalendars(contentResolver);
        Iterator<T> it = calendars.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (ArraysKt.contains(ReducerConstants.INSTANCE.getLOCAL_ACCOUNT_TYPES(), ((CalendarModel) obj2).getAccountType())) {
                break;
            }
        }
        CalendarModel calendarModel = (CalendarModel) obj2;
        if (calendarModel != null) {
            return calendarModel;
        }
        Iterator<T> it2 = calendars.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            CalendarModel calendarModel2 = (CalendarModel) next;
            String accountType = calendarModel2.getAccountType();
            if (Intrinsics.areEqual(accountType, ReducerConstants.INSTANCE.getACCOUNT_TYPE_SMARTISAN())) {
                z = Intrinsics.areEqual(calendarModel2.getOwnerAccount(), ReducerConstants.INSTANCE.getOWNER_ACCOUNT_SMARTISAN());
            } else {
                z = Intrinsics.areEqual(accountType, ReducerConstants.INSTANCE.getACCOUNT_TYPE_ZTE()) && Intrinsics.areEqual(calendarModel2.getAccountName(), ReducerConstants.INSTANCE.getACCOUNT_NAME_ZTE()) && Intrinsics.areEqual(calendarModel2.getOwnerAccount(), ReducerConstants.INSTANCE.getOWNER_ACCOUNT_ZTE());
            }
            if (z) {
                obj = next;
                break;
            }
        }
        return (CalendarModel) obj;
    }

    private final long getRemindersId(AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventParamModel params, ContentResolver contentResolver) {
        boolean z = true;
        Cursor query = contentResolver.query(CalendarContract.Events.CONTENT_URI, new String[]{"_id"}, "sync_data1=?", new String[]{params.getIdentifier()}, null);
        try {
            Cursor cursor = query;
            if (cursor == null || !cursor.moveToNext()) {
                z = false;
            }
            long j = z ? cursor.getLong(0) : -1L;
            CloseableKt.closeFinally(query, (Throwable) null);
            return j;
        } finally {
        }
    }
}
