package com.bytedance.trae.conversation.brainstorm.health;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.trae.conversation.brainstorm.model.AudioDevice;
import com.bytedance.trae.im.model.ConfirmInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OutputVolumeMuteDetector.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0003\u0014\u0015\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ$\u0010\u0010\u001a\u00020\t*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector;", "", "<init>", "()V", "consecutiveMutedChecks", "", "lastAudioDevice", "Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;", "evaluate", "Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;", "shouldCheck", "", "snapshot", "Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;", "reset", "", "toEvaluation", ConfirmInfo.STATUS_CONFIRMED, "checkHit", "hitCount", "Companion", "Snapshot", "Evaluation", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class OutputVolumeMuteDetector {
    public static final int CONFIRM_CHECK_COUNT = 2;
    private int consecutiveMutedChecks;
    private AudioDevice lastAudioDevice;

    /* compiled from: OutputVolumeMuteDetector.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AudioDevice.values().length];
            try {
                iArr[AudioDevice.Speaker.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AudioDevice.Earpiece.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: OutputVolumeMuteDetector.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ:\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;", "", "audioDevice", "Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;", "isInCommunicationMode", "", "musicVolume", "", "voiceCallVolume", "<init>", "(Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;ZLjava/lang/Integer;Ljava/lang/Integer;)V", "getAudioDevice", "()Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;", "()Z", "getMusicVolume", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVoiceCallVolume", "component1", "component2", "component3", "component4", "copy", "(Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;ZLjava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Snapshot;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Snapshot {
        private final AudioDevice audioDevice;
        private final boolean isInCommunicationMode;
        private final Integer musicVolume;
        private final Integer voiceCallVolume;

        public static /* synthetic */ Snapshot copy$default(Snapshot snapshot, AudioDevice audioDevice, boolean z, Integer num, Integer num2, int i, Object obj) {
            if ((i & 1) != 0) {
                audioDevice = snapshot.audioDevice;
            }
            if ((i & 2) != 0) {
                z = snapshot.isInCommunicationMode;
            }
            if ((i & 4) != 0) {
                num = snapshot.musicVolume;
            }
            if ((i & 8) != 0) {
                num2 = snapshot.voiceCallVolume;
            }
            return snapshot.copy(audioDevice, z, num, num2);
        }

        /* renamed from: component1, reason: from getter */
        public final AudioDevice getAudioDevice() {
            return this.audioDevice;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsInCommunicationMode() {
            return this.isInCommunicationMode;
        }

        /* renamed from: component3, reason: from getter */
        public final Integer getMusicVolume() {
            return this.musicVolume;
        }

        /* renamed from: component4, reason: from getter */
        public final Integer getVoiceCallVolume() {
            return this.voiceCallVolume;
        }

        public final Snapshot copy(AudioDevice audioDevice, boolean isInCommunicationMode, Integer musicVolume, Integer voiceCallVolume) {
            Intrinsics.checkNotNullParameter(audioDevice, "audioDevice");
            return new Snapshot(audioDevice, isInCommunicationMode, musicVolume, voiceCallVolume);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Snapshot)) {
                return false;
            }
            Snapshot snapshot = (Snapshot) other;
            return this.audioDevice == snapshot.audioDevice && this.isInCommunicationMode == snapshot.isInCommunicationMode && Intrinsics.areEqual(this.musicVolume, snapshot.musicVolume) && Intrinsics.areEqual(this.voiceCallVolume, snapshot.voiceCallVolume);
        }

        public int hashCode() {
            int hashCode = ((this.audioDevice.hashCode() * 31) + Boolean.hashCode(this.isInCommunicationMode)) * 31;
            Integer num = this.musicVolume;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.voiceCallVolume;
            return hashCode2 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "Snapshot(audioDevice=" + this.audioDevice + ", isInCommunicationMode=" + this.isInCommunicationMode + ", musicVolume=" + this.musicVolume + ", voiceCallVolume=" + this.voiceCallVolume + ')';
        }

        public Snapshot(AudioDevice audioDevice, boolean z, Integer num, Integer num2) {
            Intrinsics.checkNotNullParameter(audioDevice, "audioDevice");
            this.audioDevice = audioDevice;
            this.isInCommunicationMode = z;
            this.musicVolume = num;
            this.voiceCallVolume = num2;
        }

        public final AudioDevice getAudioDevice() {
            return this.audioDevice;
        }

        public final boolean isInCommunicationMode() {
            return this.isInCommunicationMode;
        }

        public final Integer getMusicVolume() {
            return this.musicVolume;
        }

        public final Integer getVoiceCallVolume() {
            return this.voiceCallVolume;
        }
    }

    /* compiled from: OutputVolumeMuteDetector.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0016JX\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000fR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016¨\u0006'"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;", "", ConfirmInfo.STATUS_CONFIRMED, "", "checkHit", "hitCount", "", "audioDevice", "Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;", "isInCommunicationMode", "musicVolume", "voiceCallVolume", "<init>", "(ZZILcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;ZLjava/lang/Integer;Ljava/lang/Integer;)V", "getConfirmed", "()Z", "getCheckHit", "getHitCount", "()I", "getAudioDevice", "()Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;", "getMusicVolume", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getVoiceCallVolume", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(ZZILcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;ZLjava/lang/Integer;Ljava/lang/Integer;)Lcom/bytedance/trae/conversation/brainstorm/health/OutputVolumeMuteDetector$Evaluation;", "equals", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final /* data */ class Evaluation {
        private final AudioDevice audioDevice;
        private final boolean checkHit;
        private final boolean confirmed;
        private final int hitCount;
        private final boolean isInCommunicationMode;
        private final Integer musicVolume;
        private final Integer voiceCallVolume;

        public static /* synthetic */ Evaluation copy$default(Evaluation evaluation, boolean z, boolean z2, int i, AudioDevice audioDevice, boolean z3, Integer num, Integer num2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = evaluation.confirmed;
            }
            if ((i2 & 2) != 0) {
                z2 = evaluation.checkHit;
            }
            boolean z4 = z2;
            if ((i2 & 4) != 0) {
                i = evaluation.hitCount;
            }
            int i3 = i;
            if ((i2 & 8) != 0) {
                audioDevice = evaluation.audioDevice;
            }
            AudioDevice audioDevice2 = audioDevice;
            if ((i2 & 16) != 0) {
                z3 = evaluation.isInCommunicationMode;
            }
            boolean z5 = z3;
            if ((i2 & 32) != 0) {
                num = evaluation.musicVolume;
            }
            Integer num3 = num;
            if ((i2 & 64) != 0) {
                num2 = evaluation.voiceCallVolume;
            }
            return evaluation.copy(z, z4, i3, audioDevice2, z5, num3, num2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getConfirmed() {
            return this.confirmed;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getCheckHit() {
            return this.checkHit;
        }

        /* renamed from: component3, reason: from getter */
        public final int getHitCount() {
            return this.hitCount;
        }

        /* renamed from: component4, reason: from getter */
        public final AudioDevice getAudioDevice() {
            return this.audioDevice;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getIsInCommunicationMode() {
            return this.isInCommunicationMode;
        }

        /* renamed from: component6, reason: from getter */
        public final Integer getMusicVolume() {
            return this.musicVolume;
        }

        /* renamed from: component7, reason: from getter */
        public final Integer getVoiceCallVolume() {
            return this.voiceCallVolume;
        }

        public final Evaluation copy(boolean confirmed, boolean checkHit, int hitCount, AudioDevice audioDevice, boolean isInCommunicationMode, Integer musicVolume, Integer voiceCallVolume) {
            Intrinsics.checkNotNullParameter(audioDevice, "audioDevice");
            return new Evaluation(confirmed, checkHit, hitCount, audioDevice, isInCommunicationMode, musicVolume, voiceCallVolume);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Evaluation)) {
                return false;
            }
            Evaluation evaluation = (Evaluation) other;
            return this.confirmed == evaluation.confirmed && this.checkHit == evaluation.checkHit && this.hitCount == evaluation.hitCount && this.audioDevice == evaluation.audioDevice && this.isInCommunicationMode == evaluation.isInCommunicationMode && Intrinsics.areEqual(this.musicVolume, evaluation.musicVolume) && Intrinsics.areEqual(this.voiceCallVolume, evaluation.voiceCallVolume);
        }

        public int hashCode() {
            int hashCode = ((((((((Boolean.hashCode(this.confirmed) * 31) + Boolean.hashCode(this.checkHit)) * 31) + Integer.hashCode(this.hitCount)) * 31) + this.audioDevice.hashCode()) * 31) + Boolean.hashCode(this.isInCommunicationMode)) * 31;
            Integer num = this.musicVolume;
            int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.voiceCallVolume;
            return hashCode2 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "Evaluation(confirmed=" + this.confirmed + ", checkHit=" + this.checkHit + ", hitCount=" + this.hitCount + ", audioDevice=" + this.audioDevice + ", isInCommunicationMode=" + this.isInCommunicationMode + ", musicVolume=" + this.musicVolume + ", voiceCallVolume=" + this.voiceCallVolume + ')';
        }

        public Evaluation(boolean z, boolean z2, int i, AudioDevice audioDevice, boolean z3, Integer num, Integer num2) {
            Intrinsics.checkNotNullParameter(audioDevice, "audioDevice");
            this.confirmed = z;
            this.checkHit = z2;
            this.hitCount = i;
            this.audioDevice = audioDevice;
            this.isInCommunicationMode = z3;
            this.musicVolume = num;
            this.voiceCallVolume = num2;
        }

        public final boolean getConfirmed() {
            return this.confirmed;
        }

        public final boolean getCheckHit() {
            return this.checkHit;
        }

        public final int getHitCount() {
            return this.hitCount;
        }

        public final AudioDevice getAudioDevice() {
            return this.audioDevice;
        }

        public final boolean isInCommunicationMode() {
            return this.isInCommunicationMode;
        }

        public final Integer getMusicVolume() {
            return this.musicVolume;
        }

        public final Integer getVoiceCallVolume() {
            return this.voiceCallVolume;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        if (r5 == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x006b, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0069, code lost:
    
        if ((r5.intValue() <= 0) == true) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Evaluation evaluate(boolean shouldCheck, Snapshot snapshot) {
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        if (!shouldCheck) {
            reset();
            return toEvaluation(snapshot, false, false, 0);
        }
        if (this.lastAudioDevice != snapshot.getAudioDevice()) {
            this.consecutiveMutedChecks = 0;
            this.lastAudioDevice = snapshot.getAudioDevice();
        }
        int i = WhenMappings.$EnumSwitchMapping$0[snapshot.getAudioDevice().ordinal()];
        if (i == 1) {
            Integer musicVolume = snapshot.getMusicVolume();
            if (musicVolume != null) {
            }
            z = false;
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (snapshot.isInCommunicationMode()) {
                Integer voiceCallVolume = snapshot.getVoiceCallVolume();
                if (voiceCallVolume != null) {
                    if (voiceCallVolume.intValue() <= 0) {
                        z2 = true;
                    }
                }
                z2 = false;
            }
            z = false;
        }
        int i2 = z ? this.consecutiveMutedChecks + 1 : 0;
        this.consecutiveMutedChecks = i2;
        boolean z3 = i2 >= 2;
        if (z3) {
            this.consecutiveMutedChecks = 0;
        }
        return toEvaluation(snapshot, z3, z, i2);
    }

    public final void reset() {
        this.consecutiveMutedChecks = 0;
        this.lastAudioDevice = null;
    }

    private final Evaluation toEvaluation(Snapshot snapshot, boolean z, boolean z2, int i) {
        return new Evaluation(z, z2, i, snapshot.getAudioDevice(), snapshot.isInCommunicationMode(), snapshot.getMusicVolume(), snapshot.getVoiceCallVolume());
    }
}
