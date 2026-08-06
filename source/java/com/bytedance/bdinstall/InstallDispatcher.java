package com.bytedance.bdinstall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.content.ContextCompat;
import com.bytedance.bdinstall.BaseWorker;
import com.bytedance.bdinstall.appstate.AppStateListener;
import com.bytedance.bdinstall.callback.CallbackCenter;
import com.bytedance.bdinstall.callback.EgdiCallback;
import com.bytedance.bdinstall.callback.event.HeaderChangeEvent;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.ticket.ITicketParseResultCallback;
import com.bytedance.bdinstall.ticket.TicketInitCallback;
import com.bytedance.bdinstall.util.Constants;
import com.bytedance.bdinstall.util.NetUtils;
import com.bytedance.bdinstall.util.Singleton;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class InstallDispatcher implements Handler.Callback, EgdiCallback {
    private static final int MSG_BG_START = 1234;
    private static final int MSG_WORK_ONE = 1235;
    private static final Singleton<NetworkObserver> mObservers = new Singleton<NetworkObserver>() { // from class: com.bytedance.bdinstall.InstallDispatcher.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bytedance.bdinstall.util.Singleton
        public NetworkObserver create(Object... objArr) {
            return new NetworkObserver((Context) objArr[0]);
        }
    };
    private Activator mActivator;
    private final AppStateListener mAppStateListener;
    private CallbackCenter mCallbackCenter;
    private final InstallOptions mConfig;
    private final DeviceManager mDeviceManager;
    private Env mEnv;
    private long mFetchActiveTime;
    private GWorker mGWorker;
    private final Handler mHandler;
    private Register mRegisterWorker;
    private VerifyTicketWorker mVerifyWorker;
    private final AtomicBoolean mActive = new AtomicBoolean(false);
    private final AtomicBoolean isTicketInit = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstallDispatcher(InstallOptions installOptions, DeviceManager deviceManager, AppStateListener appStateListener, Env env) {
        this.mConfig = installOptions;
        this.mDeviceManager = deviceManager;
        this.mAppStateListener = appStateListener;
        this.mHandler = new Handler(ExecutorUtil.getLooper(installOptions.getAidString()), this);
        this.mEnv = env;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void start(boolean z) {
        register(this.mEnv, z);
        active();
    }

    public void setCallbackCenter(CallbackCenter callbackCenter) {
        this.mCallbackCenter = callbackCenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean changeEnv(Env env, boolean z) {
        if (this.mEnv.equals(env)) {
            return false;
        }
        this.mEnv = env;
        this.mDeviceManager.changeEnv(env, z);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean reStart(Env env, boolean z, boolean z2) {
        if (!changeEnv(env, z2) && !z) {
            DrLog.m140e("the env is the same with before,ignore." + env);
            return false;
        }
        this.mHandler.removeMessages(MSG_WORK_ONE);
        if (this.mHandler.hasMessages(1234)) {
            this.mHandler.removeMessages(1234);
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1234, true));
        } else {
            Register register = new Register(this.mConfig, this.mDeviceManager, env, this.mAppStateListener);
            workImmediately(register);
            this.mRegisterWorker = register;
            if (this.mConfig.isAutoActive() && this.mActive.get()) {
                activeImmediately(new Activator(this.mConfig, env));
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void activeManually() {
        DrLog.m139d("dispatcher#activeManually");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mFetchActiveTime < 900000 || !NetUtils.isNetReady(this.mConfig.getContext())) {
            return;
        }
        this.mFetchActiveTime = currentTimeMillis;
        activeImmediately(new Activator(this.mConfig, this.mEnv));
    }

    private void active() {
        if (this.mConfig.isAutoActive()) {
            final Runnable runnable = new Runnable() { // from class: com.bytedance.bdinstall.InstallDispatcher.2
                @Override // java.lang.Runnable
                public void run() {
                    if (InstallDispatcher.this.mActive.compareAndSet(false, true)) {
                        InstallDispatcher.this.activeImmediately(new Activator(InstallDispatcher.this.mConfig, InstallDispatcher.this.mEnv));
                    }
                }
            };
            this.mAppStateListener.setOnResumeListener(new AppStateListener.OnActivityResumeListener() { // from class: com.bytedance.bdinstall.InstallDispatcher.3
                @Override // com.bytedance.bdinstall.appstate.AppStateListener.OnActivityResumeListener
                public void onResume() {
                    InstallDispatcher.this.mAppStateListener.setOnResumeListener(null);
                    DrLog.m139d("dispatcher#active onResume");
                    ExecutorUtil.runOnHandlerThread(InstallDispatcher.this.mConfig.getAidString(), runnable);
                }
            });
            if (this.mConfig.isDirectActive()) {
                DrLog.m139d("dispatcher#active isActive");
                runnable.run();
            } else if (this.mAppStateListener.isActive()) {
                DrLog.m139d("dispatcher#active isActive");
                runnable.run();
            }
        }
    }

    private void register(Env env, boolean z) {
        ExecutorUtil.runOnNetExecutor(String.valueOf(this.mConfig.getAid()), new Runnable() { // from class: com.bytedance.bdinstall.InstallDispatcher.4
            @Override // java.lang.Runnable
            public void run() {
                InstallDispatcher.this.mDeviceManager.notifyBeforeRegister();
            }
        });
        if (this.mDeviceManager.load()) {
            Register register = new Register(this.mConfig, this.mDeviceManager, env, this.mAppStateListener);
            CallbackCenter callbackCenter = this.mCallbackCenter;
            if (callbackCenter != null) {
                callbackCenter.postEvent(new HeaderChangeEvent(this.mDeviceManager.getConstHeader()));
            }
            if (z || this.mDeviceManager.isUpgrade() || this.mDeviceManager.isDiffChannel() || this.mDeviceManager.isDiffAid()) {
                register.setImmediately();
            }
            if (handleTicket(register)) {
                DrLog.m139d("TicketGuard# handle ticket success");
                return;
            } else {
                workAndPostAgain(register);
                this.mRegisterWorker = register;
                return;
            }
        }
        this.mHandler.removeMessages(1234);
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(1234, Boolean.valueOf(z)), 1000L);
    }

    private boolean handleTicket(Register register) {
        if (BDInstall.getBDInstallConfig().isEnableDidGuard()) {
            if (!this.mDeviceManager.getConstHeader().has("device_id") || !this.mDeviceManager.getConstHeader().has("install_id")) {
                DrLog.m139d("TicketGuard#  sp has no did and iid, skip ticket init.");
            } else {
                try {
                    C05195 c05195 = new C05195(register);
                    if (this.isTicketInit.get()) {
                        c05195.onResult(true);
                    } else {
                        this.mDeviceManager.getTicketGuardHelper().initTicketGuard(this.mConfig, c05195);
                    }
                    return true;
                } catch (Exception e) {
                    DrLog.m141e(Constants.TAG_TICKET, e);
                    return false;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.bdinstall.InstallDispatcher$5 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public class C05195 implements TicketInitCallback {
        final /* synthetic */ Register val$register;

        C05195(Register register) {
            this.val$register = register;
        }

        @Override // com.bytedance.bdinstall.ticket.TicketInitCallback
        public void onResult(boolean z) {
            if (z) {
                InstallDispatcher.this.isTicketInit.set(true);
                InstallDispatcher.this.mDeviceManager.getTicketGuardHelper().setTicketParseResultCallback(new ITicketParseResultCallback() { // from class: com.bytedance.bdinstall.InstallDispatcher.5.1
                    @Override // com.bytedance.bdinstall.ticket.ITicketParseResultCallback
                    public void onResult(final Map<String, String> map) {
                        if (map != null) {
                            new Runnable() { // from class: com.bytedance.bdinstall.InstallDispatcher.5.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    InstallDispatcher.this.verifyImmediately(new VerifyTicketWorker(InstallDispatcher.this.mConfig, InstallDispatcher.this.mEnv, InstallDispatcher.this.mDeviceManager, map));
                                }
                            }.run();
                        }
                    }
                });
                InstallDispatcher.this.workAndPostAgain(this.val$register);
                InstallDispatcher.this.mRegisterWorker = this.val$register;
                return;
            }
            InstallDispatcher.this.workAndPostAgain(this.val$register);
            InstallDispatcher.this.mRegisterWorker = this.val$register;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void workAndPostAgain(final BaseWorker baseWorker) {
        ExecutorUtil.runOnNetExecutor(String.valueOf(this.mConfig.getAid()), new Runnable() { // from class: com.bytedance.bdinstall.InstallDispatcher.6
            @Override // java.lang.Runnable
            public void run() {
                if (InstallDispatcher.this.mConfig.isEnableListenNetChange()) {
                    NetworkObserver.OnNetworkReadyListener netObserver = baseWorker.getNetObserver();
                    if (netObserver != null) {
                        baseWorker.setNetObserver(null);
                        ((NetworkObserver) InstallDispatcher.mObservers.get(InstallDispatcher.this.mConfig.getContext())).unObserve(netObserver);
                        if (DrLog.debug()) {
                            DrLog.m143v("remove observer " + baseWorker + ", " + netObserver);
                        }
                    }
                    BaseWorker.WorkResult work = baseWorker.work();
                    InstallDispatcher.this.doEventTrack(work, baseWorker);
                    if (baseWorker.isStop()) {
                        if (DrLog.debug()) {
                            DrLog.m139d("worker ends after init " + baseWorker);
                            return;
                        }
                        return;
                    }
                    if (!work.success && baseWorker.needListenNetChange() && work.errReason == 1) {
                        NetworkObserver.OnNetworkReadyListener onNetworkReadyListener = new NetworkObserver.OnNetworkReadyListener() { // from class: com.bytedance.bdinstall.InstallDispatcher.6.1
                            @Override // com.bytedance.bdinstall.InstallDispatcher.NetworkObserver.OnNetworkReadyListener
                            public void onNetworkReady() {
                                if (InstallDispatcher.this.mHandler.hasMessages(InstallDispatcher.MSG_WORK_ONE, baseWorker)) {
                                    InstallDispatcher.this.mHandler.removeMessages(InstallDispatcher.MSG_WORK_ONE, baseWorker);
                                    InstallDispatcher.this.mHandler.obtainMessage(InstallDispatcher.MSG_WORK_ONE, baseWorker).sendToTarget();
                                    if (DrLog.debug()) {
                                        DrLog.m139d("on net ready. do " + baseWorker + " again");
                                    }
                                }
                                baseWorker.setNetObserver(null);
                                ((NetworkObserver) InstallDispatcher.mObservers.get(InstallDispatcher.this.mConfig.getContext())).unObserve(this);
                                DrLog.m143v("remove observer " + baseWorker + ", " + this);
                            }
                        };
                        baseWorker.setNetObserver(onNetworkReadyListener);
                        ((NetworkObserver) InstallDispatcher.mObservers.get(InstallDispatcher.this.mConfig.getContext())).observe(onNetworkReadyListener);
                    }
                    InstallDispatcher.this.mHandler.sendMessageDelayed(InstallDispatcher.this.mHandler.obtainMessage(InstallDispatcher.MSG_WORK_ONE, baseWorker), work.nextDelay);
                    return;
                }
                BaseWorker.WorkResult work2 = baseWorker.work();
                InstallDispatcher.this.doEventTrack(work2, baseWorker);
                if (!baseWorker.isStop()) {
                    InstallDispatcher.this.mHandler.sendMessageDelayed(InstallDispatcher.this.mHandler.obtainMessage(InstallDispatcher.MSG_WORK_ONE, baseWorker), work2.nextDelay);
                } else if (DrLog.debug()) {
                    DrLog.m139d("worker ends after init " + baseWorker);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doEventTrack(BaseWorker.WorkResult workResult, BaseWorker baseWorker) {
        if (baseWorker != null && workResult.success) {
            baseWorker.updateFailCount(workResult.retryCount);
            baseWorker.onResult(workResult.success);
            baseWorker.doEventTrack();
        } else {
            if (baseWorker == null || workResult.errReason != 4) {
                return;
            }
            baseWorker.updateFailCount(workResult.retryCount);
            baseWorker.onResult(workResult.success);
            baseWorker.doEventTrack();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void activeImmediately(Activator activator) {
        DrLog.m139d("dispatcher#activeImmediately");
        this.mActive.set(true);
        Activator activator2 = this.mActivator;
        if (activator2 != null && activator != null) {
            activator2.stop();
            this.mHandler.removeMessages(MSG_WORK_ONE, this.mActivator);
        }
        this.mActivator = activator;
        workImmediately(activator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyImmediately(VerifyTicketWorker verifyTicketWorker) {
        DrLog.m139d("dispatcher# verifyTicketWorker");
        VerifyTicketWorker verifyTicketWorker2 = this.mVerifyWorker;
        if (verifyTicketWorker2 != null && verifyTicketWorker != null) {
            verifyTicketWorker2.stop();
            this.mHandler.removeMessages(MSG_WORK_ONE, this.mVerifyWorker);
        }
        this.mVerifyWorker = verifyTicketWorker;
        workImmediately(verifyTicketWorker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gWokerImmediately(GWorker gWorker) {
        DrLog.m139d("dispatcher# verifyTicketWorker");
        GWorker gWorker2 = this.mGWorker;
        if (gWorker2 != null && gWorker != null) {
            gWorker2.stop();
            this.mHandler.removeMessages(MSG_WORK_ONE, this.mGWorker);
        }
        this.mGWorker = gWorker;
        workImmediately(gWorker);
    }

    private void workImmediately(BaseWorker baseWorker) {
        workImmediately(baseWorker, false);
    }

    private void workImmediately(BaseWorker baseWorker, boolean z) {
        Handler handler = this.mHandler;
        if (handler == null || baseWorker == null) {
            return;
        }
        handler.removeMessages(MSG_WORK_ONE, baseWorker);
        Message obtainMessage = this.mHandler.obtainMessage(MSG_WORK_ONE, baseWorker.setImmediately());
        if (z && Looper.myLooper() == this.mHandler.getLooper()) {
            handleMessage(obtainMessage);
        } else {
            this.mHandler.sendMessage(obtainMessage);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1234) {
            register(this.mEnv, ((Boolean) message.obj).booleanValue());
            return false;
        }
        if (i != MSG_WORK_ONE) {
            return false;
        }
        BaseWorker baseWorker = (BaseWorker) message.obj;
        if (checkSilenceBg(baseWorker) || baseWorker.isStop()) {
            return false;
        }
        workAndPostAgain(baseWorker);
        return false;
    }

    private boolean checkSilenceBg(BaseWorker baseWorker) {
        if (!this.mConfig.isSilenceInBackground() || this.mAppStateListener.isForeground()) {
            return false;
        }
        if (DrLog.debug()) {
            DrLog.m139d("skip work " + baseWorker + " cause user set silent in bg.");
        }
        Handler handler = this.mHandler;
        handler.sendMessageDelayed(handler.obtainMessage(MSG_WORK_ONE, baseWorker), baseWorker.silenceCheckInterval());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void redoRegister() {
        Register register = this.mRegisterWorker;
        if (register != null) {
            workImmediately(register, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class NetworkObserver {
        private final Context mContext;
        private final Set<WeakReference<OnNetworkReadyListener>> mListeners = Collections.synchronizedSet(new HashSet());
        private final AtomicBoolean mHasListenNetwork = new AtomicBoolean(false);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
        public interface OnNetworkReadyListener {
            void onNetworkReady();
        }

        public NetworkObserver(Context context) {
            this.mContext = context;
        }

        public synchronized void observe(OnNetworkReadyListener onNetworkReadyListener) {
            this.mListeners.add(new WeakReference<>(onNetworkReadyListener));
            tryListenNetChange();
        }

        private void tryListenNetChange() {
            if (this.mHasListenNetwork.compareAndSet(false, true)) {
                try {
                    m146x52d0cc82(this.mContext, new BroadcastReceiver() { // from class: com.bytedance.bdinstall.InstallDispatcher.NetworkObserver.1
                        private boolean isFirstCallback = true;

                        @Override // android.content.BroadcastReceiver
                        public void onReceive(Context context, Intent intent) {
                            if (this.isFirstCallback) {
                                this.isFirstCallback = false;
                                return;
                            }
                            if (intent == null) {
                                DrLog.m139d("intent is null when receive net change event");
                            } else {
                                if (!intent.getBooleanExtra("noConnectivity", false)) {
                                    if (NetUtils.isNetReady(NetworkObserver.this.mContext)) {
                                        NetworkObserver.this.notifyObserver();
                                        return;
                                    }
                                    return;
                                }
                                DrLog.m139d("no connectivity");
                            }
                        }
                    }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized void notifyObserver() {
            ExecutorUtil.runOnFirstHandlerThread(new Runnable() { // from class: com.bytedance.bdinstall.InstallDispatcher.NetworkObserver.2
                @Override // java.lang.Runnable
                public void run() {
                    Iterator it = new ArrayList(NetworkObserver.this.mListeners).iterator();
                    while (it.hasNext()) {
                        OnNetworkReadyListener onNetworkReadyListener = (OnNetworkReadyListener) ((WeakReference) it.next()).get();
                        if (onNetworkReadyListener != null) {
                            onNetworkReadyListener.onNetworkReady();
                        }
                    }
                }
            });
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        
            r0.remove();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void unObserve(OnNetworkReadyListener onNetworkReadyListener) {
            Iterator<WeakReference<OnNetworkReadyListener>> it = this.mListeners.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WeakReference<OnNetworkReadyListener> next = it.next();
                if (next == null) {
                    it.remove();
                } else if (next.get() == onNetworkReadyListener) {
                    break;
                }
            }
        }

        @Proxy("registerReceiver")
        @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator"})
        /* renamed from: INVOKEVIRTUAL_com_bytedance_bdinstall_InstallDispatcher$NetworkObserver_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver */
        public static Intent m146x52d0cc82(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen()) {
                ReceiverRegisterCrashOptimizer.doHWReceiverFix();
            }
            try {
                if (ReceiverRegisterCrashOptimizer.doRegisterHandler()) {
                    ReceiverRegisterLancet.initHandler();
                    Context context2 = context;
                    return context.registerReceiver(broadcastReceiver, intentFilter, null, ReceiverRegisterLancet.sReceiverHandler);
                }
                if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null && ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(intentFilter)) {
                    ReceiverRegisterLancet.initProxyHandler();
                    Context context3 = context;
                    return ContextCompat.registerReceiver(context, broadcastReceiver, intentFilter, (String) null, ReceiverRegisterLancet.sProxyHandler, 2);
                }
                return context.registerReceiver(broadcastReceiver, intentFilter);
            } catch (Exception e) {
                if (!ReceiverRegisterCrashOptimizer.fixedOpen()) {
                    throw e;
                }
                return ReceiverRegisterCrashOptimizer.registerReceiver(broadcastReceiver, intentFilter);
            }
        }
    }

    @Override // com.bytedance.bdinstall.callback.EgdiCallback
    public void onEgdiFailed() {
        this.mHandler.postDelayed(new Runnable() { // from class: com.bytedance.bdinstall.InstallDispatcher.7
            @Override // java.lang.Runnable
            public void run() {
                InstallDispatcher.this.gWokerImmediately(new GWorker(InstallDispatcher.this.mConfig, InstallDispatcher.this.mDeviceManager, InstallDispatcher.this.mEnv, InstallDispatcher.this.mAppStateListener));
            }
        }, BDInstall.getBDInstallConfig().getEgdiRetryInterval());
    }
}
