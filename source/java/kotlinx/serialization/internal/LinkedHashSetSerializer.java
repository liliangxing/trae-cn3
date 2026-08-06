package kotlinx.serialization.internal;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import me.ele.lancet.base.annotations.ClassOf;
import net.openid.appauth.BuildConfig;

/* compiled from: CollectionSerializers.kt */
@Metadata(m4d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012*\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0005j\b\u0012\u0004\u0012\u0002H\u0001`\u00040\u0002B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0004H\u0014¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\u0011*\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0004H\u0014¢\u0006\u0002\u0010\u0012J'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0004H\u0014¢\u0006\u0002\u0010\u0014J'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014¢\u0006\u0002\u0010\u0016J)\u0010\u0017\u001a\u00020\u0018*\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u00042\u0006\u0010\u0019\u001a\u00020\u0011H\u0014¢\u0006\u0002\u0010\u001aJ1\u0010\u001b\u001a\u00020\u0018*\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u00042\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001eR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, m5d2 = {"Lkotlinx/serialization/internal/LinkedHashSetSerializer;", "E", "Lkotlinx/serialization/internal/CollectionSerializer;", BuildConfig.FLAVOR, "Lkotlin/collections/LinkedHashSet;", "Ljava/util/LinkedHashSet;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "()Ljava/util/LinkedHashSet;", "builderSize", BuildConfig.FLAVOR, "(Ljava/util/LinkedHashSet;)I", "toResult", "(Ljava/util/LinkedHashSet;)Ljava/util/Set;", "toBuilder", "(Ljava/util/Set;)Ljava/util/LinkedHashSet;", "checkCapacity", BuildConfig.FLAVOR, "size", "(Ljava/util/LinkedHashSet;I)V", "insert", ClassOf.INDEX, "element", "(Ljava/util/LinkedHashSet;ILjava/lang/Object;)V", "kotlinx-serialization-core"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class LinkedHashSetSerializer<E> extends CollectionSerializer<E, Set<? extends E>, LinkedHashSet<E>> {
    private final SerialDescriptor descriptor;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void checkCapacity(LinkedHashSet<E> linkedHashSet, int i) {
        Intrinsics.checkNotNullParameter(linkedHashSet, "<this>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public /* bridge */ /* synthetic */ void insert(Object obj, int i, Object obj2) {
        insert((LinkedHashSet<int>) obj, i, (int) obj2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkedHashSetSerializer(KSerializer<E> eSerializer) {
        super(eSerializer);
        Intrinsics.checkNotNullParameter(eSerializer, "eSerializer");
        this.descriptor = new LinkedHashSetClassDesc(eSerializer.getDescriptor());
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public LinkedHashSet<E> builder() {
        return new LinkedHashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int builderSize(LinkedHashSet<E> linkedHashSet) {
        Intrinsics.checkNotNullParameter(linkedHashSet, "<this>");
        return linkedHashSet.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Set<E> toResult(LinkedHashSet<E> linkedHashSet) {
        Intrinsics.checkNotNullParameter(linkedHashSet, "<this>");
        return linkedHashSet;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public LinkedHashSet<E> toBuilder(Set<? extends E> set) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        LinkedHashSet<E> linkedHashSet = set instanceof LinkedHashSet ? (LinkedHashSet) set : null;
        return linkedHashSet == null ? new LinkedHashSet<>(set) : linkedHashSet;
    }

    protected void insert(LinkedHashSet<E> linkedHashSet, int i, E e) {
        Intrinsics.checkNotNullParameter(linkedHashSet, "<this>");
        linkedHashSet.add(e);
    }
}
