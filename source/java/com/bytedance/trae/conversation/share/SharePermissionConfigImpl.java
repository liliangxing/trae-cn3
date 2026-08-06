package com.bytedance.trae.conversation.share;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.trae.common.widget.PermissionRationaleDialog;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.products.PermissionService;
import com.bytedance.trae.multilanguage.R;
import com.bytedance.ug.sdk.share.api.callback.RequestPermissionsCallback;
import com.bytedance.ug.sdk.share.api.depend.ISharePermissionConfig;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SharePermissionConfigImpl.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J3\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/share/SharePermissionConfigImpl;", "Lcom/bytedance/ug/sdk/share/api/depend/ISharePermissionConfig;", "<init>", "()V", "hasPermission", "", "context", "Landroid/content/Context;", "permission", "", "requestPermissions", "", "activity", "Landroid/app/Activity;", "permissions", "", "shareContent", "Lcom/bytedance/ug/sdk/share/api/entity/ShareContent;", "callback", "Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;", "(Landroid/app/Activity;[Ljava/lang/String;Lcom/bytedance/ug/sdk/share/api/entity/ShareContent;Lcom/bytedance/ug/sdk/share/api/callback/RequestPermissionsCallback;)V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class SharePermissionConfigImpl implements ISharePermissionConfig {
    public boolean hasPermission(Context context, String permission) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(permission, "permission");
        return ContextCompat.checkSelfPermission(context, permission) == 0;
    }

    public void requestPermissions(final Activity activity, final String[] permissions, ShareContent shareContent, final RequestPermissionsCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(shareContent, "shareContent");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (activity instanceof FragmentActivity) {
            PermissionRationaleDialog.INSTANCE.showForPermission(activity, C0591R.drawable.trae_ic_permission_file, R.string.trae_permission_storage_title, R.string.trae_permission_storage_message, R.string.trae_permission_allow, R.string.trae_permission_deny, new Function0() { // from class: com.bytedance.trae.conversation.share.SharePermissionConfigImpl$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit requestPermissions$lambda$1;
                    requestPermissions$lambda$1 = SharePermissionConfigImpl.requestPermissions$lambda$1(activity, permissions, callback);
                    return requestPermissions$lambda$1;
                }
            }, new Function0() { // from class: com.bytedance.trae.conversation.share.SharePermissionConfigImpl$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit requestPermissions$lambda$2;
                    requestPermissions$lambda$2 = SharePermissionConfigImpl.requestPermissions$lambda$2(callback);
                    return requestPermissions$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermissions$lambda$1(Activity activity, String[] strArr, final RequestPermissionsCallback requestPermissionsCallback) {
        PermissionService.INSTANCE.permission((FragmentActivity) activity, ArraysKt.toList(strArr), new Function1() { // from class: com.bytedance.trae.conversation.share.SharePermissionConfigImpl$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit requestPermissions$lambda$1$lambda$0;
                requestPermissions$lambda$1$lambda$0 = SharePermissionConfigImpl.requestPermissions$lambda$1$lambda$0(requestPermissionsCallback, ((Boolean) obj).booleanValue());
                return requestPermissions$lambda$1$lambda$0;
            }
        });
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermissions$lambda$1$lambda$0(RequestPermissionsCallback requestPermissionsCallback, boolean z) {
        if (z) {
            requestPermissionsCallback.onGranted();
        } else {
            requestPermissionsCallback.onDenied("");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestPermissions$lambda$2(RequestPermissionsCallback requestPermissionsCallback) {
        requestPermissionsCallback.onDenied("");
        return Unit.INSTANCE;
    }
}
