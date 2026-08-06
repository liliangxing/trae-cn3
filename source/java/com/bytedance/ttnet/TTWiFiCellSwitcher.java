package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ttnet.utils.TTNetProtocolUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class TTWiFiCellSwitcher {
    private static final String ACTION_NAME = "wifi-to-cell";
    private static final String ACTION_PATH_NOTIFY_SWITCH = "/notify-switch";
    private static final String ACTION_PATH_START = "/start";
    private static final String ACTION_PATH_STOP = "/stop";
    private static final String ACTION_PATH_TRIGGER = "/trigger-switch";
    private static final String ACTION_PATH_TRIGGER_THIRD_PARTY = "/trigger-third-party";
    private static final String TAG = "TTWiFiCellSwitchManager";
    private volatile State mCurrentState = State.STOPPED;
    private final Map<Observer, Handler> mObservers = new HashMap();

    /* loaded from: classes4.dex */
    public interface Observer {
        void onStateChanged(State state, State state2);
    }

    /* loaded from: classes4.dex */
    public enum State {
        UNKNOWN(Integer.MIN_VALUE),
        STOPPED(-1),
        NO_NETWORK(0),
        DEFAULT_CELLULAR(1),
        DEFAULT_WIFI_WITH_CELLULAR_DOWN(2),
        DEFAULT_WIFI_WITH_CELLULAR_UP(3),
        WAIT_CELLULAR_ALWAYS_UP(4),
        WAIT_USER_ALLOW_TO_CELLULAR(5),
        WIFI_WITH_CELLULAR_TRANS_DATA(6),
        EVALUATE_CELLULAR(7),
        WAIT_USER_ALLOW_TO_WIFI(8);

        private static final Map<Integer, State> BY_CODE = new HashMap();
        final int state;

        static {
            for (State state : values()) {
                BY_CODE.put(Integer.valueOf(state.state), state);
            }
        }

        State(int i) {
            this.state = i;
        }

        public int code() {
            return this.state;
        }

        public static State convertToState(int i) {
            State state = BY_CODE.get(Integer.valueOf(i));
            return state != null ? state : UNKNOWN;
        }
    }

    public State getCurrentState() {
        return this.mCurrentState;
    }

    /* loaded from: classes4.dex */
    public enum NetworkType {
        WIFI(0),
        CELL(1);

        final int networkType;

        NetworkType(int i) {
            this.networkType = i;
        }

        public int code() {
            return this.networkType;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class SInstanceHolder {
        static final TTWiFiCellSwitcher sInstance = new TTWiFiCellSwitcher();

        private SInstanceHolder() {
        }
    }

    public static TTWiFiCellSwitcher inst() {
        return SInstanceHolder.sInstance;
    }

    public void registerObserver(Observer observer, Handler handler) {
        if (observer == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (this) {
            if (!this.mObservers.containsKey(observer)) {
                if (handler == null) {
                    this.mObservers.put(observer, new Handler(Looper.getMainLooper()));
                } else {
                    this.mObservers.put(observer, handler);
                }
            }
        }
    }

    public void unregisterObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (this) {
            this.mObservers.remove(observer);
        }
    }

    public void start() {
        try {
            TTNetProtocolUtil.sendTTNetProtocolRequest(ACTION_NAME, ACTION_PATH_START, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            TTNetProtocolUtil.sendTTNetProtocolRequest(ACTION_NAME, ACTION_PATH_STOP, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void triggerSwitchingToNetwork(NetworkType networkType) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("network-type", Integer.toString(networkType.code()));
            TTNetProtocolUtil.sendTTNetProtocolRequest(ACTION_NAME, ACTION_PATH_TRIGGER, hashMap, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public boolean notifySwitchToMultiNetwork(boolean z) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("enable", z ? "1" : "0");
            TTNetProtocolUtil.sendTTNetProtocolRequest(ACTION_NAME, ACTION_PATH_NOTIFY_SWITCH, hashMap, null);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Deprecated
    public void triggerSwitchingToCellular() {
        try {
            TTNetProtocolUtil.sendTTNetProtocolRequest(ACTION_NAME, ACTION_PATH_TRIGGER_THIRD_PARTY, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void notifyWiFiToCellState(int i, int i2) {
        inst().handleWiFiToCellState(i, i2);
    }

    private void handleWiFiToCellState(final int i, final int i2) {
        this.mCurrentState = State.convertToState(i2);
        synchronized (this) {
            for (Map.Entry<Observer, Handler> entry : this.mObservers.entrySet()) {
                final Observer key = entry.getKey();
                Handler value = entry.getValue();
                if (value != null) {
                    value.post(new Runnable() { // from class: com.bytedance.ttnet.TTWiFiCellSwitcher.1
                        @Override // java.lang.Runnable
                        public void run() {
                            key.onStateChanged(State.convertToState(i), State.convertToState(i2));
                        }
                    });
                }
            }
        }
    }
}
