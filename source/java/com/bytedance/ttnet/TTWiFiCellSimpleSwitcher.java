package com.bytedance.ttnet;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ttnet.TTWiFiCellSwitcher;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class TTWiFiCellSimpleSwitcher implements TTWiFiCellSwitcher.Observer {
    private final Map<Observer, Handler> mSimpleObservers;
    private volatile int mState;

    /* loaded from: classes4.dex */
    public interface Observer {
        void onStateChanged(int i, int i2);
    }

    /* loaded from: classes4.dex */
    public static class SOURCE {
        public static final int PLAYER = 1;
        public static final int TTNET = 0;
    }

    /* loaded from: classes4.dex */
    public static class State {
        public static final int CELL = 2;
        public static final int READY_SWITCH_TO_CELL = 1;
        public static final int READY_SWITCH_TO_WIFI = 3;
        public static final int UNKNOWN = -1;
        public static final int WIFI = 0;
    }

    public void onMessage(int i, int i2, int i3, JSONObject jSONObject) {
    }

    public int getCurrentState() {
        return this.mState;
    }

    /* loaded from: classes4.dex */
    private static final class SInstanceHolder {
        static final TTWiFiCellSimpleSwitcher sInstance = new TTWiFiCellSimpleSwitcher();

        private SInstanceHolder() {
        }
    }

    public static TTWiFiCellSimpleSwitcher inst() {
        return SInstanceHolder.sInstance;
    }

    private TTWiFiCellSimpleSwitcher() {
        this.mState = -1;
        this.mSimpleObservers = new HashMap();
        TTWiFiCellSwitcher.inst().registerObserver(this, null);
    }

    public void registerObserver(Observer observer, Handler handler) {
        if (observer == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (this) {
            if (!this.mSimpleObservers.containsKey(observer)) {
                if (handler == null) {
                    this.mSimpleObservers.put(observer, new Handler(Looper.getMainLooper()));
                } else {
                    this.mSimpleObservers.put(observer, handler);
                }
            }
        }
    }

    public void unregisterObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("observer == null");
        }
        synchronized (this) {
            this.mSimpleObservers.remove(observer);
        }
    }

    public void start() {
        TTWiFiCellSwitcher.inst().start();
    }

    public void stop() {
        TTWiFiCellSwitcher.inst().stop();
    }

    public void switchToCell() {
        TTWiFiCellSwitcher.inst().start();
        TTWiFiCellSwitcher.inst().triggerSwitchingToNetwork(TTWiFiCellSwitcher.NetworkType.CELL);
    }

    public void switchToWiFi() {
        TTWiFiCellSwitcher.inst().start();
        TTWiFiCellSwitcher.inst().triggerSwitchingToNetwork(TTWiFiCellSwitcher.NetworkType.WIFI);
    }

    /* renamed from: com.bytedance.ttnet.TTWiFiCellSimpleSwitcher$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State;

        static {
            int[] iArr = new int[TTWiFiCellSwitcher.State.values().length];
            $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State = iArr;
            try {
                iArr[TTWiFiCellSwitcher.State.DEFAULT_CELLULAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[TTWiFiCellSwitcher.State.WIFI_WITH_CELLULAR_TRANS_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[TTWiFiCellSwitcher.State.DEFAULT_WIFI_WITH_CELLULAR_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[TTWiFiCellSwitcher.State.DEFAULT_WIFI_WITH_CELLULAR_UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[TTWiFiCellSwitcher.State.WAIT_CELLULAR_ALWAYS_UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[TTWiFiCellSwitcher.State.WAIT_USER_ALLOW_TO_CELLULAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[TTWiFiCellSwitcher.State.WAIT_USER_ALLOW_TO_WIFI.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.bytedance.ttnet.TTWiFiCellSwitcher.Observer
    public void onStateChanged(TTWiFiCellSwitcher.State state, TTWiFiCellSwitcher.State state2) {
        int i;
        switch (AnonymousClass2.$SwitchMap$com$bytedance$ttnet$TTWiFiCellSwitcher$State[state2.ordinal()]) {
            case 1:
            case 2:
                i = 2;
                break;
            case 3:
            case 4:
            case 5:
                i = 0;
                break;
            case 6:
                i = 1;
                break;
            case 7:
                i = 3;
                break;
            default:
                i = -1;
                break;
        }
        if (this.mState != i) {
            synchronized (this) {
                for (Map.Entry<Observer, Handler> entry : this.mSimpleObservers.entrySet()) {
                    Observer key = entry.getKey();
                    Handler value = entry.getValue();
                    Runnable runnable = new Runnable(i, key) { // from class: com.bytedance.ttnet.TTWiFiCellSimpleSwitcher.1
                        private final int currState;
                        private final int prevState;
                        final /* synthetic */ int val$newState;
                        final /* synthetic */ Observer val$observer;

                        {
                            this.val$newState = i;
                            this.val$observer = key;
                            this.prevState = TTWiFiCellSimpleSwitcher.this.mState;
                            this.currState = i;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            this.val$observer.onStateChanged(this.prevState, this.currState);
                        }
                    };
                    if (value != null) {
                        value.post(runnable);
                    }
                }
            }
            this.mState = i;
        }
    }
}
