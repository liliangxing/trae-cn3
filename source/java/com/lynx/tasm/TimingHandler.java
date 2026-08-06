package com.lynx.tasm;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class TimingHandler {
    public static final String CONTAINER_INIT_END = "containerInitEnd";
    public static final String CONTAINER_INIT_START = "containerInitStart";
    public static final String CREATE_LYNX_END = "createLynxEnd";
    public static final String CREATE_LYNX_START = "createLynxStart";
    public static final String OPEN_TIME = "openTime";
    public static final String PREPARE_TEMPLATE_END = "prepareTemplateEnd";
    public static final String PREPARE_TEMPLATE_START = "prepareTemplateStart";

    /* loaded from: classes6.dex */
    public static class ExtraTimingInfo {
        public long mOpenTime = 0;
        public long mContainerInitStart = 0;
        public long mContainerInitEnd = 0;
        public long mPrepareTemplateStart = 0;
        public long mPrepareTemplateEnd = 0;

        public Map<String, Long> toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put(TimingHandler.OPEN_TIME, Long.valueOf(this.mOpenTime));
            hashMap.put(TimingHandler.CONTAINER_INIT_START, Long.valueOf(this.mContainerInitStart));
            hashMap.put(TimingHandler.CONTAINER_INIT_END, Long.valueOf(this.mContainerInitEnd));
            hashMap.put(TimingHandler.PREPARE_TEMPLATE_START, Long.valueOf(this.mPrepareTemplateStart));
            hashMap.put(TimingHandler.PREPARE_TEMPLATE_END, Long.valueOf(this.mPrepareTemplateEnd));
            return hashMap;
        }
    }
}
