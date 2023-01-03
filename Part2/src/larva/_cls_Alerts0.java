package larva;


import main.Runner;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_Alerts0 implements _callable{

public static PrintWriter pw; 
public static _cls_Alerts0 root;

public static LinkedHashMap<_cls_Alerts0,_cls_Alerts0> _cls_Alerts0_instances = new LinkedHashMap<_cls_Alerts0,_cls_Alerts0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\liams\\workspace\\Part2/src/output_Alerts.txt");

root = new _cls_Alerts0();
_cls_Alerts0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_Alerts0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public int noOfAlerts =0 ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_Alerts0() {
}

public void initialisation() {
}

public static _cls_Alerts0 _get_cls_Alerts0_inst() { synchronized(_cls_Alerts0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_Alerts0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_Alerts0_instances){
_performLogic_alerts(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_Alerts0[] a = new _cls_Alerts0[1];
synchronized(_cls_Alerts0_instances){
a = _cls_Alerts0_instances.keySet().toArray(a);}
for (_cls_Alerts0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_Alerts0_instances){
_cls_Alerts0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_alerts = 21;

public void _performLogic_alerts(String _info, int... _event) {

_cls_Alerts0.pw.println("[alerts]AUTOMATON::> alerts("+") STATE::>"+ _string_alerts(_state_id_alerts, 0));
_cls_Alerts0.pw.flush();

if (0==1){}
else if (_state_id_alerts==18){
		if (1==0){}
		else if ((_occurredEvent(_event,34/*validPostAlert*/)) && (noOfAlerts >=5 )){
		noOfAlerts ++;

		_state_id_alerts = 18;//moving to state badState
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,36/*invalidPostAlert*/))){
		noOfAlerts ++;

		_state_id_alerts = 18;//moving to state badState
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,38/*deleteAlerts*/))){
		noOfAlerts =0 ;

		_state_id_alerts = 20;//moving to state deleteAlerts
		_goto_alerts(_info);
		}
}
else if (_state_id_alerts==21){
		if (1==0){}
		else if ((_occurredEvent(_event,34/*validPostAlert*/)) && (noOfAlerts <5 )){
		noOfAlerts ++;

		_state_id_alerts = 19;//moving to state postAlert
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,38/*deleteAlerts*/))){
		noOfAlerts =0 ;

		_state_id_alerts = 20;//moving to state deleteAlerts
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,36/*invalidPostAlert*/))){
		noOfAlerts ++;

		_state_id_alerts = 18;//moving to state badState
		_goto_alerts(_info);
		}
}
else if (_state_id_alerts==19){
		if (1==0){}
		else if ((_occurredEvent(_event,34/*validPostAlert*/)) && (noOfAlerts <5 )){
		noOfAlerts ++;

		_state_id_alerts = 19;//moving to state postAlert
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,38/*deleteAlerts*/))){
		noOfAlerts =0 ;

		_state_id_alerts = 20;//moving to state deleteAlerts
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,36/*invalidPostAlert*/))){
		noOfAlerts ++;

		_state_id_alerts = 18;//moving to state badState
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,34/*validPostAlert*/)) && (noOfAlerts ==5 )){
		noOfAlerts ++;

		_state_id_alerts = 18;//moving to state badState
		_goto_alerts(_info);
		}
}
else if (_state_id_alerts==20){
		if (1==0){}
		else if ((_occurredEvent(_event,38/*deleteAlerts*/))){
		noOfAlerts =0 ;

		_state_id_alerts = 20;//moving to state deleteAlerts
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,36/*invalidPostAlert*/))){
		noOfAlerts ++;

		_state_id_alerts = 18;//moving to state badState
		_goto_alerts(_info);
		}
		else if ((_occurredEvent(_event,34/*validPostAlert*/)) && (noOfAlerts ==0 )){
		noOfAlerts ++;

		_state_id_alerts = 19;//moving to state postAlert
		_goto_alerts(_info);
		}
}
}

public void _goto_alerts(String _info){
_cls_Alerts0.pw.println("[alerts]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_alerts(_state_id_alerts, 1));
_cls_Alerts0.pw.flush();
}

public String _string_alerts(int _state_id, int _mode){
switch(_state_id){
case 18: if (_mode == 0) return "badState"; else return "!!!SYSTEM REACHED BAD STATE!!! badState "+new _BadStateExceptionAlerts().toString()+" ";
case 21: if (_mode == 0) return "initialState"; else return "initialState";
case 19: if (_mode == 0) return "postAlert"; else return "postAlert";
case 20: if (_mode == 0) return "deleteAlerts"; else return "deleteAlerts";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}