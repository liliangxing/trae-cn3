package io.noties.markwon.html;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.push.constant.RemoteMessageConst;
import io.noties.markwon.SpannableBuilder;
import io.noties.markwon.html.HtmlTag;
import io.noties.markwon.html.HtmlTagImpl;
import io.noties.markwon.html.MarkwonHtmlParser;
import io.noties.markwon.html.jsoup.nodes.Attribute;
import io.noties.markwon.html.jsoup.nodes.Attributes;
import io.noties.markwon.html.jsoup.parser.CharacterReader;
import io.noties.markwon.html.jsoup.parser.ParseErrorList;
import io.noties.markwon.html.jsoup.parser.Token;
import io.noties.markwon.html.jsoup.parser.Tokeniser;
import io.noties.markwon.image.CustomImageSizeResolverDef;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class MarkwonHtmlParserImpl extends MarkwonHtmlParser {
    private final Set<String> additionBlockTags;
    private final Set<String> additionInlineTags;
    private final HtmlEmptyTagReplacement emptyTagReplacement;
    private boolean isInsidePreTag;
    private boolean previousIsBlock;
    private final Map<String, TagHandler> tagHandlers;
    private final TrimmingAppender trimmingAppender;
    static final Set<String> INLINE_TAGS = Collections.unmodifiableSet(new HashSet(Arrays.asList("a", "abbr", "acronym", "b", "bdo", "big", "br", "button", "cite", "code", "dfn", CustomImageSizeResolverDef.UNIT_EM, "i", "img", "input", "kbd", "label", "map", "object", "q", "samp", "script", "select", "small", "span", "strong", "sub", "sup", "textarea", CrashHianalyticsData.TIME, "tt", "var")));
    private static final Set<String> VOID_TAGS = Collections.unmodifiableSet(new HashSet(Arrays.asList("area", "base", "br", "col", "embed", "hr", "img", "input", "keygen", "link", "meta", RemoteMessageConst.MessageBody.PARAM, "source", "track", "wbr")));
    private static final String TAG_LIST_ITEM = "li";
    private static final String TAG_PARAGRAPH = "p";
    private static final Set<String> BLOCK_TAGS = Collections.unmodifiableSet(new HashSet(Arrays.asList("address", "article", "aside", "blockquote", "canvas", "dd", "div", "dl", "dt", "fieldset", "figcaption", "figure", "footer", "form", "h1", "h2", "h3", "h4", "h5", "h6", "header", "hgroup", "hr", TAG_LIST_ITEM, "main", "nav", "noscript", "ol", "output", TAG_PARAGRAPH, "pre", "section", "table", "tfoot", "ul", "video")));
    private final List<HtmlTagImpl.InlineImpl> inlineTags = new ArrayList(0);
    private HtmlTagImpl.BlockImpl currentBlock = HtmlTagImpl.BlockImpl.root();

    public static MarkwonHtmlParserImpl create() {
        return create(HtmlEmptyTagReplacement.create(), Collections.emptyMap());
    }

    public static MarkwonHtmlParserImpl create(HtmlEmptyTagReplacement htmlEmptyTagReplacement) {
        return create(htmlEmptyTagReplacement, Collections.emptyMap());
    }

    public static MarkwonHtmlParserImpl create(HtmlEmptyTagReplacement htmlEmptyTagReplacement, Map<String, TagHandler> map) {
        return create(htmlEmptyTagReplacement, map, new HashSet(), new HashSet());
    }

    public static MarkwonHtmlParserImpl create(HtmlEmptyTagReplacement htmlEmptyTagReplacement, Map<String, TagHandler> map, Set<String> set, Set<String> set2) {
        return new MarkwonHtmlParserImpl(htmlEmptyTagReplacement, map, TrimmingAppender.create(), set, set2);
    }

    MarkwonHtmlParserImpl(HtmlEmptyTagReplacement htmlEmptyTagReplacement, Map<String, TagHandler> map, TrimmingAppender trimmingAppender, Set<String> set, Set<String> set2) {
        this.emptyTagReplacement = htmlEmptyTagReplacement;
        this.tagHandlers = map;
        this.trimmingAppender = trimmingAppender;
        this.additionBlockTags = set;
        this.additionInlineTags = set2;
    }

    @Override // io.noties.markwon.html.MarkwonHtmlParser
    public void processFragment(SpannableBuilder spannableBuilder, String str) {
        Tokeniser tokeniser = new Tokeniser(new CharacterReader(str), ParseErrorList.noTracking());
        while (true) {
            Token read = tokeniser.read();
            Token.TokenType tokenType = read.type;
            if (Token.TokenType.EOF == tokenType) {
                return;
            }
            int i = C15591.$SwitchMap$io$noties$markwon$html$jsoup$parser$Token$TokenType[tokenType.ordinal()];
            if (i == 1) {
                Token.StartTag startTag = (Token.StartTag) read;
                if (isInlineTag(startTag.normalName) || isAdditionInlineTag(startTag.normalName)) {
                    processInlineTagStart(spannableBuilder, startTag);
                } else {
                    processBlockTagStart(spannableBuilder, startTag);
                }
            } else if (i == 2) {
                Token.EndTag endTag = (Token.EndTag) read;
                if (isInlineTag(endTag.normalName) || isAdditionInlineTag(endTag.normalName)) {
                    processInlineTagEnd(spannableBuilder, endTag);
                } else {
                    processBlockTagEnd(spannableBuilder, endTag);
                }
            } else if (i == 3) {
                processCharacter(spannableBuilder, (Token.Character) read);
            }
            read.reset();
        }
    }

    /* renamed from: io.noties.markwon.html.MarkwonHtmlParserImpl$1 */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
    static /* synthetic */ class C15591 {
        static final /* synthetic */ int[] $SwitchMap$io$noties$markwon$html$jsoup$parser$Token$TokenType;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            $SwitchMap$io$noties$markwon$html$jsoup$parser$Token$TokenType = iArr;
            try {
                iArr[Token.TokenType.StartTag.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$noties$markwon$html$jsoup$parser$Token$TokenType[Token.TokenType.EndTag.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$noties$markwon$html$jsoup$parser$Token$TokenType[Token.TokenType.Character.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // io.noties.markwon.html.MarkwonHtmlParser
    public void flushInlineTags(int i, MarkwonHtmlParser.FlushAction<HtmlTag.Inline> flushAction) {
        if (this.inlineTags.size() > 0) {
            if (i > -1) {
                Iterator<HtmlTagImpl.InlineImpl> it = this.inlineTags.iterator();
                while (it.hasNext()) {
                    it.next().closeAt(i);
                }
            }
            ArrayList arrayList = new ArrayList(this.inlineTags);
            Collections.reverse(arrayList);
            flushAction.apply(arrayList);
            this.inlineTags.clear();
            return;
        }
        flushAction.apply(Collections.emptyList());
    }

    @Override // io.noties.markwon.html.MarkwonHtmlParser
    public void flushBlockTags(int i, MarkwonHtmlParser.FlushAction<HtmlTag.Block> flushAction) {
        HtmlTagImpl.BlockImpl blockImpl = this.currentBlock;
        while (blockImpl.parent != null) {
            blockImpl = blockImpl.parent;
        }
        if (i > -1) {
            blockImpl.closeAt(i);
        }
        List<HtmlTag.Block> children = blockImpl.children();
        if (children.size() > 0) {
            flushAction.apply(children);
        } else {
            flushAction.apply(Collections.emptyList());
        }
        this.currentBlock = HtmlTagImpl.BlockImpl.root();
    }

    @Override // io.noties.markwon.html.MarkwonHtmlParser
    public void reset() {
        this.inlineTags.clear();
        this.currentBlock = HtmlTagImpl.BlockImpl.root();
    }

    protected void processInlineTagStart(SpannableBuilder spannableBuilder, Token.StartTag startTag) {
        String str = startTag.normalName;
        HtmlTagImpl.InlineImpl inlineImpl = new HtmlTagImpl.InlineImpl(str, spannableBuilder.length(), extractAttributes(startTag));
        ensureNewLineIfPreviousWasBlock(spannableBuilder);
        if (isVoidTag(str) || startTag.selfClosing) {
            inlineImpl.setTextContent(spannableBuilder.subSequence(inlineImpl.start(), spannableBuilder.length()));
            replaceTag(spannableBuilder, inlineImpl);
            inlineImpl.closeAt(spannableBuilder.length());
        }
        this.inlineTags.add(inlineImpl);
    }

    protected void processInlineTagEnd(SpannableBuilder spannableBuilder, Token.EndTag endTag) {
        HtmlTagImpl.InlineImpl findOpenInlineTag = findOpenInlineTag(endTag.normalName);
        if (findOpenInlineTag != null) {
            findOpenInlineTag.setTextContent(spannableBuilder.subSequence(findOpenInlineTag.start(), spannableBuilder.length()));
            replaceTag(spannableBuilder, findOpenInlineTag);
            findOpenInlineTag.closeAt(spannableBuilder.length());
        }
    }

    protected void processBlockTagStart(SpannableBuilder spannableBuilder, Token.StartTag startTag) {
        String str = startTag.normalName;
        if (TAG_PARAGRAPH.equals(this.currentBlock.name)) {
            this.currentBlock.closeAt(spannableBuilder.length());
            AppendableUtils.appendQuietly((Appendable) spannableBuilder, '\n');
            this.currentBlock = this.currentBlock.parent;
        } else if (TAG_LIST_ITEM.equals(str) && TAG_LIST_ITEM.equals(this.currentBlock.name)) {
            this.currentBlock.closeAt(spannableBuilder.length());
            this.currentBlock = this.currentBlock.parent;
        }
        if (isBlockTag(str) || isAdditionBlockTag(str)) {
            this.isInsidePreTag = "pre".equals(str);
            ensureNewLine(spannableBuilder);
        } else {
            ensureNewLineIfPreviousWasBlock(spannableBuilder);
        }
        HtmlTagImpl.BlockImpl create = HtmlTagImpl.BlockImpl.create(str, spannableBuilder.length(), extractAttributes(startTag), this.currentBlock);
        boolean z = isVoidTag(str) || startTag.selfClosing;
        if (z) {
            create.setTextContent(spannableBuilder.subSequence(create.start(), spannableBuilder.length()));
            replaceTag(spannableBuilder, create);
            create.closeAt(spannableBuilder.length());
        }
        appendBlockChild(create.parent, create);
        if (z) {
            return;
        }
        this.currentBlock = create;
    }

    protected void processBlockTagEnd(SpannableBuilder spannableBuilder, Token.EndTag endTag) {
        String str = endTag.normalName;
        HtmlTagImpl.BlockImpl findOpenBlockTag = findOpenBlockTag(endTag.normalName);
        if (findOpenBlockTag != null) {
            if ("pre".equals(str)) {
                this.isInsidePreTag = false;
            }
            findOpenBlockTag.setTextContent(spannableBuilder.subSequence(findOpenBlockTag.start(), spannableBuilder.length()));
            replaceTag(spannableBuilder, findOpenBlockTag);
            findOpenBlockTag.closeAt(spannableBuilder.length());
            if (!findOpenBlockTag.isEmpty()) {
                this.previousIsBlock = isBlockTag(findOpenBlockTag.name) || isAdditionBlockTag(str);
            }
            if (TAG_PARAGRAPH.equals(str)) {
                AppendableUtils.appendQuietly((Appendable) spannableBuilder, '\n');
            }
            this.currentBlock = findOpenBlockTag.parent;
        }
    }

    protected <T extends Appendable & CharSequence> void processCharacter(T t, Token.Character character) {
        if (this.isInsidePreTag) {
            AppendableUtils.appendQuietly(t, character.getData());
        } else {
            ensureNewLineIfPreviousWasBlock(t);
            this.trimmingAppender.append(t, character.getData());
        }
    }

    protected void appendBlockChild(HtmlTagImpl.BlockImpl blockImpl, HtmlTagImpl.BlockImpl blockImpl2) {
        List list = blockImpl.children;
        if (list == null) {
            list = new ArrayList(2);
            blockImpl.children = list;
        }
        list.add(blockImpl2);
    }

    protected HtmlTagImpl.InlineImpl findOpenInlineTag(String str) {
        int size = this.inlineTags.size();
        while (true) {
            size--;
            if (size <= -1) {
                return null;
            }
            HtmlTagImpl.InlineImpl inlineImpl = this.inlineTags.get(size);
            if (str.equals(inlineImpl.name) && inlineImpl.end < 0) {
                return inlineImpl;
            }
        }
    }

    protected HtmlTagImpl.BlockImpl findOpenBlockTag(String str) {
        HtmlTagImpl.BlockImpl blockImpl = this.currentBlock;
        while (blockImpl != null && !str.equals(blockImpl.name) && !blockImpl.isClosed()) {
            blockImpl = blockImpl.parent;
        }
        return blockImpl;
    }

    protected <T extends Appendable & CharSequence> void ensureNewLineIfPreviousWasBlock(T t) {
        if (this.previousIsBlock) {
            ensureNewLine(t);
            this.previousIsBlock = false;
        }
    }

    protected static boolean isInlineTag(String str) {
        return INLINE_TAGS.contains(str);
    }

    protected static boolean isVoidTag(String str) {
        return VOID_TAGS.contains(str);
    }

    protected static boolean isBlockTag(String str) {
        return BLOCK_TAGS.contains(str);
    }

    protected static <T extends Appendable & CharSequence> void ensureNewLine(T t) {
        T t2 = t;
        int length = t2.length();
        if (length <= 0 || '\n' == t2.charAt(length - 1)) {
            return;
        }
        AppendableUtils.appendQuietly((Appendable) t, '\n');
    }

    protected static Map<String, String> extractAttributes(Token.StartTag startTag) {
        Attributes attributes = startTag.attributes;
        int size = attributes.size();
        if (size > 0) {
            HashMap hashMap = new HashMap(size);
            Iterator<Attribute> it = attributes.iterator();
            while (it.hasNext()) {
                Attribute next = it.next();
                hashMap.put(next.getKey().toLowerCase(Locale.US), next.getValue());
            }
            return Collections.unmodifiableMap(hashMap);
        }
        return Collections.emptyMap();
    }

    protected static boolean isEmpty(SpannableBuilder spannableBuilder, HtmlTag htmlTag) {
        return htmlTag.start() == spannableBuilder.length();
    }

    protected void appendEmptyTagReplacement(SpannableBuilder spannableBuilder, HtmlTag htmlTag) {
        String replace = this.emptyTagReplacement.replace(htmlTag);
        if (replace == null || replace.length() <= 0) {
            return;
        }
        AppendableUtils.appendQuietly(spannableBuilder, replace);
    }

    protected void appendTagReplacement(SpannableBuilder spannableBuilder, HtmlTag htmlTag) {
        CharSequence replaceTag;
        TagHandler tagHandler = this.tagHandlers.get(htmlTag.name());
        if (tagHandler == null || (replaceTag = tagHandler.replaceTag(htmlTag, this.emptyTagReplacement)) == null || replaceTag == htmlTag.textContent()) {
            return;
        }
        spannableBuilder.removeFromEnd(htmlTag.start());
        spannableBuilder.append(replaceTag);
    }

    private void replaceTag(SpannableBuilder spannableBuilder, HtmlTag htmlTag) {
        appendTagReplacement(spannableBuilder, htmlTag);
        if (isEmpty(spannableBuilder, htmlTag)) {
            appendEmptyTagReplacement(spannableBuilder, htmlTag);
        }
    }

    private boolean isAdditionInlineTag(String str) {
        return this.additionInlineTags.contains(str);
    }

    private boolean isAdditionBlockTag(String str) {
        return this.additionBlockTags.contains(str);
    }
}
