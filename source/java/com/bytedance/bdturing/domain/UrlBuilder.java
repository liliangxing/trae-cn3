package com.bytedance.bdturing.domain;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdturing.BdTuring;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.EventReport;
import com.bytedance.bdturing.LogUtil;
import com.bytedance.bdturing.twiceverify.TwiceVerifyDepend;
import com.bytedance.bdturing.twiceverify.TwiceVerifyManager;
import com.bytedance.bdturing.utils.Consts;
import com.bytedance.bdturing.utils.UtilsKt;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlBuilder.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tJ&\u0010\n\u001a\u00060\bj\u0002`\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/bdturing/domain/UrlBuilder;", "", "()V", "appendCommon", "", "activity", "Landroid/app/Activity;", "queryBuilder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "createBuilder", "customUrl", "", "serviceType", "BdTuringSdk_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class UrlBuilder {
    public static final UrlBuilder INSTANCE = new UrlBuilder();

    private UrlBuilder() {
    }

    public final StringBuilder createBuilder(String customUrl, String serviceType, Activity activity) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        if (customUrl == null || TextUtils.isEmpty(customUrl)) {
            customUrl = com.bytedance.bdturing.setting.SettingsManager.INSTANCE.getCDN(serviceType);
        }
        String host = com.bytedance.bdturing.setting.SettingsManager.INSTANCE.getHost(serviceType);
        if (Intrinsics.areEqual(serviceType, com.bytedance.bdturing.setting.SettingsManager.TWICE_VERIFY_SERVICE)) {
            TwiceVerifyDepend depend = TwiceVerifyManager.getInstance().getDepend();
            host = depend != null ? depend.host() : null;
            TwiceVerifyDepend depend2 = TwiceVerifyManager.getInstance().getDepend();
            customUrl = depend2 != null ? depend2.url() : null;
        }
        if (LogUtil.isDebug()) {
            BdTuringConfig config = BdTuring.getInstance().getConfig();
            Pair<String, String> testConfig = config != null ? config.getTestConfig(2) : null;
            if (!TextUtils.isEmpty(testConfig != null ? (String) testConfig.first : null)) {
                Intrinsics.checkNotNull(testConfig);
                customUrl = (String) testConfig.first;
            }
            if (!TextUtils.isEmpty(testConfig != null ? (String) testConfig.second : null)) {
                Intrinsics.checkNotNull(testConfig);
                host = (String) testConfig.second;
            }
            if (activity != null) {
                Toast.makeText(activity, "url = " + customUrl + ", verifyHost = " + host, 1).show();
            }
        }
        StringBuilder appendFirstParam = UtilsKt.appendFirstParam(new StringBuilder(customUrl + '?'), "verify_host", host);
        appendCommon(activity, appendFirstParam);
        return appendFirstParam;
    }

    public final void appendCommon(Activity activity, StringBuilder queryBuilder) {
        BdTuringConfig.RegionType regionType;
        Intrinsics.checkNotNullParameter(queryBuilder, "queryBuilder");
        BdTuringConfig config = BdTuring.getInstance().getConfig();
        StringBuilder appendParams = UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(queryBuilder, "aid", config != null ? config.getAppId() : null), "lang", config != null ? config.getLanguage() : null), Api.KEY_APP_NAME, config != null ? config.getAppName() : null);
        BdTuringConfig config2 = BdTuring.getInstance().getConfig();
        UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(UtilsKt.appendParams(appendParams, "locale", config2 != null ? config2.getLocale() : null), "ch", config != null ? config.getChannel() : null), "channel", config != null ? config.getChannel() : null), WsConstants.KEY_APP_KEY, config != null ? config.getAppKey() : null), "iid", config != null ? config.getInstallId() : null), "vc", config != null ? config.getAppVersion() : null), "app_verison", config != null ? config.getAppVersion() : null), "did", config != null ? config.getDeviceId() : null), "region", (config == null || (regionType = config.getRegionType()) == null) ? null : regionType.getName()), "use_native_report", com.bytedance.bdturing.setting.SettingsManager.INSTANCE.getUseNativeReport() ? 1 : 0), "use_jsb_request", com.bytedance.bdturing.setting.SettingsManager.INSTANCE.getUseJsbRequest() ? 1 : 0), "verify_cancellable", com.bytedance.bdturing.setting.SettingsManager.INSTANCE.getVerifyCancellable() ? 1 : 0), EventReport.SCREEN_ORIENTATION, UtilsKt.getCurrentOrientation(activity)), "resolution", UtilsKt.getResolution()), "sdk_version", "4.1.1.cn"), "os_version", Consts.SYSTEM_VERSION), "device_brand", Consts.DEVICE_BRAND), "device_model", Consts.DEVICE_MODEL), "os_name", Consts.OS_NAME), "version_code", config != null ? config.getAppVersionCode() : null), "version_name", config != null ? config.getAppVersion() : null), Api.KEY_DEVICE_TYPE, Consts.DEVICE_MODEL), "device_platform", Consts.OS_NAME), "os_type", 0);
        if (com.bytedance.bdturing.setting.SettingsManager.INSTANCE.getUseMock()) {
            UtilsKt.appendParams(queryBuilder, "mock", 1);
        }
    }
}
