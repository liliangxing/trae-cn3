package com.bytedance.helios.statichook.api;

import com.bytedance.bdturing.EventReport;
import java.util.List;
import kotlin.Metadata;

/* compiled from: ITraceTracker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/bytedance/helios/statichook/api/ITraceTracker;", "", "getInvokeList", "", "", EventReport.DIALOG_POP, "", "value", "push", "statichook_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public interface ITraceTracker {
    List<Integer> getInvokeList();

    void pop(int value);

    void push(int value);
}
