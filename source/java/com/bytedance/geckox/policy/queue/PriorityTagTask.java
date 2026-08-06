package com.bytedance.geckox.policy.queue;

import com.bytedance.iesgurd.core.ReqType;

/* loaded from: classes3.dex */
public abstract class PriorityTagTask implements Runnable, Comparable<PriorityTagTask> {
    public int priority;
    public TaskProps taskProps;

    public PriorityTagTask(int i, TaskProps taskProps) {
        this.priority = i;
        this.taskProps = taskProps;
    }

    public int getPriority() {
        return this.priority;
    }

    public TaskProps getTaskProps() {
        return this.taskProps;
    }

    @Override // java.lang.Comparable
    public int compareTo(PriorityTagTask priorityTagTask) {
        if (getPriority() < priorityTagTask.getPriority()) {
            return -1;
        }
        return getPriority() > priorityTagTask.getPriority() ? 1 : 0;
    }

    /* loaded from: classes3.dex */
    public static class TaskProps {
        public String accessKey;
        public String channel;
        public String group;
        public ReqType reqType;

        public TaskProps(ReqType reqType, String str, String str2, String str3) {
            this.reqType = reqType;
            this.accessKey = str;
            this.group = str2;
            this.channel = str3;
        }
    }
}
