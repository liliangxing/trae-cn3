package com.huawei.hms.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.heytap.mcssdk.constant.C0878a;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.common.api.ConnectionPostProcessor;
import com.huawei.hms.common.internal.AutoLifecycleFragment;
import com.huawei.hms.core.aidl.CodecLookup;
import com.huawei.hms.core.aidl.DataBuffer;
import com.huawei.hms.core.aidl.IAIDLCallback;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.MessageCodec;
import com.huawei.hms.core.aidl.RequestHeader;
import com.huawei.hms.core.aidl.ResponseHeader;
import com.huawei.hms.support.api.PendingResultImpl;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.BundleResult;
import com.huawei.hms.support.api.client.InnerApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.core.ConnectService;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class HuaweiApiClientImpl extends HuaweiApiClient implements InnerApiClient, ServiceConnection {

    /* renamed from: A */
    private static final Object f1061A = new Object();

    /* renamed from: B */
    private static final Object f1062B = new Object();
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;

    /* renamed from: b */
    private final Context f1064b;

    /* renamed from: c */
    private final String f1065c;

    /* renamed from: d */
    private String f1066d;

    /* renamed from: e */
    private String f1067e;

    /* renamed from: f */
    private volatile IAIDLInvoke f1068f;

    /* renamed from: g */
    private String f1069g;

    /* renamed from: h */
    private WeakReference<Activity> f1070h;

    /* renamed from: i */
    private WeakReference<Activity> f1071i;

    /* renamed from: l */
    private List<Scope> f1074l;

    /* renamed from: m */
    private List<PermissionInfo> f1075m;

    /* renamed from: n */
    private Map<Api<?>, Api.ApiOptions> f1076n;

    /* renamed from: o */
    private SubAppInfo f1077o;

    /* renamed from: s */
    private final ReentrantLock f1081s;

    /* renamed from: t */
    private final Condition f1082t;

    /* renamed from: u */
    private ConnectionResult f1083u;

    /* renamed from: v */
    private HuaweiApiClient.ConnectionCallbacks f1084v;

    /* renamed from: w */
    private HuaweiApiClient.OnConnectionFailedListener f1085w;

    /* renamed from: x */
    private Handler f1086x;

    /* renamed from: y */
    private Handler f1087y;

    /* renamed from: z */
    private CheckUpdatelistener f1088z;

    /* renamed from: a */
    private int f1063a = -1;

    /* renamed from: j */
    private boolean f1072j = false;

    /* renamed from: k */
    private AtomicInteger f1073k = new AtomicInteger(1);

    /* renamed from: p */
    private long f1078p = 0;

    /* renamed from: q */
    private int f1079q = 0;

    /* renamed from: r */
    private final Object f1080r = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1030a implements Handler.Callback {
        C1030a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 2) {
                return false;
            }
            HMSLog.m2118e("HuaweiApiClientImpl", "In connect, bind core service time out");
            if (HuaweiApiClientImpl.this.f1073k.get() == 5) {
                HuaweiApiClientImpl.this.m1012c(1);
                HuaweiApiClientImpl.this.m1005b();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1031b implements Handler.Callback {
        C1031b() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 3) {
                return false;
            }
            HMSLog.m2118e("HuaweiApiClientImpl", "In connect, process time out");
            if (HuaweiApiClientImpl.this.f1073k.get() == 2) {
                HuaweiApiClientImpl.this.m1012c(1);
                HuaweiApiClientImpl.this.m1005b();
            }
            return true;
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    class BinderC1032c extends IAIDLCallback.Stub {

        /* renamed from: a */
        final /* synthetic */ ResultCallback f1091a;

        BinderC1032c(ResultCallback resultCallback) {
            this.f1091a = resultCallback;
        }

        @Override // com.huawei.hms.core.aidl.IAIDLCallback
        public void call(DataBuffer dataBuffer) {
            if (dataBuffer != null) {
                MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
                ResponseHeader responseHeader = new ResponseHeader();
                find.decode(dataBuffer.header, responseHeader);
                BundleResult bundleResult = new BundleResult(responseHeader.getStatusCode(), dataBuffer.getBody());
                HMSLog.m2120i("HuaweiApiClientImpl", "Exit asyncRequest onResult");
                this.f1091a.onResult(bundleResult);
                return;
            }
            HMSLog.m2120i("HuaweiApiClientImpl", "Exit asyncRequest onResult -1");
            this.f1091a.onResult(new BundleResult(-1, null));
        }
    }

    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    static class C1033d extends PendingResultImpl<Status, IMessageEntity> {
        public C1033d(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
            super(apiClient, str, iMessageEntity);
        }

        @Override // com.huawei.hms.support.api.PendingResultImpl
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Status onComplete(IMessageEntity iMessageEntity) {
            return new Status(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$e */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1034e implements ResultCallback<ResolveResult<ConnectResp>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$e$a */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ResolveResult f1094a;

            a(ResolveResult resolveResult) {
                this.f1094a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApiClientImpl.this.m1003a((ResolveResult<ConnectResp>) this.f1094a);
            }
        }

        private C1034e() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(ResolveResult<ConnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        /* synthetic */ C1034e(HuaweiApiClientImpl huaweiApiClientImpl, C1030a c1030a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$f */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1035f implements ResultCallback<ResolveResult<DisconnectResp>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$f$a */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public class a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ResolveResult f1097a;

            a(ResolveResult resolveResult) {
                this.f1097a = resolveResult;
            }

            @Override // java.lang.Runnable
            public void run() {
                HuaweiApiClientImpl.this.m1009b((ResolveResult<DisconnectResp>) this.f1097a);
            }
        }

        private C1035f() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(ResolveResult<DisconnectResp> resolveResult) {
            new Handler(Looper.getMainLooper()).post(new a(resolveResult));
        }

        /* synthetic */ C1035f(HuaweiApiClientImpl huaweiApiClientImpl, C1030a c1030a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.api.HuaweiApiClientImpl$g */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1036g implements ResultCallback<ResolveResult<JosGetNoticeResp>> {
        private C1036g() {
        }

        @Override // com.huawei.hms.support.api.client.ResultCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(ResolveResult<JosGetNoticeResp> resolveResult) {
            JosGetNoticeResp value;
            Intent noticeIntent;
            if (resolveResult == null || !resolveResult.getStatus().isSuccess() || (noticeIntent = (value = resolveResult.getValue()).getNoticeIntent()) == null || value.getStatusCode() != 0) {
                return;
            }
            HMSLog.m2120i("HuaweiApiClientImpl", "get notice has intent.");
            Activity validActivity = Util.getValidActivity((Activity) HuaweiApiClientImpl.this.f1070h.get(), HuaweiApiClientImpl.this.getTopActivity());
            if (validActivity != null) {
                HuaweiApiClientImpl.this.f1072j = true;
                validActivity.startActivity(noticeIntent);
            } else {
                HMSLog.m2118e("HuaweiApiClientImpl", "showNotice no valid activity!");
            }
        }

        /* synthetic */ C1036g(HuaweiApiClientImpl huaweiApiClientImpl, C1030a c1030a) {
            this();
        }
    }

    public HuaweiApiClientImpl(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f1081s = reentrantLock;
        this.f1082t = reentrantLock.newCondition();
        this.f1086x = null;
        this.f1087y = null;
        this.f1088z = null;
        this.f1064b = context;
        String appId = Util.getAppId(context);
        this.f1065c = appId;
        this.f1066d = appId;
        this.f1067e = Util.getCpId(context);
    }

    /* renamed from: d */
    private DisconnectInfo m1014d() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f1076n;
        if (map != null) {
            Iterator<Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getApiName());
            }
        }
        return new DisconnectInfo(this.f1074l, arrayList);
    }

    /* renamed from: e */
    private int m1015e() {
        int hmsVersion = Util.getHmsVersion(this.f1064b);
        if (hmsVersion != 0 && hmsVersion >= 20503000) {
            return hmsVersion;
        }
        int m1016f = m1016f();
        if (m1017g()) {
            if (m1016f < 20503000) {
                return 20503000;
            }
            return m1016f;
        }
        if (m1016f < 20600000) {
            return 20600000;
        }
        return m1016f;
    }

    /* renamed from: f */
    private int m1016f() {
        Integer num;
        int intValue;
        Map<Api<?>, Api.ApiOptions> apiMap = getApiMap();
        int i = 0;
        if (apiMap == null) {
            return 0;
        }
        Iterator<Api<?>> it = apiMap.keySet().iterator();
        while (it.hasNext()) {
            String apiName = it.next().getApiName();
            if (!TextUtils.isEmpty(apiName) && (num = HuaweiApiAvailability.getApiMap().get(apiName)) != null && (intValue = num.intValue()) > i) {
                i = intValue;
            }
        }
        return i;
    }

    /* renamed from: g */
    private boolean m1017g() {
        Map<Api<?>, Api.ApiOptions> map = this.f1076n;
        if (map == null) {
            return false;
        }
        Iterator<Api<?>> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (HuaweiApiAvailability.HMS_API_NAME_GAME.equals(it.next().getApiName())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private void m1018h() {
        Handler handler = this.f1086x;
        if (handler != null) {
            handler.removeMessages(2);
        } else {
            this.f1086x = new Handler(Looper.getMainLooper(), new C1030a());
        }
        this.f1086x.sendEmptyMessageDelayed(2, C0878a.f532r);
    }

    /* renamed from: i */
    private void m1019i() {
        synchronized (f1062B) {
            Handler handler = this.f1087y;
            if (handler != null) {
                handler.removeMessages(3);
            } else {
                this.f1087y = new Handler(Looper.getMainLooper(), new C1031b());
            }
            HMSLog.m2115d("HuaweiApiClientImpl", "sendEmptyMessageDelayed for onConnectionResult 3 seconds. the result is : " + this.f1087y.sendEmptyMessageDelayed(3, 3000L));
        }
    }

    /* renamed from: j */
    private void m1020j() {
        HMSLog.m2120i("HuaweiApiClientImpl", "Enter sendConnectApiServceRequest.");
        ConnectService.connect(this, m1010c()).setResultCallback(new C1034e(this, null));
    }

    /* renamed from: k */
    private void m1021k() {
        ConnectService.disconnect(this, m1014d()).setResultCallback(new C1035f(this, null));
    }

    /* renamed from: l */
    private void m1022l() {
        HMSLog.m2120i("HuaweiApiClientImpl", "Enter sendForceConnectApiServceRequest.");
        ConnectService.forceConnect(this, m1010c()).setResultCallback(new C1034e(this, null));
    }

    /* renamed from: m */
    private void m1023m() {
        if (this.f1072j) {
            HMSLog.m2120i("HuaweiApiClientImpl", "Connect notice has been shown.");
        } else if (HuaweiApiAvailability.getInstance().isHuaweiMobileNoticeAvailable(this.f1064b) == 0) {
            ConnectService.getNotice(this, 0, "6.13.0.301").setResultCallback(new C1036g(this, null));
        }
    }

    /* renamed from: n */
    private void m1024n() {
        Util.unBindServiceCatchException(this.f1064b, this);
        this.f1068f = null;
    }

    public int asyncRequest(Bundle bundle, String str, int i, ResultCallback<BundleResult> resultCallback) {
        HMSLog.m2120i("HuaweiApiClientImpl", "Enter asyncRequest.");
        if (resultCallback != null && str != null && bundle != null) {
            if (!innerIsConnected()) {
                HMSLog.m2118e("HuaweiApiClientImpl", "client is unConnect.");
                return CommonCode.ErrorCode.CLIENT_API_INVALID;
            }
            DataBuffer dataBuffer = new DataBuffer(str, i);
            MessageCodec find = CodecLookup.find(dataBuffer.getProtocol());
            dataBuffer.addBody(bundle);
            RequestHeader requestHeader = new RequestHeader(getAppID(), getPackageName(), 61300301, getSessionId());
            requestHeader.setApiNameList(getApiNameList());
            dataBuffer.header = find.encode(requestHeader, new Bundle());
            try {
                getService().asyncCall(dataBuffer, new BinderC1032c(resultCallback));
                return 0;
            } catch (RemoteException e) {
                HMSLog.m2118e("HuaweiApiClientImpl", "remote exception:" + e.getMessage());
                return CommonCode.ErrorCode.INTERNAL_ERROR;
            }
        }
        HMSLog.m2118e("HuaweiApiClientImpl", "arguments is invalid.");
        return CommonCode.ErrorCode.ARGUMENTS_INVALID;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void checkUpdate(Activity activity, CheckUpdatelistener checkUpdatelistener) {
        if (checkUpdatelistener == null) {
            HMSLog.m2118e("HuaweiApiClientImpl", "listener is null!");
            return;
        }
        if (activity != null && !activity.isFinishing()) {
            this.f1088z = checkUpdatelistener;
            try {
                Class<?> cls = Class.forName("com.huawei.hms.update.manager.CheckUpdateLegacy");
                cls.getMethod("initCheckUpdateCallBack", Object.class, Activity.class).invoke(cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), this, activity);
                return;
            } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                HMSLog.m2118e("HuaweiApiClientImpl", "invoke CheckUpdateLegacy.initCheckUpdateCallBack fail. " + e.getMessage());
                checkUpdatelistener.onResult(-1);
                return;
            }
        }
        HMSLog.m2118e("HuaweiApiClientImpl", "checkUpdate, activity is illegal: " + activity);
        checkUpdatelistener.onResult(-1);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(Activity activity) {
        HMSLog.m2120i("HuaweiApiClientImpl", "====== HMSSDK version: 61300301 ======");
        int i = this.f1073k.get();
        HMSLog.m2120i("HuaweiApiClientImpl", "Enter connect, Connection Status: " + i);
        if (i == 3 || i == 5 || i == 2 || i == 4) {
            return;
        }
        if (activity != null) {
            this.f1070h = new WeakReference<>(activity);
            this.f1071i = new WeakReference<>(activity);
        }
        this.f1066d = TextUtils.isEmpty(this.f1065c) ? Util.getAppId(this.f1064b) : this.f1065c;
        int m1015e = m1015e();
        HMSLog.m2120i("HuaweiApiClientImpl", "connect minVersion:" + m1015e);
        HuaweiApiAvailability.setServicesVersionCode(m1015e);
        int isHuaweiMobileServicesAvailable = HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(this.f1064b, m1015e);
        HMSLog.m2120i("HuaweiApiClientImpl", "In connect, isHuaweiMobileServicesAvailable result: " + isHuaweiMobileServicesAvailable);
        this.f1079q = HMSPackageManager.getInstance(this.f1064b).getHmsMultiServiceVersion();
        if (isHuaweiMobileServicesAvailable == 0) {
            m1012c(5);
            if (this.f1068f == null) {
                m999a();
                return;
            }
            m1012c(2);
            m1020j();
            m1019i();
            return;
        }
        if (this.f1085w != null) {
            m1006b(isHuaweiMobileServicesAvailable);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connectForeground() {
        HMSLog.m2120i("HuaweiApiClientImpl", "====== HMSSDK version: 61300301 ======");
        int i = this.f1073k.get();
        HMSLog.m2120i("HuaweiApiClientImpl", "Enter forceConnect, Connection Status: " + i);
        if (i == 3 || i == 5 || i == 2 || i == 4) {
            return;
        }
        this.f1066d = TextUtils.isEmpty(this.f1065c) ? Util.getAppId(this.f1064b) : this.f1065c;
        m1022l();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disableLifeCycleManagement(Activity activity) {
        if (this.f1063a >= 0) {
            AutoLifecycleFragment.getInstance(activity).stopAutoManage(this.f1063a);
            return;
        }
        throw new IllegalStateException("disableLifeCycleManagement failed");
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public PendingResult<Status> discardAndReconnect() {
        return new C1033d(this, null, null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void disconnect() {
        int i = this.f1073k.get();
        HMSLog.m2120i("HuaweiApiClientImpl", "Enter disconnect, Connection Status: " + i);
        if (i == 2) {
            m1012c(4);
            return;
        }
        if (i == 3) {
            m1012c(4);
            m1021k();
        } else {
            if (i != 5) {
                return;
            }
            m1000a(2);
            m1012c(4);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Map<Api<?>, Api.ApiOptions> getApiMap() {
        return this.f1076n;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        ArrayList arrayList = new ArrayList();
        Map<Api<?>, Api.ApiOptions> map = this.f1076n;
        if (map != null) {
            Iterator<Api<?>> it = map.keySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getApiName());
            }
        }
        return arrayList;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f1066d;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        if (isConnected()) {
            this.f1083u = null;
            return new ConnectionResult(0, (PendingIntent) null);
        }
        ConnectionResult connectionResult = this.f1083u;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.f1064b;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f1067e;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.f1064b.getPackageName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<PermissionInfo> getPermissionInfos() {
        return this.f1075m;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public List<Scope> getScopes() {
        return this.f1074l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f1068f;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.f1069g;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public final SubAppInfo getSubAppInfo() {
        return this.f1077o;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public Activity getTopActivity() {
        WeakReference<Activity> weakReference = this.f1071i;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectedApi(Api<?> api) {
        return isConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f1080r) {
            return this.f1085w == onConnectionFailedListener;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean hasConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f1080r) {
            return this.f1084v == connectionCallbacks;
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f1081s.lock();
            try {
                connect((Activity) null);
                while (isConnecting()) {
                    this.f1082t.await();
                }
                if (isConnected()) {
                    this.f1083u = null;
                    return new ConnectionResult(0, (PendingIntent) null);
                }
                ConnectionResult connectionResult = this.f1083u;
                return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            } finally {
                this.f1081s.unlock();
            }
        }
        throw new IllegalStateException("blockingConnect must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerApiClient
    public boolean innerIsConnected() {
        return this.f1073k.get() == 3 || this.f1073k.get() == 4;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient, com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        if (this.f1079q == 0) {
            this.f1079q = HMSPackageManager.getInstance(this.f1064b).getHmsMultiServiceVersion();
        }
        if (this.f1079q < 20504000) {
            long currentTimeMillis = System.currentTimeMillis() - this.f1078p;
            if (currentTimeMillis > 0 && currentTimeMillis < 300000) {
                return innerIsConnected();
            }
            if (!innerIsConnected()) {
                return false;
            }
            Status status = ConnectService.checkconnect(this, new CheckConnectInfo()).awaitOnAnyThread(2000L, TimeUnit.MILLISECONDS).getStatus();
            if (status.isSuccess()) {
                this.f1078p = System.currentTimeMillis();
                return true;
            }
            int statusCode = status.getStatusCode();
            HMSLog.m2120i("HuaweiApiClientImpl", "isConnected is false, statuscode:" + statusCode);
            if (statusCode == 907135004) {
                return false;
            }
            m1024n();
            m1012c(1);
            this.f1078p = System.currentTimeMillis();
            return false;
        }
        return innerIsConnected();
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean isConnecting() {
        int i = this.f1073k.get();
        return i == 2 || i == 5;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onPause(Activity activity) {
        HMSLog.m2120i("HuaweiApiClientImpl", WebViewContainer.EVENT_onPause);
    }

    public void onResult(int i) {
        this.f1088z.onResult(i);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void onResume(Activity activity) {
        if (activity != null) {
            HMSLog.m2120i("HuaweiApiClientImpl", WebViewContainer.EVENT_onResume);
            this.f1071i = new WeakReference<>(activity);
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HMSLog.m2120i("HuaweiApiClientImpl", "HuaweiApiClientImpl Enter onServiceConnected.");
        m1000a(2);
        this.f1068f = IAIDLInvoke.Stub.asInterface(iBinder);
        if (this.f1068f == null) {
            HMSLog.m2118e("HuaweiApiClientImpl", "In onServiceConnected, mCoreService must not be null.");
            m1024n();
            m1012c(1);
            if (this.f1085w != null) {
                WeakReference<Activity> weakReference = this.f1070h;
                ConnectionResult connectionResult = new ConnectionResult(10, (weakReference == null || weakReference.get() == null) ? null : HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f1070h.get(), 10));
                this.f1085w.onConnectionFailed(connectionResult);
                this.f1083u = connectionResult;
                return;
            }
            return;
        }
        if (this.f1073k.get() == 5) {
            m1012c(2);
            m1020j();
            m1019i();
        } else if (this.f1073k.get() != 3) {
            m1024n();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        HMSLog.m2120i("HuaweiApiClientImpl", "Enter onServiceDisconnected.");
        this.f1068f = null;
        m1012c(1);
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f1084v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnectionSuspended(1);
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void print(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void reconnect() {
        disconnect();
        connect((Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionFailureListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Checker.checkNonNull(onConnectionFailedListener, "onConnectionFailedListener should not be null");
        synchronized (this.f1080r) {
            if (this.f1085w != onConnectionFailedListener) {
                HMSLog.m2121w("HuaweiApiClientImpl", "unregisterConnectionFailedListener: this onConnectionFailedListener has not been registered");
            } else {
                this.f1085w = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void removeConnectionSuccessListener(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        Checker.checkNonNull(connectionCallbacks, "connectionCallbacksListener should not be null");
        synchronized (this.f1080r) {
            if (this.f1084v != connectionCallbacks) {
                HMSLog.m2121w("HuaweiApiClientImpl", "unregisterConnectionCallback: this connectionCallbacksListener has not been registered");
            } else {
                this.f1084v = null;
            }
        }
    }

    public void resetListener() {
        this.f1088z = null;
    }

    public void setApiMap(Map<Api<?>, Api.ApiOptions> map) {
        this.f1076n = map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setAutoLifecycleClientId(int i) {
        this.f1063a = i;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionCallbacks(HuaweiApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f1084v = connectionCallbacks;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void setConnectionFailedListener(HuaweiApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f1085w = onConnectionFailedListener;
    }

    public void setHasShowNotice(boolean z) {
        this.f1072j = z;
    }

    public void setPermissionInfos(List<PermissionInfo> list) {
        this.f1075m = list;
    }

    public void setScopes(List<Scope> list) {
        this.f1074l = list;
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public boolean setSubAppInfo(SubAppInfo subAppInfo) {
        HMSLog.m2120i("HuaweiApiClientImpl", "Enter setSubAppInfo");
        if (subAppInfo == null) {
            HMSLog.m2118e("HuaweiApiClientImpl", "subAppInfo is null");
            return false;
        }
        String subAppID = subAppInfo.getSubAppID();
        if (TextUtils.isEmpty(subAppID)) {
            HMSLog.m2118e("HuaweiApiClientImpl", "subAppId is empty");
            return false;
        }
        if (subAppID.equals(TextUtils.isEmpty(this.f1065c) ? Util.getAppId(this.f1064b) : this.f1065c)) {
            HMSLog.m2118e("HuaweiApiClientImpl", "subAppId is host appid");
            return false;
        }
        this.f1077o = new SubAppInfo(subAppInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m1012c(int i) {
        this.f1073k.set(i);
        if (i == 1 || i == 3 || i == 2) {
            this.f1081s.lock();
            try {
                this.f1082t.signalAll();
            } finally {
                this.f1081s.unlock();
            }
        }
    }

    /* renamed from: b */
    private void m1006b(int i) {
        PendingIntent pendingIntent;
        WeakReference<Activity> weakReference = this.f1070h;
        if (weakReference == null || weakReference.get() == null) {
            pendingIntent = null;
        } else {
            pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f1070h.get(), i);
            HMSLog.m2120i("HuaweiApiClientImpl", "connect 2.0 fail: " + i);
        }
        ConnectionResult connectionResult = new ConnectionResult(i, pendingIntent);
        this.f1085w.onConnectionFailed(connectionResult);
        this.f1083u = connectionResult;
    }

    /* renamed from: a */
    private void m999a() {
        Intent intent = new Intent(HMSPackageManager.getInstance(this.f1064b).getServiceAction());
        HMSPackageManager.getInstance(this.f1064b).refreshForMultiService();
        try {
            String hMSPackageNameForMultiService = HMSPackageManager.getInstance(this.f1064b).getHMSPackageNameForMultiService();
            if (TextUtils.isEmpty(hMSPackageNameForMultiService)) {
                HMSLog.m2118e("HuaweiApiClientImpl", "servicePackageName is empty, Service is invalid, bind core service fail.");
                m1012c(1);
                m1005b();
                return;
            }
            intent.setPackage(hMSPackageNameForMultiService);
            synchronized (f1061A) {
                if (this.f1064b.bindService(intent, this, 1)) {
                    m1018h();
                    return;
                }
                m1012c(1);
                HMSLog.m2118e("HuaweiApiClientImpl", "In connect, bind core service fail");
                m1005b();
            }
        } catch (IllegalArgumentException unused) {
            HMSLog.m2118e("HuaweiApiClientImpl", "IllegalArgumentException when bindCoreService intent.setPackage");
            m1012c(1);
            HMSLog.m2118e("HuaweiApiClientImpl", "In connect, bind core service fail");
            m1005b();
        }
    }

    /* renamed from: c */
    private ConnectInfo m1010c() {
        String packageSignature = new PackageManagerHelper(this.f1064b).getPackageSignature(this.f1064b.getPackageName());
        if (packageSignature == null) {
            packageSignature = "";
        }
        SubAppInfo subAppInfo = this.f1077o;
        return new ConnectInfo(getApiNameList(), this.f1074l, packageSignature, subAppInfo == null ? null : subAppInfo.getSubAppID());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1005b() {
        m1024n();
        if (this.f1085w != null) {
            int i = UIUtil.isBackground(this.f1064b) ? 7 : 6;
            WeakReference<Activity> weakReference = this.f1070h;
            ConnectionResult connectionResult = new ConnectionResult(i, (weakReference == null || weakReference.get() == null) ? null : HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f1070h.get(), i));
            this.f1085w.onConnectionFailed(connectionResult);
            this.f1083u = connectionResult;
        }
    }

    /* renamed from: c */
    private void m1013c(ResolveResult<ConnectResp> resolveResult) {
        if (resolveResult.getValue() != null) {
            ProtocolNegotiate.getInstance().negotiate(resolveResult.getValue().protocolVersion);
        }
        m1012c(3);
        this.f1083u = null;
        HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f1084v;
        if (connectionCallbacks != null) {
            connectionCallbacks.onConnected();
        }
        if (this.f1070h != null) {
            m1023m();
        }
        for (Map.Entry<Api<?>, Api.ApiOptions> entry : getApiMap().entrySet()) {
            if (entry.getKey().getmConnetctPostList() != null && !entry.getKey().getmConnetctPostList().isEmpty()) {
                HMSLog.m2120i("HuaweiApiClientImpl", "Enter onConnectionResult, get the ConnetctPostList ");
                for (ConnectionPostProcessor connectionPostProcessor : entry.getKey().getmConnetctPostList()) {
                    HMSLog.m2120i("HuaweiApiClientImpl", "Enter onConnectionResult, processor.run");
                    connectionPostProcessor.run(this, this.f1070h);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1009b(ResolveResult<DisconnectResp> resolveResult) {
        HMSLog.m2120i("HuaweiApiClientImpl", "Enter onDisconnectionResult, disconnect from server result: " + resolveResult.getStatus().getStatusCode());
        m1024n();
        m1012c(1);
    }

    /* renamed from: a */
    private void m1000a(int i) {
        if (i == 2) {
            synchronized (f1061A) {
                Handler handler = this.f1086x;
                if (handler != null) {
                    handler.removeMessages(i);
                    this.f1086x = null;
                }
            }
        }
        if (i == 3) {
            synchronized (f1062B) {
                Handler handler2 = this.f1087y;
                if (handler2 != null) {
                    handler2.removeMessages(i);
                    this.f1087y = null;
                }
            }
        }
        synchronized (f1061A) {
            Handler handler3 = this.f1086x;
            if (handler3 != null) {
                handler3.removeMessages(2);
                this.f1086x = null;
            }
        }
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public void connect(int i) {
        connect((Activity) null);
    }

    @Override // com.huawei.hms.api.HuaweiApiClient
    public ConnectionResult holdUpConnect(long j, TimeUnit timeUnit) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.f1081s.lock();
            try {
                connect((Activity) null);
                long nanos = timeUnit.toNanos(j);
                while (isConnecting()) {
                    if (nanos <= 0) {
                        disconnect();
                        return new ConnectionResult(14, (PendingIntent) null);
                    }
                    nanos = this.f1082t.awaitNanos(nanos);
                }
                if (isConnected()) {
                    this.f1083u = null;
                    return new ConnectionResult(0, (PendingIntent) null);
                }
                ConnectionResult connectionResult = this.f1083u;
                return connectionResult != null ? connectionResult : new ConnectionResult(13, (PendingIntent) null);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            } finally {
                this.f1081s.unlock();
            }
        }
        throw new IllegalStateException("blockingConnect must not be called on the UI thread");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1003a(ResolveResult<ConnectResp> resolveResult) {
        HMSLog.m2120i("HuaweiApiClientImpl", "Enter onConnectionResult");
        if (this.f1068f != null && this.f1073k.get() == 2) {
            m1000a(3);
            ConnectResp value = resolveResult.getValue();
            if (value != null) {
                this.f1069g = value.sessionId;
            }
            SubAppInfo subAppInfo = this.f1077o;
            PendingIntent pendingIntent = null;
            String subAppID = subAppInfo == null ? null : subAppInfo.getSubAppID();
            if (!TextUtils.isEmpty(subAppID)) {
                this.f1066d = subAppID;
            }
            int statusCode = resolveResult.getStatus().getStatusCode();
            HMSLog.m2120i("HuaweiApiClientImpl", "Enter onConnectionResult, connect to server result: " + statusCode);
            if (Status.SUCCESS.equals(resolveResult.getStatus())) {
                m1013c(resolveResult);
                return;
            }
            if (resolveResult.getStatus() != null && resolveResult.getStatus().getStatusCode() == 1001) {
                m1024n();
                m1012c(1);
                HuaweiApiClient.ConnectionCallbacks connectionCallbacks = this.f1084v;
                if (connectionCallbacks != null) {
                    connectionCallbacks.onConnectionSuspended(3);
                    return;
                }
                return;
            }
            m1024n();
            m1012c(1);
            if (this.f1085w != null) {
                WeakReference<Activity> weakReference = this.f1070h;
                if (weakReference != null && weakReference.get() != null) {
                    pendingIntent = HuaweiApiAvailability.getInstance().getResolveErrorPendingIntent(this.f1070h.get(), statusCode);
                }
                ConnectionResult connectionResult = new ConnectionResult(statusCode, pendingIntent);
                this.f1085w.onConnectionFailed(connectionResult);
                this.f1083u = connectionResult;
                return;
            }
            return;
        }
        HMSLog.m2118e("HuaweiApiClientImpl", "Invalid onConnectionResult");
    }
}
