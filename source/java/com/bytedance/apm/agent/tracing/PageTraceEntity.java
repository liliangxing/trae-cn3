package com.bytedance.apm.agent.tracing;

/* loaded from: classes3.dex */
public class PageTraceEntity {
    public long onCreateEndTs;
    public long onCreateStartTs;
    public long onResumeEndTs;
    public long onResumeStartTs;
    public long onViewShowTs;
    public long onWindowFocusTs;
    public String pageName;

    public PageTraceEntity(String str, long j) {
        this.pageName = str;
        this.onCreateStartTs = j;
    }

    public boolean isCreateAndResumeValid() {
        return this.onCreateStartTs > 0 && this.onCreateEndTs > 0 && this.onResumeStartTs > 0 && this.onResumeEndTs > 0;
    }

    public String getPageName() {
        return this.pageName;
    }

    public void setPageName(String str) {
        this.pageName = str;
    }

    public long getOnCreateStartTs() {
        return this.onCreateStartTs;
    }

    public void setOnCreateStartTs(long j) {
        this.onCreateStartTs = j;
    }

    public long getOnCreateEndTs() {
        return this.onCreateEndTs;
    }

    public void setOnCreateEndTs(long j) {
        this.onCreateEndTs = j;
    }

    public long getOnResumeStartTs() {
        return this.onResumeStartTs;
    }

    public void setOnResumeStartTs(long j) {
        this.onResumeStartTs = j;
    }

    public long getOnResumeEndTs() {
        return this.onResumeEndTs;
    }

    public void setOnResumeEndTs(long j) {
        this.onResumeEndTs = j;
    }

    public long getOnWindowFocusTs() {
        return this.onWindowFocusTs;
    }

    public void setOnWindowFocusTs(long j) {
        this.onWindowFocusTs = j;
    }
}
