package com.lynx.animax.setter;

import com.lynx.animax.AnimaXPlayer;
import com.lynx.animax.util.AnimaXLog;
import java.lang.ref.WeakReference;
import java.util.PriorityQueue;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class UIAnimaXPropsPrioritySetter {
    private static final String TAG = "UIAnimaXPropsPrioritySetter";
    private WeakReference<AnimaXPlayer> mPlayer;
    private final PriorityQueue<PrioritizedTask> prioritizedTasks = new PriorityQueue<>();

    @FunctionalInterface
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public interface PlayerTask {
        void run(AnimaXPlayer animaXPlayer) throws Exception;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class PrioritizedTask implements Comparable<PrioritizedTask> {
        final ExecutionPriority priority;
        final PlayerTask task;

        PrioritizedTask(PlayerTask playerTask, ExecutionPriority executionPriority) {
            this.task = playerTask;
            this.priority = executionPriority;
        }

        @Override // java.lang.Comparable
        public int compareTo(PrioritizedTask prioritizedTask) {
            return Integer.compare(this.priority.getValue(), prioritizedTask.priority.getValue());
        }
    }

    public void init(AnimaXPlayer animaXPlayer) {
        this.mPlayer = new WeakReference<>(animaXPlayer);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public enum ExecutionPriority {
        HIGH(-100),
        DEFAULT(0),
        LOW(100);

        private final int value;

        ExecutionPriority(int i) {
            this.value = i;
        }

        public int getValue() {
            return this.value;
        }
    }

    public void enqueueTask(PlayerTask playerTask) {
        enqueueTask(playerTask, ExecutionPriority.DEFAULT);
    }

    public void enqueueTask(PlayerTask playerTask, ExecutionPriority executionPriority) {
        this.prioritizedTasks.add(new PrioritizedTask(playerTask, executionPriority));
    }

    public void flush() {
        AnimaXPlayer animaXPlayer = this.mPlayer.get();
        if (animaXPlayer == null) {
            return;
        }
        while (!this.prioritizedTasks.isEmpty()) {
            PrioritizedTask poll = this.prioritizedTasks.poll();
            if (poll != null) {
                try {
                    poll.task.run(animaXPlayer);
                } catch (Exception e) {
                    AnimaXLog.m2540e(TAG, "Failed to run pending tasks with exception: " + e.getMessage());
                }
            }
        }
    }
}
