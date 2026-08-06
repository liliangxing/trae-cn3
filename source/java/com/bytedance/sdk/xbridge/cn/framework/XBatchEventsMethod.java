package com.bytedance.sdk.xbridge.cn.framework;

import com.bytedance.ies.bullet.core.container.IBulletContainer;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.framework.AbsXBatchEventsMethodIDL;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* compiled from: XBatchEventsMethod.kt */
@XBridgeMethod(name = "x.batchEvents")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/framework/XBatchEventsMethod;", "Lcom/bytedance/sdk/xbridge/cn/framework/AbsXBatchEventsMethodIDL;", "()V", "ERROR_MESSAGE", "", "checkActionType", "", ReportConstant.COMMON_ACTION_TYPE, "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/sdk/xbridge/cn/framework/AbsXBatchEventsMethodIDL$XBatchEventsParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/sdk/xbridge/cn/framework/AbsXBatchEventsMethodIDL$XBatchEventsResultModel;", "LegalAction", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class XBatchEventsMethod extends AbsXBatchEventsMethodIDL {
    private final String ERROR_MESSAGE = "invalid Parameter";

    /* compiled from: XBatchEventsMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/framework/XBatchEventsMethod$LegalAction;", "", ReportConstant.COMMON_ACTION_TYPE, "", "(Ljava/lang/String;ILjava/lang/String;)V", "getActionType", "()Ljava/lang/String;", "closed", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public enum LegalAction {
        closed("closed");

        private final String actionType;

        LegalAction(String str) {
            this.actionType = str;
        }

        public final String getActionType() {
            return this.actionType;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsXBatchEventsMethodIDL.XBatchEventsParamModel params, CompletionBlock<AbsXBatchEventsMethodIDL.XBatchEventsResultModel> callback) {
        IBulletContainer iBulletContainer;
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        try {
            if (params.getActionList().isEmpty()) {
                CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
                return;
            }
            String actionType = params.getActionType();
            List<AbsXBatchEventsMethodIDL.XBridgeBeanXBatchEventsActionList> actionList = params.getActionList();
            List<AbsXBatchEventsMethodIDL.XBridgeBeanXBatchEventsActionList> list = actionList;
            if (!(list == null || list.isEmpty())) {
                List<AbsXBatchEventsMethodIDL.XBridgeBeanXBatchEventsActionList> list2 = actionList;
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (((AbsXBatchEventsMethodIDL.XBridgeBeanXBatchEventsActionList) it.next()).getMethodName().length() == 0) {
                        CompletionBlock.DefaultImpls.onFailure$default(callback, -3, this.ERROR_MESSAGE, null, 4, null);
                        return;
                    }
                }
                ContextProviderFactory contextProviderFactory = (ContextProviderFactory) bridgeContext.getService(ContextProviderFactory.class);
                if (contextProviderFactory != null && (iBulletContainer = (IBulletContainer) contextProviderFactory.provideInstance(IBulletContainer.class)) != null) {
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it2 = list2.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(((AbsXBatchEventsMethodIDL.XBridgeBeanXBatchEventsActionList) it2.next()).getMethodName());
                    }
                    ArrayList arrayList2 = arrayList;
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                    Iterator<T> it3 = list2.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(new JSONObject(((AbsXBatchEventsMethodIDL.XBridgeBeanXBatchEventsActionList) it3.next()).getParams()));
                    }
                    iBulletContainer.addEventObserver(actionType, arrayList2, arrayList3);
                }
                CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) XBridgeKTXKt.createXModel(Reflection.getOrCreateKotlinClass(AbsXBatchEventsMethodIDL.XBatchEventsResultModel.class)), null, 2, null);
                return;
            }
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, this.ERROR_MESSAGE, null, 4, null);
        } catch (Exception unused) {
            CompletionBlock.DefaultImpls.onFailure$default(callback, -3, null, null, 6, null);
        }
    }

    private final boolean checkActionType(String actionType) {
        for (LegalAction legalAction : LegalAction.values()) {
            if (Intrinsics.areEqual(legalAction.getActionType(), actionType)) {
                return true;
            }
        }
        return false;
    }
}
