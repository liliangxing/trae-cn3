package kotlinx.atomicfu;

import kotlin.Metadata;
import me.ele.lancet.base.annotations.ClassOf;
import net.openid.appauth.BuildConfig;

/* compiled from: AtomicFU.common.kt */
@Metadata(m4d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t2\u0006\u0010\u0010\u001a\u00020\u0004H\u0087\u0002R\u001e\u0010\u0007\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, m5d2 = {"Lkotlinx/atomicfu/AtomicArray;", "T", BuildConfig.FLAVOR, "size", BuildConfig.FLAVOR, "<init>", "(I)V", "array", BuildConfig.FLAVOR, "Lkotlinx/atomicfu/AtomicRef;", "[Lkotlinx/atomicfu/AtomicRef;", "getSize$annotations", "()V", "getSize", "()I", "get", ClassOf.INDEX, "atomicfu"}, m6k = 1, m7mv = {2, 0, 0}, m9xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes8.dex */
public final class AtomicArray<T> {
    private final AtomicRef<T>[] array;

    public static /* synthetic */ void getSize$annotations() {
    }

    public AtomicArray(int i) {
        AtomicRef<T>[] atomicRefArr = new AtomicRef[i];
        for (int i2 = 0; i2 < i; i2++) {
            atomicRefArr[i2] = AtomicFU.atomic((Object) null);
        }
        this.array = atomicRefArr;
    }

    public final int getSize() {
        return this.array.length;
    }

    public final AtomicRef<T> get(int index) {
        return this.array[index];
    }
}
