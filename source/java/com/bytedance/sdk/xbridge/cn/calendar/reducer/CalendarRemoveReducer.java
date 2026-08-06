package com.bytedance.sdk.xbridge.cn.calendar.reducer;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.CalendarContract;
import com.bytedance.sdk.xbridge.cn.XBridge;
import com.bytedance.sdk.xbridge.cn.calendar.AbsXDeleteCalendarEventMethodIDL;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CalendarRemoveReducer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/reducer/CalendarRemoveReducer;", "", "()V", "deleteCalendar", "Lcom/bytedance/sdk/xbridge/cn/calendar/model/CalendarErrorCode;", "params", "Lcom/bytedance/sdk/xbridge/cn/calendar/AbsXDeleteCalendarEventMethodIDL$XDeleteCalendarEventParamModel;", "contentResolver", "Landroid/content/ContentResolver;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CalendarRemoveReducer {
    public static final CalendarRemoveReducer INSTANCE = new CalendarRemoveReducer();

    private CalendarRemoveReducer() {
    }

    public final CalendarErrorCode deleteCalendar(AbsXDeleteCalendarEventMethodIDL.XDeleteCalendarEventParamModel params, ContentResolver contentResolver) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(contentResolver, "contentResolver");
        String[] strArr = {params.getIdentifier()};
        Cursor query = contentResolver.query(CalendarContract.Events.CONTENT_URI, new String[]{"_id"}, "sync_data1=?", strArr, null);
        if (query == null) {
            XBridge.log("delete failed. maybe this identifier " + params.getIdentifier() + " matches nothing.");
            return CalendarErrorCode.NotFound;
        }
        if (query.moveToNext()) {
            contentResolver.delete(CalendarContract.Reminders.CONTENT_URI, "event_id=?", new String[]{String.valueOf(query.getLong(0))});
            if (contentResolver.delete(CalendarContract.Events.CONTENT_URI, "sync_data1=?", strArr) > 0) {
                return CalendarErrorCode.Success;
            }
            return CalendarErrorCode.Failed;
        }
        XBridge.log("delete failed. maybe this identifier " + params.getIdentifier() + " matches nothing.");
        return CalendarErrorCode.NotFound;
    }
}
