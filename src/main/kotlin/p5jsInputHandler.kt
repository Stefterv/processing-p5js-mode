package processing.p5js

import processing.app.syntax.InputHandler
import processing.app.syntax.PdeInputHandler
import java.awt.event.ActionListener

class p5jsInputHandler(editor: p5jsEditor): PdeInputHandler(editor) {
    init{
        this.addKeyBinding("ENTER", InputHandler.INSERT_BREAK)
        this.addKeyBinding("TAB", InputHandler.INSERT_TAB)
    }
}