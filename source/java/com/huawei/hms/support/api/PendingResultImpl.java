package com.huawei.hms.support.api;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.webx.addr.AddressParam;
import com.huawei.hms.adapter.BaseAdapter;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.AbstractMessageEntity;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.api.transport.DatagramTransport;
import com.huawei.hms.support.gentyref.GenericTypeReflector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public abstract class PendingResultImpl<R extends Result, T extends IMessageEntity> extends InnerPendingResult<R> {

    /* renamed from: a */
    private CountDownLatch f1774a;

    /* renamed from: c */
    private WeakReference<ApiClient> f1776c;
    protected DatagramTransport transport = null;

    /* renamed from: b */
    private R f1775b = null;

    /* renamed from: d */
    private String f1777d = null;

    /* renamed from: e */
    private String f1778e = null;

    /* renamed from: f */
    private boolean f1779f = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1242a implements DatagramTransport.InterfaceC1256a {
        C1242a() {
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.InterfaceC1256a
        /* renamed from: a */
        public void mo2071a(int i, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.m2067a(i, iMessageEntity);
            PendingResultImpl.this.f1774a.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1243b implements DatagramTransport.InterfaceC1256a {

        /* renamed from: a */
        final /* synthetic */ AtomicBoolean f1781a;

        C1243b(AtomicBoolean atomicBoolean) {
            this.f1781a = atomicBoolean;
        }

        @Override // com.huawei.hms.support.api.transport.DatagramTransport.InterfaceC1256a
        /* renamed from: a */
        public void mo2071a(int i, IMessageEntity iMessageEntity) {
            if (!this.f1781a.get()) {
                PendingResultImpl.this.m2067a(i, iMessageEntity);
            }
            PendingResultImpl.this.f1774a.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$c */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class C1244c implements DatagramTransport.InterfaceC1256a {

        /* renamed from: a */
        final /* synthetic */ HandlerC1245d f1783a;

        /* renamed from: b */
        final /* synthetic */ ResultCallback f1784b;

        C1244c(HandlerC1245d handlerC1245d, ResultCallback resultCallback) {
            this.f1783a = handlerC1245d;
            this.f1784b = resultCallback;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.huawei.hms.support.api.transport.DatagramTransport.InterfaceC1256a
        /* renamed from: a */
        public void mo2071a(int i, IMessageEntity iMessageEntity) {
            PendingResultImpl.this.m2067a(i, iMessageEntity);
            this.f1783a.m2072a(this.f1784b, PendingResultImpl.this.f1775b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.huawei.hms.support.api.PendingResultImpl$d */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class HandlerC1245d<R extends Result> extends Handler {
        public HandlerC1245d(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public void m2072a(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: b */
        protected void m2073b(ResultCallback<? super R> resultCallback, R r) {
            resultCallback.onResult(r);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            Pair pair = (Pair) message.obj;
            m2073b((ResultCallback) pair.first, (Result) pair.second);
        }
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity) {
        m2069a(apiClient, str, iMessageEntity, getResponseType(), 0);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        HMSLog.m2120i("PendingResultImpl", "await");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread();
        }
        HMSLog.m2118e("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread() {
        HMSLog.m2120i("PendingResultImpl", "awaitOnAnyThread");
        WeakReference<ApiClient> weakReference = this.f1776c;
        if (weakReference == null) {
            HMSLog.m2118e("PendingResultImpl", "api is null");
            m2067a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f1775b;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.m2118e("PendingResultImpl", "client invalid");
            m2067a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f1775b;
        }
        if (this.f1779f) {
            m2066a(0, 1);
        }
        this.transport.send(apiClient, new C1242a());
        try {
            this.f1774a.await();
        } catch (InterruptedException unused) {
            HMSLog.m2118e("PendingResultImpl", "await in anythread InterruptedException");
            m2067a(CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.f1775b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void cancel() {
    }

    protected boolean checkApiClient(ApiClient apiClient) {
        return true;
    }

    protected Class<T> getResponseType() {
        Type type;
        Type genericSuperclass = getClass().getGenericSuperclass();
        if (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[1]) == null) {
            return null;
        }
        return (Class) type;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public boolean isCanceled() {
        return false;
    }

    public abstract R onComplete(T t);

    protected R onError(int i) {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Type type = genericSuperclass != null ? ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0] : null;
        Class<?> type2 = type != null ? GenericTypeReflector.getType(type) : null;
        if (type2 != null) {
            try {
                R r = (R) type2.newInstance();
                this.f1775b = r;
                r.setStatus(new Status(i));
            } catch (Exception e) {
                HMSLog.m2118e("PendingResultImpl", "on Error:" + e.getMessage());
                return null;
            }
        }
        return this.f1775b;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(ResultCallback<R> resultCallback) {
        this.f1779f = !(resultCallback instanceof BaseAdapter.BaseRequestResultCallback);
        setResultCallback(Looper.getMainLooper(), resultCallback);
    }

    /* renamed from: a */
    private void m2069a(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls, int i) {
        HMSLog.m2120i("PendingResultImpl", "init uri:" + str);
        this.f1777d = str;
        if (apiClient == null) {
            HMSLog.m2118e("PendingResultImpl", "client is null");
            return;
        }
        this.f1776c = new WeakReference<>(apiClient);
        this.f1774a = new CountDownLatch(1);
        try {
            this.transport = (DatagramTransport) Class.forName(apiClient.getTransportName()).getConstructor(String.class, IMessageEntity.class, Class.class, Integer.TYPE).newInstance(str, iMessageEntity, cls, Integer.valueOf(i));
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            HMSLog.m2118e("PendingResultImpl", "gen transport error:" + e.getMessage());
            throw new IllegalStateException("Instancing transport exception, " + e.getMessage(), e);
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        HMSLog.m2120i("PendingResultImpl", "setResultCallback");
        if (looper == null) {
            looper = Looper.myLooper();
        }
        HandlerC1245d handlerC1245d = new HandlerC1245d(looper);
        WeakReference<ApiClient> weakReference = this.f1776c;
        if (weakReference == null) {
            HMSLog.m2118e("PendingResultImpl", "api is null");
            m2067a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.m2118e("PendingResultImpl", "client is invalid");
            m2067a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            handlerC1245d.m2072a(resultCallback, this.f1775b);
        } else {
            if (this.f1779f) {
                m2066a(0, 1);
            }
            this.transport.post(apiClient, new C1244c(handlerC1245d, resultCallback));
        }
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public R await(long j, TimeUnit timeUnit) {
        HMSLog.m2120i("PendingResultImpl", "await timeout:" + j + " unit:" + timeUnit.toString());
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return awaitOnAnyThread(j, timeUnit);
        }
        HMSLog.m2120i("PendingResultImpl", "await in main thread");
        throw new IllegalStateException("await must not be called on the UI thread");
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    @Deprecated
    public void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m2067a(int i, IMessageEntity iMessageEntity) {
        Status status;
        HMSLog.m2120i("PendingResultImpl", "setResult:" + i);
        Status commonStatus = iMessageEntity instanceof AbstractMessageEntity ? ((AbstractMessageEntity) iMessageEntity).getCommonStatus() : null;
        if (i == 0) {
            this.f1775b = onComplete(iMessageEntity);
        } else {
            this.f1775b = onError(i);
        }
        if (this.f1779f) {
            m2066a(i, 2);
        }
        R r = this.f1775b;
        if (r == null || (status = r.getStatus()) == null || commonStatus == null) {
            return;
        }
        int statusCode = status.getStatusCode();
        String statusMessage = status.getStatusMessage();
        int statusCode2 = commonStatus.getStatusCode();
        String statusMessage2 = commonStatus.getStatusMessage();
        if (statusCode != statusCode2) {
            HMSLog.m2118e("PendingResultImpl", "rstStatus code (" + statusCode + ") is not equal commonStatus code (" + statusCode2 + ")");
            HMSLog.m2118e("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
        } else {
            if (!TextUtils.isEmpty(statusMessage) || TextUtils.isEmpty(statusMessage2)) {
                return;
            }
            HMSLog.m2120i("PendingResultImpl", "rstStatus msg (" + statusMessage + ") is not equal commonStatus msg (" + statusMessage2 + ")");
            this.f1775b.setStatus(new Status(statusCode, statusMessage2, status.getResolution()));
        }
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, Class<T> cls) {
        m2069a(apiClient, str, iMessageEntity, cls, 0);
    }

    @Override // com.huawei.hms.support.api.client.InnerPendingResult
    public final R awaitOnAnyThread(long j, TimeUnit timeUnit) {
        HMSLog.m2120i("PendingResultImpl", "awaitOnAnyThread timeout:" + j + " unit:" + timeUnit.toString());
        WeakReference<ApiClient> weakReference = this.f1776c;
        if (weakReference == null) {
            HMSLog.m2118e("PendingResultImpl", "api is null");
            m2067a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f1775b;
        }
        ApiClient apiClient = weakReference.get();
        if (!checkApiClient(apiClient)) {
            HMSLog.m2118e("PendingResultImpl", "client invalid");
            m2067a(CommonCode.ErrorCode.CLIENT_API_INVALID, (IMessageEntity) null);
            return this.f1775b;
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        if (this.f1779f) {
            m2066a(0, 1);
        }
        this.transport.post(apiClient, new C1243b(atomicBoolean));
        try {
            if (!this.f1774a.await(j, timeUnit)) {
                atomicBoolean.set(true);
                m2067a(CommonCode.ErrorCode.EXECUTE_TIMEOUT, (IMessageEntity) null);
            }
        } catch (InterruptedException unused) {
            HMSLog.m2118e("PendingResultImpl", "awaitOnAnyThread InterruptedException");
            m2067a(CommonCode.ErrorCode.INTERNAL_ERROR, (IMessageEntity) null);
        }
        return this.f1775b;
    }

    /* renamed from: a */
    private void m2066a(int i, int i2) {
        SubAppInfo subAppInfo;
        HMSLog.m2120i("PendingResultImpl", "biReportEvent ====== ");
        ApiClient apiClient = this.f1776c.get();
        if (apiClient != null && this.f1777d != null && !HiAnalyticsUtil.getInstance().hasError(apiClient.getContext())) {
            HashMap hashMap = new HashMap();
            hashMap.put("package", apiClient.getPackageName());
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_BASE_VERSION, "6.13.0.301");
            if (i2 == 1) {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.REQUEST);
            } else {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, HiAnalyticsConstant.Direction.RESPONSE);
                hashMap.put("result", String.valueOf(i));
                R r = this.f1775b;
                if (r != null && r.getStatus() != null) {
                    hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(this.f1775b.getStatus().getStatusCode()));
                }
            }
            hashMap.put("version", AddressParam.TYPE_DISAPPROVE);
            String appId = Util.getAppId(apiClient.getContext());
            if (TextUtils.isEmpty(appId) && (subAppInfo = apiClient.getSubAppInfo()) != null) {
                appId = subAppInfo.getSubAppID();
            }
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_APPID, appId);
            if (TextUtils.isEmpty(this.f1778e)) {
                String id = TransactionIdCreater.getId(appId, this.f1777d);
                this.f1778e = id;
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, id);
            } else {
                hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, this.f1778e);
                this.f1778e = null;
            }
            String[] split = this.f1777d.split("\\.");
            if (split.length >= 2) {
                hashMap.put("service", split[0]);
                hashMap.put("apiName", split[1]);
            }
            hashMap.put("callTime", String.valueOf(System.currentTimeMillis()));
            hashMap.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
            HiAnalyticsUtil.getInstance().onEvent(apiClient.getContext(), HiAnalyticsConstant.HMS_SDK_BASE_CALL_AIDL, hashMap);
            return;
        }
        HMSLog.m2118e("PendingResultImpl", "<biReportEvent> has some error.");
    }

    public PendingResultImpl(ApiClient apiClient, String str, IMessageEntity iMessageEntity, int i) {
        m2069a(apiClient, str, iMessageEntity, getResponseType(), i);
    }
}
