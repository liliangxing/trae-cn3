package com.bytedance.sync.p005v4.tigger;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sync.Configuration;
import com.bytedance.sync.SyncConstants;
import com.bytedance.sync.interfaze.IDeviceInfoGetter;
import com.bytedance.sync.interfaze.ILooper;
import com.bytedance.sync.interfaze.ISettings;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.p005v4.intf.ICompensatorServiceV4;
import com.bytedance.sync.p005v4.intf.IConfiguration;
import com.bytedance.sync.p005v4.intf.IDBServiceV4;
import com.bytedance.sync.p005v4.intf.ISyncMsgSenderV4;
import com.bytedance.sync.p005v4.intf.ISyncStatus;
import com.bytedance.sync.p005v4.intf.IWsStatusService;
import com.bytedance.sync.p005v4.net.WsStatusKeeper;
import com.bytedance.sync.p005v4.protocal.Reason;
import com.bytedance.sync.p005v4.utils.ToolUtils;
import com.bytedance.sync.settings.SyncSettings;
import com.ss.android.ug.bus.UgBusFramework;
import com.ss.android.ug.bus.UgCallbackCenter;
import java.util.Objects;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class SyncTiggerV4 implements Handler.Callback {
    private static final int MSG_ACCOUNT_LOGIN_EVENT = 102;
    private static final int MSG_WHAT_CHECK_VERSION = 106;
    private static final int MSG_WHAT_CLEAR_EXPIRE = 105;
    private static final int MSG_WHAT_START_UP = 101;
    private static final int MSG_WHAT_WS_CONNECT = 103;
    private static final int MSG_WHAT_WS_DISCONNECT = 104;
    private static final String TAG = "[SyncTiggerV4] ";
    private UgCallbackCenter.Callback<Void> mAccountCallback;
    private final Context mContext;
    private long mLastSendPollTimestamp = 0;
    private final Configuration mConfiguration = ((IConfiguration) UgBusFramework.getService(IConfiguration.class)).config();
    private final Handler mHandler = new Handler(((ILooper) UgBusFramework.getService(ILooper.class)).get(), this);

    private void wsDisconnect() {
    }

    public SyncTiggerV4(Context context) {
        this.mContext = context;
    }

    public void start() {
        this.mAccountCallback = new UgCallbackCenter.Callback<Void>() { // from class: com.bytedance.sync.v4.tigger.SyncTiggerV4.1
            public void onCall(Void r5) {
                long eventChangeInterval = SyncSettings.inst(SyncTiggerV4.this.mContext).getSettings().eventChangeInterval() * 1000;
                SyncTiggerV4.this.mHandler.sendMessageDelayed(SyncTiggerV4.this.mHandler.obtainMessage(102), eventChangeInterval);
            }
        };
        ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).addAccountLoginOrSwitchEventListener(this.mAccountCallback);
        IWsStatusService iWsStatusService = (IWsStatusService) UgBusFramework.getService(IWsStatusService.class);
        final ISettings settings = SyncSettings.inst(this.mContext).getSettings();
        if (settings.wsFirst()) {
            iWsStatusService.addWsStatusChangedListener(new WsStatusKeeper.OnWsStatusChangedListener() { // from class: com.bytedance.sync.v4.tigger.SyncTiggerV4.2
                @Override // com.bytedance.sync.v4.net.WsStatusKeeper.OnWsStatusChangedListener
                public void onWsStatusChanged(boolean z) {
                    if (settings.enableReconnectPoll()) {
                        SyncTiggerV4.this.wsConnectStatusChange(z);
                    }
                }
            });
        }
        this.mHandler.sendMessage(this.mHandler.obtainMessage(106));
        this.mHandler.sendMessage(this.mHandler.obtainMessage(101));
        this.mHandler.sendMessage(this.mHandler.obtainMessage(105));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 106) {
            checkVersion();
        }
        if (message.what == 101) {
            sendPollMsgInit(Reason.Init.getValue());
        }
        if (message.what == 102) {
            sendPollMsgInit(Reason.Switch.getValue());
        }
        if (message.what == 103) {
            wsConnect();
        }
        if (message.what == 104) {
            wsDisconnect();
        }
        if (message.what != 105) {
            return false;
        }
        clearExpireSyncLog();
        return false;
    }

    private void sendPollMsgInit(int i) {
        if (SyncSettings.inst(this.mContext).getEnable()) {
            ((ISyncMsgSenderV4) UgBusFramework.getService(ISyncMsgSenderV4.class)).sendPollMsg(false, i);
            if (!ToolUtils.isMainProcess(this.mContext) && this.mConfiguration.enableMultiProcess && !this.mConfiguration.enableMultiProcessCompensate) {
                LogUtils.m187i("[SyncTiggerV4] current is non main process, config not start compensator");
            } else {
                ((ICompensatorServiceV4) UgBusFramework.getService(ICompensatorServiceV4.class)).reset();
                ((ICompensatorServiceV4) UgBusFramework.getService(ICompensatorServiceV4.class)).startOnce();
            }
        }
    }

    public void sendPollMsg(boolean z, int i) {
        ((ISyncMsgSenderV4) UgBusFramework.getService(ISyncMsgSenderV4.class)).sendPollMsg(z, i);
        this.mLastSendPollTimestamp = System.currentTimeMillis();
    }

    public void destroy() {
        if (this.mAccountCallback != null) {
            ((IDeviceInfoGetter) UgBusFramework.getService(IDeviceInfoGetter.class)).removeAccountLoginOrSwitchEventListener(this.mAccountCallback);
        }
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void wsConnectStatusChange(boolean z) {
        try {
            if (z) {
                this.mHandler.removeMessages(104);
                if (!this.mHandler.hasMessages(103)) {
                    Handler handler = this.mHandler;
                    handler.sendMessageDelayed(handler.obtainMessage(103), 1000L);
                }
            } else {
                this.mHandler.removeMessages(103);
                if (!this.mHandler.hasMessages(104)) {
                    Handler handler2 = this.mHandler;
                    handler2.sendMessage(handler2.obtainMessage(104));
                }
            }
        } catch (Throwable th) {
            LogUtils.m186e(Log.getStackTraceString(th));
        }
    }

    private void wsConnect() {
        try {
            if (((ISyncStatus) UgBusFramework.getService(ISyncStatus.class)).getLastSendSyncMethod() != 1 || (SyncSettings.inst(this.mContext).getSettings().enableReconnectPoll() && System.currentTimeMillis() - this.mLastSendPollTimestamp > SyncSettings.inst(this.mContext).getSettings().reconnectPollInterval() * 1000)) {
                LogUtils.m187i("[SyncTiggerV4] long link is online, in order for the server to sense that the long link is online, poll package needs to be sent ");
                sendPollMsg(false, Reason.ReConnect.getValue());
            }
        } catch (Throwable th) {
            LogUtils.m186e(Log.getStackTraceString(th));
        }
    }

    private void clearExpireSyncLog() {
        try {
            ((IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class)).deleteExpireSyncLog(System.currentTimeMillis());
        } catch (Throwable unused) {
        }
    }

    private void checkVersion() {
        try {
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SyncConstants.SP_NAME, 0);
            String string = sharedPreferences.getString(SyncConstants.PREV_VERSION, "");
            String name = getClass().getName();
            if (!TextUtils.isEmpty(string) && !Objects.equals(string, name)) {
                ((IDBServiceV4) UgBusFramework.getService(IDBServiceV4.class)).resetAllCursor();
            }
            sharedPreferences.edit().putString(SyncConstants.PREV_VERSION, name).apply();
        } catch (Throwable th) {
            LogUtils.m186e("[SyncTiggerV4] check version err:" + th);
        }
    }
}
