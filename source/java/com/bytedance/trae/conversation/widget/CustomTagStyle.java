package com.bytedance.trae.conversation.widget;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.account.save.database.DBData;
import com.bytedance.trae.common_ui.C0591R;
import com.bytedance.trae.conversation.C0637R;
import com.bytedance.trae.im.model.MessagePart;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CustomTagStyle.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B#\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/widget/CustomTagStyle;", "", "iconRes", "", "bgColorRes", "textColorRes", "<init>", "(Ljava/lang/String;IIII)V", "getIconRes", "()I", "FOLDER", "CODE", "TERMINAL", "FILE", "TYPE_CREATE_MR", "SLASH_COMMAND", "SPEC", "getBgColor", "context", "Landroid/content/Context;", "getTextColor", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class CustomTagStyle {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CustomTagStyle[] $VALUES;
    private static final Set<String> CODE_EXTENSIONS;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int bgColorRes;
    private final int iconRes;
    private final int textColorRes;
    public static final CustomTagStyle FOLDER = new CustomTagStyle("FOLDER", 0, C0637R.drawable.ic_tag_folder, C0591R.color.trae_accent_accent_slate, C0591R.color.trae_text_text_default);
    public static final CustomTagStyle CODE = new CustomTagStyle("CODE", 1, C0637R.drawable.ic_tag_code, C0591R.color.trae_accent_accent_slate, C0591R.color.trae_text_text_default);
    public static final CustomTagStyle TERMINAL = new CustomTagStyle("TERMINAL", 2, C0637R.drawable.ic_tag_terminal, C0591R.color.trae_accent_accent_slate, C0591R.color.trae_text_text_default);
    public static final CustomTagStyle FILE = new CustomTagStyle("FILE", 3, C0637R.drawable.ic_tag_file, C0591R.color.trae_accent_accent_slate, C0591R.color.trae_text_text_default);
    public static final CustomTagStyle TYPE_CREATE_MR = new CustomTagStyle("TYPE_CREATE_MR", 4, C0637R.drawable.ic_tag_pr, C0591R.color.trae_spec_color, C0591R.color.trae_text_text_default);
    public static final CustomTagStyle SLASH_COMMAND = new CustomTagStyle("SLASH_COMMAND", 5, C0637R.drawable.ic_tag_slash, C0591R.color.trae_spec_color, C0591R.color.trae_text_text_default);
    public static final CustomTagStyle SPEC = new CustomTagStyle("SPEC", 6, C0637R.drawable.ic_tag_plan, C0591R.color.trae_spec_color, C0591R.color.trae_text_text_default);

    private static final /* synthetic */ CustomTagStyle[] $values() {
        return new CustomTagStyle[]{FOLDER, CODE, TERMINAL, FILE, TYPE_CREATE_MR, SLASH_COMMAND, SPEC};
    }

    public static EnumEntries<CustomTagStyle> getEntries() {
        return $ENTRIES;
    }

    private CustomTagStyle(String str, int i, int i2, int i3, int i4) {
        this.iconRes = i2;
        this.bgColorRes = i3;
        this.textColorRes = i4;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    static {
        CustomTagStyle[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        CODE_EXTENSIONS = SetsKt.setOf(new String[]{"kt", "java", "py", "js", "ts", "tsx", "jsx", "c", "cpp", "h", "hpp", "cs", "go", "rs", "rb", "php", "swift", "m", "mm", "scala", "groovy", "sh", "bash", "zsh", "bat", "ps1", "pl", "lua", "r", "sql", "css", "scss", "less", "sass", "xml", "json", "yaml", "yml", "toml", "ini", "cfg", "conf", "properties", "gradle", "cmake", "makefile", "dockerfile", "dart", "vue", "svelte", "zig", "nim", "ex", "exs", "erl", "hs", "ml", "mli", "clj", "cljs", "elm"});
    }

    public final int getBgColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.getColor(context, this.bgColorRes);
    }

    public final int getTextColor(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.getColor(context, this.textColorRes);
    }

    /* compiled from: CustomTagStyle.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/trae/conversation/widget/CustomTagStyle$Companion;", "", "<init>", "()V", "CODE_EXTENSIONS", "", "", "fromMessagePartType", "Lcom/bytedance/trae/conversation/widget/CustomTagStyle;", DBData.FIELD_TYPE, "messagePart", "Lcom/bytedance/trae/im/model/MessagePart;", "fromSlashCommandPartType", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
        
            if (r4 != null) goto L24;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final CustomTagStyle fromMessagePartType(String type, MessagePart messagePart) {
            String str;
            JsonObject data;
            JsonElement jsonElement;
            if (type == null) {
                return null;
            }
            switch (type.hashCode()) {
                case -1991372985:
                    if (type.equals(MessagePart.TYPE_CREATE_MR)) {
                        return CustomTagStyle.TYPE_CREATE_MR;
                    }
                    return null;
                case -1268966290:
                    if (type.equals(MessagePart.TYPE_FOLDER)) {
                        return CustomTagStyle.FOLDER;
                    }
                    return null;
                case -1181248900:
                    if (type.equals(MessagePart.TYPE_TERMINAL)) {
                        return CustomTagStyle.TERMINAL;
                    }
                    return null;
                case 3059181:
                    if (type.equals("code")) {
                        return CustomTagStyle.CODE;
                    }
                    return null;
                case 3143036:
                    if (!type.equals(MessagePart.TYPE_FILE)) {
                        return null;
                    }
                    if (messagePart != null && (data = messagePart.getData()) != null && (jsonElement = data.get("name")) != null) {
                        JsonElement jsonElement2 = jsonElement.isJsonPrimitive() ? jsonElement : null;
                        if (jsonElement2 != null) {
                            str = jsonElement2.getAsString();
                            break;
                        }
                    }
                    str = "";
                    String lowerCase = StringsKt.substringAfterLast(str, '.', "").toLowerCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    return CustomTagStyle.CODE_EXTENSIONS.contains(lowerCase) ? CustomTagStyle.CODE : CustomTagStyle.FILE;
                default:
                    return null;
            }
        }

        public final CustomTagStyle fromSlashCommandPartType(String type) {
            if (!Intrinsics.areEqual(type, "plan") && !Intrinsics.areEqual(type, "spec")) {
                return CustomTagStyle.SLASH_COMMAND;
            }
            return CustomTagStyle.SPEC;
        }
    }

    public static CustomTagStyle valueOf(String str) {
        return (CustomTagStyle) Enum.valueOf(CustomTagStyle.class, str);
    }

    public static CustomTagStyle[] values() {
        return (CustomTagStyle[]) $VALUES.clone();
    }
}
