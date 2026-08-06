package com.huawei.hms.common.internal;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.InnerBinderAdapter;
import com.huawei.hms.adapter.OuterBinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.FailedBinderCallBack;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class BaseHmsClient implements AidlApiClient {
    protected static final int TIMEOUT_DISCONNECTED = 6;

    /* renamed from: i */
    private static final Object f1179i = new Object();

    /* renamed from: j */
    private static final AtomicInteger f1180j = new AtomicInteger(1);

    /* renamed from: k */
    private static final AtomicInteger f1181k = new AtomicInteger(1);

    /* renamed from: l */
    private static BinderAdapter f1182l;

    /* renamed from: m */
    private static BinderAdapter f1183m;

    /* renamed from: a */
    private final Context f1184a;

    /* renamed from: b */
    private String f1185b;

    /* renamed from: c */
    private final ClientSettings f1186c;

    /* renamed from: d */
    private volatile IAIDLInvoke f1187d;

    /* renamed from: e */
    private final ConnectionCallbacks f1188e;

    /* renamed from: f */
    private final OnConnectionFailedListener f1189f;

    /* renamed from: g */
    private Handler f1190g = null;

    /* renamed from: h */
    private HuaweiApi.RequestHandler f1191h;
    protected String sessionId;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int i);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static final class ConnectionResultWrapper {

        /* renamed from: a */
        private HuaweiApi.RequestHandler f1196a;

        /* renamed from: b */
        private ConnectionResult f1197b;

        public ConnectionResultWrapper(HuaweiApi.RequestHandler requestHandler, ConnectionResult connectionResult) {
            this.f1196a = requestHandler;
            this.f1197b = connectionResult;
        }

        public ConnectionResult getConnectionResult() {
            return this.f1197b;
        }

        public HuaweiApi.RequestHandler getRequest() {
            return this.f1196a;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    public BaseHmsClient(Context context, ClientSettings clientSettings, OnConnectionFailedListener onConnectionFailedListener, ConnectionCallbacks connectionCallbacks) {
        this.f1184a = context;
        this.f1186c = clientSettings;
        if (clientSettings != null) {
            this.f1185b = clientSettings.getAppID();
        }
        this.f1189f = onConnectionFailedListener;
        this.f1188e = connectionCallbacks;
    }

    /* renamed from: d */
    private BinderAdapter.BinderCallBack m1110d() {
        return new BinderAdapter.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1
            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i) {
                onBinderFailed(i, null);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onNullBinding(ComponentName componentName) {
                BaseHmsClient.this.m1114b(1);
                BaseHmsClient.this.m1098a(10);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                HMSLog.m2120i("BaseHmsClient", "Enter onServiceConnected.");
                BaseHmsClient.this.connectedInternal(iBinder);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onServiceDisconnected(ComponentName componentName) {
                HMSLog.m2120i("BaseHmsClient", "Enter onServiceDisconnected.");
                BaseHmsClient.this.m1114b(1);
                RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUSPENDED);
                if (BaseHmsClient.this.f1188e == null || (BaseHmsClient.this.f1188e instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.f1188e.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onTimedDisconnected() {
                BaseHmsClient.this.m1114b(6);
                if (BaseHmsClient.this.f1188e == null || (BaseHmsClient.this.f1188e instanceof HuaweiApi.RequestHandler)) {
                    return;
                }
                BaseHmsClient.this.f1188e.onConnectionSuspended(1);
            }

            @Override // com.huawei.hms.adapter.BinderAdapter.BinderCallBack
            public void onBinderFailed(int i, Intent intent) {
                if (intent != null) {
                    Activity activeActivity = Util.getActiveActivity(BaseHmsClient.this.getClientSettings().getCpActivity(), BaseHmsClient.this.getContext());
                    if (activeActivity != null) {
                        HMSLog.m2120i("BaseHmsClient", "onBinderFailed: SDK try to resolve and reConnect!");
                        long time = new Timestamp(System.currentTimeMillis()).getTime();
                        FailedBinderCallBack.getInstance().setCallBack(Long.valueOf(time), new FailedBinderCallBack.BinderCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.1.1
                            @Override // com.huawei.hms.api.FailedBinderCallBack.BinderCallBack
                            public void binderCallBack(int i2) {
                                if (i2 != 0) {
                                    BaseHmsClient.this.m1101a(new ConnectionResult(10, (PendingIntent) null));
                                    BaseHmsClient.this.f1187d = null;
                                }
                            }
                        });
                        intent.putExtra(FailedBinderCallBack.CALLER_ID, time);
                        activeActivity.startActivity(intent);
                        return;
                    }
                    HMSLog.m2120i("BaseHmsClient", "onBinderFailed: return pendingIntent to kit and cp");
                    BaseHmsClient.this.m1101a(new ConnectionResult(10, PendingIntent.getActivity(BaseHmsClient.this.f1184a, 11, intent, 67108864)));
                    BaseHmsClient.this.f1187d = null;
                    return;
                }
                HMSLog.m2120i("BaseHmsClient", "onBinderFailed: intent is null!");
                BaseHmsClient.this.m1101a(new ConnectionResult(10, (PendingIntent) null));
                BaseHmsClient.this.f1187d = null;
            }
        };
    }

    /* renamed from: e */
    private void m1111e() {
        HMSLog.m2121w("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
        if (this.f1186c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f1183m;
            if (binderAdapter == null) {
                HMSLog.m2121w("BaseHmsClient", "mInnerBinderAdapter is null.");
                return;
            }
            binderAdapter.unBind();
        } else {
            BinderAdapter binderAdapter2 = f1182l;
            if (binderAdapter2 == null) {
                HMSLog.m2121w("BaseHmsClient", "mOuterBinderAdapter is null.");
                return;
            }
            binderAdapter2.unBind();
        }
        m1114b(1);
        m1098a(10);
    }

    /* renamed from: f */
    private void m1112f() {
        if (this.f1186c.isUseInnerHms()) {
            BinderAdapter binderAdapter = f1183m;
            if (binderAdapter != null) {
                binderAdapter.unBind();
                return;
            }
            return;
        }
        BinderAdapter binderAdapter2 = f1182l;
        if (binderAdapter2 != null) {
            binderAdapter2.unBind();
        }
    }

    protected final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void connect(int i) {
        m1099a(i, false);
    }

    public void connectedInternal(IBinder iBinder) {
        this.f1187d = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f1187d == null) {
            HMSLog.m2118e("BaseHmsClient", "mService is null, try to unBind.");
            m1111e();
        } else {
            onConnecting();
        }
    }

    protected final void connectionConnected() {
        m1114b(3);
        RequestManager.getHandler().sendEmptyMessage(RequestManager.NOTIFY_CONNECT_SUCCESS);
        ConnectionCallbacks connectionCallbacks = this.f1188e;
        if (connectionCallbacks == null || (connectionCallbacks instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        connectionCallbacks.onConnected();
    }

    public void disconnect() {
        int i = (this.f1186c.isUseInnerHms() ? f1181k : f1180j).get();
        HMSLog.m2120i("BaseHmsClient", "Enter disconnect, Connection Status: " + i);
        if (i == 3) {
            m1112f();
            m1114b(1);
        } else {
            if (i != 5) {
                return;
            }
            m1106b();
            m1114b(1);
        }
    }

    public BinderAdapter getAdapter() {
        HMSLog.m2120i("BaseHmsClient", "getAdapter:isInner:" + this.f1186c.isUseInnerHms() + ", mInnerBinderAdapter:" + f1183m + ", mOuterBinderAdapter:" + f1182l);
        return this.f1186c.isUseInnerHms() ? f1183m : f1182l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        return this.f1186c.getApiName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f1185b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClientSettings getClientSettings() {
        return this.f1186c;
    }

    public int getConnectionStatus() {
        return (this.f1186c.isUseInnerHms() ? f1181k : f1180j).get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.f1184a;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f1186c.getCpID();
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.f1186c.getClientPackageName();
    }

    public int getRequestHmsVersionCode() {
        return getMinApkVersion();
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f1187d;
    }

    public String getServiceAction() {
        HMSPackageManager hMSPackageManager = HMSPackageManager.getInstance(this.f1184a);
        if (this.f1186c.isUseInnerHms()) {
            return hMSPackageManager.getInnerServiceAction();
        }
        return hMSPackageManager.getServiceAction();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.sessionId;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public SubAppInfo getSubAppInfo() {
        return this.f1186c.getSubAppID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        return !this.f1186c.isUseInnerHms() ? f1180j.get() != 3 : f1181k.get() != 3;
    }

    public boolean isConnecting() {
        return (this.f1186c.isUseInnerHms() ? f1181k : f1180j).get() == 5;
    }

    public void onConnecting() {
        connectionConnected();
    }

    public final void setInternalRequest(HuaweiApi.RequestHandler requestHandler) {
        this.f1191h = requestHandler;
    }

    public void setService(IAIDLInvoke iAIDLInvoke) {
        this.f1187d = iAIDLInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m1108c() {
        return HMSPackageManager.getInstance(this.f1184a).getHMSPackageStatesForMultiService() == PackageManagerHelper.PackageStates.ENABLED;
    }

    /* renamed from: b */
    void m1114b(int i) {
        if (this.f1186c.isUseInnerHms()) {
            f1181k.set(i);
        } else {
            f1180j.set(i);
        }
    }

    public void connect(int i, boolean z) {
        m1099a(i, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1113a() {
        String innerHmsPkg = this.f1186c.getInnerHmsPkg();
        String serviceAction = getServiceAction();
        HMSLog.m2120i("BaseHmsClient", "enter bindCoreService, packageName is " + innerHmsPkg + ", serviceAction is " + serviceAction);
        m1104a(innerHmsPkg, serviceAction);
    }

    /* renamed from: b */
    private void m1106b() {
        synchronized (f1179i) {
            Handler handler = this.f1190g;
            if (handler != null) {
                handler.removeMessages(2);
                this.f1190g = null;
            }
        }
    }

    /* renamed from: a */
    private void m1104a(String str, String str2) {
        if (this.f1186c.isUseInnerHms()) {
            f1183m = InnerBinderAdapter.getInstance(this.f1184a, str2, str);
            if (isConnected()) {
                HMSLog.m2120i("BaseHmsClient", "The binder is already connected.");
                getAdapter().updateDelayTask();
                connectedInternal(getAdapter().getServiceBinder());
                return;
            } else {
                m1114b(5);
                f1183m.binder(m1110d());
                return;
            }
        }
        f1182l = OuterBinderAdapter.getInstance(this.f1184a, str2, str);
        if (isConnected()) {
            HMSLog.m2120i("BaseHmsClient", "The binder is already connected.");
            getAdapter().updateDelayTask();
            connectedInternal(getAdapter().getServiceBinder());
        } else {
            m1114b(5);
            f1182l.binder(m1110d());
        }
    }

    /* renamed from: b */
    private void m1107b(AvailableAdapter availableAdapter, int i) {
        HMSLog.m2120i("BaseHmsClient", "enter HmsCore resolution");
        if (!getClientSettings().isHasActivity()) {
            m1101a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f1184a, i, 0)));
            return;
        }
        Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (activeActivity != null) {
            availableAdapter.startResolution(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.3
                @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                public void onComplete(int i2) {
                    if (i2 == 0 && BaseHmsClient.this.m1108c()) {
                        BaseHmsClient.this.m1113a();
                    } else {
                        BaseHmsClient.this.m1098a(i2);
                    }
                }
            });
        } else {
            m1098a(26);
        }
    }

    /* renamed from: a */
    private void m1099a(int i, boolean z) {
        HMSLog.m2120i("BaseHmsClient", "====== HMSSDK version: 61300301 ======");
        int i2 = (this.f1186c.isUseInnerHms() ? f1181k : f1180j).get();
        HMSLog.m2120i("BaseHmsClient", "Enter connect, Connection Status: " + i2);
        if (z || !(i2 == 3 || i2 == 5)) {
            if (getMinApkVersion() > i) {
                i = getMinApkVersion();
            }
            HMSLog.m2120i("BaseHmsClient", "connect minVersion:" + i + " packageName:" + this.f1186c.getInnerHmsPkg());
            if (this.f1184a.getPackageName().equals(this.f1186c.getInnerHmsPkg())) {
                HMSLog.m2120i("BaseHmsClient", "service packageName is same, bind core service return");
                m1113a();
                return;
            }
            if (Util.isAvailableLibExist(this.f1184a)) {
                AvailableAdapter availableAdapter = new AvailableAdapter(i);
                int isHuaweiMobileServicesAvailable = availableAdapter.isHuaweiMobileServicesAvailable(this.f1184a);
                HMSLog.m2120i("BaseHmsClient", "check available result: " + isHuaweiMobileServicesAvailable);
                if (isHuaweiMobileServicesAvailable == 0) {
                    m1113a();
                    return;
                }
                if (availableAdapter.isUserResolvableError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.m2120i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
                    m1107b(availableAdapter, isHuaweiMobileServicesAvailable);
                    return;
                } else if (availableAdapter.isUserNoticeError(isHuaweiMobileServicesAvailable)) {
                    HMSLog.m2120i("BaseHmsClient", "bindCoreService3.0 fail, start notice now.");
                    m1100a(availableAdapter, isHuaweiMobileServicesAvailable);
                    return;
                } else {
                    HMSLog.m2120i("BaseHmsClient", "bindCoreService3.0 fail: " + isHuaweiMobileServicesAvailable + " is not resolvable.");
                    m1098a(isHuaweiMobileServicesAvailable);
                    return;
                }
            }
            int isHuaweiMobileServicesAvailable2 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.f1184a, i);
            HMSLog.m2120i("BaseHmsClient", "HuaweiApiAvailability check available result: " + isHuaweiMobileServicesAvailable2);
            if (isHuaweiMobileServicesAvailable2 == 0) {
                m1113a();
            } else {
                m1098a(isHuaweiMobileServicesAvailable2);
            }
        }
    }

    /* renamed from: a */
    private void m1100a(AvailableAdapter availableAdapter, int i) {
        HMSLog.m2120i("BaseHmsClient", "enter notice");
        if (!getClientSettings().isHasActivity()) {
            if (i == 29) {
                i = 9;
            }
            m1101a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f1184a, i, 0)));
        } else {
            Activity activeActivity = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
            if (activeActivity != null) {
                availableAdapter.startNotice(activeActivity, new AvailableAdapter.AvailableCallBack() { // from class: com.huawei.hms.common.internal.BaseHmsClient.2
                    @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
                    public void onComplete(int i2) {
                        BaseHmsClient.this.m1098a(i2);
                    }
                });
            } else {
                m1098a(26);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1098a(int i) {
        HMSLog.m2120i("BaseHmsClient", "notifyFailed result: " + i);
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        message.obj = new ConnectionResultWrapper(this.f1191h, new ConnectionResult(i));
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f1189f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1101a(ConnectionResult connectionResult) {
        HMSLog.m2120i("BaseHmsClient", "notifyFailed result: " + connectionResult.getErrorCode());
        Message message = new Message();
        message.what = RequestManager.NOTIFY_CONNECT_FAILED;
        HuaweiApi.RequestHandler requestHandler = this.f1191h;
        this.f1191h = null;
        message.obj = new ConnectionResultWrapper(requestHandler, connectionResult);
        RequestManager.getHandler().sendMessage(message);
        OnConnectionFailedListener onConnectionFailedListener = this.f1189f;
        if (onConnectionFailedListener == null || (onConnectionFailedListener instanceof HuaweiApi.RequestHandler)) {
            return;
        }
        onConnectionFailedListener.onConnectionFailed(connectionResult);
    }
}
