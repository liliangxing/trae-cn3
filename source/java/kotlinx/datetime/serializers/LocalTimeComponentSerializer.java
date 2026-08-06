package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalTime;
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

/* compiled from: LocalTimeSerializers.kt */
@Metadata(m4d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, m5d2 = {"Lkotlinx/datetime/serializers/LocalTimeComponentSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/LocalTime;", "<init>", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class LocalTimeComponentSerializer implements KSerializer<LocalTime> {
    public static final LocalTimeComponentSerializer INSTANCE = new LocalTimeComponentSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("kotlinx.datetime.LocalTime", new SerialDescriptor[0], new Function1() { // from class: kotlinx.datetime.serializers.LocalTimeComponentSerializer$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            Unit descriptor$lambda$0;
            descriptor$lambda$0 = LocalTimeComponentSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
            return descriptor$lambda$0;
        }
    });

    private LocalTimeComponentSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public LocalTime deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        Short sh = null;
        Short sh2 = null;
        short s = 0;
        int i = 0;
        while (true) {
            LocalTimeComponentSerializer localTimeComponentSerializer = INSTANCE;
            int decodeElementIndex = beginStructure.decodeElementIndex(localTimeComponentSerializer.getDescriptor());
            if (decodeElementIndex == -1) {
                if (sh == null) {
                    throw new MissingFieldException("hour", localTimeComponentSerializer.getDescriptor().getSerialName());
                }
                if (sh2 == null) {
                    throw new MissingFieldException("minute", localTimeComponentSerializer.getDescriptor().getSerialName());
                }
                LocalTime localTime = new LocalTime(sh.shortValue(), sh2.shortValue(), s, i);
                beginStructure.endStructure(descriptor2);
                return localTime;
            }
            if (decodeElementIndex == 0) {
                sh = Short.valueOf(beginStructure.decodeShortElement(localTimeComponentSerializer.getDescriptor(), 0));
            } else if (decodeElementIndex == 1) {
                sh2 = Short.valueOf(beginStructure.decodeShortElement(localTimeComponentSerializer.getDescriptor(), 1));
            } else if (decodeElementIndex == 2) {
                s = beginStructure.decodeShortElement(localTimeComponentSerializer.getDescriptor(), 2);
            } else if (decodeElementIndex == 3) {
                i = beginStructure.decodeIntElement(localTimeComponentSerializer.getDescriptor(), 3);
            } else {
                throw new SerializationException("Unexpected index: " + decodeElementIndex);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, LocalTime value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        LocalTimeComponentSerializer localTimeComponentSerializer = INSTANCE;
        beginStructure.encodeShortElement(localTimeComponentSerializer.getDescriptor(), 0, (short) value.getHour());
        beginStructure.encodeShortElement(localTimeComponentSerializer.getDescriptor(), 1, (short) value.getMinute());
        if (value.getSecond() != 0 || value.getNanosecond() != 0) {
            beginStructure.encodeShortElement(localTimeComponentSerializer.getDescriptor(), 2, (short) value.getSecond());
            if (value.getNanosecond() != 0) {
                beginStructure.encodeIntElement(localTimeComponentSerializer.getDescriptor(), 3, value.getNanosecond());
            }
        }
        beginStructure.endStructure(descriptor2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        buildClassSerialDescriptor.element("hour", ShortSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        buildClassSerialDescriptor.element("minute", ShortSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), false);
        buildClassSerialDescriptor.element("second", ShortSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), true);
        buildClassSerialDescriptor.element("nanosecond", IntSerializer.INSTANCE.getDescriptor(), CollectionsKt.emptyList(), true);
        return Unit.INSTANCE;
    }
}
