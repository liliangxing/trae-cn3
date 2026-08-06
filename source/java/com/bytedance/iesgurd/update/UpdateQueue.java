package com.bytedance.iesgurd.update;

import com.bytedance.geckox.GeckoUpdateParams;
import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.policy.queue.PriorityTagTask;
import com.bytedance.geckox.policy.queue.UpdateTaskManager;
import com.bytedance.geckox.utils.GeckoExecutors;
import com.bytedance.iesgurd.core.GlobalManager;
import com.bytedance.iesgurd.meta.PrepareMeta;
import com.bytedance.pia.core.cache.IPiaCacheProvider;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpdateQueue.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/iesgurd/update/UpdateQueue;", "", "()V", "channelUpdating", "", "postFix", "Ljava/util/concurrent/atomic/AtomicInteger;", "add", "", "metas", "", "Lcom/bytedance/iesgurd/meta/PrepareMeta;", "params", "Lcom/bytedance/geckox/GeckoUpdateParams;", "addTask", IPiaCacheProvider.CacheConfig.FIELD_META, "checkIsUpdating", "", "accessKey", "channel", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UpdateQueue {
    public static final UpdateQueue INSTANCE = new UpdateQueue();
    private static final AtomicInteger postFix = new AtomicInteger(1);
    private static String channelUpdating = "";

    private UpdateQueue() {
    }

    public final void add(List<PrepareMeta> metas, GeckoUpdateParams params) {
        Intrinsics.checkParameterIsNotNull(metas, "metas");
        Intrinsics.checkParameterIsNotNull(params, "params");
        GeckoLogger.d("UpdateQueue add: " + metas.size() + '-' + params.getPriority().ordinal());
        Iterator<T> it = metas.iterator();
        while (it.hasNext()) {
            INSTANCE.addTask((PrepareMeta) it.next(), params);
        }
    }

    public final boolean checkIsUpdating(String accessKey, String channel) {
        Intrinsics.checkParameterIsNotNull(accessKey, "accessKey");
        Intrinsics.checkParameterIsNotNull(channel, "channel");
        return Intrinsics.areEqual(channelUpdating, accessKey + '_' + channel);
    }

    private final void addTask(final PrepareMeta meta, final GeckoUpdateParams params) {
        if (meta.getTimeAddQueue() == 0) {
            meta.setTimeAddQueue(System.currentTimeMillis());
        }
        final int ordinal = ((3 - params.getPriority().ordinal()) * 10000000) + postFix.getAndIncrement();
        final PriorityTagTask.TaskProps taskProps = new PriorityTagTask.TaskProps(meta.getReqType(), meta.getAccessKey(), meta.getGroupName(), meta.getChannel());
        GeckoExecutors.INSTANCE.getUpdateExecutor().execute(new PriorityTagTask(ordinal, taskProps) { // from class: com.bytedance.iesgurd.update.UpdateQueue$addTask$1
            public void run() {
                GeckoLogger.d("[" + PrepareMeta.this + "]UpdateQueue execute: " + ordinal);
                UpdateTaskManager updateTaskManager = GlobalManager.INSTANCE.getUpdateTaskManager();
                if (updateTaskManager != null && updateTaskManager.waitIfPaused()) {
                    GeckoLogger.d("UpdateQueue execute update task manager return");
                    return;
                }
                UpdateQueue updateQueue = UpdateQueue.INSTANCE;
                UpdateQueue.channelUpdating = PrepareMeta.this.getAccessKey() + '_' + PrepareMeta.this.getChannel();
                new Updater(PrepareMeta.this, params).start();
                UpdateQueue updateQueue2 = UpdateQueue.INSTANCE;
                UpdateQueue.channelUpdating = "";
            }
        });
    }
}
