package com.bytedance.kmp.network.cinterop;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IKmpNetworkCommonParamsProvider.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R$\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/kmp/network/cinterop/StringPair;", "", "str1", "", "str2", "(Ljava/lang/String;Ljava/lang/String;)V", "first", "getFirst$annotations", "()V", "getFirst", "()Ljava/lang/String;", "setFirst", "(Ljava/lang/String;)V", "second", "getSecond$annotations", "getSecond", "setSecond", "network_service_release"}, k = 1, mv = {1, 7, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StringPair {
    private String first;
    private String second;

    public static /* synthetic */ void getFirst$annotations() {
    }

    public static /* synthetic */ void getSecond$annotations() {
    }

    public final String getFirst() {
        return this.first;
    }

    public final void setFirst(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.first = str;
    }

    public final String getSecond() {
        return this.second;
    }

    public final void setSecond(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.second = str;
    }

    public StringPair(String str1, String str2) {
        Intrinsics.checkNotNullParameter(str1, "str1");
        Intrinsics.checkNotNullParameter(str2, "str2");
        this.first = str1;
        this.second = str2;
    }
}
