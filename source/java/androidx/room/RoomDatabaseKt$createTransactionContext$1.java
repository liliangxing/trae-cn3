package androidx.room;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RoomDatabase.kt */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.room.RoomDatabaseKt", f = "RoomDatabase.kt", i = {0, 0}, l = {99}, m = "createTransactionContext", n = {"$this$createTransactionContext", "controlJob"}, s = {"L$0", "L$1"})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class RoomDatabaseKt$createTransactionContext$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RoomDatabaseKt$createTransactionContext$1(Continuation<? super RoomDatabaseKt$createTransactionContext$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        Object createTransactionContext;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        createTransactionContext = RoomDatabaseKt.createTransactionContext(null, (Continuation) this);
        return createTransactionContext;
    }
}
