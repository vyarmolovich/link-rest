/* Generated By:JJTree: Do not edit this line. ASTCurrentDate.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.agrest.backend.exp.parser;

import io.agrest.backend.exp.Expression;

public class ASTCurrentDate extends SimpleNode {
    public ASTCurrentDate(int id) {
        super(id);
    }

    public ASTCurrentDate() {
        this(ExpressionParserTreeConstants.JJTCURRENTDATE);
    }

    @Override
    public Expression shallowCopy() {
        return new ASTCurrentDate(id);
    }
}
/* JavaCC - OriginalChecksum=68f03ac26a6ee9982e2d49bcfd25d723 (do not edit this line) */
