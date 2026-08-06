package com.bytedance.ies.argus.aspect.eventCenter;

import android.net.Uri;
import android.os.Bundle;
import com.bytedance.applog.server.Api;
import com.bytedance.ies.argus.api.params.IFePageInfo;
import com.bytedance.ies.argus.base.ArgusLog;
import com.bytedance.ies.argus.bean.ArgusConstants;
import com.bytedance.ies.argus.bean.ArgusSwitch;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.strategy.BaseStrategyParams;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: ContainerContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0014J$\u00109\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040*\u0018\u00010\u000b2\b\u0010:\u001a\u0004\u0018\u00010$J\b\u0010;\u001a\u00020\u0007H\u0002J$\u0010<\u001a\u00020=2\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040?2\u0006\u00108\u001a\u00020\u0014H\u0002J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0016J\u0012\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\u0004H\u0016J\u0018\u0010G\u001a\u00020H2\u0006\u0010F\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020EH\u0016J\b\u0010I\u001a\u00020\u0004H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001b\"\u0004\b!\u0010\u001dR\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040*\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010+\u001a\u0004\u0018\u00010\u00048BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R(\u00103\u001a\u0004\u0018\u00010\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u0010\u001d¨\u0006J"}, d2 = {"Lcom/bytedance/ies/argus/aspect/eventCenter/ContainerContext;", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseRuntimeContext;", "()V", "bizSceneTag", "", "containerClass", "eventCenter", "Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter;", "getEventCenter", "()Lcom/bytedance/ies/argus/aspect/eventCenter/BaseEventCenter;", "intentExtra", "", "lastOpenFePge", "Lcom/bytedance/ies/argus/api/params/IFePageInfo;", "getLastOpenFePge", "()Lcom/bytedance/ies/argus/api/params/IFePageInfo;", "setLastOpenFePge", "(Lcom/bytedance/ies/argus/api/params/IFePageInfo;)V", "lastUIPage", "openContainerBundle", "Landroid/os/Bundle;", "getOpenContainerBundle", "()Landroid/os/Bundle;", "setOpenContainerBundle", "(Landroid/os/Bundle;)V", "openContainerClass", "getOpenContainerClass", "()Ljava/lang/String;", "setOpenContainerClass", "(Ljava/lang/String;)V", "value", "originSecLinkScene", "getOriginSecLinkScene", "setOriginSecLinkScene", "routerSource", "schema", "Landroid/net/Uri;", "getSchema", "()Landroid/net/Uri;", "setSchema", "(Landroid/net/Uri;)V", "schemaQueryMap", "", "schemaString", "getSchemaString", "secLinkCheckMode", "Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "getSecLinkCheckMode", "()Lcom/bytedance/ies/argus/bean/ArgusSwitch;", "setSecLinkCheckMode", "(Lcom/bytedance/ies/argus/bean/ArgusSwitch;)V", "secLinkScene", "getSecLinkScene", "setSecLinkScene", "getOrRecordActivity", "clzName", "extras", "getOrRecordSchemaMap", "newSchema", "initEventCenter", "parseExtra", "", "bundleMap", "", "toMonitorObject", "Lorg/json/JSONObject;", "action", "Lcom/bytedance/ies/argus/bean/ArgusVerifyAction;", "ttmGetValue", "", Api.KEY_ENCRYPT_RESP_KEY, "ttmSetValue", "", "updateContextLogTag", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class ContainerContext extends BaseRuntimeContext {
    private String bizSceneTag;
    private String containerClass;
    private final BaseEventCenter eventCenter = initEventCenter();
    private Map<String, String> intentExtra;
    private IFePageInfo lastOpenFePge;
    private String lastUIPage;
    private Bundle openContainerBundle;
    private String openContainerClass;
    private String originSecLinkScene;
    private String routerSource;
    private Uri schema;
    private Map<String, ? extends List<String>> schemaQueryMap;
    private String schemaString;
    private ArgusSwitch secLinkCheckMode;
    private String secLinkScene;

    @Override // com.bytedance.ies.argus.aspect.eventCenter.BaseRuntimeContext
    public String updateContextLogTag() {
        return "container";
    }

    public final BaseEventCenter getEventCenter() {
        return this.eventCenter;
    }

    public final String getOpenContainerClass() {
        return this.openContainerClass;
    }

    public final void setOpenContainerClass(String str) {
        this.openContainerClass = str;
    }

    public final Bundle getOpenContainerBundle() {
        return this.openContainerBundle;
    }

    public final void setOpenContainerBundle(Bundle bundle) {
        this.openContainerBundle = bundle;
    }

    public final Uri getSchema() {
        return this.schema;
    }

    public final void setSchema(Uri uri) {
        this.schema = uri;
    }

    private final String getSchemaString() {
        Uri uri = this.schema;
        if (uri != null) {
            this.schemaString = String.valueOf(uri);
        }
        return this.schemaString;
    }

    public final IFePageInfo getLastOpenFePge() {
        return this.lastOpenFePge;
    }

    public final void setLastOpenFePge(IFePageInfo iFePageInfo) {
        this.lastOpenFePge = iFePageInfo;
    }

    public final String getOriginSecLinkScene() {
        return this.originSecLinkScene;
    }

    public final void setOriginSecLinkScene(String str) {
        this.originSecLinkScene = str;
        if (this.secLinkScene == null) {
            setSecLinkScene(str);
        }
    }

    public final String getSecLinkScene() {
        return this.secLinkScene;
    }

    public final void setSecLinkScene(String str) {
        this.secLinkScene = str;
        if (str == null || getArgusSceneTag() != null) {
            return;
        }
        updateArgusSceneTag(str, "container sec_link_scene");
    }

    public final ArgusSwitch getSecLinkCheckMode() {
        return this.secLinkCheckMode;
    }

    public final void setSecLinkCheckMode(ArgusSwitch argusSwitch) {
        this.secLinkCheckMode = argusSwitch;
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public JSONObject toMonitorObject(ArgusVerifyAction action) {
        Intrinsics.checkNotNullParameter(action, "action");
        JSONObject jSONObject = new JSONObject();
        JSONUtilsKt.safelyPutWithDefault(jSONObject, ArgusConstants.ARGUS_CID_KEY_NAME, getArgusBizId());
        JSONUtilsKt.safelyPutWithDefault(jSONObject, ArgusConstants.ARGUS_SCENE_TAG_KEY_NAME, getArgusSceneTag());
        JSONUtilsKt.safelyPutWithDefault(jSONObject, "seclink_scene", this.secLinkScene);
        JSONUtilsKt.safelyPutWithDefault(jSONObject, "origin_sec_link_scene", this.originSecLinkScene);
        JSONUtilsKt.safelyPut(jSONObject, "open_container_class", this.openContainerClass);
        JSONUtilsKt.safelyPut(jSONObject, "container_class", this.containerClass);
        JSONUtilsKt.safelyPut(jSONObject, "router_source", this.routerSource);
        JSONUtilsKt.safelyPut(jSONObject, "last_ui_page", this.lastUIPage);
        JSONUtilsKt.safelyPut(jSONObject, "intent_extra", String.valueOf(this.intentExtra));
        JSONUtilsKt.safelyPut(jSONObject, "biz_scene_tag", this.bizSceneTag);
        return jSONObject;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public Object ttmGetValue(String key) {
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        switch (key.hashCode()) {
            case -2122195899:
                if (key.equals("open_container_class")) {
                    return this.openContainerClass;
                }
                return null;
            case -2030165645:
                if (key.equals(ArgusConstants.ARGUS_CID_KEY_NAME)) {
                    return getArgusBizId();
                }
                return null;
            case -1788819283:
                if (key.equals("intent_extra")) {
                    return this.intentExtra;
                }
                return null;
            case -907987551:
                if (key.equals("schema")) {
                    return getSchemaString();
                }
                return null;
            case -586505145:
                if (key.equals("schema_query_map")) {
                    return this.schemaQueryMap;
                }
                return null;
            case 134106289:
                if (key.equals("last_ui_page")) {
                    return this.lastUIPage;
                }
                return null;
            case 216360540:
                if (key.equals(ArgusConstants.ARGUS_SCENE_TAG_KEY_NAME)) {
                    return getArgusSceneTag();
                }
                return null;
            case 294466741:
                if (key.equals("sec_link_scene")) {
                    return this.secLinkScene;
                }
                return null;
            case 740176954:
                if (key.equals("container_class")) {
                    return this.containerClass;
                }
                return null;
            case 2004007377:
                if (key.equals("router_source")) {
                    return this.routerSource;
                }
                return null;
            default:
                return null;
        }
    }

    @Override // com.bytedance.ies.argus.strategy.BaseStrategyParams
    public boolean ttmSetValue(String key, Object value) {
        String str;
        Intrinsics.checkNotNullParameter(key, Api.KEY_ENCRYPT_RESP_KEY);
        Intrinsics.checkNotNullParameter(value, "value");
        int hashCode = key.hashCode();
        if (hashCode == -2030165645) {
            if (!key.equals(ArgusConstants.ARGUS_CID_KEY_NAME)) {
                return true;
            }
            str = value instanceof String ? (String) value : null;
            if (str == null) {
                return true;
            }
            updateArgusBizId(str, "ttm set");
            return true;
        }
        if (hashCode == 216360540) {
            if (!key.equals(ArgusConstants.ARGUS_SCENE_TAG_KEY_NAME)) {
                return true;
            }
            str = value instanceof String ? (String) value : null;
            if (str == null) {
                return true;
            }
            updateArgusSceneTag(str, "ttm set");
            return true;
        }
        if (hashCode != 294466741 || !key.equals("sec_link_scene")) {
            return true;
        }
        str = value instanceof String ? (String) value : null;
        if (str == null) {
            return true;
        }
        setSecLinkScene(str);
        return true;
    }

    public static /* synthetic */ Map getOrRecordActivity$default(ContainerContext containerContext, String str, Bundle bundle, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            bundle = null;
        }
        return containerContext.getOrRecordActivity(str, bundle);
    }

    public final Map<String, String> getOrRecordActivity(String clzName, Bundle extras) {
        Map<String, String> map = this.intentExtra;
        if (map != null) {
            return map;
        }
        if (clzName != null) {
            this.containerClass = clzName;
        }
        HashMap hashMap = new HashMap();
        if (extras != null) {
            parseExtra(hashMap, extras);
        }
        Bundle bundle = this.openContainerBundle;
        if (bundle != null) {
            parseExtra(hashMap, bundle);
        }
        Map<String, String> map2 = MapsKt.toMap(hashMap);
        this.intentExtra = map2;
        return map2;
    }

    private final void parseExtra(Map<String, String> bundleMap, Bundle extras) {
        String valueOf;
        Locale locale;
        for (String str : extras.keySet()) {
            try {
                valueOf = String.valueOf(extras.get(str));
                Intrinsics.checkNotNullExpressionValue(str, Api.KEY_ENCRYPT_RESP_KEY);
                locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            } catch (Exception e) {
                ArgusLog.e$default(ArgusLog.INSTANCE, BaseStrategyParams.TAG, "parseExtra key=" + str + " got error: " + e, null, null, 12, null);
            }
            if (valueOf == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                break;
            }
            String lowerCase = valueOf.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            bundleMap.put(str, lowerCase);
            if (this.routerSource == null && (Intrinsics.areEqual(str, "key_calling_context") || Intrinsics.areEqual(str, "key_d_calling_context"))) {
                this.routerSource = valueOf;
            } else if (this.lastUIPage == null && Intrinsics.areEqual(str, "ui_action_last_page_name_source")) {
                this.lastUIPage = valueOf;
            } else if (Intrinsics.areEqual(str, ArgusConstants.ARGUS_CID_KEY_NAME)) {
                updateArgusBizId(valueOf, "parse extra get argus_cid");
            } else if (Intrinsics.areEqual(str, ArgusConstants.ARGUS_SCENE_TAG_KEY_NAME)) {
                this.bizSceneTag = valueOf;
            }
        }
    }

    public final Map<String, List<String>> getOrRecordSchemaMap(Uri newSchema) {
        List<String> split$default;
        if (newSchema == null) {
            return null;
        }
        if (this.schemaQueryMap != null && Intrinsics.areEqual(this.schema, newSchema)) {
            return this.schemaQueryMap;
        }
        this.schema = newSchema;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String query = newSchema.getQuery();
        if (query != null && (split$default = StringsKt.split$default(query, new String[]{"&"}, false, 0, 6, (Object) null)) != null) {
            ArrayList<Triple> arrayList = new ArrayList();
            for (String str : split$default) {
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = str.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                List split$default2 = StringsKt.split$default(lowerCase, new String[]{"="}, false, 0, 6, (Object) null);
                Triple triple = split$default2.size() >= 2 ? new Triple((String) split$default2.get(0), (String) split$default2.get(1), str) : null;
                if (triple != null) {
                    arrayList.add(triple);
                }
            }
            for (Triple triple2 : arrayList) {
                String str2 = (String) triple2.component1();
                String str3 = (String) triple2.component2();
                Object obj = linkedHashMap.get(str2);
                if (obj == null) {
                    obj = (List) new ArrayList();
                    linkedHashMap.put(str2, obj);
                }
                ((List) obj).add(str3);
            }
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            linkedHashMap2.put(entry.getKey(), CollectionsKt.toList((List) entry.getValue()));
        }
        this.schemaQueryMap = linkedHashMap2;
        return linkedHashMap2;
    }

    private final BaseEventCenter initEventCenter() {
        return new BaseEventCenter(new IEventCenterDepend() { // from class: com.bytedance.ies.argus.aspect.eventCenter.ContainerContext$initEventCenter$1
            @Override // com.bytedance.ies.argus.aspect.eventCenter.IEventCenterDepend
            /* renamed from: getContainerContext, reason: from getter */
            public ContainerContext getThis$0() {
                return ContainerContext.this;
            }
        });
    }
}
