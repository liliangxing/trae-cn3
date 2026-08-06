package com.bytedance.trae.conversation.brainstorm.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BrainstormUiState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/trae/conversation/brainstorm/model/AudioDevice;", "", "<init>", "(Ljava/lang/String;I)V", "Speaker", "Earpiece", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AudioDevice {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AudioDevice[] $VALUES;
    public static final AudioDevice Speaker = new AudioDevice("Speaker", 0);
    public static final AudioDevice Earpiece = new AudioDevice("Earpiece", 1);

    private static final /* synthetic */ AudioDevice[] $values() {
        return new AudioDevice[]{Speaker, Earpiece};
    }

    public static EnumEntries<AudioDevice> getEntries() {
        return $ENTRIES;
    }

    private AudioDevice(String str, int i) {
    }

    static {
        AudioDevice[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static AudioDevice valueOf(String str) {
        return (AudioDevice) Enum.valueOf(AudioDevice.class, str);
    }

    public static AudioDevice[] values() {
        return (AudioDevice[]) $VALUES.clone();
    }
}
