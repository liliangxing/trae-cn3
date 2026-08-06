package com.bytedance.tracing.core;

import com.bytedance.apm.util.ListUtils;
import java.util.LinkedList;
import java.util.Map;

@Deprecated
/* loaded from: classes5.dex */
public final class TraceWrapper {
    private static final String TAG = "test_trace";
    private static final ThreadLocal<LinkedList<Span>> sThreadTraceSpan = new ThreadLocal<>();
    private static final ThreadLocal<LinkedList<String>> sThreadTraceName = new ThreadLocal<>();

    /* loaded from: classes5.dex */
    public static final class TraceContext {
        String mTraceName;
        Span mTraceSpan;

        TraceContext(Span span, String str) {
            this.mTraceSpan = span;
            this.mTraceName = str;
        }
    }

    public static void startTrace(String str) {
        ThreadLocal<LinkedList<String>> threadLocal = sThreadTraceName;
        LinkedList<String> linkedList = threadLocal.get();
        if (linkedList == null) {
            linkedList = new LinkedList<>();
            threadLocal.set(linkedList);
        }
        linkedList.push(str);
    }

    public static void endTrace() {
        LinkedList<String> linkedList = sThreadTraceName.get();
        if (ListUtils.isEmpty(linkedList)) {
            return;
        }
        linkedList.pop();
    }

    public static TraceContext getFrozenContext() {
        LinkedList<Span> linkedList = sThreadTraceSpan.get();
        LinkedList<String> linkedList2 = sThreadTraceName.get();
        if (ListUtils.isEmpty(linkedList) || ListUtils.isEmpty(linkedList2)) {
            return null;
        }
        return new TraceContext(linkedList.peek(), linkedList2.peek());
    }

    public static void applyTraceContext(TraceContext traceContext) {
        ThreadLocal<LinkedList<Span>> threadLocal = sThreadTraceSpan;
        LinkedList<Span> linkedList = threadLocal.get();
        ThreadLocal<LinkedList<String>> threadLocal2 = sThreadTraceName;
        LinkedList<String> linkedList2 = threadLocal2.get();
        if (!ListUtils.isEmpty(linkedList)) {
            linkedList.clear();
        } else if (linkedList == null) {
            linkedList = new LinkedList<>();
            threadLocal.set(linkedList);
        }
        if (!ListUtils.isEmpty(linkedList2)) {
            linkedList2.clear();
        } else if (linkedList2 == null) {
            linkedList2 = new LinkedList<>();
            threadLocal2.set(linkedList2);
        }
        linkedList.push(traceContext.mTraceSpan);
        linkedList2.push(traceContext.mTraceName);
    }

    public static void clearTraceContext() {
        LinkedList<Span> linkedList = sThreadTraceSpan.get();
        LinkedList<String> linkedList2 = sThreadTraceName.get();
        if (!ListUtils.isEmpty(linkedList)) {
            linkedList.clear();
        }
        if (ListUtils.isEmpty(linkedList2)) {
            return;
        }
        linkedList2.clear();
    }

    public static void beginSectionCurrentThread(String str) {
        ThreadLocal<LinkedList<Span>> threadLocal = sThreadTraceSpan;
        LinkedList<Span> linkedList = threadLocal.get();
        LinkedList<String> linkedList2 = sThreadTraceName.get();
        if (linkedList == null) {
            if (linkedList2 == null) {
                return;
            }
            linkedList = new LinkedList<>();
            threadLocal.set(linkedList);
        }
        if (linkedList.isEmpty()) {
            linkedList.push(new Span(linkedList2 != null ? linkedList2.peek() : null, str).start());
            return;
        }
        Span peek = linkedList.peek();
        if (peek.getFinishTs() > 0) {
            linkedList.pop();
            Span peek2 = linkedList.peek();
            if (peek2 == null) {
                linkedList.push(peek.makeChild(str).start());
                return;
            } else {
                linkedList.push(peek2.makeChildAndRef(str, peek.getSpanId()).start());
                return;
            }
        }
        linkedList.push(peek.makeChild(str).start());
    }

    public static void endSectionCurrentThread() {
        Span peek;
        LinkedList<Span> linkedList = sThreadTraceSpan.get();
        if (ListUtils.isEmpty(linkedList) || (peek = linkedList.peek()) == null) {
            return;
        }
        if (peek.getFinishTs() > 0) {
            peek = linkedList.pop();
        }
        peek.getFinishTs();
        peek.finish();
    }

    public static void addTraceTag(String str, String str2) {
        Span peek;
        LinkedList<Span> linkedList = sThreadTraceSpan.get();
        if (ListUtils.isEmpty(linkedList) || (peek = linkedList.peek()) == null) {
            return;
        }
        peek.addTag(str, str2);
    }

    public static void addErrTag(String str) {
        addTraceTag("error", str);
    }

    public static void addTraceLog(String str, Map<String, String> map) {
        Span peek;
        LinkedList<Span> linkedList = sThreadTraceSpan.get();
        if (ListUtils.isEmpty(linkedList) || (peek = linkedList.peek()) == null) {
            return;
        }
        peek.addLog(str, map);
    }

    public static void addTraceLog(String str) {
        Span peek;
        LinkedList<Span> linkedList = sThreadTraceSpan.get();
        if (ListUtils.isEmpty(linkedList) || (peek = linkedList.peek()) == null) {
            return;
        }
        peek.addLog(str);
    }

    private static String stringMulti(String str, int i) {
        StringBuilder sb = new StringBuilder(str.length() * i);
        while (i > 0) {
            sb.append(str);
            i--;
        }
        return sb.toString();
    }
}
