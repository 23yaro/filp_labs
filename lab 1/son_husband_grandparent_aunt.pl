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

% Предикат выводит всех мужчин
men():- man(X), print(X), nl, fail.
% Предикат выводит всех женщин
women():- woman(X), print(X), nl, fail.

% Предикат выводит всех детей X
% children(+X)
children(X):- parent(X,Y), print(Y), nl, fail.

% Предикат определяет является X матерью Y
% mother(+X,-Y)
mother(X,Y):- woman(X), parent(X,Y).
% Предикат выводит маму X
% mother(+X)
mother(X):- mother(Y,X), print(Y), nl, fail.

% Предикат определяет является X братом Y
% brother(+X,-Y)
brother(X,Y):- man(X),X\=Y, parent(Z,X), parent(C,Y), Z=C.
% Предикат выводит всех братьев X
% brothers(+X)
brothers(X):- mother(Y,X), parent(Y,Z), man(Z), Z\=X, print(Z), nl, false.

% Предикат определяет является X сыном Y
% son(+X,-Y)
son(X,Y):- man(X), parent(Y,X).
% Предикат выводит всех сыновей родителя X
% son(+X)
son(X):- son(Y,X), man(Y), print(Y), nl, false.

% Предикат определяет является X мужем Y
% husband(+X,-Y)
husband(X,Y):- man(X), woman(Y), parent(X,Z), parent(Y,C), Z=C.
% Предикат выводит мужа женщины X
% husband(+X)
husband(X):- woman(X), husband(Y,X), print(Y).

% без создания вспомогательных предикатов
% выводит всех дедушек X
% grand_pas(+X)
grand_pas(X) :- parent(Z, X),parent(Y, Z),man(Y),print(Y), nl, fail.


% Предикат определяет является X тетей Y
% aunt(+X, -Y)
aunt(X, Y) :- parent(Z, Y),sister(X, Z).
% Предикат определяет является X сестрой Y
% sister(+X, -Y)
sister(X, Y) :- parent(Z, X),parent(Z, Y),woman(X),X \= Y.

% Предикат выводит всех теть X
% aunts(+X)
aunts(X) :- parent(Z, X), sister(Y, Z), print(Y), nl, fail.

% Предикат определяет является X дедушкой Y
% grand_pa(+X, -Y)
grand_pa(X, Y) :- man(X), parent(X, Z), parent(Z, Y).


% Предикат, который проверяет, являются ли X и Y дедушкой и внучкой или внучкой и дедушкой
% grand_pa_and_da(+X, -Y) или grand_pa_and_da(-X, +Y)
grand_pa_and_da(X, Y) :-
    (grand_pa(X, Y), woman(Y));
    (grand_pa(Y, X), woman(X)).


% Вспомогательные предикаты
% sibling(+X, +Y)
% Определяет братьев и сестер
sibling(X, Y) :- parent(Z, X), parent(Z, Y), X \= Y.

% sister(+X, -Y)
% Определяет сестер
sister(X, Y) :- woman(X), sibling(X, Y).

% grand_pas(+X)
% Предикат выводит всех дедушек X
grand_pas(X) :- parent(Z, X), parent(Y, Z), man(Y), print(Y), nl, fail.

% grand_pa(+X, -Y)
% Предикат определяющий дедушку
grand_pa(X, Y) :- man(X), parent(X, Z), parent(Z, Y).

% grand_pa_and_da(+X, -Y) или grand_pa_and_da(-X, +Y)
% Итоговый предикат проверяет отношения дедушки и внучки или внучки и дедушки
grand_pa_and_da(X, Y) :-
    (grand_pa(X, Y), woman(Y));
    (grand_pa(Y, X), woman(X)).

% aunt(+X, -Y)
% Предикат проверяет является ли X тетей Y
aunt(X, Y) :- parent(Z, Y), sister(X, Z).

% aunts(+X)
% Предикат выводит всех тетей X
aunts(X) :- parent(Z, X), sister(Y, Z), print(Y), nl, fail.
