package kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import me.ele.lancet.base.annotations.ClassOf;
import net.openid.appauth.BuildConfig;

/* compiled from: CollectionSerializers.kt */
@Metadata(m4d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003*\u0004\u0018\u0001H\u00012*\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00030\u0007j\b\u0012\u0004\u0012\u0002H\u0003`\u00060\u0004B#\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0002\u0010\u0017J\u001d\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014¢\u0006\u0002\u0010\u0019J!\u0010\u001a\u001a\u00020\u0013*\u0012\u0012\u0004\u0012\u00028\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014¢\u0006\u0002\u0010\u001bJ'\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005*\u0012\u0012\u0004\u0012\u00028\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\u0006H\u0014¢\u0006\u0002\u0010\u001dJ'\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\u0006*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0014¢\u0006\u0002\u0010\u001fJ)\u0010 \u001a\u00020!*\u0012\u0012\u0004\u0012\u00028\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010\"\u001a\u00020\u0013H\u0014¢\u0006\u0002\u0010#J1\u0010$\u001a\u00020!*\u0012\u0012\u0004\u0012\u00028\u00010\u0007j\b\u0012\u0004\u0012\u00028\u0001`\u00062\u0006\u0010%\u001a\u00020\u00132\u0006\u0010&\u001a\u00028\u0001H\u0014¢\u0006\u0002\u0010'R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006("}, m5d2 = {"Lkotlinx/serialization/internal/ReferenceArraySerializer;", "ElementKlass", BuildConfig.FLAVOR, "Element", "Lkotlinx/serialization/internal/CollectionLikeSerializer;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "kClass", "Lkotlin/reflect/KClass;", "eSerializer", "Lkotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "collectionSize", BuildConfig.FLAVOR, "([Ljava/lang/Object;)I", "collectionIterator", BuildConfig.FLAVOR, "([Ljava/lang/Object;)Ljava/util/Iterator;", "builder", "()Ljava/util/ArrayList;", "builderSize", "(Ljava/util/ArrayList;)I", "toResult", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "toBuilder", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "checkCapacity", BuildConfig.FLAVOR, "size", "(Ljava/util/ArrayList;I)V", "insert", ClassOf.INDEX, "element", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "kotlinx-serialization-core"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class ReferenceArraySerializer<ElementKlass, Element extends ElementKlass> extends CollectionLikeSerializer<Element, Element[], ArrayList<Element>> {
    private final SerialDescriptor descriptor;
    private final KClass<ElementKlass> kClass;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.CollectionLikeSerializer
    public /* bridge */ /* synthetic */ void insert(Object obj, int i, Object obj2) {
        insert((ArrayList<int>) obj, i, (int) obj2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReferenceArraySerializer(KClass<ElementKlass> kClass, KSerializer<Element> eSerializer) {
        super(eSerializer, null);
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(eSerializer, "eSerializer");
        this.kClass = kClass;
        this.descriptor = new ArrayClassDesc(eSerializer.getDescriptor());
    }

    @Override // kotlinx.serialization.internal.CollectionLikeSerializer, kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int collectionSize(Element[] elementArr) {
        Intrinsics.checkNotNullParameter(elementArr, "<this>");
        return elementArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Iterator<Element> collectionIterator(Element[] elementArr) {
        Intrinsics.checkNotNullParameter(elementArr, "<this>");
        return ArrayIteratorKt.iterator(elementArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public ArrayList<Element> builder() {
        return new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public int builderSize(ArrayList<Element> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return arrayList.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public Element[] toResult(ArrayList<Element> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return (Element[]) PlatformKt.toNativeArrayImpl(arrayList, this.kClass);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public ArrayList<Element> toBuilder(Element[] elementArr) {
        Intrinsics.checkNotNullParameter(elementArr, "<this>");
        return new ArrayList<>(ArraysKt.asList(elementArr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.AbstractCollectionSerializer
    public void checkCapacity(ArrayList<Element> arrayList, int i) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.ensureCapacity(i);
    }

    protected void insert(ArrayList<Element> arrayList, int i, Element element) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.add(i, element);
    }
}
