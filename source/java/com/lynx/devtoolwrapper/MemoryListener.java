package com.lynx.devtoolwrapper;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MemoryListener {
    private CopyOnWriteArrayList<MemoryReporter> mMemoryReporters;

    /* loaded from: classes6.dex */
    public interface MemoryReporter {
        void uploadImageInfo(JSONObject jSONObject);
    }

    /* loaded from: classes6.dex */
    private static class MemoryListenerLoader {
        private static final MemoryListener INSTANCE = new MemoryListener();

        private MemoryListenerLoader() {
        }
    }

    private MemoryListener() {
        this.mMemoryReporters = new CopyOnWriteArrayList<>();
    }

    public static MemoryListener getInstance() {
        return MemoryListenerLoader.INSTANCE;
    }

    public void uploadImageInfo(JSONObject jSONObject) {
        Iterator<MemoryReporter> it = this.mMemoryReporters.iterator();
        while (it.hasNext()) {
            it.next().uploadImageInfo(jSONObject);
        }
    }

    public void addMemoryReporter(MemoryReporter memoryReporter) {
        this.mMemoryReporters.add(memoryReporter);
    }

    public void removeMemoryReporter(MemoryReporter memoryReporter) {
        this.mMemoryReporters.remove(memoryReporter);
    }

    public boolean hasAvailableReporter() {
        return !this.mMemoryReporters.isEmpty();
    }
}
