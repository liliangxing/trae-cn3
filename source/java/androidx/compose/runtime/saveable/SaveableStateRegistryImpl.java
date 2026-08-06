package androidx.compose.runtime.saveable;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SaveableStateRegistry.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B9\u0012\u001c\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\u0003\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000fH\u0016J\u001c\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u0003H\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0002\u001a\u0018\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000f0\u000e\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/saveable/SaveableStateRegistryImpl;", "Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "restored", "", "", "", "", "canBeSaved", "Lkotlin/Function1;", "", "<init>", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)V", "Landroidx/collection/MutableScatterMap;", "valueProviders", "", "Lkotlin/Function0;", "value", "consumeRestored", "key", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "performSave", "runtime-saveable"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes.dex */
public final class SaveableStateRegistryImpl implements SaveableStateRegistry {
    private final Function1<Object, Boolean> canBeSaved;
    private final MutableScatterMap<String, List<Object>> restored;
    private MutableScatterMap<String, List<Function0<Object>>> valueProviders;

    public SaveableStateRegistryImpl(Map<String, ? extends List<? extends Object>> map, Function1<Object, Boolean> function1) {
        this.canBeSaved = function1;
        this.restored = !(map == null || map.isEmpty()) ? SaveableStateRegistryKt.toMutableScatterMap(map) : null;
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public boolean canBeSaved(Object value) {
        return ((Boolean) this.canBeSaved.invoke(value)).booleanValue();
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Object consumeRestored(String key) {
        MutableScatterMap<String, List<Object>> mutableScatterMap;
        MutableScatterMap<String, List<Object>> mutableScatterMap2 = this.restored;
        List<Object> remove = mutableScatterMap2 != null ? mutableScatterMap2.remove(key) : null;
        List<Object> list = remove;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (remove.size() > 1 && (mutableScatterMap = this.restored) != null) {
            mutableScatterMap.put(key, remove.subList(1, remove.size()));
        }
        return remove.get(0);
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public SaveableStateRegistry.Entry registerProvider(final String key, final Function0<? extends Object> valueProvider) {
        boolean fastIsBlank;
        fastIsBlank = SaveableStateRegistryKt.fastIsBlank(key);
        if (!(!fastIsBlank)) {
            throw new IllegalArgumentException("Registered key is empty or blank".toString());
        }
        final MutableScatterMap<String, List<Function0<Object>>> mutableScatterMap = this.valueProviders;
        if (mutableScatterMap == null) {
            mutableScatterMap = ScatterMapKt.mutableScatterMapOf();
            this.valueProviders = mutableScatterMap;
        }
        ArrayList arrayList = mutableScatterMap.get(key);
        if (arrayList == null) {
            arrayList = new ArrayList();
            mutableScatterMap.set(key, arrayList);
        }
        arrayList.add(valueProvider);
        return new SaveableStateRegistry.Entry() { // from class: androidx.compose.runtime.saveable.SaveableStateRegistryImpl$registerProvider$3
            @Override // androidx.compose.runtime.saveable.SaveableStateRegistry.Entry
            public void unregister() {
                List<Function0<Object>> remove = mutableScatterMap.remove(key);
                if (remove != null) {
                    remove.remove(valueProvider);
                }
                List<Function0<Object>> list = remove;
                if (list == null || list.isEmpty()) {
                    return;
                }
                mutableScatterMap.set(key, remove);
            }
        };
    }

    @Override // androidx.compose.runtime.saveable.SaveableStateRegistry
    public Map<String, List<Object>> performSave() {
        long[] jArr;
        Object[] objArr;
        int i;
        long[] jArr2;
        Object[] objArr2;
        int i2;
        MutableScatterMap<String, List<Object>> mutableScatterMap = this.restored;
        if (mutableScatterMap == null && this.valueProviders == null) {
            return MapsKt.emptyMap();
        }
        int size = mutableScatterMap != null ? mutableScatterMap.get_size() : 0;
        MutableScatterMap<String, List<Function0<Object>>> mutableScatterMap2 = this.valueProviders;
        HashMap hashMap = new HashMap(size + (mutableScatterMap2 != null ? mutableScatterMap2.get_size() : 0));
        MutableScatterMap<String, List<Object>> mutableScatterMap3 = this.restored;
        long j = 255;
        char c = 7;
        long j2 = -9187201950435737472L;
        int i3 = 8;
        if (mutableScatterMap3 != null) {
            MutableScatterMap<String, List<Object>> mutableScatterMap4 = mutableScatterMap3;
            Object[] objArr3 = mutableScatterMap4.keys;
            Object[] objArr4 = mutableScatterMap4.values;
            long[] jArr3 = mutableScatterMap4.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i4 = 0;
                while (true) {
                    long j3 = jArr3[i4];
                    if ((((~j3) << 7) & j3 & j2) != j2) {
                        int i5 = 8 - ((~(i4 - length)) >>> 31);
                        int i6 = 0;
                        while (i6 < i5) {
                            if ((j3 & j) < 128) {
                                int i7 = (i4 << 3) + i6;
                                hashMap.put((String) objArr3[i7], (List) objArr4[i7]);
                            }
                            j3 >>= 8;
                            i6++;
                            j = 255;
                        }
                        if (i5 != 8) {
                            break;
                        }
                    }
                    if (i4 == length) {
                        break;
                    }
                    i4++;
                    j = 255;
                    j2 = -9187201950435737472L;
                }
            }
        }
        MutableScatterMap<String, List<Function0<Object>>> mutableScatterMap5 = this.valueProviders;
        if (mutableScatterMap5 != null) {
            MutableScatterMap<String, List<Function0<Object>>> mutableScatterMap6 = mutableScatterMap5;
            Object[] objArr5 = mutableScatterMap6.keys;
            Object[] objArr6 = mutableScatterMap6.values;
            long[] jArr4 = mutableScatterMap6.metadata;
            int length2 = jArr4.length - 2;
            if (length2 >= 0) {
                int i8 = 0;
                while (true) {
                    long j4 = jArr4[i8];
                    if ((((~j4) << c) & j4 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i9 = 8 - ((~(i8 - length2)) >>> 31);
                        int i10 = 0;
                        while (i10 < i9) {
                            if ((j4 & 255) < 128) {
                                int i11 = (i8 << 3) + i10;
                                Object obj = objArr5[i11];
                                List list = (List) objArr6[i11];
                                String str = (String) obj;
                                if (list.size() == 1) {
                                    Object invoke = ((Function0) list.get(0)).invoke();
                                    if (invoke == null) {
                                        jArr2 = jArr4;
                                    } else {
                                        if (!canBeSaved(invoke)) {
                                            throw new IllegalStateException(RememberSaveableKt.generateCannotBeSavedErrorMessage(invoke).toString());
                                        }
                                        jArr2 = jArr4;
                                        hashMap.put(str, CollectionsKt.arrayListOf(new Object[]{invoke}));
                                    }
                                    objArr2 = objArr5;
                                } else {
                                    jArr2 = jArr4;
                                    HashMap hashMap2 = hashMap;
                                    int size2 = list.size();
                                    ArrayList arrayList = new ArrayList(size2);
                                    int i12 = 0;
                                    while (i12 < size2) {
                                        Object[] objArr7 = objArr5;
                                        Object invoke2 = ((Function0) list.get(i12)).invoke();
                                        if (invoke2 != null && !canBeSaved(invoke2)) {
                                            throw new IllegalStateException(RememberSaveableKt.generateCannotBeSavedErrorMessage(invoke2).toString());
                                        }
                                        arrayList.add(invoke2);
                                        i12++;
                                        objArr5 = objArr7;
                                    }
                                    objArr2 = objArr5;
                                    hashMap2.put(str, arrayList);
                                }
                                i2 = 8;
                            } else {
                                jArr2 = jArr4;
                                objArr2 = objArr5;
                                i2 = i3;
                            }
                            j4 >>= i2;
                            i10++;
                            i3 = i2;
                            jArr4 = jArr2;
                            objArr5 = objArr2;
                        }
                        jArr = jArr4;
                        objArr = objArr5;
                        i = i3;
                        if (i9 != i) {
                            break;
                        }
                    } else {
                        jArr = jArr4;
                        objArr = objArr5;
                        i = i3;
                    }
                    if (i8 == length2) {
                        break;
                    }
                    i8++;
                    i3 = i;
                    jArr4 = jArr;
                    objArr5 = objArr;
                    c = 7;
                }
            }
        }
        return hashMap;
    }
}
