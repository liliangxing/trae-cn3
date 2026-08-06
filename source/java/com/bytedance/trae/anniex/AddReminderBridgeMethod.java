package com.bytedance.trae.anniex;

import android.app.Activity;
import android.content.Intent;
import android.provider.CalendarContract;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.registry.core.utils.XBridgeKTXKt;
import com.bytedance.trae.anniex.AbsAddReminderMethodIDL;
import com.bytedance.trae.utils.TrustedDomainUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AddReminderBridgeMethod.kt */
@XBridgeMethod(name = "addReminder")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/anniex/AddReminderBridgeMethod;", "Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL;", "<init>", "()V", "canRunInBackground", "", "handle", "", "bridgeContext", "Lcom/bytedance/sdk/xbridge/cn/registry/core/IBDXBridgeContext;", "params", "Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderParamModel;", "callback", "Lcom/bytedance/sdk/xbridge/cn/registry/core/model/idl/CompletionBlock;", "Lcom/bytedance/trae/anniex/AbsAddReminderMethodIDL$AddReminderResultModel;", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AddReminderBridgeMethod extends AbsAddReminderMethodIDL {
    public static final int $stable = 0;
    private static final int CODE_FAILED = 0;
    private static final int CODE_SUCCESS = 1;

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod, com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod
    public boolean canRunInBackground() {
        return false;
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public void handle(IBDXBridgeContext bridgeContext, AbsAddReminderMethodIDL.AddReminderParamModel params, CompletionBlock<AbsAddReminderMethodIDL.AddReminderResultModel> callback) {
        Intrinsics.checkNotNullParameter(bridgeContext, "bridgeContext");
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!TrustedDomainUtils.INSTANCE.isTrustedUrl(bridgeContext.getBridgeCall().getUrl())) {
            XBaseModel createXModel = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsAddReminderMethodIDL.AddReminderResultModel.class);
            AbsAddReminderMethodIDL.AddReminderResultModel addReminderResultModel = (AbsAddReminderMethodIDL.AddReminderResultModel) createXModel;
            addReminderResultModel.setCode((Number) 0);
            addReminderResultModel.setMsg("untrusted domain");
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel, null, 2, null);
            return;
        }
        Activity ownerActivity = bridgeContext.getOwnerActivity();
        if (ownerActivity == null) {
            XBaseModel createXModel2 = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsAddReminderMethodIDL.AddReminderResultModel.class);
            AbsAddReminderMethodIDL.AddReminderResultModel addReminderResultModel2 = (AbsAddReminderMethodIDL.AddReminderResultModel) createXModel2;
            addReminderResultModel2.setCode((Number) 0);
            addReminderResultModel2.setMsg("Failed");
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel2, null, 2, null);
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.INSERT");
            intent.setData(CalendarContract.Events.CONTENT_URI);
            String topic = params.getTopic();
            String str = "";
            if (topic == null) {
                topic = "";
            }
            intent.putExtra("title", topic);
            String description = params.getDescription();
            if (description != null) {
                str = description;
            }
            intent.putExtra("description", str);
            Number startTime = params.getStartTime();
            intent.putExtra("beginTime", startTime != null ? startTime.longValue() : 0L);
            Number endTime = params.getEndTime();
            intent.putExtra("endTime", endTime != null ? endTime.longValue() : 0L);
            ownerActivity.startActivity(intent);
            XBaseModel createXModel3 = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsAddReminderMethodIDL.AddReminderResultModel.class);
            AbsAddReminderMethodIDL.AddReminderResultModel addReminderResultModel3 = (AbsAddReminderMethodIDL.AddReminderResultModel) createXModel3;
            addReminderResultModel3.setCode((Number) 1);
            addReminderResultModel3.setMsg("Success");
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel3, null, 2, null);
        } catch (Exception e) {
            XBaseModel createXModel4 = XBridgeKTXKt.createXModel((Class<XBaseModel>) AbsAddReminderMethodIDL.AddReminderResultModel.class);
            AbsAddReminderMethodIDL.AddReminderResultModel addReminderResultModel4 = (AbsAddReminderMethodIDL.AddReminderResultModel) createXModel4;
            addReminderResultModel4.setCode((Number) 0);
            String message = e.getMessage();
            addReminderResultModel4.setMsg(message != null ? message : "Failed");
            CompletionBlock.DefaultImpls.onSuccess$default(callback, (XBaseResultModel) createXModel4, null, 2, null);
        }
    }
}
