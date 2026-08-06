package com.bytedance.bdturing.setting;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* compiled from: DefaultSettings.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/bytedance/bdturing/setting/DefaultSettings;", "", "()V", "SETTINGS", "Lorg/json/JSONObject;", "getSETTINGS", "()Lorg/json/JSONObject;", "raw", "", "getRaw", "()Ljava/lang/String;", "raw$delegate", "Lkotlin/Lazy;", "setting_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class DefaultSettings {
    public static final DefaultSettings INSTANCE;
    private static final JSONObject SETTINGS;

    /* renamed from: raw$delegate, reason: from kotlin metadata */
    private static final Lazy raw;

    private DefaultSettings() {
    }

    static {
        DefaultSettings defaultSettings = new DefaultSettings();
        INSTANCE = defaultSettings;
        raw = LazyKt.lazy(new Function0<String>() { // from class: com.bytedance.bdturing.setting.DefaultSettings$raw$2
            public final String invoke() {
                return "{\n  \"common\": {\n    \"period\": 300000,\n    \"retry_count\": 3,\n    \"retry_interval\": 2000,\n    \"alpha\": \"0.5\",\n    \"rgb\": \"000000\",\n    \"skip_launch\": 0,\n    \"use_jsb_request\": 1,\n    \"use_native_report\": 1,\n    \"use_dialog_size_v2\": 1,\n    \"pre_create\": 0,\n    \"request_encrypt\": 0,\n    \"verify_use_dialog_v2\": 1,\n    \"identity_use_dialog_v2\": 1,\n    \"h5_load_retry_enable\": 1,\n    \"h5_load_timeout\": 8000,\n    \"verify_cancellable\": 1,\n    \"use_cache\": 0,\n    \"h5_verify_acc_switch\": 1,\n    \"h5_verify_gyro_switch\": 1,\n    \"sensor_update_interval\": 0.05,\n    \"sensor_max_num\": 1200,\n    \"host\": {\n      \"cn\": \"https://vcs.zijieapi.com/\",\n      \"boe\": \"https://vcs-boe.bytedance.net/\"\n    },\n    \"back_up_host\": {\n      \"cn\": \"https://vcs.zijieapi.com/\",\n      \"boe\": \"https://vcs-boe.bytedance.net/\"\n    },\n    \"popup_url\": {\n      \"cn\": \"https://rmc.bytedance.com/verifycenter/normal-popup\"\n    }\n  },\n  \"self_unpunish\": {\n    \"url\": {\n      \"cn\": \"https://unpkg.byted-static.com/byted/secsdk-unpunish/1.7.3/output/index.html\",\n      \"boe\": \"https://unblock.web.bytedance.net/\"\n    },\n    \"host\": {\n      \"cn\": \"https://rc.snssdk.com\",\n      \"boe\": \"https://rc-boe.snssdk.com/\"\n    },\n    \"height\": 0,\n    \"width\": 0\n  },\n  \"qa\": {\n    \"host\": {\n      \"cn\": \"https://rc.snssdk.com\",\n      \"boe\": \"https://rc-boe.snssdk.com/\"\n    },\n    \"url\": {\n      \"cn\": \"https://unpkg.byted-static.com/byted/secsdk-qa/1.2.6/build/index.html\",\n      \"boe\": \"https://qa.web.bytedance.net\"\n    },\n    \"height\": 318,\n    \"width\": 300\n  },\n  \"sms\": {\n    \"host\": {\n      \"cn\": \"https://rc.snssdk.com\",\n      \"boe\": \"https://rc-boe.snssdk.com/\"\n    },\n    \"url\": {\n      \"cn\": \"https://unpkg.byted-static.com/byted/secsdk-mobile-original/1.9.9/build/index.html\",\n      \"boe\": \"https://mobile.web.bytedance.net/\"\n    },\n    \"height\": 0,\n    \"width\": 0\n  },\n  \"twice_verify\": {\n    \"host\": {\n      \"cn\": \"\"\n    },\n    \"url\": {\n      \"cn\": \"/verifycenter/authentication\"\n    },\n    \"height\": 0,\n    \"width\": 0\n  },\n  \"verify\": {\n    \"host\": {\n      \"cn\": \"https://verify.zijieapi.com/\",\n      \"boe\": \"https://boe-verify.bytedance.net/\"\n    },\n    \"back_up_host\": {\n      \"cn\": \"https://verify.zijieapi.com/\",\n      \"boe\": \"https://boe-verify.bytedance.net/\"\n    },\n    \"url\": {\n      \"cn\": \"https://rmc.bytedance.com/verifycenter/captcha\",\n      \"boe\": \"https://captcha.web.bytedance.net/\"\n    },\n    \"height\": 303,\n    \"width\": 300\n  },\n  \"smarter_verify\": {\n    \"url\": {\n      \"cn\": \"https://unpkg.byted-static.com/byted/secsdk-smart-captcha/0.0.8/output/app/smarter/index.html\"\n    },\n    \"host\": {\n      \"cn\": \"https://verify.snssdk.com/\"\n    },\n    \"back_up_host\": {\n      \"cn\": \"https://verify.snssdk.com/\"\n    },\n    \"width\": 0,\n    \"height\": 0\n  },\n  \"smartest_verify\": {\n    \"url\": {\n      \"cn\": \"https://unpkg.byted-static.com/byted/secsdk-smart-captcha/0.0.8/output/app/smartest/index.html\"\n    },\n    \"host\": {\n      \"cn\": \"https://verify.snssdk.com/\"\n    },\n    \"back_up_host\": {\n      \"cn\": \"https://verify.snssdk.com/\"\n    },\n    \"width\": 0,\n    \"height\": 0\n  },\n  \"verify_identity\": {\n    \"report_url\": {\n      \"cn\": \"https://verify.zijieapi.com/captcha/reportIdentity\",\n      \"boe\": \"https://boe-verify.bytedance.net/captcha/reportIdentity\"\n    }\n  },\n  \"auth\": {\n    \"host\": {\n      \"cn\": \"https://verify.zijieapi.com/\",\n      \"boe\": \"https://boe-verify.bytedance.net/\"\n    },\n    \"agreement_version\": \"1.0.0\",\n    \"agreement_url\": \"https://lf3-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/douyin_agreement/9cbe3f57-32d8-487d-bb13-aa4691be1909.html\",\n    \"agreement_title\": \"《人脸信息处理人机识别规则》\",\n    \"help_url\": \"https://rmc.bytedance.com/verifycenter/huoti/help\",\n    \"cancellable\": 1,\n    \"timeout\": 10000,\n    \"use_bytenn\":1,\n    \"live_dispatch_enable\":0,\n    \"model\":{\n    \"url_list\":[\n      \"https://lf-cdn-tos.bytescm.com/obj/rc-verifycenter/client_face_model/v1.0.zip\",\n      \"https://lf-rc1.yhgfb-cn-static.com/obj/rc-verifycenter/client_face_model/v1.0.zip\",\n      \"https://lf-rc2.yhgfb-cn-static.com/obj/rc-verifycenter/client_face_model/v1.0.zip\"\n     ],\n     \"detect_md5\":\"1e227a35cdff9c38384a59409f6e4d53\",\n     \"kpt_md5\":\"fe8b8248c5d039937a85adccb39a5a10\"\n    },\n    \"model_threshold\":{\n      \"detect_model_confidence_th\":0.8,\n      \"detect_model_top_k\":5000,\n      \"detect_model_nms_th\":0.4,\n      \"detect_model_keep_top_k\":5,\n      \"illumination_low_th\":65,\n      \"illumination_high_th\":185,\n      \"in_rob_th\":0.02,\n      \"too_small_th\":0.1,\n      \"too_large_th\":0.8,\n      \"fit_roi_th\":0.9,\n      \"visible_point_th\":0.75,\n      \"visible_point_rate_th\":0.85,\n      \"eye_ratio_th\":0.3,\n      \"mouth_ratio_lo_th\":0.8,\n      \"mouth_ratio_hi_th\":4.0,\n      \"vertical_angle_th\":30.0\n    }\n  },\n  \"nocaptcha\": {\n    \"trigger_sec_sdk\": true,\n    \"collect_touch_event\": true,\n    \"collect_touch_event_pre\":true,\n    \"collect_page_history_pre\":true,\n    \"collect_page_history\": true,\n    \"report_time_out\": 2000,\n    \"async_collect_time_out\": 10000\n  }\n}";
            }
        });
        SETTINGS = new JSONObject(defaultSettings.getRaw());
    }

    private final String getRaw() {
        return (String) raw.getValue();
    }

    public final JSONObject getSETTINGS() {
        return SETTINGS;
    }
}
