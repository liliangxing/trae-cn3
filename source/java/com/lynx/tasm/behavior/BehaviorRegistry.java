package com.lynx.tasm.behavior;

import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes7.dex */
public class BehaviorRegistry {
    private final Map<String, Behavior> mBehaviorMap;
    private Map<String, Behavior> mBuiltInBehaviorsMap;

    public BehaviorRegistry() {
        this.mBuiltInBehaviorsMap = null;
        this.mBehaviorMap = new HashMap();
    }

    public BehaviorRegistry(Map<String, Behavior> map) {
        this.mBuiltInBehaviorsMap = null;
        if (map == null) {
            this.mBehaviorMap = new HashMap();
        } else {
            this.mBehaviorMap = new HashMap(map);
        }
    }

    @Deprecated
    public BehaviorRegistry(List<Behavior> list) {
        this.mBuiltInBehaviorsMap = null;
        this.mBehaviorMap = new HashMap();
        addBehaviors(list);
    }

    @Deprecated
    public void add(List<Behavior> list) {
        addBehaviors(list);
    }

    public void addBehaviors(List<Behavior> list) {
        if (list == null) {
            return;
        }
        Iterator<Behavior> it = list.iterator();
        while (it.hasNext()) {
            addBehavior(it.next());
        }
    }

    public void addBehavior(Behavior behavior) {
        if (behavior == null) {
            return;
        }
        String name = behavior.getName();
        Behavior behavior2 = this.mBehaviorMap.get(name);
        if (behavior2 != null) {
            Log.d("LynxError", "Duplicated Behavior For Name: " + name + ", " + behavior2 + " will be override");
        }
        this.mBehaviorMap.put(name, behavior);
    }

    public void setBuiltInBehaviors(Map<String, Behavior> map) {
        this.mBuiltInBehaviorsMap = map;
    }

    public Behavior get(String str) {
        Map<String, Behavior> map = this.mBuiltInBehaviorsMap;
        Behavior behavior = map != null ? map.get(str) : null;
        if (behavior == null) {
            behavior = this.mBehaviorMap.get(str);
        }
        if (behavior != null) {
            return behavior;
        }
        throw new RuntimeException("No BehaviorController defined for class " + str);
    }

    public Set<String> getAllBehaviorRegistryName() {
        HashSet hashSet = new HashSet();
        Iterator<Behavior> it = this.mBehaviorMap.values().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getName());
        }
        Map<String, Behavior> map = this.mBuiltInBehaviorsMap;
        if (map != null) {
            Iterator<Behavior> it2 = map.values().iterator();
            while (it2.hasNext()) {
                hashSet.add(it2.next().getName());
            }
        }
        return hashSet;
    }
}
