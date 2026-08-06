package com.bytedance.applog.monitor.p006v3;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class Features {

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum BooleanFeatureKeys {
        NORMAL_SAMPLING_SWITCH(0),
        TEA_SAMPLING_SWITCH(1),
        PRIORITY_SWITCH(2),
        RECOVERY_SWITCH(3),
        LOG_SETTINGS_EVENT_FILTER(4),
        CUSTOM_EVENT_FILTER(5),
        ENCRYPT_SWITCH(6),
        FORWARD_REPORT_SWITCH(7),
        DATA_ISOLATE_SWITCH(8),
        EVENT_USER_ID_SWITCH(9),
        TOURIST_MODE_SWITCH(10),
        TOURIST_MODE_EVENT_SWITCH(11),
        ADJUST_TERMINATE_SWITCH(12),
        DISABLE_PERSONALIZATION_SWITCH(13),
        CHILD_MODE_BEFORE_INIT_SWITCH(14),
        CHILD_MODE_SWITCH(15),
        DEVTOOLS_SWITCH(16),
        DEBUG_LOG_SWITCH(17),
        BG_SESSION_SWITCH(18),
        CONTROL_EVENT_PARAM_SWITCH(21),
        CONTROL_CUSTOM_HEADER_SWITCH(22);

        private final int position;

        BooleanFeatureKeys(int i) {
            this.position = i;
        }

        public int toBits(int i, boolean z) {
            int i2 = 1 << this.position;
            return z ? i | i2 : i & (~i2);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum IntFeatureKeys {
        REPORT_INTERVAL(19, 2);

        private final int length;
        private final int position;

        IntFeatureKeys(int i, int i2) {
            this.position = i;
            this.length = i2;
        }

        public int toBits(int i, int i2) {
            if (i2 >= (1 << this.length)) {
                i2 = getPositiveBitsByLength();
            }
            return (i & (~getPositiveBitsByLength())) | (i2 << this.position);
        }

        private int getPositiveBitsByLength() {
            int i = 1;
            for (int i2 = 0; i2 < this.length; i2++) {
                i &= 1 << i2;
            }
            return i;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum ReportInterval {
        DEFAULT_60(0),
        LESS_THAN_60(1),
        BIG_THAN_60(2);

        private int value;

        ReportInterval(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }
}
