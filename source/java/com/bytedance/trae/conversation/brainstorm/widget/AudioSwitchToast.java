package com.bytedance.trae.conversation.brainstorm.widget;

import android.view.ViewGroup;
import com.bytedance.trae.common.widget.InlineToast;
import com.bytedance.trae.conversation.C0637R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioSwitchToast.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\u0005¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/widget/AudioSwitchToast;", "", "<init>", "()V", "show", "", "container", "Landroid/view/ViewGroup;", "deviceName", "", "dismiss", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AudioSwitchToast {
    public static final AudioSwitchToast INSTANCE = new AudioSwitchToast();

    private AudioSwitchToast() {
    }

    public final void show(ViewGroup container, String deviceName) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        InlineToast.show$default(InlineToast.INSTANCE, container, deviceName, C0637R.drawable.icon_16_checkmark_circle_filled, 0L, 0, null, 0, 120, null);
    }

    public final void dismiss() {
        InlineToast.INSTANCE.dismiss();
    }
}
