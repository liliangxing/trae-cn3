package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.ChunkedDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;
import me.ele.lancet.base.annotations.ClassOf;
import net.openid.appauth.BuildConfig;

/* compiled from: StreamingJsonDecoder.kt */
@Metadata(m4d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u000e\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001UB1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010 \u001a\u00020!H\u0016J!\u0010\"\u001a\u0002H#\"\u0004\b\u0000\u0010#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%H\u0016¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020(2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010+\u001a\u00020*2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010,\u001a\u00020\u0013H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020*H\u0002J;\u00100\u001a\u0002H#\"\u0004\b\u0000\u0010#2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H#0%2\b\u00102\u001a\u0004\u0018\u0001H#H\u0016¢\u0006\u0002\u00103J\u0010\u00104\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u00105\u001a\u00020\u001bH\u0002J\u0018\u00106\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u001bH\u0002J\u0010\u00107\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u00108\u001a\u00020\u00132\u0006\u00109\u001a\u00020\u0015H\u0002J\b\u0010:\u001a\u00020\u001bH\u0002J\b\u0010;\u001a\u00020\u0013H\u0016J\b\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020?H\u0016J\b\u0010@\u001a\u00020\u001bH\u0016J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020\u0015H\u0002J\b\u0010J\u001a\u00020\u0015H\u0016J+\u0010K\u001a\u00020*2!\u0010L\u001a\u001d\u0012\u0013\u0012\u00110\u0015¢\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(P\u0012\u0004\u0012\u00020*0MH\u0016J\u0010\u0010Q\u001a\u00020R2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010S\u001a\u00020\u001b2\u0006\u0010T\u001a\u00020\u000bH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006V"}, m5d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/encoding/ChunkedDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "discriminatorHolder", "Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;)V", "getJson", "()Lkotlinx/serialization/json/Json;", "trySkip", BuildConfig.FLAVOR, "unknownKey", BuildConfig.FLAVOR, "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "currentIndex", BuildConfig.FLAVOR, "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "elementMarker", "Lkotlinx/serialization/json/internal/JsonElementMarker;", "decodeJsonElement", "Lkotlinx/serialization/json/JsonElement;", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "endStructure", BuildConfig.FLAVOR, "skipLeftoverElements", "decodeNotNullMark", "decodeNull", BuildConfig.FLAVOR, "checkLeadingComma", "decodeSerializableElement", ClassOf.INDEX, "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeElementIndex", "decodeMapIndex", "coerceInputValue", "decodeObjectIndex", "handleUnknown", "key", "decodeListIndex", "decodeBoolean", "decodeByte", BuildConfig.FLAVOR, "decodeShort", BuildConfig.FLAVOR, "decodeInt", "decodeLong", BuildConfig.FLAVOR, "decodeFloat", BuildConfig.FLAVOR, "decodeDouble", BuildConfig.FLAVOR, "decodeChar", BuildConfig.FLAVOR, "decodeStringKey", "decodeString", "decodeStringChunked", "consumeChunk", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "chunk", "decodeInline", "Lkotlinx/serialization/encoding/Decoder;", "decodeEnum", "enumDescriptor", "DiscriminatorHolder", "kotlinx-serialization-json"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder, ChunkedDecoder {
    private final JsonConfiguration configuration;
    private int currentIndex;
    private DiscriminatorHolder discriminatorHolder;
    private final JsonElementMarker elementMarker;
    private final Json json;
    public final AbstractJsonLexer lexer;
    private final WriteMode mode;
    private final SerializersModule serializersModule;

    /* compiled from: StreamingJsonDecoder.kt */
    @Metadata(m6k = 3, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WriteMode.values().length];
            try {
                iArr[WriteMode.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WriteMode.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WriteMode.POLY_OBJ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WriteMode.OBJ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Void decodeNull() {
        return null;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final Json getJson() {
        return this.json;
    }

    public StreamingJsonDecoder(Json json, WriteMode mode, AbstractJsonLexer lexer, SerialDescriptor descriptor, DiscriminatorHolder discriminatorHolder) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.json = json;
        this.mode = mode;
        this.lexer = lexer;
        this.serializersModule = json.getSerializersModule();
        this.currentIndex = -1;
        this.discriminatorHolder = discriminatorHolder;
        JsonConfiguration configuration = json.getConfiguration();
        this.configuration = configuration;
        this.elementMarker = configuration.getExplicitNulls() ? null : new JsonElementMarker(descriptor);
    }

    /* compiled from: StreamingJsonDecoder.kt */
    @Metadata(m4d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, m5d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonDecoder$DiscriminatorHolder;", BuildConfig.FLAVOR, "discriminatorToSkip", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "kotlinx-serialization-json"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
    public static final class DiscriminatorHolder {
        public String discriminatorToSkip;

        public DiscriminatorHolder(String str) {
            this.discriminatorToSkip = str;
        }
    }

    private final boolean trySkip(DiscriminatorHolder discriminatorHolder, String str) {
        if (discriminatorHolder == null || !Intrinsics.areEqual(discriminatorHolder.discriminatorToSkip, str)) {
            return false;
        }
        discriminatorHolder.discriminatorToSkip = null;
        return true;
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public JsonElement decodeJsonElement() {
        return new JsonTreeReader(this.json.getConfiguration(), this.lexer).read();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0177  */
    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <T> T decodeSerializableValue(DeserializationStrategy<? extends T> deserializer) {
        String message;
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        try {
        } catch (MissingFieldException e) {
            message = e.getMessage();
            Intrinsics.checkNotNull(message);
            if (StringsKt.contains$default((CharSequence) message, (CharSequence) "at path", false, 2, (Object) null)) {
            }
        }
        if ((deserializer instanceof AbstractPolymorphicSerializer) && !this.json.getConfiguration().getUseArrayPolymorphism()) {
            String classDiscriminator = PolymorphicKt.classDiscriminator(((AbstractPolymorphicSerializer) deserializer).getDescriptor(), this.json);
            String peekLeadingMatchingValue = this.lexer.peekLeadingMatchingValue(classDiscriminator, this.configuration.getIsLenient());
            if (peekLeadingMatchingValue == null) {
                StreamingJsonDecoder streamingJsonDecoder = this;
                if ((deserializer instanceof AbstractPolymorphicSerializer) && !streamingJsonDecoder.getJson().getConfiguration().getUseArrayPolymorphism()) {
                    String classDiscriminator2 = PolymorphicKt.classDiscriminator(((AbstractPolymorphicSerializer) deserializer).getDescriptor(), streamingJsonDecoder.getJson());
                    JsonElement decodeJsonElement = streamingJsonDecoder.decodeJsonElement();
                    String serialName = ((AbstractPolymorphicSerializer) deserializer).getDescriptor().getSerialName();
                    if (decodeJsonElement instanceof JsonObject) {
                        JsonObject jsonObject = (JsonObject) decodeJsonElement;
                        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) classDiscriminator2);
                        try {
                            DeserializationStrategy findPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer((AbstractPolymorphicSerializer) deserializer, streamingJsonDecoder, (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getContentOrNull(jsonPrimitive));
                            Intrinsics.checkNotNull(findPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                            return (T) TreeJsonDecoderKt.readPolymorphicJson(streamingJsonDecoder.getJson(), classDiscriminator2, jsonObject, findPolymorphicSerializer);
                        } catch (SerializationException e2) {
                            String message2 = e2.getMessage();
                            Intrinsics.checkNotNull(message2);
                            throw JsonExceptionsKt.JsonDecodingException(-1, message2, jsonObject.toString());
                        }
                    }
                    throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(decodeJsonElement.getClass()).getSimpleName() + " as the serialized body of " + serialName + " at element: " + this.lexer.path.getPath(), decodeJsonElement.toString());
                }
                return deserializer.deserialize(streamingJsonDecoder);
            }
            try {
                DeserializationStrategy findPolymorphicSerializer2 = PolymorphicSerializerKt.findPolymorphicSerializer((AbstractPolymorphicSerializer) deserializer, this, peekLeadingMatchingValue);
                Intrinsics.checkNotNull(findPolymorphicSerializer2, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.StreamingJsonDecoder.decodeSerializableValue>");
                this.discriminatorHolder = new DiscriminatorHolder(classDiscriminator);
                return (T) findPolymorphicSerializer2.deserialize(this);
            } catch (SerializationException e3) {
                String message3 = e3.getMessage();
                Intrinsics.checkNotNull(message3);
                String removeSuffix = StringsKt.removeSuffix(StringsKt.substringBefore$default(message3, '\n', (String) null, 2, (Object) null), (CharSequence) ".");
                String message4 = e3.getMessage();
                Intrinsics.checkNotNull(message4);
                AbstractJsonLexer.fail$default(this.lexer, removeSuffix, 0, StringsKt.substringAfter(message4, '\n', BuildConfig.FLAVOR), 2, null);
                throw new KotlinNothingValueException();
            }
            message = e.getMessage();
            Intrinsics.checkNotNull(message);
            if (StringsKt.contains$default((CharSequence) message, (CharSequence) "at path", false, 2, (Object) null)) {
                throw new MissingFieldException(e.getMissingFields(), e.getMessage() + " at path: " + this.lexer.path.getPath(), e);
            }
            throw e;
        }
        return deserializer.deserialize(this);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        WriteMode switchMode = WriteModeKt.switchMode(this.json, descriptor);
        this.lexer.path.pushDescriptor(descriptor);
        this.lexer.consumeNextToken(switchMode.begin);
        checkLeadingComma();
        int i = WhenMappings.$EnumSwitchMapping$0[switchMode.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return new StreamingJsonDecoder(this.json, switchMode, this.lexer, descriptor, this.discriminatorHolder);
        }
        return (this.mode == switchMode && this.json.getConfiguration().getExplicitNulls()) ? this : new StreamingJsonDecoder(this.json, switchMode, this.lexer, descriptor, this.discriminatorHolder);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.json.getConfiguration().getIgnoreUnknownKeys() && descriptor.getElementsCount() == 0) {
            skipLeftoverElements(descriptor);
        }
        if (this.lexer.tryConsumeComma() && !this.json.getConfiguration().getAllowTrailingComma()) {
            JsonExceptionsKt.invalidTrailingComma(this.lexer, BuildConfig.FLAVOR);
            throw new KotlinNothingValueException();
        }
        this.lexer.consumeNextToken(this.mode.end);
        this.lexer.path.popDescriptor();
    }

    private final void skipLeftoverElements(SerialDescriptor descriptor) {
        do {
        } while (decodeElementIndex(descriptor) != -1);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeNotNullMark() {
        JsonElementMarker jsonElementMarker = this.elementMarker;
        return ((jsonElementMarker != null ? jsonElementMarker.getIsUnmarkedNull() : false) || AbstractJsonLexer.tryConsumeNull$default(this.lexer, false, 1, null)) ? false : true;
    }

    private final void checkLeadingComma() {
        if (this.lexer.peekNextToken() != 4) {
            return;
        }
        AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public <T> T decodeSerializableElement(SerialDescriptor descriptor, int index, DeserializationStrategy<? extends T> deserializer, T previousValue) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        boolean z = this.mode == WriteMode.MAP && (index & 1) == 0;
        if (z) {
            this.lexer.path.resetCurrentMapKey();
        }
        T t = (T) super.decodeSerializableElement(descriptor, index, deserializer, previousValue);
        if (z) {
            this.lexer.path.updateCurrentMapKey(t);
        }
        return t;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int decodeElementIndex(SerialDescriptor descriptor) {
        int decodeMapIndex;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i = WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()];
        if (i == 2) {
            decodeMapIndex = decodeMapIndex();
        } else if (i == 4) {
            decodeMapIndex = decodeObjectIndex(descriptor);
        } else {
            decodeMapIndex = decodeListIndex();
        }
        if (this.mode != WriteMode.MAP) {
            this.lexer.path.updateDescriptorIndex(decodeMapIndex);
        }
        return decodeMapIndex;
    }

    private final int decodeMapIndex() {
        int i = this.currentIndex;
        boolean z = false;
        boolean z2 = i % 2 != 0;
        if (!z2) {
            this.lexer.consumeNextToken(AbstractJsonLexerKt.COLON);
        } else if (i != -1) {
            z = this.lexer.tryConsumeComma();
        }
        if (this.lexer.canConsumeValue()) {
            if (z2) {
                if (this.currentIndex != -1) {
                    AbstractJsonLexer abstractJsonLexer = this.lexer;
                    int i2 = abstractJsonLexer.currentPosition;
                    if (!z) {
                        AbstractJsonLexer.fail$default(abstractJsonLexer, "Expected comma after the key-value pair", i2, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    AbstractJsonLexer abstractJsonLexer2 = this.lexer;
                    boolean z3 = !z;
                    int i3 = abstractJsonLexer2.currentPosition;
                    if (!z3) {
                        AbstractJsonLexer.fail$default(abstractJsonLexer2, "Unexpected leading comma", i3, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            int i4 = this.currentIndex + 1;
            this.currentIndex = i4;
            return i4;
        }
        if (!z || this.json.getConfiguration().getAllowTrailingComma()) {
            return -1;
        }
        JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
        throw new KotlinNothingValueException();
    }

    private final boolean coerceInputValue(SerialDescriptor descriptor, int index) {
        String peekString;
        Json json = this.json;
        boolean isElementOptional = descriptor.isElementOptional(index);
        SerialDescriptor elementDescriptor = descriptor.getElementDescriptor(index);
        if (isElementOptional && !elementDescriptor.isNullable() && this.lexer.tryConsumeNull(true)) {
            return true;
        }
        if (Intrinsics.areEqual(elementDescriptor.getKind(), SerialKind.ENUM.INSTANCE) && ((!elementDescriptor.isNullable() || !this.lexer.tryConsumeNull(false)) && (peekString = this.lexer.peekString(this.configuration.getIsLenient())) != null)) {
            int jsonNameIndex = JsonNamesMapKt.getJsonNameIndex(elementDescriptor, json, peekString);
            boolean z = !json.getConfiguration().getExplicitNulls() && elementDescriptor.isNullable();
            if (jsonNameIndex == -3 && (isElementOptional || z)) {
                this.lexer.consumeString();
                return true;
            }
        }
        return false;
    }

    private final int decodeObjectIndex(SerialDescriptor descriptor) {
        int jsonNameIndex;
        boolean z;
        boolean tryConsumeComma = this.lexer.tryConsumeComma();
        while (true) {
            boolean z2 = true;
            if (this.lexer.canConsumeValue()) {
                String decodeStringKey = decodeStringKey();
                this.lexer.consumeNextToken(AbstractJsonLexerKt.COLON);
                jsonNameIndex = JsonNamesMapKt.getJsonNameIndex(descriptor, this.json, decodeStringKey);
                if (jsonNameIndex == -3) {
                    z = false;
                } else {
                    if (!this.configuration.getCoerceInputValues() || !coerceInputValue(descriptor, jsonNameIndex)) {
                        break;
                    }
                    z = this.lexer.tryConsumeComma();
                    z2 = false;
                }
                tryConsumeComma = z2 ? handleUnknown(decodeStringKey) : z;
            } else {
                if (tryConsumeComma && !this.json.getConfiguration().getAllowTrailingComma()) {
                    JsonExceptionsKt.invalidTrailingComma$default(this.lexer, null, 1, null);
                    throw new KotlinNothingValueException();
                }
                JsonElementMarker jsonElementMarker = this.elementMarker;
                if (jsonElementMarker != null) {
                    return jsonElementMarker.nextUnmarkedIndex$kotlinx_serialization_json();
                }
                return -1;
            }
        }
        JsonElementMarker jsonElementMarker2 = this.elementMarker;
        if (jsonElementMarker2 != null) {
            jsonElementMarker2.mark$kotlinx_serialization_json(jsonNameIndex);
        }
        return jsonNameIndex;
    }

    private final boolean handleUnknown(String key) {
        if (this.configuration.getIgnoreUnknownKeys() || trySkip(this.discriminatorHolder, key)) {
            this.lexer.skipElement(this.configuration.getIsLenient());
        } else {
            this.lexer.failOnUnknownKey(key);
        }
        return this.lexer.tryConsumeComma();
    }

    private final int decodeListIndex() {
        boolean tryConsumeComma = this.lexer.tryConsumeComma();
        if (this.lexer.canConsumeValue()) {
            int i = this.currentIndex;
            if (i != -1 && !tryConsumeComma) {
                AbstractJsonLexer.fail$default(this.lexer, "Expected end of the array or comma", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            int i2 = i + 1;
            this.currentIndex = i2;
            return i2;
        }
        if (!tryConsumeComma || this.json.getConfiguration().getAllowTrailingComma()) {
            return -1;
        }
        JsonExceptionsKt.invalidTrailingComma(this.lexer, "array");
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean decodeBoolean() {
        return this.lexer.consumeBooleanLenient();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public byte decodeByte() {
        long consumeNumericLiteral = this.lexer.consumeNumericLiteral();
        byte b = (byte) consumeNumericLiteral;
        if (consumeNumericLiteral == b) {
            return b;
        }
        AbstractJsonLexer.fail$default(this.lexer, "Failed to parse byte for input '" + consumeNumericLiteral + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public short decodeShort() {
        long consumeNumericLiteral = this.lexer.consumeNumericLiteral();
        short s = (short) consumeNumericLiteral;
        if (consumeNumericLiteral == s) {
            return s;
        }
        AbstractJsonLexer.fail$default(this.lexer, "Failed to parse short for input '" + consumeNumericLiteral + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int decodeInt() {
        long consumeNumericLiteral = this.lexer.consumeNumericLiteral();
        int i = (int) consumeNumericLiteral;
        if (consumeNumericLiteral == i) {
            return i;
        }
        AbstractJsonLexer.fail$default(this.lexer, "Failed to parse int for input '" + consumeNumericLiteral + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public long decodeLong() {
        return this.lexer.consumeNumericLiteral();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public float decodeFloat() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            float parseFloat = Float.parseFloat(consumeStringLenient);
            if (!this.json.getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (!((Float.isInfinite(parseFloat) || Float.isNaN(parseFloat)) ? false : true)) {
                    JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, Float.valueOf(parseFloat));
                    throw new KotlinNothingValueException();
                }
            }
            return parseFloat;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse type 'float' for input '" + consumeStringLenient + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public double decodeDouble() {
        AbstractJsonLexer abstractJsonLexer = this.lexer;
        String consumeStringLenient = abstractJsonLexer.consumeStringLenient();
        try {
            double parseDouble = Double.parseDouble(consumeStringLenient);
            if (!this.json.getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (!((Double.isInfinite(parseDouble) || Double.isNaN(parseDouble)) ? false : true)) {
                    JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, Double.valueOf(parseDouble));
                    throw new KotlinNothingValueException();
                }
            }
            return parseDouble;
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.fail$default(abstractJsonLexer, "Failed to parse type 'double' for input '" + consumeStringLenient + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public char decodeChar() {
        String consumeStringLenient = this.lexer.consumeStringLenient();
        if (consumeStringLenient.length() != 1) {
            AbstractJsonLexer.fail$default(this.lexer, "Expected single char, but got '" + consumeStringLenient + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        return consumeStringLenient.charAt(0);
    }

    private final String decodeStringKey() {
        if (this.configuration.getIsLenient()) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeKeyString();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public String decodeString() {
        if (this.configuration.getIsLenient()) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeString();
    }

    @Override // kotlinx.serialization.encoding.ChunkedDecoder
    public void decodeStringChunked(Function1<? super String, Unit> consumeChunk) {
        Intrinsics.checkNotNullParameter(consumeChunk, "consumeChunk");
        this.lexer.consumeStringChunked(this.configuration.getIsLenient(), consumeChunk);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Decoder decodeInline(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return StreamingJsonEncoderKt.isUnsignedNumber(descriptor) ? new JsonDecoderForUnsignedTypes(this.lexer, this.json) : super.decodeInline(descriptor);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.getJsonNameIndexOrThrow(enumDescriptor, this.json, decodeString(), " at path " + this.lexer.path.getPath());
    }
}
