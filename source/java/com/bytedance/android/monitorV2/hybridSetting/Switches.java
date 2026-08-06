package com.bytedance.android.monitorV2.hybridSetting;

import com.bytedance.android.monitorV2.logger.MonitorLog;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public enum Switches {
    monitor(true, 0),
    webMonitor(true, 1),
    webBlank(true, 2),
    webFetch(true, 3),
    webJSB(true, 4),
    webInject(true, 5),
    lynxMonitor(true, 6),
    lynxPerf(true, 7),
    lynxBlank(true, 8),
    lynxFetch(true, 9),
    lynxJsb(true, 10),
    webAutoReport(true, 11),
    webUpdatePageData(true, 12),
    webTTWebDelegate(true, 24),
    teaReport(true, 25),
    webResourceLoader(true, 26),
    lynxResourceLoader(true, 27),
    checkSelf(true, 28),
    eventStream(true, 29),
    blankBitmap(true, 30),
    webDomainWhiteList(false, 31),
    logType(false, 32),
    appSettings(false, 35);

    private boolean enabled;
    private final int index;
    private ManualState manualSwitchState = ManualState.DEFAULT;

    /* loaded from: classes3.dex */
    public enum ManualState {
        DEFAULT,
        ON,
        OFF
    }

    Switches(boolean z, int i) {
        this.enabled = z;
        this.index = i;
        Companion.INDEXES.put(Integer.valueOf(i), this);
        if (i > Companion.MAX_INDEX) {
            int unused = Companion.MAX_INDEX = i;
        }
    }

    public static void resetAll(long j) {
        for (int i = 0; i <= Companion.MAX_INDEX; i++) {
            try {
                boolean z = true;
                if (i != 0) {
                    j >>= 1;
                }
                Switches switches = (Switches) Companion.INDEXES.get(Integer.valueOf(i));
                if (switches != null) {
                    if (j % 2 == 0) {
                        z = false;
                    }
                    switches.setEnabled(z);
                }
            } catch (Throwable th) {
                ExceptionUtil.handleException(ExceptionUtil.STARTUP_HANDLE, th);
                return;
            }
        }
        MonitorLog.i("Switches", "Switches: " + Companion.switchStatus());
    }

    private void setEnabled(boolean z) {
        this.enabled = z;
    }

    public void setEnableManually(ManualState manualState) {
        this.manualSwitchState = manualState;
    }

    public boolean isEnabled() {
        return this.manualSwitchState != ManualState.DEFAULT ? this.manualSwitchState == ManualState.ON : this.enabled;
    }

    public boolean not() {
        return !isEnabled();
    }

    /* loaded from: classes3.dex */
    private static class Companion {
        private static final Map<Integer, Switches> INDEXES = new ConcurrentHashMap();
        private static int MAX_INDEX = 0;
        private static final String TAG = "Switches";

        private Companion() {
        }

        public static String switchStatus() {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, Switches> entry : INDEXES.entrySet()) {
                Integer key = entry.getKey();
                Switches value = entry.getValue();
                sb.append(key.toString()).append(Constants.COLON_SEPARATOR).append(value.name()).append(ContainerUtils.KEY_VALUE_DELIMITER).append(value.enabled).append(' ');
            }
            return sb.toString();
        }
    }
}
