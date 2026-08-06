package com.ss.android.push;

import java.io.Serializable;

/* loaded from: classes7.dex */
public abstract class Triple<L, M, R> implements Comparable<Triple<L, M, R>>, Serializable {
    private static final long serialVersionUID = 1;

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    public static <L, M, R> Triple<L, M, R> of(L l, M m, R r) {
        return new ImmutableTriple(l, m, r);
    }

    @Override // java.lang.Comparable
    public int compareTo(Triple<L, M, R> triple) {
        int compareTo = ((Comparable) getLeft()).compareTo(triple.getLeft());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = ((Comparable) getMiddle()).compareTo(triple.getMiddle());
        return compareTo2 != 0 ? compareTo2 : ((Comparable) getRight()).compareTo(triple.getRight());
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return equals(getLeft(), triple.getLeft()) && equals(getMiddle(), triple.getMiddle()) && equals(getRight(), triple.getRight());
    }

    private boolean equals(Object obj, Object obj2) {
        return (obj == null || obj2 == null || (obj != obj2 && !obj.equals(obj2))) ? false : true;
    }

    public int hashCode() {
        return ((getLeft() == null ? 0 : getLeft().hashCode()) ^ (getMiddle() == null ? 0 : getMiddle().hashCode())) ^ (getRight() != null ? getRight().hashCode() : 0);
    }

    public String toString() {
        return "(" + getLeft() + ',' + getMiddle() + ',' + getRight() + ')';
    }

    public String toString(String str) {
        return String.format(str, getLeft(), getMiddle(), getRight());
    }
}
