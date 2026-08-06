package com.bytedance.trae.home.solo.setting;

import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SettingsMainFragment.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/home/solo/setting/SaaSProductType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "TeamGroup", "TeamGroupV2", "TeamFlagship", "TeamFlagshipV2", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
final class SaaSProductType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SaaSProductType[] $VALUES;
    private final int value;
    public static final SaaSProductType TeamGroup = new SaaSProductType("TeamGroup", 0, MediaPlayer.MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM);
    public static final SaaSProductType TeamGroupV2 = new SaaSProductType("TeamGroupV2", 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR);
    public static final SaaSProductType TeamFlagship = new SaaSProductType("TeamFlagship", 2, MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT);
    public static final SaaSProductType TeamFlagshipV2 = new SaaSProductType("TeamFlagshipV2", 3, MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR);

    private static final /* synthetic */ SaaSProductType[] $values() {
        return new SaaSProductType[]{TeamGroup, TeamGroupV2, TeamFlagship, TeamFlagshipV2};
    }

    public static EnumEntries<SaaSProductType> getEntries() {
        return $ENTRIES;
    }

    private SaaSProductType(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        SaaSProductType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static SaaSProductType valueOf(String str) {
        return (SaaSProductType) Enum.valueOf(SaaSProductType.class, str);
    }

    public static SaaSProductType[] values() {
        return (SaaSProductType[]) $VALUES.clone();
    }
}
