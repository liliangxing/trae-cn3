package androidx.compose.p001ui.precompose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PreComposeView.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/precompose/PreComposePhase;", "", "<init>", "(Ljava/lang/String;I)V", "COMPOSE", "LAYOUT", "DRAW", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PreComposePhase {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PreComposePhase[] $VALUES;
    public static final PreComposePhase COMPOSE = new PreComposePhase("COMPOSE", 0);
    public static final PreComposePhase LAYOUT = new PreComposePhase("LAYOUT", 1);
    public static final PreComposePhase DRAW = new PreComposePhase("DRAW", 2);

    private static final /* synthetic */ PreComposePhase[] $values() {
        return new PreComposePhase[]{COMPOSE, LAYOUT, DRAW};
    }

    public static EnumEntries<PreComposePhase> getEntries() {
        return $ENTRIES;
    }

    private PreComposePhase(String str, int i) {
    }

    static {
        PreComposePhase[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static PreComposePhase valueOf(String str) {
        return (PreComposePhase) Enum.valueOf(PreComposePhase.class, str);
    }

    public static PreComposePhase[] values() {
        return (PreComposePhase[]) $VALUES.clone();
    }
}
