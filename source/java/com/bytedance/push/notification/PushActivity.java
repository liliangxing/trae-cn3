package com.bytedance.push.notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.notification.PushNotificationButtonInfo;
import com.bytedance.lynx.service.reporter.performance.LynxTimingPerformanceReportProcessor;
import com.bytedance.notification.Constants;
import com.bytedance.push.PushBody;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.event.sync.ISignalReportConstants;
import com.bytedance.push.interfaze.IEventSender;
import com.bytedance.push.interfaze.IPushMsgHandler;
import com.bytedance.push.interfaze.ISDKMonitor;
import com.bytedance.push.interfaze.IVerifyFailedListener;
import com.bytedance.push.safe.IPassThoughMsgCache;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.utils.Logger;
import com.bytedance.push.utils.OpenUrlUtils;
import com.bytedance.push.utils.SignUtils;
import com.bytedance.push.utils.ZlibUtil;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.push.SmartIntentUtil;
import com.ss.android.ug.bus.UgBusFramework;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class PushActivity extends Activity {
    private static final String EXTRA_SIG = "sig";
    private static final String PUBLIC_KEY = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEul5lp8sfpVIXgDHaLBjSYt4h0vSF\nSxh0kbpM5nXdkrz8UxQuIOYKO2PzySqmzxL5Ts3rHbMzG8wV+QzS0DVKBQ==";
    private static final String TAG = "PushActivity";

    protected boolean isPassThough() {
        return false;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        parseIntent();
        finish();
    }

    private void parseIntent() {
        Intent intent = getIntent();
        if (intent == null) {
            onPushActivityCreateEvent(true, null, false, -1, false, "intent is null");
            PushSupporter.logger().mo247e(TAG, "intent is null");
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras != null) {
            for (String str : extras.keySet()) {
                PushSupporter.logger().mo245d(TAG, "onCreate: key = " + str + " , val = " + extras.get(str));
            }
        }
        boolean booleanExtra = SmartIntentUtil.getBooleanExtra(intent, "from_notification", false);
        String stringExtra = intent.getStringExtra(EXTRA_SIG);
        String stringExtra2 = intent.getStringExtra("push_body");
        String checkButtonInfo = checkButtonInfo(intent.getIntExtra("id", 0), intent.getStringExtra(Constants.NOTIFICATION_TAG), (PushNotificationButtonInfo) intent.getParcelableExtra(Constants.NOTIFICATION_BUTTON_INFO), stringExtra2);
        if (!booleanExtra) {
            PushSupporter.logger().mo247e(TAG, "fromNotification = false");
            onPushActivityCreateEvent(false, stringExtra2, booleanExtra, -1, false, "fromNotification is false");
            return;
        }
        if (TextUtils.isEmpty(stringExtra2)) {
            PushSupporter.logger().mo247e(TAG, "msgBody is null");
            onPushActivityCreateEvent(false, stringExtra2, booleanExtra, -1, false, "msgBody is empty");
            return;
        }
        int checkSign = ((PushOnlineSettings) SettingsManager.obtain(getApplicationContext(), PushOnlineSettings.class)).checkSign();
        boolean checkSource = checkSource(stringExtra2, stringExtra, checkSign);
        int intExtra = SmartIntentUtil.getIntExtra(intent, "message_from", 0);
        try {
            if (PushChannelHelper.inst(getApplicationContext()).isDirectOpenActivitySender(intExtra)) {
                if (PushChannelHelper.inst(getApplicationContext()).isNeedUnzip(intExtra)) {
                    stringExtra2 = ZlibUtil.uncompressToString(Base64.decode(stringExtra2, 8));
                    Logger.m268d(TAG, "Unzipped msgBody is : " + stringExtra2);
                }
                JSONObject jSONObject = new JSONObject(stringExtra2);
                jSONObject.put(PushBody.KEY_PASS_THROUGH, 0);
                stringExtra2 = jSONObject.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        IPushMsgHandler pushHandler = PushSupporter.pushHandler();
        if (checkSource) {
            boolean onClickMsg = pushHandler.onClickMsg(this, stringExtra2, intExtra, checkButtonInfo);
            onPushActivityCreateEvent(false, stringExtra2, booleanExtra, checkSign, onClickMsg, onClickMsg ? "success" : "click error");
            return;
        }
        IVerifyFailedListener iVerifyFailedListener = PushSupporter.get().getConfiguration().verifyFailedListener;
        if (iVerifyFailedListener != null) {
            try {
                iVerifyFailedListener.onVerifyFailed(this, new PushBody(new JSONObject(stringExtra2)), intExtra);
            } catch (JSONException e2) {
                e2.printStackTrace();
                onPushActivityCreateEvent(false, stringExtra2, booleanExtra, checkSign, false, "exception:" + e2.getLocalizedMessage());
                return;
            }
        }
        onPushActivityCreateEvent(false, stringExtra2, booleanExtra, checkSign, false, "verify failed");
    }

    private boolean checkSource(String str, String str2, int i) {
        Logger.m277v(TAG, "checkSource " + str);
        if (i <= 0) {
            return true;
        }
        if (isPassThough() || ((IPassThoughMsgCache) UgBusFramework.getService(IPassThoughMsgCache.class)).isFromPassThough(str)) {
            Logger.m277v(TAG, "checkSource true " + str);
            return true;
        }
        long currentTimeMillis = ToolUtils.currentTimeMillis();
        if (!TextUtils.isEmpty(str2)) {
            SignUtils.Result verifySign = SignUtils.verifySign(str, PUBLIC_KEY, str2);
            monitorVerifyResult(verifySign.result, verifySign.msg, ToolUtils.currentTimeMillis() - currentTimeMillis, str, str2);
            if (verifySign.result) {
                Logger.m277v(TAG, "sign success" + str);
            } else {
                Logger.m271e(TAG, "verify sign failed");
            }
            if (i < 2) {
                return true;
            }
            return verifySign.result;
        }
        Logger.m271e(TAG, "sign is null or isn't string");
        monitorVerifyResult(false, "sign is empty", ToolUtils.currentTimeMillis() - currentTimeMillis, str, str2);
        return i < 2;
    }

    private String checkButtonInfo(int i, String str, PushNotificationButtonInfo pushNotificationButtonInfo, String str2) {
        if (pushNotificationButtonInfo == null || i == 0) {
            return OpenUrlUtils.getOpenUrl(pushNotificationButtonInfo, str2);
        }
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        if (notificationManager != null && Build.VERSION.SDK_INT >= 26) {
            notificationManager.cancel(str, i);
        }
        String str3 = pushNotificationButtonInfo.mButtonToast;
        if (str3 != null && !str3.isEmpty()) {
            Toast.makeText(getApplicationContext(), str3, 1).show();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", i);
            jSONObject.put(Constants.NOTIFICATION_BUTTON_INFO, pushNotificationButtonInfo.toJsonForEventV3());
        } catch (JSONException e) {
            Logger.m271e(getClass().getSimpleName(), e.getMessage());
        }
        PushServiceManager.get().getPushExternalService().getMultiProcessEventSenderService().onEventV3(Constants.NOTIFICATION_BUTTON_CLICK, jSONObject);
        return OpenUrlUtils.getOpenUrl(pushNotificationButtonInfo, str2);
    }

    private void monitorVerifyResult(boolean z, String str, long j, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject.put(ISignalReportConstants.KEY_REASON, str);
            jSONObject.put(LynxTimingPerformanceReportProcessor.KEY_DURATION, j);
            jSONObject2.put("msg_body", str2);
            jSONObject2.put(EXTRA_SIG, str3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((ISDKMonitor) UgBusFramework.getService(ISDKMonitor.class)).monitorStatusAndDuration("push_source_verify_sign_v2", z ? 1 : 0, jSONObject, jSONObject2);
    }

    private void onPushActivityCreateEvent(boolean z, String str, boolean z2, int i, boolean z3) {
        onPushActivityCreateEvent(z, str, z2, i, z3, "success");
    }

    private void onPushActivityCreateEvent(boolean z, String str, boolean z2, int i, boolean z3, String str2) {
        IEventSender iEventSender = PushSupporter.get().getConfiguration().mEventCallback;
        if (iEventSender != null) {
            JSONObject jSONObject = new JSONObject();
            int i2 = 1;
            try {
                jSONObject.put("intent_is_null", z ? 1 : 0);
                jSONObject.put("from_notification", z2 ? 1 : 0);
                jSONObject.put("sign_flag", i);
                if (!z3) {
                    i2 = 0;
                }
                jSONObject.put("verify_success", i2);
                jSONObject.put("jump_result", str2);
                if (!TextUtils.equals(str2, "success") && !TextUtils.isEmpty(str)) {
                    jSONObject.put("push_body", str);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            iEventSender.onEventV3("push_activity_on_create", jSONObject);
        }
    }
}
