
conges(mairie(M,metropole,Nombre),agent(Nom),15) :- Nombre < 1000.
conges(mairie(M,metropole,Nombre),agent(Nom),25) :- Nombre >= 1000.


a(3).
a(2).
a(4).
a(0).

somConges([],0):-not(a(_)).
somConges([X|L],R) :- a(X), somConges(L,R1), R is.

som([],0).
som([X|L],R) :- som(L,R1),R is X+R1.
