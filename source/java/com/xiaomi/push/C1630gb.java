package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC1417b;
import com.xiaomi.push.service.C1768az;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.xiaomi.push.gb */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1630gb {
    /* renamed from: a */
    public static void m2705a(Context context, InterfaceC1632gd interfaceC1632gd, List<C1637gi> list) {
        HashMap<String, ArrayList<C1637gi>> m2703a = m2703a(context, list);
        if (m2703a == null || m2703a.size() == 0) {
            AbstractC1417b.m1089a("TinyData TinyDataCacheUploader.uploadTinyData itemsUploading == null || itemsUploading.size() == 0  ts:" + System.currentTimeMillis());
        } else {
            m2704a(context, interfaceC1632gd, m2703a);
        }
    }

    /* renamed from: a */
    private static HashMap<String, ArrayList<C1637gi>> m2703a(Context context, List<C1637gi> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        HashMap<String, ArrayList<C1637gi>> hashMap = new HashMap<>();
        for (C1637gi c1637gi : list) {
            m2706a(context, c1637gi);
            ArrayList<C1637gi> arrayList = hashMap.get(c1637gi.m2743c());
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                hashMap.put(c1637gi.m2743c(), arrayList);
            }
            arrayList.add(c1637gi);
        }
        return hashMap;
    }

    /* renamed from: a */
    private static void m2706a(Context context, C1637gi c1637gi) {
        if (c1637gi.f1980a) {
            c1637gi.m2727a("push_sdk_channel");
        }
        if (TextUtils.isEmpty(c1637gi.m2747d())) {
            c1637gi.m2752f(C1768az.m3791a());
        }
        c1637gi.m2737b(System.currentTimeMillis());
        if (TextUtils.isEmpty(c1637gi.m2750e())) {
            c1637gi.m2749e(context.getPackageName());
        }
        if (TextUtils.isEmpty(c1637gi.m2743c())) {
            c1637gi.m2749e(c1637gi.m2750e());
        }
    }

    /* renamed from: a */
    private static void m2704a(Context context, InterfaceC1632gd interfaceC1632gd, HashMap<String, ArrayList<C1637gi>> hashMap) {
        for (Map.Entry<String, ArrayList<C1637gi>> entry : hashMap.entrySet()) {
            try {
                ArrayList<C1637gi> value = entry.getValue();
                if (value != null && value.size() != 0) {
                    interfaceC1632gd.mo2712a(value, value.get(0).m2750e(), entry.getKey());
                }
            } catch (Exception unused) {
            }
        }
    }
}
