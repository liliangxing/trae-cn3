package com.bytedance.ies.bullet.p003ui.common;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.bytedance.ies.bullet.core.container.IBulletActivityDelegate;
import com.bytedance.ies.bullet.service.base.YieldError;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BaseBulletActivityDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J5\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010!\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/BaseBulletActivityDelegate;", "Lcom/bytedance/ies/bullet/core/container/IBulletActivityDelegate;", "()V", "onActivityResult", "", "activity", "Landroid/app/Activity;", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(Landroid/app/Activity;I[Ljava/lang/String;[I)V", "onRestoreInstanceState", "onResume", "onSaveInstanceState", "outState", "onStart", "onStop", "onWindowFocusChanged", "hasFocus", "", "shouldInterceptBackPressedEvent", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class BaseBulletActivityDelegate implements IBulletActivityDelegate {
    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onConfigurationChanged(Activity activity, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onRequestPermissionsResult(Activity activity, int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        throw new YieldError("An operation is not implemented");
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onCreate(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onStart(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onResume(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onPause(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onStop(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onDestroy(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onSaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onRestoreInstanceState(Activity activity, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onWindowFocusChanged(Activity activity, boolean hasFocus) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public void onActivityResult(Activity activity, int requestCode, int resultCode, Intent data) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new YieldError("An operation is not implemented");
    }

    @Override // com.bytedance.ies.bullet.core.container.IBulletActivityDelegate
    public boolean shouldInterceptBackPressedEvent(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        throw new YieldError("An operation is not implemented");
    }
}
