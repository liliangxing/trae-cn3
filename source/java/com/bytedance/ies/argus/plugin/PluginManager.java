package com.bytedance.ies.argus.plugin;

import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import com.bytedance.ies.argus.repository.ContainerConfigItem;
import com.bytedance.ies.argus.repository.ContainerConfigModel;
import com.bytedance.ies.argus.repository.RecoveryConfigModel;
import com.bytedance.ies.argus.util.ArgusGsonUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.json.JSONObject;

/* compiled from: PluginManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005J3\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\b\b\u0000\u0010\u0011*\u00020\f2\u000e\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00110\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u0015H\u0002J#\u0010\u0016\u001a\u00020\u0017\"\f\b\u0000\u0010\u0011*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0018\u001a\u0002H\u0011H\u0002¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0017J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0006\u0010\u001e\u001a\u00020\u0017J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\t\u001a\u001a\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/ies/argus/plugin/PluginManager;", "", "()V", "containerConfigStorage", "", "", "Lcom/bytedance/ies/argus/plugin/ContainerPluginConf;", "globalRecoveryConf", "Lcom/bytedance/ies/argus/plugin/PluginRecoveryConf;", "mPluginMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/Class;", "Lcom/bytedance/ies/argus/plugin/ISecurePluginHandler;", "Lcom/bytedance/ies/argus/plugin/ISecurePlugin;", "getContainerConfig", "cId", "getPlugin", "T", "clazz", "(Ljava/lang/Class;Ljava/lang/String;)Lcom/bytedance/ies/argus/plugin/ISecurePluginHandler;", "getSetupPluginList", "", "registerPlugin", "", "obj", "(Lcom/bytedance/ies/argus/plugin/ISecurePlugin;)V", "setup", "setupContainerPluginConfig", "config", "Lcom/bytedance/ies/argus/repository/ContainerConfigModel;", "setupPlugin", "setupRecoveryConfig", "Lcom/bytedance/ies/argus/repository/RecoveryConfigModel;", "shouldForbiddenPlugin", "", "name", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class PluginManager {
    public static final String TAG = "PluginManager";
    private PluginRecoveryConf globalRecoveryConf;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<PluginManager> instance$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<PluginManager>() { // from class: com.bytedance.ies.argus.plugin.PluginManager$Companion$instance$2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final PluginManager m613invoke() {
            return new PluginManager();
        }
    });
    private Map<String, ContainerPluginConf> containerConfigStorage = MapsKt.emptyMap();
    private final ConcurrentHashMap<Class<? extends ISecurePluginHandler>, ISecurePlugin<?>> mPluginMap = new ConcurrentHashMap<>();

    /* compiled from: PluginManager.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/argus/plugin/PluginManager$Companion;", "", "()V", "TAG", "", "instance", "Lcom/bytedance/ies/argus/plugin/PluginManager;", "getInstance", "()Lcom/bytedance/ies/argus/plugin/PluginManager;", "instance$delegate", "Lkotlin/Lazy;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PluginManager getInstance() {
            return (PluginManager) PluginManager.instance$delegate.getValue();
        }
    }

    public final void setup() {
        ArgusConfigManager.INSTANCE.getInstance().registerRecoverConfigCollector(new Function1<RecoveryConfigModel, Unit>() { // from class: com.bytedance.ies.argus.plugin.PluginManager$setup$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((RecoveryConfigModel) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(RecoveryConfigModel recoveryConfigModel) {
                Intrinsics.checkNotNullParameter(recoveryConfigModel, "it");
                PluginManager.this.setupRecoveryConfig(recoveryConfigModel);
            }
        });
        ArgusConfigManager.INSTANCE.getInstance().registerContainerConfigCollector(new Function1<ContainerConfigModel, Unit>() { // from class: com.bytedance.ies.argus.plugin.PluginManager$setup$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContainerConfigModel) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ContainerConfigModel containerConfigModel) {
                Intrinsics.checkNotNullParameter(containerConfigModel, "it");
                PluginManager.this.setupContainerPluginConfig(containerConfigModel);
            }
        });
    }

    public final void setupPlugin() {
        List<ISecurePlugin<?>> setupPluginList = getSetupPluginList();
        CoroutineScope sharedScope = ArgusEnv.INSTANCE.getInstance().getSharedScope();
        for (ISecurePlugin<?> iSecurePlugin : setupPluginList) {
            if (!shouldForbiddenPlugin(iSecurePlugin.getPluginName())) {
                BuildersKt.launch$default(sharedScope, (CoroutineContext) null, (CoroutineStart) null, new PluginManager$setupPlugin$1(iSecurePlugin, this, null), 3, (Object) null);
            }
        }
    }

    private final List<ISecurePlugin<?>> getSetupPluginList() {
        return CollectionsKt.listOf(new SecLinkPlugin());
    }

    public static /* synthetic */ ISecurePluginHandler getPlugin$default(PluginManager pluginManager, Class cls, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        return pluginManager.getPlugin(cls, str);
    }

    public final <T extends ISecurePluginHandler> T getPlugin(Class<? extends T> clazz, String cId) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ISecurePlugin<?> iSecurePlugin = this.mPluginMap.get(clazz);
        if (iSecurePlugin == null || shouldForbiddenPlugin(iSecurePlugin.getPluginName())) {
            return null;
        }
        T t = (T) iSecurePlugin.initInstance(cId);
        if (t instanceof ISecurePluginHandler) {
            return t;
        }
        return null;
    }

    public final ContainerPluginConf getContainerConfig(String cId) {
        if (cId == null) {
            return this.containerConfigStorage.get("host");
        }
        ContainerPluginConf containerPluginConf = this.containerConfigStorage.get(cId);
        return containerPluginConf == null ? this.containerConfigStorage.get("host") : containerPluginConf;
    }

    private final boolean shouldForbiddenPlugin(String name) {
        List<String> closeKey;
        PluginRecoveryConf pluginRecoveryConf = this.globalRecoveryConf;
        return (pluginRecoveryConf == null || (closeKey = pluginRecoveryConf.getCloseKey()) == null || !closeKey.contains(name)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupRecoveryConfig(RecoveryConfigModel config) {
        JSONObject plugin = config.getPlugin();
        if (plugin != null) {
            PluginRecoveryConf pluginRecoveryConf = (PluginRecoveryConf) ArgusGsonUtils.INSTANCE.safelyFromJSONObjectToClass(plugin, PluginRecoveryConf.class);
            if (pluginRecoveryConf != null) {
                this.globalRecoveryConf = pluginRecoveryConf;
            }
            ArgusLog.i$default(ArgusLog.INSTANCE, TAG, "finish update plugin recovery config", null, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T extends ISecurePlugin<?>> void registerPlugin(T obj) {
        this.mPluginMap.put(obj.instanceClazz(), obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setupContainerPluginConfig(ContainerConfigModel config) {
        ContainerPluginConf containerPluginConf;
        long currentTimeMillis = System.currentTimeMillis();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ContainerConfigItem> entry : config.getConf().entrySet()) {
            String key = entry.getKey();
            JSONObject conf = entry.getValue().getPlugin().getConf();
            if (conf != null && (containerPluginConf = (ContainerPluginConf) ArgusGsonUtils.INSTANCE.safelyFromJSONObjectToClass(conf, ContainerPluginConf.class)) != null) {
                linkedHashMap.put(key, containerPluginConf);
            }
        }
        this.containerConfigStorage = MapsKt.toMap(linkedHashMap);
        ArgusLog.i$default(ArgusLog.INSTANCE, TAG, "finish update plugin container config， cost: " + (System.currentTimeMillis() - currentTimeMillis), null, 4, null);
    }
}
