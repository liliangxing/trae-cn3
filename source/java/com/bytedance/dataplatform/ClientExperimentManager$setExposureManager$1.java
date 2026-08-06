package com.bytedance.dataplatform;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: ClientExperimentManager.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final /* synthetic */ class ClientExperimentManager$setExposureManager$1 extends MutablePropertyReference0 {
    ClientExperimentManager$setExposureManager$1(ClientExperimentManager clientExperimentManager) {
        super(clientExperimentManager);
    }

    public String getName() {
        return "exposureManager";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ClientExperimentManager.class);
    }

    public String getSignature() {
        return "getExposureManager()Lcom/bytedance/dataplatform/ExposureManager;";
    }

    public Object get() {
        return ClientExperimentManager.access$getExposureManager$p((ClientExperimentManager) this.receiver);
    }

    public void set(Object obj) {
        ClientExperimentManager.exposureManager = (ExposureManager) obj;
    }
}
