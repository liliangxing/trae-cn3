package com.larus.business.markdown.impl.markwon.phone;

import com.larus.business.markdown.api.model.PhoneNumberConfig;
import com.larus.business.markdown.impl.markwon.phone.PhoneNumberLinkPlugin;
import com.larus.business.markdown.impl.markwon.phone.PhoneRegexPatternUtils;
import io.noties.markwon.AbstractMarkwonPlugin;
import io.noties.markwon.MarkwonPlugin;
import io.noties.markwon.MarkwonVisitor;
import io.noties.markwon.SpanFactory;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.core.CorePlugin;
import io.noties.markwon.core.CorePlugin2;
import io.noties.markwon.core.CoreProps;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.node.Text;

/* compiled from: PhoneNumberLinkPlugin.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001b\u0010\b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/phone/PhoneNumberLinkPlugin;", "Lio/noties/markwon/AbstractMarkwonPlugin;", "phoneNumberConfig", "Lcom/larus/business/markdown/api/model/PhoneNumberConfig;", "isLoading", "Lkotlin/Function0;", "", "(Lcom/larus/business/markdown/api/model/PhoneNumberConfig;Lkotlin/jvm/functions/Function0;)V", "isHighlightEnabled", "()Z", "isHighlightEnabled$delegate", "Lkotlin/Lazy;", "configure", "", "registry", "Lio/noties/markwon/MarkwonPlugin$Registry;", "PhoneNumberMarker", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class PhoneNumberLinkPlugin extends AbstractMarkwonPlugin {

    /* renamed from: isHighlightEnabled$delegate, reason: from kotlin metadata */
    private final Lazy isHighlightEnabled;
    private final Function0<Boolean> isLoading;
    private final PhoneNumberConfig phoneNumberConfig;

    public PhoneNumberLinkPlugin(PhoneNumberConfig phoneNumberConfig, Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "isLoading");
        this.phoneNumberConfig = phoneNumberConfig;
        this.isLoading = function0;
        this.isHighlightEnabled = LazyKt.lazy(new Function0<Boolean>() { // from class: com.larus.business.markdown.impl.markwon.phone.PhoneNumberLinkPlugin$isHighlightEnabled$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x001f, code lost:
            
                if (r0.getLinkGenerator() != null) goto L13;
             */
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Boolean m2898invoke() {
                PhoneNumberConfig phoneNumberConfig2;
                PhoneNumberConfig phoneNumberConfig3;
                phoneNumberConfig2 = PhoneNumberLinkPlugin.this.phoneNumberConfig;
                boolean z = true;
                if (phoneNumberConfig2 != null && phoneNumberConfig2.getEnableHighlight()) {
                    phoneNumberConfig3 = PhoneNumberLinkPlugin.this.phoneNumberConfig;
                }
                z = false;
                return Boolean.valueOf(z);
            }
        });
    }

    private final boolean isHighlightEnabled() {
        return ((Boolean) this.isHighlightEnabled.getValue()).booleanValue();
    }

    @Override // io.noties.markwon.AbstractMarkwonPlugin, io.noties.markwon.MarkwonPlugin
    public void configure(MarkwonPlugin.Registry registry) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        if (isHighlightEnabled()) {
            registry.require(CorePlugin.class, new MarkwonPlugin.Action() { // from class: com.larus.business.markdown.impl.markwon.phone.PhoneNumberLinkPlugin$configure$1
                @Override // io.noties.markwon.MarkwonPlugin.Action
                public final void apply(CorePlugin corePlugin) {
                    PhoneNumberConfig phoneNumberConfig;
                    Function0 function0;
                    Intrinsics.checkNotNullParameter(corePlugin, "corePlugin");
                    phoneNumberConfig = PhoneNumberLinkPlugin.this.phoneNumberConfig;
                    function0 = PhoneNumberLinkPlugin.this.isLoading;
                    corePlugin.addAdvancedOnTextAddedListener(new PhoneNumberLinkPlugin.PhoneNumberMarker(phoneNumberConfig, function0));
                }
            });
        }
    }

    /* compiled from: PhoneNumberLinkPlugin.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0016\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010²\u0006\f\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u008a\u0084\u0002"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/phone/PhoneNumberLinkPlugin$PhoneNumberMarker;", "Lio/noties/markwon/core/CorePlugin$AdvancedOnTextAddedListener;", "phoneNumberConfig", "Lcom/larus/business/markdown/api/model/PhoneNumberConfig;", "isLoading", "Lkotlin/Function0;", "", "(Lcom/larus/business/markdown/api/model/PhoneNumberConfig;Lkotlin/jvm/functions/Function0;)V", "onTextAdded", "", "visitor", "Lio/noties/markwon/MarkwonVisitor;", "node", "Lorg/commonmark/node/Text;", "start", "", "markdown-impl_release", "factory", "Lio/noties/markwon/SpanFactory;"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    public static class PhoneNumberMarker implements CorePlugin.AdvancedOnTextAddedListener {
        private final Function0<Boolean> isLoading;
        private final PhoneNumberConfig phoneNumberConfig;

        public PhoneNumberMarker(PhoneNumberConfig phoneNumberConfig, Function0<Boolean> function0) {
            Intrinsics.checkNotNullParameter(function0, "isLoading");
            this.phoneNumberConfig = phoneNumberConfig;
            this.isLoading = function0;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.noties.markwon.core.CorePlugin.AdvancedOnTextAddedListener
        public void onTextAdded(final MarkwonVisitor visitor, Text node, int start) {
            PhoneNumberConfig phoneNumberConfig;
            Function1<String, String> linkGenerator;
            Object spans;
            Intrinsics.checkNotNullParameter(visitor, "visitor");
            Intrinsics.checkNotNullParameter(node, "node");
            if (((Boolean) this.isLoading.invoke()).booleanValue() || (phoneNumberConfig = this.phoneNumberConfig) == null || (linkGenerator = phoneNumberConfig.getLinkGenerator()) == null) {
                return;
            }
            for (Node node2 = node.parent; node2 != null; node2 = node2.parent) {
                if (node2 instanceof Link) {
                    return;
                }
            }
            Lazy lazy = LazyKt.lazy(new Function0<SpanFactory>() { // from class: com.larus.business.markdown.impl.markwon.phone.PhoneNumberLinkPlugin$PhoneNumberMarker$onTextAdded$factory$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final SpanFactory m2897invoke() {
                    return MarkwonVisitor.this.configuration().spansFactory().get(Link.class);
                }
            });
            PhoneRegexPatternUtils phoneRegexPatternUtils = PhoneRegexPatternUtils.INSTANCE;
            String literal = node.getLiteral();
            Intrinsics.checkNotNullExpressionValue(literal, "node.literal");
            for (PhoneRegexPatternUtils.PhoneInfo phoneInfo : phoneRegexPatternUtils.getAllPhoneInfo(literal, this.phoneNumberConfig.getPhoneRegex())) {
                int start2 = phoneInfo.getStart() + start;
                int end = phoneInfo.getEnd() + start;
                String phoneNumber = phoneInfo.getPhoneNumber();
                CoreProps.LINK_DESTINATION.set(visitor.renderProps(), linkGenerator.invoke(phoneNumber));
                CorePlugin2.INSTANCE.getLINK_TITLE().set(visitor.renderProps(), phoneNumber);
                SpanFactory onTextAdded$lambda$0 = onTextAdded$lambda$0(lazy);
                if (onTextAdded$lambda$0 != null && (spans = onTextAdded$lambda$0.getSpans(visitor.configuration(), visitor.renderProps())) != null) {
                    SpannableBuilder.setSpans(visitor.builder(), spans, start2, end);
                }
            }
        }

        private static final SpanFactory onTextAdded$lambda$0(Lazy<? extends SpanFactory> lazy) {
            return (SpanFactory) lazy.getValue();
        }
    }
}
