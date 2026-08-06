package com.bytedance.android.standard.tools.p001ui;

import android.view.View;
import android.widget.Button;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.applog.server.Api;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AccessibilityUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"setAccessibilityClassName", "", "Landroid/view/View;", "className", "", "setAccessibilityHeading", "setAccessibilityOptions", Api.KEY_OPTIONS, "Lcom/bytedance/android/standard/tools/ui/AccessibilityOptions;", "setContentDescriptionAndButton", "desc", "", "mohist-standard-tools_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class AccessibilityUtilsKt {
    public static final void setAccessibilityOptions(View view, final AccessibilityOptions accessibilityOptions) {
        Intrinsics.checkParameterIsNotNull(view, "$this$setAccessibilityOptions");
        Intrinsics.checkParameterIsNotNull(accessibilityOptions, Api.KEY_OPTIONS);
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: com.bytedance.android.standard.tools.ui.AccessibilityUtilsKt$setAccessibilityOptions$1
            public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfoCompat info) {
                Intrinsics.checkParameterIsNotNull(host, "host");
                Intrinsics.checkParameterIsNotNull(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                String contentDescription = AccessibilityOptions.this.getContentDescription();
                if (contentDescription != null) {
                    info.setContentDescription(contentDescription);
                }
                info.setHeading(AccessibilityOptions.this.getIsAccessibilityHeading());
                CharSequence className = AccessibilityOptions.this.getClassName();
                if (className == null || className.length() == 0) {
                    return;
                }
                info.setClassName(AccessibilityOptions.this.getClassName());
            }
        });
    }

    public static final void setAccessibilityHeading(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$setAccessibilityHeading");
        setAccessibilityOptions(view, new AccessibilityOptions(null, true, null, 5, null));
    }

    public static final void setAccessibilityClassName(View view, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(view, "$this$setAccessibilityClassName");
        Intrinsics.checkParameterIsNotNull(charSequence, "className");
        setAccessibilityOptions(view, new AccessibilityOptions(null, false, charSequence, 3, null));
    }

    public static final void setContentDescriptionAndButton(View view, String str) {
        Intrinsics.checkParameterIsNotNull(view, "$this$setContentDescriptionAndButton");
        Intrinsics.checkParameterIsNotNull(str, "desc");
        setAccessibilityOptions(view, new AccessibilityOptions(str, false, Button.class.getName(), 2, null));
    }
}
