package com.bytedance.frameworks.baselib.network.queryfilter;

import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.LifeCycleMonitor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class QueryFilterStateListener extends LifeCycleMonitor.NetworkAppStateListener {
    private static volatile QueryFilterStateListener sInstance;
    public AtomicBoolean mIsBackgroundState;

    public static QueryFilterStateListener getInstance() {
        if (sInstance == null) {
            synchronized (QueryFilterStateListener.class) {
                if (sInstance == null) {
                    sInstance = new QueryFilterStateListener(30000);
                }
            }
        }
        return sInstance;
    }

    public QueryFilterStateListener(int i) {
        super(i);
        this.mIsBackgroundState = new AtomicBoolean(false);
    }

    public void onServerConfigChanged(JSONObject jSONObject) {
        setEnterBackgroundDelayMills(jSONObject.optInt("qf_enter_background_time", 30000));
    }

    @Override // com.bytedance.frameworks.baselib.network.LifeCycleMonitor.NetworkAppStateListener
    public void onEnterToForeground() {
        this.mIsBackgroundState.set(false);
        if (Logger.debug()) {
            Logger.d("QueryFilterStateListener", "onEnterToForeground");
        }
    }

    @Override // com.bytedance.frameworks.baselib.network.LifeCycleMonitor.NetworkAppStateListener
    public void onEnterToBackground() {
        this.mIsBackgroundState.set(true);
        if (Logger.debug()) {
            Logger.d("QueryFilterStateListener", "onEnterToBackground");
        }
    }
}
