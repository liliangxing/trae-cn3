package com.bytedance.android.anniex.detect.detection;

import kotlin.Metadata;

/* compiled from: DetectionConstants.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/anniex/detect/detection/DetectionConstants;", "", "()V", "BDX_MONITOR_BLANK_DETECT_RESULT", "", "BDX_MONITOR_MODEL_EXECUTE_RESULT", "DETECT_SUCCESS", "", "PARTIAL_BLANK", "PARTIAL_BLANK_TIME_OUT", "PURE_BLANK", "PURE_BLANK_TIME_OUT", "RENDER_TYPE_ERROR_PARTIAL", "RENDER_TYPE_ERROR_PURE", "RESOLUTION_360", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class DetectionConstants {
    public static final String BDX_MONITOR_BLANK_DETECT_RESULT = "bdx_monitor_anniex_blank_detect_result";
    public static final String BDX_MONITOR_MODEL_EXECUTE_RESULT = "bdx_monitor_anniex_model_execute_result";
    public static final int DETECT_SUCCESS = 200;
    public static final DetectionConstants INSTANCE = new DetectionConstants();
    public static final int PARTIAL_BLANK = 1003;
    public static final int PARTIAL_BLANK_TIME_OUT = 1004;
    public static final int PURE_BLANK = 1000;
    public static final int PURE_BLANK_TIME_OUT = 1002;
    public static final String RENDER_TYPE_ERROR_PARTIAL = "partial_blank";
    public static final String RENDER_TYPE_ERROR_PURE = "pure_blank";
    public static final float RESOLUTION_360 = 360.0f;

    private DetectionConstants() {
    }
}
