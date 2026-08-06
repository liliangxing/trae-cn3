package com.bytedance.pia.core.api.resource;

import com.bytedance.pia.core.api.context.IContainerContext;
import com.bytedance.pia.core.api.utils.IConsumer;
import java.util.Map;

/* loaded from: classes4.dex */
public interface IPiaPreloader {
    public static final IPiaPreloader EMPTY = new IPiaPreloader() { // from class: com.bytedance.pia.core.api.resource.IPiaPreloader.1
        @Override // com.bytedance.pia.core.api.resource.IPiaPreloader
        public void preload(String str, Map<String, ?> map) {
        }

        @Override // com.bytedance.pia.core.api.resource.IPiaPreloader
        public void setPerfListener(IConsumer<PerfInfo> iConsumer) {
        }
    };

    void preload(String str, Map<String, ?> map);

    void setPerfListener(IConsumer<PerfInfo> iConsumer);

    /* loaded from: classes4.dex */
    public static class PerfInfo {
        private final long preloadEnd;
        private final long preloadStart;
        private final String url;

        public PerfInfo(String str, long j, long j2) {
            this.url = str;
            this.preloadStart = j;
            this.preloadEnd = j2;
        }

        public long getPreloadStart() {
            return this.preloadStart;
        }

        public long getPreloadEnd() {
            return this.preloadEnd;
        }

        public String getUrl() {
            return this.url;
        }
    }

    static IPiaPreloader get(Object obj) {
        IPiaPreloader iPiaPreloader = obj instanceof IContainerContext ? (IPiaPreloader) ((IContainerContext) obj).get(IPiaPreloader.class) : null;
        return iPiaPreloader == null ? EMPTY : iPiaPreloader;
    }
}
