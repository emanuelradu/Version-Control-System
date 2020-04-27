Pentru implementarea operatiilor de VCS am ales sa respect modelul celor deja
implementate de FileSystem. Astfel, fiecare operatie extinde clasa VcsOperation
si ii implementeaza metoda de execute care se apeleaza in visit.
In clasa Vcs stochez un array de Branchuri iar in fiecare branch am un array
de commituri corespunzatoare.
Implementez clasele BranchOperation si CommitOperation cu doua clase create 
de mine, Branch si Commit care stocheaza date referitoare la sistem si 
operatii.
In clasa Context stochez un vector de stringuri numit staging in care adaug
modificarile care s-au facut asupra unui sistem de fisiere pe care nu s-a 
facut inca commit.
Nu am reusit sa implementez pana la capat metoda Checkout si de aceea nu-mi
trec toate testele. Imi pare rau pentru codul necomentat si coding style-ul 
inconsitent, dar nu mai am timp la dispozitie sa mai fac si asta. La viitoarea
tema, voi avea mai mare grija cu asta.