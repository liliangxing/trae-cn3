package com.bytedance.push.monitor;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.notification.Constants;
import com.bytedance.perf.monitor.ReportConst;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.frontier.interfaze.IFrontierMonitor;
import com.bytedance.push.interfaze.IPushService;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SenderMonitor {
    private static WeakHandler.IHandler handler = new WeakHandler.IHandler() { // from class: com.bytedance.push.monitor.SenderMonitor.1
        public void handleMsg(Message message) {
            SenderMonitor.handleMsg(message);
        }
    };
    private static Handler sHandler = new WeakHandler(PushMonitor.getLooper(), handler);
    private static final Map<Integer, Boolean> sSenderRegisterResult = new ConcurrentHashMap(2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void markUpdateSenderFailed(int i, int i2, String str, String str2) {
        String str3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IFrontierMonitor.KEY_LOG, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        switch (i) {
            case 301:
                str3 = "network error";
                break;
            case 302:
                str3 = "server return error";
                break;
            case 303:
                str3 = "server return empty allow_push_list";
                break;
            case 304:
                str3 = "update_sender api return empty";
                break;
            default:
                str3 = "";
                break;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("code", i);
            jSONObject2.put("detailCode", i2);
            jSONObject2.put("msg", str3);
            jSONObject2.put("detailMsg", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            new JSONObject().put("extraMsg", TextUtils.isEmpty(str2) ? "null" : str2);
        } catch (JSONException e3) {
            e3.printStackTrace();
        }
        PushMonitor.monitorEvent(IPushMonitor.EVENT_APPLOG_UPDATE_SENDER, jSONObject2, null, jSONObject);
        Logger.m271e(IPushService.TAG_PUSH_MONITOR, "Push Sender Monitor: update sender error, reason: " + str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void markUpdateSenderSuccess() {
        Logger.m274i(IPushService.TAG_PUSH_MONITOR, "Push Sender Monitor: update sender success");
        sendUpdateSenderResultToMonitor(0, null, "update sender success");
    }

    private static void sendUpdateSenderResultToMonitor(int i, JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("status", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PushMonitor.monitorEvent(IPushMonitor.EVENT_APPLOG_UPDATE_SENDER, jSONObject2, null, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void monitorRegisterSenderResult(boolean z, String str) {
        if (z) {
            Logger.m274i(IPushService.TAG_PUSH_MONITOR, "Push Sender Monitor: get sender success");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", 107);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("sender", str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        PushMonitor.monitorEvent(IPushMonitor.EVENT_APPLOG_REGISTER_RESULT, jSONObject, null, jSONObject2);
        Logger.m271e(IPushService.TAG_PUSH_MONITOR, "Push Sender Monitor: This device does not support the sender/channel delivered by the server");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void doRegisterPush(int i) {
        Map<Integer, Boolean> map = sSenderRegisterResult;
        synchronized (map) {
            if (map.get(Integer.valueOf(i)) != null) {
                return;
            }
            map.put(Integer.valueOf(i), true);
            sHandler.sendMessageDelayed(sHandler.obtainMessage(1001, Integer.valueOf(i)), TimeUnit.MINUTES.toMillis(1L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void doRegisterPushFailed(int i, int i2, String str, String str2) {
        Map<Integer, Boolean> map = sSenderRegisterResult;
        synchronized (map) {
            Boolean bool = map.get(Integer.valueOf(i));
            if (bool != null && bool.booleanValue()) {
                map.put(Integer.valueOf(i), false);
                cancelTimeout(i);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("pushType", i);
                    jSONObject.put("status", i2);
                    jSONObject.put("3rd_code", str);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("msg", str2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                Logger.m271e(IPushService.TAG_PUSH_MONITOR, PushChannelHelper.inst(AppProvider.getApp()).getSenderNameById(i) + " register failed，reason: " + str2);
                PushMonitor.monitorEvent(IPushMonitor.EVENT_APPLOG_REGISTER_RESULT, jSONObject, null, jSONObject2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void doRegisterPushSuccess(int i) {
        Map<Integer, Boolean> map = sSenderRegisterResult;
        synchronized (map) {
            Boolean bool = map.get(Integer.valueOf(i));
            if (bool != null && bool.booleanValue()) {
                map.put(Integer.valueOf(i), false);
                cancelTimeout(i);
                String str = PushChannelHelper.inst(AppProvider.getApp()).getSenderNameById(i) + " register success";
                Logger.m274i(IPushService.TAG_PUSH_MONITOR, "Push Sender Monitor: " + i + " register success");
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("status", 0);
                    jSONObject.put("pushType", i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                PushMonitor.monitorEvent(IPushMonitor.EVENT_APPLOG_REGISTER_RESULT, jSONObject, null, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void markOuterSwitchUploadSuccess() {
        Logger.m274i(IPushService.TAG_PUSH_MONITOR, "Push switcher monitor：the out-app switcher upload success");
        sendOuterSwitchUploadResultToMonitor(0, "the out-app switcher upload success", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void markOuterSwitchUploadFailed(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IFrontierMonitor.KEY_LOG, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String str2 = i != 301 ? i != 302 ? i != 304 ? "" : "Server return empty response" : "Server return not success" : "network error";
        sendOuterSwitchUploadResultToMonitor(i, str2, jSONObject);
        Logger.m271e(IPushService.TAG_PUSH_MONITOR, "Push switcher monitor：upload error，reason: ".concat(str2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void markOuterSwitchStatusSuccess() {
        Logger.m274i(IPushService.TAG_PUSH_MONITOR, "Push switcher monitor：the out-app switcher upload success");
        sendOuterSwitchStatusResultToMonitor(0, "the out-app switcher upload success", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void markOuterSwitchStatusFailed(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IFrontierMonitor.KEY_LOG, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String str2 = i != 301 ? i != 302 ? i != 304 ? "" : "Server return empty response" : "Server return not success" : "network error";
        sendOuterSwitchStatusResultToMonitor(i, str2, jSONObject);
        Logger.m271e(IPushService.TAG_PUSH_MONITOR, "Push switcher monitor：upload error，reason: ".concat(str2));
    }

    private static void sendOuterSwitchUploadResultToMonitor(int i, String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("status", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PushMonitor.monitorEvent(IPushMonitor.EVENT_OUTER_SWITCH_UPLOAD_RESULT, jSONObject2, null, jSONObject);
    }

    private static void sendOuterSwitchStatusResultToMonitor(int i, String str, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("status", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        PushMonitor.monitorEvent(IPushMonitor.EVENT_OUTER_SWITCH_STATUS_RESULT, jSONObject2, null, jSONObject);
    }

    private static void cancelTimeout(int i) {
        sHandler.removeMessages(1001, Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleMsg(Message message) {
        if (message != null && message.what == 1001) {
            String str = PushChannelHelper.inst(AppProvider.getApp()).getSenderNameById(((Integer) message.obj).intValue()) + " register timeout";
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("status", 108);
                jSONObject.put("pushType", message.obj);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Logger.m271e(IPushService.TAG_PUSH_MONITOR, "Push Sender Monitor:" + str);
            PushMonitor.monitorEvent(IPushMonitor.EVENT_APPLOG_REGISTER_RESULT, jSONObject, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void monitorDecryptResult(int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i2);
            jSONObject.put("pushType", i);
            PushMonitor.monitorEvent(IPushMonitor.EVENT_DECRYPT_RESULT, jSONObject, null, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void monitorShowEmpty(int i, String str, int i2, int i3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ReportConst.KEY_SCENE, i);
            jSONObject.put(Constants.NOTIFICATION_TAG, str);
            jSONObject.put("same", i2);
            jSONObject.put("result", i3);
            PushMonitor.monitorEvent(IPushMonitor.EVENT_MONITOR_SHOW_EMPTY, jSONObject, null, null);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void monitorHarmonyOs4Compliance(boolean z, int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("compliance", z);
            jSONObject.put(ISignalReportConstants.KEY_REASON, i);
            PushMonitor.monitorEvent(IPushMonitor.EVENT_MONITOR_HARMONY_OS4_COMPLIANCE, jSONObject, null, null);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void monitorEvent(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("eventType", str);
            jSONObject.put("eventDesc", str2);
            PushMonitor.monitorEvent(IPushMonitor.EVENT_COMMON_EVENT, jSONObject, null, null);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
