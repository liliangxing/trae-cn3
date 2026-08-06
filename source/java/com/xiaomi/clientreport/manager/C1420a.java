package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.clientreport.data.C1419a;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.C1470ad;
import com.xiaomi.push.C1494ba;
import com.xiaomi.push.C1501bh;
import com.xiaomi.push.C1502bi;
import com.xiaomi.push.C1504bk;
import com.xiaomi.push.C1505bl;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.RunnableC1503bj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.xiaomi.clientreport.manager.a */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1420a {

    /* renamed from: a */
    private static final int f754a;

    /* renamed from: a */
    private static volatile C1420a f755a;

    /* renamed from: a */
    private Context f756a;

    /* renamed from: a */
    private Config f757a;

    /* renamed from: a */
    private IEventProcessor f758a;

    /* renamed from: a */
    private IPerfProcessor f759a;

    /* renamed from: a */
    private String f760a;

    /* renamed from: a */
    private ExecutorService f762a = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    private HashMap<String, HashMap<String, C1419a>> f761a = new HashMap<>();

    /* renamed from: b */
    private HashMap<String, ArrayList<C1419a>> f763b = new HashMap<>();

    static {
        f754a = C1694j.m3426a() ? 30 : 10;
    }

    private C1420a(Context context) {
        this.f756a = context;
    }

    /* renamed from: a */
    public static C1420a m1108a(Context context) {
        if (f755a == null) {
            synchronized (C1420a.class) {
                if (f755a == null) {
                    f755a = new C1420a(context);
                }
            }
        }
        return f755a;
    }

    /* renamed from: a */
    public synchronized Config m1123a() {
        if (this.f757a == null) {
            this.f757a = Config.defaultConfig(this.f756a);
        }
        return this.f757a;
    }

    /* renamed from: a */
    public void m1125a() {
        m1108a(this.f756a).m1121f();
        m1108a(this.f756a).m1122g();
    }

    /* renamed from: a */
    public void m1129a(String str) {
        this.f760a = str;
    }

    /* renamed from: a */
    public void m1126a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f757a = config;
        this.f758a = iEventProcessor;
        this.f759a = iPerfProcessor;
        iEventProcessor.setEventMap(this.f763b);
        this.f759a.setPerfMap(this.f761a);
    }

    /* renamed from: a */
    public void m1130a(boolean z, boolean z2, long j, long j2) {
        Config config = this.f757a;
        if (config != null) {
            if (z == config.isEventUploadSwitchOpen() && z2 == this.f757a.isPerfUploadSwitchOpen() && j == this.f757a.getEventUploadFrequency() && j2 == this.f757a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f757a.getEventUploadFrequency();
            long perfUploadFrequency = this.f757a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(C1504bk.m1664a(this.f756a)).setEventEncrypted(this.f757a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j2).build(this.f756a);
            this.f757a = build;
            if (!build.isEventUploadSwitchOpen()) {
                C1470ad.m1444a(this.f756a).m1455a("100886");
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                AbstractC1417b.m1101c(this.f756a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                m1121f();
            }
            if (!this.f757a.isPerfUploadSwitchOpen()) {
                C1470ad.m1444a(this.f756a).m1455a("100887");
            } else if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                AbstractC1417b.m1101c(this.f756a.getPackageName() + " reset perf job " + build.getPerfUploadFrequency());
                m1122g();
            }
        }
    }

    /* renamed from: a */
    private void m1113a(C1470ad.a aVar, int i) {
        C1470ad.m1444a(this.f756a).m1456b(aVar, i);
    }

    /* renamed from: a */
    public void m1127a(final EventClientReport eventClientReport) {
        if (m1123a().isEventUploadSwitchOpen()) {
            this.f762a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.1
                @Override // java.lang.Runnable
                public void run() {
                    C1420a.this.m1116b(eventClientReport);
                }
            });
        }
    }

    /* renamed from: a */
    public void m1128a(final PerfClientReport perfClientReport) {
        if (m1123a().isPerfUploadSwitchOpen()) {
            this.f762a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.2
                @Override // java.lang.Runnable
                public void run() {
                    C1420a.this.m1117b(perfClientReport);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1116b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f758a;
        if (iEventProcessor != null) {
            iEventProcessor.mo1142a(eventClientReport);
            if (m1106a() >= 10) {
                m1119d();
                C1470ad.m1444a(this.f756a).m1455a("100888");
            } else {
                m1113a(new C1470ad.a() { // from class: com.xiaomi.clientreport.manager.a.3
                    @Override // com.xiaomi.push.C1470ad.a
                    /* renamed from: a */
                    public String mo1133a() {
                        return "100888";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (C1420a.this.m1106a() > 0) {
                            C1420a.this.f762a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    C1420a.this.m1119d();
                                }
                            });
                        }
                    }
                }, f754a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1117b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f759a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo1142a(perfClientReport);
            if (m1114b() >= 10) {
                m1120e();
                C1470ad.m1444a(this.f756a).m1455a("100889");
            } else {
                m1113a(new C1470ad.a() { // from class: com.xiaomi.clientreport.manager.a.4
                    @Override // com.xiaomi.push.C1470ad.a
                    /* renamed from: a */
                    public String mo1133a() {
                        return "100889";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (C1420a.this.m1114b() > 0) {
                            C1420a.this.f762a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    C1420a.this.m1120e();
                                }
                            });
                        }
                    }
                }, f754a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m1119d() {
        try {
            this.f758a.mo1145b();
        } catch (Exception e) {
            AbstractC1417b.m1103d("we: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m1120e() {
        try {
            this.f759a.mo1145b();
        } catch (Exception e) {
            AbstractC1417b.m1103d("wp: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m1106a() {
        HashMap<String, ArrayList<C1419a>> hashMap = this.f763b;
        if (hashMap == null) {
            return 0;
        }
        Iterator<String> it = hashMap.keySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            ArrayList<C1419a> arrayList = this.f763b.get(it.next());
            i += arrayList != null ? arrayList.size() : 0;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m1114b() {
        HashMap<String, HashMap<String, C1419a>> hashMap = this.f761a;
        int i = 0;
        if (hashMap != null) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, C1419a> hashMap2 = this.f761a.get(it.next());
                if (hashMap2 != null) {
                    Iterator<String> it2 = hashMap2.keySet().iterator();
                    while (it2.hasNext()) {
                        C1419a c1419a = hashMap2.get(it2.next());
                        if (c1419a instanceof PerfClientReport) {
                            i = (int) (i + ((PerfClientReport) c1419a).perfCounts);
                        }
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: b */
    public void m1131b() {
        if (m1123a().isEventUploadSwitchOpen()) {
            RunnableC1503bj runnableC1503bj = new RunnableC1503bj();
            runnableC1503bj.m1661a(this.f756a);
            runnableC1503bj.m1662a(this.f758a);
            this.f762a.execute(runnableC1503bj);
        }
    }

    /* renamed from: c */
    public void m1132c() {
        if (m1123a().isPerfUploadSwitchOpen()) {
            RunnableC1503bj runnableC1503bj = new RunnableC1503bj();
            runnableC1503bj.m1662a(this.f759a);
            runnableC1503bj.m1661a(this.f756a);
            this.f762a.execute(runnableC1503bj);
        }
    }

    /* renamed from: f */
    private void m1121f() {
        if (m1108a(this.f756a).m1123a().isEventUploadSwitchOpen()) {
            final C1501bh c1501bh = new C1501bh(this.f756a);
            int eventUploadFrequency = (int) m1108a(this.f756a).m1123a().getEventUploadFrequency();
            if (eventUploadFrequency < 1800) {
                eventUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - C1505bl.m1672a(this.f756a).m1673a("sp_client_report_status", "event_last_upload_time", 0L) > eventUploadFrequency * 1000) {
                C1470ad.m1444a(this.f756a).m1450a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        c1501bh.run();
                    }
                }, 10);
            }
            synchronized (C1420a.class) {
                if (!C1470ad.m1444a(this.f756a).m1452a((C1470ad.a) c1501bh, eventUploadFrequency)) {
                    C1470ad.m1444a(this.f756a).m1455a("100886");
                    C1470ad.m1444a(this.f756a).m1452a((C1470ad.a) c1501bh, eventUploadFrequency);
                }
            }
        }
    }

    /* renamed from: g */
    private void m1122g() {
        if (m1108a(this.f756a).m1123a().isPerfUploadSwitchOpen()) {
            final C1502bi c1502bi = new C1502bi(this.f756a);
            int perfUploadFrequency = (int) m1108a(this.f756a).m1123a().getPerfUploadFrequency();
            if (perfUploadFrequency < 1800) {
                perfUploadFrequency = 1800;
            }
            if (System.currentTimeMillis() - C1505bl.m1672a(this.f756a).m1673a("sp_client_report_status", "perf_last_upload_time", 0L) > perfUploadFrequency * 1000) {
                C1470ad.m1444a(this.f756a).m1450a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c1502bi.run();
                    }
                }, 15);
            }
            synchronized (C1420a.class) {
                if (!C1470ad.m1444a(this.f756a).m1452a((C1470ad.a) c1502bi, perfUploadFrequency)) {
                    C1470ad.m1444a(this.f756a).m1455a("100887");
                    C1470ad.m1444a(this.f756a).m1452a((C1470ad.a) c1502bi, perfUploadFrequency);
                }
            }
        }
    }

    /* renamed from: a */
    public EventClientReport m1124a(int i, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i;
        eventClientReport.eventId = C1494ba.m1624a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f756a.getPackageName());
        eventClientReport.setSdkVersion(this.f760a);
        return eventClientReport;
    }
}
