package com.ttnet.org.chromium.base.task;

import android.view.Choreographer;
import com.ttnet.org.chromium.base.ThreadUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DefaultTaskExecutor implements TaskExecutor {
    private final Map<TaskTraits, TaskRunner> mTraitsToRunnerMap = new HashMap();

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public boolean canRunTaskImmediately(TaskTraits taskTraits) {
        return false;
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public TaskRunner createTaskRunner(TaskTraits taskTraits) {
        return taskTraits.mIsChoreographerFrame ? createChoreographerTaskRunner() : new TaskRunnerImpl(taskTraits);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SequencedTaskRunner createSequencedTaskRunner(TaskTraits taskTraits) {
        return taskTraits.mIsChoreographerFrame ? createChoreographerTaskRunner() : new SequencedTaskRunnerImpl(taskTraits);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public SingleThreadTaskRunner createSingleThreadTaskRunner(TaskTraits taskTraits) {
        return taskTraits.mIsChoreographerFrame ? createChoreographerTaskRunner() : new SingleThreadTaskRunnerImpl(null, taskTraits);
    }

    @Override // com.ttnet.org.chromium.base.task.TaskExecutor
    public synchronized void postDelayedTask(TaskTraits taskTraits, Runnable runnable, long j) {
        if (taskTraits.hasExtension()) {
            createTaskRunner(taskTraits).postDelayedTask(runnable, j);
        } else {
            TaskRunner taskRunner = this.mTraitsToRunnerMap.get(taskTraits);
            if (taskRunner == null) {
                taskRunner = createTaskRunner(taskTraits);
                this.mTraitsToRunnerMap.put(taskTraits, taskRunner);
            }
            taskRunner.postDelayedTask(runnable, j);
        }
    }

    private synchronized ChoreographerTaskRunner createChoreographerTaskRunner() {
        return (ChoreographerTaskRunner) ThreadUtils.runOnUiThreadBlockingNoException(new Callable() { // from class: com.ttnet.org.chromium.base.task.DefaultTaskExecutor$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultTaskExecutor.lambda$createChoreographerTaskRunner$0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ChoreographerTaskRunner lambda$createChoreographerTaskRunner$0() throws Exception {
        return new ChoreographerTaskRunner(Choreographer.getInstance());
    }
}
