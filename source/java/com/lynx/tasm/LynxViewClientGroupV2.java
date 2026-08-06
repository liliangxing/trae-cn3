package com.lynx.tasm;

import com.lynx.tasm.LynxViewClientV2;
import com.lynx.tasm.performance.performanceobserver.PerformanceEntry;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxViewClientGroupV2 extends LynxViewClientV2 {
    private CopyOnWriteArrayList<LynxViewClientV2> mClients = new CopyOnWriteArrayList<>();
    private int mInstanceId = -1;

    public void setInstanceId(int i) {
        this.mInstanceId = i;
    }

    public void addClient(LynxViewClientV2 lynxViewClientV2) {
        if (lynxViewClientV2 == null || this.mClients.contains(lynxViewClientV2)) {
            return;
        }
        this.mClients.add(lynxViewClientV2);
    }

    public void removeClient(LynxViewClientV2 lynxViewClientV2) {
        this.mClients.remove(lynxViewClientV2);
    }

    @Override // com.lynx.tasm.LynxViewClientV2
    public void onPageStarted(LynxView lynxView, LynxViewClientV2.LynxPipelineInfo lynxPipelineInfo) {
        Iterator<LynxViewClientV2> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onPageStarted(lynxView, lynxPipelineInfo);
        }
    }

    @Override // com.lynx.tasm.LynxViewClientV2
    public void onPerformanceEvent(PerformanceEntry performanceEntry) {
        Iterator<LynxViewClientV2> it = this.mClients.iterator();
        while (it.hasNext()) {
            it.next().onPerformanceEvent(performanceEntry);
        }
    }
}
