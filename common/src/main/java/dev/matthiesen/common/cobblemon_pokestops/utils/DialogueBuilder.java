package dev.matthiesen.common.cobblemon_pokestops.utils;

import com.cobblemon.mod.common.api.dialogue.*;
import com.cobblemon.mod.common.api.dialogue.input.*;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class DialogueBuilder {
    private final List<DialoguePage> pages = new ArrayList<>();
    private final Map<String, DialogueSpeaker> speakers = new HashMap<>();

    private ResourceLocation background = Dialogue.Companion.getDEFAULT_BACKGROUND();
    private Function1<ActiveDialogue, Unit> escapeAction = dialogue -> {
        dialogue.close();
        return Unit.INSTANCE;
    };

    private DialogueBuilder() {
    }

    public static DialogueBuilder create() {
        return new DialogueBuilder();
    }

    public static PageBuilder page() {
        return PageBuilder.create();
    }

    public DialogueBuilder background(ResourceLocation background) {
        this.background = Objects.requireNonNull(background, "background");
        return this;
    }

    public DialogueBuilder onEscape(Function1<ActiveDialogue, Unit> escapeAction) {
        this.escapeAction = Objects.requireNonNull(escapeAction, "escapeAction");
        return this;
    }

    public DialogueBuilder onEscape(Consumer<ActiveDialogue> escapeAction) {
        Objects.requireNonNull(escapeAction, "escapeAction");
        return onEscape(dialogue -> {
            escapeAction.accept(dialogue);
            return Unit.INSTANCE;
        });
    }

    public DialogueBuilder speaker(String id, DialogueSpeaker speaker) {
        this.speakers.put(Objects.requireNonNull(id, "id"), Objects.requireNonNull(speaker, "speaker"));
        return this;
    }

    public DialogueBuilder speakers(Map<String, DialogueSpeaker> speakers) {
        this.speakers.putAll(Objects.requireNonNull(speakers, "speakers"));
        return this;
    }

    public DialogueBuilder page(DialoguePage page) {
        this.pages.add(Objects.requireNonNull(page, "page"));
        return this;
    }

    public DialogueBuilder page(Consumer<PageBuilder> configurer) {
        PageBuilder builder = PageBuilder.create();
        configurer.accept(builder);
        return page(builder.build());
    }

    public Dialogue build() {
        return Dialogue.Companion.of(pages, background, escapeAction, speakers);
    }

    public ActiveDialogue send(ServerPlayer player) {
        return sendDialogue(player, build());
    }

    public static Dialogue createDialogue() {
        return create().build();
    }

    public static ActiveDialogue sendDialogue(ServerPlayer player, Dialogue dialogue) {
        return DialogueManager.startDialogue(player, dialogue);
    }

    public static class DialogueOptionBuilder {
        private DialogueText text = new WrappedDialogueText();
        private String value = "";
        private DialogueAction action;
        private DialoguePredicate isVisible;
        private DialoguePredicate isSelectable;

        private DialogueOptionBuilder() {
        }

        public static DialogueOptionBuilder create() {
            return new DialogueOptionBuilder();
        }

        public DialogueOptionBuilder text(DialogueText text) {
            this.text = Objects.requireNonNull(text, "text");
            return this;
        }

        public DialogueOptionBuilder value(String value) {
            this.value = Objects.requireNonNull(value, "value");
            return this;
        }

        public DialogueOptionBuilder action(DialogueAction action) {
            this.action = Objects.requireNonNull(action, "action");
            return this;
        }

        public DialogueOptionBuilder isVisible(DialoguePredicate isVisible) {
            this.isVisible = isVisible;
            return this;
        }

        public DialogueOptionBuilder isSelectable(DialoguePredicate isSelectable) {
            this.isSelectable = isSelectable;
            return this;
        }

        public DialogueOption build() {
            return new DialogueOption(text, value, action, isVisible, isSelectable);
        }

    }

    public static class DialogueOptionsInputBuilder {
        private final List<DialogueOption> options = new ArrayList<>();
        private DialogueTimeout timeout = null;
        private boolean vertical = false;

        private DialogueOptionsInputBuilder() {
        }

        public static DialogueOptionsInputBuilder create() {
            return new DialogueOptionsInputBuilder();
        }

        public DialogueOptionsInputBuilder option(DialogueOption option) {
            options.add(option);
            return this;
        }

        public DialogueOptionsInputBuilder option(Consumer<DialogueOptionBuilder> configurer) {
            DialogueOptionBuilder builder = DialogueOptionBuilder.create();
            configurer.accept(builder);
            return option(builder.build());
        }

        public DialogueOptionsInputBuilder timeout(DialogueTimeout timeout) {
            this.timeout = timeout;
            return this;
        }

        public DialogueOptionsInputBuilder vertical(boolean vertical) {
            this.vertical = vertical;
            return this;
        }

        public DialogueOptionSetInput build() {
            return new DialogueOptionSetInput(options, timeout, vertical);
        }
    }

    public static class PageBuilder {
        private String id = "";
        private String speaker;
        private final List<MutableComponent> lines = new ArrayList<>();
        private String textColor;
        private DialogueInput input = new DialogueNoInput();
        private DialogueGibber gibber;
        private ResourceLocation background;
        // Kotlin expects Iterable<Expression>; we keep Java-side storage untyped to avoid hard coupling.
        private final List<Object> clientActions = new ArrayList<>();
        private Function1<ActiveDialogue, Unit> escapeAction;

        private PageBuilder() {
        }

        public static PageBuilder create() {
            return new PageBuilder();
        }

        public PageBuilder id(String id) {
            this.id = Objects.requireNonNull(id, "id");
            return this;
        }

        public PageBuilder speaker(String speaker) {
            this.speaker = speaker;
            return this;
        }

        public PageBuilder line(String line) {
            this.lines.add(Component.literal(line));
            return this;
        }

        public PageBuilder line(MutableComponent line) {
            this.lines.add(Objects.requireNonNull(line, "line"));
            return this;
        }

        public PageBuilder line(Component line) {
            this.lines.add(Objects.requireNonNull(line, "line").copy());
            return this;
        }

        public PageBuilder lines(Iterable<? extends MutableComponent> lines) {
            for (MutableComponent line : lines) {
                this.lines.add(Objects.requireNonNull(line, "line"));
            }
            return this;
        }

        public PageBuilder textColor(String textColor) {
            this.textColor = textColor;
            return this;
        }

        public PageBuilder input(DialogueInput input) {
            this.input = Objects.requireNonNull(input, "input");
            return this;
        }

        public PageBuilder inputOptions(DialogueOptionSetInput input) {
            this.input = Objects.requireNonNull(input, "input");
            return this;
        }

        public PageBuilder inputOptions(Consumer<DialogueOptionsInputBuilder> configurer) {
            DialogueOptionsInputBuilder builder = DialogueOptionsInputBuilder.create();
            configurer.accept(builder);
            return inputOptions(builder.build());
        }

        public PageBuilder gibber(DialogueGibber gibber) {
            this.gibber = gibber;
            return this;
        }

        public PageBuilder background(ResourceLocation background) {
            this.background = background;
            return this;
        }

        public PageBuilder clientAction(Object action) {
            this.clientActions.add(Objects.requireNonNull(action, "action"));
            return this;
        }

        public PageBuilder onEscape(Function1<ActiveDialogue, Unit> escapeAction) {
            this.escapeAction = escapeAction;
            return this;
        }

        public PageBuilder onEscape(Consumer<ActiveDialogue> escapeAction) {
            Objects.requireNonNull(escapeAction, "escapeAction");
            return onEscape(dialogue -> {
                escapeAction.accept(dialogue);
                return Unit.INSTANCE;
            });
        }

        @SuppressWarnings({"rawtypes", "unchecked"})
        public DialoguePage build() {
            return DialoguePage.Companion.of(
                    id,
                    speaker,
                    lines,
                    textColor,
                    input,
                    gibber,
                    background,
                    (Iterable) clientActions,
                    escapeAction
            );
        }
    }
}
