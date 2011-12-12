/*
 * Copyright 2011 Holger Brandl
 *
 * This code is licensed under BSD. For details see
 * http://www.opensource.org/licenses/bsd-license.php
 */

package com.r4intellij.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.text.StringUtil;


/**
 * Event handler for the "Run Selection" action within an Arc code editor - runs the currently selected text within the current REPL.
 */
public class EvalHeadOfCurVarAction extends AnAction {

    public void actionPerformed(AnActionEvent e) {
        Editor ed = e.getData(DataKeys.EDITOR);
        if (ed == null) {
            return;
        }

        ed.getSelectionModel().selectWordAtCaret(true);
        String curWord = ed.getSelectionModel().getSelectedText();
        if (!StringUtil.isEmptyOrSpaces(curWord)) {
            RunSelectedTextOrLineAction.push2R("head(" + curWord + "); nrow(" + curWord + ");");
        }

    }
}
