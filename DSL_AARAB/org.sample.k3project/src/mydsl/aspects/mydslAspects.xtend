package mydsl.aspects

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import mydsl.FSM
import mydsl.State
import mydsl.IntitialState
import mydsl.FinalState
import mydsl.Transition

import static extension mydsl.aspects.FSMAspect.*
import static extension mydsl.aspects.StateAspect.*
import static extension mydsl.aspects.IntitialStateAspect.*
import static extension mydsl.aspects.FinalStateAspect.*
import static extension mydsl.aspects.TransitionAspect.*
import mydsl.MydslPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI

class Interpreter{
	def static void main(String[] args){
		MydslPackage.eINSTANCE.class
		Resource$Factory.Registry.INSTANCE.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl);
		var Resource resource = new ResourceSetImpl().getResource(URI.createURI('/Users/AdminEtu/Desktop/DSL_AARAB/mydsl/model/FSM.xmi'), true);
		var myFSM = resource.contents.get(0) as FSM
		myFSM.execute
	}
}

@Aspect(className=FSM)
class FSMAspect {
	var State current;
	var State finalState;
	
	def void execute(){
		_self.state.forEach[s | 
			if (s instanceof IntitialState){
				_self.current = s;
			} else if (s instanceof FinalState){
				_self.finalState = s;
			}
		]
		_self.transition.forEach[t | 
			System.out.println("Transition :" + t.source.name + " to " + t.target.name)
		]
	}
}

@Aspect(className=State)
class StateAspect {

}

@Aspect(className=IntitialState)
class IntitialStateAspect extends StateAspect {

}

@Aspect(className=FinalState)
class FinalStateAspect extends StateAspect {

}

@Aspect(className=Transition)
class TransitionAspect {

}



