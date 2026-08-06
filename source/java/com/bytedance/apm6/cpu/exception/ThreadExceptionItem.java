package com.bytedance.apm6.cpu.exception;

import java.util.Objects;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class ThreadExceptionItem {
    private double cpuUsage;
    private StackTraceElement firstElement;
    private int priority;
    private long processCpuTime;
    private String stack;
    private long threadCpuTime;
    private int threadId;
    private String threadName;
    private String weight;

    public StackTraceElement getFirstElement() {
        return this.firstElement;
    }

    public void setFirstElement(StackTraceElement stackTraceElement) {
        this.firstElement = stackTraceElement;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public String getWeight() {
        return this.weight;
    }

    public void setWeight(String str) {
        this.weight = str;
    }

    public long getProcessCpuTime() {
        return this.processCpuTime;
    }

    public void setProcessCpuTime(long j) {
        this.processCpuTime = j;
    }

    public String getStack() {
        return this.stack;
    }

    public void setStack(String str) {
        this.stack = str;
    }

    public double getCpuUsage() {
        return this.cpuUsage;
    }

    public void setCpuUsage(double d) {
        this.cpuUsage = d;
    }

    public int getThreadId() {
        return this.threadId;
    }

    public void setThreadId(int i) {
        this.threadId = i;
    }

    public String getThreadName() {
        return this.threadName;
    }

    public void setThreadName(String str) {
        this.threadName = str;
    }

    public long getThreadCpuTime() {
        return this.threadCpuTime;
    }

    public void setThreadCpuTime(long j) {
        this.threadCpuTime = j;
    }

    public String getKey() {
        return this.threadName + "/" + this.threadId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ThreadExceptionItem)) {
            return false;
        }
        ThreadExceptionItem threadExceptionItem = (ThreadExceptionItem) obj;
        return getThreadId() == threadExceptionItem.getThreadId() && getThreadName().equals(threadExceptionItem.getThreadName());
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(getThreadId()), getThreadName());
    }

    public String toString() {
        return "ThreadExceptionItem{threadId=" + this.threadId + ", threadName='" + this.threadName + "', threadCpuTime=" + this.threadCpuTime + ", processCpuTime=" + this.processCpuTime + ", cpuUsage=" + this.cpuUsage + ", weight=" + this.weight + ", nice=" + this.priority + AbstractJsonLexerKt.END_OBJ;
    }
}
