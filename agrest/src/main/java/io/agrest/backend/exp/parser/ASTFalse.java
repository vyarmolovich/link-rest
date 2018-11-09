/* Generated By:JJTree: Do not edit this line. ASTFalse.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.agrest.backend.exp.parser;

import io.agrest.backend.exp.Expression;

/**
 * Boolean false expression element
 *
 * Notice that there is one ASTTrue and one ASTFalse instead of a ASTBoolean
 * with a Boolean value. The main reason for doing this is that a common
 * ASTBoolean will have operand count of 1 and that will default to a prepared
 * statement like " where ? and (...)", but we only need " where true and
 * (...)".
 *
 * @see ASTTrue
 */
public class ASTFalse extends ConditionNode {

    /**
     * Constructor used by expression parser. Do not invoke directly.
     */
    ASTFalse(int id) {
        super(id);
    }

    public ASTFalse() {
        super(ExpressionParserTreeConstants.JJTFALSE);
    }

    @Override
    public Expression shallowCopy() {
        return new ASTFalse(id);
    }

    @Override
    public int getType() {
        return Expression.FALSE;
    }

}
/* JavaCC - OriginalChecksum=b27ff8f02a5e4aecfbf96a57caf8a688 (do not edit this line) */
