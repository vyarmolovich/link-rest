/* Generated By:JJTree: Do not edit this line. ASTAnd.java Version 4.3 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package io.agrest.backend.exp.parser;

import io.agrest.backend.exp.Expression;

import java.util.Collection;
import java.util.Iterator;

/**
 * "And" expression.
 */
public class ASTAnd extends AggregateConditionNode {
    public ASTAnd(int id) {
        super(id);
    }

    public ASTAnd() {
        super(ExpressionParserTreeConstants.JJTAND);
    }

    public ASTAnd(Object[] nodes) {
        super(ExpressionParserTreeConstants.JJTAND);
        int len = nodes.length;
        for (int i = 0; i < len; i++) {
            jjtAddChild((Node) nodes[i], i);
        }

        connectChildren();
    }

    public ASTAnd(Collection<? extends Node> nodes) {
        super(ExpressionParserTreeConstants.JJTAND);
        int len = nodes.size();
        Iterator<? extends Node> it = nodes.iterator();
        for (int i = 0; i < len; i++) {
            jjtAddChild(it.next(), i);
        }

        connectChildren();
    }

    @Override
    public Expression shallowCopy() {
        return new ASTAnd(id);
    }

    @Override
    public int getType() {
        return Expression.AND;
    }

}
/* JavaCC - OriginalChecksum=6c63dc0e1f4d6f7a977534163c27fdf5 (do not edit this line) */
