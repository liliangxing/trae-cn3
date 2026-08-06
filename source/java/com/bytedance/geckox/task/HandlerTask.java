package com.bytedance.geckox.task;

import java.util.Map;

/* loaded from: classes3.dex */
public abstract class HandlerTask<T> {
    public T data;
    public Map<String, Object> extra;
    public long period;

    public abstract void execute();

    public abstract int taskType();
}
