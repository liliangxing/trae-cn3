package com.xiaomi.push;

import com.ttnet.org.chromium.base.task.TaskTraits;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* renamed from: com.xiaomi.push.hq */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1672hq {

    /* renamed from: a */
    private static final Comparator f2748a = new a();

    /* renamed from: a */
    public static int m3314a(byte b, byte b2) {
        if (b < b2) {
            return -1;
        }
        return b2 < b ? 1 : 0;
    }

    /* renamed from: a */
    public static int m3315a(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i2 < i ? 1 : 0;
    }

    /* renamed from: a */
    public static int m3316a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j2 < j ? 1 : 0;
    }

    /* renamed from: a */
    public static int m3323a(short s, short s2) {
        if (s < s2) {
            return -1;
        }
        return s2 < s ? 1 : 0;
    }

    /* renamed from: a */
    public static int m3324a(boolean z, boolean z2) {
        return Boolean.valueOf(z).compareTo(Boolean.valueOf(z2));
    }

    /* renamed from: a */
    public static int m3318a(String str, String str2) {
        return str.compareTo(str2);
    }

    /* renamed from: a */
    public static int m3325a(byte[] bArr, byte[] bArr2) {
        int m3315a = m3315a(bArr.length, bArr2.length);
        if (m3315a != 0) {
            return m3315a;
        }
        for (int i = 0; i < bArr.length; i++) {
            int m3314a = m3314a(bArr[i], bArr2[i]);
            if (m3314a != 0) {
                return m3314a;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m3317a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* renamed from: a */
    public static int m3320a(List list, List list2) {
        int m3315a = m3315a(list.size(), list2.size());
        if (m3315a != 0) {
            return m3315a;
        }
        for (int i = 0; i < list.size(); i++) {
            int compare = f2748a.compare(list.get(i), list2.get(i));
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m3322a(Set set, Set set2) {
        int m3315a = m3315a(set.size(), set2.size());
        if (m3315a != 0) {
            return m3315a;
        }
        Comparator comparator = f2748a;
        TreeSet treeSet = new TreeSet(comparator);
        treeSet.addAll(set);
        TreeSet treeSet2 = new TreeSet(comparator);
        treeSet2.addAll(set2);
        Iterator it = treeSet.iterator();
        Iterator it2 = treeSet2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compare = f2748a.compare(it.next(), it2.next());
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    /* renamed from: a */
    public static int m3321a(Map map, Map map2) {
        int m3315a = m3315a(map.size(), map2.size());
        if (m3315a != 0) {
            return m3315a;
        }
        Comparator comparator = f2748a;
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        Iterator it = treeMap.entrySet().iterator();
        TreeMap treeMap2 = new TreeMap(comparator);
        treeMap2.putAll(map2);
        Iterator it2 = treeMap2.entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            Comparator comparator2 = f2748a;
            int compare = comparator2.compare(entry.getKey(), entry2.getKey());
            if (compare != 0) {
                return compare;
            }
            int compare2 = comparator2.compare(entry.getValue(), entry2.getValue());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return 0;
    }

    /* renamed from: com.xiaomi.push.hq$a */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    private static class a implements Comparator {
        private a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == null && obj2 == null) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            if (obj instanceof List) {
                return C1672hq.m3320a((List) obj, (List) obj2);
            }
            if (obj instanceof Set) {
                return C1672hq.m3322a((Set) obj, (Set) obj2);
            }
            if (obj instanceof Map) {
                return C1672hq.m3321a((Map) obj, (Map) obj2);
            }
            if (obj instanceof byte[]) {
                return C1672hq.m3325a((byte[]) obj, (byte[]) obj2);
            }
            return C1672hq.m3317a((Comparable) obj, (Comparable) obj2);
        }
    }

    /* renamed from: a */
    public static void m3328a(ByteBuffer byteBuffer, StringBuilder sb) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        int limit = byteBuffer.limit();
        int i = limit - arrayOffset > 128 ? arrayOffset + 128 : limit;
        for (int i2 = arrayOffset; i2 < i; i2++) {
            if (i2 > arrayOffset) {
                sb.append(" ");
            }
            sb.append(m3326a(array[i2]));
        }
        if (limit != i) {
            sb.append("...");
        }
    }

    /* renamed from: a */
    public static String m3326a(byte b) {
        return Integer.toHexString((b | TaskTraits.INVALID_EXTENSION_ID) & 511).toUpperCase().substring(1);
    }

    /* renamed from: a */
    public static byte[] m3330a(ByteBuffer byteBuffer) {
        if (m3329a(byteBuffer)) {
            return byteBuffer.array();
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        m3319a(byteBuffer, bArr, 0);
        return bArr;
    }

    /* renamed from: a */
    public static boolean m3329a(ByteBuffer byteBuffer) {
        return byteBuffer.hasArray() && byteBuffer.position() == 0 && byteBuffer.arrayOffset() == 0 && byteBuffer.remaining() == byteBuffer.capacity();
    }

    /* renamed from: a */
    public static int m3319a(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int remaining = byteBuffer.remaining();
        System.arraycopy(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), bArr, i, remaining);
        return remaining;
    }

    /* renamed from: a */
    public static ByteBuffer m3327a(ByteBuffer byteBuffer) {
        return m3329a(byteBuffer) ? byteBuffer : ByteBuffer.wrap(m3330a(byteBuffer));
    }
}
