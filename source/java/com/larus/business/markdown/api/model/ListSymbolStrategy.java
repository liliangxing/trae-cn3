package com.larus.business.markdown.api.model;

import kotlin.Metadata;

/* compiled from: ListStyle.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bJ\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\f"}, d2 = {"Lcom/larus/business/markdown/api/model/ListSymbolStrategy;", "", "orderedSymbol", "Lcom/larus/business/markdown/api/model/OrderedSymbol;", "level", "", "unorderedSymbol", "Lcom/larus/business/markdown/api/model/UnorderedSymbol;", "CommonMarkSymbolStrategy", "FlowSymbolStrategy", "GitHubFlavoredSymbolStrategy", "LarkSymbolStrategy", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
public interface ListSymbolStrategy {
    OrderedSymbol orderedSymbol(int level);

    UnorderedSymbol unorderedSymbol(int level);

    /* compiled from: ListStyle.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/api/model/ListSymbolStrategy$CommonMarkSymbolStrategy;", "Lcom/larus/business/markdown/api/model/ListSymbolStrategy;", "()V", "orderedSymbol", "Lcom/larus/business/markdown/api/model/OrderedSymbol;", "level", "", "unorderedSymbol", "Lcom/larus/business/markdown/api/model/UnorderedSymbol;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class CommonMarkSymbolStrategy implements ListSymbolStrategy {
        @Override // com.larus.business.markdown.api.model.ListSymbolStrategy
        public UnorderedSymbol unorderedSymbol(int level) {
            if (level == 0) {
                return UnorderedSymbol.DISC;
            }
            if (level == 1) {
                return UnorderedSymbol.CIRCLE;
            }
            return UnorderedSymbol.SQUARE;
        }

        @Override // com.larus.business.markdown.api.model.ListSymbolStrategy
        public OrderedSymbol orderedSymbol(int level) {
            return OrderedSymbol.DECIMAL;
        }
    }

    /* compiled from: ListStyle.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/api/model/ListSymbolStrategy$GitHubFlavoredSymbolStrategy;", "Lcom/larus/business/markdown/api/model/ListSymbolStrategy;", "()V", "orderedSymbol", "Lcom/larus/business/markdown/api/model/OrderedSymbol;", "level", "", "unorderedSymbol", "Lcom/larus/business/markdown/api/model/UnorderedSymbol;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GitHubFlavoredSymbolStrategy implements ListSymbolStrategy {
        @Override // com.larus.business.markdown.api.model.ListSymbolStrategy
        public UnorderedSymbol unorderedSymbol(int level) {
            if (level == 0) {
                return UnorderedSymbol.DISC;
            }
            if (level == 1) {
                return UnorderedSymbol.CIRCLE;
            }
            return UnorderedSymbol.SQUARE;
        }

        @Override // com.larus.business.markdown.api.model.ListSymbolStrategy
        public OrderedSymbol orderedSymbol(int level) {
            if (level == 0) {
                return OrderedSymbol.DECIMAL;
            }
            if (level == 1) {
                return OrderedSymbol.LOWERCASE_ROMAN;
            }
            return OrderedSymbol.LOWERCASE_ALPHABET;
        }
    }

    /* compiled from: ListStyle.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/api/model/ListSymbolStrategy$LarkSymbolStrategy;", "Lcom/larus/business/markdown/api/model/ListSymbolStrategy;", "()V", "orderedSymbol", "Lcom/larus/business/markdown/api/model/OrderedSymbol;", "level", "", "unorderedSymbol", "Lcom/larus/business/markdown/api/model/UnorderedSymbol;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class LarkSymbolStrategy implements ListSymbolStrategy {
        @Override // com.larus.business.markdown.api.model.ListSymbolStrategy
        public UnorderedSymbol unorderedSymbol(int level) {
            int i = level % 3;
            if (i == 0) {
                return UnorderedSymbol.DISC;
            }
            if (i == 1) {
                return UnorderedSymbol.CIRCLE;
            }
            return UnorderedSymbol.SQUARE;
        }

        @Override // com.larus.business.markdown.api.model.ListSymbolStrategy
        public OrderedSymbol orderedSymbol(int level) {
            int i = level % 3;
            if (i == 0) {
                return OrderedSymbol.DECIMAL;
            }
            if (i == 1) {
                return OrderedSymbol.LOWERCASE_ALPHABET;
            }
            return OrderedSymbol.LOWERCASE_ROMAN;
        }
    }

    /* compiled from: ListStyle.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/larus/business/markdown/api/model/ListSymbolStrategy$FlowSymbolStrategy;", "Lcom/larus/business/markdown/api/model/ListSymbolStrategy;", "()V", "orderedSymbol", "Lcom/larus/business/markdown/api/model/OrderedSymbol;", "level", "", "unorderedSymbol", "Lcom/larus/business/markdown/api/model/UnorderedSymbol;", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class FlowSymbolStrategy implements ListSymbolStrategy {
        @Override // com.larus.business.markdown.api.model.ListSymbolStrategy
        public UnorderedSymbol unorderedSymbol(int level) {
            if (level == 0) {
                return UnorderedSymbol.DISC;
            }
            return UnorderedSymbol.CIRCLE;
        }

        @Override // com.larus.business.markdown.api.model.ListSymbolStrategy
        public OrderedSymbol orderedSymbol(int level) {
            return OrderedSymbol.DECIMAL;
        }
    }
}
