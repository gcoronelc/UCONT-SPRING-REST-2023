-- Caso 1

if( caso==1 ) {
	ServiceA sa = new ServiceA();
	. . . . 
	. . . .
} else {
	ServiceB sb = new ServiceB();
	. . . . 
	. . . .
}

-- Caso 2

IService service;
if( caso==1 ) {
	service = new ServiceA();
} else {
	service = new ServiceB();
}
. . . . 
. . . .


-- Case 3

IService service = Factory.creaService( 1 );
. . . . 
. . . .

