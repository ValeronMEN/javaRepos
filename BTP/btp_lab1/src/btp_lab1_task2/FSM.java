package btp_lab1_task2;

import java.util.ArrayList;

enum State {
	q0, q1, q2, q3, q4, q5, q6, ERROR
}
enum Event {
	PERCENT, DIGIT, PLUS, ANY
}

class Transition {
	State startState;
	Event trigger;
	State endState;
	
	Transition(State sS, Event t, State eS){
		startState = sS;
		trigger = t;
		endState = eS;
	}
}

class TransitionTable {
	public ArrayList<Transition> transitions;
	
	TransitionTable(){
		transitions = new ArrayList<Transition>();
		buildTransitionTable();
	}
	
	private void addTransition (State startState, Event e, State endState){
		Transition newTrans = new Transition(startState, e, endState);
		transitions.add(newTrans);
	}
	
	private void buildTransitionTable(){
		addTransition(State.q0, Event.PLUS, State.q1);
		addTransition(State.q0, Event.PERCENT, State.ERROR);
		addTransition(State.q0, Event.DIGIT, State.ERROR);
		addTransition(State.q0, Event.ANY, State.ERROR);
		
		addTransition(State.q1, Event.PLUS, State.ERROR);
		addTransition(State.q1, Event.PERCENT, State.ERROR);
		addTransition(State.q1, Event.DIGIT, State.q2);
		addTransition(State.q1, Event.ANY, State.ERROR);
		
		addTransition(State.q2, Event.PLUS, State.q3);
		addTransition(State.q2, Event.PERCENT, State.ERROR);
		addTransition(State.q2, Event.DIGIT, State.q2);
		addTransition(State.q2, Event.ANY, State.ERROR);
		
		addTransition(State.q3, Event.PLUS, State.ERROR);
		addTransition(State.q3, Event.PERCENT, State.q4);
		addTransition(State.q3, Event.DIGIT, State.ERROR);
		addTransition(State.q3, Event.ANY, State.ERROR);
		
		addTransition(State.q4, Event.PLUS, State.q5);
		addTransition(State.q4, Event.PERCENT, State.ERROR);
		addTransition(State.q4, Event.DIGIT, State.ERROR);
		addTransition(State.q4, Event.ANY, State.ERROR);
		
		addTransition(State.q5, Event.PLUS, State.ERROR);
		addTransition(State.q5, Event.PERCENT, State.ERROR);
		addTransition(State.q5, Event.DIGIT, State.q6);
		addTransition(State.q5, Event.ANY, State.ERROR);
		
		addTransition(State.q6, Event.PLUS, State.ERROR);
		addTransition(State.q6, Event.PERCENT, State.ERROR);
		addTransition(State.q6, Event.DIGIT, State.q6);
		addTransition(State.q6, Event.ANY, State.ERROR);
	}
}

abstract class FSM {
	State currentState;
	
	public FSM(){
		currentState = State.q0;
	}
	
	protected Event recognizeEvent(char c){
		Event event = Event.ANY;
		if (c == '+'){
			event = Event.PLUS;
		}
		if (c >= '0' && c <= '9'){
			event = Event.DIGIT;
		}
		if (c == '%'){
			event = Event.PERCENT;
		}
		return event;
	}
	
	public boolean scanString(String s){
		if (null == s){
			throw new IllegalArgumentException();
		}
		Event event;
		for (int i=0; i < s.length(); i++) {
			event = recognizeEvent(s.charAt(i));
			currentState = this.chooseNextStateMethod(event);
			if (currentState == State.ERROR){
				break;
			}
		}
		
		return currentState == State.q6 ? true : false;
	}
		
    protected abstract State chooseNextStateMethod(Event e);
}

