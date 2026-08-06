package com.xiaomi.push.service;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C1486at;
import com.xiaomi.push.C1571dx;
import com.xiaomi.push.C1612fk;
import com.xiaomi.push.C1613fl;
import com.xiaomi.push.C1614fm;
import com.xiaomi.push.C1617fp;
import com.xiaomi.push.C1624fw;
import com.xiaomi.push.C1694j;
import com.xiaomi.push.C1702q;
import com.xiaomi.push.C1802w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.http.NameValuePair;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ServiceClient {

    /* renamed from: a */
    private static ServiceClient f2843a;

    /* renamed from: a */
    private static String f2844a;

    /* renamed from: a */
    private Context f2847a;

    /* renamed from: a */
    private boolean f2850a;

    /* renamed from: b */
    private Messenger f2851b;

    /* renamed from: b */
    private static String f2845b = C1624fw.m2646a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: a */
    private static long f2842a = 0;

    /* renamed from: a */
    private Messenger f2848a = null;

    /* renamed from: a */
    private final BroadcastReceiver f2846a = new BroadcastReceiver() { // from class: com.xiaomi.push.service.ServiceClient.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            C1486at.m1543a();
        }
    };

    /* renamed from: a */
    private List<Message> f2849a = new ArrayList();

    /* renamed from: b */
    private boolean f2852b = false;

    public static ServiceClient getInstance(Context context) {
        if (f2843a == null) {
            f2843a = new ServiceClient(context);
        }
        return f2843a;
    }

    public boolean isMiuiPushServiceEnabled() {
        return this.f2850a;
    }

    private ServiceClient(Context context) {
        this.f2850a = false;
        Context applicationContext = context.getApplicationContext();
        this.f2847a = applicationContext;
        C1702q.m3465a(applicationContext);
        m3489a(this.f2847a);
        if (m3492a()) {
            AbstractC1417b.m1101c("use miui push service");
            this.f2850a = true;
        }
    }

    /* renamed from: a */
    private void m3489a(Context context) {
        try {
            C1486at.m1534a(context);
        } catch (Throwable th) {
            AbstractC1417b.m1089a("add network status listener failed:" + th);
        }
    }

    public void setMessenger(Messenger messenger) {
        this.f2848a = messenger;
    }

    /* renamed from: a */
    private Map<String, String> m3487a(List<NameValuePair> list) {
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (NameValuePair nameValuePair : list) {
                if (nameValuePair != null) {
                    hashMap.put(nameValuePair.getName(), nameValuePair.getValue());
                }
            }
        }
        return hashMap;
    }

    @Deprecated
    public int openChannel(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return openChannel(str, str2, str3, str4, str5, m3487a(list), m3487a(list2), z);
    }

    public int openChannel(String str, String str2, String str3, String str4, String str5, Map<String, String> map, Map<String, String> map2, boolean z) {
        Intent m3480a = m3480a();
        m3480a.setAction(AbstractC1756an.f3044d);
        m3491a(m3480a, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(m3480a);
        return 0;
    }

    public boolean sendMessage(C1614fm c1614fm, boolean z) {
        if (!C1486at.m1545a(this.f2847a)) {
            return false;
        }
        Intent m3480a = m3480a();
        String m2323a = C1571dx.m2323a();
        if (!TextUtils.isEmpty(m2323a)) {
            C1612fk c1612fk = new C1612fk("pf", null, null, null);
            C1612fk c1612fk2 = new C1612fk("sent", null, null, null);
            c1612fk2.m2569a(m2323a);
            c1612fk.m2568a(c1612fk2);
            c1614fm.m2607a(c1612fk);
        }
        Bundle mo2573a = c1614fm.mo2573a();
        if (mo2573a == null) {
            return false;
        }
        AbstractC1417b.m1101c("SEND:" + c1614fm.mo2575a());
        m3480a.setAction(AbstractC1756an.f3045e);
        m3480a.putExtra(AbstractC1756an.f3032J, f2844a);
        m3480a.putExtra("ext_packet", mo2573a);
        m3480a.putExtra("ext_encrypt", z);
        return startServiceSafely(m3480a);
    }

    public boolean notifyMessage(Bundle bundle, String str, String str2) {
        if (bundle == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AbstractC1417b.m1089a("Failed to notify message: bundle|userId|chid may be empty");
            return false;
        }
        Intent m3480a = m3480a();
        if (bundle == null) {
            return false;
        }
        m3480a.setAction(AbstractC1756an.f3055o);
        m3480a.putExtras(bundle);
        AbstractC1417b.m1105e("notify: chid=" + str2 + " bundle:" + bundle);
        return startServiceSafely(m3480a);
    }

    public boolean sendMessage(byte[] bArr, String str, String str2) {
        String str3;
        if (!C1486at.m1545a(this.f2847a) || bArr == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AbstractC1417b.m1089a("Failed to send message: message|userId|chid may be empty, or the network is unavailable.");
            return false;
        }
        Intent m3480a = m3480a();
        if (bArr == null) {
            return false;
        }
        m3480a.setAction(AbstractC1756an.f3045e);
        m3480a.putExtra(AbstractC1756an.f3032J, f2844a);
        m3480a.putExtra("ext_raw_packet", bArr);
        int indexOf = str.indexOf("@");
        String str4 = null;
        String substring = indexOf != -1 ? str.substring(0, indexOf) : null;
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf != -1) {
            str4 = str.substring(indexOf + 1, lastIndexOf);
            str3 = str.substring(lastIndexOf + 1);
        } else {
            str3 = null;
        }
        m3480a.putExtra(AbstractC1756an.f3059s, substring);
        m3480a.putExtra(AbstractC1756an.f3060t, str4);
        m3480a.putExtra(AbstractC1756an.f3061u, str3);
        StringBuilder append = new StringBuilder().append(f2845b);
        long j = f2842a;
        f2842a = 1 + j;
        String sb = append.append(j).toString();
        m3480a.putExtra("ext_pkt_id", sb);
        m3480a.putExtra("ext_chid", str2);
        AbstractC1417b.m1105e("SEND: chid=" + str2 + ", packetId=" + sb);
        return startServiceSafely(m3480a);
    }

    public boolean batchSendMessage(C1614fm[] c1614fmArr, boolean z) {
        if (!C1486at.m1545a(this.f2847a)) {
            return false;
        }
        Intent m3480a = m3480a();
        int length = c1614fmArr.length;
        Bundle[] bundleArr = new Bundle[length];
        for (int i = 0; i < c1614fmArr.length; i++) {
            String m2323a = C1571dx.m2323a();
            if (!TextUtils.isEmpty(m2323a)) {
                C1612fk c1612fk = new C1612fk("pf", null, null, null);
                C1612fk c1612fk2 = new C1612fk("sent", null, null, null);
                c1612fk2.m2569a(m2323a);
                c1612fk.m2568a(c1612fk2);
                c1614fmArr[i].m2607a(c1612fk);
            }
            AbstractC1417b.m1101c("SEND:" + c1614fmArr[i].mo2575a());
            bundleArr[i] = c1614fmArr[i].mo2573a();
        }
        if (length <= 0) {
            return false;
        }
        m3480a.setAction(AbstractC1756an.f3047g);
        m3480a.putExtra(AbstractC1756an.f3032J, f2844a);
        m3480a.putExtra("ext_packets", bundleArr);
        m3480a.putExtra("ext_encrypt", z);
        return startServiceSafely(m3480a);
    }

    public boolean sendIQ(C1613fl c1613fl) {
        if (!C1486at.m1545a(this.f2847a)) {
            return false;
        }
        Intent m3480a = m3480a();
        Bundle mo2573a = c1613fl.mo2573a();
        if (mo2573a == null) {
            return false;
        }
        AbstractC1417b.m1101c("SEND:" + c1613fl.mo2575a());
        m3480a.setAction(AbstractC1756an.f3046f);
        m3480a.putExtra(AbstractC1756an.f3032J, f2844a);
        m3480a.putExtra("ext_packet", mo2573a);
        return startServiceSafely(m3480a);
    }

    public boolean sendPresence(C1617fp c1617fp) {
        if (!C1486at.m1545a(this.f2847a)) {
            return false;
        }
        Intent m3480a = m3480a();
        Bundle mo2573a = c1617fp.mo2573a();
        if (mo2573a == null) {
            return false;
        }
        AbstractC1417b.m1101c("SEND:" + c1617fp.mo2575a());
        m3480a.setAction(AbstractC1756an.f3048h);
        m3480a.putExtra(AbstractC1756an.f3032J, f2844a);
        m3480a.putExtra("ext_packet", mo2573a);
        return startServiceSafely(m3480a);
    }

    public boolean closeChannel() {
        Intent m3480a = m3480a();
        m3480a.setAction(AbstractC1756an.f3049i);
        return startServiceSafely(m3480a);
    }

    public boolean closeChannel(String str) {
        Intent m3480a = m3480a();
        m3480a.setAction(AbstractC1756an.f3049i);
        m3480a.putExtra(AbstractC1756an.f3062v, str);
        return startServiceSafely(m3480a);
    }

    public boolean closeChannel(String str, String str2) {
        Intent m3480a = m3480a();
        m3480a.setAction(AbstractC1756an.f3049i);
        m3480a.putExtra(AbstractC1756an.f3062v, str);
        m3480a.putExtra(AbstractC1756an.f3059s, str2);
        return startServiceSafely(m3480a);
    }

    @Deprecated
    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        return forceReconnection(str, str2, str3, str4, str5, z, m3487a(list), m3487a(list2));
    }

    public boolean forceReconnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent m3480a = m3480a();
        m3480a.setAction(AbstractC1756an.f3050j);
        m3491a(m3480a, str, str2, str3, str4, str5, z, map, map2);
        return startServiceSafely(m3480a);
    }

    @Deprecated
    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, List<NameValuePair> list, List<NameValuePair> list2) {
        resetConnection(str, str2, str3, str4, str5, z, m3487a(list), m3487a(list2));
    }

    public void resetConnection(String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        Intent m3480a = m3480a();
        m3480a.setAction(AbstractC1756an.f3051k);
        m3491a(m3480a, str, str2, str3, str4, str5, z, map, map2);
        startServiceSafely(m3480a);
    }

    @Deprecated
    public void updateChannelInfo(String str, List<NameValuePair> list, List<NameValuePair> list2) {
        updateChannelInfo(str, m3487a(list), m3487a(list2));
    }

    public void updateChannelInfo(String str, Map<String, String> map, Map<String, String> map2) {
        Intent m3480a = m3480a();
        m3480a.setAction(AbstractC1756an.f3052l);
        if (map != null) {
            String m3485a = m3485a(map);
            if (!TextUtils.isEmpty(m3485a)) {
                m3480a.putExtra(AbstractC1756an.f3026D, m3485a);
            }
        }
        if (map2 != null) {
            String m3485a2 = m3485a(map2);
            if (!TextUtils.isEmpty(m3485a2)) {
                m3480a.putExtra(AbstractC1756an.f3027E, m3485a2);
            }
        }
        m3480a.putExtra(AbstractC1756an.f3062v, str);
        startServiceSafely(m3480a);
    }

    /* renamed from: a */
    private void m3491a(Intent intent, String str, String str2, String str3, String str4, String str5, boolean z, Map<String, String> map, Map<String, String> map2) {
        intent.putExtra(AbstractC1756an.f3059s, str);
        intent.putExtra(AbstractC1756an.f3062v, str2);
        intent.putExtra(AbstractC1756an.f3066z, str3);
        intent.putExtra(AbstractC1756an.f3024B, str5);
        intent.putExtra(AbstractC1756an.f3023A, str4);
        intent.putExtra(AbstractC1756an.f3025C, z);
        intent.putExtra(AbstractC1756an.f3032J, f2844a);
        intent.putExtra(AbstractC1756an.f3036N, this.f2848a);
        if (map != null && map.size() > 0) {
            String m3485a = m3485a(map);
            if (!TextUtils.isEmpty(m3485a)) {
                intent.putExtra(AbstractC1756an.f3026D, m3485a);
            }
        }
        if (map2 == null || map2.size() <= 0) {
            return;
        }
        String m3485a2 = m3485a(map2);
        if (TextUtils.isEmpty(m3485a2)) {
            return;
        }
        intent.putExtra(AbstractC1756an.f3027E, m3485a2);
    }

    /* renamed from: a */
    private String m3485a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(Constants.COLON_SEPARATOR).append(entry.getValue());
            if (i < map.size()) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            i++;
        }
        return sb.toString();
    }

    /* renamed from: a */
    private boolean m3492a() {
        if (C1802w.f3273a) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.f2847a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    private String m3484a() {
        try {
            return this.f2847a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    /* renamed from: a */
    private Intent m3480a() {
        if (isMiuiPushServiceEnabled()) {
            Intent intent = new Intent();
            intent.setPackage("com.xiaomi.xmsf");
            intent.setClassName("com.xiaomi.xmsf", m3484a());
            intent.putExtra(AbstractC1756an.f3028F, this.f2847a.getPackageName());
            m3488a();
            return intent;
        }
        Intent intent2 = new Intent(this.f2847a, (Class<?>) XMPushService.class);
        intent2.putExtra(AbstractC1756an.f3028F, this.f2847a.getPackageName());
        m3494b();
        return intent2;
    }

    public static String getSession() {
        return f2844a;
    }

    public static void setSession(String str) {
        f2844a = str;
    }

    /* renamed from: a */
    private void m3488a() {
        this.f2847a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f2847a, (Class<?>) XMPushService.class), 2, 1);
    }

    /* renamed from: b */
    private void m3494b() {
        this.f2847a.getPackageManager().setComponentEnabledSetting(new ComponentName(this.f2847a, (Class<?>) XMPushService.class), 1, 1);
    }

    public void checkAlive() {
        Intent m3480a = m3480a();
        m3480a.setAction("com.xiaomi.push.check_alive");
        startServiceSafely(m3480a);
    }

    public boolean startServiceSafely(Intent intent) {
        try {
            if (!C1694j.m3426a() && Build.VERSION.SDK_INT >= 26) {
                m3490a(intent);
                return true;
            }
            this.f2847a.startService(intent);
            return true;
        } catch (Exception e) {
            AbstractC1417b.m1093a(e);
            return false;
        }
    }

    /* renamed from: a */
    private synchronized void m3490a(Intent intent) {
        if (this.f2852b) {
            Message m3481a = m3481a(intent);
            if (this.f2849a.size() >= 50) {
                this.f2849a.remove(0);
            }
            this.f2849a.add(m3481a);
            return;
        }
        if (this.f2851b == null) {
            this.f2847a.bindService(intent, new ServiceConnection() { // from class: com.xiaomi.push.service.ServiceClient.2
                @Override // android.content.ServiceConnection
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    synchronized (ServiceClient.this) {
                        ServiceClient.this.f2851b = new Messenger(iBinder);
                        ServiceClient.this.f2852b = false;
                        Iterator it = ServiceClient.this.f2849a.iterator();
                        while (it.hasNext()) {
                            try {
                                ServiceClient.this.f2851b.send((Message) it.next());
                            } catch (RemoteException e) {
                                AbstractC1417b.m1093a(e);
                            }
                        }
                        ServiceClient.this.f2849a.clear();
                    }
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    ServiceClient.this.f2851b = null;
                    ServiceClient.this.f2852b = false;
                }
            }, 1);
            this.f2852b = true;
            this.f2849a.clear();
            this.f2849a.add(m3481a(intent));
        } else {
            try {
                this.f2851b.send(m3481a(intent));
            } catch (RemoteException unused) {
                this.f2851b = null;
                this.f2852b = false;
            }
        }
    }

    /* renamed from: a */
    private Message m3481a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }
}
