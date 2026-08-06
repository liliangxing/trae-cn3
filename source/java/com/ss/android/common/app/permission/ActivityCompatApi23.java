package com.ss.android.common.app.permission;

import android.app.Activity;
import androidx.core.app.ActivityCompat;

/* loaded from: classes7.dex */
public class ActivityCompatApi23 {

    /* loaded from: classes7.dex */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
        } else if (activity instanceof ActivityCompat.RequestPermissionsRequestCodeValidator) {
            ((ActivityCompat.RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i);
        }
        activity.requestPermissions(strArr, i);
    }
}
