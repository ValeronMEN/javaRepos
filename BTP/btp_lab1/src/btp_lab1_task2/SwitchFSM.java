package btp_lab1_task2;

public class SwitchFSM extends FSM {
	@Override
	public State chooseNextStateMethod(Event e){
		switch(currentState){
		case q0: 
			switch(e){
			case PLUS: return State.q1;
			default: return State.ERROR;
			}
		case q1:
			switch(e){
			case DIGIT: return State.q2;
			default: return State.ERROR;
			}
		case q2:
			switch(e){
			case DIGIT: return State.q2;
			case PLUS: return State.q3;
			default: return State.ERROR;
			}
		case q3:
			switch(e){
			case PERCENT: return State.q4;
			default: return State.ERROR;
			}
		case q4:
			switch(e){
			case PLUS: return State.q5;
			default: return State.ERROR;
			}
		case q5:
			switch(e){
			case DIGIT: return State.q6;
			default: return State.ERROR;
			}
		case q6:
			switch(e){
			case DIGIT: return State.q6;
			default: return State.ERROR;
			}
		default: return State.ERROR;
		}
	}
}
