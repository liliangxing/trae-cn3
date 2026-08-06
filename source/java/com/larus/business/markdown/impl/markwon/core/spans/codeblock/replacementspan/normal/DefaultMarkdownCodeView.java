package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.bytedance.webx.seclink.util.ReportUtil;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import com.larus.business.markdown.impl.databinding.MarkdownCodeViewLayoutBinding;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.p033ui.MarkdownCodeUtil;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.p033ui.MaxHeightLinearLayout;
import com.lynx.tasm.DefaultLogicExecutor;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.syntax.GrammarLocatorDef;
import io.noties.markwon.syntax.Prism4jSyntaxHighlight;
import io.noties.markwon.syntax.Prism4jThemeDefault;
import io.noties.prism4j.Prism4j;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: DefaultMarkdownCodeView.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\t\u0018\u0000 I2\u00020\u0001:\u0001IB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u00102\u001a\u00020*2\u0006\u00103\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!H\u0016J\b\u00105\u001a\u00020*H\u0002J\b\u00106\u001a\u00020!H\u0002J\u0006\u00107\u001a\u00020\u000eJ\u0006\u00108\u001a\u00020!J\u0006\u00109\u001a\u00020\u000eJ\b\u0010:\u001a\u000201H\u0002J\u009a\u0001\u0010;\u001a\u00020*2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2%\b\u0002\u0010+\u001a\u001f\u0012\u0013\u0012\u00110!¢\u0006\f\b<\u0012\b\b=\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020*\u0018\u00010,2\u0010\b\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0010\b\u0002\u0010.\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0010\b\u0002\u0010/\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010)2\u0006\u0010?\u001a\u00020\u000e2\b\b\u0002\u0010'\u001a\u00020\u00072\n\b\u0003\u0010@\u001a\u0004\u0018\u00010AH\u0007¢\u0006\u0002\u0010BJ\b\u0010C\u001a\u00020!H\u0002J\u0006\u0010D\u001a\u00020*J\b\u0010E\u001a\u00020*H\u0002J\b\u0010F\u001a\u00020*H\u0002J\b\u0010G\u001a\u00020*H\u0002J\b\u0010H\u001a\u00020*H\u0002R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u0012\u0010%\u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010+\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020*\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010-\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010.\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010/\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/larus/business/markdown/impl/markwon/core/spans/codeblock/replacementspan/normal/DefaultMarkdownCodeView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "DEFAULT_MAX_HEIGHT", "MAX_LINE", "binding", "Lcom/larus/business/markdown/impl/databinding/MarkdownCodeViewLayoutBinding;", "currentCode", "", "getCurrentCode", "()Ljava/lang/String;", "setCurrentCode", "(Ljava/lang/String;)V", "currentLanguage", "getCurrentLanguage", "setCurrentLanguage", "highlight", "Lio/noties/markwon/syntax/Prism4jSyntaxHighlight;", "getHighlight", "()Lio/noties/markwon/syntax/Prism4jSyntaxHighlight;", "highlight$delegate", "Lkotlin/Lazy;", "highlightDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "highlightScope", "Lkotlinx/coroutines/CoroutineScope;", "isFinish", "", "()Z", "setFinish", "(Z)V", "isFold", "Ljava/lang/Boolean;", "maxHeight", "onClickCopyListener", "Lkotlin/Function0;", "", "onClickFullScreenListener", "Lkotlin/Function1;", "onClickPreviewListener", "onLongClickListener", "supportsCodePreview", "textView", "Landroid/widget/TextView;", "bindData", "code", "language", "bindText", "enableAsync", "getCode", "getFinishState", "getLanguage", "getMarkdownTextView", ReportUtil.Event.EVENT_INIT, "Lkotlin/ParameterName;", DefaultLogicExecutor.GLOBAL_EVENT_NAME, "isClickButton", "foldText", "textSize", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;ILjava/lang/Float;)V", "isMarkdownTextViewClickable", "onRecycle", "performSingleClick", "updateGravity", "updateHafFoldStatus", "updatePreviewButton", "Companion", "markdown-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public final class DefaultMarkdownCodeView extends FrameLayout {
    public static final String MARKDOWN_CODE_STD_OUT = "STDOUT";
    public static final String TAG = "MarkdownCodeView";
    private final int DEFAULT_MAX_HEIGHT;
    private final int MAX_LINE;
    private MarkdownCodeViewLayoutBinding binding;
    private String currentCode;
    private String currentLanguage;

    /* renamed from: highlight$delegate, reason: from kotlin metadata */
    private final Lazy highlight;
    private final ExecutorCoroutineDispatcher highlightDispatcher;
    private final CoroutineScope highlightScope;
    private boolean isFinish;
    private Boolean isFold;
    private int maxHeight;
    private Function0<Unit> onClickCopyListener;
    private Function1<? super Boolean, Unit> onClickFullScreenListener;
    private Function0<Unit> onClickPreviewListener;
    private Function0<Unit> onLongClickListener;
    private Function0<Boolean> supportsCodePreview;
    private final TextView textView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultMarkdownCodeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DefaultMarkdownCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean enableAsync() {
        return false;
    }

    private final boolean isMarkdownTextViewClickable() {
        return true;
    }

    public /* synthetic */ DefaultMarkdownCodeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultMarkdownCodeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.textView = new TextView(context);
        this.highlight = LazyKt.lazy(new Function0<Prism4jSyntaxHighlight>() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$highlight$2
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Prism4jSyntaxHighlight m2895invoke() {
                Prism4jSyntaxHighlight create = Prism4jSyntaxHighlight.create(new Prism4j(new GrammarLocatorDef()), Prism4jThemeDefault.create(0), "plaintext");
                Intrinsics.checkNotNullExpressionValue(create, "create(Prism4j(GrammarLo…RANSPARENT), \"plaintext\")");
                return create;
            }
        });
        int dp_375 = MarkdownDimensExtKt.getDp_375();
        this.DEFAULT_MAX_HEIGHT = dp_375;
        this.MAX_LINE = 20;
        this.currentCode = "";
        this.currentLanguage = "";
        this.maxHeight = dp_375;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread highlightDispatcher$lambda$0;
                highlightDispatcher$lambda$0 = DefaultMarkdownCodeView.highlightDispatcher$lambda$0(runnable);
                return highlightDispatcher$lambda$0;
            }
        });
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor …\"highlight-thread\")\n    }");
        ExecutorCoroutineDispatcher from = ExecutorsKt.from(newSingleThreadExecutor);
        this.highlightDispatcher = from;
        this.highlightScope = CoroutineScopeKt.CoroutineScope(from.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)));
    }

    /* renamed from: getMarkdownTextView, reason: from getter */
    private final TextView getTextView() {
        return this.textView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Prism4jSyntaxHighlight getHighlight() {
        return (Prism4jSyntaxHighlight) this.highlight.getValue();
    }

    protected final String getCurrentCode() {
        return this.currentCode;
    }

    protected final void setCurrentCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentCode = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String getCurrentLanguage() {
        return this.currentLanguage;
    }

    protected final void setCurrentLanguage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentLanguage = str;
    }

    protected final boolean isFinish() {
        return this.isFinish;
    }

    protected final void setFinish(boolean z) {
        this.isFinish = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread highlightDispatcher$lambda$0(Runnable runnable) {
        return new Thread(runnable, "highlight-thread");
    }

    public final String getLanguage() {
        return this.currentLanguage;
    }

    /* renamed from: getCode, reason: from getter */
    public final String getCurrentCode() {
        return this.currentCode;
    }

    /* renamed from: getFinishState, reason: from getter */
    public final boolean getIsFinish() {
        return this.isFinish;
    }

    private final void performSingleClick() {
        Function1<? super Boolean, Unit> function1;
        if (!Intrinsics.areEqual(this.isFold, true) || (function1 = this.onClickFullScreenListener) == null) {
            return;
        }
        function1.invoke(false);
    }

    public final void init(final Function0<Unit> onClickCopyListener, final Function1<? super Boolean, Unit> onClickFullScreenListener, final Function0<Unit> onClickPreviewListener, final Function0<Unit> onLongClickListener, Function0<Boolean> supportsCodePreview, String foldText, final int maxHeight, Float textSize) {
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        FrameLayout frameLayout;
        MaxHeightLinearLayout root;
        MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding;
        ImageView imageView3;
        Intrinsics.checkNotNullParameter(foldText, "foldText");
        MarkdownCodeViewLayoutBinding inflate = MarkdownCodeViewLayoutBinding.inflate(LayoutInflater.from(getContext()), this, true);
        if (inflate != null) {
            TextViewCompat.setLineHeight(getTextView(), MarkdownDimensExtKt.getDp_24());
        } else {
            inflate = null;
        }
        this.binding = inflate;
        this.supportsCodePreview = supportsCodePreview;
        this.onClickFullScreenListener = onClickFullScreenListener;
        this.onClickCopyListener = onClickCopyListener;
        this.onClickPreviewListener = onClickPreviewListener;
        this.onLongClickListener = onLongClickListener;
        this.maxHeight = maxHeight;
        if (onClickFullScreenListener == null) {
            ImageView imageView4 = inflate != null ? inflate.markdownCodeFullscreenButton : null;
            if (imageView4 != null) {
                imageView4.setVisibility(8);
            }
        } else {
            ImageView imageView5 = inflate != null ? inflate.markdownCodeFullscreenButton : null;
            if (imageView5 != null) {
                imageView5.setVisibility(0);
            }
            MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding2 = this.binding;
            if (markdownCodeViewLayoutBinding2 != null && (imageView = markdownCodeViewLayoutBinding2.markdownCodeFullscreenButton) != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DefaultMarkdownCodeView.init$lambda$2(onClickFullScreenListener, view);
                    }
                });
            }
        }
        if (onClickCopyListener == null) {
            MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding3 = this.binding;
            ImageView imageView6 = markdownCodeViewLayoutBinding3 != null ? markdownCodeViewLayoutBinding3.markdownCodeCopyButton : null;
            if (imageView6 != null) {
                imageView6.setVisibility(8);
            }
        } else {
            MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding4 = this.binding;
            ImageView imageView7 = markdownCodeViewLayoutBinding4 != null ? markdownCodeViewLayoutBinding4.markdownCodeCopyButton : null;
            if (imageView7 != null) {
                imageView7.setVisibility(0);
            }
            MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding5 = this.binding;
            if (markdownCodeViewLayoutBinding5 != null && (imageView2 = markdownCodeViewLayoutBinding5.markdownCodeCopyButton) != null) {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        DefaultMarkdownCodeView.init$lambda$3(onClickCopyListener, view);
                    }
                });
            }
        }
        if (onClickPreviewListener != null && (markdownCodeViewLayoutBinding = this.binding) != null && (imageView3 = markdownCodeViewLayoutBinding.markdownCodePreviewButton) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DefaultMarkdownCodeView.init$lambda$4(onClickPreviewListener, view);
                }
            });
        }
        getTextView().setOnClickListener(new View.OnClickListener() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DefaultMarkdownCodeView.init$lambda$5(DefaultMarkdownCodeView.this, view);
            }
        });
        getTextView().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$$ExternalSyntheticLambda6
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean init$lambda$6;
                init$lambda$6 = DefaultMarkdownCodeView.init$lambda$6(onLongClickListener, view);
                return init$lambda$6;
            }
        });
        MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding6 = this.binding;
        if (markdownCodeViewLayoutBinding6 != null && (root = markdownCodeViewLayoutBinding6.getRoot()) != null) {
            root.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$$ExternalSyntheticLambda7
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    DefaultMarkdownCodeView.init$lambda$8(DefaultMarkdownCodeView.this, maxHeight, view, i, i2, i3, i4, i5, i6, i7, i8);
                }
            });
        }
        MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding7 = this.binding;
        TextView textView2 = markdownCodeViewLayoutBinding7 != null ? markdownCodeViewLayoutBinding7.markdownCodeFoldDesc : null;
        if (textView2 != null) {
            textView2.setText(foldText);
        }
        MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding8 = this.binding;
        MaxHeightLinearLayout root2 = markdownCodeViewLayoutBinding8 != null ? markdownCodeViewLayoutBinding8.getRoot() : null;
        if (root2 != null) {
            root2.setMaxHeight(maxHeight);
        }
        MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding9 = this.binding;
        if (markdownCodeViewLayoutBinding9 != null && (frameLayout = markdownCodeViewLayoutBinding9.markdownCodeContainer) != null) {
            TextView textView3 = getTextView();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(MarkdownDimensExtKt.getDp_16(), MarkdownDimensExtKt.getDp_10(), MarkdownDimensExtKt.getDp_16(), 0);
            layoutParams.gravity = 80;
            Unit unit = Unit.INSTANCE;
            frameLayout.addView(textView3, layoutParams);
        }
        if (textSize != null) {
            float floatValue = textSize.floatValue();
            MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding10 = this.binding;
            if (markdownCodeViewLayoutBinding10 != null && (textView = markdownCodeViewLayoutBinding10.markdownCodeLanguage) != null) {
                textView.setTextSize(0, floatValue);
            }
            getTextView().setTextSize(0, floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$2(Function1 function1, View view) {
        if (function1 != null) {
            function1.invoke(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$3(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$4(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$5(DefaultMarkdownCodeView defaultMarkdownCodeView, View view) {
        Intrinsics.checkNotNullParameter(defaultMarkdownCodeView, "this$0");
        if (defaultMarkdownCodeView.isMarkdownTextViewClickable()) {
            defaultMarkdownCodeView.performSingleClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$6(Function0 function0, View view) {
        if (function0 == null) {
            return true;
        }
        function0.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$8(final DefaultMarkdownCodeView defaultMarkdownCodeView, final int i, final View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        Intrinsics.checkNotNullParameter(defaultMarkdownCodeView, "this$0");
        defaultMarkdownCodeView.post(new Runnable() { // from class: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DefaultMarkdownCodeView.init$lambda$8$lambda$7(DefaultMarkdownCodeView.this, view, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void init$lambda$8$lambda$7(DefaultMarkdownCodeView defaultMarkdownCodeView, View view, int i) {
        Intrinsics.checkNotNullParameter(defaultMarkdownCodeView, "this$0");
        defaultMarkdownCodeView.isFold = Boolean.valueOf(view.getHeight() >= i);
        defaultMarkdownCodeView.updateHafFoldStatus();
    }

    public void bindData(String code, String language, boolean isFinish) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(language, "language");
        if (code.length() == 0) {
            setVisibility(8);
            return;
        }
        String substringBefore$default = StringsKt.substringBefore$default(language, " ", (String) null, 2, (Object) null);
        if (Intrinsics.areEqual(substringBefore$default, MARKDOWN_CODE_STD_OUT)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding = this.binding;
        TextView textView = markdownCodeViewLayoutBinding != null ? markdownCodeViewLayoutBinding.markdownCodeLanguage : null;
        if (textView != null) {
            textView.setText(substringBefore$default);
        }
        this.currentCode = code;
        this.currentLanguage = substringBefore$default;
        this.isFinish = isFinish;
        bindText();
        updateGravity();
        updatePreviewButton();
        updateHafFoldStatus();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
    
        if (((java.lang.Boolean) r0.invoke()).booleanValue() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updatePreviewButton() {
        boolean z;
        ImageView imageView;
        Function0<Boolean> function0 = this.supportsCodePreview;
        if (function0 != null) {
            z = true;
        }
        z = false;
        if (z && this.isFinish) {
            MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding = this.binding;
            imageView = markdownCodeViewLayoutBinding != null ? markdownCodeViewLayoutBinding.markdownCodePreviewButton : null;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(0);
            return;
        }
        MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding2 = this.binding;
        imageView = markdownCodeViewLayoutBinding2 != null ? markdownCodeViewLayoutBinding2.markdownCodePreviewButton : null;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    private final void updateGravity() {
        TextView textView = getTextView();
        int i = this.isFinish ? 48 : 80;
        if ((textView.getGravity() & 112) != i) {
            textView.setGravity(i | (textView.getGravity() & 7));
            textView.requestLayout();
        }
    }

    private final void bindText() {
        String takeLastLines;
        if (this.isFinish) {
            takeLastLines = MarkdownCodeUtil.INSTANCE.takeFirstLines(this.currentCode, this.MAX_LINE);
        } else {
            takeLastLines = MarkdownCodeUtil.INSTANCE.takeLastLines(this.currentCode, this.MAX_LINE);
        }
        TextView textView = getTextView();
        if (enableAsync()) {
            boolean z = true;
            if (!Intrinsics.areEqual(this.isFold, true)) {
                CharSequence text = textView.getText();
                if (!(text == null || text.length() == 0)) {
                    textView.setText(getHighlight().highlight(this.currentLanguage, takeLastLines));
                    return;
                }
            }
            CharSequence text2 = textView.getText();
            if (text2 != null && text2.length() != 0) {
                z = false;
            }
            if (z) {
                textView.setText(takeLastLines);
            }
            BuildersKt.launch$default(this.highlightScope, (CoroutineContext) null, (CoroutineStart) null, new DefaultMarkdownCodeView$bindText$1(this, takeLastLines, textView, null), 3, (Object) null);
            return;
        }
        textView.setText(new SpannableBuilder(getHighlight().highlight(this.currentLanguage, takeLastLines)).spannableStringBuilder());
    }

    private final void updateHafFoldStatus() {
        TextView textView;
        Boolean bool = this.isFold;
        if (bool == null) {
            return;
        }
        if (this.isFinish) {
            if (Intrinsics.areEqual(bool, true)) {
                MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding = this.binding;
                textView = markdownCodeViewLayoutBinding != null ? markdownCodeViewLayoutBinding.markdownCodeFoldDesc : null;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(0);
                return;
            }
            MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding2 = this.binding;
            textView = markdownCodeViewLayoutBinding2 != null ? markdownCodeViewLayoutBinding2.markdownCodeFoldDesc : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
            return;
        }
        MarkdownCodeViewLayoutBinding markdownCodeViewLayoutBinding3 = this.binding;
        textView = markdownCodeViewLayoutBinding3 != null ? markdownCodeViewLayoutBinding3.markdownCodeFoldDesc : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public final void onRecycle() {
        CoroutineScopeKt.cancel$default(this.highlightScope, (CancellationException) null, 1, (Object) null);
        this.highlightDispatcher.close();
    }
}
