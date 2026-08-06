package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalDateTime;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.ShortSerializer;
import net.openid.appauth.BuildConfig;

/* compiled from: LocalDateTimeSerializers.kt */
@Metadata(m4d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, m5d2 = {"Lkotlinx/datetime/serializers/LocalDateTimeComponentSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/LocalDateTime;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class LocalDateTimeComponentSerializer implements KSerializer<LocalDateTime> {
    public static final LocalDateTimeComponentSerializer INSTANCE = new LocalDateTimeComponentSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.datetime.LocalDateTime", new SerialDescriptor[0], new Function1() { // from class: kotlinx.datetime.serializers.LocalDateTimeComponentSerializer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Unit descriptor$lambda$0;
            descriptor$lambda$0 = LocalDateTimeComponentSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            return descriptor$lambda$0;
        }
    });

    private LocalDateTimeComponentSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LocalDateTime deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        Integer num = null;
        Short sh = null;
        Short sh2 = null;
        Short sh3 = null;
        Short sh4 = null;
        short s = 0;
        int i = 0;
        while (true) {
            LocalDateTimeComponentSerializer localDateTimeComponentSerializer = INSTANCE;
            int decodeElementIndex = beginStructure.decodeElementIndex(localDateTimeComponentSerializer.getDescriptor());
            switch (decodeElementIndex) {
                case -1:
                    if (num == null) {
                        throw new MissingFieldException("year", localDateTimeComponentSerializer.getDescriptor().getSerialName());
                    }
                    if (sh == null) {
                        throw new MissingFieldException("month", localDateTimeComponentSerializer.getDescriptor().getSerialName());
                    }
                    if (sh2 == null) {
                        throw new MissingFieldException("day", localDateTimeComponentSerializer.getDescriptor().getSerialName());
                    }
                    if (sh3 == null) {
                        throw new MissingFieldException("hour", localDateTimeComponentSerializer.getDescriptor().getSerialName());
                    }
                    if (sh4 == null) {
                        throw new MissingFieldException("minute", localDateTimeComponentSerializer.getDescriptor().getSerialName());
                    }
                    LocalDateTime localDateTime = new LocalDateTime(num.intValue(), sh.shortValue(), sh2.shortValue(), sh3.shortValue(), sh4.shortValue(), s, i);
                    beginStructure.endStructure(descriptor2);
                    return localDateTime;
                case 0:
                    num = Integer.valueOf(beginStructure.decodeIntElement(localDateTimeComponentSerializer.getDescriptor(), 0));
                    break;
                case 1:
                    sh = Short.valueOf(beginStructure.decodeShortElement(localDateTimeComponentSerializer.getDescriptor(), 1));
                    break;
                case 2:
                    sh2 = Short.valueOf(beginStructure.decodeShortElement(localDateTimeComponentSerializer.getDescriptor(), 2));
                    break;
                case 3:
                    sh3 = Short.valueOf(beginStructure.decodeShortElement(localDateTimeComponentSerializer.getDescriptor(), 3));
                    break;
                case 4:
                    sh4 = Short.valueOf(beginStructure.decodeShortElement(localDateTimeComponentSerializer.getDescriptor(), 4));
                    break;
                case 5:
                    s = beginStructure.decodeShortElement(localDateTimeComponentSerializer.getDescriptor(), 5);
                    break;
                case 6:
                    i = beginStructure.decodeIntElement(localDateTimeComponentSerializer.getDescriptor(), 6);
                    break;
                default:
                    throw new SerializationException("Unexpected index: " + decodeElementIndex);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LocalDateTime value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        LocalDateTimeComponentSerializer localDateTimeComponentSerializer = INSTANCE;
        beginStructure.encodeIntElement(localDateTimeComponentSerializer.getDescriptor(), 0, value.getYear());
        beginStructure.encodeShortElement(localDateTimeComponentSerializer.getDescriptor(), 1, (short) value.getMonthNumber());
        beginStructure.encodeShortElement(localDateTimeComponentSerializer.getDescriptor(), 2, (short) value.getDayOfMonth());
        beginStructure.encodeShortElement(localDateTimeComponentSerializer.getDescriptor(), 3, (short) value.getHour());
        beginStructure.encodeShortElement(localDateTimeComponentSerializer.getDescriptor(), 4, (short) value.getMinute());
        if (value.getSecond() != 0 || value.getNanosecond() != 0) {
            beginStructure.encodeShortElement(localDateTimeComponentSerializer.getDescriptor(), 5, (short) value.getSecond());
            if (value.getNanosecond() != 0) {
                beginStructure.encodeIntElement(localDateTimeComponentSerializer.getDescriptor(), 6, value.getNanosecond());
            }
        }
        beginStructure.endStructure(descriptor2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        buildClassSerialDescriptor.element("year", IntSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        buildClassSerialDescriptor.element("month", ShortSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        buildClassSerialDescriptor.element("day", ShortSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        buildClassSerialDescriptor.element("hour", ShortSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        buildClassSerialDescriptor.element("minute", ShortSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        buildClassSerialDescriptor.element("second", ShortSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), true);
        buildClassSerialDescriptor.element("nanosecond", IntSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), true);
        return Unit.INSTANCE;
    }
}
