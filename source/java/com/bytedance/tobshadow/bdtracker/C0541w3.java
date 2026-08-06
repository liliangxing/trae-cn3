package com.bytedance.tobshadow.bdtracker;

import android.app.Application;
import android.content.res.Resources;
import com.bytedance.sdk.account.bdplatform.model.BDPlatformConstants;
import com.bytedance.tobshadow.applog.InitConfig;
import com.bytedance.tobshadow.applog.exception.AppCrashType;
import com.bytedance.trae.home.solo.sitemessage.SiteMessageParams;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.bytedance.tobshadow.bdtracker.w3 */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class C0541w3 extends AbstractC0485o3 {

    /* renamed from: e */
    public String f1185e;

    /* renamed from: f */
    public String f1186f;

    /* renamed from: g */
    public long f1187g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0541w3(C0467m c0467m) {
        super(c0467m);
        Intrinsics.checkParameterIsNotNull(c0467m, "applog");
        this.f1185e = "";
        this.f1186f = "";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0485o3
    /* renamed from: a */
    public String mo588a() {
        return "init";
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0485o3
    /* renamed from: a */
    public void mo589a(JSONObject jSONObject) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        C0467m c0467m = this.f894d;
        try {
            c0467m.getSdkVersion();
            jSONObject.put(BDPlatformConstants.EventKey.EVENT_KEY_SDK_VERSION, "6.17.11-tobshadow");
            jSONObject.put("sdk_lib", SiteMessageParams.platform);
            InitConfig initConfig = this.f894d.getInitConfig();
            jSONObject.put("sdk_channel", initConfig != null ? initConfig.getChannel() : null);
        } catch (Throwable th) {
            c0467m.f764D.error(7, "Run task failed", th, new Object[0]);
        }
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        C0467m c0467m2 = this.f894d;
        try {
            InitConfig initConfig2 = c0467m2.getInitConfig();
            if (initConfig2 != null) {
                Intrinsics.checkExpressionValueIsNotNull(initConfig2, "config");
                jSONObject.put("config_app_id", initConfig2.getAid());
                jSONObject.put("config_channel", initConfig2.getChannel());
                jSONObject.put("config_sp_name", initConfig2.getSpName());
                jSONObject.put("config_db_name", initConfig2.getDbName());
                jSONObject.put("config_request_encrypt", c0467m2.f765E);
                if (c0467m2.f765E) {
                    jSONObject.put("config_response_encrypt", initConfig2.isResponseEncryptEnabled());
                    jSONObject.put("config_custom_encrypt", initConfig2.getEncryptor() == null);
                }
                jSONObject.put("config_log_enable", initConfig2.isLogEnable());
                jSONObject.put("config_ab_enable", initConfig2.isAbEnable());
                jSONObject.put("config_auto_start", initConfig2.autoStart());
                jSONObject.put("config_h5_bridge_enable", initConfig2.isH5BridgeEnable());
                jSONObject.put("config_h5_collect_enable", initConfig2.isH5CollectEnable());
                jSONObject.put("config_bridge_update_user_enable", initConfig2.isUseBridgeUpdateUUIDEnabled());
                jSONObject.put("config_auto_track_enable", initConfig2.isAutoTrackEnabled());
                jSONObject.put("config_exposure_enable", initConfig2.isExposureEnabled());
                jSONObject.put("config_oaid_enable", initConfig2.isOaidEnabled());
                jSONObject.put("config_mac_enable", initConfig2.isMacEnable());
                jSONObject.put("config_androidid_enable", initConfig2.isAndroidIdEnabled());
                jSONObject.put("config_operator_enable", initConfig2.isOperatorInfoEnabled());
                jSONObject.put("config_serialnumber_enable", initConfig2.isSerialNumberEnable());
                jSONObject.put("config_track_fragment_enable", initConfig2.isAutoTrackFragmentEnabled());
                jSONObject.put("config_crash_enable", AppCrashType.hasCrashType(initConfig2.getTrackCrashType(), 1));
                jSONObject.put("config_tracer_enable", initConfig2.isDeferredALinkEnabled());
                jSONObject.put("config_gaid_enable", initConfig2.isGaidEnabled());
                jSONObject.put("config_display_enable", initConfig2.isDisplayDensityAndDpiEnabled());
                jSONObject.put("config_cpu_encrypt", initConfig2.isCPUAbiEnabled());
                jSONObject.put("config_repeat_exposure_encrypt", initConfig2.isAbTestExposureEventRepeatEnabled());
            }
        } catch (Throwable th2) {
            c0467m2.f764D.error(7, "Run task failed", th2, new Object[0]);
        }
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        C0467m c0467m3 = this.f894d;
        try {
            jSONObject.put("run_start", this.f891a);
            jSONObject.put("run_duration", this.f1187g);
            jSONObject.put("run_status", this.f1186f);
            if (this.f1185e.length() > 0) {
                jSONObject.put("run_fail", this.f1185e);
            }
        } catch (Throwable th3) {
            c0467m3.f764D.error(7, "Run task failed", th3, new Object[0]);
        }
        Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        C0467m c0467m4 = this.f894d;
        try {
            jSONObject.put("device_platform", SiteMessageParams.platform);
            C0467m c0467m5 = this.f894d;
            Application application = c0467m5.f785n;
            Intrinsics.checkExpressionValueIsNotNull(application, "it.context");
            Resources resources = application.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "it.context.resources");
            Locale locale = resources.getConfiguration().locale;
            Intrinsics.checkExpressionValueIsNotNull(locale, "it.context.resources.configuration.locale");
            jSONObject.put("device_language", locale.getLanguage());
            jSONObject.put("device_network", C0501q5.m621a(c0467m5.f785n));
        } catch (Throwable th4) {
            c0467m4.f764D.error(7, "Run task failed", th4, new Object[0]);
        }
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0485o3
    /* renamed from: b */
    public void mo590b() {
        this.f892b = System.currentTimeMillis();
        this.f1187g = this.f892b - this.f891a;
        this.f1186f = C0380a.m251a(this.f1186f, "|1");
    }

    @Override // com.bytedance.tobshadow.bdtracker.AbstractC0485o3
    /* renamed from: d */
    public void mo592d() {
        this.f891a = System.currentTimeMillis();
        this.f1186f = "0";
        this.f893c = true;
    }
}
