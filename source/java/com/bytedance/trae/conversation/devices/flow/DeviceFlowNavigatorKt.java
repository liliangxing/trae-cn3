package com.bytedance.trae.conversation.devices.flow;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceFlowNavigator.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"deviceFlowNavigator", "Lcom/bytedance/trae/conversation/devices/flow/DeviceFlowNavigator;", "Landroidx/fragment/app/Fragment;", "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DeviceFlowNavigatorKt {
    public static final DeviceFlowNavigator deviceFlowNavigator(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        DeviceFlowNavigator parentFragment = fragment.getParentFragment();
        if (parentFragment instanceof DeviceFlowNavigator) {
            return parentFragment;
        }
        return null;
    }
}
