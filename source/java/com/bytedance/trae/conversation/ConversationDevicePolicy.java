package com.bytedance.trae.conversation;

import com.bytedance.sdk.xbridge.cn.p003ui.utils.StatusBarUtils;
import com.bytedance.trae.conversation.devices.SelectedDeviceItem;
import com.bytedance.trae.im.service.Cli;
import com.bytedance.trae.im.service.CliType;
import com.bytedance.trae.im.service.Conversation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ConversationDevicePolicy.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tJ\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/ConversationDevicePolicy;", "", "<init>", "()V", "resolveCliType", "Lcom/bytedance/trae/im/service/CliType;", "conversation", "Lcom/bytedance/trae/im/service/Conversation;", "cachedCliType", "", "buildSelectedDevice", "Lcom/bytedance/trae/conversation/devices/SelectedDeviceItem;", "cachedCli", "Lcom/bytedance/trae/im/service/Cli;", "shouldCheckIdeProject", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class ConversationDevicePolicy {
    public static final ConversationDevicePolicy INSTANCE = new ConversationDevicePolicy();

    private ConversationDevicePolicy() {
    }

    public final CliType resolveCliType(Conversation conversation, String cachedCliType) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        String takeNotBlank = ConversationProjectContextKt.takeNotBlank(conversation.getEnvironment());
        String takeNotBlank2 = ConversationProjectContextKt.takeNotBlank(cachedCliType);
        String ideProjectId = ConversationProjectContextKt.ideProjectId(conversation);
        boolean z = !(ideProjectId == null || ideProjectId.length() == 0);
        if (Intrinsics.areEqual(takeNotBlank, CliType.LOCAL.getValue()) && Intrinsics.areEqual(takeNotBlank2, CliType.IDE.getValue()) && z) {
            takeNotBlank = CliType.IDE.getValue();
        } else if (takeNotBlank == null) {
            takeNotBlank = takeNotBlank2;
        }
        return Intrinsics.areEqual(takeNotBlank, CliType.LOCAL.getValue()) ? CliType.LOCAL : Intrinsics.areEqual(takeNotBlank, CliType.IDE.getValue()) ? CliType.IDE : CliType.REMOTE;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SelectedDeviceItem buildSelectedDevice(Conversation conversation, Cli cachedCli, String cachedCliType) {
        boolean z;
        boolean z2;
        String workspace;
        String cliId;
        String takeNotBlank;
        String str;
        String str2;
        String trimEnd;
        String substringAfterLast$default;
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        CliType resolveCliType = resolveCliType(conversation, cachedCliType);
        String ownerIdeProjectId = ConversationProjectContextKt.ownerIdeProjectId(conversation);
        boolean z3 = false;
        if (resolveCliType == CliType.IDE) {
            String ideProjectId = ConversationProjectContextKt.ideProjectId(conversation);
            if (!(ideProjectId == null || ideProjectId.length() == 0)) {
                z = true;
                if (z) {
                    String str3 = ownerIdeProjectId;
                    if (str3 == null || str3.length() == 0) {
                        z2 = true;
                        if (resolveCliType == CliType.IDE) {
                            workspace = ConversationProjectContextKt.ideProjectPath(conversation);
                            if (workspace == null) {
                                workspace = conversation.getWorkspace();
                            }
                        } else {
                            workspace = conversation.getWorkspace();
                        }
                        cliId = conversation.getCliId();
                        if (cliId == null) {
                            cliId = "";
                        }
                        String str4 = null;
                        takeNotBlank = ConversationProjectContextKt.takeNotBlank(cachedCli != null ? cachedCli.getName() : null);
                        if (takeNotBlank == null) {
                            str = conversation.getCliId();
                            if (str == null) {
                                str = "";
                            }
                        } else {
                            str = takeNotBlank;
                        }
                        String ideVersion = cachedCli != null ? cachedCli.getIdeVersion() : null;
                        if (ownerIdeProjectId != null) {
                            if (resolveCliType == CliType.IDE) {
                                str2 = ownerIdeProjectId;
                                boolean z4 = !z2;
                                if (workspace != null && (trimEnd = StringsKt.trimEnd(workspace, new char[]{'/'})) != null && (substringAfterLast$default = StringsKt.substringAfterLast$default(trimEnd, '/', (String) null, 2, (Object) null)) != null) {
                                    if (resolveCliType == CliType.IDE && (!StringsKt.isBlank(substringAfterLast$default))) {
                                        z3 = true;
                                    }
                                    if (z3) {
                                        str4 = substringAfterLast$default;
                                    }
                                }
                                return new SelectedDeviceItem(cliId, str, resolveCliType, workspace, ideVersion, str2, z4, str4, false, StatusBarUtils.FLAG_NOTCH_SUPPORT, null);
                            }
                        }
                        str2 = null;
                        boolean z42 = !z2;
                        if (workspace != null) {
                            if (resolveCliType == CliType.IDE) {
                                z3 = true;
                            }
                            if (z3) {
                            }
                        }
                        return new SelectedDeviceItem(cliId, str, resolveCliType, workspace, ideVersion, str2, z42, str4, false, StatusBarUtils.FLAG_NOTCH_SUPPORT, null);
                    }
                }
                z2 = false;
                if (resolveCliType == CliType.IDE) {
                }
                cliId = conversation.getCliId();
                if (cliId == null) {
                }
                String str42 = null;
                takeNotBlank = ConversationProjectContextKt.takeNotBlank(cachedCli != null ? cachedCli.getName() : null);
                if (takeNotBlank == null) {
                }
                if (cachedCli != null) {
                }
                if (ownerIdeProjectId != null) {
                }
                str2 = null;
                boolean z422 = !z2;
                if (workspace != null) {
                }
                return new SelectedDeviceItem(cliId, str, resolveCliType, workspace, ideVersion, str2, z422, str42, false, StatusBarUtils.FLAG_NOTCH_SUPPORT, null);
            }
        }
        z = false;
        if (z) {
        }
        z2 = false;
        if (resolveCliType == CliType.IDE) {
        }
        cliId = conversation.getCliId();
        if (cliId == null) {
        }
        String str422 = null;
        takeNotBlank = ConversationProjectContextKt.takeNotBlank(cachedCli != null ? cachedCli.getName() : null);
        if (takeNotBlank == null) {
        }
        if (cachedCli != null) {
        }
        if (ownerIdeProjectId != null) {
        }
        str2 = null;
        boolean z4222 = !z2;
        if (workspace != null) {
        }
        return new SelectedDeviceItem(cliId, str, resolveCliType, workspace, ideVersion, str2, z4222, str422, false, StatusBarUtils.FLAG_NOTCH_SUPPORT, null);
    }

    public final boolean shouldCheckIdeProject(Conversation conversation, String cachedCliType) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        String ownerIdeProjectId = ConversationProjectContextKt.ownerIdeProjectId(conversation);
        boolean z = !(ownerIdeProjectId == null || ownerIdeProjectId.length() == 0);
        if (resolveCliType(conversation, cachedCliType) != CliType.IDE || z) {
            return false;
        }
        String ideProjectId = ConversationProjectContextKt.ideProjectId(conversation);
        return !(ideProjectId == null || ideProjectId.length() == 0);
    }
}
