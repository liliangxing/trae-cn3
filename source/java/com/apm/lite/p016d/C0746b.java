package com.apm.lite.p016d;

import android.text.TextUtils;
import com.apm.lite.C0744d;
import com.apm.lite.CrashType;
import com.apm.lite.p023k.C0786i;
import com.apm.lite.p023k.C0789l;
import com.apm.lite.p023k.C0794q;
import com.apm.lite.p023k.C0799v;
import com.apm.lite.runtime.C0810a;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.framwork.core.sdkmonitor.MonitorConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.apm.lite.d.b */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0746b {

    /* renamed from: a */
    private static ConcurrentLinkedQueue<C0744d> f405a = new ConcurrentLinkedQueue<>();

    /* renamed from: b */
    private static ConcurrentHashMap<Integer, C0744d> f406b = new ConcurrentHashMap<>();

    /* renamed from: com.apm.lite.d.b$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface a {
        /* renamed from: a */
        void mo413a(JSONObject jSONObject);
    }

    /* renamed from: a */
    public static File m500a(File file) {
        return new File(file, "all_data.json");
    }

    /* renamed from: a */
    public static String m501a(Object obj) {
        Iterator<C0744d> it = f405a.iterator();
        while (it.hasNext()) {
            C0744d next = it.next();
            if (next != null && next.m462a(obj)) {
                return next.m463b();
            }
        }
        return null;
    }

    /* renamed from: a */
    public static JSONArray m502a() {
        C0744d next;
        JSONArray jSONArray = new JSONArray();
        Iterator<C0744d> it = f405a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.m464c());
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static JSONArray m503a(String str) {
        C0744d next;
        JSONArray jSONArray = new JSONArray();
        String[] split = str.split("\n");
        Iterator<C0744d> it = f405a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (C0810a.m1022b(next.m463b())) {
                JSONArray m458a = next.m458a(split);
                if (!C0789l.m821a(m458a)) {
                    jSONArray.put(next.m460a(CrashType.ANR, m458a));
                }
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static JSONArray m504a(String str, String str2, JSONArray jSONArray) {
        JSONObject optJSONObject;
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject2 = jSONArray.optJSONObject(i);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject(Constants.KEY_HEADER)) != null) {
                String valueOf = String.valueOf(optJSONObject.opt(MonitorConstants.KEY_AID));
                if (C0810a.m1024c(valueOf)) {
                    try {
                        String m453b = C0744d.m453b(valueOf);
                        if (!TextUtils.isEmpty(m453b)) {
                            optJSONObject.put("x-auth-token", m453b);
                        }
                    } catch (Throwable unused) {
                    }
                    if (!TextUtils.isEmpty(optJSONObject.optString("package"))) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("so_list");
                        if (!C0789l.m821a(optJSONArray)) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                if (!str.contains(optJSONArray.optString(i2))) {
                                }
                            }
                        }
                    }
                    jSONArray2.put(optJSONObject2);
                    break;
                }
            }
        }
        return jSONArray2;
    }

    /* renamed from: a */
    public static JSONArray m505a(Throwable th, Thread thread, File file) {
        C0744d next;
        JSONArray jSONArray = new JSONArray();
        StackTraceElement[] m935b = C0799v.m935b(th);
        Iterator<C0744d> it = f405a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (C0810a.m1020a(next.m463b())) {
                JSONArray m457a = next.m457a(m935b, th);
                if (!C0789l.m821a(m457a)) {
                    jSONArray.put(next.m460a(CrashType.JAVA, m457a));
                }
            } else {
                C0794q.m887a((Object) ("not enable javaCrash aid: " + next.m463b()));
            }
        }
        if (C0789l.m821a(jSONArray)) {
            return null;
        }
        if (file != null) {
            try {
                C0786i.m790a(new File(file, "all_data.json"), jSONArray, false);
            } catch (IOException unused) {
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static void m506a(C0744d c0744d) {
        f405a.add(c0744d);
        if (c0744d.m465d()) {
            f406b.put(4444, c0744d);
        }
    }

    /* renamed from: a */
    public static void m507a(File file, CrashType crashType) {
        C0744d next;
        if (file == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<C0744d> it = f405a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            if (C0810a.m1024c(next.m463b())) {
                jSONArray.put(next.m459a(crashType));
            } else {
                C0794q.m887a((Object) ("not enable NativeCrash aid: " + next.m463b()));
            }
        }
        if (C0789l.m821a(jSONArray)) {
            return;
        }
        try {
            C0786i.m790a(new File(file, "all_data.json"), jSONArray, false);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m508a(JSONObject jSONObject, JSONArray jSONArray, a aVar) {
        JSONObject optJSONObject;
        C0794q.m887a((Object) ("uploadFromFile with allData " + jSONArray));
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length() && (optJSONObject = jSONArray.optJSONObject(i)) != null; i++) {
            if (C0789l.m816a(optJSONObject, 0, Constants.KEY_HEADER, "single_upload") == 1) {
                JSONObject jSONObject2 = new JSONObject();
                C0745a.m471b(jSONObject2, jSONObject);
                C0745a.m471b(jSONObject2, optJSONObject);
                aVar.mo413a(jSONObject2);
            } else {
                try {
                    String m453b = C0744d.m453b(C0789l.m824b(optJSONObject, Constants.KEY_HEADER, MonitorConstants.KEY_AID));
                    if (!TextUtils.isEmpty(m453b)) {
                        JSONObject jSONObject3 = (JSONObject) optJSONObject.remove(Constants.KEY_HEADER);
                        jSONObject3.put("x-auth-token", m453b);
                        optJSONObject.put(Constants.KEY_HEADER, jSONObject3);
                    }
                } catch (Throwable unused) {
                }
                jSONArray2.put(optJSONObject);
            }
        }
        if (jSONArray2.length() == 0) {
            return;
        }
        JSONObject jSONObject4 = new JSONObject();
        C0745a.m471b(jSONObject4, jSONObject);
        try {
            jSONObject4.put("all_data", jSONArray2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        aVar.mo413a(jSONObject4);
    }

    /* renamed from: b */
    public static JSONArray m509b() {
        C0744d next;
        JSONArray jSONArray = new JSONArray();
        Iterator<C0744d> it = f405a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            jSONArray.put(next.m459a((CrashType) null));
        }
        return jSONArray;
    }

    /* renamed from: c */
    public static int m510c() {
        return f405a.size();
    }

    /* renamed from: d */
    public static List<String> m511d() {
        C0744d next;
        ArrayList arrayList = new ArrayList();
        Iterator<C0744d> it = f405a.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            arrayList.add(next.m463b());
        }
        return arrayList;
    }
}
