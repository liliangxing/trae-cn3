package com.xiaomi.clientreport.manager;

import android.content.Context;
import android.os.Process;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.C1421a;
import com.xiaomi.clientreport.processor.C1422b;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.C1628g;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ClientReportClient {
    public static void init(Context context) {
        init(context, Config.defaultConfig(context), new C1421a(context), new C1422b(context));
    }

    public static void init(Context context, Config config) {
        init(context, config, new C1421a(context), new C1422b(context));
    }

    public static void init(Context context, Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        AbstractC1417b.m1101c("init in  pid :" + Process.myPid() + " threadId: " + Thread.currentThread().getId());
        C1420a.m1108a(context).m1126a(config, iEventProcessor, iPerfProcessor);
        if (C1628g.m2686a(context)) {
            AbstractC1417b.m1101c("init in process\u3000start scheduleJob");
            C1420a.m1108a(context).m1125a();
        }
    }

    public static void updateConfig(Context context, Config config) {
        if (config == null) {
            return;
        }
        C1420a.m1108a(context).m1130a(config.isEventUploadSwitchOpen(), config.isPerfUploadSwitchOpen(), config.getEventUploadFrequency(), config.getPerfUploadFrequency());
    }

    public static void reportEvent(Context context, EventClientReport eventClientReport) {
        if (eventClientReport != null) {
            C1420a.m1108a(context).m1127a(eventClientReport);
        }
    }

    public static void reportPerf(Context context, PerfClientReport perfClientReport) {
        if (perfClientReport != null) {
            C1420a.m1108a(context).m1128a(perfClientReport);
        }
    }
}
