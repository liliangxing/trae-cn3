package com.bytedance.fresco.sr;

/* loaded from: classes2.dex */
public class BmfSRParam {

    /* loaded from: classes2.dex */
    public @interface Algorithm {
        public static final int V4 = 4;
        public static final int V5 = 7;
        public static final int V6 = 8;
    }

    /* loaded from: classes2.dex */
    public @interface Backend {
        public static final int AUTO = 0;
        public static final int CPU = 1;
        public static final int DSP = 4;
        public static final int OPENCL = 2;
        public static final int OPENGL = 3;
    }

    /* loaded from: classes2.dex */
    public @interface BitmapOptimizeLevel {
        public static final int OPT_GET_HARDWARE_BUFFER = 1;
        public static final int OPT_NONE = 0;
        public static final int OPT_WRAP_HARDWARE_BUFFER = 2;
    }

    /* loaded from: classes2.dex */
    public @interface HWPlan {
        public static final int LIMIT = 1;
        public static final int NO_LIMIT = 0;
    }

    /* loaded from: classes2.dex */
    public @interface ScaleType {
        public static final int TYPE_1_1 = 4;
        public static final int TYPE_1_2 = 8;
        public static final int TYPE_1_3 = 16;
        public static final int TYPE_1_4 = 32;
        public static final int TYPE_1_5 = 1;
        public static final int TYPE_2 = 2;
        public static final int TYPE_ALL = 32768;
    }

    /* loaded from: classes2.dex */
    public @interface Stage {
        public static final int LITE = 1;
        public static final int MODS = 0;
    }
}
