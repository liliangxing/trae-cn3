package com.lynx.tasm;

import com.lynx.tasm.TemplateBundle;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.base.trace.TraceEventDef;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
class LynxEnginePool {
    private static final String TAG = "LynxEnginePool";
    private Map<TemplateBundle, LinkedList<LynxEngine>> mCache = new HashMap();

    LynxEnginePool() {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    private static class Holder {
        private static final LynxEnginePool INSTANCE = new LynxEnginePool();

        private Holder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LynxEnginePool getInstance() {
        return Holder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void registerReuseEngineWrapper(LynxEngine lynxEngine) {
        if (lynxEngine == null) {
            return;
        }
        LinkedList<LynxEngine> engineQueue = getEngineQueue(lynxEngine.getTemplateBundle());
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("engineQueue", engineQueue.toString());
            hashMap.put("registerEngine", String.valueOf(lynxEngine));
            hashMap.put("templateBundle", String.valueOf(lynxEngine.getTemplateBundle()));
            TraceEvent.beginSection(TraceEventDef.LYNX_ENGINE_POOL_REGISTER_ENGINE, hashMap);
        }
        synchronized (this) {
            if (!engineQueue.contains(lynxEngine)) {
                engineQueue.offer(lynxEngine);
            }
        }
        lynxEngine.setQueueRefFromPool(engineQueue);
        LLog.m2578i(TAG, "registerReuseEngineWrapper EngineQueue Cache: " + engineQueue + ", bundle:" + lynxEngine.getTemplateBundle());
        TraceEvent.endSection(TraceEventDef.LYNX_ENGINE_POOL_REGISTER_ENGINE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LynxEngine pollEngineFromPool(TemplateBundle templateBundle, ThreadStrategyForRendering threadStrategyForRendering) {
        LynxEngine lynxEngine;
        LinkedList<LynxEngine> engineQueue = getEngineQueue(templateBundle);
        LLog.m2578i(TAG, "pollEngine EngineQueue Cache: " + engineQueue + ", bundle:" + templateBundle);
        if (TraceEvent.isTracingStarted()) {
            HashMap hashMap = new HashMap();
            hashMap.put("engineQueue", engineQueue.toString());
            hashMap.put("templateBundle", String.valueOf(templateBundle));
            TraceEvent.beginSection(TraceEventDef.LYNX_ENGINE_POOL_POOL_ENGINE, hashMap);
        }
        synchronized (this) {
            LynxEngine lynxEngine2 = null;
            int i = 0;
            lynxEngine = null;
            while (true) {
                if (i >= engineQueue.size()) {
                    break;
                }
                LynxEngine lynxEngine3 = engineQueue.get(i);
                if (threadStrategyForRendering == lynxEngine3.getThreadStrategy() && lynxEngine3.tryBeReusing()) {
                    engineQueue.remove(i);
                    TraceEvent.endSection("pollEngineFromPool");
                    lynxEngine2 = lynxEngine3;
                    break;
                }
                if (lynxEngine3.canReused()) {
                    lynxEngine = lynxEngine3;
                }
                i++;
            }
            if (lynxEngine2 != null || lynxEngine == null || !lynxEngine.tryBeReusing()) {
                lynxEngine = lynxEngine2;
            }
        }
        TraceEvent.endSection(TraceEventDef.LYNX_ENGINE_POOL_POOL_ENGINE);
        return lynxEngine;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void delete(LynxEngine lynxEngine) {
        TemplateBundle templateBundle = lynxEngine.getTemplateBundle();
        if (templateBundle == null) {
            return;
        }
        LinkedList<LynxEngine> engineQueue = getEngineQueue(templateBundle);
        LLog.m2578i(TAG, "deleteEngine EngineQueue Cache: " + engineQueue + ", bundle:" + templateBundle);
        synchronized (this) {
            engineQueue.remove(lynxEngine);
        }
    }

    private synchronized LinkedList<LynxEngine> getEngineQueue(final TemplateBundle templateBundle) {
        final LinkedList<LynxEngine> linkedList;
        linkedList = this.mCache.get(templateBundle);
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            this.mCache.put(templateBundle, linkedList);
            templateBundle.setOnReleaseCallback(new TemplateBundle.OnReleaseCallback() { // from class: com.lynx.tasm.LynxEnginePool.1
                @Override // com.lynx.tasm.TemplateBundle.OnReleaseCallback
                public void onRelease() {
                    synchronized (LynxEnginePool.this) {
                        linkedList.clear();
                        LynxEnginePool.this.mCache.remove(templateBundle);
                    }
                }
            });
        }
        return linkedList;
    }
}
