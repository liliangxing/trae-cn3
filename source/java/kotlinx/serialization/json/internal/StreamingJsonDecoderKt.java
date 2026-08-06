package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import net.openid.appauth.BuildConfig;

/* compiled from: StreamingJsonDecoder.kt */
@Metadata(m4d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a9\u0010\t\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\n2\u0006\u0010\u000b\u001a\u00020\b2\u0017\u0010\f\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u00020\r¢\u0006\u0002\b\u000eH\u0082\b¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, m5d2 = {"decodeStringToJsonTree", "Lkotlinx/serialization/json/JsonElement;", "T", "json", "Lkotlinx/serialization/json/Json;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "source", BuildConfig.FLAVOR, "parseString", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "expectedType", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/json/internal/AbstractJsonLexer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-serialization-json"}, m6k = 2, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class StreamingJsonDecoderKt {
    @JsonFriendModuleApi
    public static final <T> JsonElement decodeStringToJsonTree(Json json, DeserializationStrategy<? extends T> deserializer, String source) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(source, "source");
        StringJsonLexer StringJsonLexer = StringJsonLexerKt.StringJsonLexer(json, source);
        JsonElement decodeJsonElement = new StreamingJsonDecoder(json, WriteMode.OBJ, StringJsonLexer, deserializer.getDescriptor(), null).decodeJsonElement();
        StringJsonLexer.expectEof();
        return decodeJsonElement;
    }

    private static final <T> T parseString(AbstractJsonLexer abstractJsonLexer, String str, Function1<? super String, ? extends T> function1) {
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            return function1.invoke(consumeStringLenient);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse type '" + str + "' for input '" + consumeStringLenient + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }
}
