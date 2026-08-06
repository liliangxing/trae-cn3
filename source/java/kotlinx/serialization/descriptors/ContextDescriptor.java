package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.text.Typography;
import kotlinx.serialization.ExperimentalSerializationApi;
import me.ele.lancet.base.annotations.ClassOf;
import net.openid.appauth.BuildConfig;

/* compiled from: ContextAware.kt */
@Metadata(m4d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0010H\u0097\u0001J\u0011\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0010H\u0097\u0001J\u0011\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\bH\u0097\u0001J\u0011\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0010H\u0097\u0001J\u0011\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0010H\u0097\u0001R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0016X\u0097\u0005R\u000b\u0010\u001c\u001a\u00020\u00108\u0016X\u0097\u0005R\t\u0010\u001d\u001a\u00020\fX\u0096\u0005R\u000b\u0010\u001e\u001a\u00020\f8\u0016X\u0097\u0005R\u000b\u0010\u001f\u001a\u00020 8\u0016X\u0097\u0005¨\u0006!"}, m5d2 = {"Lkotlinx/serialization/descriptors/ContextDescriptor;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "original", "kClass", "Lkotlin/reflect/KClass;", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/reflect/KClass;)V", "serialName", BuildConfig.FLAVOR, "getSerialName", "()Ljava/lang/String;", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "getElementAnnotations", BuildConfig.FLAVOR, BuildConfig.FLAVOR, ClassOf.INDEX, "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", "annotations", "elementsCount", "isInline", "isNullable", "kind", "Lkotlinx/serialization/descriptors/SerialKind;", "kotlinx-serialization-core"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
final class ContextDescriptor implements SerialDescriptor {
    public final KClass<?> kClass;
    private final SerialDescriptor original;
    private final String serialName;

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List<Annotation> getAnnotations() {
        return this.original.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @ExperimentalSerializationApi
    public List<Annotation> getElementAnnotations(int index) {
        return this.original.getElementAnnotations(index);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @ExperimentalSerializationApi
    public SerialDescriptor getElementDescriptor(int index) {
        return this.original.getElementDescriptor(index);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @ExperimentalSerializationApi
    public int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.original.getElementIndex(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @ExperimentalSerializationApi
    public String getElementName(int index) {
        return this.original.getElementName(index);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int getElementsCount() {
        return this.original.getElementsCount();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind getKind() {
        return this.original.getKind();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @ExperimentalSerializationApi
    public boolean isElementOptional(int index) {
        return this.original.isElementOptional(index);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    /* renamed from: isInline */
    public boolean getIsInline() {
        return this.original.getIsInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isNullable() {
        return this.original.isNullable();
    }

    public ContextDescriptor(SerialDescriptor original, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        this.original = original;
        this.kClass = kClass;
        this.serialName = original.getSerialName() + Typography.less + kClass.getSimpleName() + Typography.greater;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String getSerialName() {
        return this.serialName;
    }

    public boolean equals(Object other) {
        ContextDescriptor contextDescriptor = other instanceof ContextDescriptor ? (ContextDescriptor) other : null;
        return contextDescriptor != null && Intrinsics.areEqual(this.original, contextDescriptor.original) && Intrinsics.areEqual(contextDescriptor.kClass, this.kClass);
    }

    public int hashCode() {
        return (this.kClass.hashCode() * 31) + getSerialName().hashCode();
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.kClass + ", original: " + this.original + ')';
    }
}
