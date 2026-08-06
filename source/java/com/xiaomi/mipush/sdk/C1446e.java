package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.EnumC1638gj;
import com.xiaomi.push.service.C1750ah;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.mipush.sdk.e */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1446e implements AbstractPushManager {

    /* renamed from: a */
    private static volatile C1446e f841a;

    /* renamed from: a */
    private Context f842a;

    /* renamed from: a */
    private PushConfiguration f843a;

    /* renamed from: a */
    private boolean f845a = false;

    /* renamed from: a */
    private Map<EnumC1445d, AbstractPushManager> f844a = new HashMap();

    private C1446e(Context context) {
        this.f842a = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C1446e m1264a(Context context) {
        if (f841a == null) {
            synchronized (C1446e.class) {
                if (f841a == null) {
                    f841a = new C1446e(context);
                }
            }
        }
        return f841a;
    }

    /* renamed from: a */
    public void m1269a(PushConfiguration pushConfiguration) {
        this.f843a = pushConfiguration;
        this.f845a = C1750ah.m3674a(this.f842a).m3686a(EnumC1638gj.AggregatePushSwitch.m2760a(), true);
        if (this.f843a.getOpenHmsPush() || this.f843a.getOpenFCMPush() || this.f843a.getOpenCOSPush() || this.f843a.getOpenFTOSPush()) {
            C1750ah.m3674a(this.f842a).m3683a(new C1750ah.a(101, "assemblePush") { // from class: com.xiaomi.mipush.sdk.e.1
                @Override // com.xiaomi.push.service.C1750ah.a
                protected void onCallback() {
                    boolean m3686a = C1750ah.m3674a(C1446e.this.f842a).m3686a(EnumC1638gj.AggregatePushSwitch.m2760a(), true);
                    if (C1446e.this.f845a != m3686a) {
                        C1446e.this.f845a = m3686a;
                        C1447f.m1294b(C1446e.this.f842a);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m1271a(EnumC1445d enumC1445d, AbstractPushManager abstractPushManager) {
        if (abstractPushManager != null) {
            if (this.f844a.containsKey(enumC1445d)) {
                this.f844a.remove(enumC1445d);
            }
            this.f844a.put(enumC1445d, abstractPushManager);
        }
    }

    /* renamed from: a */
    public void m1270a(EnumC1445d enumC1445d) {
        this.f844a.remove(enumC1445d);
    }

    /* renamed from: a */
    public boolean m1272a(EnumC1445d enumC1445d) {
        return this.f844a.containsKey(enumC1445d);
    }

    /* renamed from: a */
    public AbstractPushManager m1268a(EnumC1445d enumC1445d) {
        return this.f844a.get(enumC1445d);
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void register() {
        AbstractC1417b.m1089a("ASSEMBLE_PUSH : assemble push register");
        if (this.f844a.size() <= 0) {
            m1265a();
        }
        if (this.f844a.size() > 0) {
            for (AbstractPushManager abstractPushManager : this.f844a.values()) {
                if (abstractPushManager != null) {
                    abstractPushManager.register();
                }
            }
            C1447f.m1282a(this.f842a);
        }
    }

    @Override // com.xiaomi.mipush.sdk.AbstractPushManager
    public void unregister() {
        AbstractC1417b.m1089a("ASSEMBLE_PUSH : assemble push unregister");
        for (AbstractPushManager abstractPushManager : this.f844a.values()) {
            if (abstractPushManager != null) {
                abstractPushManager.unregister();
            }
        }
        this.f844a.clear();
    }

    /* renamed from: a */
    private void m1265a() {
        AbstractPushManager m1268a;
        AbstractPushManager m1268a2;
        AbstractPushManager m1268a3;
        AbstractPushManager m1268a4;
        PushConfiguration pushConfiguration = this.f843a;
        if (pushConfiguration != null) {
            if (pushConfiguration.getOpenHmsPush()) {
                AbstractC1417b.m1089a("ASSEMBLE_PUSH : " + (" HW user switch : " + this.f843a.getOpenHmsPush() + " HW online switch : " + C1447f.m1289a(this.f842a, EnumC1445d.ASSEMBLE_PUSH_HUAWEI) + " HW isSupport : " + C1449h.m1306a(this.f842a)));
            }
            if (this.f843a.getOpenHmsPush() && C1447f.m1289a(this.f842a, EnumC1445d.ASSEMBLE_PUSH_HUAWEI) && C1449h.m1306a(this.f842a)) {
                if (!m1272a(EnumC1445d.ASSEMBLE_PUSH_HUAWEI)) {
                    m1271a(EnumC1445d.ASSEMBLE_PUSH_HUAWEI, C1460s.m1347a(this.f842a, EnumC1445d.ASSEMBLE_PUSH_HUAWEI));
                }
                AbstractC1417b.m1101c("hw manager add to list");
            } else if (m1272a(EnumC1445d.ASSEMBLE_PUSH_HUAWEI) && (m1268a = m1268a(EnumC1445d.ASSEMBLE_PUSH_HUAWEI)) != null) {
                m1270a(EnumC1445d.ASSEMBLE_PUSH_HUAWEI);
                m1268a.unregister();
            }
            if (this.f843a.getOpenFCMPush()) {
                AbstractC1417b.m1089a("ASSEMBLE_PUSH : " + (" FCM user switch : " + this.f843a.getOpenFCMPush() + " FCM online switch : " + C1447f.m1289a(this.f842a, EnumC1445d.ASSEMBLE_PUSH_FCM) + " FCM isSupport : " + C1449h.m1307b(this.f842a)));
            }
            if (this.f843a.getOpenFCMPush() && C1447f.m1289a(this.f842a, EnumC1445d.ASSEMBLE_PUSH_FCM) && C1449h.m1307b(this.f842a)) {
                if (!m1272a(EnumC1445d.ASSEMBLE_PUSH_FCM)) {
                    m1271a(EnumC1445d.ASSEMBLE_PUSH_FCM, C1460s.m1347a(this.f842a, EnumC1445d.ASSEMBLE_PUSH_FCM));
                }
                AbstractC1417b.m1101c("fcm manager add to list");
            } else if (m1272a(EnumC1445d.ASSEMBLE_PUSH_FCM) && (m1268a2 = m1268a(EnumC1445d.ASSEMBLE_PUSH_FCM)) != null) {
                m1270a(EnumC1445d.ASSEMBLE_PUSH_FCM);
                m1268a2.unregister();
            }
            if (this.f843a.getOpenCOSPush()) {
                AbstractC1417b.m1089a("ASSEMBLE_PUSH : " + (" COS user switch : " + this.f843a.getOpenCOSPush() + " COS online switch : " + C1447f.m1289a(this.f842a, EnumC1445d.ASSEMBLE_PUSH_COS) + " COS isSupport : " + C1449h.m1308c(this.f842a)));
            }
            if (this.f843a.getOpenCOSPush() && C1447f.m1289a(this.f842a, EnumC1445d.ASSEMBLE_PUSH_COS) && C1449h.m1308c(this.f842a)) {
                m1271a(EnumC1445d.ASSEMBLE_PUSH_COS, C1460s.m1347a(this.f842a, EnumC1445d.ASSEMBLE_PUSH_COS));
            } else if (m1272a(EnumC1445d.ASSEMBLE_PUSH_COS) && (m1268a3 = m1268a(EnumC1445d.ASSEMBLE_PUSH_COS)) != null) {
                m1270a(EnumC1445d.ASSEMBLE_PUSH_COS);
                m1268a3.unregister();
            }
            if (this.f843a.getOpenFTOSPush() && C1447f.m1289a(this.f842a, EnumC1445d.ASSEMBLE_PUSH_FTOS) && C1449h.m1309d(this.f842a)) {
                m1271a(EnumC1445d.ASSEMBLE_PUSH_FTOS, C1460s.m1347a(this.f842a, EnumC1445d.ASSEMBLE_PUSH_FTOS));
            } else {
                if (!m1272a(EnumC1445d.ASSEMBLE_PUSH_FTOS) || (m1268a4 = m1268a(EnumC1445d.ASSEMBLE_PUSH_FTOS)) == null) {
                    return;
                }
                m1270a(EnumC1445d.ASSEMBLE_PUSH_FTOS);
                m1268a4.unregister();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xiaomi.mipush.sdk.e$2, reason: invalid class name */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a */
        static final /* synthetic */ int[] f847a;

        static {
            int[] iArr = new int[EnumC1445d.values().length];
            f847a = iArr;
            try {
                iArr[EnumC1445d.ASSEMBLE_PUSH_HUAWEI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f847a[EnumC1445d.ASSEMBLE_PUSH_FCM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f847a[EnumC1445d.ASSEMBLE_PUSH_COS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f847a[EnumC1445d.ASSEMBLE_PUSH_FTOS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* renamed from: b */
    public boolean m1273b(EnumC1445d enumC1445d) {
        int i = AnonymousClass2.f847a[enumC1445d.ordinal()];
        boolean z = false;
        if (i == 1) {
            PushConfiguration pushConfiguration = this.f843a;
            if (pushConfiguration != null) {
                return pushConfiguration.getOpenHmsPush();
            }
            return false;
        }
        if (i == 2) {
            PushConfiguration pushConfiguration2 = this.f843a;
            if (pushConfiguration2 != null) {
                return pushConfiguration2.getOpenFCMPush();
            }
            return false;
        }
        if (i == 3) {
            PushConfiguration pushConfiguration3 = this.f843a;
            if (pushConfiguration3 != null) {
                z = pushConfiguration3.getOpenCOSPush();
            }
        } else if (i != 4) {
            return false;
        }
        PushConfiguration pushConfiguration4 = this.f843a;
        return pushConfiguration4 != null ? pushConfiguration4.getOpenFTOSPush() : z;
    }
}
