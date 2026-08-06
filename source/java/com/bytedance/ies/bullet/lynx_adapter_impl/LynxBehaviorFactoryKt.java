package com.bytedance.ies.bullet.lynx_adapter_impl;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.lynx.lynx_adapter.inter.LynxUISetterProxy;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.BaseLynxUIWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.BehaviorClassWarmerWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.CustomEventWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.DetailEventWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.EventEmitterWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxCallbackWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxFlattenUIWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxInitDataWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxShadowNodeWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxTextShadowNodeWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxTextUpdateBundleProxy;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxUIWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper;
import com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableTypeWrapper;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.Dynamic;
import com.lynx.react.bridge.DynamicFromArray;
import com.lynx.react.bridge.DynamicFromMap;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.BehaviorClassWarmer;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.TemplateData;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.PaintingContext;
import com.lynx.tasm.behavior.StylesDiffMap;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextShadowNode;
import com.lynx.tasm.behavior.shadow.text.TextUpdateBundle;
import com.lynx.tasm.behavior.ui.LynxFlattenUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.event.LynxCustomEvent;
import com.lynx.tasm.event.LynxDetailEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LynxBehaviorFactory.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0006\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u0004\u0018\u00010\t\u001a\u000e\u0010\n\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\f\u001a\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0004\u0018\u00010\u0006H\u0007\u001a\u0016\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0010*\u00020\u0011\u001a\u000e\u0010\u0012\u001a\u0004\u0018\u00010\u0013*\u0004\u0018\u00010\u0014\u001a\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0017\u001a\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u0004\u0018\u00010\u001a\u001a\u000e\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u0004\u0018\u00010\u0006\u001a\u000e\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u0004\u0018\u00010\u001f\u001a\u000e\u0010\u001d\u001a\u0004\u0018\u00010 *\u0004\u0018\u00010!\u001a\u000e\u0010\u001d\u001a\u0004\u0018\u00010\"*\u0004\u0018\u00010#\u001a,\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H%0$\"\b\b\u0000\u0010%*\u00020&*\n\u0012\u0004\u0012\u0002H%\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)\u001a\n\u0010\u001d\u001a\u00020**\u00020+¨\u0006,"}, d2 = {PrefetchRequestConfig.METHOD_GET, "", "Lcom/lynx/tasm/behavior/StylesDiffMap;", "key", "", "getMapFromBundle", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxInitDataWrapper;", "toDynamicWrapper", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/DynamicWrapper;", "Lcom/lynx/react/bridge/Dynamic;", "toLynxCallbackWrapper", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxCallbackWrapper;", "Lcom/lynx/react/bridge/Callback;", "toLynxInitData", "Lcom/bytedance/ies/bullet/lynx_adapter_impl/LynxInitData;", "toMap", "", "Landroid/os/Bundle;", "toReadableArrayWrapper", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/ReadableArrayWrapper;", "Lcom/lynx/react/bridge/ReadableArray;", "toReadableMapWrapper", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/ReadableMapWrapper;", "Lcom/lynx/react/bridge/ReadableMap;", "toReadableTypeWrapper", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/ReadableTypeWrapper;", "Lcom/lynx/react/bridge/ReadableType;", "toTemplateData", "Lcom/lynx/tasm/TemplateData;", "transform", "Lcom/lynx/tasm/BehaviorClassWarmer;", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/BehaviorClassWarmerWrapper;", "Lcom/lynx/tasm/behavior/ui/LynxFlattenUI;", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxFlattenUIWrapper;", "Lcom/lynx/tasm/behavior/shadow/ShadowNode;", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxShadowNodeWrapper;", "Lcom/lynx/tasm/behavior/ui/LynxUI;", "T", "Landroid/view/View;", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxUIWrapper;", "context", "Lcom/lynx/tasm/behavior/LynxContext;", "Lcom/bytedance/ies/lynx/lynx_adapter/wrapper/LynxTextUpdateBundleProxy;", "Lcom/lynx/tasm/behavior/shadow/text/TextUpdateBundle;", "lynx-adapter-impl_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class LynxBehaviorFactoryKt {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReadableType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ReadableType.Boolean.ordinal()] = 1;
            iArr[ReadableType.Int.ordinal()] = 2;
            iArr[ReadableType.Number.ordinal()] = 3;
            iArr[ReadableType.String.ordinal()] = 4;
            iArr[ReadableType.Map.ordinal()] = 5;
            iArr[ReadableType.Array.ordinal()] = 6;
            iArr[ReadableType.Long.ordinal()] = 7;
            iArr[ReadableType.ByteArray.ordinal()] = 8;
        }
    }

    public static final ShadowNode transform(final LynxShadowNodeWrapper lynxShadowNodeWrapper) {
        Log.d("bullet", "creating node for " + lynxShadowNodeWrapper);
        return lynxShadowNodeWrapper instanceof LynxTextShadowNodeWrapper ? new TextShadowNode() { // from class: com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactoryKt$transform$1
            public void onCollectExtraUpdates(PaintingContext paintingContext) {
                super.onCollectExtraUpdates(paintingContext);
                Object createNewUpdateBundle = LynxShadowNodeWrapper.this.createNewUpdateBundle();
                if (createNewUpdateBundle == null || paintingContext == null) {
                    return;
                }
                paintingContext.updateExtraData(getSignature(), createNewUpdateBundle);
            }
        } : new ShadowNode() { // from class: com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactoryKt$transform$2
            public void onCollectExtraUpdates(PaintingContext paintingContext) {
                Object createNewUpdateBundle;
                Intrinsics.checkParameterIsNotNull(paintingContext, "paintingContext");
                super.onCollectExtraUpdates(paintingContext);
                LynxShadowNodeWrapper lynxShadowNodeWrapper2 = LynxShadowNodeWrapper.this;
                if (lynxShadowNodeWrapper2 == null || (createNewUpdateBundle = lynxShadowNodeWrapper2.createNewUpdateBundle()) == null) {
                    return;
                }
                paintingContext.updateExtraData(getSignature(), createNewUpdateBundle);
            }
        };
    }

    public static final LynxTextUpdateBundleProxy transform(TextUpdateBundle textUpdateBundle) {
        Intrinsics.checkParameterIsNotNull(textUpdateBundle, "$this$transform");
        return new LynxTextUpdateBundleProxy(textUpdateBundle.hasImages(), textUpdateBundle.getTextLayout());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T extends View> LynxUI<T> transform(final LynxUIWrapper<T> lynxUIWrapper, final LynxContext lynxContext) {
        Log.d("bullet", "creating lynx ui");
        return new LynxUI<T>(lynxUIWrapper, lynxContext, lynxContext) { // from class: com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactoryKt$transform$3
            final /* synthetic */ LynxContext $context;
            final /* synthetic */ LynxUIWrapper $this_transform;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(lynxContext);
                this.$this_transform = lynxUIWrapper;
                this.$context = lynxContext;
                if (lynxUIWrapper == null) {
                    throw new TypeCastException("null cannot be cast to non-null type com.bytedance.ies.lynx.lynx_adapter.wrapper.BaseLynxUIWrapper<T>");
                }
                ((BaseLynxUIWrapper) lynxUIWrapper).getContext().setEventEmitterWrapper(new EventEmitterWrapper() { // from class: com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactoryKt$transform$3.1
                    private final EventEmitter localEventEmitter;

                    {
                        LynxContext lynxContext2 = LynxBehaviorFactoryKt$transform$3.this.$context;
                        if (lynxContext2 == null) {
                            Intrinsics.throwNpe();
                        }
                        this.localEventEmitter = lynxContext2.getEventEmitter();
                    }

                    public final EventEmitter getLocalEventEmitter() {
                        return this.localEventEmitter;
                    }

                    @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.EventEmitterWrapper
                    public void sendCustomEvent(CustomEventWrapper eventWrapper) {
                        LynxCustomEvent lynxCustomEvent;
                        Intrinsics.checkParameterIsNotNull(eventWrapper, "eventWrapper");
                        if (eventWrapper instanceof DetailEventWrapper) {
                            int sign = getSign();
                            String type = eventWrapper.getType();
                            LinkedHashMap params = eventWrapper.getParams();
                            if (params == null) {
                                params = new LinkedHashMap();
                            }
                            LynxDetailEvent lynxDetailEvent = new LynxDetailEvent(sign, type, params);
                            lynxDetailEvent.eventParams().putAll(((DetailEventWrapper) eventWrapper).eventParams());
                            lynxCustomEvent = (LynxCustomEvent) lynxDetailEvent;
                        } else {
                            int sign2 = getSign();
                            String type2 = eventWrapper.getType();
                            LinkedHashMap params2 = eventWrapper.getParams();
                            if (params2 == null) {
                                params2 = new LinkedHashMap();
                            }
                            lynxCustomEvent = new LynxCustomEvent(sign2, type2, params2);
                        }
                        this.localEventEmitter.sendCustomEvent(lynxCustomEvent);
                    }
                });
            }

            public void initialize() {
                super.initialize();
                LynxUIWrapper lynxUIWrapper2 = this.$this_transform;
                if (lynxUIWrapper2 != null) {
                    lynxUIWrapper2.initialize();
                }
                LynxUIWrapper lynxUIWrapper3 = this.$this_transform;
                if (lynxUIWrapper3 != null) {
                    View view = this.mView;
                    Intrinsics.checkExpressionValueIsNotNull(view, "mView");
                    lynxUIWrapper3.setMInnerView(view);
                }
                LynxUIWrapper lynxUIWrapper4 = this.$this_transform;
                if (lynxUIWrapper4 != null) {
                    lynxUIWrapper4.setSign(getSign());
                }
            }

            public void updateExtraData(Object extraData) {
                super.updateExtraData(extraData);
                if (extraData instanceof TextUpdateBundle) {
                    LynxUIWrapper lynxUIWrapper2 = this.$this_transform;
                    if (lynxUIWrapper2 != null) {
                        lynxUIWrapper2.updateExtraData(LynxBehaviorFactoryKt.transform((TextUpdateBundle) extraData));
                        return;
                    }
                    return;
                }
                LynxUIWrapper lynxUIWrapper3 = this.$this_transform;
                if (lynxUIWrapper3 != null) {
                    lynxUIWrapper3.updateExtraData(extraData);
                }
            }

            /* JADX WARN: Incorrect return type in method signature: (Landroid/content/Context;)TT; */
            protected View createView(Context context) {
                Intrinsics.checkParameterIsNotNull(context, "context");
                LynxUIWrapper lynxUIWrapper2 = this.$this_transform;
                if (lynxUIWrapper2 != null) {
                    return lynxUIWrapper2.createView(context);
                }
                return null;
            }

            /* JADX WARN: Incorrect return type in method signature: (Landroid/content/Context;Ljava/lang/Object;)TT; */
            protected View createView(Context context, Object param) {
                Intrinsics.checkParameterIsNotNull(context, "context");
                LynxUIWrapper lynxUIWrapper2 = this.$this_transform;
                if (lynxUIWrapper2 != null) {
                    return lynxUIWrapper2.createView(context, param);
                }
                return null;
            }

            public void onLayoutUpdated() {
                super.onLayoutUpdated();
                LynxUIWrapper lynxUIWrapper2 = this.$this_transform;
                if (lynxUIWrapper2 != null) {
                    lynxUIWrapper2.onLayoutUpdated();
                }
            }

            public void updateLayout(int left, int top, int width, int height, int paddingLeft, int paddingTop, int paddingRight, int paddingBottom, int marginLeft, int marginTop, int marginRight, int marginBottom, int borderLeftWidth, int borderTopWidth, int borderRightWidth, int borderBottomWidth, Rect bound) {
                super.updateLayout(left, top, width, height, paddingLeft, paddingTop, paddingRight, paddingBottom, marginLeft, marginTop, marginRight, marginBottom, borderLeftWidth, borderTopWidth, borderRightWidth, borderBottomWidth, bound);
                LynxUIWrapper lynxUIWrapper2 = this.$this_transform;
                if (lynxUIWrapper2 != null) {
                    lynxUIWrapper2.updateLayout(left, top, width, height, paddingLeft, paddingTop, paddingRight, paddingBottom, marginLeft, marginTop, marginRight, marginBottom, borderLeftWidth, borderTopWidth, borderRightWidth, borderBottomWidth, bound);
                }
            }

            protected void updateLayoutInfo(int left, int top, int width, int height, int paddingLeft, int paddingTop, int paddingRight, int paddingBottom, int marginLeft, int marginTop, int marginRight, int marginBottom, int borderLeftWidth, int borderTopWidth, int borderRightWidth, int borderBottomWidth, Rect bound) {
                super.updateLayoutInfo(left, top, width, height, paddingLeft, paddingTop, paddingRight, paddingBottom, marginLeft, marginTop, marginRight, marginBottom, borderLeftWidth, borderTopWidth, borderRightWidth, borderBottomWidth, bound);
                LynxUIWrapper lynxUIWrapper2 = this.$this_transform;
                if (lynxUIWrapper2 != null) {
                    lynxUIWrapper2.updateLayoutInfo(left, top, width, height, paddingLeft, paddingTop, paddingRight, paddingBottom, marginLeft, marginTop, marginRight, marginBottom, borderLeftWidth, borderTopWidth, borderRightWidth, borderBottomWidth, bound);
                }
            }

            public void afterPropsUpdated(StylesDiffMap props) {
                LynxUISetterProxy mPropSetter;
                super.afterPropsUpdated(props);
                LynxUIWrapper lynxUIWrapper2 = this.$this_transform;
                if (lynxUIWrapper2 == null || (mPropSetter = lynxUIWrapper2.getMPropSetter()) == null) {
                    return;
                }
                if (props == null) {
                    Intrinsics.throwNpe();
                }
                ReadableMapKeySetIterator keySetIterator = props.mBackingMap.keySetIterator();
                while (keySetIterator.hasNextKey()) {
                    String nextKey = keySetIterator.nextKey();
                    Intrinsics.checkExpressionValueIsNotNull(nextKey, "key");
                    mPropSetter.setProperty(nextKey, LynxBehaviorFactoryKt.get(props, nextKey));
                }
            }
        };
    }

    public static final Object get(StylesDiffMap stylesDiffMap, String str) {
        Intrinsics.checkParameterIsNotNull(stylesDiffMap, "$this$get");
        Intrinsics.checkParameterIsNotNull(str, "key");
        if (stylesDiffMap.hasKey(str)) {
            ReadableMap readableMap = stylesDiffMap.mBackingMap;
            if (!(readableMap instanceof JavaOnlyMap)) {
                readableMap = null;
            }
            JavaOnlyMap javaOnlyMap = (JavaOnlyMap) readableMap;
            r1 = javaOnlyMap != null ? javaOnlyMap.get(str) : null;
            Log.d("bullet", "StylesDiffMap.get() called with: key = [" + str + "], value=[" + r1 + ']');
        }
        return r1;
    }

    public static final LynxFlattenUI transform(LynxFlattenUIWrapper lynxFlattenUIWrapper) {
        Log.d("bullet", "create flatten ui called");
        return null;
    }

    public static final BehaviorClassWarmer transform(BehaviorClassWarmerWrapper behaviorClassWarmerWrapper) {
        Log.d("bullet", "class warmer called");
        return null;
    }

    public static final ReadableMapWrapper toReadableMapWrapper(final ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        return new ReadableMapWrapper() { // from class: com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactoryKt$toReadableMapWrapper$1
            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public boolean hasKey(String name) {
                Intrinsics.checkParameterIsNotNull(name, "name");
                return readableMap.hasKey(name);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public boolean isNull(String name) {
                return readableMap.isNull(name);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public boolean getBoolean(String name) {
                return readableMap.getBoolean(name);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public boolean getBoolean(String name, boolean defaultValue) {
                return readableMap.getBoolean(name, defaultValue);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public double getDouble(String name) {
                return readableMap.getDouble(name);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public double getDouble(String name, double defaultValue) {
                return readableMap.getDouble(name, defaultValue);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public int getInt(String name) {
                return readableMap.getInt(name);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public int getInt(String name, int defaultValue) {
                return readableMap.getInt(name, defaultValue);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public String getString(String name) {
                return readableMap.getString(name);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public String getString(String name, String defaultValue) {
                return readableMap.getString(name, defaultValue);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public ReadableArrayWrapper getArray(String name) {
                return LynxBehaviorFactoryKt.toReadableArrayWrapper(readableMap.getArray(name));
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public ReadableArrayWrapper getArray(String name, ReadableArrayWrapper defaultValue) {
                Intrinsics.checkParameterIsNotNull(name, "name");
                ReadableArrayWrapper readableArrayWrapper = LynxBehaviorFactoryKt.toReadableArrayWrapper(readableMap.getArray(name));
                return readableArrayWrapper != null ? readableArrayWrapper : defaultValue;
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public ReadableMapWrapper getMap(String name) {
                return LynxBehaviorFactoryKt.toReadableMapWrapper(readableMap.getMap(name));
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public ReadableMapWrapper getMap(String name, ReadableMapWrapper defaultValue) {
                Intrinsics.checkParameterIsNotNull(name, "name");
                ReadableMapWrapper readableMapWrapper = LynxBehaviorFactoryKt.toReadableMapWrapper(readableMap.getMap(name));
                return readableMapWrapper != null ? readableMapWrapper : defaultValue;
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public Long getLong(String name) {
                return Long.valueOf(readableMap.getLong(name));
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public Long getLong(String name, long defaultValue) {
                return Long.valueOf(readableMap.getLong(name, defaultValue));
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public byte[] getByteArray(String name) {
                return readableMap.getByteArray(name);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public byte[] getByteArray(String name, byte[] defaultValue) {
                Intrinsics.checkParameterIsNotNull(defaultValue, "defaultValue");
                return readableMap.getByteArray(name, defaultValue);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public DynamicWrapper getDynamic(String name) {
                Dynamic create = DynamicFromMap.create(readableMap, name);
                if (create != null) {
                    return LynxBehaviorFactoryKt.toDynamicWrapper(create);
                }
                return null;
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public ReadableTypeWrapper getType(String name) {
                return LynxBehaviorFactoryKt.toReadableTypeWrapper(readableMap.getType(name));
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public HashMap<String, Object> toHashMap() {
                return readableMap.toHashMap();
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableMapWrapper
            public int size() {
                return readableMap.size();
            }
        };
    }

    public static final ReadableArrayWrapper toReadableArrayWrapper(final ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        return new ReadableArrayWrapper() { // from class: com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactoryKt$toReadableArrayWrapper$1
            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public int size() {
                return readableArray.size();
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public boolean isNull(int index) {
                return readableArray.isNull(index);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public boolean getBoolean(int index) {
                return readableArray.getBoolean(index);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public double getDouble(int index) {
                return readableArray.getDouble(index);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public byte getByte(int index) {
                return readableArray.getByte(index);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public short getShort(int index) {
                return readableArray.getShort(index);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public long getLong(int index) {
                return readableArray.getLong(index);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public char getChar(int index) {
                return readableArray.getChar(index);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public int getInt(int index) {
                return readableArray.getInt(index);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public String getString(int index) {
                return readableArray.getString(index);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public byte[] getByteArray(int index) {
                return readableArray.getByteArray(index);
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public ReadableArrayWrapper getArray(int index) {
                return LynxBehaviorFactoryKt.toReadableArrayWrapper(readableArray.getArray(index));
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public ReadableMapWrapper getMap(int index) {
                return LynxBehaviorFactoryKt.toReadableMapWrapper(readableArray.getMap(index));
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public DynamicWrapper getDynamic(int index) {
                Dynamic create = DynamicFromArray.create(readableArray, index);
                if (create != null) {
                    return LynxBehaviorFactoryKt.toDynamicWrapper(create);
                }
                return null;
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public ReadableTypeWrapper getType(int index) {
                return LynxBehaviorFactoryKt.toReadableTypeWrapper(readableArray.getType(index));
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.ReadableArrayWrapper
            public ArrayList<Object> toArrayList() {
                return readableArray.toArrayList();
            }
        };
    }

    public static final ReadableTypeWrapper toReadableTypeWrapper(ReadableType readableType) {
        if (readableType == null) {
            return null;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[readableType.ordinal()]) {
            case 1:
                return ReadableTypeWrapper.Boolean;
            case 2:
                return ReadableTypeWrapper.Int;
            case 3:
                return ReadableTypeWrapper.Number;
            case 4:
                return ReadableTypeWrapper.String;
            case 5:
                return ReadableTypeWrapper.Map;
            case 6:
                return ReadableTypeWrapper.Array;
            case 7:
                return ReadableTypeWrapper.Long;
            case 8:
                return ReadableTypeWrapper.ByteArray;
            default:
                return ReadableTypeWrapper.Null;
        }
    }

    public static final LynxCallbackWrapper toLynxCallbackWrapper(final Callback callback) {
        if (callback == null) {
            return null;
        }
        return new LynxCallbackWrapper() { // from class: com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactoryKt$toLynxCallbackWrapper$1
            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.LynxCallbackWrapper
            public void invoke(Object... param) {
                Intrinsics.checkParameterIsNotNull(param, "param");
                callback.invoke(new Object[]{param});
            }
        };
    }

    @Deprecated(message = "")
    public static final LynxInitData toLynxInitData(LynxInitDataWrapper lynxInitDataWrapper) {
        if (lynxInitDataWrapper == null) {
            return null;
        }
        Log.d("bullet", "wrapper to LynxInitData: [" + lynxInitDataWrapper.getInitData() + ']');
        if (lynxInitDataWrapper.getInitData() != null) {
            LynxInitData fromString = LynxInitData.INSTANCE.fromString(lynxInitDataWrapper.getInitData());
            for (Map.Entry<String, Object> entry : lynxInitDataWrapper.getDataProxy().entrySet()) {
                fromString.put(entry.getKey(), entry.getValue());
            }
            return fromString;
        }
        return LynxInitData.INSTANCE.fromMap(lynxInitDataWrapper.getDataProxy());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final LynxInitDataWrapper getMapFromBundle(LynxInitDataWrapper lynxInitDataWrapper) {
        Intrinsics.checkParameterIsNotNull(lynxInitDataWrapper, "$this$getMapFromBundle");
        Map<String, Object> dataProxy = lynxInitDataWrapper.getDataProxy();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : dataProxy.entrySet()) {
            if (entry.getValue() instanceof Bundle) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            Map<String, Object> dataProxy2 = lynxInitDataWrapper.getDataProxy();
            Object key = entry2.getKey();
            Object value = entry2.getValue();
            if (value == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.os.Bundle");
            }
            dataProxy2.put(key, toMap((Bundle) value));
        }
        return lynxInitDataWrapper;
    }

    public static final Map<String, Object> toMap(Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(bundle, "$this$toMap");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set<String> keySet = bundle.keySet();
        Intrinsics.checkExpressionValueIsNotNull(keySet, "this.keySet()");
        for (String str : keySet) {
            Intrinsics.checkExpressionValueIsNotNull(str, "it");
            Object obj = bundle.get(str);
            if (obj == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(obj, "get(it)!!");
            linkedHashMap.put(str, obj);
        }
        return linkedHashMap;
    }

    public static final TemplateData toTemplateData(LynxInitDataWrapper lynxInitDataWrapper) {
        TemplateData empty;
        if (lynxInitDataWrapper == null) {
            return null;
        }
        if (lynxInitDataWrapper.getInitData() != null) {
            empty = TemplateData.fromString(lynxInitDataWrapper.getInitData());
        } else {
            empty = TemplateData.empty();
        }
        Intrinsics.checkExpressionValueIsNotNull(empty, "if (initData != null) {\n…emplateData.empty()\n    }");
        getMapFromBundle(lynxInitDataWrapper);
        empty.updateData(lynxInitDataWrapper.getDataProxy());
        if (lynxInitDataWrapper.getReadOnly()) {
            empty.markReadOnly();
        }
        return empty;
    }

    public static final DynamicWrapper toDynamicWrapper(final Dynamic dynamic) {
        if (dynamic == null) {
            return null;
        }
        return new DynamicWrapper() { // from class: com.bytedance.ies.bullet.lynx_adapter_impl.LynxBehaviorFactoryKt$toDynamicWrapper$1
            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
            public boolean isNull() {
                return dynamic.isNull();
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
            public boolean asBoolean() {
                return dynamic.asBoolean();
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
            public double asDouble() {
                return dynamic.asDouble();
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
            public int asInt() {
                return dynamic.asInt();
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
            public String asString() {
                return dynamic.asString();
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
            public ReadableArrayWrapper asArray() {
                return LynxBehaviorFactoryKt.toReadableArrayWrapper(dynamic.asArray());
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
            public ReadableMapWrapper asMap() {
                return LynxBehaviorFactoryKt.toReadableMapWrapper(dynamic.asMap());
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
            public ReadableTypeWrapper getType() {
                return LynxBehaviorFactoryKt.toReadableTypeWrapper(dynamic.getType());
            }

            @Override // com.bytedance.ies.lynx.lynx_adapter.wrapper.DynamicWrapper
            public void recycle() {
                dynamic.recycle();
            }
        };
    }
}
