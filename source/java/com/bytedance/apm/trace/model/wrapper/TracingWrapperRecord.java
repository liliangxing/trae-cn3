package com.bytedance.apm.trace.model.wrapper;

import com.bytedance.apm.trace.api.ITracingSpanAbility;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/* loaded from: classes3.dex */
public class TracingWrapperRecord {
    private ITracingSpanAbility currentPopSpan;
    private Deque<ITracingSpanAbility> recordStack;
    private Map<Long, ITracingSpanAbility> subTaskMap;

    public void startTrace() {
        this.recordStack = new LinkedList();
        this.subTaskMap = new LinkedHashMap();
    }

    public void endTrace() {
        this.recordStack.clear();
        this.subTaskMap.clear();
        this.currentPopSpan = null;
    }

    public void startSpan(ITracingSpanAbility iTracingSpanAbility) {
        if (this.currentPopSpan == null) {
            this.currentPopSpan = iTracingSpanAbility;
        } else if (!this.recordStack.isEmpty()) {
            long spanId = this.recordStack.peek().getSpanId();
            iTracingSpanAbility.setParentId(spanId);
            ITracingSpanAbility iTracingSpanAbility2 = this.subTaskMap.get(Long.valueOf(spanId));
            if (iTracingSpanAbility2 != null) {
                iTracingSpanAbility.setReferenceId(iTracingSpanAbility2.getSpanId());
            }
            this.subTaskMap.put(Long.valueOf(spanId), iTracingSpanAbility);
        } else {
            iTracingSpanAbility.setReferenceId(this.currentPopSpan.getSpanId());
        }
        this.recordStack.push(iTracingSpanAbility);
    }

    public void endSpan() {
        ITracingSpanAbility poll = this.recordStack.poll();
        if (poll != null) {
            this.currentPopSpan = poll;
            this.subTaskMap.remove(Long.valueOf(poll.getSpanId()));
        }
    }

    public ITracingSpanAbility getCurrentTopSpan() {
        return this.recordStack.peek();
    }

    public ITracingSpanAbility getCurrentPopSpan() {
        return this.currentPopSpan;
    }
}
