package com.bytedance.trae.conversation;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.devices.SelectedDeviceItem;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.CreateTaskCheckResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: IDEProjectAvailabilityPolicy.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/IDEProjectAvailabilityPolicy;", "", "<init>", "()V", "isUnavailable", "", "device", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "applyCreateTaskCheck", "response", "Lcom/bytedance/trae/im/service/CreateTaskCheckResponse;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class IDEProjectAvailabilityPolicy {
    public static final IDEProjectAvailabilityPolicy INSTANCE = new IDEProjectAvailabilityPolicy();

    private IDEProjectAvailabilityPolicy() {
    }

    public final boolean isUnavailable(SelectedDeviceItem device) {
        Intrinsics.checkNotNullParameter(device, "device");
        if (device.getType() != CliType.IDE) {
            return false;
        }
        if (device.isProjectAvailable()) {
            String projectId = device.getProjectId();
            if (!(projectId == null || StringsKt.isBlank(projectId))) {
                return false;
            }
        }
        return true;
    }

    public final SelectedDeviceItem applyCreateTaskCheck(SelectedDeviceItem device, CreateTaskCheckResponse response) {
        SelectedDeviceItem copy;
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(response, "response");
        String takeNotBlank = ConversationProjectContextKt.takeNotBlank(response.getProjectId());
        copy = device.copy((r20 & 1) != 0 ? device.id : null, (r20 & 2) != 0 ? device.name : null, (r20 & 4) != 0 ? device.type : CliType.IDE, (r20 & 8) != 0 ? device.selectedDirectory : null, (r20 & 16) != 0 ? device.ideVersion : null, (r20 & 32) != 0 ? device.projectId : takeNotBlank, (r20 & 64) != 0 ? device.isProjectAvailable : response.getAvailable() && takeNotBlank != null, (r20 & 128) != 0 ? device.projectName : null, (r20 & StatusBarUtils.FLAG_NOTCH_SUPPORT) != 0 ? device.showProductType : false);
        return copy;
    }
}
