package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.AbstractC1211a;
import com.huawei.hms.push.AbstractC1214d;
import com.huawei.hms.push.C1230q;
import com.huawei.hms.push.C1231r;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PushReceiver extends BroadcastReceiver {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.support.api.push.PushReceiver$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class RunnableC1253b implements Runnable {

        /* renamed from: a */
        private Context f1798a;

        /* renamed from: b */
        private Intent f1799b;

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            intent.setPackage(this.f1799b.getPackage());
            try {
                JSONObject m2088b = PushReceiver.m2088b(this.f1799b);
                String string = JsonUtil.getString(m2088b, "moduleName", "");
                int i = JsonUtil.getInt(m2088b, "msgType", 0);
                int i2 = JsonUtil.getInt(m2088b, "status", 0);
                if (ErrorEnum.SUCCESS.getInternalCode() != i2) {
                    i2 = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode();
                }
                Bundle bundle = new Bundle();
                if ("Push".equals(string) && i == 1) {
                    bundle.putString(RemoteMessageConst.MSGTYPE, "delivery");
                    bundle.putString("message_id", JsonUtil.getString(m2088b, RemoteMessageConst.MSGID, ""));
                    bundle.putInt("error", i2);
                    bundle.putString(CommonCode.MapKey.TRANSACTION_ID, JsonUtil.getString(m2088b, "transactionId", ""));
                } else {
                    if (this.f1799b.getExtras() != null) {
                        bundle.putAll(this.f1799b.getExtras());
                    }
                    bundle.putString(RemoteMessageConst.MSGTYPE, "received_message");
                    bundle.putString("message_id", this.f1799b.getStringExtra("msgIdStr"));
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, this.f1799b.getByteArrayExtra("msg_data"));
                    bundle.putString(RemoteMessageConst.DEVICE_TOKEN, AbstractC1211a.m1934a(this.f1799b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN)));
                    bundle.putInt(RemoteMessageConst.INPUT_TYPE, 1);
                    bundle.putString("message_proxy_type", this.f1799b.getStringExtra("message_proxy_type"));
                }
                if (new C1231r().m2035a(this.f1798a, bundle, intent)) {
                    HMSLog.m2120i("PushReceiver", "receive " + this.f1799b.getAction() + " and start service success");
                } else {
                    HMSLog.m2118e("PushReceiver", "receive " + this.f1799b.getAction() + " and start service failed");
                }
            } catch (RuntimeException unused) {
                HMSLog.m2118e("PushReceiver", "handle push message occur exception.");
            }
        }

        private RunnableC1253b(Context context, Intent intent) {
            this.f1798a = context;
            this.f1799b = intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.support.api.push.PushReceiver$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class RunnableC1254c implements Runnable {

        /* renamed from: a */
        private Context f1800a;

        /* renamed from: b */
        private Intent f1801b;

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte[] byteArrayExtra = this.f1801b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN);
                if (byteArrayExtra != null && byteArrayExtra.length != 0) {
                    HMSLog.m2120i("PushReceiver", "receive a push token: " + this.f1800a.getPackageName());
                    Intent intent = new Intent("com.huawei.push.action.MESSAGING_EVENT");
                    intent.setPackage(this.f1801b.getPackage());
                    Bundle bundle = new Bundle();
                    bundle.putString(RemoteMessageConst.MSGTYPE, "new_token");
                    bundle.putString(RemoteMessageConst.DEVICE_TOKEN, AbstractC1211a.m1934a(byteArrayExtra));
                    bundle.putString(CommonCode.MapKey.TRANSACTION_ID, this.f1801b.getStringExtra(CommonCode.MapKey.TRANSACTION_ID));
                    bundle.putString("subjectId", this.f1801b.getStringExtra("subjectId"));
                    bundle.putInt("error", this.f1801b.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode()));
                    bundle.putString("belongId", this.f1801b.getStringExtra("belongId"));
                    if (new C1231r().m2035a(this.f1800a, bundle, intent)) {
                        return;
                    }
                    HMSLog.m2118e("PushReceiver", "receive " + this.f1801b.getAction() + " and start service failed");
                    return;
                }
                HMSLog.m2120i("PushReceiver", "get a deviceToken, but it is null or empty");
            } catch (RejectedExecutionException unused) {
                HMSLog.m2118e("PushReceiver", "execute task error");
            } catch (Exception unused2) {
                HMSLog.m2118e("PushReceiver", "handle push token error");
            }
        }

        private RunnableC1254c(Context context, Intent intent) {
            this.f1800a = context;
            this.f1801b = intent;
        }
    }

    /* renamed from: b */
    private void m2090b(Context context, Intent intent) {
        try {
            if (intent.hasExtra(RemoteMessageConst.DEVICE_TOKEN)) {
                C1230q.m2031a().execute(new RunnableC1254c(context, intent));
            } else {
                HMSLog.m2120i("PushReceiver", "This message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.m2118e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.m2118e("PushReceiver", "handlePushTokenEvent execute task error");
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        HMSLog.m2120i("PushReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
        try {
            intent.getStringExtra("TestIntent");
            String action = intent.getAction();
            if (ResourceLoaderUtil.getmContext() == null) {
                ResourceLoaderUtil.setmContext(context.getApplicationContext());
            }
            if ("com.huawei.android.push.intent.REGISTRATION".equals(action)) {
                m2090b(context, intent);
            } else if ("com.huawei.android.push.intent.RECEIVE".equals(action)) {
                m2087a(context, intent);
            } else {
                HMSLog.m2120i("PushReceiver", "message can't be recognised.");
            }
        } catch (Exception unused) {
            HMSLog.m2118e("PushReceiver", "intent has some error");
        }
    }

    /* renamed from: a */
    private void m2087a(Context context, Intent intent) {
        try {
            if (intent.hasExtra("msg_data")) {
                C1230q.m2031a().execute(new RunnableC1253b(context, intent));
            } else {
                HMSLog.m2120i("PushReceiver", "This push message dose not sent by hwpush.");
            }
        } catch (RuntimeException unused) {
            HMSLog.m2118e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        } catch (Exception unused2) {
            HMSLog.m2118e("PushReceiver", "handlePushMessageEvent execute task error");
        }
    }

    /* renamed from: b */
    private static JSONObject m2089b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    /* renamed from: a */
    private static JSONObject m2086a(byte[] bArr) {
        try {
            return new JSONObject(AbstractC1211a.m1934a(bArr));
        } catch (JSONException unused) {
            HMSLog.m2121w("PushReceiver", "JSONException:parse message body failed.");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static JSONObject m2088b(Intent intent) throws RuntimeException {
        JSONObject m2086a = m2086a(intent.getByteArrayExtra("msg_data"));
        JSONObject m2085a = m2085a(m2086a);
        String string = JsonUtil.getString(m2085a, "data", null);
        if (AbstractC1214d.m1941a(m2085a, m2089b(m2085a), string)) {
            return m2086a;
        }
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static JSONObject m2085a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
