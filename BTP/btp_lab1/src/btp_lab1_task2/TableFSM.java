package btp_lab1_task2;

public class TableFSM extends FSM {
	private TransitionTable tt;
	
	public TableFSM(){
		tt = new TransitionTable();
	}
	
	@Override
	public State chooseNextStateMethod(Event e){
		for (int i = 0; i < tt.transitions.size(); i++){
			Transition transition = tt.transitions.get(i);
			if (currentState == transition.startState && e == transition.trigger){
				return tt.transitions.get(i).endState;
			}
		}
		return State.ERROR;
	}
}
