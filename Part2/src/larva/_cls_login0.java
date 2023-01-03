package larva;


import main.Runner_2;

import java.util.LinkedHashMap;
import java.io.PrintWriter;

public class _cls_login0 implements _callable{

public static PrintWriter pw; 
public static _cls_login0 root;

public static LinkedHashMap<_cls_login0,_cls_login0> _cls_login0_instances = new LinkedHashMap<_cls_login0,_cls_login0>();
static{
try{
RunningClock.start();
pw = new PrintWriter("C:\\Users\\liams\\workspace\\Part2/src/output_login.txt");

root = new _cls_login0();
_cls_login0_instances.put(root, root);
  root.initialisation();
}catch(Exception ex)
{ex.printStackTrace();}
}

_cls_login0 parent; //to remain null - this class does not have a parent!
int no_automata = 1;
 public boolean loggedIn =false ;
 public boolean alertsBeingViewed =false ;

public static void initialize(){}
//inheritance could not be used because of the automatic call to super()
//when the constructor is called...we need to keep the SAME parent if this exists!

public _cls_login0() {
}

public void initialisation() {
}

public static _cls_login0 _get_cls_login0_inst() { synchronized(_cls_login0_instances){
 return root;
}
}

public boolean equals(Object o) {
 if ((o instanceof _cls_login0))
{return true;}
else
{return false;}
}

public int hashCode() {
return 0;
}

public void _call(String _info, int... _event){
synchronized(_cls_login0_instances){
_performLogic_apiFunctionalityProperty(_info, _event);
}
}

public void _call_all_filtered(String _info, int... _event){
}

public static void _call_all(String _info, int... _event){

_cls_login0[] a = new _cls_login0[1];
synchronized(_cls_login0_instances){
a = _cls_login0_instances.keySet().toArray(a);}
for (_cls_login0 _inst : a)

if (_inst != null) _inst._call(_info, _event);
}

public void _killThis(){
try{
if (--no_automata == 0){
synchronized(_cls_login0_instances){
_cls_login0_instances.remove(this);}
}
else if (no_automata < 0)
{throw new Exception("no_automata < 0!!");}
}catch(Exception ex){ex.printStackTrace();}
}

int _state_id_apiFunctionalityProperty = 10;

public void _performLogic_apiFunctionalityProperty(String _info, int... _event) {

_cls_login0.pw.println("[apiFunctionalityProperty]AUTOMATON::> apiFunctionalityProperty("+") STATE::>"+ _string_apiFunctionalityProperty(_state_id_apiFunctionalityProperty, 0));
_cls_login0.pw.flush();

if (0==1){}
else if (_state_id_apiFunctionalityProperty==9){
		if (1==0){}
		else if ((_occurredEvent(_event,22/*logOut*/)) && (loggedIn ==true )){
		loggedIn =false ;

		_state_id_apiFunctionalityProperty = 10;//moving to state initialState
		_goto_apiFunctionalityProperty(_info);
		}
		else if ((_occurredEvent(_event,26/*viewAlerts*/)) && (loggedIn ==true )){
		alertsBeingViewed =true ;

		_state_id_apiFunctionalityProperty = 9;//moving to state validLogin
		_goto_apiFunctionalityProperty(_info);
		}
}
else if (_state_id_apiFunctionalityProperty==10){
		if (1==0){}
		else if ((_occurredEvent(_event,20/*invalidCredentials*/)) && (loggedIn ==false )){
		loggedIn =false ;

		_state_id_apiFunctionalityProperty = 8;//moving to state invalidLogin
		_goto_apiFunctionalityProperty(_info);
		}
		else if ((_occurredEvent(_event,24/*validCredentials*/)) && (loggedIn ==false )){
		loggedIn =true ;

		_state_id_apiFunctionalityProperty = 9;//moving to state validLogin
		_goto_apiFunctionalityProperty(_info);
		}
		else if ((_occurredEvent(_event,26/*viewAlerts*/)) && (loggedIn ==false )){
		alertsBeingViewed =true ;

		_state_id_apiFunctionalityProperty = 7;//moving to state badState
		_goto_apiFunctionalityProperty(_info);
		}
}
else if (_state_id_apiFunctionalityProperty==8){
		if (1==0){}
		else if ((_occurredEvent(_event,28/*login*/)) && (loggedIn ==false )){
		loggedIn =false ;

		_state_id_apiFunctionalityProperty = 10;//moving to state initialState
		_goto_apiFunctionalityProperty(_info);
		}
}
}

public void _goto_apiFunctionalityProperty(String _info){
_cls_login0.pw.println("[apiFunctionalityProperty]MOVED ON METHODCALL: "+ _info +" TO STATE::> " + _string_apiFunctionalityProperty(_state_id_apiFunctionalityProperty, 1));
_cls_login0.pw.flush();
}

public String _string_apiFunctionalityProperty(int _state_id, int _mode){
switch(_state_id){
case 7: if (_mode == 0) return "badState"; else return "!!!SYSTEM REACHED BAD STATE!!! badState "+new _BadStateExceptionlogin().toString()+" ";
case 9: if (_mode == 0) return "validLogin"; else return "validLogin";
case 10: if (_mode == 0) return "initialState"; else return "initialState";
case 8: if (_mode == 0) return "invalidLogin"; else return "invalidLogin";
default: return "!!!SYSTEM REACHED AN UNKNOWN STATE!!!";
}
}

public boolean _occurredEvent(int[] _events, int event){
for (int i:_events) if (i == event) return true;
return false;
}
}