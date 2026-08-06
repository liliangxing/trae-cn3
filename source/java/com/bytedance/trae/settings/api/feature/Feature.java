package com.bytedance.trae.settings.api.feature;

import com.bytedance.trae.home.solo.setting.SettingsTracker;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Feature.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/trae/settings/api/feature/Feature;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "CONNECTORS", "MOBILE_IDE_GUIDE", "BRAINSTORM_V2", "TASK_LIST_SEARCH", "TASK_LIST_PIN", "HTML_SHARE", "PLUGIN", "api_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Feature {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Feature[] $VALUES;
    private final String key;
    public static final Feature CONNECTORS = new Feature("CONNECTORS", 0, SettingsTracker.TYPE_CONNECTORS);
    public static final Feature MOBILE_IDE_GUIDE = new Feature("MOBILE_IDE_GUIDE", 1, "mobile_ide_guide");
    public static final Feature BRAINSTORM_V2 = new Feature("BRAINSTORM_V2", 2, "brainstorm-v2");
    public static final Feature TASK_LIST_SEARCH = new Feature("TASK_LIST_SEARCH", 3, "task-list-search");
    public static final Feature TASK_LIST_PIN = new Feature("TASK_LIST_PIN", 4, "task-list-pin");
    public static final Feature HTML_SHARE = new Feature("HTML_SHARE", 5, "share_html");
    public static final Feature PLUGIN = new Feature("PLUGIN", 6, CloudControlInf.PLUGIN);

    private static final /* synthetic */ Feature[] $values() {
        return new Feature[]{CONNECTORS, MOBILE_IDE_GUIDE, BRAINSTORM_V2, TASK_LIST_SEARCH, TASK_LIST_PIN, HTML_SHARE, PLUGIN};
    }

    public static EnumEntries<Feature> getEntries() {
        return $ENTRIES;
    }

    private Feature(String str, int i, String str2) {
        this.key = str2;
    }

    public final String getKey() {
        return this.key;
    }

    static {
        Feature[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static Feature valueOf(String str) {
        return (Feature) Enum.valueOf(Feature.class, str);
    }

    public static Feature[] values() {
        return (Feature[]) $VALUES.clone();
    }
}
