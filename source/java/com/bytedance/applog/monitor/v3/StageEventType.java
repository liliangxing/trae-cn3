package com.bytedance.applog.monitor.v3;

import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes3.dex */
public enum StageEventType {
    V3_EVENT(0),
    V1_EVENT(1),
    LOG_DATA(2),
    LAUNCH(3),
    TERMINATE(4),
    ITEM_IMPRESSION(5);

    private final int label;

    StageEventType(int i) {
        this.label = i;
    }

    public int getLabel() {
        return this.label;
    }

    public static StageEventType parse(String str) {
        for (StageEventType stageEventType : values()) {
            if (stageEventType.name().equals(str)) {
                return stageEventType;
            }
        }
        return V3_EVENT;
    }

    public static StageEventType fromLabel(int i) {
        if (i == 1) {
            return V1_EVENT;
        }
        if (i == 2) {
            return LOG_DATA;
        }
        if (i == 3) {
            return LAUNCH;
        }
        if (i == 4) {
            return TERMINATE;
        }
        return V3_EVENT;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + this.label;
    }
}
