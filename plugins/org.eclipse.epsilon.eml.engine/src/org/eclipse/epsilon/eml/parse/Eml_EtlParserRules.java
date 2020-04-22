package org.eclipse.epsilon.eml.parse;

// $ANTLR 3.1b1 EtlParserRules.g 2020-04-22 23:32:27

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 * -----------------------------------------------------------------------------
 * ANTLR 3 License
 * [The "BSD licence"]
 * Copyright (c) 2005-2008 Terence Parr
 * All rights reserved.
 *  
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 * 3. The name of the author may not be used to endorse or promote products
 *   derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
public class Eml_EtlParserRules extends org.eclipse.epsilon.common.parse.EpsilonParser {
    public static final int T__144=144;
    public static final int T__143=143;
    public static final int T__146=146;
    public static final int MODELDECLARATIONPARAMETER=74;
    public static final int T__145=145;
    public static final int BREAKALL=40;
    public static final int T__140=140;
    public static final int T__142=142;
    public static final int VAR=49;
    public static final int MODELDECLARATIONPARAMETERS=73;
    public static final int T__141=141;
    public static final int THROW=54;
    public static final int PARAMLIST=25;
    public static final int EXPRLIST=55;
    public static final int EXPRRANGE=56;
    public static final int BREAK=39;
    public static final int ELSE=32;
    public static final int T__137=137;
    public static final int T__136=136;
    public static final int FORMAL=24;
    public static final int IF=31;
    public static final int MultiplicativeExpression=58;
    public static final int TYPE=66;
    public static final int T__139=139;
    public static final int T__138=138;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__135=135;
    public static final int T__134=134;
    public static final int T__131=131;
    public static final int NewExpression=48;
    public static final int T__130=130;
    public static final int CASE=36;
    public static final int Letter=16;
    public static final int LINE_COMMENT=22;
    public static final int T__129=129;
    public static final int T__126=126;
    public static final int JavaIDDigit=18;
    public static final int T__125=125;
    public static final int LAMBDAEXPR=65;
    public static final int MAP=76;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int T__166=166;
    public static final int T__165=165;
    public static final int T__168=168;
    public static final int T__167=167;
    public static final int T__162=162;
    public static final int T__161=161;
    public static final int MERGE=84;
    public static final int T__164=164;
    public static final int MODELDECLARATION=69;
    public static final int T__163=163;
    public static final int EXPRESSIONINBRACKETS=60;
    public static final int T__160=160;
    public static final int TERNARY=33;
    public static final int TRANSACTION=42;
    public static final int FLOAT_TYPE_SUFFIX=7;
    public static final int ITEMSELECTOR=75;
    public static final int COMMENT=21;
    public static final int ModelElementType=46;
    public static final int IMPORT=68;
    public static final int DELETE=53;
    public static final int ARROW=11;
    public static final int T__159=159;
    public static final int T__158=158;
    public static final int T__155=155;
    public static final int SPECIAL_ASSIGNMENT=27;
    public static final int T__154=154;
    public static final int T__157=157;
    public static final int T__156=156;
    public static final int T__151=151;
    public static final int T__150=150;
    public static final int T__153=153;
    public static final int T__152=152;
    public static final int Annotation=23;
    public static final int CONTINUE=41;
    public static final int ENUMERATION_VALUE=67;
    public static final int OPERATOR=59;
    public static final int EMLMODULE=85;
    public static final int EXPONENT=6;
    public static final int STRING=14;
    public static final int T__148=148;
    public static final int T__147=147;
    public static final int T__149=149;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int NAMESPACE=70;
    public static final int T__92=92;
    public static final int COLLECTION=43;
    public static final int NEW=50;
    public static final int EXTENDS=81;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int PRE=79;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int POST=80;
    public static final int T__90=90;
    public static final int ALIAS=71;
    public static final int DRIVER=72;
    public static final int KEYVAL=77;
    public static final int POINT_POINT=10;
    public static final int GUARD=82;
    public static final int T__99=99;
    public static final int TRANSFORM=83;
    public static final int T__95=95;
    public static final int HELPERMETHOD=28;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int StatementBlock=29;
    public static final int T__98=98;
    public static final int ABORT=44;
    public static final int StrangeNameLiteral=15;
    public static final int FOR=30;
    public static final int BLOCK=63;
    public static final int T__171=171;
    public static final int T__170=170;
    public static final int PARAMETERS=47;
    public static final int SpecialNameChar=17;
    public static final int BOOLEAN=12;
    public static final int NAME=19;
    public static final int SWITCH=35;
    public static final int T__169=169;
    public static final int FeatureCall=61;
    public static final int T__122=122;
    public static final int T__121=121;
    public static final int T__124=124;
    public static final int FLOAT=4;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int NativeType=57;
    public static final int INT=8;
    public static final int ANNOTATIONBLOCK=51;
    public static final int RETURN=38;
    public static final int KEYVALLIST=78;
    public static final int FEATURECALL=64;
    public static final int CollectionType=45;
    public static final int T__119=119;
    public static final int ASSIGNMENT=26;
    public static final int T__118=118;
    public static final int T__115=115;
    public static final int WS=20;
    public static final int EOF=-1;
    public static final int T__114=114;
    public static final int T__117=117;
    public static final int T__116=116;
    public static final int T__111=111;
    public static final int T__110=110;
    public static final int T__113=113;
    public static final int T__112=112;
    public static final int EscapeSequence=13;
    public static final int EOLMODULE=62;
    public static final int DIGIT=5;
    public static final int EXECUTABLEANNOTATION=52;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int WHILE=34;
    public static final int T__109=109;
    public static final int T__104=104;
    public static final int POINT=9;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int DEFAULT=37;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators
    public EmlParser gEml;


        public Eml_EtlParserRules(TokenStream input, EmlParser gEml) {
            this(input, new RecognizerSharedState(), gEml);
        }
        public Eml_EtlParserRules(TokenStream input, RecognizerSharedState state, EmlParser gEml) {
            super(input, state);
            this.gEml = gEml;
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return EmlParser.tokenNames; }
    public String getGrammarFileName() { return "EtlParserRules.g"; }


    public static class transformationRule_return extends ParserRuleReturnScope {
        org.eclipse.epsilon.common.parse.AST tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start transformationRule
    // EtlParserRules.g:45:1: transformationRule : r= 'rule' rule= NAME 'transform' formalParameter 'to' formalParameterList ( extendz )? ob= '{' ( guard )? block cb= '}' ;
    public final Eml_EtlParserRules.transformationRule_return transformationRule() throws RecognitionException {
        Eml_EtlParserRules.transformationRule_return retval = new Eml_EtlParserRules.transformationRule_return();
        retval.start = input.LT(1);

        org.eclipse.epsilon.common.parse.AST root_0 = null;

        Token r=null;
        Token rule=null;
        Token ob=null;
        Token cb=null;
        Token string_literal1=null;
        Token string_literal3=null;
        Eml_EolParserRules.formalParameter_return formalParameter2 = null;

        Eml_EolParserRules.formalParameterList_return formalParameterList4 = null;

        Eml_ErlParserRules.extendz_return extendz5 = null;

        Eml_ErlParserRules.guard_return guard6 = null;

        Eml_EolParserRules.block_return block7 = null;


        org.eclipse.epsilon.common.parse.AST r_tree=null;
        org.eclipse.epsilon.common.parse.AST rule_tree=null;
        org.eclipse.epsilon.common.parse.AST ob_tree=null;
        org.eclipse.epsilon.common.parse.AST cb_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal1_tree=null;
        org.eclipse.epsilon.common.parse.AST string_literal3_tree=null;

        try {
            // EtlParserRules.g:50:2: (r= 'rule' rule= NAME 'transform' formalParameter 'to' formalParameterList ( extendz )? ob= '{' ( guard )? block cb= '}' )
            // EtlParserRules.g:50:4: r= 'rule' rule= NAME 'transform' formalParameter 'to' formalParameterList ( extendz )? ob= '{' ( guard )? block cb= '}'
            {
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.nil();

            r=(Token)match(input,166,FOLLOW_166_in_transformationRule46); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            r_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(r);
            root_0 = (org.eclipse.epsilon.common.parse.AST)adaptor.becomeRoot(r_tree, root_0);
            }
            rule=(Token)match(input,NAME,FOLLOW_NAME_in_transformationRule51); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            rule_tree = (org.eclipse.epsilon.common.parse.AST)adaptor.create(rule);
            adaptor.addChild(root_0, rule_tree);
            }
            string_literal1=(Token)match(input,167,FOLLOW_167_in_transformationRule53); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameter_in_transformationRule56);
            formalParameter2=gEml.formalParameter();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameter2.getTree());
            string_literal3=(Token)match(input,168,FOLLOW_168_in_transformationRule58); if (state.failed) return retval;
            pushFollow(FOLLOW_formalParameterList_in_transformationRule61);
            formalParameterList4=gEml.formalParameterList();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, formalParameterList4.getTree());
            // EtlParserRules.g:51:2: ( extendz )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==165) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // EtlParserRules.g:0:0: extendz
                    {
                    pushFollow(FOLLOW_extendz_in_transformationRule64);
                    extendz5=gEml.extendz();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, extendz5.getTree());

                    }
                    break;

            }

            ob=(Token)match(input,91,FOLLOW_91_in_transformationRule69); if (state.failed) return retval;
            // EtlParserRules.g:51:19: ( guard )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==164) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // EtlParserRules.g:0:0: guard
                    {
                    pushFollow(FOLLOW_guard_in_transformationRule72);
                    guard6=gEml.guard();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, guard6.getTree());

                    }
                    break;

            }

            pushFollow(FOLLOW_block_in_transformationRule75);
            block7=gEml.block();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, block7.getTree());
            cb=(Token)match(input,92,FOLLOW_92_in_transformationRule79); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
              r.setType(TRANSFORM);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
            if ( state.backtracking==0 ) {

              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(ob);
              		((org.eclipse.epsilon.common.parse.AST)retval.tree).getExtraTokens().add(cb);
              	
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (org.eclipse.epsilon.common.parse.AST)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end transformationRule

    // Delegated rules


 

    public static final BitSet FOLLOW_166_in_transformationRule46 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_NAME_in_transformationRule51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000008000000000L});
    public static final BitSet FOLLOW_167_in_transformationRule53 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameter_in_transformationRule56 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_168_in_transformationRule58 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_formalParameterList_in_transformationRule61 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_extendz_in_transformationRule64 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_91_in_transformationRule69 = new BitSet(new long[]{0x0000000000085110L,0xF4A7FF0110000000L,0x000000138120001FL});
    public static final BitSet FOLLOW_guard_in_transformationRule72 = new BitSet(new long[]{0x0000000000085110L,0xF4A7FF0110000000L,0x000000038120001FL});
    public static final BitSet FOLLOW_block_in_transformationRule75 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_92_in_transformationRule79 = new BitSet(new long[]{0x0000000000000002L});

}
