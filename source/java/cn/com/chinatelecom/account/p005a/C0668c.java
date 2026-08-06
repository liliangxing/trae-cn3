package cn.com.chinatelecom.account.p005a;

import android.content.Context;
import android.text.TextUtils;
import cn.com.chinatelecom.account.api.Helper;
import cn.com.chinatelecom.account.api.p006a.C0677c;
import cn.com.chinatelecom.account.api.p009d.C0686a;
import cn.com.chinatelecom.account.api.p010e.C0696c;
import cn.com.chinatelecom.account.api.p010e.C0700g;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: cn.com.chinatelecom.account.a.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class C0668c extends C0686a {

    /* renamed from: b */
    private static final String f102b = "c";

    /* renamed from: a */
    private static void m170a(Context context, int i) {
        try {
            C0696c.m289a(context, "key_c_l_l_v", i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    public static void m171a(Context context, String str) {
        char c;
        str.hashCode();
        int i = 0;
        switch (str.hashCode()) {
            case 64897:
                if (str.equals("ALL")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 78159:
                if (str.equals("OFF")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 66247144:
                if (str.equals("ERROR")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 1:
                i = -2;
                break;
            case 2:
                i = -1;
                break;
        }
        m170a(context, i);
    }

    /* renamed from: a */
    public static void m172a(Context context, List<String> list) {
        int m174b = m174b(context);
        if (m174b == -2) {
            return;
        }
        m177b(context, list, m174b);
    }

    /* renamed from: b */
    private static int m174b(Context context) {
        try {
            return C0696c.m292b(context, "key_c_l_l_v", 0);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    /* renamed from: b */
    private static String m175b(Context context, String str) {
        return C0666a.m161a(context, C0700g.m342c(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static String m176b(Context context, Queue<String> queue) {
        JSONArray jSONArray = new JSONArray();
        String jSONArray2 = jSONArray.toString();
        if (!queue.isEmpty()) {
            Iterator<String> it = queue.iterator();
            while (it.hasNext()) {
                try {
                    jSONArray.put(new JSONObject(it.next()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        if (jSONArray.length() <= 0) {
            return "";
        }
        String jSONArray3 = jSONArray.toString();
        if (!TextUtils.isEmpty(jSONArray3)) {
            try {
                jSONArray2 = URLEncoder.encode(Helper.guulam(context, jSONArray3), UrlUtils.UTF_8);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return m175b(context, jSONArray2);
    }

    /* renamed from: b */
    private static void m177b(final Context context, final List<String> list, final int i) {
        m238a(new Runnable() { // from class: cn.com.chinatelecom.account.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Queue m179c = C0668c.m179c(context, list, i);
                    if (m179c.isEmpty()) {
                        return;
                    }
                    String m176b = C0668c.m176b(context, (Queue<String>) m179c);
                    JSONObject jSONObject = null;
                    int i2 = -1;
                    try {
                        if (!TextUtils.isEmpty(m176b)) {
                            JSONObject jSONObject2 = new JSONObject(m176b);
                            try {
                                i2 = jSONObject2.getInt("code");
                                jSONObject = jSONObject2;
                            } catch (Exception e) {
                                e = e;
                                jSONObject = jSONObject2;
                                e.printStackTrace();
                                if (jSONObject != null) {
                                }
                                C0668c.m178b(context, (Queue<String>) m179c, i);
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    if (jSONObject != null || i2 != 0) {
                        C0668c.m178b(context, (Queue<String>) m179c, i);
                    } else {
                        C0668c.m180c(context);
                        m179c.clear();
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m178b(Context context, Queue<String> queue, int i) {
        String str;
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        if (queue != null && !queue.isEmpty()) {
            Iterator<String> it = queue.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                try {
                    jSONObject = new JSONObject(it.next());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (i != -1 || jSONObject.getInt("rt") != 0) {
                    jSONArray.put(jSONObject);
                    i2++;
                    if (i2 > 10) {
                        break;
                    }
                }
            }
        }
        if (jSONArray.length() > 0) {
            try {
                str = Helper.eneulret(jSONArray.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
                str = null;
            }
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        C0667b.m163a(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static synchronized Queue<String> m179c(Context context, List<String> list, int i) {
        ConcurrentLinkedQueue concurrentLinkedQueue;
        synchronized (C0668c.class) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue();
            String m162a = C0667b.m162a(context);
            if (!TextUtils.isEmpty(m162a)) {
                try {
                    JSONArray jSONArray = new JSONArray(new String(Helper.dneulret(C0677c.m188a(m162a))));
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length && i2 <= 10; i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        if (jSONObject != null) {
                            concurrentLinkedQueue.add(jSONObject.toString());
                        }
                    }
                    C0667b.m163a(context, "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (i == -1) {
                for (String str : list) {
                    try {
                        if (new JSONObject(str).getInt("rt") != 0) {
                            concurrentLinkedQueue.add(str);
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } else if (i == 0) {
                concurrentLinkedQueue.addAll(list);
            }
            while (concurrentLinkedQueue.size() > 10) {
                concurrentLinkedQueue.poll();
            }
        }
        return concurrentLinkedQueue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m180c(Context context) {
        C0667b.m163a(context, "");
    }
}
