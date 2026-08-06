package com.bytedance.ies.bullet.core.container;

import android.app.Activity;
import android.content.Intent;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.forest.model.Timing;
import com.bytedance.push.proxy.ActivityTaskManagerHooker;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletActivityWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u0007H&J\b\u0010\u000b\u001a\u00020\u0007H&J\n\u0010\f\u001a\u0004\u0018\u00010\rH&J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0015H&J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0013H&J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ies/bullet/core/container/IBulletActivityWrapper;", "Lcom/bytedance/ies/bullet/core/container/IBulletActivityDelegate;", "delegates", "", "getDelegates", "()Ljava/util/List;", "bind", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "doBackPress", Timing.SUFFIX_FINISH, "getActivity", "Landroid/app/Activity;", "registerDelegate", "delegate", "registerDelegateAtFirst", "setResult", "resultCode", "", "data", "Landroid/content/Intent;", ActivityTaskManagerHooker.METHOD_START_ACTIVITY, "intent", "startActivityForResult", "requestCode", "unregisterDelegate", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IBulletActivityWrapper extends IBulletActivityDelegate {

    /* compiled from: BulletActivityWrapper.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class DefaultImpls {
        public static void registerDelegateAtFirst(IBulletActivityWrapper iBulletActivityWrapper, IBulletActivityDelegate delegate) {
            Intrinsics.checkNotNullParameter(delegate, "delegate");
        }
    }

    void bind(LifecycleOwner lifecycleOwner);

    void doBackPress();

    void finish();

    Activity getActivity();

    List<IBulletActivityDelegate> getDelegates();

    void registerDelegate(IBulletActivityDelegate delegate);

    void registerDelegateAtFirst(IBulletActivityDelegate delegate);

    void setResult(int resultCode);

    void setResult(int resultCode, Intent data);

    void startActivity(Intent intent);

    void startActivityForResult(Intent intent, int requestCode);

    void unregisterDelegate(IBulletActivityDelegate delegate);
}
