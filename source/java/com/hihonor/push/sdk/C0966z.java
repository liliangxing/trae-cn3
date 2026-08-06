package com.hihonor.push.sdk;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.mcssdk.constant.C0878a;
import com.hihonor.push.framework.aidl.DataBuffer;
import com.hihonor.push.framework.aidl.IMessageEntity;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.framework.aidl.MessageCodec;
import com.hihonor.push.framework.aidl.entity.RequestHeader;
import com.hihonor.push.sdk.InterfaceC0910b0;
import com.hihonor.push.sdk.bean.RemoteServiceBean;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.hihonor.push.sdk.z */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0966z implements Handler.Callback {

    /* renamed from: c */
    public static final C0966z f792c = new C0966z();

    /* renamed from: a */
    public final Handler f793a;

    /* renamed from: b */
    public final Map<C0960w, a> f794b = new ConcurrentHashMap(5, 0.75f, 1);

    /* renamed from: com.hihonor.push.sdk.z$b */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class b implements InterfaceC0932i0 {

        /* renamed from: a */
        public AbstractC0924f1<?> f801a;

        public b(AbstractC0924f1<?> abstractC0924f1) {
            this.f801a = abstractC0924f1;
        }
    }

    public C0966z() {
        HandlerThread handlerThread = new HandlerThread("HonorApiManager");
        handlerThread.start();
        this.f793a = new Handler(handlerThread.getLooper(), this);
    }

    /* renamed from: a */
    public <TResult> C0908a1<TResult> m783a(AbstractC0924f1<TResult> abstractC0924f1) {
        C0943n0<TResult> c0943n0 = new C0943n0<>();
        abstractC0924f1.f711a = c0943n0;
        Log.i("HonorApiManager", "sendRequest start");
        Handler handler = this.f793a;
        handler.sendMessage(handler.obtainMessage(1, abstractC0924f1));
        return c0943n0.f745a;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        a aVar;
        int i = message.what;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            AbstractC0924f1 abstractC0924f1 = (AbstractC0924f1) message.obj;
            C0960w c0960w = abstractC0924f1.f714d;
            if (c0960w != null && this.f794b.containsKey(c0960w) && (aVar = this.f794b.get(c0960w)) != null) {
                synchronized (aVar) {
                    String str = "resolveResult apiCall " + abstractC0924f1.f712b;
                    aVar.f796b.remove(abstractC0924f1);
                    if (aVar.f795a.peek() == null || aVar.f796b.peek() == null) {
                        aVar.m784a();
                        C0966z.this.f794b.remove(aVar.f799e);
                    }
                }
            }
            return true;
        }
        AbstractC0924f1<?> abstractC0924f12 = (AbstractC0924f1) message.obj;
        C0960w c0960w2 = abstractC0924f12.f714d;
        a aVar2 = this.f794b.get(c0960w2);
        if (aVar2 == null) {
            Log.i("HonorApiManager", "connect and send request, create new connection manager.");
            aVar2 = new a(c0960w2);
            this.f794b.put(c0960w2, aVar2);
        }
        synchronized (aVar2) {
            C0909b.m746a(C0966z.this.f793a);
            String str2 = "sendRequest " + abstractC0924f12.f712b;
            if (((C0917d0) aVar2.f797c).m763a()) {
                aVar2.m785a(abstractC0924f12);
            } else {
                aVar2.f795a.add(abstractC0924f12);
                HonorPushErrorEnum honorPushErrorEnum = aVar2.f798d;
                if (honorPushErrorEnum != null && honorPushErrorEnum.getErrorCode() != 0) {
                    aVar2.m786a(aVar2.f798d);
                } else {
                    synchronized (aVar2) {
                        C0909b.m746a(C0966z.this.f793a);
                        if (((C0917d0) aVar2.f797c).m763a()) {
                            Log.i("HonorApiManager", "client is connected");
                        } else {
                            if (((C0917d0) aVar2.f797c).f696a.get() == 5) {
                                Log.i("HonorApiManager", "client is isConnecting");
                            } else {
                                C0917d0 c0917d0 = (C0917d0) aVar2.f797c;
                                c0917d0.getClass();
                                Log.i("PushConnectionClient", " ==== PUSHSDK VERSION 70061303 ====");
                                int i2 = c0917d0.f696a.get();
                                Log.i("PushConnectionClient", "enter connect, connection Status: " + i2);
                                if (i2 != 3 && i2 != 5 && i2 != 4) {
                                    C0937l c0937l = C0937l.f734e;
                                    int m751b = C0909b.m751b(c0937l.m773a());
                                    if (m751b == HonorPushErrorEnum.SUCCESS.getErrorCode()) {
                                        c0917d0.f696a.set(5);
                                        RemoteServiceBean m741a = C0909b.m741a(c0937l.m773a());
                                        Log.i("PushConnectionClient", "enter bindCoreService.");
                                        ServiceConnectionC0923f0 serviceConnectionC0923f0 = new ServiceConnectionC0923f0(m741a);
                                        c0917d0.f699d = serviceConnectionC0923f0;
                                        serviceConnectionC0923f0.f708b = new C0913c0(c0917d0);
                                        if (!m741a.checkServiceInfo()) {
                                            String str3 = "bind core is null : " + serviceConnectionC0923f0.f707a;
                                            serviceConnectionC0923f0.m765a(8002004);
                                        } else {
                                            Intent intent = new Intent();
                                            String packageName = serviceConnectionC0923f0.f707a.getPackageName();
                                            String packageAction = serviceConnectionC0923f0.f707a.getPackageAction();
                                            String packageServiceName = serviceConnectionC0923f0.f707a.getPackageServiceName();
                                            if (!TextUtils.isEmpty(packageServiceName)) {
                                                intent.setComponent(new ComponentName(packageName, packageServiceName));
                                            } else {
                                                intent.setAction(packageAction);
                                                intent.setPackage(packageName);
                                            }
                                            synchronized (ServiceConnectionC0923f0.f706e) {
                                                if (c0937l.m773a().bindService(intent, serviceConnectionC0923f0, 1)) {
                                                    Handler handler = serviceConnectionC0923f0.f709c;
                                                    if (handler != null) {
                                                        handler.removeMessages(1001);
                                                    } else {
                                                        serviceConnectionC0923f0.f709c = new Handler(Looper.getMainLooper(), new C0920e0(serviceConnectionC0923f0));
                                                    }
                                                    serviceConnectionC0923f0.f709c.sendEmptyMessageDelayed(1001, C0878a.f531q);
                                                } else {
                                                    serviceConnectionC0923f0.f710d = true;
                                                    serviceConnectionC0923f0.m765a(8002001);
                                                }
                                            }
                                        }
                                    } else {
                                        c0917d0.m762a(m751b);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    /* renamed from: com.hihonor.push.sdk.z$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public class a implements InterfaceC0910b0.a {

        /* renamed from: a */
        public final Queue<AbstractC0924f1<?>> f795a = new LinkedList();

        /* renamed from: b */
        public final Queue<AbstractC0924f1<?>> f796b = new LinkedList();

        /* renamed from: c */
        public final InterfaceC0910b0 f797c = new C0917d0(this);

        /* renamed from: d */
        public HonorPushErrorEnum f798d = null;

        /* renamed from: e */
        public final C0960w f799e;

        public a(C0960w c0960w) {
            this.f799e = c0960w;
        }

        /* renamed from: a */
        public final synchronized void m786a(HonorPushErrorEnum honorPushErrorEnum) {
            Log.i("HonorApiManager", "onConnectionFailed");
            C0909b.m746a(C0966z.this.f793a);
            Iterator<AbstractC0924f1<?>> it = this.f795a.iterator();
            while (it.hasNext()) {
                it.next().m767b(honorPushErrorEnum.toApiException(), null);
            }
            this.f795a.clear();
            this.f798d = honorPushErrorEnum;
            m784a();
            C0966z.this.f794b.remove(this.f799e);
        }

        /* renamed from: b */
        public final synchronized void m787b() {
            Log.i("HonorApiManager", "onConnected");
            C0909b.m746a(C0966z.this.f793a);
            this.f798d = null;
            Iterator<AbstractC0924f1<?>> it = this.f795a.iterator();
            while (it.hasNext()) {
                m785a(it.next());
            }
            this.f795a.clear();
        }

        /* renamed from: a */
        public final synchronized void m785a(AbstractC0924f1<?> abstractC0924f1) {
            Type type;
            this.f796b.add(abstractC0924f1);
            InterfaceC0910b0 interfaceC0910b0 = this.f797c;
            b bVar = new b(abstractC0924f1);
            abstractC0924f1.getClass();
            Object obj = null;
            try {
                Type genericSuperclass = abstractC0924f1.getClass().getGenericSuperclass();
                Class cls = (genericSuperclass == null || (type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]) == null) ? null : (Class) type;
                if (cls != null && !cls.isPrimitive()) {
                    obj = cls.newInstance();
                }
            } catch (Exception e) {
                C0912c.m756a("In newResponseInstance, instancing exception." + e.getMessage());
            }
            BinderC0929h0 binderC0929h0 = new BinderC0929h0(obj, bVar);
            Log.i("IpcTransport", "start transport parse. " + abstractC0924f1.f712b);
            IPushInvoke iPushInvoke = ((C0917d0) interfaceC0910b0).f697b;
            String str = abstractC0924f1.f712b;
            RequestHeader requestHeader = abstractC0924f1.f715e;
            IMessageEntity iMessageEntity = abstractC0924f1.f713c;
            Bundle bundle = new Bundle();
            Bundle bundle2 = new Bundle();
            MessageCodec.formMessageEntity(requestHeader, bundle);
            MessageCodec.formMessageEntity(iMessageEntity, bundle2);
            DataBuffer dataBuffer = new DataBuffer(str, bundle, bundle2);
            if (iPushInvoke != null) {
                try {
                    iPushInvoke.call(dataBuffer, binderC0929h0);
                } catch (Exception e2) {
                    String str2 = "transport remote error. " + e2;
                }
            }
            Log.i("IpcTransport", "end transport parse.");
        }

        /* renamed from: a */
        public void m784a() {
            C0909b.m746a(C0966z.this.f793a);
            C0917d0 c0917d0 = (C0917d0) this.f797c;
            int i = c0917d0.f696a.get();
            Log.i("PushConnectionClient", "enter disconnect, connection Status: " + i);
            if (i != 3) {
                if (i != 5) {
                    return;
                }
                c0917d0.f696a.set(4);
            } else {
                ServiceConnectionC0923f0 serviceConnectionC0923f0 = c0917d0.f699d;
                if (serviceConnectionC0923f0 != null) {
                    serviceConnectionC0923f0.m766b();
                }
                c0917d0.f696a.set(1);
            }
        }
    }
}
