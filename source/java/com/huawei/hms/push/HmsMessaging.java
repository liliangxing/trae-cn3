package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import java.util.regex.Pattern;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HmsMessaging {
    public static final String DEFAULT_TOKEN_SCOPE = "HCM";

    /* renamed from: c */
    private static final Pattern f1629c = Pattern.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");

    /* renamed from: a */
    private Context f1630a;

    /* renamed from: b */
    private HuaweiApi<Api.ApiOptions.NoOptions> f1631b;

    private HmsMessaging(Context context) {
        Preconditions.checkNotNull(context);
        this.f1630a = context;
        Api api = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if (context instanceof Activity) {
            this.f1631b = new HuaweiApi<>((Activity) context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, (AbstractClientBuilder) new PushClientBuilder());
        } else {
            this.f1631b = new HuaweiApi<>(context, (Api<Api.ApiOptions>) api, (Api.ApiOptions) null, new PushClientBuilder());
        }
        this.f1631b.setKitSdkVersion(61300300);
    }

    /* renamed from: a */
    private Task<Void> m1914a(String str, String str2) {
        String reportEntry = PushBiUtil.reportEntry(this.f1630a, PushNaming.SUBSCRIBE);
        if (str != null && f1629c.matcher(str).matches()) {
            if (ProxyCenter.getProxy() != null) {
                HMSLog.m2120i("HmsMessaging", "use proxy subscribe.");
                return TextUtils.equals(str2, "Sub") ? ProxyCenter.getProxy().subscribe(this.f1630a, str, reportEntry) : ProxyCenter.getProxy().unsubscribe(this.f1630a, str, reportEntry);
            }
            try {
                ErrorEnum m2056a = C1238v.m2056a(this.f1630a);
                if (m2056a == ErrorEnum.SUCCESS) {
                    if (NetWorkUtil.getNetworkType(this.f1630a) != 0) {
                        SubscribeReq subscribeReq = new SubscribeReq(this.f1630a, str2, str);
                        subscribeReq.setToken(BaseUtils.getLocalToken(this.f1630a, null));
                        if (AbstractC1214d.m1943b()) {
                            return this.f1631b.doWrite(new BaseVoidTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
                        }
                        return this.f1631b.doWrite(new SubscribeTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(subscribeReq), reportEntry));
                    }
                    HMSLog.m2118e("HmsMessaging", "no network");
                    throw ErrorEnum.ERROR_NO_NETWORK.toApiException();
                }
                throw m2056a.toApiException();
            } catch (ApiException e) {
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setException(e);
                PushBiUtil.reportExit(this.f1630a, PushNaming.SUBSCRIBE, reportEntry, e.getStatusCode());
                return taskCompletionSource.getTask();
            } catch (Exception unused) {
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                taskCompletionSource2.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
                PushBiUtil.reportExit(this.f1630a, PushNaming.SUBSCRIBE, reportEntry, ErrorEnum.ERROR_INTERNAL_ERROR);
                return taskCompletionSource2.getTask();
            }
        }
        PushBiUtil.reportExit(this.f1630a, PushNaming.SUBSCRIBE, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
        HMSLog.m2118e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
        throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
    }

    public static synchronized HmsMessaging getInstance(Context context) {
        HmsMessaging hmsMessaging;
        synchronized (HmsMessaging.class) {
            hmsMessaging = new HmsMessaging(context);
        }
        return hmsMessaging;
    }

    public boolean isAutoInitEnabled() {
        return AutoInitHelper.isAutoInitEnabled(this.f1630a);
    }

    public void send(RemoteMessage remoteMessage) {
        if (ProxyCenter.getProxy() == null) {
            HMSLog.m2120i("HmsMessaging", "send upstream message");
            m1916a(remoteMessage);
        } else {
            HMSLog.m2118e("HmsMessaging", "Operation(send) unsupported");
            throw new UnsupportedOperationException("Operation(send) unsupported");
        }
    }

    public void setAutoInitEnabled(boolean z) {
        AutoInitHelper.setAutoInitEnabled(this.f1630a, z);
    }

    public Task<Void> subscribe(String str) {
        HMSLog.m2120i("HmsMessaging", "invoke subscribe");
        return m1914a(str, "Sub");
    }

    public Task<Void> turnOffPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m2120i("HmsMessaging", "turn off for proxy");
            return ProxyCenter.getProxy().turnOff(this.f1630a, null);
        }
        HMSLog.m2120i("HmsMessaging", "invoke turnOffPush");
        return m1915a(false);
    }

    public Task<Void> turnOnPush() {
        if (ProxyCenter.getProxy() != null) {
            HMSLog.m2120i("HmsMessaging", "turn on for proxy");
            return ProxyCenter.getProxy().turnOn(this.f1630a, null);
        }
        HMSLog.m2120i("HmsMessaging", "invoke turnOnPush");
        return m1915a(true);
    }

    public Task<Void> unsubscribe(String str) {
        HMSLog.m2120i("HmsMessaging", "invoke unsubscribe");
        return m1914a(str, "UnSub");
    }

    /* renamed from: a */
    private void m1916a(RemoteMessage remoteMessage) {
        String reportEntry = PushBiUtil.reportEntry(this.f1630a, PushNaming.UPSEND_MSG);
        ErrorEnum m2056a = C1238v.m2056a(this.f1630a);
        if (m2056a == ErrorEnum.SUCCESS) {
            if (!TextUtils.isEmpty(remoteMessage.getTo())) {
                if (!TextUtils.isEmpty(remoteMessage.getMessageId())) {
                    if (!TextUtils.isEmpty(remoteMessage.getData())) {
                        UpSendMsgReq upSendMsgReq = new UpSendMsgReq();
                        upSendMsgReq.setPackageName(this.f1630a.getPackageName());
                        upSendMsgReq.setMessageId(remoteMessage.getMessageId());
                        upSendMsgReq.setTo(remoteMessage.getTo());
                        upSendMsgReq.setData(remoteMessage.getData());
                        upSendMsgReq.setMessageType(remoteMessage.getMessageType());
                        upSendMsgReq.setTtl(remoteMessage.getTtl());
                        upSendMsgReq.setCollapseKey(remoteMessage.getCollapseKey());
                        upSendMsgReq.setSendMode(remoteMessage.getSendMode());
                        upSendMsgReq.setReceiptMode(remoteMessage.getReceiptMode());
                        if (AbstractC1214d.m1943b()) {
                            this.f1631b.doWrite(new BaseVoidTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), reportEntry));
                            return;
                        } else {
                            m1917a(upSendMsgReq, reportEntry);
                            return;
                        }
                    }
                    HMSLog.m2118e("HmsMessaging", "Mandatory parameter 'data' missing");
                    PushBiUtil.reportExit(this.f1630a, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                    throw new IllegalArgumentException("Mandatory parameter 'data' missing");
                }
                HMSLog.m2118e("HmsMessaging", "Mandatory parameter 'message_id' missing");
                PushBiUtil.reportExit(this.f1630a, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
                throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
            }
            HMSLog.m2118e("HmsMessaging", "Mandatory parameter 'to' missing");
            PushBiUtil.reportExit(this.f1630a, PushNaming.UPSEND_MSG, reportEntry, ErrorEnum.ERROR_ARGUMENTS_INVALID);
            throw new IllegalArgumentException("Mandatory parameter 'to' missing");
        }
        HMSLog.m2118e("HmsMessaging", "Message sent failed:" + m2056a.getExternalCode() + ':' + m2056a.getMessage());
        PushBiUtil.reportExit(this.f1630a, PushNaming.UPSEND_MSG, reportEntry, m2056a);
        throw new UnsupportedOperationException(m2056a.getMessage());
    }

    /* renamed from: a */
    private Task<Void> m1915a(boolean z) {
        String reportEntry = PushBiUtil.reportEntry(this.f1630a, PushNaming.SET_NOTIFY_FLAG);
        if (AbstractC1214d.m1946d(this.f1630a) && !AbstractC1214d.m1943b()) {
            if (HwBuildEx.VERSION.EMUI_SDK_INT < 12) {
                HMSLog.m2118e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                taskCompletionSource.setException(ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED.toApiException());
                PushBiUtil.reportExit(this.f1630a, PushNaming.SET_NOTIFY_FLAG, reportEntry, ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED);
                return taskCompletionSource.getTask();
            }
            if (AbstractC1214d.m1942b(this.f1630a) < 90101310) {
                HMSLog.m2120i("HmsMessaging", "turn on/off with broadcast v1");
                Intent putExtra = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", PushEncrypter.encrypterOld(this.f1630a, this.f1630a.getPackageName() + "#" + z));
                putExtra.setPackage("android");
                return Tasks.callInBackground(new IntentCallable(this.f1630a, putExtra, reportEntry));
            }
            if (AbstractC1214d.m1942b(this.f1630a) < 110118300) {
                HMSLog.m2120i("HmsMessaging", "turn on/off with broadcast v2");
                new PushPreferences(this.f1630a, "push_notify_flag").saveBoolean("notify_msg_enable", !z);
                Uri parse = Uri.parse("content://" + this.f1630a.getPackageName() + ".huawei.push.provider/push_notify_flag.xml");
                Intent intent = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
                intent.putExtra("type", "enalbeFlag");
                intent.putExtra("pkgName", this.f1630a.getPackageName());
                intent.putExtra("url", parse);
                intent.setPackage("android");
                return Tasks.callInBackground(new IntentCallable(this.f1630a, intent, reportEntry));
            }
            HMSLog.m2120i("HmsMessaging", "turn on/off with broadcast v3");
            if (TextUtils.isEmpty(BaseUtils.getLocalToken(this.f1630a, null))) {
                TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
                taskCompletionSource2.setException(ErrorEnum.ERROR_NO_TOKEN.toApiException());
                return taskCompletionSource2.getTask();
            }
            new PushPreferences(this.f1630a, "push_notify_flag").saveBoolean("notify_msg_enable", !z);
            Intent intent2 = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG");
            intent2.putExtra("enalbeFlag", z);
            intent2.putExtra(RemoteMessageConst.DEVICE_TOKEN, BaseUtils.getLocalToken(this.f1630a, null));
            intent2.putExtra("pkgName", this.f1630a.getPackageName());
            intent2.putExtra("uid", this.f1630a.getApplicationInfo().uid);
            intent2.setPackage("android");
            return Tasks.callInBackground(new IntentCallable(this.f1630a, intent2, reportEntry));
        }
        HMSLog.m2120i("HmsMessaging", "turn on/off with AIDL");
        EnableNotifyReq enableNotifyReq = new EnableNotifyReq();
        enableNotifyReq.setPackageName(this.f1630a.getPackageName());
        enableNotifyReq.setEnable(z);
        return this.f1631b.doWrite(new BaseVoidTask(PushNaming.SET_NOTIFY_FLAG, JsonUtil.createJsonString(enableNotifyReq), reportEntry));
    }

    /* renamed from: a */
    private void m1917a(UpSendMsgReq upSendMsgReq, String str) {
        upSendMsgReq.setToken(BaseUtils.getLocalToken(this.f1630a, null));
        try {
            this.f1631b.doWrite(new SendUpStreamTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(upSendMsgReq), str, upSendMsgReq.getPackageName(), upSendMsgReq.getMessageId()));
        } catch (Exception e) {
            if (e.getCause() instanceof ApiException) {
                PushBiUtil.reportExit(this.f1630a, PushNaming.UPSEND_MSG, str, ((ApiException) e.getCause()).getStatusCode());
            } else {
                PushBiUtil.reportExit(this.f1630a, PushNaming.UPSEND_MSG, str, ErrorEnum.ERROR_INTERNAL_ERROR);
            }
        }
    }
}
