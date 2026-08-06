package com.bytedance.push.task;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.support.impl.PushNetworkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.lynx.scc.cloudservice.SccResult;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.interfaze.IThirdSupportService;
import com.bytedance.push.model.TokenCache;
import com.bytedance.push.settings.PushOnlineSettings;
import com.bytedance.push.settings.SettingsManager;
import com.bytedance.push.third.ISendTokenCallBack;
import com.bytedance.push.third.PushChannelHelper;
import com.bytedance.push.utils.Logger;
import com.bytedance.ug.sdk.deeplink.CommonConstants;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.MessageConstants;
import com.ss.android.pushmanager.app.MessageAppHooks;
import com.ss.android.pushmanager.setting.PushSetting;
import com.ss.android.ug.bus.UgBusFramework;
import com.ss.android.ug.bus.account.IAccountService;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SendTokenTask implements Runnable {
    private static final int MSG_SENT_TOKEN_FAIL = 10;
    private static final int MSG_SENT_TOKEN_SUCCESS = 11;
    private static final int MSG_WHAT_SENT_TOKEN = 1;
    private static final String TAG = "SendTokenTask";
    static final Object UPLOAD_TOKEN_LOCK = new Object();
    private static boolean sForceSendToken;
    private final ISendTokenCallBack mCallback;
    private Context mContext;
    private int error = 10;
    private final Handler mHandler = new Handler(PushThreadHandlerManager.inst().getLooper()) { // from class: com.bytedance.push.task.SendTokenTask.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            SendTokenTask.this.handleMsg(message);
        }
    };
    private int retryCount = 0;

    public static void forceSendToken(boolean z) {
        Logger.m274i(TAG, "set sForceSendToken to " + z);
        sForceSendToken = z;
    }

    public static void doSendToken(Context context, ISendTokenCallBack iSendTokenCallBack) {
        Logger.m268d(TAG, "sendTokenStack:" + Log.getStackTraceString(new Throwable()));
        ThreadPlus.submitRunnable(new SendTokenTask(context, iSendTokenCallBack));
    }

    public static String getToken(Context context, int i) {
        TokenCache bySenderType = TokenStorage.getBySenderType(context, i);
        if (bySenderType == null) {
            return null;
        }
        return bySenderType.token;
    }

    private SendTokenTask(Context context, ISendTokenCallBack iSendTokenCallBack) {
        this.mContext = context;
        this.mCallback = iSendTokenCallBack;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(21:15|(1:17)|18|(1:20)|21|22|(2:67|(2:69|(15:73|(2:75|76)|27|(1:29)|30|31|32|33|34|35|36|(5:51|52|(1:54)|55|56)(2:38|39)|40|41|(1:43)(1:46))))(1:25)|26|27|(0)|30|31|32|33|34|35|36|(0)(0)|40|41|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x02e3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x02e4, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x02a4, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02a8, code lost:
    
        r14 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x02a6, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x02a7, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01b4 A[Catch: all -> 0x0302, TryCatch #0 {all -> 0x0302, blocks: (B:7:0x0029, B:10:0x0033, B:13:0x004c, B:15:0x0052, B:17:0x0058, B:18:0x0072, B:20:0x009d, B:21:0x00a2, B:25:0x00f5, B:27:0x0181, B:29:0x01b4, B:30:0x01bf, B:49:0x02e4, B:43:0x02e9, B:46:0x02ee, B:60:0x02a9, B:67:0x00fc, B:69:0x0102, B:71:0x0124, B:73:0x012a, B:75:0x013b, B:77:0x02f3, B:41:0x02bd), top: B:6:0x0029, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0291 A[Catch: all -> 0x02a4, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x02a4, blocks: (B:36:0x01f9, B:38:0x0291), top: B:35:0x01f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x02e9 A[Catch: all -> 0x0302, TryCatch #0 {all -> 0x0302, blocks: (B:7:0x0029, B:10:0x0033, B:13:0x004c, B:15:0x0052, B:17:0x0058, B:18:0x0072, B:20:0x009d, B:21:0x00a2, B:25:0x00f5, B:27:0x0181, B:29:0x01b4, B:30:0x01bf, B:49:0x02e4, B:43:0x02e9, B:46:0x02ee, B:60:0x02a9, B:67:0x00fc, B:69:0x0102, B:71:0x0124, B:73:0x012a, B:75:0x013b, B:77:0x02f3, B:41:0x02bd), top: B:6:0x0029, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02ee A[Catch: all -> 0x0302, TryCatch #0 {all -> 0x0302, blocks: (B:7:0x0029, B:10:0x0033, B:13:0x004c, B:15:0x0052, B:17:0x0058, B:18:0x0072, B:20:0x009d, B:21:0x00a2, B:25:0x00f5, B:27:0x0181, B:29:0x01b4, B:30:0x01bf, B:49:0x02e4, B:43:0x02e9, B:46:0x02ee, B:60:0x02a9, B:67:0x00fc, B:69:0x0102, B:71:0x0124, B:73:0x012a, B:75:0x013b, B:77:0x02f3, B:41:0x02bd), top: B:6:0x0029, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x021c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void sendToken(ISendTokenCallBack iSendTokenCallBack) {
        int i;
        String str;
        String str2;
        int i2;
        String str3;
        ArrayList arrayList;
        String lastProfileId;
        String addUrlParam;
        boolean z;
        int i3;
        NetworkClient.ReqContext reqContext;
        try {
            str2 = iSendTokenCallBack.getToken(this.mContext);
            try {
                i2 = iSendTokenCallBack.getType();
                try {
                } catch (Throwable th) {
                    th = th;
                    i = i2;
                    str = str2;
                    th.printStackTrace();
                    this.error = 10;
                    str2 = str;
                    i2 = i;
                    this.mHandler.obtainMessage(1, this.error, i2, str2).sendToTarget();
                }
            } catch (Throwable th2) {
                th = th2;
                i = 0;
            }
        } catch (Throwable th3) {
            th = th3;
            i = 0;
            str = null;
        }
        if (!isValidSender(i2)) {
            Logger.m278w(TAG, "ignore update token task : type = " + i2 + ", token = " + str2);
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (Logger.debug()) {
                Logger.m268d(TAG, "token = " + str2 + ", sender = " + i2);
            }
            Map<String, String> commonParams = PushSupporter.get().getCommonParams();
            String str4 = commonParams.get(CommonConstants.KEY_DID);
            String str5 = commonParams.get("version_code");
            String str6 = commonParams.get("alias");
            if (!TextUtils.isEmpty(str6)) {
                commonParams.put("device_login_id", str6);
            }
            PushOnlineSettings pushOnlineSettings = (PushOnlineSettings) SettingsManager.obtain(this.mContext, PushOnlineSettings.class);
            long currentTimeMillis = ToolUtils.currentTimeMillis();
            TokenCache tokenCache = new TokenCache(i2, str2, str4, str5, currentTimeMillis, str6);
            boolean allowForceSendToken = pushOnlineSettings.allowForceSendToken();
            Logger.m274i(TAG, "sForceSendToken:" + sForceSendToken + " allowForceSendToken:" + allowForceSendToken);
            if (sForceSendToken && allowForceSendToken) {
                Logger.m274i(TAG, "force send token because  sForceSendToken is true");
            } else if (pushOnlineSettings.enableRestrictUpdateToken()) {
                TokenCache bySenderType = TokenStorage.getBySenderType(this.mContext, i2);
                Logger.m274i(TAG, "last = " + bySenderType + ", current = " + tokenCache);
                if (bySenderType != null && bySenderType.isSame(tokenCache)) {
                    str3 = "lastProfileId:";
                    if (Math.abs(currentTimeMillis - bySenderType.updateTime) < pushOnlineSettings.getUpdateTokenIntervalInSecond()) {
                        Logger.m274i(TAG, "same token,deviceId,versionCode with sp，ignore upload token : type = " + i2 + ", token = " + str2);
                        PushSupporter.monitor().monitorRegisterSenderSuccess(i2);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("channel", bySenderType.type);
                        jSONObject.put("token", bySenderType.token);
                        UgBusFramework.getService(MessageAppHooks.PushHook.class).onEventV3("push_token", jSONObject);
                        PushSupporter.get().getTokenRetryService().onUpdateTokenSuccess(i2);
                        return;
                    }
                    String addUrlParam2 = ToolUtils.addUrlParam(MessageConstants.getSendPushTokenUrl(), commonParams);
                    arrayList = new ArrayList();
                    arrayList.add(new Pair("token", str2));
                    lastProfileId = PushSetting.getInstance().getLastProfileId();
                    Logger.m274i(TAG, str3 + lastProfileId);
                    if (!TextUtils.isEmpty(lastProfileId)) {
                        arrayList.add(new Pair("profile_id", lastProfileId));
                    }
                    arrayList.add(new Pair("type", String.valueOf(i2)));
                    arrayList.add(new Pair("update_event", "push_sdk"));
                    addUrlParam = ToolUtils.addUrlParam(addUrlParam2, arrayList);
                    Logger.m274i(TAG, "request url = " + addUrlParam);
                    reqContext = new NetworkClient.ReqContext();
                    boolean z2 = false;
                    reqContext.addCommonParams = false;
                    if (!"success".equals(new JSONObject(PushNetworkClient.getDefault().post(addUrlParam, arrayList, ToolUtils.addNetworkTagToHeader((Map) null), reqContext)).optString("message"))) {
                        try {
                            TokenStorage.save(this.mContext, tokenCache);
                            PushSupporter.monitor().monitorRegisterSenderSuccess(i2);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("channel", tokenCache.type);
                            jSONObject2.put("token", tokenCache.token);
                            UgBusFramework.getService(MessageAppHooks.PushHook.class).onEventV3("push_token", jSONObject2);
                            IAccountService service = UgBusFramework.getService(IAccountService.class);
                            Logger.m274i(TAG, "success send token to server,set last_sec_uid,accountService=" + service);
                            if (service != null) {
                                String secUid = service.getSecUid();
                                Logger.m274i(TAG, "success send token to server,set last_sec_uid,secUid=" + secUid);
                                PushSetting.getInstance().getLocalSettings().setLastSecUid(secUid);
                            }
                            PushSupporter.get().getTokenRetryService().onUpdateTokenSuccess(i2);
                            i3 = 200;
                            z = true;
                        } catch (Throwable th4) {
                            th = th4;
                            z = true;
                            th.printStackTrace();
                            PushSupporter.monitor().monitorRegisterSenderFailed(i2, 103, String.valueOf(1), Log.getStackTraceString(th));
                            i3 = 1;
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("label", "send_token");
                            jSONObject3.put("status", i3);
                            jSONObject3.put("token", str2);
                            jSONObject3.put("type", i2);
                            PushSupporter.thirdService().sendMonitor(this.mContext, IThirdSupportService.LOG_TYPE, jSONObject3);
                            if (!z) {
                            }
                            this.mHandler.obtainMessage(1, this.error, i2, str2).sendToTarget();
                        }
                    } else {
                        PushSupporter.monitor().monitorRegisterSenderFailed(i2, 103, String.valueOf(-200), "return error");
                        i3 = -200;
                        z = false;
                    }
                    JSONObject jSONObject32 = new JSONObject();
                    jSONObject32.put("label", "send_token");
                    jSONObject32.put("status", i3);
                    jSONObject32.put("token", str2);
                    jSONObject32.put("type", i2);
                    PushSupporter.thirdService().sendMonitor(this.mContext, IThirdSupportService.LOG_TYPE, jSONObject32);
                    if (!z) {
                        this.error = 11;
                    } else {
                        this.error = 10;
                    }
                }
            }
            str3 = "lastProfileId:";
            String addUrlParam22 = ToolUtils.addUrlParam(MessageConstants.getSendPushTokenUrl(), commonParams);
            arrayList = new ArrayList();
            arrayList.add(new Pair("token", str2));
            lastProfileId = PushSetting.getInstance().getLastProfileId();
            Logger.m274i(TAG, str3 + lastProfileId);
            if (!TextUtils.isEmpty(lastProfileId)) {
            }
            arrayList.add(new Pair("type", String.valueOf(i2)));
            arrayList.add(new Pair("update_event", "push_sdk"));
            addUrlParam = ToolUtils.addUrlParam(addUrlParam22, arrayList);
            Logger.m274i(TAG, "request url = " + addUrlParam);
            reqContext = new NetworkClient.ReqContext();
            boolean z22 = false;
            reqContext.addCommonParams = false;
            if (!"success".equals(new JSONObject(PushNetworkClient.getDefault().post(addUrlParam, arrayList, ToolUtils.addNetworkTagToHeader((Map) null), reqContext)).optString("message"))) {
            }
            JSONObject jSONObject322 = new JSONObject();
            jSONObject322.put("label", "send_token");
            jSONObject322.put("status", i3);
            jSONObject322.put("token", str2);
            jSONObject322.put("type", i2);
            PushSupporter.thirdService().sendMonitor(this.mContext, IThirdSupportService.LOG_TYPE, jSONObject322);
            if (!z) {
            }
        } else {
            PushSupporter.monitor().monitorRegisterSenderFailed(i2, 102, ViewVisibleBridge.INVISIBLE, "token is empty");
        }
        this.mHandler.obtainMessage(1, this.error, i2, str2).sendToTarget();
    }

    private boolean isValidSender(int i) {
        return PushChannelHelper.isServerSupportChannel(i);
    }

    public void handleMsg(Message message) {
        if (message.what == 1) {
            handleSentTokenResult(message);
        }
    }

    private void handleSentTokenResult(Message message) {
        try {
            int i = message.arg1;
            boolean z = false;
            if (i != 10 && i == 11) {
                z = true;
            }
            Logger.m274i(TAG, "Send token ".concat(z ? "success" : SccResult.MESSAGE_FAIL));
            if (z) {
                return;
            }
            markTokenSendFail((String) message.obj);
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mContext == null || this.mCallback == null) {
            return;
        }
        synchronized (UPLOAD_TOKEN_LOCK) {
            sendToken(this.mCallback);
        }
    }

    private void markTokenSendFail(String str) {
        try {
            int i = this.retryCount + 1;
            this.retryCount = i;
            if (i > 3 || TextUtils.isEmpty(str)) {
                return;
            }
            Logger.m271e(TAG, "token fail, token = " + str + ". retry = " + this.retryCount);
            PushThreadHandlerManager.inst().postRunnable(new Runnable() { // from class: com.bytedance.push.task.SendTokenTask.2
                @Override // java.lang.Runnable
                public void run() {
                    SendTokenTask.this.run();
                }
            }, TimeUnit.SECONDS.toMillis(4L) * this.retryCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
