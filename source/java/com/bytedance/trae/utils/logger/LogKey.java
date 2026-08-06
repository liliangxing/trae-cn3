package com.bytedance.trae.utils.logger;

import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.apm.constant.ReportProtocal;
import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.push.helper.MultiProcessPushMessageDatabaseHelper;
import com.bytedance.trae.conversation.tracker.NewTaskTracker;
import com.bytedance.trae.push.api.PushConst;
import com.heytap.mcssdk.constant.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.cms.CMSAttributeTableGenerator;

/* compiled from: FormatLogBuilder.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/trae/utils/logger/LogKey;", "", "rawValue", "", "<init>", "(Ljava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "Companion", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LogKey {
    private final String rawValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LogKey callID = new LogKey("call_id");
    private static final LogKey taskID = new LogKey(NewTaskTracker.Param.TASK_ID);
    private static final LogKey sessionID = new LogKey("session_id");
    private static final LogKey logID = new LogKey(ReportProtocal.KEY_LOG_ID);
    private static final LogKey styleID = new LogKey("style_id");
    private static final LogKey audioScene = new LogKey("audio_scene");
    private static final LogKey sessionCategory = new LogKey("session_category");
    private static final LogKey sessionMode = new LogKey("session_mode");
    private static final LogKey sessionOptions = new LogKey("session_options");
    private static final LogKey result = new LogKey("result");
    private static final LogKey botId = new LogKey("bot_id");
    private static final LogKey botName = new LogKey("bot_name");
    private static final LogKey contentType = new LogKey("content_type");
    private static final LogKey conversationId = new LogKey(PushConst.PUSH_KEY_CONVERSATION_ID);
    private static final LogKey messageId = new LogKey(MultiProcessPushMessageDatabaseHelper.COL_MESSAGE_ID);
    private static final LogKey voiceId = new LogKey("voice_id");
    private static final LogKey text = new LogKey("text");
    private static final LogKey errorMsg = new LogKey("error_msg");
    private static final LogKey callTtsTaskId = new LogKey("last_call_tts_task_id");
    private static final LogKey isInterrupt = new LogKey("is_interrupt");
    private static final LogKey TTSSubtitleData = new LogKey("tts_subtitle_data");
    private static final LogKey sectionId = new LogKey("sectionId");
    private static final LogKey queryRound = new LogKey("queryRound");
    private static final LogKey type = new LogKey("type");
    private static final LogKey updateKey = new LogKey("updateKey");
    private static final LogKey action = new LogKey(StrategyConstants.ACTION);
    private static final LogKey enterMethod = new LogKey(PushConst.PUSH_KEY_ENTER_METHOD);

    /* compiled from: FormatLogBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b6\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001c\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0007R\u0011\u0010\u001e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0007R\u0011\u0010 \u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0011\u0010\"\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0007R\u0011\u0010$\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0007R\u0011\u0010&\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0007R\u0011\u0010(\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0007R\u0011\u0010*\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0007R\u0011\u0010,\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0007R\u0011\u0010-\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0007R\u0011\u0010/\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0007R\u0011\u00101\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0007R\u0011\u00103\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0007R\u0011\u00105\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0007R\u0011\u00107\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0007R\u0011\u00109\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0007¨\u0006;"}, d2 = {"Lcom/bytedance/trae/utils/logger/LogKey$Companion;", "", "<init>", "()V", "callID", "Lcom/bytedance/trae/utils/logger/LogKey;", "getCallID", "()Lcom/bytedance/trae/utils/logger/LogKey;", b.d, "getTaskID", "sessionID", "getSessionID", "logID", "getLogID", "styleID", "getStyleID", "audioScene", "getAudioScene", "sessionCategory", "getSessionCategory", "sessionMode", "getSessionMode", "sessionOptions", "getSessionOptions", "result", "getResult", "botId", "getBotId", "botName", "getBotName", CMSAttributeTableGenerator.CONTENT_TYPE, "getContentType", "conversationId", "getConversationId", "messageId", "getMessageId", "voiceId", "getVoiceId", "text", "getText", "errorMsg", "getErrorMsg", "callTtsTaskId", "getCallTtsTaskId", "isInterrupt", "TTSSubtitleData", "getTTSSubtitleData", "sectionId", "getSectionId", "queryRound", "getQueryRound", "type", "getType", "updateKey", "getUpdateKey", StrategyConstants.ACTION, "getAction", "enterMethod", "getEnterMethod", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LogKey getCallID() {
            return LogKey.callID;
        }

        public final LogKey getTaskID() {
            return LogKey.taskID;
        }

        public final LogKey getSessionID() {
            return LogKey.sessionID;
        }

        public final LogKey getLogID() {
            return LogKey.logID;
        }

        public final LogKey getStyleID() {
            return LogKey.styleID;
        }

        public final LogKey getAudioScene() {
            return LogKey.audioScene;
        }

        public final LogKey getSessionCategory() {
            return LogKey.sessionCategory;
        }

        public final LogKey getSessionMode() {
            return LogKey.sessionMode;
        }

        public final LogKey getSessionOptions() {
            return LogKey.sessionOptions;
        }

        public final LogKey getResult() {
            return LogKey.result;
        }

        public final LogKey getBotId() {
            return LogKey.botId;
        }

        public final LogKey getBotName() {
            return LogKey.botName;
        }

        public final LogKey getContentType() {
            return LogKey.contentType;
        }

        public final LogKey getConversationId() {
            return LogKey.conversationId;
        }

        public final LogKey getMessageId() {
            return LogKey.messageId;
        }

        public final LogKey getVoiceId() {
            return LogKey.voiceId;
        }

        public final LogKey getText() {
            return LogKey.text;
        }

        public final LogKey getErrorMsg() {
            return LogKey.errorMsg;
        }

        public final LogKey getCallTtsTaskId() {
            return LogKey.callTtsTaskId;
        }

        public final LogKey isInterrupt() {
            return LogKey.isInterrupt;
        }

        public final LogKey getTTSSubtitleData() {
            return LogKey.TTSSubtitleData;
        }

        public final LogKey getSectionId() {
            return LogKey.sectionId;
        }

        public final LogKey getQueryRound() {
            return LogKey.queryRound;
        }

        public final LogKey getType() {
            return LogKey.type;
        }

        public final LogKey getUpdateKey() {
            return LogKey.updateKey;
        }

        public final LogKey getAction() {
            return LogKey.action;
        }

        public final LogKey getEnterMethod() {
            return LogKey.enterMethod;
        }
    }

    public LogKey(String rawValue) {
        Intrinsics.checkNotNullParameter(rawValue, "rawValue");
        this.rawValue = rawValue;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    public boolean equals(Object other) {
        LogKey logKey = other instanceof LogKey ? (LogKey) other : null;
        return Intrinsics.areEqual(logKey != null ? logKey.rawValue : null, this.rawValue);
    }

    public int hashCode() {
        return this.rawValue.hashCode();
    }
}
