package com.bytedance.trae.init.task;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
import com.bytedance.trae.common.apphost.AppHost;
import com.bytedance.trae.im.database.DatabaseManager;
import com.bytedance.trae.login.api.ForceLogoutUtils;
import kotlin.Metadata;

/* compiled from: InitAccountTask.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/bytedance/trae/init/task/InitAccountTask$runInternal$1", "Lcom/bytedance/trae/login/api/ForceLogoutUtils$OnLogoutListener;", "onLogout", "", "navigateToLogin", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class InitAccountTask$runInternal$1 implements ForceLogoutUtils.OnLogoutListener {
    public void onLogout() {
        DatabaseManager.INSTANCE.onUserLogout();
    }

    public void navigateToLogin() {
        final Activity currentActivity = AppHost.INSTANCE.getActivityStackManager().getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.bytedance.trae.init.task.InitAccountTask$runInternal$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InitAccountTask$runInternal$1.navigateToLogin$lambda$0(currentActivity);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void navigateToLogin$lambda$0(Activity activity) {
        Activity activity2 = activity;
        Toast.makeText(activity2, 2131689845, 1).show();
        Intent intent = new Intent();
        intent.setClassName(activity2, "com.bytedance.trae.login.activity.AccountLoginActivity");
        intent.setFlags(268468224);
        activity.startActivity(intent);
    }
}
