package com.bytedance.trae.push.impl;

import android.content.Context;
import android.net.Uri;
import com.bytedance.ies.bullet.lynx.DefaultLynxParams;
import com.bytedance.ies.bullet.service.schema.SchemaConstants;
import com.bytedance.pia.core.metrics.ErrorType;
import com.bytedance.praisedialoglib.PraiseDialogConstant;
import com.bytedance.push.PushBody;
import com.bytedance.push.interfaze.IMessageCallbackService;
import com.bytedance.trae.applog.api.IApplog;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.common.apphost.lifecycle.ActivityStackManager;
import com.bytedance.trae.platform.service.ApmService;
import com.bytedance.trae.push.api.PushConst;
import com.bytedance.trae.utils.logger.FLogger;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import org.json.JSONObject;

/* compiled from: PushEventManager.kt */
@Metadata(d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0005*\u0001\u0018\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\u0005J\u0018\u0010\u001d\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\bJ\u0010\u0010!\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0006\u0010\"\u001a\u00020\u0005J\u001c\u0010\"\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010%\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010&\u001a\u00020'2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010(\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0002J\u001e\u0010)\u001a\u0004\u0018\u00010\u00052\b\u0010#\u001a\u0004\u0018\u00010\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010*\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\bH\u0002J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0002J\u0016\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020\u00132\u0006\u00101\u001a\u00020\bJ$\u00102\u001a\u00020\u001b2\u0006\u00103\u001a\u0002042\u0014\b\u0002\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000106J\u000e\u00107\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0005J\u0018\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020'H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006;"}, d2 = {"Lcom/bytedance/trae/push/impl/PushEventManager;", "", "<init>", "()V", "TAG", "", "EVENT_PUSH", "VALUE_IS_PUSH_TRUE", "", "VALUE_IS_PUSH_FALSE", "VALUE_PUSH_CONTENT_TYPE_DEFAULT", "VALUE_PUSH_CONTENT_TYPE_OTHER", "VALUE_PUSH_RULE_ID_DEFAULT", "", "VALUE_PUSH_GROUP_ID_DEFAULT", "BADGE_NUMBER_ERROR", "EVENT_NOTIFICATION_ARRIVE", "EVENT_NOTIFICATION_CLICK", "isPush", "", "isPushInt", "pushContentType", "currentPushOpenUrl", "appBackgroundListener", "com/bytedance/trae/push/impl/PushEventManager$appBackgroundListener$1", "Lcom/bytedance/trae/push/impl/PushEventManager$appBackgroundListener$1;", "reportPushEventWhenColdStart", "", "setOrUpdateIsPushCommonParams", "onPushClick", "pushBody", "Lcom/bytedance/push/PushBody;", PraiseDialogConstant.FROM, "onPushArrive", "getPushContentType", "extra", "openUrl", "reportNotificationClick", "buildNotificationParams", "Lorg/json/JSONObject;", "getTargetPage", "getTaskId", "reportPushClickDetail", "reportAppLaunchStatus", "context", "Landroid/content/Context;", "reportPushNotificationStatus", "onChannelRegisterResult", "success", "type", "trackPushProcess", "eventType", "Lcom/bytedance/trae/push/impl/PushTrackerType;", "extraParams", "", "updateCurrentPushOpenUrl", "reportPushMonitorEvent", "action", "params", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class PushEventManager {
    private static final int BADGE_NUMBER_ERROR = -3;
    private static final String EVENT_NOTIFICATION_ARRIVE = "icube_notification_arrive";
    private static final String EVENT_NOTIFICATION_CLICK = "icube_notification_click";
    private static final String EVENT_PUSH = "push_event";
    public static final PushEventManager INSTANCE;
    private static final String TAG = "PushEventManager";
    private static final int VALUE_IS_PUSH_FALSE = 0;
    private static final int VALUE_IS_PUSH_TRUE = 1;
    private static final String VALUE_PUSH_CONTENT_TYPE_DEFAULT = "default";
    private static final String VALUE_PUSH_CONTENT_TYPE_OTHER = "other";
    private static final String VALUE_PUSH_GROUP_ID_DEFAULT = "-1";
    private static final long VALUE_PUSH_RULE_ID_DEFAULT = -1;
    private static final PushEventManager$appBackgroundListener$1 appBackgroundListener;
    private static String currentPushOpenUrl;
    private static boolean isPush;
    private static int isPushInt;
    private static String pushContentType;

    private PushEventManager() {
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.bytedance.trae.push.impl.PushEventManager$appBackgroundListener$1] */
    static {
        PushEventManager pushEventManager = new PushEventManager();
        INSTANCE = pushEventManager;
        pushContentType = "default";
        currentPushOpenUrl = "";
        ?? r2 = new ActivityStackManager.OnAppBackGroundListener() { // from class: com.bytedance.trae.push.impl.PushEventManager$appBackgroundListener$1
            public void onAllActivityDestroyed() {
            }

            public void onAppBackground() {
                boolean z;
                z = PushEventManager.isPush;
                if (z) {
                    PushEventManager pushEventManager2 = PushEventManager.INSTANCE;
                    PushEventManager.isPush = false;
                    PushEventManager.INSTANCE.setOrUpdateIsPushCommonParams(0, DefaultLynxParams.DEFAULT_LYNX_GROUP_NAME);
                }
            }

            public void onAppForeground() {
                PushEventManager.INSTANCE.reportAppLaunchStatus(AppHost.Companion.getApplication());
            }
        };
        appBackgroundListener = r2;
        AppHost.Companion.getActivityStackManager().addAppBackGroundListener((ActivityStackManager.OnAppBackGroundListener) r2);
        pushEventManager.setOrUpdateIsPushCommonParams(0, "default");
        IApplog.Companion.addEventCommonParams(PushConst.KEY_PARAM_IS_PUSH, new Function0() { // from class: com.bytedance.trae.push.impl.PushEventManager$$ExternalSyntheticLambda0
            public final Object invoke() {
                Object _init_$lambda$0;
                _init_$lambda$0 = PushEventManager._init_$lambda$0();
                return _init_$lambda$0;
            }
        });
        IApplog.Companion.addEventCommonParams(PushConst.KEY_PARAM_PUSH_CONTENT_TYPE, new Function0() { // from class: com.bytedance.trae.push.impl.PushEventManager$$ExternalSyntheticLambda1
            public final Object invoke() {
                Object obj;
                obj = PushEventManager.pushContentType;
                return obj;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object _init_$lambda$0() {
        return Integer.valueOf(isPushInt);
    }

    public final void reportPushEventWhenColdStart() {
        reportPushNotificationStatus(AppHost.Companion.getApplication());
        reportAppLaunchStatus(AppHost.Companion.getApplication());
    }

    public static /* synthetic */ void setOrUpdateIsPushCommonParams$default(PushEventManager pushEventManager, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            str = "default";
        }
        pushEventManager.setOrUpdateIsPushCommonParams(i, str);
    }

    public final void setOrUpdateIsPushCommonParams(int isPush2, String pushContentType2) {
        Intrinsics.checkNotNullParameter(pushContentType2, "pushContentType");
        pushContentType = pushContentType2;
        isPushInt = isPush2;
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getDefault(), (CoroutineStart) null, new PushEventManager$setOrUpdateIsPushCommonParams$1(isPush2, pushContentType2, null), 2, (Object) null);
    }

    public final void onPushClick(PushBody pushBody, int from) {
        isPush = true;
        setOrUpdateIsPushCommonParams(1, getPushContentType(pushBody != null ? pushBody.extra : null, pushBody != null ? pushBody.open_url : null));
        reportNotificationClick(pushBody);
        reportPushClickDetail(pushBody, from);
    }

    public final void onPushArrive(PushBody pushBody) {
        JSONObject buildNotificationParams = buildNotificationParams(pushBody);
        IApplog.Companion.reportEvent(EVENT_NOTIFICATION_ARRIVE, buildNotificationParams);
        reportPushMonitorEvent("notification_arrive", buildNotificationParams);
    }

    public final String getPushContentType() {
        return pushContentType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String getPushContentType(String extra, String openUrl) {
        JSONObject jSONObject;
        String str;
        String str2 = extra;
        if (!(str2 == null || str2.length() == 0)) {
            try {
                Result.Companion companion = Result.Companion;
                PushEventManager pushEventManager = this;
                jSONObject = Result.constructor-impl(new JSONObject(extra));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                jSONObject = Result.constructor-impl(ResultKt.createFailure(th));
            }
            r3 = Result.isFailure-impl(jSONObject) ? null : jSONObject;
        }
        if (r3 == null || (str = r3.optString(PushConst.KEY_PARAM_PUSH_CONTENT_TYPE, "")) == null) {
            str = "";
        }
        if (str.length() == 0) {
            String str3 = openUrl;
            if (!(str3 == null || str3.length() == 0)) {
                Uri parse = Uri.parse(openUrl);
                String queryParameter = parse.getQueryParameter(PushConst.KEY_PARAM_PUSH_CONTENT_TYPE);
                str = queryParameter == null ? "" : queryParameter;
                if (str.length() == 0) {
                    String queryParameter2 = parse.getQueryParameter(PushConst.KEY_OPEN_URL_SEC_TYPE);
                    str = queryParameter2 != null ? queryParameter2 : "";
                }
            }
        }
        return str.length() == 0 ? VALUE_PUSH_CONTENT_TYPE_OTHER : str;
    }

    private final void reportNotificationClick(PushBody pushBody) {
        JSONObject buildNotificationParams = buildNotificationParams(pushBody);
        IApplog.Companion.reportEvent(EVENT_NOTIFICATION_CLICK, buildNotificationParams);
        reportPushMonitorEvent("notification_click", buildNotificationParams);
    }

    private final JSONObject buildNotificationParams(PushBody pushBody) {
        JSONObject jSONObject = new JSONObject();
        PushEventManager pushEventManager = INSTANCE;
        jSONObject.put("type", pushEventManager.getPushContentType(pushBody != null ? pushBody.extra : null, pushBody != null ? pushBody.open_url : null));
        jSONObject.put("target_page", pushEventManager.getTargetPage(pushBody != null ? pushBody.open_url : null));
        String taskId = pushEventManager.getTaskId(pushBody != null ? pushBody.extra : null, pushBody != null ? pushBody.open_url : null);
        String str = taskId;
        if (!(str == null || str.length() == 0)) {
            jSONObject.put("task_id", taskId);
        }
        return jSONObject;
    }

    private final String getTargetPage(String openUrl) {
        Object obj;
        String str = openUrl;
        if (str == null || str.length() == 0) {
            return "task_list";
        }
        try {
            Result.Companion companion = Result.Companion;
            PushEventManager pushEventManager = this;
            obj = Result.constructor-impl(Uri.parse(openUrl));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Uri uri = (Uri) obj;
        if (uri == null) {
            return "task_list";
        }
        String host = uri.getHost();
        if (host == null && (host = uri.getPath()) == null) {
            host = "";
        }
        String str2 = host;
        return (StringsKt.contains$default(str2, "conversation", false, 2, (Object) null) || StringsKt.contains$default(str2, "task_detail", false, 2, (Object) null)) ? "task_detail" : StringsKt.contains$default(str2, ErrorType.SETTINGS, false, 2, (Object) null) ? ErrorType.SETTINGS : "task_list";
    }

    private final String getTaskId(String extra, String openUrl) {
        Object obj;
        String optString;
        Object obj2;
        String str = extra;
        if (!(str == null || str.length() == 0)) {
            try {
                Result.Companion companion = Result.Companion;
                PushEventManager pushEventManager = this;
                obj = Result.constructor-impl(new JSONObject(extra));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            JSONObject jSONObject = (JSONObject) obj;
            String str2 = "";
            if (jSONObject != null && (optString = jSONObject.optString("task_id", "")) != null) {
                str2 = optString;
            }
            if (str2.length() > 0) {
                return str2;
            }
        }
        String str3 = openUrl;
        if (str3 == null || str3.length() == 0) {
            return null;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            PushEventManager pushEventManager2 = this;
            obj2 = Result.constructor-impl(Uri.parse(openUrl));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        if (Result.isFailure-impl(obj2)) {
            obj2 = null;
        }
        Uri uri = (Uri) obj2;
        if (uri != null) {
            return uri.getQueryParameter("task_id");
        }
        return null;
    }

    private final void reportPushClickDetail(PushBody pushBody, int from) {
        Object obj;
        String str;
        String str2;
        String optString;
        String str3;
        if (pushBody == null) {
            return;
        }
        String str4 = pushBody.extra;
        String str5 = str4;
        if (str5 == null || str5.length() == 0) {
            str2 = null;
        } else {
            try {
                Result.Companion companion = Result.Companion;
                PushEventManager pushEventManager = this;
                obj = Result.constructor-impl(new JSONObject(str4));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            JSONObject jSONObject = (JSONObject) (Result.isFailure-impl(obj) ? null : obj);
            if (jSONObject == null || (str = jSONObject.optString(PushConst.KEY_PUSH_CONTENT_FIR_TYPE, "")) == null) {
                str = "";
            }
            String str6 = (jSONObject == null || (optString = jSONObject.optString(PushConst.KEY_PUSH_CONTENT_SEC_TYPE, "")) == null) ? "" : optString;
            r4 = str;
            str2 = str6;
        }
        String str7 = pushBody.open_url;
        String str8 = str7;
        if (!(str8 == null || str8.length() == 0)) {
            Uri parse = Uri.parse(str7);
            CharSequence charSequence = (CharSequence) r4;
            if ((charSequence == null || charSequence.length() == 0) && (r4 = parse.getQueryParameter(PushConst.KEY_OPEN_URL_FIR_TYPE)) == null) {
                r4 = "";
            }
            String str9 = str2;
            if (str9 == null || str9.length() == 0) {
                String queryParameter = parse.getQueryParameter(PushConst.KEY_OPEN_URL_SEC_TYPE);
                str2 = queryParameter != null ? queryParameter : "";
            }
        }
        if (pushBody.imageType != 0) {
            String str10 = pushBody.imageUrl;
            if (!(str10 == null || str10.length() == 0)) {
                str3 = "content_pic";
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PushConst.KEY_RULE_ID, pushBody.f84id);
                jSONObject2.put(PushConst.KEY_GROUP_ID, pushBody.groupId);
                jSONObject2.put("click_position", "notify");
                jSONObject2.put("push_type", "remote_push");
                jSONObject2.put("sender", from);
                jSONObject2.put(SchemaConstants.QUERY_KEY_TITLE, pushBody.title);
                jSONObject2.put("right_image_url", pushBody.imageUrl);
                jSONObject2.put("push_show_type", pushBody.pushShowType);
                jSONObject2.put("push_content_firtype", r4);
                jSONObject2.put("push_content_sectype", str2);
                jSONObject2.put("push_style", str3);
                jSONObject2.put(PushConst.KEY_PARAM_PUSH_CONTENT_TYPE, pushContentType);
                IApplog.Companion.reportEvent("push_click_detail", jSONObject2);
                reportPushMonitorEvent(IMessageCallbackService.EVENT_TYPE_CLICK, jSONObject2);
            }
        }
        str3 = "content";
        JSONObject jSONObject22 = new JSONObject();
        jSONObject22.put(PushConst.KEY_RULE_ID, pushBody.f84id);
        jSONObject22.put(PushConst.KEY_GROUP_ID, pushBody.groupId);
        jSONObject22.put("click_position", "notify");
        jSONObject22.put("push_type", "remote_push");
        jSONObject22.put("sender", from);
        jSONObject22.put(SchemaConstants.QUERY_KEY_TITLE, pushBody.title);
        jSONObject22.put("right_image_url", pushBody.imageUrl);
        jSONObject22.put("push_show_type", pushBody.pushShowType);
        jSONObject22.put("push_content_firtype", r4);
        jSONObject22.put("push_content_sectype", str2);
        jSONObject22.put("push_style", str3);
        jSONObject22.put(PushConst.KEY_PARAM_PUSH_CONTENT_TYPE, pushContentType);
        IApplog.Companion.reportEvent("push_click_detail", jSONObject22);
        reportPushMonitorEvent(IMessageCallbackService.EVENT_TYPE_CLICK, jSONObject22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportAppLaunchStatus(Context context) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new PushEventManager$reportAppLaunchStatus$1(context, null), 2, (Object) null);
    }

    private final void reportPushNotificationStatus(Context context) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new PushEventManager$reportPushNotificationStatus$1(context, null), 2, (Object) null);
    }

    public final void onChannelRegisterResult(boolean success, int type) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("is_success", success ? 1 : 0);
        jSONObject.put("type", type);
        IApplog.Companion.reportEvent("rd_push_register_result", jSONObject);
        reportPushMonitorEvent("register_result", jSONObject);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void trackPushProcess$default(PushEventManager pushEventManager, PushTrackerType pushTrackerType, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        pushEventManager.trackPushProcess(pushTrackerType, map);
    }

    public final void trackPushProcess(PushTrackerType eventType, Map<String, ? extends Object> extraParams) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(extraParams, "extraParams");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("absolute_schema", currentPushOpenUrl);
        if (currentPushOpenUrl.length() > 0) {
            try {
                Result.Companion companion = Result.Companion;
                Uri parse = Uri.parse(currentPushOpenUrl);
                String path = parse.getPath();
                String str = "";
                if (path == null) {
                    path = "";
                }
                jSONObject.put("schema_path", path);
                String host = parse.getHost();
                if (host != null) {
                    str = host;
                }
                jSONObject.put("schema_host", str);
                Set<String> queryParameterNames = parse.getQueryParameterNames();
                Intrinsics.checkNotNullExpressionValue(queryParameterNames, "getQueryParameterNames(...)");
                Result.constructor-impl(jSONObject.put("schema_queries", CollectionsKt.joinToString$default(queryParameterNames, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th));
            }
        }
        for (Map.Entry<String, ? extends Object> entry : extraParams.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        FLogger.INSTANCE.mo428i(TAG, "trackPushProcess: " + eventType.getEventName() + ", params=" + jSONObject);
        IApplog.Companion.reportEvent(eventType.getEventName(), jSONObject);
        reportPushMonitorEvent(eventType.getActionName(), jSONObject);
    }

    public final void updateCurrentPushOpenUrl(String openUrl) {
        Intrinsics.checkNotNullParameter(openUrl, "openUrl");
        currentPushOpenUrl = openUrl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportPushMonitorEvent(String action, JSONObject params) {
        try {
            Result.Companion companion = Result.Companion;
            PushEventManager pushEventManager = this;
            JSONObject jSONObject = new JSONObject(params.toString());
            jSONObject.put("action", action);
            ApmService.INSTANCE.monitorEventForSlardar(EVENT_PUSH, jSONObject, null, null);
            Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
    }
}
