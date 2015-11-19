/*
 * Copyright (c) 2015 Villu Ruusmann
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

import org.junit.Test;

public class ClassifierTest extends EstimatorTest {

	@Test
	public void evaluateDecisionTreeAudit() throws Exception {
		evaluate("DecisionTree", "Audit");
	}

	@Test
	public void evaluatExtraTreesAudit() throws Exception {
		evaluate("ExtraTrees", "Audit");
	}

	@Test
	public void evaluateGradientBoostingAudit() throws Exception {
		evaluate("GradientBoosting", "Audit");
	}

	@Test
	public void evaluateLinearDiscriminantAnalysisAudit() throws Exception {
		evaluate("LinearDiscriminantAnalysis", "Audit");
	}

	@Test
	public void evaluateLogisticRegressionAudit() throws Exception {
		evaluate("LogisticRegression", "Audit");
	}

	@Test
	public void evaluateLogisticRegressionEnsembleAudit() throws Exception {
		evaluate("LogisticRegressionEnsemble", "Audit");
	}

	@Test
	public void evaluateNaiveBayesAudit() throws Exception {
		evaluate("NaiveBayes", "Audit");
	}

	@Test
	public void evaluateRandomForestAudit() throws Exception {
		evaluate("RandomForest", "Audit");
	}

	@Test
	public void evaluateRidgeAudit() throws Exception {
		evaluate("Ridge", "Audit");
	}

	@Test
	public void evaluateRidgeEnsembleAudit() throws Exception {
		evaluate("RidgeEnsemble", "Audit");
	}

	@Test
	public void evaluateDecisionTreeIris() throws Exception {
		evaluate("DecisionTree", "Iris");
	}

	@Test
	public void evaluateExtraTreesIris() throws Exception {
		evaluate("ExtraTrees", "Iris");
	}

	@Test
	public void evaluateGradientBoostingIris() throws Exception {
		evaluate("GradientBoosting", "Iris");
	}

	@Test
	public void evaluateLinearDiscriminantAnalysisIris() throws Exception {
		evaluate("LinearDiscriminantAnalysis", "Iris");
	}

	@Test
	public void evaluateLogisticRegressionIris() throws Exception {
		evaluate("LogisticRegression", "Iris");
	}

	@Test
	public void evaluateLogisticRegressionEnsembleIris() throws Exception {
		evaluate("LogisticRegressionEnsemble", "Iris");
	}

	@Test
	public void evaluateNaiveBayesIris() throws Exception {
		evaluate("NaiveBayes", "Iris");
	}

	@Test
	public void evaluateRandomForestIris() throws Exception {
		evaluate("RandomForest", "Iris");
	}

	@Test
	public void evaluateRidgeIris() throws Exception {
		evaluate("Ridge", "Iris");
	}

	@Test
	public void evaluateRidgeEnsembleIris() throws Exception {
		evaluate("RidgeEnsemble", "Iris");
	}

	@Test
	public void evaluateSGDIris() throws Exception {
		evaluate("SGD", "Iris");
	}

	@Test
	public void evaluateSGDLogIris() throws Exception {
		evaluate("SGDLog", "Iris");
	}

	@Test
	public void evaluateSGDVersicolor() throws Exception {
		evaluate("SGD", "Versicolor");
	}

	@Test
	public void evaluateSGDLogVersicolor() throws Exception {
		evaluate("SGDLog", "Versicolor");
	}
}