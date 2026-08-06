package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;

/* loaded from: classes7.dex */
public class bj implements Runnable {
    private Context a;

    /* renamed from: a, reason: collision with other field name */
    private com.xiaomi.clientreport.processor.c f204a;

    public void a(com.xiaomi.clientreport.processor.c cVar) {
        this.f204a = cVar;
    }

    public void a(Context context) {
        this.a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            com.xiaomi.clientreport.processor.c cVar = this.f204a;
            if (cVar != null) {
                cVar.a();
            }
            com.xiaomi.channel.commonutils.logger.b.c("begin read and send perf / event");
            com.xiaomi.clientreport.processor.c cVar2 = this.f204a;
            if (cVar2 instanceof IEventProcessor) {
                bl.a(this.a).m9665a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (cVar2 instanceof IPerfProcessor) {
                bl.a(this.a).m9665a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
        }
    }
}
