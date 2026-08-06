package bytedance.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes2.dex */
class SAFUtils {
    public static final int OPEN_FILE_REQUEST_CODE = 1;
    public static final int OPEN_FOLDER_REQUEST_CODE = 2;
    public static final int PICK_FILE_CODE = 4;

    /* loaded from: classes2.dex */
    interface TaskCallback {
        void onResult(boolean z, Uri uri);
    }

    SAFUtils() {
    }

    public static void openFile(Activity activity, int i, TaskCallback taskCallback) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("*/*");
        activity.startActivityForResult(intent, 1);
    }
}
