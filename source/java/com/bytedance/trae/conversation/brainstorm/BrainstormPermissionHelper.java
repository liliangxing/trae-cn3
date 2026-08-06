package com.bytedance.trae.conversation.brainstorm;

import android.content.Context;
import android.util.Log;
import androidx.activity.result.ActivityResultLauncher;
import androidx.core.content.ContextCompat;
import com.bytedance.trae.common.widget.PermissionRationaleDialog;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.multilanguage.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BrainstormPermissionHelper.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tJ@\u0010\n\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000e0\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/BrainstormPermissionHelper;", "", "<init>", "()V", "TAG", "", "getUngrantedPermissions", "", "context", "Landroid/content/Context;", "requestPermissions", "", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "", "onAllGranted", "Lkotlin/Function0;", "onDeny", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormPermissionHelper {
    public static final BrainstormPermissionHelper INSTANCE = new BrainstormPermissionHelper();
    private static final String TAG = "BrainstormPermission";

    private BrainstormPermissionHelper() {
    }

    public final List<String> getUngrantedPermissions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        if (ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") != 0) {
            arrayList.add("android.permission.RECORD_AUDIO");
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestPermissions$default(BrainstormPermissionHelper brainstormPermissionHelper, Context context, ActivityResultLauncher activityResultLauncher, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 8) != 0) {
            function02 = new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormPermissionHelper$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            };
        }
        brainstormPermissionHelper.requestPermissions(context, activityResultLauncher, function0, function02);
    }

    public final void requestPermissions(Context context, final ActivityResultLauncher<String[]> launcher, Function0<Unit> onAllGranted, Function0<Unit> onDeny) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        Intrinsics.checkNotNullParameter(onAllGranted, "onAllGranted");
        Intrinsics.checkNotNullParameter(onDeny, "onDeny");
        final List<String> ungrantedPermissions = getUngrantedPermissions(context);
        if (ungrantedPermissions.isEmpty()) {
            Log.d(TAG, "requestPermissions: all permissions already granted");
            onAllGranted.invoke();
            return;
        }
        Log.d(TAG, "requestPermissions: need to request " + ungrantedPermissions);
        if (ungrantedPermissions.contains("android.permission.RECORD_AUDIO")) {
            PermissionRationaleDialog.INSTANCE.showForPermission(context, C0591R.drawable.trae_ic_permission_microphone, R.string.trae_permission_microphone_title, R.string.trae_permission_microphone_message, R.string.trae_permission_allow, R.string.trae_permission_deny, new Function0() { // from class: com.bytedance.trae.conversation.brainstorm.BrainstormPermissionHelper$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit requestPermissions$lambda$1;
                    requestPermissions$lambda$1 = BrainstormPermissionHelper.requestPermissions$lambda$1(launcher, ungrantedPermissions);
                    return requestPermissions$lambda$1;
                }
            }, onDeny);
        } else {
            launcher.launch(ungrantedPermissions.toArray(new String[0]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermissions$lambda$1(ActivityResultLauncher activityResultLauncher, List list) {
        activityResultLauncher.launch(list.toArray(new String[0]));
        return Unit.INSTANCE;
    }
}
