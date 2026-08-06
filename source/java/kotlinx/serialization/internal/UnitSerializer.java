package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import net.openid.appauth.BuildConfig;

/* compiled from: Primitives.kt */
@Metadata(m4d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0096\u0001J\u0019\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0096\u0001R\t\u0010\f\u001a\u00020\rX\u0096\u0005¨\u0006\u000e"}, m5d2 = {"Lkotlinx/serialization/internal/UnitSerializer;", "Lkotlinx/serialization/KSerializer;", BuildConfig.FLAVOR, "<init>", "()V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "kotlinx-serialization-core"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class UnitSerializer implements KSerializer<Unit> {
    public static final UnitSerializer INSTANCE = new UnitSerializer();
    private final /* synthetic */ ObjectSerializer<Unit> $$delegate_0 = new ObjectSerializer<>("kotlin.Unit", Unit.INSTANCE);

    /* renamed from: deserialize, reason: collision with other method in class */
    public void m2060deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        this.$$delegate_0.deserialize(decoder);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.$$delegate_0.getDescriptor();
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Unit value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        this.$$delegate_0.serialize(encoder, value);
    }

    private UnitSerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        m2060deserialize(decoder);
        return Unit.INSTANCE;
    }
}
