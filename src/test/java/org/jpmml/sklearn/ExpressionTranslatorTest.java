/*
 * Copyright (c) 2017 Villu Ruusmann
 *
 * This file is part of JPMML-SkLearn
 *
 * JPMML-SkLearn is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JPMML-SkLearn is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with JPMML-SkLearn.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jpmml.sklearn;

import java.util.List;

import org.dmg.pmml.Apply;
import org.dmg.pmml.Constant;
import org.dmg.pmml.Expression;
import org.dmg.pmml.FieldRef;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionTranslatorTest extends TranslatorTest {

	@Test
	public void translateLogicalExpression(){
		Apply apply = (Apply)ExpressionTranslator.translate("X[\"a\"] and X[\"b\"] or X[\"c\"]", booleanFeatures);

		checkApply(apply, "or", Apply.class, FieldRef.class);

		apply = (Apply)ExpressionTranslator.translate("not X[\"a\"]", booleanFeatures);

		checkApply(apply, "not", FieldRef.class);
	}

	@Test
	public void translateComparisonExpression(){
		Apply apply = (Apply)ExpressionTranslator.translate("X['a'] == True and X['b'] == False", booleanFeatures);

		checkApply(apply, "and", Apply.class, Apply.class);

		apply = (Apply)ExpressionTranslator.translate("X[\"a\"] > X[\"b\"]", doubleFeatures);

		checkApply(apply, "greaterThan", FieldRef.class, FieldRef.class);

		apply = (Apply)ExpressionTranslator.translate("not X[\"a\"] < 0.0", doubleFeatures, false);

		checkApply(apply, "not", Apply.class);

		apply = (Apply)ExpressionTranslator.translate("not X[\"a\"] < 0.0", doubleFeatures, true);

		checkApply(apply, "greaterOrEqual", FieldRef.class, Constant.class);
	}

	@Test
	public void translateArithmeticExpression(){
		Apply apply = (Apply)ExpressionTranslator.translate("(X[0] + X[1] - 1) / X[2] * -2", doubleFeatures);

		checkApply(apply, "*", Apply.class, Constant.class);

		apply = (Apply)ExpressionTranslator.translate("(X[\"a\"] + X[\"b\"] - 1.0) / X['c'] * -2.0", doubleFeatures);

		checkApply(apply, "*", Apply.class, Constant.class);
	}

	@Test
	public void translateUnaryExpression(){
		Constant constant = (Constant)ExpressionTranslator.translate("-1", doubleFeatures);

		checkConstant(constant, "-1");

		constant = (Constant)ExpressionTranslator.translate("+1", doubleFeatures);

		checkConstant(constant, "1");

		constant = (Constant)ExpressionTranslator.translate("-+1", doubleFeatures);

		checkConstant(constant, "-1");

		constant = (Constant)ExpressionTranslator.translate("--1", doubleFeatures);

		checkConstant(constant, "1");

		constant = (Constant)ExpressionTranslator.translate("---1", doubleFeatures);

		checkConstant(constant, "-1");
	}

	@Test
	public void translateFunctionInvocationExpression(){
		Apply apply = (Apply)ExpressionTranslator.translate("X[\"a\"] if pandas.notnull(X[\"a\"]) else X[\"b\"] + X[\"c\"]", doubleFeatures);

		checkApply(apply, "if", Apply.class, FieldRef.class, Apply.class);
	}

	static
	private void checkConstant(Constant constant, String value){
		assertEquals(value, constant.getValue());
	}

	static
	private void checkApply(Apply apply, String function, Class<? extends Expression>... expressionClazzes){
		assertEquals(function, apply.getFunction());

		List<Expression> expressions = apply.getExpressions();
		assertEquals(expressionClazzes.length, expressions.size());

		for(int i = 0; i < expressionClazzes.length; i++){
			Class<? extends Expression> expressionClazz = expressionClazzes[i];
			Expression expression = expressions.get(i);

			assertEquals(expressionClazz, expression.getClass());
		}
	}
}