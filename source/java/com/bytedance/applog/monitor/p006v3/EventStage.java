package com.bytedance.applog.monitor.p006v3;

import com.bytedance.apm.constant.CommonServiceName;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public enum EventStage {
    UNKNOWN("-1"),
    COLLECTED("00"),
    PARAMS_INVALID_DROP("01"),
    NOT_INIT_DROP("02"),
    PRE_PROCESS_START("03"),
    CACHED_BEFORE_HANDLE("04"),
    CACHE_DROP_BEFORE_HANDLE("05"),
    DATA_LIST_ADDED("06"),
    PRE_PROCESS_END("0F"),
    PROCESS_START("10"),
    TOURIST_BREAK(CommonServiceName.CRONET_ERROR_CODE_CANCEL),
    FILTER_EVENT_BLOCKED("12"),
    FILTER_SERVER_BLOCKED("13"),
    FILTER_CUSTOM_BLOCKED("14"),
    FILTER_SAMPLING_DROPPED("15"),
    NO_SESSION_DROP("16"),
    PROCESS_END("1F"),
    DB_SAVE_START("20"),
    HANDLE_REALTIME_START("21"),
    REALTIME_SEND_START("22"),
    REALTIME_SEND_FAILED("23"),
    REALTIME_CRASH_DROP("24"),
    PRIORITY_HANDLE("28"),
    PRIORITY_ACCEPT("29"),
    DB_INSERT_START("2A"),
    DB_SAVE_FAILED("2B"),
    DB_SAVE_END("2F"),
    REPORT_START("30"),
    PACK_END("31"),
    PACK_INSERT_START("34"),
    PACK_INSERT_FAILED("35"),
    PACK_INSERT_END("36"),
    POST_START("3A"),
    POST_FAILED("3B"),
    REPORT_END("3F");

    private final String label;

    EventStage(String str) {
        this.label = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.label;
    }

    public static EventStage fromLabel(String str) {
        for (EventStage eventStage : values()) {
            if (eventStage.label.equals(str)) {
                return eventStage;
            }
        }
        return UNKNOWN;
    }
}
