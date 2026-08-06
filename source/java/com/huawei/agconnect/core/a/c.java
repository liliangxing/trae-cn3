package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class c {
    private final Context a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context) {
        this.a = context;
    }

    private <T extends ServiceRegistrar> T a(String str) {
        StringBuilder sb;
        String localizedMessage;
        StringBuilder append;
        try {
            Class<?> cls = Class.forName(str);
            if (ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            Log.e("AGC_Registrar", cls + " must extends from ServiceRegistrar.");
            return null;
        } catch (ClassNotFoundException e) {
            append = new StringBuilder("Can not found service class, ").append(e.getMessage());
            Log.e("AGC_Registrar", append.toString());
            return null;
        } catch (IllegalAccessException e2) {
            sb = new StringBuilder("instantiate service class exception ");
            localizedMessage = e2.getLocalizedMessage();
            append = sb.append(localizedMessage);
            Log.e("AGC_Registrar", append.toString());
            return null;
        } catch (InstantiationException e3) {
            sb = new StringBuilder("instantiate service class exception ");
            localizedMessage = e3.getLocalizedMessage();
            append = sb.append(localizedMessage);
            Log.e("AGC_Registrar", append.toString());
            return null;
        }
    }

    private List<String> b() {
        StringBuilder sb;
        ArrayList arrayList = new ArrayList();
        Bundle c = c();
        if (c == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap(10);
        for (String str : c.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(c.getString(str))) {
                String[] split = str.split(Constants.COLON_SEPARATOR);
                if (split.length == 2) {
                    try {
                        hashMap.put(split[0], Integer.valueOf(split[1]));
                    } catch (NumberFormatException e) {
                        sb = new StringBuilder("registrar configuration format error:");
                        str = e.getMessage();
                    }
                } else if (split.length == 1) {
                    hashMap.put(split[0], 1000);
                } else {
                    sb = new StringBuilder("registrar configuration error, ");
                    Log.e("AGC_Registrar", sb.append(str).toString());
                }
            }
        }
        ArrayList arrayList2 = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList2, new a());
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(((Map.Entry) it.next()).getKey());
        }
        return arrayList;
    }

    private Bundle c() {
        ServiceInfo serviceInfo;
        PackageManager packageManager = this.a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new ComponentName(this.a, (Class<?>) ServiceDiscovery.class), 128);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("AGC_Registrar", "get ServiceDiscovery exception." + e.getLocalizedMessage());
        }
        if (serviceInfo != null) {
            return serviceInfo.metaData;
        }
        Log.e("AGC_Registrar", "Can not found ServiceDiscovery service.");
        return null;
    }

    public List<Service> a() {
        Log.i("AGC_Registrar", "getServices");
        List<String> b = b();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = b.iterator();
        while (it.hasNext()) {
            ServiceRegistrar a2 = a(it.next());
            if (a2 != null) {
                a2.initialize(this.a);
                List<Service> services = a2.getServices(this.a);
                if (services != null) {
                    arrayList.addAll(services);
                }
            }
        }
        Log.i("AGC_Registrar", "services:" + arrayList.size());
        return arrayList;
    }
}
