package com.bytedance.applog.engine;

import com.bytedance.applog.IHeaderCustomTimelyCallback;
import com.bytedance.applog.forward.EventForward;
import com.bytedance.applog.log.EventBus;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LogUtils;
import com.bytedance.applog.manager.DeviceManager;
import com.bytedance.applog.monitor.p006v3.StatsCountKeys;
import com.bytedance.applog.store.DbStore;
import com.bytedance.applog.store.ForwardEvent;
import com.bytedance.applog.store.Pack;
import com.bytedance.applog.util.SensitiveUtils;
import com.bytedance.ies.argus.bean.ArgusConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ForwardSender extends BaseWorker {
    private static final List<String> logTags = Collections.singletonList("ForwardSender");
    private final EventForward mEventForward;

    @Override // com.bytedance.applog.engine.BaseWorker
    protected String getName() {
        return "ForwardSender";
    }

    @Override // com.bytedance.applog.engine.BaseWorker
    protected boolean needNet() {
        return true;
    }

    public ForwardSender(Engine engine, EventForward eventForward) {
        super(engine);
        this.mEventForward = eventForward;
    }

    @Override // com.bytedance.applog.engine.BaseWorker
    protected long nextInterval() {
        EventForward eventForward = this.mEventForward;
        if (eventForward != null) {
            return eventForward.getInterval();
        }
        return this.mEngine.getConfig().getEventInterval();
    }

    @Override // com.bytedance.applog.engine.BaseWorker
    protected long[] getRetryIntervals() {
        return RETRY_SAME;
    }

    @Override // com.bytedance.applog.engine.BaseWorker
    public synchronized boolean doWork(int i) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        Session session = this.mEngine.getSession();
        IAppLogLogger logger = getAppLog().getLogger();
        List<String> list = logTags;
        Object[] objArr = new Object[4];
        z = false;
        objArr[0] = getName();
        objArr[1] = Long.valueOf(currentTimeMillis);
        objArr[2] = session != null ? session.getId() : ArgusConstants.NULL_PLACE_HOLDER;
        objArr[3] = Integer.valueOf(i);
        logger.debug(list, "{} start doWork curTs={}, curSid={}, requestFrom={}", objArr);
        DbStore dbStore = this.mEngine.getDbStore();
        DeviceManager dm = this.mEngine.getDm();
        if (dm.isValidDidAndIid() && this.mEventForward != null) {
            JSONObject transferHeader = SensitiveUtils.transferHeader(dm.getCopiedHeader());
            IHeaderCustomTimelyCallback headerCustomCallback = getAppLog().getHeaderCustomCallback();
            if (headerCustomCallback != null) {
                try {
                    headerCustomCallback.updateHeader(transferHeader);
                } catch (Throwable th) {
                    getAppLog().getMonitorHelper().increaseStats(StatsCountKeys.PACK_ERROR_COUNT);
                    getAppLog().getMonitorHelper().sendError("HeaderCustomTimelyCallback update header failed", th);
                    getAppLog().getLogger().error(logTags, "header custom callback updateHeader error", th, new Object[0]);
                }
            }
            List<ForwardEvent> queryForwardEvents = dbStore.queryForwardEvents();
            if (queryForwardEvents != null && !queryForwardEvents.isEmpty()) {
                dbStore.deleteForwardEvents(queryForwardEvents);
                trySendPack(queryForwardEvents, transferHeader, i);
            }
            z = true;
        }
        return z;
    }

    private void trySendPack(List<ForwardEvent> list, JSONObject jSONObject, int i) {
        boolean z;
        if (this.mEventForward == null) {
            return;
        }
        Iterator<ForwardEvent> it = list.iterator();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        while (true) {
            z = true;
            if (!it.hasNext()) {
                break;
            }
            JSONArray jSONArray = new JSONArray();
            Pack pack = new Pack();
            pack.setData(getAppLog().getAppId(), jSONObject, null, null, null, new JSONArray[]{null, jSONArray, null}, new long[]{0, 0, 0}, null, null, i);
            while (it.hasNext()) {
                ForwardEvent next = it.next();
                jSONArray.put(next.toPackJson());
                if (!LogUtils.isDisabled() && next.eventId > 0) {
                    hashSet.add(Long.valueOf(next.eventId));
                }
                if (jSONArray.length() == 200) {
                    break;
                }
            }
            pack.toBytes();
            arrayList.add(pack);
        }
        String encryptSendLogUri = getAppLog().getApiParamsUtil().encryptSendLogUri(getAppLog().getContext(), this.mEventForward.getUri());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            z &= getAppLog().getApi().trySendForward(encryptSendLogUri, (Pack) it2.next(), getAppLog().getEventForwardHttpHeaders());
        }
        sendPackUpload2Devtools(this.mEngine.getAppLog().getAppId(), hashSet, z);
    }

    private void sendPackUpload2Devtools(final String str, final Set<Long> set, final boolean z) {
        if (LogUtils.isDisabled() || set == null || set.isEmpty()) {
            return;
        }
        LogUtils.sendJsonFetcher("event_upload_eid", new EventBus.DataFetcher() { // from class: com.bytedance.applog.engine.ForwardSender.1
            @Override // com.bytedance.applog.log.EventBus.DataFetcher
            public Object fetch() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("$$APP_ID", str);
                    JSONArray jSONArray = new JSONArray();
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        jSONArray.put((Long) it.next());
                    }
                    jSONObject.put("$$EVENT_LOCAL_ID_ARRAY", jSONArray);
                    jSONObject.put("$$UPLOAD_STATUS", z ? "success" : "failed");
                } catch (JSONException unused) {
                }
                return jSONObject;
            }
        });
    }
}
