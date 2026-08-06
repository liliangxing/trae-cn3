package com.bytedance.trae.conversation.devices.newfeature;

import com.bytedance.trae.conversation.devices.DeviceProductType;
import com.bytedance.trae.conversation.widget.ChatMode;
import com.bytedance.trae.im.service.CliType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NewFeaturePromptConnectionPolicy.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionPolicy;", "", "<init>", "()V", "actionFor", "Lcom/bytedance/trae/conversation/devices/newfeature/NewFeaturePromptConnectionAction;", "productType", "Lcom/bytedance/trae/conversation/devices/DeviceProductType;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class NewFeaturePromptConnectionPolicy {
    public static final NewFeaturePromptConnectionPolicy INSTANCE = new NewFeaturePromptConnectionPolicy();

    /* compiled from: NewFeaturePromptConnectionPolicy.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DeviceProductType.values().length];
            try {
                iArr[DeviceProductType.WORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeviceProductType.IDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private NewFeaturePromptConnectionPolicy() {
    }

    public final NewFeaturePromptConnectionAction actionFor(DeviceProductType productType) {
        Intrinsics.checkNotNullParameter(productType, "productType");
        int i = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i == 1) {
            return new NewFeaturePromptConnectionAction(ChatMode.MTC, CliType.LOCAL, true);
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return new NewFeaturePromptConnectionAction(ChatMode.CODE, CliType.IDE, true);
    }
}
