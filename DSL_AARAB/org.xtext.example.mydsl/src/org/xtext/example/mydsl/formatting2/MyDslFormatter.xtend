/*
 * generated by Xtext 2.14.0
 */
package org.xtext.example.mydsl.formatting2

import com.google.inject.Inject
import mydsl.FSM
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.xtext.example.mydsl.services.MyDslGrammarAccess

class MyDslFormatter extends AbstractFormatter2 {
	
	@Inject extension MyDslGrammarAccess

	def dispatch void format(FSM fSM, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (state : fSM.state) {
			state.format
		}
		for (transition : fSM.transition) {
			transition.format
		}
	}
	
	// TODO: implement for 
}
