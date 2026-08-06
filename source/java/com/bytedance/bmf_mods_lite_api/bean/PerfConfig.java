package com.bytedance.bmf_mods_lite_api.bean;

/* loaded from: classes3.dex */
public class PerfConfig {
    public static final int MEASURE_TOOL_DISJOINT_TIMER_FALLBACK_GL_FINISH = 2;
    public static final int MEASURE_TOOL_DISJOINT_TIMER_ONLY = 0;
    public static final int MEASURE_TOOL_GL_FINISH_ONLY = 1;
    public boolean isEnable = false;
    public int measureTool = 0;
    public int sampleFrameInterval = 300;
}
