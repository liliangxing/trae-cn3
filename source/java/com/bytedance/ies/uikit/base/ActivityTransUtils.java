package com.bytedance.ies.uikit.base;

import android.app.Activity;
import com.bytedance.ugc.uikit.C1158R;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class ActivityTransUtils {
    public static final int TYPE_ACTIVITY_TRANS_NONE = 1;
    public static final int TYPE_ACTIVITY_TRANS_NORMAL = 0;
    public static final int TYPE_ACTIVITY_TRANS_RTL = 3;
    public static final int TYPE_ACTIVITY_TRANS_VIDEO = 2;
    public static int SLIDE_IN_LEFT_NORMAL = C1158R.anim.slide_in_left;
    public static int SLIDE_OUT_RIGHT_NORMAL = C1158R.anim.slide_out_right;
    public static int SLIDE_IN_RIGHT_NORMAL = C1158R.anim.slide_in_right;
    public static int SLIDE_OUT_LEFT_NORMAL = C1158R.anim.slide_out_left;
    public static int SLIDE_IN_LEFT_VIDEO = C1158R.anim.slide_in_left_top;
    public static int SLIDE_OUT_RIGHT_VIDEO = C1158R.anim.slide_out_right_bottom;
    public static int SLIDE_IN_RIGHT_VIDEO = C1158R.anim.slide_in_right_bottom;
    public static int SLIDE_OUT_LEFT_VIDEO = C1158R.anim.slide_out_left_top;
    public static int SLIDE_IN_LEFT_NONE = 0;
    public static int SLIDE_OUT_RIGHT_NONE = 0;
    public static int SLIDE_IN_RIGHT_NONE = 0;
    public static int SLIDE_OUT_LEFT_NONE = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static void startActivityAnim(Activity activity, int i) {
        int i2;
        int i3;
        if (activity == 0) {
            return;
        }
        if (i == 0) {
            i2 = SLIDE_IN_RIGHT_NORMAL;
            i3 = SLIDE_OUT_LEFT_NORMAL;
        } else if (i == 1) {
            i2 = SLIDE_IN_RIGHT_NONE;
            i3 = SLIDE_OUT_LEFT_NONE;
        } else if (i == 2) {
            i2 = SLIDE_IN_RIGHT_VIDEO;
            i3 = SLIDE_OUT_LEFT_VIDEO;
        } else if (i == 3) {
            i2 = SLIDE_IN_LEFT_NORMAL;
            i3 = SLIDE_OUT_RIGHT_NORMAL;
        } else {
            i2 = SLIDE_IN_RIGHT_NORMAL;
            i3 = SLIDE_OUT_LEFT_NORMAL;
        }
        if (activity instanceof SSActivity) {
            ((SSActivity) activity).superOverridePendingTransition(i2, i3);
        } else {
            activity.overridePendingTransition(i2, i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void finishActivityAnim(Activity activity, int i) {
        int i2;
        int i3;
        if (activity == 0) {
            return;
        }
        if (i == 0) {
            i2 = SLIDE_IN_LEFT_NORMAL;
            i3 = SLIDE_OUT_RIGHT_NORMAL;
        } else if (i == 1) {
            i2 = SLIDE_IN_LEFT_NONE;
            i3 = SLIDE_OUT_RIGHT_NONE;
        } else if (i == 2) {
            i2 = SLIDE_IN_LEFT_VIDEO;
            i3 = SLIDE_OUT_RIGHT_VIDEO;
        } else if (i == 3) {
            i2 = SLIDE_IN_RIGHT_NORMAL;
            i3 = SLIDE_OUT_LEFT_NORMAL;
        } else {
            i2 = SLIDE_IN_LEFT_NORMAL;
            i3 = SLIDE_OUT_RIGHT_NORMAL;
        }
        if (activity instanceof SSActivity) {
            ((SSActivity) activity).superOverridePendingTransition(i2, i3);
        } else {
            activity.overridePendingTransition(i2, i3);
        }
    }
}
