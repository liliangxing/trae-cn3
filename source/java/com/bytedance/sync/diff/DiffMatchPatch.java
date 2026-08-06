package com.bytedance.sync.diff;

import com.bytedance.bdturing.livedetect.camera.CameraErrorCode;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.update.UpdateDialogNewBase;
import com.xiaomi.mipush.sdk.Constants;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* loaded from: classes5.dex */
public class DiffMatchPatch {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public float Diff_Timeout = 1.0f;
    public short Diff_EditCost = 4;
    public float Match_Threshold = 0.5f;
    public int Match_Distance = 1000;
    public float Patch_DeleteThreshold = 0.5f;
    public short Patch_Margin = 4;
    private short Match_MaxBits = 32;
    private Pattern BLANKLINEEND = Pattern.compile("\\n\\r?\\n\\Z", 32);
    private Pattern BLANKLINESTART = Pattern.compile("\\A\\r?\\n\\r?\\n", 32);

    /* loaded from: classes5.dex */
    public enum Operation {
        DELETE,
        INSERT,
        EQUAL
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes5.dex */
    public static class LinesToCharsResult {
        protected String chars1;
        protected String chars2;
        protected List<String> lineArray;

        protected LinesToCharsResult(String str, String str2, List<String> list) {
            this.chars1 = str;
            this.chars2 = str2;
            this.lineArray = list;
        }
    }

    public LinkedList<Diff> diff_main(String str, String str2) {
        return diff_main(str, str2, true);
    }

    public LinkedList<Diff> diff_main(String str, String str2, boolean z) {
        return diff_main(str, str2, z, this.Diff_Timeout <= 0.0f ? Long.MAX_VALUE : System.currentTimeMillis() + (this.Diff_Timeout * 1000.0f));
    }

    private LinkedList<Diff> diff_main(String str, String str2, boolean z, long j) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Null inputs. (diff_main)");
        }
        if (str.equals(str2)) {
            LinkedList<Diff> linkedList = new LinkedList<>();
            if (str.length() != 0) {
                linkedList.add(new Diff(Operation.EQUAL, str));
            }
            return linkedList;
        }
        int diff_commonPrefix = diff_commonPrefix(str, str2);
        String substring = str.substring(0, diff_commonPrefix);
        String substring2 = str.substring(diff_commonPrefix);
        String substring3 = str2.substring(diff_commonPrefix);
        int diff_commonSuffix = diff_commonSuffix(substring2, substring3);
        String substring4 = substring2.substring(substring2.length() - diff_commonSuffix);
        LinkedList<Diff> diff_compute = diff_compute(substring2.substring(0, substring2.length() - diff_commonSuffix), substring3.substring(0, substring3.length() - diff_commonSuffix), z, j);
        if (substring.length() != 0) {
            diff_compute.addFirst(new Diff(Operation.EQUAL, substring));
        }
        if (substring4.length() != 0) {
            diff_compute.addLast(new Diff(Operation.EQUAL, substring4));
        }
        diff_cleanupMerge(diff_compute);
        return diff_compute;
    }

    private LinkedList<Diff> diff_compute(String str, String str2, boolean z, long j) {
        LinkedList<Diff> linkedList = new LinkedList<>();
        if (str.length() == 0) {
            linkedList.add(new Diff(Operation.INSERT, str2));
            return linkedList;
        }
        if (str2.length() == 0) {
            linkedList.add(new Diff(Operation.DELETE, str));
            return linkedList;
        }
        String str3 = str.length() > str2.length() ? str : str2;
        String str4 = str.length() > str2.length() ? str2 : str;
        int indexOf = str3.indexOf(str4);
        if (indexOf != -1) {
            Operation operation = str.length() > str2.length() ? Operation.DELETE : Operation.INSERT;
            linkedList.add(new Diff(operation, str3.substring(0, indexOf)));
            linkedList.add(new Diff(Operation.EQUAL, str4));
            linkedList.add(new Diff(operation, str3.substring(indexOf + str4.length())));
            return linkedList;
        }
        if (str4.length() == 1) {
            linkedList.add(new Diff(Operation.DELETE, str));
            linkedList.add(new Diff(Operation.INSERT, str2));
            return linkedList;
        }
        String[] diff_halfMatch = diff_halfMatch(str, str2);
        if (diff_halfMatch != null) {
            String str5 = diff_halfMatch[0];
            String str6 = diff_halfMatch[1];
            String str7 = diff_halfMatch[2];
            String str8 = diff_halfMatch[3];
            String str9 = diff_halfMatch[4];
            LinkedList<Diff> diff_main = diff_main(str5, str7, z, j);
            LinkedList<Diff> diff_main2 = diff_main(str6, str8, z, j);
            diff_main.add(new Diff(Operation.EQUAL, str9));
            diff_main.addAll(diff_main2);
            return diff_main;
        }
        if (z && str.length() > 100 && str2.length() > 100) {
            return diff_lineMode(str, str2, j);
        }
        return diff_bisect(str, str2, j);
    }

    private LinkedList<Diff> diff_lineMode(String str, String str2, long j) {
        LinesToCharsResult diff_linesToChars = diff_linesToChars(str, str2);
        String str3 = diff_linesToChars.chars1;
        String str4 = diff_linesToChars.chars2;
        List<String> list = diff_linesToChars.lineArray;
        LinkedList<Diff> diff_main = diff_main(str3, str4, false, j);
        diff_charsToLines(diff_main, list);
        diff_cleanupSemantic(diff_main);
        diff_main.add(new Diff(Operation.EQUAL, ""));
        ListIterator<Diff> listIterator = diff_main.listIterator();
        Diff next = listIterator.next();
        String str5 = "";
        String str6 = str5;
        int i = 0;
        int i2 = 0;
        while (next != null) {
            int i3 = AnonymousClass1.$SwitchMap$com$bytedance$sync$diff$DiffMatchPatch$Operation[next.operation.ordinal()];
            if (i3 == 1) {
                i++;
                str6 = str6 + next.text;
            } else if (i3 == 2) {
                i2++;
                str5 = str5 + next.text;
            } else if (i3 == 3) {
                if (i2 >= 1 && i >= 1) {
                    listIterator.previous();
                    for (int i4 = 0; i4 < i2 + i; i4++) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                    Iterator<Diff> it = diff_main(str5, str6, false, j).iterator();
                    while (it.hasNext()) {
                        listIterator.add(it.next());
                    }
                }
                str5 = "";
                str6 = str5;
                i = 0;
                i2 = 0;
            }
            next = listIterator.hasNext() ? listIterator.next() : null;
        }
        diff_main.removeLast();
        return diff_main;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sync.diff.DiffMatchPatch$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$sync$diff$DiffMatchPatch$Operation;

        static {
            int[] iArr = new int[Operation.values().length];
            $SwitchMap$com$bytedance$sync$diff$DiffMatchPatch$Operation = iArr;
            try {
                iArr[Operation.INSERT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$bytedance$sync$diff$DiffMatchPatch$Operation[Operation.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$bytedance$sync$diff$DiffMatchPatch$Operation[Operation.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0061, code lost:
    
        if (r7[r14 - 1] < r7[r14 + 1]) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ef, code lost:
    
        if (r20[r1 - 1] < r20[r1 + 1]) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0089 A[LOOP:3: B:23:0x0079->B:27:0x0089, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094 A[EDGE_INSN: B:28:0x0094->B:29:0x0094 BREAK  A[LOOP:3: B:23:0x0079->B:27:0x0089], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0123 A[LOOP:5: B:72:0x0105->B:76:0x0123, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0132 A[EDGE_INSN: B:77:0x0132->B:78:0x0132 BREAK  A[LOOP:5: B:72:0x0105->B:76:0x0123], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x013a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected LinkedList<Diff> diff_bisect(String str, String str2, long j) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr;
        int i11;
        int i12;
        String str3 = str;
        int length = str.length();
        int length2 = str2.length();
        int i13 = ((length + length2) + 1) / 2;
        int i14 = i13 * 2;
        int[] iArr2 = new int[i14];
        int[] iArr3 = new int[i14];
        int i15 = 0;
        for (int i16 = 0; i16 < i14; i16++) {
            iArr2[i16] = -1;
            iArr3[i16] = -1;
        }
        int i17 = i13 + 1;
        iArr2[i17] = 0;
        iArr3[i17] = 0;
        int i18 = length - length2;
        boolean z = i18 % 2 != 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        while (i15 < i13 && System.currentTimeMillis() <= j) {
            int i23 = -i15;
            int i24 = i20;
            int i25 = i23 + i19;
            while (i25 <= i15 - i21) {
                int i26 = i13 + i25;
                if (i25 != i23) {
                    if (i25 != i15) {
                        i7 = i15;
                        i8 = i23;
                    } else {
                        i7 = i15;
                        i8 = i23;
                    }
                    i9 = iArr2[i26 - 1] + 1;
                    i10 = i9 - i25;
                    while (i9 < length && i10 < length2) {
                        iArr = iArr3;
                        if (str3.charAt(i9) == str2.charAt(i10)) {
                            break;
                        }
                        i9++;
                        i10++;
                        str3 = str;
                        iArr3 = iArr;
                    }
                    iArr = iArr3;
                    iArr2[i26] = i9;
                    if (i9 <= length) {
                        i21 += 2;
                    } else if (i10 > length2) {
                        i19 += 2;
                    } else if (z && (i11 = (i13 + i18) - i25) >= 0 && i11 < i14 && (i12 = iArr[i11]) != -1 && i9 >= length - i12) {
                        return diff_bisectSplit(str, str2, i9, i10, j);
                    }
                    i25 += 2;
                    str3 = str;
                    iArr3 = iArr;
                    i15 = i7;
                    i23 = i8;
                } else {
                    i7 = i15;
                    i8 = i23;
                }
                i9 = iArr2[i26 + 1];
                i10 = i9 - i25;
                while (i9 < length) {
                    iArr = iArr3;
                    if (str3.charAt(i9) == str2.charAt(i10)) {
                    }
                }
                iArr = iArr3;
                iArr2[i26] = i9;
                if (i9 <= length) {
                }
                i25 += 2;
                str3 = str;
                iArr3 = iArr;
                i15 = i7;
                i23 = i8;
            }
            int[] iArr4 = iArr3;
            int i27 = i15;
            int i28 = i23;
            int i29 = i28 + i24;
            i20 = i24;
            while (i29 <= i27 - i22) {
                int i30 = i13 + i29;
                int i31 = i28;
                if (i29 != i31) {
                    i = i27;
                    if (i29 != i) {
                        i28 = i31;
                    } else {
                        i28 = i31;
                    }
                    i2 = iArr4[i30 - 1] + 1;
                    i3 = i2 - i29;
                    while (i2 < length && i3 < length2) {
                        i4 = i19;
                        i5 = i21;
                        if (str.charAt((length - i2) - 1) == str2.charAt((length2 - i3) - 1)) {
                            break;
                        }
                        i2++;
                        i3++;
                        i21 = i5;
                        i19 = i4;
                    }
                    i4 = i19;
                    i5 = i21;
                    iArr4[i30] = i2;
                    if (i2 <= length) {
                        i22 += 2;
                    } else if (i3 > length2) {
                        i20 += 2;
                    } else if (!z && (i6 = (i13 + i18) - i29) >= 0 && i6 < i14) {
                        int i32 = iArr2[i6];
                        if (i32 != -1) {
                            int i33 = (i13 + i32) - i6;
                            if (i32 >= length - i2) {
                                return diff_bisectSplit(str, str2, i32, i33, j);
                            }
                        } else {
                            continue;
                        }
                        i29 += 2;
                        i21 = i5;
                        i19 = i4;
                        i27 = i;
                    }
                    i29 += 2;
                    i21 = i5;
                    i19 = i4;
                    i27 = i;
                } else {
                    i28 = i31;
                    i = i27;
                }
                i2 = iArr4[i30 + 1];
                i3 = i2 - i29;
                while (i2 < length) {
                    i4 = i19;
                    i5 = i21;
                    if (str.charAt((length - i2) - 1) == str2.charAt((length2 - i3) - 1)) {
                    }
                }
                i4 = i19;
                i5 = i21;
                iArr4[i30] = i2;
                if (i2 <= length) {
                }
                i29 += 2;
                i21 = i5;
                i19 = i4;
                i27 = i;
            }
            i15 = i27 + 1;
            str3 = str;
            iArr3 = iArr4;
            i19 = i19;
        }
        LinkedList<Diff> linkedList = new LinkedList<>();
        linkedList.add(new Diff(Operation.DELETE, str));
        linkedList.add(new Diff(Operation.INSERT, str2));
        return linkedList;
    }

    private LinkedList<Diff> diff_bisectSplit(String str, String str2, int i, int i2, long j) {
        String substring = str.substring(0, i);
        String substring2 = str2.substring(0, i2);
        String substring3 = str.substring(i);
        String substring4 = str2.substring(i2);
        LinkedList<Diff> diff_main = diff_main(substring, substring2, false, j);
        diff_main.addAll(diff_main(substring3, substring4, false, j));
        return diff_main;
    }

    protected LinesToCharsResult diff_linesToChars(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        arrayList.add("");
        return new LinesToCharsResult(diff_linesToCharsMunge(str, arrayList, hashMap, CameraErrorCode.ERROR_CODE_CAMARA_OPEN_FAILED), diff_linesToCharsMunge(str2, arrayList, hashMap, 65535), arrayList);
    }

    private String diff_linesToCharsMunge(String str, List<String> list, Map<String, Integer> map, int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        int i3 = -1;
        while (i3 < str.length() - 1) {
            i3 = str.indexOf(10, i2);
            if (i3 == -1) {
                i3 = str.length() - 1;
            }
            String substring = str.substring(i2, i3 + 1);
            if (map.containsKey(substring)) {
                sb.append(String.valueOf((char) map.get(substring).intValue()));
            } else {
                if (list.size() == i) {
                    substring = str.substring(i2);
                    i3 = str.length();
                }
                list.add(substring);
                map.put(substring, Integer.valueOf(list.size() - 1));
                sb.append(String.valueOf((char) (list.size() - 1)));
            }
            i2 = i3 + 1;
        }
        return sb.toString();
    }

    protected void diff_charsToLines(List<Diff> list, List<String> list2) {
        for (Diff diff : list) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < diff.text.length(); i++) {
                sb.append(list2.get(diff.text.charAt(i)));
            }
            diff.text = sb.toString();
        }
    }

    public int diff_commonPrefix(String str, String str2) {
        int min = Math.min(str.length(), str2.length());
        for (int i = 0; i < min; i++) {
            if (str.charAt(i) != str2.charAt(i)) {
                return i;
            }
        }
        return min;
    }

    public int diff_commonSuffix(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        int min = Math.min(length, length2);
        for (int i = 1; i <= min; i++) {
            if (str.charAt(length - i) != str2.charAt(length2 - i)) {
                return i - 1;
            }
        }
        return min;
    }

    protected int diff_commonOverlap(String str, String str2) {
        int length = str.length();
        int length2 = str2.length();
        if (length == 0 || length2 == 0) {
            return 0;
        }
        if (length > length2) {
            str = str.substring(length - length2);
        } else if (length < length2) {
            str2 = str2.substring(0, length);
        }
        int min = Math.min(length, length2);
        if (str.equals(str2)) {
            return min;
        }
        int i = 1;
        int i2 = 0;
        while (true) {
            int indexOf = str2.indexOf(str.substring(min - i));
            if (indexOf == -1) {
                return i2;
            }
            i += indexOf;
            if (indexOf == 0 || str.substring(min - i).equals(str2.substring(0, i))) {
                i2 = i;
                i++;
            }
        }
    }

    protected String[] diff_halfMatch(String str, String str2) {
        if (this.Diff_Timeout <= 0.0f) {
            return null;
        }
        String str3 = str.length() > str2.length() ? str : str2;
        String str4 = str.length() > str2.length() ? str2 : str;
        if (str3.length() < 4 || str4.length() * 2 < str3.length()) {
            return null;
        }
        String[] diff_halfMatchI = diff_halfMatchI(str3, str4, (str3.length() + 3) / 4);
        String[] diff_halfMatchI2 = diff_halfMatchI(str3, str4, (str3.length() + 1) / 2);
        if (diff_halfMatchI == null && diff_halfMatchI2 == null) {
            return null;
        }
        if (diff_halfMatchI2 != null && (diff_halfMatchI == null || diff_halfMatchI[4].length() <= diff_halfMatchI2[4].length())) {
            diff_halfMatchI = diff_halfMatchI2;
        }
        return str.length() > str2.length() ? diff_halfMatchI : new String[]{diff_halfMatchI[2], diff_halfMatchI[3], diff_halfMatchI[0], diff_halfMatchI[1], diff_halfMatchI[4]};
    }

    private String[] diff_halfMatchI(String str, String str2, int i) {
        String substring = str.substring(i, (str.length() / 4) + i);
        int i2 = -1;
        String str3 = "";
        int i3 = -1;
        String str4 = "";
        String str5 = str4;
        String str6 = str5;
        String str7 = str6;
        while (true) {
            i3 = str2.indexOf(substring, i3 + 1);
            if (i3 == i2) {
                break;
            }
            int diff_commonPrefix = diff_commonPrefix(str.substring(i), str2.substring(i3));
            int diff_commonSuffix = diff_commonSuffix(str.substring(0, i), str2.substring(0, i3));
            if (str3.length() < diff_commonSuffix + diff_commonPrefix) {
                int i4 = i3 - diff_commonSuffix;
                int i5 = i3 + diff_commonPrefix;
                String str8 = str2.substring(i4, i3) + str2.substring(i3, i5);
                String substring2 = str.substring(0, i - diff_commonSuffix);
                str5 = str.substring(i + diff_commonPrefix);
                str6 = str2.substring(0, i4);
                str7 = str2.substring(i5);
                str3 = str8;
                str4 = substring2;
            }
            i2 = -1;
        }
        if (str3.length() * 2 >= str.length()) {
            return new String[]{str4, str5, str6, str7, str3};
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x00e9, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void diff_cleanupSemantic(LinkedList<Diff> linkedList) {
        Diff diff;
        Diff diff2;
        if (linkedList.isEmpty()) {
            return;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        ListIterator<Diff> listIterator = linkedList.listIterator();
        Diff next = listIterator.next();
        String str = null;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (next != null) {
            if (next.operation == Operation.EQUAL) {
                arrayDeque.push(next);
                str = next.text;
                i3 = i;
                i4 = i2;
                i = 0;
                i2 = 0;
            } else {
                if (next.operation == Operation.INSERT) {
                    i += next.text.length();
                } else {
                    i2 += next.text.length();
                }
                if (str != null && str.length() <= Math.max(i3, i4) && str.length() <= Math.max(i, i2)) {
                    while (next != arrayDeque.peek()) {
                        next = listIterator.previous();
                    }
                    listIterator.next();
                    listIterator.set(new Diff(Operation.DELETE, str));
                    listIterator.add(new Diff(Operation.INSERT, str));
                    arrayDeque.pop();
                    if (!arrayDeque.isEmpty()) {
                        arrayDeque.pop();
                    }
                    if (arrayDeque.isEmpty()) {
                        while (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                    } else {
                        do {
                        } while (((Diff) arrayDeque.peek()) != listIterator.previous());
                    }
                    z = true;
                    str = null;
                    i = 0;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                }
            }
            next = listIterator.hasNext() ? listIterator.next() : null;
        }
        if (z) {
            diff_cleanupMerge(linkedList);
        }
        diff_cleanupSemanticLossless(linkedList);
        ListIterator<Diff> listIterator2 = linkedList.listIterator();
        if (listIterator2.hasNext()) {
            diff = listIterator2.next();
            if (listIterator2.hasNext()) {
                diff2 = listIterator2.next();
            }
        } else {
            diff = null;
            diff2 = null;
        }
        while (diff2 != null) {
            if (diff.operation == Operation.DELETE && diff2.operation == Operation.INSERT) {
                String str2 = diff.text;
                String str3 = diff2.text;
                int diff_commonOverlap = diff_commonOverlap(str2, str3);
                int diff_commonOverlap2 = diff_commonOverlap(str3, str2);
                if (diff_commonOverlap >= diff_commonOverlap2) {
                    double d = diff_commonOverlap;
                    if (d >= str2.length() / 2.0d || d >= str3.length() / 2.0d) {
                        listIterator2.previous();
                        listIterator2.add(new Diff(Operation.EQUAL, str3.substring(0, diff_commonOverlap)));
                        diff.text = str2.substring(0, str2.length() - diff_commonOverlap);
                        diff2.text = str3.substring(diff_commonOverlap);
                    }
                } else {
                    double d2 = diff_commonOverlap2;
                    if (d2 >= str2.length() / 2.0d || d2 >= str3.length() / 2.0d) {
                        listIterator2.previous();
                        listIterator2.add(new Diff(Operation.EQUAL, str2.substring(0, diff_commonOverlap2)));
                        diff.operation = Operation.INSERT;
                        diff.text = str3.substring(0, str3.length() - diff_commonOverlap2);
                        diff2.operation = Operation.DELETE;
                        diff2.text = str2.substring(diff_commonOverlap2);
                    }
                }
                diff = listIterator2.hasNext() ? listIterator2.next() : null;
            } else {
                diff = diff2;
            }
            diff2 = listIterator2.hasNext() ? listIterator2.next() : null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x002f, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0129 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x002e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void diff_cleanupSemanticLossless(LinkedList<Diff> linkedList) {
        Diff diff;
        ListIterator<Diff> listIterator = linkedList.listIterator();
        Diff next = listIterator.hasNext() ? listIterator.next() : null;
        Diff next2 = listIterator.hasNext() ? listIterator.next() : null;
        if (listIterator.hasNext()) {
            diff = listIterator.next();
            while (diff != null) {
                if (next.operation == Operation.EQUAL && diff.operation == Operation.EQUAL) {
                    String str = next.text;
                    String str2 = next2.text;
                    String str3 = diff.text;
                    int diff_commonSuffix = diff_commonSuffix(str, str2);
                    if (diff_commonSuffix != 0) {
                        String substring = str2.substring(str2.length() - diff_commonSuffix);
                        str = str.substring(0, str.length() - diff_commonSuffix);
                        str2 = substring + str2.substring(0, str2.length() - diff_commonSuffix);
                        str3 = substring + str3;
                    }
                    String str4 = str3;
                    String str5 = str4;
                    int diff_cleanupSemanticScore = diff_cleanupSemanticScore(str, str2) + diff_cleanupSemanticScore(str2, str3);
                    String str6 = str2;
                    String str7 = str6;
                    String str8 = str;
                    while (str6.length() != 0 && str4.length() != 0 && str6.charAt(0) == str4.charAt(0)) {
                        str8 = str8 + str6.charAt(0);
                        str6 = str6.substring(1) + str4.charAt(0);
                        str4 = str4.substring(1);
                        int diff_cleanupSemanticScore2 = diff_cleanupSemanticScore(str8, str6) + diff_cleanupSemanticScore(str6, str4);
                        if (diff_cleanupSemanticScore2 >= diff_cleanupSemanticScore) {
                            str = str8;
                            str7 = str6;
                            str5 = str4;
                            diff_cleanupSemanticScore = diff_cleanupSemanticScore2;
                        }
                    }
                    if (!next.text.equals(str)) {
                        if (str.length() != 0) {
                            next.text = str;
                        } else {
                            listIterator.previous();
                            listIterator.previous();
                            listIterator.previous();
                            listIterator.remove();
                            listIterator.next();
                            listIterator.next();
                        }
                        next2.text = str7;
                        if (str5.length() != 0) {
                            diff.text = str5;
                        } else {
                            listIterator.remove();
                            if (!listIterator.hasNext()) {
                                diff = listIterator.next();
                            }
                        }
                    }
                }
                next = next2;
                next2 = diff;
                if (!listIterator.hasNext()) {
                }
            }
            return;
        }
        diff = null;
    }

    private int diff_cleanupSemanticScore(String str, String str2) {
        if (str.length() == 0 || str2.length() == 0) {
            return 6;
        }
        char charAt = str.charAt(str.length() - 1);
        char charAt2 = str2.charAt(0);
        boolean z = !Character.isLetterOrDigit(charAt);
        boolean z2 = !Character.isLetterOrDigit(charAt2);
        boolean z3 = z && Character.isWhitespace(charAt);
        boolean z4 = z2 && Character.isWhitespace(charAt2);
        boolean z5 = z3 && Character.getType(charAt) == 15;
        boolean z6 = z4 && Character.getType(charAt2) == 15;
        boolean z7 = z5 && this.BLANKLINEEND.matcher(str).find();
        boolean z8 = z6 && this.BLANKLINESTART.matcher(str2).find();
        if (z7 || z8) {
            return 5;
        }
        if (z5 || z6) {
            return 4;
        }
        if (z && !z3 && z4) {
            return 3;
        }
        if (z3 || z4) {
            return 2;
        }
        return (z || z2) ? 1 : 0;
    }

    public void diff_cleanupEfficiency(LinkedList<Diff> linkedList) {
        int i;
        if (linkedList.isEmpty()) {
            return;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        ListIterator<Diff> listIterator = linkedList.listIterator();
        Diff next = listIterator.next();
        Diff diff = next;
        String str = null;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (next != null) {
            if (next.operation == Operation.EQUAL) {
                if (next.text.length() < this.Diff_EditCost && (i2 != 0 || i3 != 0)) {
                    arrayDeque.push(next);
                    str = next.text;
                    next = diff;
                } else {
                    arrayDeque.clear();
                    str = null;
                    i2 = i4;
                    i3 = i5;
                }
                diff = next;
                i4 = i2;
                i5 = i3;
                i2 = 0;
                i3 = 0;
            } else {
                if (next.operation == Operation.DELETE) {
                    i3 = 1;
                } else {
                    i2 = 1;
                }
                if (str != null && ((i4 != 0 && i5 != 0 && i2 != 0 && i3 != 0) || (str.length() < this.Diff_EditCost / 2 && i4 + i5 + i2 + i3 == 3))) {
                    while (next != arrayDeque.peek()) {
                        next = listIterator.previous();
                    }
                    listIterator.next();
                    listIterator.set(new Diff(Operation.DELETE, str));
                    Diff diff2 = new Diff(Operation.INSERT, str);
                    listIterator.add(diff2);
                    arrayDeque.pop();
                    if (i4 != 0 && i5 != 0) {
                        arrayDeque.clear();
                        diff = diff2;
                        i = 1;
                    } else {
                        if (!arrayDeque.isEmpty()) {
                            arrayDeque.pop();
                        }
                        do {
                        } while ((arrayDeque.isEmpty() ? diff : (Diff) arrayDeque.peek()) != listIterator.previous());
                        i = 0;
                    }
                    i2 = i;
                    i3 = i2;
                    str = null;
                    z = true;
                }
            }
            next = listIterator.hasNext() ? listIterator.next() : null;
        }
        if (z) {
            diff_cleanupMerge(linkedList);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x0175 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x016d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x029c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0294 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void diff_cleanupMerge(LinkedList<Diff> linkedList) {
        linkedList.add(new Diff(Operation.EQUAL, ""));
        ListIterator<Diff> listIterator = linkedList.listIterator();
        Diff next = listIterator.next();
        String str = "";
        String str2 = str;
        int i = 0;
        int i2 = 0;
        Diff diff = null;
        while (true) {
            if (next == null) {
                break;
            }
            int i3 = AnonymousClass1.$SwitchMap$com$bytedance$sync$diff$DiffMatchPatch$Operation[next.operation.ordinal()];
            if (i3 == 1) {
                i++;
                str = str + next.text;
            } else if (i3 == 2) {
                i2++;
                str2 = str2 + next.text;
            } else {
                if (i3 == 3) {
                    if (i2 + i > 1) {
                        boolean z = (i2 == 0 || i == 0) ? false : true;
                        listIterator.previous();
                        while (true) {
                            int i4 = i2 - 1;
                            if (i2 <= 0) {
                                break;
                            }
                            listIterator.previous();
                            listIterator.remove();
                            i2 = i4;
                        }
                        while (true) {
                            int i5 = i - 1;
                            if (i <= 0) {
                                break;
                            }
                            listIterator.previous();
                            listIterator.remove();
                            i = i5;
                        }
                        if (z) {
                            int diff_commonPrefix = diff_commonPrefix(str, str2);
                            if (diff_commonPrefix != 0) {
                                if (listIterator.hasPrevious()) {
                                    listIterator.previous().text += str.substring(0, diff_commonPrefix);
                                    listIterator.next();
                                } else {
                                    listIterator.add(new Diff(Operation.EQUAL, str.substring(0, diff_commonPrefix)));
                                }
                                String substring = str.substring(diff_commonPrefix);
                                str2 = str2.substring(diff_commonPrefix);
                                str = substring;
                            }
                            int diff_commonSuffix = diff_commonSuffix(str, str2);
                            if (diff_commonSuffix != 0) {
                                Diff next2 = listIterator.next();
                                next2.text = str.substring(str.length() - diff_commonSuffix) + next2.text;
                                str = str.substring(0, str.length() - diff_commonSuffix);
                                str2 = str2.substring(0, str2.length() - diff_commonSuffix);
                                listIterator.previous();
                            }
                        }
                        if (str2.length() != 0) {
                            listIterator.add(new Diff(Operation.DELETE, str2));
                        }
                        if (str.length() != 0) {
                            listIterator.add(new Diff(Operation.INSERT, str));
                        }
                        next = listIterator.hasNext() ? listIterator.next() : null;
                    } else if (diff != null) {
                        diff.text += next.text;
                        listIterator.remove();
                        next = listIterator.previous();
                        listIterator.next();
                    }
                    diff = next;
                    str = "";
                    str2 = str;
                    i = 0;
                    i2 = 0;
                }
                next = !listIterator.hasNext() ? listIterator.next() : null;
            }
            diff = null;
            if (!listIterator.hasNext()) {
            }
        }
        if (linkedList.getLast().text.length() == 0) {
            linkedList.removeLast();
        }
        ListIterator<Diff> listIterator2 = linkedList.listIterator();
        Diff next3 = listIterator2.hasNext() ? listIterator2.next() : null;
        Diff next4 = listIterator2.hasNext() ? listIterator2.next() : null;
        Diff next5 = listIterator2.hasNext() ? listIterator2.next() : null;
        boolean z2 = false;
        while (next5 != null) {
            if (next3.operation == Operation.EQUAL && next5.operation == Operation.EQUAL) {
                if (next4.text.endsWith(next3.text)) {
                    next4.text = next3.text + next4.text.substring(0, next4.text.length() - next3.text.length());
                    next5.text = next3.text + next5.text;
                    listIterator2.previous();
                    listIterator2.previous();
                    listIterator2.previous();
                    listIterator2.remove();
                    listIterator2.next();
                    next3 = listIterator2.next();
                    next4 = listIterator2.hasNext() ? listIterator2.next() : null;
                    z2 = true;
                } else if (next4.text.startsWith(next5.text)) {
                    next3.text += next5.text;
                    next4.text = next4.text.substring(next5.text.length()) + next5.text;
                    listIterator2.remove();
                    z2 = true;
                    Diff diff2 = next4;
                    next4 = listIterator2.hasNext() ? listIterator2.next() : null;
                    next3 = diff2;
                }
                next5 = !listIterator2.hasNext() ? listIterator2.next() : null;
            }
            next3 = next4;
            next4 = next5;
            if (!listIterator2.hasNext()) {
            }
        }
        if (z2) {
            diff_cleanupMerge(linkedList);
        }
    }

    public int diff_xIndex(List<Diff> list, int i) {
        Diff diff;
        Iterator<Diff> it = list.iterator();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (!it.hasNext()) {
                diff = null;
                break;
            }
            diff = it.next();
            if (diff.operation != Operation.INSERT) {
                i2 += diff.text.length();
            }
            if (diff.operation != Operation.DELETE) {
                i3 += diff.text.length();
            }
            if (i2 > i) {
                break;
            }
            i4 = i2;
            i5 = i3;
        }
        return (diff == null || diff.operation != Operation.DELETE) ? i5 + (i - i4) : i5;
    }

    public String diff_prettyHtml(List<Diff> list) {
        StringBuilder sb = new StringBuilder();
        for (Diff diff : list) {
            String replace = diff.text.replace(ContainerUtils.FIELD_DELIMITER, "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace(UpdateDialogNewBase.TYPE, "&para;<br>");
            int i = AnonymousClass1.$SwitchMap$com$bytedance$sync$diff$DiffMatchPatch$Operation[diff.operation.ordinal()];
            if (i == 1) {
                sb.append("<ins style=\"background:#e6ffe6;\">").append(replace).append("</ins>");
            } else if (i == 2) {
                sb.append("<del style=\"background:#ffe6e6;\">").append(replace).append("</del>");
            } else if (i == 3) {
                sb.append("<span>").append(replace).append("</span>");
            }
        }
        return sb.toString();
    }

    public String diff_text1(List<Diff> list) {
        StringBuilder sb = new StringBuilder();
        for (Diff diff : list) {
            if (diff.operation != Operation.INSERT) {
                sb.append(diff.text);
            }
        }
        return sb.toString();
    }

    public String diff_text2(List<Diff> list) {
        StringBuilder sb = new StringBuilder();
        for (Diff diff : list) {
            if (diff.operation != Operation.DELETE) {
                sb.append(diff.text);
            }
        }
        return sb.toString();
    }

    public int diff_levenshtein(List<Diff> list) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            for (Diff diff : list) {
                int i4 = AnonymousClass1.$SwitchMap$com$bytedance$sync$diff$DiffMatchPatch$Operation[diff.operation.ordinal()];
                if (i4 == 1) {
                    i2 += diff.text.length();
                } else if (i4 == 2) {
                    i3 += diff.text.length();
                } else if (i4 != 3) {
                }
            }
            return i + Math.max(i2, i3);
            i += Math.max(i2, i3);
            i2 = 0;
        }
    }

    public String diff_toDelta(List<Diff> list) {
        StringBuilder sb = new StringBuilder();
        for (Diff diff : list) {
            int i = AnonymousClass1.$SwitchMap$com$bytedance$sync$diff$DiffMatchPatch$Operation[diff.operation.ordinal()];
            if (i == 1) {
                try {
                    sb.append("+").append(URLEncoder.encode(diff.text, "UTF-8").replace('+', ' ')).append("\t");
                } catch (UnsupportedEncodingException e) {
                    throw new Error("This system does not support UTF-8.", e);
                }
            } else if (i == 2) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER).append(diff.text.length()).append("\t");
            } else if (i == 3) {
                sb.append(ContainerUtils.KEY_VALUE_DELIMITER).append(diff.text.length()).append("\t");
            }
        }
        String sb2 = sb.toString();
        return sb2.length() != 0 ? unescapeForEncodeUriCompatability(sb2.substring(0, sb2.length() - 1)) : sb2;
    }

    public LinkedList<Diff> diff_fromDelta(String str, String str2) throws IllegalArgumentException {
        LinkedList<Diff> linkedList = new LinkedList<>();
        int i = 0;
        for (String str3 : str2.split("\t")) {
            if (str3.length() != 0) {
                String substring = str3.substring(1);
                char charAt = str3.charAt(0);
                if (charAt == '+') {
                    String replace = substring.replace("+", "%2B");
                    try {
                        linkedList.add(new Diff(Operation.INSERT, URLDecoder.decode(replace, "UTF-8")));
                    } catch (UnsupportedEncodingException e) {
                        throw new Error("This system does not support UTF-8.", e);
                    } catch (IllegalArgumentException e2) {
                        throw new IllegalArgumentException("Illegal escape in diff_fromDelta: " + replace, e2);
                    }
                } else if (charAt == '-' || charAt == '=') {
                    try {
                        int parseInt = Integer.parseInt(substring);
                        if (parseInt < 0) {
                            throw new IllegalArgumentException("Negative number in diff_fromDelta: " + substring);
                        }
                        int i2 = parseInt + i;
                        try {
                            String substring2 = str.substring(i, i2);
                            if (str3.charAt(0) == '=') {
                                linkedList.add(new Diff(Operation.EQUAL, substring2));
                            } else {
                                linkedList.add(new Diff(Operation.DELETE, substring2));
                            }
                            i = i2;
                        } catch (StringIndexOutOfBoundsException e3) {
                            throw new IllegalArgumentException("Delta length (" + i2 + ") larger than source text length (" + str.length() + ").", e3);
                        }
                    } catch (NumberFormatException e4) {
                        throw new IllegalArgumentException("Invalid number in diff_fromDelta: " + substring, e4);
                    }
                } else {
                    throw new IllegalArgumentException("Invalid diff operation in diff_fromDelta: " + str3.charAt(0));
                }
            }
        }
        if (i == str.length()) {
            return linkedList;
        }
        throw new IllegalArgumentException("Delta length (" + i + ") smaller than source text length (" + str.length() + ").");
    }

    public int match_main(String str, String str2, int i) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Null inputs. (match_main)");
        }
        int max = Math.max(0, Math.min(i, str.length()));
        if (str.equals(str2)) {
            return 0;
        }
        if (str.length() == 0) {
            return -1;
        }
        return (str2.length() + max > str.length() || !str.substring(max, str2.length() + max).equals(str2)) ? match_bitap(str, str2, max) : max;
    }

    protected int match_bitap(String str, String str2, int i) {
        Map<Character, Integer> match_alphabet = match_alphabet(str2);
        double d = this.Match_Threshold;
        int indexOf = str.indexOf(str2, i);
        int i2 = -1;
        int i3 = 0;
        if (indexOf != -1) {
            d = Math.min(match_bitapScore(0, indexOf, i, str2), d);
            int lastIndexOf = str.lastIndexOf(str2, str2.length() + i);
            if (lastIndexOf != -1) {
                d = Math.min(match_bitapScore(0, lastIndexOf, i, str2), d);
            }
        }
        int i4 = 1;
        int length = 1 << (str2.length() - 1);
        int length2 = str2.length() + str.length();
        int[] iArr = new int[0];
        int i5 = 0;
        while (i5 < str2.length()) {
            int i6 = i3;
            int i7 = length2;
            while (i6 < length2) {
                if (match_bitapScore(i5, i + length2, i, str2) <= d) {
                    i6 = length2;
                } else {
                    i7 = length2;
                }
                length2 = ((i7 - i6) / 2) + i6;
            }
            int max = Math.max(i4, (i - length2) + i4);
            int min = Math.min(i + length2, str.length()) + str2.length();
            int[] iArr2 = new int[min + 2];
            iArr2[min + 1] = (i4 << i5) - 1;
            while (true) {
                if (min < max) {
                    break;
                }
                int i8 = i2;
                i2 = min - 1;
                int intValue = (str.length() <= i2 || !match_alphabet.containsKey(Character.valueOf(str.charAt(i2)))) ? 0 : match_alphabet.get(Character.valueOf(str.charAt(i2))).intValue();
                if (i5 == 0) {
                    iArr2[min] = ((iArr2[min + 1] << 1) | 1) & intValue;
                } else {
                    int i9 = min + 1;
                    int i10 = ((iArr2[i9] << 1) | 1) & intValue;
                    int i11 = iArr[i9];
                    iArr2[min] = i10 | ((i11 | iArr[min]) << 1) | 1 | i11;
                }
                if ((iArr2[min] & length) != 0) {
                    double match_bitapScore = match_bitapScore(i5, i2, i, str2);
                    if (match_bitapScore <= d) {
                        if (i2 <= i) {
                            i4 = 1;
                            d = match_bitapScore;
                            break;
                        }
                        i4 = 1;
                        max = Math.max(1, (i * 2) - i2);
                        d = match_bitapScore;
                        min--;
                    }
                }
                i4 = 1;
                i2 = i8;
                min--;
            }
            i5++;
            if (match_bitapScore(i5, i, i, str2) > d) {
                break;
            }
            iArr = iArr2;
            i3 = 0;
        }
        return i2;
    }

    private double match_bitapScore(int i, int i2, int i3, String str) {
        float length = i / str.length();
        int abs = Math.abs(i3 - i2);
        if (this.Match_Distance != 0) {
            return length + (abs / r3);
        }
        if (abs == 0) {
            return length;
        }
        return 1.0d;
    }

    protected Map<Character, Integer> match_alphabet(String str) {
        HashMap hashMap = new HashMap();
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            hashMap.put(Character.valueOf(c), 0);
        }
        int i = 0;
        for (char c2 : charArray) {
            hashMap.put(Character.valueOf(c2), Integer.valueOf(((Integer) hashMap.get(Character.valueOf(c2))).intValue() | (1 << ((str.length() - i) - 1))));
            i++;
        }
        return hashMap;
    }

    protected void patch_addContext(Patch patch, String str) {
        if (str.length() == 0) {
            return;
        }
        String substring = str.substring(patch.start2, patch.start2 + patch.length1);
        int i = 0;
        while (str.indexOf(substring) != str.lastIndexOf(substring)) {
            int length = substring.length();
            short s = this.Match_MaxBits;
            short s2 = this.Patch_Margin;
            if (length >= (s - s2) - s2) {
                break;
            }
            i += s2;
            substring = str.substring(Math.max(0, patch.start2 - i), Math.min(str.length(), patch.start2 + patch.length1 + i));
        }
        int i2 = i + this.Patch_Margin;
        String substring2 = str.substring(Math.max(0, patch.start2 - i2), patch.start2);
        if (substring2.length() != 0) {
            patch.diffs.addFirst(new Diff(Operation.EQUAL, substring2));
        }
        String substring3 = str.substring(patch.start2 + patch.length1, Math.min(str.length(), patch.start2 + patch.length1 + i2));
        if (substring3.length() != 0) {
            patch.diffs.addLast(new Diff(Operation.EQUAL, substring3));
        }
        patch.start1 -= substring2.length();
        patch.start2 -= substring2.length();
        patch.length1 += substring2.length() + substring3.length();
        patch.length2 += substring2.length() + substring3.length();
    }

    public LinkedList<Patch> patch_make(String str, String str2) {
        if (str == null || str2 == null) {
            throw new IllegalArgumentException("Null inputs. (patch_make)");
        }
        LinkedList<Diff> diff_main = diff_main(str, str2, true);
        if (diff_main.size() > 2) {
            diff_cleanupSemantic(diff_main);
            diff_cleanupEfficiency(diff_main);
        }
        return patch_make(str, diff_main);
    }

    public LinkedList<Patch> patch_make(LinkedList<Diff> linkedList) {
        if (linkedList == null) {
            throw new IllegalArgumentException("Null inputs. (patch_make)");
        }
        return patch_make(diff_text1(linkedList), linkedList);
    }

    @Deprecated
    public LinkedList<Patch> patch_make(String str, String str2, LinkedList<Diff> linkedList) {
        return patch_make(str, linkedList);
    }

    public LinkedList<Patch> patch_make(String str, LinkedList<Diff> linkedList) {
        if (str == null || linkedList == null) {
            throw new IllegalArgumentException("Null inputs. (patch_make)");
        }
        LinkedList<Patch> linkedList2 = new LinkedList<>();
        if (linkedList.isEmpty()) {
            return linkedList2;
        }
        Patch patch = new Patch();
        Iterator<Diff> it = linkedList.iterator();
        Patch patch2 = patch;
        int i = 0;
        int i2 = 0;
        String str2 = str;
        while (it.hasNext()) {
            Diff next = it.next();
            if (patch2.diffs.isEmpty() && next.operation != Operation.EQUAL) {
                patch2.start1 = i;
                patch2.start2 = i2;
            }
            int i3 = AnonymousClass1.$SwitchMap$com$bytedance$sync$diff$DiffMatchPatch$Operation[next.operation.ordinal()];
            if (i3 == 1) {
                patch2.diffs.add(next);
                patch2.length2 += next.text.length();
                str2 = str2.substring(0, i2) + next.text + str2.substring(i2);
            } else if (i3 == 2) {
                patch2.length1 += next.text.length();
                patch2.diffs.add(next);
                str2 = str2.substring(0, i2) + str2.substring(next.text.length() + i2);
            } else if (i3 == 3) {
                if (next.text.length() <= this.Patch_Margin * 2 && !patch2.diffs.isEmpty() && next != linkedList.getLast()) {
                    patch2.diffs.add(next);
                    patch2.length1 += next.text.length();
                    patch2.length2 += next.text.length();
                }
                if (next.text.length() >= this.Patch_Margin * 2 && !patch2.diffs.isEmpty() && !patch2.diffs.isEmpty()) {
                    patch_addContext(patch2, str);
                    linkedList2.add(patch2);
                    patch2 = new Patch();
                    str = str2;
                    i = i2;
                }
            }
            if (next.operation != Operation.INSERT) {
                i += next.text.length();
            }
            if (next.operation != Operation.DELETE) {
                i2 += next.text.length();
            }
        }
        if (!patch2.diffs.isEmpty()) {
            patch_addContext(patch2, str);
            linkedList2.add(patch2);
        }
        return linkedList2;
    }

    public LinkedList<Patch> patch_deepCopy(LinkedList<Patch> linkedList) {
        LinkedList<Patch> linkedList2 = new LinkedList<>();
        Iterator<Patch> it = linkedList.iterator();
        while (it.hasNext()) {
            Patch next = it.next();
            Patch patch = new Patch();
            Iterator<Diff> it2 = next.diffs.iterator();
            while (it2.hasNext()) {
                Diff next2 = it2.next();
                patch.diffs.add(new Diff(next2.operation, next2.text));
            }
            patch.start1 = next.start1;
            patch.start2 = next.start2;
            patch.length1 = next.length1;
            patch.length2 = next.length2;
            linkedList2.add(patch);
        }
        return linkedList2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object[] patch_apply(LinkedList<Patch> linkedList, String str) {
        int match_main;
        int i;
        String substring;
        if (linkedList.isEmpty()) {
            return new Object[]{str, new boolean[0]};
        }
        LinkedList<Patch> patch_deepCopy = patch_deepCopy(linkedList);
        String patch_addPadding = patch_addPadding(patch_deepCopy);
        String str2 = patch_addPadding + str + patch_addPadding;
        patch_splitMax(patch_deepCopy);
        boolean[] zArr = new boolean[patch_deepCopy.size()];
        Iterator<Patch> it = patch_deepCopy.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Patch next = it.next();
            int i4 = next.start2 + i2;
            String diff_text1 = diff_text1(next.diffs);
            int length = diff_text1.length();
            short s = this.Match_MaxBits;
            if (length > s) {
                match_main = match_main(str2, diff_text1.substring(0, s), i4);
                if (match_main != -1) {
                    i = match_main(str2, diff_text1.substring(diff_text1.length() - this.Match_MaxBits), (diff_text1.length() + i4) - this.Match_MaxBits);
                    if (i == -1 || match_main >= i) {
                        match_main = -1;
                    }
                    if (match_main != -1) {
                        zArr[i3] = false;
                        i2 -= next.length2 - next.length1;
                    } else {
                        zArr[i3] = true;
                        int i5 = match_main - i4;
                        if (i == -1) {
                            substring = str2.substring(match_main, Math.min(diff_text1.length() + match_main, str2.length()));
                        } else {
                            substring = str2.substring(match_main, Math.min(i + this.Match_MaxBits, str2.length()));
                        }
                        if (diff_text1.equals(substring)) {
                            str2 = str2.substring(0, match_main) + diff_text2(next.diffs) + str2.substring(match_main + diff_text1.length());
                        } else {
                            LinkedList<Diff> diff_main = diff_main(diff_text1, substring, false);
                            if (diff_text1.length() > this.Match_MaxBits && diff_levenshtein(diff_main) / diff_text1.length() > this.Patch_DeleteThreshold) {
                                zArr[i3] = false;
                            } else {
                                diff_cleanupSemanticLossless(diff_main);
                                Iterator<Diff> it2 = next.diffs.iterator();
                                int i6 = 0;
                                while (it2.hasNext()) {
                                    Diff next2 = it2.next();
                                    if (next2.operation != Operation.EQUAL) {
                                        int diff_xIndex = diff_xIndex(diff_main, i6);
                                        if (next2.operation == Operation.INSERT) {
                                            int i7 = diff_xIndex + match_main;
                                            str2 = str2.substring(0, i7) + next2.text + str2.substring(i7);
                                        } else if (next2.operation == Operation.DELETE) {
                                            str2 = str2.substring(0, diff_xIndex + match_main) + str2.substring(diff_xIndex(diff_main, next2.text.length() + i6) + match_main);
                                        }
                                    }
                                    if (next2.operation != Operation.DELETE) {
                                        i6 += next2.text.length();
                                    }
                                }
                            }
                        }
                        i2 = i5;
                    }
                    i3++;
                }
            } else {
                match_main = match_main(str2, diff_text1, i4);
            }
            i = -1;
            if (match_main != -1) {
            }
            i3++;
        }
        return new Object[]{str2.substring(patch_addPadding.length(), str2.length() - patch_addPadding.length()), zArr};
    }

    public String patch_addPadding(LinkedList<Patch> linkedList) {
        short s = this.Patch_Margin;
        String str = "";
        for (short s2 = 1; s2 <= s; s2 = (short) (s2 + 1)) {
            str = str + String.valueOf((char) s2);
        }
        Iterator<Patch> it = linkedList.iterator();
        while (it.hasNext()) {
            Patch next = it.next();
            next.start1 += s;
            next.start2 += s;
        }
        Patch first = linkedList.getFirst();
        LinkedList<Diff> linkedList2 = first.diffs;
        if (linkedList2.isEmpty() || linkedList2.getFirst().operation != Operation.EQUAL) {
            linkedList2.addFirst(new Diff(Operation.EQUAL, str));
            first.start1 -= s;
            first.start2 -= s;
            first.length1 += s;
            first.length2 += s;
        } else if (s > linkedList2.getFirst().text.length()) {
            Diff first2 = linkedList2.getFirst();
            int length = s - first2.text.length();
            first2.text = str.substring(first2.text.length()) + first2.text;
            first.start1 -= length;
            first.start2 -= length;
            first.length1 += length;
            first.length2 += length;
        }
        Patch last = linkedList.getLast();
        LinkedList<Diff> linkedList3 = last.diffs;
        if (linkedList3.isEmpty() || linkedList3.getLast().operation != Operation.EQUAL) {
            linkedList3.addLast(new Diff(Operation.EQUAL, str));
            last.length1 += s;
            last.length2 += s;
        } else if (s > linkedList3.getLast().text.length()) {
            Diff last2 = linkedList3.getLast();
            int length2 = s - last2.text.length();
            last2.text += str.substring(0, length2);
            last.length1 += length2;
            last.length2 += length2;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x0014 -> B:4:0x0015). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void patch_splitMax(LinkedList<Patch> linkedList) {
        Patch patch;
        String diff_text1;
        short s = this.Match_MaxBits;
        ListIterator<Patch> listIterator = linkedList.listIterator();
        if (listIterator.hasNext()) {
            patch = listIterator.next();
            while (patch != null) {
                if (patch.length1 <= this.Match_MaxBits) {
                    if (listIterator.hasNext()) {
                        patch = listIterator.next();
                    }
                } else {
                    listIterator.remove();
                    int i = patch.start1;
                    int i2 = patch.start2;
                    String str = "";
                    while (!patch.diffs.isEmpty()) {
                        Patch patch2 = new Patch();
                        patch2.start1 = i - str.length();
                        patch2.start2 = i2 - str.length();
                        if (str.length() != 0) {
                            int length = str.length();
                            patch2.length2 = length;
                            patch2.length1 = length;
                            patch2.diffs.add(new Diff(Operation.EQUAL, str));
                        }
                        boolean z = true;
                        while (!patch.diffs.isEmpty() && patch2.length1 < s - this.Patch_Margin) {
                            Operation operation = patch.diffs.getFirst().operation;
                            String str2 = patch.diffs.getFirst().text;
                            if (operation == Operation.INSERT) {
                                patch2.length2 += str2.length();
                                i2 += str2.length();
                                patch2.diffs.addLast(patch.diffs.removeFirst());
                            } else if (operation == Operation.DELETE && patch2.diffs.size() == 1 && patch2.diffs.getFirst().operation == Operation.EQUAL && str2.length() > s * 2) {
                                patch2.length1 += str2.length();
                                i += str2.length();
                                patch2.diffs.add(new Diff(operation, str2));
                                patch.diffs.removeFirst();
                            } else {
                                String substring = str2.substring(0, Math.min(str2.length(), (s - patch2.length1) - this.Patch_Margin));
                                patch2.length1 += substring.length();
                                i += substring.length();
                                if (operation == Operation.EQUAL) {
                                    patch2.length2 += substring.length();
                                    i2 += substring.length();
                                } else {
                                    z = false;
                                }
                                patch2.diffs.add(new Diff(operation, substring));
                                if (substring.equals(patch.diffs.getFirst().text)) {
                                    patch.diffs.removeFirst();
                                } else {
                                    patch.diffs.getFirst().text = patch.diffs.getFirst().text.substring(substring.length());
                                }
                            }
                            z = false;
                        }
                        String diff_text2 = diff_text2(patch2.diffs);
                        str = diff_text2.substring(Math.max(0, diff_text2.length() - this.Patch_Margin));
                        if (diff_text1(patch.diffs).length() > this.Patch_Margin) {
                            diff_text1 = diff_text1(patch.diffs).substring(0, this.Patch_Margin);
                        } else {
                            diff_text1 = diff_text1(patch.diffs);
                        }
                        if (diff_text1.length() != 0) {
                            patch2.length1 += diff_text1.length();
                            patch2.length2 += diff_text1.length();
                            if (!patch2.diffs.isEmpty() && patch2.diffs.getLast().operation == Operation.EQUAL) {
                                StringBuilder sb = new StringBuilder();
                                Diff last = patch2.diffs.getLast();
                                last.text = sb.append(last.text).append(diff_text1).toString();
                            } else {
                                patch2.diffs.add(new Diff(Operation.EQUAL, diff_text1));
                            }
                        }
                        if (!z) {
                            listIterator.add(patch2);
                        }
                    }
                    if (listIterator.hasNext()) {
                        patch = listIterator.next();
                    }
                }
                while (patch != null) {
                }
            }
        }
        patch = null;
        while (patch != null) {
        }
    }

    public String patch_toText(List<Patch> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<Patch> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public List<Patch> patch_fromText(String str) throws IllegalArgumentException {
        char charAt;
        String replace;
        LinkedList linkedList = new LinkedList();
        if (str.length() == 0) {
            return linkedList;
        }
        LinkedList linkedList2 = new LinkedList(Arrays.asList(str.split(UpdateDialogNewBase.TYPE)));
        Pattern compile = Pattern.compile("^@@ -(\\d+),?(\\d*) \\+(\\d+),?(\\d*) @@$");
        while (!linkedList2.isEmpty()) {
            Matcher matcher = compile.matcher((CharSequence) linkedList2.getFirst());
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Invalid patch string: " + ((String) linkedList2.getFirst()));
            }
            Patch patch = new Patch();
            linkedList.add(patch);
            patch.start1 = Integer.parseInt(matcher.group(1));
            if (matcher.group(2).length() == 0) {
                patch.start1--;
                patch.length1 = 1;
            } else if (matcher.group(2).equals("0")) {
                patch.length1 = 0;
            } else {
                patch.start1--;
                patch.length1 = Integer.parseInt(matcher.group(2));
            }
            patch.start2 = Integer.parseInt(matcher.group(3));
            if (matcher.group(4).length() == 0) {
                patch.start2--;
                patch.length2 = 1;
            } else if (matcher.group(4).equals("0")) {
                patch.length2 = 0;
            } else {
                patch.start2--;
                patch.length2 = Integer.parseInt(matcher.group(4));
            }
            linkedList2.removeFirst();
            while (true) {
                if (!linkedList2.isEmpty()) {
                    try {
                        charAt = ((String) linkedList2.getFirst()).charAt(0);
                        replace = ((String) linkedList2.getFirst()).substring(1).replace("+", "%2B");
                    } catch (IndexOutOfBoundsException unused) {
                        linkedList2.removeFirst();
                    }
                    try {
                        String decode = URLDecoder.decode(replace, "UTF-8");
                        if (charAt == '-') {
                            patch.diffs.add(new Diff(Operation.DELETE, decode));
                        } else if (charAt == '+') {
                            patch.diffs.add(new Diff(Operation.INSERT, decode));
                        } else if (charAt == ' ') {
                            patch.diffs.add(new Diff(Operation.EQUAL, decode));
                        } else if (charAt != '@') {
                            throw new IllegalArgumentException("Invalid patch mode '" + charAt + "' in: " + decode);
                        }
                        linkedList2.removeFirst();
                    } catch (UnsupportedEncodingException e) {
                        throw new Error("This system does not support UTF-8.", e);
                    } catch (IllegalArgumentException e2) {
                        throw new IllegalArgumentException("Illegal escape in patch_fromText: " + replace, e2);
                    }
                }
            }
        }
        return linkedList;
    }

    /* loaded from: classes5.dex */
    public static class Diff {
        public Operation operation;
        public String text;

        public Diff(Operation operation, String str) {
            this.operation = operation;
            this.text = str;
        }

        public String toString() {
            return "Diff(" + this.operation + ",\"" + this.text.replace('\n', Typography.paragraph) + "\")";
        }

        public int hashCode() {
            Operation operation = this.operation;
            int hashCode = operation == null ? 0 : operation.hashCode();
            String str = this.text;
            return hashCode + ((str != null ? str.hashCode() : 0) * 31);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Diff diff = (Diff) obj;
            if (this.operation != diff.operation) {
                return false;
            }
            String str = this.text;
            if (str == null) {
                if (diff.text != null) {
                    return false;
                }
            } else if (!str.equals(diff.text)) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    public static class Patch {
        public LinkedList<Diff> diffs = new LinkedList<>();
        public int length1;
        public int length2;
        public int start1;
        public int start2;

        public String toString() {
            String str;
            String str2;
            int i = this.length1;
            if (i == 0) {
                str = this.start1 + ",0";
            } else if (i == 1) {
                str = Integer.toString(this.start1 + 1);
            } else {
                str = (this.start1 + 1) + "," + this.length1;
            }
            int i2 = this.length2;
            if (i2 == 0) {
                str2 = this.start2 + ",0";
            } else if (i2 == 1) {
                str2 = Integer.toString(this.start2 + 1);
            } else {
                str2 = (this.start2 + 1) + "," + this.length2;
            }
            StringBuilder sb = new StringBuilder("@@ -");
            sb.append(str).append(" +").append(str2).append(" @@\n");
            Iterator<Diff> it = this.diffs.iterator();
            while (it.hasNext()) {
                Diff next = it.next();
                int i3 = AnonymousClass1.$SwitchMap$com$bytedance$sync$diff$DiffMatchPatch$Operation[next.operation.ordinal()];
                if (i3 == 1) {
                    sb.append('+');
                } else if (i3 == 2) {
                    sb.append('-');
                } else if (i3 == 3) {
                    sb.append(' ');
                }
                try {
                    sb.append(URLEncoder.encode(next.text, "UTF-8").replace('+', ' ')).append(UpdateDialogNewBase.TYPE);
                } catch (UnsupportedEncodingException e) {
                    throw new Error("This system does not support UTF-8.", e);
                }
            }
            return DiffMatchPatch.unescapeForEncodeUriCompatability(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String unescapeForEncodeUriCompatability(String str) {
        return str.replace("%21", "!").replace("%7E", Constants.WAVE_SEPARATOR).replace("%27", "'").replace("%28", "(").replace("%29", ")").replace("%3B", ";").replace("%2F", "/").replace("%3F", "?").replace("%3A", Constants.COLON_SEPARATOR).replace("%40", "@").replace("%26", ContainerUtils.FIELD_DELIMITER).replace("%3D", ContainerUtils.KEY_VALUE_DELIMITER).replace("%2B", "+").replace("%24", "$").replace("%2C", ",").replace("%23", "#");
    }
}
