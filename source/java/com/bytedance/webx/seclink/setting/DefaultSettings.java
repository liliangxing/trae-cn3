package com.bytedance.webx.seclink.setting;

import com.bytedance.webx.seclink.util.JsonParsUtil;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: DefaultSettings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/webx/seclink/setting/DefaultSettings;", "", "()V", "SETTINGS", "Lcom/bytedance/webx/seclink/setting/SettingConfig;", "getSETTINGS", "()Lcom/bytedance/webx/seclink/setting/SettingConfig;", "SETTINGS$delegate", "Lkotlin/Lazy;", "raw", "", "seclink_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class DefaultSettings {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {(KProperty) Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DefaultSettings.class), "SETTINGS", "getSETTINGS()Lcom/bytedance/webx/seclink/setting/SettingConfig;"))};
    public static final DefaultSettings INSTANCE = new DefaultSettings();
    private static final String raw = "{\n    \"config\": {\n        \"custom_settings_biz_first\": true,\n        \"error_overwhelming_count\": 100,\n        \"error_overwhelming_duration\": 1800,\n        \"period\": 86400,\n        \"safe_duration_after_overwhelming\": 1800,\n        \"seclink_settings_version\": \"B350AFCAB4F3218AF5D74ADC624143E2\",\n        \"settings_url_array\": [\n            \"https://rc.zijieapi.com/seclink/setting/v1\",\n            \"https://seclink.bytedance.com/setting/v1\",\n            \"https://link.wtturl.cn/setting/v1\",\n            \"https://api.xseclink.cn/setting/v1\",\n            \"https://api.xseclink.com/setting/v1\"\n        ],\n        \"sync_check_time_limit\": 1,\n        \"use_cache\": true,\n        \"verify_host_array\": [\n            \"https://seclink.bytedance.com\",\n            \"https://api.xseclink.cn\",\n            \"https://link.wtturl.cn\"\n        ]\n    },\n    \"global\": {\n        \"async_mode\": true,\n        \"enable\": true,\n        \"scheme\": [\n            \"https\",\n            \"http\"\n        ],\n        \"use_verify_mode_v2\": true\n    }\n}\n ";

    /* renamed from: SETTINGS$delegate, reason: from kotlin metadata */
    private static final Lazy SETTINGS = LazyKt.lazy(new Function0<SettingConfig>() { // from class: com.bytedance.webx.seclink.setting.DefaultSettings$SETTINGS$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final SettingConfig m2633invoke() {
            String str;
            DefaultSettings defaultSettings = DefaultSettings.INSTANCE;
            str = DefaultSettings.raw;
            return JsonParsUtil.parseSettings(str);
        }
    });

    public final SettingConfig getSETTINGS() {
        Lazy lazy = SETTINGS;
        KProperty kProperty = $$delegatedProperties[0];
        return (SettingConfig) lazy.getValue();
    }

    private DefaultSettings() {
    }
}
