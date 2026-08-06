package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.log.LoggerImpl;

/* loaded from: classes5.dex */
public class j5 implements Runnable {
    public final /* synthetic */ k5 a;

    public j5(k5 k5Var) {
        this.a = k5Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.a.a.size(); i++) {
            try {
                String[] strArr = {"openudid", "clientudid", "serial_number", "sim_serial_number", "udid", "device_id"};
                for (int i2 = 0; i2 < 6; i2++) {
                    String str = strArr[i2];
                    try {
                        k5 k5Var = this.a;
                        k5Var.a(k5Var.a.get(i), str);
                    } catch (Exception e) {
                        LoggerImpl.global().error("DeprecatedFileCleaner execute failed", e, new Object[0]);
                    }
                }
            } catch (Exception unused) {
                return;
            }
        }
    }
}
