package com.bytedance.applog.filter;

import android.util.Pair;
import com.bytedance.applog.IBDAccountCallback;
import com.bytedance.applog.engine.Engine;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.monitor.MonitorKey;
import com.bytedance.applog.sampling.AbsSamplingUser;
import com.bytedance.applog.sampling.EventSampling;
import com.bytedance.applog.sampling.EventSamplingLoader;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SamplingFilter implements IEventFilter {
    public static final String KEY_SP_NAME = "sampling_list";
    private volatile AbsSamplingUser cachedUser = null;
    private final Engine engine;
    private final EventSampling eventSampling;

    public SamplingFilter(final Engine engine, final EventSampling eventSampling) {
        this.engine = engine;
        this.eventSampling = eventSampling;
        if (LogUtils.isDisabled()) {
            return;
        }
        LogUtils.sendJsonFetcher("sampling_config", new EventBus.DataFetcher() { // from class: com.bytedance.applog.filter.SamplingFilter.1
            @Override // com.bytedance.applog.log.EventBus.DataFetcher
            public Object fetch() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("appId", engine.getAppLog().getAppId());
                    jSONObject.put("config", eventSampling.getConfigJson());
                } catch (Throwable unused) {
                }
                return jSONObject;
            }
        });
    }

    public EventSampling getEventSampling() {
        return this.eventSampling;
    }

    @Override // com.bytedance.applog.filter.IEventFilter
    public boolean filterAndDiscardEvent(MonitorKey monitorKey, String str, String str2) {
        if (MonitorKey.event_v3.equals(monitorKey) || MonitorKey.log_data.equals(monitorKey)) {
            return this.eventSampling.isHitSamplingDropString(buildSamplingUser(), str, str2);
        }
        return false;
    }

    @Override // com.bytedance.applog.filter.IEventFilter
    public boolean noFilter() {
        return !this.eventSampling.hasStrategy();
    }

    public boolean isHitStickySamplingDrop(String str, JSONObject jSONObject) {
        return this.eventSampling.isHitStickySamplingDrop(buildSamplingUser(), str, jSONObject);
    }

    public static SamplingFilter parseEventSamplingFromLocal(Engine engine, String str) {
        return new SamplingFilter(engine, EventSamplingLoader.parseEventSamplingFromLocal(engine.getContext(), str));
    }

    public static SamplingFilter parseEventSamplingFromServer(Engine engine, JSONObject jSONObject, SamplingFilter samplingFilter, String str) {
        if (jSONObject == null) {
            return samplingFilter;
        }
        if (samplingFilter == null) {
            return new SamplingFilter(engine, EventSamplingLoader.parseEventSamplingFromJson(engine.getContext(), str, jSONObject, null));
        }
        return new SamplingFilter(engine, EventSamplingLoader.parseEventSamplingFromJson(engine.getContext(), str, jSONObject, samplingFilter.getEventSampling()));
    }

    private AbsSamplingUser buildSamplingUser() {
        if (this.cachedUser != null) {
            return this.cachedUser;
        }
        this.cachedUser = new AbsSamplingUser() { // from class: com.bytedance.applog.filter.SamplingFilter.2
            @Override // com.bytedance.applog.sampling.AbsSamplingUser
            public String getAppIdCallback() {
                return SamplingFilter.this.engine.getAppLog().getAppId();
            }

            @Override // com.bytedance.applog.sampling.AbsSamplingUser
            public String getDeviceIdCallback() {
                return SamplingFilter.this.engine.getAppLog().getDid();
            }

            @Override // com.bytedance.applog.sampling.AbsSamplingUser
            public String getUserUniqueIdCallback() {
                return SamplingFilter.this.engine.getAppLog().getUserUniqueID();
            }

            @Override // com.bytedance.applog.sampling.AbsSamplingUser
            public String getUserIdCallback() {
                IBDAccountCallback bDAccountCallback = SamplingFilter.this.engine.getAppLog().getBDAccountCallback();
                if (bDAccountCallback == null) {
                    if (SamplingFilter.this.engine.getSession().getUserId() > 0) {
                        return String.valueOf(SamplingFilter.this.engine.getSession().getUserId());
                    }
                    return null;
                }
                Pair<Integer, Long> odinUserInfo = bDAccountCallback.getOdinUserInfo();
                if (((Long) odinUserInfo.second).longValue() <= 0) {
                    if (SamplingFilter.this.engine.getSession().sUserIsLoginFromResp == 0) {
                        return String.valueOf(SamplingFilter.this.engine.getSession().sUidFromResp);
                    }
                    return null;
                }
                return String.valueOf(odinUserInfo.second);
            }

            @Override // com.bytedance.applog.sampling.AbsSamplingUser
            public String getUserTypeCallback() {
                IBDAccountCallback bDAccountCallback = SamplingFilter.this.engine.getAppLog().getBDAccountCallback();
                if (bDAccountCallback == null) {
                    return null;
                }
                Pair<Integer, Long> odinUserInfo = bDAccountCallback.getOdinUserInfo();
                if (((Long) odinUserInfo.second).longValue() <= 0) {
                    if (SamplingFilter.this.engine.getSession().sUserIsLoginFromResp == 0) {
                        return String.valueOf(SamplingFilter.this.engine.getSession().sUserTypeFromResp);
                    }
                    return null;
                }
                return String.valueOf(odinUserInfo.first);
            }
        };
        return this.cachedUser;
    }
}
