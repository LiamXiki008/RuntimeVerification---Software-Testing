package aspects;

import main.Runner;

import larva.*;
public aspect _asp_Alerts0 {

public static Object lock = new Object();

boolean initialized = false;

after():(staticinitialization(*)){
if (!initialized){
	initialized = true;
	_cls_Alerts0.initialize();
}
}
before () : (call(* *.invalidPostAlert(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 36/*invalidPostAlert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 36/*invalidPostAlert*/);
}
}
before () : (call(* *.deleteAlerts(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 38/*deleteAlerts*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 38/*deleteAlerts*/);
}
}
before () : (call(* *.validPostAlert(..)) && !cflow(adviceexecution()) && !cflow(within(larva.*))  && !(within(larva.*))) {

synchronized(_asp_Alerts0.lock){

_cls_Alerts0 _cls_inst = _cls_Alerts0._get_cls_Alerts0_inst();
_cls_inst._call(thisJoinPoint.getSignature().toString(), 34/*validPostAlert*/);
_cls_inst._call_all_filtered(thisJoinPoint.getSignature().toString(), 34/*validPostAlert*/);
}
}
}