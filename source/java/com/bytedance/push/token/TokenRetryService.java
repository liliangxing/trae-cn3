package com.bytedance.push.token;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.push.ActivityLifecycleObserver;
import com.bytedance.common.push.interfaze.IEventReportListener;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.helper.NetWorkStatusMonitorHelper;
import com.bytedance.push.interfaze.ITokenRetryService;
import com.bytedance.push.settings.token.TokenRetrySettingsMode;
import com.bytedance.push.third.PushManager;
import com.bytedance.push.utils.Logger;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.pushmanager.setting.PushSetting;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TokenRetryService implements ITokenRetryService, Handler.Callback, Observer {
    private final String TAG = "TokenRetryService";
    private final int MSG_WHAT_TOKEN_REGISTER_TIMEOUT = 20250115;
    private final int MSG_WHAT_TOKEN_RETRY_TIMEOUT = 20250116;
    private final int MSG_WHAT_TOKEN_REGISTER_AGAIN = 20250117;
    private final Set<Integer> mNeedRetrySenderSet = new HashSet();
    private final Map<Integer, TokenRetryTask> mTokenRetryTaskMap = new HashMap();
    private final AtomicBoolean mRetryEd = new AtomicBoolean(false);
    private IEventReportListener.IEventReportCallback mIEventReportCallback = new IEventReportListener.IEventReportCallback() { // from class: com.bytedance.push.token.TokenRetryService.1
        public List<String> needMonitorEventList() {
            return TokenRetryService.this.mTokenRetrySettingsMode.triggerRetryEventList;
        }

        public void onEvent(String str, JSONObject jSONObject) {
            Logger.m274i("TokenRetryService", "[onEvent]eventName:" + str);
            if (TokenRetryService.this.mTokenRetrySettingsMode.triggerRetryEventList.contains(str)) {
                Logger.m274i("TokenRetryService", "[onEvent]retry token register because event:" + str);
                synchronized (TokenRetryService.this.mTokenRetryTaskMap) {
                    if (!TokenRetryService.this.mTokenRetryTaskMap.isEmpty()) {
                        synchronized (TokenRetryService.this.mTokenRetryTaskMap) {
                            Iterator it = TokenRetryService.this.mTokenRetryTaskMap.values().iterator();
                            while (it.hasNext()) {
                                ((TokenRetryTask) it.next()).startRetry("event_trigger-" + str);
                            }
                        }
                    } else {
                        Logger.m274i("TokenRetryService", "[onEvent]unregister eventReportListener because  mTokenRetryTaskMap is empty");
                    }
                }
            }
        }
    };
    private int mLoopRetryTimes = 0;
    private boolean mIsBackground = false;
    private boolean mHasRegisterAppStatusObserver = false;
    private TokenRetrySettingsMode mTokenRetrySettingsMode = PushSetting.getInstance().getPushOnLineSettings().getTokenRetrySettingsMode();

    public TokenRetryService() {
        PushThreadHandlerManager.inst().addHandlerCallback(this);
    }

    @Override // com.bytedance.push.interfaze.ITokenRetryService
    public void onPushAdapterRegister(int i) {
        Logger.m274i("TokenRetryService", "[onPushAdapterRegister]pushType:" + i);
        if (!this.mTokenRetrySettingsMode.enableTokenRetry) {
            Logger.m274i("TokenRetryService", "[onPushAdapterRegister]do nothing because enableTokenRetry is false");
            return;
        }
        if (!this.mTokenRetrySettingsMode.needRetryChannel.contains(Integer.valueOf(i))) {
            Logger.m274i("TokenRetryService", "[onPushAdapterRegister]do nothing because needRetryChannel not contains " + i);
            return;
        }
        synchronized (this.mNeedRetrySenderSet) {
            if (this.mNeedRetrySenderSet.contains(Integer.valueOf(i))) {
                Logger.m274i("TokenRetryService", "[onPushAdapterRegister]do nothing because mNeedRetrySenderSet has contains " + i);
                return;
            }
            this.mNeedRetrySenderSet.add(Integer.valueOf(i));
            long j = this.mTokenRetrySettingsMode.tokenRegisterTimeout * 1000;
            Logger.m274i("TokenRetryService", "[onPushAdapterRegister]send token register timeout message after " + j);
            WeakHandler handler = PushThreadHandlerManager.inst().getHandler();
            handler.sendMessageDelayed(handler.obtainMessage(20250115, Integer.valueOf(i)), j);
        }
    }

    @Override // com.bytedance.push.interfaze.ITokenRetryService
    public void onUpdateTokenSuccess(int i) {
        TokenRetryTask tokenRetryTask;
        Logger.m274i("TokenRetryService", "[onUpdateTokenSuccess]pushType:" + i);
        if (!this.mTokenRetrySettingsMode.enableTokenRetry) {
            Logger.m274i("TokenRetryService", "[onUpdateTokenSuccess]do nothing because enableTokenRetry is false");
            return;
        }
        synchronized (this.mNeedRetrySenderSet) {
            if (!this.mNeedRetrySenderSet.contains(Integer.valueOf(i))) {
                Logger.m274i("TokenRetryService", "[onUpdateTokenSuccess]needn't retry:" + i);
                return;
            }
            this.mNeedRetrySenderSet.remove(Integer.valueOf(i));
            synchronized (this.mTokenRetryTaskMap) {
                if (!this.mTokenRetryTaskMap.isEmpty() && (tokenRetryTask = this.mTokenRetryTaskMap.get(Integer.valueOf(i))) != null) {
                    PushSupporter.get().getPushSdkMonitorService().onTokenRetryResult(i, true, tokenRetryTask.getRetryReason());
                    this.mTokenRetryTaskMap.remove(Integer.valueOf(i));
                }
            }
            Logger.m274i("TokenRetryService", "[onUpdateTokenSuccess]remove timeout message for " + i);
            PushThreadHandlerManager.inst().getHandler().removeMessages(20250115, Integer.valueOf(i));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 20250115) {
            Logger.m274i("TokenRetryService", "[handleMessage]MSG_WHAT_TOKEN_REGISTER_TIMEOUT:" + message.obj);
            registerTokenRetryCallback(((Integer) message.obj).intValue());
            return true;
        }
        if (message.what == 20250117) {
            Logger.m274i("TokenRetryService", "[handleMessage]MSG_WHAT_TOKEN_REGISTER_AGAIN");
            synchronized (this.mTokenRetryTaskMap) {
                if (!this.mTokenRetryTaskMap.isEmpty()) {
                    Logger.m274i("TokenRetryService", "[handleMessage]maxLoopRetryTimes:" + this.mTokenRetrySettingsMode.maxLoopRetryTimes + " mLoopRetryTimes:" + this.mLoopRetryTimes);
                    if (this.mTokenRetrySettingsMode.maxLoopRetryTimes > 0 && this.mLoopRetryTimes >= this.mTokenRetrySettingsMode.maxLoopRetryTimes) {
                        Logger.m274i("TokenRetryService", "[handleMessage]not loop retry because mLoopRetryTimes >maxRetryTimes,mLoopRetryTimes:" + this.mLoopRetryTimes + " maxRetryTimes:" + this.mTokenRetrySettingsMode.maxLoopRetryTimes);
                        return true;
                    }
                    this.mLoopRetryTimes++;
                    Logger.m274i("TokenRetryService", "[handleMessage]update mLoopRetryTimes to " + this.mLoopRetryTimes);
                    Iterator<TokenRetryTask> it = this.mTokenRetryTaskMap.values().iterator();
                    while (it.hasNext()) {
                        it.next().startRetry("interval_loop");
                    }
                    WeakHandler handler = PushThreadHandlerManager.inst().getHandler();
                    handler.sendMessageDelayed(handler.obtainMessage(20250117), this.mTokenRetrySettingsMode.loopRetryIntervalInSecond * 1000);
                } else {
                    this.mLoopRetryTimes = 0;
                    Logger.m274i("TokenRetryService", "[handleMessage]update mLoopRetryTimes to 0");
                }
                return true;
            }
        }
        if (message.what == 20250116) {
            int intValue = ((Integer) message.obj).intValue();
            String string = message.getData().getString("retry_reason");
            Logger.m274i("TokenRetryService", "[handleMessage]MSG_WHAT_TOKEN_RETRY_TIMEOUT:" + message.obj + " retryReason:" + string);
            synchronized (this.mTokenRetryTaskMap) {
                if (!this.mTokenRetryTaskMap.isEmpty()) {
                    TokenRetryTask tokenRetryTask = this.mTokenRetryTaskMap.get(Integer.valueOf(intValue));
                    if (tokenRetryTask != null) {
                        tokenRetryTask.retryFailed(string);
                    } else {
                        PushSupporter.get().getPushSdkMonitorService().onTokenRetryResult(intValue, true, string);
                    }
                }
            }
        }
        return false;
    }

    private void registerTokenRetryCallback(int i) {
        initTokenRetryTask(i);
        if (this.mRetryEd.compareAndSet(false, true)) {
            Logger.m274i("TokenRetryService", "[registerTokenRetryCallback]retryAfterNetworkChanged:" + this.mTokenRetrySettingsMode.retryAfterNetworkChanged + " loopRetryIntervalInSecond:" + this.mTokenRetrySettingsMode.loopRetryIntervalInSecond + " triggerRetryEventList.size:" + this.mTokenRetrySettingsMode.triggerRetryEventList.size() + " retryAfterEnterBackground:" + this.mTokenRetrySettingsMode.retryAfterEnterBackground);
            if (this.mTokenRetrySettingsMode.retryAfterNetworkChanged) {
                NetWorkStatusMonitorHelper.getInstance().addNetworkStatusListener(new NetWorkStatusMonitorHelper.INetworkStatusListener() { // from class: com.bytedance.push.token.TokenRetryService.2
                    @Override // com.bytedance.push.helper.NetWorkStatusMonitorHelper.INetworkStatusListener
                    public void onAvailableNetworkTypeChanged(String str, String str2) {
                        Logger.m274i("TokenRetryService", "[onAvailableNetworkTypeChanged]lastType:" + str + " curType:" + str2);
                        synchronized (TokenRetryService.this.mTokenRetryTaskMap) {
                            if (!TokenRetryService.this.mTokenRetryTaskMap.isEmpty()) {
                                Iterator it = TokenRetryService.this.mTokenRetryTaskMap.values().iterator();
                                while (it.hasNext()) {
                                    ((TokenRetryTask) it.next()).startRetry("network_type_changed-" + str2);
                                }
                                return;
                            }
                            Logger.m274i("TokenRetryService", "[onCapabilitiesChanged]unregister NetworkCallback because  mTokenRetryTaskMap is empty");
                        }
                    }
                });
            }
            if (this.mTokenRetrySettingsMode.loopRetryIntervalInSecond > 0) {
                WeakHandler handler = PushThreadHandlerManager.inst().getHandler();
                handler.sendMessageDelayed(handler.obtainMessage(20250117), this.mTokenRetrySettingsMode.loopRetryIntervalInSecond * 1000);
            }
            if (!this.mTokenRetrySettingsMode.triggerRetryEventList.isEmpty()) {
                IEventReportListener eventReportListener = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.getEventReportListener();
                Logger.m274i("TokenRetryService", "[registerTokenRetryCallback]eventReportListener:" + eventReportListener);
                if (eventReportListener != null) {
                    eventReportListener.registerEventReportCallback(this.mIEventReportCallback);
                } else {
                    Logger.m278w("TokenRetryService", "[registerTokenRetryCallback]not monitor event report because eventReportListener is null");
                }
            }
            if (this.mTokenRetrySettingsMode.retryAfterEnterBackground) {
                Logger.m274i("TokenRetryService", "[registerTokenRetryCallback]mHasRegisterAppStatusObserver:" + this.mHasRegisterAppStatusObserver);
                if (this.mHasRegisterAppStatusObserver) {
                    return;
                }
                this.mHasRegisterAppStatusObserver = true;
                this.mIsBackground = ActivityLifecycleObserver.getIns().isBackGround();
                ActivityLifecycleObserver.getIns().addObserver(this);
            }
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        Logger.m274i("TokenRetryService", "app status changed,mIsBackground:" + this.mIsBackground + " isBackground:" + booleanValue);
        if (!this.mIsBackground && booleanValue) {
            synchronized (this.mTokenRetryTaskMap) {
                Iterator<TokenRetryTask> it = this.mTokenRetryTaskMap.values().iterator();
                while (it.hasNext()) {
                    it.next().startRetry("enter_background");
                }
            }
        }
        this.mIsBackground = booleanValue;
    }

    private TokenRetryTask initTokenRetryTask(int i) {
        TokenRetryTask tokenRetryTask;
        synchronized (this.mTokenRetryTaskMap) {
            tokenRetryTask = this.mTokenRetryTaskMap.get(Integer.valueOf(i));
            if (tokenRetryTask == null) {
                tokenRetryTask = new TokenRetryTask(i);
                this.mTokenRetryTaskMap.put(Integer.valueOf(i), tokenRetryTask);
            }
        }
        return tokenRetryTask;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public class TokenRetryTask {
        private String mRetryReason;
        private int pushType;
        private final String TAG = "TokenRetryTask";
        private final AtomicBoolean mRetrying = new AtomicBoolean(false);

        public TokenRetryTask(int i) {
            this.pushType = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void startRetry(String str) {
            Logger.m274i("TokenRetryTask", "[startRetry]pushType:" + this.pushType + " retryReason:" + str + " mRetrying:" + this.mRetrying + " mRetryingReason:" + this.mRetryReason);
            if (this.mRetrying.compareAndSet(false, true)) {
                this.mRetryReason = str;
                Logger.m274i("TokenRetryTask", "[retryForEnterBackground]retry token register because " + str);
                PushManager.inst().registerPush(AppProvider.getApp(), this.pushType);
                PushSupporter.get().getPushSdkMonitorService().onTokenRetry(this.pushType, str);
                long j = TokenRetryService.this.mTokenRetrySettingsMode.tokenRegisterTimeout * 1000;
                Logger.m274i("TokenRetryTask", "[retryForEnterBackground]send token register timeout message after " + j);
                WeakHandler handler = PushThreadHandlerManager.inst().getHandler();
                Message obtainMessage = handler.obtainMessage(20250116, Integer.valueOf(this.pushType));
                Bundle bundle = new Bundle();
                bundle.putString("retry_reason", str);
                obtainMessage.setData(bundle);
                handler.sendMessageDelayed(obtainMessage, j);
                return;
            }
            Logger.m274i("TokenRetryTask", "[retryForEnterBackground]do nothing because mRetryingReason:" + this.mRetryReason);
        }

        public void retryFailed(String str) {
            Logger.m274i("TokenRetryTask", "[retryFailed]pushType:" + this.pushType + " retryReason:" + str);
            PushSupporter.get().getPushSdkMonitorService().onTokenRetryResult(this.pushType, false, str);
            this.mRetrying.set(false);
            this.mRetryReason = null;
        }

        public String getRetryReason() {
            return this.mRetryReason;
        }
    }
}
