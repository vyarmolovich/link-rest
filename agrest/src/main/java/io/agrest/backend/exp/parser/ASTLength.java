/* Generated By:JJTree: Do not edit this line. ASTLength.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.agrest.backend.exp.parser;

import io.agrest.backend.exp.Expression;

public class ASTLength extends ASTFunctionCall {

    ASTLength(int id) {
        super(id, "LENGTH");
    }

    public ASTLength(Expression expression) {
        super(ExpressionParserTreeConstants.JJTLENGTH, "LENGTH", expression);
    }

    @Override
    public Expression shallowCopy() {
        return new ASTLength(id);
    }
}
/* JavaCC - OriginalChecksum=1b4781e1f4d2471295c91faaf6003c37 (do not edit this line) */