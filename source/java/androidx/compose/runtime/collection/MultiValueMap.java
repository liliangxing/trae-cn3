package androidx.compose.runtime.collection;

import androidx.autofill.HintConstants;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterMap;
import androidx.collection.ObjectList;
import androidx.collection.ObjectListKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: MultiValueMap.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081@\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u001d\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u0001¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00162\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u0012¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u0004\u0018\u00018\u00012\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\"\u0010 J\u0013\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016¢\u0006\u0004\b$\u0010%J;\u0010&\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002!\u0010'\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\t0(H\u0086\b¢\u0006\u0004\b+\u0010,J8\u0010-\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u00002!\u0010.\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0004\b/\u0010,J\u0013\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u000205HÖ\u0001R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0004\u0092\u0001\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005¨\u00066"}, d2 = {"Landroidx/compose/runtime/collection/MultiValueMap;", "K", "", "V", "map", "Landroidx/collection/MutableScatterMap;", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "add", "", "key", "value", "add-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "clear", "clear-impl", "(Landroidx/collection/MutableScatterMap;)V", "contains", "", "contains-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "get", "Landroidx/collection/ObjectList;", "get-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Landroidx/collection/ObjectList;", "isEmpty", "isEmpty-impl", "(Landroidx/collection/MutableScatterMap;)Z", "isNotEmpty", "isNotEmpty-impl", "removeLast", "removeLast-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Ljava/lang/Object;", "removeFirst", "removeFirst-impl", "values", "values-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/ObjectList;", "forEachValue", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "forEachValue-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "removeValueIf", "condition", "removeValueIf-impl", "equals", "other", "hashCode", "", "toString", "", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class MultiValueMap<K, V> {
    private final MutableScatterMap<Object, Object> map;

    /* renamed from: box-impl */
    public static final /* synthetic */ MultiValueMap m4187boximpl(MutableScatterMap mutableScatterMap) {
        return new MultiValueMap(mutableScatterMap);
    }

    /* renamed from: constructor-impl */
    public static <K, V> MutableScatterMap<Object, Object> m4189constructorimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap;
    }

    /* renamed from: equals-impl */
    public static boolean m4192equalsimpl(MutableScatterMap<Object, Object> mutableScatterMap, Object obj) {
        return (obj instanceof MultiValueMap) && Intrinsics.areEqual(mutableScatterMap, ((MultiValueMap) obj).getMap());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m4193equalsimpl0(MutableScatterMap<Object, Object> mutableScatterMap, MutableScatterMap<Object, Object> mutableScatterMap2) {
        return Intrinsics.areEqual(mutableScatterMap, mutableScatterMap2);
    }

    /* renamed from: hashCode-impl */
    public static int m4196hashCodeimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    /* renamed from: toString-impl */
    public static String m4202toStringimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return "MultiValueMap(map=" + mutableScatterMap + ')';
    }

    public boolean equals(Object other) {
        return m4192equalsimpl(this.map, other);
    }

    public int hashCode() {
        return m4196hashCodeimpl(this.map);
    }

    public String toString() {
        return m4202toStringimpl(this.map);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ MutableScatterMap getMap() {
        return this.map;
    }

    private /* synthetic */ MultiValueMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    /* renamed from: constructor-impl$default */
    public static /* synthetic */ MutableScatterMap m4190constructorimpl$default(MutableScatterMap mutableScatterMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            mutableScatterMap = new MutableScatterMap(0, 1, null);
        }
        return m4189constructorimpl(mutableScatterMap);
    }

    /* renamed from: clear-impl */
    public static final void m4188clearimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        mutableScatterMap.clear();
    }

    /* renamed from: contains-impl */
    public static final boolean m4191containsimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k) {
        return mutableScatterMap.contains(k);
    }

    /* renamed from: get-impl */
    public static final ObjectList<V> m4195getimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k) {
        Object obj = mutableScatterMap.get(k);
        if (obj == null) {
            return ObjectListKt.emptyObjectList();
        }
        return obj instanceof MutableObjectList ? (ObjectList) obj : ObjectListKt.objectListOf(obj);
    }

    /* renamed from: isEmpty-impl */
    public static final boolean m4197isEmptyimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.isEmpty();
    }

    /* renamed from: isNotEmpty-impl */
    public static final boolean m4198isNotEmptyimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        return mutableScatterMap.isNotEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: removeLast-impl */
    public static final V m4200removeLastimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k) {
        V v = (V) mutableScatterMap.get(k);
        if (v == 0) {
            return null;
        }
        if (v instanceof MutableObjectList) {
            MutableObjectList mutableObjectList = (MutableObjectList) v;
            V v2 = (V) ExtensionsKt.removeLast(mutableObjectList);
            Intrinsics.checkNotNull(v2, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
            if (mutableObjectList.isEmpty()) {
                mutableScatterMap.remove(k);
            }
            if (mutableObjectList.getSize() == 1) {
                mutableScatterMap.set(k, mutableObjectList.first());
            }
            return v2;
        }
        mutableScatterMap.remove(k);
        return v;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: removeFirst-impl */
    public static final V m4199removeFirstimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k) {
        V v = (V) mutableScatterMap.get(k);
        if (v == 0) {
            return null;
        }
        if (v instanceof MutableObjectList) {
            MutableObjectList mutableObjectList = (MutableObjectList) v;
            V v2 = (V) mutableObjectList.removeAt(0);
            if (mutableObjectList.isEmpty()) {
                mutableScatterMap.remove(k);
            }
            if (mutableObjectList.getSize() == 1) {
                mutableScatterMap.set(k, mutableObjectList.first());
            }
            return v2;
        }
        mutableScatterMap.remove(k);
        return v;
    }

    /* renamed from: values-impl */
    public static final ObjectList<V> m4203valuesimpl(MutableScatterMap<Object, Object> mutableScatterMap) {
        if (mutableScatterMap.isEmpty()) {
            return ObjectListKt.emptyObjectList();
        }
        MutableObjectList mutableObjectList = new MutableObjectList(0, 1, null);
        MutableScatterMap<Object, Object> mutableScatterMap2 = mutableScatterMap;
        Object[] objArr = mutableScatterMap2.values;
        long[] jArr = mutableScatterMap2.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            Object obj = objArr[(i << 3) + i3];
                            if (obj instanceof MutableObjectList) {
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.collection.MutableObjectList<V of androidx.compose.runtime.collection.MultiValueMap>");
                                mutableObjectList.addAll((MutableObjectList) obj);
                            } else {
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
                                mutableObjectList.add(obj);
                            }
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    }
                }
                if (i == length) {
                    break;
                }
                i++;
            }
        }
        return mutableObjectList;
    }

    /* renamed from: forEachValue-impl */
    public static final void m4194forEachValueimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k, Function1<? super V, Unit> function1) {
        Object obj = mutableScatterMap.get(k);
        if (obj != null) {
            if (obj instanceof MutableObjectList) {
                ObjectList objectList = (ObjectList) obj;
                Object[] objArr = objectList.content;
                int i = objectList._size;
                for (int i2 = 0; i2 < i; i2++) {
                    Object obj2 = objArr[i2];
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type V of androidx.compose.runtime.collection.MultiValueMap");
                    function1.invoke(obj2);
                }
                return;
            }
            function1.invoke(obj);
        }
    }

    /* renamed from: removeValueIf-impl */
    public static final void m4201removeValueIfimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k, Function1<? super V, Boolean> function1) {
        Object obj = mutableScatterMap.get(k);
        if (obj != null) {
            if (obj instanceof MutableObjectList) {
                MutableObjectList mutableObjectList = (MutableObjectList) obj;
                int i = mutableObjectList._size;
                Object[] objArr = mutableObjectList.content;
                int i2 = 0;
                IntRange until = RangesKt.until(0, mutableObjectList._size);
                int first = until.getFirst();
                int last = until.getLast();
                if (first <= last) {
                    while (true) {
                        objArr[first - i2] = objArr[first];
                        if (((Boolean) function1.invoke(objArr[first])).booleanValue()) {
                            i2++;
                        }
                        if (first == last) {
                            break;
                        } else {
                            first++;
                        }
                    }
                }
                ArraysKt.fill(objArr, (Object) null, i - i2, i);
                mutableObjectList._size -= i2;
                if (mutableObjectList.isEmpty()) {
                    mutableScatterMap.remove(k);
                }
                if (mutableObjectList.getSize() == 0) {
                    mutableScatterMap.set(k, mutableObjectList.first());
                    return;
                }
                return;
            }
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                mutableScatterMap.remove(k);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: add-impl */
    public static final void m4186addimpl(MutableScatterMap<Object, Object> mutableScatterMap, K k, V v) {
        int findInsertIndex = mutableScatterMap.findInsertIndex(k);
        boolean z = findInsertIndex < 0;
        Object obj = z ? null : mutableScatterMap.values[findInsertIndex];
        TypeIntrinsics.isMutableList(obj);
        if (obj != null) {
            if (obj instanceof MutableObjectList) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.collection.MutableObjectList<kotlin.Any>");
                MutableObjectList mutableObjectList = (MutableObjectList) obj;
                mutableObjectList.add(v);
                v = mutableObjectList;
            } else {
                v = (V) ObjectListKt.mutableObjectListOf(obj, v);
            }
        }
        if (z) {
            int i = ~findInsertIndex;
            mutableScatterMap.keys[i] = k;
            mutableScatterMap.values[i] = v;
            return;
        }
        mutableScatterMap.values[findInsertIndex] = v;
    }
}
