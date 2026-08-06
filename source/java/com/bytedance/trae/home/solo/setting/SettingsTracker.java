package com.bytedance.trae.home.solo.setting;

import android.util.Log;
import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: SettingsTracker.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0003¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u0005J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010#\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u0005J\u0006\u0010)\u001a\u00020\u001eJ\u0016\u0010*\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005J;\u0010,\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00052\n\b\u0002\u0010.\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u00100J*\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u00052\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u001e04¢\u0006\u0002\b6H\u0082\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SettingsTracker;", "", "<init>", "()V", "TAG", "", "EVENT_SETTINGS_PAGE_VIEW", "EVENT_SETTINGS_CLICK", "EVENT_THEME_SWITCH_CLICK", "EVENT_LANGUAGE_SWITCH_CLICK", "EVENT_DEVICE_MANAGEMENT_PAGE_VIEW", "EVENT_DEVICE_REMOVE_CLICK", "EVENT_LOGOUT_CLICK", "EVENT_ACCOUNT_BINDING_CLICK", "EVENT_ACCOUNT_BINDING_RESULT", "TYPE_ACCOUNT", "TYPE_THEME", "TYPE_LANGUAGE", "TYPE_NOTIFICATION", "TYPE_DEVICE_MANAGEMENT", "TYPE_CONNECTORS", "TYPE_ABOUT", "BINDING_TYPE_PHONE", "BINDING_TYPE_DOUYIN", "BINDING_ACTION_BIND", "BINDING_ACTION_CHANGE", "BINDING_ACTION_UNBIND", "RESULT_SUCCESS", "RESULT_FAIL", "trackSettingsPageView", "", "enterFrom", "trackSettingsClick", DBData.FIELD_TYPE, "trackThemeSwitchClick", "trackLanguageSwitchClick", "trackDeviceManagementPageView", "deviceCount", "", "trackDeviceRemoveClick", "deviceId", "trackLogoutClick", "trackAccountBindingClick", "action", "trackAccountBindingResult", "result", AccountMonitorConstants.CommonParameter.ERROR, "failReason", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "report", Fields.EVENT, "buildParams", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ExtensionFunctionType;", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SettingsTracker {
    public static final int $stable = 0;
    public static final String BINDING_ACTION_BIND = "bind";
    public static final String BINDING_ACTION_CHANGE = "change";
    public static final String BINDING_ACTION_UNBIND = "unbind";
    public static final String BINDING_TYPE_DOUYIN = "douyin";
    public static final String BINDING_TYPE_PHONE = "phone";
    private static final String EVENT_ACCOUNT_BINDING_CLICK = "icube_account_binding_click";
    private static final String EVENT_ACCOUNT_BINDING_RESULT = "icube_account_binding_result";
    private static final String EVENT_DEVICE_MANAGEMENT_PAGE_VIEW = "device_management_page_view";
    private static final String EVENT_DEVICE_REMOVE_CLICK = "icube_device_remove_click";
    private static final String EVENT_LANGUAGE_SWITCH_CLICK = "icube_language_switch_click";
    private static final String EVENT_LOGOUT_CLICK = "icube_logout_click";
    private static final String EVENT_SETTINGS_CLICK = "icube_settings_click";
    private static final String EVENT_SETTINGS_PAGE_VIEW = "settings_page_view";
    private static final String EVENT_THEME_SWITCH_CLICK = "icube_theme_switch_click";
    public static final SettingsTracker INSTANCE = new SettingsTracker();
    public static final String RESULT_FAIL = "fail";
    public static final String RESULT_SUCCESS = "success";
    private static final String TAG = "SettingsTracker";
    public static final String TYPE_ABOUT = "about";
    public static final String TYPE_ACCOUNT = "account";
    public static final String TYPE_CONNECTORS = "connectors";
    public static final String TYPE_DEVICE_MANAGEMENT = "device_management";
    public static final String TYPE_LANGUAGE = "language";
    public static final String TYPE_NOTIFICATION = "notification";
    public static final String TYPE_THEME = "theme";

    private SettingsTracker() {
    }

    public static /* synthetic */ void trackSettingsPageView$default(SettingsTracker settingsTracker, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = NewTaskTracker.EnterFrom.TASK_LIST;
        }
        settingsTracker.trackSettingsPageView(str);
    }

    private final void report(String event, Function1<? super JSONObject, Unit> buildParams) {
        JSONObject jSONObject = new JSONObject();
        buildParams.invoke(jSONObject);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: " + event + ", params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(event, jSONObject);
    }

    public final void trackSettingsPageView(String enterFrom) {
        Intrinsics.checkNotNullParameter(enterFrom, "enterFrom");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("enter_from", enterFrom);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: settings_page_view, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_SETTINGS_PAGE_VIEW, jSONObject);
    }

    public final void trackSettingsClick(String type) {
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(DBData.FIELD_TYPE, type);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_settings_click, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_SETTINGS_CLICK, jSONObject);
    }

    public final void trackThemeSwitchClick(String type) {
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(DBData.FIELD_TYPE, type);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_theme_switch_click, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_THEME_SWITCH_CLICK, jSONObject);
    }

    public final void trackLanguageSwitchClick(String type) {
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(DBData.FIELD_TYPE, type);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_language_switch_click, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_LANGUAGE_SWITCH_CLICK, jSONObject);
    }

    public final void trackDeviceManagementPageView(int deviceCount) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("device_count", deviceCount);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: device_management_page_view, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_DEVICE_MANAGEMENT_PAGE_VIEW, jSONObject);
    }

    public final void trackDeviceRemoveClick(String deviceId) {
        Intrinsics.checkNotNullParameter(deviceId, "deviceId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("device_id", deviceId);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_device_remove_click, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_DEVICE_REMOVE_CLICK, jSONObject);
    }

    public final void trackLogoutClick() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("current_page", "settings");
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_logout_click, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_LOGOUT_CLICK, jSONObject);
    }

    public final void trackAccountBindingClick(String type, String action) {
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("current_page", "settings");
        jSONObject.put(DBData.FIELD_TYPE, type);
        jSONObject.put("action", action);
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_account_binding_click, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_ACCOUNT_BINDING_CLICK, jSONObject);
    }

    public final void trackAccountBindingResult(String type, String action, String result, Integer errorCode, String failReason) {
        Intrinsics.checkNotNullParameter(type, DBData.FIELD_TYPE);
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(result, "result");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("current_page", "settings");
        jSONObject.put(DBData.FIELD_TYPE, type);
        jSONObject.put("action", action);
        jSONObject.put("result", result);
        if (errorCode != null) {
            jSONObject.put("error_code", String.valueOf(errorCode.intValue()));
        }
        if (failReason != null) {
            jSONObject.put("fail_reason", failReason);
        }
        if (AppHost.INSTANCE.isDebug()) {
            Log.d(TAG, "reportEvent: icube_account_binding_result, params: " + jSONObject);
        }
        IApplog.INSTANCE.reportEvent(EVENT_ACCOUNT_BINDING_RESULT, jSONObject);
    }
}
