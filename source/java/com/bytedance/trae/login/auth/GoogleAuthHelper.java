package com.bytedance.trae.login.auth;

import android.app.Activity;
import android.content.Intent;
import com.lynx.tasm.DefaultLogicExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GoogleAuthHelper.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J \u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0006\u0010\u0011\u001a\u00020\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/login/auth/GoogleAuthHelper;", "", "<init>", "()V", "initIfNeeded", "", "activity", "Landroid/app/Activity;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "getSignInIntent", "parseSignInResult", "Lcom/bytedance/trae/login/auth/GoogleAuthInfo;", DefaultLogicExecutor.LIFECYCLE_EVENT_ON_DESTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GoogleAuthHelper {
    public static final GoogleAuthHelper INSTANCE = new GoogleAuthHelper();

    public final Intent getSignInIntent(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return null;
    }

    public final void initIfNeeded(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public final void onDestroy() {
    }

    public final GoogleAuthInfo parseSignInResult(Intent data) {
        return null;
    }

    private GoogleAuthHelper() {
    }
}
