package com.bytedance.trae.conversation.brainstorm.widget;

import com.bytedance.sdk.account.monitor.AccountMonitorConstants;
import kotlin.Metadata;
import kotlin.text.StringsKt;

/* compiled from: BrainstormVoiceHistorySheet.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"VOICE_HISTORY_REMOTE_RESOURCE_PREFIX", "", "VOICE_HISTORY_REMOTE_RESOURCE_CACHE_DIR", "normalizeRemoteResourceId", AccountMonitorConstants.CommonParameter.RAW, "conversation_mainlandRelease"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class BrainstormVoiceHistorySheetKt {
    private static final String VOICE_HISTORY_REMOTE_RESOURCE_CACHE_DIR = "voice_history_remote_resource";
    private static final String VOICE_HISTORY_REMOTE_RESOURCE_PREFIX = "trae-res://remote_resource/";

    /* JADX INFO: Access modifiers changed from: private */
    public static final String normalizeRemoteResourceId(String str) {
        String obj = str != null ? StringsKt.trim(str).toString() : null;
        if (obj == null) {
            obj = "";
        }
        if (StringsKt.isBlank(obj)) {
            return null;
        }
        String removePrefix = StringsKt.removePrefix(obj, VOICE_HISTORY_REMOTE_RESOURCE_PREFIX);
        if (!StringsKt.isBlank(removePrefix)) {
            return removePrefix;
        }
        return null;
    }
}
