package com.bytedance.tobshadow.bdtracker;

import com.bytedance.tobshadow.applog.log.LoggerImpl;

/* renamed from: com.bytedance.tobshadow.bdtracker.j5 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class RunnableC0452j5 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C0459k5 f709a;

    public RunnableC0452j5(C0459k5 c0459k5) {
        this.f709a = c0459k5;
    }

    @Override // java.lang.Runnable
    public void run() {
        for (int i = 0; i < this.f709a.f728a.size(); i++) {
            try {
                String[] strArr = {"openudid", "clientudid", "serial_number", "sim_serial_number", "udid", "device_id"};
                for (int i2 = 0; i2 < 6; i2++) {
                    String str = strArr[i2];
                    try {
                        C0459k5 c0459k5 = this.f709a;
                        c0459k5.m504a(c0459k5.f728a.get(i), str);
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
