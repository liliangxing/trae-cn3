package com.bytedance.android.anniex.base.container;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.anniex.base.container.IContainer;
import com.bytedance.android.anniex.base.lifecycle.AbsAnnieXLifecycle;
import com.bytedance.android.anniex.pitaya.StrategyConstants;
import com.bytedance.framwork.core.sdklib.apm6.Constants;
import com.bytedance.ies.bullet.core.kit.bridge.IEvent;
import com.bytedance.ies.bullet.core.model.context.ContextProviderFactory;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.bytedance.ies.bullet.service.schema.ISchemaData;
import com.bytedance.ies.bullet.service.sdk.SchemaService;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IContainer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0014\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\n\u0010\u001f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\u0010\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\"H\u0016J\b\u0010$\u001a\u00020\u0004H\u0016J\b\u0010%\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\bH\u0016J\b\u0010)\u001a\u00020\bH\u0016J&\u0010*\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00062\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,\u0018\u00010\u001dH\u0016J\b\u0010-\u001a\u00020\u0004H\u0016J\u0012\u0010.\u001a\u00020\u00042\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u001f\u00101\u001a\u00020\u00042\u0006\u00102\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0002\u00104J\u0010\u00105\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J)\u00106\u001a\u00020\u0004\"\u0004\b\u0000\u001072\f\u00108\u001a\b\u0012\u0004\u0012\u0002H7092\u0006\u0010:\u001a\u0002H7H\u0016¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020\u0004H\u0016J\u001e\u0010=\u001a\u00020\u00042\u0014\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,\u0018\u00010\u001dH\u0016J \u0010>\u001a\u00020\u00042\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010,\u0018\u00010\u001dH\u0016J\u0010\u0010@\u001a\u00020\u00042\u0006\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020\u0004H\u0016J\b\u0010D\u001a\u00020\u0004H\u0016J\u0010\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u0006H\u0016J\u001c\u0010E\u001a\u00020\u00042\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,0\u001dH\u0016J\u001c\u0010G\u001a\u00020\u00042\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020,0\u001dH\u0016J\u0018\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020KH\u0016¨\u0006M"}, d2 = {"Lcom/bytedance/android/anniex/base/container/BaseContainer;", "Lcom/bytedance/android/anniex/base/container/IContainer;", "()V", "bindContainerId", "", "containerId", "", "canBackPress", "", "canGoBack", "close", "enterBackground", "enterForeground", "generateSchemaData", "Lcom/bytedance/ies/bullet/service/schema/ISchemaData;", StrategyConstants.SCHEMA, "getBDXLaunchMode", "Lcom/bytedance/ies/bullet/service/sdk/param/LaunchMode;", "getBDXTag", "getBid", "getContainerId", "getContextProviderFactory", "Lcom/bytedance/ies/bullet/core/model/context/ContextProviderFactory;", "getCurrentUrl", "getKitType", "Lcom/bytedance/ies/bullet/service/base/utils/KitType;", "getKitView", "Landroid/view/View;", "getPerfMap", "", "", "getSchemaData", "getViewType", "getWeakContext", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "goBack", "hideError", "hideLoading", "interceptBackPress", StrategyConstants.ENABLE, "isVisibility", "loadSchema", "renderData", "", "observerKeyboardStatusChange", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onVisibleChange", "visible", "hasReadySendVisibleEvent", "(ZLjava/lang/Boolean;)V", "preloadSchema", "registerWeakHolder", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "item", "(Ljava/lang/Class;Ljava/lang/Object;)V", "release", "reload", "reloadTemplate", "templateData", "sendEvent", NotificationCompat.CATEGORY_EVENT, "Lcom/bytedance/ies/bullet/core/kit/bridge/IEvent;", "showError", "showLoading", "updateData", Constants.KEY_DATA, "updateGlobalProps", "globalProps", "updateScreenMetrics", "width", "", "height", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class BaseContainer implements IContainer {
    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void bindContainerId(String containerId) {
        Intrinsics.checkNotNullParameter(containerId, "containerId");
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public boolean canBackPress() {
        return false;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public boolean canGoBack() {
        return false;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void close() {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void enterBackground() {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void enterForeground() {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public String getBDXTag() {
        return "";
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public String getBid() {
        return "";
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public String getContainerId() {
        return "";
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public ContextProviderFactory getContextProviderFactory() {
        return null;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public String getCurrentUrl() {
        return "";
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public View getKitView() {
        return null;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public ISchemaData getSchemaData() {
        return null;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public String getViewType() {
        return "";
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void goBack() {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void hideError() {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void hideLoading() {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void interceptBackPress(boolean enable) {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public boolean isVisibility() {
        return false;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void loadSchema(String schema, Map<String, ? extends Object> renderData) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void observerKeyboardStatusChange() {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void onCreate(Bundle savedInstanceState) {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void onVisibleChange(boolean visible, Boolean hasReadySendVisibleEvent) {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void preloadSchema(String schema) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public <T> void registerWeakHolder(Class<T> clazz, T item) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void release() {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void reload(Map<String, ? extends Object> renderData) {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void reloadTemplate(Map<String, ? extends Object> templateData) {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void sendEvent(IEvent event) {
        Intrinsics.checkNotNullParameter(event, NotificationCompat.CATEGORY_EVENT);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void showError() {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void showLoading() {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void updateData(String data) {
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void updateData(Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(data, Constants.KEY_DATA);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void updateGlobalProps(Map<String, ? extends Object> globalProps) {
        Intrinsics.checkNotNullParameter(globalProps, "globalProps");
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void updateScreenMetrics(int width, int height) {
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void finish() {
        IContainer.DefaultImpls.finish(this);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public ISchemaData getCurrentSchema() {
        return IContainer.DefaultImpls.getCurrentSchema(this);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public Context getSystemContext() {
        return IContainer.DefaultImpls.getSystemContext(this);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void loadSchema(String str, Map<String, ? extends Object> map, ContextProviderFactory contextProviderFactory, AbsAnnieXLifecycle absAnnieXLifecycle) {
        IContainer.DefaultImpls.loadSchema(this, str, map, contextProviderFactory, absAnnieXLifecycle);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void onAttachToWindow() {
        IContainer.DefaultImpls.onAttachToWindow(this);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public void onEngineReady(ContextProviderFactory contextProviderFactory) {
        IContainer.DefaultImpls.onEngineReady(this, contextProviderFactory);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public KitType getKitType() {
        return KitType.UNKNOWN;
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public ISchemaData generateSchemaData(String schema) {
        Intrinsics.checkNotNullParameter(schema, StrategyConstants.SCHEMA);
        SchemaService companion = SchemaService.Companion.getInstance();
        Uri uri = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri, "EMPTY");
        return companion.generateSchemaData("default_bid", uri);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public Map<String, Long> getPerfMap() {
        return new LinkedHashMap();
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public WeakReference<Context> getWeakContext() {
        return new WeakReference<>(null);
    }

    @Override // com.bytedance.android.anniex.base.container.IContainer
    public LaunchMode getBDXLaunchMode() {
        return LaunchMode.MODE_UNSPECIFIED;
    }
}
