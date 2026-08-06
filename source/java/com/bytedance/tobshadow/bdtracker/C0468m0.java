package com.bytedance.tobshadow.bdtracker;

import android.text.TextUtils;
import com.bytedance.tobshadow.applog.Level;
import com.bytedance.tobshadow.applog.log.EventBus;
import com.bytedance.tobshadow.applog.log.LogUtils;
import com.bytedance.trae.conversation.imageupload.ImageUploadConstants;
import com.bytedance.trae.conversation.voice.subtask.SubTaskUiState;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.m0 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class C0468m0 extends AbstractC0461l0 {

    /* renamed from: g */
    public static final long[] f804g = {SubTaskUiState.LONG_RUNNING_THRESHOLD_MS, 20000, 30000, 180000, 180000, 360000, 360000, 540000, 540000, 720000, 720000};

    /* renamed from: com.bytedance.tobshadow.bdtracker.m0$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public class a implements EventBus.DataFetcher {

        /* renamed from: a */
        public final /* synthetic */ JSONObject f805a;

        public a(JSONObject jSONObject) {
            this.f805a = jSONObject;
        }

        @Override // com.bytedance.tobshadow.applog.log.EventBus.DataFetcher
        public Object fetch() {
            JSONObject jSONObject = new JSONObject();
            C0411e.m375c(this.f805a, jSONObject);
            try {
                jSONObject.put("appId", C0468m0.this.f735f.f784m);
            } catch (Throwable unused) {
            }
            return jSONObject;
        }
    }

    public C0468m0(C0475n0 c0475n0) {
        super(c0475n0, c0475n0.f835e.f505f.getLong("app_log_last_config_time", 0L));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:81:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0296  */
    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo485c() {
        String str;
        C0421f2 c0421f2 = this.f734e.f839i;
        JSONObject m420f = c0421f2.m420f();
        if (c0421f2.m426i() != 0 && m420f != null) {
            JSONObject m461b = C0444i4.m461b(m420f);
            if (this.f734e.f835e.f502c.isEventFilterEnable()) {
                m461b.put("event_filter", 1);
            }
            C0480n5.m582a(this.f735f, m461b);
            String m501a = this.f735f.f781j.m501a(c0421f2.m420f(), this.f734e.m554e().getSettingUri(), true, Level.L1);
            C0444i4 c0444i4 = this.f735f.f782k;
            String m458a = C0444i4.m458a(m501a, C0480n5.f886b);
            c0444i4.f668b.f764D.debug(11, "Start to get config to uri:{} with request:{}...", m458a, m461b);
            try {
                str = c0444i4.m463a(m461b, m458a, c0444i4.m464a(), 60000);
            } catch (Throwable th) {
                c0444i4.f668b.f764D.error(11, "Config failed", th, new Object[0]);
                c0444i4.f668b.m522b().mo639a(th, "config");
                str = null;
            }
            c0444i4.f668b.f764D.debug(11, "Get config with response:{}", str);
            JSONObject m465a = c0444i4.m465a(str);
            JSONObject optJSONObject = (m465a != null && "ss_app_log".equals(m465a.optString("magic_tag", ""))) != false ? m465a.optJSONObject("config") : null;
            C0407d2 c0407d2 = this.f734e.f835e;
            C0497q1 c0497q1 = this.f735f.f796y;
            if (c0497q1 != null) {
                c0497q1.onRemoteConfigGet(!C0411e.m372b(optJSONObject, c0407d2.f508i), optJSONObject);
            }
            if (optJSONObject != null) {
                c0407d2.f501b.f764D.debug(Collections.singletonList("ConfigManager"), "Set config:{}", optJSONObject);
                c0407d2.f508i = optJSONObject;
                long currentTimeMillis = System.currentTimeMillis();
                long optInt = optJSONObject.optInt("session_interval", 0);
                if (optInt <= 0 || optInt > 604800) {
                    c0407d2.f505f.remove("session_interval");
                } else {
                    c0407d2.f505f.putLong("session_interval", optInt * 1000);
                }
                long optInt2 = optJSONObject.optInt("batch_event_interval", 60) * 1000;
                if ((optInt2 >= SubTaskUiState.LONG_RUNNING_THRESHOLD_MS && optInt2 <= ImageUploadConstants.TOKEN_SAFETY_THRESHOLD_MS) == true) {
                    c0407d2.f505f.putLong("batch_event_interval", optInt2);
                } else {
                    c0407d2.f505f.remove("batch_event_interval");
                }
                int optInt3 = optJSONObject.optInt("batch_event_size", -1);
                if (c0407d2.m312a(optInt3)) {
                    c0407d2.f505f.putInt("batch_event_size", optInt3);
                } else {
                    c0407d2.f505f.remove("batch_event_size");
                }
                int optInt4 = optJSONObject.optInt("send_launch_timely", 0);
                if (optInt4 <= 0 || optInt4 > 604800) {
                    c0407d2.f505f.remove("send_launch_timely");
                } else {
                    c0407d2.f505f.putInt("send_launch_timely", optInt4);
                }
                long optInt5 = optJSONObject.optInt("abtest_fetch_interval", 0);
                if (optInt5 <= 20 || optInt5 > 604800) {
                    c0407d2.f505f.remove("abtest_fetch_interval");
                } else {
                    c0407d2.f505f.putLong("abtest_fetch_interval", optInt5 * 1000);
                }
                boolean optBoolean = optJSONObject.optBoolean("bav_log_collect", c0407d2.f502c.isAutoTrackEnabled());
                c0407d2.f505f.putBoolean("bav_log_collect", optBoolean);
                c0407d2.f518s = optBoolean ? 1 : 0;
                c0407d2.f505f.putBoolean("bav_ab_config", optJSONObject.optBoolean("bav_ab_config", c0407d2.f502c.isAbEnable()));
                JSONArray optJSONArray = optJSONObject.optJSONArray("real_time_events");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    c0407d2.f505f.remove("real_time_events");
                } else {
                    c0407d2.f505f.putString("real_time_events", optJSONArray.toString());
                }
                c0407d2.f510k = null;
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("sensitive_fields");
                if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                    c0407d2.f505f.remove("sensitive_fields");
                } else {
                    c0407d2.f505f.putString("sensitive_fields", optJSONArray2.toString());
                }
                c0407d2.f505f.putLong("app_log_last_config_time", currentTimeMillis);
                long optLong = optJSONObject.optLong("fetch_interval", 21600L) * 1000;
                if (optLong < 1800000 || optLong > 172800000) {
                    optLong = 21600000;
                }
                c0407d2.f505f.putLong("fetch_interval", optLong);
                if (optJSONObject.has("applog_disable_monitor")) {
                    c0407d2.f505f.putBoolean("monitor_enabled", optJSONObject.optInt("applog_disable_monitor", 0) == 1);
                }
                if (optJSONObject.has("enter_background_not_send")) {
                    c0407d2.f505f.putBoolean("enter_background_not_send", optJSONObject.optInt("enter_background_not_send") == 1);
                }
                if (1 == optJSONObject.optInt("observe_enable", 0)) {
                    String optString = optJSONObject.optString("observe_appid", "");
                    if (!TextUtils.isEmpty(optString)) {
                        c0407d2.f505f.putString("observe_appid", optString);
                        c0407d2.m327n();
                        if (!c0407d2.m324k()) {
                            this.f734e.f847q = null;
                        }
                        C0475n0 c0475n0 = this.f734e;
                        c0475n0.f840j.removeMessages(13);
                        c0475n0.f840j.sendEmptyMessage(13);
                        if (this.f734e.f835e.f502c.isEventFilterEnable()) {
                            String m492a = C0453k.m492a(this.f735f, "sp_filter_name");
                            C0475n0 c0475n02 = this.f734e;
                            c0475n02.f855y = AbstractC0476n1.m562a(c0475n02.m546b(), m492a, optJSONObject);
                        }
                        if (!LogUtils.isDisabled()) {
                            LogUtils.sendJsonFetcher("fetch_log_settings_end", new a(optJSONObject));
                        }
                        return true;
                    }
                }
                c0407d2.f505f.remove("observe_appid");
                c0407d2.m327n();
                if (!c0407d2.m324k()) {
                }
                C0475n0 c0475n03 = this.f734e;
                c0475n03.f840j.removeMessages(13);
                c0475n03.f840j.sendEmptyMessage(13);
                if (this.f734e.f835e.f502c.isEventFilterEnable()) {
                }
                if (!LogUtils.isDisabled()) {
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: d */
    public String mo486d() {
        return "Configure";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: e */
    public long[] mo487e() {
        return f804g;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: f */
    public boolean mo488f() {
        return true;
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0461l0
    /* renamed from: g */
    public long mo489g() {
        return this.f734e.f835e.f505f.getLong("fetch_interval", 21600000L);
    }
}
