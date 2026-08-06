package com.bytedance.trae.conversation;

import com.bytedance.trae.conversation.devices.SelectedDeviceItem;
import com.bytedance.trae.im.service.CliType;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CreateTaskWorkspacePolicy.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/CreateTaskWorkspacePolicy;", "", "<init>", "()V", "fromDevice", "Lcom/bytedance/trae/conversation/CreateTaskWorkspaceFields;", "device", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "requiresWorkspace", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CreateTaskWorkspacePolicy {
    public static final CreateTaskWorkspacePolicy INSTANCE = new CreateTaskWorkspacePolicy();

    /* compiled from: CreateTaskWorkspacePolicy.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CliType.values().length];
            try {
                iArr[CliType.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CliType.IDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CliType.REMOTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private CreateTaskWorkspacePolicy() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0031, code lost:
    
        if ((!kotlin.text.StringsKt.isBlank(r0)) != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final CreateTaskWorkspaceFields fromDevice(SelectedDeviceItem device) {
        String selectedDirectory;
        Intrinsics.checkNotNullParameter(device, "device");
        int i = WhenMappings.$EnumSwitchMapping$0[device.getType().ordinal()];
        String str = null;
        if (i == 1 || i == 2) {
            selectedDirectory = device.getSelectedDirectory();
            if (selectedDirectory != null) {
            }
        } else if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        selectedDirectory = null;
        List listOf = selectedDirectory != null ? CollectionsKt.listOf(selectedDirectory) : null;
        String projectId = device.getProjectId();
        if (projectId != null) {
            if (device.getType() == CliType.IDE && (StringsKt.isBlank(projectId) ^ true)) {
                str = projectId;
            }
        }
        return new CreateTaskWorkspaceFields(selectedDirectory, listOf, str);
    }

    public final boolean requiresWorkspace(SelectedDeviceItem device) {
        Intrinsics.checkNotNullParameter(device, "device");
        return device.getType() == CliType.LOCAL || device.getType() == CliType.IDE;
    }
}
