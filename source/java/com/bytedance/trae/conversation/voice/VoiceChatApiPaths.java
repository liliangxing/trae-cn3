package com.bytedance.trae.conversation.voice;

import com.bytedance.trae.network.HostResolver;
import com.bytedance.trae.network.HostType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoiceChatApiPaths.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001:\u0002\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0005R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths;", "", "<init>", "()V", "HOST", "", "getHOST", "()Ljava/lang/String;", "START_VOICE_CHAT", "STOP_VOICE_CHAT", "GET_VOICE_CHAT_HISTORY", "buildHeaders", "", "conversationId", "sceneId", "xAppId", "ppeEnv", "HeaderKey", "HeaderValue", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class VoiceChatApiPaths {
    public static final String GET_VOICE_CHAT_HISTORY = "api/stream/v1/history";
    public static final VoiceChatApiPaths INSTANCE = new VoiceChatApiPaths();
    public static final String START_VOICE_CHAT = "api/stream/v1/startVoiceChat";
    public static final String STOP_VOICE_CHAT = "api/stream/v1/stopVoiceChat";

    private VoiceChatApiPaths() {
    }

    public final String getHOST() {
        return HostResolver.INSTANCE.getBaseUrl(HostType.AI);
    }

    /* compiled from: VoiceChatApiPaths.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderKey;", "", "<init>", "()V", "CONTENT_TYPE", "", "SCENE_ID", "APP_ID", "CONVERSATION_ID", "IDE_VERSION_CODE", "AUDIO_SOURCE", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class HeaderKey {
        public static final String APP_ID = "X-App-Id";
        public static final String AUDIO_SOURCE = "x-audio-source";
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String CONVERSATION_ID = "x-conversation-id";
        public static final String IDE_VERSION_CODE = "X-IDE-Version-Code";
        public static final HeaderKey INSTANCE = new HeaderKey();
        public static final String SCENE_ID = "X-Scene-Id";

        private HeaderKey() {
        }
    }

    /* compiled from: VoiceChatApiPaths.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/trae/conversation/voice/VoiceChatApiPaths$HeaderValue;", "", "<init>", "()V", "CONTENT_TYPE_JSON", "", "IDE_VERSION_CODE", "DEFAULT_X_APP_ID", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class HeaderValue {
        public static final String CONTENT_TYPE_JSON = "application/json";
        public static final String DEFAULT_X_APP_ID = "6eefa01c-1036-4c7e-9ca5-d891f63bfcd8";
        public static final String IDE_VERSION_CODE = "20260623";
        public static final HeaderValue INSTANCE = new HeaderValue();

        private HeaderValue() {
        }
    }

    public static /* synthetic */ Map buildHeaders$default(VoiceChatApiPaths voiceChatApiPaths, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = HeaderValue.DEFAULT_X_APP_ID;
        }
        if ((i & 8) != 0) {
            str4 = "";
        }
        return voiceChatApiPaths.buildHeaders(str, str2, str3, str4);
    }

    public final Map<String, String> buildHeaders(String conversationId, String sceneId, String xAppId, String ppeEnv) {
        Intrinsics.checkNotNullParameter(conversationId, "conversationId");
        Intrinsics.checkNotNullParameter(sceneId, "sceneId");
        Intrinsics.checkNotNullParameter(xAppId, "xAppId");
        Intrinsics.checkNotNullParameter(ppeEnv, "ppeEnv");
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("Content-Type", HeaderValue.CONTENT_TYPE_JSON), TuplesKt.to(HeaderKey.SCENE_ID, sceneId), TuplesKt.to(HeaderKey.APP_ID, xAppId), TuplesKt.to(HeaderKey.CONVERSATION_ID, conversationId), TuplesKt.to(HeaderKey.IDE_VERSION_CODE, HeaderValue.IDE_VERSION_CODE), TuplesKt.to(HeaderKey.AUDIO_SOURCE, "mobile")});
    }
}
