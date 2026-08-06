package com.bytedance.trae.conversation.chat.block.renderer;

import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.im.service.CliType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AssistantAvatarDisplayConfig.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplayConfig;", "", "<init>", "()V", "AVATAR_KEY_TRAE_IDE", "", "AVATAR_KEY_TRAE_CODE", "AVATAR_KEY_TRAE_WORK", "ideDisplay", "Lcom/bytedance/trae/conversation/chat/block/renderer/AssistantAvatarDisplay;", "codeDisplay", "defaultDisplay", "localDefaults", "", "resolve", "agentType", "cliType", "avatarResId", "", "avatarKey", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AssistantAvatarDisplayConfig {
    private static final String AVATAR_KEY_TRAE_CODE = "trae_code";
    private static final String AVATAR_KEY_TRAE_WORK = "trae_work";
    private static final AssistantAvatarDisplay codeDisplay;
    private static final AssistantAvatarDisplay defaultDisplay;
    private static final Map<String, AssistantAvatarDisplay> localDefaults;
    public static final AssistantAvatarDisplayConfig INSTANCE = new AssistantAvatarDisplayConfig();
    private static final String AVATAR_KEY_TRAE_IDE = "trae_ide";
    private static final AssistantAvatarDisplay ideDisplay = new AssistantAvatarDisplay("TRAE IDE", AVATAR_KEY_TRAE_IDE);

    private AssistantAvatarDisplayConfig() {
    }

    static {
        AssistantAvatarDisplay assistantAvatarDisplay = new AssistantAvatarDisplay("TRAE Code", AVATAR_KEY_TRAE_CODE);
        codeDisplay = assistantAvatarDisplay;
        AssistantAvatarDisplay assistantAvatarDisplay2 = new AssistantAvatarDisplay("TRAE Work", AVATAR_KEY_TRAE_WORK);
        defaultDisplay = assistantAvatarDisplay2;
        localDefaults = MapsKt.mapOf(new Pair[]{TuplesKt.to("solo_agent_lite", assistantAvatarDisplay), TuplesKt.to("solo_agent_remote", assistantAvatarDisplay), TuplesKt.to("solo_work_lite", assistantAvatarDisplay2), TuplesKt.to("solo_work_remote", assistantAvatarDisplay2)});
    }

    public static /* synthetic */ AssistantAvatarDisplay resolve$default(AssistantAvatarDisplayConfig assistantAvatarDisplayConfig, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return assistantAvatarDisplayConfig.resolve(str, str2);
    }

    public final AssistantAvatarDisplay resolve(String agentType, String cliType) {
        if (Intrinsics.areEqual(cliType, CliType.IDE.getValue())) {
            return ideDisplay;
        }
        if (agentType != null) {
            if (!(!StringsKt.isBlank(agentType))) {
                agentType = null;
            }
            if (agentType != null) {
                AssistantAvatarDisplay assistantAvatarDisplay = localDefaults.get(agentType);
                return assistantAvatarDisplay == null ? defaultDisplay : assistantAvatarDisplay;
            }
        }
        return defaultDisplay;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002a, code lost:
    
        if (r3.equals(com.bytedance.trae.conversation.chat.block.renderer.AssistantAvatarDisplayConfig.AVATAR_KEY_TRAE_WORK) == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:?, code lost:
    
        return com.bytedance.trae.conversation.C0637R.drawable.trae_ic_avatar_non_ide;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        if (r3.equals(com.bytedance.trae.conversation.chat.block.renderer.AssistantAvatarDisplayConfig.AVATAR_KEY_TRAE_CODE) == false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int avatarResId(String avatarKey) {
        if (avatarKey != null) {
            int hashCode = avatarKey.hashCode();
            if (hashCode != 776444138) {
                if (hashCode != 777040398) {
                    if (hashCode == 1271977997 && avatarKey.equals(AVATAR_KEY_TRAE_IDE)) {
                        return C0637R.drawable.trae_ic_avatar_coder;
                    }
                }
            }
        }
        return C0637R.drawable.trae_ic_avatar_non_ide;
    }
}
