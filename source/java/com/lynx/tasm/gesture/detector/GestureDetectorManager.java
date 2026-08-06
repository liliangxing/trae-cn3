package com.lynx.tasm.gesture.detector;

import android.util.Pair;
import com.lynx.tasm.gesture.GestureArenaMember;
import com.lynx.tasm.gesture.arena.GestureArenaManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class GestureDetectorManager {
    private final GestureArenaManager mArenaManager;
    private final Map<Integer, Set<Integer>> mGestureToArenaMembers = new HashMap();

    public GestureDetectorManager(GestureArenaManager gestureArenaManager) {
        this.mArenaManager = gestureArenaManager;
    }

    private void registerGestureIdWithMemberId(int i, int i2) {
        if (this.mGestureToArenaMembers.get(Integer.valueOf(i)) == null) {
            this.mGestureToArenaMembers.put(Integer.valueOf(i), new HashSet());
        }
        this.mGestureToArenaMembers.get(Integer.valueOf(i)).add(Integer.valueOf(i2));
    }

    private void unregisterGestureIdWithMemberId(int i, int i2) {
        Set<Integer> set = this.mGestureToArenaMembers.get(Integer.valueOf(i));
        if (set == null || set.isEmpty() || !set.contains(Integer.valueOf(i2))) {
            return;
        }
        set.remove(Integer.valueOf(i2));
        if (set.isEmpty()) {
            this.mGestureToArenaMembers.remove(Integer.valueOf(i));
        }
    }

    public void registerGestureDetector(int i, GestureDetector gestureDetector) {
        if (gestureDetector == null) {
            return;
        }
        registerGestureIdWithMemberId(gestureDetector.getGestureID(), i);
    }

    public void unregisterGestureDetector(int i, GestureDetector gestureDetector) {
        if (gestureDetector == null) {
            return;
        }
        unregisterGestureIdWithMemberId(gestureDetector.getGestureID(), i);
    }

    public LinkedList<GestureArenaMember> convertResponseChainToCompeteChain(LinkedList<GestureArenaMember> linkedList) {
        LinkedList<GestureArenaMember> linkedList2 = new LinkedList<>();
        if (linkedList != null && !linkedList.isEmpty()) {
            int i = 0;
            while (true) {
                if (i >= linkedList.size()) {
                    break;
                }
                GestureArenaMember gestureArenaMember = linkedList.get(i);
                Map<Integer, GestureDetector> gestureDetectorMap = gestureArenaMember.getGestureDetectorMap();
                if (gestureDetectorMap == null) {
                    linkedList2.add(gestureArenaMember);
                } else {
                    List<Integer> list = null;
                    List<Integer> list2 = null;
                    for (Map.Entry entry : new TreeMap(gestureDetectorMap).entrySet()) {
                        List<Integer> list3 = ((GestureDetector) entry.getValue()).getRelationMap().get(GestureDetector.WAIT_FOR);
                        List<Integer> list4 = ((GestureDetector) entry.getValue()).getRelationMap().get(GestureDetector.CONTINUE_WITH);
                        if ((list3 != null && !list3.isEmpty()) || (list4 != null && !list4.isEmpty())) {
                            list2 = list4;
                            list = list3;
                            break;
                        }
                        list2 = list4;
                        list = list3;
                    }
                    if ((list2 == null || list2.isEmpty()) && (list == null || list.isEmpty())) {
                        linkedList2.add(gestureArenaMember);
                    } else {
                        if (list != null && !list.isEmpty()) {
                            LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
                            for (Integer num : list) {
                                if (this.mGestureToArenaMembers.get(num) != null) {
                                    linkedHashSet.addAll(this.mGestureToArenaMembers.get(num));
                                }
                            }
                            LinkedList<Integer> findCandidatesAfterCurrentInChain = findCandidatesAfterCurrentInChain(linkedList, gestureArenaMember, linkedHashSet);
                            if (findCandidatesAfterCurrentInChain == null || findCandidatesAfterCurrentInChain.isEmpty()) {
                                linkedList2.add(gestureArenaMember);
                            } else {
                                Iterator<Integer> it = findCandidatesAfterCurrentInChain.iterator();
                                while (it.hasNext()) {
                                    Integer next = it.next();
                                    if (linkedList.get(next.intValue()) != null) {
                                        linkedList2.add(linkedList.get(next.intValue()));
                                    }
                                }
                                linkedList2.add(gestureArenaMember);
                                i = linkedList.size();
                            }
                        } else {
                            linkedList2.add(gestureArenaMember);
                        }
                        if (list2 != null && !list2.isEmpty()) {
                            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                            for (Integer num2 : list2) {
                                if (this.mGestureToArenaMembers.get(num2) != null) {
                                    linkedHashSet2.addAll(this.mGestureToArenaMembers.get(num2));
                                }
                            }
                            LinkedList<GestureArenaMember> findCandidatesFromArenaMember = findCandidatesFromArenaMember(this.mGestureToArenaMembers, gestureArenaMember, linkedHashSet2);
                            if (findCandidatesFromArenaMember != null && !findCandidatesFromArenaMember.isEmpty()) {
                                linkedList2.addAll(findCandidatesFromArenaMember);
                            }
                        }
                    }
                }
                i++;
            }
        }
        return linkedList2;
    }

    public Pair<HashSet<GestureArenaMember>, HashSet<Integer>> handleSimultaneousWinner(GestureArenaMember gestureArenaMember) {
        Map<Integer, GestureDetector> gestureDetectorMap;
        List<Integer> list;
        if (gestureArenaMember == null || this.mArenaManager == null || (gestureDetectorMap = gestureArenaMember.getGestureDetectorMap()) == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        Iterator<Map.Entry<Integer, GestureDetector>> it = gestureDetectorMap.entrySet().iterator();
        while (it.hasNext()) {
            hashSet2.add(Integer.valueOf(it.next().getValue().getGestureID()));
        }
        for (Map.Entry<Integer, GestureDetector> entry : gestureDetectorMap.entrySet()) {
            if (entry.getValue() != null && (list = entry.getValue().getRelationMap().get(GestureDetector.SIMULTANEOUS)) != null && !list.isEmpty()) {
                Iterator<Integer> it2 = list.iterator();
                while (it2.hasNext()) {
                    int intValue = it2.next().intValue();
                    if (hashSet2.contains(Integer.valueOf(intValue))) {
                        hashSet3.add(Integer.valueOf(intValue));
                    } else {
                        Set<Integer> set = this.mGestureToArenaMembers.get(Integer.valueOf(intValue));
                        if (set != null) {
                            Iterator<Integer> it3 = set.iterator();
                            while (it3.hasNext()) {
                                GestureArenaMember memberById = this.mArenaManager.getMemberById(it3.next().intValue());
                                if (memberById != null && memberById.getGestureArenaMemberId() != gestureArenaMember.getGestureArenaMemberId()) {
                                    hashSet.add(memberById);
                                }
                            }
                        }
                    }
                }
            }
        }
        return new Pair<>(hashSet, hashSet3);
    }

    private LinkedList<Integer> findCandidatesAfterCurrentInChain(LinkedList<GestureArenaMember> linkedList, GestureArenaMember gestureArenaMember, LinkedHashSet<Integer> linkedHashSet) {
        int lastIndexOf;
        LinkedList<Integer> linkedList2 = null;
        if (linkedList != null && linkedHashSet != null && gestureArenaMember != null && (lastIndexOf = linkedList.lastIndexOf(gestureArenaMember)) >= 0 && lastIndexOf < linkedList.size()) {
            linkedList2 = new LinkedList<>();
            Iterator<Integer> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                for (int i = lastIndexOf + 1; i < linkedList.size(); i++) {
                    if (intValue == linkedList.get(i).getGestureArenaMemberId()) {
                        linkedList2.add(Integer.valueOf(i));
                    }
                }
            }
        }
        return linkedList2;
    }

    private LinkedList<GestureArenaMember> findCandidatesFromArenaMember(Map<Integer, Set<Integer>> map, GestureArenaMember gestureArenaMember, Set<Integer> set) {
        if (map == null || set == null || gestureArenaMember == null || this.mArenaManager == null) {
            return null;
        }
        LinkedList<GestureArenaMember> linkedList = new LinkedList<>();
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            linkedList.add(this.mArenaManager.getMemberById(it.next().intValue()));
        }
        return linkedList;
    }

    public void onDestroy() {
        this.mGestureToArenaMembers.clear();
    }
}
