package com.bytedance.sdk.xbridge.cn.calendar.reducer;

import android.content.ContentResolver;
import android.content.ContentUris;
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

/* compiled from: CalendarCreateReducer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/reducer/CalendarCreateReducer;", "", "()V", "TAG", "", "checkCalendarAccount", "", "contentResolver", "Landroid/content/ContentResolver;", "name", "createCalendar", "Lcom/bytedance/sdk/xbridge/cn/calendar/model/CalendarErrorCode;", "params", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXCreateCalendarEventMethodIDL$XCreateCalendarEventParamModel;", "createLocalCalenderAccount", "accountName", "getCalendars", "", "Lcom/bytedance/sdk/xbridge/cn/calendar/model/CalendarModel;", "getLocalCalendar", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CalendarCreateReducer {
    public static final CalendarCreateReducer INSTANCE = new CalendarCreateReducer();
    private static final String TAG = "[CalendarCreateReducer]";

    private CalendarCreateReducer() {
    }

    public final CalendarErrorCode createCalendar(AbsXCreateCalendarEventMethodIDL.XCreateCalendarEventParamModel params, ContentResolver contentResolver) {
        long id;
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        String calendarName = params.getCalendarName();
        String str = calendarName;
        if (!(str == null || str.length() == 0)) {
            id = checkCalendarAccount(contentResolver, calendarName);
            if (id == -1) {
                id = createLocalCalenderAccount(contentResolver, calendarName);
            }
        } else {
            CalendarModel localCalendar = getLocalCalendar(contentResolver);
            if (localCalendar == null) {
                XBridge.log("createCalendar: no available local calendar");
                return CalendarErrorCode.NoAccount;
            }
            id = localCalendar.getId();
        }
        if (id == -1) {
            return CalendarErrorCode.NoAccount;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("calendar_id", Long.valueOf(id));
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
            contentValues.put("rrule", "FREQ=" + params.getRepeatFrequency() + ";COUNT=" + params.getRepeatCount() + ";INTERVAL=" + params.getRepeatInterval());
            contentValues.put(ReportConstant.COMMON_INIT_DURATION, "P" + ((params.getEndDate().longValue() - params.getStartDate().longValue()) / 60000) + 'M');
        }
        Uri uri = CalendarContract.Events.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(uri, "CONTENT_URI");
        Uri insert = contentResolver.insert(KotlinUtilsKt.asSyncAdapter(uri, ReducerConstants.SYNC_ADAPTER_ACCOUNT, "LOCAL"), contentValues);
        XBridge.log("create calendar " + id + " insert, uri:" + insert);
        if (insert != null) {
            Number alarmOffset = params.getAlarmOffset();
            if (alarmOffset == null) {
                return CalendarErrorCode.Success;
            }
            if (alarmOffset.longValue() >= 0) {
                ContentValues contentValues2 = new ContentValues();
                String lastPathSegment = insert.getLastPathSegment();
                contentValues2.put("event_id", lastPathSegment != null ? Long.valueOf(Long.parseLong(lastPathSegment)) : null);
                Number alarmOffset2 = params.getAlarmOffset();
                contentValues2.put("minutes", alarmOffset2 != null ? Long.valueOf(alarmOffset2.longValue() / 60000) : null);
                contentValues2.put("method", (Integer) 1);
                if (contentResolver.insert(CalendarContract.Reminders.CONTENT_URI, contentValues2) == null) {
                    XBridge.log("insert the reminders res == null");
                    return CalendarErrorCode.Unknown;
                }
                return CalendarErrorCode.Success;
            }
            return CalendarErrorCode.InvalidParameter;
        }
        XBridge.log("createCalendar: insert ret = null");
        return CalendarErrorCode.Unknown;
    }

    private final long createLocalCalenderAccount(ContentResolver contentResolver, String accountName) {
        TimeZone timeZone = TimeZone.getDefault();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", accountName);
        contentValues.put("account_name", accountName);
        contentValues.put(AccountConstants.AccountShareCols.ACCOUNT_TYPE, "LOCAL");
        contentValues.put("calendar_displayName", accountName);
        contentValues.put("visible", (Integer) 1);
        contentValues.put("calendar_color", (Integer) (-16776961));
        contentValues.put("calendar_access_level", (Integer) 700);
        contentValues.put("sync_events", (Integer) 1);
        contentValues.put("calendar_timezone", timeZone.getID());
        contentValues.put("ownerAccount", accountName);
        contentValues.put("canOrganizerRespond", (Integer) 0);
        Uri insert = contentResolver.insert(CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", accountName).appendQueryParameter(AccountConstants.AccountShareCols.ACCOUNT_TYPE, "LOCAL").build(), contentValues);
        if (insert == null) {
            return -1L;
        }
        return ContentUris.parseId(insert);
    }

    private final long checkCalendarAccount(ContentResolver contentResolver, String name) {
        Cursor query = contentResolver.query(CalendarContract.Calendars.CONTENT_URI, new String[]{"_id", "name"}, null, null, null);
        try {
            Cursor cursor = query;
            if (cursor == null) {
                CloseableKt.closeFinally(query, (Throwable) null);
                return -1L;
            }
            while (cursor.moveToNext()) {
                if (Intrinsics.areEqual(cursor.getString(1), name)) {
                    long j = cursor.getLong(0);
                    CloseableKt.closeFinally(query, (Throwable) null);
                    return j;
                }
            }
            CloseableKt.closeFinally(query, (Throwable) null);
            return -1L;
        } finally {
        }
    }

    private final List<CalendarModel> getCalendars(ContentResolver contentResolver) {
        Uri uri = CalendarContract.Calendars.CONTENT_URI;
        Intrinsics.checkNotNullExpressionValue(uri, "CONTENT_URI");
        Cursor query = contentResolver.query(uri, new String[]{"_id", "name", "calendar_displayName", "account_name", AccountConstants.AccountShareCols.ACCOUNT_TYPE, "visible", "ownerAccount", "calendar_access_level"}, null, null, null);
        if (query != null) {
            Cursor cursor = query;
            try {
                List<CalendarModel> list = SequencesKt.toList(SequencesKt.sequence(new CalendarCreateReducer$getCalendars$1$1(cursor, null)));
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
}
