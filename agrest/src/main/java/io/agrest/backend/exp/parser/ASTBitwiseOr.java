/* Generated By:JJTree: Do not edit this line. ASTBitwiseOr.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.agrest.backend.exp.parser;

import io.agrest.backend.exp.Expression;

public class ASTBitwiseOr extends SimpleNode {
    public ASTBitwiseOr(int id) {
        super(id);
    }

    public ASTBitwiseOr() {
        super(ExpressionParserTreeConstants.JJTBITWISEOR);
    }

    @Override
    public Expression shallowCopy() {
        return new ASTBitwiseOr(id);
    }
}
/* JavaCC - OriginalChecksum=201425d6c236b54b0c036170c2ecf907 (do not edit this line) */
