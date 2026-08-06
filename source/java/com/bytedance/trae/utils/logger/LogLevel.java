package com.bytedance.trae.utils.logger;

import androidx.exifinterface.media.ExifInterface;
import com.lynx.tasm.behavior.shadow.text.TextAttributes;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FormatLogBuilder.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/trae/utils/logger/LogLevel;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEBUG", "INFO", "WARN", "ERROR", "utils_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LogLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LogLevel[] $VALUES;
    private final String value;
    public static final LogLevel DEBUG = new LogLevel("DEBUG", 0, "D");
    public static final LogLevel INFO = new LogLevel("INFO", 1, TextAttributes.INLINE_IMAGE_PLACEHOLDER);
    public static final LogLevel WARN = new LogLevel("WARN", 2, ExifInterface.LONGITUDE_WEST);
    public static final LogLevel ERROR = new LogLevel("ERROR", 3, ExifInterface.LONGITUDE_EAST);

    private static final /* synthetic */ LogLevel[] $values() {
        return new LogLevel[]{DEBUG, INFO, WARN, ERROR};
    }

    public static EnumEntries<LogLevel> getEntries() {
        return $ENTRIES;
    }

    private LogLevel(String str, int i, String str2) {
        this.value = str2;
    }

    public final String getValue() {
        return this.value;
    }

    static {
        LogLevel[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static LogLevel valueOf(String str) {
        return (LogLevel) Enum.valueOf(LogLevel.class, str);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) $VALUES.clone();
    }
}
