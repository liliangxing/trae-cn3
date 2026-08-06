package androidx.compose.p001ui.precompose;

import com.bytedance.framwork.core.sdklib.apm6.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PausableSubPreComposeController.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0013\u001a\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nJ\u0010\u0010\u0016\u001a\u00020\u0017H\u0080@¢\u0006\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/precompose/PausableSubPreComposeController;", "", "precomposeCount", "", "<init>", "(I)V", "getPrecomposeCount", "()I", Constants.KEY_LIST, "", "Lkotlin/Function0;", "", "Landroidx/compose/ui/precompose/PausableSubPreComposeController$PausableSubPreComposeTask;", "inPausablePreCompose", "", "getInPausablePreCompose", "()Z", "setInPausablePreCompose", "(Z)V", "registerSubPreComposeTask", "Landroidx/compose/ui/precompose/Disposable;", "block", "triggerSubPreCompose", "", "triggerSubPreCompose$ui_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PausableSubPreComposeTask", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class PausableSubPreComposeController {
    public static final int $stable = 8;
    private boolean inPausablePreCompose;
    private final List<Function0<List<PausableSubPreComposeTask>>> list;
    private final int precomposeCount;

    /* compiled from: PausableSubPreComposeController.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0005À\u0006\u0001"}, d2 = {"Landroidx/compose/ui/precompose/PausableSubPreComposeController$PausableSubPreComposeTask;", "", "await", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public interface PausableSubPreComposeTask {
        Object await(Continuation<? super Unit> continuation);
    }

    public PausableSubPreComposeController() {
        this(0, 1, null);
    }

    public PausableSubPreComposeController(int i) {
        this.precomposeCount = i;
        this.list = new ArrayList();
        this.inPausablePreCompose = true;
    }

    public /* synthetic */ PausableSubPreComposeController(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? -1 : i);
    }

    public final int getPrecomposeCount() {
        return this.precomposeCount;
    }

    public final boolean getInPausablePreCompose() {
        return this.inPausablePreCompose;
    }

    public final void setInPausablePreCompose(boolean z) {
        this.inPausablePreCompose = z;
    }

    public final Disposable registerSubPreComposeTask(final Function0<? extends List<? extends PausableSubPreComposeTask>> block) {
        this.list.add(block);
        return new Disposable() { // from class: androidx.compose.ui.precompose.PausableSubPreComposeController$registerSubPreComposeTask$1
            @Override // androidx.compose.p001ui.precompose.Disposable
            public void dispose() {
                List list;
                list = PausableSubPreComposeController.this.list;
                list.remove(block);
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object triggerSubPreCompose$ui_release(Continuation<? super Unit> continuation) {
        PausableSubPreComposeController$triggerSubPreCompose$1 pausableSubPreComposeController$triggerSubPreCompose$1;
        int i;
        Iterator it;
        if (continuation instanceof PausableSubPreComposeController$triggerSubPreCompose$1) {
            pausableSubPreComposeController$triggerSubPreCompose$1 = (PausableSubPreComposeController$triggerSubPreCompose$1) continuation;
            if ((pausableSubPreComposeController$triggerSubPreCompose$1.label & Integer.MIN_VALUE) != 0) {
                pausableSubPreComposeController$triggerSubPreCompose$1.label -= Integer.MIN_VALUE;
                Object obj = pausableSubPreComposeController$triggerSubPreCompose$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = pausableSubPreComposeController$triggerSubPreCompose$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    List<Function0<List<PausableSubPreComposeTask>>> list = this.list;
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        CollectionsKt.addAll(arrayList, (Iterable) ((Function0) it2.next()).invoke());
                    }
                    this.list.clear();
                    it = arrayList.iterator();
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) pausableSubPreComposeController$triggerSubPreCompose$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                while (it.hasNext()) {
                    PausableSubPreComposeTask pausableSubPreComposeTask = (PausableSubPreComposeTask) it.next();
                    pausableSubPreComposeController$triggerSubPreCompose$1.L$0 = it;
                    pausableSubPreComposeController$triggerSubPreCompose$1.label = 1;
                    if (pausableSubPreComposeTask.await(pausableSubPreComposeController$triggerSubPreCompose$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                this.inPausablePreCompose = false;
                return Unit.INSTANCE;
            }
        }
        pausableSubPreComposeController$triggerSubPreCompose$1 = new PausableSubPreComposeController$triggerSubPreCompose$1(this, continuation);
        Object obj2 = pausableSubPreComposeController$triggerSubPreCompose$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = pausableSubPreComposeController$triggerSubPreCompose$1.label;
        if (i != 0) {
        }
        while (it.hasNext()) {
        }
        this.inPausablePreCompose = false;
        return Unit.INSTANCE;
    }
}
