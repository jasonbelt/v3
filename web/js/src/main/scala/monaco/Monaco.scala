import scala.scalajs.js
import js.annotation._
import js.|

package monaco {

  import org.scalajs.dom.{KeyboardEvent, MouseEvent}
  import org.scalajs.dom.raw.HTMLElement

  @js.native
  trait Thenable[T] extends js.Object {
    @JSName("then")
    def then1[TResult](onfulfilled: js.Function1[T, TResult | Thenable[TResult]] = ???, onrejected: js.Function1[js.Any, TResult | Thenable[TResult]] = ???): Thenable[TResult] = js.native

    @JSName("then")
    def then2[TResult](onfulfilled: js.Function1[T, TResult | Thenable[TResult]] = ???, onrejected: js.Function1[js.Any, Unit] = ???): Thenable[TResult] = js.native
  }

  @js.native
  trait IDisposable extends js.Object {
    def dispose(): Unit = js.native
  }

  @js.native
  trait IEvent[T] extends js.Object {
    def apply(listener: js.Function1[T, Any], thisArg: js.Any = ???): IDisposable = js.native
  }

  @js.native
  @JSGlobal("monaco.Emitter")
  class Emitter[T] extends js.Object {
    var event: IEvent[T] = js.native

    def fire(event: T = ???): Unit = js.native

    def dispose(): Unit = js.native
  }

  @js.native
  sealed trait Severity extends js.Object {
  }

  @js.native
  @JSGlobal("monaco.Severity")
  object Severity extends js.Object {
    var Ignore: Severity = js.native
    var Info: Severity = js.native
    var Warning: Severity = js.native
    var Error: Severity = js.native

    @JSBracketAccess
    def apply(value: Severity): String = js.native
  }

  @js.native
  trait TValueCallback[T] extends js.Object {
    def apply(value: T): Unit = js.native
  }

  @js.native
  trait ProgressCallback extends js.Object {
    def apply(progress: js.Any): js.Dynamic = js.native
  }

  @js.native
  @JSGlobal("monaco.Promise")
  class Promise[V] protected() extends js.Object {
    def this(init: js.Function3[TValueCallback[V], js.Function1[js.Any, Unit], ProgressCallback, Unit], oncancel: js.Any = ???) = this()

    @JSName("then")
    def then1[U](success: js.Function1[V, Promise[U]] = ???, error: js.Function1[js.Any, Promise[U]] = ???, progress: ProgressCallback = ???): Promise[U] = js.native

    @JSName("then")
    def then2[U](success: js.Function1[V, Promise[U]] = ???, error: js.Function1[js.Any, Promise[U] | U] = ???, progress: ProgressCallback = ???): Promise[U] = js.native

    @JSName("then")
    def then3[U](success: js.Function1[V, Promise[U]] = ???, error: js.Function1[js.Any, U] = ???, progress: ProgressCallback = ???): Promise[U] = js.native

    @JSName("then")
    def then4[U](success: js.Function1[V, Promise[U]] = ???, error: js.Function1[js.Any, Unit] = ???, progress: ProgressCallback = ???): Promise[U] = js.native

    @JSName("then")
    def then5[U](success: js.Function1[V, Promise[U] | U] = ???, error: js.Function1[js.Any, Promise[U]] = ???, progress: ProgressCallback = ???): Promise[U] = js.native

    @JSName("then")
    def then6[U](success: js.Function1[V, Promise[U] | U] = ???, error: js.Function1[js.Any, Promise[U] | U] = ???, progress: ProgressCallback = ???): Promise[U] = js.native

    @JSName("then")
    def then7[U](success: js.Function1[V, Promise[U] | U] = ???, error: js.Function1[js.Any, U] = ???, progress: ProgressCallback = ???): Promise[U] = js.native

    @JSName("then")
    def then8[U](success: js.Function1[V, Promise[U] | U] = ???, error: js.Function1[js.Any, Unit] = ???, progress: ProgressCallback = ???): Promise[U] = js.native

    @JSName("then")
    def then9[U](success: js.Function1[V, U] = ???, error: js.Function1[js.Any, Promise[U]] = ???, progress: ProgressCallback = ???): Promise[U] = js.native

    @JSName("then")
    def then10[U](success: js.Function1[V, U] = ???, error: js.Function1[js.Any, Promise[U] | U] = ???, progress: ProgressCallback = ???): Promise[U] = js.native

    @JSName("then")
    def then11[U](success: js.Function1[V, U] = ???, error: js.Function1[js.Any, U] = ???, progress: ProgressCallback = ???): Promise[U] = js.native

    @JSName("then")
    def then12[U](success: js.Function1[V, U] = ???, error: js.Function1[js.Any, Unit] = ???, progress: ProgressCallback = ???): Promise[U] = js.native

    def done(success: js.Function1[V, Unit] = ???, error: js.Function1[js.Any, Any] = ???, progress: ProgressCallback = ???): Unit = js.native

    def cancel(): Unit = js.native
  }

  @js.native
  @JSGlobal("monaco.Promise")
  object Promise extends js.Object {
    def as[ValueType](value: ValueType): Promise[ValueType] = js.native

    def is(value: js.Any): Boolean = js.native

    def timeout(delay: Double): Promise[Unit] = js.native

    def join[ValueType](promises: js.Array[Promise[ValueType]]): Promise[js.Array[ValueType]] = js.native

    def join[ValueType](promises: js.Array[Thenable[ValueType]]): Thenable[js.Array[ValueType]] = js.native

    def join[ValueType](promises: js.Dictionary[Promise[ValueType]]): Promise[js.Dictionary[ValueType]] = js.native

    def any[ValueType](promises: js.Array[Promise[ValueType]]): Promise[js.Any] = js.native

    def wrap[ValueType](value: Thenable[ValueType]): Promise[ValueType] = js.native

    def wrap[ValueType](value: ValueType): Promise[ValueType] = js.native

    def wrapError[ValueType](error: js.Any): Promise[ValueType] = js.native
  }

  @js.native
  @JSGlobal("monaco.CancellationTokenSource")
  class CancellationTokenSource extends js.Object {
    var token: CancellationToken = js.native

    def cancel(): Unit = js.native

    def dispose(): Unit = js.native
  }

  @js.native
  trait CancellationToken extends js.Object {
    var isCancellationRequested: Boolean = js.native
    var onCancellationRequested: IEvent[js.Any] = js.native
  }

  @js.native
  @JSGlobal("monaco.Uri")
  class Uri extends js.Object {
    var scheme: String = js.native
    var authority: String = js.native
    var path: String = js.native
    var query: String = js.native
    var fragment: String = js.native
    var fsPath: String = js.native

    def `with`(change: js.Any): Uri = js.native

    def toString(skipEncoding: Boolean = ???): String = js.native

    def toJSON(): js.Dynamic = js.native
  }

  @js.native
  @JSGlobal("monaco.Uri")
  object Uri extends js.Object {
    def isUri(thing: js.Any): Boolean = js.native

    def parse(value: String): Uri = js.native

    def file(path: String): Uri = js.native

    def from(components: js.Any): Uri = js.native

    def revive(data: js.Any): Uri = js.native
  }

  @js.native
  sealed trait KeyCode extends js.Object {
  }

  @js.native
  @JSGlobal("monaco.KeyCode")
  object KeyCode extends js.Object {
    var Unknown: KeyCode = js.native
    var Backspace: KeyCode = js.native
    var Tab: KeyCode = js.native
    var Enter: KeyCode = js.native
    var Shift: KeyCode = js.native
    var Ctrl: KeyCode = js.native
    var Alt: KeyCode = js.native
    var PauseBreak: KeyCode = js.native
    var CapsLock: KeyCode = js.native
    var Escape: KeyCode = js.native
    var Space: KeyCode = js.native
    var PageUp: KeyCode = js.native
    var PageDown: KeyCode = js.native
    var End: KeyCode = js.native
    var Home: KeyCode = js.native
    var LeftArrow: KeyCode = js.native
    var UpArrow: KeyCode = js.native
    var RightArrow: KeyCode = js.native
    var DownArrow: KeyCode = js.native
    var Insert: KeyCode = js.native
    var Delete: KeyCode = js.native
    var KEY_0: KeyCode = js.native
    var KEY_1: KeyCode = js.native
    var KEY_2: KeyCode = js.native
    var KEY_3: KeyCode = js.native
    var KEY_4: KeyCode = js.native
    var KEY_5: KeyCode = js.native
    var KEY_6: KeyCode = js.native
    var KEY_7: KeyCode = js.native
    var KEY_8: KeyCode = js.native
    var KEY_9: KeyCode = js.native
    var KEY_A: KeyCode = js.native
    var KEY_B: KeyCode = js.native
    var KEY_C: KeyCode = js.native
    var KEY_D: KeyCode = js.native
    var KEY_E: KeyCode = js.native
    var KEY_F: KeyCode = js.native
    var KEY_G: KeyCode = js.native
    var KEY_H: KeyCode = js.native
    var KEY_I: KeyCode = js.native
    var KEY_J: KeyCode = js.native
    var KEY_K: KeyCode = js.native
    var KEY_L: KeyCode = js.native
    var KEY_M: KeyCode = js.native
    var KEY_N: KeyCode = js.native
    var KEY_O: KeyCode = js.native
    var KEY_P: KeyCode = js.native
    var KEY_Q: KeyCode = js.native
    var KEY_R: KeyCode = js.native
    var KEY_S: KeyCode = js.native
    var KEY_T: KeyCode = js.native
    var KEY_U: KeyCode = js.native
    var KEY_V: KeyCode = js.native
    var KEY_W: KeyCode = js.native
    var KEY_X: KeyCode = js.native
    var KEY_Y: KeyCode = js.native
    var KEY_Z: KeyCode = js.native
    var Meta: KeyCode = js.native
    var ContextMenu: KeyCode = js.native
    var F1: KeyCode = js.native
    var F2: KeyCode = js.native
    var F3: KeyCode = js.native
    var F4: KeyCode = js.native
    var F5: KeyCode = js.native
    var F6: KeyCode = js.native
    var F7: KeyCode = js.native
    var F8: KeyCode = js.native
    var F9: KeyCode = js.native
    var F10: KeyCode = js.native
    var F11: KeyCode = js.native
    var F12: KeyCode = js.native
    var F13: KeyCode = js.native
    var F14: KeyCode = js.native
    var F15: KeyCode = js.native
    var F16: KeyCode = js.native
    var F17: KeyCode = js.native
    var F18: KeyCode = js.native
    var F19: KeyCode = js.native
    var NumLock: KeyCode = js.native
    var ScrollLock: KeyCode = js.native
    var US_SEMICOLON: KeyCode = js.native
    var US_EQUAL: KeyCode = js.native
    var US_COMMA: KeyCode = js.native
    var US_MINUS: KeyCode = js.native
    var US_DOT: KeyCode = js.native
    var US_SLASH: KeyCode = js.native
    var US_BACKTICK: KeyCode = js.native
    var US_OPEN_SQUARE_BRACKET: KeyCode = js.native
    var US_BACKSLASH: KeyCode = js.native
    var US_CLOSE_SQUARE_BRACKET: KeyCode = js.native
    var US_QUOTE: KeyCode = js.native
    var OEM_8: KeyCode = js.native
    var OEM_102: KeyCode = js.native
    var NUMPAD_0: KeyCode = js.native
    var NUMPAD_1: KeyCode = js.native
    var NUMPAD_2: KeyCode = js.native
    var NUMPAD_3: KeyCode = js.native
    var NUMPAD_4: KeyCode = js.native
    var NUMPAD_5: KeyCode = js.native
    var NUMPAD_6: KeyCode = js.native
    var NUMPAD_7: KeyCode = js.native
    var NUMPAD_8: KeyCode = js.native
    var NUMPAD_9: KeyCode = js.native
    var NUMPAD_MULTIPLY: KeyCode = js.native
    var NUMPAD_ADD: KeyCode = js.native
    var NUMPAD_SEPARATOR: KeyCode = js.native
    var NUMPAD_SUBTRACT: KeyCode = js.native
    var NUMPAD_DECIMAL: KeyCode = js.native
    var NUMPAD_DIVIDE: KeyCode = js.native
    var MAX_VALUE: KeyCode = js.native

    @JSBracketAccess
    def apply(value: KeyCode): String = js.native
  }

  @js.native
  @JSGlobal("monaco.KeyMod")
  class KeyMod extends js.Object {
  }

  @js.native
  @JSGlobal("monaco.KeyMod")
  object KeyMod extends js.Object {
    var CtrlCmd: Double = js.native
    var Shift: Double = js.native
    var Alt: Double = js.native
    var WinCtrl: Double = js.native

    def chord(firstPart: Double, secondPart: Double): Double = js.native
  }

  @js.native
  @JSGlobal("monaco.Keybinding")
  class Keybinding protected() extends js.Object {
    def this(keybinding: Double) = this()

    var value: Double = js.native

    def equals(other: Keybinding): Boolean = js.native

    def hasCtrlCmd(): Boolean = js.native

    def hasShift(): Boolean = js.native

    def hasAlt(): Boolean = js.native

    def hasWinCtrl(): Boolean = js.native

    def isModifierKey(): Boolean = js.native

    def getKeyCode(): KeyCode = js.native
  }

  @js.native
  trait IKeyboardEvent extends js.Object {
    var browserEvent: KeyboardEvent = js.native
    var target: HTMLElement = js.native
    var ctrlKey: Boolean = js.native
    var shiftKey: Boolean = js.native
    var altKey: Boolean = js.native
    var metaKey: Boolean = js.native
    var keyCode: KeyCode = js.native

    def toKeybinding(): Keybinding = js.native

    def equals(keybinding: Double): Boolean = js.native

    def preventDefault(): Unit = js.native

    def stopPropagation(): Unit = js.native
  }

  @js.native
  trait IMouseEvent extends js.Object {
    var browserEvent: MouseEvent = js.native
    var leftButton: Boolean = js.native
    var middleButton: Boolean = js.native
    var rightButton: Boolean = js.native
    var target: HTMLElement = js.native
    var detail: Double = js.native
    var posx: Double = js.native
    var posy: Double = js.native
    var ctrlKey: Boolean = js.native
    var shiftKey: Boolean = js.native
    var altKey: Boolean = js.native
    var metaKey: Boolean = js.native
    var timestamp: Double = js.native

    def preventDefault(): Unit = js.native

    def stopPropagation(): Unit = js.native
  }

  @js.native
  trait IScrollEvent extends js.Object {
    var scrollTop: Double = js.native
    var scrollLeft: Double = js.native
    var scrollWidth: Double = js.native
    var scrollHeight: Double = js.native
    var scrollTopChanged: Boolean = js.native
    var scrollLeftChanged: Boolean = js.native
    var scrollWidthChanged: Boolean = js.native
    var scrollHeightChanged: Boolean = js.native
  }

  @js.native
  trait IPosition extends js.Object {
    var lineNumber: Double = js.native
    var column: Double = js.native
  }

  @js.native
  trait IRange extends js.Object {
    var startLineNumber: Double = js.native
    var startColumn: Double = js.native
    var endLineNumber: Double = js.native
    var endColumn: Double = js.native
  }

  @js.native
  trait ISelection extends js.Object {
    var selectionStartLineNumber: Double = js.native
    var selectionStartColumn: Double = js.native
    var positionLineNumber: Double = js.native
    var positionColumn: Double = js.native
  }

  @js.native
  @JSGlobal("monaco.Position")
  class Position protected() extends js.Object {
    def this(lineNumber: Double, column: Double) = this()

    var lineNumber: Double = js.native
    var column: Double = js.native

    def equals(other: IPosition): Boolean = js.native

    def isBefore(other: IPosition): Boolean = js.native

    def isBeforeOrEqual(other: IPosition): Boolean = js.native

    override def clone(): Position = js.native

    override def toString(): String = js.native
  }

  @js.native
  @JSGlobal("monaco.Position")
  object Position extends js.Object {
    def equals(a: IPosition, b: IPosition): Boolean = js.native

    def isBefore(a: IPosition, b: IPosition): Boolean = js.native

    def isBeforeOrEqual(a: IPosition, b: IPosition): Boolean = js.native

    def compare(a: IPosition, b: IPosition): Double = js.native

    def lift(pos: IPosition): Position = js.native

    def isIPosition(obj: js.Any): Boolean = js.native
  }

  @js.native
  @JSGlobal("monaco.Range")
  class Range protected() extends js.Object {
    def this(startLineNumber: Double, startColumn: Double, endLineNumber: Double, endColumn: Double) = this()

    var startLineNumber: Double = js.native
    var startColumn: Double = js.native
    var endLineNumber: Double = js.native
    var endColumn: Double = js.native

    def isEmpty(): Boolean = js.native

    def containsPosition(position: IPosition): Boolean = js.native

    def containsRange(range: IRange): Boolean = js.native

    def plusRange(range: IRange): Range = js.native

    def intersectRanges(range: IRange): Range = js.native

    def equalsRange(other: IRange): Boolean = js.native

    def getEndPosition(): Position = js.native

    def getStartPosition(): Position = js.native

    def cloneRange(): Range = js.native

    override def toString(): String = js.native

    def setEndPosition(endLineNumber: Double, endColumn: Double): Range = js.native

    def setStartPosition(startLineNumber: Double, startColumn: Double): Range = js.native

    def collapseToStart(): Range = js.native
  }

  @js.native
  @JSGlobal("monaco.Range")
  object Range extends js.Object {
    def isEmpty(range: IRange): Boolean = js.native

    def containsPosition(range: IRange, position: IPosition): Boolean = js.native

    def containsRange(range: IRange, otherRange: IRange): Boolean = js.native

    def plusRange(a: IRange, b: IRange): Range = js.native

    def intersectRanges(a: IRange, b: IRange): Range = js.native

    def equalsRange(a: IRange, b: IRange): Boolean = js.native

    def collapseToStart(range: IRange): Range = js.native

    def lift(range: IRange): Range = js.native

    def isIRange(obj: js.Any): Boolean = js.native

    def areIntersectingOrTouching(a: IRange, b: IRange): Boolean = js.native

    def compareRangesUsingStarts(a: IRange, b: IRange): Double = js.native

    def compareRangesUsingEnds(a: IRange, b: IRange): Double = js.native

    def spansMultipleLines(range: IRange): Boolean = js.native
  }

  @js.native
  @JSGlobal("monaco.Selection")
  class Selection protected() extends Range {
    def this(selectionStartLineNumber: Double, selectionStartColumn: Double, positionLineNumber: Double, positionColumn: Double) = this()

    var selectionStartLineNumber: Double = js.native
    var selectionStartColumn: Double = js.native
    var positionLineNumber: Double = js.native
    var positionColumn: Double = js.native

    override def clone(): Selection = js.native

    override def toString(): String = js.native

    def equalsSelection(other: ISelection): Boolean = js.native

    def getDirection(): SelectionDirection = js.native

    override def setEndPosition(endLineNumber: Double, endColumn: Double): Selection = js.native

    override def setStartPosition(startLineNumber: Double, startColumn: Double): Selection = js.native
  }

  @js.native
  @JSGlobal("monaco.Selection")
  object Selection extends js.Object {
    def selectionsEqual(a: ISelection, b: ISelection): Boolean = js.native

    def liftSelection(sel: ISelection): Selection = js.native

    def selectionsArrEqual(a: js.Array[ISelection], b: js.Array[ISelection]): Boolean = js.native

    def isISelection(obj: js.Any): ISelection = js.native

    def createWithDirection(startLineNumber: Double, startColumn: Double, endLineNumber: Double, endColumn: Double, direction: SelectionDirection): Selection = js.native
  }

  @js.native
  sealed trait SelectionDirection extends js.Object {
  }

  @js.native
  @JSGlobal("monaco.SelectionDirection")
  object SelectionDirection extends js.Object {
    var LTR: SelectionDirection = js.native
    var RTL: SelectionDirection = js.native

    @JSBracketAccess
    def apply(value: SelectionDirection): String = js.native
  }

  @js.native
  @JSGlobal("monaco.Token")
  class Token protected() extends js.Object {
    def this(offset: Double, `type`: String, language: String) = this()

    var _tokenBrand: Unit = js.native
    var offset: Double = js.native
    var `type`: String = js.native
    var language: String = js.native

    override def toString(): String = js.native
  }

  package editor {

    import monaco.Monaco.MarkedString
    import monaco.editor.Editor.{BuiltinTheme, LineNumbersOption}
    import org.scalajs.dom.Element

    @js.native
    trait IDiffNavigator extends js.Object {
      var revealFirst: Boolean = js.native

      def canNavigate(): Boolean = js.native

      def next(): Unit = js.native

      def previous(): Unit = js.native

      def dispose(): Unit = js.native
    }

    @js.native
    trait IDiffNavigatorOptions extends js.Object {
      var followsCaret: Boolean = js.native
      var ignoreCharChanges: Boolean = js.native
      var alwaysRevealFirst: Boolean = js.native
    }

    @js.native
    trait ITheme extends js.Object {
      var base: BuiltinTheme = js.native
      var inherit: Boolean = js.native
      var rules: js.Array[IThemeRule] = js.native
    }

    @js.native
    trait IThemeRule extends js.Object {
      var token: String = js.native
      var foreground: String = js.native
      var background: String = js.native
      var fontStyle: String = js.native
    }

    @js.native
    trait MonacoWebWorker[T] extends js.Object {
      def dispose(): Unit = js.native

      def getProxy(): Promise[T] = js.native

      def withSyncedResources(resources: js.Array[Uri]): Promise[T] = js.native
    }

    @js.native
    trait IWebWorkerOptions extends js.Object {
      var moduleId: String = js.native
      var createData: js.Any = js.native
      var label: String = js.native
    }

    @js.native
    trait IEditorConstructionOptions extends ICodeEditorWidgetCreationOptions {
      var value: String = js.native
      var language: String = js.native
    }

    @js.native
    trait IDiffEditorConstructionOptions extends IDiffEditorOptions {
    }

    @js.native
    trait IStandaloneCodeEditor extends ICodeEditor {
      def addCommand(keybinding: Double, handler: ICommandHandler, context: String): String = js.native

      def createContextKey[T](key: String, defaultValue: T): IContextKey[T] = js.native

      def addAction(descriptor: IActionDescriptor): IDisposable = js.native
    }

    @js.native
    trait IStandaloneDiffEditor extends IDiffEditor {
      def addCommand(keybinding: Double, handler: ICommandHandler, context: String): String = js.native

      def createContextKey[T](key: String, defaultValue: T): IContextKey[T] = js.native

      def addAction(descriptor: IActionDescriptor): IDisposable = js.native

      override def getOriginalEditor(): IStandaloneCodeEditor = js.native

      override def getModifiedEditor(): IStandaloneCodeEditor = js.native
    }

    @js.native
    trait ICommandHandler extends js.Object {
      def apply(args: js.Any*): Unit = js.native
    }

    @js.native
    trait IContextKey[T] extends js.Object {
      def set(value: T): Unit = js.native

      def reset(): Unit = js.native

      def get(): T = js.native
    }

    @js.native
    trait IEditorOverrideServices extends js.Object {
    }

    @js.native
    trait IMarkerData extends js.Object {
      var code: String = js.native
      var severity: Severity = js.native
      var message: String = js.native
      var source: String = js.native
      var startLineNumber: Double = js.native
      var startColumn: Double = js.native
      var endLineNumber: Double = js.native
      var endColumn: Double = js.native
    }

    @js.native
    trait IColorizerOptions extends js.Object {
      var tabSize: Double = js.native
    }

    @js.native
    trait IColorizerElementOptions extends IColorizerOptions {
      var theme: String = js.native
      var mimeType: String = js.native
    }

    @js.native
    sealed trait ScrollbarVisibility extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.ScrollbarVisibility")
    object ScrollbarVisibility extends js.Object {
      var Auto: ScrollbarVisibility = js.native
      var Hidden: ScrollbarVisibility = js.native
      var Visible: ScrollbarVisibility = js.native

      @JSBracketAccess
      def apply(value: ScrollbarVisibility): String = js.native
    }

    @js.native
    trait IEditorScrollbarOptions extends js.Object {
      var arrowSize: Double = js.native
      var vertical: String = js.native
      var horizontal: String = js.native
      var useShadows: Boolean = js.native
      var verticalHasArrows: Boolean = js.native
      var horizontalHasArrows: Boolean = js.native
      var handleMouseWheel: Boolean = js.native
      var horizontalScrollbarSize: Double = js.native
      var verticalScrollbarSize: Double = js.native
      var verticalSliderSize: Double = js.native
      var horizontalSliderSize: Double = js.native
    }

    @js.native
    sealed trait WrappingIndent extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.WrappingIndent")
    object WrappingIndent extends js.Object {
      var None: WrappingIndent = js.native
      var Same: WrappingIndent = js.native
      var Indent: WrappingIndent = js.native

      @JSBracketAccess
      def apply(value: WrappingIndent): String = js.native
    }

    @js.native
    trait IEditorOptions extends js.Object {
      var experimentalScreenReader: Boolean = js.native
      var ariaLabel: String = js.native
      var rulers: js.Array[Double] = js.native
      var wordSeparators: String = js.native
      var selectionClipboard: Boolean = js.native
      var lineNumbers: LineNumbersOption = js.native
      var selectOnLineNumbers: Boolean = js.native
      var lineNumbersMinChars: Double = js.native
      var glyphMargin: Boolean = js.native
      var lineDecorationsWidth: Double | String = js.native
      var revealHorizontalRightPadding: Double = js.native
      var roundedSelection: Boolean = js.native
      var theme: String = js.native
      var readOnly: Boolean = js.native
      var scrollbar: IEditorScrollbarOptions = js.native
      var fixedOverflowWidgets: Boolean = js.native
      var overviewRulerLanes: Double = js.native
      var cursorBlinking: String = js.native
      var mouseWheelZoom: Boolean = js.native
      var cursorStyle: String = js.native
      var fontLigatures: Boolean = js.native
      var disableTranslate3d: Boolean = js.native
      var disableMonospaceOptimizations: Boolean = js.native
      var hideCursorInOverviewRuler: Boolean = js.native
      var scrollBeyondLastLine: Boolean = js.native
      var automaticLayout: Boolean = js.native
      var wrappingColumn: Double = js.native
      var wordWrap: Boolean = js.native
      var wrappingIndent: String = js.native
      var wordWrapBreakBeforeCharacters: String = js.native
      var wordWrapBreakAfterCharacters: String = js.native
      var wordWrapBreakObtrusiveCharacters: String = js.native
      var stopRenderingLineAfter: Double = js.native
      var hover: Boolean = js.native
      var contextmenu: Boolean = js.native
      var mouseWheelScrollSensitivity: Double = js.native
      var quickSuggestions: Boolean = js.native
      var quickSuggestionsDelay: Double = js.native
      var parameterHints: Boolean = js.native
      var iconsInSuggestions: Boolean = js.native
      var autoClosingBrackets: Boolean = js.native
      var formatOnType: Boolean = js.native
      var formatOnPaste: Boolean = js.native
      var suggestOnTriggerCharacters: Boolean = js.native
      var acceptSuggestionOnEnter: Boolean = js.native
      var acceptSuggestionOnCommitCharacter: Boolean = js.native
      var snippetSuggestions: String = js.native
      var emptySelectionClipboard: Boolean = js.native
      var tabCompletion: Boolean = js.native
      var wordBasedSuggestions: Boolean = js.native
      var suggestFontSize: Double = js.native
      var suggestLineHeight: Double = js.native
      var selectionHighlight: Boolean = js.native
      var codeLens: Boolean = js.native
      var folding: Boolean = js.native
      var renderWhitespace: String = js.native
      var renderControlCharacters: Boolean = js.native
      var renderIndentGuides: Boolean = js.native
      var renderLineHighlight: String = js.native
      var useTabStops: Boolean = js.native
      var fontFamily: String = js.native
      var fontWeight: String = js.native
      var fontSize: Double = js.native
      var lineHeight: Double = js.native
    }

    @js.native
    trait IDiffEditorOptions extends IEditorOptions {
      var enableSplitViewResizing: Boolean = js.native
      var renderSideBySide: Boolean = js.native
      var ignoreTrimWhitespace: Boolean = js.native
      var renderIndicators: Boolean = js.native
      var originalEditable: Boolean = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.InternalEditorScrollbarOptions")
    class InternalEditorScrollbarOptions extends js.Object {
      var _internalEditorScrollbarOptionsBrand: Unit = js.native
      var arrowSize: Double = js.native
      var vertical: ScrollbarVisibility = js.native
      var horizontal: ScrollbarVisibility = js.native
      var useShadows: Boolean = js.native
      var verticalHasArrows: Boolean = js.native
      var horizontalHasArrows: Boolean = js.native
      var handleMouseWheel: Boolean = js.native
      var horizontalScrollbarSize: Double = js.native
      var horizontalSliderSize: Double = js.native
      var verticalScrollbarSize: Double = js.native
      var verticalSliderSize: Double = js.native
      var mouseWheelScrollSensitivity: Double = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.EditorWrappingInfo")
    class EditorWrappingInfo extends js.Object {
      var _editorWrappingInfoBrand: Unit = js.native
      var isViewportWrapping: Boolean = js.native
      var wrappingColumn: Double = js.native
      var wrappingIndent: WrappingIndent = js.native
      var wordWrapBreakBeforeCharacters: String = js.native
      var wordWrapBreakAfterCharacters: String = js.native
      var wordWrapBreakObtrusiveCharacters: String = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.InternalEditorViewOptions")
    class InternalEditorViewOptions extends js.Object {
      var _internalEditorViewOptionsBrand: Unit = js.native
      var theme: String = js.native
      var canUseTranslate3d: Boolean = js.native
      var disableMonospaceOptimizations: Boolean = js.native
      var experimentalScreenReader: Boolean = js.native
      var rulers: js.Array[Double] = js.native
      var ariaLabel: String = js.native
      var renderLineNumbers: Boolean = js.native
      var renderCustomLineNumbers: js.Function1[Double, String] = js.native
      var renderRelativeLineNumbers: Boolean = js.native
      var selectOnLineNumbers: Boolean = js.native
      var glyphMargin: Boolean = js.native
      var revealHorizontalRightPadding: Double = js.native
      var roundedSelection: Boolean = js.native
      var overviewRulerLanes: Double = js.native
      var cursorBlinking: TextEditorCursorBlinkingStyle = js.native
      var mouseWheelZoom: Boolean = js.native
      var cursorStyle: TextEditorCursorStyle = js.native
      var hideCursorInOverviewRuler: Boolean = js.native
      var scrollBeyondLastLine: Boolean = js.native
      var editorClassName: String = js.native
      var stopRenderingLineAfter: Double = js.native
      var renderWhitespace: String = js.native
      var renderControlCharacters: Boolean = js.native
      var renderIndentGuides: Boolean = js.native
      var renderLineHighlight: String = js.native
      var scrollbar: InternalEditorScrollbarOptions = js.native
      var fixedOverflowWidgets: Boolean = js.native
    }

    @js.native
    trait IViewConfigurationChangedEvent extends js.Object {
      var theme: Boolean = js.native
      var canUseTranslate3d: Boolean = js.native
      var disableMonospaceOptimizations: Boolean = js.native
      var experimentalScreenReader: Boolean = js.native
      var rulers: Boolean = js.native
      var ariaLabel: Boolean = js.native
      var renderLineNumbers: Boolean = js.native
      var renderCustomLineNumbers: Boolean = js.native
      var renderRelativeLineNumbers: Boolean = js.native
      var selectOnLineNumbers: Boolean = js.native
      var glyphMargin: Boolean = js.native
      var revealHorizontalRightPadding: Boolean = js.native
      var roundedSelection: Boolean = js.native
      var overviewRulerLanes: Boolean = js.native
      var cursorBlinking: Boolean = js.native
      var mouseWheelZoom: Boolean = js.native
      var cursorStyle: Boolean = js.native
      var hideCursorInOverviewRuler: Boolean = js.native
      var scrollBeyondLastLine: Boolean = js.native
      var editorClassName: Boolean = js.native
      var stopRenderingLineAfter: Boolean = js.native
      var renderWhitespace: Boolean = js.native
      var renderControlCharacters: Boolean = js.native
      var renderIndentGuides: Boolean = js.native
      var renderLineHighlight: Boolean = js.native
      var scrollbar: Boolean = js.native
      var fixedOverflowWidgets: Boolean = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.EditorContribOptions")
    class EditorContribOptions extends js.Object {
      var selectionClipboard: Boolean = js.native
      var hover: Boolean = js.native
      var contextmenu: Boolean = js.native
      var quickSuggestions: Boolean = js.native
      var quickSuggestionsDelay: Double = js.native
      var parameterHints: Boolean = js.native
      var iconsInSuggestions: Boolean = js.native
      var formatOnType: Boolean = js.native
      var formatOnPaste: Boolean = js.native
      var suggestOnTriggerCharacters: Boolean = js.native
      var acceptSuggestionOnEnter: Boolean = js.native
      var acceptSuggestionOnCommitCharacter: Boolean = js.native
      var snippetSuggestions: String = js.native
      var emptySelectionClipboard: Boolean = js.native
      var tabCompletion: Boolean = js.native
      var wordBasedSuggestions: Boolean = js.native
      var suggestFontSize: Double = js.native
      var suggestLineHeight: Double = js.native
      var selectionHighlight: Boolean = js.native
      var codeLens: Boolean = js.native
      var folding: Boolean = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.InternalEditorOptions")
    class InternalEditorOptions extends js.Object {
      var _internalEditorOptionsBrand: Unit = js.native
      var lineHeight: Double = js.native
      var readOnly: Boolean = js.native
      var wordSeparators: String = js.native
      var autoClosingBrackets: Boolean = js.native
      var useTabStops: Boolean = js.native
      var tabFocusMode: Boolean = js.native
      var layoutInfo: EditorLayoutInfo = js.native
      var fontInfo: FontInfo = js.native
      var viewInfo: InternalEditorViewOptions = js.native
      var wrappingInfo: EditorWrappingInfo = js.native
      var contribInfo: EditorContribOptions = js.native
    }

    @js.native
    trait IConfigurationChangedEvent extends js.Object {
      var lineHeight: Boolean = js.native
      var readOnly: Boolean = js.native
      var wordSeparators: Boolean = js.native
      var autoClosingBrackets: Boolean = js.native
      var useTabStops: Boolean = js.native
      var tabFocusMode: Boolean = js.native
      var layoutInfo: Boolean = js.native
      var fontInfo: Boolean = js.native
      var viewInfo: IViewConfigurationChangedEvent = js.native
      var wrappingInfo: Boolean = js.native
      var contribInfo: Boolean = js.native
    }

    @js.native
    sealed trait OverviewRulerLane extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.OverviewRulerLane")
    object OverviewRulerLane extends js.Object {
      var Left: OverviewRulerLane = js.native
      var Center: OverviewRulerLane = js.native
      var Right: OverviewRulerLane = js.native
      var Full: OverviewRulerLane = js.native

      @JSBracketAccess
      def apply(value: OverviewRulerLane): String = js.native
    }

    @js.native
    trait IModelDecorationOverviewRulerOptions extends js.Object {
      var color: String = js.native
      var darkColor: String = js.native
      var position: OverviewRulerLane = js.native
    }

    @js.native
    trait IModelDecorationOptions extends js.Object {
      var stickiness: TrackedRangeStickiness = js.native
      var className: String = js.native
      var glyphMarginHoverMessage: MarkedString | js.Array[MarkedString] = js.native
      var hoverMessage: MarkedString | js.Array[MarkedString] = js.native
      var isWholeLine: Boolean = js.native
      var showInOverviewRuler: String = js.native
      var overviewRuler: IModelDecorationOverviewRulerOptions = js.native
      var glyphMarginClassName: String = js.native
      var linesDecorationsClassName: String = js.native
      var marginClassName: String = js.native
      var inlineClassName: String = js.native
      var beforeContentClassName: String = js.native
      var afterContentClassName: String = js.native
    }

    @js.native
    trait IModelDeltaDecoration extends js.Object {
      var range: IRange = js.native
      var options: IModelDecorationOptions = js.native
    }

    @js.native
    trait IModelDecoration extends js.Object {
      var id: String = js.native
      var ownerId: Double = js.native
      var range: Range = js.native
      var options: IModelDecorationOptions = js.native
      var isForValidation: Boolean = js.native
    }

    @js.native
    trait IWordAtPosition extends js.Object {
      var word: String = js.native
      var startColumn: Double = js.native
      var endColumn: Double = js.native
    }

    @js.native
    sealed trait EndOfLinePreference extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.EndOfLinePreference")
    object EndOfLinePreference extends js.Object {
      var TextDefined: EndOfLinePreference = js.native
      var LF: EndOfLinePreference = js.native
      var CRLF: EndOfLinePreference = js.native

      @JSBracketAccess
      def apply(value: EndOfLinePreference): String = js.native
    }

    @js.native
    sealed trait DefaultEndOfLine extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.DefaultEndOfLine")
    object DefaultEndOfLine extends js.Object {
      var LF: DefaultEndOfLine = js.native
      var CRLF: DefaultEndOfLine = js.native

      @JSBracketAccess
      def apply(value: DefaultEndOfLine): String = js.native
    }

    @js.native
    sealed trait EndOfLineSequence extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.EndOfLineSequence")
    object EndOfLineSequence extends js.Object {
      var LF: EndOfLineSequence = js.native
      var CRLF: EndOfLineSequence = js.native

      @JSBracketAccess
      def apply(value: EndOfLineSequence): String = js.native
    }

    @js.native
    trait ISingleEditOperationIdentifier extends js.Object {
      var major: Double = js.native
      var minor: Double = js.native
    }

    @js.native
    trait IEditOperationBuilder extends js.Object {
      def addEditOperation(range: Range, text: String): Unit = js.native

      def trackSelection(selection: Selection, trackPreviousOnEmpty: Boolean = ???): String = js.native
    }

    @js.native
    trait ICursorStateComputerData extends js.Object {
      def getInverseEditOperations(): js.Array[IIdentifiedSingleEditOperation] = js.native

      def getTrackedSelection(id: String): Selection = js.native
    }

    @js.native
    trait ICommand extends js.Object {
      def getEditOperations(model: ITokenizedModel, builder: IEditOperationBuilder): Unit = js.native

      def computeCursorState(model: ITokenizedModel, helper: ICursorStateComputerData): Selection = js.native
    }

    @js.native
    trait ISingleEditOperation extends js.Object {
      var range: IRange = js.native
      var text: String = js.native
      var forceMoveMarkers: Boolean = js.native
    }

    @js.native
    trait IIdentifiedSingleEditOperation extends js.Object {
      var identifier: ISingleEditOperationIdentifier = js.native
      var range: Range = js.native
      var text: String = js.native
      var forceMoveMarkers: Boolean = js.native
      var isAutoWhitespaceEdit: Boolean = js.native
    }

    @js.native
    trait ICursorStateComputer extends js.Object {
      def apply(inverseEditOperations: js.Array[IIdentifiedSingleEditOperation]): js.Array[Selection] = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.TextModelResolvedOptions")
    class TextModelResolvedOptions extends js.Object {
      var _textModelResolvedOptionsBrand: Unit = js.native
      var tabSize: Double = js.native
      var insertSpaces: Boolean = js.native
      var defaultEOL: DefaultEndOfLine = js.native
      var trimAutoWhitespace: Boolean = js.native
    }

    @js.native
    trait ITextModelUpdateOptions extends js.Object {
      var tabSize: Double = js.native
      var insertSpaces: Boolean = js.native
      var trimAutoWhitespace: Boolean = js.native
    }

    @js.native
    trait IModelOptionsChangedEvent extends js.Object {
      var tabSize: Boolean = js.native
      var insertSpaces: Boolean = js.native
      var trimAutoWhitespace: Boolean = js.native
    }

    @js.native
    trait ITextModel extends js.Object {
      def getOptions(): TextModelResolvedOptions = js.native

      def getVersionId(): Double = js.native

      def getAlternativeVersionId(): Double = js.native

      def setValue(newValue: String): Unit = js.native

      def getValue(eol: EndOfLinePreference = ???, preserveBOM: Boolean = ???): String = js.native

      def getValueLength(eol: EndOfLinePreference = ???, preserveBOM: Boolean = ???): Double = js.native

      def getValueInRange(range: IRange, eol: EndOfLinePreference = ???): String = js.native

      def getValueLengthInRange(range: IRange): Double = js.native

      def getLineCount(): Double = js.native

      def getLineContent(lineNumber: Double): String = js.native

      def getLinesContent(): js.Array[String] = js.native

      def getEOL(): String = js.native

      def setEOL(eol: EndOfLineSequence): Unit = js.native

      def getLineMinColumn(lineNumber: Double): Double = js.native

      def getLineMaxColumn(lineNumber: Double): Double = js.native

      def getLineFirstNonWhitespaceColumn(lineNumber: Double): Double = js.native

      def getLineLastNonWhitespaceColumn(lineNumber: Double): Double = js.native

      def validatePosition(position: IPosition): Position = js.native

      def modifyPosition(position: IPosition, offset: Double): Position = js.native

      def validateRange(range: IRange): Range = js.native

      def getOffsetAt(position: IPosition): Double = js.native

      def getPositionAt(offset: Double): Position = js.native

      def getFullModelRange(): Range = js.native

      def isDisposed(): Boolean = js.native

      @JSName("findMatches")
      def findMatches1(searchString: String, searchOnlyEditableRange: Boolean, isRegex: Boolean, matchCase: Boolean, wholeWord: Boolean, captureMatches: Boolean, limitResultCount: Double = ???): js.Array[FindMatch] = js.native

      @JSName("findMatches")
      def findMatches2(searchString: String, searchScope: IRange, isRegex: Boolean, matchCase: Boolean, wholeWord: Boolean, captureMatches: Boolean, limitResultCount: Double = ???): js.Array[FindMatch] = js.native

      def findNextMatch(searchString: String, searchStart: IPosition, isRegex: Boolean, matchCase: Boolean, wholeWord: Boolean, captureMatches: Boolean): FindMatch = js.native

      def findPreviousMatch(searchString: String, searchStart: IPosition, isRegex: Boolean, matchCase: Boolean, wholeWord: Boolean, captureMatches: Boolean): FindMatch = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.FindMatch")
    class FindMatch extends js.Object {
      var _findMatchBrand: Unit = js.native
      var range: Range = js.native
      var matches: js.Array[String] = js.native
    }

    @js.native
    trait IReadOnlyModel extends ITextModel {
      var uri: Uri = js.native

      def getModeId(): String = js.native

      def getWordAtPosition(position: IPosition): IWordAtPosition = js.native

      def getWordUntilPosition(position: IPosition): IWordAtPosition = js.native
    }

    @js.native
    trait ITokenizedModel extends ITextModel {
      def getModeId(): String = js.native

      def getWordAtPosition(position: IPosition): IWordAtPosition = js.native

      def getWordUntilPosition(position: IPosition): IWordAtPosition = js.native
    }

    @js.native
    trait ITextModelWithMarkers extends ITextModel {
    }

    @js.native
    sealed trait TrackedRangeStickiness extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.TrackedRangeStickiness")
    object TrackedRangeStickiness extends js.Object {
      var AlwaysGrowsWhenTypingAtEdges: TrackedRangeStickiness = js.native
      var NeverGrowsWhenTypingAtEdges: TrackedRangeStickiness = js.native
      var GrowsOnlyWhenTypingBefore: TrackedRangeStickiness = js.native
      var GrowsOnlyWhenTypingAfter: TrackedRangeStickiness = js.native

      @JSBracketAccess
      def apply(value: TrackedRangeStickiness): String = js.native
    }

    @js.native
    trait ITextModelWithDecorations extends js.Object {
      def deltaDecorations(oldDecorations: js.Array[String], newDecorations: js.Array[IModelDeltaDecoration], ownerId: Double = ???): js.Array[String] = js.native

      def getDecorationOptions(id: String): IModelDecorationOptions = js.native

      def getDecorationRange(id: String): Range = js.native

      def getLineDecorations(lineNumber: Double, ownerId: Double = ???, filterOutValidation: Boolean = ???): js.Array[IModelDecoration] = js.native

      def getLinesDecorations(startLineNumber: Double, endLineNumber: Double, ownerId: Double = ???, filterOutValidation: Boolean = ???): js.Array[IModelDecoration] = js.native

      def getDecorationsInRange(range: IRange, ownerId: Double = ???, filterOutValidation: Boolean = ???): js.Array[IModelDecoration] = js.native

      def getAllDecorations(ownerId: Double = ???, filterOutValidation: Boolean = ???): js.Array[IModelDecoration] = js.native
    }

    @js.native
    trait IEditableTextModel extends ITextModelWithMarkers {
      def normalizeIndentation(str: String): String = js.native

      def getOneIndent(): String = js.native

      def updateOptions(newOpts: ITextModelUpdateOptions): Unit = js.native

      def detectIndentation(defaultInsertSpaces: Boolean, defaultTabSize: Double): Unit = js.native

      def pushStackElement(): Unit = js.native

      def pushEditOperations(beforeCursorState: js.Array[Selection], editOperations: js.Array[IIdentifiedSingleEditOperation], cursorStateComputer: ICursorStateComputer): js.Array[Selection] = js.native

      def applyEdits(operations: js.Array[IIdentifiedSingleEditOperation]): js.Array[IIdentifiedSingleEditOperation] = js.native
    }

    @js.native
    trait IModel extends IReadOnlyModel with IEditableTextModel with ITextModelWithMarkers with ITokenizedModel with ITextModelWithDecorations with IEditorModel {

      override def getModeId(): String = js.native

      override def getWordAtPosition(position: IPosition): IWordAtPosition = js.native

      override def getWordUntilPosition(position: IPosition): IWordAtPosition = js.native

      def onDidChangeContent(listener: js.Function1[IModelContentChangedEvent2, Unit]): IDisposable = js.native

      def onDidChangeDecorations(listener: js.Function1[IModelDecorationsChangedEvent, Unit]): IDisposable = js.native

      def onDidChangeOptions(listener: js.Function1[IModelOptionsChangedEvent, Unit]): IDisposable = js.native

      def onDidChangeLanguage(listener: js.Function1[IModelLanguageChangedEvent, Unit]): IDisposable = js.native

      def onWillDispose(listener: js.Function0[Unit]): IDisposable = js.native

      var id: String = js.native

      def dispose(): Unit = js.native
    }

    @js.native
    trait IModelLanguageChangedEvent extends js.Object {
      var oldLanguage: String = js.native
      var newLanguage: String = js.native
    }

    @js.native
    trait IModelContentChangedEvent2 extends js.Object {
      var range: IRange = js.native
      var rangeLength: Double = js.native
      var text: String = js.native
      var eol: String = js.native
      var versionId: Double = js.native
      var isUndoing: Boolean = js.native
      var isRedoing: Boolean = js.native
    }

    @js.native
    trait IModelDecorationsChangedEvent extends js.Object {
      var addedDecorations: js.Array[String] = js.native
      var changedDecorations: js.Array[String] = js.native
      var removedDecorations: js.Array[String] = js.native
    }

    @js.native
    trait IModelTokensChangedEvent extends js.Object {
      var ranges: js.Array[js.Any] = js.native
    }

    @js.native
    sealed trait CursorChangeReason extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.CursorChangeReason")
    object CursorChangeReason extends js.Object {
      var NotSet: CursorChangeReason = js.native
      var ContentFlush: CursorChangeReason = js.native
      var RecoverFromMarkers: CursorChangeReason = js.native
      var Explicit: CursorChangeReason = js.native
      var Paste: CursorChangeReason = js.native
      var Undo: CursorChangeReason = js.native
      var Redo: CursorChangeReason = js.native

      @JSBracketAccess
      def apply(value: CursorChangeReason): String = js.native
    }

    @js.native
    trait ICursorPositionChangedEvent extends js.Object {
      var position: Position = js.native
      var viewPosition: Position = js.native
      var secondaryPositions: js.Array[Position] = js.native
      var secondaryViewPositions: js.Array[Position] = js.native
      var reason: CursorChangeReason = js.native
      var source: String = js.native
      var isInEditableRange: Boolean = js.native
    }

    @js.native
    trait ICursorSelectionChangedEvent extends js.Object {
      var selection: Selection = js.native
      var viewSelection: Selection = js.native
      var secondarySelections: js.Array[Selection] = js.native
      var secondaryViewSelections: js.Array[Selection] = js.native
      var source: String = js.native
      var reason: CursorChangeReason = js.native
    }

    @js.native
    trait IModelChangedEvent extends js.Object {
      var oldModelUrl: Uri = js.native
      var newModelUrl: Uri = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.OverviewRulerPosition")
    class OverviewRulerPosition extends js.Object {
      var _overviewRulerPositionBrand: Unit = js.native
      var width: Double = js.native
      var height: Double = js.native
      var top: Double = js.native
      var right: Double = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.EditorLayoutInfo")
    class EditorLayoutInfo extends js.Object {
      var _editorLayoutInfoBrand: Unit = js.native
      var width: Double = js.native
      var height: Double = js.native
      var glyphMarginLeft: Double = js.native
      var glyphMarginWidth: Double = js.native
      var glyphMarginHeight: Double = js.native
      var lineNumbersLeft: Double = js.native
      var lineNumbersWidth: Double = js.native
      var lineNumbersHeight: Double = js.native
      var decorationsLeft: Double = js.native
      var decorationsWidth: Double = js.native
      var decorationsHeight: Double = js.native
      var contentLeft: Double = js.native
      var contentWidth: Double = js.native
      var contentHeight: Double = js.native
      var verticalScrollbarWidth: Double = js.native
      var horizontalScrollbarHeight: Double = js.native
      var overviewRuler: OverviewRulerPosition = js.native
    }

    @js.native
    trait ICodeEditorWidgetCreationOptions extends IEditorOptions {
      var model: IModel = js.native
    }

    @js.native
    trait IEditorModel extends js.Object {
    }

    @js.native
    trait IEditorViewState extends js.Object {
    }

    @js.native
    trait IDimension extends js.Object {
      var width: Double = js.native
      var height: Double = js.native
    }

    @js.native
    trait ICursorState extends js.Object {
      var inSelectionMode: Boolean = js.native
      var selectionStart: IPosition = js.native
      var position: IPosition = js.native
    }

    @js.native
    trait IViewState extends js.Object {
      var scrollTop: Double = js.native
      var scrollTopWithoutViewZones: Double = js.native
      var scrollLeft: Double = js.native
    }

    @js.native
    trait ICodeEditorViewState extends IEditorViewState {
      var cursorState: js.Array[ICursorState] = js.native
      var viewState: IViewState = js.native
      var contributionsState: js.Dictionary[js.Any] = js.native
    }

    @js.native
    sealed trait MouseTargetType extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.MouseTargetType")
    object MouseTargetType extends js.Object {
      var UNKNOWN: MouseTargetType = js.native
      var TEXTAREA: MouseTargetType = js.native
      var GUTTER_GLYPH_MARGIN: MouseTargetType = js.native
      var GUTTER_LINE_NUMBERS: MouseTargetType = js.native
      var GUTTER_LINE_DECORATIONS: MouseTargetType = js.native
      var GUTTER_VIEW_ZONE: MouseTargetType = js.native
      var CONTENT_TEXT: MouseTargetType = js.native
      var CONTENT_EMPTY: MouseTargetType = js.native
      var CONTENT_VIEW_ZONE: MouseTargetType = js.native
      var CONTENT_WIDGET: MouseTargetType = js.native
      var OVERVIEW_RULER: MouseTargetType = js.native
      var SCROLLBAR: MouseTargetType = js.native
      var OVERLAY_WIDGET: MouseTargetType = js.native

      @JSBracketAccess
      def apply(value: MouseTargetType): String = js.native
    }

    @js.native
    trait IDiffEditorModel extends IEditorModel {
      var original: IModel = js.native
      var modified: IModel = js.native
    }

    @js.native
    trait IDiffEditorViewState extends IEditorViewState {
      var original: ICodeEditorViewState = js.native
      var modified: ICodeEditorViewState = js.native
    }

    @js.native
    trait IChange extends js.Object {
      var originalStartLineNumber: Double = js.native
      var originalEndLineNumber: Double = js.native
      var modifiedStartLineNumber: Double = js.native
      var modifiedEndLineNumber: Double = js.native
    }

    @js.native
    trait ICharChange extends IChange {
      var originalStartColumn: Double = js.native
      var originalEndColumn: Double = js.native
      var modifiedStartColumn: Double = js.native
      var modifiedEndColumn: Double = js.native
    }

    @js.native
    trait ILineChange extends IChange {
      var charChanges: js.Array[ICharChange] = js.native
    }

    @js.native
    trait IDiffLineInformation extends js.Object {
      var equivalentLineNumber: Double = js.native
    }

    @js.native
    trait INewScrollPosition extends js.Object {
      var scrollLeft: Double = js.native
      var scrollTop: Double = js.native
    }

    @js.native
    trait IActionDescriptor extends js.Object {
      var id: String = js.native
      var label: String = js.native
      var precondition: String = js.native
      var keybindings: js.Array[Double] = js.native
      var keybindingContext: String = js.native
      var contextMenuGroupId: String = js.native
      var contextMenuOrder: Double = js.native

      def run(editor: ICommonCodeEditor): js.Dynamic = js.native
    }

    @js.native
    trait IEditorAction extends js.Object {
      var id: String = js.native
      var label: String = js.native
      var alias: String = js.native

      def isSupported(): Boolean = js.native

      def run(): Promise[Unit] = js.native
    }

    @js.native
    trait IEditor extends js.Object {
      def onDidChangeModelContent(listener: js.Function1[IModelContentChangedEvent2, Unit]): IDisposable = js.native

      def onDidChangeModelLanguage(listener: js.Function1[IModelLanguageChangedEvent, Unit]): IDisposable = js.native

      def onDidChangeModelOptions(listener: js.Function1[IModelOptionsChangedEvent, Unit]): IDisposable = js.native

      def onDidChangeConfiguration(listener: js.Function1[IConfigurationChangedEvent, Unit]): IDisposable = js.native

      def onDidChangeCursorPosition(listener: js.Function1[ICursorPositionChangedEvent, Unit]): IDisposable = js.native

      def onDidChangeCursorSelection(listener: js.Function1[ICursorSelectionChangedEvent, Unit]): IDisposable = js.native

      def onDidDispose(listener: js.Function0[Unit]): IDisposable = js.native

      def dispose(): Unit = js.native

      def getId(): String = js.native

      def getEditorType(): String = js.native

      def updateOptions(newOptions: IEditorOptions): Unit = js.native

      def layout(dimension: IDimension = ???): Unit = js.native

      def focus(): Unit = js.native

      def isFocused(): Boolean = js.native

      def getActions(): js.Array[IEditorAction] = js.native

      def getSupportedActions(): js.Array[IEditorAction] = js.native

      def saveViewState(): IEditorViewState = js.native

      def restoreViewState(state: IEditorViewState): Unit = js.native

      def getVisibleColumnFromPosition(position: IPosition): Double = js.native

      def getPosition(): Position = js.native

      def setPosition(position: IPosition): Unit = js.native

      def revealLine(lineNumber: Double): Unit = js.native

      def revealLineInCenter(lineNumber: Double): Unit = js.native

      def revealLineInCenterIfOutsideViewport(lineNumber: Double): Unit = js.native

      def revealPosition(position: IPosition): Unit = js.native

      def revealPositionInCenter(position: IPosition): Unit = js.native

      def revealPositionInCenterIfOutsideViewport(position: IPosition): Unit = js.native

      def getSelection(): Selection = js.native

      def getSelections(): js.Array[Selection] = js.native

      def setSelection(selection: IRange): Unit = js.native

      def setSelection(selection: Range): Unit = js.native

      def setSelection(selection: ISelection): Unit = js.native

      def setSelection(selection: Selection): Unit = js.native

      def setSelections(selections: js.Array[ISelection]): Unit = js.native

      def revealLines(startLineNumber: Double, endLineNumber: Double): Unit = js.native

      def revealLinesInCenter(lineNumber: Double, endLineNumber: Double): Unit = js.native

      def revealLinesInCenterIfOutsideViewport(lineNumber: Double, endLineNumber: Double): Unit = js.native

      def revealRange(range: IRange): Unit = js.native

      def revealRangeInCenter(range: IRange): Unit = js.native

      def revealRangeAtTop(range: IRange): Unit = js.native

      def revealRangeInCenterIfOutsideViewport(range: IRange): Unit = js.native

      def trigger(source: String, handlerId: String, payload: js.Any): Unit = js.native

      def getModel(): IEditorModel = js.native

      def setModel(model: IEditorModel): Unit = js.native
    }

    @js.native
    trait IEditorContribution extends js.Object {
      def getId(): String = js.native

      def dispose(): Unit = js.native

      def saveViewState(): js.Dynamic = js.native

      def restoreViewState(state: js.Any): Unit = js.native
    }

    @js.native
    trait ICommonCodeEditor extends IEditor {
      def onDidChangeModel(listener: js.Function1[IModelChangedEvent, Unit]): IDisposable = js.native

      def onDidChangeModelDecorations(listener: js.Function1[IModelDecorationsChangedEvent, Unit]): IDisposable = js.native

      def onDidFocusEditorText(listener: js.Function0[Unit]): IDisposable = js.native

      def onDidBlurEditorText(listener: js.Function0[Unit]): IDisposable = js.native

      def onDidFocusEditor(listener: js.Function0[Unit]): IDisposable = js.native

      def onDidBlurEditor(listener: js.Function0[Unit]): IDisposable = js.native

      def hasWidgetFocus(): Boolean = js.native

      def getContribution[T <: IEditorContribution](id: String): T = js.native

      override def getModel(): IModel = js.native

      def getConfiguration(): InternalEditorOptions = js.native

      def getValue(options: js.Any = ???): String = js.native

      def setValue(newValue: String): Unit = js.native

      def getScrollWidth(): Double = js.native

      def getScrollLeft(): Double = js.native

      def getScrollHeight(): Double = js.native

      def getScrollTop(): Double = js.native

      def setScrollLeft(newScrollLeft: Double): Unit = js.native

      def setScrollTop(newScrollTop: Double): Unit = js.native

      def setScrollPosition(position: INewScrollPosition): Unit = js.native

      def getAction(id: String): IEditorAction = js.native

      def executeCommand(source: String, command: ICommand): Unit = js.native

      def pushUndoStop(): Boolean = js.native

      def executeEdits(source: String, edits: js.Array[IIdentifiedSingleEditOperation], endCursoState: js.Array[Selection] = ???): Boolean = js.native

      def executeCommands(source: String, commands: js.Array[ICommand]): Unit = js.native

      def getLineDecorations(lineNumber: Double): js.Array[IModelDecoration] = js.native

      def deltaDecorations(oldDecorations: js.Array[String], newDecorations: js.Array[IModelDeltaDecoration]): js.Array[String] = js.native

      def getLayoutInfo(): EditorLayoutInfo = js.native
    }

    @js.native
    trait ICommonDiffEditor extends IEditor {
      def onDidUpdateDiff(listener: js.Function0[Unit]): IDisposable = js.native

      override def getModel(): IDiffEditorModel = js.native

      def getOriginalEditor(): ICommonCodeEditor = js.native

      def getModifiedEditor(): ICommonCodeEditor = js.native

      def getLineChanges(): js.Array[ILineChange] = js.native

      def getDiffLineInformationForOriginal(lineNumber: Double): IDiffLineInformation = js.native

      def getDiffLineInformationForModified(lineNumber: Double): IDiffLineInformation = js.native

      def getValue(options: js.Any = ???): String = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.EditorType")
    object EditorType extends js.Object {
      var ICodeEditor: String = js.native
      var IDiffEditor: String = js.native
    }

    @js.native
    trait CursorMovePosition extends js.Object {
      var Left: String = js.native
      var Right: String = js.native
      var Up: String = js.native
      var Down: String = js.native
      var WrappedLineStart: String = js.native
      var WrappedLineFirstNonWhitespaceCharacter: String = js.native
      var WrappedLineColumnCenter: String = js.native
      var WrappedLineEnd: String = js.native
      var WrappedLineLastNonWhitespaceCharacter: String = js.native
      var ViewPortTop: String = js.native
      var ViewPortCenter: String = js.native
      var ViewPortBottom: String = js.native
      var ViewPortIfOutside: String = js.native
    }

    @js.native
    trait CursorMoveByUnit extends js.Object {
      var Line: String = js.native
      var WrappedLine: String = js.native
      var Character: String = js.native
      var HalfLine: String = js.native
    }

    @js.native
    trait CursorMoveArguments extends js.Object {
      var to: String = js.native
      var select: Boolean = js.native
      var by: String = js.native
      var value: Double = js.native
    }

    @js.native
    trait EditorScrollDirection extends js.Object {
      var Up: String = js.native
      var Down: String = js.native
    }

    @js.native
    trait EditorScrollByUnit extends js.Object {
      var Line: String = js.native
      var WrappedLine: String = js.native
      var Page: String = js.native
      var HalfPage: String = js.native
    }

    @js.native
    trait EditorScrollArguments extends js.Object {
      var to: String = js.native
      var by: String = js.native
      var value: Double = js.native
      var revealCursor: Boolean = js.native
    }

    @js.native
    trait RevealLineArguments extends js.Object {
      var lineNumber: Double = js.native
      var at: String = js.native
    }

    @js.native
    trait RevealLineAtArgument extends js.Object {
      var Top: String = js.native
      var Center: String = js.native
      var Bottom: String = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.Handler")
    object Handler extends js.Object {
      var ExecuteCommand: String = js.native
      var ExecuteCommands: String = js.native
      var CursorLeft: String = js.native
      var CursorLeftSelect: String = js.native
      var CursorWordLeft: String = js.native
      var CursorWordStartLeft: String = js.native
      var CursorWordEndLeft: String = js.native
      var CursorWordLeftSelect: String = js.native
      var CursorWordStartLeftSelect: String = js.native
      var CursorWordEndLeftSelect: String = js.native
      var CursorRight: String = js.native
      var CursorRightSelect: String = js.native
      var CursorWordRight: String = js.native
      var CursorWordStartRight: String = js.native
      var CursorWordEndRight: String = js.native
      var CursorWordRightSelect: String = js.native
      var CursorWordStartRightSelect: String = js.native
      var CursorWordEndRightSelect: String = js.native
      var CursorUp: String = js.native
      var CursorUpSelect: String = js.native
      var CursorDown: String = js.native
      var CursorDownSelect: String = js.native
      var CursorPageUp: String = js.native
      var CursorPageUpSelect: String = js.native
      var CursorPageDown: String = js.native
      var CursorPageDownSelect: String = js.native
      var CursorHome: String = js.native
      var CursorHomeSelect: String = js.native
      var CursorEnd: String = js.native
      var CursorEndSelect: String = js.native
      var ExpandLineSelection: String = js.native
      var CursorTop: String = js.native
      var CursorTopSelect: String = js.native
      var CursorBottom: String = js.native
      var CursorBottomSelect: String = js.native
      var CursorColumnSelectLeft: String = js.native
      var CursorColumnSelectRight: String = js.native
      var CursorColumnSelectUp: String = js.native
      var CursorColumnSelectPageUp: String = js.native
      var CursorColumnSelectDown: String = js.native
      var CursorColumnSelectPageDown: String = js.native
      var CursorMove: String = js.native
      var AddCursorDown: String = js.native
      var AddCursorUp: String = js.native
      var CursorUndo: String = js.native
      var MoveTo: String = js.native
      var MoveToSelect: String = js.native
      var ColumnSelect: String = js.native
      var CreateCursor: String = js.native
      var LastCursorMoveToSelect: String = js.native
      var Type: String = js.native
      var ReplacePreviousChar: String = js.native
      var CompositionStart: String = js.native
      var CompositionEnd: String = js.native
      var Paste: String = js.native
      var Tab: String = js.native
      var Indent: String = js.native
      var Outdent: String = js.native
      var DeleteLeft: String = js.native
      var DeleteRight: String = js.native
      var DeleteWordLeft: String = js.native
      var DeleteWordStartLeft: String = js.native
      var DeleteWordEndLeft: String = js.native
      var DeleteWordRight: String = js.native
      var DeleteWordStartRight: String = js.native
      var DeleteWordEndRight: String = js.native
      var RemoveSecondaryCursors: String = js.native
      var CancelSelection: String = js.native
      var Cut: String = js.native
      var Undo: String = js.native
      var Redo: String = js.native
      var WordSelect: String = js.native
      var WordSelectDrag: String = js.native
      var LastCursorWordSelect: String = js.native
      var LineSelect: String = js.native
      var LineSelectDrag: String = js.native
      var LastCursorLineSelect: String = js.native
      var LastCursorLineSelectDrag: String = js.native
      var LineInsertBefore: String = js.native
      var LineInsertAfter: String = js.native
      var LineBreakInsert: String = js.native
      var SelectAll: String = js.native
      var EditorScroll: String = js.native
      var ScrollLineUp: String = js.native
      var ScrollLineDown: String = js.native
      var ScrollPageUp: String = js.native
      var ScrollPageDown: String = js.native
      var RevealLine: String = js.native
    }

    @js.native
    sealed trait TextEditorCursorStyle extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.TextEditorCursorStyle")
    object TextEditorCursorStyle extends js.Object {
      var Line: TextEditorCursorStyle = js.native
      var Block: TextEditorCursorStyle = js.native
      var Underline: TextEditorCursorStyle = js.native

      @JSBracketAccess
      def apply(value: TextEditorCursorStyle): String = js.native
    }

    @js.native
    sealed trait TextEditorCursorBlinkingStyle extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.TextEditorCursorBlinkingStyle")
    object TextEditorCursorBlinkingStyle extends js.Object {
      var Hidden: TextEditorCursorBlinkingStyle = js.native
      var Blink: TextEditorCursorBlinkingStyle = js.native
      var Smooth: TextEditorCursorBlinkingStyle = js.native
      var Phase: TextEditorCursorBlinkingStyle = js.native
      var Expand: TextEditorCursorBlinkingStyle = js.native
      var Solid: TextEditorCursorBlinkingStyle = js.native

      @JSBracketAccess
      def apply(value: TextEditorCursorBlinkingStyle): String = js.native
    }

    @js.native
    trait IViewZone extends js.Object {
      var afterLineNumber: Double = js.native
      var afterColumn: Double = js.native
      var suppressMouseDown: Boolean = js.native
      var heightInLines: Double = js.native
      var heightInPx: Double = js.native
      var domNode: HTMLElement = js.native
      var marginDomNode: HTMLElement = js.native
      var onDomNodeTop: js.Function1[Double, Unit] = js.native
      var onComputedHeight: js.Function1[Double, Unit] = js.native
    }

    @js.native
    trait IViewZoneChangeAccessor extends js.Object {
      def addZone(zone: IViewZone): Double = js.native

      def removeZone(id: Double): Unit = js.native

      def layoutZone(id: Double): Unit = js.native
    }

    @js.native
    sealed trait ContentWidgetPositionPreference extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.ContentWidgetPositionPreference")
    object ContentWidgetPositionPreference extends js.Object {
      var EXACT: ContentWidgetPositionPreference = js.native
      var ABOVE: ContentWidgetPositionPreference = js.native
      var BELOW: ContentWidgetPositionPreference = js.native

      @JSBracketAccess
      def apply(value: ContentWidgetPositionPreference): String = js.native
    }

    @js.native
    trait IContentWidgetPosition extends js.Object {
      var position: IPosition = js.native
      var preference: js.Array[ContentWidgetPositionPreference] = js.native
    }

    @js.native
    trait IContentWidget extends js.Object {
      var allowEditorOverflow: Boolean = js.native
      var suppressMouseDown: Boolean = js.native

      def getId(): String = js.native

      def getDomNode(): HTMLElement = js.native

      def getPosition(): IContentWidgetPosition = js.native
    }

    @js.native
    sealed trait OverlayWidgetPositionPreference extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.editor.OverlayWidgetPositionPreference")
    object OverlayWidgetPositionPreference extends js.Object {
      var TOP_RIGHT_CORNER: OverlayWidgetPositionPreference = js.native
      var BOTTOM_RIGHT_CORNER: OverlayWidgetPositionPreference = js.native
      var TOP_CENTER: OverlayWidgetPositionPreference = js.native

      @JSBracketAccess
      def apply(value: OverlayWidgetPositionPreference): String = js.native
    }

    @js.native
    trait IOverlayWidgetPosition extends js.Object {
      var preference: OverlayWidgetPositionPreference = js.native
    }

    @js.native
    trait IOverlayWidget extends js.Object {
      def getId(): String = js.native

      def getDomNode(): HTMLElement = js.native

      def getPosition(): IOverlayWidgetPosition = js.native
    }

    @js.native
    trait IMouseTarget extends js.Object {
      var element: Element = js.native
      var `type`: MouseTargetType = js.native
      var position: Position = js.native
      var mouseColumn: Double = js.native
      var range: Range = js.native
      var detail: js.Any = js.native
    }

    @js.native
    trait IEditorMouseEvent extends js.Object {
      var event: IMouseEvent = js.native
      var target: IMouseTarget = js.native
    }

    @js.native
    trait ICodeEditor extends ICommonCodeEditor {
      def onMouseUp(listener: js.Function1[IEditorMouseEvent, Unit]): IDisposable = js.native

      def onMouseDown(listener: js.Function1[IEditorMouseEvent, Unit]): IDisposable = js.native

      def onContextMenu(listener: js.Function1[IEditorMouseEvent, Unit]): IDisposable = js.native

      def onMouseMove(listener: js.Function1[IEditorMouseEvent, Unit]): IDisposable = js.native

      def onMouseLeave(listener: js.Function1[IEditorMouseEvent, Unit]): IDisposable = js.native

      def onKeyUp(listener: js.Function1[IKeyboardEvent, Unit]): IDisposable = js.native

      def onKeyDown(listener: js.Function1[IKeyboardEvent, Unit]): IDisposable = js.native

      def onDidLayoutChange(listener: js.Function1[EditorLayoutInfo, Unit]): IDisposable = js.native

      def onDidScrollChange(listener: js.Function1[IScrollEvent, Unit]): IDisposable = js.native

      def getDomNode(): HTMLElement = js.native

      def addContentWidget(widget: IContentWidget): Unit = js.native

      def layoutContentWidget(widget: IContentWidget): Unit = js.native

      def removeContentWidget(widget: IContentWidget): Unit = js.native

      def addOverlayWidget(widget: IOverlayWidget): Unit = js.native

      def layoutOverlayWidget(widget: IOverlayWidget): Unit = js.native

      def removeOverlayWidget(widget: IOverlayWidget): Unit = js.native

      def changeViewZones(callback: js.Function1[IViewZoneChangeAccessor, Unit]): Unit = js.native

      def getCenteredRangeInViewport(): Range = js.native

      def getOffsetForColumn(lineNumber: Double, column: Double): Double = js.native

      def render(): Unit = js.native

      def getTopForLineNumber(lineNumber: Double): Double = js.native

      def getTopForPosition(lineNumber: Double, column: Double): Double = js.native

      def getTargetAtClientPoint(clientX: Double, clientY: Double): IMouseTarget = js.native

      def getScrolledVisiblePosition(position: IPosition): js.Any = js.native

      def applyFontInfo(target: HTMLElement): Unit = js.native
    }

    @js.native
    trait IDiffEditor extends ICommonDiffEditor {
      def getDomNode(): HTMLElement = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.FontInfo")
    class FontInfo extends BareFontInfo {
      var _editorStylingBrand: Unit = js.native
      var isMonospace: Boolean = js.native
      var typicalHalfwidthCharacterWidth: Double = js.native
      var typicalFullwidthCharacterWidth: Double = js.native
      var spaceWidth: Double = js.native
      var maxDigitWidth: Double = js.native
    }

    @js.native
    @JSGlobal("monaco.editor.BareFontInfo")
    class BareFontInfo extends js.Object {
      var _bareFontInfoBrand: Unit = js.native
      var fontFamily: String = js.native
      var fontWeight: String = js.native
      var fontSize: Double = js.native
      var lineHeight: Double = js.native
    }

    @js.native
    @JSGlobal("monaco.editor")
    object Editor extends js.Object {
      def create(domElement: Element, options: IEditorConstructionOptions = ???, `override`: IEditorOverrideServices = ???): IStandaloneCodeEditor = js.native

      def onDidCreateEditor(listener: js.Function1[ICodeEditor, Unit]): IDisposable = js.native

      def createDiffEditor(domElement: Element, options: IDiffEditorConstructionOptions = ???, `override`: IEditorOverrideServices = ???): IStandaloneDiffEditor = js.native

      def createDiffNavigator(diffEditor: IStandaloneDiffEditor, opts: IDiffNavigatorOptions = ???): IDiffNavigator = js.native

      def createModel(value: String, language: String = ???, uri: Uri = ???): IModel = js.native

      def setModelLanguage(model: IModel, language: String): Unit = js.native

      def setModelMarkers(model: IModel, owner: String, markers: js.Array[IMarkerData]): Unit = js.native

      def getModel(uri: Uri): IModel = js.native

      def getModels(): js.Array[IModel] = js.native

      def onDidCreateModel(listener: js.Function1[IModel, Unit]): IDisposable = js.native

      def onWillDisposeModel(listener: js.Function1[IModel, Unit]): IDisposable = js.native

      def onDidChangeModelLanguage(listener: js.Function1[js.Any, Unit]): IDisposable = js.native

      def createWebWorker[T](opts: IWebWorkerOptions): MonacoWebWorker[T] = js.native

      def colorizeElement(domNode: HTMLElement, options: IColorizerElementOptions): Promise[Unit] = js.native

      def colorize(text: String, languageId: String, options: IColorizerOptions): Promise[String] = js.native

      def colorizeModelLine(model: IModel, lineNumber: Double, tabSize: Double = ???): String = js.native

      def tokenize(text: String, languageId: String): js.Array[js.Array[Token]] = js.native

      def defineTheme(themeName: String, themeData: ITheme): Unit = js.native

      type BuiltinTheme = String
      type LineNumbersOption = js.Any
    }

  }

  package languages {

    import monaco.Monaco.MarkedString
    import monaco.languages.Languages.{CharacterPair, Definition}

    import scala.scalajs.js.RegExp

    @js.native
    trait IToken extends js.Object {
      var startIndex: Double = js.native
      var scopes: String = js.native
    }

    @js.native
    trait ILineTokens extends js.Object {
      var tokens: js.Array[IToken] = js.native
      var endState: IState = js.native
    }

    @js.native
    trait TokensProvider extends js.Object {
      def getInitialState(): IState = js.native

      def tokenize(line: String, state: IState): ILineTokens = js.native
    }

    @js.native
    trait CodeActionContext extends js.Object {
      var markers: js.Array[editor.IMarkerData] = js.native
    }

    @js.native
    trait CodeActionProvider extends js.Object {
      def provideCodeActions(model: editor.IReadOnlyModel, range: Range, context: CodeActionContext, token: CancellationToken): js.Array[CodeAction] | Thenable[js.Array[CodeAction]] = js.native
    }

    @js.native
    sealed trait CompletionItemKind extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.languages.CompletionItemKind")
    object CompletionItemKind extends js.Object {
      var Text: CompletionItemKind = js.native
      var Method: CompletionItemKind = js.native
      var Function: CompletionItemKind = js.native
      var Constructor: CompletionItemKind = js.native
      var Field: CompletionItemKind = js.native
      var Variable: CompletionItemKind = js.native
      var Class: CompletionItemKind = js.native
      var Interface: CompletionItemKind = js.native
      var Module: CompletionItemKind = js.native
      var Property: CompletionItemKind = js.native
      var Unit: CompletionItemKind = js.native
      var Value: CompletionItemKind = js.native
      var Enum: CompletionItemKind = js.native
      var Keyword: CompletionItemKind = js.native
      var Snippet: CompletionItemKind = js.native
      var Color: CompletionItemKind = js.native
      var File: CompletionItemKind = js.native
      var Reference: CompletionItemKind = js.native
      var Folder: CompletionItemKind = js.native

      @JSBracketAccess
      def apply(value: CompletionItemKind): String = js.native
    }

    @js.native
    trait SnippetString extends js.Object {
      var value: String = js.native
    }

    @js.native
    trait CompletionItem extends js.Object {
      var label: String = js.native
      var kind: CompletionItemKind = js.native
      var detail: String = js.native
      var documentation: String = js.native
      var sortText: String = js.native
      var filterText: String = js.native
      var insertText: String | SnippetString = js.native
      var range: Range = js.native
      var textEdit: editor.ISingleEditOperation = js.native
    }

    @js.native
    trait CompletionList extends js.Object {
      var isIncomplete: Boolean = js.native
      var items: js.Array[CompletionItem] = js.native
    }

    @js.native
    trait CompletionItemProvider extends js.Object {
      var triggerCharacters: js.Array[String] = js.native

      def provideCompletionItems(model: editor.IReadOnlyModel, position: Position, token: CancellationToken): js.Array[CompletionItem] | Thenable[js.Array[CompletionItem]] | CompletionList | Thenable[CompletionList] = js.native

      def resolveCompletionItem(item: CompletionItem, token: CancellationToken): CompletionItem | Thenable[CompletionItem] = js.native
    }

    @js.native
    trait CommentRule extends js.Object {
      var lineComment: String = js.native
      var blockComment: CharacterPair = js.native
    }

    @js.native
    trait LanguageConfiguration extends js.Object {
      var comments: CommentRule = js.native
      var brackets: js.Array[CharacterPair] = js.native
      var wordPattern: RegExp = js.native
      var indentationRules: IndentationRule = js.native
      var onEnterRules: js.Array[OnEnterRule] = js.native
      var autoClosingPairs: js.Array[IAutoClosingPairConditional] = js.native
      var surroundingPairs: js.Array[IAutoClosingPair] = js.native
      var __electricCharacterSupport: IBracketElectricCharacterContribution = js.native
    }

    @js.native
    trait IndentationRule extends js.Object {
      var decreaseIndentPattern: RegExp = js.native
      var increaseIndentPattern: RegExp = js.native
      var indentNextLinePattern: RegExp = js.native
      var unIndentedLinePattern: RegExp = js.native
    }

    @js.native
    trait OnEnterRule extends js.Object {
      var beforeText: RegExp = js.native
      var afterText: RegExp = js.native
      var action: EnterAction = js.native
    }

    @js.native
    trait IBracketElectricCharacterContribution extends js.Object {
      var docComment: IDocComment = js.native
    }

    @js.native
    trait IDocComment extends js.Object {
      var open: String = js.native
      var close: String = js.native
    }

    @js.native
    trait IAutoClosingPair extends js.Object {
      var open: String = js.native
      var close: String = js.native
    }

    @js.native
    trait IAutoClosingPairConditional extends IAutoClosingPair {
      var notIn: js.Array[String] = js.native
    }

    @js.native
    sealed trait IndentAction extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.languages.IndentAction")
    object IndentAction extends js.Object {
      var None: IndentAction = js.native
      var Indent: IndentAction = js.native
      var IndentOutdent: IndentAction = js.native
      var Outdent: IndentAction = js.native

      @JSBracketAccess
      def apply(value: IndentAction): String = js.native
    }

    @js.native
    trait EnterAction extends js.Object {
      var indentAction: IndentAction = js.native
      var outdentCurrentLine: Boolean = js.native
      var appendText: String = js.native
      var removeText: Double = js.native
    }

    @js.native
    trait IState extends js.Object {
      override def clone(): IState = js.native

      def equals(other: IState): Boolean = js.native
    }

    @js.native
    trait Hover extends js.Object {
      var contents: js.Array[MarkedString] = js.native
      var range: IRange = js.native
    }

    @js.native
    trait HoverProvider extends js.Object {
      def provideHover(model: editor.IReadOnlyModel, position: Position, token: CancellationToken): Hover | Thenable[Hover] = js.native
    }

    @js.native
    trait CodeAction extends js.Object {
      var command: Command = js.native
      var score: Double = js.native
    }

    @js.native
    trait ParameterInformation extends js.Object {
      var label: String = js.native
      var documentation: String = js.native
    }

    @js.native
    trait SignatureInformation extends js.Object {
      var label: String = js.native
      var documentation: String = js.native
      var parameters: js.Array[ParameterInformation] = js.native
    }

    @js.native
    trait SignatureHelp extends js.Object {
      var signatures: js.Array[SignatureInformation] = js.native
      var activeSignature: Double = js.native
      var activeParameter: Double = js.native
    }

    @js.native
    trait SignatureHelpProvider extends js.Object {
      var signatureHelpTriggerCharacters: js.Array[String] = js.native

      def provideSignatureHelp(model: editor.IReadOnlyModel, position: Position, token: CancellationToken): SignatureHelp | Thenable[SignatureHelp] = js.native
    }

    @js.native
    sealed trait DocumentHighlightKind extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.languages.DocumentHighlightKind")
    object DocumentHighlightKind extends js.Object {
      var Text: DocumentHighlightKind = js.native
      var Read: DocumentHighlightKind = js.native
      var Write: DocumentHighlightKind = js.native

      @JSBracketAccess
      def apply(value: DocumentHighlightKind): String = js.native
    }

    @js.native
    trait DocumentHighlight extends js.Object {
      var range: IRange = js.native
      var kind: DocumentHighlightKind = js.native
    }

    @js.native
    trait DocumentHighlightProvider extends js.Object {
      def provideDocumentHighlights(model: editor.IReadOnlyModel, position: Position, token: CancellationToken): js.Array[DocumentHighlight] | Thenable[js.Array[DocumentHighlight]] = js.native
    }

    @js.native
    trait ReferenceContext extends js.Object {
      var includeDeclaration: Boolean = js.native
    }

    @js.native
    trait ReferenceProvider extends js.Object {
      def provideReferences(model: editor.IReadOnlyModel, position: Position, context: ReferenceContext, token: CancellationToken): js.Array[Location] | Thenable[js.Array[Location]] = js.native
    }

    @js.native
    trait Location extends js.Object {
      var uri: Uri = js.native
      var range: IRange = js.native
    }

    @js.native
    trait DefinitionProvider extends js.Object {
      def provideDefinition(model: editor.IReadOnlyModel, position: Position, token: CancellationToken): Definition | Thenable[Definition] = js.native
    }

    @js.native
    trait ImplementationProvider extends js.Object {
      def provideImplementation(model: editor.IReadOnlyModel, position: Position, token: CancellationToken): Definition | Thenable[Definition] = js.native
    }

    @js.native
    sealed trait SymbolKind extends js.Object {
    }

    @js.native
    @JSGlobal("monaco.languages.SymbolKind")
    object SymbolKind extends js.Object {
      var File: SymbolKind = js.native
      var Module: SymbolKind = js.native
      var Namespace: SymbolKind = js.native
      var Package: SymbolKind = js.native
      var Class: SymbolKind = js.native
      var Method: SymbolKind = js.native
      var Property: SymbolKind = js.native
      var Field: SymbolKind = js.native
      var Constructor: SymbolKind = js.native
      var Enum: SymbolKind = js.native
      var Interface: SymbolKind = js.native
      var Function: SymbolKind = js.native
      var Variable: SymbolKind = js.native
      var Constant: SymbolKind = js.native
      var String: SymbolKind = js.native
      var Number: SymbolKind = js.native
      var Boolean: SymbolKind = js.native
      var Array: SymbolKind = js.native
      var Object: SymbolKind = js.native
      var Key: SymbolKind = js.native
      var Null: SymbolKind = js.native

      @JSBracketAccess
      def apply(value: SymbolKind): String = js.native
    }

    @js.native
    trait SymbolInformation extends js.Object {
      var name: String = js.native
      var containerName: String = js.native
      var kind: SymbolKind = js.native
      var location: Location = js.native
    }

    @js.native
    trait DocumentSymbolProvider extends js.Object {
      def provideDocumentSymbols(model: editor.IReadOnlyModel, token: CancellationToken): js.Array[SymbolInformation] | Thenable[js.Array[SymbolInformation]] = js.native
    }

    @js.native
    trait FormattingOptions extends js.Object {
      var tabSize: Double = js.native
      var insertSpaces: Boolean = js.native
    }

    @js.native
    trait DocumentFormattingEditProvider extends js.Object {
      def provideDocumentFormattingEdits(model: editor.IReadOnlyModel, options: FormattingOptions, token: CancellationToken): js.Array[editor.ISingleEditOperation] | Thenable[js.Array[editor.ISingleEditOperation]] = js.native
    }

    @js.native
    trait DocumentRangeFormattingEditProvider extends js.Object {
      def provideDocumentRangeFormattingEdits(model: editor.IReadOnlyModel, range: Range, options: FormattingOptions, token: CancellationToken): js.Array[editor.ISingleEditOperation] | Thenable[js.Array[editor.ISingleEditOperation]] = js.native
    }

    @js.native
    trait OnTypeFormattingEditProvider extends js.Object {
      var autoFormatTriggerCharacters: js.Array[String] = js.native

      def provideOnTypeFormattingEdits(model: editor.IReadOnlyModel, position: Position, ch: String, options: FormattingOptions, token: CancellationToken): js.Array[editor.ISingleEditOperation] | Thenable[js.Array[editor.ISingleEditOperation]] = js.native
    }

    @js.native
    trait ILink extends js.Object {
      var range: IRange = js.native
      var url: String = js.native
    }

    @js.native
    trait LinkProvider extends js.Object {
      def provideLinks(model: editor.IReadOnlyModel, token: CancellationToken): js.Array[ILink] | Thenable[js.Array[ILink]] = js.native

      var resolveLink: js.Function2[ILink, CancellationToken, ILink | Thenable[ILink]] = js.native
    }

    @js.native
    trait IResourceEdit extends js.Object {
      var resource: Uri = js.native
      var range: IRange = js.native
      var newText: String = js.native
    }

    @js.native
    trait WorkspaceEdit extends js.Object {
      var edits: js.Array[IResourceEdit] = js.native
      var rejectReason: String = js.native
    }

    @js.native
    trait RenameProvider extends js.Object {
      def provideRenameEdits(model: editor.IReadOnlyModel, position: Position, newName: String, token: CancellationToken): WorkspaceEdit | Thenable[WorkspaceEdit] = js.native
    }

    @js.native
    trait Command extends js.Object {
      var id: String = js.native
      var title: String = js.native
      var arguments: js.Array[js.Any] = js.native
    }

    @js.native
    trait ICodeLensSymbol extends js.Object {
      var range: IRange = js.native
      var id: String = js.native
      var command: Command = js.native
    }

    @js.native
    trait CodeLensProvider extends js.Object {
      var onDidChange: IEvent[CodeLensProvider] = js.native

      def provideCodeLenses(model: editor.IReadOnlyModel, token: CancellationToken): js.Array[ICodeLensSymbol] | Thenable[js.Array[ICodeLensSymbol]] = js.native

      def resolveCodeLens(model: editor.IReadOnlyModel, codeLens: ICodeLensSymbol, token: CancellationToken): ICodeLensSymbol | Thenable[ICodeLensSymbol] = js.native
    }

    @js.native
    trait ILanguageExtensionPoint extends js.Object {
      var id: String = js.native
      var extensions: js.Array[String] = js.native
      var filenames: js.Array[String] = js.native
      var filenamePatterns: js.Array[String] = js.native
      var firstLine: String = js.native
      var aliases: js.Array[String] = js.native
      var mimetypes: js.Array[String] = js.native
      var configuration: String = js.native
    }

    @js.native
    trait IMonarchLanguage extends js.Object {
      var tokenizer: js.Dictionary[js.Array[IMonarchLanguageRule]] = js.native
      var ignoreCase: Boolean = js.native
      var defaultToken: String = js.native
      var brackets: js.Array[IMonarchLanguageBracket] = js.native
      var start: String = js.native
      var tokenPostfix: String = js.native
    }

    @js.native
    trait IMonarchLanguageRule extends js.Object {
      var regex: String | RegExp = js.native
      var action: IMonarchLanguageAction = js.native
      var include: String = js.native
    }

    @js.native
    trait IMonarchLanguageAction extends js.Object {
      var group: js.Array[IMonarchLanguageAction] = js.native
      var cases: Object = js.native
      var token: String = js.native
      var next: String = js.native
      var switchTo: String = js.native
      var goBack: Double = js.native
      var bracket: String = js.native
      var nextEmbedded: String = js.native
      var log: String = js.native
    }

    @js.native
    trait IMonarchLanguageBracket extends js.Object {
      var open: String = js.native
      var close: String = js.native
      var token: String = js.native
    }

    package typescript {

      import monaco.languages.typescript.Typescript.CompilerOptionsValue

      @js.native
      sealed trait ModuleKind extends js.Object {
      }

      @js.native
      @JSGlobal("monaco.languages.typescript.ModuleKind")
      object ModuleKind extends js.Object {
        var None: ModuleKind = js.native
        var CommonJS: ModuleKind = js.native
        var AMD: ModuleKind = js.native
        var UMD: ModuleKind = js.native
        var System: ModuleKind = js.native
        var ES2015: ModuleKind = js.native

        @JSBracketAccess
        def apply(value: ModuleKind): String = js.native
      }

      @js.native
      sealed trait JsxEmit extends js.Object {
      }

      @js.native
      @JSGlobal("monaco.languages.typescript.JsxEmit")
      object JsxEmit extends js.Object {
        var None: JsxEmit = js.native
        var Preserve: JsxEmit = js.native
        var React: JsxEmit = js.native

        @JSBracketAccess
        def apply(value: JsxEmit): String = js.native
      }

      @js.native
      sealed trait NewLineKind extends js.Object {
      }

      @js.native
      @JSGlobal("monaco.languages.typescript.NewLineKind")
      object NewLineKind extends js.Object {
        var CarriageReturnLineFeed: NewLineKind = js.native
        var LineFeed: NewLineKind = js.native

        @JSBracketAccess
        def apply(value: NewLineKind): String = js.native
      }

      @js.native
      sealed trait ScriptTarget extends js.Object {
      }

      @js.native
      @JSGlobal("monaco.languages.typescript.ScriptTarget")
      object ScriptTarget extends js.Object {
        var ES3: ScriptTarget = js.native
        var ES5: ScriptTarget = js.native
        var ES2015: ScriptTarget = js.native
        var ES2016: ScriptTarget = js.native
        var ES2017: ScriptTarget = js.native
        var ESNext: ScriptTarget = js.native
        var Latest: ScriptTarget = js.native

        @JSBracketAccess
        def apply(value: ScriptTarget): String = js.native
      }

      @js.native
      sealed trait ModuleResolutionKind extends js.Object {
      }

      @js.native
      @JSGlobal("monaco.languages.typescript.ModuleResolutionKind")
      object ModuleResolutionKind extends js.Object {
        var Classic: ModuleResolutionKind = js.native
        var NodeJs: ModuleResolutionKind = js.native

        @JSBracketAccess
        def apply(value: ModuleResolutionKind): String = js.native
      }

      @js.native
      trait CompilerOptions extends js.Object {
        var allowJs: Boolean = js.native
        var allowSyntheticDefaultImports: Boolean = js.native
        var allowUnreachableCode: Boolean = js.native
        var allowUnusedLabels: Boolean = js.native
        var alwaysStrict: Boolean = js.native
        var baseUrl: String = js.native
        var charset: String = js.native
        var declaration: Boolean = js.native
        var declarationDir: String = js.native
        var disableSizeLimit: Boolean = js.native
        var emitBOM: Boolean = js.native
        var emitDecoratorMetadata: Boolean = js.native
        var experimentalDecorators: Boolean = js.native
        var forceConsistentCasingInFileNames: Boolean = js.native
        var importHelpers: Boolean = js.native
        var inlineSourceMap: Boolean = js.native
        var inlineSources: Boolean = js.native
        var isolatedModules: Boolean = js.native
        var jsx: JsxEmit = js.native
        var lib: js.Array[String] = js.native
        var locale: String = js.native
        var mapRoot: String = js.native
        var maxNodeModuleJsDepth: Double = js.native
        var module: ModuleKind = js.native
        var moduleResolution: ModuleResolutionKind = js.native
        var newLine: NewLineKind = js.native
        var noEmit: Boolean = js.native
        var noEmitHelpers: Boolean = js.native
        var noEmitOnError: Boolean = js.native
        var noErrorTruncation: Boolean = js.native
        var noFallthroughCasesInSwitch: Boolean = js.native
        var noImplicitAny: Boolean = js.native
        var noImplicitReturns: Boolean = js.native
        var noImplicitThis: Boolean = js.native
        var noUnusedLocals: Boolean = js.native
        var noUnusedParameters: Boolean = js.native
        var noImplicitUseStrict: Boolean = js.native
        var noLib: Boolean = js.native
        var noResolve: Boolean = js.native
        var out: String = js.native
        var outDir: String = js.native
        var outFile: String = js.native
        var preserveConstEnums: Boolean = js.native
        var project: String = js.native
        var reactNamespace: String = js.native
        var jsxFactory: String = js.native
        var removeComments: Boolean = js.native
        var rootDir: String = js.native
        var rootDirs: js.Array[String] = js.native
        var skipLibCheck: Boolean = js.native
        var skipDefaultLibCheck: Boolean = js.native
        var sourceMap: Boolean = js.native
        var sourceRoot: String = js.native
        var strictNullChecks: Boolean = js.native
        var suppressExcessPropertyErrors: Boolean = js.native
        var suppressImplicitAnyIndexErrors: Boolean = js.native
        var target: ScriptTarget = js.native
        var traceResolution: Boolean = js.native
        var types: js.Array[String] = js.native
        var typeRoots: js.Array[String] = js.native

        @JSBracketAccess
        def apply(option: String): CompilerOptionsValue | Unit = js.native

        @JSBracketAccess
        def update(option: String, v: CompilerOptionsValue | Unit): Unit = js.native
      }

      @js.native
      trait DiagnosticsOptions extends js.Object {
        var noSemanticValidation: Boolean = js.native
        var noSyntaxValidation: Boolean = js.native
      }

      @js.native
      trait LanguageServiceDefaults extends js.Object {
        def addExtraLib(content: String, filePath: String = ???): IDisposable = js.native

        def setCompilerOptions(options: CompilerOptions): Unit = js.native

        def setDiagnosticsOptions(options: DiagnosticsOptions): Unit = js.native

        def setMaximunWorkerIdleTime(value: Double): Unit = js.native
      }

      @JSGlobal("monaco.languages.typescript")
      @js.native
      object Typescript extends js.Object {
        type CompilerOptionsValue = String | Double | Boolean | js.Array[String | Double] | js.Array[String]
        var typescriptDefaults: LanguageServiceDefaults = js.native
        var javascriptDefaults: LanguageServiceDefaults = js.native
        var getTypeScriptWorker: js.Function0[monaco.Promise[js.Any]] = js.native
        var getJavaScriptWorker: js.Function0[monaco.Promise[js.Any]] = js.native
      }

    }

    package css {

      @js.native
      trait DiagnosticsOptions extends js.Object {
        var validate: Boolean = js.native
        var lint: js.Any = js.native
      }

      @js.native
      trait LanguageServiceDefaults extends js.Object {
        var onDidChange: IEvent[LanguageServiceDefaults] = js.native
        var diagnosticsOptions: DiagnosticsOptions = js.native

        def setDiagnosticsOptions(options: DiagnosticsOptions): Unit = js.native
      }

      @JSGlobal("monaco.languages.css")
      @js.native
      object Css extends js.Object {
        var cssDefaults: LanguageServiceDefaults = js.native
        var lessDefaults: LanguageServiceDefaults = js.native
        var scssDefaults: LanguageServiceDefaults = js.native
      }

    }

    package json {

      @js.native
      trait DiagnosticsOptions extends js.Object {
        var validate: Boolean = js.native
        var allowComments: Boolean = js.native
        var schemas: js.Array[js.Any] = js.native
      }

      @js.native
      trait LanguageServiceDefaults extends js.Object {
        var onDidChange: IEvent[LanguageServiceDefaults] = js.native
        var diagnosticsOptions: DiagnosticsOptions = js.native

        def setDiagnosticsOptions(options: DiagnosticsOptions): Unit = js.native
      }

      @JSGlobal("monaco.languages.json")
      @js.native
      object Json extends js.Object {
        var jsonDefaults: LanguageServiceDefaults = js.native
      }

    }

    package html {

      @js.native
      trait HTMLFormatConfiguration extends js.Object {
        var tabSize: Double = js.native
        var insertSpaces: Boolean = js.native
        var wrapLineLength: Double = js.native
        var unformatted: String = js.native
        var contentUnformatted: String = js.native
        var indentInnerHtml: Boolean = js.native
        var preserveNewLines: Boolean = js.native
        var maxPreserveNewLines: Double = js.native
        var indentHandlebars: Boolean = js.native
        var endWithNewline: Boolean = js.native
        var extraLiners: String = js.native
        var wrapAttributes: String = js.native
      }

      @js.native
      trait CompletionConfiguration extends js.Object {
        @JSBracketAccess
        def apply(provider: String): Boolean = js.native

        @JSBracketAccess
        def update(provider: String, v: Boolean): Unit = js.native
      }

      @js.native
      trait Options extends js.Object {
        var format: HTMLFormatConfiguration = js.native
        var suggest: CompletionConfiguration = js.native
      }

      @js.native
      trait LanguageServiceDefaults extends js.Object {
        var onDidChange: IEvent[LanguageServiceDefaults] = js.native
        var options: Options = js.native

        def setOptions(options: Options): Unit = js.native
      }

      @JSGlobal("monaco.languages.html")
      @js.native
      object Html extends js.Object {
        var htmlDefaults: LanguageServiceDefaults = js.native
        var handlebarDefaults: LanguageServiceDefaults = js.native
        var razorDefaults: LanguageServiceDefaults = js.native
      }

    }

    @JSGlobal("monaco.languages")
    @js.native
    object Languages extends js.Object {
      def register(language: ILanguageExtensionPoint): Unit = js.native

      def getLanguages(): js.Array[ILanguageExtensionPoint] = js.native

      def onLanguage(languageId: String, callback: js.Function0[Unit]): IDisposable = js.native

      def setLanguageConfiguration(languageId: String, configuration: LanguageConfiguration): IDisposable = js.native

      def setTokensProvider(languageId: String, provider: TokensProvider): IDisposable = js.native

      def setMonarchTokensProvider(languageId: String, languageDef: IMonarchLanguage): IDisposable = js.native

      def registerReferenceProvider(languageId: String, provider: ReferenceProvider): IDisposable = js.native

      def registerRenameProvider(languageId: String, provider: RenameProvider): IDisposable = js.native

      def registerSignatureHelpProvider(languageId: String, provider: SignatureHelpProvider): IDisposable = js.native

      def registerHoverProvider(languageId: String, provider: HoverProvider): IDisposable = js.native

      def registerDocumentSymbolProvider(languageId: String, provider: DocumentSymbolProvider): IDisposable = js.native

      def registerDocumentHighlightProvider(languageId: String, provider: DocumentHighlightProvider): IDisposable = js.native

      def registerDefinitionProvider(languageId: String, provider: DefinitionProvider): IDisposable = js.native

      def registerImplementationProvider(languageId: String, provider: ImplementationProvider): IDisposable = js.native

      def registerCodeLensProvider(languageId: String, provider: CodeLensProvider): IDisposable = js.native

      def registerCodeActionProvider(languageId: String, provider: CodeActionProvider): IDisposable = js.native

      def registerDocumentFormattingEditProvider(languageId: String, provider: DocumentFormattingEditProvider): IDisposable = js.native

      def registerDocumentRangeFormattingEditProvider(languageId: String, provider: DocumentRangeFormattingEditProvider): IDisposable = js.native

      def registerOnTypeFormattingEditProvider(languageId: String, provider: OnTypeFormattingEditProvider): IDisposable = js.native

      def registerLinkProvider(languageId: String, provider: LinkProvider): IDisposable = js.native

      def registerCompletionItemProvider(languageId: String, provider: CompletionItemProvider): IDisposable = js.native

      type CharacterPair = js.Tuple2[String, String]
      type Definition = Location | js.Array[Location]
    }

  }

  package worker {

    @js.native
    trait IMirrorModel extends js.Object {
      var uri: Uri = js.native
      var version: Double = js.native

      def getValue(): String = js.native
    }

    @js.native
    trait IWorkerContext extends js.Object {
      def getMirrorModels(): js.Array[IMirrorModel] = js.native
    }

  }

  @JSGlobal("monaco")
  @js.native
  object Monaco extends js.Object {
    type MarkedString = String | js.Any
  }

}
