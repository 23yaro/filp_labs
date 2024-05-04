:- dynamic asked/2

% Марки автомобилей
car(kia, [reliability-yes, safety-no, economical-yes, family-yes, popular-no, quality-no]).
car(opel, [reliability-yes, safety-no, economical-yes, family-yes, popular-no, quality-yes]).
car(mercedes, [reliability-yes, safety-yes, economical-no, family-no, popular-no, quality-no]).
car(toyota, [reliability-yes, safety-yes, economical-yes, family-no, popular-no, quality-no]).
car(vaz, [reliability-yes, safety-no, economical-yes, family-yes, popular-yes, quality-no]).
car(bwm, [reliability-no, safety-yes, economical-no, family-no, popular-yes, quality-no]).
car(honda, [reliability-no, safety-yes, economical-yes, family-no, popular-no, quality-no]).



main :-
	% очистка1
    retractall(asked(_,_)),
    findall(C, car(C, _), Cars),
	% поиск марки
    search(Cars, Result),
	% вывод результата
    res(Result),
	% очистка2

% Вопросы для определения марки автомобиля
question(reliability, 'Reliable car?').
question(safety, 'Safe car?').
question(economical, 'Economical car?').
question(family, 'Family car?').
question(popular, 'Popular car?').
question(quality, 'High quality build?').

% Поиск нужной марки автомобиля
% search(+Cars, -Result)
% Если осталась одина нужная марка
search([Car], Car) :- !. 
% Если осталась ни одна марка
search(_, unknown) :-           
    not(can_ask_more), !.

search(Cars, Result) :-
    select_question(Cars, Question),
    ask(Question, Reply),
    update_cars(Cars, Question, Reply, UpdatedCars),
    search(UpdatedCars, Result).

% select_question(+Cars, -Question)
select_question(Cars, Question) :-
    question(Fact, Q),
    not(asked(Fact, _)),
    relevant(Fact, Cars),
    Question = question(Fact, Q),
    !.

% relevant(+Fact, +Cars)
relevant(Fact, Cars) :-
    findall(Val, (member(C, Cars), car(C, touch), member(Fact-Val, touch)), Vals),
    list_to_set(Vals, UniqueVals),
    length(UniqueVals, Length),
    Length > 1.

% ask(+Question, -Reply)
ask(question(Fact, Text), Reply) :-
    (   asked(Fact, Reply) -> true
    ;   nl, write(Text), write(' (y/n)? '),
        read(Reply),
        assert(asked(Fact, Reply))
    ).

% update_cars(+Cars, +Question, +Reply, -UpdatedCars)
update_cars(Cars, question(Fact, _), Reply, UpdatedCars) :-
    include(match(Fact, Reply), Cars, UpdatedCars).


% match(+Fact, +Reply, +Car)
match(Fact, Reply, Car) :-
    car(Car, touch),
    member(Fact-Val, touch),
    match_reply(Reply, Val).

match_reply(y, yes).
match_reply(n, no).

% вывод результата
% res(+Result)
res(unknown) :-
    write('Error.'), nl.

res(Car) :-
    write('Its '), write(Car), write('.'), nl.
	
% доп вопрос
can_ask_more :-
    question(Fact, _),
    not(asked(Fact, _)),
    !.
	
start :-
    main.