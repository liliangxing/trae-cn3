package com.bytedance.timonbase.pipeline;

import com.bytedance.timon.TimonException;
import com.bytedance.timon.foundation.TimonFoundation;
import com.bytedance.timon.pipeline.ApmParams;
import com.bytedance.timon.pipeline.ComponentDeps;
import com.bytedance.timon.pipeline.TimonComponent;
import com.bytedance.timon.pipeline.TimonEntity;
import com.bytedance.timon.pipeline.TimonSystem;
import com.bytedance.timonbase.TMEnv;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: TimonPipeline.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 &2\u00020\u0001:\u0002&'B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J4\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016J:\u0010\u000f\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0016J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u001b\u001a\u00020\u0014J\u0006\u0010\u001c\u001a\u00020\u0010J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010!\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0001J$\u0010\"\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00032\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140$H\u0004J\u0018\u0010%\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\u0001H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/bytedance/timonbase/pipeline/TimonPipeline;", "Lcom/bytedance/timon/pipeline/TimonSystem;", "name", "", "(Ljava/lang/String;)V", "initialed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getInitialed", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "systemTree", "", "", "getSystemTree$timonbase_release", "()Ljava/util/Map;", "systemsWithName", "addSystem", "", "system", "parent", "reverse", "", "condition", "Lkotlin/Function0;", "systems", "", "buildSystemGraph", "Lcom/bytedance/timonbase/pipeline/TimonPipeline$GraphNode;", "isInitialed", "markInitialed", "postInvoke", "entity", "Lcom/bytedance/timon/pipeline/TimonEntity;", "preInvoke", "replaceSystem", "traverseSystem", "block", "Lkotlin/Function1;", "validSystemAnnotation", "Companion", "GraphNode", "timonbase_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class TimonPipeline implements TimonSystem {
    public static final String KEY_POST_START_TIME = "pipeline_post_start_time";
    public static final String KEY_PRE_START_TIME = "pipeline_pre_start_time";
    public static final String KEY_SOURCE = "source";
    public static final String ROOT = "pipeline_root";
    public static final String TAG = "TimonPipeline";
    private final AtomicBoolean initialed;
    private final String name;
    private final Map<String, List<TimonSystem>> systemTree;
    private final Map<String, TimonSystem> systemsWithName;

    public TimonPipeline(String str) {
        Intrinsics.checkParameterIsNotNull(str, "name");
        this.name = str;
        this.systemsWithName = new LinkedHashMap();
        this.systemTree = new LinkedHashMap();
        this.initialed = new AtomicBoolean(false);
    }

    public final Map<String, List<TimonSystem>> getSystemTree$timonbase_release() {
        return this.systemTree;
    }

    protected final AtomicBoolean getInitialed() {
        return this.initialed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addSystem$default(TimonPipeline timonPipeline, TimonSystem timonSystem, String str, boolean z, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSystem");
        }
        if ((i & 2) != 0) {
            str = ROOT;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            function0 = null;
        }
        timonPipeline.addSystem(timonSystem, str, z, (Function0<Boolean>) function0);
    }

    public final void addSystem(TimonSystem system, String parent, boolean reverse, Function0<Boolean> condition) {
        Intrinsics.checkParameterIsNotNull(system, "system");
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        addSystem(CollectionsKt.listOf(system), parent, reverse, condition);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addSystem$default(TimonPipeline timonPipeline, List list, String str, boolean z, Function0 function0, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSystem");
        }
        if ((i & 2) != 0) {
            str = ROOT;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        if ((i & 8) != 0) {
            function0 = null;
        }
        timonPipeline.addSystem((List<? extends TimonSystem>) list, str, z, (Function0<Boolean>) function0);
    }

    public final void addSystem(List<? extends TimonSystem> systems, String parent, boolean reverse, Function0<Boolean> condition) {
        boolean z;
        Intrinsics.checkParameterIsNotNull(systems, "systems");
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        List<? extends TimonSystem> list = systems;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (this.systemsWithName.containsKey(((TimonSystem) it.next()).getName())) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            if (TMEnv.INSTANCE.getDEBUG()) {
                StringBuilder sb = new StringBuilder("duplicate system added, please check ");
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList.add(((TimonSystem) it2.next()).getName());
                }
                throw new IllegalArgumentException(sb.append(arrayList).toString());
            }
            return;
        }
        for (TimonSystem timonSystem : list) {
            this.systemsWithName.put(timonSystem.getName(), timonSystem);
        }
        if (condition != null) {
            String str = "condition_before_" + ((TimonSystem) CollectionsKt.first(systems)).getName();
            ConditionCheckerSystem conditionCheckerSystem = new ConditionCheckerSystem(str, condition, condition);
            this.systemsWithName.put(str, conditionCheckerSystem);
            this.systemTree.put(str, CollectionsKt.toMutableList(systems));
            systems = CollectionsKt.listOf(conditionCheckerSystem);
        }
        if ((Intrinsics.areEqual(parent, ROOT) ? this : (TimonSystem) this.systemsWithName.get(parent)) == null) {
            TimonFoundation.INSTANCE.getLogger().mo214e(TAG, "parent system(" + parent + ") not exist. please check.", null);
            return;
        }
        List<TimonSystem> list2 = this.systemTree.get(parent);
        if (list2 == null) {
            this.systemTree.put(parent, CollectionsKt.toMutableList(systems));
        } else if (reverse) {
            list2.addAll(0, systems);
        } else {
            list2.addAll(systems);
        }
    }

    public final boolean replaceSystem(TimonSystem system) {
        Intrinsics.checkParameterIsNotNull(system, "system");
        if (!this.systemsWithName.containsKey(system.getName())) {
            if (TMEnv.INSTANCE.getDEBUG()) {
                throw new IllegalArgumentException("replace system(" + system.getName() + ") failed, please check.");
            }
            return false;
        }
        this.systemsWithName.put(system.getName(), system);
        Iterator<Map.Entry<String, List<TimonSystem>>> it = this.systemTree.entrySet().iterator();
        while (it.hasNext()) {
            ListIterator<TimonSystem> listIterator = it.next().getValue().listIterator();
            while (listIterator.hasNext()) {
                if (Intrinsics.areEqual(listIterator.next().getName(), system.getName())) {
                    listIterator.set(system);
                }
            }
        }
        return true;
    }

    public final void markInitialed() {
        this.initialed.set(true);
    }

    public final boolean isInitialed() {
        return this.initialed.get();
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public boolean preInvoke(final TimonEntity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        if (!this.initialed.get()) {
            return false;
        }
        try {
            long nanoTime = System.nanoTime();
            final ApmParams obtainApmParams = ComponentPool.INSTANCE.obtainApmParams();
            entity.assignComponent(obtainApmParams);
            obtainApmParams.put(KEY_PRE_START_TIME, nanoTime);
            obtainApmParams.put(KEY_SOURCE, this.name);
            traverseSystem(ROOT, new Function1<TimonSystem, Boolean>() { // from class: com.bytedance.timonbase.pipeline.TimonPipeline$preInvoke$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Boolean.valueOf(invoke((TimonSystem) obj));
                }

                public final boolean invoke(TimonSystem timonSystem) {
                    Intrinsics.checkParameterIsNotNull(timonSystem, "system");
                    long nanoTime2 = System.nanoTime();
                    TimonPipeline.this.validSystemAnnotation(entity, timonSystem);
                    boolean preInvoke = timonSystem.preInvoke(entity);
                    obtainApmParams.put("system_pre_" + timonSystem.getName(), (System.nanoTime() - nanoTime2) / 1000);
                    return preInvoke;
                }
            });
        } catch (Exception e) {
            if (TMEnv.INSTANCE.getDEBUG()) {
                throw new Error(e);
            }
            TimonFoundation.INSTANCE.getExceptionMonitor().monitorThrowable(e, "TimonException-Pipeline", MapsKt.emptyMap());
        }
        return false;
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    public boolean postInvoke(final TimonEntity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        if (!this.initialed.get()) {
            return false;
        }
        try {
            long nanoTime = System.nanoTime();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ReentrantReadWriteLock.ReadLock readLock = entity.getLock().readLock();
            readLock.lock();
            try {
                TimonComponent timonComponent = entity.getComponents().get(Reflection.getOrCreateKotlinClass(ApmParams.class));
                if (!(timonComponent instanceof ApmParams)) {
                    timonComponent = null;
                }
                ApmParams apmParams = (ApmParams) timonComponent;
                readLock.unlock();
                objectRef.element = apmParams;
                if (((ApmParams) objectRef.element) == null) {
                    objectRef.element = ComponentPool.INSTANCE.obtainApmParams();
                    entity.assignComponent((ApmParams) objectRef.element);
                }
                ((ApmParams) objectRef.element).put(KEY_POST_START_TIME, nanoTime);
                ((ApmParams) objectRef.element).put(KEY_SOURCE, this.name);
                traverseSystem(ROOT, new Function1<TimonSystem, Boolean>() { // from class: com.bytedance.timonbase.pipeline.TimonPipeline$postInvoke$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return Boolean.valueOf(invoke((TimonSystem) obj));
                    }

                    public final boolean invoke(TimonSystem timonSystem) {
                        Intrinsics.checkParameterIsNotNull(timonSystem, "system");
                        long nanoTime2 = System.nanoTime();
                        TimonPipeline.this.validSystemAnnotation(entity, timonSystem);
                        boolean postInvoke = timonSystem.postInvoke(entity);
                        ((ApmParams) objectRef.element).put("system_post_" + timonSystem.getName(), (System.nanoTime() - nanoTime2) / 1000);
                        return postInvoke;
                    }
                });
            } catch (Throwable th) {
                readLock.unlock();
                throw th;
            }
        } catch (Exception e) {
            if (TMEnv.INSTANCE.getDEBUG()) {
                throw new Error(e);
            }
            TimonFoundation.INSTANCE.getExceptionMonitor().monitorThrowable(e, "TimonException-Pipeline", MapsKt.emptyMap());
        }
        return false;
    }

    protected final void traverseSystem(String parent, Function1<? super TimonSystem, Boolean> block) {
        List<TimonSystem> list;
        List asReversedMutable;
        List asReversedMutable2;
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Stack stack = new Stack();
        List<TimonSystem> list2 = this.systemTree.get(parent);
        if (list2 != null && (asReversedMutable2 = CollectionsKt.asReversedMutable(list2)) != null) {
            Iterator it = asReversedMutable2.iterator();
            while (it.hasNext()) {
                stack.push((TimonSystem) it.next());
            }
        }
        while (!stack.isEmpty()) {
            TimonSystem timonSystem = (TimonSystem) stack.pop();
            Intrinsics.checkExpressionValueIsNotNull(timonSystem, "system");
            if (((Boolean) block.invoke(timonSystem)).booleanValue() && (list = this.systemTree.get(timonSystem.getName())) != null && (asReversedMutable = CollectionsKt.asReversedMutable(list)) != null) {
                Iterator it2 = asReversedMutable.iterator();
                while (it2.hasNext()) {
                    stack.push((TimonSystem) it2.next());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validSystemAnnotation(TimonEntity entity, final TimonSystem system) throws TimonException {
        ComponentDeps componentDeps;
        KClass<? extends TimonComponent>[] orCreateKotlinClasses;
        if (!TMEnv.INSTANCE.getDEBUG() || (componentDeps = (ComponentDeps) ((Class) new PropertyReference0(system) { // from class: com.bytedance.timonbase.pipeline.TimonPipeline$validSystemAnnotation$componentDeps$1
            public String getName() {
                return "javaClass";
            }

            public KDeclarationContainer getOwner() {
                return Reflection.getOrCreateKotlinPackage(JvmClassMappingKt.class, "timonbase_release");
            }

            public String getSignature() {
                return "getJavaClass(Ljava/lang/Object;)Ljava/lang/Class;";
            }

            public Object get() {
                return JvmClassMappingKt.getJavaClass((TimonSystem) this.receiver);
            }
        }.get()).getAnnotation(ComponentDeps.class)) == null || (orCreateKotlinClasses = Reflection.getOrCreateKotlinClasses(componentDeps.required())) == null) {
            return;
        }
        for (KClass<? extends TimonComponent> kClass : orCreateKotlinClasses) {
            if (!entity.hasComponent(kClass)) {
                throw new TimonException("system " + system + " required " + kClass.getSimpleName() + ", but target component not found.");
            }
        }
    }

    public final GraphNode buildSystemGraph(String name) {
        List emptyList;
        Intrinsics.checkParameterIsNotNull(name, "name");
        TimonSystem timonSystem = this.systemsWithName.get(name);
        if (timonSystem instanceof TimonPipeline) {
            return GraphNode.copy$default(((TimonPipeline) timonSystem).buildSystemGraph(ROOT), name, false, false, null, 14, null);
        }
        boolean z = false;
        boolean z2 = false;
        List<TimonSystem> list = this.systemTree.get(name);
        if (list == null) {
            emptyList = CollectionsKt.emptyList();
        } else {
            List<TimonSystem> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(buildSystemGraph(((TimonSystem) it.next()).getName()));
            }
            emptyList = arrayList;
        }
        return new GraphNode(name, z, z2, emptyList, 6, null);
    }

    @Override // com.bytedance.timon.pipeline.TimonSystem
    /* renamed from: name, reason: from getter */
    public String getName() {
        return this.name;
    }

    /* compiled from: TimonPipeline.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00000\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00000\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/timonbase/pipeline/TimonPipeline$GraphNode;", "", "name", "", "preInvoke", "", "postInvoke", "children", "", "(Ljava/lang/String;ZZLjava/util/List;)V", "getChildren", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "getPostInvoke", "()Z", "getPreInvoke", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "timonbase_release"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static final /* data */ class GraphNode {

        @SerializedName("children")
        private final List<GraphNode> children;

        @SerializedName("name")
        private final String name;

        @SerializedName("postInvoke")
        private final boolean postInvoke;

        @SerializedName("preInvoke")
        private final boolean preInvoke;

        public GraphNode() {
            this(null, false, false, null, 15, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ GraphNode copy$default(GraphNode graphNode, String str, boolean z, boolean z2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = graphNode.name;
            }
            if ((i & 2) != 0) {
                z = graphNode.preInvoke;
            }
            if ((i & 4) != 0) {
                z2 = graphNode.postInvoke;
            }
            if ((i & 8) != 0) {
                list = graphNode.children;
            }
            return graphNode.copy(str, z, z2, list);
        }

        /* renamed from: component1, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getPreInvoke() {
            return this.preInvoke;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getPostInvoke() {
            return this.postInvoke;
        }

        public final List<GraphNode> component4() {
            return this.children;
        }

        public final GraphNode copy(String name, boolean preInvoke, boolean postInvoke, List<GraphNode> children) {
            Intrinsics.checkParameterIsNotNull(name, "name");
            Intrinsics.checkParameterIsNotNull(children, "children");
            return new GraphNode(name, preInvoke, postInvoke, children);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GraphNode)) {
                return false;
            }
            GraphNode graphNode = (GraphNode) other;
            return Intrinsics.areEqual(this.name, graphNode.name) && this.preInvoke == graphNode.preInvoke && this.postInvoke == graphNode.postInvoke && Intrinsics.areEqual(this.children, graphNode.children);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            String str = this.name;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.preInvoke;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode + i) * 31;
            boolean z2 = this.postInvoke;
            int i3 = (i2 + (z2 ? 1 : z2 ? 1 : 0)) * 31;
            List<GraphNode> list = this.children;
            return i3 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            return "GraphNode(name=" + this.name + ", preInvoke=" + this.preInvoke + ", postInvoke=" + this.postInvoke + ", children=" + this.children + ")";
        }

        public GraphNode(String str, boolean z, boolean z2, List<GraphNode> list) {
            Intrinsics.checkParameterIsNotNull(str, "name");
            Intrinsics.checkParameterIsNotNull(list, "children");
            this.name = str;
            this.preInvoke = z;
            this.postInvoke = z2;
            this.children = list;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean getPreInvoke() {
            return this.preInvoke;
        }

        public final boolean getPostInvoke() {
            return this.postInvoke;
        }

        public /* synthetic */ GraphNode(String str, boolean z, boolean z2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? CollectionsKt.emptyList() : list);
        }

        public final List<GraphNode> getChildren() {
            return this.children;
        }
    }
}
