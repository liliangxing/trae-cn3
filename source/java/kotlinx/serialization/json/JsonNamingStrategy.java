package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.JsonNamingStrategy;
import net.openid.appauth.BuildConfig;

/* compiled from: JsonNamingStrategy.kt */
@Metadata(m4d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bç\u0080\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\n"}, m5d2 = {"Lkotlinx/serialization/json/JsonNamingStrategy;", BuildConfig.FLAVOR, "serialNameForJson", BuildConfig.FLAVOR, "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "elementIndex", BuildConfig.FLAVOR, "serialName", "Builtins", "kotlinx-serialization-json"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
@ExperimentalSerializationApi
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public interface JsonNamingStrategy {

    /* renamed from: Builtins, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName);

    /* compiled from: JsonNamingStrategy.kt */
    @Metadata(m4d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\b¨\u0006\u0011"}, m5d2 = {"Lkotlinx/serialization/json/JsonNamingStrategy$Builtins;", BuildConfig.FLAVOR, "<init>", "()V", "SnakeCase", "Lkotlinx/serialization/json/JsonNamingStrategy;", "getSnakeCase$annotations", "getSnakeCase", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "KebabCase", "getKebabCase$annotations", "getKebabCase", "convertCamelCase", BuildConfig.FLAVOR, "serialName", "delimiter", BuildConfig.FLAVOR, "kotlinx-serialization-json"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    @ExperimentalSerializationApi
    /* renamed from: kotlinx.serialization.json.JsonNamingStrategy$Builtins, reason: from kotlin metadata */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final JsonNamingStrategy SnakeCase = new JsonNamingStrategy() { // from class: kotlinx.serialization.json.JsonNamingStrategy$Builtins$SnakeCase$1
            public String toString() {
                return "kotlinx.serialization.json.JsonNamingStrategy.SnakeCase";
            }

            @Override // kotlinx.serialization.json.JsonNamingStrategy
            public String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName) {
                String convertCamelCase;
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                Intrinsics.checkNotNullParameter(serialName, "serialName");
                convertCamelCase = JsonNamingStrategy.Companion.$$INSTANCE.convertCamelCase(serialName, '_');
                return convertCamelCase;
            }
        };
        private static final JsonNamingStrategy KebabCase = new JsonNamingStrategy() { // from class: kotlinx.serialization.json.JsonNamingStrategy$Builtins$KebabCase$1
            public String toString() {
                return "kotlinx.serialization.json.JsonNamingStrategy.KebabCase";
            }

            @Override // kotlinx.serialization.json.JsonNamingStrategy
            public String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName) {
                String convertCamelCase;
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                Intrinsics.checkNotNullParameter(serialName, "serialName");
                convertCamelCase = JsonNamingStrategy.Companion.$$INSTANCE.convertCamelCase(serialName, '-');
                return convertCamelCase;
            }
        };

        @ExperimentalSerializationApi
        public static /* synthetic */ void getKebabCase$annotations() {
        }

        @ExperimentalSerializationApi
        public static /* synthetic */ void getSnakeCase$annotations() {
        }

        private Companion() {
        }

        public final JsonNamingStrategy getSnakeCase() {
            return SnakeCase;
        }

        public final JsonNamingStrategy getKebabCase() {
            return KebabCase;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String convertCamelCase(String serialName, char delimiter) {
            StringBuilder sb = new StringBuilder(serialName.length() * 2);
            String str = serialName;
            Character ch = null;
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                char charAt = str.charAt(i2);
                if (Character.isUpperCase(charAt)) {
                    if (i == 0) {
                        StringBuilder sb2 = sb;
                        if ((sb2.length() > 0) && StringsKt.last(sb2) != delimiter) {
                            sb.append(delimiter);
                        }
                    }
                    if (ch != null) {
                        sb.append(ch.charValue());
                    }
                    i++;
                    ch = Character.valueOf(Character.toLowerCase(charAt));
                } else {
                    if (ch != null) {
                        if (i > 1 && Character.isLetter(charAt)) {
                            sb.append(delimiter);
                        }
                        sb.append(ch.charValue());
                        ch = null;
                        i = 0;
                    }
                    sb.append(charAt);
                }
            }
            if (ch != null) {
                sb.append(ch.charValue());
            }
            String sb3 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
            return sb3;
        }
    }
}
