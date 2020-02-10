/*
 * generated by Xtext 2.14.0
 */
package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import mydsl.FSM;
import mydsl.FinalState;
import mydsl.IntitialState;
import mydsl.MydslPackage;
import mydsl.State;
import mydsl.Transition;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("all")
public class MyDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MyDslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MydslPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MydslPackage.FSM:
				sequence_FSM(context, (FSM) semanticObject); 
				return; 
			case MydslPackage.FINAL_STATE:
				sequence_FinalState(context, (FinalState) semanticObject); 
				return; 
			case MydslPackage.INTITIAL_STATE:
				sequence_IntitialState(context, (IntitialState) semanticObject); 
				return; 
			case MydslPackage.STATE:
				sequence_State(context, (State) semanticObject); 
				return; 
			case MydslPackage.TRANSITION:
				sequence_Transition(context, (Transition) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     FSM returns FSM
	 *
	 * Constraint:
	 *     (name=EString state+=IntitialState state+=FinalState ((state+=State state+=State*) | (transition+=Transition transition+=Transition*))*)
	 */
	protected void sequence_FSM(ISerializationContext context, FSM semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     FinalState returns FinalState
	 *
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_FinalState(ISerializationContext context, FinalState semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MydslPackage.Literals.STATE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MydslPackage.Literals.STATE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getFinalStateAccess().getNameEStringParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     IntitialState returns IntitialState
	 *
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_IntitialState(ISerializationContext context, IntitialState semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MydslPackage.Literals.STATE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MydslPackage.Literals.STATE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIntitialStateAccess().getNameEStringParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     State returns State
	 *
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_State(ISerializationContext context, State semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MydslPackage.Literals.STATE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MydslPackage.Literals.STATE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStateAccess().getNameEStringParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Transition returns Transition
	 *
	 * Constraint:
	 *     (name=EString source=[State|EString] target=[State|EString])
	 */
	protected void sequence_Transition(ISerializationContext context, Transition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MydslPackage.Literals.TRANSITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MydslPackage.Literals.TRANSITION__NAME));
			if (transientValues.isValueTransient(semanticObject, MydslPackage.Literals.TRANSITION__SOURCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MydslPackage.Literals.TRANSITION__SOURCE));
			if (transientValues.isValueTransient(semanticObject, MydslPackage.Literals.TRANSITION__TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MydslPackage.Literals.TRANSITION__TARGET));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTransitionAccess().getNameEStringParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTransitionAccess().getSourceStateEStringParserRuleCall_1_0_1(), semanticObject.eGet(MydslPackage.Literals.TRANSITION__SOURCE, false));
		feeder.accept(grammarAccess.getTransitionAccess().getTargetStateEStringParserRuleCall_3_0_1(), semanticObject.eGet(MydslPackage.Literals.TRANSITION__TARGET, false));
		feeder.finish();
	}
	
	
}
