package com.bytedance.tobshadow.applog.log;

import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.bdtracker.AbstractC0479n4;
import com.bytedance.tobshadow.bdtracker.C0380a;
import com.bytedance.tobshadow.bdtracker.C0386a5;
import com.bytedance.tobshadow.bdtracker.C0394b5;
import com.bytedance.tobshadow.bdtracker.C0411e;
import com.bytedance.tobshadow.bdtracker.C0500q4;
import com.bytedance.tobshadow.bdtracker.C0528u4;
import com.bytedance.tobshadow.bdtracker.C0535v4;
import com.bytedance.tobshadow.bdtracker.C0549x4;
import com.bytedance.tobshadow.bdtracker.C0556y4;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class LogUtils {
    public static final String EVENT_TYPE_EVENT_V3 = "EVENT_V3";
    public static final String EVENT_TYPE_LAUNCH = "LAUNCH";
    public static final String EVENT_TYPE_PROFILE = "PROFILE";
    public static final String EVENT_TYPE_TERMINATE = "TERMINATE";
    public static final String EVENT_TYPE_TRACE = "TRACE";

    /* renamed from: a */
    public static volatile boolean f411a;

    /* renamed from: com.bytedance.tobshadow.applog.log.LogUtils$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class C0364a implements EventBus.DataFetcher {

        /* renamed from: a */
        public final /* synthetic */ Object f412a;

        public C0364a(Object obj) {
            this.f412a = obj;
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            AbstractC0479n4 abstractC0479n4;
            String str;
            JSONObject m579h = ((AbstractC0479n4) this.f412a).m579h();
            JSONObject jSONObject = new JSONObject();
            C0411e.m375c(m579h, jSONObject);
            try {
                jSONObject.put("$$APP_ID", ((AbstractC0479n4) this.f412a).f882m);
                abstractC0479n4 = (AbstractC0479n4) this.f412a;
            } catch (JSONException unused) {
            }
            if (abstractC0479n4 != null) {
                if (!(abstractC0479n4 instanceof C0528u4) && !(abstractC0479n4 instanceof C0549x4)) {
                    if (abstractC0479n4 instanceof C0500q4) {
                        str = ((C0500q4) abstractC0479n4).f948s.toUpperCase(Locale.ROOT);
                    } else if (abstractC0479n4 instanceof C0535v4) {
                        str = LogUtils.EVENT_TYPE_LAUNCH;
                    } else if (abstractC0479n4 instanceof C0386a5) {
                        str = LogUtils.EVENT_TYPE_TERMINATE;
                    } else if (abstractC0479n4 instanceof C0556y4) {
                        str = LogUtils.EVENT_TYPE_PROFILE;
                    } else if (abstractC0479n4 instanceof C0394b5) {
                        str = "TRACE";
                    }
                    jSONObject.put("$$EVENT_TYPE", str);
                    jSONObject.put("$$EVENT_LOCAL_ID", ((AbstractC0479n4) this.f412a).f885p);
                    return jSONObject;
                }
                str = LogUtils.EVENT_TYPE_EVENT_V3;
                jSONObject.put("$$EVENT_TYPE", str);
                jSONObject.put("$$EVENT_LOCAL_ID", ((AbstractC0479n4) this.f412a).f885p);
                return jSONObject;
            }
            str = "";
            jSONObject.put("$$EVENT_TYPE", str);
            jSONObject.put("$$EVENT_LOCAL_ID", ((AbstractC0479n4) this.f412a).f885p);
            return jSONObject;
        }
    }

    /* renamed from: a */
    public static String m232a(String str) {
        return C0380a.m251a("applog_", str);
    }

    public static boolean isDisabled() {
        return !f411a;
    }

    public static void sendJson(String str, JSONObject jSONObject) {
        if (isDisabled() || C0411e.m376c(str)) {
            return;
        }
        EventBus.global.get(new Object[0]).emit(m232a(str), jSONObject);
    }

    public static void sendJsonFetcher(String str, EventBus.DataFetcher dataFetcher) {
        if (isDisabled() || C0411e.m376c(str)) {
            return;
        }
        EventBus.global.get(new Object[0]).emit(m232a(str), dataFetcher);
    }

    public static void sendObject(String str, Object obj) {
        if (isDisabled() || C0411e.m376c(str) || (obj instanceof C0549x4)) {
            return;
        }
        if (obj instanceof AbstractC0479n4) {
            EventBus.global.get(new Object[0]).emit(m232a(str), (EventBus.DataFetcher) new C0364a(obj));
        } else {
            EventBus.global.get(new Object[0]).emit(m232a(str), obj);
        }
    }

    public static void sendString(String str, String str2) {
        if (isDisabled() || C0411e.m376c(str)) {
            return;
        }
        EventBus.global.get(new Object[0]).emit(m232a(str), str2);
    }

    public static void setEnable(boolean z) {
        f411a = z;
    }
}
