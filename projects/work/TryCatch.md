Dzisiaj pobawimy się pożyczkowym wzorcem, a mianowicie Loan Pattern. Na jego podstawie zrobimy sobie funkcyjnego TryCatcha. Jest to wzorzec wywodzący się bardziej ze środowiska funkcyjnego tuteż Scalowego. Java ostatnimi czasy również stara się zainstnieć w tym świecie i tak właśnie powstało kilka bibliotek umożliwiających tworzenie bardziej funkcyjnego kodu. Przedstawimy sobie takie biblioteki jak Vavr, oraz JOOλ.

#### Szable w dłoń i robimy funkcyjnie!
### Ale zacznijmy od początku... 
Funkcjnie, czyli mamy... funkcje, metody. Mają one jakiś input oraz output. Kluczowym konceptem jest tutaj modułowość. Możemy rozbić nasz algorytm, czy cokolwiek tam robimy na mniejsze pod-funkcje. Jak wiadomo nasze umysły mają tylko ograniczoną ilość RAMu do rozwiązywania codziennych problemów, dlatego wymyślamy koncepty, paradygmaty, standardy aby uprościć to wszystko. Małe moduły mogą być kodzone szybko i być łatwo testowane. Do tego jest możliwe ich re-używanie. Czyli mamy w sumie kilka najważniejszych zasad dobrego kodu spakowane do jednego worka z tego też powodu programowanie zorientowane na funkcje staje się poopularne. 

### To jak pisać? OOP vs FP 🥊
Używanie FP wcale nie znaczy, że OOP jest już passé. Wręcz przeciwnie oba paradygmaty doskonale ze sobą współpracują. 
Dobra może nie do końca współpracują, ale bardziej zastępują lub uzpełniają niektóre techniki zawierające się w innych paradygmatach. Przykładowo: 
* Higher-order functions - przekazują funkcję jako paramter do innej funkcji - istna incepcja. Przykładowo mamy `availableCustomersList(Customer::isAvailable)` to do naszej methody <b>availableCustomersList</b> przekazujemy inną funkcję `Customer::isAvailable`.
* First-class citizens - czyli traktowanie funkcji jako wartości. 
* Anonymous classes - () -> "czyli lambdy"

## Skutki uboczne programowania imperatywnego
Impratywnego, czyli takiego z jakim mamy styczność zazwyczaj na początku drogi z programowaniem. 
Przykładowo jeśli A == 0 to zwróć B inaczej B++ oraz A--. 
Mamy tutaj mutowalne zmienne, czyli w sumie niszczymy stany obiektów. 
Jeśli okaże się, że trzeba zmienić wymagania biznesowe to szybko okazuje się, że również zmieniamy wynik działania naszej aplikacji.


## Nie język czyni programowanie funkcyjnym
Mimo, że haskell jest praktycznym przykładem czysto funkcjonalnego języka to jednak nie język czyni programowanie funkcyjnym. Takowy język daje nam tyle, że jest bardziej przyjazny takiemu podejściu, ale w sposób funkcyjny można pisać w większości języków... większości, bo w brainfucku byłoby to conajmniej ciężkie.  


Jest jeszcze parę innych pojęć jakie  anonymous functions, closures, lazy-evaluation i wiele innych rzeczy wychodzących poza ten wpis. Rzeczy te pojawiją się często w językach funkcjonalnych i są praktycznie spowiwem tworzącym język funkcjonalym. 


## 

# Osobny Wpis (or not) #

## Na początek zacznijmy od starego i wciąż dobrego (co warto podkreślić) TryCatcha:
// todo: 

## To teraz czas na mięso 🍗  (Loan Pattern)
// todo: 

## JOOλ.append(Vavr).build()
// todo: 
