man(voeneg).
man(ratibor).
man(boguslav).
man(velerad).
man(duhovlad).
man(svyatoslav).
man(dobrozhir).
man(bogomil).
man(zlatomir).

woman(goluba).
woman(lubomila).
woman(bratislava).
woman(veslava).
woman(zhdana).
woman(bozhedara).
woman(broneslava).
woman(veselina).
woman(zdislava).

parent(voeneg,ratibor).
parent(voeneg,bratislava).
parent(voeneg,velerad).
parent(voeneg,zhdana).

parent(goluba,ratibor).
parent(goluba,bratislava).
parent(goluba,velerad).
parent(goluba,zhdana).

parent(ratibor,svyatoslav).
parent(ratibor,dobrozhir).
parent(lubomila,svyatoslav).
parent(lubomila,dobrozhir).

parent(boguslav,bogomil).
parent(boguslav,bozhedara).
parent(bratislava,bogomil).
parent(bratislava,bozhedara).

parent(velerad,broneslava).
parent(velerad,veselina).
parent(veslava,broneslava).
parent(veslava,veselina).

parent(duhovlad,zdislava).
parent(duhovlad,zlatomir).
parent(zhdana,zdislava).
parent(zhdana,zlatomir).


men():- man(X), print(X), nl, fail.
women():- woman(X), print(X), nl, fail.
children(X):- parent(X,Y), print(Y), nl, fail.

mother(X,Y):- woman(X), parent(X,Y).
mother(X):- mother(Y,X), print(Y), nl, fail.

brother(X,Y):- man(X),X\=Y, parent(Z,X), parent(C,Y), Z=C.
brothers(X):- mother(Y,X), parent(Y,Z), man(Z), Z\=X, print(Z), nl, false.

son(X,Y):- man(X), parent(Y,X).
son(X):- son(Y,X), man(Y), print(Y), nl, false.

husband(X,Y):- man(X), woman(Y), parent(X,Z), parent(Y,C), Z=C.
husband(X):- woman(X), husband(Y,X), print(Y).

/*grand_pa ищет отца Y, после чего проверяет отцовство X и отца Y*/
grand_pa(X, Y):- man(X), parent(Z,Y), parent(X,Z).
grand_pas(X):- grand_pa(Y,X), print(Y), nl, false.
grand_pa_and_da(X,Y):- grand_pa(X,Y),woman(Y);grand_pa(Y,X),woman(X).

/*проверка на тётю через дедушку племяника(цы)*/
aunt(X,Y):- woman(X), not(parent(X,Y)), grand_pa(Z,Y), parent(Z,X).
aunts(X):- aunt(Y,X), print(Y), nl, false.

/*Only FDB ->*/
grand_pa_f(X, Y):- man(X), parent(Z,Y), parent(X,Z).
grand_pas_f(X):- man(Y), parent(Z,X), parent(Y,Z), print(Y), nl, false.
grand_pa_and_da_f(X,Y):- man(X), parent(Z,Y), parent(X,Z),woman(Y); man(Y), parent(Z,X), parent(Y,Z), woman(X).

aunt_f(X,Y):- woman(X), not(parent(X,Y)), man(Z), parent(C,Y), parent(Z,C), parent(Z,X).
aunts_f(X):- woman(Y), not(parent(Y,X)), man(Z), parent(C,X), parent(Z,C), parent(Z,Y), print(Y), nl, false.
/*.*/


b_s(X,Y):- X\=Y, parent(Z,X), parent(C,Y), Z=C.
b_s(X):- mother(Y,X), parent(Y,Z), Z\=X, print(Z), nl, false.

max(X,Y,Z):-(
     X>=Y -> Z is X;
     Y>X -> Z is Y
    ).

fact(0,1).
fact(N,X):- N>0,
    N1 is N-1, fact(N1,X1), X is N*X1.

fact2(0,X,X).
fact2(N,A,X):- N>0,
    A1 is N*A,
    N1 is N-1,
    fact2(N1,A1,X).

call_fact2(N,X):- fact2(N,1,X).

