/*
 * Copyright 2011 Holger Brandl
 *
 * This code is licensed under BSD. For details see
 * http://www.opensource.org/licenses/bsd-license.php
 */

package com.r4intellij.lang.lexer;

import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.r4intellij.file.RFileType;


/**
 * Identifies all of the token types (at least, the ones we'll care about) in Arc.
 * Used by the lexer to break a R source file down into tokens.
 *
 * @author Holger Brandl
 */
public interface RTokenTypes {

    IFileElementType FILE = new IFileElementType(RFileType.R_LANGUAGE);

    IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;

    IElementType CONSTANT = new RElementType("Constant");
    IElementType VARIABLE = new RElementType("variable");
    IElementType INTERNAL_COMMAND = new RElementType("internal R command");
    IElementType INTEGER_LITERAL = new RElementType("int literal");
    IElementType STRING_LITERAL = new RElementType("String");
    IElementType COMMENT = new RElementType("Comment");
    IElementType NUMBER = new RElementType("number");
    IElementType IDENTIFIER = new RElementType("word");


    // squares
    IElementType LEFT_PAREN = new RElementType("(");
    IElementType RIGHT_PAREN = new RElementType(")");
    IElementType LEFT_CURLY = new RElementType("{");
    IElementType RIGHT_CURLY = new RElementType("}");
    IElementType LEFT_SQUARE = new RElementType("[ (left square)");
    IElementType RIGHT_SQUARE = new RElementType("] (right square)");

    // R reserved keywords, in alphabetic order
    IElementType CASE_KEYWORD = new RElementType("case"); //case
    IElementType DO_KEYWORD = new RElementType("do"); //do
    IElementType DONE_KEYWORD = new RElementType("done"); //done
    IElementType ELIF_KEYWORD = new RElementType("elif");//elif
    IElementType ELSE_KEYWORD = new RElementType("else");//else
    IElementType ESAC_KEYWORD = new RElementType("esac"); //esac
    IElementType FI_KEYWORD = new RElementType("fi");//fi
    IElementType FOR_KEYWORD = new RElementType("for");//for
    IElementType FUNCTION_KEYWORD = new RElementType("function");//function
    IElementType IF_KEYWORD = new RElementType("if");//if
    IElementType IN_KEYWORD = new RElementType("in");//in
    IElementType SELECT_KEYWORD = new RElementType("select");//select
    IElementType THEN_KEYWORD = new RElementType("then");//then
    IElementType UNTIL_KEYWORD = new RElementType("until");//until
    IElementType WHILE_KEYWORD = new RElementType("while");//while
    IElementType TIME_KEYWORD = new RElementType("time");//time
    IElementType BRACKET_KEYWORD = new RElementType("[[ (left bracket)");//[[
    IElementType _BRACKET_KEYWORD = new RElementType("]] (right bracket)");//]]

    TokenSet keywords = TokenSet.create(CASE_KEYWORD, DO_KEYWORD, DONE_KEYWORD,
            ELIF_KEYWORD, ELSE_KEYWORD, ESAC_KEYWORD, FI_KEYWORD, FOR_KEYWORD, FUNCTION_KEYWORD,
            IF_KEYWORD, IN_KEYWORD, SELECT_KEYWORD, THEN_KEYWORD, UNTIL_KEYWORD, WHILE_KEYWORD,
            TIME_KEYWORD, BRACKET_KEYWORD, _BRACKET_KEYWORD);

    // single characters
    IElementType COLON = new RElementType(":");
    IElementType COMMA = new RElementType(",");
    IElementType SEMICOLON = new RElementType(";");
    IElementType DOT = new RElementType(".");
    IElementType TILDE = new RElementType("~");

    IElementType ASSIGNMENT = new RElementType("assignment_word");
    IElementType LOG_OPERATOR = new RElementType("logical operator");
    IElementType LIST_SUBSET = new RElementType("$");
    IElementType VARARGS = new RElementType("...");


    IElementType ARITH_PLUS = new RElementType("+");//+
    IElementType ARITH_MINUS = new RElementType("-");//+
    IElementType NEGATION = new RElementType("!");
    IElementType ARITH_MULT = new RElementType("*");//*
    IElementType ARITH_DIV = new RElementType("/");// /
    IElementType ARITH_MOD = new RElementType("%");//%
    IElementType ARITH_EXPONENTIAION = new RElementType("^");
    IElementType ARITH_MISC = new RElementType("%someop%");
}