package com.bytedance.common.wschannel.server;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.SocketHandler;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.client.AbsWsClientService;
import com.bytedance.common.wschannel.utils.Utils;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class ClientMsgSender {
    private final ISender mSender;
    private final Class<? extends AbsWsClientService> mTargetServiceClass;

    /* loaded from: classes3.dex */
    public interface ISender {
        void sendMsg(Intent intent);

        void tryResendMsg();
    }

    public ClientMsgSender(Context context, Class<? extends AbsWsClientService> cls) {
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            this.mSender = new OSender(context);
        } else {
            this.mSender = new DefaultSender(context);
        }
        this.mTargetServiceClass = cls;
    }

    public void sendMsg(Intent intent) {
        this.mSender.sendMsg(intent);
    }

    public void tryResendMsg() {
        this.mSender.tryResendMsg();
    }

    /* loaded from: classes3.dex */
    private class DefaultSender implements ISender {
        private final Context mContext;

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void tryResendMsg() {
        }

        DefaultSender(Context context) {
            this.mContext = context;
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void sendMsg(Intent intent) {
            try {
                intent.setComponent(new ComponentName(this.mContext, (Class<?>) ClientMsgSender.this.mTargetServiceClass));
                this.mContext.startService(intent);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class OSender implements ISender {
        private final Context mContext;
        private Messenger service;
        private ServiceConnection serviceConnection;
        private final LinkedBlockingDeque<Intent> mServiceHolderQueue = new LinkedBlockingDeque<>();
        private boolean mBinding = false;
        private final Object mLock = new Object();
        private final Runnable mBindServiceTimeoutRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.server.ClientMsgSender.OSender.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (OSender.this.mLock) {
                    Logger.d("WsChannelSdk", "mBindServiceTimeoutRunnable run");
                    if (OSender.this.mBinding) {
                        OSender.this.mBinding = false;
                    }
                }
            }
        };
        private final Runnable mDisconnectRunnable = new Runnable() { // from class: com.bytedance.common.wschannel.server.ClientMsgSender.OSender.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (OSender.this.mLock) {
                    try {
                        if (OSender.this.serviceConnection != null && Utils.isServiceRunning(OSender.this.mContext, ClientMsgSender.this.mTargetServiceClass)) {
                            OSender.this.mContext.unbindService(OSender.this.serviceConnection);
                        }
                    } finally {
                        OSender.this.serviceConnection = null;
                        OSender.this.service = null;
                        Logger.d("WsChannelSdk", "mDisconnectRunnable timeout");
                    }
                    OSender.this.serviceConnection = null;
                    OSender.this.service = null;
                    Logger.d("WsChannelSdk", "mDisconnectRunnable timeout");
                }
            }
        };
        final AtomicInteger mMsgCount = new AtomicInteger(0);

        OSender(Context context) {
            this.mContext = context;
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void sendMsg(Intent intent) {
            if (intent == null) {
                return;
            }
            if (Logger.debug()) {
                intent.putExtra(WsConstants.MSG_COUNT, this.mMsgCount.addAndGet(1));
            }
            synchronized (this.mLock) {
                removeTimeout();
                this.mServiceHolderQueue.offer(intent);
                if (this.service == null) {
                    if (this.mBinding) {
                    } else {
                        doBindService();
                    }
                } else {
                    onServiceConnected();
                }
            }
        }

        @Override // com.bytedance.common.wschannel.server.ClientMsgSender.ISender
        public void tryResendMsg() {
            if (this.mServiceHolderQueue.size() <= 0 || this.service != null) {
                return;
            }
            Logger.d("WsChannelSdk", "tryResendMsg try reconnect");
            synchronized (this.mLock) {
                if (this.mServiceHolderQueue.size() > 0 && this.service == null) {
                    doBindService();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onServiceConnected() {
            while (this.mServiceHolderQueue.peek() != null) {
                try {
                    Intent poll = this.mServiceHolderQueue.poll();
                    if (poll == null) {
                        return;
                    }
                    try {
                        try {
                            send(poll);
                        } catch (DeadObjectException unused) {
                            Logger.d("WsChannelSdk", "onServiceConnected DeadObjectException");
                            this.service = null;
                            this.mServiceHolderQueue.offerFirst(poll);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                    return;
                }
            }
            sendTimeout();
        }

        private void send(Intent intent) throws RemoteException {
            if (intent == null) {
                return;
            }
            if (Logger.debug()) {
                Logger.d("WsChannelSdk", "sendMsg msg = " + intent);
            }
            Messenger messenger = this.service;
            Message message = new Message();
            message.what = 10123;
            message.getData().putParcelable(WsConstants.DATA_INTENT, intent);
            if (messenger == null) {
                return;
            }
            messenger.send(message);
        }

        private void doBindService() {
            if (Logger.debug()) {
                Logger.d("WsChannelSdk", "doBindService");
            }
            try {
                this.mContext.startService(new Intent(this.mContext, (Class<?>) ClientMsgSender.this.mTargetServiceClass));
            } catch (Throwable unused) {
            }
            try {
                this.serviceConnection = new MessengerServiceConnection();
                this.mContext.bindService(new Intent(this.mContext, (Class<?>) ClientMsgSender.this.mTargetServiceClass), this.serviceConnection, 1);
                sendBindServiceTimeout();
                this.mBinding = true;
                Logger.d("WsChannelSdk", "doBindService, set mBinding = true");
            } catch (Throwable th) {
                removeSendBindServiceTimeout();
                this.mBinding = false;
                Logger.d("WsChannelSdk", "doBindService error, set Unbind = false");
                th.printStackTrace();
            }
        }

        private void sendBindServiceTimeout() {
            removeSendBindServiceTimeout();
            SocketHandler.inst().getHandler().postDelayed(this.mBindServiceTimeoutRunnable, TimeUnit.SECONDS.toMillis(7L));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeSendBindServiceTimeout() {
            SocketHandler.inst().getHandler().removeCallbacks(this.mBindServiceTimeoutRunnable);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes3.dex */
        public class MessengerServiceConnection implements ServiceConnection {
            private MessengerServiceConnection() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                if (Logger.debug()) {
                    Logger.d("WsChannelSdk", "onServiceDisconnected name = " + componentName.toString());
                }
                synchronized (OSender.this.mLock) {
                    if (componentName == null) {
                        return;
                    }
                    Logger.d("WsChannelSdk", "onServiceDisconnected set service = null");
                    OSender.this.service = null;
                    OSender.this.serviceConnection = null;
                    Logger.d("WsChannelSdk", "onServiceDisconnected, set Unbind = false");
                    OSender.this.mBinding = false;
                    OSender.this.removeTimeout();
                    OSender.this.removeSendBindServiceTimeout();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (Logger.debug()) {
                    Logger.d("WsChannelSdk", "onServiceConnected name = " + componentName.toString());
                }
                synchronized (OSender.this.mLock) {
                    OSender.this.removeSendBindServiceTimeout();
                    if (componentName == null || iBinder == null) {
                        return;
                    }
                    try {
                        OSender.this.service = new Messenger(iBinder);
                        Logger.d("WsChannelSdk", "onServiceConnected set service");
                        OSender.this.onServiceConnected();
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    Logger.d("WsChannelSdk", "onServiceConnected, set Unbind = false");
                    OSender.this.mBinding = false;
                }
            }
        }

        private synchronized void sendTimeout() {
            removeTimeout();
            SocketHandler.inst().getHandler().postDelayed(this.mDisconnectRunnable, TimeUnit.SECONDS.toMillis(10L));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeTimeout() {
            try {
                SocketHandler.inst().getHandler().removeCallbacks(this.mDisconnectRunnable);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
