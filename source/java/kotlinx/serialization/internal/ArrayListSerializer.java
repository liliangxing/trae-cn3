package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import me.ele.lancet.base.annotations.ClassOf;
import net.openid.appauth.BuildConfig;

/* compiled from: CollectionSerializers.kt */
@Metadata(m4d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012*\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0005j\b\u0012\u0004\u0012\u0002H\u0001`\u00040\u0002B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0004H\u0014¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u00020\u0011*\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0004H\u0014¢\u0006\u0002\u0010\u0012J'\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0004H\u0014¢\u0006\u0002\u0010\u0014J'\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0014¢\u0006\u0002\u0010\u0016J)\u0010\u0017\u001a\u00020\u0018*\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u00042\u0006\u0010\u0019\u001a\u00020\u0011H\u0014¢\u0006\u0002\u0010\u001aJ1\u0010\u001b\u001a\u00020\u0018*\u0012\u0012\u0004\u0012\u00028\u00000\u0005j\b\u0012\u0004\u0012\u00028\u0000`\u00042\u0006\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u001dR\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001e"}, m5d2 = {"Lkotlinx/serialization/internal/ArrayListSerializer;", "E", "Lkotlinx/serialization/internal/CollectionSerializer;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "element", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "()Ljava/util/ArrayList;", "builderSize", BuildConfig.FLAVOR, "(Ljava/util/ArrayList;)I", "toResult", "(Ljava/util/ArrayList;)Ljava/util/List;", "toBuilder", "(Ljava/util/List;)Ljava/util/ArrayList;", "checkCapacity", BuildConfig.FLAVOR, "size", "(Ljava/util/ArrayList;I)V", "insert", ClassOf.INDEX, "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "kotlinx-serialization-core"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
@InternalSerializationApi
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ArrayListSerializer<E> extends CollectionSerializer<E, List<? extends E>, ArrayList<E>> {
    private final SerialDescriptor descriptor;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public /* bridge */ /* synthetic */ void insert(Object obj, int i, Object obj2) {
        insert((ArrayList<int>) obj, i, (int) obj2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArrayListSerializer(KSerializer<E> element) {
        super(element);
        Intrinsics.checkNotNullParameter(element, "element");
        this.descriptor = new ArrayListClassDesc(element.getDescriptor());
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public ArrayList<E> builder() {
        return new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int builderSize(ArrayList<E> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return arrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public List<E> toResult(ArrayList<E> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public ArrayList<E> toBuilder(List<? extends E> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList<E> arrayList = list instanceof ArrayList ? (ArrayList) list : null;
        return arrayList == null ? new ArrayList<>(list) : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void checkCapacity(ArrayList<E> arrayList, int i) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.ensureCapacity(i);
    }

    protected void insert(ArrayList<E> arrayList, int i, E e) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.add(i, e);
    }
}
