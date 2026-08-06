package com.ttnet.org.chromium.base;

import android.os.PowerManager;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class PowerMonitorForQ {
    private PowerMonitorForQ() {
    }

    public static void addThermalStatusListener(PowerManager powerManager) {
        powerManager.addThermalStatusListener(new PowerManager.OnThermalStatusChangedListener() { // from class: com.ttnet.org.chromium.base.PowerMonitorForQ.1
            @Override // android.os.PowerManager.OnThermalStatusChangedListener
            public void onThermalStatusChanged(int i) {
                PowerMonitorJni.get().onThermalStatusChanged(i);
            }
        });
    }
}
