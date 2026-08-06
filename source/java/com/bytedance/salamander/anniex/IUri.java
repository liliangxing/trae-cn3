package com.bytedance.salamander.anniex;

import kotlin.Metadata;

/* compiled from: AnniexMonitorFoundationInterfaceIUri.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&¨\u0006\b"}, d2 = {"Lcom/bytedance/salamander/anniex/IUri;", "", "getHost", "", "getPath", "getQueryParameter", "k", "getScheme", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public interface IUri {
    String getHost();

    String getPath();

    String getQueryParameter(String k);

    String getScheme();
}
