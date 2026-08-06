package com.bytedance.forest.preload;

import com.bytedance.applog.server.Api;
import com.bytedance.forest.utils.CacheIdentifier;
import com.bytedance.forest.utils.LogUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: PreLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\f\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u001dR\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\nj\b\u0012\u0004\u0012\u00020\b`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/bytedance/forest/preload/Recorder;", "", "maxProducingCount", "", "maxPreparingCount", "(II)V", "preparingTasks", "Ljava/util/LinkedList;", "Lcom/bytedance/forest/preload/PreloadTask;", "producingTasks", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fetchLatestPreparingTask", "fetchLatestPreparingTask$forest_release", "findPreparingTask", Api.KEY_ENCRYPT_RESP_KEY, "Lcom/bytedance/forest/utils/CacheIdentifier;", "findProducingTask", "findProducingTask$forest_release", "isPreloadPerformed", "", "isPreloadPerformed$forest_release", "onProducingFinish", "", "onProducingFinish$forest_release", "prepareToProduce", "task", "prepareToProduce$forest_release", "removePreparingTask", "removePreparingTask$forest_release", "forest_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class Recorder {
    private final int maxPreparingCount;
    private final int maxProducingCount;
    private final LinkedList<PreloadTask> preparingTasks;
    private final ArrayList<PreloadTask> producingTasks;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Recorder() {
        this(r2, r2, 3, null);
        int i = 0;
    }

    public Recorder(int i, int i2) {
        this.maxProducingCount = i;
        this.maxPreparingCount = i2;
        this.preparingTasks = new LinkedList<>();
        this.producingTasks = new ArrayList<>(i);
    }

    public /* synthetic */ Recorder(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 3 : i, (i3 & 2) != 0 ? 30 : i2);
    }

    public final boolean prepareToProduce$forest_release(PreloadTask task) {
        Intrinsics.checkParameterIsNotNull(task, "task");
        synchronized (this.producingTasks) {
            if (this.preparingTasks.size() >= this.maxProducingCount) {
                LogUtils.i$default(LogUtils.INSTANCE, PreLoader.TAG, "can not producing " + task.getKey() + ", cause " + this.preparingTasks.size() + " in producing, maxProducingCount=" + this.maxProducingCount, false, null, null, null, 60, null);
                Unit unit = Unit.INSTANCE;
                synchronized (this.preparingTasks) {
                    if (this.preparingTasks.size() >= this.maxPreparingCount) {
                        LogUtils.d$default(LogUtils.INSTANCE, PreLoader.TAG, "eliminate " + this.preparingTasks.removeFirst() + " for inserting " + task, false, null, null, null, 60, null);
                    }
                    this.preparingTasks.add(task);
                }
                return false;
            }
            synchronized (this.preparingTasks) {
                this.preparingTasks.remove(task);
            }
            this.producingTasks.add(task);
            return true;
        }
    }

    public final void removePreparingTask$forest_release(CacheIdentifier key) {
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        synchronized (this.preparingTasks) {
            PreloadTask findPreparingTask = findPreparingTask(key);
            LinkedList<PreloadTask> linkedList = this.preparingTasks;
            if (linkedList == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            }
            TypeIntrinsics.asMutableCollection(linkedList).remove(findPreparingTask);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void onProducingFinish$forest_release(CacheIdentifier key) {
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        synchronized (this.producingTasks) {
            PreloadTask findProducingTask$forest_release = findProducingTask$forest_release(key);
            ArrayList<PreloadTask> arrayList = this.producingTasks;
            if (arrayList == null) {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            }
            TypeIntrinsics.asMutableCollection(arrayList).remove(findProducingTask$forest_release);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final PreloadTask findPreparingTask(CacheIdentifier key) {
        Object obj;
        PreloadTask preloadTask;
        synchronized (this.preparingTasks) {
            Iterator<T> it = this.preparingTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((PreloadTask) obj).getKey(), key)) {
                    break;
                }
            }
            preloadTask = (PreloadTask) obj;
        }
        return preloadTask;
    }

    public final PreloadTask fetchLatestPreparingTask$forest_release() {
        Object obj;
        PreloadTask preloadTask;
        synchronized (this.preparingTasks) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(this.preparingTasks.removeLast());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            preloadTask = (PreloadTask) obj;
        }
        return preloadTask;
    }

    public final PreloadTask findProducingTask$forest_release(CacheIdentifier key) {
        Object obj;
        PreloadTask preloadTask;
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        synchronized (this.producingTasks) {
            Iterator<T> it = this.producingTasks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((PreloadTask) obj).getKey(), key)) {
                    break;
                }
            }
            preloadTask = (PreloadTask) obj;
        }
        return preloadTask;
    }

    public final boolean isPreloadPerformed$forest_release(CacheIdentifier key) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(key, Api.KEY_ENCRYPT_RESP_KEY);
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Boolean.valueOf(findProducingTask$forest_release(key) != null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Boolean bool = (Boolean) obj;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }
}
