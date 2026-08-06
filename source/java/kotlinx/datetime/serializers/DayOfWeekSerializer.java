package kotlinx.datetime.serializers;

import bytedance.jvm.time.DayOfWeek;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import net.openid.appauth.BuildConfig;

/* compiled from: DayOfWeekSerializers.kt */
@Metadata(m4d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0003j\u0002`\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00060\u0003j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001J\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0003j\u0002`\u0002H\u0096\u0001R\t\u0010\u000e\u001a\u00020\u000fX\u0096\u0005¨\u0006\u0010"}, m5d2 = {"Lkotlinx/datetime/serializers/DayOfWeekSerializer;", "Lkotlinx/serialization/KSerializer;", "Lkotlinx/datetime/DayOfWeek;", "Lbytedance/jvm/time/DayOfWeek;", "<init>", "()V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", BuildConfig.FLAVOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-datetime_release"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class DayOfWeekSerializer implements KSerializer<DayOfWeek> {
    public static final DayOfWeekSerializer INSTANCE = new DayOfWeekSerializer();
    private final /* synthetic */ KSerializer<DayOfWeek> $$delegate_0 = MonthSerializersKt.createEnumSerializer("kotlinx.datetime.DayOfWeek", DayOfWeek.values());

    @Override // kotlinx.serialization.DeserializationStrategy
    public DayOfWeek deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return this.$$delegate_0.deserialize(decoder);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.$$delegate_0.getDescriptor();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DayOfWeek value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        this.$$delegate_0.serialize(encoder, value);
    }

    private DayOfWeekSerializer() {
    }
}
