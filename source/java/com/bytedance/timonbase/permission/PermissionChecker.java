package com.bytedance.timonbase.permission;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.AppOpsManagerCompat;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PermissionChecker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0014B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u001e\u0010\u0012\u001a\u00020\u00132\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\nj\u0002`\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\nj\u0004\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/bytedance/timonbase/permission/PermissionChecker;", "", "()V", "PERMISSION_DENIED", "", "PERMISSION_DENIED_APP_OP", "PERMISSION_EMPTY", "PERMISSION_GRANTED", "PERMISSION_UNKNOWN", "reference", "Lkotlin/Function1;", "", "Lcom/bytedance/timonbase/scene/PermissionCheckerReference;", "checkSelfPermission", "context", "Landroid/content/Context;", "permission", "checkSelfPermissionInner", "registerPermissionCheckerReference", "", RXScreenCaptureService.KEY_RESULT_DATA, "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes5.dex */
public final class PermissionChecker {
    public static final PermissionChecker INSTANCE = new PermissionChecker();
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_EMPTY = -4;
    public static final int PERMISSION_GRANTED = 0;
    public static final int PERMISSION_UNKNOWN = -3;
    private static Function1<? super String, Integer> reference;

    /* compiled from: PermissionChecker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/timonbase/permission/PermissionChecker$PermissionResult;", "", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes5.dex */
    public @interface PermissionResult {
    }

    private PermissionChecker() {
    }

    public final void registerPermissionCheckerReference(Function1<? super String, Integer> reference2) {
        Intrinsics.checkParameterIsNotNull(reference2, "reference");
        reference = reference2;
    }

    public final int checkSelfPermission(Context context, String permission) {
        Integer invoke;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(permission, "permission");
        if (TextUtils.isEmpty(permission)) {
            return 0;
        }
        Function1<? super String, Integer> function1 = reference;
        return (function1 == null || (invoke = function1.invoke(permission)) == null) ? checkSelfPermissionInner(context, permission) : invoke.intValue();
    }

    private final int checkSelfPermissionInner(Context context, String permission) {
        int checkOpNoThrow;
        if (TextUtils.isEmpty(permission)) {
            return 0;
        }
        if (context.checkPermission(permission, Process.myPid(), Process.myUid()) == -1) {
            return -1;
        }
        String permissionToOp = AppOpsManagerCompat.permissionToOp(permission);
        if (permissionToOp != null) {
            Intrinsics.checkExpressionValueIsNotNull(permissionToOp, "AppOpsManagerCompat.perm…return PERMISSION_GRANTED");
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            if (appOpsManager != null) {
                if (Build.VERSION.SDK_INT >= 29) {
                    checkOpNoThrow = appOpsManager.unsafeCheckOpNoThrow(permissionToOp, Process.myUid(), context.getPackageName());
                } else {
                    checkOpNoThrow = appOpsManager.checkOpNoThrow(permissionToOp, Process.myUid(), context.getPackageName());
                }
                if (checkOpNoThrow != 0) {
                    return -2;
                }
            }
        }
        return 0;
    }
}
