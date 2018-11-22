/* Generated By:JJTree: Do not edit this line. ASTSubstring.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.agrest.backend.exp.parser;

import io.agrest.backend.exp.Expression;

public class ASTSubstring extends ASTFunctionCall {

    ASTSubstring(int id) {
        super(id, "SUBSTRING");
    }

    public ASTSubstring(Expression path, Expression length, Expression offset) {
        super(ExpressionParserTreeConstants.JJTSUBSTRING, "SUBSTRING", path, length, offset);
    }


    @Override
    public Expression shallowCopy() {
        return new ASTSubstring(id);
    }
}
/* JavaCC - OriginalChecksum=f29b457ecf99701b81a12cfb1d6f2627 (do not edit this line) */