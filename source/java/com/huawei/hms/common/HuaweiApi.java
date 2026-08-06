package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.common.internal.ResolveClientBean;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsInnerClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HuaweiApi<TOption extends Api.ApiOptions> {

    /* renamed from: a */
    private Context f1132a;

    /* renamed from: b */
    private TOption f1133b;

    /* renamed from: c */
    private Context f1134c;

    /* renamed from: d */
    private AbstractClientBuilder<?, TOption> f1135d;

    /* renamed from: e */
    private String f1136e;

    /* renamed from: f */
    private String f1137f;

    /* renamed from: g */
    private SubAppInfo f1138g;

    /* renamed from: h */
    private WeakReference<Activity> f1139h;

    /* renamed from: i */
    private int f1140i;

    /* renamed from: j */
    private int f1141j = 1;

    /* renamed from: k */
    private boolean f1142k = false;

    /* renamed from: l */
    private String f1143l;

    /* renamed from: m */
    private boolean f1144m;

    /* renamed from: n */
    private RequestManager f1145n;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class RequestHandler<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {

        /* renamed from: b */
        private final AnyClient f1150b;

        /* renamed from: d */
        private final HuaweiApi<OptionsT> f1152d;

        /* renamed from: e */
        private ResolveClientBean f1153e;
        public final Queue<TaskApiCallbackWrapper> callbackWaitQueue = new LinkedList();

        /* renamed from: a */
        private final Queue<TaskApiCallbackWrapper> f1149a = new LinkedList();

        /* renamed from: c */
        private ConnectionResult f1151c = null;

        RequestHandler(HuaweiApi<OptionsT> huaweiApi) {
            this.f1152d = huaweiApi;
            this.f1150b = huaweiApi.getClient(RequestManager.getHandler().getLooper(), this);
        }

        public AnyClient getClient() {
            return this.f1150b;
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            HMSLog.m2120i("HuaweiApi", "onConnected");
            BindResolveClients.getInstance().unRegister(this.f1153e);
            this.f1153e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.4
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.m1079b();
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(final ConnectionResult connectionResult) {
            HMSLog.m2120i("HuaweiApi", "onConnectionFailed");
            BindResolveClients.getInstance().unRegister(this.f1153e);
            this.f1153e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.3
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.m1080b(connectionResult);
                }
            });
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
            HMSLog.m2120i("HuaweiApi", "onConnectionSuspended");
            BindResolveClients.getInstance().unRegister(this.f1153e);
            this.f1153e = null;
            RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.5
                @Override // java.lang.Runnable
                public void run() {
                    RequestHandler.this.m1083c();
                }
            });
        }

        public void postMessage(final TaskApiCallbackWrapper taskApiCallbackWrapper) {
            RequestManager.addToConnectedReqMap(taskApiCallbackWrapper.m1089a().getTaskApiCall().getTransactionId(), this);
            this.f1149a.add(taskApiCallbackWrapper);
            String uri = taskApiCallbackWrapper.m1089a().getTaskApiCall().getUri();
            String packageName = (((HuaweiApi) this.f1152d).f1134c == null ? this.f1152d.getContext() : ((HuaweiApi) this.f1152d).f1134c).getPackageName();
            if (((HuaweiApi) this.f1152d).f1134c != null) {
                HuaweiApi<OptionsT> huaweiApi = this.f1152d;
                huaweiApi.m1070b(((HuaweiApi) huaweiApi).f1134c);
            }
            final RequestHeader requestHeader = new RequestHeader();
            requestHeader.setSrvName(uri.split("\\.")[0]);
            requestHeader.setApiName(uri);
            requestHeader.setAppID(this.f1152d.getAppID() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f1152d.getSubAppID());
            requestHeader.setPkgName(packageName);
            requestHeader.setSessionId(this.f1150b.getSessionId());
            TaskApiCall taskApiCall = taskApiCallbackWrapper.m1089a().getTaskApiCall();
            requestHeader.setTransactionId(m1075a(taskApiCall.getTransactionId(), uri));
            requestHeader.setParcelable(taskApiCall.getParcelable());
            requestHeader.setKitSdkVersion(this.f1152d.getKitSdkVersion());
            requestHeader.setApiLevel(Math.max(this.f1152d.getApiLevel(), taskApiCall.getApiLevel()));
            this.f1150b.post(requestHeader, taskApiCall.getRequestJson(), new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2
                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    AnyClient.CallBack m1090b = taskApiCallbackWrapper.m1090b();
                    if (m1090b != null) {
                        m1090b.onCallback(iMessageEntity, str);
                    }
                    RequestManager.removeReqByTransId(requestHeader.getTransactionId());
                    RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RequestHandler.this.f1149a.remove(taskApiCallbackWrapper);
                        }
                    });
                }
            });
        }

        /* renamed from: b */
        private TaskApiCallbackWrapper m1078b(final TaskApiCallWrapper taskApiCallWrapper) {
            return new TaskApiCallbackWrapper(taskApiCallWrapper, new AnyClient.CallBack() { // from class: com.huawei.hms.common.HuaweiApi.RequestHandler.1

                /* renamed from: a */
                private AtomicBoolean f1154a = new AtomicBoolean(true);

                @Override // com.huawei.hms.common.internal.AnyClient.CallBack
                public void onCallback(IMessageEntity iMessageEntity, String str) {
                    if (!(iMessageEntity instanceof ResponseHeader)) {
                        HMSLog.m2118e("HuaweiApi", "header is not instance of ResponseHeader");
                        return;
                    }
                    ResponseHeader responseHeader = (ResponseHeader) iMessageEntity;
                    if (responseHeader.getErrorCode() == 11) {
                        RequestHandler.this.m1086a();
                        HMSLog.m2120i("HuaweiApi", "unbind service");
                    }
                    if (!TextUtils.isEmpty(responseHeader.getResolution())) {
                        HMSLog.m2118e("HuaweiApi", "Response has resolution: " + responseHeader.getResolution());
                    }
                    if (this.f1154a.compareAndSet(true, false)) {
                        HiAnalyticsInnerClient.reportEntryExit(RequestHandler.this.f1152d.getContext(), responseHeader, String.valueOf(RequestHandler.this.f1152d.getKitSdkVersion()));
                    }
                    taskApiCallWrapper.getTaskApiCall().onResponse(RequestHandler.this.f1150b, responseHeader, str, taskApiCallWrapper.getTaskCompletionSource());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: c */
        public void m1083c() {
            HMSLog.m2120i("HuaweiApi", "wait queue size = " + this.callbackWaitQueue.size());
            HMSLog.m2120i("HuaweiApi", "run queue size = " + this.f1149a.size());
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                m1077a(it.next());
            }
            Iterator<TaskApiCallbackWrapper> it2 = this.f1149a.iterator();
            while (it2.hasNext()) {
                m1077a(it2.next());
            }
            this.callbackWaitQueue.clear();
            this.f1149a.clear();
            this.f1151c = null;
            this.f1150b.disconnect();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m1080b(ConnectionResult connectionResult) {
            this.f1151c = connectionResult;
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            boolean z = true;
            while (it.hasNext()) {
                TaskApiCallWrapper m1089a = it.next().m1089a();
                ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Failed:" + m1074a(connectionResult) + "(" + connectionResult.getErrorCode() + ")");
                responseHeader.setTransactionId(m1089a.getTaskApiCall().getTransactionId());
                HiAnalyticsInnerClient.reportEntryExit(this.f1152d.getContext(), responseHeader, String.valueOf(this.f1152d.getKitSdkVersion()));
                if (this.f1151c.getResolution() != null && z) {
                    responseHeader.setParcelable(this.f1151c.getResolution());
                    if (Util.isAvailableLibExist(this.f1152d.getContext()) && this.f1151c.getErrorCode() == 26) {
                        responseHeader.setResolution(CommonCode.Resolution.HAS_RESOLUTION);
                    }
                    z = false;
                }
                int errorCode = this.f1151c.getErrorCode();
                if (errorCode == 30 || errorCode == 31) {
                    responseHeader.setErrorCode(errorCode);
                }
                m1089a.getTaskApiCall().onResponse(this.f1150b, responseHeader, null, m1089a.getTaskCompletionSource());
            }
            this.callbackWaitQueue.clear();
            this.f1149a.clear();
            this.f1151c = null;
            this.f1150b.disconnect();
        }

        /* renamed from: a */
        void m1088a(TaskApiCallWrapper taskApiCallWrapper) {
            HMSLog.m2120i("HuaweiApi", "sendRequest");
            TaskApiCallbackWrapper m1078b = m1078b(taskApiCallWrapper);
            if (HMSPackageManager.getInstance(this.f1152d.getContext()).isUpdateHmsForThirdPartyDevice()) {
                this.f1150b.disconnect();
            }
            int hmsVersionCode = HMSPackageManager.getInstance(((HuaweiApi) this.f1152d).f1132a).getHmsVersionCode();
            if ((hmsVersionCode < 40000000 && hmsVersionCode > 0) && this.f1150b.isConnected() && !((HuaweiApi) this.f1152d).f1144m && ((BaseHmsClient) this.f1150b).getAdapter().getServiceAction().equals("com.huawei.hms.core.aidlservice")) {
                int requestHmsVersionCode = this.f1150b.getRequestHmsVersionCode();
                if (requestHmsVersionCode <= taskApiCallWrapper.getTaskApiCall().getMinApkVersion()) {
                    requestHmsVersionCode = taskApiCallWrapper.getTaskApiCall().getMinApkVersion();
                }
                if (requestHmsVersionCode > hmsVersionCode) {
                    this.f1150b.disconnect();
                }
            }
            if (this.f1150b.isConnected()) {
                HMSLog.m2120i("HuaweiApi", "isConnected:true.");
                BinderAdapter adapter = ((BaseHmsClient) this.f1150b).getAdapter();
                adapter.updateDelayTask();
                ((HmsClient) this.f1150b).setService(IAIDLInvoke.Stub.asInterface(adapter.getServiceBinder()));
                postMessage(m1078b);
                return;
            }
            HMSLog.m2120i("HuaweiApi", "isConnected:false.");
            this.callbackWaitQueue.add(m1078b);
            ConnectionResult connectionResult = this.f1151c;
            if (connectionResult != null && connectionResult.getErrorCode() != 0) {
                HMSLog.m2120i("HuaweiApi", "onConnectionFailed, ErrorCode:" + this.f1151c.getErrorCode());
                onConnectionFailed(this.f1151c);
                return;
            }
            RequestManager.addRequestToQueue(this);
            Object obj = this.f1150b;
            if (obj instanceof BaseHmsClient) {
                ((BaseHmsClient) obj).setInternalRequest(this);
            }
            m1087a(taskApiCallWrapper.getTaskApiCall().getMinApkVersion(), m1078b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: b */
        public void m1079b() {
            this.f1151c = null;
            this.f1149a.clear();
            Iterator<TaskApiCallbackWrapper> it = this.callbackWaitQueue.iterator();
            while (it.hasNext()) {
                postMessage(it.next());
            }
            this.callbackWaitQueue.clear();
        }

        /* renamed from: a */
        private String m1075a(String str, String str2) {
            return TextUtils.isEmpty(str) ? TransactionIdCreater.getId(this.f1152d.getAppID(), str2) : str;
        }

        /* renamed from: a */
        synchronized void m1087a(int i, TaskApiCallbackWrapper taskApiCallbackWrapper) {
            if (this.f1150b.isConnected()) {
                HMSLog.m2115d("HuaweiApi", "client is connected");
                return;
            }
            if (this.f1150b.isConnecting()) {
                HMSLog.m2115d("HuaweiApi", "client is isConnecting");
                return;
            }
            if (this.f1152d.getActivity() != null) {
                if (this.f1153e == null) {
                    this.f1153e = new ResolveClientBean(this.f1150b, i);
                }
                if (BindResolveClients.getInstance().isClientRegistered(this.f1153e)) {
                    HMSLog.m2120i("HuaweiApi", "mResolveClientBean has already register, return!");
                    return;
                }
                BindResolveClients.getInstance().register(this.f1153e);
            }
            this.f1150b.connect(i);
        }

        /* renamed from: a */
        void m1086a() {
            this.f1150b.disconnect();
        }

        /* renamed from: a */
        private void m1077a(TaskApiCallbackWrapper taskApiCallbackWrapper) {
            TaskApiCallWrapper m1089a = taskApiCallbackWrapper.m1089a();
            ResponseHeader responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Suspended");
            responseHeader.setTransactionId(m1089a.getTaskApiCall().getTransactionId());
            m1089a.getTaskApiCall().onResponse(this.f1150b, responseHeader, null, m1089a.getTaskCompletionSource());
        }

        /* renamed from: a */
        private String m1074a(ConnectionResult connectionResult) {
            if (Util.isAvailableLibExist(this.f1152d.getContext())) {
                int errorCode = connectionResult.getErrorCode();
                if (errorCode != -1) {
                    if (errorCode == 3) {
                        return "HuaWei Mobile Service is disabled";
                    }
                    if (errorCode != 8) {
                        if (errorCode != 10) {
                            if (errorCode == 13) {
                                return "update cancelled";
                            }
                            if (errorCode == 21) {
                                return "device is too old to be support";
                            }
                            switch (errorCode) {
                                case 25:
                                    return "failed to get update result";
                                case 26:
                                    return "update failed, because no activity incoming, can't pop update page";
                                case 27:
                                    return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
                                default:
                                    return "unknown errorReason";
                            }
                        }
                        return "application configuration error, please developer check configuration";
                    }
                    return "internal error";
                }
                return "get update result, but has other error codes";
            }
            int errorCode2 = connectionResult.getErrorCode();
            if (errorCode2 != -1) {
                if (errorCode2 != 8) {
                    if (errorCode2 != 10) {
                        return "unknown errorReason";
                    }
                    return "application configuration error, please developer check configuration";
                }
                return "internal error";
            }
            return "get update result, but has other error codes";
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class TaskApiCallbackWrapper {

        /* renamed from: a */
        private final TaskApiCallWrapper f1165a;

        /* renamed from: b */
        private final AnyClient.CallBack f1166b;

        TaskApiCallbackWrapper(TaskApiCallWrapper taskApiCallWrapper, AnyClient.CallBack callBack) {
            this.f1165a = taskApiCallWrapper;
            this.f1166b = callBack;
        }

        /* renamed from: a */
        TaskApiCallWrapper m1089a() {
            return this.f1165a;
        }

        /* renamed from: b */
        AnyClient.CallBack m1090b() {
            return this.f1166b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.common.HuaweiApi$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class RunnableC1055a<OptionsT extends Api.ApiOptions> implements Runnable {

        /* renamed from: a */
        private final HuaweiApi<OptionsT> f1167a;

        /* renamed from: b */
        private final TaskApiCallWrapper f1168b;

        public RunnableC1055a(HuaweiApi<OptionsT> huaweiApi, TaskApiCallWrapper taskApiCallWrapper) {
            this.f1167a = huaweiApi;
            this.f1168b = taskApiCallWrapper;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0054 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void m1091a(RequestHandler requestHandler, Throwable th) {
            Throwable th2;
            AnyClient anyClient;
            String str;
            ResponseHeader responseHeader;
            TaskCompletionSource taskCompletionSource;
            TaskApiCall taskApiCall = null;
            try {
                anyClient = requestHandler.getClient();
                try {
                    responseHeader = new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, th.getMessage());
                    try {
                        str = new JSONObject().toString();
                        try {
                            taskCompletionSource = this.f1168b.getTaskCompletionSource();
                            try {
                                taskApiCall = this.f1168b.getTaskApiCall();
                            } catch (Throwable th3) {
                                th2 = th3;
                                HMSLog.m2118e("HuaweiApi", "<notifyCpException> " + th2.getMessage());
                                if ((anyClient != null || responseHeader == null || str == null || taskCompletionSource == null || taskApiCall == null) ? false : true) {
                                }
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            taskCompletionSource = null;
                        }
                    } catch (Throwable th5) {
                        th2 = th5;
                        str = null;
                        taskCompletionSource = null;
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    str = null;
                    responseHeader = null;
                    taskCompletionSource = null;
                    HMSLog.m2118e("HuaweiApi", "<notifyCpException> " + th2.getMessage());
                    if ((anyClient != null || responseHeader == null || str == null || taskCompletionSource == null || taskApiCall == null) ? false : true) {
                    }
                }
            } catch (Throwable th7) {
                th2 = th7;
                anyClient = null;
            }
            if ((anyClient != null || responseHeader == null || str == null || taskCompletionSource == null || taskApiCall == null) ? false : true) {
                taskApiCall.onResponse(anyClient, responseHeader, str, taskCompletionSource);
            } else {
                HMSLog.m2118e("HuaweiApi", "<notifyCpException> isNotify is false, Can not notify CP.");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            RequestHandler requestHandler = new RequestHandler(this.f1167a);
            try {
                requestHandler.m1088a(this.f1168b);
            } catch (Throwable th) {
                HMSLog.m2119e("HuaweiApi", "sendRequest has exception", th);
                m1091a(requestHandler, th);
            }
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f1139h = new WeakReference<>(activity);
        m1066a(activity, api, toption, abstractClientBuilder, i, null);
    }

    @Deprecated
    public Task<Boolean> disconnectService() {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        RequestManager.getInstance();
        RequestManager.getHandler().post(new Runnable() { // from class: com.huawei.hms.common.HuaweiApi.1
            @Override // java.lang.Runnable
            public void run() {
                HuaweiApi.this.m1068a((HuaweiApi<?>) this, (TaskCompletionSource<Boolean>) taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> taskApiCall) {
        this.f1142k = true;
        if (taskApiCall == null) {
            HMSLog.m2118e("HuaweiApi", "in doWrite:taskApiCall is null");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setException(new ApiException(Status.FAILURE));
            return taskCompletionSource.getTask();
        }
        HiAnalyticsInnerClient.reportEntryClient(this.f1132a, taskApiCall.getUri(), TextUtils.isEmpty(this.f1138g.getSubAppID()) ? this.f1137f : this.f1138g.getSubAppID(), taskApiCall.getTransactionId(), String.valueOf(getKitSdkVersion()));
        if (this.f1145n == null) {
            this.f1145n = RequestManager.getInstance();
        }
        return m1064a(taskApiCall);
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.f1139h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public int getApiLevel() {
        return this.f1141j;
    }

    public String getAppID() {
        return this.f1137f;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.huawei.hms.common.internal.AnyClient] */
    public AnyClient getClient(Looper looper, RequestHandler requestHandler) {
        return this.f1135d.buildClient(this.f1132a, getClientSetting(), requestHandler, requestHandler);
    }

    protected ClientSettings getClientSetting() {
        ClientSettings clientSettings = new ClientSettings(this.f1132a.getPackageName(), this.f1132a.getClass().getName(), getScopes(), this.f1136e, null, this.f1138g);
        if (!this.f1144m) {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(this.f1132a).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                hMSPackageNameForMultiService = "com.huawei.hwid";
            }
            this.f1143l = hMSPackageNameForMultiService;
            HMSLog.m2120i("HuaweiApi", "No setInnerHms, hms pkg name is " + this.f1143l);
        }
        clientSettings.setInnerHmsPkg(this.f1143l);
        clientSettings.setUseInnerHms(this.f1144m);
        WeakReference<Activity> weakReference = this.f1139h;
        if (weakReference != null) {
            clientSettings.setCpActivity(weakReference.get());
        }
        return clientSettings;
    }

    public Context getContext() {
        return this.f1132a;
    }

    public int getKitSdkVersion() {
        return this.f1140i;
    }

    public TOption getOption() {
        return this.f1133b;
    }

    protected List<Scope> getScopes() {
        return Collections.emptyList();
    }

    public String getSubAppID() {
        return this.f1138g.getSubAppID();
    }

    public void setApiLevel(int i) {
        this.f1141j = i;
    }

    public void setHostContext(Context context) {
        this.f1134c = context;
    }

    public void setInnerHms() {
        this.f1143l = this.f1132a.getPackageName();
        this.f1144m = true;
        HMSLog.m2120i("HuaweiApi", "<setInnerHms> init inner hms pkg info:" + this.f1143l);
    }

    public void setKitSdkVersion(int i) {
        this.f1140i = i;
    }

    public void setSubAppId(String str) throws ApiException {
        if (!setSubAppInfo(new SubAppInfo(str))) {
            throw new ApiException(Status.FAILURE);
        }
    }

    @Deprecated
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.m2120i("HuaweiApi", "Enter setSubAppInfo");
        SubAppInfo subAppInfo2 = this.f1138g;
        if (subAppInfo2 != null && !TextUtils.isEmpty(subAppInfo2.getSubAppID())) {
            HMSLog.m2118e("HuaweiApi", "subAppInfo is already set");
            return false;
        }
        if (subAppInfo == null) {
            HMSLog.m2118e("HuaweiApi", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.m2118e("HuaweiApi", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(this.f1136e)) {
            HMSLog.m2118e("HuaweiApi", "subAppId is host appid");
            return false;
        }
        if (this.f1142k) {
            HMSLog.m2118e("HuaweiApi", "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
            return false;
        }
        this.f1138g = new SubAppInfo(subAppInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1070b(Context context) {
        String appId = Util.getAppId(context);
        this.f1136e = appId;
        this.f1137f = appId;
    }

    /* renamed from: a */
    private void m1066a(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i, String str) {
        this.f1132a = context.getApplicationContext();
        this.f1133b = toption;
        this.f1135d = abstractClientBuilder;
        m1070b(context);
        this.f1138g = new SubAppInfo("");
        this.f1140i = i;
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(this.f1136e)) {
                HMSLog.m2118e("HuaweiApi", "subAppId is host appid");
            } else {
                HMSLog.m2120i("HuaweiApi", "subAppId is " + str);
                this.f1138g = new SubAppInfo(str);
            }
        }
        m1065a(context);
        if (Util.isAvailableLibExist(context)) {
            AvailableUtil.asyncCheckHmsUpdateInfo(context);
        }
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i, String str) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f1139h = new WeakReference<>(activity);
        m1066a(activity, api, toption, abstractClientBuilder, i, str);
    }

    /* renamed from: a */
    private void m1065a(Context context) {
        HMSBIInitializer.getInstance(context).initBI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1068a(HuaweiApi<?> huaweiApi, TaskCompletionSource<Boolean> taskCompletionSource) {
        HMSLog.m2120i("HuaweiApi", "innerDisconnect.");
        try {
            huaweiApi.getClient(RequestManager.getHandler().getLooper(), null).disconnect();
            taskCompletionSource.setResult(Boolean.TRUE);
        } catch (Exception e) {
            HMSLog.m2121w("HuaweiApi", "disconnect the binder failed for:" + e.getMessage());
        }
    }

    /* renamed from: a */
    private <TResult, TClient extends AnyClient> Task<TResult> m1064a(TaskApiCall<TClient, TResult> taskApiCall) {
        TaskCompletionSource taskCompletionSource;
        if (taskApiCall.getToken() == null) {
            taskCompletionSource = new TaskCompletionSource();
        } else {
            taskCompletionSource = new TaskCompletionSource(taskApiCall.getToken());
        }
        RequestManager.getHandler().post(new RunnableC1055a(this, new TaskApiCallWrapper(taskApiCall, taskCompletionSource)));
        return taskCompletionSource.getTask();
    }

    public HuaweiApi(Activity activity, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(activity, "Null activity is not permitted.");
        this.f1139h = new WeakReference<>(activity);
        m1066a(activity, api, toption, abstractClientBuilder, 0, null);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        m1066a(context, api, toption, abstractClientBuilder, i, null);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder, int i, String str) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        m1066a(context, api, toption, abstractClientBuilder, i, str);
    }

    public HuaweiApi(Context context, Api<TOption> api, TOption toption, AbstractClientBuilder abstractClientBuilder) {
        Checker.checkNonNull(context, "Null context is not permitted.");
        m1066a(context, api, toption, abstractClientBuilder, 0, null);
    }
}
