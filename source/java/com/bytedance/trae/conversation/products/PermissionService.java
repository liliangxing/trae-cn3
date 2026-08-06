package com.bytedance.trae.conversation.products;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.trae.conversation.products.PermissionService;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionService.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/products/PermissionService;", "", "<init>", "()V", "TAG_PERMISSION_FRAGMENT", "", "permission", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "permissions", "", "callback", "Lkotlin/Function1;", "", "PermissionFragment", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class PermissionService {
    public static final PermissionService INSTANCE = new PermissionService();
    private static final String TAG_PERMISSION_FRAGMENT = "PermissionServiceFragment";

    private PermissionService() {
    }

    public final void permission(FragmentActivity activity, List<String> permissions, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(callback, "callback");
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
        Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(TAG_PERMISSION_FRAGMENT);
        PermissionFragment permissionFragment = findFragmentByTag instanceof PermissionFragment ? (PermissionFragment) findFragmentByTag : null;
        if (permissionFragment != null) {
            supportFragmentManager.beginTransaction().remove(permissionFragment).commitNowAllowingStateLoss();
        }
        supportFragmentManager.beginTransaction().add(PermissionFragment.INSTANCE.newInstance(permissions, callback), TAG_PERMISSION_FRAGMENT).commitNowAllowingStateLoss();
    }

    /* compiled from: PermissionService.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000f\u001a\u00020\u0007H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "callback", "Lkotlin/Function1;", "", "", "permissions", "", "", "launched", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "", "onResume", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class PermissionFragment extends Fragment {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private Function1<? super Boolean, Unit> callback;
        private boolean launched;
        private final ActivityResultLauncher<String[]> launcher;
        private List<String> permissions = CollectionsKt.emptyList();

        public PermissionFragment() {
            ActivityResultLauncher<String[]> registerForActivityResult = registerForActivityResult((ActivityResultContract) new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.bytedance.trae.conversation.products.PermissionService$PermissionFragment$$ExternalSyntheticLambda0
                public final void onActivityResult(Object obj) {
                    PermissionService.PermissionFragment.launcher$lambda$1(PermissionService.PermissionFragment.this, (Map) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(registerForActivityResult, "registerForActivityResult(...)");
            this.launcher = registerForActivityResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void launcher$lambda$1(PermissionFragment permissionFragment, Map map) {
            Collection values = map.values();
            boolean z = true;
            if (!(values instanceof Collection) || !values.isEmpty()) {
                Iterator it = values.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (!((Boolean) it.next()).booleanValue()) {
                        z = false;
                        break;
                    }
                }
            }
            Function1<? super Boolean, Unit> function1 = permissionFragment.callback;
            if (function1 != null) {
                function1.invoke(Boolean.valueOf(z));
            }
            permissionFragment.callback = null;
            permissionFragment.getParentFragmentManager().beginTransaction().remove(permissionFragment).commitAllowingStateLoss();
        }

        public void onResume() {
            super.onResume();
            if (this.launched || !(!this.permissions.isEmpty())) {
                return;
            }
            this.launched = true;
            this.launcher.launch(this.permissions.toArray(new String[0]));
        }

        /* compiled from: PermissionService.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment$Companion;", "", "<init>", "()V", "newInstance", "Lcom/bytedance/trae/conversation/products/PermissionService$PermissionFragment;", "permissions", "", "", "callback", "Lkotlin/Function1;", "", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final PermissionFragment newInstance(List<String> permissions, Function1<? super Boolean, Unit> callback) {
                Intrinsics.checkNotNullParameter(permissions, "permissions");
                Intrinsics.checkNotNullParameter(callback, "callback");
                PermissionFragment permissionFragment = new PermissionFragment();
                permissionFragment.permissions = permissions;
                permissionFragment.callback = callback;
                return permissionFragment;
            }
        }
    }
}
