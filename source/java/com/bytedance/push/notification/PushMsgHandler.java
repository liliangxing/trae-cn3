package com.bytedance.push.notification;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.client.intelligence.IFeatureCallBack;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.IAccountService;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.notification.NotificationDeleteBroadcastReceiver;
import com.bytedance.push.Configuration;
import com.bytedance.push.PushBody;
import com.bytedance.push.PushNotificationMessage;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.client.intelligence.ClientIntelligenceShowResult;
import com.bytedance.push.client.intelligence.FeatureCollectionHelper;
import com.bytedance.push.client.intelligence.FeatureConnectionConstant;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.push.interfaze.IEventSender;
import com.bytedance.push.interfaze.IPushMsgHandler;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.interfaze.OnPushClickListener;
import com.bytedance.push.safe.IPassThoughMsgCache;
import com.bytedance.push.settings.notification.MessageBlackTimeWindowSettingsModel;
import com.bytedance.push.settings.push.click.PushClickReportOptSettingsModel;
import com.bytedance.push.task.UploadFilterEventTask;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.RomVersionParamHelper;
import com.bytedance.trae.push.api.PushConst;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.push.SmartIntentUtil;
import com.ss.android.pushmanager.setting.PushSetting;
import com.ss.android.ug.bus.UgBusFramework;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushMsgHandler implements IPushMsgHandler {
    private final Configuration mConfiguration;
    private final IEventSender mEventImpl;
    private final OnPushClickListener mOnPushClickListener;
    private final PushReceiveHandler mPushReceiveHandler;
    private final String TAG = "PushMsgHandler";
    private final long ONE_MINUTE_MILL = 60000;
    private final List<Long> mClickedRids = new ArrayList();
    private final DebouncingClickHelper mDeboundingClickHelper = new DebouncingClickHelper();

    static /* synthetic */ String access$000() {
        return getSecUid();
    }

    public PushMsgHandler(Configuration configuration) {
        this.mPushReceiveHandler = configuration.mPushReceiveHandler;
        this.mEventImpl = configuration.mEventCallback;
        this.mOnPushClickListener = configuration.mOnPushClickListener;
        this.mConfiguration = configuration;
    }

    @Override // com.bytedance.push.interfaze.IPushMsgHandler
    public void handlePassThroughMsg(JSONObject jSONObject, int i, String str) {
        handlePassThroughMsg(jSONObject, i, str, false);
    }

    @Override // com.bytedance.push.interfaze.IPushMsgHandler
    public void handlePassThroughMsg(final JSONObject jSONObject, final int i, final String str, final boolean z) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.notification.PushMsgHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    PushMsgHandler.this.handlePassThroughMsgOnChildThread(jSONObject, i, str, z);
                }
            });
        } else {
            handlePassThroughMsgOnChildThread(jSONObject, i, str, z);
        }
    }

    public void handlePassThroughMsgOnChildThread(JSONObject jSONObject, int i, String str, boolean z) {
        boolean z2;
        PushBody pushBody = new PushBody(jSONObject);
        PushServiceManager.get().getPushExternalService().getPushSdkMonitorService().onMessageArrive(pushBody.f84id);
        ((IPassThoughMsgCache) UgBusFramework.getService(IPassThoughMsgCache.class)).cacheMsg(pushBody, i);
        if (!pushBody.checkValid()) {
            PushSupporter.logger().mo247e(IPushService.TAG_PUSH_SHOW, "PushBody error : " + pushBody);
        }
        boolean shouldDiscardMsg = shouldDiscardMsg(pushBody);
        boolean curIsDuplicateMsg = curIsDuplicateMsg(pushBody);
        Logger.m268d("PushMsgHandler", "[handlePassThroughMsgOnChildThread] curIsDuplicateMsg is " + curIsDuplicateMsg + " :" + pushBody.f84id);
        if (this.mPushReceiveHandler != null && !shouldDiscardMsg && !curIsDuplicateMsg) {
            Logger.m268d("PushMsgHandler", "[handlePassThroughMsgOnChildThread] addMessageToDb: " + pushBody.f84id);
            PushNotificationMessage pushNotificationMessage = new PushNotificationMessage(i, pushBody.rid64, ToolUtils.currentTimeMillis(), pushBody.messageExpiredTime, z, false, jSONObject.toString());
            pushNotificationMessage.setPushBody(pushBody);
            MultiProcessPushMessageDatabaseHelper.getInstance(this.mConfiguration.mApplication).addMessageToDb(pushNotificationMessage);
            if (!PushSupporter.get().getMessageSpreadOutService().spreadOut(pushNotificationMessage)) {
                ClientIntelligenceShowResult handleMessageShow = handleMessageShow(pushNotificationMessage);
                if (handleMessageShow != null) {
                    r19 = (handleMessageShow.showByClientIntelligence || TextUtils.isEmpty(handleMessageShow.reason)) ? false : true;
                    r20 = r19 ? handleMessageShow.reason : null;
                    if (!handleMessageShow.successShow) {
                        r19 = false;
                    }
                }
            } else {
                z2 = false;
                String str2 = r20;
                if (!TextUtils.isEmpty(pushBody.targetSecUid) && !TextUtils.equals(pushBody.targetSecUid, getSecUid())) {
                    ThreadPlus.submitRunnable(new UploadFilterEventTask(i, pushBody));
                }
                onShowEvent(i, pushBody, shouldDiscardMsg, curIsDuplicateMsg, z2, str2);
            }
        }
        z2 = r19;
        String str22 = r20;
        if (!TextUtils.isEmpty(pushBody.targetSecUid)) {
            ThreadPlus.submitRunnable(new UploadFilterEventTask(i, pushBody));
        }
        onShowEvent(i, pushBody, shouldDiscardMsg, curIsDuplicateMsg, z2, str22);
    }

    @Override // com.bytedance.push.interfaze.IPushMsgHandler
    public ClientIntelligenceShowResult handleMessageShow(final PushNotificationMessage pushNotificationMessage) {
        PushBody pushBody = pushNotificationMessage.getPushBody();
        Logger.m268d("PushMsgHandler", "[handleMessageShow]delayShowIntervalInSecond:" + pushBody.delayShowIntervalInSecond);
        if (pushBody.delayShowIntervalInSecond > 0) {
            ClientIntelligenceShowResult clientIntelligenceShowResult = new ClientIntelligenceShowResult();
            clientIntelligenceShowResult.successShow = false;
            Logger.m268d("PushMsgHandler", "[handleMessageShow]delay show notification after " + pushBody.delayShowIntervalInSecond);
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.notification.PushMsgHandler.2
                @Override // java.lang.Runnable
                public void run() {
                    PushMsgHandler.this.handleMessageShowInternal(pushNotificationMessage);
                }
            }, pushBody.delayShowIntervalInSecond * 1000);
            return clientIntelligenceShowResult;
        }
        return handleMessageShowInternal(pushNotificationMessage);
    }

    public ClientIntelligenceShowResult handleMessageShowInternal(PushNotificationMessage pushNotificationMessage) {
        PushBody pushBody = pushNotificationMessage.getPushBody();
        if (PushSupporter.get().getClientIntelligenceService().enableClientIntelligencePushShow() && pushBody.useClientIntelligenceShow && pushBody.messageExpiredTime > ToolUtils.currentTimeMillis()) {
            Logger.m268d("PushMsgHandler", "show push by client intelligence");
            return PushSupporter.get().getClientIntelligenceService().showPushWithClientIntelligenceStrategy(pushNotificationMessage, false);
        }
        Logger.m268d("PushMsgHandler", "show push directly");
        if (showNotification(pushNotificationMessage.from, pushBody, pushNotificationMessage.handleBySdk, false, false, null, ToolUtils.currentTimeMillis())) {
            return null;
        }
        ClientIntelligenceShowResult clientIntelligenceShowResult = new ClientIntelligenceShowResult();
        clientIntelligenceShowResult.successShow = false;
        return clientIntelligenceShowResult;
    }

    private boolean curIsDuplicateMsg(PushBody pushBody) {
        if (PushSetting.getInstance().getPushOnLineSettings().getUnDuplicateMessageSettings().enableUnDuplicateMessage) {
            return MultiProcessPushMessageDatabaseHelper.getInstance(this.mConfiguration.mApplication).curMessageHasExists(pushBody.rid64);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
    
        if (r12 != 2) goto L9;
     */
    @Override // com.bytedance.push.interfaze.IPushMsgHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean showNotification(int i, PushBody pushBody, boolean z, boolean z2, boolean z3, String str, long j) {
        if (z2) {
        }
        onNotificationShowEvent(i, pushBody, z, z3, str, j);
        boolean curMessageHasExists = MultiProcessPushMessageDatabaseHelper.getInstance(this.mConfiguration.mApplication).curMessageHasExists(pushBody.rid64);
        if (needInterceptNotificationShowBecauseBlackTimeWindow(pushBody) && curMessageHasExists) {
            Logger.m268d("PushMsgHandler", "[showNotification] intercept notification show because cur is in black time window");
            return false;
        }
        Logger.m268d("PushMsgHandler", "[showNotification] not intercept notification show");
        long markMessageAsShown = MultiProcessPushMessageDatabaseHelper.getInstance(this.mConfiguration.mApplication).markMessageAsShown(pushBody.rid64);
        Logger.m268d("PushMsgHandler", "[showNotification] markMessageAsShown: " + pushBody.f84id + " updateMessageStatusResult:" + markMessageAsShown + " pushBody.bdpushStr:" + pushBody.mBdPushStr);
        if (markMessageAsShown < 0) {
            Logger.m271e("PushMsgHandler", "failed show notification because updateMessageStatusResult is invalid!");
            return false;
        }
        if (z3) {
            return true;
        }
        PushReceiveHandler pushReceiveHandler = this.mPushReceiveHandler;
        if (pushReceiveHandler != null) {
            pushReceiveHandler.onReceivePushMsg(AppProvider.getApp(), i, pushBody, z, j);
            return true;
        }
        Logger.m271e("PushMsgHandler", "failed show notification because mPushReceiveHandler is null!");
        return true;
    }

    private boolean needInterceptNotificationShowBecauseBlackTimeWindow(PushBody pushBody) {
        MessageBlackTimeWindowSettingsModel messageBlackTimeWindowSettings = PushSetting.getInstance().getPushOnLineSettings().getMessageBlackTimeWindowSettings();
        if (!messageBlackTimeWindowSettings.needIntercept) {
            Logger.m268d("PushMsgHandler", "[needInterceptNotificationShowBecauseBlackTimeWindow] not intercept because settings.needIntercept is false");
            return false;
        }
        if (pushBody == null || !pushBody.allowInterceptInBlackTimeWindow) {
            Logger.m268d("PushMsgHandler", "[needInterceptNotificationShowBecauseBlackTimeWindow] not intercept because pushBody.allowInterceptInBlackTimeWindow is invalid");
            return false;
        }
        if (!messageBlackTimeWindowSettings.checkSettingsFormat()) {
            Logger.m271e("PushMsgHandler", "[needInterceptNotificationShowBecauseBlackTimeWindow] not intercept because beginTime and endTime is invalid");
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(11, messageBlackTimeWindowSettings.beginHour);
        calendar2.set(12, messageBlackTimeWindowSettings.beginMinute);
        calendar2.set(13, 0);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(11, messageBlackTimeWindowSettings.endHour);
        calendar3.set(12, messageBlackTimeWindowSettings.endMinute);
        calendar3.set(13, 0);
        if (calendar.before(calendar3)) {
            Logger.m268d("PushMsgHandler", "[needInterceptNotificationShowBecauseBlackTimeWindow] nowCalendar before endCalendar , reduce beginCalendar day");
            calendar2.add(5, -messageBlackTimeWindowSettings.endDay);
        } else {
            Logger.m268d("PushMsgHandler", "[needInterceptNotificationShowBecauseBlackTimeWindow] nowCalendar after endCalendar , add endCalendar day");
            calendar3.add(5, messageBlackTimeWindowSettings.endDay);
        }
        if (!calendar2.after(calendar3)) {
            boolean z = calendar.after(calendar2) && calendar.before(calendar3);
            Logger.m268d("PushMsgHandler", String.format("[needInterceptNotificationShowBecauseBlackTimeWindow] result of add day is %b", Boolean.valueOf(z)));
            if (z) {
                NotificationTimer.getNotificationTimer().startNotificationShowTask((calendar3.getTimeInMillis() - calendar.getTimeInMillis()) + 60000);
                return true;
            }
        }
        return false;
    }

    private void onNotificationShowEvent(final int i, final PushBody pushBody, final boolean z, final boolean z2, final String str, final long j) {
        ThreadPlus.runOnChildThread(new Runnable() { // from class: com.bytedance.push.notification.PushMsgHandler.3
            @Override // java.lang.Runnable
            public void run() {
                if (pushBody != null) {
                    final JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(PushConst.KEY_RULE_ID, pushBody.f84id);
                        jSONObject.put("rule_id64", pushBody.rid64);
                        jSONObject.put("sender", i);
                        if (i == 2 && pushBody.getProxySender() != -1) {
                            jSONObject.put("sender", pushBody.getProxySender());
                        }
                        jSONObject.put("push_sdk_version", String.valueOf(30919));
                        jSONObject.put("push_sdk_version_name", "3.9.19-alpha.51");
                        jSONObject.put("ttpush_sec_target_uid", pushBody.targetSecUid);
                        jSONObject.put("local_sec_uid", PushMsgHandler.access$000());
                        jSONObject.put("push_show_type", pushBody.pushShowType);
                        int proxyOriginAPP = pushBody.getProxyOriginAPP();
                        int proxyTargetAPP = pushBody.getProxyTargetAPP();
                        if (proxyOriginAPP != -1) {
                            jSONObject.put("origin_app", proxyOriginAPP);
                        }
                        if (proxyTargetAPP != -1) {
                            jSONObject.put("target_app", proxyTargetAPP);
                        }
                        jSONObject.put("is_self", PushMsgHandler.hasLoggedInBefore(pushBody.targetSecUid) ? "1" : ViewVisibleBridge.INVISIBLE);
                        jSONObject.put("client_time", ToolUtils.currentTimeMillis());
                        long j2 = j;
                        if (j2 > 0) {
                            jSONObject.put(MultiProcessPushMessageDatabaseHelper.COL_ARRIVE_TIME, j2);
                        }
                        jSONObject.put(MultiProcessPushMessageDatabaseHelper.COL_HANDLE_BY_SDK, z);
                        jSONObject.put("message_expired", z2);
                        jSONObject.put("server_client_intelligence_push_show_mode", pushBody.clientIntelligencePushShowMode);
                        jSONObject.put("server_client_intelligence_push_show_sub_mode", pushBody.clientIntelligencePushShowSubMode);
                        jSONObject.put("client_intelligence_push_show_mode", PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().clientIntelligencePushShowMode);
                        jSONObject.put("client_intelligence_push_show_sub_mode", PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().clientIntelligencePushShowSubMode);
                        jSONObject.put("show_reason", str);
                        if (pushBody.mBdPushStr != null) {
                            jSONObject.put("push_style", pushBody.mBdPushStr);
                        }
                        if (!TextUtils.isEmpty(pushBody.groupId)) {
                            jSONObject.put("ttpush_group_id", pushBody.groupId);
                        }
                        if (pushBody.eventExtra != null) {
                            jSONObject.put("ttpush_event_extra", pushBody.eventExtra);
                        }
                        if (pushBody.minDisplayIntervalFromLastMsg >= 0) {
                            jSONObject.put("min_display_interval_from_last_msg", pushBody.minDisplayIntervalFromLastMsg);
                        }
                        if (pushBody.minDisplayIntervalFromForeground >= 0) {
                            jSONObject.put("min_display_interval_from_foreground", pushBody.minDisplayIntervalFromForeground);
                        }
                        FeatureCollectionHelper.getInstance(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication).getFeatureForEventReport(new IFeatureCallBack() { // from class: com.bytedance.push.notification.PushMsgHandler.3.1
                            public void onFeatureCallBack(JSONObject jSONObject2) {
                                if (jSONObject2 != null) {
                                    try {
                                        jSONObject.put(FeatureConnectionConstant.CLIENT_FEATURE, jSONObject2);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                                PushSupporter.get().getMultiProcessEventSenderService().onEventV3(i == 2, "notification_show_ug", jSONObject);
                            }
                        }, "event_notification_show_ug");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.bytedance.push.interfaze.IPushMsgHandler
    public void handlePassThroughMsg(String str, int i, String str2) {
        try {
            try {
                String messageV2 = PushSupporter.thirdService().getMessageV2(i, str.getBytes(), false);
                if (messageV2 != null) {
                    str = messageV2;
                }
            } catch (Exception unused) {
                Logger.m268d(IPushService.TAG_PUSH_SHOW, "message handler error");
            }
            handlePassThroughMsg(new JSONObject(str), i, str2);
        } catch (JSONException e) {
            PushSupporter.monitor().monitorEvent("handle_pass_through_msg", "handle_pass_through_msg_exception_" + i + RomVersionParamHelper.SEPARATOR + Log.getStackTraceString(e));
            e.printStackTrace();
        }
    }

    private void onShowEvent(final int i, PushBody pushBody, boolean z, boolean z2, boolean z3, String str) {
        final JSONObject jSONObject;
        if (pushBody != null) {
            jSONObject = buildPushShowEventParams(i, pushBody, z, z2, z3, str);
            PushSupporter.get().getMessageCallbackService().onMessageArrive(pushBody, jSONObject);
        } else {
            jSONObject = null;
        }
        Runnable runnable = new Runnable() { // from class: com.bytedance.push.notification.PushMsgHandler.4
            @Override // java.lang.Runnable
            public void run() {
                if (jSONObject != null) {
                    FeatureCollectionHelper.getInstance(PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mApplication).getFeatureForEventReport(new IFeatureCallBack() { // from class: com.bytedance.push.notification.PushMsgHandler.4.1
                        public void onFeatureCallBack(JSONObject jSONObject2) {
                            if (jSONObject2 != null) {
                                try {
                                    jSONObject.put(FeatureConnectionConstant.CLIENT_FEATURE, jSONObject2);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            PushSupporter.get().getMultiProcessEventSenderService().onEventV3(i == 2, "push_show_ug", jSONObject);
                        }
                    }, "event_push_show_ug");
                }
            }
        };
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadPlus.submitRunnable(runnable);
        } else {
            runnable.run();
        }
    }

    private JSONObject buildPushShowEventParams(int i, PushBody pushBody, boolean z, boolean z2, boolean z3, String str) {
        JSONObject jSONObject = new JSONObject();
        if (pushBody != null) {
            try {
                jSONObject.put(PushConst.KEY_RULE_ID, pushBody.f84id);
                jSONObject.put("rule_id64", pushBody.rid64);
                jSONObject.put("sender", i);
                if (i == 2 && pushBody.getProxySender() != -1) {
                    jSONObject.put("sender", pushBody.getProxySender());
                }
                jSONObject.put("push_sdk_version", String.valueOf(30919));
                jSONObject.put("push_sdk_version_name", "3.9.19-alpha.51");
                jSONObject.put("ttpush_sec_target_uid", pushBody.targetSecUid);
                jSONObject.put("local_sec_uid", getSecUid());
                jSONObject.put("push_show_type", pushBody.pushShowType);
                int proxyOriginAPP = pushBody.getProxyOriginAPP();
                int proxyTargetAPP = pushBody.getProxyTargetAPP();
                if (proxyOriginAPP != -1) {
                    jSONObject.put("origin_app", proxyOriginAPP);
                }
                if (proxyTargetAPP != -1) {
                    jSONObject.put("target_app", proxyTargetAPP);
                }
                jSONObject.put("client_time", ToolUtils.currentTimeMillis());
                String str2 = "1";
                jSONObject.put("real_filter", z ? "1" : ViewVisibleBridge.INVISIBLE);
                jSONObject.put("is_duplicate", z2 ? "1" : ViewVisibleBridge.INVISIBLE);
                if (!z3) {
                    str2 = ViewVisibleBridge.INVISIBLE;
                }
                jSONObject.put(MultiProcessPushMessageDatabaseHelper.HAS_BEEN_SHOWN, str2);
                jSONObject.put("is_revoke", pushBody.revokeId > 0);
                jSONObject.put("server_client_intelligence_push_show_mode", pushBody.clientIntelligencePushShowMode);
                jSONObject.put("server_client_intelligence_push_show_sub_mode", pushBody.clientIntelligencePushShowSubMode);
                jSONObject.put("client_intelligence_push_show_mode", PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().clientIntelligencePushShowMode);
                jSONObject.put("client_intelligence_push_show_sub_mode", PushSupporter.get().getClientIntelligenceService().getClientIntelligenceSettings().clientIntelligencePushShowSubMode);
                if (pushBody.minDisplayIntervalFromLastMsg >= 0) {
                    jSONObject.put("min_display_interval_from_last_msg", pushBody.minDisplayIntervalFromLastMsg);
                }
                if (pushBody.minDisplayIntervalFromForeground >= 0) {
                    jSONObject.put("min_display_interval_from_foreground", pushBody.minDisplayIntervalFromForeground);
                }
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("show_reason", str);
                }
                if (pushBody.mBdPushStr != null) {
                    jSONObject.put("push_style", pushBody.mBdPushStr);
                }
                if (!TextUtils.isEmpty(pushBody.groupId)) {
                    jSONObject.put("ttpush_group_id", pushBody.groupId);
                }
                if (pushBody.eventExtra != null) {
                    jSONObject.put("ttpush_event_extra", pushBody.eventExtra);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private boolean shouldDiscardMsg(PushBody pushBody) {
        if (pushBody == null) {
            Logger.m268d(IPushService.TAG_PUSH_SHOW, "PushBody is null,filter");
            return true;
        }
        if (TextUtils.isEmpty(pushBody.targetSecUid)) {
            return false;
        }
        IAccountService iAccountService = PushSupporter.get().getConfiguration().mAccountService;
        if (iAccountService != null) {
            return pushBody.needFilterMsgByUid && !TextUtils.equals(iAccountService.getSecUid(), pushBody.targetSecUid);
        }
        Logger.m268d(IPushService.TAG_PUSH_SHOW, "account service is null，not filter");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasLoggedInBefore(String str) {
        IAccountService service = UgBusFramework.getService(IAccountService.class);
        if (service == null || TextUtils.isEmpty(str)) {
            Logger.m268d(IPushService.TAG_PUSH_SHOW, "account service is null，hasLoggedInBefore return false");
            return false;
        }
        if (TextUtils.equals(str, getSecUid())) {
            return true;
        }
        List loginHistoryUids = service.getLoginHistoryUids();
        return loginHistoryUids != null && loginHistoryUids.contains(str);
    }

    private static String getSecUid() {
        IAccountService iAccountService = PushSupporter.get().getConfiguration().mAccountService;
        if (iAccountService == null) {
            return "";
        }
        String secUid = iAccountService.getSecUid();
        return !TextUtils.isEmpty(secUid) ? secUid : "";
    }

    @Override // com.bytedance.push.interfaze.IPushMsgHandler
    public boolean onClickMsg(Context context, String str, int i, String str2) {
        if (this.mDeboundingClickHelper.isDeboundClick(str, i)) {
            PushSupporter.logger().mo247e(IPushService.TAG_PUSH_CLICK, "onClickMsg#repeat click:" + str + ", from = " + i);
            return false;
        }
        try {
            PushBody pushBody = new PushBody(new JSONObject(str));
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("client_time", System.currentTimeMillis());
                jSONObject.put(PushConst.KEY_RULE_ID, pushBody.f84id);
                jSONObject.put("rule_id64", pushBody.rid64);
                jSONObject.put("ttpush_group_id", pushBody.groupId);
                jSONObject.put("sender", String.valueOf(i));
                jSONObject.put("click_position", "notify");
            } catch (Throwable th) {
                PushSupporter.logger().mo247e(IPushService.TAG_PUSH_CLICK, "onClickMsg#error when call back click:" + th.getLocalizedMessage());
            }
            PushSupporter.get().getMessageCallbackService().onMessageClick(pushBody.callbackClick, jSONObject);
            OnPushClickListener onPushClickListener = this.mOnPushClickListener;
            JSONObject addClickFrom = addClickFrom(onPushClickListener != null ? onPushClickListener.onClickPush(context, i, pushBody, str2) : null, i);
            if (!this.mConfiguration.forbidSDKClickEvent) {
                trackClickPush(context, pushBody, true, addClickFrom);
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
            PushSupporter.logger().mo247e(IPushService.TAG_PUSH_CLICK, "exception:" + e.getLocalizedMessage());
            return false;
        }
    }

    private JSONObject addClickFrom(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(jSONObject.optString("sender"))) {
            jSONObject.put("sender", i);
        }
        return jSONObject;
    }

    @Override // com.bytedance.push.interfaze.IPushMsgHandler
    public void trackClickPush(Context context, long j, String str, String str2, boolean z, JSONObject jSONObject, boolean z2) {
        PushCommonConfiguration pushCommonConfiguration = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        Logger.m274i("PushMsgHandler", "[trackClickPush]stack:" + Log.getStackTraceString(new Throwable()));
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("rule_id64"))) {
            if (pushCommonConfiguration.mIsDebugMode && pushCommonConfiguration.mIPushCommonConfiguration.enableExceptionInDebugModeWhenFatalError()) {
                throw new IllegalArgumentException("rule_id64 is empty，please set effective rule_id64 for push click event !!");
            }
            Logger.m271e("PushMsgHandler", "rule_id64 is empty，please set effective rule_id64 for push click event !!");
        }
        if (jSONObject == null || TextUtils.isEmpty(jSONObject.optString("sender"))) {
            if (pushCommonConfiguration.mIsDebugMode && pushCommonConfiguration.mIPushCommonConfiguration.enableExceptionInDebugModeWhenFatalError()) {
                throw new IllegalArgumentException("sender is empty，please set effective sender(from) for push click event !!");
            }
            Logger.m271e("PushMsgHandler", "sender is empty，please set effective sender(from) for push click event !!");
        }
        JSONObject buildPushClickEventParams = buildPushClickEventParams(j, str, str2, z, jSONObject);
        if (buildPushClickEventParams == null) {
            buildPushClickEventParams = new JSONObject();
        } else {
            PushSupporter.get().getMessageCallbackService().onMessageClick(z2, buildPushClickEventParams);
        }
        RunnableC06305 runnableC06305 = new RunnableC06305(j, buildPushClickEventParams, context);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadPlus.submitRunnable(runnableC06305);
        } else {
            runnableC06305.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.push.notification.PushMsgHandler$5 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class RunnableC06305 implements Runnable {
        final /* synthetic */ Context val$context;
        final /* synthetic */ JSONObject val$finalParam;
        final /* synthetic */ long val$ruleId;

        RunnableC06305(long j, JSONObject jSONObject, Context context) {
            this.val$ruleId = j;
            this.val$finalParam = jSONObject;
            this.val$context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (PushMsgHandler.this.mClickedRids) {
                if (!PushMsgHandler.this.mClickedRids.contains(Long.valueOf(this.val$ruleId))) {
                    PushMsgHandler.this.mClickedRids.add(Long.valueOf(this.val$ruleId));
                    FeatureCollectionHelper.getInstance(this.val$context).getFeatureForEventReport(new IFeatureCallBack() { // from class: com.bytedance.push.notification.PushMsgHandler.5.1
                        public void onFeatureCallBack(JSONObject jSONObject) {
                            if (jSONObject != null) {
                                try {
                                    RunnableC06305.this.val$finalParam.put(FeatureConnectionConstant.CLIENT_FEATURE, jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            PushSupporter.logger().mo250i(IPushService.TAG_PUSH_CLICK, "push_click:" + RunnableC06305.this.val$finalParam);
                            final PushClickReportOptSettingsModel pushClickReportOptSettingsModel = PushSetting.getInstance().getPushOnLineSettings().getPushClickReportOptSettingsModel();
                            if (pushClickReportOptSettingsModel != null) {
                                PushSupporter.logger().mo250i(IPushService.TAG_PUSH_CLICK, "[trackClickPush]optPushClickSessionId:" + pushClickReportOptSettingsModel.optPushClickSessionId);
                                if (pushClickReportOptSettingsModel.optPushClickSessionId) {
                                    boolean z = !ActivityLifecycleObserver.getIns().isBackGround();
                                    PushSupporter.logger().mo250i(IPushService.TAG_PUSH_CLICK, "[trackClickPush]isInForeground:" + z + " minDelayTimeInMill:" + pushClickReportOptSettingsModel.minDelayTimeInMill);
                                    if (z) {
                                        long lastForeGroundTime = ActivityLifecycleObserver.getIns().getLastForeGroundTime();
                                        long currentTimeMillis = System.currentTimeMillis() - lastForeGroundTime;
                                        long j = pushClickReportOptSettingsModel.minDelayTimeInMill;
                                        if (lastForeGroundTime > 0 && currentTimeMillis >= pushClickReportOptSettingsModel.minDelayTimeInMill) {
                                            j = 0;
                                        }
                                        PushMsgHandler.this.reportPushClickForSessionId(j, RunnableC06305.this.val$finalParam);
                                    } else {
                                        PushSupporter.logger().mo250i(IPushService.TAG_PUSH_CLICK, "[trackClickPush]delay report push_click until app to foreground");
                                        final boolean[] zArr = {false};
                                        ActivityLifecycleObserver.getIns().addObserver(new Observer() { // from class: com.bytedance.push.notification.PushMsgHandler.5.1.1
                                            @Override // java.util.Observer
                                            public void update(Observable observable, Object obj) {
                                                boolean z2 = !((Boolean) obj).booleanValue();
                                                if (z2) {
                                                    synchronized (zArr) {
                                                        if (!zArr[0]) {
                                                            PushSupporter.logger().mo250i(IPushService.TAG_PUSH_CLICK, "[trackClickPush]on app status changed,isInForeGround:" + z2);
                                                            zArr[0] = true;
                                                            PushMsgHandler.this.reportPushClickForSessionId(pushClickReportOptSettingsModel.minDelayTimeInMill, RunnableC06305.this.val$finalParam);
                                                        }
                                                    }
                                                    ActivityLifecycleObserver.getIns().deleteObserver(this);
                                                }
                                            }
                                        });
                                        if (!ActivityLifecycleObserver.getIns().isBackGround()) {
                                            synchronized (zArr) {
                                                if (!zArr[0]) {
                                                    PushSupporter.logger().mo250i(IPushService.TAG_PUSH_CLICK, "[trackClickPush]report click event because app to foreground after add Observer");
                                                    zArr[0] = true;
                                                    PushMsgHandler.this.reportPushClickForSessionId(pushClickReportOptSettingsModel.minDelayTimeInMill, RunnableC06305.this.val$finalParam);
                                                }
                                            }
                                        }
                                        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.notification.PushMsgHandler.5.1.2
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                synchronized (zArr) {
                                                    if (!zArr[0]) {
                                                        PushSupporter.logger().mo250i(IPushService.TAG_PUSH_CLICK, "[trackClickPush]backup report click after maxDelayTimeInMill");
                                                        zArr[0] = true;
                                                        PushMsgHandler.this.reportPushClickForSessionId(0L, RunnableC06305.this.val$finalParam);
                                                    }
                                                }
                                            }
                                        }, pushClickReportOptSettingsModel.maxDelayTimeInMill);
                                    }
                                }
                            }
                            PushSupporter.logger().mo250i(IPushService.TAG_PUSH_CLICK, "default report push_click");
                            PushMsgHandler.this.mEventImpl.onEventV3("push_click", RunnableC06305.this.val$finalParam);
                            if (RunnableC06305.this.val$ruleId <= 0) {
                                PushSupporter.logger().mo247e(IPushService.TAG_PUSH_CLICK, "error ruleId:" + RunnableC06305.this.val$ruleId);
                            }
                        }
                    }, "event_push_click");
                } else {
                    PushSupporter.logger().mo247e(IPushService.TAG_PUSH_CLICK, "duplication click:" + this.val$finalParam);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPushClickForSessionId(long j, final JSONObject jSONObject) {
        PushSupporter.logger().mo250i(IPushService.TAG_PUSH_CLICK, "[reportPushClickForSessionId]minDelayTimeInMill:" + j);
        PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.notification.PushMsgHandler.6
            @Override // java.lang.Runnable
            public void run() {
                PushSupporter.logger().mo250i(IPushService.TAG_PUSH_CLICK, "[reportPushClickForSessionId]report bdpush_push_click_for_session_id now");
                PushMsgHandler.this.mEventImpl.onEventV3("bdpush_push_click_for_session_id", jSONObject);
            }
        }, j);
    }

    private JSONObject buildPushClickEventParams(long j, String str, String str2, boolean z, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (PushServiceManager.get().getIPushNotificationService().isClickByBanner(j)) {
            jSONObject.put("click_position", "banner");
        }
        if (TextUtils.isEmpty(jSONObject.optString("click_position"))) {
            if (z) {
                jSONObject.put("click_position", "notify");
            } else {
                jSONObject.put("click_position", "alert");
            }
        }
        jSONObject.put("ttpush_sec_target_uid", str2);
        jSONObject.put("local_sec_uid", getSecUid());
        jSONObject.put("client_time", ToolUtils.currentTimeMillis());
        jSONObject.put("real_filter", ViewVisibleBridge.INVISIBLE);
        jSONObject.put(PushConst.KEY_RULE_ID, j);
        jSONObject.put("push_sdk_version", String.valueOf(30919));
        jSONObject.put("push_sdk_version_name", "3.9.19-alpha.51");
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("ttpush_group_id", str);
        }
        PushBody revokedMsg = ((IPassThoughMsgCache) UgBusFramework.getService(IPassThoughMsgCache.class)).getRevokedMsg(j);
        if (revokedMsg != null && revokedMsg.eventExtra != null) {
            jSONObject.put("ttpush_event_extra", revokedMsg.eventExtra);
        }
        return jSONObject;
    }

    @Override // com.bytedance.push.interfaze.IPushMsgHandler
    public void trackClickPush(Context context, Intent intent, String str, JSONObject jSONObject) {
        String stringExtra = intent.getStringExtra("push_body");
        if (!TextUtils.isEmpty(stringExtra)) {
            try {
                PushBody pushBody = new PushBody(new JSONObject(stringExtra));
                JSONObject parseRuleId64 = parseRuleId64(pushBody, jSONObject);
                parseRuleId64.put("push_show_type", pushBody.pushShowType);
                trackClickPush(context, pushBody, true, parseRuleId64);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        trackClickPush(context, parseRuleId(intent), null, str, true, jSONObject, false);
    }

    @Override // com.bytedance.push.interfaze.IPushMsgHandler
    public void trackClickPush(Context context, PushBody pushBody, boolean z, JSONObject jSONObject) {
        if (pushBody != null) {
            JSONObject parseRuleId64 = parseRuleId64(pushBody, jSONObject);
            try {
                parseRuleId64.put("push_show_type", pushBody.pushShowType);
                if (pushBody.eventExtra != null) {
                    parseRuleId64.put("ttpush_event_extra", pushBody.eventExtra);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            trackClickPush(context, pushBody.f84id, pushBody.groupId, pushBody.targetSecUid, z, parseRuleId64, pushBody.callbackClick);
        }
    }

    private long parseRuleId(Intent intent) {
        long longExtra = SmartIntentUtil.getLongExtra(intent, NotificationDeleteBroadcastReceiver.KEY_MSG_ID, 0L);
        return longExtra <= 0 ? SmartIntentUtil.getIntExtra(intent, NotificationDeleteBroadcastReceiver.KEY_MSG_ID, 0) : longExtra;
    }

    private JSONObject parseRuleId64(PushBody pushBody, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(jSONObject.optString("rule_id64"))) {
            jSONObject.put("rule_id64", pushBody.rid64);
        }
        return jSONObject;
    }

    @Override // com.bytedance.push.interfaze.IPushMsgHandler
    public void trySupplyIntentData(Intent intent) {
        Uri data = intent.getData();
        if (data == null || TextUtils.isEmpty(data.toString()) || data.isOpaque()) {
            return;
        }
        String stringExtra = intent.getStringExtra("push_body");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(stringExtra);
            String optString = jSONObject.optString("open_url", "");
            if (TextUtils.isEmpty(optString) || !optString.contains("need_supply_url_params")) {
                return;
            }
            jSONObject.put("open_url", data.toString());
            intent.putExtra("push_body", jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
