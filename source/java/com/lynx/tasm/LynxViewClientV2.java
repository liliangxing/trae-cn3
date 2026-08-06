package com.lynx.tasm;

import com.lynx.tasm.performance.IPerformanceObserver;
import com.lynx.tasm.performance.performanceobserver.PerformanceEntry;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class LynxViewClientV2 implements IPerformanceObserver {
    public void onPageStarted(LynxView lynxView, LynxPipelineInfo lynxPipelineInfo) {
    }

    public void onPerformanceEvent(PerformanceEntry performanceEntry) {
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class LynxPipelineInfo {
        private int pipelineOrigin;
        private final String url;

        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
        public enum LynxPipelineOrigin {
            LYNX_FIRST_SCREEN(1),
            LYNX_RELOAD(2);

            private final int origin;

            LynxPipelineOrigin(int i) {
                this.origin = i;
            }

            int getValue() {
                return this.origin;
            }
        }

        public LynxPipelineInfo(String str) {
            this.url = str;
        }

        public String getUrl() {
            return this.url;
        }

        public boolean isFromFirstScreen() {
            return (this.pipelineOrigin & LynxPipelineOrigin.LYNX_FIRST_SCREEN.getValue()) > 0;
        }

        public boolean isFromReload() {
            return (this.pipelineOrigin & LynxPipelineOrigin.LYNX_RELOAD.getValue()) > 0;
        }

        public void addPipelineOrigin(LynxPipelineOrigin lynxPipelineOrigin) {
            this.pipelineOrigin = lynxPipelineOrigin.getValue() | this.pipelineOrigin;
        }
    }
}
