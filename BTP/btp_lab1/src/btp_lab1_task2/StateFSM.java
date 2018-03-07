package btp_lab1_task2;

public class StateFSM extends FSM {
	public static Q0 q0State = new Q0();
	public static Q1 q1State = new Q1();
	public static Q2 q2State = new Q2();
	public static Q3 q3State = new Q3();
	public static Q4 q4State = new Q4();
	public static Q5 q5State = new Q5();
	public static Q6 q6State = new Q6();
	
	private AbstractState state = q0State;
	
	@Override
	public State chooseNextStateMethod(Event e){
		state.nextState(e, this);
		if (state == null)
			return State.ERROR;
		return state.getState();
	}
	
	public void setState(AbstractState state){
		this.state = state;
	}
}

abstract class AbstractState{
	abstract void nextState(Event e, StateFSM fsm);
	abstract State getState();
}

class Q0 extends AbstractState{
	void nextState(Event e, StateFSM fsm){
		if (e == Event.PLUS){
			fsm.setState(StateFSM.q1State);
		}
		else{
			fsm.setState(null);
		}
	}
	State getState() { return State.q0; }
}

class Q1 extends AbstractState{
	void nextState(Event e, StateFSM fsm){
		if (e == Event.DIGIT){
			fsm.setState(StateFSM.q2State);
		}
		else{
			fsm.setState(null);
		}
	}
	State getState() { return State.q1; }
}

class Q2 extends AbstractState{
	void nextState(Event e, StateFSM fsm){
		if (e == Event.DIGIT){
			fsm.setState(StateFSM.q2State);
		}
		else if (e == Event.PLUS){
			fsm.setState(StateFSM.q3State);
		}
		else{
			fsm.setState(null);
		}
	}
	State getState() { return State.q2; }
}

class Q3 extends AbstractState{
	void nextState(Event e, StateFSM fsm){
		if (e == Event.PERCENT){
			fsm.setState(StateFSM.q4State);
		}
		else{
			fsm.setState(null);
		}
	}
	State getState() { return State.q3; }
}

class Q4 extends AbstractState{
	void nextState(Event e, StateFSM fsm){
		if (e == Event.PLUS){
			fsm.setState(StateFSM.q5State);
		}
		else{
			fsm.setState(null);
		}
	}
	State getState() { return State.q4; }
}

class Q5 extends AbstractState{
	void nextState(Event e, StateFSM fsm){
		if (e == Event.DIGIT){
			fsm.setState(StateFSM.q6State);
		}
		else{
			fsm.setState(null);
		}
	}
	State getState() { return State.q5; }
}

class Q6 extends AbstractState{
	void nextState(Event e, StateFSM fsm){
		if (e == Event.DIGIT){
			fsm.setState(StateFSM.q6State);
		}
		else{
			fsm.setState(null);
		}
	}
	State getState() { return State.q6; }
}
