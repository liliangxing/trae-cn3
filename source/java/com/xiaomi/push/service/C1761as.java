package com.xiaomi.push.service;

import com.ss.ttm.player.MediaPlayer;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.C1588en;
import com.xiaomi.push.service.XMPushService;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.xiaomi.push.service.as */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1761as {

    /* renamed from: d */
    private static int f3079d = 300000;

    /* renamed from: a */
    private XMPushService f3082a;

    /* renamed from: b */
    private int f3083b = 0;

    /* renamed from: c */
    private int f3084c = 0;

    /* renamed from: a */
    private int f3080a = MediaPlayer.MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE;

    /* renamed from: a */
    private long f3081a = 0;

    public C1761as(XMPushService xMPushService) {
        this.f3082a = xMPushService;
    }

    /* renamed from: a */
    public void m3751a() {
        this.f3081a = System.currentTimeMillis();
        this.f3082a.m3545a(1);
        this.f3083b = 0;
    }

    /* renamed from: a */
    public void m3752a(boolean z) {
        if (!this.f3082a.m3557a()) {
            AbstractC1417b.m1101c("should not reconnect as no client or network.");
            return;
        }
        if (z) {
            if (!this.f3082a.m3558a(1)) {
                this.f3083b++;
            }
            this.f3082a.m3545a(1);
            AbstractC1417b.m1090a("ReconnectionManager", "-->tryReconnect(): exec ConnectJob");
            XMPushService xMPushService = this.f3082a;
            XMPushService xMPushService2 = this.f3082a;
            xMPushService2.getClass();
            xMPushService.m3548a(new XMPushService.C1726e());
            return;
        }
        if (this.f3082a.m3558a(1)) {
            return;
        }
        int m3750a = m3750a();
        this.f3083b++;
        AbstractC1417b.m1089a("schedule reconnect in " + m3750a + "ms");
        XMPushService xMPushService3 = this.f3082a;
        XMPushService xMPushService4 = this.f3082a;
        xMPushService4.getClass();
        xMPushService3.m3549a(new XMPushService.C1726e(), m3750a);
        if (this.f3083b == 2 && C1588en.m2403a().m2410a()) {
            C1798z.m4098b();
        }
        if (this.f3083b == 3) {
            C1798z.m4095a();
        }
    }

    /* renamed from: a */
    private int m3750a() {
        double d;
        if (this.f3083b > 8) {
            return 300000;
        }
        double random = (Math.random() * 2.0d) + 1.0d;
        int i = this.f3083b;
        if (i > 4) {
            d = 60000.0d;
        } else {
            if (i <= 1) {
                if (this.f3081a == 0) {
                    return 0;
                }
                if (System.currentTimeMillis() - this.f3081a < 310000) {
                    int i2 = this.f3080a;
                    int i3 = f3079d;
                    if (i2 >= i3) {
                        return i2;
                    }
                    int i4 = this.f3084c + 1;
                    this.f3084c = i4;
                    if (i4 >= 4) {
                        return i3;
                    }
                    this.f3080a = (int) (i2 * 1.5d);
                    return i2;
                }
                this.f3080a = 1000;
                this.f3084c = 0;
                return 0;
            }
            d = 10000.0d;
        }
        return (int) (random * d);
    }
}
