package androidx.compose.runtime.snapshots;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* compiled from: SnapshotStateObserver.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR,\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\u0003\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/runtime/snapshots/ScopeInvalidationContext;", "", "<init>", "()V", "currentScope", "getCurrentScope$annotations", "getCurrentScope", "()Ljava/lang/Object;", "setCurrentScope", "(Ljava/lang/Object;)V", "currentTriggerStates", "", "getCurrentTriggerStates$annotations", "getCurrentTriggerStates", "()Ljava/util/List;", "setCurrentTriggerStates", "(Ljava/util/List;)V", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScopeInvalidationContext {
    private static Object currentScope;
    private static List<? extends Object> currentTriggerStates;
    public static final ScopeInvalidationContext INSTANCE = new ScopeInvalidationContext();
    public static final int $stable = 8;

    @JvmStatic
    public static /* synthetic */ void getCurrentScope$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getCurrentTriggerStates$annotations() {
    }

    private ScopeInvalidationContext() {
    }

    public static final Object getCurrentScope() {
        return currentScope;
    }

    public static final void setCurrentScope(Object obj) {
        currentScope = obj;
    }

    public static final List<Object> getCurrentTriggerStates() {
        return currentTriggerStates;
    }

    public static final void setCurrentTriggerStates(List<? extends Object> list) {
        currentTriggerStates = list;
    }
}
