package com.bytedance.sdk.xbridge.cn.calendar.reducer;

import kotlin.Metadata;

/* compiled from: ReducerConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0013¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\u0019\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u000e\u0010\u001b\u001a\u00020\u001cX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/reducer/ReducerConstants;", "", "()V", "ACCOUNT_NAME_ZTE", "", "getACCOUNT_NAME_ZTE", "()Ljava/lang/String;", "ACCOUNT_TYPE_GOOGLE", "getACCOUNT_TYPE_GOOGLE", "ACCOUNT_TYPE_SMARTISAN", "getACCOUNT_TYPE_SMARTISAN", "ACCOUNT_TYPE_ZTE", "getACCOUNT_TYPE_ZTE", "EVENT_ALL_DAY", "EVENT_ID_COLUMN", "EVENT_LOCATION_COLUMN", "EVENT_URL_COLUMN", "HAS_PERMISSION", "LOCAL_ACCOUNT_TYPES", "", "getLOCAL_ACCOUNT_TYPES", "()[Ljava/lang/String;", "[Ljava/lang/String;", "OWNER_ACCOUNT_SMARTISAN", "getOWNER_ACCOUNT_SMARTISAN", "OWNER_ACCOUNT_ZTE", "getOWNER_ACCOUNT_ZTE", "REQUEST_CODE", "", "SYNC_ADAPTER_ACCOUNT", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final class ReducerConstants {
    public static final String EVENT_ALL_DAY = "allDay";
    public static final String EVENT_ID_COLUMN = "sync_data1";
    public static final String EVENT_LOCATION_COLUMN = "eventLocation";
    public static final String EVENT_URL_COLUMN = "sync_data3";
    public static final String HAS_PERMISSION = "HAS_CALENDAR_PERMISSION";
    public static final int REQUEST_CODE = 255;
    public static final String SYNC_ADAPTER_ACCOUNT = "com.bytedance";
    public static final ReducerConstants INSTANCE = new ReducerConstants();
    private static final String[] LOCAL_ACCOUNT_TYPES = {"LOCAL", "com.android.huawei.phone", "com.xiaomi", "com.meizu.account"};
    private static final String ACCOUNT_TYPE_SMARTISAN = "com.smartisan.localcalendar";
    private static final String OWNER_ACCOUNT_SMARTISAN = "Local";
    private static final String ACCOUNT_TYPE_GOOGLE = "com.google";
    private static final String ACCOUNT_TYPE_ZTE = "My calendar";
    private static final String ACCOUNT_NAME_ZTE = "My calendar";
    private static final String OWNER_ACCOUNT_ZTE = "My calendar";

    private ReducerConstants() {
    }

    public final String[] getLOCAL_ACCOUNT_TYPES() {
        return LOCAL_ACCOUNT_TYPES;
    }

    public final String getACCOUNT_TYPE_SMARTISAN() {
        return ACCOUNT_TYPE_SMARTISAN;
    }

    public final String getOWNER_ACCOUNT_SMARTISAN() {
        return OWNER_ACCOUNT_SMARTISAN;
    }

    public final String getACCOUNT_TYPE_GOOGLE() {
        return ACCOUNT_TYPE_GOOGLE;
    }

    public final String getACCOUNT_TYPE_ZTE() {
        return ACCOUNT_TYPE_ZTE;
    }

    public final String getACCOUNT_NAME_ZTE() {
        return ACCOUNT_NAME_ZTE;
    }

    public final String getOWNER_ACCOUNT_ZTE() {
        return OWNER_ACCOUNT_ZTE;
    }
}
