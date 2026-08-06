package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.threads.AsyncExec;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.HandlerC1216f;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HmsMessageService extends Service {
    public static final String PROXY_TYPE = "proxy_type";
    public static final String SUBJECT_ID = "subject_id";

    /* renamed from: a */
    private final Messenger f1624a = new Messenger(new HandlerC1216f(new C1209b(this, null)));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.push.HmsMessageService$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class RunnableC1208a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f1625a;

        /* renamed from: b */
        final /* synthetic */ String f1626b;

        RunnableC1208a(String str, String str2) {
            this.f1625a = str;
            this.f1626b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context applicationContext = HmsMessageService.this.getApplicationContext();
            if (this.f1626b.equals(BaseUtils.getLocalToken(applicationContext, this.f1625a))) {
                return;
            }
            HMSLog.m2120i("HmsMessageService", "receive a new token, refresh the local token");
            BaseUtils.saveToken(applicationContext, this.f1625a, this.f1626b);
        }
    }

    /* renamed from: com.huawei.hms.push.HmsMessageService$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private class C1209b implements HandlerC1216f.a {
        private C1209b() {
        }

        @Override // com.huawei.hms.push.HandlerC1216f.a
        /* renamed from: a */
        public void mo1913a(Message message) {
            if (message == null) {
                HMSLog.m2118e("HmsMessageService", "receive message is null");
                return;
            }
            HMSLog.m2120i("HmsMessageService", "handle message start...");
            Bundle data = Message.obtain(message).getData();
            if (data != null) {
                Intent intent = new Intent();
                intent.putExtras(data);
                intent.putExtra(RemoteMessageConst.INPUT_TYPE, data.getInt(RemoteMessageConst.INPUT_TYPE, -1));
                HmsMessageService.this.handleIntentMessage(intent);
            }
        }

        /* synthetic */ C1209b(HmsMessageService hmsMessageService, RunnableC1208a runnableC1208a) {
            this();
        }
    }

    /* renamed from: a */
    private void m1908a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AsyncExec.submitSeqIO(new RunnableC1208a(str2, str));
    }

    /* renamed from: b */
    private void m1910b(Intent intent) {
        HMSLog.m2120i("HmsMessageService", "parse batch response.");
        String stringExtra = intent.getStringExtra("batchMsgbody");
        if (TextUtils.isEmpty(stringExtra)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(stringExtra);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                String optString = jSONObject.optString("transactionId");
                String optString2 = jSONObject.optString(RemoteMessageConst.MSGID);
                int optInt = jSONObject.optInt("ret", ErrorEnum.ERROR_UNKNOWN.getInternalCode());
                if (ErrorEnum.SUCCESS.getInternalCode() == optInt) {
                    m1911b(optString, optString2);
                } else {
                    m1912b(optString, optString2, optInt);
                }
            }
        } catch (JSONException unused) {
            HMSLog.m2121w("HmsMessageService", "parse batch response failed.");
        }
    }

    protected void doMsgReceived(Intent intent) {
        onMessageReceived(new RemoteMessage(m1904a(intent)));
    }

    public void handleIntentMessage(Intent intent) {
        if (intent == null) {
            HMSLog.m2118e("HmsMessageService", "receive message is null");
            return;
        }
        try {
            String stringExtra = intent.getStringExtra("message_id");
            String stringExtra2 = intent.getStringExtra(RemoteMessageConst.MSGTYPE);
            String stringExtra3 = intent.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);
            if ("new_token".equals(stringExtra2)) {
                HMSLog.m2120i("HmsMessageService", "onNewToken");
                m1907a(intent, stringExtra3);
            } else if ("received_message".equals(stringExtra2)) {
                HMSLog.m2120i("HmsMessageService", "onMessageReceived, message id:" + stringExtra);
                m1909a(PushNaming.RECEIVE_MSG_RSP, stringExtra, ErrorEnum.SUCCESS.getInternalCode());
                doMsgReceived(intent);
            } else if ("sent_message".equals(stringExtra2)) {
                m1911b(stringExtra3, stringExtra);
            } else if ("send_error".equals(stringExtra2)) {
                m1912b(stringExtra3, stringExtra, intent.getIntExtra("error", ErrorEnum.ERROR_UNKNOWN.getInternalCode()));
            } else if ("delivery".equals(stringExtra2)) {
                int intExtra = intent.getIntExtra("error", ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode());
                HMSLog.m2120i("HmsMessageService", "onMessageDelivery, message id:" + stringExtra + ", status:" + intExtra + ", transactionId: " + stringExtra3);
                m1909a(PushNaming.UPSEND_RECEIPT, stringExtra3, intExtra);
                onMessageDelivered(stringExtra, new SendException(intExtra));
            } else if ("server_deleted_message".equals(stringExtra2)) {
                HMSLog.m2120i("HmsMessageService", "delete message, message id:" + stringExtra);
                onDeletedMessages();
            } else if ("batchSent".equals(stringExtra2)) {
                m1910b(intent);
            } else {
                HMSLog.m2118e("HmsMessageService", "Receive unknown message: " + stringExtra2);
            }
        } catch (RuntimeException e) {
            HMSLog.m2118e("HmsMessageService", "handle intent RuntimeException: " + e.getMessage());
        } catch (Exception e2) {
            HMSLog.m2118e("HmsMessageService", "handle intent exception: " + e2.getMessage());
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        HMSLog.m2120i("HmsMessageService", "start to bind");
        return this.f1624a.getBinder();
    }

    public void onDeletedMessages() {
    }

    @Override // android.app.Service
    public void onDestroy() {
        HMSLog.m2120i("HmsMessageService", "start to destroy");
        super.onDestroy();
    }

    public void onMessageDelivered(String str, Exception exc) {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
    }

    public void onMessageSent(String str) {
    }

    public void onNewToken(String str) {
    }

    public void onNewToken(String str, Bundle bundle) {
    }

    public void onSendError(String str, Exception exc) {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        HMSLog.m2120i("HmsMessageService", "start to command , startId = " + i2);
        handleIntentMessage(intent);
        return 2;
    }

    public void onTokenError(Exception exc) {
    }

    public void onTokenError(Exception exc, Bundle bundle) {
    }

    /* renamed from: a */
    private Bundle m1904a(Intent intent) {
        Bundle bundle = new Bundle();
        bundle.putString("message_id", intent.getStringExtra("message_id"));
        bundle.putByteArray(RemoteMessageConst.MSGBODY, intent.getByteArrayExtra(RemoteMessageConst.MSGBODY));
        bundle.putString(RemoteMessageConst.DEVICE_TOKEN, intent.getStringExtra(RemoteMessageConst.DEVICE_TOKEN));
        if (intent.getIntExtra(RemoteMessageConst.INPUT_TYPE, -1) == 1) {
            bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
        }
        return bundle;
    }

    /* renamed from: a */
    private void m1907a(Intent intent, String str) {
        int intExtra = intent.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode());
        m1909a(PushNaming.GETTOKEN_ASYNC_RSP, str, intExtra);
        String stringExtra = intent.getStringExtra("subjectId");
        String stringExtra2 = intent.getStringExtra("message_proxy_type");
        HMSLog.m2120i("HmsMessageService", "doOnNewToken:transactionId = " + str + " , internalCode = " + intExtra + ",subjectId:" + stringExtra + ",proxyType:" + stringExtra2);
        Bundle bundle = new Bundle();
        if (!TextUtils.isEmpty(stringExtra)) {
            bundle.putString(SUBJECT_ID, stringExtra);
        }
        if (!TextUtils.isEmpty(stringExtra2)) {
            bundle.putString(PROXY_TYPE, stringExtra2);
        }
        if (intExtra == ErrorEnum.SUCCESS.getInternalCode()) {
            HMSLog.m2120i("HmsMessageService", "Apply token OnNewToken, subId: " + stringExtra);
            m1905a(intent, bundle, stringExtra);
        } else {
            HMSLog.m2120i("HmsMessageService", "Apply token failed, subId: " + stringExtra);
            m1906a(intent, bundle, stringExtra, intExtra);
        }
    }

    /* renamed from: b */
    private void m1911b(String str, String str2) {
        HMSLog.m2120i("HmsMessageService", "onMessageSent, message id:" + str2 + ", transactionId: " + str);
        m1909a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, ErrorEnum.SUCCESS.getInternalCode());
        onMessageSent(str2);
    }

    /* renamed from: b */
    private void m1912b(String str, String str2, int i) {
        HMSLog.m2120i("HmsMessageService", "onSendError, message id:" + str2 + " error:" + i + ", transactionId: " + str);
        m1909a(PushNaming.UPSEND_MSG_ASYNC_RSP, str, i);
        onSendError(str2, new SendException(i));
    }

    /* renamed from: a */
    private synchronized void m1906a(Intent intent, Bundle bundle, String str, int i) {
        Context applicationContext = getApplicationContext();
        boolean z = !TextUtils.isEmpty(BaseUtils.getCacheData(applicationContext, applicationContext.getPackageName(), false));
        if (bundle.isEmpty() && z) {
            HMSLog.m2120i("HmsMessageService", "onTokenError to host app.");
            onTokenError(new BaseException(i));
            BaseUtils.deleteCacheData(applicationContext, applicationContext.getPackageName());
        }
        if (TextUtils.isEmpty(str)) {
            String[] subjectIds = BaseUtils.getSubjectIds(applicationContext);
            if (subjectIds != null && subjectIds.length != 0) {
                for (int i2 = 0; i2 < subjectIds.length; i2++) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(SUBJECT_ID, subjectIds[i2]);
                    HMSLog.m2120i("HmsMessageService", "onTokenError to sub app, subjectId:" + subjectIds[i2]);
                    onTokenError(new BaseException(i), bundle2);
                }
                BaseUtils.clearSubjectIds(applicationContext);
            }
            HMSLog.m2120i("HmsMessageService", "onTokenError to host app with bundle.");
            onTokenError(new BaseException(i), bundle);
            return;
        }
        HMSLog.m2120i("HmsMessageService", "onTokenError to sub app, subjectId:" + str);
        onTokenError(new BaseException(i), bundle);
    }

    /* renamed from: a */
    private synchronized void m1905a(Intent intent, Bundle bundle, String str) {
        String stringExtra = intent.getStringExtra(RemoteMessageConst.DEVICE_TOKEN);
        m1908a(stringExtra, str);
        Context applicationContext = getApplicationContext();
        boolean z = !TextUtils.isEmpty(BaseUtils.getCacheData(applicationContext, applicationContext.getPackageName(), false));
        if (bundle.isEmpty() && z) {
            HMSLog.m2120i("HmsMessageService", "onNewToken to host app.");
            onNewToken(stringExtra);
            BaseUtils.deleteCacheData(applicationContext, applicationContext.getPackageName());
        }
        if (TextUtils.isEmpty(str)) {
            String[] subjectIds = BaseUtils.getSubjectIds(applicationContext);
            if (subjectIds != null && subjectIds.length != 0) {
                for (int i = 0; i < subjectIds.length; i++) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(SUBJECT_ID, subjectIds[i]);
                    HMSLog.m2120i("HmsMessageService", "onNewToken to sub app, subjectId:" + subjectIds[i]);
                    onNewToken(stringExtra, bundle2);
                    m1908a(stringExtra, subjectIds[i]);
                }
                BaseUtils.clearSubjectIds(applicationContext);
            }
            HMSLog.m2120i("HmsMessageService", "onNewToken to host app with bundle.");
            bundle.putString("belongId", intent.getStringExtra("belongId"));
            onNewToken(stringExtra, bundle);
            return;
        }
        HMSLog.m2120i("HmsMessageService", "onNewToken to sub app, subjectId:" + str);
        onNewToken(stringExtra, bundle);
    }

    /* renamed from: a */
    private void m1909a(String str, String str2, int i) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "null";
        }
        PushBiUtil.reportExit(getApplicationContext(), str, str2, i);
    }
}
