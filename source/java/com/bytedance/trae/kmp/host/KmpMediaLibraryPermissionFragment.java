package com.bytedance.trae.kmp.host;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidKmpMediaLibraryHandler.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J-\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u000e\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0011R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "", "requestPermission", "", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class KmpMediaLibraryPermissionFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int REQUEST_CODE = 4107;
    private static final String TAG = "KmpMediaLibraryPermission";
    private CancellableContinuation<? super Boolean> continuation;

    public final void requestPermission(final CancellableContinuation<? super Boolean> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        if (!(this.continuation == null)) {
            throw new IllegalStateException("Storage permission request is already running".toString());
        }
        this.continuation = continuation;
        continuation.invokeOnCancellation(new Function1() { // from class: com.bytedance.trae.kmp.host.KmpMediaLibraryPermissionFragment$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit requestPermission$lambda$1;
                requestPermission$lambda$1 = KmpMediaLibraryPermissionFragment.requestPermission$lambda$1(KmpMediaLibraryPermissionFragment.this, continuation, (Throwable) obj);
                return requestPermission$lambda$1;
            }
        });
        requestPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, REQUEST_CODE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermission$lambda$1(KmpMediaLibraryPermissionFragment kmpMediaLibraryPermissionFragment, CancellableContinuation cancellableContinuation, Throwable th) {
        if (kmpMediaLibraryPermissionFragment.continuation == cancellableContinuation) {
            kmpMediaLibraryPermissionFragment.continuation = null;
        }
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Deprecated by Android SDK")
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Continuation continuation;
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE && (continuation = this.continuation) != null) {
            this.continuation = null;
            if (continuation.isActive()) {
                Continuation continuation2 = continuation;
                Integer firstOrNull = ArraysKt.firstOrNull(grantResults);
                Boolean valueOf = Boolean.valueOf(firstOrNull != null && firstOrNull.intValue() == 0);
                Result.Companion companion = Result.Companion;
                continuation2.resumeWith(Result.constructor-impl(valueOf));
            }
        }
    }

    /* compiled from: AndroidKmpMediaLibraryHandler.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/kmp/host/KmpMediaLibraryPermissionFragment$Companion;", "", "<init>", "()V", "TAG", "", "REQUEST_CODE", "", "request", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object request(FragmentActivity fragmentActivity, Continuation<? super Boolean> continuation) {
            return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new KmpMediaLibraryPermissionFragment$Companion$request$2(fragmentActivity, null), continuation);
        }
    }
}
