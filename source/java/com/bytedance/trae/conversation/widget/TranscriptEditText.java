package com.bytedance.trae.conversation.widget;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import com.bytedance.tracing.log.Fields;
import com.bytedance.trae.common_ui.C0591R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: TranscriptEditText.kt */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 @2\u00020\u0001:\u0003>?@B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0014J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0014J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020\u001bJ\u0006\u0010&\u001a\u00020\u0010J\b\u0010'\u001a\u0004\u0018\u00010\u0014J\u0010\u0010(\u001a\u00020\u001b2\b\u0010!\u001a\u0004\u0018\u00010\u0014J\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00140*J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0*J\b\u0010-\u001a\u00020\u001bH\u0002J\u001d\u0010.\u001a\u00020\u001b\"\n\b\u0000\u0010/\u0018\u0001*\u0002002\u0006\u00101\u001a\u000202H\u0082\bJ\u0012\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0012\u00107\u001a\b\u0012\u0004\u0012\u0002000**\u000208H\u0002J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020=H\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00108F@BX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u00109\u001a\u00020:X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/bytedance/trae/conversation/widget/TranscriptEditText;", "Landroidx/appcompat/widget/AppCompatEditText;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "handler", "Landroid/os/Handler;", "downX", "", "downY", "longPressTriggered", "", "touchSlop", "isInternalUpdate", "currentSkill", "Lcom/bytedance/trae/conversation/widget/SkillItem;", "value", "isInternalUpdateFlag", "()Z", "setInternalUpdateFlag", "(Z)V", "onDetachedFromWindow", "", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "insertSkillTag", "skill", "insertPluginTag", "plugin", "Lcom/bytedance/trae/conversation/widget/PluginTagItem;", "removeSkillTag", "hasInputTag", "getSelectedSkill", "setCurrentSkill", "getSkillList", "", "getContentSegments", "Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment;", "removeSkillTagInternal", "removeSpansOfType", "T", "Lcom/bytedance/trae/conversation/widget/InputTagSpan;", "editable", "Landroid/text/Editable;", "getTextExcludingSkillTag", "", "s", "", "getTagSpans", "Landroid/text/Spanned;", "longPressRunnable", "Ljava/lang/Runnable;", "onTouchEvent", Fields.EVENT, "Landroid/view/MotionEvent;", "SkillTagInputConnection", "ContentSegment", "Companion", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class TranscriptEditText extends AppCompatEditText {
    public static final long LONG_PRESS_TIMEOUT = 250;
    private SkillItem currentSkill;
    private float downX;
    private float downY;
    private final Handler handler;
    private boolean isInternalUpdate;
    private final Runnable longPressRunnable;
    private boolean longPressTriggered;
    private final int touchSlop;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TranscriptEditText(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TranscriptEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TranscriptEditText(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? R.attr.editTextStyle : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TranscriptEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.handler = new Handler(Looper.getMainLooper());
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        addTextChangedListener(new InputTagProtectWatcher((EditText) this));
        this.longPressRunnable = new Runnable() { // from class: com.bytedance.trae.conversation.widget.TranscriptEditText$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TranscriptEditText.longPressRunnable$lambda$10(TranscriptEditText.this);
            }
        };
    }

    /* renamed from: isInternalUpdateFlag, reason: from getter */
    public final boolean getIsInternalUpdate() {
        return this.isInternalUpdate;
    }

    private final void setInternalUpdateFlag(boolean z) {
        this.isInternalUpdate = z;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Editable text = getText();
        if (text != null) {
            Object[] spans = text.getSpans(0, text.length(), PluginTagSpan.class);
            Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
            for (Object obj : spans) {
                ((PluginTagSpan) obj).release();
            }
        }
    }

    public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
        Intrinsics.checkNotNullParameter(outAttrs, "outAttrs");
        InputConnection onCreateInputConnection = super.onCreateInputConnection(outAttrs);
        if (onCreateInputConnection == null) {
            return null;
        }
        return new SkillTagInputConnection(this, onCreateInputConnection, true);
    }

    /* compiled from: TranscriptEditText.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0002¨\u0006\u0010"}, d2 = {"Lcom/bytedance/trae/conversation/widget/TranscriptEditText$SkillTagInputConnection;", "Landroid/view/inputmethod/InputConnectionWrapper;", "target", "Landroid/view/inputmethod/InputConnection;", "mutable", "", "<init>", "(Lcom/bytedance/trae/conversation/widget/TranscriptEditText;Landroid/view/inputmethod/InputConnection;Z)V", "deleteSurroundingText", "beforeLength", "", "afterLength", "sendKeyEvent", Fields.EVENT, "Landroid/view/KeyEvent;", "tryDeleteInputTag", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private final class SkillTagInputConnection extends InputConnectionWrapper {
        final /* synthetic */ TranscriptEditText this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SkillTagInputConnection(TranscriptEditText transcriptEditText, InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
            Intrinsics.checkNotNullParameter(inputConnection, "target");
            this.this$0 = transcriptEditText;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int beforeLength, int afterLength) {
            if (beforeLength <= 0 || !tryDeleteInputTag()) {
                return super.deleteSurroundingText(beforeLength, afterLength);
            }
            return true;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent event) {
            Intrinsics.checkNotNullParameter(event, Fields.EVENT);
            if (event.getAction() == 0 && event.getKeyCode() == 67 && tryDeleteInputTag()) {
                return true;
            }
            return super.sendKeyEvent(event);
        }

        private final boolean tryDeleteInputTag() {
            Editable text = this.this$0.getText();
            if (text == null) {
                return false;
            }
            int selectionStart = this.this$0.getSelectionStart();
            for (InputTagSpan inputTagSpan : this.this$0.getTagSpans(text)) {
                int spanEnd = text.getSpanEnd(inputTagSpan);
                if (selectionStart == spanEnd || selectionStart == spanEnd + 1) {
                    int spanStart = text.getSpanStart(inputTagSpan);
                    this.this$0.isInternalUpdate = true;
                    if (inputTagSpan instanceof PluginTagSpan) {
                        ((PluginTagSpan) inputTagSpan).release();
                    }
                    text.removeSpan(inputTagSpan);
                    text.delete(spanStart, RangesKt.coerceAtMost(spanEnd + 1, text.length()));
                    this.this$0.setSelection(RangesKt.coerceAtMost(spanStart, text.length()));
                    this.this$0.isInternalUpdate = false;
                    return true;
                }
            }
            return false;
        }
    }

    public final void insertSkillTag(SkillItem skill) {
        Intrinsics.checkNotNullParameter(skill, "skill");
        this.currentSkill = skill;
        this.isInternalUpdate = true;
        Editable text = getText();
        if (text == null) {
            this.isInternalUpdate = false;
            return;
        }
        int coerceIn = RangesKt.coerceIn(getSelectionStart(), 0, text.length());
        String str = " " + skill.getName() + (char) 160;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String name = skill.getName();
        int iconRes = skill.getIconRes();
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        float m867dp = SkillTagSpanKt.m867dp(13.0f, context2);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        float m867dp2 = SkillTagSpanKt.m867dp(6.0f, context3);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        float m867dp3 = SkillTagSpanKt.m867dp(1.0f, context4);
        int color = ContextCompat.getColor(getContext(), C0591R.color.trae_brand_blue_100);
        int color2 = ContextCompat.getColor(getContext(), C0591R.color.trae_brand_blue_900);
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
        spannableStringBuilder.setSpan(new SkillTagSpan(context, name, iconRes, skill, m867dp, m867dp2, 0.0f, 0.0f, m867dp3, color, color2, SkillTagSpanKt.m867dp(8.0f, context5), 192, null), 0, str.length(), 33);
        spannableStringBuilder.append((CharSequence) " ");
        text.insert(coerceIn, spannableStringBuilder);
        setSelection(RangesKt.coerceAtMost(coerceIn + spannableStringBuilder.length(), text.length()));
        this.isInternalUpdate = false;
    }

    public final void insertPluginTag(PluginTagItem plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        this.isInternalUpdate = true;
        Editable text = getText();
        if (text == null) {
            this.isInternalUpdate = false;
            return;
        }
        int coerceIn = RangesKt.coerceIn(getSelectionStart(), 0, text.length());
        String str = " " + plugin.getDisplayName() + (char) 160;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        String displayName = plugin.getDisplayName();
        int iconRes = plugin.getIconRes();
        String iconUrl = plugin.getIconUrl();
        WeakReference weakReference = new WeakReference(this);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
        float m867dp = SkillTagSpanKt.m867dp(13.0f, context2);
        Context context3 = getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
        float m867dp2 = SkillTagSpanKt.m867dp(6.0f, context3);
        Context context4 = getContext();
        Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
        float m867dp3 = SkillTagSpanKt.m867dp(1.0f, context4);
        int color = ContextCompat.getColor(getContext(), C0591R.color.trae_brand_blue_100);
        int color2 = ContextCompat.getColor(getContext(), C0591R.color.trae_brand_blue_900);
        Context context5 = getContext();
        Intrinsics.checkNotNullExpressionValue(context5, "getContext(...)");
        spannableStringBuilder.setSpan(new PluginTagSpan(context, displayName, iconRes, plugin, iconUrl, weakReference, m867dp, m867dp2, 0.0f, 0.0f, m867dp3, color, color2, SkillTagSpanKt.m867dp(8.0f, context5), 768, null), 0, str.length(), 33);
        spannableStringBuilder.append((CharSequence) " ");
        text.insert(coerceIn, spannableStringBuilder);
        setSelection(RangesKt.coerceAtMost(coerceIn + spannableStringBuilder.length(), text.length()));
        this.isInternalUpdate = false;
    }

    public final void removeSkillTag() {
        this.isInternalUpdate = true;
        removeSkillTagInternal();
        this.currentSkill = null;
        this.isInternalUpdate = false;
    }

    public final boolean hasInputTag() {
        if (getText() == null) {
            return false;
        }
        return !getTagSpans(r0).isEmpty();
    }

    /* renamed from: getSelectedSkill, reason: from getter */
    public final SkillItem getCurrentSkill() {
        return this.currentSkill;
    }

    public final void setCurrentSkill(SkillItem skill) {
        this.currentSkill = skill;
    }

    public final List<SkillItem> getSkillList() {
        final Editable text = getText();
        if (text == null) {
            return CollectionsKt.emptyList();
        }
        Object[] spans = text.getSpans(0, text.length(), SkillTagSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        List sortedWith = ArraysKt.sortedWith(spans, new Comparator() { // from class: com.bytedance.trae.conversation.widget.TranscriptEditText$getSkillList$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(text.getSpanStart((SkillTagSpan) t)), Integer.valueOf(text.getSpanStart((SkillTagSpan) t2)));
            }
        });
        ArrayList arrayList = new ArrayList();
        Iterator it = sortedWith.iterator();
        while (it.hasNext()) {
            SkillItem skillItem = ((SkillTagSpan) it.next()).getSkillItem();
            if (skillItem != null) {
                arrayList.add(skillItem);
            }
        }
        return arrayList;
    }

    /* compiled from: TranscriptEditText.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment;", "", "<init>", "()V", "Text", "Skill", "Plugin", "Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Plugin;", "Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Skill;", "Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Text;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static abstract class ContentSegment {
        public /* synthetic */ ContentSegment(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* compiled from: TranscriptEditText.kt */
        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Text;", "Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment;", ReportConstant.COMMON_CONTENT, "", "<init>", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Text extends ContentSegment {
            private final String content;

            public static /* synthetic */ Text copy$default(Text text, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = text.content;
                }
                return text.copy(str);
            }

            /* renamed from: component1, reason: from getter */
            public final String getContent() {
                return this.content;
            }

            public final Text copy(String content) {
                Intrinsics.checkNotNullParameter(content, ReportConstant.COMMON_CONTENT);
                return new Text(content);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Text) && Intrinsics.areEqual(this.content, ((Text) other).content);
            }

            public int hashCode() {
                return this.content.hashCode();
            }

            public String toString() {
                return "Text(content=" + this.content + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Text(String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, ReportConstant.COMMON_CONTENT);
                this.content = str;
            }

            public final String getContent() {
                return this.content;
            }
        }

        private ContentSegment() {
        }

        /* compiled from: TranscriptEditText.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Skill;", "Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment;", "skillItem", "Lcom/bytedance/trae/conversation/widget/SkillItem;", "<init>", "(Lcom/bytedance/trae/conversation/widget/SkillItem;)V", "getSkillItem", "()Lcom/bytedance/trae/conversation/widget/SkillItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Skill extends ContentSegment {
            private final SkillItem skillItem;

            public static /* synthetic */ Skill copy$default(Skill skill, SkillItem skillItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    skillItem = skill.skillItem;
                }
                return skill.copy(skillItem);
            }

            /* renamed from: component1, reason: from getter */
            public final SkillItem getSkillItem() {
                return this.skillItem;
            }

            public final Skill copy(SkillItem skillItem) {
                Intrinsics.checkNotNullParameter(skillItem, "skillItem");
                return new Skill(skillItem);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Skill) && Intrinsics.areEqual(this.skillItem, ((Skill) other).skillItem);
            }

            public int hashCode() {
                return this.skillItem.hashCode();
            }

            public String toString() {
                return "Skill(skillItem=" + this.skillItem + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Skill(SkillItem skillItem) {
                super(null);
                Intrinsics.checkNotNullParameter(skillItem, "skillItem");
                this.skillItem = skillItem;
            }

            public final SkillItem getSkillItem() {
                return this.skillItem;
            }
        }

        /* compiled from: TranscriptEditText.kt */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment$Plugin;", "Lcom/bytedance/trae/conversation/widget/TranscriptEditText$ContentSegment;", "pluginItem", "Lcom/bytedance/trae/conversation/widget/PluginTagItem;", "<init>", "(Lcom/bytedance/trae/conversation/widget/PluginTagItem;)V", "getPluginItem", "()Lcom/bytedance/trae/conversation/widget/PluginTagItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
        public static final /* data */ class Plugin extends ContentSegment {
            private final PluginTagItem pluginItem;

            public static /* synthetic */ Plugin copy$default(Plugin plugin, PluginTagItem pluginTagItem, int i, Object obj) {
                if ((i & 1) != 0) {
                    pluginTagItem = plugin.pluginItem;
                }
                return plugin.copy(pluginTagItem);
            }

            /* renamed from: component1, reason: from getter */
            public final PluginTagItem getPluginItem() {
                return this.pluginItem;
            }

            public final Plugin copy(PluginTagItem pluginItem) {
                Intrinsics.checkNotNullParameter(pluginItem, "pluginItem");
                return new Plugin(pluginItem);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Plugin) && Intrinsics.areEqual(this.pluginItem, ((Plugin) other).pluginItem);
            }

            public int hashCode() {
                return this.pluginItem.hashCode();
            }

            public String toString() {
                return "Plugin(pluginItem=" + this.pluginItem + ')';
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Plugin(PluginTagItem pluginTagItem) {
                super(null);
                Intrinsics.checkNotNullParameter(pluginTagItem, "pluginItem");
                this.pluginItem = pluginTagItem;
            }

            public final PluginTagItem getPluginItem() {
                return this.pluginItem;
            }
        }
    }

    public final List<ContentSegment> getContentSegments() {
        Editable text = getText();
        if (text == null) {
            return CollectionsKt.emptyList();
        }
        List<InputTagSpan> tagSpans = getTagSpans(text);
        ArrayList arrayList = new ArrayList();
        Iterator<InputTagSpan> it = tagSpans.iterator();
        int i = 0;
        while (true) {
            if (it.hasNext()) {
                InputTagSpan next = it.next();
                int spanStart = text.getSpanStart(next);
                int spanEnd = text.getSpanEnd(next);
                if (i < spanStart) {
                    String obj = StringsKt.trim(text.subSequence(i, spanStart).toString()).toString();
                    if (obj.length() > 0) {
                        arrayList.add(new ContentSegment.Text(obj));
                    }
                }
                if (next instanceof SkillTagSpan) {
                    SkillItem skillItem = ((SkillTagSpan) next).getSkillItem();
                    if (skillItem != null) {
                        arrayList.add(new ContentSegment.Skill(skillItem));
                    }
                } else {
                    if (!(next instanceof PluginTagSpan)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    arrayList.add(new ContentSegment.Plugin(((PluginTagSpan) next).getPluginItem()));
                }
                i = spanEnd;
            } else {
                if (i < text.length()) {
                    String obj2 = StringsKt.trim(text.subSequence(i, text.length()).toString()).toString();
                    if (obj2.length() > 0) {
                        arrayList.add(new ContentSegment.Text(obj2));
                    }
                }
                return arrayList;
            }
        }
    }

    private final void removeSkillTagInternal() {
        final Editable text = getText();
        if (text == null) {
            return;
        }
        Object[] spans = text.getSpans(0, text.length(), SkillTagSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        for (InputTagSpan inputTagSpan : ArraysKt.sortedWith(spans, new Comparator() { // from class: com.bytedance.trae.conversation.widget.TranscriptEditText$removeSkillTagInternal$$inlined$removeSpansOfType$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(text.getSpanStart((InputTagSpan) t2)), Integer.valueOf(text.getSpanStart((InputTagSpan) t)));
            }
        })) {
            int spanStart = text.getSpanStart(inputTagSpan);
            int spanEnd = text.getSpanEnd(inputTagSpan);
            if (inputTagSpan instanceof PluginTagSpan) {
                ((PluginTagSpan) inputTagSpan).release();
            }
            text.removeSpan(inputTagSpan);
            text.delete(spanStart, spanEnd);
        }
    }

    private final /* synthetic */ <T extends InputTagSpan> void removeSpansOfType(final Editable editable) {
        int length = editable.length();
        Intrinsics.reifiedOperationMarker(4, "T");
        Object[] spans = editable.getSpans(0, length, InputTagSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        Intrinsics.needClassReification();
        for (InputTagSpan inputTagSpan : ArraysKt.sortedWith(spans, new Comparator() { // from class: com.bytedance.trae.conversation.widget.TranscriptEditText$removeSpansOfType$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(editable.getSpanStart((InputTagSpan) t2)), Integer.valueOf(editable.getSpanStart((InputTagSpan) t)));
            }
        })) {
            int spanStart = editable.getSpanStart(inputTagSpan);
            int spanEnd = editable.getSpanEnd(inputTagSpan);
            if (inputTagSpan instanceof PluginTagSpan) {
                ((PluginTagSpan) inputTagSpan).release();
            }
            editable.removeSpan(inputTagSpan);
            editable.delete(spanStart, spanEnd);
        }
    }

    private final String getTextExcludingSkillTag(CharSequence s) {
        if (s == null) {
            return "";
        }
        if (s instanceof Spanned) {
            Spanned spanned = (Spanned) s;
            List<InputTagSpan> tagSpans = getTagSpans(spanned);
            if (!tagSpans.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                int i = 0;
                for (InputTagSpan inputTagSpan : tagSpans) {
                    int spanStart = spanned.getSpanStart(inputTagSpan);
                    int spanEnd = spanned.getSpanEnd(inputTagSpan);
                    if (i < spanStart) {
                        sb.append(spanned.subSequence(i, spanStart));
                    }
                    i = spanEnd;
                }
                if (i < spanned.length()) {
                    sb.append(spanned.subSequence(i, spanned.length()));
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                return StringsKt.trim(sb2).toString();
            }
        }
        return StringsKt.trim(s.toString()).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<InputTagSpan> getTagSpans(final Spanned spanned) {
        List createListBuilder = CollectionsKt.createListBuilder();
        List list = createListBuilder;
        Object[] spans = spanned.getSpans(0, spanned.length(), SkillTagSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
        CollectionsKt.addAll(list, spans);
        Object[] spans2 = spanned.getSpans(0, spanned.length(), PluginTagSpan.class);
        Intrinsics.checkNotNullExpressionValue(spans2, "getSpans(...)");
        CollectionsKt.addAll(list, spans2);
        return CollectionsKt.sortedWith(CollectionsKt.build(createListBuilder), new Comparator() { // from class: com.bytedance.trae.conversation.widget.TranscriptEditText$getTagSpans$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Spanned spanned2 = spanned;
                Intrinsics.checkNotNull(t, "null cannot be cast to non-null type kotlin.Any");
                Integer valueOf = Integer.valueOf(spanned2.getSpanStart(t));
                Spanned spanned3 = spanned;
                Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type kotlin.Any");
                return ComparisonsKt.compareValues(valueOf, Integer.valueOf(spanned3.getSpanStart(t2)));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void longPressRunnable$lambda$10(TranscriptEditText transcriptEditText) {
        transcriptEditText.longPressTriggered = true;
        transcriptEditText.cancelLongPress();
        transcriptEditText.performLongClick();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0013, code lost:
    
        if (r0 != 3) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, Fields.EVENT);
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.downX = event.getX();
            this.downY = event.getY();
            this.longPressTriggered = false;
            this.handler.postDelayed(this.longPressRunnable, 250L);
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (Math.abs(event.getX() - this.downX) > this.touchSlop || Math.abs(event.getY() - this.downY) > this.touchSlop) {
                        this.handler.removeCallbacks(this.longPressRunnable);
                    }
                }
            }
            this.handler.removeCallbacks(this.longPressRunnable);
            if (this.longPressTriggered) {
                this.longPressTriggered = false;
                return true;
            }
        }
        return super.onTouchEvent(event);
    }
}
