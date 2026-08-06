package com.bytedance.apm6.cpu;

import android.os.Process;
import com.bytedance.monitor.collector.PerfMonitorManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CgroupFetcher {
    private static final int MY_PID = Process.myPid();

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public enum CGROUP_LEVEL {
        UNKNOWN(-1),
        TOP_APP(0),
        FOREGROUND(1),
        BACKGROUND(2);

        private final int value;

        CGROUP_LEVEL(int i) {
            this.value = i;
        }

        public static CGROUP_LEVEL valueOf(int i) {
            if (i == -1) {
                return UNKNOWN;
            }
            if (i == 0) {
                return TOP_APP;
            }
            if (i == 1) {
                return FOREGROUND;
            }
            if (i == 2) {
                return BACKGROUND;
            }
            return UNKNOWN;
        }
    }

    public static CGROUP_LEVEL getGroupLevel() {
        return CGROUP_LEVEL.valueOf(PerfMonitorManager.getInstance().getProcCGroup(MY_PID));
    }
}
