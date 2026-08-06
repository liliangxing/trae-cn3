package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.tobshadow.applog.DynamicValueCallback;
import com.bytedance.tobshadow.applog.Level;
import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.applog.log.LogUtils;
import com.bytedance.trae.conversation.voice.subtask.SubTaskUiState;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.q0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0496q0 extends AbstractC0461l0 {

    /* renamed from: g */
    public static final long[] f934g = {60000, 60000, 60000, 120000, 120000, 180000, 180000, 360000, 360000, 540000, 540000};

    /* renamed from: h */
    public static final long[] f935h = {180000, 180000, 360000, 360000, 540000, 540000, 720000, 720000};

    /* renamed from: i */
    public static final long[] f936i = {2000, SubTaskUiState.LONG_RUNNING_THRESHOLD_MS, SubTaskUiState.LONG_RUNNING_THRESHOLD_MS, 20000, 20000, 60000, 60000, 120000, 120000, 180000, 180000, 360000, 360000, 540000, 540000};

    /* renamed from: com.bytedance.tobshadow.bdtracker.q0$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements EventBus.DataFetcher {

        /* renamed from: a */
        public final /* synthetic */ String f937a;

        /* renamed from: b */
        public final /* synthetic */ String f938b;

        /* renamed from: c */
        public final /* synthetic */ String f939c;

        /* renamed from: d */
        public final /* synthetic */ String f940d;

        /* renamed from: e */
        public final /* synthetic */ String f941e;

        /* renamed from: f */
        public final /* synthetic */ String f942f;

        public a(String str, String str2, String str3, String str4, String str5, String str6) {
            this.f937a = str;
            this.f938b = str2;
            this.f939c = str3;
            this.f940d = str4;
            this.f941e = str5;
            this.f942f = str6;
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("appId", C0496q0.this.f735f.f784m);
                jSONObject.put("did", this.f937a);
                jSONObject.put("installId", this.f938b);
                jSONObject.put("ssid", this.f939c);
                jSONObject.put("bdDid", this.f940d);
                jSONObject.put("uuid", this.f941e);
                jSONObject.put("uuidType", this.f942f);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public C0496q0(C0475n0 c0475n0) {
        super(c0475n0, c0475n0.f839i.f587d.optLong("register_time", 0L));
    }

    /* renamed from: a */
    public synchronized boolean m613a(JSONObject jSONObject) {
        this.f734e.f834d.f764D.debug(1, "Start do register work", new Object[0]);
        String optString = jSONObject.optString("user_unique_id");
        String optString2 = jSONObject.optString("user_unique_id_type");
        C0475n0 c0475n0 = this.f734e;
        C0421f2 c0421f2 = c0475n0.f839i;
        C0407d2 c0407d2 = c0475n0.f835e;
        c0407d2.f502c.getPreInstallCallback();
        Map<String, Object> commonHeader = c0407d2.f502c.getCommonHeader();
        jSONObject.put("req_id", C0536v5.f1143a.m456b(new Object[0]));
        if (c0407d2.m325l()) {
            try {
                boolean z = C0404d.f491a.m277b(this.f735f.f785n).f572c;
                this.f734e.f834d.f764D.debug(1, "Oaid maySupport: {}", Boolean.valueOf(z));
                DynamicValueCallback<String> customOaidCallback = c0407d2.f502c.getCustomOaidCallback();
                if (customOaidCallback != null && !TextUtils.isEmpty(customOaidCallback.get())) {
                    jSONObject.put("oaid_may_support", true);
                }
                jSONObject.put("oaid_may_support", z);
            } catch (Throwable th) {
                this.f734e.f834d.f764D.error(1, "Check oaid maySupport failed.", th, new Object[0]);
            }
        }
        if (commonHeader != null) {
            for (Map.Entry<String, Object> entry : commonHeader.entrySet()) {
                if (entry.getValue() != null) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            }
        }
        JSONObject m614b = m614b(jSONObject);
        if (m614b == null) {
            this.f734e.f834d.f764D.debug(1, "Register finished", new Object[0]);
            return false;
        }
        String optString3 = m614b.optString("device_id", "");
        String optString4 = m614b.optString("install_id", "");
        String optString5 = m614b.optString("ssid", "");
        String optString6 = m614b.optString("bd_did", "");
        String optString7 = m614b.optString("cd", "");
        if (C0411e.m361a(optString5)) {
            this.f734e.m550c().m689a(optString, optString5);
        }
        boolean m408a = c0421f2.m408a(m614b, optString, optString3, optString4, optString5, optString6, optString7);
        if (m408a) {
            C0475n0 c0475n02 = this.f734e;
            c0475n02.m537a(c0475n02.f843m);
            if (this.f734e.f835e.f502c.isReportOaidEnable()) {
                this.f734e.m536a();
            }
            if (!LogUtils.isDisabled()) {
                LogUtils.sendJsonFetcher("device_register_end", new a(optString3, optString4, optString5, optString6, optString, optString2));
            }
        }
        return m408a;
    }

    /* renamed from: b */
    public JSONObject m614b(JSONObject jSONObject) {
        this.f734e.f834d.f764D.debug(1, "Start to invokeRegister", new Object[0]);
        try {
            if (jSONObject.opt("oaid") instanceof String) {
                jSONObject.remove("oaid");
                if (this.f734e.f839i != null && this.f734e.f839i.m420f() != null) {
                    Object opt = this.f734e.f839i.m420f().opt("oaid");
                    if (opt instanceof JSONObject) {
                        jSONObject.put("oaid", opt);
                    }
                }
            }
            JSONObject m461b = C0444i4.m461b(jSONObject);
            return this.f735f.f782k.m466a(this.f735f.f781j.m501a(jSONObject, this.f734e.m554e().getRegisterUri(), true, Level.L1), m461b);
        } catch (Throwable th) {
            this.f734e.f834d.f764D.error(1, "Request to register server failed.", th, new Object[0]);
            return null;
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: c */
    public boolean mo485c() {
        JSONObject jSONObject = new JSONObject();
        C0411e.m351a(jSONObject, this.f734e.f839i.m420f());
        return m613a(jSONObject);
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: d */
    public String mo486d() {
        return "register";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: e */
    public long[] mo487e() {
        int m426i = this.f734e.f839i.m426i();
        if (m426i == 0) {
            return f936i;
        }
        if (m426i != 1) {
            if (m426i == 2) {
                return f934g;
            }
            this.f734e.f834d.f764D.error(1, "Unknown register state", new Object[0]);
        }
        return f935h;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: f */
    public boolean mo488f() {
        return true;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: g */
    public long mo489g() {
        return this.f734e.f844n.f1003j ? 21600000L : 43200000L;
    }

    /* renamed from: c */
    public JSONObject m615c(JSONObject jSONObject) {
        try {
            JSONObject m461b = C0444i4.m461b(jSONObject);
            return this.f735f.f782k.m471b(this.f734e.m554e().getReportOaidUri(), m461b);
        } catch (Throwable th) {
            this.f734e.f834d.f764D.error(1, "Report oaid failed.", th, new Object[0]);
            return null;
        }
    }
}
