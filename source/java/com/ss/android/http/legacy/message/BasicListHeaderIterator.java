package com.ss.android.http.legacy.message;

import com.ss.android.http.legacy.Header;
import com.ss.android.http.legacy.HeaderIterator;
import java.util.List;
import java.util.NoSuchElementException;

@Deprecated
/* loaded from: classes7.dex */
public class BasicListHeaderIterator implements HeaderIterator {
    protected final List allHeaders;
    protected int currentIndex;
    protected String headerName;
    protected int lastIndex;

    public BasicListHeaderIterator(List list, String str) {
        if (list == null) {
            throw new IllegalArgumentException("Header list must not be null.");
        }
        this.allHeaders = list;
        this.headerName = str;
        this.currentIndex = findNext(-1);
        this.lastIndex = -1;
    }

    protected int findNext(int i) {
        if (i < -1) {
            return -1;
        }
        int size = this.allHeaders.size() - 1;
        boolean z = false;
        while (!z && i < size) {
            i++;
            z = filterHeader(i);
        }
        if (z) {
            return i;
        }
        return -1;
    }

    protected boolean filterHeader(int i) {
        if (this.headerName == null) {
            return true;
        }
        return this.headerName.equalsIgnoreCase(((Header) this.allHeaders.get(i)).getName());
    }

    @Override // com.ss.android.http.legacy.HeaderIterator, java.util.Iterator
    public boolean hasNext() {
        return this.currentIndex >= 0;
    }

    @Override // com.ss.android.http.legacy.HeaderIterator
    public Header nextHeader() throws NoSuchElementException {
        int i = this.currentIndex;
        if (i < 0) {
            throw new NoSuchElementException("Iteration already finished.");
        }
        this.lastIndex = i;
        this.currentIndex = findNext(i);
        return (Header) this.allHeaders.get(i);
    }

    @Override // java.util.Iterator
    public final Object next() throws NoSuchElementException {
        return nextHeader();
    }

    @Override // java.util.Iterator
    public void remove() throws UnsupportedOperationException {
        int i = this.lastIndex;
        if (i < 0) {
            throw new IllegalStateException("No header to remove.");
        }
        this.allHeaders.remove(i);
        this.lastIndex = -1;
        this.currentIndex--;
    }
}
