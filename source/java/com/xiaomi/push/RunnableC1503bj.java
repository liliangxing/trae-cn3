package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.clientreport.processor.InterfaceC1423c;

/* renamed from: com.xiaomi.push.bj */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class RunnableC1503bj implements Runnable {

    /* renamed from: a */
    private Context f1072a;

    /* renamed from: a */
    private InterfaceC1423c f1073a;

    /* renamed from: a */
    public void m1662a(InterfaceC1423c interfaceC1423c) {
        this.f1073a = interfaceC1423c;
    }

    /* renamed from: a */
    public void m1661a(Context context) {
        this.f1072a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            InterfaceC1423c interfaceC1423c = this.f1073a;
            if (interfaceC1423c != null) {
                interfaceC1423c.mo1140a();
            }
            AbstractC1417b.m1101c("begin read and send perf / event");
            InterfaceC1423c interfaceC1423c2 = this.f1073a;
            if (interfaceC1423c2 instanceof IEventProcessor) {
                C1505bl.m1672a(this.f1072a).m1675a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (interfaceC1423c2 instanceof IPerfProcessor) {
                C1505bl.m1672a(this.f1072a).m1675a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
        }
    }
}
