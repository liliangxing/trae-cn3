package com.bytedance.common.wschannel.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.bytedance.common.wschannel.SocketHandler;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.app.IWsApp;
import com.bytedance.common.wschannel.app.OnBindWsChannelServiceListener;
import com.bytedance.common.wschannel.client.WsChannelApi;
import com.bytedance.common.wschannel.model.IntegerParcelable;
import com.bytedance.common.wschannel.model.ServiceParcelable;
import com.bytedance.common.wschannel.model.SsWsApp;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.common.wschannel.server.WsChannelService;
import java.lang.ref.WeakReference;
import java.util.concurrent.LinkedBlockingDeque;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class WsChannelMultiProcessImpl implements WsChannelApi {
    private static final int CHECK_CONNECTION_TIMEOUT = 10000;
    private static boolean mAsync;
    private WeakReference<Context> sContextRef;
    Messenger service;
    ServiceConnection serviceConnection;
    private final Runnable checkConnectionRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.client.WsChannelMultiProcessImpl.1
        @Override // java.lang.Runnable
        public void run() {
            if (WsChannelMultiProcessImpl.this.service == null) {
                WsChannelMultiProcessImpl.this.onReportServiceConnect(1, SystemClock.uptimeMillis() - WsChannelMultiProcessImpl.this.bindServiceStartTime);
            }
        }
    };
    private long bindServiceStartTime = 0;
    private long bindServiceConnectedTime = 0;
    private final LinkedBlockingDeque<WsChannelApi.ServiceHolder> mServiceHolderQueue = new LinkedBlockingDeque<>();

    public static void setAsyncOpt(boolean z) {
        mAsync = z;
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void tryStartPushProcess(Context context, boolean z) {
        tryStartPushProcess(context, z, false);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void tryStartPushProcess(final Context context, boolean z, boolean z2) {
        if (z) {
            startPushProcess(context, z2);
        } else {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.common.wschannel.client.WsChannelMultiProcessImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        context.startService(new Intent(context, (Class<?>) WsChannelService.class));
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private void startPushProcess(final Context context, final boolean z) {
        ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.common.wschannel.client.WsChannelMultiProcessImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (context == null) {
                    return;
                }
                if (WsChannelMultiProcessImpl.this.sContextRef == null || WsChannelMultiProcessImpl.this.sContextRef.get() == null) {
                    WsChannelMultiProcessImpl.this.sContextRef = new WeakReference(context.getApplicationContext());
                }
                try {
                    ComponentName componentName = new ComponentName(context, (Class<?>) WsChannelService.class);
                    WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
                    serviceHolder.what = z ? 9 : 11;
                    WsChannelMultiProcessImpl.this.mServiceHolderQueue.offer(serviceHolder);
                    WsChannelMultiProcessImpl.this.bindOrSendMsg(componentName);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void bindOrSendMsg(ComponentName componentName) {
        if (this.service == null) {
            doBindService(componentName);
        } else {
            onServiceConnected(componentName);
        }
    }

    private void sendMsg(ComponentName componentName, Message message) throws RemoteException {
        if (componentName == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "sendMsg msg = " + message.toString() + " , + what = " + message.what);
        }
        Messenger messenger = this.service;
        if (messenger == null) {
            return;
        }
        messenger.send(message);
    }

    private void doBindService(ComponentName componentName) {
        WeakReference<Context> weakReference = this.sContextRef;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        Context context = weakReference.get();
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "doBindService");
        }
        if (componentName == null) {
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setComponent(componentName);
            context.startService(intent);
        } catch (Throwable unused) {
        }
        try {
            Intent intent2 = new Intent();
            intent2.setComponent(componentName);
            MessengerServiceConnection messengerServiceConnection = new MessengerServiceConnection();
            this.serviceConnection = messengerServiceConnection;
            startConnectCheckTimeout();
            context.bindService(intent2, messengerServiceConnection, 1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void startConnectCheckTimeout() {
        this.bindServiceStartTime = SystemClock.uptimeMillis();
        if (WsConstants.getBindWsChannelServiceListener() == null) {
            return;
        }
        SocketHandler.inst().getHandler().postDelayed(this.checkConnectionRunnable, GWorker.INTERVAL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onReportServiceConnect(int i, long j) {
        OnBindWsChannelServiceListener bindWsChannelServiceListener = WsConstants.getBindWsChannelServiceListener();
        if (bindWsChannelServiceListener == null) {
            return;
        }
        bindWsChannelServiceListener.onBindServiceResult(i, j);
    }

    private JSONObject getExtra(long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("total_duration", j);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class MessengerServiceConnection implements ServiceConnection {
        MessengerServiceConnection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (componentName == null) {
                return;
            }
            if (Logger.debug()) {
                Logger.m190d("WsChannelSdk", "onServiceDisconnected name = " + componentName.toString());
            }
            try {
                WsChannelMultiProcessImpl.this.service = null;
                WsChannelMultiProcessImpl.this.mServiceHolderQueue.clear();
                WsChannelMultiProcessImpl.this.onServiceDisconnected(componentName);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            WsChannelMultiProcessImpl.this.onReportServiceConnect(2, SystemClock.uptimeMillis() - WsChannelMultiProcessImpl.this.bindServiceConnectedTime);
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(final ComponentName componentName, IBinder iBinder) {
            if (componentName == null || iBinder == null) {
                return;
            }
            if (Logger.debug()) {
                Logger.m190d("WsChannelSdk", "onServiceConnected name = " + componentName.toString() + ", " + WsChannelMultiProcessImpl.mAsync);
            }
            try {
                WsChannelMultiProcessImpl.this.service = new Messenger(iBinder);
                if (!WsChannelMultiProcessImpl.mAsync) {
                    WsChannelMultiProcessImpl.this.bindOrSendMsg(componentName);
                } else {
                    ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.common.wschannel.client.WsChannelMultiProcessImpl.MessengerServiceConnection.1
                        @Override // java.lang.Runnable
                        public void run() {
                            WsChannelMultiProcessImpl.this.bindOrSendMsg(componentName);
                        }
                    });
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            WsChannelMultiProcessImpl.this.bindServiceConnectedTime = SystemClock.uptimeMillis();
            WsChannelMultiProcessImpl.this.onReportServiceConnect(0, SystemClock.uptimeMillis() - WsChannelMultiProcessImpl.this.bindServiceStartTime);
        }
    }

    private void onServiceConnected(ComponentName componentName) {
        WsChannelApi.ServiceHolder poll;
        if (componentName == null) {
            return;
        }
        while (this.mServiceHolderQueue.peek() != null && (poll = this.mServiceHolderQueue.poll()) != null) {
            try {
                Message message = new Message();
                message.what = poll.what;
                message.getData().putParcelable(poll.key, poll.obj);
                try {
                    try {
                        sendMsg(componentName, message);
                    } catch (DeadObjectException unused) {
                        this.service = null;
                        this.mServiceHolderQueue.offerFirst(poll);
                        onReportServiceConnect(3, SystemClock.uptimeMillis() - this.bindServiceConnectedTime);
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            } catch (Throwable unused2) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onServiceDisconnected(ComponentName componentName) {
    }

    private void register(Context context, IWsApp iWsApp) {
        if (context == null || iWsApp == null) {
            return;
        }
        WeakReference<Context> weakReference = this.sContextRef;
        if (weakReference == null || weakReference.get() == null) {
            this.sContextRef = new WeakReference<>(context.getApplicationContext());
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "register wsApp = " + iWsApp.toString());
        }
        if (WsChannelSettings.inst(context).isEnable()) {
            try {
                ComponentName componentName = new ComponentName(context, (Class<?>) WsChannelService.class);
                WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
                serviceHolder.key = WsConstants.KEY_WS_APP;
                serviceHolder.obj = iWsApp;
                serviceHolder.what = 0;
                this.mServiceHolderQueue.offer(serviceHolder);
                bindOrSendMsg(componentName);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void unregister(Context context, int i) {
        if (context == null) {
            return;
        }
        WeakReference<Context> weakReference = this.sContextRef;
        if (weakReference == null || weakReference.get() == null) {
            this.sContextRef = new WeakReference<>(context.getApplicationContext());
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "unregister channelId = " + i);
        }
        try {
            ComponentName componentName = new ComponentName(context, (Class<?>) WsChannelService.class);
            WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
            serviceHolder.key = WsConstants.KEY_WS_APP;
            serviceHolder.obj = new IntegerParcelable(i);
            serviceHolder.what = 1;
            this.mServiceHolderQueue.offer(serviceHolder);
            bindOrSendMsg(componentName);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void sendParameterChange(Context context, IWsApp iWsApp) {
        if (context == null || iWsApp == null) {
            return;
        }
        WeakReference<Context> weakReference = this.sContextRef;
        if (weakReference == null || weakReference.get() == null) {
            this.sContextRef = new WeakReference<>(context.getApplicationContext());
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "sendParameterChange wsApp = " + iWsApp.toString());
        }
        if (WsChannelSettings.inst(context).isEnable()) {
            try {
                ComponentName componentName = new ComponentName(context, (Class<?>) WsChannelService.class);
                WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
                serviceHolder.key = WsConstants.KEY_WS_APP;
                serviceHolder.obj = iWsApp;
                serviceHolder.what = 4;
                this.mServiceHolderQueue.offer(serviceHolder);
                bindOrSendMsg(componentName);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void sendPayload(Context context, WsChannelMsg wsChannelMsg) {
        if (context == null || wsChannelMsg == null) {
            return;
        }
        WeakReference<Context> weakReference = this.sContextRef;
        if (weakReference == null || weakReference.get() == null) {
            this.sContextRef = new WeakReference<>(context.getApplicationContext());
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "sendPayload wsChannelMsg = " + wsChannelMsg.toString());
        }
        if (WsChannelSettings.inst(context).isEnable()) {
            try {
                ComponentName componentName = new ComponentName(context, (Class<?>) WsChannelService.class);
                WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
                serviceHolder.key = WsConstants.KEY_PAYLOAD;
                serviceHolder.obj = wsChannelMsg;
                serviceHolder.what = 5;
                this.mServiceHolderQueue.offer(serviceHolder);
                bindOrSendMsg(componentName);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void sendAppState(final Context context, final int i) {
        if (context == null || i <= 0 || i > 3) {
            return;
        }
        WeakReference<Context> weakReference = this.sContextRef;
        if (weakReference == null || weakReference.get() == null) {
            this.sContextRef = new WeakReference<>(context.getApplicationContext());
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "sendAppState appState = " + i);
        }
        if (WsChannelSettings.inst(context).isEnable()) {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.common.wschannel.client.WsChannelMultiProcessImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ComponentName componentName = new ComponentName(context, (Class<?>) WsChannelService.class);
                        Intent intent = new Intent(WsConstants.APP_STATE_ACTION);
                        intent.setComponent(componentName);
                        intent.putExtra(WsConstants.KEY_APP_STATE, i);
                        context.startService(intent);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void registerApp(Context context, SsWsApp ssWsApp) {
        if (context == null) {
            return;
        }
        WeakReference<Context> weakReference = this.sContextRef;
        if (weakReference == null || weakReference.get() == null) {
            this.sContextRef = new WeakReference<>(context.getApplicationContext());
        }
        if (WsChannelSettings.inst(context).isEnable() && ssWsApp != null) {
            register(context, ssWsApp);
        }
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void unRegisterApp(Context context, int i) {
        if (context == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "unRegisterApp");
        }
        unregister(context, i);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onParameterChange(Context context, SsWsApp ssWsApp) {
        if (context == null || ssWsApp == null) {
            return;
        }
        WeakReference<Context> weakReference = this.sContextRef;
        if (weakReference == null || weakReference.get() == null) {
            this.sContextRef = new WeakReference<>(context.getApplicationContext());
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "onParameterChange" + ssWsApp.toString());
        }
        if (WsChannelSettings.inst(context).isEnable()) {
            sendParameterChange(context, ssWsApp);
        }
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onEnterToForeground(Context context) {
        sendAppState(context, 1);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onEnterToBackground(Context context) {
        sendAppState(context, 2);
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void onTrimMemory(final Context context, final int i) {
        if (context == null) {
            return;
        }
        WeakReference<Context> weakReference = this.sContextRef;
        if (weakReference == null || weakReference.get() == null) {
            this.sContextRef = new WeakReference<>(context.getApplicationContext());
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "onTrimMemory level = " + i);
        }
        if (WsChannelSettings.inst(context).isEnable()) {
            ThreadPlus.submitRunnable(new Runnable() { // from class: com.bytedance.common.wschannel.client.WsChannelMultiProcessImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ComponentName componentName = new ComponentName(context, (Class<?>) WsChannelService.class);
                        Intent intent = new Intent(WsConstants.MEM_TRIM_ACTION);
                        intent.setComponent(componentName);
                        intent.putExtra(WsConstants.KEY_MEM_TRIM, i);
                        context.startService(intent);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void registerServiceId(Context context, int i, int i2) {
        if (context == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "register serviceId = " + i2);
        }
        try {
            ComponentName componentName = new ComponentName(context, (Class<?>) WsChannelService.class);
            WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
            serviceHolder.key = WsConstants.KEY_WS_APP;
            serviceHolder.obj = new ServiceParcelable(i, i2);
            serviceHolder.what = 12;
            this.mServiceHolderQueue.offer(serviceHolder);
            bindOrSendMsg(componentName);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.bytedance.common.wschannel.client.WsChannelApi
    public void unregisterServiceId(Context context, int i, int i2) {
        if (context == null) {
            return;
        }
        if (Logger.debug()) {
            Logger.m190d("WsChannelSdk", "unregister serviceId = " + i2);
        }
        try {
            ComponentName componentName = new ComponentName(context, (Class<?>) WsChannelService.class);
            WsChannelApi.ServiceHolder serviceHolder = new WsChannelApi.ServiceHolder();
            serviceHolder.key = WsConstants.KEY_WS_APP;
            serviceHolder.obj = new ServiceParcelable(i, i2);
            serviceHolder.what = 13;
            this.mServiceHolderQueue.offer(serviceHolder);
            bindOrSendMsg(componentName);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
