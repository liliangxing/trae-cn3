package androidx.savedstate.serialization;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: SavedStateEncoder.kt */
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J!\u0010\u001c\u001a\u00020\u001d2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u001e\u001a\u00020\rH\u0002¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u0016H\u0016J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\u001aH\u0016J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020+H\u0016J\u0010\u0010,\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010/\u001a\u00020\u001d2\u0006\u00100\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u00101\u001a\u00020\u001dH\u0016J\u0016\u00102\u001a\u00020\u001d2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u001a03H\u0002J\u0016\u00104\u001a\u00020\u001d2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r03H\u0002J\u0010\u00105\u001a\u00020\u001d2\u0006\u0010\f\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u0010\f\u001a\u000208H\u0002J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020:H\u0002J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020<H\u0002J\u0010\u0010=\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020>H\u0002J\u0010\u0010?\u001a\u00020\u001d2\u0006\u0010\f\u001a\u00020@H\u0002J\u001b\u0010A\u001a\u00020\u001d2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0BH\u0002¢\u0006\u0002\u0010CJ\u0010\u0010D\u001a\u00020E2\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J)\u0010F\u001a\u00020\u001d2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0002¢\u0006\u0002\u0010GJ)\u0010H\u001a\u00020\u001d\"\u0004\b\u0000\u0010I2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HI0K2\u0006\u0010\f\u001a\u0002HIH\u0016¢\u0006\u0002\u0010LJ)\u0010M\u001a\u00020\u0016\"\u0004\b\u0000\u0010I2\f\u0010J\u001a\b\u0012\u0004\u0012\u0002HI0K2\u0006\u0010\f\u001a\u0002HIH\u0002¢\u0006\u0002\u0010NR\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006O"}, d2 = {"Landroidx/savedstate/serialization/SavedStateEncoder;", "Lkotlinx/serialization/encoding/AbstractEncoder;", "savedState", "Landroid/os/Bundle;", "Landroidx/savedstate/SavedState;", "configuration", "Landroidx/savedstate/serialization/SavedStateConfiguration;", "<init>", "(Landroid/os/Bundle;Landroidx/savedstate/serialization/SavedStateConfiguration;)V", "getSavedState$savedstate", "()Landroid/os/Bundle;", "Landroid/os/Bundle;", StrategyConstants.VALUE, "", "key", "getKey$savedstate", "()Ljava/lang/String;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "shouldEncodeElementDefault", "", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "index", "", "encodeElement", "checkDiscriminatorCollisions", "", "elementName", "(Landroid/os/Bundle;Ljava/lang/String;)V", "encodeBoolean", "encodeByte", "", "encodeShort", "", "encodeInt", "encodeLong", "", "encodeFloat", "", "encodeDouble", "", "encodeChar", "", "encodeString", "encodeEnum", "enumDescriptor", "encodeNull", "encodeIntList", "", "encodeStringList", "encodeBooleanArray", "", "encodeCharArray", "", "encodeDoubleArray", "", "encodeFloatArray", "", "encodeIntArray", "", "encodeLongArray", "", "encodeStringArray", "", "([Ljava/lang/String;)V", "beginStructure", "Lkotlinx/serialization/encoding/CompositeEncoder;", "putClassDiscriminatorIfRequired", "(Landroidx/savedstate/serialization/SavedStateConfiguration;Lkotlinx/serialization/descriptors/SerialDescriptor;Landroid/os/Bundle;)V", "encodeSerializableValue", ExifInterface.GPS_DIRECTION_TRUE, "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeFormatSpecificTypes", "(Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Z", "savedstate"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class SavedStateEncoder extends AbstractEncoder {
    private final SavedStateConfiguration configuration;
    private String key;
    private final Bundle savedState;
    private final SerializersModule serializersModule;

    /* renamed from: getSavedState$savedstate, reason: from getter */
    public final Bundle getSavedState() {
        return this.savedState;
    }

    public SavedStateEncoder(Bundle bundle, SavedStateConfiguration savedStateConfiguration) {
        Intrinsics.checkNotNullParameter(bundle, "savedState");
        Intrinsics.checkNotNullParameter(savedStateConfiguration, "configuration");
        this.savedState = bundle;
        this.configuration = savedStateConfiguration;
        this.key = "";
        this.serializersModule = savedStateConfiguration.getSerializersModule();
    }

    /* renamed from: getKey$savedstate, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.configuration.getEncodeDefaults();
    }

    public boolean encodeElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        String elementName = descriptor.getElementName(index);
        this.key = elementName;
        checkDiscriminatorCollisions(this.savedState, elementName);
        return true;
    }

    private final void checkDiscriminatorCollisions(Bundle savedState, String elementName) {
        if (this.configuration.getClassDiscriminatorMode() == 1) {
            boolean m3024containsimpl = SavedStateReader.m3024containsimpl(SavedStateReader.m3023constructorimpl(savedState), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            boolean areEqual = Intrinsics.areEqual(elementName, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            if (m3024containsimpl && areEqual) {
                throw new IllegalArgumentException("SavedStateEncoder for " + SavedStateReader.m3094getStringimpl(SavedStateReader.m3023constructorimpl(savedState), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY) + " has property '" + elementName + "' that conflicts with the class discriminator. You can rename a property with @SerialName annotation.");
            }
        }
    }

    public void encodeBoolean(boolean value) {
        SavedStateWriter.m3116putBooleanimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    public void encodeByte(byte value) {
        SavedStateWriter.m3127putIntimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    public void encodeShort(short value) {
        SavedStateWriter.m3127putIntimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    public void encodeInt(int value) {
        SavedStateWriter.m3127putIntimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    public void encodeLong(long value) {
        SavedStateWriter.m3131putLongimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    public void encodeFloat(float value) {
        SavedStateWriter.m3125putFloatimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    public void encodeDouble(double value) {
        SavedStateWriter.m3123putDoubleimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    public void encodeChar(char value) {
        SavedStateWriter.m3118putCharimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    public void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, StrategyConstants.VALUE);
        SavedStateWriter.m3143putStringimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    public void encodeEnum(SerialDescriptor enumDescriptor, int index) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        SavedStateWriter.m3127putIntimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, index);
    }

    public void encodeNull() {
        SavedStateWriter.m3133putNullimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key);
    }

    private final void encodeIntList(List<Integer> value) {
        SavedStateWriter.m3129putIntListimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeStringList(List<String> value) {
        SavedStateWriter.m3145putStringListimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeBooleanArray(boolean[] value) {
        SavedStateWriter.m3117putBooleanArrayimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeCharArray(char[] value) {
        SavedStateWriter.m3119putCharArrayimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeDoubleArray(double[] value) {
        SavedStateWriter.m3124putDoubleArrayimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeFloatArray(float[] value) {
        SavedStateWriter.m3126putFloatArrayimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeIntArray(int[] value) {
        SavedStateWriter.m3128putIntArrayimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeLongArray(long[] value) {
        SavedStateWriter.m3132putLongArrayimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    private final void encodeStringArray(String[] value) {
        SavedStateWriter.m3144putStringArrayimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, value);
    }

    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (Intrinsics.areEqual(this.key, "")) {
            putClassDiscriminatorIfRequired(this.configuration, descriptor, this.savedState);
            return (CompositeEncoder) this;
        }
        Map emptyMap = MapsKt.emptyMap();
        if (emptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(emptyMap.size());
            for (Map.Entry entry : emptyMap.entrySet()) {
                arrayList.add(TuplesKt.to((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.m3110constructorimpl(bundleOf);
        SavedStateWriter.m3137putSavedStateimpl(SavedStateWriter.m3110constructorimpl(this.savedState), this.key, bundleOf);
        putClassDiscriminatorIfRequired(this.configuration, descriptor, bundleOf);
        return new SavedStateEncoder(bundleOf, this.configuration);
    }

    private final void putClassDiscriminatorIfRequired(SavedStateConfiguration configuration, SerialDescriptor descriptor, Bundle savedState) {
        if (configuration.getClassDiscriminatorMode() == 1 && !SavedStateReader.m3024containsimpl(SavedStateReader.m3023constructorimpl(savedState), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
            if (Intrinsics.areEqual(descriptor.getKind(), StructureKind.CLASS.INSTANCE) || Intrinsics.areEqual(descriptor.getKind(), StructureKind.OBJECT.INSTANCE)) {
                SavedStateWriter.m3143putStringimpl(SavedStateWriter.m3110constructorimpl(savedState), ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, descriptor.getSerialName());
            }
        }
    }

    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T value) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (encodeFormatSpecificTypes(serializer, value)) {
            return;
        }
        super.encodeSerializableValue(serializer, value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> boolean encodeFormatSpecificTypes(SerializationStrategy<? super T> serializer, T value) {
        if (SavedStateEncoder_androidKt.encodeFormatSpecificTypesOnPlatform(this, serializer, value)) {
            return true;
        }
        SerialDescriptor descriptor = serializer.getDescriptor();
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntListDescriptor())) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
            encodeIntList((List) value);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringListDescriptor())) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            encodeStringList((List) value);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getBooleanArrayDescriptor())) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.BooleanArray");
            encodeBooleanArray((boolean[]) value);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getCharArrayDescriptor())) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.CharArray");
            encodeCharArray((char[]) value);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getDoubleArrayDescriptor())) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.DoubleArray");
            encodeDoubleArray((double[]) value);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getFloatArrayDescriptor())) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.FloatArray");
            encodeFloatArray((float[]) value);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getIntArrayDescriptor())) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.IntArray");
            encodeIntArray((int[]) value);
            return true;
        }
        if (Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getLongArrayDescriptor())) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.LongArray");
            encodeLongArray((long[]) value);
            return true;
        }
        if (!Intrinsics.areEqual(descriptor, SavedStateCodecUtilsKt.getStringArrayDescriptor())) {
            return false;
        }
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        encodeStringArray((String[]) value);
        return true;
    }
}
