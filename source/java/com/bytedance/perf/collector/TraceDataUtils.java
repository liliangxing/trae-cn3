package com.bytedance.perf.collector;

import android.util.Log;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.block.trace.MethodCollector;
import com.bytedance.apm.block.trace.MethodItem;
import com.bytedance.apm.logging.MethodLogger;
import com.bytedance.rts.foundation.Int64;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class TraceDataUtils {
    private static final String TAG = "TraceDataUtils";

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface IStructuredDataFilter {
        void fallback(List<MethodItem> list, int i);

        int getFilterMaxCount();

        boolean isFilter(long j, int i);
    }

    public static int getMethodId(long j) {
        return (int) ((j >> 43) & 1048575);
    }

    private static long getTime(long j) {
        return j & 8796093022207L;
    }

    private static boolean isIn(long j) {
        return ((j >> 63) & 1) == 1;
    }

    public static void structuredDataToStack(long[] jArr, LinkedList<MethodItem> linkedList, long j, int i) {
        structuredDataToStack(1048574, jArr, linkedList, true, j, i);
    }

    public static void structuredDataToStack(long[] jArr, LinkedList<MethodItem> linkedList, boolean z, long j) {
        structuredDataToStack(1048574, jArr, linkedList, z, j, -1);
    }

    public static void structuredDataToStack(int i, long[] jArr, LinkedList<MethodItem> linkedList, boolean z, long j, int i2) {
        long j2;
        int methodId;
        if (jArr == null || jArr.length == 0) {
            return;
        }
        int i3 = 1;
        long j3 = 0;
        long time = jArr[jArr.length - 1] != 0 ? getTime(jArr[jArr.length - 1]) : Int64.MAX_VALUE;
        int i4 = 0;
        int i5 = 0;
        while (i5 < jArr.length && getTime(jArr[i5]) >= time) {
            i5++;
        }
        int i6 = i <= 0 ? 1048574 : i;
        LinkedList linkedList2 = new LinkedList();
        int i7 = 0;
        int i8 = 0;
        while (i5 < jArr.length) {
            long j4 = jArr[i5];
            if (j3 != j4) {
                if (z) {
                    if (isIn(j4) && i6 == getMethodId(j4)) {
                        i8 = i3;
                    }
                    if (i8 == 0) {
                        if (getMethodId(j4) > 1048000) {
                            Object[] objArr = new Object[2];
                            objArr[i4] = Integer.valueOf(getMethodId(j4));
                            objArr[i3] = Boolean.valueOf(isIn(j4));
                            MethodLogger.i("SceneMethodsInfo", "s2 pass this method[%s], isIn [%b] ", objArr);
                        }
                    }
                }
                if (isIn(j4)) {
                    if (getMethodId(j4) == i6) {
                        linkedList2.clear();
                        i7 = i4;
                    }
                    i7 += i3;
                    linkedList2.push(Long.valueOf(j4));
                } else {
                    int methodId2 = getMethodId(j4);
                    if (!linkedList2.isEmpty()) {
                        long longValue = ((Long) linkedList2.pop()).longValue();
                        i7--;
                        LinkedList linkedList3 = new LinkedList();
                        linkedList3.push(Long.valueOf(longValue));
                        while (true) {
                            methodId = getMethodId(longValue);
                            if (methodId == methodId2 || linkedList2.isEmpty()) {
                                break;
                            }
                            if (ApmContext.isDebugMode()) {
                                Object[] objArr2 = new Object[2];
                                objArr2[i4] = Integer.valueOf(methodId);
                                objArr2[i3] = Integer.valueOf(methodId2);
                                MethodLogger.w(TAG, "pop inMethodId[%s] to continue match ouMethodId[%s]", objArr2);
                            }
                            longValue = ((Long) linkedList2.pop()).longValue();
                            i7--;
                            linkedList3.push(Long.valueOf(longValue));
                        }
                        if (methodId != methodId2 && methodId == i6) {
                            ApmContext.isDebugMode();
                            linkedList2.addAll(linkedList3);
                            i7 += linkedList2.size();
                        } else {
                            long time2 = getTime(j4) + MethodCollector.getDiffTime();
                            while (linkedList3.size() != 0) {
                                long time3 = getTime(((Long) linkedList3.pop()).longValue()) + MethodCollector.getDiffTime();
                                long j5 = time2 - time3;
                                if (j5 < 0) {
                                    if (ApmContext.isDebugMode()) {
                                        MethodLogger.e(TAG, "[structuredDataToStack] trace during invalid:%d", new Object[]{Long.valueOf(j5)});
                                    }
                                    linkedList2.clear();
                                    linkedList.clear();
                                    return;
                                }
                                addMethodItem(linkedList, new MethodItem(methodId2, (int) j5, time3, i7));
                            }
                        }
                        j2 = 0;
                    } else {
                        j2 = j3;
                        if (ApmContext.isDebugMode()) {
                            MethodLogger.w(TAG, "[structuredDataToStack] method[%s] not found in! ", new Object[]{Integer.valueOf(methodId2)});
                        }
                    }
                    i5++;
                    j3 = j2;
                    i4 = 0;
                    i3 = 1;
                }
            }
            j2 = j3;
            i5++;
            j3 = j2;
            i4 = 0;
            i3 = 1;
        }
        MethodLogger.i("SceneMethodsInfo", "structuredDataToStack inner, result.size: " + linkedList.size() + ", " + linkedList2.size(), new Object[0]);
        while (!linkedList2.isEmpty()) {
            long longValue2 = ((Long) linkedList2.pop()).longValue();
            int methodId3 = getMethodId(longValue2);
            boolean isIn = isIn(longValue2);
            long time4 = getTime(longValue2) + MethodCollector.getDiffTime();
            if (ApmContext.isDebugMode()) {
                MethodLogger.w(TAG, "[structuredDataToStack] has never out method[%s], isIn:%s, inTime:%s, endTime:%s,rawData size:%s", new Object[]{Integer.valueOf(methodId3), Boolean.valueOf(isIn), Long.valueOf(time4), Long.valueOf(j), Integer.valueOf(linkedList2.size())});
            }
            if (isIn) {
                if (!(i2 > 0) || i7 <= i2) {
                    addMethodItem(linkedList, new MethodItem(methodId3, (int) (j - time4), time4, linkedList2.size()));
                }
            } else if (ApmContext.isDebugMode()) {
                MethodLogger.e(TAG, "[structuredDataToStack] why has out Method[%s]? is wrong! ", new Object[]{Integer.valueOf(methodId3)});
            }
        }
        TreeNode treeNode = new TreeNode(null, null);
        stackToTree(linkedList, treeNode);
        linkedList.clear();
        treeToStack(treeNode, linkedList);
    }

    private static int addMethodItem(LinkedList<MethodItem> linkedList, MethodItem methodItem) {
        if (ApmContext.isDebugMode()) {
            Log.v(TAG, "method:" + methodItem);
        }
        MethodItem peek = !linkedList.isEmpty() ? linkedList.peek() : null;
        if (peek != null && peek.methodId == methodItem.methodId && peek.depth == methodItem.depth && methodItem.depth != 0) {
            methodItem.durTime = methodItem.durTime == 5000 ? peek.durTime : methodItem.durTime;
            peek.mergeMore(methodItem.durTime);
            return peek.durTime;
        }
        linkedList.push(methodItem);
        return methodItem.durTime;
    }

    private static void rechange(TreeNode treeNode) {
        if (treeNode.nextNode.isEmpty()) {
            return;
        }
        int size = treeNode.nextNode.size();
        TreeNode[] treeNodeArr = new TreeNode[size];
        treeNode.nextNode.toArray(treeNodeArr);
        treeNode.nextNode.clear();
        for (int i = 0; i < size; i++) {
            TreeNode treeNode2 = treeNodeArr[i];
            treeNode.nextNode.addFirst(treeNode2);
            rechange(treeNode2);
        }
    }

    private static void treeToStack(TreeNode treeNode, LinkedList<MethodItem> linkedList) {
        LinkedList linkedList2 = new LinkedList();
        while (treeNode != null) {
            if (treeNode.item != null) {
                linkedList.add(treeNode.item);
            }
            LinkedList<TreeNode> linkedList3 = treeNode.nextNode;
            if (!linkedList3.isEmpty()) {
                for (int size = linkedList3.size() - 1; size >= 0; size--) {
                    linkedList2.add(linkedList3.get(size));
                }
            }
            treeNode = (TreeNode) linkedList2.pollLast();
        }
    }

    public static int stackToTree(LinkedList<MethodItem> linkedList, TreeNode treeNode) {
        ListIterator<MethodItem> listIterator = linkedList.listIterator(0);
        TreeNode treeNode2 = null;
        int i = 0;
        while (listIterator.hasNext()) {
            TreeNode treeNode3 = new TreeNode(listIterator.next(), treeNode2);
            i++;
            if (treeNode2 == null && treeNode3.depth() != 0) {
                if (ApmContext.isDebugMode()) {
                    MethodLogger.e(TAG, "[stackToTree] SceneMethodsInfo begin error! why the first node'depth is not 0!", new Object[0]);
                }
                return 0;
            }
            int depth = treeNode3.depth();
            if (treeNode2 == null || depth == 0) {
                treeNode.add(treeNode3);
            } else if (treeNode2.depth() >= depth) {
                while (treeNode2 != null && treeNode2.depth() > depth) {
                    treeNode2 = treeNode2.father;
                }
                if (treeNode2 != null) {
                    if (treeNode2.father != null) {
                        treeNode3.father = treeNode2.father;
                        treeNode2.father.add(treeNode3);
                    }
                }
            } else {
                treeNode2.add(treeNode3);
            }
            treeNode2 = treeNode3;
        }
        MethodLogger.i("SceneMethodsInfo", "[stackToTree] count [%d] ", new Object[]{Integer.valueOf(i)});
        return i;
    }

    public static long stackToString(LinkedList<MethodItem> linkedList, StringBuilder sb) {
        Iterator<MethodItem> it = linkedList.iterator();
        long j = 0;
        while (it.hasNext()) {
            MethodItem next = it.next();
            sb.append(next.toString()).append('\n');
            if (j < next.durTime) {
                j = next.durTime;
            }
        }
        return j;
    }

    public static int countTreeNode(TreeNode treeNode) {
        int size = treeNode.nextNode.size();
        Iterator<TreeNode> it = treeNode.nextNode.iterator();
        while (it.hasNext()) {
            size += countTreeNode(it.next());
        }
        return size;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final class TreeNode {
        TreeNode father;
        MethodItem item;
        LinkedList<TreeNode> nextNode = new LinkedList<>();

        TreeNode(MethodItem methodItem, TreeNode treeNode) {
            this.item = methodItem;
            this.father = treeNode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int depth() {
            MethodItem methodItem = this.item;
            if (methodItem == null) {
                return 0;
            }
            return methodItem.depth;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void add(TreeNode treeNode) {
            this.nextNode.addFirst(treeNode);
        }

        private boolean isLeaf() {
            return this.nextNode.isEmpty();
        }
    }

    public static void printTree(TreeNode treeNode, StringBuilder sb) {
        sb.append("|*   TraceStack: ").append("\n");
        printTree(treeNode, 0, sb, "|*        ");
    }

    public static void printTree(TreeNode treeNode, int i, StringBuilder sb, String str) {
        StringBuilder sb2 = new StringBuilder(str);
        for (int i2 = 0; i2 <= i; i2++) {
            sb2.append("    ");
        }
        for (int i3 = 0; i3 < treeNode.nextNode.size(); i3++) {
            TreeNode treeNode2 = treeNode.nextNode.get(i3);
            sb.append(sb2.toString()).append(treeNode2.item.methodId).append("[").append(treeNode2.item.durTime).append("]").append("\n");
            if (!treeNode2.nextNode.isEmpty()) {
                printTree(treeNode2, i + 1, sb, str);
            }
        }
    }

    public static void trimStack(List<MethodItem> list, int i) {
        ListIterator<MethodItem> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            MethodItem previous = listIterator.previous();
            if (previous != null && previous.durTime < i) {
                listIterator.remove();
            }
        }
    }

    public static void trimStack(List<MethodItem> list, int i, IStructuredDataFilter iStructuredDataFilter) {
        if (i < 0) {
            list.clear();
            return;
        }
        int size = list.size();
        int i2 = 1;
        while (size > i) {
            ListIterator<MethodItem> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                if (iStructuredDataFilter.isFilter(listIterator.previous().durTime, i2)) {
                    listIterator.remove();
                    size--;
                    if (size <= i) {
                        return;
                    }
                }
            }
            size = list.size();
            i2++;
            if (iStructuredDataFilter.getFilterMaxCount() < i2) {
                break;
            }
        }
        int size2 = list.size();
        if (size2 > i) {
            iStructuredDataFilter.fallback(list, size2);
        }
    }

    public static void simplyTrimStack(List<MethodItem> list, int i) {
        if (i < 0) {
            list.clear();
            return;
        }
        ListIterator<MethodItem> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (listIterator.previous().durTime < i) {
                listIterator.remove();
            }
        }
    }

    @Deprecated
    public static String getTreeKey(List<MethodItem> list, final int i) {
        StringBuilder sb = new StringBuilder();
        LinkedList linkedList = new LinkedList(list);
        trimStack(linkedList, i, new IStructuredDataFilter() { // from class: com.bytedance.perf.collector.TraceDataUtils.1
            @Override // com.bytedance.perf.collector.TraceDataUtils.IStructuredDataFilter
            public int getFilterMaxCount() {
                return 60;
            }

            @Override // com.bytedance.perf.collector.TraceDataUtils.IStructuredDataFilter
            public boolean isFilter(long j, int i2) {
                return j < ((long) (i2 * 5));
            }

            @Override // com.bytedance.perf.collector.TraceDataUtils.IStructuredDataFilter
            public void fallback(List<MethodItem> list2, int i2) {
                if (ApmContext.isDebugMode()) {
                    MethodLogger.w(TraceDataUtils.TAG, "[getTreeKey] size:%s targetSize:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
                }
                ListIterator<MethodItem> listIterator = list2.listIterator(Math.min(i2, i));
                while (listIterator.hasNext()) {
                    listIterator.next();
                    listIterator.remove();
                }
            }
        });
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(((MethodItem) it.next()).methodId + "|");
        }
        return sb.toString();
    }

    public static String getTreeKey(List<MethodItem> list, long j) {
        StringBuilder sb = new StringBuilder();
        long j2 = ((float) j) * 0.3f;
        LinkedList linkedList = new LinkedList();
        for (MethodItem methodItem : list) {
            if (methodItem.durTime >= j2) {
                linkedList.add(methodItem);
            }
        }
        Collections.sort(linkedList, new Comparator<MethodItem>() { // from class: com.bytedance.perf.collector.TraceDataUtils.2
            @Override // java.util.Comparator
            public int compare(MethodItem methodItem2, MethodItem methodItem3) {
                return Integer.compare((methodItem3.depth + 1) * methodItem3.durTime, (methodItem2.depth + 1) * methodItem2.durTime);
            }
        });
        if (linkedList.isEmpty() && !list.isEmpty()) {
            linkedList.add(list.get(0));
        } else if (linkedList.size() > 1 && ((MethodItem) linkedList.peek()).methodId == 1048574) {
            linkedList.removeFirst();
        }
        Iterator it = linkedList.iterator();
        if (it.hasNext()) {
            sb.append(((MethodItem) it.next()).methodId + "\n");
        }
        return sb.toString();
    }
}
