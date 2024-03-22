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

% �������� ������� ���� ������
men():- man(X), print(X), nl, fail.
% �������� ������� ���� ������
women():- woman(X), print(X), nl, fail.

% �������� ������� ���� ����� X
% children(+X)
children(X):- parent(X,Y), print(Y), nl, fail.

% �������� ���������� �������� X ������� Y
% mother(+X,-Y)
mother(X,Y):- woman(X), parent(X,Y).
% �������� ������� ���� X
% mother(+X)
mother(X):- mother(Y,X), print(Y), nl, fail.

% �������� ���������� �������� X ������ Y
% brother(+X,-Y)
brother(X,Y):- man(X),X\=Y, parent(Z,X), parent(C,Y), Z=C.
% �������� ������� ���� ������� X
% brothers(+X)
brothers(X):- mother(Y,X), parent(Y,Z), man(Z), Z\=X, print(Z), nl, false.

% �������� ���������� �������� X ����� Y
% son(+X,-Y)
son(X,Y):- man(X), parent(Y,X).
% �������� ������� ���� ������� �������� X
% son(+X)
son(X):- son(Y,X), man(Y), print(Y), nl, false.

% �������� ���������� �������� X ����� Y
% husband(+X,-Y)
husband(X,Y):- man(X), woman(Y), parent(X,Z), parent(Y,C), Z=C.
% �������� ������� ���� ������� X
% husband(+X)
husband(X):- woman(X), husband(Y,X), print(Y).

% ��� �������� ��������������� ����������
% ������� ���� ������� X
% grand_pas(+X)
grand_pas(X) :- parent(Z, X),parent(Y, Z),man(Y),print(Y), nl, fail.


% �������� ���������� �������� X ����� Y
% aunt(+X, -Y)
aunt(X, Y) :- parent(Z, Y),sister(X, Z).
% �������� ���������� �������� X ������� Y
% sister(+X, -Y)
sister(X, Y) :- parent(Z, X),parent(Z, Y),woman(X),X \= Y.

% �������� ������� ���� ���� X
% aunts(+X)
aunts(X) :- parent(Z, X), sister(Y, Z), print(Y), nl, fail.

% �������� ���������� �������� X �������� Y
% grand_pa(+X, -Y)
grand_pa(X, Y) :- man(X), parent(X, Z), parent(Z, Y).


% ��������, ������� ���������, �������� �� X � Y �������� � ������� ��� ������� � ��������
% grand_pa_and_da(+X, -Y) ��� grand_pa_and_da(-X, +Y)
grand_pa_and_da(X, Y) :-
    (grand_pa(X, Y), woman(Y));
    (grand_pa(Y, X), woman(X)).


% ��������������� ���������
% sibling(+X, +Y)
% ���������� ������� � ������
sibling(X, Y) :- parent(Z, X), parent(Z, Y), X \= Y.

% sister(+X, -Y)
% ���������� ������
sister(X, Y) :- woman(X), sibling(X, Y).

% grand_pas(+X)
% �������� ������� ���� ������� X
grand_pas(X) :- parent(Z, X), parent(Y, Z), man(Y), print(Y), nl, fail.

% grand_pa(+X, -Y)
% �������� ������������ �������
grand_pa(X, Y) :- man(X), parent(X, Z), parent(Z, Y).

% grand_pa_and_da(+X, -Y) ��� grand_pa_and_da(-X, +Y)
% �������� �������� ��������� ��������� ������� � ������ ��� ������ � �������
grand_pa_and_da(X, Y) :-
    (grand_pa(X, Y), woman(Y));
    (grand_pa(Y, X), woman(X)).

% aunt(+X, -Y)
% �������� ��������� �������� �� X ����� Y
aunt(X, Y) :- parent(Z, Y), sister(X, Z).

% aunts(+X)
% �������� ������� ���� ����� X
aunts(X) :- parent(Z, X), sister(Y, Z), print(Y), nl, fail.
