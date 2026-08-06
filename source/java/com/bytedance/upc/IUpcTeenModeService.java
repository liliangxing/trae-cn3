package com.bytedance.upc;

import com.bytedance.bdturing.methods.JsCallParser;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: IUpcTeenModeService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001c\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0003H&J,\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/upc/IUpcTeenModeService;", "", "getAllowStayDuration", "", "getTeenModeEnable", "", JsCallParser.VALUE_CALLBACK, "Lkotlin/Function1;", "", "getTeenModeEntryDuration", "init", "setAllowStayDuration", "duration", "setTeenModeEnable", "enable", "passwd", "", BuildConfig.LIBRARY_PACKAGE_NAME}, k = 1, mv = {1, 1, 16})
/* loaded from: classes.dex */
public interface IUpcTeenModeService {
    long getAllowStayDuration();

    void getTeenModeEnable(Function1<? super Boolean, Unit> callback);

    long getTeenModeEntryDuration();

    void init();

    void setAllowStayDuration(long duration);

    void setTeenModeEnable(boolean enable, String passwd, Function1<? super Boolean, Unit> callback);
}
