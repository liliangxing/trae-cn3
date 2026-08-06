package com.ss.android.http.legacy;

import java.util.Iterator;

@Deprecated
/* loaded from: classes7.dex */
public interface HeaderIterator extends Iterator {
    @Override // java.util.Iterator
    boolean hasNext();

    Header nextHeader();
}
