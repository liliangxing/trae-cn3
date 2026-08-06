package com.bytedance.trae.conversation.brainstorm.health;

import android.content.Context;
import com.bytedance.trae.conversation.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VoicePrompt.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B%\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;", "", "priority", "", "iconRes", "throttleMs", "", "<init>", "(IIJ)V", "getPriority", "()I", "getIconRes", "getThrottleMs", "()J", "text", "", "ctx", "Landroid/content/Context;", "Health", "Runtime", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class VoicePrompt {
    private final int iconRes;
    private final int priority;
    private final long throttleMs;

    public /* synthetic */ VoicePrompt(int i, int i2, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, j);
    }

    public abstract CharSequence text(Context ctx);

    private VoicePrompt(int i, int i2, long j) {
        this.priority = i;
        this.iconRes = i2;
        this.throttleMs = j;
    }

    public final int getPriority() {
        return this.priority;
    }

    public /* synthetic */ VoicePrompt(int i, int i2, long j, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? R.drawable.warning_filled_yellow : i2, (i3 & 4) != 0 ? 30000L : j, null);
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final long getThrottleMs() {
        return this.throttleMs;
    }

    /* compiled from: VoicePrompt.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010B\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u0082\u0001\u0004\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;", "priority", "", "messageRes", "<init>", "(II)V", "getMessageRes", "()I", "text", "", "ctx", "Landroid/content/Context;", "MicPermissionDenied", "WeakNetwork", "LowAudioInput", "OutputVolumeMuted", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$LowAudioInput;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$MicPermissionDenied;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$OutputVolumeMuted;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$WeakNetwork;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class Health extends VoicePrompt {
        private final int messageRes;

        public /* synthetic */ Health(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2);
        }

        public final int getMessageRes() {
            return this.messageRes;
        }

        private Health(int i, int i2) {
            super(i, 0, 0L, 6, null);
            this.messageRes = i2;
        }

        @Override // com.bytedance.trae.conversation.brainstorm.health.VoicePrompt
        public CharSequence text(Context ctx) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            String string = ctx.getString(this.messageRes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }

        /* compiled from: VoicePrompt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$MicPermissionDenied;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class MicPermissionDenied extends Health {
            public static final MicPermissionDenied INSTANCE = new MicPermissionDenied();

            private MicPermissionDenied() {
                super(100, R.string.trae_brainstorm_exception_mic_permission, null);
            }
        }

        /* compiled from: VoicePrompt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$WeakNetwork;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class WeakNetwork extends Health {
            public static final WeakNetwork INSTANCE = new WeakNetwork();

            private WeakNetwork() {
                super(80, R.string.trae_brainstorm_exception_weak_network, null);
            }
        }

        /* compiled from: VoicePrompt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$LowAudioInput;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class LowAudioInput extends Health {
            public static final LowAudioInput INSTANCE = new LowAudioInput();

            private LowAudioInput() {
                super(50, R.string.trae_brainstorm_exception_low_volume, null);
            }
        }

        /* compiled from: VoicePrompt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health$OutputVolumeMuted;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Health;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class OutputVolumeMuted extends Health {
            public static final OutputVolumeMuted INSTANCE = new OutputVolumeMuted();

            private OutputVolumeMuted() {
                super(45, R.string.trae_brainstorm_exception_output_volume_muted, null);
            }
        }
    }

    /* compiled from: VoicePrompt.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u000b\f\r\u000e\u000f\u0010B\u001b\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt;", "priority", "", "messageRes", "<init>", "(II)V", "text", "", "ctx", "Landroid/content/Context;", "RtcError", "StartFailed", "MicPermissionDeniedRuntime", "AttachmentTooLarge", "AttachmentTotalTooLarge", "MinimizeRefused", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$AttachmentTooLarge;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$AttachmentTotalTooLarge;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$MicPermissionDeniedRuntime;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$MinimizeRefused;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$RtcError;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static abstract class Runtime extends VoicePrompt {
        private final int messageRes;

        public /* synthetic */ Runtime(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2);
        }

        private Runtime(int i, int i2) {
            super(i, 0, 5000L, 2, null);
            this.messageRes = i2;
        }

        @Override // com.bytedance.trae.conversation.brainstorm.health.VoicePrompt
        public CharSequence text(Context ctx) {
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            String string = ctx.getString(this.messageRes);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }

        /* compiled from: VoicePrompt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$RtcError;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class RtcError extends Runtime {
            public static final RtcError INSTANCE = new RtcError();

            private RtcError() {
                super(70, R.string.trae_brainstorm_voice_error_rtc, null);
            }
        }

        /* compiled from: VoicePrompt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$StartFailed;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class StartFailed extends Runtime {
            public static final StartFailed INSTANCE = new StartFailed();

            private StartFailed() {
                super(70, R.string.trae_brainstorm_voice_error_start, null);
            }
        }

        /* compiled from: VoicePrompt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$MicPermissionDeniedRuntime;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class MicPermissionDeniedRuntime extends Runtime {
            public static final MicPermissionDeniedRuntime INSTANCE = new MicPermissionDeniedRuntime();

            private MicPermissionDeniedRuntime() {
                super(100, R.string.trae_brainstorm_mic_permission_denied, null);
            }
        }

        /* compiled from: VoicePrompt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$AttachmentTooLarge;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class AttachmentTooLarge extends Runtime {
            public static final AttachmentTooLarge INSTANCE = new AttachmentTooLarge();

            private AttachmentTooLarge() {
                super(40, R.string.trae_brainstorm_attach_too_large, null);
            }
        }

        /* compiled from: VoicePrompt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$AttachmentTotalTooLarge;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class AttachmentTotalTooLarge extends Runtime {
            public static final AttachmentTotalTooLarge INSTANCE = new AttachmentTotalTooLarge();

            private AttachmentTotalTooLarge() {
                super(40, R.string.trae_brainstorm_attach_total_too_large, null);
            }
        }

        /* compiled from: VoicePrompt.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime$MinimizeRefused;", "Lcom/bytedance/trae/conversation/brainstorm/health/VoicePrompt$Runtime;", "<init>", "()V", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final class MinimizeRefused extends Runtime {
            public static final MinimizeRefused INSTANCE = new MinimizeRefused();

            private MinimizeRefused() {
                super(40, R.string.trae_brainstorm_voice_error_minimize_refused, null);
            }
        }
    }
}
