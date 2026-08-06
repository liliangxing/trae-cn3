package com.xiaomi.push.service;

import android.content.Context;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ss.ttm.player.MediaPlayer;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.xiaomi.push.service.am */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1755am {

    /* renamed from: a */
    private static C1755am f2983a;

    /* renamed from: a */
    private ConcurrentHashMap<String, HashMap<String, b>> f2985a = new ConcurrentHashMap<>();

    /* renamed from: a */
    private List<a> f2984a = new ArrayList();

    /* renamed from: com.xiaomi.push.service.am$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface a {
        /* renamed from: a */
        void mo3565a();
    }

    /* renamed from: com.xiaomi.push.service.am$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public enum c {
        unbind,
        binding,
        binded
    }

    /* renamed from: a */
    public static synchronized C1755am m3702a() {
        C1755am c1755am;
        synchronized (C1755am.class) {
            if (f2983a == null) {
                f2983a = new C1755am();
            }
            c1755am = f2983a;
        }
        return c1755am;
    }

    private C1755am() {
    }

    /* renamed from: a */
    public synchronized void m3713a(b bVar) {
        HashMap<String, b> hashMap = this.f2985a.get(bVar.f3005g);
        if (hashMap == null) {
            hashMap = new HashMap<>();
            this.f2985a.put(bVar.f3005g, hashMap);
        }
        hashMap.put(m3703a(bVar.f2999b), bVar);
        AbstractC1417b.m1089a("add active client. " + bVar.f2995a);
        Iterator<a> it = this.f2984a.iterator();
        while (it.hasNext()) {
            it.next().mo3565a();
        }
    }

    /* renamed from: a */
    public synchronized void m3715a(String str, String str2) {
        HashMap<String, b> hashMap = this.f2985a.get(str);
        if (hashMap != null) {
            b bVar = hashMap.get(m3703a(str2));
            if (bVar != null) {
                bVar.m3727a();
            }
            hashMap.remove(m3703a(str2));
            if (hashMap.isEmpty()) {
                this.f2985a.remove(str);
            }
        }
        Iterator<a> it = this.f2984a.iterator();
        while (it.hasNext()) {
            it.next().mo3565a();
        }
    }

    /* renamed from: a */
    public synchronized void m3714a(String str) {
        HashMap<String, b> hashMap = this.f2985a.get(str);
        if (hashMap != null) {
            Iterator<b> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().m3727a();
            }
            hashMap.clear();
            this.f2985a.remove(str);
        }
        Iterator<a> it2 = this.f2984a.iterator();
        while (it2.hasNext()) {
            it2.next().mo3565a();
        }
    }

    /* renamed from: a */
    public synchronized List<String> m3708a(String str) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<HashMap<String, b>> it = this.f2985a.values().iterator();
        while (it.hasNext()) {
            for (b bVar : it.next().values()) {
                if (str.equals(bVar.f2995a)) {
                    arrayList.add(bVar.f3005g);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized ArrayList<b> m3706a() {
        ArrayList<b> arrayList;
        arrayList = new ArrayList<>();
        Iterator<HashMap<String, b>> it = this.f2985a.values().iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().values());
        }
        return arrayList;
    }

    /* renamed from: a */
    public synchronized Collection<b> m3707a(String str) {
        if (!this.f2985a.containsKey(str)) {
            return new ArrayList();
        }
        return ((HashMap) this.f2985a.get(str).clone()).values();
    }

    /* renamed from: a */
    public synchronized b m3705a(String str, String str2) {
        HashMap<String, b> hashMap = this.f2985a.get(str);
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(m3703a(str2));
    }

    /* renamed from: a */
    public synchronized void m3711a(Context context, int i) {
        Iterator<HashMap<String, b>> it = this.f2985a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().m3730a(c.unbind, 2, i, (String) null, (String) null);
            }
        }
    }

    /* renamed from: a */
    public synchronized int m3704a() {
        return this.f2985a.size();
    }

    /* renamed from: a */
    public synchronized void m3709a() {
        Iterator<b> it = m3706a().iterator();
        while (it.hasNext()) {
            it.next().m3727a();
        }
        this.f2985a.clear();
    }

    /* renamed from: a */
    public synchronized void m3710a(Context context) {
        Iterator<HashMap<String, b>> it = this.f2985a.values().iterator();
        while (it.hasNext()) {
            Iterator<b> it2 = it.next().values().iterator();
            while (it2.hasNext()) {
                it2.next().m3730a(c.unbind, 1, 3, (String) null, (String) null);
            }
        }
    }

    /* renamed from: a */
    private String m3703a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("@");
        return indexOf > 0 ? str.substring(0, indexOf) : str;
    }

    /* renamed from: com.xiaomi.push.service.am$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public static class b {

        /* renamed from: a */
        public Context f2987a;

        /* renamed from: a */
        Messenger f2989a;

        /* renamed from: a */
        private XMPushService f2991a;

        /* renamed from: a */
        public C1779h f2994a;

        /* renamed from: a */
        public String f2995a;

        /* renamed from: a */
        public boolean f2997a;

        /* renamed from: b */
        public String f2999b;

        /* renamed from: c */
        public String f3001c;

        /* renamed from: d */
        public String f3002d;

        /* renamed from: e */
        public String f3003e;

        /* renamed from: f */
        public String f3004f;

        /* renamed from: g */
        public String f3005g;

        /* renamed from: h */
        public String f3006h;

        /* renamed from: i */
        public String f3007i;

        /* renamed from: a */
        c f2993a = c.unbind;

        /* renamed from: a */
        private int f2986a = 0;

        /* renamed from: a */
        private final CopyOnWriteArrayList<a> f2996a = new CopyOnWriteArrayList<>();

        /* renamed from: b */
        c f2998b = null;

        /* renamed from: b */
        private boolean f3000b = false;

        /* renamed from: a */
        private XMPushService.C1724c f2990a = new XMPushService.C1724c(this);

        /* renamed from: a */
        IBinder.DeathRecipient f2988a = null;

        /* renamed from: a */
        final C1853b f2992a = new C1853b();

        /* renamed from: com.xiaomi.push.service.am$b$a */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public interface a {
            /* renamed from: a */
            void mo2388a(c cVar, c cVar2, int i);
        }

        /* renamed from: a */
        public String m3726a(int i) {
            return i != 1 ? i != 2 ? i != 3 ? "unknown" : "KICK" : "CLOSE" : "OPEN";
        }

        public b() {
        }

        public b(XMPushService xMPushService) {
            this.f2991a = xMPushService;
            m3729a(new a() { // from class: com.xiaomi.push.service.am.b.1
                @Override // com.xiaomi.push.service.C1755am.b.a
                /* renamed from: a */
                public void mo2388a(c cVar, c cVar2, int i) {
                    if (cVar2 == c.binding) {
                        b.this.f2991a.m3549a(b.this.f2990a, 60000L);
                    } else {
                        b.this.f2991a.m3561b(b.this.f2990a);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.xiaomi.push.service.am$b$c */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public class c implements IBinder.DeathRecipient {

            /* renamed from: a */
            final Messenger f3014a;

            /* renamed from: a */
            final b f3015a;

            c(b bVar, Messenger messenger) {
                this.f3015a = bVar;
                this.f3014a = messenger;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                AbstractC1417b.m1098b("peer died, chid = " + this.f3015a.f3005g);
                int i = 0;
                b.this.f2991a.m3549a(new XMPushService.AbstractC1731j(i) { // from class: com.xiaomi.push.service.am.b.c.1
                    @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
                    /* renamed from: a */
                    public String mo2389a() {
                        return "clear peer job";
                    }

                    @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
                    /* renamed from: a */
                    public void mo2390a() {
                        if (c.this.f3014a == c.this.f3015a.f2989a) {
                            AbstractC1417b.m1098b("clean peer, chid = " + c.this.f3015a.f3005g);
                            c.this.f3015a.f2989a = null;
                        }
                    }
                }, 0L);
                if ("9".equals(this.f3015a.f3005g) && "com.xiaomi.xmsf".equals(b.this.f2991a.getPackageName())) {
                    b.this.f2991a.m3549a(new XMPushService.AbstractC1731j(i) { // from class: com.xiaomi.push.service.am.b.c.2
                        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
                        /* renamed from: a */
                        public String mo2389a() {
                            return "check peer job";
                        }

                        @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
                        /* renamed from: a */
                        public void mo2390a() {
                            if (C1755am.m3702a().m3705a(c.this.f3015a.f3005g, c.this.f3015a.f2999b).f2989a == null) {
                                b.this.f2991a.m3552a(c.this.f3015a.f3005g, c.this.f3015a.f2999b, 2, null, null);
                            }
                        }
                    }, 60000L);
                }
            }
        }

        /* renamed from: a */
        void m3727a() {
            try {
                Messenger messenger = this.f2989a;
                if (messenger != null && this.f2988a != null) {
                    messenger.getBinder().unlinkToDeath(this.f2988a, 0);
                }
            } catch (Exception unused) {
            }
            this.f2998b = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public void m3728a(Messenger messenger) {
            m3727a();
            try {
                if (messenger != null) {
                    this.f2989a = messenger;
                    this.f3000b = true;
                    this.f2988a = new c(this, messenger);
                    messenger.getBinder().linkToDeath(this.f2988a, 0);
                } else {
                    AbstractC1417b.m1098b("peer linked with old sdk chid = " + this.f3005g);
                }
            } catch (Exception e) {
                AbstractC1417b.m1098b("peer linkToDeath err: " + e.getMessage());
                this.f2989a = null;
                this.f3000b = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.xiaomi.push.service.am$b$b, reason: collision with other inner class name */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
        public class C1853b extends XMPushService.AbstractC1731j {

            /* renamed from: a */
            String f3010a;

            /* renamed from: b */
            int f3011b;

            /* renamed from: b */
            String f3012b;

            /* renamed from: c */
            int f3013c;

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public String mo2389a() {
                return "notify job";
            }

            public C1853b() {
                super(0);
            }

            @Override // com.xiaomi.push.service.XMPushService.AbstractC1731j
            /* renamed from: a */
            public void mo2390a() {
                if (b.this.m3722a(this.f3011b, this.f3013c, this.f3012b)) {
                    b.this.m3720a(this.f3011b, this.f3013c, this.f3010a, this.f3012b);
                } else {
                    AbstractC1417b.m1098b(" ignore notify client :" + b.this.f3005g);
                }
            }

            /* renamed from: a */
            public XMPushService.AbstractC1731j m3732a(int i, int i2, String str, String str2) {
                this.f3011b = i;
                this.f3013c = i2;
                this.f3012b = str2;
                this.f3010a = str;
                return this;
            }
        }

        /* renamed from: a */
        public void m3730a(c cVar, int i, int i2, String str, String str2) {
            boolean z;
            Iterator<a> it = this.f2996a.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.mo2388a(this.f2993a, cVar, i2);
                }
            }
            c cVar2 = this.f2993a;
            int i3 = 0;
            if (cVar2 != cVar) {
                AbstractC1417b.m1089a(String.format("update the client %7$s status. %1$s->%2$s %3$s %4$s %5$s %6$s", cVar2, cVar, m3726a(i), AbstractC1756an.m3733a(i2), str, str2, this.f3005g));
                this.f2993a = cVar;
            }
            if (this.f2994a == null) {
                AbstractC1417b.m1103d("status changed while the client dispatcher is missing");
                return;
            }
            if (cVar == c.binding) {
                return;
            }
            if (this.f2998b != null && (z = this.f3000b)) {
                i3 = (this.f2989a == null || !z) ? MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_OUTLET_DB_VALUE : 1000;
            }
            this.f2991a.m3561b(this.f2992a);
            if (m3724b(i, i2, str2)) {
                m3720a(i, i2, str, str2);
            } else {
                this.f2991a.m3549a(this.f2992a.m3732a(i, i2, str, str2), i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m3720a(int i, int i2, String str, String str2) {
            c cVar = this.f2993a;
            this.f2998b = cVar;
            if (i == 2) {
                this.f2994a.m3854a(this.f2987a, this, i2);
                return;
            }
            if (i == 3) {
                this.f2994a.m3855a(this.f2987a, this, str2, str);
                return;
            }
            if (i == 1) {
                boolean z = cVar == c.binded;
                if (!z && "wait".equals(str2)) {
                    this.f2986a++;
                } else if (z) {
                    this.f2986a = 0;
                    if (this.f2989a != null) {
                        try {
                            this.f2989a.send(Message.obtain(null, 16, this.f2991a.f2864a));
                        } catch (RemoteException unused) {
                        }
                    }
                }
                this.f2994a.m3856a(this.f2991a, this, z, i2, str);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public boolean m3722a(int i, int i2, String str) {
            boolean z;
            c cVar = this.f2998b;
            if (cVar == null || !(z = this.f3000b)) {
                return true;
            }
            if (cVar == this.f2993a) {
                AbstractC1417b.m1098b(" status recovered, don't notify client:" + this.f3005g);
                return false;
            }
            if (this.f2989a != null && z) {
                AbstractC1417b.m1098b("Peer alive notify status to client:" + this.f3005g);
                return true;
            }
            AbstractC1417b.m1098b("peer died, ignore notify " + this.f3005g);
            return false;
        }

        /* renamed from: b */
        private boolean m3724b(int i, int i2, String str) {
            if (i == 1) {
                return (this.f2993a == c.binded || !this.f2991a.m3563c() || i2 == 21 || (i2 == 7 && "wait".equals(str))) ? false : true;
            }
            if (i == 2) {
                return this.f2991a.m3563c();
            }
            if (i != 3) {
                return false;
            }
            return !"wait".equals(str);
        }

        /* renamed from: a */
        public void m3729a(a aVar) {
            this.f2996a.add(aVar);
        }

        /* renamed from: b */
        public void m3731b(a aVar) {
            this.f2996a.remove(aVar);
        }

        /* renamed from: a */
        public long m3725a() {
            return (((long) ((Math.random() * 20.0d) - 10.0d)) + ((this.f2986a + 1) * 15)) * 1000;
        }

        /* renamed from: a */
        public static String m3719a(String str) {
            int lastIndexOf;
            return (TextUtils.isEmpty(str) || (lastIndexOf = str.lastIndexOf("/")) == -1) ? "" : str.substring(lastIndexOf + 1);
        }
    }

    /* renamed from: a */
    public synchronized void m3712a(a aVar) {
        this.f2984a.add(aVar);
    }

    /* renamed from: b */
    public synchronized void m3716b() {
        this.f2984a.clear();
    }
}
